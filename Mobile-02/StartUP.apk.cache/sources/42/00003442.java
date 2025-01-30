package com.google.android.gms.internal.p000firebaseperf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.y5  reason: invalid package */
/* loaded from: classes2.dex */
final class y5<T> implements m6<T> {
    private final v5 a;

    /* renamed from: b  reason: collision with root package name */
    private final e7<?, ?> f6984b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f6985c;

    /* renamed from: d  reason: collision with root package name */
    private final c4<?> f6986d;

    private y5(e7<?, ?> e7Var, c4<?> c4Var, v5 v5Var) {
        this.f6984b = e7Var;
        this.f6985c = c4Var.e(v5Var);
        this.f6986d = c4Var;
        this.a = v5Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> y5<T> h(e7<?, ?> e7Var, c4<?> c4Var, v5 v5Var) {
        return new y5<>(e7Var, c4Var, v5Var);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.m6
    public final void a(T t) {
        this.f6984b.c(t);
        this.f6986d.f(t);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.m6
    public final void b(T t, y7 y7Var) throws IOException {
        Iterator<Map.Entry<?, Object>> d2 = this.f6986d.c(t).d();
        while (d2.hasNext()) {
            Map.Entry<?, Object> next = d2.next();
            g4 g4Var = (g4) next.getKey();
            if (g4Var.k() == v7.MESSAGE && !g4Var.w() && !g4Var.x()) {
                if (next instanceof x4) {
                    y7Var.i(g4Var.getNumber(), ((x4) next).a().c());
                } else {
                    y7Var.i(g4Var.getNumber(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        e7<?, ?> e7Var = this.f6984b;
        e7Var.b(e7Var.g(t), y7Var);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.m6
    public final int c(T t) {
        e7<?, ?> e7Var = this.f6984b;
        int h2 = e7Var.h(e7Var.g(t)) + 0;
        return this.f6985c ? h2 + this.f6986d.c(t).s() : h2;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.m6
    public final boolean d(T t) {
        return this.f6986d.c(t).c();
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.m6
    public final boolean e(T t, T t2) {
        if (this.f6984b.g(t).equals(this.f6984b.g(t2))) {
            if (this.f6985c) {
                return this.f6986d.c(t).equals(this.f6986d.c(t2));
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.m6
    public final int f(T t) {
        int hashCode = this.f6984b.g(t).hashCode();
        return this.f6985c ? (hashCode * 53) + this.f6986d.c(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.m6
    public final void g(T t, T t2) {
        o6.f(this.f6984b, t, t2);
        if (this.f6985c) {
            o6.d(this.f6986d, t, t2);
        }
    }
}