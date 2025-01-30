package com.journeyapps.barcodescanner;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/* compiled from: DecoderThread.java */
/* loaded from: classes2.dex */
public class h {
    private static final String a = "h";

    /* renamed from: b  reason: collision with root package name */
    private com.journeyapps.barcodescanner.q.b f10370b;

    /* renamed from: c  reason: collision with root package name */
    private HandlerThread f10371c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f10372d;

    /* renamed from: e  reason: collision with root package name */
    private e f10373e;

    /* renamed from: f  reason: collision with root package name */
    private Handler f10374f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f10375g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10376h = false;

    /* renamed from: i  reason: collision with root package name */
    private final Object f10377i = new Object();

    /* renamed from: j  reason: collision with root package name */
    private final Handler.Callback f10378j = new a();

    /* renamed from: k  reason: collision with root package name */
    private final com.journeyapps.barcodescanner.q.k f10379k = new b();

    /* compiled from: DecoderThread.java */
    /* loaded from: classes2.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == com.google.zxing.p.a.g.zxing_decode) {
                h.this.g((o) message.obj);
                return true;
            } else if (i2 == com.google.zxing.p.a.g.zxing_preview_failed) {
                h.this.h();
                return true;
            } else {
                return true;
            }
        }
    }

    /* compiled from: DecoderThread.java */
    /* loaded from: classes2.dex */
    class b implements com.journeyapps.barcodescanner.q.k {
        b() {
        }

        @Override // com.journeyapps.barcodescanner.q.k
        public void a(Exception exc) {
            synchronized (h.this.f10377i) {
                if (h.this.f10376h) {
                    h.this.f10372d.obtainMessage(com.google.zxing.p.a.g.zxing_preview_failed).sendToTarget();
                }
            }
        }

        @Override // com.journeyapps.barcodescanner.q.k
        public void b(o oVar) {
            synchronized (h.this.f10377i) {
                if (h.this.f10376h) {
                    h.this.f10372d.obtainMessage(com.google.zxing.p.a.g.zxing_decode, oVar).sendToTarget();
                }
            }
        }
    }

    public h(com.journeyapps.barcodescanner.q.b bVar, e eVar, Handler handler) {
        p.a();
        this.f10370b = bVar;
        this.f10373e = eVar;
        this.f10374f = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(o oVar) {
        long currentTimeMillis = System.currentTimeMillis();
        oVar.i(this.f10375g);
        com.google.zxing.g f2 = f(oVar);
        com.google.zxing.k c2 = f2 != null ? this.f10373e.c(f2) : null;
        if (c2 != null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            String str = a;
            Log.d(str, "Found barcode in " + (currentTimeMillis2 - currentTimeMillis) + " ms");
            if (this.f10374f != null) {
                Message obtain = Message.obtain(this.f10374f, com.google.zxing.p.a.g.zxing_decode_succeeded, new com.journeyapps.barcodescanner.b(c2, oVar));
                obtain.setData(new Bundle());
                obtain.sendToTarget();
            }
        } else {
            Handler handler = this.f10374f;
            if (handler != null) {
                Message.obtain(handler, com.google.zxing.p.a.g.zxing_decode_failed).sendToTarget();
            }
        }
        if (this.f10374f != null) {
            Message.obtain(this.f10374f, com.google.zxing.p.a.g.zxing_possible_result_points, this.f10373e.d()).sendToTarget();
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f10370b.q(this.f10379k);
    }

    protected com.google.zxing.g f(o oVar) {
        if (this.f10375g == null) {
            return null;
        }
        return oVar.a();
    }

    public void i(Rect rect) {
        this.f10375g = rect;
    }

    public void j(e eVar) {
        this.f10373e = eVar;
    }

    public void k() {
        p.a();
        HandlerThread handlerThread = new HandlerThread(a);
        this.f10371c = handlerThread;
        handlerThread.start();
        this.f10372d = new Handler(this.f10371c.getLooper(), this.f10378j);
        this.f10376h = true;
        h();
    }

    public void l() {
        p.a();
        synchronized (this.f10377i) {
            this.f10376h = false;
            this.f10372d.removeCallbacksAndMessages(null);
            this.f10371c.quit();
        }
    }
}