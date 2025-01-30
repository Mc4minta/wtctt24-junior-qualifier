package h.c.n0.e.e;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableWindowBoundarySupplier.java */
/* loaded from: classes3.dex */
public final class g4<T, B> extends h.c.n0.e.e.a<T, h.c.s<T>> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends h.c.x<B>> f15712b;

    /* renamed from: c  reason: collision with root package name */
    final int f15713c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableWindowBoundarySupplier.java */
    /* loaded from: classes3.dex */
    public static final class a<T, B> extends h.c.p0.d<B> {

        /* renamed from: b  reason: collision with root package name */
        final b<T, B> f15714b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15715c;

        a(b<T, B> bVar) {
            this.f15714b = bVar;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15715c) {
                return;
            }
            this.f15715c = true;
            this.f15714b.c();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15715c) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15715c = true;
            this.f15714b.d(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(B b2) {
            if (this.f15715c) {
                return;
            }
            this.f15715c = true;
            dispose();
            this.f15714b.e(this);
        }
    }

    /* compiled from: ObservableWindowBoundarySupplier.java */
    /* loaded from: classes3.dex */
    static final class b<T, B> extends AtomicInteger implements h.c.z<T>, h.c.k0.b, Runnable {
        static final a<Object, Object> a = new a<>(null);

        /* renamed from: b  reason: collision with root package name */
        static final Object f15716b = new Object();

        /* renamed from: c  reason: collision with root package name */
        final h.c.z<? super h.c.s<T>> f15717c;

        /* renamed from: d  reason: collision with root package name */
        final int f15718d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<a<T, B>> f15719e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f15720f = new AtomicInteger(1);

        /* renamed from: g  reason: collision with root package name */
        final h.c.n0.f.a<Object> f15721g = new h.c.n0.f.a<>();

        /* renamed from: h  reason: collision with root package name */
        final h.c.n0.j.c f15722h = new h.c.n0.j.c();

        /* renamed from: j  reason: collision with root package name */
        final AtomicBoolean f15723j = new AtomicBoolean();

        /* renamed from: k  reason: collision with root package name */
        final Callable<? extends h.c.x<B>> f15724k;

        /* renamed from: l  reason: collision with root package name */
        h.c.k0.b f15725l;
        volatile boolean m;
        h.c.v0.g<T> n;

        b(h.c.z<? super h.c.s<T>> zVar, int i2, Callable<? extends h.c.x<B>> callable) {
            this.f15717c = zVar;
            this.f15718d = i2;
            this.f15724k = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            a<Object, Object> aVar = a;
            h.c.k0.b bVar = (h.c.k0.b) this.f15719e.getAndSet(aVar);
            if (bVar == null || bVar == aVar) {
                return;
            }
            bVar.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            h.c.z<? super h.c.s<T>> zVar = this.f15717c;
            h.c.n0.f.a<Object> aVar = this.f15721g;
            h.c.n0.j.c cVar = this.f15722h;
            int i2 = 1;
            while (this.f15720f.get() != 0) {
                h.c.v0.g<T> gVar = this.n;
                boolean z = this.m;
                if (z && cVar.get() != null) {
                    aVar.clear();
                    Throwable b2 = cVar.b();
                    if (gVar != 0) {
                        this.n = null;
                        gVar.onError(b2);
                    }
                    zVar.onError(b2);
                    return;
                }
                Object poll = aVar.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    Throwable b3 = cVar.b();
                    if (b3 == null) {
                        if (gVar != 0) {
                            this.n = null;
                            gVar.onComplete();
                        }
                        zVar.onComplete();
                        return;
                    }
                    if (gVar != 0) {
                        this.n = null;
                        gVar.onError(b3);
                    }
                    zVar.onError(b3);
                    return;
                } else if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (poll != f15716b) {
                    gVar.onNext(poll);
                } else {
                    if (gVar != 0) {
                        this.n = null;
                        gVar.onComplete();
                    }
                    if (!this.f15723j.get()) {
                        h.c.v0.g<T> e2 = h.c.v0.g.e(this.f15718d, this);
                        this.n = e2;
                        this.f15720f.getAndIncrement();
                        try {
                            h.c.x xVar = (h.c.x) h.c.n0.b.b.e(this.f15724k.call(), "The other Callable returned a null ObservableSource");
                            a<T, B> aVar2 = new a<>(this);
                            if (this.f15719e.compareAndSet(null, aVar2)) {
                                xVar.subscribe(aVar2);
                                zVar.onNext(e2);
                            }
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.b(th);
                            cVar.a(th);
                            this.m = true;
                        }
                    }
                }
            }
            aVar.clear();
            this.n = null;
        }

        void c() {
            this.f15725l.dispose();
            this.m = true;
            b();
        }

        void d(Throwable th) {
            this.f15725l.dispose();
            if (this.f15722h.a(th)) {
                this.m = true;
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f15723j.compareAndSet(false, true)) {
                a();
                if (this.f15720f.decrementAndGet() == 0) {
                    this.f15725l.dispose();
                }
            }
        }

        void e(a<T, B> aVar) {
            this.f15719e.compareAndSet(aVar, null);
            this.f15721g.offer(f15716b);
            b();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15723j.get();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            a();
            this.m = true;
            b();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            a();
            if (this.f15722h.a(th)) {
                this.m = true;
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.f15721g.offer(t);
            b();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15725l, bVar)) {
                this.f15725l = bVar;
                this.f15717c.onSubscribe(this);
                this.f15721g.offer(f15716b);
                b();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f15720f.decrementAndGet() == 0) {
                this.f15725l.dispose();
            }
        }
    }

    public g4(h.c.x<T> xVar, Callable<? extends h.c.x<B>> callable, int i2) {
        super(xVar);
        this.f15712b = callable;
        this.f15713c = i2;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super h.c.s<T>> zVar) {
        this.a.subscribe(new b(zVar, this.f15713c, this.f15712b));
    }
}