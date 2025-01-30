package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.e1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class x1 implements a3 {
    private static final h2 a = new y1();

    /* renamed from: b  reason: collision with root package name */
    private final h2 f6611b;

    public x1() {
        this(new z1(d1.c(), c()));
    }

    private x1(h2 h2Var) {
        this.f6611b = (h2) g1.e(h2Var, "messageInfoFactory");
    }

    private static boolean b(g2 g2Var) {
        return g2Var.a() == e1.e.f6409i;
    }

    private static h2 c() {
        try {
            return (h2) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return a;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.a3
    public final <T> z2<T> a(Class<T> cls) {
        b3.I(cls);
        g2 b2 = this.f6611b.b(cls);
        if (b2.b()) {
            return e1.class.isAssignableFrom(cls) ? n2.a(b3.B(), u0.b(), b2.c()) : n2.a(b3.z(), u0.c(), b2.c());
        } else if (!e1.class.isAssignableFrom(cls)) {
            boolean b3 = b(b2);
            p2 a2 = r2.a();
            s1 c2 = s1.c();
            return b3 ? m2.s(cls, b2, a2, c2, b3.z(), u0.c(), f2.a()) : m2.s(cls, b2, a2, c2, b3.A(), null, f2.a());
        } else {
            boolean b4 = b(b2);
            p2 b5 = r2.b();
            s1 d2 = s1.d();
            q3<?, ?> B = b3.B();
            return b4 ? m2.s(cls, b2, b5, d2, B, u0.b(), f2.b()) : m2.s(cls, b2, b5, d2, B, null, f2.b());
        }
    }
}