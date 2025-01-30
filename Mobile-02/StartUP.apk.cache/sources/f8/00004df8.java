package h.c.n0.e.d;

import h.c.p;
import h.c.q;
import h.c.s;
import h.c.z;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableConcatMapMaybe.java */
/* loaded from: classes3.dex */
public final class i<T, R> extends s<R> {
    final s<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends q<? extends R>> f15427b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.n0.j.i f15428c;

    /* renamed from: d  reason: collision with root package name */
    final int f15429d;

    /* compiled from: ObservableConcatMapMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements z<T>, h.c.k0.b {
        final z<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends q<? extends R>> f15430b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.n0.j.c f15431c = new h.c.n0.j.c();

        /* renamed from: d  reason: collision with root package name */
        final C0370a<R> f15432d = new C0370a<>(this);

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.c.i<T> f15433e;

        /* renamed from: f  reason: collision with root package name */
        final h.c.n0.j.i f15434f;

        /* renamed from: g  reason: collision with root package name */
        h.c.k0.b f15435g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f15436h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f15437j;

        /* renamed from: k  reason: collision with root package name */
        R f15438k;

        /* renamed from: l  reason: collision with root package name */
        volatile int f15439l;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableConcatMapMaybe.java */
        /* renamed from: h.c.n0.e.d.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0370a<R> extends AtomicReference<h.c.k0.b> implements p<R> {
            final a<?, R> a;

            C0370a(a<?, R> aVar) {
                this.a = aVar;
            }

            void a() {
                h.c.n0.a.c.h(this);
            }

            @Override // h.c.p
            public void onComplete() {
                this.a.b();
            }

            @Override // h.c.p
            public void onError(Throwable th) {
                this.a.c(th);
            }

            @Override // h.c.p
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.q(this, bVar);
            }

            @Override // h.c.p
            public void onSuccess(R r) {
                this.a.d(r);
            }
        }

        a(z<? super R> zVar, h.c.m0.n<? super T, ? extends q<? extends R>> nVar, int i2, h.c.n0.j.i iVar) {
            this.a = zVar;
            this.f15430b = nVar;
            this.f15434f = iVar;
            this.f15433e = new h.c.n0.f.c(i2);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            z<? super R> zVar = this.a;
            h.c.n0.j.i iVar = this.f15434f;
            h.c.n0.c.i<T> iVar2 = this.f15433e;
            h.c.n0.j.c cVar = this.f15431c;
            int i2 = 1;
            while (true) {
                if (this.f15437j) {
                    iVar2.clear();
                    this.f15438k = null;
                } else {
                    int i3 = this.f15439l;
                    if (cVar.get() == null || (iVar != h.c.n0.j.i.IMMEDIATE && (iVar != h.c.n0.j.i.BOUNDARY || i3 != 0))) {
                        if (i3 == 0) {
                            boolean z = this.f15436h;
                            T poll = iVar2.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable b2 = cVar.b();
                                if (b2 == null) {
                                    zVar.onComplete();
                                    return;
                                } else {
                                    zVar.onError(b2);
                                    return;
                                }
                            } else if (!z2) {
                                try {
                                    q qVar = (q) h.c.n0.b.b.e(this.f15430b.apply(poll), "The mapper returned a null MaybeSource");
                                    this.f15439l = 1;
                                    qVar.b(this.f15432d);
                                } catch (Throwable th) {
                                    io.reactivex.exceptions.a.b(th);
                                    this.f15435g.dispose();
                                    iVar2.clear();
                                    cVar.a(th);
                                    zVar.onError(cVar.b());
                                    return;
                                }
                            }
                        } else if (i3 == 2) {
                            this.f15438k = null;
                            zVar.onNext((R) this.f15438k);
                            this.f15439l = 0;
                        }
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
            iVar2.clear();
            this.f15438k = null;
            zVar.onError(cVar.b());
        }

        void b() {
            this.f15439l = 0;
            a();
        }

        void c(Throwable th) {
            if (this.f15431c.a(th)) {
                if (this.f15434f != h.c.n0.j.i.END) {
                    this.f15435g.dispose();
                }
                this.f15439l = 0;
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        void d(R r) {
            this.f15438k = r;
            this.f15439l = 2;
            a();
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15437j = true;
            this.f15435g.dispose();
            this.f15432d.a();
            if (getAndIncrement() == 0) {
                this.f15433e.clear();
                this.f15438k = null;
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15437j;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15436h = true;
            a();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15431c.a(th)) {
                if (this.f15434f == h.c.n0.j.i.IMMEDIATE) {
                    this.f15432d.a();
                }
                this.f15436h = true;
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.f15433e.offer(t);
            a();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15435g, bVar)) {
                this.f15435g = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public i(s<T> sVar, h.c.m0.n<? super T, ? extends q<? extends R>> nVar, h.c.n0.j.i iVar, int i2) {
        this.a = sVar;
        this.f15427b = nVar;
        this.f15428c = iVar;
        this.f15429d = i2;
    }

    @Override // h.c.s
    protected void subscribeActual(z<? super R> zVar) {
        if (n.b(this.a, this.f15427b, zVar)) {
            return;
        }
        this.a.subscribe(new a(zVar, this.f15427b, this.f15429d, this.f15428c));
    }
}