package h.c.t0;

import h.c.b0;
import h.c.s;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: subscribers.kt */
/* loaded from: classes3.dex */
public final class g {
    private static final l<Object, x> a = c.a;

    /* renamed from: b */
    private static final l<Throwable, x> f16822b = b.a;

    /* renamed from: c */
    private static final kotlin.e0.c.a<x> f16823c = a.a;

    /* compiled from: subscribers.kt */
    /* loaded from: classes3.dex */
    static final class a extends o implements kotlin.e0.c.a<x> {
        public static final a a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public /* bridge */ /* synthetic */ x invoke() {
            invoke2();
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2() {
        }
    }

    /* compiled from: subscribers.kt */
    /* loaded from: classes3.dex */
    static final class b extends o implements l<Throwable, x> {
        public static final b a = new b();

        b() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Throwable th) {
            invoke2(th);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable it) {
            m.h(it, "it");
        }
    }

    /* compiled from: subscribers.kt */
    /* loaded from: classes3.dex */
    static final class c extends o implements l<Object, x> {
        public static final c a = new c();

        c() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Object obj) {
            invoke2(obj);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Object it) {
            m.h(it, "it");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [h.c.t0.i] */
    private static final <T> h.c.m0.f<T> a(l<? super T, x> lVar) {
        if (lVar == a) {
            h.c.m0.f<T> h2 = h.c.n0.b.a.h();
            m.d(h2, "Functions.emptyConsumer()");
            return h2;
        }
        if (lVar != null) {
            lVar = new i(lVar);
        }
        return (h.c.m0.f) lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [h.c.t0.h] */
    private static final h.c.m0.a b(kotlin.e0.c.a<x> aVar) {
        if (aVar == f16823c) {
            h.c.m0.a aVar2 = h.c.n0.b.a.f14096c;
            m.d(aVar2, "Functions.EMPTY_ACTION");
            return aVar2;
        }
        if (aVar != null) {
            aVar = new h(aVar);
        }
        return (h.c.m0.a) aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [h.c.t0.i] */
    private static final h.c.m0.f<Throwable> c(l<? super Throwable, x> lVar) {
        if (lVar == f16822b) {
            h.c.m0.f<Throwable> fVar = h.c.n0.b.a.f14099f;
            m.d(fVar, "Functions.ON_ERROR_MISSING");
            return fVar;
        }
        if (lVar != null) {
            lVar = new i(lVar);
        }
        return (h.c.m0.f) lVar;
    }

    public static final h.c.k0.b d(h.c.c receiver, l<? super Throwable, x> onError, kotlin.e0.c.a<x> onComplete) {
        m.h(receiver, "$receiver");
        m.h(onError, "onError");
        m.h(onComplete, "onComplete");
        l<Throwable, x> lVar = f16822b;
        if (onError == lVar && onComplete == f16823c) {
            h.c.k0.b subscribe = receiver.subscribe();
            m.d(subscribe, "subscribe()");
            return subscribe;
        } else if (onError == lVar) {
            h.c.k0.b d2 = receiver.d(new h(onComplete));
            m.d(d2, "subscribe(onComplete)");
            return d2;
        } else {
            h.c.k0.b b2 = receiver.b(b(onComplete), new i(onError));
            m.d(b2, "subscribe(onComplete.asO…ion(), Consumer(onError))");
            return b2;
        }
    }

    public static final <T> h.c.k0.b e(s<T> receiver, l<? super Throwable, x> onError, kotlin.e0.c.a<x> onComplete, l<? super T, x> onNext) {
        m.h(receiver, "$receiver");
        m.h(onError, "onError");
        m.h(onComplete, "onComplete");
        m.h(onNext, "onNext");
        h.c.k0.b subscribe = receiver.subscribe(a(onNext), c(onError), b(onComplete));
        m.d(subscribe, "subscribe(onNext.asConsu…ete.asOnCompleteAction())");
        return subscribe;
    }

    public static final <T> h.c.k0.b f(b0<T> receiver, l<? super Throwable, x> onError, l<? super T, x> onSuccess) {
        m.h(receiver, "$receiver");
        m.h(onError, "onError");
        m.h(onSuccess, "onSuccess");
        h.c.k0.b subscribe = receiver.subscribe(a(onSuccess), c(onError));
        m.d(subscribe, "subscribe(onSuccess.asCo…rror.asOnErrorConsumer())");
        return subscribe;
    }

    public static /* bridge */ /* synthetic */ h.c.k0.b g(h.c.c cVar, l lVar, kotlin.e0.c.a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lVar = f16822b;
        }
        if ((i2 & 2) != 0) {
            aVar = f16823c;
        }
        return d(cVar, lVar, aVar);
    }

    public static /* bridge */ /* synthetic */ h.c.k0.b h(s sVar, l lVar, kotlin.e0.c.a aVar, l lVar2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lVar = f16822b;
        }
        if ((i2 & 2) != 0) {
            aVar = f16823c;
        }
        if ((i2 & 4) != 0) {
            lVar2 = a;
        }
        return e(sVar, lVar, aVar, lVar2);
    }

    public static /* bridge */ /* synthetic */ h.c.k0.b i(b0 b0Var, l lVar, l lVar2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lVar = f16822b;
        }
        if ((i2 & 2) != 0) {
            lVar2 = a;
        }
        return f(b0Var, lVar, lVar2);
    }
}