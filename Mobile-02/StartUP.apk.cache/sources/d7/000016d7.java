package com.coinbase.wallet.consumer.repositories;

import android.net.Uri;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.AuthorizationRequest;
import com.coinbase.Coinbase;
import com.coinbase.Scope;
import com.coinbase.errors.CoinbaseException;
import com.coinbase.errors.Error;
import com.coinbase.errors.ErrorCodes;
import com.coinbase.resources.auth.AccessToken;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.common.models.UserProperties;
import com.coinbase.wallet.consumer.BuildConfig;
import com.coinbase.wallet.consumer.apis.ConsumerAPI;
import com.coinbase.wallet.consumer.extensions.AnalyticsEvent_ConsumerKt;
import com.coinbase.wallet.consumer.extensions.StoreKeys_ConsumerConnectKt;
import com.coinbase.wallet.consumer.extensions.TraceKey_ConsumerConnectKt;
import com.coinbase.wallet.consumer.models.Connected;
import com.coinbase.wallet.consumer.models.ConsumerConnectionStatus;
import com.coinbase.wallet.consumer.models.ConsumerNetworkConfig;
import com.coinbase.wallet.consumer.models.ConsumerUser;
import com.coinbase.wallet.consumer.models.NotConnected;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.Destroyable;
import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.models.TraceKey;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.featureflags.models.FeatureFlag;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;

