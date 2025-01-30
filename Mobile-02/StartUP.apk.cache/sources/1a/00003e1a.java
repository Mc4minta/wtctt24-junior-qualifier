package com.journeyapps.barcodescanner.q;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.journeyapps.barcodescanner.n;
import com.journeyapps.barcodescanner.p;

/* compiled from: CameraInstance.java */
/* loaded from: classes2.dex */
public class b {
    private static final String a = "b";

    /* renamed from: b  reason: collision with root package name */
    private com.journeyapps.barcodescanner.q.f f10402b;

    /* renamed from: c  reason: collision with root package name */
    private com.journeyapps.barcodescanner.q.e f10403c;

    /* renamed from: d  reason: collision with root package name */
    private com.journeyapps.barcodescanner.q.c f10404d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f10405e;

    /* renamed from: f  reason: collision with root package name */
    private h f10406f;

    /* renamed from: i  reason: collision with root package name */
    private Handler f10409i;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10407g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10408h = true;

    /* renamed from: j  reason: collision with root package name */
    private com.journeyapps.barcodescanner.q.d f10410j = new com.journeyapps.barcodescanner.q.d();

    /* renamed from: k  reason: collision with root package name */
    private Runnable f10411k = new c();

    /* renamed from: l  reason: collision with root package name */
    private Runnable f10412l = new d();
    private Runnable m = new e();
    private Runnable n = new f();

    /* compiled from: CameraInstance.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f10404d.s(this.a);
        }
    }

    /* compiled from: CameraInstance.java */
    /* renamed from: com.journeyapps.barcodescanner.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0220b implements Runnable {
        final /* synthetic */ k a;

        /* compiled from: CameraInstance.java */
        /* renamed from: com.journeyapps.barcodescanner.q.b$b$a */
        /* loaded from: classes2.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f10404d.l(RunnableC0220b.this.a);
            }
        }

        RunnableC0220b(k kVar) {
            this.a = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!b.this.f10407g) {
                Log.d(b.a, "Camera is closed, not requesting preview");
            } else {
                b.this.f10402b.c(new a());
            }
        }
    }

    /* compiled from: CameraInstance.java */
    /* loaded from: classes2.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.a, "Opening camera");
                b.this.f10404d.k();
            } catch (Exception e2) {
                b.this.o(e2);
                Log.e(b.a, "Failed to open camera", e2);
            }
        }
    }

    /* compiled from: CameraInstance.java */
    /* loaded from: classes2.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.a, "Configuring camera");
                b.this.f10404d.d();
                if (b.this.f10405e != null) {
                    b.this.f10405e.obtainMessage(com.google.zxing.p.a.g.zxing_prewiew_size_ready, b.this.m()).sendToTarget();
                }
            } catch (Exception e2) {
                b.this.o(e2);
                Log.e(b.a, "Failed to configure camera", e2);
            }
        }
    }

    /* compiled from: CameraInstance.java */
    /* loaded from: classes2.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.a, "Starting preview");
                b.this.f10404d.r(b.this.f10403c);
                b.this.f10404d.t();
            } catch (Exception e2) {
                b.this.o(e2);
                Log.e(b.a, "Failed to start preview", e2);
            }
        }
    }

    /* compiled from: CameraInstance.java */
    /* loaded from: classes2.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.a, "Closing camera");
                b.this.f10404d.u();
                b.this.f10404d.c();
            } catch (Exception e2) {
                Log.e(b.a, "Failed to close camera", e2);
            }
            b.this.f10408h = true;
            b.this.f10405e.sendEmptyMessage(com.google.zxing.p.a.g.zxing_camera_closed);
            b.this.f10402b.b();
        }
    }

    public b(Context context) {
        p.a();
        this.f10402b = com.journeyapps.barcodescanner.q.f.d();
        com.journeyapps.barcodescanner.q.c cVar = new com.journeyapps.barcodescanner.q.c(context);
        this.f10404d = cVar;
        cVar.n(this.f10410j);
        this.f10409i = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public n m() {
        return this.f10404d.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Exception exc) {
        Handler handler = this.f10405e;
        if (handler != null) {
            handler.obtainMessage(com.google.zxing.p.a.g.zxing_camera_error, exc).sendToTarget();
        }
    }

    private void x() {
        if (!this.f10407g) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }

    public void j() {
        p.a();
        if (this.f10407g) {
            this.f10402b.c(this.n);
        } else {
            this.f10408h = true;
        }
        this.f10407g = false;
    }

    public void k() {
        p.a();
        x();
        this.f10402b.c(this.f10412l);
    }

    public h l() {
        return this.f10406f;
    }

    public boolean n() {
        return this.f10408h;
    }

    public void p() {
        p.a();
        this.f10407g = true;
        this.f10408h = false;
        this.f10402b.e(this.f10411k);
    }

    public void q(k kVar) {
        this.f10409i.post(new RunnableC0220b(kVar));
    }

    public void r(com.journeyapps.barcodescanner.q.d dVar) {
        if (this.f10407g) {
            return;
        }
        this.f10410j = dVar;
        this.f10404d.n(dVar);
    }

    public void s(h hVar) {
        this.f10406f = hVar;
        this.f10404d.p(hVar);
    }

    public void t(Handler handler) {
        this.f10405e = handler;
    }

    public void u(com.journeyapps.barcodescanner.q.e eVar) {
        this.f10403c = eVar;
    }

    public void v(boolean z) {
        p.a();
        if (this.f10407g) {
            this.f10402b.c(new a(z));
        }
    }

    public void w() {
        p.a();
        x();
        this.f10402b.c(this.m);
    }
}