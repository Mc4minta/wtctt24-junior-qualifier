package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class fa implements ca {
    private static final x1<Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    private static final x1<Boolean> f7135b;

    static {
        d2 d2Var = new d2(u1.a("com.google.android.gms.measurement"));
        a = d2Var.d("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        f7135b = d2Var.d("measurement.collection.redundant_engagement_removal_enabled", false);
    }

    @Override // com.google.android.gms.internal.measurement.ca
    public final boolean a() {
        return a.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ca
    public final boolean b() {
        return f7135b.n().booleanValue();
    }
}