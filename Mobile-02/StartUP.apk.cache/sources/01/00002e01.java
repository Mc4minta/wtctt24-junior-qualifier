package com.facebook.react.fabric;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.View;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.events.FabricEventEmitter;
import com.facebook.react.fabric.mounting.mountitems.BatchMountItem;
import com.facebook.react.fabric.mounting.mountitems.e;
import com.facebook.react.fabric.mounting.mountitems.f;
import com.facebook.react.fabric.mounting.mountitems.g;
import com.facebook.react.fabric.mounting.mountitems.h;
import com.facebook.react.fabric.mounting.mountitems.i;
import com.facebook.react.fabric.mounting.mountitems.j;
import com.facebook.react.fabric.mounting.mountitems.k;
import com.facebook.react.fabric.mounting.mountitems.l;
import com.facebook.react.fabric.mounting.mountitems.m;
import com.facebook.react.fabric.mounting.mountitems.n;
import com.facebook.react.fabric.mounting.mountitems.o;
import com.facebook.react.fabric.mounting.mountitems.p;
import com.facebook.react.fabric.mounting.mountitems.q;
import com.facebook.react.modules.core.g;
import com.facebook.react.uimanager.h0;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.w;
import com.facebook.react.uimanager.x;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: FabricUIManager.java */
@SuppressLint({"MissingNativeLoadLibrary"})
/* loaded from: classes2.dex */
public class c implements UIManager, LifecycleEventListener {
    public static final boolean a;
    private long A;
    private long B;
    private int C;

    /* renamed from: b  reason: collision with root package name */
    private Binding f4793b;

    /* renamed from: c  reason: collision with root package name */
    private final ReactApplicationContext f4794c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.react.fabric.e.b f4795d;

    /* renamed from: e  reason: collision with root package name */
    private final com.facebook.react.uimanager.events.d f4796e;

    /* renamed from: f  reason: collision with root package name */
    private final ConcurrentHashMap<Integer, i0> f4797f;

    /* renamed from: g  reason: collision with root package name */
    private final EventBeatManager f4798g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f4799h;

    /* renamed from: j  reason: collision with root package name */
    private final Object f4800j;

    /* renamed from: k  reason: collision with root package name */
    private final Object f4801k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4802l;
    private int m;
    private List<com.facebook.react.fabric.mounting.mountitems.c> n;
    private List<g> p;
    private ArrayDeque<g> q;
    private final C0114c t;
    private volatile boolean u;
    private long v;
    private long w;
    private long x;
    private long y;
    private long z;

    /* compiled from: FabricUIManager.java */
    /* loaded from: classes2.dex */
    class a implements g {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f4803b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f4804c;

        a(int i2, int i3, boolean z) {
            this.a = i2;
            this.f4803b = i3;
            this.f4804c = z;
        }

        @Override // com.facebook.react.fabric.mounting.mountitems.g
        public void a(com.facebook.react.fabric.e.b bVar) {
            throw null;
        }
    }

    /* compiled from: FabricUIManager.java */
    /* loaded from: classes2.dex */
    class b implements g {
        b() {
        }

        @Override // com.facebook.react.fabric.mounting.mountitems.g
        public void a(com.facebook.react.fabric.e.b bVar) {
            throw null;
        }
    }

