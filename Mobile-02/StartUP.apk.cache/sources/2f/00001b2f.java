package com.coinbase.wallet.di;

import android.content.Context;
import com.coinbase.wallet.common.annotations.AppCoreScoped;
import com.coinbase.wallet.core.jsonadapters.BigDecimalAdapter;
import com.coinbase.wallet.core.jsonadapters.BigIntegerAdapter;
import com.coinbase.wallet.features.networking.annotation.WalletApiUrl;
import com.coinbase.wallet.features.networking.annotation.WalletService;
import com.coinbase.wallet.features.networking.interceptor.AppInfoUserAgentInterceptor;
import com.coinbase.wallet.features.networking.jwt.AccessTokenAuthenticator;
import com.coinbase.wallet.features.networking.jwt.AccessTokenInterceptor;
import com.coinbase.wallet.features.networking.jwt.AccessTokenProvider;
import com.coinbase.wallet.features.networking.jwt.AccessTokenProviderInterface;
import com.coinbase.wallet.user.dtos.CreateAccessTokenResponseDTO;
import com.coinbase.wallet.user.repositories.AccessTokenRepository;
import com.coinbase.walletengine.services.xrp.UIntJsonAdapter;
import com.squareup.moshi.Moshi;
import h.c.b0;
import java.io.File;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.x;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.t;

