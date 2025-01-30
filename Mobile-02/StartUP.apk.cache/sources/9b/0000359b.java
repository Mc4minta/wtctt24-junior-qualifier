package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class u9 implements v9 {
    private static final x1<Boolean> a = new d2(u1.a("com.google.android.gms.measurement")).d("measurement.service.use_appinfo_modified", false);

    @Override // com.google.android.gms.internal.measurement.v9
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.v9
    public final boolean b() {
        return a.n().booleanValue();
    }
}