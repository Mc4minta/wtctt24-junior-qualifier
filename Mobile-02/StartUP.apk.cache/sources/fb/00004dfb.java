package h.c.n0.e.d;

import h.c.e0;
import h.c.h0;
import h.c.s;
import h.c.z;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableConcatMapSingle.java */
/* loaded from: classes3.dex */
public final class j<T, R> extends s<R> {
    final s<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h0<? extends R>> f15440b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.n0.j.i f15441c;

    /* renamed from: d  reason: collision with root package name */
    final int f15442d;

    /* compiled from: ObservableConcatMapSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements z<T>, h.c.k0.b {
        final z<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h0<? extends R>> f15443b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.n0.j.c f15444c = new h.c.n0.j.c();

        /* renamed from: d  reason: collision with root package name */
        final C0371a<R> f15445d = new C0371a<>(this);

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.c.i<T> f15446e;

        /* renamed from: f  reason: collision with root package name */
        final h.c.n0.j.i f15447f;

        /* renamed from: g  reason: collision with root package name */
        h.c.k0.b f15448g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f15449h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f15450j;

        /* renamed from: k  reason: collision with root package name */
        R f15451k;

        /* renamed from: l  reason: collision with root package name */
        volatile int f15452l;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableConcatMapSingle.java */
        /* renamed from: h.c.n0.e.d.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0371a<R> extends AtomicReference<h.c.k0.b> implements e0<R> {
            final a<?, R> a;

            C0371a(a<?, R> aVar) {
                this.a = aVar;
            }

            void a() {
                h.c.n0.a.c.h(this);
            }

            @Override // h.c.e0
            public void onError(Throwable th) {
                this.a.b(th);
            }

            @Override // h.c.e0
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.q(this, bVar);
            }

            @Override // h.c.e0
            public void onSuccess(R r) {
                this.a.c(r);
            }
        }

        a(z<? super R> zVar, h.c.m0.n<? super T, ? extends h0<? extends R>> nVar, int i2, h.c.n0.j.i iVar) {
            this.a = zVar;
            this.f15443b = nVar;
            this.f15447f = iVar;
            this.f15446e = new h.c.n0.f.c(i2);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            z<? super R> zVar = this.a;
            h.c.n0.j.i iVar = this.f15447f;
            h.c.n0.c.i<T> iVar2 = this.f15446e;
            h.c.n0.j.c cVar = this.f15444c;
            int i2 = 1;
            while (true) {
                if (this.f15450j) {
                    iVar2.clear();
                    this.f15451k = null;
                } else {
                    int i3 = this.f15452l;
                    if (cVar.get() == null || (iVar != h.c.n0.j.i.IMMEDIATE && (iVar != h.c.n0.j.i.BOUNDARY || i3 != 0))) {
                        if (i3 == 0) {
                            boolean z = this.f15449h;
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
                                    h0 h0Var = (h0) h.c.n0.b.b.e(this.f15443b.apply(poll), "The mapper returned a null SingleSource");
                                    this.f15452l = 1;
                                    h0Var.subscribe(this.f15445d);
                                } catch (Throwable th) {
                                    io.reactivex.exceptions.a.b(th);
                                    this.f15448g.dispose();
                                    iVar2.clear();
                                    cVar.a(th);
                                    zVar.onError(cVar.b());
                                    return;
                                }
                            }
                        } else if (i3 == 2) {
                            this.f15451k = null;
                            zVar.onNext((R) this.f15451k);
                            this.f15452l = 0;
                        }
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
            iVar2.clear();
            this.f15451k = null;
            zVar.onError(cVar.b());
        }

        void b(Throwable th) {
            if (this.f15444c.a(th)) {
                if (this.f15447f != h.c.n0.j.i.END) {
                    this.f15448g.dispose();
                }
                this.f15452l = 0;
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        void c(R r) {
            this.f15451k = r;
            this.f15452l = 2;
            a();
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15450j = true;
            this.f15448g.dispose();
            this.f15445d.a();
            if (getAndIncrement() == 0) {
                this.f15446e.clear();
                this.f15451k = null;
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15450j;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15449h = true;
            a();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15444c.a(th)) {
                if (this.f15447f == h.c.n0.j.i.IMMEDIATE) {
                    this.f15445d.a();
                }
                this.f15449h = true;
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.f15446e.offer(t);
            a();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15448g, bVar)) {
                this.f15448g = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public j(s<T> sVar, h.c.m0.n<? super T, ? extends h0<? extends R>> nVar, h.c.n0.j.i iVar, int i2) {
        this.a = sVar;
        this.f15440b = nVar;
        this.f15441c = iVar;
        this.f15442d = i2;
    }

    @Override // h.c.s
    protected void subscribeActual(z<? super R> zVar) {
        if (n.c(this.a, this.f15440b, zVar)) {
            return;
        }
        this.a.subscribe(new a(zVar, this.f15440b, this.f15442d, this.f15441c));
    }
}