/* compiled from: NetworkCoreModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/di/NetworkCoreModule;", "", "Lcom/coinbase/wallet/features/networking/jwt/AccessTokenProvider;", "accessTokenProvider", "Lcom/coinbase/wallet/features/networking/jwt/AccessTokenProviderInterface;", "(Lcom/coinbase/wallet/features/networking/jwt/AccessTokenProvider;)Lcom/coinbase/wallet/features/networking/jwt/AccessTokenProviderInterface;", "<init>", "()V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class NetworkCoreModule {
    private static final long CACHE_SIZE_MB = 5242880;
    public static final Companion Companion = new Companion(null);

    /* compiled from: NetworkCoreModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/coinbase/wallet/di/NetworkCoreModule$Companion;", "", "Landroid/content/Context;", "context", "Lokhttp3/Cache;", "provideCache", "(Landroid/content/Context;)Lokhttp3/Cache;", "cache", "Lokhttp3/OkHttpClient;", "baseOkHttpClient", "(Lokhttp3/Cache;)Lokhttp3/OkHttpClient;", "Lcom/squareup/moshi/Moshi;", "providesMoshi", "()Lcom/squareup/moshi/Moshi;", "moshi", "okHttpClient", "", "walletApiUrl", "Lretrofit2/t;", "baseRetrofit", "(Lcom/squareup/moshi/Moshi;Lokhttp3/OkHttpClient;Ljava/lang/String;)Lretrofit2/t;", "Lcom/coinbase/wallet/features/networking/jwt/AccessTokenAuthenticator;", "authenticator", "Lcom/coinbase/wallet/features/networking/jwt/AccessTokenInterceptor;", "accessTokenInterceptor", "retrofit", "baseWalletServiceRetrofit", "(Lokhttp3/OkHttpClient;Lcom/coinbase/wallet/features/networking/jwt/AccessTokenAuthenticator;Lcom/coinbase/wallet/features/networking/jwt/AccessTokenInterceptor;Lretrofit2/t;)Lretrofit2/t;", "Lcom/coinbase/wallet/user/repositories/AccessTokenRepository;", "accessTokenRepository", "Lh/c/b0;", "Lcom/coinbase/wallet/user/dtos/CreateAccessTokenResponseDTO;", "providesSignInHandler", "(Lcom/coinbase/wallet/user/repositories/AccessTokenRepository;)Lh/c/b0;", "", "CACHE_SIZE_MB", "J", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @AppCoreScoped
        public final OkHttpClient baseOkHttpClient(Cache cache) {
            m.g(cache, "cache");
            OkHttpClient.Builder cache2 = new OkHttpClient.Builder().cache(cache);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            OkHttpClient.Builder addInterceptor = cache2.connectTimeout(15L, timeUnit).readTimeout(15L, timeUnit).addInterceptor(new AppInfoUserAgentInterceptor());
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
            httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
            x xVar = x.a;
            return addInterceptor.addNetworkInterceptor(httpLoggingInterceptor).build();
        }

        @AppCoreScoped
        public final t baseRetrofit(Moshi moshi, OkHttpClient okHttpClient, @WalletApiUrl String walletApiUrl) {
            m.g(moshi, "moshi");
            m.g(okHttpClient, "okHttpClient");
            m.g(walletApiUrl, "walletApiUrl");
            t e2 = new t.b().c(walletApiUrl).f(okHttpClient).b(retrofit2.y.b.a.a(moshi)).a(retrofit2.adapter.rxjava2.g.b(h.c.u0.a.c())).e();
            m.f(e2, "Builder()\n            .baseUrl(walletApiUrl)\n            .callFactory(okHttpClient)\n            .addConverterFactory(MoshiConverterFactory.create(moshi))\n            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))\n            .build()");
            return e2;
        }

        @AppCoreScoped
        @WalletService
        public final t baseWalletServiceRetrofit(OkHttpClient okHttpClient, AccessTokenAuthenticator authenticator, AccessTokenInterceptor accessTokenInterceptor, t retrofit) {
            m.g(okHttpClient, "okHttpClient");
            m.g(authenticator, "authenticator");
            m.g(accessTokenInterceptor, "accessTokenInterceptor");
            m.g(retrofit, "retrofit");
            t e2 = retrofit.e().f(okHttpClient.newBuilder().authenticator(authenticator).addInterceptor(accessTokenInterceptor).build()).e();
            m.f(e2, "retrofit.newBuilder()\n                .callFactory(authenticatedOkHttpClient)\n                .build()");
            return e2;
        }

        @AppCoreScoped
        public final Cache provideCache(Context context) {
            m.g(context, "context");
            File filesDir = context.getFilesDir();
            m.f(filesDir, "context.filesDir");
            return new Cache(filesDir, NetworkCoreModule.CACHE_SIZE_MB);
        }

        @AppCoreScoped
        public final Moshi providesMoshi() {
            Moshi build = new Moshi.Builder().add(new BigDecimalAdapter()).add(new BigIntegerAdapter()).add(UInt.class, new UIntJsonAdapter()).build();
            m.f(build, "Builder()\n            .add(BigDecimalAdapter())\n            .add(BigIntegerAdapter())\n            .add(UInt::class.javaObjectType, UIntJsonAdapter())\n            .build()");
            return build;
        }

        public final b0<CreateAccessTokenResponseDTO> providesSignInHandler(AccessTokenRepository accessTokenRepository) {
            m.g(accessTokenRepository, "accessTokenRepository");
            return accessTokenRepository.getSignInHandler();
        }
    }

    @AppCoreScoped
    public static final OkHttpClient baseOkHttpClient(Cache cache) {
        return Companion.baseOkHttpClient(cache);
    }

    @AppCoreScoped
    public static final t baseRetrofit(Moshi moshi, OkHttpClient okHttpClient, @WalletApiUrl String str) {
        return Companion.baseRetrofit(moshi, okHttpClient, str);
    }

    @AppCoreScoped
    @WalletService
    public static final t baseWalletServiceRetrofit(OkHttpClient okHttpClient, AccessTokenAuthenticator accessTokenAuthenticator, AccessTokenInterceptor accessTokenInterceptor, t tVar) {
        return Companion.baseWalletServiceRetrofit(okHttpClient, accessTokenAuthenticator, accessTokenInterceptor, tVar);
    }

    @AppCoreScoped
    public static final Cache provideCache(Context context) {
        return Companion.provideCache(context);
    }

    @AppCoreScoped
    public static final Moshi providesMoshi() {
        return Companion.providesMoshi();
    }

    public static final b0<CreateAccessTokenResponseDTO> providesSignInHandler(AccessTokenRepository accessTokenRepository) {
        return Companion.providesSignInHandler(accessTokenRepository);
    }

    @AppCoreScoped
    public abstract AccessTokenProviderInterface accessTokenProvider(AccessTokenProvider accessTokenProvider);
}