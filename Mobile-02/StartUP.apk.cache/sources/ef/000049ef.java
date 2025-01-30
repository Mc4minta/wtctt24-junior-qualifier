package e.j.i;

import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.RefreshInterval;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.models.TraceKey;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import com.coinbase.wallet.features.ethereum.apis.CollectiblesApi;
import com.coinbase.wallet.features.ethereum.dtos.GetCollectibleTypesResponseDTO;
import com.coinbase.wallet.features.wallets.extensions.legacy.Network_ApplicationKt;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.toshi.model.local.room.CollectibleType;
import e.j.i.w1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: CollectibleTypesRepository.kt */
@ApplicationScoped
/* loaded from: classes2.dex */
public final class w1 implements e.j.i.i2.b {
    private final CollectiblesApi a;

    /* renamed from: b */
    private final com.toshi.db.h.b f13657b;

    /* renamed from: c */
    private final IWalletRepository f13658c;

    /* renamed from: d */
    private final Tracing f13659d;

    /* renamed from: e */
    private final h.c.a0 f13660e;

    /* renamed from: f */
    private final kotlin.h f13661f;

    /* renamed from: g */
    private final kotlin.h f13662g;

    /* renamed from: h */
    private final h.c.v0.a<List<CollectibleType>> f13663h;

    /* renamed from: i */
    private final h.c.s<List<CollectibleType>> f13664i;

    /* renamed from: j */
    private volatile RefreshInterval f13665j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CollectibleTypesRepository.kt */
    /* loaded from: classes2.dex */
    public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.a<h.c.s<Wallet>> {

        /* compiled from: Observable+Core.kt */
        /* renamed from: e.j.i.w1$a$a */
        /* loaded from: classes2.dex */
        public static final class C0320a<T> implements h.c.m0.p {
            public static final C0320a<T> a = new C0320a<>();

            @Override // h.c.m0.p
            /* renamed from: a */
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }
        }

        /* compiled from: Observable+Core.kt */
        /* loaded from: classes2.dex */
        public static final class b<T, R> implements h.c.m0.n {
            public static final b<T, R> a = new b<>();

            @Override // h.c.m0.n
            /* renamed from: a */
            public final T apply(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a() {
            super(0);
            w1.this = r1;
        }

        public static final h.c.x a(w1 this$0, Network it) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(it, "it");
            h.c.s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(this$0.f13658c, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion).currencyCodeForNetwork(it));
            kotlin.jvm.internal.m.f(observeWallet, "walletRepository\n                    .observeWallet(Blockchain.ETHEREUM, EthereumBasedConfiguration.ETH.currencyCodeForNetwork(it))");
            h.c.x map = observeWallet.filter(C0320a.a).map(b.a);
            kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
            return map;
        }

        public static /* synthetic */ h.c.x b(w1 w1Var, Network network) {
            return a(w1Var, network);
        }

