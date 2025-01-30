package h.c.n0.e.d;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableSwitchMapCompletable.java */
/* loaded from: classes3.dex */
public final class d<T> extends h.c.c {
    final h.c.h<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.f> f15378b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f15379c;

    /* compiled from: FlowableSwitchMapCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, h.c.k0.b {
        static final C0366a a = new C0366a(null);

        /* renamed from: b  reason: collision with root package name */
        final h.c.e f15380b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.f> f15381c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f15382d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.j.c f15383e = new h.c.n0.j.c();

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<C0366a> f15384f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f15385g;

        /* renamed from: h  reason: collision with root package name */
        k.a.d f15386h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FlowableSwitchMapCompletable.java */
        /* renamed from: h.c.n0.e.d.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0366a extends AtomicReference<h.c.k0.b> implements h.c.e {
            final a<?> a;

            C0366a(a<?> aVar) {
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
            this.f15380b = eVar;
            this.f15381c = nVar;
            this.f15382d = z;
        }

        void a() {
            AtomicReference<C0366a> atomicReference = this.f15384f;
            C0366a c0366a = a;
            C0366a andSet = atomicReference.getAndSet(c0366a);
            if (andSet == null || andSet == c0366a) {
                return;
            }
            andSet.a();
        }

        void b(C0366a c0366a) {
            if (this.f15384f.compareAndSet(c0366a, null) && this.f15385g) {
                Throwable b2 = this.f15383e.b();
                if (b2 == null) {
                    this.f15380b.onComplete();
                } else {
                    this.f15380b.onError(b2);
                }
            }
        }

        void c(C0366a c0366a, Throwable th) {
            if (this.f15384f.compareAndSet(c0366a, null) && this.f15383e.a(th)) {
                if (this.f15382d) {
                    if (this.f15385g) {
                        this.f15380b.onError(this.f15383e.b());
                        return;
                    }
                    return;
                }
                dispose();
                Throwable b2 = this.f15383e.b();
                if (b2 != h.c.n0.j.j.a) {
                    this.f15380b.onError(b2);
                    return;
                }
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15386h.cancel();
            a();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15384f.get() == a;
        }

        @Override // k.a.c
        public void onComplete() {
            this.f15385g = true;
            if (this.f15384f.get() == null) {
                Throwable b2 = this.f15383e.b();
                if (b2 == null) {
                    this.f15380b.onComplete();
                } else {
                    this.f15380b.onError(b2);
                }
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15383e.a(th)) {
                if (this.f15382d) {
                    onComplete();
                    return;
                }
                a();
                Throwable b2 = this.f15383e.b();
                if (b2 != h.c.n0.j.j.a) {
                    this.f15380b.onError(b2);
                    return;
                }
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            C0366a c0366a;
            try {
                h.c.f fVar = (h.c.f) h.c.n0.b.b.e(this.f15381c.apply(t), "The mapper returned a null CompletableSource");
                C0366a c0366a2 = new C0366a(this);
                do {
                    c0366a = this.f15384f.get();
                    if (c0366a == a) {
                        return;
                    }
                } while (!this.f15384f.compareAndSet(c0366a, c0366a2));
                if (c0366a != null) {
                    c0366a.a();
                }
                fVar.c(c0366a2);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15386h.cancel();
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15386h, dVar)) {
                this.f15386h = dVar;
                this.f15380b.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public d(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends h.c.f> nVar, boolean z) {
        this.a = hVar;
        this.f15378b = nVar;
        this.f15379c = z;
    }

    @Override // h.c.c
    protected void t(h.c.e eVar) {
        this.a.subscribe((h.c.m) new a(eVar, this.f15378b, this.f15379c));
    }
}