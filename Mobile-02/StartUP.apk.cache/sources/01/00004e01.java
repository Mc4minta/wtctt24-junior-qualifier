package h.c.n0.e.d;

import h.c.p;
import h.c.q;
import h.c.s;
import h.c.z;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSwitchMapMaybe.java */
/* loaded from: classes3.dex */
public final class l<T, R> extends s<R> {
    final s<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends q<? extends R>> f15462b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f15463c;

    /* compiled from: ObservableSwitchMapMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements z<T>, h.c.k0.b {
        static final C0373a<Object> a = new C0373a<>(null);

        /* renamed from: b  reason: collision with root package name */
        final z<? super R> f15464b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends q<? extends R>> f15465c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f15466d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.j.c f15467e = new h.c.n0.j.c();

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<C0373a<R>> f15468f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        h.c.k0.b f15469g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f15470h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f15471j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableSwitchMapMaybe.java */
        /* renamed from: h.c.n0.e.d.l$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0373a<R> extends AtomicReference<h.c.k0.b> implements p<R> {
            final a<?, R> a;

            /* renamed from: b  reason: collision with root package name */
            volatile R f15472b;

            C0373a(a<?, R> aVar) {
                this.a = aVar;
            }

            void a() {
                h.c.n0.a.c.h(this);
            }

            @Override // h.c.p
            public void onComplete() {
                this.a.c(this);
            }

            @Override // h.c.p
            public void onError(Throwable th) {
                this.a.d(this, th);
            }

            @Override // h.c.p
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.z(this, bVar);
            }

            @Override // h.c.p
            public void onSuccess(R r) {
                this.f15472b = r;
                this.a.b();
            }
        }

        a(z<? super R> zVar, h.c.m0.n<? super T, ? extends q<? extends R>> nVar, boolean z) {
            this.f15464b = zVar;
            this.f15465c = nVar;
            this.f15466d = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            C0373a<Object> c0373a = a;
            C0373a<Object> c0373a2 = (C0373a) this.f15468f.getAndSet(c0373a);
            if (c0373a2 == null || c0373a2 == c0373a) {
                return;
            }
            c0373a2.a();
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            z<? super R> zVar = this.f15464b;
            h.c.n0.j.c cVar = this.f15467e;
            AtomicReference<C0373a<R>> atomicReference = this.f15468f;
            int i2 = 1;
            while (!this.f15471j) {
                if (cVar.get() != null && !this.f15466d) {
                    zVar.onError(cVar.b());
                    return;
                }
                boolean z = this.f15470h;
                C0373a<R> c0373a = atomicReference.get();
                boolean z2 = c0373a == null;
                if (z && z2) {
                    Throwable b2 = cVar.b();
                    if (b2 != null) {
                        zVar.onError(b2);
                        return;
                    } else {
                        zVar.onComplete();
                        return;
                    }
                } else if (!z2 && c0373a.f15472b != null) {
                    atomicReference.compareAndSet(c0373a, null);
                    zVar.onNext((R) c0373a.f15472b);
                } else {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        void c(C0373a<R> c0373a) {
            if (this.f15468f.compareAndSet(c0373a, null)) {
                b();
            }
        }

        void d(C0373a<R> c0373a, Throwable th) {
            if (this.f15468f.compareAndSet(c0373a, null) && this.f15467e.a(th)) {
                if (!this.f15466d) {
                    this.f15469g.dispose();
                    a();
                }
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15471j = true;
            this.f15469g.dispose();
            a();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15471j;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15470h = true;
            b();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15467e.a(th)) {
                if (!this.f15466d) {
                    a();
                }
                this.f15470h = true;
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            C0373a<R> c0373a;
            C0373a<R> c0373a2 = this.f15468f.get();
            if (c0373a2 != null) {
                c0373a2.a();
            }
            try {
                q qVar = (q) h.c.n0.b.b.e(this.f15465c.apply(t), "The mapper returned a null MaybeSource");
                C0373a<R> c0373a3 = new C0373a<>(this);
                do {
                    c0373a = this.f15468f.get();
                    if (c0373a == a) {
                        return;
                    }
                } while (!this.f15468f.compareAndSet(c0373a, c0373a3));
                qVar.b(c0373a3);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15469g.dispose();
                this.f15468f.getAndSet(a);
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15469g, bVar)) {
                this.f15469g = bVar;
                this.f15464b.onSubscribe(this);
            }
        }
    }

    public l(s<T> sVar, h.c.m0.n<? super T, ? extends q<? extends R>> nVar, boolean z) {
        this.a = sVar;
        this.f15462b = nVar;
        this.f15463c = z;
    }

    @Override // h.c.s
    protected void subscribeActual(z<? super R> zVar) {
        if (n.b(this.a, this.f15462b, zVar)) {
            return;
        }
        this.a.subscribe(new a(zVar, this.f15462b, this.f15463c));
    }
}