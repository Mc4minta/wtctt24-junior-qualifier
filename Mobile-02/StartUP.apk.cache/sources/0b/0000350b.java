package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class l5 implements l6 {
    private static final v5 a = new k5();

    /* renamed from: b  reason: collision with root package name */
    private final v5 f7232b;

    public l5() {
        this(new n5(l4.c(), b()));
    }

    private static v5 b() {
        try {
            return (v5) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return a;
        }
    }

    private static boolean c(s5 s5Var) {
        return s5Var.a() == n4.f.f7262i;
    }

    @Override // com.google.android.gms.internal.measurement.l6
    public final <T> m6<T> a(Class<T> cls) {
        o6.p(cls);
        s5 b2 = this.f7232b.b(cls);
        if (b2.b()) {
            if (n4.class.isAssignableFrom(cls)) {
                return a6.j(o6.B(), d4.a(), b2.c());
            }
            return a6.j(o6.f(), d4.b(), b2.c());
        } else if (n4.class.isAssignableFrom(cls)) {
            if (c(b2)) {
                return y5.p(cls, b2, d6.b(), d5.c(), o6.B(), d4.a(), t5.b());
            }
            return y5.p(cls, b2, d6.b(), d5.c(), o6.B(), null, t5.b());
        } else if (c(b2)) {
            return y5.p(cls, b2, d6.a(), d5.a(), o6.f(), d4.b(), t5.a());
        } else {
            return y5.p(cls, b2, d6.a(), d5.a(), o6.v(), null, t5.a());
        }
    }

    private l5(v5 v5Var) {
        this.f7232b = (v5) q4.f(v5Var, "messageInfoFactory");
    }
}