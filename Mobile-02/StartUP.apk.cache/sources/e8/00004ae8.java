package e.j.n;

import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.analytics.models.AnalyticsUserProperty;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.application.extensions.BigInteger_ApplicationKt;
import com.coinbase.wallet.bitcoin.extensions.CurrencyCode_BitcoinKt;
import com.coinbase.wallet.bitcoincash.extensions.CurrencyCode_BitcoinCashKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.models.UserProperties;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.featureflags.models.FeatureFlag;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.swap.models.SwapInterstitialFragmentArgs;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.litecoin.extensions.CurrencyCode_LitecoinKt;
import com.coinbase.wallet.ripple.extensions.CurrencyCode_RippleKt;
import com.coinbase.wallet.user.models.User;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.toshi.R;

/* compiled from: HomeViewModel.kt */
/* loaded from: classes2.dex */
public final class l2 extends androidx.lifecycle.b0 {
    private final e.j.i.i2.b a;

    /* renamed from: b */
    private final FeatureFlagsRepository f13886b;

    /* renamed from: c */
    private final ConsumerUserRepository f13887c;

    /* renamed from: d */
    private final e.j.j.b f13888d;

    /* renamed from: e */
    private final e.j.i.c2 f13889e;

    /* renamed from: f */
    private final IWalletRepository f13890f;

    /* renamed from: g */
    private final h.c.a0 f13891g;

    /* renamed from: h */
    private final h.c.v0.b<ViewModelNavRoute> f13892h;

    /* renamed from: i */
    private final h.c.v0.b<ViewModelNavRoute> f13893i;

    /* renamed from: j */
    private final h.c.v0.b<kotlin.x> f13894j;

    /* renamed from: k */
    private final h.c.k0.a f13895k;

    /* renamed from: l */
    private final h.c.s<Boolean> f13896l;
    private final h.c.s<ViewModelNavRoute> m;
    private final h.c.s<User> n;
    private final h.c.s<ViewModelNavRoute> o;
    private final h.c.s<kotlin.x> p;
    private final h.c.s<Boolean> q;
    private final h.c.s<String> r;
    private final h.c.s<Boolean> s;
    private final h.c.s<Boolean> t;
    private final h.c.s<List<AnalyticsUserProperty>> u;
    private final h.c.s<Boolean> v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<List<? extends Wallet>, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a() {
            super(1);
            l2.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(List<? extends Wallet> list) {
            invoke2((List<Wallet>) list);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(List<Wallet> wallets) {
            kotlin.jvm.internal.m.g(wallets, "wallets");
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.globalSendSelected(AnalyticsEvent.Companion));
            if (!wallets.isEmpty()) {
                l2.this.f13894j.onNext(kotlin.x.a);
            } else {
                l2.this.f13892h.onNext(new ViewModelNavRoute(R.id.fundActionSheetFragment, com.toshi.view.fragment.k0.a.a(LocalizedStrings.INSTANCE.get(R.string.fund_sheet_dialog_title), false, l2.this.f13887c.getConnectStatus()), null, 4, null));
            }
        }
    }

    /* compiled from: Observables.kt */
    /* loaded from: classes2.dex */
    public static final class b<T1, T2, T3, R> implements h.c.m0.g<T1, T2, T3, R> {
        final /* synthetic */ CurrencyFormatter a;

        public b(CurrencyFormatter currencyFormatter) {
            this.a = currencyFormatter;
        }

        /* JADX WARN: Removed duplicated region for block: B:161:0x0174 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:163:0x010d A[SYNTHETIC] */
        @Override // h.c.m0.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final R a(T1 r18, T2 r19, T3 r20) {
            /*
                Method dump skipped, instructions count: 433
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: e.j.n.l2.b.a(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: Observable+Core.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements h.c.m0.p {
        public static final c<T> a = new c<>();

        @Override // h.c.m0.p
        /* renamed from: a */
        public final boolean test(Optional<? extends T> it) {
            kotlin.jvm.internal.m.g(it, "it");
            return it.toNullable() != null;
        }
    }

    /* compiled from: Observable+Core.kt */
    /* loaded from: classes2.dex */
    public static final class d<T, R> implements h.c.m0.n {
        public static final d<T, R> a = new d<>();

