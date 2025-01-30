package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class na implements oa {
    private static final x1<Boolean> a = new d2(u1.a("com.google.android.gms.measurement")).d("measurement.client.global_params.dev", false);

    @Override // com.google.android.gms.internal.measurement.oa
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.oa
    public final boolean b() {
        return a.n().booleanValue();
    }
}