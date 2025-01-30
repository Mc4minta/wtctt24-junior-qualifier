package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class db implements m2<gb> {
    private static db a = new db();

    /* renamed from: b  reason: collision with root package name */
    private final m2<gb> f7100b;

    private db(m2<gb> m2Var) {
        this.f7100b = l2.a(m2Var);
    }

    public static boolean b() {
        return ((gb) a.a()).a();
    }

    @Override // com.google.android.gms.internal.measurement.m2
    public final /* synthetic */ gb a() {
        return this.f7100b.a();
    }

    public db() {
        this(l2.b(new fb()));
    }
}