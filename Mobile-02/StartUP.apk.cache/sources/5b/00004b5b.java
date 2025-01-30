package e.j.n;

import android.annotation.SuppressLint;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.bitcoin.extensions.CurrencyCode_BitcoinKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.EthereumChain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.wallet.wallets.models.CryptoCurrency;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* compiled from: ReceiveCoinPickerViewModel.kt */
/* loaded from: classes2.dex */
public final class y2 extends androidx.lifecycle.b0 {
    private final IWalletRepository a;

    /* renamed from: b */
    private final h.c.a0 f14002b;

    /* renamed from: c */
    private final h.c.v0.b<List<e.j.m.a.p>> f14003c;

    /* renamed from: d */
    private final Set<CurrencyCode> f14004d;

    /* renamed from: e */
    private final List<e.j.m.a.n> f14005e;

    /* renamed from: f */
    private final h.c.s<List<e.j.m.a.p>> f14006f;

    /* renamed from: g */
    private final h.c.s<Wallet> f14007g;

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

    public y2(IWalletRepository walletRepository) {
        Set<CurrencyCode> e2;
        List<e.j.m.a.n> j2;
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        this.a = walletRepository;
        this.f14002b = h.c.j0.c.a.b();
        h.c.v0.b<List<e.j.m.a.p>> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<List<SectionedListItem>>()");
        this.f14003c = d2;
        CurrencyCode.Companion companion = CurrencyCode.Companion;
        e2 = kotlin.a0.s0.e(CurrencyCode_BitcoinKt.getBTC(companion), CurrencyCode_EthereumKt.getETH(companion), companion.getUSDC());
        this.f14004d = e2;
        j2 = kotlin.a0.r.j(new e.j.m.a.n("Suggested", e.j.m.a.k.SMALL), new e.j.m.a.n("All Coins", e.j.m.a.k.LARGE));
        this.f14005e = j2;
        h.c.s<List<e.j.m.a.p>> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "refreshSubject.hide()");
        this.f14006f = hide;
        this.f14007g = walletRepository.observeNetwork(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)).flatMap(new h.c.m0.n() { // from class: e.j.n.a1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return y2.n(y2.this, (Network) obj);
            }
        });
        x();
    }

    public static final void A(Throwable th) {
        l.a.a.f(th, "Could not build ReceiveCoinPickerViewModel", new Object[0]);
    }

    private final h.c.b0<List<m3>> B() {
        h.c.b0<List<m3>> map = Observable_CoreKt.takeSingle(this.a.observeWallets(false)).map(new h.c.m0.n() { // from class: e.j.n.w0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return y2.j((List) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.n.x0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return y2.k(y2.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletRepository.observeWallets(false)\n                .takeSingle()\n                .map { tokens ->\n                    val crypto = tokens.withIndex().map { (index, token) ->\n                        CryptoCurrency(\n                            token.currencyCode,\n                            token.displayName,\n                            token.imageURL,\n                            token.decimals,\n                            token.blockchain,\n                            index\n                        )\n                    }\n\n                    Pair(crypto, tokens)\n                }.map { (cryptos, tokens) ->\n                    convertCryptoCurrenciesToCoinCompact(cryptos, tokens)\n                }");
        return map;
    }

    public static final kotlin.o C(List tokens) {
        Iterable<kotlin.a0.e0> P0;
        int r;
        kotlin.jvm.internal.m.g(tokens, "tokens");
        P0 = kotlin.a0.z.P0(tokens);
        r = kotlin.a0.s.r(P0, 10);
        ArrayList arrayList = new ArrayList(r);
        for (kotlin.a0.e0 e0Var : P0) {
            int a2 = e0Var.a();
            Wallet wallet = (Wallet) e0Var.b();
            arrayList.add(new CryptoCurrency(wallet.getCurrencyCode(), wallet.getDisplayName(), wallet.getImageURL(), wallet.getDecimals(), wallet.getBlockchain(), a2));
        }
        return new kotlin.o(arrayList, tokens);
    }

    public static final List D(y2 this$0, kotlin.o dstr$cryptos$tokens) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$cryptos$tokens, "$dstr$cryptos$tokens");
        List<Wallet> tokens = (List) dstr$cryptos$tokens.b();
        kotlin.jvm.internal.m.f(tokens, "tokens");
        return this$0.e((List) dstr$cryptos$tokens.a(), tokens);
    }

    public static final h.c.x a(y2 this$0, Network network) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(network, "network");
        h.c.s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(this$0.a, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion).currencyCodeForNetwork(network));
        kotlin.jvm.internal.m.f(observeWallet, "walletRepository\n                .observeWallet(Blockchain.ETHEREUM, EthereumBasedConfiguration.ETH.currencyCodeForNetwork(network))");
        h.c.x map = observeWallet.filter(a.a).map(b.a);
        kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        return map;
    }

    private final void b(List<m3> list) {
        List P;
        List<e.j.m.a.p> P2;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.f14004d.iterator();
        while (true) {
            Object obj = null;
            if (!it.hasNext()) {
                break;
            }
            CurrencyCode currencyCode = (CurrencyCode) it.next();
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (kotlin.jvm.internal.m.c(((m3) next).b().getCode(), currencyCode)) {
                    obj = next;
                    break;
                }
            }
            m3 m3Var = (m3) obj;
            if (m3Var != null) {
                arrayList.add(m3Var);
            }
        }
        arrayList.addAll(list);
        e.j.m.a.n nVar = this.f14005e.get(0);
        e.j.m.a.n nVar2 = this.f14005e.get(1);
        P = kotlin.a0.z.P(arrayList);
        if (P.size() <= 3) {
            arrayList.add(0, e.j.m.a.n.b(nVar2, null, e.j.m.a.k.SMALL, 1, null));
        } else {
            arrayList.add(0, nVar);
            arrayList.add(4, nVar2);
        }
        h.c.v0.b<List<e.j.m.a.p>> bVar = this.f14003c;
        P2 = kotlin.a0.z.P(arrayList);
        bVar.onNext(P2);
    }

    private final h.c.b0<List<m3>> c() {
        h.c.s<Wallet> activeWalletObservable = this.f14007g;
        kotlin.jvm.internal.m.f(activeWalletObservable, "activeWalletObservable");
        h.c.b0<List<m3>> flatMap = Observable_CoreKt.takeSingle(activeWalletObservable).flatMap(new h.c.m0.n() { // from class: e.j.n.z0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return y2.m(y2.this, (Wallet) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "activeWalletObservable\n            .takeSingle()\n            .flatMap { wallet ->\n                if (wallet.network == EthereumChain.ETHEREUM_MAINNET.asNetwork) {\n                    mainnetCryptoCurrencies()\n                } else {\n                    testnetCryptoCurrencies()\n                }\n            }");
        return flatMap;
    }

    public static final h.c.h0 d(y2 this$0, Wallet wallet) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallet, "wallet");
        if (kotlin.jvm.internal.m.c(wallet.getNetwork(), EthereumChain_EthereumKt.getAsNetwork(EthereumChain.ETHEREUM_MAINNET))) {
            return this$0.s();
        }
        return this$0.B();
    }

    private final List<m3> e(List<CryptoCurrency> list, List<Wallet> list2) {
        int r;
        int d2;
        int b2;
        int r2;
        int d3;
        int b3;
        boolean z;
        List I0;
        r = kotlin.a0.s.r(list2, 10);
        d2 = kotlin.a0.l0.d(r);
        b2 = kotlin.i0.f.b(d2, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
        for (Wallet wallet : list2) {
            String rawValue = wallet.getBlockchain().getRawValue();
            I0 = kotlin.a0.z.I0(wallet.getAddresses());
            kotlin.o a2 = kotlin.u.a(rawValue, I0);
            linkedHashMap.put(a2.c(), a2.d());
        }
        r2 = kotlin.a0.s.r(list, 10);
        d3 = kotlin.a0.l0.d(r2);
        b3 = kotlin.i0.f.b(d3, 16);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(b3);
        Iterator<T> it = list.iterator();
        while (true) {
            Object obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            CryptoCurrency cryptoCurrency = (CryptoCurrency) next;
            Iterator<T> it2 = list2.iterator();
            while (true) {
                if (it2.hasNext()) {
                    Object next2 = it2.next();
                    Wallet wallet2 = (Wallet) next2;
                    if (kotlin.jvm.internal.m.c(wallet2.getBlockchain(), cryptoCurrency.getBlockchain()) && kotlin.jvm.internal.m.c(wallet2.getCurrencyCode(), cryptoCurrency.getCode())) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        obj = next2;
                        break;
                    }
                }
            }
            linkedHashMap2.put(next, (Wallet) obj);
        }
        ArrayList arrayList = new ArrayList();
        for (CryptoCurrency cryptoCurrency2 : list) {
            List list3 = (List) linkedHashMap.get(cryptoCurrency2.getBlockchain().getRawValue());
            List b4 = list3 == null ? null : kotlin.a0.q.b(new m3(cryptoCurrency2, list3, (Wallet) linkedHashMap2.get(cryptoCurrency2)));
            if (b4 == null) {
                b4 = kotlin.a0.r.g();
            }
            kotlin.a0.w.y(arrayList, b4);
        }
        return arrayList;
    }

    public static /* synthetic */ h.c.h0 i(y2 y2Var, Throwable th) {
        return t(y2Var, th);
    }

    public static /* synthetic */ kotlin.o j(List list) {
        return C(list);
    }

    public static /* synthetic */ List k(y2 y2Var, kotlin.o oVar) {
        return D(y2Var, oVar);
    }

    public static /* synthetic */ List l(List list) {
        return u(list);
    }

    public static /* synthetic */ h.c.h0 m(y2 y2Var, Wallet wallet) {
        return d(y2Var, wallet);
    }

    public static /* synthetic */ h.c.x n(y2 y2Var, Network network) {
        return a(y2Var, network);
    }

    public static /* synthetic */ void o(Throwable th) {
        A(th);
    }

    public static /* synthetic */ List p(y2 y2Var, kotlin.o oVar) {
        return v(y2Var, oVar);
    }

    public static /* synthetic */ void q(kotlin.x xVar) {
        z(xVar);
    }

    public static /* synthetic */ kotlin.x r(y2 y2Var, List list) {
        return y(y2Var, list);
    }

    private final h.c.b0<List<m3>> s() {
        h.c.b0 takeSingle = Observable_CoreKt.takeSingle(this.a.observeWallets(false));
        h.c.b0 onErrorResumeNext = IWalletRepository.DefaultImpls.getCryptoCurrencies$default(this.a, null, 1, null).onErrorResumeNext(new h.c.m0.n() { // from class: e.j.n.v0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return y2.i(y2.this, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorResumeNext, "walletRepository.getCryptoCurrencies()\n                .onErrorResumeNext {\n                    walletRepository.observeWallets(false).takeSingle()\n                            .map { tokens ->\n                                tokens.enumerated().map { (index, token) ->\n                                    CryptoCurrency(\n                                        token.currencyCode,\n                                        token.displayName,\n                                        token.imageURL,\n                                        token.decimals,\n                                        token.blockchain,\n                                        index\n                                    )\n                                }\n                            }\n                }");
        h.c.b0<List<m3>> map = h.c.t0.f.a(onErrorResumeNext, takeSingle).map(new h.c.m0.n() { // from class: e.j.n.c1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return y2.p(y2.this, (kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "getCryptoSingles\n                .zipWith(tokensSingle)\n                .map { (cryptoCurrencies, tokens) ->\n                    convertCryptoCurrenciesToCoinCompact(cryptoCurrencies, tokens)\n                }");
        return map;
    }

    public static final h.c.h0 t(y2 this$0, Throwable it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return Observable_CoreKt.takeSingle(this$0.a.observeWallets(false)).map(new h.c.m0.n() { // from class: e.j.n.y0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return y2.l((List) obj);
            }
        });
    }

    public static final List u(List tokens) {
        int r;
        kotlin.jvm.internal.m.g(tokens, "tokens");
        Iterable<kotlin.a0.e0> a2 = e.j.f.g.a(tokens);
        r = kotlin.a0.s.r(a2, 10);
        ArrayList arrayList = new ArrayList(r);
        for (kotlin.a0.e0 e0Var : a2) {
            int a3 = e0Var.a();
            Wallet wallet = (Wallet) e0Var.b();
            arrayList.add(new CryptoCurrency(wallet.getCurrencyCode(), wallet.getDisplayName(), wallet.getImageURL(), wallet.getDecimals(), wallet.getBlockchain(), a3));
        }
        return arrayList;
    }

    public static final List v(y2 this$0, kotlin.o dstr$cryptoCurrencies$tokens) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$cryptoCurrencies$tokens, "$dstr$cryptoCurrencies$tokens");
        List<CryptoCurrency> cryptoCurrencies = (List) dstr$cryptoCurrencies$tokens.a();
        List<Wallet> tokens = (List) dstr$cryptoCurrencies$tokens.b();
        kotlin.jvm.internal.m.f(cryptoCurrencies, "cryptoCurrencies");
        kotlin.jvm.internal.m.f(tokens, "tokens");
        return this$0.e(cryptoCurrencies, tokens);
    }

    @SuppressLint({"CheckResult"})
    private final void x() {
        c().subscribeOn(this.f14002b).map(new h.c.m0.n() { // from class: e.j.n.e1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return y2.r(y2.this, (List) obj);
            }
        }).subscribe(new h.c.m0.f() { // from class: e.j.n.d1
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                y2.q((kotlin.x) obj);
            }
        }, new h.c.m0.f() { // from class: e.j.n.b1
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                y2.o((Throwable) obj);
            }
        });
    }

    public static final kotlin.x y(y2 this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.b(it);
        return kotlin.x.a;
    }

    public static final void z(kotlin.x xVar) {
    }

    public final m3 f(Wallet wallet) {
        List I0;
        if (wallet == null) {
            return null;
        }
        CryptoCurrency cryptoCurrency = new CryptoCurrency(wallet.getCurrencyCode(), wallet.getDisplayName(), wallet.getImageURL(), wallet.getDecimals(), wallet.getBlockchain(), 1);
        I0 = kotlin.a0.z.I0(wallet.getAddresses());
        return new m3(cryptoCurrency, I0, wallet);
    }

    public final h.c.s<Wallet> g() {
        return this.f14007g;
    }

    public final h.c.s<List<e.j.m.a.p>> h() {
        return this.f14006f;
    }

    public final void w() {
        x();
    }
}