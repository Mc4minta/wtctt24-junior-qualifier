package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class i9 implements j9 {
    private static final x1<Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    private static final x1<Boolean> f7187b;

    /* renamed from: c  reason: collision with root package name */
    private static final x1<Boolean> f7188c;

    /* renamed from: d  reason: collision with root package name */
    private static final x1<Boolean> f7189d;

    static {
        d2 d2Var = new d2(u1.a("com.google.android.gms.measurement"));
        a = d2Var.d("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        f7187b = d2Var.d("measurement.audience.refresh_event_count_filters_timestamp", false);
        f7188c = d2Var.d("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        f7189d = d2Var.d("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final boolean b() {
        return a.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final boolean c() {
        return f7187b.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final boolean d() {
        return f7188c.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.j9
    public final boolean e() {
        return f7189d.n().booleanValue();
    }
}