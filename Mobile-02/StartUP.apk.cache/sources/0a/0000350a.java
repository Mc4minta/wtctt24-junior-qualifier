package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class l4 implements v5 {
    private static final l4 a = new l4();

    private l4() {
    }

    public static l4 c() {
        return a;
    }

    @Override // com.google.android.gms.internal.measurement.v5
    public final boolean a(Class<?> cls) {
        return n4.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.v5
    public final s5 b(Class<?> cls) {
        if (!n4.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (s5) n4.o(cls.asSubclass(n4.class)).r(n4.f.f7256c, null, null);
        } catch (Exception e2) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e2);
        }
    }
}