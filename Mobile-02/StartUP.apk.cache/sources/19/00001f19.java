package com.coinbase.wallet.features.networking.jwt;

import com.coinbase.wallet.consumer.views.ConsumerAuthenticateWebViewClient;
import com.coinbase.wallet.user.annotations.AuthenticatedRequest;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.k;

/* compiled from: AccessTokenInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/features/networking/jwt/AccessTokenInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lcom/coinbase/wallet/features/networking/jwt/AccessTokenProviderInterface;", "tokenProvider", "Lcom/coinbase/wallet/features/networking/jwt/AccessTokenProviderInterface;", "<init>", "(Lcom/coinbase/wallet/features/networking/jwt/AccessTokenProviderInterface;)V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AccessTokenInterceptor implements Interceptor {
    private static final String AuthHeaderPrefix = "Authorization";
    public static final Companion Companion = new Companion(null);
    private final AccessTokenProviderInterface tokenProvider;

    /* compiled from: AccessTokenInterceptor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/networking/jwt/AccessTokenInterceptor$Companion;", "", "", "AuthHeaderPrefix", "Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AccessTokenInterceptor(AccessTokenProviderInterface tokenProvider) {
        m.g(tokenProvider, "tokenProvider");
        this.tokenProvider = tokenProvider;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        String str;
        Request build;
        Method a;
        m.g(chain, "chain");
        Request request = chain.request();
        k kVar = (k) request.tag(k.class);
        AuthenticatedRequest authenticatedRequest = null;
        if (kVar != null && (a = kVar.a()) != null) {
            authenticatedRequest = (AuthenticatedRequest) a.getAnnotation(AuthenticatedRequest.class);
        }
        if (authenticatedRequest != null && (str = this.tokenProvider.token()) != null && (build = request.newBuilder().addHeader("Authorization", m.o(ConsumerAuthenticateWebViewClient.BEARER, str)).build()) != null) {
            request = build;
        }
        return chain.proceed(request);
    }
}