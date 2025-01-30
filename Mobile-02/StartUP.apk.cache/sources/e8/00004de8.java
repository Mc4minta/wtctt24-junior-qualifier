package h.c.n0.e.d;

import h.c.e0;
import h.c.h0;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableConcatMapSingle.java */
/* loaded from: classes3.dex */
public final class c<T, R> extends h.c.h<R> {
    final h.c.h<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h0<? extends R>> f15365b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.n0.j.i f15366c;

    /* renamed from: d  reason: collision with root package name */
    final int f15367d;

    /* compiled from: FlowableConcatMapSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements h.c.m<T>, k.a.d {
        final k.a.c<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h0<? extends R>> f15368b;

        /* renamed from: c  reason: collision with root package name */
        final int f15369c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicLong f15370d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.j.c f15371e = new h.c.n0.j.c();

        /* renamed from: f  reason: collision with root package name */
        final C0365a<R> f15372f = new C0365a<>(this);

        /* renamed from: g  reason: collision with root package name */
        final h.c.n0.c.i<T> f15373g;

        /* renamed from: h  reason: collision with root package name */
        final h.c.n0.j.i f15374h;

        /* renamed from: j  reason: collision with root package name */
        k.a.d f15375j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f15376k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f15377l;
        long m;
        int n;
        R p;
        volatile int q;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FlowableConcatMapSingle.java */
        /* renamed from: h.c.n0.e.d.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0365a<R> extends AtomicReference<h.c.k0.b> implements e0<R> {
            final a<?, R> a;

            C0365a(a<?, R> aVar) {
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

        a(k.a.c<? super R> cVar, h.c.m0.n<? super T, ? extends h0<? extends R>> nVar, int i2, h.c.n0.j.i iVar) {
            this.a = cVar;
            this.f15368b = nVar;
            this.f15369c = i2;
            this.f15374h = iVar;
            this.f15373g = new h.c.n0.f.b(i2);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            k.a.c<? super R> cVar = this.a;
            h.c.n0.j.i iVar = this.f15374h;
            h.c.n0.c.i<T> iVar2 = this.f15373g;
            h.c.n0.j.c cVar2 = this.f15371e;
            AtomicLong atomicLong = this.f15370d;
            int i2 = this.f15369c;
            int i3 = i2 - (i2 >> 1);
            int i4 = 1;
            while (true) {
                if (this.f15377l) {
                    iVar2.clear();
                    this.p = null;
                } else {
                    int i5 = this.q;
                    if (cVar2.get() == null || (iVar != h.c.n0.j.i.IMMEDIATE && (iVar != h.c.n0.j.i.BOUNDARY || i5 != 0))) {
                        if (i5 == 0) {
                            boolean z = this.f15376k;
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
                                    this.f15375j.request(i3);
                                } else {
                                    this.n = i6;
                                }
                                try {
                                    h0 h0Var = (h0) h.c.n0.b.b.e(this.f15368b.apply(poll), "The mapper returned a null SingleSource");
                                    this.q = 1;
                                    h0Var.subscribe(this.f15372f);
                                } catch (Throwable th) {
                                    io.reactivex.exceptions.a.b(th);
                                    this.f15375j.cancel();
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

        void b(Throwable th) {
            if (this.f15371e.a(th)) {
                if (this.f15374h != h.c.n0.j.i.END) {
                    this.f15375j.cancel();
                }
                this.q = 0;
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        void c(R r) {
            this.p = r;
            this.q = 2;
            a();
        }

        @Override // k.a.d
        public void cancel() {
            this.f15377l = true;
            this.f15375j.cancel();
            this.f15372f.a();
            if (getAndIncrement() == 0) {
                this.f15373g.clear();
                this.p = null;
            }
        }

        @Override // k.a.c
        public void onComplete() {
            this.f15376k = true;
            a();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15371e.a(th)) {
                if (this.f15374h == h.c.n0.j.i.IMMEDIATE) {
                    this.f15372f.a();
                }
                this.f15376k = true;
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (!this.f15373g.offer(t)) {
                this.f15375j.cancel();
                onError(new MissingBackpressureException("queue full?!"));
                return;
            }
            a();
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15375j, dVar)) {
                this.f15375j = dVar;
                this.a.onSubscribe(this);
                dVar.request(this.f15369c);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            h.c.n0.j.d.a(this.f15370d, j2);
            a();
        }
    }

    public c(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends h0<? extends R>> nVar, h.c.n0.j.i iVar, int i2) {
        this.a = hVar;
        this.f15365b = nVar;
        this.f15366c = iVar;
        this.f15367d = i2;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f15365b, this.f15367d, this.f15366c));
    }
}