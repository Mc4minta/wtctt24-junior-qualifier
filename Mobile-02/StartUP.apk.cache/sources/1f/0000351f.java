package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class mb implements nb {
    private static final x1<Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    private static final x1<Double> f7243b;

    /* renamed from: c  reason: collision with root package name */
    private static final x1<Long> f7244c;

    /* renamed from: d  reason: collision with root package name */
    private static final x1<Long> f7245d;

    /* renamed from: e  reason: collision with root package name */
    private static final x1<String> f7246e;

    static {
        d2 d2Var = new d2(u1.a("com.google.android.gms.measurement"));
        a = d2Var.d("measurement.test.boolean_flag", false);
        f7243b = d2Var.a("measurement.test.double_flag", -3.0d);
        f7244c = d2Var.b("measurement.test.int_flag", -2L);
        f7245d = d2Var.b("measurement.test.long_flag", -1L);
        f7246e = d2Var.c("measurement.test.string_flag", "---");
    }

    @Override // com.google.android.gms.internal.measurement.nb
    public final boolean a() {
        return a.n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.nb
    public final double b() {
        return f7243b.n().doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.nb
    public final long c() {
        return f7244c.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.nb
    public final long d() {
        return f7245d.n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.nb
    public final String e() {
        return f7246e.n();
    }
}