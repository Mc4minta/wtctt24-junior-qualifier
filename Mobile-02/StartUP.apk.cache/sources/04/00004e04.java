package h.c.n0.e.d;

import h.c.e0;
import h.c.h0;
import h.c.s;
import h.c.z;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSwitchMapSingle.java */
/* loaded from: classes3.dex */
public final class m<T, R> extends s<R> {
    final s<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h0<? extends R>> f15473b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f15474c;

    /* compiled from: ObservableSwitchMapSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements z<T>, h.c.k0.b {
        static final C0374a<Object> a = new C0374a<>(null);

        /* renamed from: b  reason: collision with root package name */
        final z<? super R> f15475b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h0<? extends R>> f15476c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f15477d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.j.c f15478e = new h.c.n0.j.c();

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<C0374a<R>> f15479f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        h.c.k0.b f15480g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f15481h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f15482j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableSwitchMapSingle.java */
        /* renamed from: h.c.n0.e.d.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0374a<R> extends AtomicReference<h.c.k0.b> implements e0<R> {
            final a<?, R> a;

            /* renamed from: b  reason: collision with root package name */
            volatile R f15483b;

            C0374a(a<?, R> aVar) {
                this.a = aVar;
            }

            void a() {
                h.c.n0.a.c.h(this);
            }

            @Override // h.c.e0
            public void onError(Throwable th) {
                this.a.c(this, th);
            }

            @Override // h.c.e0
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.z(this, bVar);
            }

            @Override // h.c.e0
            public void onSuccess(R r) {
                this.f15483b = r;
                this.a.b();
            }
        }

        a(z<? super R> zVar, h.c.m0.n<? super T, ? extends h0<? extends R>> nVar, boolean z) {
            this.f15475b = zVar;
            this.f15476c = nVar;
            this.f15477d = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            C0374a<Object> c0374a = a;
            C0374a<Object> c0374a2 = (C0374a) this.f15479f.getAndSet(c0374a);
            if (c0374a2 == null || c0374a2 == c0374a) {
                return;
            }
            c0374a2.a();
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            z<? super R> zVar = this.f15475b;
            h.c.n0.j.c cVar = this.f15478e;
            AtomicReference<C0374a<R>> atomicReference = this.f15479f;
            int i2 = 1;
            while (!this.f15482j) {
                if (cVar.get() != null && !this.f15477d) {
                    zVar.onError(cVar.b());
                    return;
                }
                boolean z = this.f15481h;
                C0374a<R> c0374a = atomicReference.get();
                boolean z2 = c0374a == null;
                if (z && z2) {
                    Throwable b2 = cVar.b();
                    if (b2 != null) {
                        zVar.onError(b2);
                        return;
                    } else {
                        zVar.onComplete();
                        return;
                    }
                } else if (!z2 && c0374a.f15483b != null) {
                    atomicReference.compareAndSet(c0374a, null);
                    zVar.onNext((R) c0374a.f15483b);
                } else {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        void c(C0374a<R> c0374a, Throwable th) {
            if (this.f15479f.compareAndSet(c0374a, null) && this.f15478e.a(th)) {
                if (!this.f15477d) {
                    this.f15480g.dispose();
                    a();
                }
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15482j = true;
            this.f15480g.dispose();
            a();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15482j;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15481h = true;
            b();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15478e.a(th)) {
                if (!this.f15477d) {
                    a();
                }
                this.f15481h = true;
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            C0374a<R> c0374a;
            C0374a<R> c0374a2 = this.f15479f.get();
            if (c0374a2 != null) {
                c0374a2.a();
            }
            try {
                h0 h0Var = (h0) h.c.n0.b.b.e(this.f15476c.apply(t), "The mapper returned a null SingleSource");
                C0374a<R> c0374a3 = new C0374a<>(this);
                do {
                    c0374a = this.f15479f.get();
                    if (c0374a == a) {
                        return;
                    }
                } while (!this.f15479f.compareAndSet(c0374a, c0374a3));
                h0Var.subscribe(c0374a3);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15480g.dispose();
                this.f15479f.getAndSet(a);
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15480g, bVar)) {
                this.f15480g = bVar;
                this.f15475b.onSubscribe(this);
            }
        }
    }

    public m(s<T> sVar, h.c.m0.n<? super T, ? extends h0<? extends R>> nVar, boolean z) {
        this.a = sVar;
        this.f15473b = nVar;
        this.f15474c = z;
    }

    @Override // h.c.s
    protected void subscribeActual(z<? super R> zVar) {
        if (n.c(this.a, this.f15473b, zVar)) {
            return;
        }
        this.a.subscribe(new a(zVar, this.f15473b, this.f15474c));
    }
}