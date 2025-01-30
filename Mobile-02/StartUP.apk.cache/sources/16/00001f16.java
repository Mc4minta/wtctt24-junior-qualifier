package com.coinbase.wallet.features.networking.jwt;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.common.annotations.AppCoreScoped;
import com.coinbase.wallet.consumer.views.ConsumerAuthenticateWebViewClient;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* compiled from: AccessTokenAuthenticator.kt */
@AppCoreScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/features/networking/jwt/AccessTokenAuthenticator;", "Lokhttp3/Authenticator;", "Lokhttp3/Route;", "route", "Lokhttp3/Response;", Payload.RESPONSE, "Lokhttp3/Request;", "authenticate", "(Lokhttp3/Route;Lokhttp3/Response;)Lokhttp3/Request;", "Lcom/coinbase/wallet/features/networking/jwt/AccessTokenProviderInterface;", "tokenProvider", "Lcom/coinbase/wallet/features/networking/jwt/AccessTokenProviderInterface;", "<init>", "(Lcom/coinbase/wallet/features/networking/jwt/AccessTokenProviderInterface;)V", "HeaderConstants", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AccessTokenAuthenticator implements Authenticator {
    private static final String AUTH_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer";
    public static final HeaderConstants HeaderConstants = new HeaderConstants(null);
    private final AccessTokenProviderInterface tokenProvider;

    /* compiled from: AccessTokenAuthenticator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/features/networking/jwt/AccessTokenAuthenticator$HeaderConstants;", "", "", "AUTH_HEADER", "Ljava/lang/String;", "BEARER_PREFIX", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class HeaderConstants {
        private HeaderConstants() {
        }

        public /* synthetic */ HeaderConstants(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AccessTokenAuthenticator(AccessTokenProviderInterface tokenProvider) {
        m.g(tokenProvider, "tokenProvider");
        this.tokenProvider = tokenProvider;
    }

    @Override // okhttp3.Authenticator
    public Request authenticate(Route route, Response response) {
        String substring;
        m.g(response, "response");
        String header = response.request().header("Authorization");
        if (header == null) {
            substring = null;
        } else {
            substring = header.substring(7);
            m.f(substring, "(this as java.lang.String).substring(startIndex)");
        }
        if (substring == null) {
            return null;
        }
        synchronized (this) {
            String str = this.tokenProvider.token();
            if (m.c(str, substring) && (str = this.tokenProvider.refreshToken()) == null) {
                return null;
            }
            return response.request().newBuilder().removeHeader("Authorization").addHeader("Authorization", m.o(ConsumerAuthenticateWebViewClient.BEARER, str)).build();
        }
    }
}