package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.x2  reason: invalid package */
/* loaded from: classes2.dex */
public enum x2 implements q4 {
    VISIBILITY_STATE_UNKNOWN(0),
    VISIBLE(1),
    HIDDEN(2),
    PRERENDER(3),
    UNLOADED(4);
    

    /* renamed from: f  reason: collision with root package name */
    private static final p4<x2> f6960f = new p4<x2>() { // from class: com.google.android.gms.internal.firebase-perf.w2
    };

    /* renamed from: h  reason: collision with root package name */
    private final int f6962h;

    x2(int i2) {
        this.f6962h = i2;
    }

    public static s4 h() {
        return z2.a;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.q4
    public final int getNumber() {
        return this.f6962h;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + x2.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + '>';
    }
}