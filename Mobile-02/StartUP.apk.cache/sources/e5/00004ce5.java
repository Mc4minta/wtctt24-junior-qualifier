package h.c.n0.e.b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableGenerate.java */
/* loaded from: classes3.dex */
public final class l1<T, S> extends h.c.h<T> {
    final Callable<S> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.c<S, h.c.g<T>, S> f14628b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.f<? super S> f14629c;

    /* compiled from: FlowableGenerate.java */
    /* loaded from: classes3.dex */
    static final class a<T, S> extends AtomicLong implements h.c.g<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.c<S, ? super h.c.g<T>, S> f14630b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.f<? super S> f14631c;

        /* renamed from: d  reason: collision with root package name */
        S f14632d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f14633e;

        /* renamed from: f  reason: collision with root package name */
        boolean f14634f;

        /* renamed from: g  reason: collision with root package name */
        boolean f14635g;

        a(k.a.c<? super T> cVar, h.c.m0.c<S, ? super h.c.g<T>, S> cVar2, h.c.m0.f<? super S> fVar, S s) {
            this.a = cVar;
            this.f14630b = cVar2;
            this.f14631c = fVar;
            this.f14632d = s;
        }

        private void a(S s) {
            try {
                this.f14631c.accept(s);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.r0.a.u(th);
            }
        }

        public void b(Throwable th) {
            if (this.f14634f) {
                h.c.r0.a.u(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f14634f = true;
            this.a.onError(th);
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f14633e) {
                return;
            }
            this.f14633e = true;
            if (h.c.n0.j.d.a(this, 1L) == 0) {
                S s = this.f14632d;
                this.f14632d = null;
                a(s);
            }
        }

        @Override // h.c.g
        public void onComplete() {
            if (this.f14634f) {
                return;
            }
            this.f14634f = true;
            this.a.onComplete();
        }

        @Override // h.c.g
        public void onNext(T t) {
            if (this.f14634f) {
                return;
            }
            if (this.f14635g) {
                b(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                b(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.f14635g = true;
                this.a.onNext(t);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2) && h.c.n0.j.d.a(this, j2) == 0) {
                S s = this.f14632d;
                h.c.m0.c<S, ? super h.c.g<T>, S> cVar = this.f14630b;
                do {
                    long j3 = 0;
                    while (true) {
                        if (j3 != j2) {
                            if (this.f14633e) {
                                this.f14632d = null;
                                a(s);
                                return;
                            }
                            this.f14635g = false;
                            try {
                                s = cVar.apply(s, this);
                                if (this.f14634f) {
                                    this.f14633e = true;
                                    this.f14632d = null;
                                    a(s);
                                    return;
                                }
                                j3++;
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.b(th);
                                this.f14633e = true;
                                this.f14632d = null;
                                b(th);
                                a(s);
                                return;
                            }
                        } else {
                            j2 = get();
                            if (j3 == j2) {
                                this.f14632d = s;
                                j2 = addAndGet(-j3);
                            }
                        }
                    }
                } while (j2 != 0);
            }
        }
    }

    public l1(Callable<S> callable, h.c.m0.c<S, h.c.g<T>, S> cVar, h.c.m0.f<? super S> fVar) {
        this.a = callable;
        this.f14628b = cVar;
        this.f14629c = fVar;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        try {
            cVar.onSubscribe(new a(cVar, this.f14628b, this.f14629c, this.a.call()));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.i.d.q(th, cVar);
        }
    }
}