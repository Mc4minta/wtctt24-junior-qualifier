package e.j.n;

import android.app.Activity;
import android.net.Uri;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.application.model.AppState;
import com.coinbase.wallet.application.model.Notification;
import com.coinbase.wallet.application.model.NotificationDestination;
import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.NotificationRepositoryInterface;
import com.coinbase.wallet.appreview.repositories.AppReviewRepository;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TxUpdate;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.annotations.ActivityScoped;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.crypto.extensions.String_CryptoKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.pushnotifications.repositories.PushNotificationRepository;
import com.coinbase.wallet.http.connectivity.ConnectionStatus;
import com.coinbase.wallet.routing.repositories.DeepLinkRepository;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.user.extensions.StoreKeys_UserKt;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.toshi.model.network.MinimumSupportBuild;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

/* compiled from: MainViewModel.kt */
@ActivityScoped
/* loaded from: classes2.dex */
public final class o2 extends androidx.lifecycle.b0 {
    private final e.j.j.b a;

    /* renamed from: b */
    private final NotificationRepositoryInterface f13915b;

    /* renamed from: c */
    private final UserRepository f13916c;

    /* renamed from: d */
    private final IWalletRepository f13917d;

    /* renamed from: e */
    private final AppLockRepositoryInterface f13918e;

    /* renamed from: f */
    private final DeepLinkRepository f13919f;

    /* renamed from: g */
    private final StoreInterface f13920g;

    /* renamed from: h */
    private final PushNotificationRepository f13921h;

    /* renamed from: i */
    private final AuthenticationHelper f13922i;

    /* renamed from: j */
    private final MnemonicRepositoryInterface f13923j;

    /* renamed from: k */
    private final h.c.s<ConnectionStatus> f13924k;

