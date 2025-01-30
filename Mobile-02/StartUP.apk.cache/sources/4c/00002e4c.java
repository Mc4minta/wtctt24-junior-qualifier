package com.facebook.react.modules.core;

import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.modules.core.a;
import com.facebook.react.modules.core.g;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: JavaTimerManager.java */
/* loaded from: classes2.dex */
public class d {
    private final ReactApplicationContext a;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.react.modules.core.c f4876b;

    /* renamed from: c  reason: collision with root package name */
    private final g f4877c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.react.devsupport.g.c f4878d;
    private c m;

    /* renamed from: e  reason: collision with root package name */
    private final Object f4879e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private final Object f4880f = new Object();

    /* renamed from: i  reason: collision with root package name */
    private final AtomicBoolean f4883i = new AtomicBoolean(true);

    /* renamed from: j  reason: collision with root package name */
    private final AtomicBoolean f4884j = new AtomicBoolean(false);

    /* renamed from: k  reason: collision with root package name */
    private final f f4885k = new f(this, null);

    /* renamed from: l  reason: collision with root package name */
    private final C0117d f4886l = new C0117d(this, null);
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    /* renamed from: g  reason: collision with root package name */
    private final PriorityQueue<e> f4881g = new PriorityQueue<>(11, new a());

    /* renamed from: h  reason: collision with root package name */
    private final SparseArray<e> f4882h = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JavaTimerManager.java */
    /* loaded from: classes2.dex */
    public class a implements Comparator<e> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(e eVar, e eVar2) {
            int i2 = ((eVar.f4893d - eVar2.f4893d) > 0L ? 1 : ((eVar.f4893d - eVar2.f4893d) == 0L ? 0 : -1));
            if (i2 == 0) {
                return 0;
            }
            return i2 < 0 ? -1 : 1;
        }
    }

    /* compiled from: JavaTimerManager.java */
    /* loaded from: classes2.dex */
    class b implements Runnable {
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (d.this.f4880f) {
                if (this.a) {
                    d.this.C();
                } else {
                    d.this.o();
                }
            }
        }
    }

    /* compiled from: JavaTimerManager.java */
    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private volatile boolean a = false;

        /* renamed from: b  reason: collision with root package name */
        private final long f4888b;

        public c(long j2) {
            this.f4888b = j2;
        }

        public void a() {
            this.a = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            if (this.a) {
                return;
            }
            long c2 = com.facebook.react.common.f.c() - (this.f4888b / 1000000);
            long a = com.facebook.react.common.f.a() - c2;
            if (16.666666f - ((float) c2) < 1.0f) {
                return;
            }
            synchronized (d.this.f4880f) {
                z = d.this.p;
            }
            if (z) {
                d.this.f4876b.callIdleCallbacks(a);
            }
            d.this.m = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JavaTimerManager.java */
    /* renamed from: com.facebook.react.modules.core.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0117d extends a.AbstractC0115a {
        private C0117d() {
        }

        @Override // com.facebook.react.modules.core.a.AbstractC0115a
        public void a(long j2) {
            if (!d.this.f4883i.get() || d.this.f4884j.get()) {
                if (d.this.m != null) {
                    d.this.m.a();
                }
                d dVar = d.this;
                dVar.m = new c(j2);
                d.this.a.runOnJSQueueThread(d.this.m);
                d.this.f4877c.m(g.c.IDLE_EVENT, this);
            }
        }

        /* synthetic */ C0117d(d dVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JavaTimerManager.java */
    /* loaded from: classes2.dex */
    public static class e {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f4891b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4892c;

        /* renamed from: d  reason: collision with root package name */
        private long f4893d;

        /* synthetic */ e(int i2, long j2, int i3, boolean z, a aVar) {
            this(i2, j2, i3, z);
        }

        private e(int i2, long j2, int i3, boolean z) {
            this.a = i2;
            this.f4893d = j2;
            this.f4892c = i3;
            this.f4891b = z;
        }
    }

    public d(ReactApplicationContext reactApplicationContext, com.facebook.react.modules.core.c cVar, g gVar, com.facebook.react.devsupport.g.c cVar2) {
        this.a = reactApplicationContext;
        this.f4876b = cVar;
        this.f4877c = gVar;
        this.f4878d = cVar2;
    }

    private void B() {
        if (this.n) {
            return;
        }
        this.f4877c.m(g.c.TIMERS_EVENTS, this.f4885k);
        this.n = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (this.o) {
            return;
        }
        this.f4877c.m(g.c.IDLE_EVENT, this.f4886l);
        this.o = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.o) {
            this.f4877c.o(g.c.IDLE_EVENT, this.f4886l);
            this.o = false;
        }
    }

    private void p() {
        e.f.m.w.b e2 = e.f.m.w.b.e(this.a);
        if (this.n && this.f4883i.get() && !e2.f()) {
            this.f4877c.o(g.c.TIMERS_EVENTS, this.f4885k);
            this.n = false;
        }
    }

    private static boolean s(e eVar, long j2) {
        return !eVar.f4891b && ((long) eVar.f4892c) < j2;
    }

    private void t() {
        if (!this.f4883i.get() || this.f4884j.get()) {
            return;
        }
        p();
    }

    private void u() {
        synchronized (this.f4880f) {
            if (this.p) {
                C();
            }
        }
    }

    public void A() {
        p();
        o();
    }

    @e.f.l.a.a
    public void createTimer(int i2, long j2, boolean z) {
        e eVar = new e(i2, (com.facebook.react.common.f.b() / 1000000) + j2, (int) j2, z, null);
        synchronized (this.f4879e) {
            this.f4881g.add(eVar);
            this.f4882h.put(i2, eVar);
        }
    }

    @e.f.l.a.a
    public void deleteTimer(int i2) {
        synchronized (this.f4879e) {
            e eVar = this.f4882h.get(i2);
            if (eVar == null) {
                return;
            }
            this.f4882h.remove(i2);
            this.f4881g.remove(eVar);
        }
    }

    public void q(int i2, int i3, double d2, boolean z) {
        long a2 = com.facebook.react.common.f.a();
        long j2 = (long) d2;
        if (this.f4878d.b() && Math.abs(j2 - a2) > 60000) {
            this.f4876b.emitTimeDriftWarning("Debugger and device times have drifted by more than 60s. Please correct this by running adb shell \"date `date +%m%d%H%M%Y.%S`\" on your debugger machine.");
        }
        long max = Math.max(0L, (j2 - a2) + i3);
        if (i3 == 0 && !z) {
            WritableArray createArray = Arguments.createArray();
            createArray.pushInt(i2);
            this.f4876b.callTimers(createArray);
            return;
        }
        createTimer(i2, max, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(long j2) {
        synchronized (this.f4879e) {
            e peek = this.f4881g.peek();
            if (peek == null) {
                return false;
            }
            if (s(peek, j2)) {
                return true;
            }
            Iterator<e> it = this.f4881g.iterator();
            while (it.hasNext()) {
                if (s(it.next(), j2)) {
                    return true;
                }
            }
            return false;
        }
    }

    @e.f.l.a.a
    public void setSendIdleEvents(boolean z) {
        synchronized (this.f4880f) {
            this.p = z;
        }
        UiThreadUtil.runOnUiThread(new b(z));
    }

    public void v(int i2) {
        if (e.f.m.w.b.e(this.a).f()) {
            return;
        }
        this.f4884j.set(false);
        p();
        t();
    }

    public void w(int i2) {
        if (this.f4884j.getAndSet(true)) {
            return;
        }
        B();
        u();
    }

    public void x() {
        p();
        t();
    }

    public void y() {
        this.f4883i.set(true);
        p();
        t();
    }

    public void z() {
        this.f4883i.set(false);
        B();
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JavaTimerManager.java */
    /* loaded from: classes2.dex */
    public class f extends a.AbstractC0115a {

        /* renamed from: b  reason: collision with root package name */
        private WritableArray f4894b;

        private f() {
            this.f4894b = null;
        }

        @Override // com.facebook.react.modules.core.a.AbstractC0115a
        public void a(long j2) {
            if (!d.this.f4883i.get() || d.this.f4884j.get()) {
                long j3 = j2 / 1000000;
                synchronized (d.this.f4879e) {
                    while (!d.this.f4881g.isEmpty() && ((e) d.this.f4881g.peek()).f4893d < j3) {
                        e eVar = (e) d.this.f4881g.poll();
                        if (this.f4894b == null) {
                            this.f4894b = Arguments.createArray();
                        }
                        this.f4894b.pushInt(eVar.a);
                        if (eVar.f4891b) {
                            eVar.f4893d = eVar.f4892c + j3;
                            d.this.f4881g.add(eVar);
                        } else {
                            d.this.f4882h.remove(eVar.a);
                        }
                    }
                }
                if (this.f4894b != null) {
                    d.this.f4876b.callTimers(this.f4894b);
                    this.f4894b = null;
                }
                d.this.f4877c.m(g.c.TIMERS_EVENTS, this);
            }
        }

        /* synthetic */ f(d dVar, a aVar) {
            this();
        }
    }
}