package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.n5  reason: invalid package */
/* loaded from: classes2.dex */
public final class n5<K, V> {
    private final m5<K, V> a;

    /* renamed from: b  reason: collision with root package name */
    private final K f6855b;

    /* renamed from: c  reason: collision with root package name */
    private final V f6856c;

    private n5(s7 s7Var, K k2, s7 s7Var2, V v) {
        this.a = new m5<>(s7Var, k2, s7Var2, v);
        this.f6855b = k2;
        this.f6856c = v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int b(m5<K, V> m5Var, K k2, V v) {
        return e4.e(m5Var.a, 1, k2) + e4.e(m5Var.f6834c, 2, v);
    }

    public static <K, V> n5<K, V> c(s7 s7Var, K k2, s7 s7Var2, V v) {
        return new n5<>(s7Var, k2, s7Var2, v);
    }

    public final int a(int i2, K k2, V v) {
        return zzev.F0(i2) + zzev.w(b(this.a, k2, v));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final m5<K, V> d() {
        return this.a;
    }
}