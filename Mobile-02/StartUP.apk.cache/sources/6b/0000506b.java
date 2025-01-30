package h.c.t0;

import h.c.b0;
import h.c.h0;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.t;

/* compiled from: Singles.kt */
/* loaded from: classes3.dex */
public final class e {
    public static final e a = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T, U] */
    /* compiled from: Singles.kt */
    /* loaded from: classes3.dex */
    public static final class a<T1, T2, R, T, U> implements h.c.m0.c<T, U, o<? extends T, ? extends U>> {
        public static final a a = new a();

        a() {
        }

        @Override // h.c.m0.c
        /* renamed from: a */
        public final o<T, U> apply(T t, U u) {
            return new o<>(t, u);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Singles.kt */
    /* loaded from: classes3.dex */
    public static final class b<T1, T2, T3, R> implements h.c.m0.g<T1, T2, T3, t<? extends T1, ? extends T2, ? extends T3>> {
        public static final b a = new b();

        b() {
        }

        @Override // h.c.m0.g
        /* renamed from: b */
        public final t<T1, T2, T3> a(T1 t1, T2 t2, T3 t3) {
            return new t<>(t1, t2, t3);
        }
    }

    private e() {
    }

    public final <T, U> b0<o<T, U>> a(h0<T> s1, h0<U> s2) {
        m.h(s1, "s1");
        m.h(s2, "s2");
        b0<o<T, U>> zip = b0.zip(s1, s2, a.a);
        m.d(zip, "Single.zip(s1, s2, BiFun…on { t, u -> Pair(t,u) })");
        return zip;
    }

    public final <T1, T2, T3> b0<t<T1, T2, T3>> b(h0<T1> s1, h0<T2> s2, h0<T3> s3) {
        m.h(s1, "s1");
        m.h(s2, "s2");
        m.h(s3, "s3");
        b0<t<T1, T2, T3>> zip = b0.zip(s1, s2, s3, b.a);
        m.d(zip, "Single.zip(s1, s2, s3, F…t3 -> Triple(t1,t2,t3) })");
        return zip;
    }
}