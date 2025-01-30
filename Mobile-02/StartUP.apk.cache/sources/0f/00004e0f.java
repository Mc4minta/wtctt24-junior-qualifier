package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableMergeWithSingle.java */
/* loaded from: classes3.dex */
public final class a2<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.h0<? extends T> f15491b;

    /* compiled from: ObservableMergeWithSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f15492b = new AtomicReference<>();

        /* renamed from: c  reason: collision with root package name */
        final C0375a<T> f15493c = new C0375a<>(this);

        /* renamed from: d  reason: collision with root package name */
        final h.c.n0.j.c f15494d = new h.c.n0.j.c();

        /* renamed from: e  reason: collision with root package name */
        volatile h.c.n0.c.i<T> f15495e;

        /* renamed from: f  reason: collision with root package name */
        T f15496f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f15497g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f15498h;

        /* renamed from: j  reason: collision with root package name */
        volatile int f15499j;

        /* compiled from: ObservableMergeWithSingle.java */
        /* renamed from: h.c.n0.e.e.a2$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0375a<T> extends AtomicReference<h.c.k0.b> implements h.c.e0<T> {
            final a<T> a;

            C0375a(a<T> aVar) {
                this.a = aVar;
            }

            @Override // h.c.e0
            public void onError(Throwable th) {
                this.a.d(th);
            }

            @Override // h.c.e0
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.z(this, bVar);
            }

            @Override // h.c.e0
            public void onSuccess(T t) {
                this.a.e(t);
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
            while (!this.f15497g) {
                if (this.f15494d.get() != null) {
                    this.f15496f = null;
                    this.f15495e = null;
                    zVar.onError(this.f15494d.b());
                    return;
                }
                int i3 = this.f15499j;
                if (i3 == 1) {
                    this.f15496f = null;
                    this.f15499j = 2;
                    zVar.onNext((T) this.f15496f);
                    i3 = 2;
                }
                boolean z = this.f15498h;
                h.c.n0.c.i<T> iVar = this.f15495e;
                T poll = iVar != null ? iVar.poll() : (Object) null;
                boolean z2 = poll == null;
                if (z && z2 && i3 == 2) {
                    this.f15495e = null;
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
            this.f15496f = null;
            this.f15495e = null;
        }

        h.c.n0.c.i<T> c() {
            h.c.n0.c.i<T> iVar = this.f15495e;
            if (iVar == null) {
                h.c.n0.f.c cVar = new h.c.n0.f.c(h.c.s.bufferSize());
                this.f15495e = cVar;
                return cVar;
            }
            return iVar;
        }

        void d(Throwable th) {
            if (this.f15494d.a(th)) {
                h.c.n0.a.c.h(this.f15492b);
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15497g = true;
            h.c.n0.a.c.h(this.f15492b);
            h.c.n0.a.c.h(this.f15493c);
            if (getAndIncrement() == 0) {
                this.f15495e = null;
                this.f15496f = null;
            }
        }

        void e(T t) {
            if (compareAndSet(0, 1)) {
                this.a.onNext(t);
                this.f15499j = 2;
            } else {
                this.f15496f = t;
                this.f15499j = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(this.f15492b.get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15498h = true;
            a();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15494d.a(th)) {
                h.c.n0.a.c.h(this.f15492b);
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
            h.c.n0.a.c.z(this.f15492b, bVar);
        }
    }

    public a2(h.c.s<T> sVar, h.c.h0<? extends T> h0Var) {
        super(sVar);
        this.f15491b = h0Var;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        a aVar = new a(zVar);
        zVar.onSubscribe(aVar);
        this.a.subscribe(aVar);
        this.f15491b.subscribe(aVar.f15493c);
    }
}