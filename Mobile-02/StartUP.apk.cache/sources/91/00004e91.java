package h.c.n0.e.e;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableGroupJoin.java */
/* loaded from: classes3.dex */
public final class j1<TLeft, TRight, TLeftEnd, TRightEnd, R> extends h.c.n0.e.e.a<TLeft, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.x<? extends TRight> f15830b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.n<? super TLeft, ? extends h.c.x<TLeftEnd>> f15831c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.m0.n<? super TRight, ? extends h.c.x<TRightEnd>> f15832d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.m0.c<? super TLeft, ? super h.c.s<TRight>, ? extends R> f15833e;

    /* compiled from: ObservableGroupJoin.java */
    /* loaded from: classes3.dex */
    static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements h.c.k0.b, b {
        static final Integer a = 1;

        /* renamed from: b  reason: collision with root package name */
        static final Integer f15834b = 2;

        /* renamed from: c  reason: collision with root package name */
        static final Integer f15835c = 3;

        /* renamed from: d  reason: collision with root package name */
        static final Integer f15836d = 4;

        /* renamed from: e  reason: collision with root package name */
        final h.c.z<? super R> f15837e;

        /* renamed from: l  reason: collision with root package name */
        final h.c.m0.n<? super TLeft, ? extends h.c.x<TLeftEnd>> f15843l;
        final h.c.m0.n<? super TRight, ? extends h.c.x<TRightEnd>> m;
        final h.c.m0.c<? super TLeft, ? super h.c.s<TRight>, ? extends R> n;
        int q;
        int t;
        volatile boolean u;

        /* renamed from: g  reason: collision with root package name */
        final h.c.k0.a f15839g = new h.c.k0.a();

        /* renamed from: f  reason: collision with root package name */
        final h.c.n0.f.c<Object> f15838f = new h.c.n0.f.c<>(h.c.s.bufferSize());

        /* renamed from: h  reason: collision with root package name */
        final Map<Integer, h.c.v0.g<TRight>> f15840h = new LinkedHashMap();

        /* renamed from: j  reason: collision with root package name */
        final Map<Integer, TRight> f15841j = new LinkedHashMap();

        /* renamed from: k  reason: collision with root package name */
        final AtomicReference<Throwable> f15842k = new AtomicReference<>();
        final AtomicInteger p = new AtomicInteger(2);

        a(h.c.z<? super R> zVar, h.c.m0.n<? super TLeft, ? extends h.c.x<TLeftEnd>> nVar, h.c.m0.n<? super TRight, ? extends h.c.x<TRightEnd>> nVar2, h.c.m0.c<? super TLeft, ? super h.c.s<TRight>, ? extends R> cVar) {
            this.f15837e = zVar;
            this.f15843l = nVar;
            this.m = nVar2;
            this.n = cVar;
        }

        @Override // h.c.n0.e.e.j1.b
        public void a(Throwable th) {
            if (h.c.n0.j.j.a(this.f15842k, th)) {
                this.p.decrementAndGet();
                g();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.n0.e.e.j1.b
        public void b(Throwable th) {
            if (h.c.n0.j.j.a(this.f15842k, th)) {
                g();
            } else {
                h.c.r0.a.u(th);
            }
        }

        @Override // h.c.n0.e.e.j1.b
        public void c(boolean z, Object obj) {
            synchronized (this) {
                this.f15838f.l(z ? a : f15834b, obj);
            }
            g();
        }

        @Override // h.c.n0.e.e.j1.b
        public void d(boolean z, c cVar) {
            synchronized (this) {
                this.f15838f.l(z ? f15835c : f15836d, cVar);
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
                this.f15838f.clear();
            }
        }

        @Override // h.c.n0.e.e.j1.b
        public void e(d dVar) {
            this.f15839g.c(dVar);
            this.p.decrementAndGet();
            g();
        }

        void f() {
            this.f15839g.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void g() {
            if (getAndIncrement() != 0) {
                return;
            }
            h.c.n0.f.c<?> cVar = this.f15838f;
            h.c.z<? super R> zVar = this.f15837e;
            int i2 = 1;
            while (!this.u) {
                if (this.f15842k.get() != null) {
                    cVar.clear();
                    f();
                    h(zVar);
                    return;
                }
                boolean z = this.p.get() == 0;
                Integer num = (Integer) cVar.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    for (h.c.v0.g<TRight> gVar : this.f15840h.values()) {
                        gVar.onComplete();
                    }
                    this.f15840h.clear();
                    this.f15841j.clear();
                    this.f15839g.dispose();
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
                        h.c.v0.g<TRight> c2 = h.c.v0.g.c();
                        int i3 = this.q;
                        this.q = i3 + 1;
                        this.f15840h.put(Integer.valueOf(i3), c2);
                        try {
                            h.c.x xVar = (h.c.x) h.c.n0.b.b.e(this.f15843l.apply(poll), "The leftEnd returned a null ObservableSource");
                            c cVar2 = new c(this, true, i3);
                            this.f15839g.b(cVar2);
                            xVar.subscribe(cVar2);
                            if (this.f15842k.get() != null) {
                                cVar.clear();
                                f();
                                h(zVar);
                                return;
                            }
                            try {
                                zVar.onNext((Object) h.c.n0.b.b.e(this.n.apply(poll, c2), "The resultSelector returned a null value"));
                                for (TRight tright : this.f15841j.values()) {
                                    c2.onNext(tright);
                                }
                            } catch (Throwable th) {
                                i(th, zVar, cVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            i(th2, zVar, cVar);
                            return;
                        }
                    } else if (num == f15834b) {
                        int i4 = this.t;
                        this.t = i4 + 1;
                        this.f15841j.put(Integer.valueOf(i4), poll);
                        try {
                            h.c.x xVar2 = (h.c.x) h.c.n0.b.b.e(this.m.apply(poll), "The rightEnd returned a null ObservableSource");
                            c cVar3 = new c(this, false, i4);
                            this.f15839g.b(cVar3);
                            xVar2.subscribe(cVar3);
                            if (this.f15842k.get() != null) {
                                cVar.clear();
                                f();
                                h(zVar);
                                return;
                            }
                            for (h.c.v0.g<TRight> gVar2 : this.f15840h.values()) {
                                gVar2.onNext(poll);
                            }
                        } catch (Throwable th3) {
                            i(th3, zVar, cVar);
                            return;
                        }
                    } else if (num == f15835c) {
                        c cVar4 = (c) poll;
                        h.c.v0.g<TRight> remove = this.f15840h.remove(Integer.valueOf(cVar4.f15845c));
                        this.f15839g.a(cVar4);
                        if (remove != null) {
                            remove.onComplete();
                        }
                    } else if (num == f15836d) {
                        c cVar5 = (c) poll;
                        this.f15841j.remove(Integer.valueOf(cVar5.f15845c));
                        this.f15839g.a(cVar5);
                    }
                }
            }
            cVar.clear();
        }

        void h(h.c.z<?> zVar) {
            Throwable b2 = h.c.n0.j.j.b(this.f15842k);
            for (h.c.v0.g<TRight> gVar : this.f15840h.values()) {
                gVar.onError(b2);
            }
            this.f15840h.clear();
            this.f15841j.clear();
            zVar.onError(b2);
        }

        void i(Throwable th, h.c.z<?> zVar, h.c.n0.f.c<?> cVar) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.j.j.a(this.f15842k, th);
            cVar.clear();
            f();
            h(zVar);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.u;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableGroupJoin.java */
    /* loaded from: classes3.dex */
    public interface b {
        void a(Throwable th);

        void b(Throwable th);

        void c(boolean z, Object obj);

        void d(boolean z, c cVar);

        void e(d dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableGroupJoin.java */
    /* loaded from: classes3.dex */
    public static final class c extends AtomicReference<h.c.k0.b> implements h.c.z<Object>, h.c.k0.b {
        final b a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f15844b;

        /* renamed from: c  reason: collision with root package name */
        final int f15845c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(b bVar, boolean z, int i2) {
            this.a = bVar;
            this.f15844b = z;
            this.f15845c = i2;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.d(this.f15844b, this);
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.b(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(Object obj) {
            if (h.c.n0.a.c.h(this)) {
                this.a.d(this.f15844b, this);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this, bVar);
        }
    }

    /* compiled from: ObservableGroupJoin.java */
    /* loaded from: classes3.dex */
    static final class d extends AtomicReference<h.c.k0.b> implements h.c.z<Object>, h.c.k0.b {
        final b a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f15846b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(b bVar, boolean z) {
            this.a = bVar;
            this.f15846b = z;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.e(this);
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.a(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(Object obj) {
            this.a.c(this.f15846b, obj);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this, bVar);
        }
    }

    public j1(h.c.x<TLeft> xVar, h.c.x<? extends TRight> xVar2, h.c.m0.n<? super TLeft, ? extends h.c.x<TLeftEnd>> nVar, h.c.m0.n<? super TRight, ? extends h.c.x<TRightEnd>> nVar2, h.c.m0.c<? super TLeft, ? super h.c.s<TRight>, ? extends R> cVar) {
        super(xVar);
        this.f15830b = xVar2;
        this.f15831c = nVar;
        this.f15832d = nVar2;
        this.f15833e = cVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super R> zVar) {
        a aVar = new a(zVar, this.f15831c, this.f15832d, this.f15833e);
        zVar.onSubscribe(aVar);
        d dVar = new d(aVar, true);
        aVar.f15839g.b(dVar);
        d dVar2 = new d(aVar, false);
        aVar.f15839g.b(dVar2);
        this.a.subscribe(dVar);
        this.f15830b.subscribe(dVar2);
    }
}