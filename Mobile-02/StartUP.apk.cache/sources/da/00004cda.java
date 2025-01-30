package h.c.n0.e.b;

import h.c.n0.e.b.l4;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableTimeout.java */
/* loaded from: classes3.dex */
public final class k4<T, U, V> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final k.a.b<U> f14590b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends k.a.b<V>> f14591c;

    /* renamed from: d  reason: collision with root package name */
    final k.a.b<? extends T> f14592d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableTimeout.java */
    /* loaded from: classes3.dex */
    public static final class a extends AtomicReference<k.a.d> implements h.c.m<Object>, h.c.k0.b {
        final c a;

        /* renamed from: b  reason: collision with root package name */
        final long f14593b;

        a(long j2, c cVar) {
            this.f14593b = j2;
            this.a = cVar;
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
            Object obj = get();
            h.c.n0.i.g gVar = h.c.n0.i.g.CANCELLED;
            if (obj != gVar) {
                lazySet(gVar);
                this.a.a(this.f14593b);
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            Object obj = get();
            h.c.n0.i.g gVar = h.c.n0.i.g.CANCELLED;
            if (obj != gVar) {
                lazySet(gVar);
                this.a.b(this.f14593b, th);
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(Object obj) {
            k.a.d dVar = (k.a.d) get();
            h.c.n0.i.g gVar = h.c.n0.i.g.CANCELLED;
            if (dVar != gVar) {
                dVar.cancel();
                lazySet(gVar);
                this.a.a(this.f14593b);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.A(this, dVar, Long.MAX_VALUE);
        }
    }

    /* compiled from: FlowableTimeout.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends h.c.n0.i.f implements h.c.m<T>, c {

        /* renamed from: j  reason: collision with root package name */
        final k.a.c<? super T> f14594j;

        /* renamed from: k  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends k.a.b<?>> f14595k;

        /* renamed from: l  reason: collision with root package name */
        final h.c.n0.a.g f14596l;
        final AtomicReference<k.a.d> m;
        final AtomicLong n;
        k.a.b<? extends T> p;
        long q;

        b(k.a.c<? super T> cVar, h.c.m0.n<? super T, ? extends k.a.b<?>> nVar, k.a.b<? extends T> bVar) {
            super(true);
            this.f14594j = cVar;
            this.f14595k = nVar;
            this.f14596l = new h.c.n0.a.g();
            this.m = new AtomicReference<>();
            this.p = bVar;
            this.n = new AtomicLong();
        }

        @Override // h.c.n0.e.b.l4.d
        public void a(long j2) {
            if (this.n.compareAndSet(j2, Long.MAX_VALUE)) {
                h.c.n0.i.g.h(this.m);
                k.a.b<? extends T> bVar = this.p;
                this.p = null;
                long j3 = this.q;
                if (j3 != 0) {
                    g(j3);
                }
                bVar.subscribe(new l4.a(this.f14594j, this));
            }
        }

        @Override // h.c.n0.e.b.k4.c
        public void b(long j2, Throwable th) {
            if (this.n.compareAndSet(j2, Long.MAX_VALUE)) {
                h.c.n0.i.g.h(this.m);
                this.f14594j.onError(th);
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.n0.i.f, k.a.d
        public void cancel() {
            super.cancel();
            this.f14596l.dispose();
        }

        void j(k.a.b<?> bVar) {
            if (bVar != null) {
                a aVar = new a(0L, this);
                if (this.f14596l.a(aVar)) {
                    bVar.subscribe(aVar);
                }
            }
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.n.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f14596l.dispose();
                this.f14594j.onComplete();
                this.f14596l.dispose();
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.n.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f14596l.dispose();
                this.f14594j.onError(th);
                this.f14596l.dispose();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            long j2 = this.n.get();
            if (j2 != Long.MAX_VALUE) {
                long j3 = j2 + 1;
                if (this.n.compareAndSet(j2, j3)) {
                    h.c.k0.b bVar = this.f14596l.get();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    this.q++;
                    this.f14594j.onNext(t);
                    try {
                        k.a.b bVar2 = (k.a.b) h.c.n0.b.b.e(this.f14595k.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        a aVar = new a(j3, this);
                        if (this.f14596l.a(aVar)) {
                            bVar2.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.m.get().cancel();
                        this.n.getAndSet(Long.MAX_VALUE);
                        this.f14594j.onError(th);
                    }
                }
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.z(this.m, dVar)) {
                i(dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableTimeout.java */
    /* loaded from: classes3.dex */
    public interface c extends l4.d {
        void b(long j2, Throwable th);
    }

    /* compiled from: FlowableTimeout.java */
    /* loaded from: classes3.dex */
    static final class d<T> extends AtomicLong implements h.c.m<T>, k.a.d, c {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends k.a.b<?>> f14597b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.n0.a.g f14598c = new h.c.n0.a.g();

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<k.a.d> f14599d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        final AtomicLong f14600e = new AtomicLong();

        d(k.a.c<? super T> cVar, h.c.m0.n<? super T, ? extends k.a.b<?>> nVar) {
            this.a = cVar;
            this.f14597b = nVar;
        }

        @Override // h.c.n0.e.b.l4.d
        public void a(long j2) {
            if (compareAndSet(j2, Long.MAX_VALUE)) {
                h.c.n0.i.g.h(this.f14599d);
                this.a.onError(new TimeoutException());
            }
        }

        @Override // h.c.n0.e.b.k4.c
        public void b(long j2, Throwable th) {
            if (compareAndSet(j2, Long.MAX_VALUE)) {
                h.c.n0.i.g.h(this.f14599d);
                this.a.onError(th);
                return;
            }
            h.c.r0.a.u(th);
        }

        void c(k.a.b<?> bVar) {
            if (bVar != null) {
                a aVar = new a(0L, this);
                if (this.f14598c.a(aVar)) {
                    bVar.subscribe(aVar);
                }
            }
        }

        @Override // k.a.d
        public void cancel() {
            h.c.n0.i.g.h(this.f14599d);
            this.f14598c.dispose();
        }

        @Override // k.a.c
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f14598c.dispose();
                this.a.onComplete();
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f14598c.dispose();
                this.a.onError(th);
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            long j2 = get();
            if (j2 != Long.MAX_VALUE) {
                long j3 = 1 + j2;
                if (compareAndSet(j2, j3)) {
                    h.c.k0.b bVar = this.f14598c.get();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    this.a.onNext(t);
                    try {
                        k.a.b bVar2 = (k.a.b) h.c.n0.b.b.e(this.f14597b.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        a aVar = new a(j3, this);
                        if (this.f14598c.a(aVar)) {
                            bVar2.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f14599d.get().cancel();
                        getAndSet(Long.MAX_VALUE);
                        this.a.onError(th);
                    }
                }
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.q(this.f14599d, this.f14600e, dVar);
        }

        @Override // k.a.d
        public void request(long j2) {
            h.c.n0.i.g.n(this.f14599d, this.f14600e, j2);
        }
    }

    public k4(h.c.h<T> hVar, k.a.b<U> bVar, h.c.m0.n<? super T, ? extends k.a.b<V>> nVar, k.a.b<? extends T> bVar2) {
        super(hVar);
        this.f14590b = bVar;
        this.f14591c = nVar;
        this.f14592d = bVar2;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        if (this.f14592d == null) {
            d dVar = new d(cVar, this.f14591c);
            cVar.onSubscribe(dVar);
            dVar.c(this.f14590b);
            this.a.subscribe((h.c.m) dVar);
            return;
        }
        b bVar = new b(cVar, this.f14591c, this.f14592d);
        cVar.onSubscribe(bVar);
        bVar.j(this.f14590b);
        this.a.subscribe((h.c.m) bVar);
    }
}