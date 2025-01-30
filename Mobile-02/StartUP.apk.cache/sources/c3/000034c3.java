package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class g9 implements d9 {
    private static final x1<Boolean> a = new d2(u1.a("com.google.android.gms.measurement")).d("measurement.client.firebase_feature_rollout.v1.enable", true);

    @Override // com.google.android.gms.internal.measurement.d9
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.d9
    public final boolean b() {
        return a.n().booleanValue();
    }
}