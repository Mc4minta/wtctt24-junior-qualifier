package com.google.android.gms.internal.p000firebaseperf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.i5  reason: invalid package */
/* loaded from: classes2.dex */
public final class i5 implements l6 {
    private static final s5 a = new l5();

    /* renamed from: b  reason: collision with root package name */
    private final s5 f6756b;

    public i5() {
        this(new k5(k4.c(), c()));
    }

    private static boolean b(t5 t5Var) {
        return t5Var.c() == i6.a;
    }

    private static s5 c() {
        try {
            return (s5) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return a;
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.l6
    public final <T> m6<T> a(Class<T> cls) {
        o6.x(cls);
        t5 b2 = this.f6756b.b(cls);
        if (b2.a()) {
            if (m4.class.isAssignableFrom(cls)) {
                return y5.h(o6.J(), f4.b(), b2.b());
            }
            return y5.h(o6.F(), f4.c(), b2.b());
        } else if (m4.class.isAssignableFrom(cls)) {
            if (b(b2)) {
                return z5.i(cls, b2, c6.b(), f5.d(), o6.J(), f4.b(), q5.b());
            }
            return z5.i(cls, b2, c6.b(), f5.d(), o6.J(), null, q5.b());
        } else if (b(b2)) {
            return z5.i(cls, b2, c6.a(), f5.c(), o6.F(), f4.c(), q5.a());
        } else {
            return z5.i(cls, b2, c6.a(), f5.c(), o6.G(), null, q5.a());
        }
    }

    private i5(s5 s5Var) {
        this.f6756b = (s5) n4.b(s5Var, "messageInfoFactory");
    }
}