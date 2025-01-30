package h.c.t0;

import h.c.s;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.t;
import kotlin.u;

/* compiled from: Observables.kt */
/* loaded from: classes3.dex */
public final class c {
    public static final c a = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Observables.kt */
    /* loaded from: classes3.dex */
    public static final class a<T1, T2, R> implements h.c.m0.c<T1, T2, o<? extends T1, ? extends T2>> {
        public static final a a = new a();

        a() {
        }

        @Override // h.c.m0.c
        /* renamed from: a */
        public final o<T1, T2> apply(T1 t1, T2 t2) {
            return u.a(t1, t2);
        }
    }

    /* compiled from: Observables.kt */
    /* loaded from: classes3.dex */
    static final class b<T1, T2, T3, R> implements h.c.m0.g<T1, T2, T3, t<? extends T1, ? extends T2, ? extends T3>> {
        public static final b a = new b();

        b() {
        }

        @Override // h.c.m0.g
        /* renamed from: b */
        public final t<T1, T2, T3> a(T1 t1, T2 t2, T3 t3) {
            return new t<>(t1, t2, t3);
        }
    }

    /* compiled from: Observables.kt */
    /* renamed from: h.c.t0.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0401c<T1, T2, R> implements h.c.m0.c<T1, T2, o<? extends T1, ? extends T2>> {
        public static final C0401c a = new C0401c();

        C0401c() {
        }

        @Override // h.c.m0.c
        /* renamed from: a */
        public final o<T1, T2> apply(T1 t1, T2 t2) {
            return u.a(t1, t2);
        }
    }

    private c() {
    }

    public final <T1, T2> s<o<T1, T2>> a(s<T1> source1, s<T2> source2) {
        m.h(source1, "source1");
        m.h(source2, "source2");
        return s.combineLatest(source1, source2, a.a);
    }

    public final <T1, T2, T3> s<t<T1, T2, T3>> b(s<T1> source1, s<T2> source2, s<T3> source3) {
        m.h(source1, "source1");
        m.h(source2, "source2");
        m.h(source3, "source3");
        return s.combineLatest(source1, source2, source3, b.a);
    }

    public final <T1, T2> s<o<T1, T2>> c(s<T1> source1, s<T2> source2) {
        m.h(source1, "source1");
        m.h(source2, "source2");
        return s.zip(source1, source2, C0401c.a);
    }
}