package h.c.n0.e.b;

import h.c.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableBufferTimed.java */
/* loaded from: classes3.dex */
public final class p<T, U extends Collection<? super T>> extends h.c.n0.e.b.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final long f14797b;

    /* renamed from: c  reason: collision with root package name */
    final long f14798c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f14799d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.a0 f14800e;

    /* renamed from: f  reason: collision with root package name */
    final Callable<U> f14801f;

    /* renamed from: g  reason: collision with root package name */
    final int f14802g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f14803h;

    /* compiled from: FlowableBufferTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T, U extends Collection<? super T>> extends h.c.n0.h.m<T, U, U> implements k.a.d, Runnable, h.c.k0.b {

        /* renamed from: h  reason: collision with root package name */
        final Callable<U> f14804h;

        /* renamed from: j  reason: collision with root package name */
        final long f14805j;

        /* renamed from: k  reason: collision with root package name */
        final TimeUnit f14806k;

        /* renamed from: l  reason: collision with root package name */
        final int f14807l;
        final boolean m;
        final a0.c n;
        U p;
        h.c.k0.b q;
        k.a.d t;
        long u;
        long v;

        a(k.a.c<? super U> cVar, Callable<U> callable, long j2, TimeUnit timeUnit, int i2, boolean z, a0.c cVar2) {
            super(cVar, new h.c.n0.f.a());
            this.f14804h = callable;
            this.f14805j = j2;
            this.f14806k = timeUnit;
            this.f14807l = i2;
            this.m = z;
            this.n = cVar2;
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f16741e) {
                return;
            }
            this.f16741e = true;
            dispose();
        }

        @Override // h.c.k0.b
        public void dispose() {
            synchronized (this) {
                this.p = null;
            }
            this.t.cancel();
            this.n.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.n.isDisposed();
        }

        @Override // h.c.n0.h.m, h.c.n0.j.q
        /* renamed from: m */
        public boolean e(k.a.c<? super U> cVar, U u) {
            cVar.onNext(u);
            return true;
        }

        @Override // k.a.c
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.p;
                this.p = null;
            }
            this.f16740d.offer(u);
            this.f16742f = true;
            if (g()) {
                h.c.n0.j.r.e(this.f16740d, this.f16739c, false, this, this);
            }
            this.n.dispose();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            synchronized (this) {
                this.p = null;
            }
            this.f16739c.onError(th);
            this.n.dispose();
        }

        @Override // k.a.c
        public void onNext(T t) {
            synchronized (this) {
                U u = this.p;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.f14807l) {
                    return;
                }
                this.p = null;
                this.u++;
                if (this.m) {
                    this.q.dispose();
                }
                k(u, false, this);
                try {
                    U u2 = (U) h.c.n0.b.b.e(this.f14804h.call(), "The supplied buffer is null");
                    synchronized (this) {
                        this.p = u2;
                        this.v++;
                    }
                    if (this.m) {
                        a0.c cVar = this.n;
                        long j2 = this.f14805j;
                        this.q = cVar.d(this, j2, j2, this.f14806k);
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    cancel();
                    this.f16739c.onError(th);
                }
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.t, dVar)) {
                this.t = dVar;
                try {
                    this.p = (U) h.c.n0.b.b.e(this.f14804h.call(), "The supplied buffer is null");
                    this.f16739c.onSubscribe(this);
                    a0.c cVar = this.n;
                    long j2 = this.f14805j;
                    this.q = cVar.d(this, j2, j2, this.f14806k);
                    dVar.request(Long.MAX_VALUE);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.n.dispose();
                    dVar.cancel();
                    h.c.n0.i.d.q(th, this.f16739c);
                }
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            l(j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) h.c.n0.b.b.e(this.f14804h.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.p;
                    if (u2 != null && this.u == this.v) {
                        this.p = u;
                        k(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                cancel();
                this.f16739c.onError(th);
            }
        }
    }

    /* compiled from: FlowableBufferTimed.java */
    /* loaded from: classes3.dex */
    static final class b<T, U extends Collection<? super T>> extends h.c.n0.h.m<T, U, U> implements k.a.d, Runnable, h.c.k0.b {

        /* renamed from: h  reason: collision with root package name */
        final Callable<U> f14808h;

        /* renamed from: j  reason: collision with root package name */
        final long f14809j;

        /* renamed from: k  reason: collision with root package name */
        final TimeUnit f14810k;

        /* renamed from: l  reason: collision with root package name */
        final h.c.a0 f14811l;
        k.a.d m;
        U n;
        final AtomicReference<h.c.k0.b> p;

        b(k.a.c<? super U> cVar, Callable<U> callable, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
            super(cVar, new h.c.n0.f.a());
            this.p = new AtomicReference<>();
            this.f14808h = callable;
            this.f14809j = j2;
            this.f14810k = timeUnit;
            this.f14811l = a0Var;
        }

        @Override // k.a.d
        public void cancel() {
            this.f16741e = true;
            this.m.cancel();
            h.c.n0.a.c.h(this.p);
        }

        @Override // h.c.k0.b
        public void dispose() {
            cancel();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.p.get() == h.c.n0.a.c.DISPOSED;
        }

        @Override // h.c.n0.h.m, h.c.n0.j.q
        /* renamed from: m */
        public boolean e(k.a.c<? super U> cVar, U u) {
            this.f16739c.onNext(u);
            return true;
        }

        @Override // k.a.c
        public void onComplete() {
            h.c.n0.a.c.h(this.p);
            synchronized (this) {
                U u = this.n;
                if (u == null) {
                    return;
                }
                this.n = null;
                this.f16740d.offer(u);
                this.f16742f = true;
                if (g()) {
                    h.c.n0.j.r.e(this.f16740d, this.f16739c, false, null, this);
                }
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            h.c.n0.a.c.h(this.p);
            synchronized (this) {
                this.n = null;
            }
            this.f16739c.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            synchronized (this) {
                U u = this.n;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.m, dVar)) {
                this.m = dVar;
                try {
                    this.n = (U) h.c.n0.b.b.e(this.f14808h.call(), "The supplied buffer is null");
                    this.f16739c.onSubscribe(this);
                    if (this.f16741e) {
                        return;
                    }
                    dVar.request(Long.MAX_VALUE);
                    h.c.a0 a0Var = this.f14811l;
                    long j2 = this.f14809j;
                    h.c.k0.b e2 = a0Var.e(this, j2, j2, this.f14810k);
                    if (this.p.compareAndSet(null, e2)) {
                        return;
                    }
                    e2.dispose();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    cancel();
                    h.c.n0.i.d.q(th, this.f16739c);
                }
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            l(j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) h.c.n0.b.b.e(this.f14808h.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.n;
                    if (u2 == null) {
                        return;
                    }
                    this.n = u;
                    j(u2, false, this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                cancel();
                this.f16739c.onError(th);
            }
        }
    }

    /* compiled from: FlowableBufferTimed.java */
    /* loaded from: classes3.dex */
    static final class c<T, U extends Collection<? super T>> extends h.c.n0.h.m<T, U, U> implements k.a.d, Runnable {

        /* renamed from: h  reason: collision with root package name */
        final Callable<U> f14812h;

        /* renamed from: j  reason: collision with root package name */
        final long f14813j;

        /* renamed from: k  reason: collision with root package name */
        final long f14814k;

        /* renamed from: l  reason: collision with root package name */
        final TimeUnit f14815l;
        final a0.c m;
        final List<U> n;
        k.a.d p;

        /* compiled from: FlowableBufferTimed.java */
        /* loaded from: classes3.dex */
        final class a implements Runnable {
            private final U a;

            a(U u) {
                this.a = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.n.remove(this.a);
                }
                c cVar = c.this;
                cVar.k(this.a, false, cVar.m);
            }
        }

        c(k.a.c<? super U> cVar, Callable<U> callable, long j2, long j3, TimeUnit timeUnit, a0.c cVar2) {
            super(cVar, new h.c.n0.f.a());
            this.f14812h = callable;
            this.f14813j = j2;
            this.f14814k = j3;
            this.f14815l = timeUnit;
            this.m = cVar2;
            this.n = new LinkedList();
        }

        @Override // k.a.d
        public void cancel() {
            this.f16741e = true;
            this.p.cancel();
            this.m.dispose();
            o();
        }

        @Override // h.c.n0.h.m, h.c.n0.j.q
        /* renamed from: m */
        public boolean e(k.a.c<? super U> cVar, U u) {
            cVar.onNext(u);
            return true;
        }

        void o() {
            synchronized (this) {
                this.n.clear();
            }
        }

        @Override // k.a.c
        public void onComplete() {
            ArrayList<Collection> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.n);
                this.n.clear();
            }
            for (Collection collection : arrayList) {
                this.f16740d.offer(collection);
            }
            this.f16742f = true;
            if (g()) {
                h.c.n0.j.r.e(this.f16740d, this.f16739c, false, this.m, this);
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f16742f = true;
            this.m.dispose();
            o();
            this.f16739c.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            synchronized (this) {
                for (U u : this.n) {
                    u.add(t);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.p, dVar)) {
                this.p = dVar;
                try {
                    Collection collection = (Collection) h.c.n0.b.b.e(this.f14812h.call(), "The supplied buffer is null");
                    this.n.add(collection);
                    this.f16739c.onSubscribe(this);
                    dVar.request(Long.MAX_VALUE);
                    a0.c cVar = this.m;
                    long j2 = this.f14814k;
                    cVar.d(this, j2, j2, this.f14815l);
                    this.m.c(new a(collection), this.f14813j, this.f14815l);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.m.dispose();
                    dVar.cancel();
                    h.c.n0.i.d.q(th, this.f16739c);
                }
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            l(j2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (this.f16741e) {
                return;
            }
            try {
                Collection collection = (Collection) h.c.n0.b.b.e(this.f14812h.call(), "The supplied buffer is null");
                synchronized (this) {
                    if (this.f16741e) {
                        return;
                    }
                    this.n.add(collection);
                    this.m.c(new a(collection), this.f14813j, this.f14815l);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                cancel();
                this.f16739c.onError(th);
            }
        }
    }

    public p(h.c.h<T> hVar, long j2, long j3, TimeUnit timeUnit, h.c.a0 a0Var, Callable<U> callable, int i2, boolean z) {
        super(hVar);
        this.f14797b = j2;
        this.f14798c = j3;
        this.f14799d = timeUnit;
        this.f14800e = a0Var;
        this.f14801f = callable;
        this.f14802g = i2;
        this.f14803h = z;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super U> cVar) {
        if (this.f14797b == this.f14798c && this.f14802g == Integer.MAX_VALUE) {
            this.a.subscribe((h.c.m) new b(new h.c.w0.d(cVar), this.f14801f, this.f14797b, this.f14799d, this.f14800e));
            return;
        }
        a0.c a2 = this.f14800e.a();
        if (this.f14797b == this.f14798c) {
            this.a.subscribe((h.c.m) new a(new h.c.w0.d(cVar), this.f14801f, this.f14797b, this.f14799d, this.f14802g, this.f14803h, a2));
        } else {
            this.a.subscribe((h.c.m) new c(new h.c.w0.d(cVar), this.f14801f, this.f14797b, this.f14798c, this.f14799d, a2));
        }
    }
}