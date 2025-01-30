package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class u8 implements r8 {
    private static final x1<Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    private static final x1<Boolean> f7364b;

    /* renamed from: c  reason: collision with root package name */
    private static final x1<Boolean> f7365c;

    /* renamed from: d  reason: collision with root package name */
    private static final x1<Long> f7366d;

    static {
        d2 d2Var = new d2(u1.a("com.google.android.gms.measurement"));
        a = d2Var.d("measurement.sdk.dynamite.allow_remote_dynamite", false);
        f7364b = d2Var.d("measurement.collection.init_params_control_enabled", true);
        f7365c = d2Var.d("measurement.sdk.dynamite.use_dynamite3", true);
        f7366d = d2Var.b("measurement.id.sdk.dynamite.use_dynamite", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.r8
    public final boolean a() {
        return a.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.r8
    public final boolean b() {
        return f7365c.n().booleanValue();
    }
}