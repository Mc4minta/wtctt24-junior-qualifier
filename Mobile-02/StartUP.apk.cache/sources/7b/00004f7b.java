package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableMergeWithMaybe.java */
/* loaded from: classes3.dex */
public final class z1<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.q<? extends T> f16438b;

    /* compiled from: ObservableMergeWithMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f16439b = new AtomicReference<>();

        /* renamed from: c  reason: collision with root package name */
        final C0392a<T> f16440c = new C0392a<>(this);

        /* renamed from: d  reason: collision with root package name */
        final h.c.n0.j.c f16441d = new h.c.n0.j.c();

        /* renamed from: e  reason: collision with root package name */
        volatile h.c.n0.c.i<T> f16442e;

        /* renamed from: f  reason: collision with root package name */
        T f16443f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f16444g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f16445h;

        /* renamed from: j  reason: collision with root package name */
        volatile int f16446j;

        /* compiled from: ObservableMergeWithMaybe.java */
        /* renamed from: h.c.n0.e.e.z1$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0392a<T> extends AtomicReference<h.c.k0.b> implements h.c.p<T> {
            final a<T> a;

            C0392a(a<T> aVar) {
                this.a = aVar;
            }

            @Override // h.c.p
            public void onComplete() {
                this.a.d();
            }

            @Override // h.c.p
            public void onError(Throwable th) {
                this.a.e(th);
            }

            @Override // h.c.p
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.z(this, bVar);
            }

            @Override // h.c.p
            public void onSuccess(T t) {
                this.a.f(t);
            }
        }

        a(h.c.z<? super T> zVar) {
            this.a = zVar;
        }

        void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        void b() {
            h.c.z<? super T> zVar = this.a;
            int i2 = 1;
            while (!this.f16444g) {
                if (this.f16441d.get() != null) {
                    this.f16443f = null;
                    this.f16442e = null;
                    zVar.onError(this.f16441d.b());
                    return;
                }
                int i3 = this.f16446j;
                if (i3 == 1) {
                    this.f16443f = null;
                    this.f16446j = 2;
                    zVar.onNext((T) this.f16443f);
                    i3 = 2;
                }
                boolean z = this.f16445h;
                h.c.n0.c.i<T> iVar = this.f16442e;
                T poll = iVar != null ? iVar.poll() : (Object) null;
                boolean z2 = poll == null;
                if (z && z2 && i3 == 2) {
                    this.f16442e = null;
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
            this.f16443f = null;
            this.f16442e = null;
        }

        h.c.n0.c.i<T> c() {
            h.c.n0.c.i<T> iVar = this.f16442e;
            if (iVar == null) {
                h.c.n0.f.c cVar = new h.c.n0.f.c(h.c.s.bufferSize());
                this.f16442e = cVar;
                return cVar;
            }
            return iVar;
        }

        void d() {
            this.f16446j = 2;
            a();
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16444g = true;
            h.c.n0.a.c.h(this.f16439b);
            h.c.n0.a.c.h(this.f16440c);
            if (getAndIncrement() == 0) {
                this.f16442e = null;
                this.f16443f = null;
            }
        }

        void e(Throwable th) {
            if (this.f16441d.a(th)) {
                h.c.n0.a.c.h(this.f16439b);
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        void f(T t) {
            if (compareAndSet(0, 1)) {
                this.a.onNext(t);
                this.f16446j = 2;
            } else {
                this.f16443f = t;
                this.f16446j = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(this.f16439b.get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f16445h = true;
            a();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16441d.a(th)) {
                h.c.n0.a.c.h(this.f16439b);
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                this.a.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                c().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this.f16439b, bVar);
        }
    }

    public z1(h.c.s<T> sVar, h.c.q<? extends T> qVar) {
        super(sVar);
        this.f16438b = qVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        a aVar = new a(zVar);
        zVar.onSubscribe(aVar);
        this.a.subscribe(aVar);
        this.f16438b.b(aVar.f16440c);
    }
}