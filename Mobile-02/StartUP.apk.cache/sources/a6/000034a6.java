package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class eb implements bb {
    private static final x1<Long> a;

    /* renamed from: b  reason: collision with root package name */
    private static final x1<Long> f7116b;

    static {
        d2 d2Var = new d2(u1.a("com.google.android.gms.measurement"));
        a = d2Var.b("measurement.id.max_bundles_per_iteration", 0L);
        f7116b = d2Var.b("measurement.max_bundles_per_iteration", 2L);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final long a() {
        return f7116b.n().longValue();
    }
}