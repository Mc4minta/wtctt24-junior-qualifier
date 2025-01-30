package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class v8 implements w8 {
    private static final x1<Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    private static final x1<Long> f7374b;

    /* renamed from: c  reason: collision with root package name */
    private static final x1<Boolean> f7375c;

    /* renamed from: d  reason: collision with root package name */
    private static final x1<Boolean> f7376d;

    /* renamed from: e  reason: collision with root package name */
    private static final x1<Boolean> f7377e;

    /* renamed from: f  reason: collision with root package name */
    private static final x1<Boolean> f7378f;

    /* renamed from: g  reason: collision with root package name */
    private static final x1<Boolean> f7379g;

    static {
        d2 d2Var = new d2(u1.a("com.google.android.gms.measurement"));
        a = d2Var.d("measurement.gold.enhanced_ecommerce.format_logs", false);
        f7374b = d2Var.b("measurement.id.gold.enhanced_ecommerce.service", 0L);
        f7375c = d2Var.d("measurement.gold.enhanced_ecommerce.log_nested_complex_events", true);
        f7376d = d2Var.d("measurement.gold.enhanced_ecommerce.nested_param_daily_event_count", false);
        f7377e = d2Var.d("measurement.gold.enhanced_ecommerce.updated_schema.client", true);
        f7378f = d2Var.d("measurement.gold.enhanced_ecommerce.updated_schema.service", false);
        f7379g = d2Var.d("measurement.gold.enhanced_ecommerce.upload_nested_complex_events", false);
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean b() {
        return a.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean c() {
        return f7375c.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean d() {
        return f7376d.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean e() {
        return f7377e.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean m() {
        return f7378f.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.w8
    public final boolean n() {
        return f7379g.n().booleanValue();
    }
}