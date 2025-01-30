package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final c a = new c();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f6077b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f6078c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<a> f6079d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private boolean f6080e = false;

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z);
    }

    private c() {
    }

    public static c b() {
        return a;
    }

    public static void c(Application application) {
        c cVar = a;
        synchronized (cVar) {
            if (!cVar.f6080e) {
                application.registerActivityLifecycleCallbacks(cVar);
                application.registerComponentCallbacks(cVar);
                cVar.f6080e = true;
            }
        }
    }

    private final void e(boolean z) {
        synchronized (a) {
            ArrayList<a> arrayList = this.f6079d;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                a aVar = arrayList.get(i2);
                i2++;
                aVar.a(z);
            }
        }
    }

    public final void a(a aVar) {
        synchronized (a) {
            this.f6079d.add(aVar);
        }
    }

    public final boolean d() {
        return this.f6077b.get();
    }

    @TargetApi(16)
    public final boolean f(boolean z) {
        if (!this.f6078c.get()) {
            if (!com.google.android.gms.common.util.l.c()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f6078c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f6077b.set(true);
            }
        }
        return d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f6077b.compareAndSet(true, false);
        this.f6078c.set(true);
        if (compareAndSet) {
            e(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f6077b.compareAndSet(true, false);
        this.f6078c.set(true);
        if (compareAndSet) {
            e(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        if (i2 == 20 && this.f6077b.compareAndSet(false, true)) {
            this.f6078c.set(true);
            e(true);
        }
    }
}