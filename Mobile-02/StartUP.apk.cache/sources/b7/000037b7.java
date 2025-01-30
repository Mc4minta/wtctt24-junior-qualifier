package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: SnackbarManager.java */
/* loaded from: classes2.dex */
class e {
    private static e a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f8204b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final Handler f8205c = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: d  reason: collision with root package name */
    private c f8206d;

    /* renamed from: e  reason: collision with root package name */
    private c f8207e;

    /* compiled from: SnackbarManager.java */
    /* loaded from: classes2.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            e.this.c((c) message.obj);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SnackbarManager.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SnackbarManager.java */
    /* loaded from: classes2.dex */
    public static class c {
        final WeakReference<b> a;

        /* renamed from: b  reason: collision with root package name */
        int f8208b;

        /* renamed from: c  reason: collision with root package name */
        boolean f8209c;

        boolean a(b bVar) {
            return bVar != null && this.a.get() == bVar;
        }
    }

    private e() {
    }

    private boolean a(c cVar, int i2) {
        b bVar = cVar.a.get();
        if (bVar != null) {
            this.f8205c.removeCallbacksAndMessages(cVar);
            bVar.a(i2);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e b() {
        if (a == null) {
            a = new e();
        }
        return a;
    }

    private boolean d(b bVar) {
        c cVar = this.f8206d;
        return cVar != null && cVar.a(bVar);
    }

    private void g(c cVar) {
        int i2 = cVar.f8208b;
        if (i2 == -2) {
            return;
        }
        if (i2 <= 0) {
            i2 = i2 == -1 ? 1500 : 2750;
        }
        this.f8205c.removeCallbacksAndMessages(cVar);
        Handler handler = this.f8205c;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i2);
    }

    void c(c cVar) {
        synchronized (this.f8204b) {
            if (this.f8206d == cVar || this.f8207e == cVar) {
                a(cVar, 2);
            }
        }
    }

    public void e(b bVar) {
        synchronized (this.f8204b) {
            if (d(bVar)) {
                c cVar = this.f8206d;
                if (!cVar.f8209c) {
                    cVar.f8209c = true;
                    this.f8205c.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.f8204b) {
            if (d(bVar)) {
                c cVar = this.f8206d;
                if (cVar.f8209c) {
                    cVar.f8209c = false;
                    g(cVar);
                }
            }
        }
    }
}