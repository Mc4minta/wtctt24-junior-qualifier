package org.apache.http.impl.client;

import org.apache.commons.logging.a;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthState;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.protocol.HttpContext;

@Deprecated
/* loaded from: classes3.dex */
public class HttpAuthenticator extends org.apache.http.impl.auth.HttpAuthenticator {
    public HttpAuthenticator(a aVar) {
        super(aVar);
    }

    public boolean authenticate(HttpHost httpHost, HttpResponse httpResponse, AuthenticationStrategy authenticationStrategy, AuthState authState, HttpContext httpContext) {
        return handleAuthChallenge(httpHost, httpResponse, authenticationStrategy, authState, httpContext);
    }

    public HttpAuthenticator() {
    }
}