package e.j.h.a;

import android.os.Bundle;
import androidx.lifecycle.b0;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.features.send.viewmodels.CompleteViewModel;
import com.coinbase.wallet.features.walletlink.models.WalletLinkCompleteArgs;
import com.coinbase.wallet.features.walletlink.models.WalletLinkOnboardingState;
import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import com.coinbase.wallet.features.walletlink.viewmodels.WalletLinkCompleteViewModel;
import com.coinbase.wallet.features.wallets.extensions.legacy.Wallet_Erc20Kt;
import com.coinbase.wallet.qr.models.QRCodeScanResult;
import com.coinbase.wallet.qr.parsers.QRCodeIntentParser;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.walletlink.models.HostRequestId;
import h.c.a0;
import h.c.h0;
import h.c.m0.n;
import h.c.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.a0.r;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: UniversalQRScannerViewModel.kt */
/* loaded from: classes2.dex */
public final class l extends b0 {
    private final Set<QRCodeIntentParser> a;

    /* renamed from: b */
    private final IWalletRepository f13587b;

    /* renamed from: c */
    private final WalletLinkRepository f13588c;

    /* renamed from: d */
    private final a0 f13589d;

    /* renamed from: e */
    private final h.c.k0.a f13590e;

    /* renamed from: f */
    private final h.c.v0.b<List<QRCodeScanResult>> f13591f;

    /* renamed from: g */
    private final h.c.v0.b<ViewModelNavRoute> f13592g;

    /* renamed from: h */
    private final s<List<QRCodeScanResult>> f13593h;

