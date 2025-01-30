package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class a9 implements x8 {
    private static final x1<Boolean> a = new d2(u1.a("com.google.android.gms.measurement")).d("measurement.collection.event_safelist", true);

    @Override // com.google.android.gms.internal.measurement.x8
    public final boolean a() {
        return a.n().booleanValue();
    }
}