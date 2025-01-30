package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.o2  reason: invalid package */
/* loaded from: classes2.dex */
public enum o2 implements q4 {
    SESSION_VERBOSITY_NONE(0),
    GAUGES_AND_SYSTEM_EVENTS(1);
    

    /* renamed from: c  reason: collision with root package name */
    private static final p4<o2> f6875c = new p4<o2>() { // from class: com.google.android.gms.internal.firebase-perf.n2
    };

    /* renamed from: e  reason: collision with root package name */
    private final int f6877e;

    o2(int i2) {
        this.f6877e = i2;
    }

    public static s4 h() {
        return q2.a;
    }

    public static o2 n(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                return null;
            }
            return GAUGES_AND_SYSTEM_EVENTS;
        }
        return SESSION_VERBOSITY_NONE;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.q4
    public final int getNumber() {
        return this.f6877e;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + o2.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + '>';
    }
}