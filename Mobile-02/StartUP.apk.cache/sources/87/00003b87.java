package com.google.firebase.perf.internal;

import android.content.Context;
import com.google.android.gms.internal.p000firebaseperf.c1;
import com.google.android.gms.internal.p000firebaseperf.c2;
import com.google.android.gms.internal.p000firebaseperf.g2;
import com.google.android.gms.internal.p000firebaseperf.h2;
import com.google.android.gms.internal.p000firebaseperf.m0;
import com.google.android.gms.internal.p000firebaseperf.n0;
import com.google.android.gms.internal.p000firebaseperf.o2;
import java.util.List;
import java.util.Random;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public final class t {
    private final float a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9343b;

    /* renamed from: c  reason: collision with root package name */
    private v f9344c;

    /* renamed from: d  reason: collision with root package name */
    private v f9345d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.gms.internal.p000firebaseperf.i f9346e;

    public t(Context context, double d2, long j2) {
        this(100.0d, 500L, new m0(), new Random().nextFloat(), com.google.android.gms.internal.p000firebaseperf.i.A());
        this.f9343b = c1.a(context);
    }

    private static boolean b(List<h2> list) {
        return list.size() > 0 && list.get(0).x() > 0 && list.get(0).A(0) == o2.GAUGES_AND_SYSTEM_EVENTS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(g2 g2Var) {
        if (g2Var.D()) {
            if (!(this.a < this.f9346e.F()) && !b(g2Var.E().N())) {
                return false;
            }
        }
        if (g2Var.F()) {
            if (!(this.a < this.f9346e.G()) && !b(g2Var.G().l0())) {
                return false;
            }
        }
        if ((!g2Var.D() || (!(g2Var.E().u().equals(n0.FOREGROUND_TRACE_NAME.toString()) || g2Var.E().u().equals(n0.BACKGROUND_TRACE_NAME.toString())) || g2Var.E().P() <= 0)) && !g2Var.H()) {
            if (g2Var.F()) {
                return this.f9345d.a(g2Var);
            }
            if (g2Var.D()) {
                return this.f9344c.a(g2Var);
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(boolean z) {
        this.f9344c.b(z);
        this.f9345d.b(z);
    }

    private t(double d2, long j2, m0 m0Var, float f2, com.google.android.gms.internal.p000firebaseperf.i iVar) {
        boolean z = false;
        this.f9343b = false;
        this.f9344c = null;
        this.f9345d = null;
        if (0.0f <= f2 && f2 < 1.0f) {
            z = true;
        }
        c2.a(z, "Sampling bucket ID should be in range [0.0f, 1.0f).");
        this.a = f2;
        this.f9346e = iVar;
        this.f9344c = new v(100.0d, 500L, m0Var, iVar, "Trace", this.f9343b);
        this.f9345d = new v(100.0d, 500L, m0Var, iVar, "Network", this.f9343b);
    }
}