    /* compiled from: FabricUIManager.java */
    /* renamed from: com.facebook.react.fabric.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0114c extends d {
    }

    static {
        a = e.f.m.v.a.f12888b || e.f.f.b.c.a().a(e.f.f.c.a.f12131g);
        com.facebook.react.fabric.b.a();
    }

    private void a(com.facebook.react.fabric.mounting.mountitems.c cVar) {
        if (e.f.m.v.a.f12892f) {
            synchronized (this.f4799h) {
                this.n.add(cVar);
            }
            return;
        }
        synchronized (this.f4800j) {
            this.p.add(cVar);
        }
    }

    private boolean b() {
        if (this.m == 0) {
            this.w = 0L;
        }
        this.v = SystemClock.uptimeMillis();
        List<com.facebook.react.fabric.mounting.mountitems.c> e2 = e();
        List<g> c2 = c();
        if (c2 == null && e2 == null) {
            return false;
        }
        if (e2 != null) {
            com.facebook.systrace.a.c(0L, "FabricUIManager::mountViews viewCommandMountItems to execute: " + e2.size());
            for (com.facebook.react.fabric.mounting.mountitems.c cVar : e2) {
                if (a) {
                    e.f.d.d.a.b("FabricUIManager", "dispatchMountItems: Executing viewCommandMountItem: " + cVar.toString());
                }
                try {
                    cVar.a(this.f4795d);
                } catch (RetryableMountingLayerException e3) {
                    if (cVar.b() == 0) {
                        cVar.c();
                        a(cVar);
                    } else {
                        ReactSoftException.logSoftException("FabricUIManager", new ReactNoCrashSoftException("Caught exception executing ViewCommand: " + cVar.toString(), e3));
                    }
                } catch (Throwable th) {
                    ReactSoftException.logSoftException("FabricUIManager", new RuntimeException("Caught exception executing ViewCommand: " + cVar.toString(), th));
                }
            }
            com.facebook.systrace.a.g(0L);
        }
        ArrayDeque<g> d2 = d();
        if (d2 != null) {
            com.facebook.systrace.a.c(0L, "FabricUIManager::mountViews preMountItems to execute: " + d2.size());
            while (!d2.isEmpty()) {
                d2.pollFirst().a(this.f4795d);
            }
            com.facebook.systrace.a.g(0L);
        }
        if (c2 != null) {
            com.facebook.systrace.a.c(0L, "FabricUIManager::mountViews mountItems to execute: " + c2.size());
            long uptimeMillis = SystemClock.uptimeMillis();
            for (g gVar : c2) {
                if (a) {
                    for (String str : gVar.toString().split("\n")) {
                        e.f.d.d.a.b("FabricUIManager", "dispatchMountItems: Executing mountItem: " + str);
                    }
                }
                gVar.a(this.f4795d);
            }
            this.w += SystemClock.uptimeMillis() - uptimeMillis;
        }
        com.facebook.systrace.a.g(0L);
        return true;
    }

    private List<g> c() {
        synchronized (this.f4800j) {
            List<g> list = this.p;
            if (list.isEmpty()) {
                return null;
            }
            this.p = new ArrayList();
            return list;
        }
    }

    @e.f.l.a.a
    private g createBatchMountItem(g[] gVarArr, int i2, int i3) {
        return new BatchMountItem(gVarArr, i2, i3);
    }

    @e.f.l.a.a
    private g createMountItem(String str, ReadableMap readableMap, Object obj, int i2, int i3, boolean z) {
        String a2 = com.facebook.react.fabric.a.a(str);
        i0 i0Var = this.f4797f.get(Integer.valueOf(i2));
        if (i0Var != null) {
            return new com.facebook.react.fabric.mounting.mountitems.a(i0Var, i2, i3, a2, readableMap, (h0) obj, z);
        }
        throw new IllegalArgumentException("Unable to find ReactContext for root: " + i2);
    }

    private ArrayDeque<g> d() {
        synchronized (this.f4801k) {
            ArrayDeque<g> arrayDeque = this.q;
            if (arrayDeque.isEmpty()) {
                return null;
            }
            this.q = new ArrayDeque<>(250);
            return arrayDeque;
        }
    }

    @e.f.l.a.a
    private g deleteMountItem(int i2) {
        return new com.facebook.react.fabric.mounting.mountitems.b(i2);
    }

    private List<com.facebook.react.fabric.mounting.mountitems.c> e() {
        if (e.f.m.v.a.f12892f) {
            synchronized (this.f4799h) {
                List<com.facebook.react.fabric.mounting.mountitems.c> list = this.n;
                if (list.isEmpty()) {
                    return null;
                }
                this.n = new ArrayList();
                return list;
            }
        }
        return null;
    }

    private void h() {
        if (this.f4802l) {
            return;
        }
        try {
            boolean b2 = b();
            this.f4802l = false;
            int i2 = this.m;
            if (i2 < 10 && b2) {
                if (i2 > 2) {
                    ReactSoftException.logSoftException("FabricUIManager", new ReactNoCrashSoftException("Re-dispatched " + this.m + " times. This indicates setState (?) is likely being called too many times during mounting."));
                }
                this.m++;
                h();
            }
            this.m = 0;
        } finally {
        }
    }

    @e.f.l.a.a
    private g insertMountItem(int i2, int i3, int i4) {
        return new f(i2, i3, i4);
    }

    @e.f.l.a.a
    private long measure(int i2, String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, float f3, float f4, float f5) {
        return measure(i2, str, readableMap, readableMap2, readableMap3, f2, f3, f4, f5, null);
    }

    @e.f.l.a.a
    private void preallocateView(int i2, int i3, String str, ReadableMap readableMap, Object obj, boolean z) {
        i0 i0Var = this.f4797f.get(Integer.valueOf(i2));
        String a2 = com.facebook.react.fabric.a.a(str);
        synchronized (this.f4801k) {
            this.q.add(new h(i0Var, i2, i3, a2, readableMap, (h0) obj, z));
        }
    }

    @e.f.l.a.a
    private g removeDeleteMultiMountItem(int[] iArr) {
        return new i(iArr);
    }

    @e.f.l.a.a
    private g removeMountItem(int i2, int i3, int i4) {
        return new j(i2, i3, i4);
    }

    @e.f.l.a.a
    private void scheduleMountItem(g gVar, int i2, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        boolean z = gVar instanceof BatchMountItem;
        if (z) {
            this.y = j2;
            this.z = j6 - j5;
            this.B = j8 - j7;
            this.A = SystemClock.uptimeMillis() - j7;
            this.x = SystemClock.uptimeMillis();
        }
        synchronized (this.f4800j) {
            this.p.add(gVar);
        }
        if (UiThreadUtil.isOnUiThread()) {
            h();
        }
        if (z) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_COMMIT_START, null, i2, j2);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_START, null, i2, j7);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_END, null, i2, j8);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_DIFF_START, null, i2, j3);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_DIFF_END, null, i2, j4);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_LAYOUT_START, null, i2, j5);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_LAYOUT_END, null, i2, j6);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_COMMIT_END, null, i2);
        }
    }

    @e.f.l.a.a
    private g updateEventEmitterMountItem(int i2, Object obj) {
        return new l(i2, (EventEmitterWrapper) obj);
    }

    @e.f.l.a.a
    private g updateLayoutMountItem(int i2, int i3, int i4, int i5, int i6, int i7) {
        return new m(i2, i3, i4, i5, i6, i7);
    }

    @e.f.l.a.a
    private g updateLocalDataMountItem(int i2, ReadableMap readableMap) {
        return new n(i2, readableMap);
    }

    @e.f.l.a.a
    private g updatePaddingMountItem(int i2, int i3, int i4, int i5, int i6) {
        return new o(i2, i3, i4, i5, i6);
    }

    @e.f.l.a.a
    private g updatePropsMountItem(int i2, ReadableMap readableMap) {
        return new p(i2, readableMap);
    }

    @e.f.l.a.a
    private g updateStateMountItem(int i2, Object obj) {
        return new q(i2, (h0) obj);
    }

    @Override // com.facebook.react.bridge.UIManager
    public <T extends View> int addRootView(T t, WritableMap writableMap, String str) {
        x.a();
        new i0(this.f4794c, t.getContext(), ((w) t).getSurfaceID());
        throw null;
    }

    @e.f.l.a.a
    public void clearJSResponder() {
        synchronized (this.f4800j) {
            this.p.add(new b());
        }
    }

    @Override // com.facebook.react.bridge.UIManager
    @Deprecated
    public void dispatchCommand(int i2, int i3, ReadableArray readableArray) {
        a(new com.facebook.react.fabric.mounting.mountitems.d(i2, i3, readableArray));
    }

    @Override // com.facebook.react.bridge.UIManager
    /* renamed from: f */
    public com.facebook.react.uimanager.events.d getEventDispatcher() {
        return this.f4796e;
    }

