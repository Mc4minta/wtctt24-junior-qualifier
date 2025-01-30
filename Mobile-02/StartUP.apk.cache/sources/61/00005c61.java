package org.apache.http.client.protocol;

import java.io.IOException;
import org.apache.commons.logging.a;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.auth.AuthState;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
/* loaded from: classes3.dex */
public class RequestTargetAuthentication extends RequestAuthenticationBase {
    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        if (httpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") || httpRequest.containsHeader("Authorization")) {
            return;
        }
        AuthState authState = (AuthState) httpContext.getAttribute("http.auth.target-scope");
        if (authState == null) {
            this.log.a("Target auth state not set in the context");
            return;
        }
        if (this.log.d()) {
            a aVar = this.log;
            aVar.a("Target auth state: " + authState.getState());
        }
        process(authState, httpRequest, httpContext);
    }
}