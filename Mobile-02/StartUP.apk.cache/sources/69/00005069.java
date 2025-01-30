package h.c.t0;

import h.c.s;
import h.c.x;
import kotlin.jvm.internal.m;
import kotlin.o;

/* compiled from: Observables.kt */
/* loaded from: classes3.dex */
public final class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T, U] */
    /* compiled from: Observables.kt */
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

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, U> s<o<T, U>> a(s<T> receiver, x<U> other) {
        m.h(receiver, "$receiver");
        m.h(other, "other");
        s<o<T, U>> sVar = (s<o<T, U>>) receiver.zipWith(other, a.a);
        m.d(sVar, "zipWith(other, BiFunction { t, u -> Pair(t,u) })");
        return sVar;
    }
}