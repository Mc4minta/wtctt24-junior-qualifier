package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class f implements Handler.Callback {
    public static final Status a = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* renamed from: b  reason: collision with root package name */
    private static final Status f6084b = new Status(4, "The user must be signed in to make this API call.");

    /* renamed from: c  reason: collision with root package name */
    private static final Object f6085c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static f f6086d;

    /* renamed from: h  reason: collision with root package name */
    private final Context f6090h;

    /* renamed from: i  reason: collision with root package name */
    private final com.google.android.gms.common.e f6091i;

    /* renamed from: j  reason: collision with root package name */
    private final com.google.android.gms.common.internal.k f6092j;
    private final Handler q;

    /* renamed from: e  reason: collision with root package name */
    private long f6087e = 5000;

    /* renamed from: f  reason: collision with root package name */
    private long f6088f = 120000;

    /* renamed from: g  reason: collision with root package name */
    private long f6089g = 10000;

    /* renamed from: k  reason: collision with root package name */
    private final AtomicInteger f6093k = new AtomicInteger(1);

    /* renamed from: l  reason: collision with root package name */
    private final AtomicInteger f6094l = new AtomicInteger(0);
    private final Map<com.google.android.gms.common.api.internal.b<?>, a<?>> m = new ConcurrentHashMap(5, 0.75f, 1);
    private r n = null;
    private final Set<com.google.android.gms.common.api.internal.b<?>> o = new c.e.b();
    private final Set<com.google.android.gms.common.api.internal.b<?>> p = new c.e.b();

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public class a<O extends a.d> implements d.a, d.b {

        /* renamed from: b  reason: collision with root package name */
        private final a.f f6095b;

        /* renamed from: c  reason: collision with root package name */
        private final a.b f6096c;

        /* renamed from: d  reason: collision with root package name */
        private final com.google.android.gms.common.api.internal.b<O> f6097d;

        /* renamed from: e  reason: collision with root package name */
        private final x0 f6098e;

        /* renamed from: h  reason: collision with root package name */
        private final int f6101h;

        /* renamed from: i  reason: collision with root package name */
        private final i0 f6102i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f6103j;
        private final Queue<g0> a = new LinkedList();

        /* renamed from: f  reason: collision with root package name */
        private final Set<r0> f6099f = new HashSet();

        /* renamed from: g  reason: collision with root package name */
        private final Map<j<?>, f0> f6100g = new HashMap();

        /* renamed from: k  reason: collision with root package name */
        private final List<c> f6104k = new ArrayList();

        /* renamed from: l  reason: collision with root package name */
        private com.google.android.gms.common.b f6105l = null;

        public a(com.google.android.gms.common.api.c<O> cVar) {
            a.f l2 = cVar.l(f.this.q.getLooper(), this);
            this.f6095b = l2;
            if (l2 instanceof com.google.android.gms.common.internal.w) {
                this.f6096c = ((com.google.android.gms.common.internal.w) l2).m0();
            } else {
                this.f6096c = l2;
            }
            this.f6097d = cVar.g();
            this.f6098e = new x0();
            this.f6101h = cVar.j();
            if (l2.p()) {
                this.f6102i = cVar.n(f.this.f6090h, f.this.q);
            } else {
                this.f6102i = null;
            }
        }

        private final void A() {
            if (this.f6103j) {
                f.this.q.removeMessages(11, this.f6097d);
                f.this.q.removeMessages(9, this.f6097d);
                this.f6103j = false;
            }
        }

        private final void B() {
            f.this.q.removeMessages(12, this.f6097d);
            f.this.q.sendMessageDelayed(f.this.q.obtainMessage(12, this.f6097d), f.this.f6089g);
        }

        private final void E(g0 g0Var) {
            g0Var.c(this.f6098e, d());
            try {
                g0Var.f(this);
            } catch (DeadObjectException unused) {
                n(1);
                this.f6095b.disconnect();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean F(boolean z) {
            com.google.android.gms.common.internal.t.d(f.this.q);
            if (this.f6095b.j() && this.f6100g.size() == 0) {
                if (!this.f6098e.d()) {
                    this.f6095b.disconnect();
                    return true;
                }
                if (z) {
                    B();
                }
                return false;
            }
            return false;
        }

        private final boolean K(com.google.android.gms.common.b bVar) {
            synchronized (f.f6085c) {
                if (f.this.n == null || !f.this.o.contains(this.f6097d)) {
                    return false;
                }
                f.this.n.n(bVar, this.f6101h);
                return true;
            }
        }

        private final void L(com.google.android.gms.common.b bVar) {
            for (r0 r0Var : this.f6099f) {
                String str = null;
                if (com.google.android.gms.common.internal.r.a(bVar, com.google.android.gms.common.b.a)) {
                    str = this.f6095b.e();
                }
                r0Var.a(this.f6097d, bVar, str);
            }
            this.f6099f.clear();
        }

        private final com.google.android.gms.common.d f(com.google.android.gms.common.d[] dVarArr) {
            if (dVarArr != null && dVarArr.length != 0) {
                com.google.android.gms.common.d[] o = this.f6095b.o();
                if (o == null) {
                    o = new com.google.android.gms.common.d[0];
                }
                c.e.a aVar = new c.e.a(o.length);
                for (com.google.android.gms.common.d dVar : o) {
                    aVar.put(dVar.i1(), Long.valueOf(dVar.j1()));
                }
                for (com.google.android.gms.common.d dVar2 : dVarArr) {
                    if (!aVar.containsKey(dVar2.i1()) || ((Long) aVar.get(dVar2.i1())).longValue() < dVar2.j1()) {
                        return dVar2;
                    }
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h(c cVar) {
            if (this.f6104k.contains(cVar) && !this.f6103j) {
                if (!this.f6095b.j()) {
                    a();
                } else {
                    v();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void r(c cVar) {
            com.google.android.gms.common.d[] g2;
            if (this.f6104k.remove(cVar)) {
                f.this.q.removeMessages(15, cVar);
                f.this.q.removeMessages(16, cVar);
                com.google.android.gms.common.d dVar = cVar.f6111b;
                ArrayList arrayList = new ArrayList(this.a.size());
                for (g0 g0Var : this.a) {
                    if ((g0Var instanceof u) && (g2 = ((u) g0Var).g(this)) != null && com.google.android.gms.common.util.b.b(g2, dVar)) {
                        arrayList.add(g0Var);
                    }
                }
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    g0 g0Var2 = (g0) obj;
                    this.a.remove(g0Var2);
                    g0Var2.d(new UnsupportedApiCallException(dVar));
                }
            }
        }

        private final boolean s(g0 g0Var) {
            if (!(g0Var instanceof u)) {
                E(g0Var);
                return true;
            }
            u uVar = (u) g0Var;
            com.google.android.gms.common.d f2 = f(uVar.g(this));
            if (f2 == null) {
                E(g0Var);
                return true;
            } else if (uVar.h(this)) {
                c cVar = new c(this.f6097d, f2, null);
                int indexOf = this.f6104k.indexOf(cVar);
                if (indexOf >= 0) {
                    c cVar2 = this.f6104k.get(indexOf);
                    f.this.q.removeMessages(15, cVar2);
                    f.this.q.sendMessageDelayed(Message.obtain(f.this.q, 15, cVar2), f.this.f6087e);
                    return false;
                }
                this.f6104k.add(cVar);
                f.this.q.sendMessageDelayed(Message.obtain(f.this.q, 15, cVar), f.this.f6087e);
                f.this.q.sendMessageDelayed(Message.obtain(f.this.q, 16, cVar), f.this.f6088f);
                com.google.android.gms.common.b bVar = new com.google.android.gms.common.b(2, null);
                if (K(bVar)) {
                    return false;
                }
                f.this.o(bVar, this.f6101h);
                return false;
            } else {
                uVar.d(new UnsupportedApiCallException(f2));
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void t() {
            y();
            L(com.google.android.gms.common.b.a);
            A();
            Iterator<f0> it = this.f6100g.values().iterator();
            if (!it.hasNext()) {
                v();
                B();
                return;
            }
            l<a.b, ?> lVar = it.next().a;
            throw null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void u() {
            y();
            this.f6103j = true;
            this.f6098e.f();
            f.this.q.sendMessageDelayed(Message.obtain(f.this.q, 9, this.f6097d), f.this.f6087e);
            f.this.q.sendMessageDelayed(Message.obtain(f.this.q, 11, this.f6097d), f.this.f6088f);
            f.this.f6092j.a();
        }

        private final void v() {
            ArrayList arrayList = new ArrayList(this.a);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                g0 g0Var = (g0) obj;
                if (!this.f6095b.j()) {
                    return;
                }
                if (s(g0Var)) {
                    this.a.remove(g0Var);
                }
            }
        }

        public final boolean C() {
            return F(true);
        }

        public final void D(Status status) {
            com.google.android.gms.common.internal.t.d(f.this.q);
            for (g0 g0Var : this.a) {
                g0Var.b(status);
            }
            this.a.clear();
        }

        public final void J(com.google.android.gms.common.b bVar) {
            com.google.android.gms.common.internal.t.d(f.this.q);
            this.f6095b.disconnect();
            p(bVar);
        }

        public final void a() {
            com.google.android.gms.common.internal.t.d(f.this.q);
            if (this.f6095b.j() || this.f6095b.d()) {
                return;
            }
            int b2 = f.this.f6092j.b(f.this.f6090h, this.f6095b);
            if (b2 != 0) {
                p(new com.google.android.gms.common.b(b2, null));
                return;
            }
            b bVar = new b(this.f6095b, this.f6097d);
            if (this.f6095b.p()) {
                this.f6102i.b1(bVar);
            }
            this.f6095b.f(bVar);
        }

        public final int b() {
            return this.f6101h;
        }

        final boolean c() {
            return this.f6095b.j();
        }

        public final boolean d() {
            return this.f6095b.p();
        }

        public final void e() {
            com.google.android.gms.common.internal.t.d(f.this.q);
            if (this.f6103j) {
                a();
            }
        }

        public final void i(g0 g0Var) {
            com.google.android.gms.common.internal.t.d(f.this.q);
            if (this.f6095b.j()) {
                if (s(g0Var)) {
                    B();
                    return;
                } else {
                    this.a.add(g0Var);
                    return;
                }
            }
            this.a.add(g0Var);
            com.google.android.gms.common.b bVar = this.f6105l;
            if (bVar != null && bVar.l1()) {
                p(this.f6105l);
            } else {
                a();
            }
        }

        public final void j(r0 r0Var) {
            com.google.android.gms.common.internal.t.d(f.this.q);
            this.f6099f.add(r0Var);
        }

        public final a.f l() {
            return this.f6095b;
        }

        public final void m() {
            Status status;
            com.google.android.gms.common.internal.t.d(f.this.q);
            if (this.f6103j) {
                A();
                if (f.this.f6091i.g(f.this.f6090h) == 18) {
                    status = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
                } else {
                    status = new Status(8, "API failed to connect while resuming due to an unknown error.");
                }
                D(status);
                this.f6095b.disconnect();
            }
        }

        @Override // com.google.android.gms.common.api.internal.e
        public final void n(int i2) {
            if (Looper.myLooper() != f.this.q.getLooper()) {
                f.this.q.post(new x(this));
            } else {
                u();
            }
        }

        @Override // com.google.android.gms.common.api.internal.k
        public final void p(com.google.android.gms.common.b bVar) {
            com.google.android.gms.common.internal.t.d(f.this.q);
            i0 i0Var = this.f6102i;
            if (i0Var != null) {
                i0Var.c1();
            }
            y();
            f.this.f6092j.a();
            L(bVar);
            if (bVar.i1() == 4) {
                D(f.f6084b);
            } else if (this.a.isEmpty()) {
                this.f6105l = bVar;
            } else if (K(bVar) || f.this.o(bVar, this.f6101h)) {
            } else {
                if (bVar.i1() == 18) {
                    this.f6103j = true;
                }
                if (this.f6103j) {
                    f.this.q.sendMessageDelayed(Message.obtain(f.this.q, 9, this.f6097d), f.this.f6087e);
                    return;
                }
                String a = this.f6097d.a();
                String valueOf = String.valueOf(bVar);
                StringBuilder sb = new StringBuilder(String.valueOf(a).length() + 63 + valueOf.length());
                sb.append("API: ");
                sb.append(a);
                sb.append(" is not available on this device. Connection failed with: ");
                sb.append(valueOf);
                D(new Status(17, sb.toString()));
            }
        }

        @Override // com.google.android.gms.common.api.internal.e
        public final void q(Bundle bundle) {
            if (Looper.myLooper() != f.this.q.getLooper()) {
                f.this.q.post(new w(this));
            } else {
                t();
            }
        }

        public final void w() {
            com.google.android.gms.common.internal.t.d(f.this.q);
            D(f.a);
            this.f6098e.e();
            for (j jVar : (j[]) this.f6100g.keySet().toArray(new j[this.f6100g.size()])) {
                i(new q0(jVar, new com.google.android.gms.tasks.h()));
            }
            L(new com.google.android.gms.common.b(4));
            if (this.f6095b.j()) {
                this.f6095b.i(new z(this));
            }
        }

        public final Map<j<?>, f0> x() {
            return this.f6100g;
        }

        public final void y() {
            com.google.android.gms.common.internal.t.d(f.this.q);
            this.f6105l = null;
        }

        public final com.google.android.gms.common.b z() {
            com.google.android.gms.common.internal.t.d(f.this.q);
            return this.f6105l;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public class b implements j0, c.InterfaceC0141c {
        private final a.f a;

        /* renamed from: b  reason: collision with root package name */
        private final com.google.android.gms.common.api.internal.b<?> f6106b;

        /* renamed from: c  reason: collision with root package name */
        private com.google.android.gms.common.internal.l f6107c = null;

        /* renamed from: d  reason: collision with root package name */
        private Set<Scope> f6108d = null;

        /* renamed from: e  reason: collision with root package name */
        private boolean f6109e = false;

        public b(a.f fVar, com.google.android.gms.common.api.internal.b<?> bVar) {
            this.a = fVar;
            this.f6106b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean e(b bVar, boolean z) {
            bVar.f6109e = true;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g() {
            com.google.android.gms.common.internal.l lVar;
            if (!this.f6109e || (lVar = this.f6107c) == null) {
                return;
            }
            this.a.b(lVar, this.f6108d);
        }

        @Override // com.google.android.gms.common.internal.c.InterfaceC0141c
        public final void a(com.google.android.gms.common.b bVar) {
            f.this.q.post(new b0(this, bVar));
        }

        @Override // com.google.android.gms.common.api.internal.j0
        public final void b(com.google.android.gms.common.internal.l lVar, Set<Scope> set) {
            if (lVar != null && set != null) {
                this.f6107c = lVar;
                this.f6108d = set;
                g();
                return;
            }
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            c(new com.google.android.gms.common.b(4));
        }

        @Override // com.google.android.gms.common.api.internal.j0
        public final void c(com.google.android.gms.common.b bVar) {
            ((a) f.this.m.get(this.f6106b)).J(bVar);
        }
    }

    private f(Context context, Looper looper, com.google.android.gms.common.e eVar) {
        this.f6090h = context;
        e.g.a.e.d.d.d dVar = new e.g.a.e.d.d.d(looper, this);
        this.q = dVar;
        this.f6091i = eVar;
        this.f6092j = new com.google.android.gms.common.internal.k(eVar);
        dVar.sendMessage(dVar.obtainMessage(6));
    }

    public static void a() {
        synchronized (f6085c) {
            f fVar = f6086d;
            if (fVar != null) {
                fVar.f6094l.incrementAndGet();
                Handler handler = fVar.q;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
    }

    public static f h(Context context) {
        f fVar;
        synchronized (f6085c) {
            if (f6086d == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                f6086d = new f(context.getApplicationContext(), handlerThread.getLooper(), com.google.android.gms.common.e.o());
            }
            fVar = f6086d;
        }
        return fVar;
    }

    private final void i(com.google.android.gms.common.api.c<?> cVar) {
        com.google.android.gms.common.api.internal.b<?> g2 = cVar.g();
        a<?> aVar = this.m.get(g2);
        if (aVar == null) {
            aVar = new a<>(cVar);
            this.m.put(g2, aVar);
        }
        if (aVar.d()) {
            this.p.add(g2);
        }
        aVar.a();
    }

    public final void c(com.google.android.gms.common.b bVar, int i2) {
        if (o(bVar, i2)) {
            return;
        }
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(5, i2, 0, bVar));
    }

    public final void d(com.google.android.gms.common.api.c<?> cVar) {
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(7, cVar));
    }

    public final <O extends a.d> void e(com.google.android.gms.common.api.c<O> cVar, int i2, d<? extends com.google.android.gms.common.api.i, a.b> dVar) {
        o0 o0Var = new o0(i2, dVar);
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(4, new e0(o0Var, this.f6094l.get(), cVar)));
    }

    public final void f(r rVar) {
        synchronized (f6085c) {
            if (this.n != rVar) {
                this.n = rVar;
                this.o.clear();
            }
            this.o.addAll(rVar.r());
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a<?> aVar;
        int i2 = message.what;
        switch (i2) {
            case 1:
                this.f6089g = ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.q.removeMessages(12);
                for (com.google.android.gms.common.api.internal.b<?> bVar : this.m.keySet()) {
                    Handler handler = this.q;
                    handler.sendMessageDelayed(handler.obtainMessage(12, bVar), this.f6089g);
                }
                break;
            case 2:
                r0 r0Var = (r0) message.obj;
                Iterator<com.google.android.gms.common.api.internal.b<?>> it = r0Var.b().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        com.google.android.gms.common.api.internal.b<?> next = it.next();
                        a<?> aVar2 = this.m.get(next);
                        if (aVar2 == null) {
                            r0Var.a(next, new com.google.android.gms.common.b(13), null);
                            break;
                        } else if (aVar2.c()) {
                            r0Var.a(next, com.google.android.gms.common.b.a, aVar2.l().e());
                        } else if (aVar2.z() != null) {
                            r0Var.a(next, aVar2.z(), null);
                        } else {
                            aVar2.j(r0Var);
                            aVar2.a();
                        }
                    }
                }
            case 3:
                for (a<?> aVar3 : this.m.values()) {
                    aVar3.y();
                    aVar3.a();
                }
                break;
            case 4:
            case 8:
            case 13:
                e0 e0Var = (e0) message.obj;
                a<?> aVar4 = this.m.get(e0Var.f6083c.g());
                if (aVar4 == null) {
                    i(e0Var.f6083c);
                    aVar4 = this.m.get(e0Var.f6083c.g());
                }
                if (aVar4.d() && this.f6094l.get() != e0Var.f6082b) {
                    e0Var.a.b(a);
                    aVar4.w();
                    break;
                } else {
                    aVar4.i(e0Var.a);
                    break;
                }
                break;
            case 5:
                int i3 = message.arg1;
                com.google.android.gms.common.b bVar2 = (com.google.android.gms.common.b) message.obj;
                Iterator<a<?>> it2 = this.m.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        a<?> next2 = it2.next();
                        aVar = next2.b() == i3 ? next2 : null;
                    }
                }
                if (aVar != null) {
                    String e2 = this.f6091i.e(bVar2.i1());
                    String j1 = bVar2.j1();
                    StringBuilder sb = new StringBuilder(String.valueOf(e2).length() + 69 + String.valueOf(j1).length());
                    sb.append("Error resolution was canceled by the user, original error message: ");
                    sb.append(e2);
                    sb.append(": ");
                    sb.append(j1);
                    aVar.D(new Status(17, sb.toString()));
                    break;
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i3);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                    break;
                }
            case 6:
                if (com.google.android.gms.common.util.l.a() && (this.f6090h.getApplicationContext() instanceof Application)) {
                    com.google.android.gms.common.api.internal.c.c((Application) this.f6090h.getApplicationContext());
                    com.google.android.gms.common.api.internal.c.b().a(new v(this));
                    if (!com.google.android.gms.common.api.internal.c.b().f(true)) {
                        this.f6089g = 300000L;
                        break;
                    }
                }
                break;
            case 7:
                i((com.google.android.gms.common.api.c) message.obj);
                break;
            case 9:
                if (this.m.containsKey(message.obj)) {
                    this.m.get(message.obj).e();
                    break;
                }
                break;
            case 10:
                for (com.google.android.gms.common.api.internal.b<?> bVar3 : this.p) {
                    this.m.remove(bVar3).w();
                }
                this.p.clear();
                break;
            case 11:
                if (this.m.containsKey(message.obj)) {
                    this.m.get(message.obj).m();
                    break;
                }
                break;
            case 12:
                if (this.m.containsKey(message.obj)) {
                    this.m.get(message.obj).C();
                    break;
                }
                break;
            case 14:
                s sVar = (s) message.obj;
                com.google.android.gms.common.api.internal.b<?> a2 = sVar.a();
                if (!this.m.containsKey(a2)) {
                    sVar.b().c(Boolean.FALSE);
                    break;
                } else {
                    sVar.b().c(Boolean.valueOf(this.m.get(a2).F(false)));
                    break;
                }
            case 15:
                c cVar = (c) message.obj;
                if (this.m.containsKey(cVar.a)) {
                    this.m.get(cVar.a).h(cVar);
                    break;
                }
                break;
            case 16:
                c cVar2 = (c) message.obj;
                if (this.m.containsKey(cVar2.a)) {
                    this.m.get(cVar2.a).r(cVar2);
                    break;
                }
                break;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i2);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j(r rVar) {
        synchronized (f6085c) {
            if (this.n == rVar) {
                this.n = null;
                this.o.clear();
            }
        }
    }

    public final int k() {
        return this.f6093k.getAndIncrement();
    }

    final boolean o(com.google.android.gms.common.b bVar, int i2) {
        return this.f6091i.y(this.f6090h, bVar, i2);
    }

    public final void w() {
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes2.dex */
    public static class c {
        private final com.google.android.gms.common.api.internal.b<?> a;

        /* renamed from: b  reason: collision with root package name */
        private final com.google.android.gms.common.d f6111b;

        private c(com.google.android.gms.common.api.internal.b<?> bVar, com.google.android.gms.common.d dVar) {
            this.a = bVar;
            this.f6111b = dVar;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof c)) {
                c cVar = (c) obj;
                if (com.google.android.gms.common.internal.r.a(this.a, cVar.a) && com.google.android.gms.common.internal.r.a(this.f6111b, cVar.f6111b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return com.google.android.gms.common.internal.r.b(this.a, this.f6111b);
        }

        public final String toString() {
            return com.google.android.gms.common.internal.r.c(this).a("key", this.a).a("feature", this.f6111b).toString();
        }

        /* synthetic */ c(com.google.android.gms.common.api.internal.b bVar, com.google.android.gms.common.d dVar, v vVar) {
            this(bVar, dVar);
        }
    }
}