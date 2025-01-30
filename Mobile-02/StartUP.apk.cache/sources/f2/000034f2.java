package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class j8 implements k8 {
    private static final x1<Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    private static final x1<Long> f7211b;

    static {
        d2 d2Var = new d2(u1.a("com.google.android.gms.measurement"));
        a = d2Var.d("measurement.sdk.attribution.cache", true);
        f7211b = d2Var.b("measurement.sdk.attribution.cache.ttl", 604800000L);
    }

    @Override // com.google.android.gms.internal.measurement.k8
    public final boolean a() {
        return a.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.k8
    public final long b() {
        return f7211b.n().longValue();
    }
}