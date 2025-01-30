package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class t9 implements q9 {
    private static final x1<Boolean> a = new d2(u1.a("com.google.android.gms.measurement")).d("measurement.engagement_time_main_thread", true);

    @Override // com.google.android.gms.internal.measurement.q9
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.q9
    public final boolean b() {
        return a.n().booleanValue();
    }
}