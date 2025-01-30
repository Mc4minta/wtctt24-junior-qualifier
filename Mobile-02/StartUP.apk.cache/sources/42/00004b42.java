package e.j.n;

import android.webkit.WebView;
import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.ethereum.interfaces.IETHWalletRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import java.util.Iterator;
import java.util.List;
import org.toshi.R;

/* compiled from: AdvancedSettingsViewModel.kt */
/* loaded from: classes2.dex */
public final class u1 extends androidx.lifecycle.b0 {
    private final e.j.j.b a;

    /* renamed from: b */
    private final h.c.v0.a<Boolean> f13970b;

    /* renamed from: c */
    private final h.c.s<String> f13971c;

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

    public u1(e.j.j.b appPrefs, IWalletRepository walletRepository, final IETHWalletRepository ethWalletRepository) {
        kotlin.jvm.internal.m.g(appPrefs, "appPrefs");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(ethWalletRepository, "ethWalletRepository");
        this.a = appPrefs;
        h.c.v0.a<Boolean> d2 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d2, "create()");
        this.f13970b = d2;
        h.c.s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(walletRepository, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion));
        kotlin.jvm.internal.m.f(observeWallet, "walletRepository\n        .observeWallet(Blockchain.ETHEREUM, CurrencyCode.ETH)");
        h.c.s<R> map = observeWallet.filter(a.a).map(b.a);
        kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        h.c.s map2 = map.flatMap(new h.c.m0.n() { // from class: e.j.n.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return u1.c(IETHWalletRepository.this, (Wallet) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.n.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return u1.d((kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map2, "walletRepository\n        .observeWallet(Blockchain.ETHEREUM, CurrencyCode.ETH)\n        .unwrap()\n        .flatMap { wallet ->\n            val getAddresses = ethWalletRepository.getAddresses(wallet.network).toObservable()\n            Observables.zip(Observable.just(wallet.primaryAddress), getAddresses)\n        }\n        .map { (primaryAddress, addresses) ->\n            addresses.firstOrNull { it.address == primaryAddress }?.index.toOptional()\n        }");
        h.c.s map3 = map2.filter(c.a).map(d.a);
        kotlin.jvm.internal.m.f(map3, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        h.c.s<String> map4 = map3.map(new h.c.m0.n() { // from class: e.j.n.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return u1.e((Integer) obj);
            }
        });
        kotlin.jvm.internal.m.f(map4, "walletRepository\n        .observeWallet(Blockchain.ETHEREUM, CurrencyCode.ETH)\n        .unwrap()\n        .flatMap { wallet ->\n            val getAddresses = ethWalletRepository.getAddresses(wallet.network).toObservable()\n            Observables.zip(Observable.just(wallet.primaryAddress), getAddresses)\n        }\n        .map { (primaryAddress, addresses) ->\n            addresses.firstOrNull { it.address == primaryAddress }?.index.toOptional()\n        }\n        .unwrap()\n        .map { LocalizedStrings[R.string.active_wallet_name, it + 1] }");
        this.f13971c = map4;
    }

    public static /* synthetic */ h.c.x c(IETHWalletRepository iETHWalletRepository, Wallet wallet) {
        return g(iETHWalletRepository, wallet);
    }

    public static /* synthetic */ Optional d(kotlin.o oVar) {
        return h(oVar);
    }

    public static /* synthetic */ String e(Integer num) {
        return i(num);
    }

    public static final h.c.x g(IETHWalletRepository ethWalletRepository, Wallet wallet) {
        kotlin.jvm.internal.m.g(ethWalletRepository, "$ethWalletRepository");
        kotlin.jvm.internal.m.g(wallet, "wallet");
        h.c.s<List<Address>> getAddresses = ethWalletRepository.getAddresses(wallet.getNetwork()).toObservable();
        h.c.t0.c cVar = h.c.t0.c.a;
        h.c.s just = h.c.s.just(wallet.getPrimaryAddress());
        kotlin.jvm.internal.m.f(just, "just(wallet.primaryAddress)");
        kotlin.jvm.internal.m.f(getAddresses, "getAddresses");
        return cVar.c(just, getAddresses);
    }

    public static final Optional h(kotlin.o dstr$primaryAddress$addresses) {
        Object obj;
        kotlin.jvm.internal.m.g(dstr$primaryAddress$addresses, "$dstr$primaryAddress$addresses");
        String str = (String) dstr$primaryAddress$addresses.a();
        List addresses = (List) dstr$primaryAddress$addresses.b();
        kotlin.jvm.internal.m.f(addresses, "addresses");
        Iterator it = addresses.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (kotlin.jvm.internal.m.c(((Address) obj).getAddress(), str)) {
                break;
            }
        }
        Address address = (Address) obj;
        return OptionalKt.toOptional(address != null ? Integer.valueOf(address.getIndex()) : null);
    }

    public static final String i(Integer it) {
        kotlin.jvm.internal.m.g(it, "it");
        return LocalizedStrings.INSTANCE.get(R.string.active_wallet_name, Integer.valueOf(it.intValue() + 1));
    }

    public final h.c.s<String> a() {
        return this.f13971c;
    }

    public final h.c.s<Boolean> b() {
        h.c.s<Boolean> hide = this.f13970b.hide();
        kotlin.jvm.internal.m.f(hide, "isWebViewDebuggableSubject.hide()");
        return hide;
    }

    public final void f() {
        boolean z = !this.a.f();
        this.a.g(z);
        WebView.setWebContentsDebuggingEnabled(z);
        this.f13970b.onNext(Boolean.valueOf(z));
    }
}