package h.c.n0.e.e;

import h.c.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableBufferTimed.java */
/* loaded from: classes3.dex */
public final class p<T, U extends Collection<? super T>> extends h.c.n0.e.e.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final long f16032b;

    /* renamed from: c  reason: collision with root package name */
    final long f16033c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f16034d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.a0 f16035e;

    /* renamed from: f  reason: collision with root package name */
    final Callable<U> f16036f;

    /* renamed from: g  reason: collision with root package name */
    final int f16037g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f16038h;

    /* compiled from: ObservableBufferTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T, U extends Collection<? super T>> extends h.c.n0.d.u<T, U, U> implements Runnable, h.c.k0.b {

        /* renamed from: g  reason: collision with root package name */
        final Callable<U> f16039g;

        /* renamed from: h  reason: collision with root package name */
        final long f16040h;

        /* renamed from: j  reason: collision with root package name */
        final TimeUnit f16041j;

        /* renamed from: k  reason: collision with root package name */
        final int f16042k;

        /* renamed from: l  reason: collision with root package name */
        final boolean f16043l;
        final a0.c m;
        U n;
        h.c.k0.b p;
        h.c.k0.b q;
        long t;
        long u;

        a(h.c.z<? super U> zVar, Callable<U> callable, long j2, TimeUnit timeUnit, int i2, boolean z, a0.c cVar) {
            super(zVar, new h.c.n0.f.a());
            this.f16039g = callable;
            this.f16040h = j2;
            this.f16041j = timeUnit;
            this.f16042k = i2;
            this.f16043l = z;
            this.m = cVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f14145d) {
                return;
            }
            this.f14145d = true;
            this.q.dispose();
            this.m.dispose();
            synchronized (this) {
                this.n = null;
            }
        }

        @Override // h.c.n0.d.u, h.c.n0.j.n
        /* renamed from: i */
        public void d(h.c.z<? super U> zVar, U u) {
            zVar.onNext(u);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14145d;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            U u;
            this.m.dispose();
            synchronized (this) {
                u = this.n;
                this.n = null;
            }
            this.f14144c.offer(u);
            this.f14146e = true;
            if (e()) {
                h.c.n0.j.r.d(this.f14144c, this.f14143b, false, this, this);
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            synchronized (this) {
                this.n = null;
            }
            this.f14143b.onError(th);
            this.m.dispose();
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            synchronized (this) {
                U u = this.n;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.f16042k) {
                    return;
                }
                this.n = null;
                this.t++;
                if (this.f16043l) {
                    this.p.dispose();
                }
                h(u, false, this);
                try {
                    U u2 = (U) h.c.n0.b.b.e(this.f16039g.call(), "The buffer supplied is null");
                    synchronized (this) {
                        this.n = u2;
                        this.u++;
                    }
                    if (this.f16043l) {
                        a0.c cVar = this.m;
                        long j2 = this.f16040h;
                        this.p = cVar.d(this, j2, j2, this.f16041j);
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f14143b.onError(th);
                    dispose();
                }
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.q, bVar)) {
                this.q = bVar;
                try {
                    this.n = (U) h.c.n0.b.b.e(this.f16039g.call(), "The buffer supplied is null");
                    this.f14143b.onSubscribe(this);
                    a0.c cVar = this.m;
                    long j2 = this.f16040h;
                    this.p = cVar.d(this, j2, j2, this.f16041j);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    bVar.dispose();
                    h.c.n0.a.d.y(th, this.f14143b);
                    this.m.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) h.c.n0.b.b.e(this.f16039g.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    U u2 = this.n;
                    if (u2 != null && this.t == this.u) {
                        this.n = u;
                        h(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                dispose();
                this.f14143b.onError(th);
            }
        }
    }

    /* compiled from: ObservableBufferTimed.java */
    /* loaded from: classes3.dex */
    static final class b<T, U extends Collection<? super T>> extends h.c.n0.d.u<T, U, U> implements Runnable, h.c.k0.b {

        /* renamed from: g  reason: collision with root package name */
        final Callable<U> f16044g;

        /* renamed from: h  reason: collision with root package name */
        final long f16045h;

        /* renamed from: j  reason: collision with root package name */
        final TimeUnit f16046j;

        /* renamed from: k  reason: collision with root package name */
        final h.c.a0 f16047k;

        /* renamed from: l  reason: collision with root package name */
        h.c.k0.b f16048l;
        U m;
        final AtomicReference<h.c.k0.b> n;

        b(h.c.z<? super U> zVar, Callable<U> callable, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
            super(zVar, new h.c.n0.f.a());
            this.n = new AtomicReference<>();
            this.f16044g = callable;
            this.f16045h = j2;
            this.f16046j = timeUnit;
            this.f16047k = a0Var;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this.n);
            this.f16048l.dispose();
        }

        @Override // h.c.n0.d.u, h.c.n0.j.n
        /* renamed from: i */
        public void d(h.c.z<? super U> zVar, U u) {
            this.f14143b.onNext(u);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.n.get() == h.c.n0.a.c.DISPOSED;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.m;
                this.m = null;
            }
            if (u != null) {
                this.f14144c.offer(u);
                this.f14146e = true;
                if (e()) {
                    h.c.n0.j.r.d(this.f14144c, this.f14143b, false, null, this);
                }
            }
            h.c.n0.a.c.h(this.n);
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            synchronized (this) {
                this.m = null;
            }
            this.f14143b.onError(th);
            h.c.n0.a.c.h(this.n);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            synchronized (this) {
                U u = this.m;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16048l, bVar)) {
                this.f16048l = bVar;
                try {
                    this.m = (U) h.c.n0.b.b.e(this.f16044g.call(), "The buffer supplied is null");
                    this.f14143b.onSubscribe(this);
                    if (this.f14145d) {
                        return;
                    }
                    h.c.a0 a0Var = this.f16047k;
                    long j2 = this.f16045h;
                    h.c.k0.b e2 = a0Var.e(this, j2, j2, this.f16046j);
                    if (this.n.compareAndSet(null, e2)) {
                        return;
                    }
                    e2.dispose();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    dispose();
                    h.c.n0.a.d.y(th, this.f14143b);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            U u;
            try {
                U u2 = (U) h.c.n0.b.b.e(this.f16044g.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    u = this.m;
                    if (u != null) {
                        this.m = u2;
                    }
                }
                if (u == null) {
                    h.c.n0.a.c.h(this.n);
                } else {
                    g(u, false, this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f14143b.onError(th);
                dispose();
            }
        }
    }

    /* compiled from: ObservableBufferTimed.java */
    /* loaded from: classes3.dex */
    static final class c<T, U extends Collection<? super T>> extends h.c.n0.d.u<T, U, U> implements Runnable, h.c.k0.b {

        /* renamed from: g  reason: collision with root package name */
        final Callable<U> f16049g;

        /* renamed from: h  reason: collision with root package name */
        final long f16050h;

        /* renamed from: j  reason: collision with root package name */
        final long f16051j;

        /* renamed from: k  reason: collision with root package name */
        final TimeUnit f16052k;

        /* renamed from: l  reason: collision with root package name */
        final a0.c f16053l;
        final List<U> m;
        h.c.k0.b n;

        /* compiled from: ObservableBufferTimed.java */
        /* loaded from: classes3.dex */
        final class a implements Runnable {
            private final U a;

            a(U u) {
                this.a = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.m.remove(this.a);
                }
                c cVar = c.this;
                cVar.h(this.a, false, cVar.f16053l);
            }
        }

        /* compiled from: ObservableBufferTimed.java */
        /* loaded from: classes3.dex */
        final class b implements Runnable {
            private final U a;

            b(U u) {
                this.a = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.m.remove(this.a);
                }
                c cVar = c.this;
                cVar.h(this.a, false, cVar.f16053l);
            }
        }

        c(h.c.z<? super U> zVar, Callable<U> callable, long j2, long j3, TimeUnit timeUnit, a0.c cVar) {
            super(zVar, new h.c.n0.f.a());
            this.f16049g = callable;
            this.f16050h = j2;
            this.f16051j = j3;
            this.f16052k = timeUnit;
            this.f16053l = cVar;
            this.m = new LinkedList();
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f14145d) {
                return;
            }
            this.f14145d = true;
            l();
            this.n.dispose();
            this.f16053l.dispose();
        }

        @Override // h.c.n0.d.u, h.c.n0.j.n
        /* renamed from: i */
        public void d(h.c.z<? super U> zVar, U u) {
            zVar.onNext(u);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14145d;
        }

        void l() {
            synchronized (this) {
                this.m.clear();
            }
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            ArrayList<Collection> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.m);
                this.m.clear();
            }
            for (Collection collection : arrayList) {
                this.f14144c.offer(collection);
            }
            this.f14146e = true;
            if (e()) {
                h.c.n0.j.r.d(this.f14144c, this.f14143b, false, this.f16053l, this);
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f14146e = true;
            l();
            this.f14143b.onError(th);
            this.f16053l.dispose();
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            synchronized (this) {
                for (U u : this.m) {
                    u.add(t);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.n, bVar)) {
                this.n = bVar;
                try {
                    Collection collection = (Collection) h.c.n0.b.b.e(this.f16049g.call(), "The buffer supplied is null");
                    this.m.add(collection);
                    this.f14143b.onSubscribe(this);
                    a0.c cVar = this.f16053l;
                    long j2 = this.f16051j;
                    cVar.d(this, j2, j2, this.f16052k);
                    this.f16053l.c(new b(collection), this.f16050h, this.f16052k);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    bVar.dispose();
                    h.c.n0.a.d.y(th, this.f14143b);
                    this.f16053l.dispose();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (this.f14145d) {
                return;
            }
            try {
                Collection collection = (Collection) h.c.n0.b.b.e(this.f16049g.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    if (this.f14145d) {
                        return;
                    }
                    this.m.add(collection);
                    this.f16053l.c(new a(collection), this.f16050h, this.f16052k);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f14143b.onError(th);
                dispose();
            }
        }
    }

    public p(h.c.x<T> xVar, long j2, long j3, TimeUnit timeUnit, h.c.a0 a0Var, Callable<U> callable, int i2, boolean z) {
        super(xVar);
        this.f16032b = j2;
        this.f16033c = j3;
        this.f16034d = timeUnit;
        this.f16035e = a0Var;
        this.f16036f = callable;
        this.f16037g = i2;
        this.f16038h = z;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super U> zVar) {
        if (this.f16032b == this.f16033c && this.f16037g == Integer.MAX_VALUE) {
            this.a.subscribe(new b(new h.c.p0.f(zVar), this.f16036f, this.f16032b, this.f16034d, this.f16035e));
            return;
        }
        a0.c a2 = this.f16035e.a();
        if (this.f16032b == this.f16033c) {
            this.a.subscribe(new a(new h.c.p0.f(zVar), this.f16036f, this.f16032b, this.f16034d, this.f16037g, this.f16038h, a2));
        } else {
            this.a.subscribe(new c(new h.c.p0.f(zVar), this.f16036f, this.f16032b, this.f16033c, this.f16034d, a2));
        }
    }
}