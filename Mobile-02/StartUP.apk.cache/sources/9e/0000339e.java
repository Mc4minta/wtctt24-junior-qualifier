package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.k2  reason: invalid package */
/* loaded from: classes2.dex */
public enum k2 implements q4 {
    SERVICE_WORKER_STATUS_UNKNOWN(0),
    UNSUPPORTED(1),
    CONTROLLED(2),
    UNCONTROLLED(3);
    

    /* renamed from: e  reason: collision with root package name */
    private static final p4<k2> f6791e = new p4<k2>() { // from class: com.google.android.gms.internal.firebase-perf.m2
    };

    /* renamed from: g  reason: collision with root package name */
    private final int f6793g;

    k2(int i2) {
        this.f6793g = i2;
    }

    public static s4 h() {
        return l2.a;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.q4
    public final int getNumber() {
        return this.f6793g;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + k2.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + '>';
    }
}