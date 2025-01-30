package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class kb implements m2<nb> {
    private static kb a = new kb();

    /* renamed from: b  reason: collision with root package name */
    private final m2<nb> f7225b;

    private kb(m2<nb> m2Var) {
        this.f7225b = l2.a(m2Var);
    }

    public static boolean b() {
        return ((nb) a.a()).a();
    }

    public static double c() {
        return ((nb) a.a()).b();
    }

    public static long d() {
        return ((nb) a.a()).c();
    }

    public static long e() {
        return ((nb) a.a()).d();
    }

    public static String f() {
        return ((nb) a.a()).e();
    }

    @Override // com.google.android.gms.internal.measurement.m2
    public final /* synthetic */ nb a() {
        return this.f7225b.a();
    }

    public kb() {
        this(l2.b(new mb()));
    }
}