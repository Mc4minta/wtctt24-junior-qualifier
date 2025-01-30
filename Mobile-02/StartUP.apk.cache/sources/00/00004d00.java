package h.c.n0.e.b;

import h.c.n0.e.b.l3;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FlowableSequenceEqualSingle.java */
/* loaded from: classes3.dex */
public final class m3<T> extends h.c.b0<Boolean> implements h.c.n0.c.b<Boolean> {
    final k.a.b<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final k.a.b<? extends T> f14717b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.d<? super T, ? super T> f14718c;

    /* renamed from: d  reason: collision with root package name */
    final int f14719d;

    /* compiled from: FlowableSequenceEqualSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.k0.b, l3.b {
        final h.c.e0<? super Boolean> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.d<? super T, ? super T> f14720b;

        /* renamed from: c  reason: collision with root package name */
        final l3.c<T> f14721c;

        /* renamed from: d  reason: collision with root package name */
        final l3.c<T> f14722d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.j.c f14723e = new h.c.n0.j.c();

        /* renamed from: f  reason: collision with root package name */
        T f14724f;

        /* renamed from: g  reason: collision with root package name */
        T f14725g;

        a(h.c.e0<? super Boolean> e0Var, int i2, h.c.m0.d<? super T, ? super T> dVar) {
            this.a = e0Var;
            this.f14720b = dVar;
            this.f14721c = new l3.c<>(this, i2);
            this.f14722d = new l3.c<>(this, i2);
        }

        @Override // h.c.n0.e.b.l3.b
        public void a(Throwable th) {
            if (this.f14723e.a(th)) {
                b();
            } else {
                h.c.r0.a.u(th);
            }
        }

        @Override // h.c.n0.e.b.l3.b
        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            int i2 = 1;
            do {
                h.c.n0.c.j<T> jVar = this.f14721c.f14653e;
                h.c.n0.c.j<T> jVar2 = this.f14722d.f14653e;
                if (jVar != null && jVar2 != null) {
                    while (!isDisposed()) {
                        if (this.f14723e.get() != null) {
                            c();
                            this.a.onError(this.f14723e.b());
                            return;
                        }
                        boolean z = this.f14721c.f14654f;
                        T t = this.f14724f;
                        if (t == null) {
                            try {
                                t = jVar.poll();
                                this.f14724f = t;
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.b(th);
                                c();
                                this.f14723e.a(th);
                                this.a.onError(this.f14723e.b());
                                return;
                            }
                        }
                        boolean z2 = t == null;
                        boolean z3 = this.f14722d.f14654f;
                        T t2 = this.f14725g;
                        if (t2 == null) {
                            try {
                                t2 = jVar2.poll();
                                this.f14725g = t2;
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.b(th2);
                                c();
                                this.f14723e.a(th2);
                                this.a.onError(this.f14723e.b());
                                return;
                            }
                        }
                        boolean z4 = t2 == null;
                        if (z && z3 && z2 && z4) {
                            this.a.onSuccess(Boolean.TRUE);
                            return;
                        } else if (z && z3 && z2 != z4) {
                            c();
                            this.a.onSuccess(Boolean.FALSE);
                            return;
                        } else if (!z2 && !z4) {
                            try {
                                if (!this.f14720b.a(t, t2)) {
                                    c();
                                    this.a.onSuccess(Boolean.FALSE);
                                    return;
                                }
                                this.f14724f = null;
                                this.f14725g = null;
                                this.f14721c.c();
                                this.f14722d.c();
                            } catch (Throwable th3) {
                                io.reactivex.exceptions.a.b(th3);
                                c();
                                this.f14723e.a(th3);
                                this.a.onError(this.f14723e.b());
                                return;
                            }
                        }
                    }
                    this.f14721c.b();
                    this.f14722d.b();
                    return;
                } else if (isDisposed()) {
                    this.f14721c.b();
                    this.f14722d.b();
                    return;
                } else if (this.f14723e.get() != null) {
                    c();
                    this.a.onError(this.f14723e.b());
                    return;
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }

        void c() {
            this.f14721c.a();
            this.f14721c.b();
            this.f14722d.a();
            this.f14722d.b();
        }

        void d(k.a.b<? extends T> bVar, k.a.b<? extends T> bVar2) {
            bVar.subscribe(this.f14721c);
            bVar2.subscribe(this.f14722d);
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f14721c.a();
            this.f14722d.a();
            if (getAndIncrement() == 0) {
                this.f14721c.b();
                this.f14722d.b();
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14721c.get() == h.c.n0.i.g.CANCELLED;
        }
    }

    public m3(k.a.b<? extends T> bVar, k.a.b<? extends T> bVar2, h.c.m0.d<? super T, ? super T> dVar, int i2) {
        this.a = bVar;
        this.f14717b = bVar2;
        this.f14718c = dVar;
        this.f14719d = i2;
    }

    @Override // h.c.n0.c.b
    public h.c.h<Boolean> e() {
        return h.c.r0.a.l(new l3(this.a, this.f14717b, this.f14718c, this.f14719d));
    }

    @Override // h.c.b0
    public void subscribeActual(h.c.e0<? super Boolean> e0Var) {
        a aVar = new a(e0Var, this.f14719d, this.f14718c);
        e0Var.onSubscribe(aVar);
        aVar.d(this.a, this.f14717b);
    }
}