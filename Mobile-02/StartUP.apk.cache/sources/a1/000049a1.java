package e.j.i;

import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.application.BaseApplication;
import com.coinbase.wallet.application.extensions.TraceKey_ApplicationKt;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.Destroyable;
import com.coinbase.wallet.core.interfaces.RefreshInterval;
import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.core.models.TraceKey;
import com.coinbase.wallet.performance.Tracer;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import e.j.i.c2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RefreshService.kt */
@ApplicationScoped
/* loaded from: classes2.dex */
public final class c2 implements Startable, Destroyable {
    public static final a a = new a(null);

    /* renamed from: b */
    private static final int f13617b;

    /* renamed from: c */
    private final List<Refreshable> f13618c;

    /* renamed from: d */
    private final IWalletRepository f13619d;

    /* renamed from: e */
    private final h.c.a0 f13620e;

    /* renamed from: f */
    private final h.c.k0.a f13621f;

    /* renamed from: g */
    private final h.c.k0.a f13622g;

    /* renamed from: h */
    private final h.c.v0.b<Boolean> f13623h;

    /* renamed from: i */
    private int f13624i;

    /* renamed from: j */
    private ReentrantReadWriteLock f13625j;

    /* renamed from: k */
    private final h.c.s<Boolean> f13626k;

    /* compiled from: RefreshService.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Singles+Core.kt */
    /* loaded from: classes2.dex */
    public static final class b<T, R> implements h.c.m0.n {
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
                if (obj != null ? obj instanceof kotlin.x : true) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
    }

