package h.c.n0.e.g;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: SingleFlatMapIterableFlowable.java */
/* loaded from: classes3.dex */
public final class z<T, R> extends h.c.h<R> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends Iterable<? extends R>> f16601b;

    /* compiled from: SingleFlatMapIterableFlowable.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends h.c.n0.i.a<R> implements h.c.e0<T> {
        final k.a.c<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends Iterable<? extends R>> f16602b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicLong f16603c = new AtomicLong();

        /* renamed from: d  reason: collision with root package name */
        h.c.k0.b f16604d;

        /* renamed from: e  reason: collision with root package name */
        volatile Iterator<? extends R> f16605e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f16606f;

        /* renamed from: g  reason: collision with root package name */
        boolean f16607g;

        a(k.a.c<? super R> cVar, h.c.m0.n<? super T, ? extends Iterable<? extends R>> nVar) {
            this.a = cVar;
            this.f16602b = nVar;
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            k.a.c<? super R> cVar = this.a;
            Iterator<? extends R> it = this.f16605e;
            if (this.f16607g && it != null) {
                cVar.onNext(null);
                cVar.onComplete();
                return;
            }
            int i2 = 1;
            while (true) {
                if (it != null) {
                    long j2 = this.f16603c.get();
                    if (j2 == Long.MAX_VALUE) {
                        c(cVar, it);
                        return;
                    }
                    long j3 = 0;
                    while (j3 != j2) {
                        if (this.f16606f) {
                            return;
                        }
                        try {
                            cVar.onNext((Object) h.c.n0.b.b.e(it.next(), "The iterator returned a null value"));
                            if (this.f16606f) {
                                return;
                            }
                            j3++;
                            try {
                                if (!it.hasNext()) {
                                    cVar.onComplete();
                                    return;
                                }
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.b(th);
                                cVar.onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            cVar.onError(th2);
                            return;
                        }
                    }
                    if (j3 != 0) {
                        h.c.n0.j.d.e(this.f16603c, j3);
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
                if (it == null) {
                    it = this.f16605e;
                }
            }
        }

        void c(k.a.c<? super R> cVar, Iterator<? extends R> it) {
            while (!this.f16606f) {
                try {
                    cVar.onNext((R) it.next());
                    if (this.f16606f) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            cVar.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        cVar.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    cVar.onError(th2);
                    return;
                }
            }
        }

        @Override // k.a.d
        public void cancel() {
            this.f16606f = true;
            this.f16604d.dispose();
            this.f16604d = h.c.n0.a.c.DISPOSED;
        }

        @Override // h.c.n0.c.j
        public void clear() {
            this.f16605e = null;
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return this.f16605e == null;
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            if ((i2 & 2) != 0) {
                this.f16607g = true;
                return 2;
            }
            return 0;
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.f16604d = h.c.n0.a.c.DISPOSED;
            this.a.onError(th);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16604d, bVar)) {
                this.f16604d = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            try {
                Iterator<? extends R> it = this.f16602b.apply(t).iterator();
                if (!it.hasNext()) {
                    this.a.onComplete();
                    return;
                }
                this.f16605e = it;
                b();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.a.onError(th);
            }
        }

        @Override // h.c.n0.c.j
        public R poll() throws Exception {
            Iterator<? extends R> it = this.f16605e;
            if (it != null) {
                R r = (R) h.c.n0.b.b.e(it.next(), "The iterator returned a null value");
                if (!it.hasNext()) {
                    this.f16605e = null;
                }
                return r;
            }
            return null;
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f16603c, j2);
                b();
            }
        }
    }

    public z(h.c.h0<T> h0Var, h.c.m0.n<? super T, ? extends Iterable<? extends R>> nVar) {
        this.a = h0Var;
        this.f16601b = nVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        this.a.subscribe(new a(cVar, this.f16601b));
    }
}