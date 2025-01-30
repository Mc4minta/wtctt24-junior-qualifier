package e.j.i;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import com.coinbase.wallet.features.ethereum.apis.CollectiblesApi;
import com.coinbase.wallet.features.ethereum.dtos.GetCollectibleItemResponseDTO;
import com.coinbase.wallet.features.ethereum.exceptions.CollectiblesException;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.toshi.model.local.room.CollectibleType;
import com.toshi.model.local.room.Erc721Token;
import e.j.i.y1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: Erc721Repository.kt */
@ApplicationScoped
/* loaded from: classes2.dex */
public final class y1 implements e.j.i.i2.c {
    private final w1 a;

    /* renamed from: b */
    private final CollectiblesApi f13669b;

    /* renamed from: c */
    private final com.toshi.db.i.b f13670c;

    /* renamed from: d */
    private final IWalletRepository f13671d;

    /* renamed from: e */
    private final kotlin.h f13672e;

    /* renamed from: f */
    private final h.c.a0 f13673f;

    /* renamed from: g */
    private final kotlin.h f13674g;

    /* renamed from: h */
    private final h.c.v0.a<List<Erc721Token>> f13675h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Erc721Repository.kt */
    /* loaded from: classes2.dex */
    public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.a<h.c.s<Wallet>> {

        /* compiled from: Observable+Core.kt */
        /* renamed from: e.j.i.y1$a$a */
        /* loaded from: classes2.dex */
        public static final class C0321a<T> implements h.c.m0.p {
            public static final C0321a<T> a = new C0321a<>();

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
            y1.this = r1;
        }

        public static final h.c.x a(y1 this$0, Network it) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(it, "it");
            h.c.s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(this$0.f13671d, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion).currencyCodeForNetwork(it));
            kotlin.jvm.internal.m.f(observeWallet, "walletRepository\n                    .observeWallet(Blockchain.ETHEREUM, EthereumBasedConfiguration.ETH.currencyCodeForNetwork(it))");
            h.c.x map = observeWallet.filter(C0321a.a).map(b.a);
            kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
            return map;
        }

        public static /* synthetic */ h.c.x b(y1 y1Var, Network network) {
            return a(y1Var, network);
        }

        @Override // kotlin.e0.c.a
        public final h.c.s<Wallet> invoke() {
            h.c.s<Network> observeNetwork = y1.this.f13671d.observeNetwork(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion));
            final y1 y1Var = y1.this;
            return observeNetwork.flatMap(new h.c.m0.n() { // from class: e.j.i.z
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return y1.a.b(y1.this, (Network) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Erc721Repository.kt */
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

    /* compiled from: Singles+Core.kt */
    /* loaded from: classes2.dex */
    public static final class c<T, R> implements h.c.m0.n {
        @Override // h.c.m0.n
        /* renamed from: a */
        public final List<T> apply(Object[] it) {
            List<T> g2;
            kotlin.jvm.internal.m.g(it, "it");
            if (it.length == 0) {
                g2 = kotlin.a0.r.g();
                return g2;
            }
            ArrayList arrayList = new ArrayList();
            int length = it.length;
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = it[i2];
                if (obj != null ? obj instanceof List : true) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
    }

    public y1(w1 collectibleTypesRepository, CollectiblesApi collectiblesApi, com.toshi.db.i.b erc721TokenDao, IWalletRepository walletRepository) {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.jvm.internal.m.g(collectibleTypesRepository, "collectibleTypesRepository");
        kotlin.jvm.internal.m.g(collectiblesApi, "collectiblesApi");
        kotlin.jvm.internal.m.g(erc721TokenDao, "erc721TokenDao");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        this.a = collectibleTypesRepository;
        this.f13669b = collectiblesApi;
        this.f13670c = erc721TokenDao;
        this.f13671d = walletRepository;
        b2 = kotlin.k.b(b.a);
        this.f13672e = b2;
        h.c.a0 c2 = h.c.u0.a.c();
        kotlin.jvm.internal.m.f(c2, "io()");
        this.f13673f = c2;
        b3 = kotlin.k.b(new a());
        this.f13674g = b3;
        h.c.v0.a<List<Erc721Token>> d2 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d2, "create<List<Erc721Token>>()");
        this.f13675h = d2;
    }

    public static final h.c.h0 A(y1 this$0, Wallet wallet) {
        h.c.b0<List<Erc721Token>> a2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallet, "wallet");
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(wallet.getNetwork());
        if (asEthereumChain == null) {
            a2 = null;
        } else {
            a2 = this$0.f13670c.a(wallet.getPrimaryAddress(), asEthereumChain.getChainId());
        }
        if (a2 != null) {
            return a2;
        }
        throw CollectiblesException.UnableToGetErc721Tokens.INSTANCE;
    }

    public static final void B(y1 this$0, List list) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.f13675h.onNext(list);
    }

    public static final boolean C(List it) {
        kotlin.jvm.internal.m.g(it, "it");
        return !it.isEmpty();
    }

    public static final boolean D(List it) {
        kotlin.jvm.internal.m.g(it, "it");
        return !it.isEmpty();
    }

    public static final boolean E(List lhs, List rhs) {
        Set N0;
        kotlin.jvm.internal.m.g(lhs, "lhs");
        kotlin.jvm.internal.m.g(rhs, "rhs");
        if (lhs.size() == rhs.size()) {
            N0 = kotlin.a0.z.N0(lhs, rhs);
            if (N0.size() == lhs.size()) {
                return true;
            }
        }
        return false;
    }

    public static final h.c.h0 F(y1 this$0, final List collectibleTypes) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(collectibleTypes, "collectibleTypes");
        return this$0.z().map(new h.c.m0.n() { // from class: e.j.i.c0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return y1.u(collectibleTypes, (List) obj);
            }
        });
    }

    public static final List G(List collectibleTypes, List it) {
        kotlin.jvm.internal.m.g(collectibleTypes, "$collectibleTypes");
        kotlin.jvm.internal.m.g(it, "it");
        return collectibleTypes;
    }

    public static final h.c.h0 H(y1 this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.v(it);
    }

    private final h.c.s<Wallet> c() {
        Object value = this.f13674g.getValue();
        kotlin.jvm.internal.m.f(value, "<get-activeWalletObservable>(...)");
        return (h.c.s) value;
    }

    private final h.c.b0<List<Erc721Token>> d(List<CollectibleType> list, Wallet wallet) {
        int r;
        h.c.b0 zip;
        List g2;
        r = kotlin.a0.s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (CollectibleType collectibleType : list) {
            final String contractAddress = collectibleType.getContractAddress();
            final String primaryAddress = wallet.getPrimaryAddress();
            EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(wallet.getNetwork());
            Integer valueOf = asEthereumChain == null ? null : Integer.valueOf(asEthereumChain.getChainId());
            if (valueOf == null) {
                h.c.b0<List<Erc721Token>> error = h.c.b0.error(CollectiblesException.UnableToGetErc721Tokens.INSTANCE);
                kotlin.jvm.internal.m.f(error, "error(CollectiblesException.UnableToGetErc721Tokens)");
                return error;
            }
            final int intValue = valueOf.intValue();
            arrayList.add(CollectiblesApi.getERC721Tokens$default(this.f13669b, primaryAddress, intValue, contractAddress, 0, 0, 24, null).map(new h.c.m0.n() { // from class: e.j.i.q
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return y1.j(contractAddress, primaryAddress, intValue, (List) obj);
                }
            }));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList, new c());
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        h.c.b0<List<Erc721Token>> map = zip.map(new h.c.m0.n() { // from class: e.j.i.x
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return y1.q((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Singles.zipOrEmpty(singles).map { it.flatten() }");
        return map;
    }

    public static final List e(String contractAddress, String address, int i2, List items) {
        int r;
        kotlin.jvm.internal.m.g(contractAddress, "$contractAddress");
        kotlin.jvm.internal.m.g(address, "$address");
        kotlin.jvm.internal.m.g(items, "items");
        r = kotlin.a0.s.r(items, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(((GetCollectibleItemResponseDTO.CollectibleItemDetail) it.next()).asErc721Token(contractAddress, address, i2));
        }
        return arrayList;
    }

    public static final List f(List it) {
        List u;
        kotlin.jvm.internal.m.g(it, "it");
        u = kotlin.a0.s.u(it);
        return u;
    }

    private final h.c.k0.a h() {
        return (h.c.k0.a) this.f13672e.getValue();
    }

    public static /* synthetic */ boolean i(List list, List list2) {
        return E(list, list2);
    }

    public static /* synthetic */ List j(String str, String str2, int i2, List list) {
        return e(str, str2, i2, list);
    }

    public static /* synthetic */ boolean k(List list) {
        return D(list);
    }

    public static /* synthetic */ h.c.h0 l(y1 y1Var, List list, Wallet wallet) {
        return w(y1Var, list, wallet);
    }

    public static /* synthetic */ h.c.h0 m(y1 y1Var, List list) {
        return F(y1Var, list);
    }

    public static /* synthetic */ h.c.h0 n(y1 y1Var, List list) {
        return x(y1Var, list);
    }

    public static /* synthetic */ h.c.h0 o(y1 y1Var, List list) {
        return H(y1Var, list);
    }

    public static /* synthetic */ h.c.h0 p(y1 y1Var, Wallet wallet) {
        return A(y1Var, wallet);
    }

    public static /* synthetic */ List q(List list) {
        return f(list);
    }

    public static /* synthetic */ h.c.h0 r(y1 y1Var, List list) {
        return y(y1Var, list);
    }

    public static /* synthetic */ boolean s(List list) {
        return C(list);
    }

    public static /* synthetic */ void t(y1 y1Var, List list) {
        B(y1Var, list);
    }

    public static /* synthetic */ List u(List list, List list2) {
        return G(list, list2);
    }

    public static final h.c.h0 w(y1 this$0, List collectibleTypes, Wallet wallet) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(collectibleTypes, "$collectibleTypes");
        kotlin.jvm.internal.m.g(wallet, "wallet");
        return this$0.d(collectibleTypes, wallet);
    }

    public static final h.c.h0 x(y1 this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.f13670c.c();
        return this$0.f13670c.b(it).x(it);
    }

    public static final h.c.h0 y(y1 this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.z();
    }

    private final h.c.b0<List<Erc721Token>> z() {
        h.c.b0 doOnSuccess = Observable_CoreKt.takeSingle(c()).flatMap(new h.c.m0.n() { // from class: e.j.i.w
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return y1.p(y1.this, (Wallet) obj);
            }
        }).doOnSuccess(new h.c.m0.f() { // from class: e.j.i.b0
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                y1.t(y1.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnSuccess, "activeWalletObservable\n            .takeSingle()\n            .flatMap { wallet ->\n                wallet.network.asEthereumChain?.chainId?.let {\n                    erc721TokenDao.getAll(wallet.primaryAddress, it)\n                } ?: throw CollectiblesException.UnableToGetErc721Tokens\n            }\n            .doOnSuccess { collectiblesSubject.onNext(it) }");
        return Single_AnalyticsKt.logError$default(doOnSuccess, "Error while reloading collectible items from database", null, 2, null);
    }

    public h.c.s<List<Erc721Token>> g() {
        h.c.s<List<Erc721Token>> hide = this.f13675h.hide();
        kotlin.jvm.internal.m.f(hide, "collectiblesSubject.hide()");
        return hide;
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        h.c.s flatMapSingle = h.c.s.merge(this.a.a().filter(new h.c.m0.p() { // from class: e.j.i.a0
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return y1.s((List) obj);
            }
        }).take(1L), this.a.a().filter(new h.c.m0.p() { // from class: e.j.i.r
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return y1.k((List) obj);
            }
        }).skip(1L).throttleWithTimeout(0L, TimeUnit.SECONDS)).observeOn(this.f13673f).distinctUntilChanged(new h.c.m0.d() { // from class: e.j.i.p
            @Override // h.c.m0.d
            public final boolean a(Object obj, Object obj2) {
                return y1.i((List) obj, (List) obj2);
            }
        }).flatMapSingle(new h.c.m0.n() { // from class: e.j.i.t
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return y1.m(y1.this, (List) obj);
            }
        }).flatMapSingle(new h.c.m0.n() { // from class: e.j.i.v
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return y1.o(y1.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMapSingle, "merge(firstRunObservable, continuousObservable)\n            .observeOn(ioScheduler)\n            .distinctUntilChanged { lhs, rhs ->\n                lhs.size == rhs.size && lhs.union(rhs).size == lhs.size\n            }\n            .flatMapSingle { collectibleTypes ->\n                reloadCollectiblesFromDatabase().map { collectibleTypes }\n            }\n            .flatMapSingle { reloadCollectibles(it) }");
        h.c.k0.b subscribe = Observable_AnalyticsKt.logError$default(flatMapSingle, "Error while fetching collectibleTypes", null, 2, null).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "merge(firstRunObservable, continuousObservable)\n            .observeOn(ioScheduler)\n            .distinctUntilChanged { lhs, rhs ->\n                lhs.size == rhs.size && lhs.union(rhs).size == lhs.size\n            }\n            .flatMapSingle { collectibleTypes ->\n                reloadCollectiblesFromDatabase().map { collectibleTypes }\n            }\n            .flatMapSingle { reloadCollectibles(it) }\n            .logError(\"Error while fetching collectibleTypes\")\n            .subscribe()");
        h.c.t0.a.a(subscribe, h());
    }

    public h.c.b0<List<Erc721Token>> v(final List<CollectibleType> collectibleTypes) {
        kotlin.jvm.internal.m.g(collectibleTypes, "collectibleTypes");
        h.c.b0 flatMap = Observable_CoreKt.takeSingle(c()).flatMap(new h.c.m0.n() { // from class: e.j.i.s
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return y1.l(y1.this, collectibleTypes, (Wallet) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: e.j.i.u
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return y1.n(y1.this, (List) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: e.j.i.y
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return y1.r(y1.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "activeWalletObservable\n            .takeSingle()\n            .flatMap { wallet -> getCollectibles(collectibleTypes, wallet) }\n            .flatMap {\n                erc721TokenDao.deleteAll() // Clear the table before inserting new collectibles\n                erc721TokenDao.insert(it).toSingleDefault(it)\n            }\n            .flatMap { reloadCollectiblesFromDatabase() }");
        return Single_AnalyticsKt.logError$default(flatMap, "Unable to reload collectibles", null, 2, null);
    }
}