    public void g(int i2, String str, WritableMap writableMap) {
        throw null;
    }

    @Override // com.facebook.react.bridge.PerformanceCounter
    public Map<String, Long> getPerformanceCounters() {
        HashMap hashMap = new HashMap();
        hashMap.put("CommitStartTime", Long.valueOf(this.y));
        hashMap.put("LayoutTime", Long.valueOf(this.z));
        hashMap.put("DispatchViewUpdatesTime", Long.valueOf(this.x));
        hashMap.put("RunStartTime", Long.valueOf(this.v));
        hashMap.put("BatchedExecutionTime", Long.valueOf(this.w));
        hashMap.put("FinishFabricTransactionTime", Long.valueOf(this.A));
        hashMap.put("FinishFabricTransactionCPPTime", Long.valueOf(this.B));
        return hashMap;
    }

    @Override // com.facebook.react.bridge.JSIModule
    public void initialize() {
        this.f4796e.B(2, new FabricEventEmitter(this));
        this.f4796e.q(this.f4798g);
    }

    @Override // com.facebook.react.bridge.JSIModule
    public void onCatalystInstanceDestroy() {
        e.f.d.d.a.n("FabricUIManager", "FabricUIManager.onCatalystInstanceDestroy");
        if (this.u) {
            ReactSoftException.logSoftException("FabricUIManager", new IllegalStateException("Cannot double-destroy FabricUIManager"));
        } else {
            this.u = true;
            throw null;
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        com.facebook.react.modules.core.g.i().o(g.c.DISPATCH_UI, this.t);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        com.facebook.react.modules.core.g.i().m(g.c.DISPATCH_UI, this.t);
    }

    @e.f.l.a.a
    public void onRequestEventBeat() {
        this.f4796e.u();
    }

    @Override // com.facebook.react.bridge.PerformanceCounter
    public void profileNextBatch() {
    }

    @Override // com.facebook.react.bridge.UIManager
    public void sendAccessibilityEvent(int i2, int i3) {
        synchronized (this.f4800j) {
            this.p.add(new k(i2, i3));
        }
    }

    @e.f.l.a.a
    public void setJSResponder(int i2, int i3, boolean z) {
        synchronized (this.f4800j) {
            this.p.add(new a(i2, i3, z));
        }
    }

    @Override // com.facebook.react.bridge.UIManager
    public void synchronouslyUpdateViewOnUIThread(int i2, ReadableMap readableMap) {
        int i3;
        String str;
        ReactMarkerConstants reactMarkerConstants;
        UiThreadUtil.assertOnUiThread();
        long uptimeMillis = SystemClock.uptimeMillis();
        int i4 = this.C;
        this.C = i4 + 1;
        String str2 = null;
        try {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_START, null, i4);
            if (a) {
                e.f.d.d.a.c("FabricUIManager", "SynchronouslyUpdateViewOnUIThread for tag %d", Integer.valueOf(i2));
            }
            str = "FabricUIManager";
        } catch (Exception e2) {
            e = e2;
            i3 = i4;
            str = "FabricUIManager";
        } catch (Throwable th) {
            th = th;
            i3 = i4;
        }
        try {
            scheduleMountItem(updatePropsMountItem(i2, readableMap), i4, uptimeMillis, 0L, 0L, 0L, 0L, 0L, 0L);
            reactMarkerConstants = ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END;
            i3 = i4;
            str2 = null;
        } catch (Exception e3) {
            e = e3;
            i3 = i4;
            str2 = null;
            try {
                ReactSoftException.logSoftException(str, new ReactNoCrashSoftException("Caught exception in synchronouslyUpdateViewOnUIThread", e));
                reactMarkerConstants = ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END;
                ReactMarker.logFabricMarker(reactMarkerConstants, str2, i3);
            } catch (Throwable th2) {
                th = th2;
                ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END, str2, i3);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            i3 = i4;
            str2 = null;
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END, str2, i3);
            throw th;
        }
        ReactMarker.logFabricMarker(reactMarkerConstants, str2, i3);
    }

    @Override // com.facebook.react.bridge.UIManager
    public void updateRootLayoutSpecs(int i2, int i3, int i4) {
        boolean z;
        boolean z2;
        if (a) {
            e.f.d.d.a.b("FabricUIManager", "Updating Root Layout Specs");
        }
        i0 i0Var = this.f4797f.get(Integer.valueOf(i2));
        if (i0Var != null) {
            boolean g2 = com.facebook.react.modules.i18nmanager.a.d().g(i0Var);
            z2 = com.facebook.react.modules.i18nmanager.a.d().b(i0Var);
            z = g2;
        } else {
            ReactSoftException.logSoftException("FabricUIManager", new IllegalStateException("updateRootLayoutSpecs called before ReactContext set for tag: " + i2));
            z = false;
            z2 = false;
        }
        this.f4793b.setConstraints(i2, com.facebook.react.fabric.e.a.b(i3), com.facebook.react.fabric.e.a.a(i3), com.facebook.react.fabric.e.a.b(i4), com.facebook.react.fabric.e.a.a(i4), z, z2);
    }

    @e.f.l.a.a
    private long measure(int i2, String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, float f3, float f4, float f5, int[] iArr) {
        if (i2 >= 0) {
            this.f4797f.get(Integer.valueOf(i2));
        }
        com.facebook.react.fabric.e.a.d(f2, f3);
        com.facebook.react.fabric.e.a.c(f2, f3);
        com.facebook.react.fabric.e.a.d(f4, f5);
        com.facebook.react.fabric.e.a.c(f4, f5);
        throw null;
    }

    @Override // com.facebook.react.bridge.UIManager
    public void dispatchCommand(int i2, String str, ReadableArray readableArray) {
        a(new e(i2, str, readableArray));
    }
}