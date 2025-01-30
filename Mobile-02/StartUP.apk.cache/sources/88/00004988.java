package e.j.h.a;

import androidx.lifecycle.b0;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.wallets.extensions.legacy.Wallet_Erc20Kt;
import com.coinbase.wallet.qr.models.QRCodeScanResult;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import e.j.f.p;
import h.c.m0.n;
import h.c.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.a0.z;

/* compiled from: QRScannerViewModel.kt */
/* loaded from: classes2.dex */
public final class j extends b0 {
    private final IWalletRepository a;

    /* renamed from: b */
    private final h.c.v0.b<List<QRCodeScanResult>> f13583b;

    /* renamed from: c */
    private final h.c.v0.b<Optional<String>> f13584c;

    /* renamed from: d */
    private final s<List<QRCodeScanResult>> f13585d;

    /* renamed from: e */
    private final s<Optional<String>> f13586e;

    public j(IWalletRepository walletRepository) {
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        this.a = walletRepository;
        h.c.v0.b<List<QRCodeScanResult>> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<List<QRCodeScanResult>>()");
        this.f13583b = d2;
        h.c.v0.b<Optional<String>> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<Optional<String>>()");
        this.f13584c = d3;
        s<List<QRCodeScanResult>> throttleLatest = d2.hide().throttleLatest(300L, TimeUnit.MILLISECONDS);
        kotlin.jvm.internal.m.f(throttleLatest, "qrResultsSubject\n        .hide()\n        .throttleLatest(300, TimeUnit.MILLISECONDS)");
        this.f13585d = throttleLatest;
        s<Optional<String>> hide = d3.hide();
        kotlin.jvm.internal.m.f(hide, "warningSubject.hide()");
        this.f13586e = hide;
    }

    public static final List c(List results, List wallets) {
        int r;
        List P;
        String lowerCase;
        boolean O;
        kotlin.jvm.internal.m.g(results, "$results");
        kotlin.jvm.internal.m.g(wallets, "wallets");
        ArrayList arrayList = new ArrayList();
        for (Object obj : results) {
            if (obj instanceof QRCodeScanResult.ERC20) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            String str = null;
            if (!it.hasNext()) {
                break;
            }
            String contractAddress = ((QRCodeScanResult.ERC20) it.next()).getContractAddress();
            if (contractAddress != null) {
                Locale US = Locale.US;
                kotlin.jvm.internal.m.f(US, "US");
                str = contractAddress.toLowerCase(US);
                kotlin.jvm.internal.m.f(str, "(this as java.lang.String).toLowerCase(locale)");
            }
            if (str != null) {
                arrayList2.add(str);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : wallets) {
            if (Wallet_Erc20Kt.isErc20((Wallet) obj2)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : arrayList3) {
            String contractAddress2 = ((Wallet) obj3).getContractAddress();
            if (contractAddress2 == null) {
                lowerCase = null;
            } else {
                Locale US2 = Locale.US;
                kotlin.jvm.internal.m.f(US2, "US");
                lowerCase = contractAddress2.toLowerCase(US2);
                kotlin.jvm.internal.m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            }
            O = z.O(arrayList2, lowerCase);
            if (O) {
                arrayList4.add(obj3);
            }
        }
        ArrayList<QRCodeScanResult> arrayList5 = new ArrayList();
        for (Object obj4 : results) {
            if (!(((QRCodeScanResult) obj4) instanceof QRCodeScanResult.ERC20)) {
                arrayList5.add(obj4);
            }
        }
        r = kotlin.a0.s.r(arrayList5, 10);
        ArrayList arrayList6 = new ArrayList(r);
        for (QRCodeScanResult qRCodeScanResult : arrayList5) {
            arrayList6.add(qRCodeScanResult.getBlockchain());
        }
        ArrayList arrayList7 = new ArrayList();
        for (Object obj5 : wallets) {
            if (arrayList6.contains(((Wallet) obj5).getBlockchain())) {
                arrayList7.add(obj5);
            }
        }
        P = z.P(p.a(arrayList4, arrayList7));
        return P;
    }

    public static /* synthetic */ List f(List list, List list2) {
        return c(list, list2);
    }

    public final s<List<QRCodeScanResult>> a() {
        return this.f13585d;
    }

    public final h.c.b0<List<Wallet>> b(final List<? extends QRCodeScanResult> results) {
        kotlin.jvm.internal.m.g(results, "results");
        h.c.b0<List<Wallet>> map = Observable_CoreKt.takeSingle(this.a.observeWallets(false)).map(new n() { // from class: e.j.h.a.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return j.f(results, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletRepository.observeWallets(false)\n        .takeSingle()\n        .map { wallets ->\n            val erc20ContractAddresses = results\n                .filterIsInstance<QRCodeScanResult.ERC20>()\n                .mapNotNull { it.contractAddress?.toLowerCase(Locale.US) }\n\n            val erc20Wallets = wallets\n                .filter { it.isErc20() }\n                .filter { erc20ContractAddresses.contains(it.contractAddress?.toLowerCase(Locale.US)) }\n\n            val nonErc20Blockchains = results.filter { it !is QRCodeScanResult.ERC20 }.map { it.blockchain }\n            val nonErc20Wallets = wallets.filter { wallet -> nonErc20Blockchains.contains(wallet.blockchain) }\n            erc20Wallets.mergeList(nonErc20Wallets).distinct()\n        }");
        return map;
    }

    public final s<Optional<String>> d() {
        return this.f13586e;
    }

    public final void e(List<? extends QRCodeScanResult> results) {
        kotlin.jvm.internal.m.g(results, "results");
        this.f13583b.onNext(results);
    }

    public final void g(String text) {
        kotlin.jvm.internal.m.g(text, "text");
        this.f13584c.onNext(new Optional<>(text));
    }
}