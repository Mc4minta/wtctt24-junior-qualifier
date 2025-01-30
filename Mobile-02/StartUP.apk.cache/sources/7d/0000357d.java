package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class s9 implements m2<v9> {
    private static s9 a = new s9();

    /* renamed from: b  reason: collision with root package name */
    private final m2<v9> f7340b;

    private s9(m2<v9> m2Var) {
        this.f7340b = l2.a(m2Var);
    }

    public static boolean b() {
        return ((v9) a.a()).a();
    }

    public static boolean c() {
        return ((v9) a.a()).b();
    }

    @Override // com.google.android.gms.internal.measurement.m2
    public final /* synthetic */ v9 a() {
        return this.f7340b.a();
    }

    public s9() {
        this(l2.b(new u9()));
    }
}