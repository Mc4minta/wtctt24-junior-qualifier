package h.c.n0.e.e;

import h.c.n0.e.e.j1;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableJoin.java */
/* loaded from: classes3.dex */
public final class q1<TLeft, TRight, TLeftEnd, TRightEnd, R> extends h.c.n0.e.e.a<TLeft, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.x<? extends TRight> f16116b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.n<? super TLeft, ? extends h.c.x<TLeftEnd>> f16117c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.m0.n<? super TRight, ? extends h.c.x<TRightEnd>> f16118d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.m0.c<? super TLeft, ? super TRight, ? extends R> f16119e;

    /* compiled from: ObservableJoin.java */
    /* loaded from: classes3.dex */
    static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements h.c.k0.b, j1.b {
        static final Integer a = 1;

        /* renamed from: b  reason: collision with root package name */
        static final Integer f16120b = 2;

        /* renamed from: c  reason: collision with root package name */
        static final Integer f16121c = 3;

        /* renamed from: d  reason: collision with root package name */
        static final Integer f16122d = 4;

        /* renamed from: e  reason: collision with root package name */
        final h.c.z<? super R> f16123e;

        /* renamed from: l  reason: collision with root package name */
        final h.c.m0.n<? super TLeft, ? extends h.c.x<TLeftEnd>> f16129l;
        final h.c.m0.n<? super TRight, ? extends h.c.x<TRightEnd>> m;
        final h.c.m0.c<? super TLeft, ? super TRight, ? extends R> n;
        int q;
        int t;
        volatile boolean u;

        /* renamed from: g  reason: collision with root package name */
        final h.c.k0.a f16125g = new h.c.k0.a();

        /* renamed from: f  reason: collision with root package name */
        final h.c.n0.f.c<Object> f16124f = new h.c.n0.f.c<>(h.c.s.bufferSize());

        /* renamed from: h  reason: collision with root package name */
        final Map<Integer, TLeft> f16126h = new LinkedHashMap();

        /* renamed from: j  reason: collision with root package name */
        final Map<Integer, TRight> f16127j = new LinkedHashMap();

        /* renamed from: k  reason: collision with root package name */
        final AtomicReference<Throwable> f16128k = new AtomicReference<>();
        final AtomicInteger p = new AtomicInteger(2);

        a(h.c.z<? super R> zVar, h.c.m0.n<? super TLeft, ? extends h.c.x<TLeftEnd>> nVar, h.c.m0.n<? super TRight, ? extends h.c.x<TRightEnd>> nVar2, h.c.m0.c<? super TLeft, ? super TRight, ? extends R> cVar) {
            this.f16123e = zVar;
            this.f16129l = nVar;
            this.m = nVar2;
            this.n = cVar;
        }

        @Override // h.c.n0.e.e.j1.b
        public void a(Throwable th) {
            if (h.c.n0.j.j.a(this.f16128k, th)) {
                this.p.decrementAndGet();
                g();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.n0.e.e.j1.b
        public void b(Throwable th) {
            if (h.c.n0.j.j.a(this.f16128k, th)) {
                g();
            } else {
                h.c.r0.a.u(th);
            }
        }

        @Override // h.c.n0.e.e.j1.b
        public void c(boolean z, Object obj) {
            synchronized (this) {
                this.f16124f.l(z ? a : f16120b, obj);
            }
            g();
        }

        @Override // h.c.n0.e.e.j1.b
        public void d(boolean z, j1.c cVar) {
            synchronized (this) {
                this.f16124f.l(z ? f16121c : f16122d, cVar);
            }
            g();
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.u) {
                return;
            }
            this.u = true;
            f();
            if (getAndIncrement() == 0) {
                this.f16124f.clear();
            }
        }

        @Override // h.c.n0.e.e.j1.b
        public void e(j1.d dVar) {
            this.f16125g.c(dVar);
            this.p.decrementAndGet();
            g();
        }

        void f() {
            this.f16125g.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void g() {
            if (getAndIncrement() != 0) {
                return;
            }
            h.c.n0.f.c<?> cVar = this.f16124f;
            h.c.z<? super R> zVar = this.f16123e;
            int i2 = 1;
            while (!this.u) {
                if (this.f16128k.get() != null) {
                    cVar.clear();
                    f();
                    h(zVar);
                    return;
                }
                boolean z = this.p.get() == 0;
                Integer num = (Integer) cVar.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    this.f16126h.clear();
                    this.f16127j.clear();
                    this.f16125g.dispose();
                    zVar.onComplete();
                    return;
                } else if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    Object poll = cVar.poll();
                    if (num == a) {
                        int i3 = this.q;
                        this.q = i3 + 1;
                        this.f16126h.put(Integer.valueOf(i3), poll);
                        try {
                            h.c.x xVar = (h.c.x) h.c.n0.b.b.e(this.f16129l.apply(poll), "The leftEnd returned a null ObservableSource");
                            j1.c cVar2 = new j1.c(this, true, i3);
                            this.f16125g.b(cVar2);
                            xVar.subscribe(cVar2);
                            if (this.f16128k.get() != null) {
                                cVar.clear();
                                f();
                                h(zVar);
                                return;
                            }
                            for (TRight tright : this.f16127j.values()) {
                                try {
                                    zVar.onNext((Object) h.c.n0.b.b.e(this.n.apply(poll, tright), "The resultSelector returned a null value"));
                                } catch (Throwable th) {
                                    i(th, zVar, cVar);
                                    return;
                                }
                            }
                            continue;
                        } catch (Throwable th2) {
                            i(th2, zVar, cVar);
                            return;
                        }
                    } else if (num == f16120b) {
                        int i4 = this.t;
                        this.t = i4 + 1;
                        this.f16127j.put(Integer.valueOf(i4), poll);
                        try {
                            h.c.x xVar2 = (h.c.x) h.c.n0.b.b.e(this.m.apply(poll), "The rightEnd returned a null ObservableSource");
                            j1.c cVar3 = new j1.c(this, false, i4);
                            this.f16125g.b(cVar3);
                            xVar2.subscribe(cVar3);
                            if (this.f16128k.get() != null) {
                                cVar.clear();
                                f();
                                h(zVar);
                                return;
                            }
                            for (TLeft tleft : this.f16126h.values()) {
                                try {
                                    zVar.onNext((Object) h.c.n0.b.b.e(this.n.apply(tleft, poll), "The resultSelector returned a null value"));
                                } catch (Throwable th3) {
                                    i(th3, zVar, cVar);
                                    return;
                                }
                            }
                            continue;
                        } catch (Throwable th4) {
                            i(th4, zVar, cVar);
                            return;
                        }
                    } else if (num == f16121c) {
                        j1.c cVar4 = (j1.c) poll;
                        this.f16126h.remove(Integer.valueOf(cVar4.f15845c));
                        this.f16125g.a(cVar4);
                    } else {
                        j1.c cVar5 = (j1.c) poll;
                        this.f16127j.remove(Integer.valueOf(cVar5.f15845c));
                        this.f16125g.a(cVar5);
                    }
                }
            }
            cVar.clear();
        }

        void h(h.c.z<?> zVar) {
            Throwable b2 = h.c.n0.j.j.b(this.f16128k);
            this.f16126h.clear();
            this.f16127j.clear();
            zVar.onError(b2);
        }

        void i(Throwable th, h.c.z<?> zVar, h.c.n0.f.c<?> cVar) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.j.j.a(this.f16128k, th);
            cVar.clear();
            f();
            h(zVar);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.u;
        }
    }

    public q1(h.c.x<TLeft> xVar, h.c.x<? extends TRight> xVar2, h.c.m0.n<? super TLeft, ? extends h.c.x<TLeftEnd>> nVar, h.c.m0.n<? super TRight, ? extends h.c.x<TRightEnd>> nVar2, h.c.m0.c<? super TLeft, ? super TRight, ? extends R> cVar) {
        super(xVar);
        this.f16116b = xVar2;
        this.f16117c = nVar;
        this.f16118d = nVar2;
        this.f16119e = cVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super R> zVar) {
        a aVar = new a(zVar, this.f16117c, this.f16118d, this.f16119e);
        zVar.onSubscribe(aVar);
        j1.d dVar = new j1.d(aVar, true);
        aVar.f16125g.b(dVar);
        j1.d dVar2 = new j1.d(aVar, false);
        aVar.f16125g.b(dVar2);
        this.a.subscribe(dVar);
        this.f16116b.subscribe(dVar2);
    }
}