    /* renamed from: l */
    private final kotlin.h f13925l;
    private final h.c.s<List<Notification>> m;
    private final h.c.s<Notification> n;
    private final h.c.s<kotlin.x> o;
    private final h.c.b0<Boolean> p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Wallet, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a() {
            super(1);
            o2.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Wallet wallet) {
            invoke2(wallet);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Wallet it) {
            kotlin.jvm.internal.m.g(it, "it");
            o2.this.z(it.getPrimaryAddress());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.l<TxUpdate, kotlin.x> {
        final /* synthetic */ AppReviewRepository a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AppReviewRepository appReviewRepository) {
            super(1);
            this.a = appReviewRepository;
        }

        public final void a(TxUpdate txUpdate) {
            this.a.requestAppReview();
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(TxUpdate txUpdate) {
            a(txUpdate);
            return kotlin.x.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.a<h.c.k0.a> {
        public static final c a = new c();

        c() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final h.c.k0.a invoke() {
            return new h.c.k0.a();
        }
    }

    /* compiled from: Observable+Core.kt */
    /* loaded from: classes2.dex */
    public static final class d<T> implements h.c.m0.p {
        public static final d<T> a = new d<>();

        @Override // h.c.m0.p
        /* renamed from: a */
        public final boolean test(Optional<? extends T> it) {
            kotlin.jvm.internal.m.g(it, "it");
            return it.toNullable() != null;
        }
    }

    /* compiled from: Observable+Core.kt */
    /* loaded from: classes2.dex */
    public static final class e<T, R> implements h.c.m0.n {
        public static final e<T, R> a = new e<>();

        @Override // h.c.m0.n
        /* renamed from: a */
        public final T apply(Optional<? extends T> it) {
            kotlin.jvm.internal.m.g(it, "it");
            return it.toNullable();
        }
    }

    public o2(AppReviewRepository appReviewRepository, e.j.i.g2 versioningRepo, ITxRepository txRepository, e.j.j.b appPrefs, NotificationRepositoryInterface notificationRepository, UserRepository userRepository, IWalletRepository walletRepository, AppLockRepositoryInterface appLockRepository, DeepLinkRepository deepLinkRepository, StoreInterface store, PushNotificationRepository pushNotificationRepository, AuthenticationHelper authenticationHelper, MnemonicRepositoryInterface mnemonicRepository, h.c.s<ConnectionStatus> networkStatusObservable) {
        kotlin.h b2;
        kotlin.jvm.internal.m.g(appReviewRepository, "appReviewRepository");
        kotlin.jvm.internal.m.g(versioningRepo, "versioningRepo");
        kotlin.jvm.internal.m.g(txRepository, "txRepository");
        kotlin.jvm.internal.m.g(appPrefs, "appPrefs");
        kotlin.jvm.internal.m.g(notificationRepository, "notificationRepository");
        kotlin.jvm.internal.m.g(userRepository, "userRepository");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(appLockRepository, "appLockRepository");
        kotlin.jvm.internal.m.g(deepLinkRepository, "deepLinkRepository");
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(pushNotificationRepository, "pushNotificationRepository");
        kotlin.jvm.internal.m.g(authenticationHelper, "authenticationHelper");
        kotlin.jvm.internal.m.g(mnemonicRepository, "mnemonicRepository");
        kotlin.jvm.internal.m.g(networkStatusObservable, "networkStatusObservable");
        this.a = appPrefs;
        this.f13915b = notificationRepository;
        this.f13916c = userRepository;
        this.f13917d = walletRepository;
        this.f13918e = appLockRepository;
        this.f13919f = deepLinkRepository;
        this.f13920g = store;
        this.f13921h = pushNotificationRepository;
        this.f13922i = authenticationHelper;
        this.f13923j = mnemonicRepository;
        this.f13924k = networkStatusObservable;
        b2 = kotlin.k.b(c.a);
        this.f13925l = b2;
        versioningRepo.d();
        h.c.s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(walletRepository, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion));
        kotlin.jvm.internal.m.f(observeWallet, "walletRepository.observeWallet(Blockchain.ETHEREUM, CurrencyCode.ETH)");
        h.c.s<R> map = observeWallet.filter(d.a).map(e.a);
        kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        h.c.t0.a.a(h.c.t0.g.i(Single_AnalyticsKt.logError$default(Observable_CoreKt.takeSingle(map), "Primary address not available", null, 2, null), null, new a(), 1, null), getDisposeBag());
        h.c.s<TxUpdate> filter = txRepository.getTxUpdatesObservable().filter(new h.c.m0.p() { // from class: e.j.n.k0
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return o2.q((TxUpdate) obj);
            }
        });
        kotlin.jvm.internal.m.f(filter, "txRepository.txUpdatesObservable\n            .filter { it is TxUpdate.Submitted }");
        h.c.t0.a.a(h.c.t0.g.h(filter, null, null, new b(appReviewRepository), 3, null), getDisposeBag());
        this.m = notificationRepository.getUnreadNotificationsObservable();
        this.n = authenticationHelper.getLockoutNotificationObservable();
        this.o = appReviewRepository.getAppReviewObservable();
        h.c.b0<Boolean> map2 = Observable_CoreKt.takeSingle(versioningRepo.a()).doOnSuccess(new h.c.m0.f() { // from class: e.j.n.m0
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                o2.s(o2.this, (MinimumSupportBuild) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.n.n0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return o2.t((MinimumSupportBuild) obj);
            }
        });
        kotlin.jvm.internal.m.f(map2, "versioningRepo.minVersionObservable\n        .takeSingle()\n        .doOnSuccess { appPrefs.setLastMinSupportBuildNumber(it.android) }\n        .map { it.android < BuildConfig.VERSION_CODE }");
        this.p = map2;
    }

    public static final AppState a(o2 this$0, kotlin.t dstr$unlockRequired$hasCreatedWallets$hasMnemonic) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$unlockRequired$hasCreatedWallets$hasMnemonic, "$dstr$unlockRequired$hasCreatedWallets$hasMnemonic");
        Boolean unlockRequired = (Boolean) dstr$unlockRequired$hasCreatedWallets$hasMnemonic.a();
        Boolean hasCreatedWallets = (Boolean) dstr$unlockRequired$hasCreatedWallets$hasMnemonic.b();
        boolean has = this$0.f13920g.has(StoreKeys_UserKt.getActiveUser(StoreKeys.INSTANCE));
        if (((Boolean) dstr$unlockRequired$hasCreatedWallets$hasMnemonic.c()).booleanValue()) {
            if (has && hasCreatedWallets.booleanValue()) {
                kotlin.jvm.internal.m.f(unlockRequired, "unlockRequired");
                return unlockRequired.booleanValue() ? AppState.AppLocked.INSTANCE : AppState.AppUnlocked.INSTANCE;
            }
            kotlin.jvm.internal.m.f(hasCreatedWallets, "hasCreatedWallets");
            return new AppState.UnfinishedAccountSetup(hasCreatedWallets.booleanValue());
        }
        return AppState.NoStoredMnemonic.INSTANCE;
    }

    public static final boolean b(TxUpdate it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it instanceof TxUpdate.Submitted;
    }

    private final h.c.k0.a getDisposeBag() {
        return (h.c.k0.a) this.f13925l.getValue();
    }

    public static final void o(o2 this$0, MinimumSupportBuild minimumSupportBuild) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.a.d(minimumSupportBuild.getAndroid());
    }

    public static final Boolean p(MinimumSupportBuild it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(it.getAndroid() < 44000398);
    }

    public static /* synthetic */ boolean q(TxUpdate txUpdate) {
        return b(txUpdate);
    }

    public static /* synthetic */ AppState r(o2 o2Var, kotlin.t tVar) {
        return a(o2Var, tVar);
    }

    public static /* synthetic */ void s(o2 o2Var, MinimumSupportBuild minimumSupportBuild) {
        o(o2Var, minimumSupportBuild);
    }

    public static /* synthetic */ Boolean t(MinimumSupportBuild minimumSupportBuild) {
        return p(minimumSupportBuild);
    }

    public final void z(String str) {
        String r1;
        try {
            r1 = kotlin.l0.a0.r1(String_CryptoKt.sha256(str), new kotlin.i0.c(0, 31));
            com.google.firebase.crashlytics.b.a().g(r1);
            e.j.l.f.a.b(r1);
        } catch (NoSuchAlgorithmException e2) {
            l.a.a.f(e2, "MessageDigest implementation not available", new Object[0]);
        }
    }

    public final h.c.c A(String mnemonic) {
        kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
        if (this.f13920g.has(StoreKeys_UserKt.getActiveUser(StoreKeys.INSTANCE))) {
            h.c.c g2 = h.c.c.g();
            kotlin.jvm.internal.m.f(g2, "complete()");
            return g2;
        }
        h.c.c ignoreElement = this.f13916c.signIn(mnemonic).ignoreElement();
        kotlin.jvm.internal.m.f(ignoreElement, "userRepository.signIn(mnemonic).ignoreElement()");
        return ignoreElement;
    }

    public final h.c.s<Uri> B(Activity activity) {
        kotlin.jvm.internal.m.g(activity, "activity");
        return this.f13919f.setupSession(activity);
    }

    public final void C() {
        this.a.q();
    }

    public final void D() {
        this.f13918e.setIsAppLocked(false);
    }

    public final void d(Notification notification, NotificationDestination action) {
        kotlin.jvm.internal.m.g(notification, "notification");
        kotlin.jvm.internal.m.g(action, "action");
        this.f13915b.actionPerformed(notification, action);
    }

    public final h.c.b0<kotlin.x> e() {
        return this.f13922i.checkIfKeyInvalidated();
    }

    public final h.c.c f(String mnemonic) {
        kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
        h.c.c ignoreElement = this.f13917d.createWallets(mnemonic).ignoreElement();
        kotlin.jvm.internal.m.f(ignoreElement, "walletRepository.createWallets(mnemonic).ignoreElement()");
        return ignoreElement;
    }

    public final h.c.s<kotlin.x> g() {
        return this.o;
    }

    public final h.c.b0<AppState> h() {
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0 just = h.c.b0.just(Boolean.valueOf(this.f13918e.isUnlockRequiredOnAppFocus()));
        kotlin.jvm.internal.m.f(just, "just(appLockRepository.isUnlockRequiredOnAppFocus)");
        h.c.b0<AppState> map = eVar.b(just, this.f13917d.hasWallets(), this.f13923j.hasStoredMnemonic()).map(new h.c.m0.n() { // from class: e.j.n.l0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return o2.r(o2.this, (kotlin.t) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Singles.zip(\n            Single.just(appLockRepository.isUnlockRequiredOnAppFocus),\n            walletRepository.hasWallets(),\n            mnemonicRepository.hasStoredMnemonic()\n        ).map { (unlockRequired, hasCreatedWallets, hasMnemonic) ->\n            // When a user successfully signs in (via manual mnemonic entry or cloud backup restore)\n            // StoreKeys.activeUser becomes non-null\n            val hasActiveUser = store.has(StoreKeys.activeUser)\n\n            when {\n                !hasMnemonic -> AppState.NoStoredMnemonic\n                !hasActiveUser || !hasCreatedWallets -> AppState.UnfinishedAccountSetup(hasCreatedWallets)\n                unlockRequired -> AppState.AppLocked\n                else -> AppState.AppUnlocked\n            }\n        }");
        return map;
    }

    public final h.c.s<Notification> i() {
        return this.n;
    }

    public final h.c.s<ConnectionStatus> j() {
        return this.f13924k;
    }

    public final h.c.s<List<Notification>> k() {
        return this.m;
    }

    public final void l(Uri uri) {
        kotlin.jvm.internal.m.g(uri, "uri");
        this.f13919f.pushNewIntentUrl(uri);
    }

    public final boolean m() {
        return this.a.e();
    }

    public final h.c.b0<Boolean> n() {
        return this.p;
    }

    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        getDisposeBag().d();
    }

    public final void u() {
        this.a.r(false);
        this.f13918e.setIsAppLocked(true);
    }

    public final void v(Notification notification) {
        kotlin.jvm.internal.m.g(notification, "notification");
        this.f13915b.notificationSeen(notification);
    }

    public final void w(Map<String, String> data) {
        kotlin.jvm.internal.m.g(data, "data");
        this.f13921h.onNotificationSelected(data);
    }

    public final void x(String url) {
        kotlin.jvm.internal.m.g(url, "url");
        this.f13919f.pushDappDeeplink(url);
    }

    public final void y() {
        this.a.m();
    }
}