package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class ya implements va {
    private static final x1<Long> a;

    /* renamed from: b  reason: collision with root package name */
    private static final x1<Boolean> f7442b;

    /* renamed from: c  reason: collision with root package name */
    private static final x1<Boolean> f7443c;

    /* renamed from: d  reason: collision with root package name */
    private static final x1<Boolean> f7444d;

    /* renamed from: e  reason: collision with root package name */
    private static final x1<Long> f7445e;

    static {
        d2 d2Var = new d2(u1.a("com.google.android.gms.measurement"));
        a = d2Var.b("measurement.id.lifecycle.app_in_background_parameter", 0L);
        f7442b = d2Var.d("measurement.lifecycle.app_backgrounded_engagement", false);
        f7443c = d2Var.d("measurement.lifecycle.app_backgrounded_tracking", true);
        f7444d = d2Var.d("measurement.lifecycle.app_in_background_parameter", false);
        f7445e = d2Var.b("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.va
    public final boolean a() {
        return f7442b.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.va
    public final boolean b() {
        return f7443c.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.va
    public final boolean c() {
        return f7444d.n().booleanValue();
    }
}