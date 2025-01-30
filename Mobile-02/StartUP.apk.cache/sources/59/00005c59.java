package org.apache.http.client.protocol;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.a;
import org.apache.commons.logging.h;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Lookup;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.TextUtils;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes3.dex */
public class RequestAddCookies implements HttpRequestInterceptor {
    private final a log = h.n(getClass());

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        URI uri;
        Header versionHeader;
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        if (httpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {
            return;
        }
        HttpClientContext adapt = HttpClientContext.adapt(httpContext);
        CookieStore cookieStore = adapt.getCookieStore();
        if (cookieStore == null) {
            this.log.a("Cookie store not specified in HTTP context");
            return;
        }
        Lookup<CookieSpecProvider> cookieSpecRegistry = adapt.getCookieSpecRegistry();
        if (cookieSpecRegistry == null) {
            this.log.a("CookieSpec registry not specified in HTTP context");
            return;
        }
        HttpHost targetHost = adapt.getTargetHost();
        if (targetHost == null) {
            this.log.a("Target host not set in the context");
            return;
        }
        RouteInfo httpRoute = adapt.getHttpRoute();
        if (httpRoute == null) {
            this.log.a("Connection route not set in the context");
            return;
        }
        String cookieSpec = adapt.getRequestConfig().getCookieSpec();
        if (cookieSpec == null) {
            cookieSpec = CookieSpecs.DEFAULT;
        }
        if (this.log.d()) {
            this.log.a("CookieSpec selected: " + cookieSpec);
        }
        if (httpRequest instanceof HttpUriRequest) {
            uri = ((HttpUriRequest) httpRequest).getURI();
        } else {
            try {
                uri = new URI(httpRequest.getRequestLine().getUri());
            } catch (URISyntaxException unused) {
                uri = null;
            }
        }
        String path = uri != null ? uri.getPath() : null;
        String hostName = targetHost.getHostName();
        int port = targetHost.getPort();
        if (port < 0) {
            port = httpRoute.getTargetHost().getPort();
        }
        boolean z = false;
        if (port < 0) {
            port = 0;
        }
        if (TextUtils.isEmpty(path)) {
            path = "/";
        }
        CookieOrigin cookieOrigin = new CookieOrigin(hostName, port, path, httpRoute.isSecure());
        CookieSpecProvider lookup = cookieSpecRegistry.lookup(cookieSpec);
        if (lookup == null) {
            if (this.log.d()) {
                this.log.a("Unsupported cookie policy: " + cookieSpec);
                return;
            }
            return;
        }
        CookieSpec create = lookup.create(adapt);
        List<Cookie> cookies = cookieStore.getCookies();
        ArrayList arrayList = new ArrayList();
        Date date = new Date();
        for (Cookie cookie : cookies) {
            if (!cookie.isExpired(date)) {
                if (create.match(cookie, cookieOrigin)) {
                    if (this.log.d()) {
                        this.log.a("Cookie " + cookie + " match " + cookieOrigin);
                    }
                    arrayList.add(cookie);
                }
            } else {
                if (this.log.d()) {
                    this.log.a("Cookie " + cookie + " expired");
                }
                z = true;
            }
        }
        if (z) {
            cookieStore.clearExpired(date);
        }
        if (!arrayList.isEmpty()) {
            for (Header header : create.formatCookies(arrayList)) {
                httpRequest.addHeader(header);
            }
        }
        if (create.getVersion() > 0 && (versionHeader = create.getVersionHeader()) != null) {
            httpRequest.addHeader(versionHeader);
        }
        httpContext.setAttribute("http.cookie-spec", create);
        httpContext.setAttribute("http.cookie-origin", cookieOrigin);
    }
}