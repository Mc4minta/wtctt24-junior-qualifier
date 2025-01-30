package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class o9 implements p9 {
    private static final x1<Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    private static final x1<Long> f7297b;

    static {
        d2 d2Var = new d2(u1.a("com.google.android.gms.measurement"));
        a = d2Var.d("measurement.sdk.referrer.delayed_install_referrer_api", false);
        f7297b = d2Var.b("measurement.id.sdk.referrer.delayed_install_referrer_api", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.p9
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.p9
    public final boolean b() {
        return a.n().booleanValue();
    }
}