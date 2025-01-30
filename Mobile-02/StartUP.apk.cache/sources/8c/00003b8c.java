package com.google.firebase.perf.metrics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.internal.p000firebaseperf.i1;
import com.google.android.gms.internal.p000firebaseperf.k0;
import com.google.android.gms.internal.p000firebaseperf.m0;
import com.google.android.gms.internal.p000firebaseperf.m4;
import com.google.android.gms.internal.p000firebaseperf.n0;
import com.google.android.gms.internal.p000firebaseperf.p2;
import com.google.android.gms.internal.p000firebaseperf.y0;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.provider.FirebasePerfProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public class AppStartTrace implements Application.ActivityLifecycleCallbacks {
    private static final long a = TimeUnit.MINUTES.toMicros(1);

    /* renamed from: b  reason: collision with root package name */
    private static volatile AppStartTrace f9357b;

    /* renamed from: e  reason: collision with root package name */
    private final m0 f9360e;

    /* renamed from: f  reason: collision with root package name */
    private Context f9361f;

    /* renamed from: g  reason: collision with root package name */
    private WeakReference<Activity> f9362g;

    /* renamed from: h  reason: collision with root package name */
    private WeakReference<Activity> f9363h;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9358c = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9364j = false;

    /* renamed from: k  reason: collision with root package name */
    private y0 f9365k = null;

    /* renamed from: l  reason: collision with root package name */
    private y0 f9366l = null;
    private y0 m = null;
    private boolean n = false;

    /* renamed from: d  reason: collision with root package name */
    private com.google.firebase.perf.internal.d f9359d = null;

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        private final AppStartTrace a;

        public a(AppStartTrace appStartTrace) {
            this.a = appStartTrace;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.a.f9365k == null) {
                AppStartTrace.c(this.a, true);
            }
        }
    }

    private AppStartTrace(com.google.firebase.perf.internal.d dVar, m0 m0Var) {
        this.f9360e = m0Var;
    }

    private static AppStartTrace b(com.google.firebase.perf.internal.d dVar, m0 m0Var) {
        if (f9357b == null) {
            synchronized (AppStartTrace.class) {
                if (f9357b == null) {
                    f9357b = new AppStartTrace(null, m0Var);
                }
            }
        }
        return f9357b;
    }

    static /* synthetic */ boolean c(AppStartTrace appStartTrace, boolean z) {
        appStartTrace.n = true;
        return true;
    }

    public static AppStartTrace d() {
        if (f9357b != null) {
            return f9357b;
        }
        return b(null, new m0());
    }

    private final synchronized void e() {
        if (this.f9358c) {
            ((Application) this.f9361f).unregisterActivityLifecycleCallbacks(this);
            this.f9358c = false;
        }
    }

    @Keep
    public static void setLauncherActivityOnCreateTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnResumeTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnStartTime(String str) {
    }

    public final synchronized void f(Context context) {
        if (this.f9358c) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
            this.f9358c = true;
            this.f9361f = applicationContext;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityCreated(Activity activity, Bundle bundle) {
        if (!this.n && this.f9365k == null) {
            this.f9362g = new WeakReference<>(activity);
            this.f9365k = new y0();
            if (FirebasePerfProvider.zzcz().e(this.f9365k) > a) {
                this.f9364j = true;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(Activity activity) {
        if (!this.n && this.m == null && !this.f9364j) {
            this.f9363h = new WeakReference<>(activity);
            this.m = new y0();
            y0 zzcz = FirebasePerfProvider.zzcz();
            k0 a2 = k0.a();
            String name = activity.getClass().getName();
            long e2 = zzcz.e(this.m);
            StringBuilder sb = new StringBuilder(name.length() + 47);
            sb.append("onResume(): ");
            sb.append(name);
            sb.append(": ");
            sb.append(e2);
            sb.append(" microseconds");
            a2.c(sb.toString());
            p2.a q = p2.X().o(n0.APP_START_TRACE_NAME.toString()).p(zzcz.c()).q(zzcz.e(this.m));
            ArrayList arrayList = new ArrayList(3);
            arrayList.add((p2) ((m4) p2.X().o(n0.ON_CREATE_TRACE_NAME.toString()).p(zzcz.c()).q(zzcz.e(this.f9365k)).O()));
            p2.a X = p2.X();
            X.o(n0.ON_START_TRACE_NAME.toString()).p(this.f9365k.c()).q(this.f9365k.e(this.f9366l));
            arrayList.add((p2) ((m4) X.O()));
            p2.a X2 = p2.X();
            X2.o(n0.ON_RESUME_TRACE_NAME.toString()).p(this.f9366l.c()).q(this.f9366l.e(this.m));
            arrayList.add((p2) ((m4) X2.O()));
            q.t(arrayList).r(SessionManager.zzcm().zzcn().g());
            if (this.f9359d == null) {
                this.f9359d = com.google.firebase.perf.internal.d.k();
            }
            com.google.firebase.perf.internal.d dVar = this.f9359d;
            if (dVar != null) {
                dVar.d((p2) ((m4) q.O()), i1.FOREGROUND_BACKGROUND);
            }
            if (this.f9358c) {
                e();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStarted(Activity activity) {
        if (!this.n && this.f9366l == null && !this.f9364j) {
            this.f9366l = new y0();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStopped(Activity activity) {
    }
}