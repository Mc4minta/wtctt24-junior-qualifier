package org.apache.http.client.protocol;

import java.io.IOException;
import org.apache.commons.logging.a;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.auth.AuthState;
import org.apache.http.conn.HttpRoutedConnection;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
/* loaded from: classes3.dex */
public class RequestProxyAuthentication extends RequestAuthenticationBase {
    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        if (httpRequest.containsHeader("Proxy-Authorization")) {
            return;
        }
        HttpRoutedConnection httpRoutedConnection = (HttpRoutedConnection) httpContext.getAttribute("http.connection");
        if (httpRoutedConnection == null) {
            this.log.a("HTTP connection not set in the context");
        } else if (httpRoutedConnection.getRoute().isTunnelled()) {
        } else {
            AuthState authState = (AuthState) httpContext.getAttribute("http.auth.proxy-scope");
            if (authState == null) {
                this.log.a("Proxy auth state not set in the context");
                return;
            }
            if (this.log.d()) {
                a aVar = this.log;
                aVar.a("Proxy auth state: " + authState.getState());
            }
            process(authState, httpRequest, httpContext);
        }
    }
}