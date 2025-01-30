package h.c.n0.e.d;

import h.c.s;
import h.c.z;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSwitchMapCompletable.java */
/* loaded from: classes3.dex */
public final class k<T> extends h.c.c {
    final s<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.f> f15453b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f15454c;

    /* compiled from: ObservableSwitchMapCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements z<T>, h.c.k0.b {
        static final C0372a a = new C0372a(null);

        /* renamed from: b  reason: collision with root package name */
        final h.c.e f15455b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.f> f15456c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f15457d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.j.c f15458e = new h.c.n0.j.c();

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<C0372a> f15459f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f15460g;

        /* renamed from: h  reason: collision with root package name */
        h.c.k0.b f15461h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableSwitchMapCompletable.java */
        /* renamed from: h.c.n0.e.d.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0372a extends AtomicReference<h.c.k0.b> implements h.c.e {
            final a<?> a;

            C0372a(a<?> aVar) {
                this.a = aVar;
            }

            void a() {
                h.c.n0.a.c.h(this);
            }

            @Override // h.c.e
            public void onComplete() {
                this.a.b(this);
            }

            @Override // h.c.e
            public void onError(Throwable th) {
                this.a.c(this, th);
            }

            @Override // h.c.e
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.z(this, bVar);
            }
        }

        a(h.c.e eVar, h.c.m0.n<? super T, ? extends h.c.f> nVar, boolean z) {
            this.f15455b = eVar;
            this.f15456c = nVar;
            this.f15457d = z;
        }

        void a() {
            AtomicReference<C0372a> atomicReference = this.f15459f;
            C0372a c0372a = a;
            C0372a andSet = atomicReference.getAndSet(c0372a);
            if (andSet == null || andSet == c0372a) {
                return;
            }
            andSet.a();
        }

        void b(C0372a c0372a) {
            if (this.f15459f.compareAndSet(c0372a, null) && this.f15460g) {
                Throwable b2 = this.f15458e.b();
                if (b2 == null) {
                    this.f15455b.onComplete();
                } else {
                    this.f15455b.onError(b2);
                }
            }
        }

        void c(C0372a c0372a, Throwable th) {
            if (this.f15459f.compareAndSet(c0372a, null) && this.f15458e.a(th)) {
                if (this.f15457d) {
                    if (this.f15460g) {
                        this.f15455b.onError(this.f15458e.b());
                        return;
                    }
                    return;
                }
                dispose();
                Throwable b2 = this.f15458e.b();
                if (b2 != h.c.n0.j.j.a) {
                    this.f15455b.onError(b2);
                    return;
                }
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15461h.dispose();
            a();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15459f.get() == a;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15460g = true;
            if (this.f15459f.get() == null) {
                Throwable b2 = this.f15458e.b();
                if (b2 == null) {
                    this.f15455b.onComplete();
                } else {
                    this.f15455b.onError(b2);
                }
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15458e.a(th)) {
                if (this.f15457d) {
                    onComplete();
                    return;
                }
                a();
                Throwable b2 = this.f15458e.b();
                if (b2 != h.c.n0.j.j.a) {
                    this.f15455b.onError(b2);
                    return;
                }
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            C0372a c0372a;
            try {
                h.c.f fVar = (h.c.f) h.c.n0.b.b.e(this.f15456c.apply(t), "The mapper returned a null CompletableSource");
                C0372a c0372a2 = new C0372a(this);
                do {
                    c0372a = this.f15459f.get();
                    if (c0372a == a) {
                        return;
                    }
                } while (!this.f15459f.compareAndSet(c0372a, c0372a2));
                if (c0372a != null) {
                    c0372a.a();
                }
                fVar.c(c0372a2);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15461h.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15461h, bVar)) {
                this.f15461h = bVar;
                this.f15455b.onSubscribe(this);
            }
        }
    }

    public k(s<T> sVar, h.c.m0.n<? super T, ? extends h.c.f> nVar, boolean z) {
        this.a = sVar;
        this.f15453b = nVar;
        this.f15454c = z;
    }

    @Override // h.c.c
    protected void t(h.c.e eVar) {
        if (n.a(this.a, this.f15453b, eVar)) {
            return;
        }
        this.a.subscribe(new a(eVar, this.f15453b, this.f15454c));
    }
}