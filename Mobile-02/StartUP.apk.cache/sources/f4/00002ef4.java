package com.facebook.react.uimanager.events;

import android.util.LongSparseArray;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.a;
import com.facebook.react.modules.core.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: EventDispatcher.java */
/* loaded from: classes2.dex */
public class d implements LifecycleEventListener {
    private static final Comparator<com.facebook.react.uimanager.events.c> a = new a();

    /* renamed from: d  reason: collision with root package name */
    private final ReactApplicationContext f5058d;
    private volatile ReactEventEmitter q;

    /* renamed from: b  reason: collision with root package name */
    private final Object f5056b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final Object f5057c = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final LongSparseArray<Integer> f5059e = new LongSparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Short> f5060f = com.facebook.react.common.c.b();

    /* renamed from: g  reason: collision with root package name */
    private final c f5061g = new c(this, null);

    /* renamed from: h  reason: collision with root package name */
    private final ArrayList<com.facebook.react.uimanager.events.c> f5062h = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private final ArrayList<e> f5063j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private final List<com.facebook.react.uimanager.events.a> f5064k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private final C0123d f5065l = new C0123d(this, null);
    private final AtomicInteger m = new AtomicInteger();
    private com.facebook.react.uimanager.events.c[] n = new com.facebook.react.uimanager.events.c[16];
    private int p = 0;
    private short t = 0;
    private volatile boolean u = false;

