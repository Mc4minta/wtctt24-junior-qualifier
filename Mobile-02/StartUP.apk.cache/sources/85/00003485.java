package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class c8 implements d8 {
    private static final x1<Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    private static final x1<Boolean> f7081b;

    static {
        d2 d2Var = new d2(u1.a("com.google.android.gms.measurement"));
        a = d2Var.d("measurement.androidId.delete_feature", true);
        f7081b = d2Var.d("measurement.log_androidId_enabled", false);
    }

    @Override // com.google.android.gms.internal.measurement.d8
    public final boolean a() {
        return a.n().booleanValue();
    }
}