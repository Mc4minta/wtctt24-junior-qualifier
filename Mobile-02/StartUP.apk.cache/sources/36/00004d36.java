package h.c.n0.e.b;

import io.reactivex.exceptions.CompositeException;

/* compiled from: FlowableDoOnEach.java */
/* loaded from: classes3.dex */
public final class q0<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.f<? super T> f14851b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.f<? super Throwable> f14852c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.m0.a f14853d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.m0.a f14854e;

    /* compiled from: FlowableDoOnEach.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.h.a<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final h.c.m0.f<? super T> f14855f;

        /* renamed from: g  reason: collision with root package name */
        final h.c.m0.f<? super Throwable> f14856g;

        /* renamed from: h  reason: collision with root package name */
        final h.c.m0.a f14857h;

        /* renamed from: j  reason: collision with root package name */
        final h.c.m0.a f14858j;

        a(h.c.n0.c.a<? super T> aVar, h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar2, h.c.m0.a aVar3) {
            super(aVar);
            this.f14855f = fVar;
            this.f14856g = fVar2;
            this.f14857h = aVar2;
            this.f14858j = aVar3;
        }

        @Override // h.c.n0.c.a
        public boolean h(T t) {
            if (this.f16709d) {
                return false;
            }
            try {
                this.f14855f.accept(t);
                return this.a.h(t);
            } catch (Throwable th) {
                c(th);
                return false;
            }
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            return d(i2);
        }

        @Override // h.c.n0.h.a, k.a.c
        public void onComplete() {
            if (this.f16709d) {
                return;
            }
            try {
                this.f14857h.run();
                this.f16709d = true;
                this.a.onComplete();
                try {
                    this.f14858j.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    h.c.r0.a.u(th);
                }
            } catch (Throwable th2) {
                c(th2);
            }
        }

        @Override // h.c.n0.h.a, k.a.c
        public void onError(Throwable th) {
            if (this.f16709d) {
                h.c.r0.a.u(th);
                return;
            }
            boolean z = true;
            this.f16709d = true;
            try {
                this.f14856g.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.a.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.a.onError(th);
            }
            try {
                this.f14858j.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                h.c.r0.a.u(th3);
            }
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f16709d) {
                return;
            }
            if (this.f16710e != 0) {
                this.a.onNext(null);
                return;
            }
            try {
                this.f14855f.accept(t);
                this.a.onNext(t);
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            try {
                T poll = this.f16708c.poll();
                if (poll != null) {
                    try {
                        this.f14855f.accept(poll);
                    } catch (Throwable th) {
                        try {
                            io.reactivex.exceptions.a.b(th);
                            this.f14856g.accept(th);
                            throw h.c.n0.j.j.c(th);
                        } finally {
                            this.f14858j.run();
                        }
                    }
                } else if (this.f16710e == 1) {
                    this.f14857h.run();
                }
                return poll;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                try {
                    this.f14856g.accept(th2);
                    throw h.c.n0.j.j.c(th2);
                } catch (Throwable th3) {
                    throw new CompositeException(th2, th3);
                }
            }
        }
    }

    /* compiled from: FlowableDoOnEach.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends h.c.n0.h.b<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final h.c.m0.f<? super T> f14859f;

        /* renamed from: g  reason: collision with root package name */
        final h.c.m0.f<? super Throwable> f14860g;

        /* renamed from: h  reason: collision with root package name */
        final h.c.m0.a f14861h;

        /* renamed from: j  reason: collision with root package name */
        final h.c.m0.a f14862j;

        b(k.a.c<? super T> cVar, h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar, h.c.m0.a aVar2) {
            super(cVar);
            this.f14859f = fVar;
            this.f14860g = fVar2;
            this.f14861h = aVar;
            this.f14862j = aVar2;
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            return d(i2);
        }

        @Override // h.c.n0.h.b, k.a.c
        public void onComplete() {
            if (this.f16713d) {
                return;
            }
            try {
                this.f14861h.run();
                this.f16713d = true;
                this.a.onComplete();
                try {
                    this.f14862j.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    h.c.r0.a.u(th);
                }
            } catch (Throwable th2) {
                c(th2);
            }
        }

        @Override // h.c.n0.h.b, k.a.c
        public void onError(Throwable th) {
            if (this.f16713d) {
                h.c.r0.a.u(th);
                return;
            }
            boolean z = true;
            this.f16713d = true;
            try {
                this.f14860g.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.a.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.a.onError(th);
            }
            try {
                this.f14862j.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                h.c.r0.a.u(th3);
            }
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f16713d) {
                return;
            }
            if (this.f16714e != 0) {
                this.a.onNext(null);
                return;
            }
            try {
                this.f14859f.accept(t);
                this.a.onNext(t);
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            try {
                T poll = this.f16712c.poll();
                if (poll != null) {
                    try {
                        this.f14859f.accept(poll);
                    } catch (Throwable th) {
                        try {
                            io.reactivex.exceptions.a.b(th);
                            this.f14860g.accept(th);
                            throw h.c.n0.j.j.c(th);
                        } finally {
                            this.f14862j.run();
                        }
                    }
                } else if (this.f16714e == 1) {
                    this.f14861h.run();
                }
                return poll;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                try {
                    this.f14860g.accept(th2);
                    throw h.c.n0.j.j.c(th2);
                } catch (Throwable th3) {
                    throw new CompositeException(th2, th3);
                }
            }
        }
    }

    public q0(h.c.h<T> hVar, h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar, h.c.m0.a aVar2) {
        super(hVar);
        this.f14851b = fVar;
        this.f14852c = fVar2;
        this.f14853d = aVar;
        this.f14854e = aVar2;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        if (cVar instanceof h.c.n0.c.a) {
            this.a.subscribe((h.c.m) new a((h.c.n0.c.a) cVar, this.f14851b, this.f14852c, this.f14853d, this.f14854e));
        } else {
            this.a.subscribe((h.c.m) new b(cVar, this.f14851b, this.f14852c, this.f14853d, this.f14854e));
        }
    }
}