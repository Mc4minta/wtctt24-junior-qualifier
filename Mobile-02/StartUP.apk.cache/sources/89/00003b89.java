package com.google.firebase.perf.internal;

import android.util.Log;
import com.google.android.gms.internal.p000firebaseperf.g2;
import com.google.android.gms.internal.p000firebaseperf.m0;
import com.google.android.gms.internal.p000firebaseperf.y0;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public final class v {
    private static final long a = TimeUnit.SECONDS.toMicros(1);

    /* renamed from: b  reason: collision with root package name */
    private long f9347b;

    /* renamed from: c  reason: collision with root package name */
    private double f9348c;

    /* renamed from: d  reason: collision with root package name */
    private y0 f9349d = new y0();

    /* renamed from: e  reason: collision with root package name */
    private long f9350e;

    /* renamed from: f  reason: collision with root package name */
    private final m0 f9351f;

    /* renamed from: g  reason: collision with root package name */
    private double f9352g;

    /* renamed from: h  reason: collision with root package name */
    private long f9353h;

    /* renamed from: i  reason: collision with root package name */
    private double f9354i;

    /* renamed from: j  reason: collision with root package name */
    private long f9355j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f9356k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(double d2, long j2, m0 m0Var, com.google.android.gms.internal.p000firebaseperf.i iVar, String str, boolean z) {
        long j3;
        long k2;
        this.f9351f = m0Var;
        this.f9347b = j2;
        this.f9348c = d2;
        this.f9350e = j2;
        long l2 = iVar.l();
        if (str == "Trace") {
            j3 = iVar.h();
        } else {
            j3 = iVar.j();
        }
        double d3 = j3 / l2;
        this.f9352g = d3;
        this.f9353h = j3;
        if (z) {
            Log.d("FirebasePerformance", String.format("Foreground %s logging rate:%f, burst capacity:%d", str, Double.valueOf(d3), Long.valueOf(this.f9353h)));
        }
        long l3 = iVar.l();
        if (str == "Trace") {
            k2 = iVar.i();
        } else {
            k2 = iVar.k();
        }
        double d4 = k2 / l3;
        this.f9354i = d4;
        this.f9355j = k2;
        if (z) {
            Log.d("FirebasePerformance", String.format("Background %s logging rate:%f, capacity:%d", str, Double.valueOf(d4), Long.valueOf(this.f9355j)));
        }
        this.f9356k = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean a(g2 g2Var) {
        y0 y0Var = new y0();
        long min = Math.min(this.f9350e + Math.max(0L, (long) ((this.f9349d.e(y0Var) * this.f9348c) / a)), this.f9347b);
        this.f9350e = min;
        if (min > 0) {
            this.f9350e = min - 1;
            this.f9349d = y0Var;
            return true;
        }
        if (this.f9356k) {
            Log.w("FirebasePerformance", "Exceeded log rate limit, dropping the log.");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void b(boolean z) {
        this.f9348c = z ? this.f9352g : this.f9354i;
        this.f9347b = z ? this.f9353h : this.f9355j;
    }
}