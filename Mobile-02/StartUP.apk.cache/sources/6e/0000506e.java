package h.c.t0;

import h.c.b0;
import h.c.h0;
import kotlin.jvm.internal.m;
import kotlin.o;

/* compiled from: Singles.kt */
/* loaded from: classes3.dex */
public final class f {

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

    public static final <T, U> b0<o<T, U>> a(b0<T> receiver, h0<U> other) {
        m.h(receiver, "$receiver");
        m.h(other, "other");
        b0<o<T, U>> b0Var = (b0<o<T, U>>) receiver.zipWith(other, a.a);
        m.d(b0Var, "zipWith(other, BiFunction { t, u -> Pair(t,u) })");
        return b0Var;
    }
}