package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.i1  reason: invalid package */
/* loaded from: classes2.dex */
public enum i1 implements q4 {
    APPLICATION_PROCESS_STATE_UNKNOWN(0),
    FOREGROUND(1),
    BACKGROUND(2),
    FOREGROUND_BACKGROUND(3);
    

    /* renamed from: e  reason: collision with root package name */
    private static final p4<i1> f6749e = new p4<i1>() { // from class: com.google.android.gms.internal.firebase-perf.k1
    };

    /* renamed from: g  reason: collision with root package name */
    private final int f6751g;

    i1(int i2) {
        this.f6751g = i2;
    }

    public static s4 h() {
        return j1.a;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.q4
    public final int getNumber() {
        return this.f6751g;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + i1.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + '>';
    }
}