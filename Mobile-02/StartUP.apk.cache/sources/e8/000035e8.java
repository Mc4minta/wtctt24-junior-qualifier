package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class z9 implements w9 {
    private static final x1<Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    private static final x1<Boolean> f7455b;

    /* renamed from: c  reason: collision with root package name */
    private static final x1<Boolean> f7456c;

    static {
        d2 d2Var = new d2(u1.a("com.google.android.gms.measurement"));
        a = d2Var.d("measurement.client.sessions.check_on_reset_and_enable2", true);
        f7455b = d2Var.d("measurement.client.sessions.check_on_startup", true);
        f7456c = d2Var.d("measurement.client.sessions.start_session_before_view_screen", true);
    }

    @Override // com.google.android.gms.internal.measurement.w9
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.w9
    public final boolean b() {
        return a.n().booleanValue();
    }
}