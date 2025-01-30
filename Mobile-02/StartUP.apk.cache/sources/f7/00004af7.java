package e.j.n;

import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt;
import com.coinbase.wallet.ethereum.interfaces.IETHWalletRepository;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: WalletPickerViewModel.kt */
/* loaded from: classes2.dex */
public final class n3 extends androidx.lifecycle.b0 {
    private final IETHWalletRepository a;

    /* renamed from: b */
    private final IWalletRepository f13913b;

    /* compiled from: Observable+Core.kt */
    /* loaded from: classes2.dex */
    public static final class a<T> implements h.c.m0.p {
        public static final a<T> a = new a<>();

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

    /* compiled from: Comparisons.kt */
    /* loaded from: classes2.dex */
    public static final class e<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int c2;
            c2 = kotlin.b0.b.c(Integer.valueOf(((Address) t).getIndex()), Integer.valueOf(((Address) t2).getIndex()));
            return c2;
        }
    }

    public n3(IETHWalletRepository ethWalletRepository, IWalletRepository walletRepository) {
        kotlin.jvm.internal.m.g(ethWalletRepository, "ethWalletRepository");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        this.a = ethWalletRepository;
        this.f13913b = walletRepository;
    }

    public static final Optional b(List wallets) {
        Object obj;
        boolean z;
        kotlin.jvm.internal.m.g(wallets, "wallets");
        Iterator it = wallets.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Wallet wallet = (Wallet) obj;
            if (kotlin.jvm.internal.m.c(wallet.getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)) && kotlin.jvm.internal.m.c(wallet.getCurrencyCode(), WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion).currencyCodeForNetwork(wallet.getNetwork()))) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        return OptionalKt.toOptional(obj);
    }

    public static final h.c.x c(n3 this$0, Wallet wallet) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallet, "wallet");
        h.c.s getAddresses = this$0.a.getAddresses(wallet.getNetwork()).map(new h.c.m0.n() { // from class: e.j.n.s1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return n3.h((List) obj);
            }
        }).toObservable();
        h.c.t0.c cVar = h.c.t0.c.a;
        h.c.s just = h.c.s.just(wallet);
        kotlin.jvm.internal.m.f(just, "just(wallet)");
        kotlin.jvm.internal.m.f(getAddresses, "getAddresses");
        return cVar.c(just, getAddresses);
    }

    public static final List d(List addresses) {
        List B0;
        kotlin.jvm.internal.m.g(addresses, "addresses");
        B0 = kotlin.a0.z.B0(addresses, new e());
        return B0;
    }

    public static final Optional e(kotlin.o dstr$wallet$addresses) {
        Object obj;
        kotlin.jvm.internal.m.g(dstr$wallet$addresses, "$dstr$wallet$addresses");
        Wallet wallet = (Wallet) dstr$wallet$addresses.a();
        List addresses = (List) dstr$wallet$addresses.b();
        kotlin.jvm.internal.m.f(addresses, "addresses");
        Iterator it = addresses.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (kotlin.jvm.internal.m.c(wallet.getPrimaryAddress(), ((Address) obj).getAddress())) {
                break;
            }
        }
        Address address = (Address) obj;
        if (address != null) {
            return OptionalKt.toOptional(new kotlin.o(addresses, address));
        }
        return OptionalKt.toOptional(null);
    }

    public static /* synthetic */ Optional f(kotlin.o oVar) {
        return e(oVar);
    }

    public static /* synthetic */ Optional g(List list) {
        return b(list);
    }

    public static /* synthetic */ List h(List list) {
        return d(list);
    }

    public static /* synthetic */ h.c.x i(n3 n3Var, Wallet wallet) {
        return c(n3Var, wallet);
    }

    public final h.c.b0<kotlin.o<List<Address>, Address>> a() {
        h.c.s<R> map = this.f13913b.observeWallets(false).map(new h.c.m0.n() { // from class: e.j.n.r1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return n3.g((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletRepository\n        .observeWallets(false)\n        .map { wallets ->\n            wallets\n                .firstOrNull {\n                    it.blockchain == Blockchain.ETHEREUM &&\n                        it.currencyCode == EthereumBasedConfiguration.ETH.currencyCodeForNetwork(it.network)\n                }\n                .toOptional()\n        }");
        h.c.s map2 = map.filter(a.a).map(b.a);
        kotlin.jvm.internal.m.f(map2, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        h.c.s map3 = map2.flatMap(new h.c.m0.n() { // from class: e.j.n.t1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return n3.i(n3.this, (Wallet) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.n.q1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return n3.f((kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map3, "walletRepository\n        .observeWallets(false)\n        .map { wallets ->\n            wallets\n                .firstOrNull {\n                    it.blockchain == Blockchain.ETHEREUM &&\n                        it.currencyCode == EthereumBasedConfiguration.ETH.currencyCodeForNetwork(it.network)\n                }\n                .toOptional()\n        }\n        .unwrap()\n        .flatMap { wallet ->\n            val getAddresses = ethWalletRepository.getAddresses(wallet.network)\n                .map { addresses -> addresses.sortedBy { it.index } }\n                .toObservable()\n\n            Observables.zip(Observable.just(wallet), getAddresses)\n        }\n        .map { (wallet, addresses) ->\n            val activeAddress = addresses.firstOrNull { wallet.primaryAddress == it.address }\n\n            if (activeAddress != null) {\n                Pair(addresses, activeAddress).toOptional()\n            } else {\n                null.toOptional()\n            }\n        }");
        h.c.s map4 = map3.filter(c.a).map(d.a);
        kotlin.jvm.internal.m.f(map4, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        return Observable_CoreKt.takeSingle(map4);
    }

    public final void j(Address newAddress) {
        kotlin.jvm.internal.m.g(newAddress, "newAddress");
        IWalletRepository iWalletRepository = this.f13913b;
        Blockchain.Companion companion = Blockchain.Companion;
        iWalletRepository.switchIndex(Blockchain_EthereumKt.getETHEREUM(companion), newAddress.getIndex());
        this.f13913b.switchIndex(Blockchain_EthereumKt.getETHEREUM_CLASSIC(companion), newAddress.getIndex());
    }
}