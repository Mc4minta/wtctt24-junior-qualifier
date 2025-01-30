package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.i;
import androidx.lifecycle.y;

/* compiled from: ProcessLifecycleOwner.java */
/* loaded from: classes.dex */
public class x implements o {
    private static final x a = new x();

    /* renamed from: f  reason: collision with root package name */
    private Handler f1812f;

    /* renamed from: b  reason: collision with root package name */
    private int f1808b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f1809c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1810d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1811e = true;

    /* renamed from: g  reason: collision with root package name */
    private final p f1813g = new p(this);

    /* renamed from: h  reason: collision with root package name */
    private Runnable f1814h = new a();

    /* renamed from: j  reason: collision with root package name */
    y.a f1815j = new b();

    /* compiled from: ProcessLifecycleOwner.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x.this.f();
            x.this.g();
        }
    }

    /* compiled from: ProcessLifecycleOwner.java */
    /* loaded from: classes.dex */
    class b implements y.a {
        b() {
        }

        @Override // androidx.lifecycle.y.a
        public void a() {
        }

        @Override // androidx.lifecycle.y.a
        public void b() {
            x.this.b();
        }

        @Override // androidx.lifecycle.y.a
        public void onStart() {
            x.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProcessLifecycleOwner.java */
    /* loaded from: classes.dex */
    public class c extends e {

        /* compiled from: ProcessLifecycleOwner.java */
        /* loaded from: classes.dex */
        class a extends e {
            a() {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                x.this.b();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                x.this.c();
            }
        }

        c() {
        }

        @Override // androidx.lifecycle.e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 29) {
                y.f(activity).h(x.this.f1815j);
            }
        }

        @Override // androidx.lifecycle.e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            x.this.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // androidx.lifecycle.e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            x.this.d();
        }
    }

    private x() {
    }

    public static o h() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Context context) {
        a.e(context);
    }

    void a() {
        int i2 = this.f1809c - 1;
        this.f1809c = i2;
        if (i2 == 0) {
            this.f1812f.postDelayed(this.f1814h, 700L);
        }
    }

    void b() {
        int i2 = this.f1809c + 1;
        this.f1809c = i2;
        if (i2 == 1) {
            if (this.f1810d) {
                this.f1813g.i(i.a.ON_RESUME);
                this.f1810d = false;
                return;
            }
            this.f1812f.removeCallbacks(this.f1814h);
        }
    }

    void c() {
        int i2 = this.f1808b + 1;
        this.f1808b = i2;
        if (i2 == 1 && this.f1811e) {
            this.f1813g.i(i.a.ON_START);
            this.f1811e = false;
        }
    }

    void d() {
        this.f1808b--;
        g();
    }

    void e(Context context) {
        this.f1812f = new Handler();
        this.f1813g.i(i.a.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new c());
    }

    void f() {
        if (this.f1809c == 0) {
            this.f1810d = true;
            this.f1813g.i(i.a.ON_PAUSE);
        }
    }

    void g() {
        if (this.f1808b == 0 && this.f1810d) {
            this.f1813g.i(i.a.ON_STOP);
            this.f1811e = true;
        }
    }

    @Override // androidx.lifecycle.o
    public i getLifecycle() {
        return this.f1813g;
    }
}