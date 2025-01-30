package h.c.n0.e.b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FlowableConcatMap.java */
/* loaded from: classes3.dex */
public final class v<T, R> extends h.c.n0.e.b.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends k.a.b<? extends R>> f15116b;

    /* renamed from: c  reason: collision with root package name */
    final int f15117c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.n0.j.i f15118d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableConcatMap.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[h.c.n0.j.i.values().length];
            a = iArr;
            try {
                iArr[h.c.n0.j.i.BOUNDARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.c.n0.j.i.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableConcatMap.java */
    /* loaded from: classes3.dex */
    public static abstract class b<T, R> extends AtomicInteger implements h.c.m<T>, f<R>, k.a.d {

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends k.a.b<? extends R>> f15119b;

        /* renamed from: c  reason: collision with root package name */
        final int f15120c;

        /* renamed from: d  reason: collision with root package name */
        final int f15121d;

        /* renamed from: e  reason: collision with root package name */
        k.a.d f15122e;

        /* renamed from: f  reason: collision with root package name */
        int f15123f;

        /* renamed from: g  reason: collision with root package name */
        h.c.n0.c.j<T> f15124g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f15125h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f15126j;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f15128l;
        int m;
        final e<R> a = new e<>(this);

        /* renamed from: k  reason: collision with root package name */
        final h.c.n0.j.c f15127k = new h.c.n0.j.c();

        b(h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2) {
            this.f15119b = nVar;
            this.f15120c = i2;
            this.f15121d = i2 - (i2 >> 2);
        }

        @Override // h.c.n0.e.b.v.f
        public final void c() {
            this.f15128l = false;
            d();
        }

        abstract void d();

        abstract void e();

        @Override // k.a.c
        public final void onComplete() {
            this.f15125h = true;
            d();
        }

        @Override // k.a.c
        public final void onNext(T t) {
            if (this.m != 2 && !this.f15124g.offer(t)) {
                this.f15122e.cancel();
                onError(new IllegalStateException("Queue full?!"));
                return;
            }
            d();
        }

        @Override // h.c.m, k.a.c
        public final void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15122e, dVar)) {
                this.f15122e = dVar;
                if (dVar instanceof h.c.n0.c.g) {
                    h.c.n0.c.g gVar = (h.c.n0.c.g) dVar;
                    int n = gVar.n(7);
                    if (n == 1) {
                        this.m = n;
                        this.f15124g = gVar;
                        this.f15125h = true;
                        e();
                        d();
                        return;
                    } else if (n == 2) {
                        this.m = n;
                        this.f15124g = gVar;
                        e();
                        dVar.request(this.f15120c);
                        return;
                    }
                }
                this.f15124g = new h.c.n0.f.b(this.f15120c);
                e();
                dVar.request(this.f15120c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableConcatMap.java */
    /* loaded from: classes3.dex */
    public static final class c<T, R> extends b<T, R> {
        final k.a.c<? super R> n;
        final boolean p;

        c(k.a.c<? super R> cVar, h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2, boolean z) {
            super(nVar, i2);
            this.n = cVar;
            this.p = z;
        }

        @Override // h.c.n0.e.b.v.f
        public void a(Throwable th) {
            if (this.f15127k.a(th)) {
                if (!this.p) {
                    this.f15122e.cancel();
                    this.f15125h = true;
                }
                this.f15128l = false;
                d();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.n0.e.b.v.f
        public void b(R r) {
            this.n.onNext(r);
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f15126j) {
                return;
            }
            this.f15126j = true;
            this.a.cancel();
            this.f15122e.cancel();
        }

        @Override // h.c.n0.e.b.v.b
        void d() {
            if (getAndIncrement() == 0) {
                while (!this.f15126j) {
                    if (!this.f15128l) {
                        boolean z = this.f15125h;
                        if (z && !this.p && this.f15127k.get() != null) {
                            this.n.onError(this.f15127k.b());
                            return;
                        }
                        try {
                            T poll = this.f15124g.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable b2 = this.f15127k.b();
                                if (b2 != null) {
                                    this.n.onError(b2);
                                    return;
                                } else {
                                    this.n.onComplete();
                                    return;
                                }
                            } else if (!z2) {
                                try {
                                    k.a.b bVar = (k.a.b) h.c.n0.b.b.e(this.f15119b.apply(poll), "The mapper returned a null Publisher");
                                    if (this.m != 1) {
                                        int i2 = this.f15123f + 1;
                                        if (i2 == this.f15121d) {
                                            this.f15123f = 0;
                                            this.f15122e.request(i2);
                                        } else {
                                            this.f15123f = i2;
                                        }
                                    }
                                    if (bVar instanceof Callable) {
                                        try {
                                            Object call = ((Callable) bVar).call();
                                            if (call == null) {
                                                continue;
                                            } else if (this.a.f()) {
                                                this.n.onNext(call);
                                            } else {
                                                this.f15128l = true;
                                                e<R> eVar = this.a;
                                                eVar.i(new g(call, eVar));
                                            }
                                        } catch (Throwable th) {
                                            io.reactivex.exceptions.a.b(th);
                                            this.f15122e.cancel();
                                            this.f15127k.a(th);
                                            this.n.onError(this.f15127k.b());
                                            return;
                                        }
                                    } else {
                                        this.f15128l = true;
                                        bVar.subscribe(this.a);
                                    }
                                } catch (Throwable th2) {
                                    io.reactivex.exceptions.a.b(th2);
                                    this.f15122e.cancel();
                                    this.f15127k.a(th2);
                                    this.n.onError(this.f15127k.b());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            io.reactivex.exceptions.a.b(th3);
                            this.f15122e.cancel();
                            this.f15127k.a(th3);
                            this.n.onError(this.f15127k.b());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // h.c.n0.e.b.v.b
        void e() {
            this.n.onSubscribe(this);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15127k.a(th)) {
                this.f15125h = true;
                d();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.d
        public void request(long j2) {
            this.a.request(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableConcatMap.java */
    /* loaded from: classes3.dex */
    public static final class d<T, R> extends b<T, R> {
        final k.a.c<? super R> n;
        final AtomicInteger p;

        d(k.a.c<? super R> cVar, h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2) {
            super(nVar, i2);
            this.n = cVar;
            this.p = new AtomicInteger();
        }

        @Override // h.c.n0.e.b.v.f
        public void a(Throwable th) {
            if (this.f15127k.a(th)) {
                this.f15122e.cancel();
                if (getAndIncrement() == 0) {
                    this.n.onError(this.f15127k.b());
                    return;
                }
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.n0.e.b.v.f
        public void b(R r) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.n.onNext(r);
                if (compareAndSet(1, 0)) {
                    return;
                }
                this.n.onError(this.f15127k.b());
            }
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f15126j) {
                return;
            }
            this.f15126j = true;
            this.a.cancel();
            this.f15122e.cancel();
        }

        @Override // h.c.n0.e.b.v.b
        void d() {
            if (this.p.getAndIncrement() == 0) {
                while (!this.f15126j) {
                    if (!this.f15128l) {
                        boolean z = this.f15125h;
                        try {
                            T poll = this.f15124g.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.n.onComplete();
                                return;
                            } else if (!z2) {
                                try {
                                    k.a.b bVar = (k.a.b) h.c.n0.b.b.e(this.f15119b.apply(poll), "The mapper returned a null Publisher");
                                    if (this.m != 1) {
                                        int i2 = this.f15123f + 1;
                                        if (i2 == this.f15121d) {
                                            this.f15123f = 0;
                                            this.f15122e.request(i2);
                                        } else {
                                            this.f15123f = i2;
                                        }
                                    }
                                    if (bVar instanceof Callable) {
                                        try {
                                            Object call = ((Callable) bVar).call();
                                            if (call == null) {
                                                continue;
                                            } else if (this.a.f()) {
                                                if (get() == 0 && compareAndSet(0, 1)) {
                                                    this.n.onNext(call);
                                                    if (!compareAndSet(1, 0)) {
                                                        this.n.onError(this.f15127k.b());
                                                        return;
                                                    }
                                                }
                                            } else {
                                                this.f15128l = true;
                                                e<R> eVar = this.a;
                                                eVar.i(new g(call, eVar));
                                            }
                                        } catch (Throwable th) {
                                            io.reactivex.exceptions.a.b(th);
                                            this.f15122e.cancel();
                                            this.f15127k.a(th);
                                            this.n.onError(this.f15127k.b());
                                            return;
                                        }
                                    } else {
                                        this.f15128l = true;
                                        bVar.subscribe(this.a);
                                    }
                                } catch (Throwable th2) {
                                    io.reactivex.exceptions.a.b(th2);
                                    this.f15122e.cancel();
                                    this.f15127k.a(th2);
                                    this.n.onError(this.f15127k.b());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            io.reactivex.exceptions.a.b(th3);
                            this.f15122e.cancel();
                            this.f15127k.a(th3);
                            this.n.onError(this.f15127k.b());
                            return;
                        }
                    }
                    if (this.p.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // h.c.n0.e.b.v.b
        void e() {
            this.n.onSubscribe(this);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15127k.a(th)) {
                this.a.cancel();
                if (getAndIncrement() == 0) {
                    this.n.onError(this.f15127k.b());
                    return;
                }
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.d
        public void request(long j2) {
            this.a.request(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableConcatMap.java */
    /* loaded from: classes3.dex */
    public static final class e<R> extends h.c.n0.i.f implements h.c.m<R> {

        /* renamed from: j  reason: collision with root package name */
        final f<R> f15129j;

        /* renamed from: k  reason: collision with root package name */
        long f15130k;

        e(f<R> fVar) {
            super(false);
            this.f15129j = fVar;
        }

        @Override // k.a.c
        public void onComplete() {
            long j2 = this.f15130k;
            if (j2 != 0) {
                this.f15130k = 0L;
                g(j2);
            }
            this.f15129j.c();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            long j2 = this.f15130k;
            if (j2 != 0) {
                this.f15130k = 0L;
                g(j2);
            }
            this.f15129j.a(th);
        }

        @Override // k.a.c
        public void onNext(R r) {
            this.f15130k++;
            this.f15129j.b(r);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            i(dVar);
        }
    }

    /* compiled from: FlowableConcatMap.java */
    /* loaded from: classes3.dex */
    interface f<T> {
        void a(Throwable th);

        void b(T t);

        void c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableConcatMap.java */
    /* loaded from: classes3.dex */
    public static final class g<T> implements k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final T f15131b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15132c;

        g(T t, k.a.c<? super T> cVar) {
            this.f15131b = t;
            this.a = cVar;
        }

        @Override // k.a.d
        public void cancel() {
        }

        @Override // k.a.d
        public void request(long j2) {
            if (j2 <= 0 || this.f15132c) {
                return;
            }
            this.f15132c = true;
            k.a.c<? super T> cVar = this.a;
            cVar.onNext((T) this.f15131b);
            cVar.onComplete();
        }
    }

    public v(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2, h.c.n0.j.i iVar) {
        super(hVar);
        this.f15116b = nVar;
        this.f15117c = i2;
        this.f15118d = iVar;
    }

    public static <T, R> k.a.c<T> b(k.a.c<? super R> cVar, h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2, h.c.n0.j.i iVar) {
        int i3 = a.a[iVar.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return new d(cVar, nVar, i2);
            }
            return new c(cVar, nVar, i2, true);
        }
        return new c(cVar, nVar, i2, false);
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        if (i3.b(this.a, cVar, this.f15116b)) {
            return;
        }
        this.a.subscribe(b(cVar, this.f15116b, this.f15117c, this.f15118d));
    }
}