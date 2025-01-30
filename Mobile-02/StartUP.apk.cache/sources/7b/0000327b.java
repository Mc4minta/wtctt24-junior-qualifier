package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.e1;

/* loaded from: classes2.dex */
final class d1 implements h2 {
    private static final d1 a = new d1();

    private d1() {
    }

    public static d1 c() {
        return a;
    }

    @Override // com.google.android.gms.internal.clearcut.h2
    public final boolean a(Class<?> cls) {
        return e1.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.clearcut.h2
    public final g2 b(Class<?> cls) {
        if (!e1.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (g2) e1.p(cls.asSubclass(e1.class)).e(e1.e.f6403c, null, null);
        } catch (Exception e2) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e2);
        }
    }
}