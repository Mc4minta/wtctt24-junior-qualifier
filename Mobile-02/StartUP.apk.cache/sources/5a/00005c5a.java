package org.apache.http.client.protocol;

import java.io.IOException;
import org.apache.commons.logging.a;
import org.apache.commons.logging.h;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.auth.AuthProtocolState;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes3.dex */
public class RequestAuthCache implements HttpRequestInterceptor {
    private final a log = h.n(getClass());

    private void doPreemptiveAuth(HttpHost httpHost, AuthScheme authScheme, AuthState authState, CredentialsProvider credentialsProvider) {
        String schemeName = authScheme.getSchemeName();
        if (this.log.d()) {
            a aVar = this.log;
            aVar.a("Re-using cached '" + schemeName + "' auth scheme for " + httpHost);
        }
        Credentials credentials = credentialsProvider.getCredentials(new AuthScope(httpHost, AuthScope.ANY_REALM, schemeName));
        if (credentials != null) {
            authState.update(authScheme, credentials);
        } else {
            this.log.a("No credentials for preemptive authentication");
        }
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        AuthScheme authScheme;
        AuthScheme authScheme2;
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext adapt = HttpClientContext.adapt(httpContext);
        AuthCache authCache = adapt.getAuthCache();
        if (authCache == null) {
            this.log.a("Auth cache not set in the context");
            return;
        }
        CredentialsProvider credentialsProvider = adapt.getCredentialsProvider();
        if (credentialsProvider == null) {
            this.log.a("Credentials provider not set in the context");
            return;
        }
        RouteInfo httpRoute = adapt.getHttpRoute();
        if (httpRoute == null) {
            this.log.a("Route info not set in the context");
            return;
        }
        HttpHost targetHost = adapt.getTargetHost();
        if (targetHost == null) {
            this.log.a("Target host not set in the context");
            return;
        }
        if (targetHost.getPort() < 0) {
            targetHost = new HttpHost(targetHost.getHostName(), httpRoute.getTargetHost().getPort(), targetHost.getSchemeName());
        }
        AuthState targetAuthState = adapt.getTargetAuthState();
        if (targetAuthState != null && targetAuthState.getState() == AuthProtocolState.UNCHALLENGED && (authScheme2 = authCache.get(targetHost)) != null) {
            doPreemptiveAuth(targetHost, authScheme2, targetAuthState, credentialsProvider);
        }
        HttpHost proxyHost = httpRoute.getProxyHost();
        AuthState proxyAuthState = adapt.getProxyAuthState();
        if (proxyHost == null || proxyAuthState == null || proxyAuthState.getState() != AuthProtocolState.UNCHALLENGED || (authScheme = authCache.get(proxyHost)) == null) {
            return;
        }
        doPreemptiveAuth(proxyHost, authScheme, proxyAuthState, credentialsProvider);
    }
}