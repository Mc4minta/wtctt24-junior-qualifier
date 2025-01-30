package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableGroupJoin.java */
/* loaded from: classes3.dex */
public final class n1<TLeft, TRight, TLeftEnd, TRightEnd, R> extends h.c.n0.e.b.a<TLeft, R> {

    /* renamed from: b  reason: collision with root package name */
    final k.a.b<? extends TRight> f14747b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.n<? super TLeft, ? extends k.a.b<TLeftEnd>> f14748c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.m0.n<? super TRight, ? extends k.a.b<TRightEnd>> f14749d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.m0.c<? super TLeft, ? super h.c.h<TRight>, ? extends R> f14750e;

    /* compiled from: FlowableGroupJoin.java */
    /* loaded from: classes3.dex */
    static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements k.a.d, b {
        static final Integer a = 1;

        /* renamed from: b  reason: collision with root package name */
        static final Integer f14751b = 2;

        /* renamed from: c  reason: collision with root package name */
        static final Integer f14752c = 3;

        /* renamed from: d  reason: collision with root package name */
        static final Integer f14753d = 4;

        /* renamed from: e  reason: collision with root package name */
        final k.a.c<? super R> f14754e;
        final h.c.m0.n<? super TLeft, ? extends k.a.b<TLeftEnd>> m;
        final h.c.m0.n<? super TRight, ? extends k.a.b<TRightEnd>> n;
        final h.c.m0.c<? super TLeft, ? super h.c.h<TRight>, ? extends R> p;
        int t;
        int u;
        volatile boolean v;

        /* renamed from: f  reason: collision with root package name */
        final AtomicLong f14755f = new AtomicLong();

        /* renamed from: h  reason: collision with root package name */
        final h.c.k0.a f14757h = new h.c.k0.a();

        /* renamed from: g  reason: collision with root package name */
        final h.c.n0.f.c<Object> f14756g = new h.c.n0.f.c<>(h.c.h.bufferSize());

        /* renamed from: j  reason: collision with root package name */
        final Map<Integer, h.c.s0.c<TRight>> f14758j = new LinkedHashMap();

        /* renamed from: k  reason: collision with root package name */
        final Map<Integer, TRight> f14759k = new LinkedHashMap();

        /* renamed from: l  reason: collision with root package name */
        final AtomicReference<Throwable> f14760l = new AtomicReference<>();
        final AtomicInteger q = new AtomicInteger(2);

        a(k.a.c<? super R> cVar, h.c.m0.n<? super TLeft, ? extends k.a.b<TLeftEnd>> nVar, h.c.m0.n<? super TRight, ? extends k.a.b<TRightEnd>> nVar2, h.c.m0.c<? super TLeft, ? super h.c.h<TRight>, ? extends R> cVar2) {
            this.f14754e = cVar;
            this.m = nVar;
            this.n = nVar2;
            this.p = cVar2;
        }

        @Override // h.c.n0.e.b.n1.b
        public void a(Throwable th) {
            if (h.c.n0.j.j.a(this.f14760l, th)) {
                this.q.decrementAndGet();
                g();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.n0.e.b.n1.b
        public void b(Throwable th) {
            if (h.c.n0.j.j.a(this.f14760l, th)) {
                g();
            } else {
                h.c.r0.a.u(th);
            }
        }

        @Override // h.c.n0.e.b.n1.b
        public void c(boolean z, Object obj) {
            synchronized (this) {
                this.f14756g.l(z ? a : f14751b, obj);
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
                this.f14756g.clear();
            }
        }

        @Override // h.c.n0.e.b.n1.b
        public void d(boolean z, c cVar) {
            synchronized (this) {
                this.f14756g.l(z ? f14752c : f14753d, cVar);
            }
            g();
        }

        @Override // h.c.n0.e.b.n1.b
        public void e(d dVar) {
            this.f14757h.c(dVar);
            this.q.decrementAndGet();
            g();
        }

        void f() {
            this.f14757h.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void g() {
            if (getAndIncrement() != 0) {
                return;
            }
            h.c.n0.f.c<Object> cVar = this.f14756g;
            k.a.c<? super R> cVar2 = this.f14754e;
            int i2 = 1;
            while (!this.v) {
                if (this.f14760l.get() != null) {
                    cVar.clear();
                    f();
                    h(cVar2);
                    return;
                }
                boolean z = this.q.get() == 0;
                Integer num = (Integer) cVar.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    for (h.c.s0.c<TRight> cVar3 : this.f14758j.values()) {
                        cVar3.onComplete();
                    }
                    this.f14758j.clear();
                    this.f14759k.clear();
                    this.f14757h.dispose();
                    cVar2.onComplete();
                    return;
                } else if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    Object poll = cVar.poll();
                    if (num == a) {
                        h.c.s0.c<TRight> d2 = h.c.s0.c.d();
                        int i3 = this.t;
                        this.t = i3 + 1;
                        this.f14758j.put(Integer.valueOf(i3), d2);
                        try {
                            k.a.b bVar = (k.a.b) h.c.n0.b.b.e(this.m.apply(poll), "The leftEnd returned a null Publisher");
                            c cVar4 = new c(this, true, i3);
                            this.f14757h.b(cVar4);
                            bVar.subscribe(cVar4);
                            if (this.f14760l.get() != null) {
                                cVar.clear();
                                f();
                                h(cVar2);
                                return;
                            }
                            try {
                                Object obj = (Object) h.c.n0.b.b.e(this.p.apply(poll, d2), "The resultSelector returned a null value");
                                if (this.f14755f.get() != 0) {
                                    cVar2.onNext(obj);
                                    h.c.n0.j.d.e(this.f14755f, 1L);
                                    for (TRight tright : this.f14759k.values()) {
                                        d2.onNext(tright);
                                    }
                                } else {
                                    i(new MissingBackpressureException("Could not emit value due to lack of requests"), cVar2, cVar);
                                    return;
                                }
                            } catch (Throwable th) {
                                i(th, cVar2, cVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            i(th2, cVar2, cVar);
                            return;
                        }
                    } else if (num == f14751b) {
                        int i4 = this.u;
                        this.u = i4 + 1;
                        this.f14759k.put(Integer.valueOf(i4), poll);
                        try {
                            k.a.b bVar2 = (k.a.b) h.c.n0.b.b.e(this.n.apply(poll), "The rightEnd returned a null Publisher");
                            c cVar5 = new c(this, false, i4);
                            this.f14757h.b(cVar5);
                            bVar2.subscribe(cVar5);
                            if (this.f14760l.get() != null) {
                                cVar.clear();
                                f();
                                h(cVar2);
                                return;
                            }
                            for (h.c.s0.c<TRight> cVar6 : this.f14758j.values()) {
                                cVar6.onNext(poll);
                            }
                        } catch (Throwable th3) {
                            i(th3, cVar2, cVar);
                            return;
                        }
                    } else if (num == f14752c) {
                        c cVar7 = (c) poll;
                        h.c.s0.c<TRight> remove = this.f14758j.remove(Integer.valueOf(cVar7.f14762c));
                        this.f14757h.a(cVar7);
                        if (remove != null) {
                            remove.onComplete();
                        }
                    } else if (num == f14753d) {
                        c cVar8 = (c) poll;
                        this.f14759k.remove(Integer.valueOf(cVar8.f14762c));
                        this.f14757h.a(cVar8);
                    }
                }
            }
            cVar.clear();
        }

        void h(k.a.c<?> cVar) {
            Throwable b2 = h.c.n0.j.j.b(this.f14760l);
            for (h.c.s0.c<TRight> cVar2 : this.f14758j.values()) {
                cVar2.onError(b2);
            }
            this.f14758j.clear();
            this.f14759k.clear();
            cVar.onError(b2);
        }

        void i(Throwable th, k.a.c<?> cVar, h.c.n0.c.j<?> jVar) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.j.j.a(this.f14760l, th);
            jVar.clear();
            f();
            h(cVar);
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f14755f, j2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableGroupJoin.java */
    /* loaded from: classes3.dex */
    public interface b {
        void a(Throwable th);

        void b(Throwable th);

        void c(boolean z, Object obj);

        void d(boolean z, c cVar);

        void e(d dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableGroupJoin.java */
    /* loaded from: classes3.dex */
    public static final class c extends AtomicReference<k.a.d> implements h.c.m<Object>, h.c.k0.b {
        final b a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f14761b;

        /* renamed from: c  reason: collision with root package name */
        final int f14762c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(b bVar, boolean z, int i2) {
            this.a = bVar;
            this.f14761b = z;
            this.f14762c = i2;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.i.g.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get() == h.c.n0.i.g.CANCELLED;
        }

        @Override // k.a.c
        public void onComplete() {
            this.a.d(this.f14761b, this);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.b(th);
        }

        @Override // k.a.c
        public void onNext(Object obj) {
            if (h.c.n0.i.g.h(this)) {
                this.a.d(this.f14761b, this);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.A(this, dVar, Long.MAX_VALUE);
        }
    }

    /* compiled from: FlowableGroupJoin.java */
    /* loaded from: classes3.dex */
    static final class d extends AtomicReference<k.a.d> implements h.c.m<Object>, h.c.k0.b {
        final b a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f14763b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(b bVar, boolean z) {
            this.a = bVar;
            this.f14763b = z;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.i.g.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get() == h.c.n0.i.g.CANCELLED;
        }

        @Override // k.a.c
        public void onComplete() {
            this.a.e(this);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.a(th);
        }

        @Override // k.a.c
        public void onNext(Object obj) {
            this.a.c(this.f14763b, obj);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.A(this, dVar, Long.MAX_VALUE);
        }
    }

    public n1(h.c.h<TLeft> hVar, k.a.b<? extends TRight> bVar, h.c.m0.n<? super TLeft, ? extends k.a.b<TLeftEnd>> nVar, h.c.m0.n<? super TRight, ? extends k.a.b<TRightEnd>> nVar2, h.c.m0.c<? super TLeft, ? super h.c.h<TRight>, ? extends R> cVar) {
        super(hVar);
        this.f14747b = bVar;
        this.f14748c = nVar;
        this.f14749d = nVar2;
        this.f14750e = cVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        a aVar = new a(cVar, this.f14748c, this.f14749d, this.f14750e);
        cVar.onSubscribe(aVar);
        d dVar = new d(aVar, true);
        aVar.f14757h.b(dVar);
        d dVar2 = new d(aVar, false);
        aVar.f14757h.b(dVar2);
        this.a.subscribe((h.c.m) dVar);
        this.f14747b.subscribe(dVar2);
    }
}