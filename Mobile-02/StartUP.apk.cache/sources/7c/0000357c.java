package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class s8 implements m2<r8> {
    private static s8 a = new s8();

    /* renamed from: b  reason: collision with root package name */
    private final m2<r8> f7339b;

    private s8(m2<r8> m2Var) {
        this.f7339b = l2.a(m2Var);
    }

    public static boolean b() {
        return ((r8) a.a()).a();
    }

    public static boolean c() {
        return ((r8) a.a()).b();
    }

    @Override // com.google.android.gms.internal.measurement.m2
    public final /* synthetic */ r8 a() {
        return this.f7339b.a();
    }

    public s8() {
        this(l2.b(new u8()));
    }
}