package com.google.firebase.perf.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.internal.p000firebaseperf.b1;
import com.google.android.gms.internal.p000firebaseperf.c1;
import com.google.android.gms.internal.p000firebaseperf.g1;
import com.google.android.gms.internal.p000firebaseperf.g2;
import com.google.android.gms.internal.p000firebaseperf.i1;
import com.google.android.gms.internal.p000firebaseperf.m4;
import com.google.android.gms.internal.p000firebaseperf.o0;
import com.google.android.gms.internal.p000firebaseperf.p2;
import com.google.android.gms.internal.p000firebaseperf.s1;
import com.google.android.gms.internal.p000firebaseperf.z1;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public class d {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile d a;

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f9314b;

    /* renamed from: c  reason: collision with root package name */
    private com.google.firebase.c f9315c;

    /* renamed from: d  reason: collision with root package name */
    private com.google.firebase.perf.a f9316d;

    /* renamed from: e  reason: collision with root package name */
    private FirebaseInstanceId f9317e;

    /* renamed from: f  reason: collision with root package name */
    private Context f9318f;

    /* renamed from: g  reason: collision with root package name */
    private e.g.a.e.c.a f9319g;

    /* renamed from: h  reason: collision with root package name */
    private String f9320h;

    /* renamed from: i  reason: collision with root package name */
    private final g1.a f9321i = g1.F();

    /* renamed from: j  reason: collision with root package name */
    private t f9322j;

    /* renamed from: k  reason: collision with root package name */
    private a f9323k;

    /* renamed from: l  reason: collision with root package name */
    private com.google.android.gms.internal.p000firebaseperf.i f9324l;
    private boolean m;

    private d(ExecutorService executorService, e.g.a.e.c.a aVar, t tVar, a aVar2, FirebaseInstanceId firebaseInstanceId, com.google.android.gms.internal.p000firebaseperf.i iVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f9314b = threadPoolExecutor;
        this.f9319g = null;
        this.f9322j = null;
        this.f9323k = null;
        this.f9317e = null;
        this.f9324l = null;
        threadPoolExecutor.execute(new g(this));
    }

    private final void c(g2 g2Var) {
        if (this.f9319g != null && n()) {
            if (!g2Var.C().t()) {
                Log.w("FirebasePerformance", "App Instance ID is null or empty, dropping the log");
                return;
            }
            Context context = this.f9318f;
            ArrayList arrayList = new ArrayList();
            if (g2Var.D()) {
                arrayList.add(new l(g2Var.E()));
            }
            if (g2Var.F()) {
                arrayList.add(new m(g2Var.G(), context));
            }
            if (g2Var.B()) {
                arrayList.add(new e(g2Var.C()));
            }
            if (g2Var.H()) {
                arrayList.add(new j(g2Var.I()));
            }
            boolean z = false;
            if (arrayList.isEmpty()) {
                Log.d("FirebasePerformance", "No validators found for PerfMetric.");
            } else {
                int size = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = true;
                        break;
                    }
                    Object obj = arrayList.get(i2);
                    i2++;
                    if (!((s) obj).b()) {
                        break;
                    }
                }
            }
            if (!z) {
                Log.w("FirebasePerformance", "Unable to process the PerfMetric due to missing or invalid values. See earlier log statements for additional information on the specific missing/invalid values.");
            } else if (!this.f9322j.a(g2Var)) {
                if (g2Var.F()) {
                    this.f9323k.g(o0.NETWORK_TRACE_EVENT_RATE_LIMITED.toString(), 1L);
                } else if (g2Var.D()) {
                    this.f9323k.g(o0.TRACE_EVENT_RATE_LIMITED.toString(), 1L);
                }
                if (this.m) {
                    if (g2Var.F()) {
                        String valueOf = String.valueOf(g2Var.G().t());
                        Log.i("FirebasePerformance", valueOf.length() != 0 ? "Rate Limited NetworkRequestMetric - ".concat(valueOf) : new String("Rate Limited NetworkRequestMetric - "));
                    } else if (g2Var.D()) {
                        String valueOf2 = String.valueOf(g2Var.E().u());
                        Log.i("FirebasePerformance", valueOf2.length() != 0 ? "Rate Limited TraceMetric - ".concat(valueOf2) : new String("Rate Limited TraceMetric - "));
                    }
                }
            } else {
                try {
                    this.f9319g.b(g2Var.a()).a();
                } catch (SecurityException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(s1 s1Var, i1 i1Var) {
        if (n()) {
            if (this.m) {
                Log.d("FirebasePerformance", String.format("Logging GaugeMetric. Cpu Metrics: %d, Memory Metrics: %d, Has Metadata: %b, Session ID: %s", Integer.valueOf(s1Var.F()), Integer.valueOf(s1Var.G()), Boolean.valueOf(s1Var.D()), s1Var.C()));
            }
            g2.a J = g2.J();
            m();
            J.o(this.f9321i.r(i1Var)).p(s1Var);
            c((g2) ((m4) J.O()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(z1 z1Var, i1 i1Var) {
        if (n()) {
            if (this.m) {
                Log.d("FirebasePerformance", String.format("Logging NetworkRequestMetric - %s %db %dms,", z1Var.t(), Long.valueOf(z1Var.Z() ? z1Var.a0() : 0L), Long.valueOf((!z1Var.j0() ? 0L : z1Var.k0()) / 1000)));
            }
            m();
            c((g2) ((m4) g2.J().o(this.f9321i.r(i1Var)).r(z1Var).O()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(p2 p2Var, i1 i1Var) {
        Map<String, String> emptyMap;
        if (n()) {
            if (this.m) {
                Log.d("FirebasePerformance", String.format("Logging TraceMetric - %s %dms", p2Var.u(), Long.valueOf(p2Var.t() / 1000)));
            }
            m();
            g2.a J = g2.J();
            g1.a r = ((g1.a) ((m4.a) this.f9321i.clone())).r(i1Var);
            o();
            com.google.firebase.perf.a aVar = this.f9316d;
            if (aVar != null) {
                emptyMap = aVar.a();
            } else {
                emptyMap = Collections.emptyMap();
            }
            c((g2) ((m4) J.o(r.q(emptyMap)).q(p2Var).O()));
        }
    }

    public static d k() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    try {
                        com.google.firebase.c.h();
                        a = new d(null, null, null, null, null, null);
                    } catch (IllegalStateException unused) {
                        return null;
                    }
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        this.f9315c = com.google.firebase.c.h();
        this.f9316d = com.google.firebase.perf.a.b();
        this.f9318f = this.f9315c.g();
        String c2 = this.f9315c.j().c();
        this.f9320h = c2;
        this.f9321i.s(c2).p(b1.y().o(this.f9318f.getPackageName()).p(b.f9312b).q(s(this.f9318f)));
        m();
        t tVar = this.f9322j;
        if (tVar == null) {
            tVar = new t(this.f9318f, 100.0d, 500L);
        }
        this.f9322j = tVar;
        a aVar = this.f9323k;
        if (aVar == null) {
            aVar = a.j();
        }
        this.f9323k = aVar;
        com.google.android.gms.internal.p000firebaseperf.i iVar = this.f9324l;
        if (iVar == null) {
            iVar = com.google.android.gms.internal.p000firebaseperf.i.A();
        }
        this.f9324l = iVar;
        iVar.r(this.f9318f);
        this.m = c1.a(this.f9318f);
        if (this.f9319g == null) {
            try {
                this.f9319g = e.g.a.e.c.a.a(this.f9318f, this.f9324l.m());
            } catch (SecurityException e2) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.w("FirebasePerformance", valueOf.length() != 0 ? "Caught SecurityException while init ClearcutLogger: ".concat(valueOf) : new String("Caught SecurityException while init ClearcutLogger: "));
                this.f9319g = null;
            }
        }
    }

    private final void m() {
        if (!this.f9321i.o() && n()) {
            if (this.f9317e == null) {
                this.f9317e = FirebaseInstanceId.c();
            }
            String b2 = this.f9317e.b();
            if (b2 == null || b2.isEmpty()) {
                return;
            }
            this.f9321i.t(b2);
        }
    }

    private final boolean n() {
        o();
        if (this.f9324l == null) {
            this.f9324l = com.google.android.gms.internal.p000firebaseperf.i.A();
        }
        com.google.firebase.perf.a aVar = this.f9316d;
        return aVar != null && aVar.c() && this.f9324l.E();
    }

    private final void o() {
        if (this.f9316d == null) {
            this.f9316d = this.f9315c != null ? com.google.firebase.perf.a.b() : null;
        }
    }

    private static String s(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public final void a(s1 s1Var, i1 i1Var) {
        this.f9314b.execute(new h(this, s1Var, i1Var));
        SessionManager.zzcm().zzco();
    }

    public final void b(z1 z1Var, i1 i1Var) {
        this.f9314b.execute(new i(this, z1Var, i1Var));
        SessionManager.zzcm().zzco();
    }

    public final void d(p2 p2Var, i1 i1Var) {
        this.f9314b.execute(new f(this, p2Var, i1Var));
        SessionManager.zzcm().zzco();
    }

    public final void q(boolean z) {
        this.f9314b.execute(new k(this, z));
    }

    public final void r(boolean z) {
        this.f9322j.c(z);
    }
}