/* compiled from: ConsumerUserRepository.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B?\b\u0007\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010,\u001a\u00020+\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0.\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u00103\u001a\u000202¢\u0006\u0004\bG\u0010HJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\t2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u0013\u0010\u0018J\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0019\u0010\u000eJ\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\t¢\u0006\u0004\b\u001a\u0010\u000eJ\u001b\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\fJ\r\u0010\u001c\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dR%\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001e\u0010&\u001a\n \u0012*\u0004\u0018\u00010%0%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020/0.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00038B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R0\u0010<\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020  \u0012*\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f0\u001f0;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00150>8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0013\u0010C\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\bC\u00106R\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006I"}, d2 = {"Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lcom/coinbase/wallet/core/interfaces/Destroyable;", "", "onrampEnabled", "Lcom/coinbase/wallet/consumer/models/ConsumerConnectionStatus;", "getConnectStatusForOnrampEnabled", "(Z)Lcom/coinbase/wallet/consumer/models/ConsumerConnectionStatus;", "isForced", "Lh/c/b0;", "Lkotlin/x;", "refresh", "(Z)Lh/c/b0;", "destroy", "()Lh/c/b0;", "Landroid/net/Uri;", "uri", "Lh/c/k0/b;", "kotlin.jvm.PlatformType", "getAccessToken", "(Landroid/net/Uri;)Lh/c/b0;", "", "redirectUri", "code", "(Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "revokeToken", "generateAuthRequest", "requireRefresh", "getConnectStatus", "()Lcom/coinbase/wallet/consumer/models/ConsumerConnectionStatus;", "Lh/c/s;", "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/consumer/models/ConsumerUser;", "userObservable", "Lh/c/s;", "getUserObservable", "()Lh/c/s;", "Lh/c/a0;", "mainScheduler", "Lh/c/a0;", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "featureFlagsRepository", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "Lcom/coinbase/wallet/consumer/apis/ConsumerAPI;", "consumerAPI", "Lcom/coinbase/wallet/consumer/apis/ConsumerAPI;", "Lf/a;", "Lcom/coinbase/Coinbase;", "coinbase", "Lf/a;", "Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "consumerNetworkConfig", "Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "getHasSignInRestrictions", "()Z", "hasSignInRestrictions", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lh/c/v0/a;", "userSubject", "Lh/c/v0/a;", "", "walletScopes", "[Ljava/lang/String;", "getWalletScopes", "()[Ljava/lang/String;", "isAuthenticated", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "<init>", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/consumer/apis/ConsumerAPI;Lf/a;Lcom/coinbase/wallet/core/interfaces/Tracing;Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerUserRepository implements Refreshable, Destroyable {
    private final f.a<Coinbase> coinbase;
    private final ConsumerAPI consumerAPI;
    private final ConsumerNetworkConfig consumerNetworkConfig;
    private final FeatureFlagsRepository featureFlagsRepository;
    private final h.c.a0 mainScheduler;
    private final StoreInterface store;
    private final Tracing tracer;
    private final h.c.s<Optional<ConsumerUser>> userObservable;
    private final h.c.v0.a<Optional<ConsumerUser>> userSubject;
    private final String[] walletScopes;

    public ConsumerUserRepository(StoreInterface store, ConsumerAPI consumerAPI, f.a<Coinbase> coinbase, Tracing tracer, FeatureFlagsRepository featureFlagsRepository, ConsumerNetworkConfig consumerNetworkConfig) {
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(consumerAPI, "consumerAPI");
        kotlin.jvm.internal.m.g(coinbase, "coinbase");
        kotlin.jvm.internal.m.g(tracer, "tracer");
        kotlin.jvm.internal.m.g(featureFlagsRepository, "featureFlagsRepository");
        kotlin.jvm.internal.m.g(consumerNetworkConfig, "consumerNetworkConfig");
        this.store = store;
        this.consumerAPI = consumerAPI;
        this.coinbase = coinbase;
        this.tracer = tracer;
        this.featureFlagsRepository = featureFlagsRepository;
        this.consumerNetworkConfig = consumerNetworkConfig;
        this.mainScheduler = h.c.j0.c.a.b();
        h.c.v0.a<Optional<ConsumerUser>> e2 = h.c.v0.a.e(OptionalKt.toOptional(null));
        kotlin.jvm.internal.m.f(e2, "createDefault<Optional<ConsumerUser>>(null.toOptional())");
        this.userSubject = e2;
        this.walletScopes = new String[]{Scope.Wallet.Transactions.SEND, Scope.Wallet.User.EMAIL, Scope.Wallet.Buys.READ, Scope.Wallet.Buys.CREATE, Scope.Wallet.Accounts.READ, Scope.Wallet.Transactions.READ, Scope.Wallet.User.READ, Scope.Wallet.PaymentMethods.READ, Scope.Wallet.PaymentMethods.LIMITS, Scope.Wallet.Addresses.READ, Scope.Wallet.Addresses.CREATE};
        h.c.s<Optional<ConsumerUser>> hide = e2.hide();
        kotlin.jvm.internal.m.f(hide, "userSubject.hide()");
        this.userObservable = hide;
    }

    public static /* synthetic */ h.c.k0.b b(ConsumerUserRepository consumerUserRepository, ConsumerUser consumerUser) {
        return m947refresh$lambda1(consumerUserRepository, consumerUser);
    }

    public static /* synthetic */ h.c.h0 c(ConsumerUserRepository consumerUserRepository, kotlin.o oVar) {
        return m943getAccessToken$lambda7(consumerUserRepository, oVar);
    }

    public static /* synthetic */ h.c.h0 d(ConsumerUserRepository consumerUserRepository, Throwable th) {
        return m948refresh$lambda3(consumerUserRepository, th);
    }

    /* renamed from: destroy$lambda-4 */
    public static final Boolean m940destroy$lambda4(kotlin.x it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.TRUE;
    }

    public static /* synthetic */ kotlin.x e(ConsumerUserRepository consumerUserRepository, kotlin.x xVar) {
        return m949revokeToken$lambda10(consumerUserRepository, xVar);
    }

    public static /* synthetic */ kotlin.o f(ConsumerUserRepository consumerUserRepository, Uri uri) {
        return m942getAccessToken$lambda5(consumerUserRepository, uri);
    }

    public static /* synthetic */ h.c.k0.b g(kotlin.x xVar) {
        return m944getAccessToken$lambda7$lambda6(xVar);
    }

    /* renamed from: generateAuthRequest$lambda-11 */
    public static final String m941generateAuthRequest$lambda11(ConsumerUserRepository this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        Uri parse = Uri.parse(BuildConfig.REDIRECT_URI);
        String[] walletScopes = this$0.getWalletScopes();
        AuthorizationRequest metaSendLimitCurrency = new AuthorizationRequest(parse, (String[]) Arrays.copyOf(walletScopes, walletScopes.length)).setMetaSendLimitAmount("5000").setMetaSendLimitCurrency("USD");
        metaSendLimitCurrency.setAccount(AuthorizationRequest.AccountSetting.ALL);
        return this$0.coinbase.get().buildAuthorizationUri(metaSendLimitCurrency).toString();
    }

    /* renamed from: getAccessToken$lambda-5 */
    public static final kotlin.o m942getAccessToken$lambda5(ConsumerUserRepository this$0, Uri uri) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(uri, "$uri");
        return kotlin.u.a(this$0.coinbase.get().getRedirectUrlFromUri(uri), this$0.coinbase.get().getAuthCodeFromUri(uri));
    }

    /* renamed from: getAccessToken$lambda-7 */
    public static final h.c.h0 m943getAccessToken$lambda7(ConsumerUserRepository this$0, kotlin.o dstr$redirectUri$code) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$redirectUri$code, "$dstr$redirectUri$code");
        String redirectUri = (String) dstr$redirectUri$code.a();
        String code = (String) dstr$redirectUri$code.b();
        kotlin.jvm.internal.m.f(redirectUri, "redirectUri");
        kotlin.jvm.internal.m.f(code, "code");
        return this$0.getAccessToken(redirectUri, code).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.g2
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerUserRepository.g((kotlin.x) obj);
            }
        });
    }

    /* renamed from: getAccessToken$lambda-7$lambda-6 */
    public static final h.c.k0.b m944getAccessToken$lambda7$lambda6(kotlin.x it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Analytics.INSTANCE.log(AnalyticsEvent_ConsumerKt.consumerConnectSuccess(AnalyticsEvent.Companion, "webview"));
    }

    /* renamed from: getAccessToken$lambda-8 */
    public static final String m945getAccessToken$lambda8(ConsumerUserRepository this$0, AccessToken accessToken) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(accessToken, "accessToken");
        StoreInterface storeInterface = this$0.store;
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        storeInterface.set(StoreKeys_ConsumerConnectKt.getConsumerAccessToken(storeKeys), accessToken.getAccessToken());
        this$0.store.set(StoreKeys_ConsumerConnectKt.getConsumerRefreshToken(storeKeys), accessToken.getRefreshToken());
        this$0.store.set(StoreKeys_ConsumerConnectKt.getConsumerScope(storeKeys), accessToken.getScope());
        this$0.userSubject.onNext(OptionalKt.toOptional(null));
        Analytics.INSTANCE.setUserProperties(UserProperties.INSTANCE.getConsumerConnectActivated());
        return accessToken.getAccessToken();
    }

    /* renamed from: getConnectStatus$lambda-12 */
    public static final ConsumerConnectionStatus m946getConnectStatus$lambda12(ConsumerUserRepository this$0, kotlin.o dstr$onrampUSAEnabled$onrampEUEnabled) {
        boolean z;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$onrampUSAEnabled$onrampEUEnabled, "$dstr$onrampUSAEnabled$onrampEUEnabled");
        Boolean onrampUSAEnabled = (Boolean) dstr$onrampUSAEnabled$onrampEUEnabled.a();
        Boolean onrampEUEnabled = (Boolean) dstr$onrampUSAEnabled$onrampEUEnabled.b();
        kotlin.jvm.internal.m.f(onrampUSAEnabled, "onrampUSAEnabled");
        if (!onrampUSAEnabled.booleanValue()) {
            kotlin.jvm.internal.m.f(onrampEUEnabled, "onrampEUEnabled");
            if (!onrampEUEnabled.booleanValue()) {
                z = false;
                return this$0.getConnectStatusForOnrampEnabled(z);
            }
        }
        z = true;
        return this$0.getConnectStatusForOnrampEnabled(z);
    }

    private final ConsumerConnectionStatus getConnectStatusForOnrampEnabled(boolean z) {
        if (isAuthenticated() && getHasSignInRestrictions()) {
            return new Connected(z, true, null, null, 12, null);
        }
        if (isAuthenticated()) {
            return new Connected(z, false, null, null, 12, null);
        }
        if (!isAuthenticated()) {
            return new NotConnected(z);
        }
        throw new IllegalStateException("Should never reach here, logic error");
    }

    private final boolean getHasSignInRestrictions() {
        List<String> restrictions;
        ConsumerUser consumerUser = (ConsumerUser) this.store.get(StoreKeys_ConsumerConnectKt.getConsumerUser(StoreKeys.INSTANCE));
        return (consumerUser == null || (restrictions = consumerUser.getRestrictions()) == null || !(restrictions.isEmpty() ^ true)) ? false : true;
    }

    public static /* synthetic */ ConsumerConnectionStatus h(ConsumerUserRepository consumerUserRepository, kotlin.o oVar) {
        return m946getConnectStatus$lambda12(consumerUserRepository, oVar);
    }

    public static /* synthetic */ Boolean i(kotlin.x xVar) {
        return m940destroy$lambda4(xVar);
    }

    public static /* synthetic */ String j(ConsumerUserRepository consumerUserRepository, AccessToken accessToken) {
        return m945getAccessToken$lambda8(consumerUserRepository, accessToken);
    }

    public static /* synthetic */ kotlin.x k(Throwable th) {
        return m950revokeToken$lambda9(th);
    }

    public static /* synthetic */ String l(ConsumerUserRepository consumerUserRepository) {
        return m941generateAuthRequest$lambda11(consumerUserRepository);
    }

    /* renamed from: refresh$lambda-1 */
    public static final h.c.k0.b m947refresh$lambda1(ConsumerUserRepository this$0, ConsumerUser user) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(user, "user");
        this$0.store.set(StoreKeys_ConsumerConnectKt.getConsumerUser(StoreKeys.INSTANCE), user);
        this$0.userSubject.onNext(OptionalKt.toOptional(user));
        return Analytics.INSTANCE.setUserProperties(UserProperties.INSTANCE.consumerUserRestrictions(user.getRestrictions()));
    }

    /* renamed from: refresh$lambda-3 */
    public static final h.c.h0 m948refresh$lambda3(ConsumerUserRepository this$0, Throwable it) {
        List u0;
        List P;
        Error error;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        if (it instanceof CoinbaseException) {
            List<Error> serverErrors = ((CoinbaseException) it).getServerErrors();
            String str = null;
            if (serverErrors != null && (error = (Error) kotlin.a0.p.Y(serverErrors)) != null) {
                str = error.getId();
            }
            if (kotlin.jvm.internal.m.c(str, ErrorCodes.UNVERIFIED_EMAIL)) {
                StoreInterface storeInterface = this$0.store;
                StoreKeys storeKeys = StoreKeys.INSTANCE;
                ConsumerUser consumerUser = (ConsumerUser) storeInterface.get(StoreKeys_ConsumerConnectKt.getConsumerUser(storeKeys));
                if (consumerUser == null) {
                    return h.c.b0.just(kotlin.x.a);
                }
                u0 = kotlin.a0.z.u0(consumerUser.getRestrictions(), ErrorCodes.UNVERIFIED_EMAIL);
                P = kotlin.a0.z.P(u0);
                ConsumerUser copy$default = ConsumerUser.copy$default(consumerUser, null, null, null, null, P, 15, null);
                this$0.store.set(StoreKeys_ConsumerConnectKt.getConsumerUser(storeKeys), copy$default);
                this$0.userSubject.onNext(OptionalKt.toOptional(copy$default));
                Analytics.INSTANCE.setUserProperties(UserProperties.INSTANCE.consumerUserRestrictions(copy$default.getRestrictions()));
            }
        }
        return h.c.b0.just(kotlin.x.a);
    }

    /* renamed from: revokeToken$lambda-10 */
    public static final kotlin.x m949revokeToken$lambda10(ConsumerUserRepository this$0, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        StoreInterface storeInterface = this$0.store;
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        storeInterface.set(StoreKeys_ConsumerConnectKt.getConsumerAccessToken(storeKeys), null);
        this$0.store.set(StoreKeys_ConsumerConnectKt.getConsumerRefreshToken(storeKeys), null);
        this$0.store.set(StoreKeys_ConsumerConnectKt.getConsumerScope(storeKeys), null);
        this$0.store.set(StoreKeys_ConsumerConnectKt.getConsumerUser(storeKeys), null);
        this$0.userSubject.onNext(new Optional<>(null));
        this$0.coinbase.get().logout();
        return kotlin.x.a;
    }

    /* renamed from: revokeToken$lambda-9 */
    public static final kotlin.x m950revokeToken$lambda9(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    @Override // com.coinbase.wallet.core.interfaces.Destroyable
    public h.c.b0<Boolean> destroy() {
        h.c.b0 map = revokeToken().map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.i2
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerUserRepository.i((kotlin.x) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "revokeToken().map { true }");
        return map;
    }

    public final h.c.b0<String> generateAuthRequest() {
        h.c.b0<String> fromCallable = h.c.b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.consumer.repositories.l2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ConsumerUserRepository.l(ConsumerUserRepository.this);
            }
        });
        kotlin.jvm.internal.m.f(fromCallable, "fromCallable {\n        val authorizationRequest = AuthorizationRequest(Uri.parse(BuildConfig.REDIRECT_URI), *walletScopes)\n            .setMetaSendLimitAmount(\"5000\")\n            .setMetaSendLimitCurrency(\"USD\")\n\n        // Set ALL to make sure the sample app can see all user's accounts.\n        authorizationRequest.setAccount(AuthorizationRequest.AccountSetting.ALL)\n        coinbase.get().buildAuthorizationUri(authorizationRequest).toString()\n    }");
        return fromCallable;
    }

    public final h.c.b0<h.c.k0.b> getAccessToken(final Uri uri) {
        kotlin.jvm.internal.m.g(uri, "uri");
        h.c.b0<h.c.k0.b> flatMap = h.c.b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.consumer.repositories.f2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ConsumerUserRepository.f(ConsumerUserRepository.this, uri);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.c2
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerUserRepository.c(ConsumerUserRepository.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "fromCallable { coinbase.get().getRedirectUrlFromUri(uri) to coinbase.get().getAuthCodeFromUri(uri) }\n        .flatMap { (redirectUri, code) ->\n            getAccessToken(redirectUri, code)\n                .map {\n                    Analytics.log(AnalyticsEvent.consumerConnectSuccess(\"webview\"))\n                }\n        }");
        return flatMap;
    }

    public final h.c.b0<ConsumerConnectionStatus> getConnectStatus(boolean z) {
        h.c.b0<ConsumerConnectionStatus> map = h.c.t0.e.a.a(FeatureFlagsRepository.value$default(this.featureFlagsRepository, FeatureFlag.ONRAMP_USA, z, 0L, 4, null), FeatureFlagsRepository.value$default(this.featureFlagsRepository, FeatureFlag.ONRAMP_EU, z, 0L, 4, null)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.h2
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerUserRepository.h(ConsumerUserRepository.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Singles\n            .zip(\n                featureFlagsRepository.value(featureFlag = FeatureFlag.ONRAMP_USA, requireRefresh = requireRefresh),\n                featureFlagsRepository.value(featureFlag = FeatureFlag.ONRAMP_EU, requireRefresh = requireRefresh)\n            )\n            .map { (onrampUSAEnabled, onrampEUEnabled) ->\n                getConnectStatusForOnrampEnabled(onrampUSAEnabled || onrampEUEnabled)\n            }");
        return map;
    }

    public final h.c.s<Optional<ConsumerUser>> getUserObservable() {
        return this.userObservable;
    }

    public final String[] getWalletScopes() {
        return this.walletScopes;
    }

    public final boolean isAuthenticated() {
        return this.store.has(StoreKeys_ConsumerConnectKt.getConsumerAccessToken(StoreKeys.INSTANCE));
    }

    @Override // com.coinbase.wallet.core.interfaces.Refreshable
    public h.c.b0<kotlin.x> refresh(boolean z) {
        ConsumerUser consumerUser = (ConsumerUser) this.store.get(StoreKeys_ConsumerConnectKt.getConsumerUser(StoreKeys.INSTANCE));
        if (consumerUser != null) {
            this.userSubject.onNext(OptionalKt.toOptional(consumerUser));
        }
        if (!isAuthenticated()) {
            h.c.b0<kotlin.x> just = h.c.b0.just(kotlin.x.a);
            kotlin.jvm.internal.m.f(just, "just(Unit)");
            return just;
        }
        h.c.b0<R> map = this.consumerAPI.getUser().map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.b2
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerUserRepository.b(ConsumerUserRepository.this, (ConsumerUser) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerAPI.getUser()\n            .map { user ->\n                store.set(StoreKeys.consumerUser, user)\n                userSubject.onNext(user.toOptional())\n                Analytics.setUserProperties(UserProperties.consumerUserRestrictions(user.restrictions))\n            }");
        h.c.b0 onErrorResumeNext = Single_AnalyticsKt.logError$default(Single_CoreKt.asUnit(map), null, null, 3, null).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.d2
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerUserRepository.d(ConsumerUserRepository.this, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorResumeNext, "consumerAPI.getUser()\n            .map { user ->\n                store.set(StoreKeys.consumerUser, user)\n                userSubject.onNext(user.toOptional())\n                Analytics.setUserProperties(UserProperties.consumerUserRestrictions(user.restrictions))\n            }\n            .asUnit()\n            .logError()\n            .onErrorResumeNext {\n                if (it is CoinbaseException && it.serverErrors?.first()?.id == \"unverified_email\") {\n                    val user = store.get(StoreKeys.consumerUser) ?: return@onErrorResumeNext Single.just(Unit)\n\n                    val restrictions = (user.restrictions + \"unverified_email\").distinct()\n                    user.copy(restrictions = restrictions).also { updatedUser ->\n                        store.set(StoreKeys.consumerUser, updatedUser)\n                        userSubject.onNext(updatedUser.toOptional())\n                        Analytics.setUserProperties(\n                            UserProperties.consumerUserRestrictions(updatedUser.restrictions)\n                        )\n                    }\n                }\n                Single.just(Unit)\n            }");
        h.c.b0<kotlin.x> trace = Single_CoreKt.trace(onErrorResumeNext, TraceKey_ConsumerConnectKt.consumerUserRepositoryTrace(TraceKey.Companion), this.tracer);
        kotlin.jvm.internal.m.f(trace, "consumerAPI.getUser()\n            .map { user ->\n                store.set(StoreKeys.consumerUser, user)\n                userSubject.onNext(user.toOptional())\n                Analytics.setUserProperties(UserProperties.consumerUserRestrictions(user.restrictions))\n            }\n            .asUnit()\n            .logError()\n            .onErrorResumeNext {\n                if (it is CoinbaseException && it.serverErrors?.first()?.id == \"unverified_email\") {\n                    val user = store.get(StoreKeys.consumerUser) ?: return@onErrorResumeNext Single.just(Unit)\n\n                    val restrictions = (user.restrictions + \"unverified_email\").distinct()\n                    user.copy(restrictions = restrictions).also { updatedUser ->\n                        store.set(StoreKeys.consumerUser, updatedUser)\n                        userSubject.onNext(updatedUser.toOptional())\n                        Analytics.setUserProperties(\n                            UserProperties.consumerUserRestrictions(updatedUser.restrictions)\n                        )\n                    }\n                }\n                Single.just(Unit)\n            }\n            .trace(TraceKey.consumerUserRepositoryTrace(), tracer)");
        return trace;
    }

    public final h.c.b0<kotlin.x> revokeToken() {
        String str = (String) this.store.get(StoreKeys_ConsumerConnectKt.getConsumerAccessToken(StoreKeys.INSTANCE));
        if (str == null) {
            h.c.b0<kotlin.x> just = h.c.b0.just(kotlin.x.a);
            kotlin.jvm.internal.m.f(just, "just(Unit)");
            return just;
        }
        h.c.b0<kotlin.x> observeOn = this.consumerAPI.revokeAccessToken(str).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.k2
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerUserRepository.k((Throwable) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.e2
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerUserRepository.e(ConsumerUserRepository.this, (kotlin.x) obj);
            }
        }).observeOn(this.mainScheduler);
        kotlin.jvm.internal.m.f(observeOn, "consumerAPI.revokeAccessToken(accessToken)\n            .onErrorReturn { Unit }\n            .map {\n                store.set(StoreKeys.consumerAccessToken, null)\n                store.set(StoreKeys.consumerRefreshToken, null)\n                store.set(StoreKeys.consumerScope, null)\n                store.set(StoreKeys.consumerUser, null)\n                userSubject.onNext(Optional(null))\n                coinbase.get().logout()\n            }\n            .observeOn(mainScheduler)");
        return observeOn;
    }

    public final h.c.b0<kotlin.x> getAccessToken(String redirectUri, String code) {
        kotlin.jvm.internal.m.g(redirectUri, "redirectUri");
        kotlin.jvm.internal.m.g(code, "code");
        h.c.b0 map = Single_AnalyticsKt.logError$default(this.consumerAPI.getAccessToken(code, this.consumerNetworkConfig.getClientId(), this.consumerNetworkConfig.getClientSecret(), redirectUri), "Error while storing auth from URI", null, 2, null).map(new h.c.m0.n() { // from class: com.coinbase.wallet.consumer.repositories.j2
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerUserRepository.j(ConsumerUserRepository.this, (AccessToken) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "consumerAPI\n            .getAccessToken(code, consumerNetworkConfig.clientId, consumerNetworkConfig.clientSecret, redirectUri)\n            .logError(\"Error while storing auth from URI\")\n            .map { accessToken ->\n                store.set(StoreKeys.consumerAccessToken, accessToken.accessToken)\n                store.set(StoreKeys.consumerRefreshToken, accessToken.refreshToken)\n                store.set(StoreKeys.consumerScope, accessToken.scope)\n                userSubject.onNext(null.toOptional())\n                Analytics.setUserProperties(UserProperties.consumerConnectActivated)\n                accessToken.accessToken\n            }");
        return Single_CoreKt.asUnit(map);
    }

    public final ConsumerConnectionStatus getConnectStatus() {
        return getConnectStatusForOnrampEnabled(this.featureFlagsRepository.valueSync(FeatureFlag.ONRAMP_USA) || this.featureFlagsRepository.valueSync(FeatureFlag.ONRAMP_EU));
    }
}