package h.c.n0.e.d;

import h.c.p;
import h.c.q;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableConcatMapMaybe.java */
/* loaded from: classes3.dex */
public final class b<T, R> extends h.c.h<R> {
    final h.c.h<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends q<? extends R>> f15352b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.n0.j.i f15353c;

    /* renamed from: d  reason: collision with root package name */
    final int f15354d;

    /* compiled from: FlowableConcatMapMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements h.c.m<T>, k.a.d {
        final k.a.c<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends q<? extends R>> f15355b;

        /* renamed from: c  reason: collision with root package name */
        final int f15356c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicLong f15357d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.j.c f15358e = new h.c.n0.j.c();

        /* renamed from: f  reason: collision with root package name */
        final C0364a<R> f15359f = new C0364a<>(this);

        /* renamed from: g  reason: collision with root package name */
        final h.c.n0.c.i<T> f15360g;

        /* renamed from: h  reason: collision with root package name */
        final h.c.n0.j.i f15361h;

        /* renamed from: j  reason: collision with root package name */
        k.a.d f15362j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f15363k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f15364l;
        long m;
        int n;
        R p;
        volatile int q;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FlowableConcatMapMaybe.java */
        /* renamed from: h.c.n0.e.d.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0364a<R> extends AtomicReference<h.c.k0.b> implements p<R> {
            final a<?, R> a;

            C0364a(a<?, R> aVar) {
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

        a(k.a.c<? super R> cVar, h.c.m0.n<? super T, ? extends q<? extends R>> nVar, int i2, h.c.n0.j.i iVar) {
            this.a = cVar;
            this.f15355b = nVar;
            this.f15356c = i2;
            this.f15361h = iVar;
            this.f15360g = new h.c.n0.f.b(i2);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            k.a.c<? super R> cVar = this.a;
            h.c.n0.j.i iVar = this.f15361h;
            h.c.n0.c.i<T> iVar2 = this.f15360g;
            h.c.n0.j.c cVar2 = this.f15358e;
            AtomicLong atomicLong = this.f15357d;
            int i2 = this.f15356c;
            int i3 = i2 - (i2 >> 1);
            int i4 = 1;
            while (true) {
                if (this.f15364l) {
                    iVar2.clear();
                    this.p = null;
                } else {
                    int i5 = this.q;
                    if (cVar2.get() == null || (iVar != h.c.n0.j.i.IMMEDIATE && (iVar != h.c.n0.j.i.BOUNDARY || i5 != 0))) {
                        if (i5 == 0) {
                            boolean z = this.f15363k;
                            T poll = iVar2.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable b2 = cVar2.b();
                                if (b2 == null) {
                                    cVar.onComplete();
                                    return;
                                } else {
                                    cVar.onError(b2);
                                    return;
                                }
                            } else if (!z2) {
                                int i6 = this.n + 1;
                                if (i6 == i3) {
                                    this.n = 0;
                                    this.f15362j.request(i3);
                                } else {
                                    this.n = i6;
                                }
                                try {
                                    q qVar = (q) h.c.n0.b.b.e(this.f15355b.apply(poll), "The mapper returned a null MaybeSource");
                                    this.q = 1;
                                    qVar.b(this.f15359f);
                                } catch (Throwable th) {
                                    io.reactivex.exceptions.a.b(th);
                                    this.f15362j.cancel();
                                    iVar2.clear();
                                    cVar2.a(th);
                                    cVar.onError(cVar2.b());
                                    return;
                                }
                            }
                        } else if (i5 == 2) {
                            long j2 = this.m;
                            if (j2 != atomicLong.get()) {
                                this.p = null;
                                cVar.onNext((R) this.p);
                                this.m = j2 + 1;
                                this.q = 0;
                            }
                        }
                    }
                }
                i4 = addAndGet(-i4);
                if (i4 == 0) {
                    return;
                }
            }
            iVar2.clear();
            this.p = null;
            cVar.onError(cVar2.b());
        }

        void b() {
            this.q = 0;
            a();
        }

        void c(Throwable th) {
            if (this.f15358e.a(th)) {
                if (this.f15361h != h.c.n0.j.i.END) {
                    this.f15362j.cancel();
                }
                this.q = 0;
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.d
        public void cancel() {
            this.f15364l = true;
            this.f15362j.cancel();
            this.f15359f.a();
            if (getAndIncrement() == 0) {
                this.f15360g.clear();
                this.p = null;
            }
        }

        void d(R r) {
            this.p = r;
            this.q = 2;
            a();
        }

        @Override // k.a.c
        public void onComplete() {
            this.f15363k = true;
            a();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15358e.a(th)) {
                if (this.f15361h == h.c.n0.j.i.IMMEDIATE) {
                    this.f15359f.a();
                }
                this.f15363k = true;
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (!this.f15360g.offer(t)) {
                this.f15362j.cancel();
                onError(new MissingBackpressureException("queue full?!"));
                return;
            }
            a();
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15362j, dVar)) {
                this.f15362j = dVar;
                this.a.onSubscribe(this);
                dVar.request(this.f15356c);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            h.c.n0.j.d.a(this.f15357d, j2);
            a();
        }
    }

    public b(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends q<? extends R>> nVar, h.c.n0.j.i iVar, int i2) {
        this.a = hVar;
        this.f15352b = nVar;
        this.f15353c = iVar;
        this.f15354d = i2;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f15352b, this.f15354d, this.f15353c));
    }
}