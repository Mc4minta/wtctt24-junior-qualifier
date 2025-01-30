package com.facebook.react.modules.core;

import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.a;
import java.util.ArrayDeque;

/* compiled from: ReactChoreographer.java */
/* loaded from: classes2.dex */
public class g {
    private static g a;

    /* renamed from: b  reason: collision with root package name */
    private volatile com.facebook.react.modules.core.a f4896b;

    /* renamed from: d  reason: collision with root package name */
    private final Object f4898d = new Object();

    /* renamed from: f  reason: collision with root package name */
    private int f4900f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4901g = false;

    /* renamed from: c  reason: collision with root package name */
    private final d f4897c = new d(this, null);

    /* renamed from: e  reason: collision with root package name */
    private final ArrayDeque<a.AbstractC0115a>[] f4899e = new ArrayDeque[c.values().length];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReactChoreographer.java */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReactChoreographer.java */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        final /* synthetic */ Runnable a;

        b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (g.class) {
                if (g.this.f4896b == null) {
                    g.this.f4896b = com.facebook.react.modules.core.a.d();
                }
            }
            Runnable runnable = this.a;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* compiled from: ReactChoreographer.java */
    /* loaded from: classes2.dex */
    public enum c {
        PERF_MARKERS(0),
        DISPATCH_UI(1),
        NATIVE_ANIMATED_MODULE(2),
        TIMERS_EVENTS(3),
        IDLE_EVENT(4);
        

        /* renamed from: g  reason: collision with root package name */
        private final int f4908g;

        c(int i2) {
            this.f4908g = i2;
        }

        int h() {
            return this.f4908g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReactChoreographer.java */
    /* loaded from: classes2.dex */
    public class d extends a.AbstractC0115a {
        private d() {
        }

        @Override // com.facebook.react.modules.core.a.AbstractC0115a
        public void a(long j2) {
            synchronized (g.this.f4898d) {
                g.this.f4901g = false;
                for (int i2 = 0; i2 < g.this.f4899e.length; i2++) {
                    ArrayDeque arrayDeque = g.this.f4899e[i2];
                    int size = arrayDeque.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        a.AbstractC0115a abstractC0115a = (a.AbstractC0115a) arrayDeque.pollFirst();
                        if (abstractC0115a != null) {
                            abstractC0115a.a(j2);
                            g.g(g.this);
                        } else {
                            e.f.d.d.a.i("ReactNative", "Tried to execute non-existent frame callback");
                        }
                    }
                }
                g.this.l();
            }
        }

        /* synthetic */ d(g gVar, a aVar) {
            this();
        }
    }

    private g() {
        int i2 = 0;
        while (true) {
            ArrayDeque<a.AbstractC0115a>[] arrayDequeArr = this.f4899e;
            if (i2 < arrayDequeArr.length) {
                arrayDequeArr[i2] = new ArrayDeque<>();
                i2++;
            } else {
                k(null);
                return;
            }
        }
    }

    static /* synthetic */ int g(g gVar) {
        int i2 = gVar.f4900f;
        gVar.f4900f = i2 - 1;
        return i2;
    }

    public static g i() {
        e.f.k.a.a.d(a, "ReactChoreographer needs to be initialized.");
        return a;
    }

    public static void j() {
        if (a == null) {
            a = new g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        e.f.k.a.a.a(this.f4900f >= 0);
        if (this.f4900f == 0 && this.f4901g) {
            if (this.f4896b != null) {
                this.f4896b.f(this.f4897c);
            }
            this.f4901g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.f4896b.e(this.f4897c);
        this.f4901g = true;
    }

    public void k(Runnable runnable) {
        UiThreadUtil.runOnUiThread(new b(runnable));
    }

    public void m(c cVar, a.AbstractC0115a abstractC0115a) {
        synchronized (this.f4898d) {
            this.f4899e[cVar.h()].addLast(abstractC0115a);
            boolean z = true;
            int i2 = this.f4900f + 1;
            this.f4900f = i2;
            if (i2 <= 0) {
                z = false;
            }
            e.f.k.a.a.a(z);
            if (!this.f4901g) {
                if (this.f4896b == null) {
                    k(new a());
                } else {
                    n();
                }
            }
        }
    }

    public void o(c cVar, a.AbstractC0115a abstractC0115a) {
        synchronized (this.f4898d) {
            if (this.f4899e[cVar.h()].removeFirstOccurrence(abstractC0115a)) {
                this.f4900f--;
                l();
            } else {
                e.f.d.d.a.i("ReactNative", "Tried to remove non-existent frame callback");
            }
        }
    }
}