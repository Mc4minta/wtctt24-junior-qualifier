package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class p8 implements q8 {
    private static final x1<Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    private static final x1<Boolean> f7305b;

    static {
        d2 d2Var = new d2(u1.a("com.google.android.gms.measurement"));
        a = d2Var.d("measurement.service.configurable_service_limits", false);
        f7305b = d2Var.d("measurement.client.configurable_service_limits", false);
    }

    @Override // com.google.android.gms.internal.measurement.q8
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.q8
    public final boolean b() {
        return a.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.q8
    public final boolean c() {
        return f7305b.n().booleanValue();
    }
}