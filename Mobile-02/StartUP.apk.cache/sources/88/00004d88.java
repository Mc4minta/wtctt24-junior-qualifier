package h.c.n0.e.b;

import h.c.n0.e.b.n1;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableJoin.java */
/* loaded from: classes3.dex */
public final class u1<TLeft, TRight, TLeftEnd, TRightEnd, R> extends h.c.n0.e.b.a<TLeft, R> {

    /* renamed from: b  reason: collision with root package name */
    final k.a.b<? extends TRight> f15079b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.n<? super TLeft, ? extends k.a.b<TLeftEnd>> f15080c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.m0.n<? super TRight, ? extends k.a.b<TRightEnd>> f15081d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.m0.c<? super TLeft, ? super TRight, ? extends R> f15082e;

    /* compiled from: FlowableJoin.java */
    /* loaded from: classes3.dex */
    static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements k.a.d, n1.b {
        static final Integer a = 1;

        /* renamed from: b  reason: collision with root package name */
        static final Integer f15083b = 2;

        /* renamed from: c  reason: collision with root package name */
        static final Integer f15084c = 3;

        /* renamed from: d  reason: collision with root package name */
        static final Integer f15085d = 4;

        /* renamed from: e  reason: collision with root package name */
        final k.a.c<? super R> f15086e;
        final h.c.m0.n<? super TLeft, ? extends k.a.b<TLeftEnd>> m;
        final h.c.m0.n<? super TRight, ? extends k.a.b<TRightEnd>> n;
        final h.c.m0.c<? super TLeft, ? super TRight, ? extends R> p;
        int t;
        int u;
        volatile boolean v;

        /* renamed from: f  reason: collision with root package name */
        final AtomicLong f15087f = new AtomicLong();

        /* renamed from: h  reason: collision with root package name */
        final h.c.k0.a f15089h = new h.c.k0.a();

        /* renamed from: g  reason: collision with root package name */
        final h.c.n0.f.c<Object> f15088g = new h.c.n0.f.c<>(h.c.h.bufferSize());

        /* renamed from: j  reason: collision with root package name */
        final Map<Integer, TLeft> f15090j = new LinkedHashMap();

        /* renamed from: k  reason: collision with root package name */
        final Map<Integer, TRight> f15091k = new LinkedHashMap();

        /* renamed from: l  reason: collision with root package name */
        final AtomicReference<Throwable> f15092l = new AtomicReference<>();
        final AtomicInteger q = new AtomicInteger(2);

        a(k.a.c<? super R> cVar, h.c.m0.n<? super TLeft, ? extends k.a.b<TLeftEnd>> nVar, h.c.m0.n<? super TRight, ? extends k.a.b<TRightEnd>> nVar2, h.c.m0.c<? super TLeft, ? super TRight, ? extends R> cVar2) {
            this.f15086e = cVar;
            this.m = nVar;
            this.n = nVar2;
            this.p = cVar2;
        }

        @Override // h.c.n0.e.b.n1.b
        public void a(Throwable th) {
            if (h.c.n0.j.j.a(this.f15092l, th)) {
                this.q.decrementAndGet();
                g();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.n0.e.b.n1.b
        public void b(Throwable th) {
            if (h.c.n0.j.j.a(this.f15092l, th)) {
                g();
            } else {
                h.c.r0.a.u(th);
            }
        }

        @Override // h.c.n0.e.b.n1.b
        public void c(boolean z, Object obj) {
            synchronized (this) {
                this.f15088g.l(z ? a : f15083b, obj);
            }
            g();
        }

        @Override // k.a.d
        public void cancel() {
            if (this.v) {
                return;
            }
            this.v = true;
            f();
            if (getAndIncrement() == 0) {
                this.f15088g.clear();
            }
        }

        @Override // h.c.n0.e.b.n1.b
        public void d(boolean z, n1.c cVar) {
            synchronized (this) {
                this.f15088g.l(z ? f15084c : f15085d, cVar);
            }
            g();
        }

        @Override // h.c.n0.e.b.n1.b
        public void e(n1.d dVar) {
            this.f15089h.c(dVar);
            this.q.decrementAndGet();
            g();
        }

        void f() {
            this.f15089h.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void g() {
            if (getAndIncrement() != 0) {
                return;
            }
            h.c.n0.f.c<Object> cVar = this.f15088g;
            k.a.c<? super R> cVar2 = this.f15086e;
            boolean z = true;
            int i2 = 1;
            while (!this.v) {
                if (this.f15092l.get() != null) {
                    cVar.clear();
                    f();
                    h(cVar2);
                    return;
                }
                boolean z2 = this.q.get() == 0 ? z : false;
                Integer num = (Integer) cVar.poll();
                boolean z3 = num == null ? z : false;
                if (z2 && z3) {
                    this.f15090j.clear();
                    this.f15091k.clear();
                    this.f15089h.dispose();
                    cVar2.onComplete();
                    return;
                } else if (z3) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    Object poll = cVar.poll();
                    if (num == a) {
                        int i3 = this.t;
                        this.t = i3 + 1;
                        this.f15090j.put(Integer.valueOf(i3), poll);
                        try {
                            k.a.b bVar = (k.a.b) h.c.n0.b.b.e(this.m.apply(poll), "The leftEnd returned a null Publisher");
                            n1.c cVar3 = new n1.c(this, z, i3);
                            this.f15089h.b(cVar3);
                            bVar.subscribe(cVar3);
                            if (this.f15092l.get() != null) {
                                cVar.clear();
                                f();
                                h(cVar2);
                                return;
                            }
                            long j2 = this.f15087f.get();
                            long j3 = 0;
                            for (TRight tright : this.f15091k.values()) {
                                try {
                                    Object obj = (Object) h.c.n0.b.b.e(this.p.apply(poll, tright), "The resultSelector returned a null value");
                                    if (j3 != j2) {
                                        cVar2.onNext(obj);
                                        j3++;
                                    } else {
                                        h.c.n0.j.j.a(this.f15092l, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                        cVar.clear();
                                        f();
                                        h(cVar2);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    i(th, cVar2, cVar);
                                    return;
                                }
                            }
                            if (j3 != 0) {
                                h.c.n0.j.d.e(this.f15087f, j3);
                            }
                        } catch (Throwable th2) {
                            i(th2, cVar2, cVar);
                            return;
                        }
                    } else if (num == f15083b) {
                        int i4 = this.u;
                        this.u = i4 + 1;
                        this.f15091k.put(Integer.valueOf(i4), poll);
                        try {
                            k.a.b bVar2 = (k.a.b) h.c.n0.b.b.e(this.n.apply(poll), "The rightEnd returned a null Publisher");
                            n1.c cVar4 = new n1.c(this, false, i4);
                            this.f15089h.b(cVar4);
                            bVar2.subscribe(cVar4);
                            if (this.f15092l.get() != null) {
                                cVar.clear();
                                f();
                                h(cVar2);
                                return;
                            }
                            long j4 = this.f15087f.get();
                            long j5 = 0;
                            for (TLeft tleft : this.f15090j.values()) {
                                try {
                                    Object obj2 = (Object) h.c.n0.b.b.e(this.p.apply(tleft, poll), "The resultSelector returned a null value");
                                    if (j5 != j4) {
                                        cVar2.onNext(obj2);
                                        j5++;
                                    } else {
                                        h.c.n0.j.j.a(this.f15092l, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                        cVar.clear();
                                        f();
                                        h(cVar2);
                                        return;
                                    }
                                } catch (Throwable th3) {
                                    i(th3, cVar2, cVar);
                                    return;
                                }
                            }
                            if (j5 != 0) {
                                h.c.n0.j.d.e(this.f15087f, j5);
                            }
                        } catch (Throwable th4) {
                            i(th4, cVar2, cVar);
                            return;
                        }
                    } else if (num == f15084c) {
                        n1.c cVar5 = (n1.c) poll;
                        this.f15090j.remove(Integer.valueOf(cVar5.f14762c));
                        this.f15089h.a(cVar5);
                    } else if (num == f15085d) {
                        n1.c cVar6 = (n1.c) poll;
                        this.f15091k.remove(Integer.valueOf(cVar6.f14762c));
                        this.f15089h.a(cVar6);
                    }
                    z = true;
                }
            }
            cVar.clear();
        }

        void h(k.a.c<?> cVar) {
            Throwable b2 = h.c.n0.j.j.b(this.f15092l);
            this.f15090j.clear();
            this.f15091k.clear();
            cVar.onError(b2);
        }

        void i(Throwable th, k.a.c<?> cVar, h.c.n0.c.j<?> jVar) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.j.j.a(this.f15092l, th);
            jVar.clear();
            f();
            h(cVar);
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f15087f, j2);
            }
        }
    }

    public u1(h.c.h<TLeft> hVar, k.a.b<? extends TRight> bVar, h.c.m0.n<? super TLeft, ? extends k.a.b<TLeftEnd>> nVar, h.c.m0.n<? super TRight, ? extends k.a.b<TRightEnd>> nVar2, h.c.m0.c<? super TLeft, ? super TRight, ? extends R> cVar) {
        super(hVar);
        this.f15079b = bVar;
        this.f15080c = nVar;
        this.f15081d = nVar2;
        this.f15082e = cVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        a aVar = new a(cVar, this.f15080c, this.f15081d, this.f15082e);
        cVar.onSubscribe(aVar);
        n1.d dVar = new n1.d(aVar, true);
        aVar.f15089h.b(dVar);
        n1.d dVar2 = new n1.d(aVar, false);
        aVar.f15089h.b(dVar2);
        this.a.subscribe((h.c.m) dVar);
        this.f15079b.subscribe(dVar2);
    }
}