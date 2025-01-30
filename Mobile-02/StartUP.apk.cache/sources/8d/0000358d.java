package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class ta implements ua {
    private static final x1<Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    private static final x1<Boolean> f7351b;

    /* renamed from: c  reason: collision with root package name */
    private static final x1<Boolean> f7352c;

    /* renamed from: d  reason: collision with root package name */
    private static final x1<Boolean> f7353d;

    /* renamed from: e  reason: collision with root package name */
    private static final x1<Long> f7354e;

    static {
        d2 d2Var = new d2(u1.a("com.google.android.gms.measurement"));
        a = d2Var.d("measurement.sdk.collection.enable_extend_user_property_size", true);
        f7351b = d2Var.d("measurement.sdk.collection.last_deep_link_referrer2", true);
        f7352c = d2Var.d("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        f7353d = d2Var.d("measurement.sdk.collection.last_gclid_from_referrer2", false);
        f7354e = d2Var.b("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.ua
    public final boolean a() {
        return a.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ua
    public final boolean b() {
        return f7351b.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ua
    public final boolean c() {
        return f7352c.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.ua
    public final boolean d() {
        return f7353d.n().booleanValue();
    }
}