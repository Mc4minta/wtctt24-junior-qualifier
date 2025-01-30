package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.m4;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.k4  reason: invalid package */
/* loaded from: classes2.dex */
final class k4 implements s5 {
    private static final k4 a = new k4();

    private k4() {
    }

    public static k4 c() {
        return a;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.s5
    public final boolean a(Class<?> cls) {
        return m4.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.s5
    public final t5 b(Class<?> cls) {
        if (!m4.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (t5) m4.p(cls.asSubclass(m4.class)).i(m4.d.BUILD_MESSAGE_INFO, null, null);
        } catch (Exception e2) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e2);
        }
    }
}