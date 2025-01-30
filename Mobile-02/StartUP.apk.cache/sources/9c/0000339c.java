package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.k0  reason: invalid package */
/* loaded from: classes2.dex */
public final class k0 {
    private static k0 a;

    /* renamed from: b  reason: collision with root package name */
    private l0 f6786b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6787c;

    private k0(l0 l0Var) {
        this.f6787c = false;
        this.f6786b = l0.a();
    }

    public static synchronized k0 a() {
        k0 k0Var;
        synchronized (k0.class) {
            if (a == null) {
                a = new k0();
            }
            k0Var = a;
        }
        return k0Var;
    }

    public final void b(boolean z) {
        this.f6787c = z;
    }

    public final void c(String str) {
        if (this.f6787c) {
            l0.b(str);
        }
    }

    private k0() {
        this(null);
    }
}