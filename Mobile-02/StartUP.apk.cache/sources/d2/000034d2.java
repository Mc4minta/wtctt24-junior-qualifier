package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class h8 implements m2<k8> {
    private static h8 a = new h8();

    /* renamed from: b  reason: collision with root package name */
    private final m2<k8> f7170b;

    private h8(m2<k8> m2Var) {
        this.f7170b = l2.a(m2Var);
    }

    public static boolean b() {
        return ((k8) a.a()).a();
    }

    public static long c() {
        return ((k8) a.a()).b();
    }

    @Override // com.google.android.gms.internal.measurement.m2
    public final /* synthetic */ k8 a() {
        return this.f7170b.a();
    }

    public h8() {
        this(l2.b(new j8()));
    }
}