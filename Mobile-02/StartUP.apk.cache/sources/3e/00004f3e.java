package h.c.n0.e.e;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableConcatMapEager.java */
/* loaded from: classes3.dex */
public final class v<T, R> extends h.c.n0.e.e.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.x<? extends R>> f16285b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.n0.j.i f16286c;

    /* renamed from: d  reason: collision with root package name */
    final int f16287d;

    /* renamed from: e  reason: collision with root package name */
    final int f16288e;

    /* compiled from: ObservableConcatMapEager.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements h.c.z<T>, h.c.k0.b, h.c.n0.d.s<R> {
        final h.c.z<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.x<? extends R>> f16289b;

        /* renamed from: c  reason: collision with root package name */
        final int f16290c;

        /* renamed from: d  reason: collision with root package name */
        final int f16291d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.j.i f16292e;

        /* renamed from: f  reason: collision with root package name */
        final h.c.n0.j.c f16293f = new h.c.n0.j.c();

        /* renamed from: g  reason: collision with root package name */
        final ArrayDeque<h.c.n0.d.r<R>> f16294g = new ArrayDeque<>();

        /* renamed from: h  reason: collision with root package name */
        h.c.n0.c.j<T> f16295h;

        /* renamed from: j  reason: collision with root package name */
        h.c.k0.b f16296j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f16297k;

        /* renamed from: l  reason: collision with root package name */
        int f16298l;
        volatile boolean m;
        h.c.n0.d.r<R> n;
        int p;

        a(h.c.z<? super R> zVar, h.c.m0.n<? super T, ? extends h.c.x<? extends R>> nVar, int i2, int i3, h.c.n0.j.i iVar) {
            this.a = zVar;
            this.f16289b = nVar;
            this.f16290c = i2;
            this.f16291d = i3;
            this.f16292e = iVar;
        }

        void a() {
            h.c.n0.d.r<R> rVar = this.n;
            if (rVar != null) {
                rVar.dispose();
            }
            while (true) {
                h.c.n0.d.r<R> poll = this.f16294g.poll();
                if (poll == null) {
                    return;
                }
                poll.dispose();
            }
        }

        @Override // h.c.n0.d.s
        public void b() {
            R poll;
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            h.c.n0.c.j<T> jVar = this.f16295h;
            ArrayDeque<h.c.n0.d.r<R>> arrayDeque = this.f16294g;
            h.c.z<? super R> zVar = this.a;
            h.c.n0.j.i iVar = this.f16292e;
            int i2 = 1;
            while (true) {
                int i3 = this.p;
                while (i3 != this.f16290c) {
                    if (this.m) {
                        jVar.clear();
                        a();
                        return;
                    } else if (iVar == h.c.n0.j.i.IMMEDIATE && this.f16293f.get() != null) {
                        jVar.clear();
                        a();
                        zVar.onError(this.f16293f.b());
                        return;
                    } else {
                        try {
                            T poll2 = jVar.poll();
                            if (poll2 == null) {
                                break;
                            }
                            h.c.x xVar = (h.c.x) h.c.n0.b.b.e(this.f16289b.apply(poll2), "The mapper returned a null ObservableSource");
                            h.c.n0.d.r<R> rVar = new h.c.n0.d.r<>(this, this.f16291d);
                            arrayDeque.offer(rVar);
                            xVar.subscribe(rVar);
                            i3++;
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.b(th);
                            this.f16296j.dispose();
                            jVar.clear();
                            a();
                            this.f16293f.a(th);
                            zVar.onError(this.f16293f.b());
                            return;
                        }
                    }
                }
                this.p = i3;
                if (this.m) {
                    jVar.clear();
                    a();
                    return;
                } else if (iVar == h.c.n0.j.i.IMMEDIATE && this.f16293f.get() != null) {
                    jVar.clear();
                    a();
                    zVar.onError(this.f16293f.b());
                    return;
                } else {
                    h.c.n0.d.r<R> rVar2 = this.n;
                    if (rVar2 == null) {
                        if (iVar == h.c.n0.j.i.BOUNDARY && this.f16293f.get() != null) {
                            jVar.clear();
                            a();
                            zVar.onError(this.f16293f.b());
                            return;
                        }
                        boolean z2 = this.f16297k;
                        h.c.n0.d.r<R> poll3 = arrayDeque.poll();
                        boolean z3 = poll3 == null;
                        if (z2 && z3) {
                            if (this.f16293f.get() != null) {
                                jVar.clear();
                                a();
                                zVar.onError(this.f16293f.b());
                                return;
                            }
                            zVar.onComplete();
                            return;
                        }
                        if (!z3) {
                            this.n = poll3;
                        }
                        rVar2 = poll3;
                    }
                    if (rVar2 != null) {
                        h.c.n0.c.j<R> b2 = rVar2.b();
                        while (!this.m) {
                            boolean a = rVar2.a();
                            if (iVar == h.c.n0.j.i.IMMEDIATE && this.f16293f.get() != null) {
                                jVar.clear();
                                a();
                                zVar.onError(this.f16293f.b());
                                return;
                            }
                            try {
                                poll = b2.poll();
                                z = poll == null;
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.b(th2);
                                this.f16293f.a(th2);
                                this.n = null;
                                this.p--;
                            }
                            if (a && z) {
                                this.n = null;
                                this.p--;
                            } else if (!z) {
                                zVar.onNext(poll);
                            }
                        }
                        jVar.clear();
                        a();
                        return;
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // h.c.n0.d.s
        public void c(h.c.n0.d.r<R> rVar, Throwable th) {
            if (this.f16293f.a(th)) {
                if (this.f16292e == h.c.n0.j.i.IMMEDIATE) {
                    this.f16296j.dispose();
                }
                rVar.c();
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.n0.d.s
        public void d(h.c.n0.d.r<R> rVar) {
            rVar.c();
            b();
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.m) {
                return;
            }
            this.m = true;
            this.f16296j.dispose();
            f();
        }

        @Override // h.c.n0.d.s
        public void e(h.c.n0.d.r<R> rVar, R r) {
            rVar.b().offer(r);
            b();
        }

        void f() {
            if (getAndIncrement() == 0) {
                do {
                    this.f16295h.clear();
                    a();
                } while (decrementAndGet() != 0);
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.m;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f16297k = true;
            b();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16293f.a(th)) {
                this.f16297k = true;
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f16298l == 0) {
                this.f16295h.offer(t);
            }
            b();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16296j, bVar)) {
                this.f16296j = bVar;
                if (bVar instanceof h.c.n0.c.e) {
                    h.c.n0.c.e eVar = (h.c.n0.c.e) bVar;
                    int n = eVar.n(3);
                    if (n == 1) {
                        this.f16298l = n;
                        this.f16295h = eVar;
                        this.f16297k = true;
                        this.a.onSubscribe(this);
                        b();
                        return;
                    } else if (n == 2) {
                        this.f16298l = n;
                        this.f16295h = eVar;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.f16295h = new h.c.n0.f.c(this.f16291d);
                this.a.onSubscribe(this);
            }
        }
    }

    public v(h.c.x<T> xVar, h.c.m0.n<? super T, ? extends h.c.x<? extends R>> nVar, h.c.n0.j.i iVar, int i2, int i3) {
        super(xVar);
        this.f16285b = nVar;
        this.f16286c = iVar;
        this.f16287d = i2;
        this.f16288e = i3;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super R> zVar) {
        this.a.subscribe(new a(zVar, this.f16285b, this.f16287d, this.f16288e, this.f16286c));
    }
}