    /* compiled from: EventDispatcher.java */
    /* loaded from: classes2.dex */
    static class a implements Comparator<com.facebook.react.uimanager.events.c> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.facebook.react.uimanager.events.c cVar, com.facebook.react.uimanager.events.c cVar2) {
            if (cVar == null && cVar2 == null) {
                return 0;
            }
            if (cVar == null) {
                return -1;
            }
            if (cVar2 == null) {
                return 1;
            }
            int i2 = ((cVar.g() - cVar2.g()) > 0L ? 1 : ((cVar.g() - cVar2.g()) == 0L ? 0 : -1));
            if (i2 == 0) {
                return 0;
            }
            return i2 < 0 ? -1 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventDispatcher.java */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.C();
        }
    }

    /* compiled from: EventDispatcher.java */
    /* loaded from: classes2.dex */
    private class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.facebook.systrace.a.c(0L, "DispatchEventsRunnable");
            try {
                com.facebook.systrace.a.d(0L, "ScheduleDispatchFrameCallback", d.this.m.getAndIncrement());
                d.this.u = false;
                e.f.k.a.a.c(d.this.q);
                synchronized (d.this.f5057c) {
                    if (d.this.p > 0) {
                        if (d.this.p > 1) {
                            Arrays.sort(d.this.n, 0, d.this.p, d.a);
                        }
                        for (int i2 = 0; i2 < d.this.p; i2++) {
                            com.facebook.react.uimanager.events.c cVar = d.this.n[i2];
                            if (cVar != null) {
                                com.facebook.systrace.a.d(0L, cVar.f(), cVar.h());
                                cVar.c(d.this.q);
                                cVar.d();
                            }
                        }
                        d.this.t();
                        d.this.f5059e.clear();
                    }
                }
                for (com.facebook.react.uimanager.events.a aVar : d.this.f5064k) {
                    aVar.a();
                }
            } finally {
                com.facebook.systrace.a.g(0L);
            }
        }

        /* synthetic */ c(d dVar, a aVar) {
            this();
        }
    }

    public d(ReactApplicationContext reactApplicationContext) {
        this.f5058d = reactApplicationContext;
        reactApplicationContext.addLifecycleEventListener(this);
        this.q = new ReactEventEmitter(reactApplicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        UiThreadUtil.assertOnUiThread();
        this.f5065l.f();
    }

    private void r(com.facebook.react.uimanager.events.c cVar) {
        int i2 = this.p;
        com.facebook.react.uimanager.events.c[] cVarArr = this.n;
        if (i2 == cVarArr.length) {
            this.n = (com.facebook.react.uimanager.events.c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        com.facebook.react.uimanager.events.c[] cVarArr2 = this.n;
        int i3 = this.p;
        this.p = i3 + 1;
        cVarArr2[i3] = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Arrays.fill(this.n, 0, this.p, (Object) null);
        this.p = 0;
    }

    private long w(int i2, String str, short s) {
        short s2;
        Short sh = this.f5060f.get(str);
        if (sh != null) {
            s2 = sh.shortValue();
        } else {
            short s3 = this.t;
            this.t = (short) (s3 + 1);
            this.f5060f.put(str, Short.valueOf(s3));
            s2 = s3;
        }
        return x(i2, s2, s);
    }

    private static long x(int i2, short s, short s2) {
        return ((s & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | i2 | ((s2 & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48);
    }

    private void y() {
        if (this.q != null) {
            this.f5065l.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        synchronized (this.f5056b) {
            synchronized (this.f5057c) {
                for (int i2 = 0; i2 < this.f5062h.size(); i2++) {
                    com.facebook.react.uimanager.events.c cVar = this.f5062h.get(i2);
                    if (!cVar.a()) {
                        r(cVar);
                    } else {
                        long w = w(cVar.i(), cVar.f(), cVar.e());
                        Integer num = this.f5059e.get(w);
                        com.facebook.react.uimanager.events.c cVar2 = null;
                        if (num == null) {
                            this.f5059e.put(w, Integer.valueOf(this.p));
                        } else {
                            com.facebook.react.uimanager.events.c cVar3 = this.n[num.intValue()];
                            com.facebook.react.uimanager.events.c b2 = cVar.b(cVar3);
                            if (b2 != cVar3) {
                                this.f5059e.put(w, Integer.valueOf(this.p));
                                this.n[num.intValue()] = null;
                                cVar2 = cVar3;
                                cVar = b2;
                            } else {
                                cVar2 = cVar;
                                cVar = null;
                            }
                        }
                        if (cVar != null) {
                            r(cVar);
                        }
                        if (cVar2 != null) {
                            cVar2.d();
                        }
                    }
                }
            }
            this.f5062h.clear();
        }
    }

    public void A() {
        UiThreadUtil.runOnUiThread(new b());
    }

    public void B(int i2, RCTEventEmitter rCTEventEmitter) {
        this.q.register(i2, rCTEventEmitter);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        C();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        C();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        y();
    }

    public void q(com.facebook.react.uimanager.events.a aVar) {
        this.f5064k.add(aVar);
    }

    public void s(e eVar) {
        this.f5063j.add(eVar);
    }

    public void u() {
        y();
    }

    public void v(com.facebook.react.uimanager.events.c cVar) {
        e.f.k.a.a.b(cVar.k(), "Dispatched event hasn't been initialized");
        Iterator<e> it = this.f5063j.iterator();
        while (it.hasNext()) {
            it.next().a(cVar);
        }
        synchronized (this.f5056b) {
            this.f5062h.add(cVar);
            com.facebook.systrace.a.j(0L, cVar.f(), cVar.h());
        }
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EventDispatcher.java */
    /* renamed from: com.facebook.react.uimanager.events.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0123d extends a.AbstractC0115a {

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f5066b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f5067c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: EventDispatcher.java */
        /* renamed from: com.facebook.react.uimanager.events.d$d$a */
        /* loaded from: classes2.dex */
        public class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0123d.this.c();
            }
        }

        private C0123d() {
            this.f5066b = false;
            this.f5067c = false;
        }

        private void e() {
            com.facebook.react.modules.core.g.i().m(g.c.TIMERS_EVENTS, d.this.f5065l);
        }

        @Override // com.facebook.react.modules.core.a.AbstractC0115a
        public void a(long j2) {
            UiThreadUtil.assertOnUiThread();
            if (this.f5067c) {
                this.f5066b = false;
            } else {
                e();
            }
            com.facebook.systrace.a.c(0L, "ScheduleDispatchFrameCallback");
            try {
                d.this.z();
                if (!d.this.u) {
                    d.this.u = true;
                    com.facebook.systrace.a.j(0L, "ScheduleDispatchFrameCallback", d.this.m.get());
                    d.this.f5058d.runOnJSQueueThread(d.this.f5061g);
                }
            } finally {
                com.facebook.systrace.a.g(0L);
            }
        }

        public void c() {
            if (this.f5066b) {
                return;
            }
            this.f5066b = true;
            e();
        }

        public void d() {
            if (this.f5066b) {
                return;
            }
            if (!d.this.f5058d.isOnUiQueueThread()) {
                d.this.f5058d.runOnUiQueueThread(new a());
            } else {
                c();
            }
        }

        public void f() {
            this.f5067c = true;
        }

        /* synthetic */ C0123d(d dVar, a aVar) {
            this();
        }
    }
}