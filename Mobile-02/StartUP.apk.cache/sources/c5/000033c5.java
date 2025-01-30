package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.n1  reason: invalid package */
/* loaded from: classes2.dex */
public enum n1 implements q4 {
    EFFECTIVE_CONNECTION_TYPE_UNKNOWN(0),
    EFFECTIVE_CONNECTION_TYPE_SLOW_2G(1),
    EFFECTIVE_CONNECTION_TYPE_2G(2),
    EFFECTIVE_CONNECTION_TYPE_3G(3),
    EFFECTIVE_CONNECTION_TYPE_4G(4);
    

    /* renamed from: f  reason: collision with root package name */
    private static final p4<n1> f6848f = new p4<n1>() { // from class: com.google.android.gms.internal.firebase-perf.p1
    };

    /* renamed from: h  reason: collision with root package name */
    private final int f6850h;

    n1(int i2) {
        this.f6850h = i2;
    }

    public static s4 h() {
        return o1.a;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.q4
    public final int getNumber() {
        return this.f6850h;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + n1.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + '>';
    }
}