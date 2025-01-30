package com.google.firebase.perf.internal;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.internal.p000firebaseperf.c0;
import com.google.android.gms.internal.p000firebaseperf.h0;
import com.google.android.gms.internal.p000firebaseperf.i1;
import com.google.android.gms.internal.p000firebaseperf.m4;
import com.google.android.gms.internal.p000firebaseperf.r1;
import com.google.android.gms.internal.p000firebaseperf.s1;
import com.google.android.gms.internal.p000firebaseperf.y0;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
@Keep
/* loaded from: classes2.dex */
public class GaugeManager {
    private static GaugeManager zzdw = new GaugeManager();
    private final com.google.android.gms.internal.p000firebaseperf.i zzac;
    private final ScheduledExecutorService zzdx;
    private final c0 zzdy;
    private final h0 zzdz;
    private d zzea;
    private q zzeb;
    private i1 zzec;
    private String zzed;
    private ScheduledFuture zzee;
    private final ConcurrentLinkedQueue<a> zzef;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* loaded from: classes2.dex */
    public class a {
        private final s1 a;

        /* renamed from: b  reason: collision with root package name */
        private final i1 f9301b;

        a(GaugeManager gaugeManager, s1 s1Var, i1 i1Var) {
            this.a = s1Var;
            this.f9301b = i1Var;
        }
    }

    private GaugeManager() {
        this(Executors.newSingleThreadScheduledExecutor(), null, com.google.android.gms.internal.p000firebaseperf.i.A(), null, c0.e(), h0.d());
    }

    public static synchronized GaugeManager zzby() {
        GaugeManager gaugeManager;
        synchronized (GaugeManager.class) {
            gaugeManager = zzdw;
        }
        return gaugeManager;
    }

    public final void zza(r rVar, i1 i1Var) {
        long J;
        boolean z;
        long L;
        if (this.zzed != null) {
            zzbz();
        }
        y0 e2 = rVar.e();
        int[] iArr = o.a;
        int i2 = iArr[i1Var.ordinal()];
        boolean z2 = true;
        if (i2 != 1) {
            J = i2 != 2 ? -1L : this.zzac.I();
        } else {
            J = this.zzac.J();
        }
        if (c0.k(J)) {
            J = -1;
        }
        if (J == -1) {
            Log.d("FirebasePerformance", "Invalid Cpu Metrics collection frequency. Did not collect Cpu Metrics.");
            z = false;
        } else {
            this.zzdy.a(J, e2);
            z = true;
        }
        if (!z) {
            J = -1;
        }
        int i3 = iArr[i1Var.ordinal()];
        if (i3 != 1) {
            L = i3 != 2 ? -1L : this.zzac.K();
        } else {
            L = this.zzac.L();
        }
        if (h0.j(L)) {
            L = -1;
        }
        if (L == -1) {
            Log.d("FirebasePerformance", "Invalid Memory Metrics collection frequency. Did not collect Memory Metrics.");
            z2 = false;
        } else {
            this.zzdz.a(L, e2);
        }
        if (z2) {
            J = J == -1 ? L : Math.min(J, L);
        }
        if (J == -1) {
            Log.w("FirebasePerformance", "Invalid gauge collection frequency. Unable to start collecting Gauges.");
            return;
        }
        String d2 = rVar.d();
        this.zzed = d2;
        this.zzec = i1Var;
        try {
            long j2 = J * 20;
            this.zzee = this.zzdx.scheduleAtFixedRate(new Runnable(this, d2, i1Var) { // from class: com.google.firebase.perf.internal.n
                private final GaugeManager a;

                /* renamed from: b  reason: collision with root package name */
                private final String f9333b;

                /* renamed from: c  reason: collision with root package name */
                private final i1 f9334c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.f9333b = d2;
                    this.f9334c = i1Var;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.zzd(this.f9333b, this.f9334c);
                }
            }, j2, j2, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e3) {
            String valueOf = String.valueOf(e3.getMessage());
            Log.w("FirebasePerformance", valueOf.length() != 0 ? "Unable to start collecting Gauges: ".concat(valueOf) : new String("Unable to start collecting Gauges: "));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzb(String str, i1 i1Var) {
        if (this.zzeb != null) {
            zzc((s1) ((m4) s1.H().o(str).r((r1) ((m4) r1.z().o(this.zzeb.a()).p(this.zzeb.d()).q(this.zzeb.b()).r(this.zzeb.c()).O())).O()), i1Var);
            return true;
        }
        return false;
    }

    public final void zzbz() {
        String str = this.zzed;
        if (str == null) {
            return;
        }
        i1 i1Var = this.zzec;
        this.zzdy.f();
        this.zzdz.c();
        ScheduledFuture scheduledFuture = this.zzee;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzdx.schedule(new Runnable(this, str, i1Var) { // from class: com.google.firebase.perf.internal.p
            private final GaugeManager a;

            /* renamed from: b  reason: collision with root package name */
            private final String f9335b;

            /* renamed from: c  reason: collision with root package name */
            private final i1 f9336c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f9335b = str;
                this.f9336c = i1Var;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.zzc(this.f9335b, this.f9336c);
            }
        }, 20L, TimeUnit.MILLISECONDS);
        this.zzed = null;
        this.zzec = i1.APPLICATION_PROCESS_STATE_UNKNOWN;
    }

    public final void zzc(Context context) {
        this.zzeb = new q(context);
    }

    public final void zzj(y0 y0Var) {
        c0 c0Var = this.zzdy;
        h0 h0Var = this.zzdz;
        c0Var.b(y0Var);
        h0Var.b(y0Var);
    }

    private final void zzc(s1 s1Var, i1 i1Var) {
        d dVar = this.zzea;
        if (dVar == null) {
            dVar = d.k();
        }
        this.zzea = dVar;
        if (dVar != null) {
            dVar.a(s1Var, i1Var);
            while (!this.zzef.isEmpty()) {
                a poll = this.zzef.poll();
                this.zzea.a(poll.a, poll.f9301b);
            }
            return;
        }
        this.zzef.add(new a(this, s1Var, i1Var));
    }

    private GaugeManager(ScheduledExecutorService scheduledExecutorService, d dVar, com.google.android.gms.internal.p000firebaseperf.i iVar, q qVar, c0 c0Var, h0 h0Var) {
        this.zzec = i1.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.zzed = null;
        this.zzee = null;
        this.zzef = new ConcurrentLinkedQueue<>();
        this.zzdx = scheduledExecutorService;
        this.zzea = null;
        this.zzac = iVar;
        this.zzeb = null;
        this.zzdy = c0Var;
        this.zzdz = h0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zza */
    public final void zzd(String str, i1 i1Var) {
        s1.a H = s1.H();
        while (!this.zzdy.f6697h.isEmpty()) {
            H.q(this.zzdy.f6697h.poll());
        }
        while (!this.zzdz.f6726c.isEmpty()) {
            H.p(this.zzdz.f6726c.poll());
        }
        H.o(str);
        zzc((s1) ((m4) H.O()), i1Var);
    }
}