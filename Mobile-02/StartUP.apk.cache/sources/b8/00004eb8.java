package h.c.n0.e.e;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableBufferBoundary.java */
/* loaded from: classes3.dex */
public final class m<T, U extends Collection<? super T>, Open, Close> extends h.c.n0.e.e.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<U> f15937b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.x<? extends Open> f15938c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.m0.n<? super Open, ? extends h.c.x<? extends Close>> f15939d;

    /* compiled from: ObservableBufferBoundary.java */
    /* loaded from: classes3.dex */
    static final class a<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super C> a;

        /* renamed from: b  reason: collision with root package name */
        final Callable<C> f15940b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.x<? extends Open> f15941c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.m0.n<? super Open, ? extends h.c.x<? extends Close>> f15942d;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f15946h;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f15948k;

        /* renamed from: l  reason: collision with root package name */
        long f15949l;

        /* renamed from: j  reason: collision with root package name */
        final h.c.n0.f.c<C> f15947j = new h.c.n0.f.c<>(h.c.s.bufferSize());

        /* renamed from: e  reason: collision with root package name */
        final h.c.k0.a f15943e = new h.c.k0.a();

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f15944f = new AtomicReference<>();
        Map<Long, C> m = new LinkedHashMap();

        /* renamed from: g  reason: collision with root package name */
        final h.c.n0.j.c f15945g = new h.c.n0.j.c();

        /* compiled from: ObservableBufferBoundary.java */
        /* renamed from: h.c.n0.e.e.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0382a<Open> extends AtomicReference<h.c.k0.b> implements h.c.z<Open>, h.c.k0.b {
            final a<?, ?, Open, ?> a;

            C0382a(a<?, ?, Open, ?> aVar) {
                this.a = aVar;
            }

            @Override // h.c.k0.b
            public void dispose() {
                h.c.n0.a.c.h(this);
            }

            @Override // h.c.k0.b
            public boolean isDisposed() {
                return get() == h.c.n0.a.c.DISPOSED;
            }

            @Override // h.c.z, k.a.c
            public void onComplete() {
                lazySet(h.c.n0.a.c.DISPOSED);
                this.a.e(this);
            }

            @Override // h.c.z, k.a.c
            public void onError(Throwable th) {
                lazySet(h.c.n0.a.c.DISPOSED);
                this.a.a(this, th);
            }

            @Override // h.c.z, k.a.c
            public void onNext(Open open) {
                this.a.d(open);
            }

            @Override // h.c.z
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.z(this, bVar);
            }
        }

        a(h.c.z<? super C> zVar, h.c.x<? extends Open> xVar, h.c.m0.n<? super Open, ? extends h.c.x<? extends Close>> nVar, Callable<C> callable) {
            this.a = zVar;
            this.f15940b = callable;
            this.f15941c = xVar;
            this.f15942d = nVar;
        }

        void a(h.c.k0.b bVar, Throwable th) {
            h.c.n0.a.c.h(this.f15944f);
            this.f15943e.c(bVar);
            onError(th);
        }

        void b(b<T, C> bVar, long j2) {
            boolean z;
            this.f15943e.c(bVar);
            if (this.f15943e.f() == 0) {
                h.c.n0.a.c.h(this.f15944f);
                z = true;
            } else {
                z = false;
            }
            synchronized (this) {
                Map<Long, C> map = this.m;
                if (map == null) {
                    return;
                }
                this.f15947j.offer(map.remove(Long.valueOf(j2)));
                if (z) {
                    this.f15946h = true;
                }
                c();
            }
        }

        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            h.c.z<? super C> zVar = this.a;
            h.c.n0.f.c<C> cVar = this.f15947j;
            int i2 = 1;
            while (!this.f15948k) {
                boolean z = this.f15946h;
                if (z && this.f15945g.get() != null) {
                    cVar.clear();
                    zVar.onError(this.f15945g.b());
                    return;
                }
                C poll = cVar.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    zVar.onComplete();
                    return;
                } else if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    zVar.onNext(poll);
                }
            }
            cVar.clear();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void d(Open open) {
            try {
                Collection collection = (Collection) h.c.n0.b.b.e(this.f15940b.call(), "The bufferSupplier returned a null Collection");
                h.c.x xVar = (h.c.x) h.c.n0.b.b.e(this.f15942d.apply(open), "The bufferClose returned a null ObservableSource");
                long j2 = this.f15949l;
                this.f15949l = 1 + j2;
                synchronized (this) {
                    Map<Long, C> map = this.m;
                    if (map == 0) {
                        return;
                    }
                    map.put(Long.valueOf(j2), collection);
                    b bVar = new b(this, j2);
                    this.f15943e.b(bVar);
                    xVar.subscribe(bVar);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.n0.a.c.h(this.f15944f);
                onError(th);
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (h.c.n0.a.c.h(this.f15944f)) {
                this.f15948k = true;
                this.f15943e.dispose();
                synchronized (this) {
                    this.m = null;
                }
                if (getAndIncrement() != 0) {
                    this.f15947j.clear();
                }
            }
        }

        void e(C0382a<Open> c0382a) {
            this.f15943e.c(c0382a);
            if (this.f15943e.f() == 0) {
                h.c.n0.a.c.h(this.f15944f);
                this.f15946h = true;
                c();
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(this.f15944f.get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15943e.dispose();
            synchronized (this) {
                Map<Long, C> map = this.m;
                if (map == null) {
                    return;
                }
                for (C c2 : map.values()) {
                    this.f15947j.offer(c2);
                }
                this.m = null;
                this.f15946h = true;
                c();
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15945g.a(th)) {
                this.f15943e.dispose();
                synchronized (this) {
                    this.m = null;
                }
                this.f15946h = true;
                c();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            synchronized (this) {
                Map<Long, C> map = this.m;
                if (map == null) {
                    return;
                }
                for (C c2 : map.values()) {
                    c2.add(t);
                }
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.z(this.f15944f, bVar)) {
                C0382a c0382a = new C0382a(this);
                this.f15943e.b(c0382a);
                this.f15941c.subscribe(c0382a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableBufferBoundary.java */
    /* loaded from: classes3.dex */
    public static final class b<T, C extends Collection<? super T>> extends AtomicReference<h.c.k0.b> implements h.c.z<Object>, h.c.k0.b {
        final a<T, C, ?, ?> a;

        /* renamed from: b  reason: collision with root package name */
        final long f15950b;

        b(a<T, C, ?, ?> aVar, long j2) {
            this.a = aVar;
            this.f15950b = j2;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get() == h.c.n0.a.c.DISPOSED;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            h.c.k0.b bVar = get();
            h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
            if (bVar != cVar) {
                lazySet(cVar);
                this.a.b(this, this.f15950b);
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            h.c.k0.b bVar = get();
            h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
            if (bVar != cVar) {
                lazySet(cVar);
                this.a.a(this, th);
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(Object obj) {
            h.c.k0.b bVar = get();
            h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
            if (bVar != cVar) {
                lazySet(cVar);
                bVar.dispose();
                this.a.b(this, this.f15950b);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this, bVar);
        }
    }

    public m(h.c.x<T> xVar, h.c.x<? extends Open> xVar2, h.c.m0.n<? super Open, ? extends h.c.x<? extends Close>> nVar, Callable<U> callable) {
        super(xVar);
        this.f15938c = xVar2;
        this.f15939d = nVar;
        this.f15937b = callable;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super U> zVar) {
        a aVar = new a(zVar, this.f15938c, this.f15939d, this.f15937b);
        zVar.onSubscribe(aVar);
        this.a.subscribe(aVar);
    }
}