        @Override // kotlin.e0.c.a
        public final h.c.s<Wallet> invoke() {
            h.c.s<Network> observeNetwork = w1.this.f13658c.observeNetwork(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion));
            final w1 w1Var = w1.this;
            return observeNetwork.flatMap(new h.c.m0.n() { // from class: e.j.i.l
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return w1.a.b(w1.this, (Network) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CollectibleTypesRepository.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.a<h.c.k0.a> {
        public static final b a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final h.c.k0.a invoke() {
            return new h.c.k0.a();
        }
    }

    public w1(CollectiblesApi collectiblesApi, com.toshi.db.h.b collectibleTypeDao, IWalletRepository walletRepository, Tracing tracer) {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.jvm.internal.m.g(collectiblesApi, "collectiblesApi");
        kotlin.jvm.internal.m.g(collectibleTypeDao, "collectibleTypeDao");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(tracer, "tracer");
        this.a = collectiblesApi;
        this.f13657b = collectibleTypeDao;
        this.f13658c = walletRepository;
        this.f13659d = tracer;
        h.c.a0 c2 = h.c.u0.a.c();
        kotlin.jvm.internal.m.f(c2, "io()");
        this.f13660e = c2;
        b2 = kotlin.k.b(new a());
        this.f13661f = b2;
        b3 = kotlin.k.b(b.a);
        this.f13662g = b3;
        h.c.v0.a<List<CollectibleType>> d2 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d2, "create()");
        this.f13663h = d2;
        h.c.s<List<CollectibleType>> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "collectibleTypesSubject.hide()");
        this.f13664i = hide;
        this.f13665j = RefreshInterval.HOUR;
    }

    private final h.c.s<Wallet> c() {
        Object value = this.f13661f.getValue();
        kotlin.jvm.internal.m.f(value, "<get-activeWalletObservable>(...)");
        return (h.c.s) value;
    }

    private final h.c.b0<List<CollectibleType>> d(final String str, final int i2) {
        h.c.b0 map = this.a.getCollectibleTypes(str, i2).map(new h.c.m0.n() { // from class: e.j.i.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return w1.n(i2, str, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "collectiblesApi.getCollectibleTypes(address, chainId)\n        .map { items -> items.map { it.asCollectibleTypeModel(chainId, address) } }");
        return map;
    }

    public static final List e(int i2, String address, List items) {
        int r;
        kotlin.jvm.internal.m.g(address, "$address");
        kotlin.jvm.internal.m.g(items, "items");
        r = kotlin.a0.s.r(items, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(((GetCollectibleTypesResponseDTO.CollectibleTypeDetail) it.next()).asCollectibleTypeModel(i2, address));
        }
        return arrayList;
    }

    private final h.c.k0.a f() {
        return (h.c.k0.a) this.f13662g.getValue();
    }

    public static /* synthetic */ boolean g(Wallet wallet, Wallet wallet2) {
        return w(wallet, wallet2);
    }

    public static /* synthetic */ h.c.h0 h(w1 w1Var, List list) {
        return y(w1Var, list);
    }

    public static /* synthetic */ void i(w1 w1Var, List list) {
        v(w1Var, list);
    }

    public static /* synthetic */ h.c.h0 j(w1 w1Var, Wallet wallet) {
        return u(w1Var, wallet);
    }

    public static /* synthetic */ h.c.h0 k(w1 w1Var, Wallet wallet) {
        return q(w1Var, wallet);
    }

    public static /* synthetic */ h.c.h0 l(w1 w1Var, Wallet wallet) {
        return x(w1Var, wallet);
    }

    public static /* synthetic */ h.c.h0 m(w1 w1Var, List list) {
        return r(w1Var, list);
    }

    public static /* synthetic */ List n(int i2, String str, List list) {
        return e(i2, str, list);
    }

    public static /* synthetic */ h.c.h0 o(w1 w1Var, kotlin.x xVar) {
        return s(w1Var, xVar);
    }

    public static final h.c.h0 q(w1 this$0, Wallet it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.d(it.getPrimaryAddress(), Network_ApplicationKt.asChainId(it.getNetwork()));
    }

    public static final h.c.h0 r(w1 this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.f13657b.c();
        return this$0.f13657b.b(it).x(kotlin.x.a);
    }

    public static final h.c.h0 s(w1 this$0, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.t();
    }

    private final h.c.b0<List<CollectibleType>> t() {
        h.c.b0 doOnSuccess = Observable_CoreKt.takeSingle(c()).flatMap(new h.c.m0.n() { // from class: e.j.i.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return w1.j(w1.this, (Wallet) obj);
            }
        }).doOnSuccess(new h.c.m0.f() { // from class: e.j.i.h
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                w1.i(w1.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnSuccess, "activeWalletObservable\n            .takeSingle()\n            .flatMap {\n                collectibleTypeDao.getAll(it.primaryAddress, it.network.asChainId())\n            }.doOnSuccess { collectibleTypesSubject.onNext(it) }");
        return Single_AnalyticsKt.logError$default(doOnSuccess, "Error while reloading collectible types from database", null, 2, null);
    }

    public static final h.c.h0 u(w1 this$0, Wallet it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.f13657b.a(it.getPrimaryAddress(), Network_ApplicationKt.asChainId(it.getNetwork()));
    }

    public static final void v(w1 this$0, List list) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.f13663h.onNext(list);
    }

    public static final boolean w(Wallet lhs, Wallet rhs) {
        kotlin.jvm.internal.m.g(lhs, "lhs");
        kotlin.jvm.internal.m.g(rhs, "rhs");
        return kotlin.jvm.internal.m.c(lhs.getPrimaryAddress(), rhs.getPrimaryAddress()) && kotlin.jvm.internal.m.c(lhs.getNetwork(), rhs.getNetwork());
    }

    public static final h.c.h0 x(w1 this$0, Wallet it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.t();
    }

    public static final h.c.h0 y(w1 this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.p();
    }

    @Override // e.j.i.i2.b
    public h.c.s<List<CollectibleType>> a() {
        return this.f13664i;
    }

    @Override // com.coinbase.wallet.core.interfaces.RefreshIntervalCustomizable
    public RefreshInterval getRefreshInterval() {
        return this.f13665j;
    }

    public h.c.b0<List<CollectibleType>> p() {
        h.c.b0 flatMap = Observable_CoreKt.takeSingle(c()).flatMap(new h.c.m0.n() { // from class: e.j.i.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return w1.k(w1.this, (Wallet) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: e.j.i.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return w1.m(w1.this, (List) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: e.j.i.o
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return w1.o(w1.this, (kotlin.x) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "activeWalletObservable\n            .takeSingle()\n            .flatMap { getCollectibleTypes(it.primaryAddress, it.network.asChainId()) }\n            .flatMap {\n                collectibleTypeDao.deleteAll() // Clear the table before inserting new collectibles\n                collectibleTypeDao.insert(it).toSingleDefault(Unit)\n            }\n            .flatMap { reloadCollectibleTypesFromDatabase() }");
        return Single_AnalyticsKt.logError$default(flatMap, "Error while reloading collectible types", null, 2, null);
    }

    @Override // com.coinbase.wallet.core.interfaces.Refreshable
    public h.c.b0<kotlin.x> refresh(boolean z) {
        h.c.b0<kotlin.x> trace = Single_CoreKt.trace(Single_CoreKt.asUnit(p()), e.j.f.x.a(TraceKey.Companion), this.f13659d);
        kotlin.jvm.internal.m.f(trace, "reloadCollectibleTypes().asUnit()\n        .trace(TraceKey.collectiblesRepositoryRefreshTrace(), tracer)");
        return trace;
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        h.c.s flatMapSingle = h.c.s.merge(c().take(1L), c().skip(1L).throttleWithTimeout(0L, TimeUnit.SECONDS)).observeOn(this.f13660e).distinctUntilChanged(new h.c.m0.d() { // from class: e.j.i.f
            @Override // h.c.m0.d
            public final boolean a(Object obj, Object obj2) {
                return w1.g((Wallet) obj, (Wallet) obj2);
            }
        }).flatMapSingle(new h.c.m0.n() { // from class: e.j.i.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return w1.l(w1.this, (Wallet) obj);
            }
        }).flatMapSingle(new h.c.m0.n() { // from class: e.j.i.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return w1.h(w1.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMapSingle, "merge(firstRunObservable, continuousObservable)\n            .observeOn(ioScheduler)\n            .distinctUntilChanged { lhs, rhs ->\n                lhs.primaryAddress == rhs.primaryAddress && lhs.network == rhs.network\n            }\n            .flatMapSingle { reloadCollectibleTypesFromDatabase() }\n            .flatMapSingle { reloadCollectibleTypes() }");
        h.c.k0.b subscribe = Observable_AnalyticsKt.logError$default(flatMapSingle, "Error while reloading collectible types", null, 2, null).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "merge(firstRunObservable, continuousObservable)\n            .observeOn(ioScheduler)\n            .distinctUntilChanged { lhs, rhs ->\n                lhs.primaryAddress == rhs.primaryAddress && lhs.network == rhs.network\n            }\n            .flatMapSingle { reloadCollectibleTypesFromDatabase() }\n            .flatMapSingle { reloadCollectibleTypes() }\n            .logError(\"Error while reloading collectible types\")\n            .subscribe()");
        h.c.t0.a.a(subscribe, f());
    }

    @Override // com.coinbase.wallet.core.interfaces.RefreshIntervalCustomizable
    public void updateRefreshInterval(RefreshInterval interval) {
        kotlin.jvm.internal.m.g(interval, "interval");
        this.f13665j = interval;
    }
}