    /* compiled from: RefreshService.kt */
    /* loaded from: classes2.dex */
    static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Boolean, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c() {
            super(1);
            c2.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Boolean bool) {
            invoke2(bool);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Boolean bool) {
            c2.this.q();
        }
    }

    /* compiled from: RefreshService.kt */
    /* loaded from: classes2.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Boolean, kotlin.x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d() {
            super(1);
            c2.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Boolean bool) {
            invoke2(bool);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Boolean it) {
            kotlin.jvm.internal.m.f(it, "it");
            if (it.booleanValue()) {
                c2.this.t();
            } else {
                c2.this.r();
            }
        }
    }

    /* compiled from: RefreshService.kt */
    /* loaded from: classes2.dex */
    public static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.x, kotlin.x> {

        /* compiled from: RefreshService.kt */
        /* loaded from: classes2.dex */
        public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.x, kotlin.x> {
            public static final a a = new a();

            a() {
                super(1);
            }

            @Override // kotlin.e0.c.l
            public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.x xVar) {
                invoke2(xVar);
                return kotlin.x.a;
            }

            /* renamed from: invoke */
            public final void invoke2(kotlin.x xVar) {
                l.a.a.a(kotlin.jvm.internal.m.o("Refreshed at: ", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(new Date())), new Object[0]);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e() {
            super(1);
            c2.this = r1;
        }

        public static final h.c.h0 a(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            return h.c.b0.just(kotlin.x.a);
        }

        public static /* synthetic */ h.c.h0 b(Throwable th) {
            return a(th);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.x xVar) {
            invoke2(xVar);
            return kotlin.x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(kotlin.x xVar) {
            h.c.b0<kotlin.x> onErrorResumeNext = c2.this.l(false).onErrorResumeNext(new h.c.m0.n() { // from class: e.j.i.q1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return c2.e.b((Throwable) obj);
                }
            });
            kotlin.jvm.internal.m.f(onErrorResumeNext, "refresh(false)\n                    .onErrorResumeNext { Single.just(Unit) }");
            h.c.t0.a.a(h.c.t0.g.i(onErrorResumeNext, null, a.a, 1, null), c2.this.f13621f);
        }
    }

    static {
        int c2;
        c2 = d2.c(RefreshInterval.HOUR);
        f13617b = c2;
    }

    public c2(List<Refreshable> refreshables, IWalletRepository walletRepository) {
        kotlin.jvm.internal.m.g(refreshables, "refreshables");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        this.f13618c = refreshables;
        this.f13619d = walletRepository;
        h.c.a0 c2 = h.c.u0.a.c();
        kotlin.jvm.internal.m.f(c2, "io()");
        this.f13620e = c2;
        this.f13621f = new h.c.k0.a();
        this.f13622g = new h.c.k0.a();
        h.c.v0.b<Boolean> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<Boolean>()");
        this.f13623h = d2;
        this.f13624i = 1;
        this.f13625j = new ReentrantReadWriteLock();
        h.c.s<Boolean> hide = d2.hide();
        kotlin.jvm.internal.m.f(hide, "isRefreshingSubject.hide()");
        this.f13626k = hide;
    }

    public static /* synthetic */ h.c.x g(c2 c2Var, List list) {
        return o(c2Var, list);
    }

    public static /* synthetic */ kotlin.x h(Throwable th) {
        return m(th);
    }

    public static /* synthetic */ boolean i(Boolean bool) {
        return p(bool);
    }

    public static /* synthetic */ kotlin.x j(Throwable th) {
        return s(th);
    }

    public static /* synthetic */ kotlin.x k(c2 c2Var, List list) {
        return n(c2Var, list);
    }

    public static final kotlin.x m(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    public static final kotlin.x n(c2 this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        this$0.f13623h.onNext(Boolean.FALSE);
        return kotlin.x.a;
    }

    public static final h.c.x o(c2 this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.f13619d.hasWallets().toObservable();
    }

    public static final boolean p(Boolean it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.booleanValue();
    }

    public final void q() {
        this.f13621f.d();
        h.c.s<Boolean> distinctUntilChanged = BaseApplication.Companion.isBackgrounded().distinctUntilChanged();
        kotlin.jvm.internal.m.f(distinctUntilChanged, "BaseApplication.isBackgrounded\n            .distinctUntilChanged()");
        h.c.t0.a.a(h.c.t0.g.h(distinctUntilChanged, null, null, new d(), 3, null), this.f13621f);
    }

    public final void r() {
        h.c.s<Long> startWith = h.c.s.interval(30L, TimeUnit.SECONDS).startWith((h.c.s<Long>) 0L);
        kotlin.jvm.internal.m.f(startWith, "interval(UNIT_INTERVAL_SECONDS, TimeUnit.SECONDS)\n            .startWith(0L)");
        h.c.s onErrorReturn = Observable_AnalyticsKt.logError$default(Observable_CoreKt.asUnit(startWith), "Shouldn't get here since we always retry", null, 2, null).onErrorReturn(new h.c.m0.n() { // from class: e.j.i.p1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return c2.j((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn, "interval(UNIT_INTERVAL_SECONDS, TimeUnit.SECONDS)\n            .startWith(0L)\n            .asUnit()\n            .logError(\"Shouldn't get here since we always retry\")\n            .onErrorReturn { Unit }");
        h.c.t0.a.a(h.c.t0.g.h(onErrorReturn, null, null, new e(), 3, null), this.f13622g);
    }

    public static final kotlin.x s(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    public final void t() {
        this.f13622g.d();
    }

    private final int u(boolean z) {
        ReentrantReadWriteLock reentrantReadWriteLock = this.f13625j;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        if (z) {
            try {
                this.f13624i = 0;
            } finally {
                while (i2 < readHoldCount) {
                    readLock.lock();
                    i2++;
                }
                writeLock.unlock();
            }
        }
        int i4 = this.f13624i;
        int s = UInt.s(i4 + 1);
        this.f13624i = s;
        if (!(kotlin.z.a(s, 0) >= 0 && kotlin.z.a(s, f13617b) < 0)) {
            this.f13624i = 0;
        }
        return i4;
    }

    @Override // com.coinbase.wallet.core.interfaces.Destroyable
    public h.c.b0<Boolean> destroy() {
        this.f13621f.d();
        t();
        h.c.b0<Boolean> just = h.c.b0.just(Boolean.TRUE);
        kotlin.jvm.internal.m.f(just, "just(true)");
        return just;
    }

    public final h.c.s<Boolean> f() {
        return this.f13626k;
    }

    public final h.c.b0<kotlin.x> l(boolean z) {
        int r;
        h.c.b0 zip;
        List g2;
        boolean d2;
        h.c.b0<kotlin.x> just;
        this.f13623h.onNext(Boolean.TRUE);
        int u = u(z);
        List<Refreshable> list = this.f13618c;
        r = kotlin.a0.s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (Refreshable refreshable : list) {
            d2 = d2.d(refreshable, u);
            if (d2) {
                just = refreshable.refresh(z).onErrorReturn(new h.c.m0.n() { // from class: e.j.i.n1
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return c2.h((Throwable) obj);
                    }
                });
            } else {
                just = h.c.b0.just(kotlin.x.a);
            }
            arrayList.add(just);
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList, new b());
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        h.c.b0 map = zip.map(new h.c.m0.n() { // from class: e.j.i.r1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return c2.k(c2.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "refreshables.map {\n            if (it.needsToBeRefreshed(currentPhase)) {\n                it.refresh(isForce).onErrorReturn { Unit }\n            } else {\n                Single.just(Unit)\n            }\n        }\n            .zipOrEmpty()\n            .map { isRefreshingSubject.onNext(false) }");
        h.c.b0 trace = Single_CoreKt.trace(map, TraceKey_ApplicationKt.refreshTrace(TraceKey.Companion, kotlin.h0.c.f17279b.c()), Tracer.INSTANCE);
        kotlin.jvm.internal.m.f(trace, "refreshables.map {\n            if (it.needsToBeRefreshed(currentPhase)) {\n                it.refresh(isForce).onErrorReturn { Unit }\n            } else {\n                Single.just(Unit)\n            }\n        }\n            .zipOrEmpty()\n            .map { isRefreshingSubject.onNext(false) }\n            .trace(TraceKey.refreshTrace(nextInt()), Tracer)");
        h.c.b0<kotlin.x> subscribeOn = Single_AnalyticsKt.logError$default(trace, "Error refreshing", null, 2, null).subscribeOn(this.f13620e);
        kotlin.jvm.internal.m.f(subscribeOn, "refreshables.map {\n            if (it.needsToBeRefreshed(currentPhase)) {\n                it.refresh(isForce).onErrorReturn { Unit }\n            } else {\n                Single.just(Unit)\n            }\n        }\n            .zipOrEmpty()\n            .map { isRefreshingSubject.onNext(false) }\n            .trace(TraceKey.refreshTrace(nextInt()), Tracer)\n            .logError(\"Error refreshing\")\n            .subscribeOn(concurrentScheduler)");
        return subscribeOn;
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        h.c.s filter = this.f13619d.observeWallets(false).flatMap(new h.c.m0.n() { // from class: e.j.i.m1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return c2.g(c2.this, (List) obj);
            }
        }).filter(new h.c.m0.p() { // from class: e.j.i.o1
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return c2.i((Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.f(filter, "walletRepository.observeWallets(false)\n            .flatMap { walletRepository.hasWallets().toObservable() }\n            .filter { it }");
        h.c.t0.a.a(h.c.t0.g.i(Observable_CoreKt.takeSingle(filter), null, new c(), 1, null), this.f13621f);
    }
}