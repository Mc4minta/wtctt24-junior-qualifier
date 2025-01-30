package com.google.firebase.perf.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import com.google.android.gms.internal.p000firebaseperf.c1;
import com.google.android.gms.internal.p000firebaseperf.i1;
import com.google.android.gms.internal.p000firebaseperf.m0;
import com.google.android.gms.internal.p000firebaseperf.m4;
import com.google.android.gms.internal.p000firebaseperf.n0;
import com.google.android.gms.internal.p000firebaseperf.o0;
import com.google.android.gms.internal.p000firebaseperf.p2;
import com.google.android.gms.internal.p000firebaseperf.y0;
import com.google.firebase.perf.metrics.Trace;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.http2.Http2Connection;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    private static volatile a a;

    /* renamed from: e  reason: collision with root package name */
    private final m0 f9305e;

    /* renamed from: h  reason: collision with root package name */
    private y0 f9308h;

    /* renamed from: j  reason: collision with root package name */
    private y0 f9309j;
    private boolean p;
    private androidx.core.app.g q;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9302b = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9306f = true;

    /* renamed from: g  reason: collision with root package name */
    private final WeakHashMap<Activity, Boolean> f9307g = new WeakHashMap<>();

    /* renamed from: k  reason: collision with root package name */
    private final Map<String, Long> f9310k = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    private AtomicInteger f9311l = new AtomicInteger(0);
    private i1 m = i1.BACKGROUND;
    private Set<WeakReference<InterfaceC0193a>> n = new HashSet();
    private final WeakHashMap<Activity, Trace> t = new WeakHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private d f9303c = null;

    /* renamed from: d  reason: collision with root package name */
    private com.google.android.gms.internal.p000firebaseperf.i f9304d = com.google.android.gms.internal.p000firebaseperf.i.A();

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.firebase.perf.internal.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0193a {
        void zza(i1 i1Var);
    }

    private a(d dVar, m0 m0Var) {
        this.p = false;
        this.f9305e = m0Var;
        boolean n = n();
        this.p = n;
        if (n) {
            this.q = new androidx.core.app.g();
        }
    }

    private final void a(String str, y0 y0Var, y0 y0Var2) {
        if (this.f9304d.B()) {
            m();
            p2.a r = p2.X().o(str).p(y0Var.c()).q(y0Var.e(y0Var2)).r(SessionManager.zzcm().zzcn().g());
            int andSet = this.f9311l.getAndSet(0);
            synchronized (this.f9310k) {
                r.u(this.f9310k);
                if (andSet != 0) {
                    r.s(o0.TRACE_STARTED_NOT_STOPPED.toString(), andSet);
                }
                this.f9310k.clear();
            }
            d dVar = this.f9303c;
            if (dVar != null) {
                dVar.d((p2) ((m4) r.O()), i1.FOREGROUND_BACKGROUND);
            }
        }
    }

    private final boolean c(Activity activity) {
        return (!this.p || activity.getWindow() == null || (activity.getWindow().getAttributes().flags & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) == 0) ? false : true;
    }

    private static a d(d dVar) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(null, new m0());
                }
            }
        }
        return a;
    }

    private static String e(Activity activity) {
        String simpleName = activity.getClass().getSimpleName();
        return simpleName.length() != 0 ? "_st_".concat(simpleName) : new String("_st_");
    }

    private final void f(i1 i1Var) {
        this.m = i1Var;
        synchronized (this.n) {
            Iterator<WeakReference<InterfaceC0193a>> it = this.n.iterator();
            while (it.hasNext()) {
                InterfaceC0193a interfaceC0193a = it.next().get();
                if (interfaceC0193a != null) {
                    interfaceC0193a.zza(this.m);
                } else {
                    it.remove();
                }
            }
        }
    }

    private final void i(boolean z) {
        m();
        d dVar = this.f9303c;
        if (dVar != null) {
            dVar.q(z);
        }
    }

    public static a j() {
        if (a != null) {
            return a;
        }
        return d(null);
    }

    private final void m() {
        if (this.f9303c == null) {
            this.f9303c = d.k();
        }
    }

    private static boolean n() {
        try {
            Class.forName("androidx.core.app.g");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void b(WeakReference<InterfaceC0193a> weakReference) {
        synchronized (this.n) {
            this.n.add(weakReference);
        }
    }

    public final void g(String str, long j2) {
        synchronized (this.f9310k) {
            Long l2 = this.f9310k.get(str);
            if (l2 == null) {
                this.f9310k.put(str, 1L);
            } else {
                this.f9310k.put(str, Long.valueOf(l2.longValue() + 1));
            }
        }
    }

    public final void h(WeakReference<InterfaceC0193a> weakReference) {
        synchronized (this.n) {
            this.n.remove(weakReference);
        }
    }

    public final boolean k() {
        return this.f9306f;
    }

    public final i1 l() {
        return this.m;
    }

    public final void o(int i2) {
        this.f9311l.addAndGet(1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(Activity activity) {
        if (this.f9307g.isEmpty()) {
            this.f9309j = new y0();
            this.f9307g.put(activity, Boolean.TRUE);
            f(i1.FOREGROUND);
            i(true);
            if (this.f9306f) {
                this.f9306f = false;
                return;
            } else {
                a(n0.BACKGROUND_TRACE_NAME.toString(), this.f9308h, this.f9309j);
                return;
            }
        }
        this.f9307g.put(activity, Boolean.TRUE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStarted(Activity activity) {
        if (c(activity) && this.f9304d.B()) {
            this.q.a(activity);
            m();
            Trace trace = new Trace(e(activity), this.f9303c, this.f9305e, this);
            trace.start();
            this.t.put(activity, trace);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStopped(Activity activity) {
        Trace trace;
        int i2;
        int i3;
        int i4;
        SparseIntArray sparseIntArray;
        if (c(activity) && this.t.containsKey(activity) && (trace = this.t.get(activity)) != null) {
            this.t.remove(activity);
            SparseIntArray[] b2 = this.q.b(activity);
            if (b2 == null || (sparseIntArray = b2[0]) == null) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                for (int i5 = 0; i5 < sparseIntArray.size(); i5++) {
                    int keyAt = sparseIntArray.keyAt(i5);
                    int valueAt = sparseIntArray.valueAt(i5);
                    i2 += valueAt;
                    if (keyAt > 700) {
                        i4 += valueAt;
                    }
                    if (keyAt > 16) {
                        i3 += valueAt;
                    }
                }
            }
            if (i2 > 0) {
                trace.putMetric(o0.FRAMES_TOTAL.toString(), i2);
            }
            if (i3 > 0) {
                trace.putMetric(o0.FRAMES_SLOW.toString(), i3);
            }
            if (i4 > 0) {
                trace.putMetric(o0.FRAMES_FROZEN.toString(), i4);
            }
            if (c1.a(activity.getApplicationContext())) {
                String e2 = e(activity);
                StringBuilder sb = new StringBuilder(String.valueOf(e2).length() + 81);
                sb.append("sendScreenTrace name:");
                sb.append(e2);
                sb.append(" _fr_tot:");
                sb.append(i2);
                sb.append(" _fr_slo:");
                sb.append(i3);
                sb.append(" _fr_fzn:");
                sb.append(i4);
                Log.d("FirebasePerformance", sb.toString());
            }
            trace.stop();
        }
        if (this.f9307g.containsKey(activity)) {
            this.f9307g.remove(activity);
            if (this.f9307g.isEmpty()) {
                this.f9308h = new y0();
                f(i1.BACKGROUND);
                i(false);
                a(n0.FOREGROUND_TRACE_NAME.toString(), this.f9309j, this.f9308h);
            }
        }
    }

    public final synchronized void p(Context context) {
        if (this.f9302b) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
            this.f9302b = true;
        }
    }
}