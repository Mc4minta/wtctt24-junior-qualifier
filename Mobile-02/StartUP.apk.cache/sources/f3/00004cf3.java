package h.c.n0.e.b;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableBufferBoundary.java */
/* loaded from: classes3.dex */
public final class m<T, U extends Collection<? super T>, Open, Close> extends h.c.n0.e.b.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<U> f14671b;

    /* renamed from: c  reason: collision with root package name */
    final k.a.b<? extends Open> f14672c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.m0.n<? super Open, ? extends k.a.b<? extends Close>> f14673d;

    /* compiled from: FlowableBufferBoundary.java */
    /* loaded from: classes3.dex */
    static final class a<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements h.c.m<T>, k.a.d {
        final k.a.c<? super C> a;

        /* renamed from: b  reason: collision with root package name */
        final Callable<C> f14674b;

        /* renamed from: c  reason: collision with root package name */
        final k.a.b<? extends Open> f14675c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.m0.n<? super Open, ? extends k.a.b<? extends Close>> f14676d;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f14681j;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f14683l;
        long m;
        long p;

        /* renamed from: k  reason: collision with root package name */
        final h.c.n0.f.c<C> f14682k = new h.c.n0.f.c<>(h.c.h.bufferSize());

        /* renamed from: e  reason: collision with root package name */
        final h.c.k0.a f14677e = new h.c.k0.a();

        /* renamed from: f  reason: collision with root package name */
        final AtomicLong f14678f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<k.a.d> f14679g = new AtomicReference<>();
        Map<Long, C> n = new LinkedHashMap();

        /* renamed from: h  reason: collision with root package name */
        final h.c.n0.j.c f14680h = new h.c.n0.j.c();

        /* compiled from: FlowableBufferBoundary.java */
        /* renamed from: h.c.n0.e.b.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0355a<Open> extends AtomicReference<k.a.d> implements h.c.m<Open>, h.c.k0.b {
            final a<?, ?, Open, ?> a;

            C0355a(a<?, ?, Open, ?> aVar) {
                this.a = aVar;
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
                lazySet(h.c.n0.i.g.CANCELLED);
                this.a.e(this);
            }

            @Override // k.a.c
            public void onError(Throwable th) {
                lazySet(h.c.n0.i.g.CANCELLED);
                this.a.a(this, th);
            }

            @Override // k.a.c
            public void onNext(Open open) {
                this.a.d(open);
            }

            @Override // h.c.m, k.a.c
            public void onSubscribe(k.a.d dVar) {
                h.c.n0.i.g.A(this, dVar, Long.MAX_VALUE);
            }
        }

        a(k.a.c<? super C> cVar, k.a.b<? extends Open> bVar, h.c.m0.n<? super Open, ? extends k.a.b<? extends Close>> nVar, Callable<C> callable) {
            this.a = cVar;
            this.f14674b = callable;
            this.f14675c = bVar;
            this.f14676d = nVar;
        }

        void a(h.c.k0.b bVar, Throwable th) {
            h.c.n0.i.g.h(this.f14679g);
            this.f14677e.c(bVar);
            onError(th);
        }

        void b(b<T, C> bVar, long j2) {
            boolean z;
            this.f14677e.c(bVar);
            if (this.f14677e.f() == 0) {
                h.c.n0.i.g.h(this.f14679g);
                z = true;
            } else {
                z = false;
            }
            synchronized (this) {
                Map<Long, C> map = this.n;
                if (map == null) {
                    return;
                }
                this.f14682k.offer(map.remove(Long.valueOf(j2)));
                if (z) {
                    this.f14681j = true;
                }
                c();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
            if (r8 != 0) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
            if (r12.f14683l == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
            r3.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0060, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0063, code lost:
            if (r12.f14681j == false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x006b, code lost:
            if (r12.f14680h.get() == null) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x006d, code lost:
            r3.clear();
            r2.onError(r12.f14680h.b());
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0079, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x007e, code lost:
            if (r3.isEmpty() == false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0080, code lost:
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0084, code lost:
            r12.p = r0;
            r5 = addAndGet(-r5);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void c() {
            /*
                r12 = this;
                int r0 = r12.getAndIncrement()
                if (r0 == 0) goto L7
                return
            L7:
                long r0 = r12.p
                k.a.c<? super C extends java.util.Collection<? super T>> r2 = r12.a
                h.c.n0.f.c<C extends java.util.Collection<? super T>> r3 = r12.f14682k
                r4 = 1
                r5 = r4
            Lf:
                java.util.concurrent.atomic.AtomicLong r6 = r12.f14678f
                long r6 = r6.get()
            L15:
                int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r8 == 0) goto L57
                boolean r9 = r12.f14683l
                if (r9 == 0) goto L21
                r3.clear()
                return
            L21:
                boolean r9 = r12.f14681j
                if (r9 == 0) goto L3a
                h.c.n0.j.c r10 = r12.f14680h
                java.lang.Object r10 = r10.get()
                if (r10 == 0) goto L3a
                r3.clear()
                h.c.n0.j.c r0 = r12.f14680h
                java.lang.Throwable r0 = r0.b()
                r2.onError(r0)
                return
            L3a:
                java.lang.Object r10 = r3.poll()
                java.util.Collection r10 = (java.util.Collection) r10
                if (r10 != 0) goto L44
                r11 = r4
                goto L45
            L44:
                r11 = 0
            L45:
                if (r9 == 0) goto L4d
                if (r11 == 0) goto L4d
                r2.onComplete()
                return
            L4d:
                if (r11 == 0) goto L50
                goto L57
            L50:
                r2.onNext(r10)
                r8 = 1
                long r0 = r0 + r8
                goto L15
            L57:
                if (r8 != 0) goto L84
                boolean r6 = r12.f14683l
                if (r6 == 0) goto L61
                r3.clear()
                return
            L61:
                boolean r6 = r12.f14681j
                if (r6 == 0) goto L84
                h.c.n0.j.c r6 = r12.f14680h
                java.lang.Object r6 = r6.get()
                if (r6 == 0) goto L7a
                r3.clear()
                h.c.n0.j.c r0 = r12.f14680h
                java.lang.Throwable r0 = r0.b()
                r2.onError(r0)
                return
            L7a:
                boolean r6 = r3.isEmpty()
                if (r6 == 0) goto L84
                r2.onComplete()
                return
            L84:
                r12.p = r0
                int r5 = -r5
                int r5 = r12.addAndGet(r5)
                if (r5 != 0) goto Lf
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.b.m.a.c():void");
        }

        @Override // k.a.d
        public void cancel() {
            if (h.c.n0.i.g.h(this.f14679g)) {
                this.f14683l = true;
                this.f14677e.dispose();
                synchronized (this) {
                    this.n = null;
                }
                if (getAndIncrement() != 0) {
                    this.f14682k.clear();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void d(Open open) {
            try {
                Collection collection = (Collection) h.c.n0.b.b.e(this.f14674b.call(), "The bufferSupplier returned a null Collection");
                k.a.b bVar = (k.a.b) h.c.n0.b.b.e(this.f14676d.apply(open), "The bufferClose returned a null Publisher");
                long j2 = this.m;
                this.m = 1 + j2;
                synchronized (this) {
                    Map<Long, C> map = this.n;
                    if (map == 0) {
                        return;
                    }
                    map.put(Long.valueOf(j2), collection);
                    b bVar2 = new b(this, j2);
                    this.f14677e.b(bVar2);
                    bVar.subscribe(bVar2);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.n0.i.g.h(this.f14679g);
                onError(th);
            }
        }

        void e(C0355a<Open> c0355a) {
            this.f14677e.c(c0355a);
            if (this.f14677e.f() == 0) {
                h.c.n0.i.g.h(this.f14679g);
                this.f14681j = true;
                c();
            }
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14677e.dispose();
            synchronized (this) {
                Map<Long, C> map = this.n;
                if (map == null) {
                    return;
                }
                for (C c2 : map.values()) {
                    this.f14682k.offer(c2);
                }
                this.n = null;
                this.f14681j = true;
                c();
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14680h.a(th)) {
                this.f14677e.dispose();
                synchronized (this) {
                    this.n = null;
                }
                this.f14681j = true;
                c();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            synchronized (this) {
                Map<Long, C> map = this.n;
                if (map == null) {
                    return;
                }
                for (C c2 : map.values()) {
                    c2.add(t);
                }
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.z(this.f14679g, dVar)) {
                C0355a c0355a = new C0355a(this);
                this.f14677e.b(c0355a);
                this.f14675c.subscribe(c0355a);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            h.c.n0.j.d.a(this.f14678f, j2);
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableBufferBoundary.java */
    /* loaded from: classes3.dex */
    public static final class b<T, C extends Collection<? super T>> extends AtomicReference<k.a.d> implements h.c.m<Object>, h.c.k0.b {
        final a<T, C, ?, ?> a;

        /* renamed from: b  reason: collision with root package name */
        final long f14684b;

        b(a<T, C, ?, ?> aVar, long j2) {
            this.a = aVar;
            this.f14684b = j2;
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
            k.a.d dVar = get();
            h.c.n0.i.g gVar = h.c.n0.i.g.CANCELLED;
            if (dVar != gVar) {
                lazySet(gVar);
                this.a.b(this, this.f14684b);
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            k.a.d dVar = get();
            h.c.n0.i.g gVar = h.c.n0.i.g.CANCELLED;
            if (dVar != gVar) {
                lazySet(gVar);
                this.a.a(this, th);
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(Object obj) {
            k.a.d dVar = get();
            h.c.n0.i.g gVar = h.c.n0.i.g.CANCELLED;
            if (dVar != gVar) {
                lazySet(gVar);
                dVar.cancel();
                this.a.b(this, this.f14684b);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.A(this, dVar, Long.MAX_VALUE);
        }
    }

    public m(h.c.h<T> hVar, k.a.b<? extends Open> bVar, h.c.m0.n<? super Open, ? extends k.a.b<? extends Close>> nVar, Callable<U> callable) {
        super(hVar);
        this.f14672c = bVar;
        this.f14673d = nVar;
        this.f14671b = callable;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super U> cVar) {
        a aVar = new a(cVar, this.f14672c, this.f14673d, this.f14671b);
        cVar.onSubscribe(aVar);
        this.a.subscribe((h.c.m) aVar);
    }
}