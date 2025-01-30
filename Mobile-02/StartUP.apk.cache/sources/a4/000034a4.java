package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class e9 implements m2<d9> {
    private static e9 a = new e9();

    /* renamed from: b  reason: collision with root package name */
    private final m2<d9> f7114b;

    private e9(m2<d9> m2Var) {
        this.f7114b = l2.a(m2Var);
    }

    public static boolean b() {
        return ((d9) a.a()).a();
    }

    public static boolean c() {
        return ((d9) a.a()).b();
    }

    @Override // com.google.android.gms.internal.measurement.m2
    public final /* synthetic */ d9 a() {
        return this.f7114b.a();
    }

    public e9() {
        this(l2.b(new g9()));
    }
}