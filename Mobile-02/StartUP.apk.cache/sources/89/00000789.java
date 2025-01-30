package com.bugsnag.android;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: AppNotRespondingMonitor.java */
/* loaded from: classes.dex */
final class d {

    /* renamed from: b  reason: collision with root package name */
    private final Handler f3635b;

    /* renamed from: c  reason: collision with root package name */
    private final b f3636c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f3637d = new a();
    private final ByteBuffer a = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder());

    /* compiled from: AppNotRespondingMonitor.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ByteBuffer c2 = d.this.c();
                if (c2.getChar(0) == 'a') {
                    d.this.a().a(Looper.getMainLooper().getThread());
                    c2.putChar(0, (char) 0);
                }
            } catch (IndexOutOfBoundsException unused) {
            } catch (Throwable th) {
                d.this.b().postDelayed(this, 5L);
                throw th;
            }
            d.this.b().postDelayed(this, 5L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppNotRespondingMonitor.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(Thread thread);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        HandlerThread handlerThread = new HandlerThread("bugsnag-anr-watchdog");
        handlerThread.start();
        this.f3635b = new Handler(handlerThread.getLooper());
        this.f3636c = bVar;
    }

    b a() {
        return this.f3636c;
    }

    Handler b() {
        return this.f3635b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer c() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.f3635b.postDelayed(this.f3637d, 5L);
    }
}