        @Override // h.c.m0.n
        /* renamed from: a */
        public final T apply(Optional<? extends T> it) {
            kotlin.jvm.internal.m.g(it, "it");
            return it.toNullable();
        }
    }

    public l2(UserRepository userRepository, e.j.i.i2.b collectibleTypesRepository, IExchangeRateRepository exchangeRateRepository, ILendRepository lendRepository, CurrencyFormatter currencyFormatter, FeatureFlagsRepository featureFlagsRepository, ConsumerUserRepository consumerUserRepository, e.j.j.b appPrefs, e.j.i.c2 refreshService, IWalletRepository walletRepository) {
        kotlin.jvm.internal.m.g(userRepository, "userRepository");
        kotlin.jvm.internal.m.g(collectibleTypesRepository, "collectibleTypesRepository");
        kotlin.jvm.internal.m.g(exchangeRateRepository, "exchangeRateRepository");
        kotlin.jvm.internal.m.g(lendRepository, "lendRepository");
        kotlin.jvm.internal.m.g(currencyFormatter, "currencyFormatter");
        kotlin.jvm.internal.m.g(featureFlagsRepository, "featureFlagsRepository");
        kotlin.jvm.internal.m.g(consumerUserRepository, "consumerUserRepository");
        kotlin.jvm.internal.m.g(appPrefs, "appPrefs");
        kotlin.jvm.internal.m.g(refreshService, "refreshService");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        this.a = collectibleTypesRepository;
        this.f13886b = featureFlagsRepository;
        this.f13887c = consumerUserRepository;
        this.f13888d = appPrefs;
        this.f13889e = refreshService;
        this.f13890f = walletRepository;
        h.c.a0 c2 = h.c.u0.a.c();
        kotlin.jvm.internal.m.f(c2, "io()");
        this.f13891g = c2;
        h.c.v0.b<ViewModelNavRoute> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<ViewModelNavRoute>()");
        this.f13892h = d2;
        h.c.v0.b<ViewModelNavRoute> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<ViewModelNavRoute>()");
        this.f13893i = d3;
        h.c.v0.b<kotlin.x> d4 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d4, "create<Unit>()");
        this.f13894j = d4;
        this.f13895k = new h.c.k0.a();
        h.c.s<Boolean> tokensAreNonZero = walletRepository.observeWallets(true).map(new h.c.m0.n() { // from class: e.j.n.j0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return l2.u((List) obj);
            }
        }).distinctUntilChanged();
        this.f13896l = tokensAreNonZero;
        h.c.s<ViewModelNavRoute> hide = d3.hide();
        kotlin.jvm.internal.m.f(hide, "navigationSubject.hide()");
        this.m = hide;
        h.c.s map = userRepository.getActiveUserObservable().filter(c.a).map(d.a);
        kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        this.n = map;
        h.c.s<ViewModelNavRoute> hide2 = d2.hide();
        kotlin.jvm.internal.m.f(hide2, "showTransferWalletsActionSubject.hide()");
        this.o = hide2;
        h.c.s<kotlin.x> hide3 = d4.hide();
        kotlin.jvm.internal.m.f(hide3, "launchSendFlowSubject.hide()");
        this.p = hide3;
        this.q = refreshService.f();
        h.c.t0.c cVar = h.c.t0.c.a;
        h.c.s distinctUntilChanged = h.c.s.combineLatest(walletRepository.observeWallets(true), exchangeRateRepository.getExchangeRateObservable(), lendRepository.observeTokens(), new b(currencyFormatter)).distinctUntilChanged();
        kotlin.jvm.internal.m.f(distinctUntilChanged, "Observables\n        .combineLatest(\n            walletRepository.observeWallets(true),\n            exchangeRateRepository.exchangeRateObservable,\n            lendRepository.observeTokens()\n        ) { wallets, exchangeRates, lendTokens ->\n            val walletBalance = wallets\n                .filter { !it.network.isTestnet }\n                .mapNotNull { wallet ->\n                    val exchangeRate = exchangeRates.rateFor(\n                        currencyCode = wallet.currencyCode,\n                        contractAddress = wallet.contractAddress,\n                        chainId = wallet.network.asEthereumChain?.chainId\n                    ) ?: return@mapNotNull null\n                    return@mapNotNull (exchangeRate.times(wallet.balance.toBigDecimal()))\n                        .divide(BigDecimal.TEN.pow(wallet.decimals))\n                }\n                .fold(BigDecimal.ZERO) { sum, balance -> sum + balance }\n\n            val walletMap: Map<String, Wallet> = wallets.reduceIntoMap { mutableMap, wallet ->\n                mutableMap[wallet.primaryAddress] = wallet\n            }\n            // Dydx Lending does not return tokens (E.g Ctoken, Atoken) So must be calculated separately\n            val lendBalance = lendTokens\n                .filter { it.provider.id == LendProviderID.dydx }\n                .mapNotNull { token ->\n                    val wallet = walletMap[token.walletAddress] ?: return@mapNotNull null\n                    val ethereumChain = EthereumChain.fromNetworkRawValue(wallet.network.rawValue)\n                    if (ethereumChain != EthereumChain.ETHEREUM_MAINNET) return@mapNotNull null\n                    val exchangeRate = exchangeRates.rateFor(\n                        currencyCode = token.currencyCode,\n                        contractAddress = token.contractAddress?.rawValue\n                    ) ?: return@mapNotNull null\n\n                    (exchangeRate * BigDecimal(token.supplyBalance)).movePointLeft(token.decimals)\n                }\n                .fold(BigDecimal.ZERO) { sum, balance -> sum + balance }\n\n            currencyFormatter.fiatValueString(walletBalance + lendBalance)\n        }\n        .distinctUntilChanged()");
        this.r = Observable_AnalyticsKt.logError$default(distinctUntilChanged, "Error while observing wallets", null, 2, null);
        h.c.s<Boolean> distinctUntilChanged2 = collectibleTypesRepository.a().map(new h.c.m0.n() { // from class: e.j.n.e0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return l2.p((List) obj);
            }
        }).distinctUntilChanged();
        kotlin.jvm.internal.m.f(distinctUntilChanged2, "collectibleTypesRepository.collectibleTypesObservable\n        .map { it.isNotEmpty() }\n        .distinctUntilChanged()");
        this.s = distinctUntilChanged2;
        kotlin.jvm.internal.m.f(tokensAreNonZero, "tokensAreNonZero");
        h.c.s<Boolean> subscribeOn = cVar.a(tokensAreNonZero, distinctUntilChanged2).filter(new h.c.m0.p() { // from class: e.j.n.h0
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return l2.s(l2.this, (kotlin.o) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.n.f0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return l2.q(l2.this, (kotlin.o) obj);
            }
        }).subscribeOn(c2);
        kotlin.jvm.internal.m.f(subscribeOn, "Observables\n        .combineLatest(tokensAreNonZero, collectiblesAreNonZero)\n        .filter { (it.first || it.second) && !appPrefs.hasUserActivated() }\n        .map {\n            appPrefs.setHasUserActivated(true)\n            true\n        }\n        .subscribeOn(concurrentScheduler)");
        this.t = subscribeOn;
        h.c.s<List<AnalyticsUserProperty>> distinctUntilChanged3 = walletRepository.observeWallets(false).map(new h.c.m0.n() { // from class: e.j.n.i0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return l2.t((List) obj);
            }
        }).distinctUntilChanged();
        kotlin.jvm.internal.m.f(distinctUntilChanged3, "walletRepository.observeWallets(false)\n        .map { wallets ->\n            val list = mutableListOf<AnalyticsUserProperty>()\n            wallets.forEach {\n                if (it.balance.isMoreThanZero()) {\n                    when (it.currencyCode) {\n                        CurrencyCode.ETH -> list.add(userHasETH)\n                        CurrencyCode.ETC -> list.add(userHasETC)\n                        CurrencyCode.BTC -> list.add(userHasBTC)\n                        CurrencyCode.BCH -> list.add(userHasBCH)\n                        CurrencyCode.LTC -> list.add(userHasLTC)\n                        CurrencyCode.XRP -> list.add(userHasXRP)\n                    }\n                }\n            }\n            return@map list.toList()\n        }\n        .distinctUntilChanged()");
        this.u = distinctUntilChanged3;
        h.c.s<Network> observeNetwork = walletRepository.observeNetwork(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion));
        h.c.s observable = FeatureFlagsRepository.getOrFetchValue$default(featureFlagsRepository, FeatureFlag.NATIVE_DEX, 0L, 2, null).toObservable();
        kotlin.jvm.internal.m.f(observable, "featureFlagsRepository.getOrFetchValue(featureFlag = FeatureFlag.NATIVE_DEX).toObservable()");
        h.c.s observable2 = FeatureFlagsRepository.getOrFetchValue$default(featureFlagsRepository, FeatureFlag.L2_POLYGON_DEX, 0L, 2, null).toObservable();
        kotlin.jvm.internal.m.f(observable2, "featureFlagsRepository.getOrFetchValue(featureFlag = FeatureFlag.L2_POLYGON_DEX).toObservable()");
        h.c.s<Boolean> map2 = cVar.b(observeNetwork, observable, observable2).map(new h.c.m0.n() { // from class: e.j.n.g0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return l2.r((kotlin.t) obj);
            }
        });
        kotlin.jvm.internal.m.f(map2, "Observables.combineLatest(\n        walletRepository.observeNetwork(Blockchain.ETHEREUM),\n        featureFlagsRepository.getOrFetchValue(featureFlag = FeatureFlag.NATIVE_DEX).toObservable(),\n        featureFlagsRepository.getOrFetchValue(featureFlag = FeatureFlag.L2_POLYGON_DEX).toObservable()\n    )\n        .map { (network, flagEnabled, l2FlagEnabled) ->\n            (network.asEthereumChain == EthereumChain.ETHEREUM_MAINNET && flagEnabled) ||\n                (network.asEthereumChain == EthereumChain.POLYGON_MAINNET && l2FlagEnabled)\n        }");
        this.v = map2;
    }

    public static final Boolean A(l2 this$0, kotlin.o it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.f13888d.o(true);
        return Boolean.TRUE;
    }

    public static final Boolean d(List it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(!it.isEmpty());
    }

    public static final List l(List wallets) {
        List I0;
        kotlin.jvm.internal.m.g(wallets, "wallets");
        ArrayList arrayList = new ArrayList();
        Iterator it = wallets.iterator();
        while (it.hasNext()) {
            Wallet wallet = (Wallet) it.next();
            if (BigInteger_ApplicationKt.isMoreThanZero(wallet.getBalance())) {
                CurrencyCode currencyCode = wallet.getCurrencyCode();
                CurrencyCode.Companion companion = CurrencyCode.Companion;
                if (kotlin.jvm.internal.m.c(currencyCode, CurrencyCode_EthereumKt.getETH(companion))) {
                    arrayList.add(UserProperties.INSTANCE.getUserHasETH());
                } else if (kotlin.jvm.internal.m.c(currencyCode, CurrencyCode_EthereumKt.getETC(companion))) {
                    arrayList.add(UserProperties.INSTANCE.getUserHasETC());
                } else if (kotlin.jvm.internal.m.c(currencyCode, CurrencyCode_BitcoinKt.getBTC(companion))) {
                    arrayList.add(UserProperties.INSTANCE.getUserHasBTC());
                } else if (kotlin.jvm.internal.m.c(currencyCode, CurrencyCode_BitcoinCashKt.getBCH(companion))) {
                    arrayList.add(UserProperties.INSTANCE.getUserHasBCH());
                } else if (kotlin.jvm.internal.m.c(currencyCode, CurrencyCode_LitecoinKt.getLTC(companion))) {
                    arrayList.add(UserProperties.INSTANCE.getUserHasLTC());
                } else if (kotlin.jvm.internal.m.c(currencyCode, CurrencyCode_RippleKt.getXRP(companion))) {
                    arrayList.add(UserProperties.INSTANCE.getUserHasXRP());
                }
            }
        }
        I0 = kotlin.a0.z.I0(arrayList);
        return I0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0028, code lost:
        if (r1.booleanValue() == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
        if (r4.booleanValue() != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003d, code lost:
        r4 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Boolean o(kotlin.t r4) {
        /*
            java.lang.String r0 = "$dstr$network$flagEnabled$l2FlagEnabled"
            kotlin.jvm.internal.m.g(r4, r0)
            java.lang.Object r0 = r4.a()
            com.coinbase.wallet.blockchains.models.Network r0 = (com.coinbase.wallet.blockchains.models.Network) r0
            java.lang.Object r1 = r4.b()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            java.lang.Object r4 = r4.c()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            com.coinbase.ciphercore.ethereum.EthereumChain r2 = com.coinbase.wallet.ethereum.extensions.Network_EthereumKt.getAsEthereumChain(r0)
            com.coinbase.ciphercore.ethereum.EthereumChain r3 = com.coinbase.ciphercore.ethereum.EthereumChain.ETHEREUM_MAINNET
            if (r2 != r3) goto L2a
            java.lang.String r2 = "flagEnabled"
            kotlin.jvm.internal.m.f(r1, r2)
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L3d
        L2a:
            com.coinbase.ciphercore.ethereum.EthereumChain r0 = com.coinbase.wallet.ethereum.extensions.Network_EthereumKt.getAsEthereumChain(r0)
            com.coinbase.ciphercore.ethereum.EthereumChain r1 = com.coinbase.ciphercore.ethereum.EthereumChain.POLYGON_MAINNET
            if (r0 != r1) goto L3f
            java.lang.String r0 = "l2FlagEnabled"
            kotlin.jvm.internal.m.f(r4, r0)
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L3f
        L3d:
            r4 = 1
            goto L40
        L3f:
            r4 = 0
        L40:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.n.l2.o(kotlin.t):java.lang.Boolean");
    }

    public static /* synthetic */ Boolean p(List list) {
        return d(list);
    }

    public static /* synthetic */ Boolean q(l2 l2Var, kotlin.o oVar) {
        return A(l2Var, oVar);
    }

    public static /* synthetic */ Boolean r(kotlin.t tVar) {
        return o(tVar);
    }

    public static /* synthetic */ boolean s(l2 l2Var, kotlin.o oVar) {
        return z(l2Var, oVar);
    }

    public static /* synthetic */ List t(List list) {
        return l(list);
    }

    public static /* synthetic */ Boolean u(List list) {
        return y(list);
    }

    public static final Boolean y(List tokens) {
        kotlin.jvm.internal.m.g(tokens, "tokens");
        return Boolean.valueOf(!tokens.isEmpty());
    }

    public static final boolean z(l2 this$0, kotlin.o it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        Object c2 = it.c();
        kotlin.jvm.internal.m.f(c2, "it.first");
        return (((Boolean) c2).booleanValue() || ((Boolean) it.d()).booleanValue()) && !this$0.f13888d.b();
    }

    public final h.c.s<User> e() {
        return this.n;
    }

    public final h.c.s<String> f() {
        return this.r;
    }

    public final h.c.s<Boolean> g() {
        return this.s;
    }

    public final h.c.s<ViewModelNavRoute> getNavigationObservable() {
        return this.m;
    }

    public final h.c.s<List<AnalyticsUserProperty>> h() {
        return this.u;
    }

    public final h.c.s<kotlin.x> i() {
        return this.p;
    }

    public final h.c.s<ViewModelNavRoute> j() {
        return this.o;
    }

    public final h.c.s<Boolean> k() {
        return this.t;
    }

    public final h.c.s<Boolean> m() {
        return this.q;
    }

    public final h.c.s<Boolean> n() {
        return this.v;
    }

    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        this.f13895k.d();
    }

    public final void v() {
        h.c.t0.a.a(h.c.t0.g.i(Observable_CoreKt.takeSingle(this.f13890f.observeWallets(true)), null, new a(), 1, null), this.f13895k);
    }

    public final void w() {
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.getSwapEntryPointHome(AnalyticsEvent.Companion));
        this.f13893i.onNext(new ViewModelNavRoute(R.id.action_walletFragment_to_swapInterstitialFragment, SwapInterstitialFragmentArgs.createArguments$default(SwapInterstitialFragmentArgs.INSTANCE, true, null, null, 6, null), Fragment_CommonKt.getHoldNavOptions(this)));
    }

    public final h.c.b0<kotlin.x> x(boolean z) {
        return this.f13889e.l(z);
    }
}