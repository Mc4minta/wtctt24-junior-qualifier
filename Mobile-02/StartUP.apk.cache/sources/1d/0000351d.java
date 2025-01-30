package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class m9 implements m2<p9> {
    private static m9 a = new m9();

    /* renamed from: b  reason: collision with root package name */
    private final m2<p9> f7242b;

    private m9(m2<p9> m2Var) {
        this.f7242b = l2.a(m2Var);
    }

    public static boolean b() {
        return ((p9) a.a()).a();
    }

    public static boolean c() {
        return ((p9) a.a()).b();
    }

    @Override // com.google.android.gms.internal.measurement.m2
    public final /* synthetic */ p9 a() {
        return this.f7242b.a();
    }

    public m9() {
        this(l2.b(new o9()));
    }
}