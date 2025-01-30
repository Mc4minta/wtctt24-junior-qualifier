package org.apache.http.client.protocol;

import java.util.Queue;
import org.apache.commons.logging.a;
import org.apache.commons.logging.h;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthOption;
import org.apache.http.auth.AuthProtocolState;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.ContextAwareAuthScheme;
import org.apache.http.auth.Credentials;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Asserts;

@Deprecated
/* loaded from: classes3.dex */
abstract class RequestAuthenticationBase implements HttpRequestInterceptor {
    final a log = h.n(getClass());

    /* renamed from: org.apache.http.client.protocol.RequestAuthenticationBase$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$http$auth$AuthProtocolState;

        static {
            int[] iArr = new int[AuthProtocolState.values().length];
            $SwitchMap$org$apache$http$auth$AuthProtocolState = iArr;
            try {
                iArr[AuthProtocolState.FAILURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$http$auth$AuthProtocolState[AuthProtocolState.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$http$auth$AuthProtocolState[AuthProtocolState.CHALLENGED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private Header authenticate(AuthScheme authScheme, Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        Asserts.notNull(authScheme, "Auth scheme");
        if (authScheme instanceof ContextAwareAuthScheme) {
            return ((ContextAwareAuthScheme) authScheme).authenticate(credentials, httpRequest, httpContext);
        }
        return authScheme.authenticate(credentials, httpRequest);
    }

    private void ensureAuthScheme(AuthScheme authScheme) {
        Asserts.notNull(authScheme, "Auth scheme");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void process(AuthState authState, HttpRequest httpRequest, HttpContext httpContext) {
        AuthScheme authScheme = authState.getAuthScheme();
        Credentials credentials = authState.getCredentials();
        int i2 = AnonymousClass1.$SwitchMap$org$apache$http$auth$AuthProtocolState[authState.getState().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                ensureAuthScheme(authScheme);
                if (authScheme.isConnectionBased()) {
                    return;
                }
            } else if (i2 == 3) {
                Queue<AuthOption> authOptions = authState.getAuthOptions();
                if (authOptions != null) {
                    while (!authOptions.isEmpty()) {
                        AuthOption remove = authOptions.remove();
                        AuthScheme authScheme2 = remove.getAuthScheme();
                        Credentials credentials2 = remove.getCredentials();
                        authState.update(authScheme2, credentials2);
                        if (this.log.d()) {
                            a aVar = this.log;
                            aVar.a("Generating response to an authentication challenge using " + authScheme2.getSchemeName() + " scheme");
                        }
                        try {
                            httpRequest.addHeader(authenticate(authScheme2, credentials2, httpRequest, httpContext));
                            return;
                        } catch (AuthenticationException e2) {
                            if (this.log.c()) {
                                a aVar2 = this.log;
                                aVar2.j(authScheme2 + " authentication error: " + e2.getMessage());
                            }
                        }
                    }
                    return;
                }
                ensureAuthScheme(authScheme);
            }
            if (authScheme != null) {
                try {
                    httpRequest.addHeader(authenticate(authScheme, credentials, httpRequest, httpContext));
                } catch (AuthenticationException e3) {
                    if (this.log.e()) {
                        a aVar3 = this.log;
                        aVar3.k(authScheme + " authentication error: " + e3.getMessage());
                    }
                }
            }
        }
    }
}