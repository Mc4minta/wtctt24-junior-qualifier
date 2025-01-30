package com.journeyapps.barcodescanner.q;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraThread.java */
/* loaded from: classes2.dex */
public class f {
    private static f a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f10441b;

    /* renamed from: c  reason: collision with root package name */
    private HandlerThread f10442c;

    /* renamed from: d  reason: collision with root package name */
    private int f10443d = 0;

    /* renamed from: e  reason: collision with root package name */
    private final Object f10444e = new Object();

    private f() {
    }

    private void a() {
        synchronized (this.f10444e) {
            if (this.f10441b == null) {
                if (this.f10443d > 0) {
                    HandlerThread handlerThread = new HandlerThread("CameraThread");
                    this.f10442c = handlerThread;
                    handlerThread.start();
                    this.f10441b = new Handler(this.f10442c.getLooper());
                } else {
                    throw new IllegalStateException("CameraThread is not open");
                }
            }
        }
    }

    public static f d() {
        if (a == null) {
            a = new f();
        }
        return a;
    }

    private void f() {
        synchronized (this.f10444e) {
            this.f10442c.quit();
            this.f10442c = null;
            this.f10441b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        synchronized (this.f10444e) {
            int i2 = this.f10443d - 1;
            this.f10443d = i2;
            if (i2 == 0) {
                f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Runnable runnable) {
        synchronized (this.f10444e) {
            a();
            this.f10441b.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Runnable runnable) {
        synchronized (this.f10444e) {
            this.f10443d++;
            c(runnable);
        }
    }
}