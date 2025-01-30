package e.j.n;

import android.annotation.SuppressLint;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: CurrencyViewModel.kt */
/* loaded from: classes2.dex */
public final class f2 extends androidx.lifecycle.b0 {
    private final IFiatCurrencyRepository a;

    /* renamed from: b */
    private final kotlin.h f13829b;

    /* renamed from: c */
    private final androidx.lifecycle.u<List<FiatCurrency>> f13830c;

    /* renamed from: d */
    private final e.j.l.k<FiatCurrency> f13831d;

    /* compiled from: CurrencyViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<List<? extends FiatCurrency>, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a() {
            super(1);
            f2.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(List<? extends FiatCurrency> list) {
            invoke2((List<FiatCurrency>) list);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(List<FiatCurrency> list) {
            f2.this.d().l(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CurrencyViewModel.kt */
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

    public f2(IFiatCurrencyRepository fiatCurrencyRepository) {
        kotlin.h b2;
        kotlin.jvm.internal.m.g(fiatCurrencyRepository, "fiatCurrencyRepository");
        this.a = fiatCurrencyRepository;
        b2 = kotlin.k.b(b.a);
        this.f13829b = b2;
        this.f13830c = new androidx.lifecycle.u<>();
        this.f13831d = new e.j.l.k<>();
        a();
    }

    @SuppressLint({"CheckResult"})
    private final void a() {
        h.c.b0 flatMap = this.a.getCurrencies().map(new h.c.m0.n() { // from class: e.j.n.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return f2.i((List) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: e.j.n.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return f2.h(f2.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "fiatCurrencyRepository.getCurrencies()\n            // NOTE: remove all subscribeOn's for (new) database and store\n            .map { it.toMutableList() }\n            .flatMap { sortCurrencies(it) }");
        h.c.b0 observeOn = Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null).observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "fiatCurrencyRepository.getCurrencies()\n            // NOTE: remove all subscribeOn's for (new) database and store\n            .map { it.toMutableList() }\n            .flatMap { sortCurrencies(it) }\n            .logError()\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.g.i(observeOn, null, new a(), 1, null);
    }

    public static final List b(List it) {
        List K0;
        kotlin.jvm.internal.m.g(it, "it");
        K0 = kotlin.a0.z.K0(it);
        return K0;
    }

    public static final h.c.h0 c(f2 this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.k(it);
    }

    private final h.c.k0.a f() {
        return (h.c.k0.a) this.f13829b.getValue();
    }

    public static /* synthetic */ h.c.h0 h(f2 f2Var, List list) {
        return c(f2Var, list);
    }

    public static /* synthetic */ List i(List list) {
        return b(list);
    }

    public static /* synthetic */ List j(List list) {
        return l(list);
    }

    private final h.c.b0<List<FiatCurrency>> k(final List<FiatCurrency> list) {
        h.c.b0<List<FiatCurrency>> fromCallable = h.c.b0.fromCallable(new Callable() { // from class: e.j.n.l
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return f2.j(list);
            }
        });
        kotlin.jvm.internal.m.f(fromCallable, "fromCallable {\n            Collections.sort(currencies, FiatCurrencyComparator())\n            currencies\n        }");
        return fromCallable;
    }

    public static final List l(List currencies) {
        kotlin.jvm.internal.m.g(currencies, "$currencies");
        Collections.sort(currencies, new e.j.l.s.a());
        return currencies;
    }

    public final androidx.lifecycle.u<List<FiatCurrency>> d() {
        return this.f13830c;
    }

    public final e.j.l.k<FiatCurrency> e() {
        return this.f13831d;
    }

    public final void g(FiatCurrency currency) {
        kotlin.jvm.internal.m.g(currency, "currency");
        this.a.saveActiveCurrency(currency);
        this.f13831d.l(currency);
    }

    @Override // androidx.lifecycle.b0
    public void onCleared() {
        super.onCleared();
        f().d();
    }
}