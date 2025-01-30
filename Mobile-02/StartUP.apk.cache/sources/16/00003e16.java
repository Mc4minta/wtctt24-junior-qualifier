package com.journeyapps.barcodescanner.q;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: AutoFocusManager.java */
/* loaded from: classes2.dex */
public final class a {
    private static final String a = "a";

    /* renamed from: b  reason: collision with root package name */
    private static final Collection<String> f10393b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10394c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10395d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f10396e;

    /* renamed from: f  reason: collision with root package name */
    private final Camera f10397f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f10398g;

    /* renamed from: h  reason: collision with root package name */
    private int f10399h = 1;

    /* renamed from: i  reason: collision with root package name */
    private final Handler.Callback f10400i;

    /* renamed from: j  reason: collision with root package name */
    private final Camera.AutoFocusCallback f10401j;

    /* compiled from: AutoFocusManager.java */
    /* renamed from: com.journeyapps.barcodescanner.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0218a implements Handler.Callback {
        C0218a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == a.this.f10399h) {
                a.this.h();
                return true;
            }
            return false;
        }
    }

    /* compiled from: AutoFocusManager.java */
    /* loaded from: classes2.dex */
    class b implements Camera.AutoFocusCallback {

        /* compiled from: AutoFocusManager.java */
        /* renamed from: com.journeyapps.barcodescanner.q.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0219a implements Runnable {
            RunnableC0219a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f10395d = false;
                a.this.f();
            }
        }

        b() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            a.this.f10398g.post(new RunnableC0219a());
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        f10393b = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    public a(Camera camera, d dVar) {
        boolean z = true;
        C0218a c0218a = new C0218a();
        this.f10400i = c0218a;
        this.f10401j = new b();
        this.f10398g = new Handler(c0218a);
        this.f10397f = camera;
        String focusMode = camera.getParameters().getFocusMode();
        z = (dVar.c() && f10393b.contains(focusMode)) ? false : false;
        this.f10396e = z;
        String str = a;
        Log.i(str, "Current focus mode '" + focusMode + "'; use auto focus? " + z);
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        if (!this.f10394c && !this.f10398g.hasMessages(this.f10399h)) {
            Handler handler = this.f10398g;
            handler.sendMessageDelayed(handler.obtainMessage(this.f10399h), 2000L);
        }
    }

    private void g() {
        this.f10398g.removeMessages(this.f10399h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.f10396e || this.f10394c || this.f10395d) {
            return;
        }
        try {
            this.f10397f.autoFocus(this.f10401j);
            this.f10395d = true;
        } catch (RuntimeException e2) {
            Log.w(a, "Unexpected exception while focusing", e2);
            f();
        }
    }

    public void i() {
        this.f10394c = false;
        h();
    }

    public void j() {
        this.f10394c = true;
        this.f10395d = false;
        g();
        if (this.f10396e) {
            try {
                this.f10397f.cancelAutoFocus();
            } catch (RuntimeException e2) {
                Log.w(a, "Unexpected exception while cancelling focusing", e2);
            }
        }
    }
}