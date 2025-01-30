package com.facebook.react.modules.debug;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.a;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: FpsDebugFrameCallback.java */
/* loaded from: classes2.dex */
public class b extends a.AbstractC0115a {

    /* renamed from: b  reason: collision with root package name */
    private com.facebook.react.modules.core.a f4921b;

    /* renamed from: c  reason: collision with root package name */
    private final ReactContext f4922c;

    /* renamed from: d  reason: collision with root package name */
    private final UIManagerModule f4923d;
    private TreeMap<Long, C0119b> n;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4925f = false;

    /* renamed from: g  reason: collision with root package name */
    private long f4926g = -1;

    /* renamed from: h  reason: collision with root package name */
    private long f4927h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f4928i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f4929j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f4930k = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f4931l = 0;
    private boolean m = false;

    /* renamed from: e  reason: collision with root package name */
    private final com.facebook.react.modules.debug.a f4924e = new com.facebook.react.modules.debug.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FpsDebugFrameCallback.java */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f4921b = com.facebook.react.modules.core.a.d();
            b.this.f4921b.e(this.a);
        }
    }

    /* compiled from: FpsDebugFrameCallback.java */
    /* renamed from: com.facebook.react.modules.debug.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0119b {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4933b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4934c;

        /* renamed from: d  reason: collision with root package name */
        public final int f4935d;

        /* renamed from: e  reason: collision with root package name */
        public final double f4936e;

        /* renamed from: f  reason: collision with root package name */
        public final double f4937f;

        /* renamed from: g  reason: collision with root package name */
        public final int f4938g;

        public C0119b(int i2, int i3, int i4, int i5, double d2, double d3, int i6) {
            this.a = i2;
            this.f4933b = i3;
            this.f4934c = i4;
            this.f4935d = i5;
            this.f4936e = d2;
            this.f4937f = d3;
            this.f4938g = i6;
        }
    }

    public b(ReactContext reactContext) {
        this.f4922c = reactContext;
        this.f4923d = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
    }

    @Override // com.facebook.react.modules.core.a.AbstractC0115a
    public void a(long j2) {
        if (this.f4925f) {
            return;
        }
        if (this.f4926g == -1) {
            this.f4926g = j2;
        }
        long j3 = this.f4927h;
        this.f4927h = j2;
        if (this.f4924e.e(j3, j2)) {
            this.f4931l++;
        }
        this.f4928i++;
        int e2 = e();
        if ((e2 - this.f4929j) - 1 >= 4) {
            this.f4930k++;
        }
        if (this.m) {
            e.f.k.a.a.c(this.n);
            this.n.put(Long.valueOf(System.currentTimeMillis()), new C0119b(i(), j(), e2, this.f4930k, f(), h(), k()));
        }
        this.f4929j = e2;
        com.facebook.react.modules.core.a aVar = this.f4921b;
        if (aVar != null) {
            aVar.e(this);
        }
    }

    public int e() {
        return (int) ((k() / 16.9d) + 1.0d);
    }

    public double f() {
        if (this.f4927h == this.f4926g) {
            return 0.0d;
        }
        return (i() * 1.0E9d) / (this.f4927h - this.f4926g);
    }

    public C0119b g(long j2) {
        e.f.k.a.a.d(this.n, "FPS was not recorded at each frame!");
        Map.Entry<Long, C0119b> floorEntry = this.n.floorEntry(Long.valueOf(j2));
        if (floorEntry == null) {
            return null;
        }
        return floorEntry.getValue();
    }

    public double h() {
        if (this.f4927h == this.f4926g) {
            return 0.0d;
        }
        return (j() * 1.0E9d) / (this.f4927h - this.f4926g);
    }

    public int i() {
        return this.f4928i - 1;
    }

    public int j() {
        return this.f4931l - 1;
    }

    public int k() {
        return ((int) (this.f4927h - this.f4926g)) / 1000000;
    }

    public void l() {
        this.f4925f = false;
        this.f4922c.getCatalystInstance().addBridgeIdleDebugListener(this.f4924e);
        this.f4923d.setViewHierarchyUpdateDebugListener(this.f4924e);
        UiThreadUtil.runOnUiThread(new a(this));
    }

    public void m() {
        this.n = new TreeMap<>();
        this.m = true;
        l();
    }

    public void n() {
        this.f4925f = true;
        this.f4922c.getCatalystInstance().removeBridgeIdleDebugListener(this.f4924e);
        this.f4923d.setViewHierarchyUpdateDebugListener(null);
    }
}