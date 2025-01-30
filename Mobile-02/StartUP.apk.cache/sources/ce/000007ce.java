package com.bugsnag.android;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bugsnag.android.NativeInterface;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionTracker.java */
/* loaded from: classes.dex */
public class y0 extends Observable implements Application.ActivityLifecycleCallbacks {
    private final Collection<String> a;

    /* renamed from: b  reason: collision with root package name */
    private final long f3730b;

    /* renamed from: c  reason: collision with root package name */
    final s f3731c;

    /* renamed from: d  reason: collision with root package name */
    final q f3732d;

    /* renamed from: e  reason: collision with root package name */
    final x0 f3733e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicLong f3734f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicLong f3735g;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicReference<w0> f3736h;

    /* renamed from: j  reason: collision with root package name */
    private final Semaphore f3737j;

    /* renamed from: k  reason: collision with root package name */
    private final j0 f3738k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SessionTracker.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ w0 a;

        a(w0 w0Var) {
            this.a = w0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            y0.this.a();
            w0 w0Var = this.a;
            q qVar = y0.this.f3732d;
            z0 z0Var = new z0(w0Var, null, qVar.f3686d, qVar.f3685c);
            try {
                for (i iVar : y0.this.f3731c.B()) {
                    iVar.a(z0Var);
                }
                y0.this.f3731c.l().b(z0Var, y0.this.f3731c);
            } catch (DeliveryFailureException e2) {
                q0.e("Storing session payload for future delivery", e2);
                y0.this.f3733e.g(this.a);
            } catch (Exception e3) {
                q0.e("Dropping invalid session tracking payload", e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y0(s sVar, q qVar, x0 x0Var) {
        this(sVar, qVar, 30000L, x0Var);
    }

    private String b(Activity activity) {
        return activity.getClass().getSimpleName();
    }

    private String f() {
        return r0.a("releaseStage", this.f3732d.f3686d.h());
    }

    private void j(String str, String str2) {
        if (this.f3731c.D()) {
            HashMap hashMap = new HashMap();
            hashMap.put("ActivityLifecycle", str2);
            try {
                this.f3732d.u(str, BreadcrumbType.NAVIGATION, hashMap);
            } catch (Exception e2) {
                q0.d("Failed to leave breadcrumb in SessionTracker: " + e2.getMessage());
            }
        }
    }

    private void l() {
        notifyObservers(new NativeInterface.b(NativeInterface.c.UPDATE_IN_FOREGROUND, Arrays.asList(Boolean.valueOf(i()), c())));
    }

    private void m(w0 w0Var) {
        setChanged();
        notifyObservers(new NativeInterface.b(NativeInterface.c.START_SESSION, Arrays.asList(w0Var.c(), x.b(w0Var.d()), Integer.valueOf(w0Var.b()), Integer.valueOf(w0Var.e()))));
    }

    private void t(w0 w0Var) {
        if (this.f3731c.X(f())) {
            if ((this.f3731c.e() || !w0Var.h()) && w0Var.i().compareAndSet(false, true)) {
                m(w0Var);
                try {
                    this.f3731c.C();
                    e.a(new a(w0Var));
                } catch (RejectedExecutionException unused) {
                    this.f3733e.g(w0Var);
                }
            }
        }
    }

    void a() {
        if (this.f3737j.tryAcquire(1)) {
            try {
                List<File> e2 = this.f3733e.e();
                if (!e2.isEmpty()) {
                    q qVar = this.f3732d;
                    try {
                        this.f3731c.l().b(new z0(null, e2, qVar.f3686d, qVar.f3685c), this.f3731c);
                        this.f3733e.b(e2);
                    } catch (DeliveryFailureException e3) {
                        this.f3733e.a(e2);
                        q0.e("Leaving session payload for future delivery", e3);
                    } catch (Exception e4) {
                        q0.e("Deleting invalid session tracking payload", e4);
                        this.f3733e.b(e2);
                    }
                }
            } finally {
                this.f3737j.release(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        if (this.a.isEmpty()) {
            return null;
        }
        int size = this.a.size();
        return ((String[]) this.a.toArray(new String[size]))[size - 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0 d() {
        w0 w0Var = this.f3736h.get();
        if (w0Var == null || w0Var.f3728h.get()) {
            return null;
        }
        return w0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long e(long j2) {
        long j3 = this.f3735g.get();
        long j4 = (!i() || j3 == 0) ? 0L : j2 - j3;
        if (j4 > 0) {
            return j4;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0 g() {
        w0 d2 = d();
        if (d2 != null) {
            return d2.f();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0 h() {
        w0 d2 = d();
        if (d2 != null) {
            return d2.g();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        return this.f3738k.c();
    }

    void k(String str, String str2) {
        j(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        w0 w0Var = this.f3736h.get();
        if (w0Var == null || this.a.isEmpty()) {
            return;
        }
        t(w0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0 o(Date date, String str, d1 d1Var, int i2, int i3) {
        w0 w0Var = null;
        if (date != null && str != null) {
            w0Var = new w0(str, date, d1Var, i2, i3);
            m(w0Var);
        } else {
            setChanged();
            notifyObservers(new NativeInterface.b(NativeInterface.c.STOP_SESSION, null));
        }
        this.f3736h.set(w0Var);
        return w0Var;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        k(b(activity), "onCreate()");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        k(b(activity), "onDestroy()");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        k(b(activity), "onPause()");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        k(b(activity), "onResume()");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        k(b(activity), "onSaveInstanceState()");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        String b2 = b(activity);
        k(b2, "onStart()");
        u(b2, true, System.currentTimeMillis());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        String b2 = b(activity);
        k(b2, "onStop()");
        u(b2, false, System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        w0 w0Var = this.f3736h.get();
        boolean z = false;
        if (w0Var == null) {
            w0Var = r(false);
        } else {
            z = w0Var.f3728h.compareAndSet(true, false);
        }
        if (w0Var != null) {
            m(w0Var);
        }
        return z;
    }

    w0 q(Date date, d1 d1Var, boolean z) {
        if (this.f3731c.C() == null) {
            q0.d("The session tracking endpoint has not been set. Session tracking is disabled");
            return null;
        }
        w0 w0Var = new w0(UUID.randomUUID().toString(), date, d1Var, z);
        this.f3736h.set(w0Var);
        t(w0Var);
        return w0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0 r(boolean z) {
        return q(new Date(), this.f3732d.s(), z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        w0 w0Var = this.f3736h.get();
        if (w0Var != null) {
            w0Var.f3728h.set(true);
            setChanged();
            notifyObservers(new NativeInterface.b(NativeInterface.c.STOP_SESSION, null));
        }
    }

    void u(String str, boolean z, long j2) {
        if (z) {
            long j3 = j2 - this.f3734f.get();
            if (this.a.isEmpty()) {
                this.f3735g.set(j2);
                if (j3 >= this.f3730b && this.f3731c.e()) {
                    q(new Date(j2), this.f3732d.s(), true);
                }
            }
            this.a.add(str);
        } else {
            this.a.remove(str);
            if (this.a.isEmpty()) {
                this.f3734f.set(j2);
            }
        }
        setChanged();
        l();
    }

    y0(s sVar, q qVar, long j2, x0 x0Var) {
        this.a = new ConcurrentLinkedQueue();
        this.f3734f = new AtomicLong(0L);
        this.f3735g = new AtomicLong(0L);
        this.f3736h = new AtomicReference<>();
        this.f3737j = new Semaphore(1);
        this.f3731c = sVar;
        this.f3732d = qVar;
        this.f3730b = j2;
        this.f3733e = x0Var;
        this.f3738k = new j0(qVar.f3684b);
        l();
    }
}