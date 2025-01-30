package com.facebook.react.modules.debug;

import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;

/* compiled from: DidJSUpdateUiDuringFrameDetector.java */
/* loaded from: classes2.dex */
public class a implements NotThreadSafeBridgeIdleDebugListener, com.facebook.react.uimanager.e1.a {
    private final com.facebook.react.common.b a = com.facebook.react.common.b.b(20);

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.react.common.b f4917b = com.facebook.react.common.b.b(20);

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.react.common.b f4918c = com.facebook.react.common.b.b(20);

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.react.common.b f4919d = com.facebook.react.common.b.b(20);

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f4920e = true;

    private static void c(com.facebook.react.common.b bVar, long j2) {
        int g2 = bVar.g();
        int i2 = 0;
        for (int i3 = 0; i3 < g2; i3++) {
            if (bVar.d(i3) < j2) {
                i2++;
            }
        }
        if (i2 > 0) {
            for (int i4 = 0; i4 < g2 - i2; i4++) {
                bVar.f(i4, bVar.d(i4 + i2));
            }
            bVar.c(i2);
        }
    }

    private boolean d(long j2, long j3) {
        long f2 = f(this.a, j2, j3);
        long f3 = f(this.f4917b, j2, j3);
        if (f2 == -1 && f3 == -1) {
            return this.f4920e;
        }
        return f2 > f3;
    }

    private static long f(com.facebook.react.common.b bVar, long j2, long j3) {
        long j4 = -1;
        for (int i2 = 0; i2 < bVar.g(); i2++) {
            long d2 = bVar.d(i2);
            if (d2 >= j2 && d2 < j3) {
                j4 = d2;
            } else if (d2 >= j3) {
                break;
            }
        }
        return j4;
    }

    private static boolean g(com.facebook.react.common.b bVar, long j2, long j3) {
        for (int i2 = 0; i2 < bVar.g(); i2++) {
            long d2 = bVar.d(i2);
            if (d2 >= j2 && d2 < j3) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.react.uimanager.e1.a
    public synchronized void a() {
        this.f4918c.a(System.nanoTime());
    }

    @Override // com.facebook.react.uimanager.e1.a
    public synchronized void b() {
        this.f4919d.a(System.nanoTime());
    }

    public synchronized boolean e(long j2, long j3) {
        boolean z;
        boolean g2 = g(this.f4919d, j2, j3);
        boolean d2 = d(j2, j3);
        z = true;
        if (!g2 && (!d2 || g(this.f4918c, j2, j3))) {
            z = false;
        }
        c(this.a, j3);
        c(this.f4917b, j3);
        c(this.f4918c, j3);
        c(this.f4919d, j3);
        this.f4920e = d2;
        return z;
    }

    @Override // com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
    public synchronized void onBridgeDestroyed() {
    }

    @Override // com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
    public synchronized void onTransitionToBridgeBusy() {
        this.f4917b.a(System.nanoTime());
    }

    @Override // com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
    public synchronized void onTransitionToBridgeIdle() {
        this.a.a(System.nanoTime());
    }
}