    /* renamed from: i */
    private final s<ViewModelNavRoute> f13594i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UniversalQRScannerViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a extends o implements kotlin.e0.c.l<Throwable, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a() {
            super(1);
            l.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Throwable th) {
            invoke2(th);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable it) {
            List g2;
            kotlin.jvm.internal.m.g(it, "it");
            h.c.v0.b bVar = l.this.f13591f;
            g2 = r.g();
            bVar.onNext(g2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UniversalQRScannerViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class b extends o implements kotlin.e0.c.l<List<? extends QRCodeScanResult>, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b() {
            super(1);
            l.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(List<? extends QRCodeScanResult> list) {
            invoke2(list);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(List<? extends QRCodeScanResult> list) {
            l.this.f13591f.onNext(list);
        }
    }

    /* compiled from: Singles+Core.kt */
    /* loaded from: classes2.dex */
    public static final class c<T, R> implements n {
        @Override // h.c.m0.n
        /* renamed from: a */
        public final List<T> apply(Object[] it) {
            List<T> g2;
            kotlin.jvm.internal.m.g(it, "it");
            if (it.length == 0) {
                g2 = r.g();
                return g2;
            }
            ArrayList arrayList = new ArrayList();
            int length = it.length;
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = it[i2];
                if (obj != null ? obj instanceof Optional : true) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
    }

    public l(Set<QRCodeIntentParser> parsers, IWalletRepository walletRepository, WalletLinkRepository walletLinkRepository) {
        kotlin.jvm.internal.m.g(parsers, "parsers");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(walletLinkRepository, "walletLinkRepository");
        this.a = parsers;
        this.f13587b = walletRepository;
        this.f13588c = walletLinkRepository;
        a0 c2 = h.c.u0.a.c();
        kotlin.jvm.internal.m.f(c2, "io()");
        this.f13589d = c2;
        this.f13590e = new h.c.k0.a();
        h.c.v0.b<List<QRCodeScanResult>> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<List<QRCodeScanResult>>()");
        this.f13591f = d2;
        h.c.v0.b<ViewModelNavRoute> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<ViewModelNavRoute>()");
        this.f13592g = d3;
        s<List<QRCodeScanResult>> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "qrResultsSubject.hide()");
        this.f13593h = hide;
        s<ViewModelNavRoute> hide2 = d3.hide();
        kotlin.jvm.internal.m.f(hide2, "navigationSubject.hide()");
        this.f13594i = hide2;
    }

    public static final Optional c(l this$0, Optional hostRequestIdOptional) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(hostRequestIdOptional, "hostRequestIdOptional");
        HostRequestId hostRequestId = (HostRequestId) hostRequestIdOptional.toNullable();
        if (hostRequestId != null) {
            String dappName = hostRequestId.getDappName();
            if (dappName == null) {
                dappName = LocalizedStrings.INSTANCE.get(R.string.walletlink_dapp_name);
            }
            Bundle createArgs = WalletLinkCompleteArgs.INSTANCE.createArgs(dappName);
            createArgs.putSerializable(CompleteViewModel.class.getName(), WalletLinkCompleteViewModel.class);
            Analytics analytics = Analytics.INSTANCE;
            AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
            String dappName2 = hostRequestId.getDappName();
            if (dappName2 == null) {
                dappName2 = "";
            }
            String host = hostRequestId.getDappURL().getHost();
            analytics.log(AnalyticsEvent_ApplicationKt.dappConnectedViaWalletLink(companion, dappName2, host != null ? host : "", String.valueOf(hostRequestId.getDappImageURL())));
            this$0.f13592g.onNext(new ViewModelNavRoute(R.id.action_universalQRScannerFragment_to_completeFragment, createArgs, null, 4, null));
            return OptionalKt.toOptional(null);
        }
        return OptionalKt.toOptional(WalletLinkOnboardingState.Connected);
    }

    public static final List e(List wallets) {
        kotlin.jvm.internal.m.g(wallets, "wallets");
        ArrayList arrayList = new ArrayList();
        for (Object obj : wallets) {
            if (Wallet_Erc20Kt.isErc20((Wallet) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final Optional f(String contractAddress, List wallets) {
        Object obj;
        kotlin.jvm.internal.m.g(contractAddress, "$contractAddress");
        kotlin.jvm.internal.m.g(wallets, "wallets");
        Iterator it = wallets.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String contractAddress2 = ((Wallet) next).getContractAddress();
            if (contractAddress2 != null) {
                Locale US = Locale.US;
                kotlin.jvm.internal.m.f(US, "US");
                obj = contractAddress2.toLowerCase(US);
                kotlin.jvm.internal.m.f(obj, "(this as java.lang.String).toLowerCase(locale)");
            }
            Locale US2 = Locale.US;
            kotlin.jvm.internal.m.f(US2, "US");
            String lowerCase = contractAddress.toLowerCase(US2);
            kotlin.jvm.internal.m.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (kotlin.jvm.internal.m.c(obj, lowerCase)) {
                obj = next;
                break;
            }
        }
        return OptionalKt.toOptional(obj);
    }

    public static /* synthetic */ Optional h(String str, List list) {
        return f(str, list);
    }

    public static /* synthetic */ Optional j(QRCodeScanResult qRCodeScanResult) {
        return s(qRCodeScanResult);
    }

    public static /* synthetic */ Optional k(Throwable th) {
        return t(th);
    }

    public static /* synthetic */ List l(List list) {
        return e(list);
    }

    public static /* synthetic */ Optional m(l lVar, Optional optional) {
        return c(lVar, optional);
    }

    public static /* synthetic */ List o(List list) {
        return u(list);
    }

    public static final h0 q(h.c.b0 it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it;
    }

    public static final h.c.b0 r(l this$0, String text) {
        int r;
        h.c.b0 zip;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(text, "$text");
        Set<QRCodeIntentParser> set = this$0.a;
        r = kotlin.a0.s.r(set, 10);
        ArrayList arrayList = new ArrayList(r);
        for (QRCodeIntentParser qRCodeIntentParser : set) {
            arrayList.add(qRCodeIntentParser.parse(text).map(new n() { // from class: e.j.h.a.d
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return l.j((QRCodeScanResult) obj);
                }
            }).onErrorReturn(new n() { // from class: e.j.h.a.e
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return l.k((Throwable) obj);
                }
            }));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList, new c());
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return zip.map(new n() { // from class: e.j.h.a.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return l.o((List) obj);
            }
        });
    }

    public static final Optional s(QRCodeScanResult res) {
        kotlin.jvm.internal.m.g(res, "res");
        return OptionalKt.toOptional(res);
    }

    public static final Optional t(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return OptionalKt.toOptional(null);
    }

    public static final List u(List results) {
        kotlin.jvm.internal.m.g(results, "results");
        ArrayList arrayList = new ArrayList();
        Iterator it = results.iterator();
        while (it.hasNext()) {
            QRCodeScanResult qRCodeScanResult = (QRCodeScanResult) ((Optional) it.next()).toNullable();
            if (qRCodeScanResult != null) {
                arrayList.add(qRCodeScanResult);
            }
        }
        return arrayList;
    }

    public final h.c.b0<Optional<WalletLinkOnboardingState>> b(QRCodeScanResult.WalletLink walletLinkResult) {
        h.c.b0 connect;
        kotlin.jvm.internal.m.g(walletLinkResult, "walletLinkResult");
        connect = this.f13588c.connect(walletLinkResult.getSessionId(), walletLinkResult.getSecret(), walletLinkResult.getServerUrl(), walletLinkResult.getVersion(), walletLinkResult.isParent(), (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? null : null, (r23 & 256) != 0 ? null : null);
        h.c.b0<Optional<WalletLinkOnboardingState>> map = connect.map(new n() { // from class: e.j.h.a.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return l.m(l.this, (Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletLinkRepository\n        .connect(\n            sessionId = walletLinkResult.sessionId,\n            secret = walletLinkResult.secret,\n            serverUrl = walletLinkResult.serverUrl,\n            version = walletLinkResult.version,\n            isParent = walletLinkResult.isParent\n        )\n        .map { hostRequestIdOptional ->\n            val hostRequestId = hostRequestIdOptional.toNullable()\n            if (hostRequestId != null) {\n                val dappName = hostRequestId.dappName ?: LocalizedStrings[R.string.walletlink_dapp_name]\n                val args = WalletLinkCompleteArgs.createArgs(dappName).apply {\n                    putSerializable(CompleteViewModel::class.java.name, WalletLinkCompleteViewModel::class.java)\n                }\n\n                Analytics.log(\n                    AnalyticsEvent.dappConnectedViaWalletLink(\n                        hostRequestId.dappName ?: \"\",\n                        hostRequestId.dappURL.host ?: \"\",\n                        hostRequestId.dappImageURL.toString()\n                    )\n                )\n\n                navigationSubject.onNext(\n                    ViewModelNavRoute(\n                        resourceId = R.id.action_universalQRScannerFragment_to_completeFragment,\n                        args = args\n                    )\n                )\n                null.toOptional()\n            } else {\n                WalletLinkOnboardingState.Connected.toOptional()\n            }\n        }");
        return map;
    }

    public final h.c.b0<Optional<Wallet>> d(final String contractAddress) {
        kotlin.jvm.internal.m.g(contractAddress, "contractAddress");
        h.c.b0<Optional<Wallet>> map = Observable_CoreKt.takeSingle(this.f13587b.observeWallets(false)).map(new n() { // from class: e.j.h.a.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return l.l((List) obj);
            }
        }).map(new n() { // from class: e.j.h.a.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return l.h(contractAddress, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletRepository.observeWallets(false)\n        .takeSingle()\n        .map { wallets -> wallets.filter { it.isErc20() } }\n        .map { wallets ->\n            wallets\n                .firstOrNull {\n                    it.contractAddress?.toLowerCase(Locale.US) == contractAddress.toLowerCase(Locale.US)\n                }.toOptional()\n        }");
        return map;
    }

    public final s<List<QRCodeScanResult>> g() {
        return this.f13593h;
    }

    public final s<ViewModelNavRoute> getNavigationObservable() {
        return this.f13594i;
    }

    public final void p(final String text) {
        kotlin.jvm.internal.m.g(text, "text");
        h.c.b0 flatMap = h.c.b0.fromCallable(new Callable() { // from class: e.j.h.a.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                h.c.b0 r;
                r = l.r(l.this, text);
                return r;
            }
        }).flatMap(new n() { // from class: e.j.h.a.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                h0 q;
                q = l.q((h.c.b0) obj);
                return q;
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "fromCallable {\n                parsers\n                    .map { it.parse(text).map { res -> res.toOptional() }.onErrorReturn { null.toOptional() } }\n                    .zipOrEmpty()\n                    .map { results -> results.mapNotNull { it.toNullable() } }\n            }\n            .flatMap { it }");
        h.c.b0 subscribeOn = Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null).subscribeOn(this.f13589d);
        kotlin.jvm.internal.m.f(subscribeOn, "fromCallable {\n                parsers\n                    .map { it.parse(text).map { res -> res.toOptional() }.onErrorReturn { null.toOptional() } }\n                    .zipOrEmpty()\n                    .map { results -> results.mapNotNull { it.toNullable() } }\n            }\n            .flatMap { it }\n            .logError()\n            .subscribeOn(concurrentScheduler)");
        h.c.t0.a.a(h.c.t0.g.f(subscribeOn, new a(), new b()), this.f13590e);
    }
}