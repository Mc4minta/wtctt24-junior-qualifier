package com.google.android.gms.internal.p000firebaseperf;

import android.os.Bundle;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.q0  reason: invalid package */
/* loaded from: classes2.dex */
public final class q0 {
    private final Bundle a;

    /* renamed from: b  reason: collision with root package name */
    private k0 f6895b;

    public q0() {
        this(new Bundle());
    }

    private final boolean a(String str) {
        return str != null && this.a.containsKey(str);
    }

    private final p0<Integer> e(String str) {
        if (!a(str)) {
            return p0.e();
        }
        try {
            return p0.d((Integer) this.a.get(str));
        } catch (ClassCastException e2) {
            this.f6895b.c(String.format("Metadata key %s contains type other than int: %s", str, e2.getMessage()));
            return p0.e();
        }
    }

    public final p0<Boolean> b(String str) {
        if (!a(str)) {
            return p0.e();
        }
        try {
            return p0.d((Boolean) this.a.get(str));
        } catch (ClassCastException e2) {
            this.f6895b.c(String.format("Metadata key %s contains type other than boolean: %s", str, e2.getMessage()));
            return p0.e();
        }
    }

    public final p0<Float> c(String str) {
        if (!a(str)) {
            return p0.e();
        }
        try {
            return p0.d((Float) this.a.get(str));
        } catch (ClassCastException e2) {
            this.f6895b.c(String.format("Metadata key %s contains type other than float: %s", str, e2.getMessage()));
            return p0.e();
        }
    }

    public final p0<Long> d(String str) {
        p0<Integer> e2 = e(str);
        if (e2.b()) {
            return p0.c(Long.valueOf(e2.a().intValue()));
        }
        return p0.e();
    }

    public q0(Bundle bundle) {
        this.a = (Bundle) bundle.clone();
        this.f6895b = k0.a();
    }
}