package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class ec implements fc {
    private static final x1<Boolean> a = new d2(u1.a("com.google.android.gms.measurement")).d("measurement.integration.disable_firebase_instance_id", false);

    @Override // com.google.android.gms.internal.measurement.fc
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.fc
    public final boolean b() {
        return a.n().booleanValue();
    }
}