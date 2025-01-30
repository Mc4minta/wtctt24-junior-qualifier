package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class xa implements m2<ab> {
    private static xa a = new xa();

    /* renamed from: b  reason: collision with root package name */
    private final m2<ab> f7418b;

    private xa(m2<ab> m2Var) {
        this.f7418b = l2.a(m2Var);
    }

    public static boolean b() {
        return ((ab) a.a()).a();
    }

    public static boolean c() {
        return ((ab) a.a()).b();
    }

    public static boolean d() {
        return ((ab) a.a()).c();
    }

    @Override // com.google.android.gms.internal.measurement.m2
    public final /* synthetic */ ab a() {
        return this.f7418b.a();
    }

    public xa() {
        this(l2.b(new za()));
    }
}