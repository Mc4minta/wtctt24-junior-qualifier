package com.swmansion.gesturehandler.react;

import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import e.f.m.s;

/* compiled from: RNGestureHandlerRootHelper.java */
/* loaded from: classes2.dex */
public class g {
    private final ReactContext a;

    /* renamed from: b  reason: collision with root package name */
    private final e.i.a.d f10912b;

    /* renamed from: c  reason: collision with root package name */
    private final e.i.a.b f10913c;

    /* renamed from: d  reason: collision with root package name */
    private final ViewGroup f10914d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10915e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10916f = false;

    /* compiled from: RNGestureHandlerRootHelper.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.j();
        }
    }

    /* compiled from: RNGestureHandlerRootHelper.java */
    /* loaded from: classes2.dex */
    private class b extends e.i.a.b {
        private b() {
        }

        @Override // e.i.a.b
        protected void B() {
            g.this.f10915e = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            obtain.setAction(3);
            if (g.this.f10914d instanceof s) {
                ((s) g.this.f10914d).onChildStartedNativeGesture(obtain);
            } else {
                com.facebook.react.views.modal.c.a(g.this.f10914d, obtain);
            }
        }

        @Override // e.i.a.b
        protected void C(MotionEvent motionEvent) {
            if (p() == 0) {
                c();
                g.this.f10915e = false;
            }
            if (motionEvent.getActionMasked() == 1) {
                g();
            }
        }

        /* synthetic */ b(g gVar, a aVar) {
            this();
        }
    }

    public g(ReactContext reactContext, ViewGroup viewGroup) {
        UiThreadUtil.assertOnUiThread();
        int id = viewGroup.getId();
        if (id >= 1) {
            RNGestureHandlerModule rNGestureHandlerModule = (RNGestureHandlerModule) reactContext.getNativeModule(RNGestureHandlerModule.class);
            f registry = rNGestureHandlerModule.getRegistry();
            ViewGroup e2 = e(viewGroup);
            this.f10914d = e2;
            Log.i("ReactNative", "[GESTURE HANDLER] Initialize gesture handler for root view " + e2);
            this.a = reactContext;
            e.i.a.d dVar = new e.i.a.d(viewGroup, registry, new j());
            this.f10912b = dVar;
            dVar.w(0.1f);
            b bVar = new b(this, null);
            this.f10913c = bVar;
            bVar.M(-id);
            registry.h(bVar);
            registry.b(bVar.q(), id);
            rNGestureHandlerModule.registerRootHelper(this);
            return;
        }
        throw new IllegalStateException("Expect view tag to be set for " + viewGroup);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
        return (android.view.ViewGroup) r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.view.ViewGroup e(android.view.ViewGroup r3) {
        /*
            com.facebook.react.bridge.UiThreadUtil.assertOnUiThread()
            r0 = r3
        L4:
            if (r0 == 0) goto L15
            boolean r1 = r0 instanceof e.f.m.s
            if (r1 != 0) goto L15
            boolean r1 = com.facebook.react.views.modal.c.b(r0)
            if (r1 != 0) goto L15
            android.view.ViewParent r0 = r0.getParent()
            goto L4
        L15:
            if (r0 == 0) goto L1a
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            return r0
        L1a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "View "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = " has not been mounted under ReactRootView"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.react.g.e(android.view.ViewGroup):android.view.ViewGroup");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        e.i.a.b bVar = this.f10913c;
        if (bVar == null || bVar.p() != 2) {
            return;
        }
        this.f10913c.a();
        this.f10913c.g();
    }

    public boolean d(MotionEvent motionEvent) {
        this.f10916f = true;
        this.f10912b.s(motionEvent);
        this.f10916f = false;
        return this.f10915e;
    }

    public ViewGroup f() {
        return this.f10914d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i2, boolean z) {
        if (z) {
            UiThreadUtil.runOnUiThread(new a());
        }
    }

    public void h(boolean z) {
        if (this.f10912b == null || this.f10916f) {
            return;
        }
        j();
    }

    public void i() {
        Log.i("ReactNative", "[GESTURE HANDLER] Tearing down gesture handler registered for root view " + this.f10914d);
        RNGestureHandlerModule rNGestureHandlerModule = (RNGestureHandlerModule) this.a.getNativeModule(RNGestureHandlerModule.class);
        rNGestureHandlerModule.getRegistry().e(this.f10913c.q());
        rNGestureHandlerModule.unregisterRootHelper(this);
    }
}