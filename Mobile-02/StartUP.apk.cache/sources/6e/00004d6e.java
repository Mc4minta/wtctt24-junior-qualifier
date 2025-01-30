package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableWindowBoundary.java */
/* loaded from: classes3.dex */
public final class s4<T, B> extends h.c.n0.e.b.a<T, h.c.h<T>> {

    /* renamed from: b  reason: collision with root package name */
    final k.a.b<B> f14991b;

    /* renamed from: c  reason: collision with root package name */
    final int f14992c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableWindowBoundary.java */
    /* loaded from: classes3.dex */
    public static final class a<T, B> extends h.c.w0.b<B> {

        /* renamed from: b  reason: collision with root package name */
        final b<T, B> f14993b;

        /* renamed from: c  reason: collision with root package name */
        boolean f14994c;

        a(b<T, B> bVar) {
            this.f14993b = bVar;
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14994c) {
                return;
            }
            this.f14994c = true;
            this.f14993b.b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14994c) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14994c = true;
            this.f14993b.c(th);
        }

        @Override // k.a.c
        public void onNext(B b2) {
            if (this.f14994c) {
                return;
            }
            this.f14993b.d();
        }
    }

    /* compiled from: FlowableWindowBoundary.java */
    /* loaded from: classes3.dex */
    static final class b<T, B> extends AtomicInteger implements h.c.m<T>, k.a.d, Runnable {
        static final Object a = new Object();

        /* renamed from: b  reason: collision with root package name */
        final k.a.c<? super h.c.h<T>> f14995b;

        /* renamed from: c  reason: collision with root package name */
        final int f14996c;

        /* renamed from: d  reason: collision with root package name */
        final a<T, B> f14997d = new a<>(this);

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<k.a.d> f14998e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f14999f = new AtomicInteger(1);

        /* renamed from: g  reason: collision with root package name */
        final h.c.n0.f.a<Object> f15000g = new h.c.n0.f.a<>();

        /* renamed from: h  reason: collision with root package name */
        final h.c.n0.j.c f15001h = new h.c.n0.j.c();

        /* renamed from: j  reason: collision with root package name */
        final AtomicBoolean f15002j = new AtomicBoolean();

        /* renamed from: k  reason: collision with root package name */
        final AtomicLong f15003k = new AtomicLong();

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f15004l;
        h.c.s0.c<T> m;
        long n;

        b(k.a.c<? super h.c.h<T>> cVar, int i2) {
            this.f14995b = cVar;
            this.f14996c = i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            k.a.c<? super h.c.h<T>> cVar = this.f14995b;
            h.c.n0.f.a<Object> aVar = this.f15000g;
            h.c.n0.j.c cVar2 = this.f15001h;
            long j2 = this.n;
            int i2 = 1;
            while (this.f14999f.get() != 0) {
                h.c.s0.c<T> cVar3 = this.m;
                boolean z = this.f15004l;
                if (z && cVar2.get() != null) {
                    aVar.clear();
                    Throwable b2 = cVar2.b();
                    if (cVar3 != 0) {
                        this.m = null;
                        cVar3.onError(b2);
                    }
                    cVar.onError(b2);
                    return;
                }
                Object poll = aVar.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    Throwable b3 = cVar2.b();
                    if (b3 == null) {
                        if (cVar3 != 0) {
                            this.m = null;
                            cVar3.onComplete();
                        }
                        cVar.onComplete();
                        return;
                    }
                    if (cVar3 != 0) {
                        this.m = null;
                        cVar3.onError(b3);
                    }
                    cVar.onError(b3);
                    return;
                } else if (z2) {
                    this.n = j2;
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (poll != a) {
                    cVar3.onNext(poll);
                } else {
                    if (cVar3 != 0) {
                        this.m = null;
                        cVar3.onComplete();
                    }
                    if (!this.f15002j.get()) {
                        h.c.s0.c<T> f2 = h.c.s0.c.f(this.f14996c, this);
                        this.m = f2;
                        this.f14999f.getAndIncrement();
                        if (j2 != this.f15003k.get()) {
                            j2++;
                            cVar.onNext(f2);
                        } else {
                            h.c.n0.i.g.h(this.f14998e);
                            this.f14997d.dispose();
                            cVar2.a(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                            this.f15004l = true;
                        }
                    }
                }
            }
            aVar.clear();
            this.m = null;
        }

        void b() {
            h.c.n0.i.g.h(this.f14998e);
            this.f15004l = true;
            a();
        }

        void c(Throwable th) {
            h.c.n0.i.g.h(this.f14998e);
            if (this.f15001h.a(th)) {
                this.f15004l = true;
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f15002j.compareAndSet(false, true)) {
                this.f14997d.dispose();
                if (this.f14999f.decrementAndGet() == 0) {
                    h.c.n0.i.g.h(this.f14998e);
                }
            }
        }

        void d() {
            this.f15000g.offer(a);
            a();
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14997d.dispose();
            this.f15004l = true;
            a();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f14997d.dispose();
            if (this.f15001h.a(th)) {
                this.f15004l = true;
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.f15000g.offer(t);
            a();
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.A(this.f14998e, dVar, Long.MAX_VALUE);
        }

        @Override // k.a.d
        public void request(long j2) {
            h.c.n0.j.d.a(this.f15003k, j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14999f.decrementAndGet() == 0) {
                h.c.n0.i.g.h(this.f14998e);
            }
        }
    }

    public s4(h.c.h<T> hVar, k.a.b<B> bVar, int i2) {
        super(hVar);
        this.f14991b = bVar;
        this.f14992c = i2;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super h.c.h<T>> cVar) {
        b bVar = new b(cVar, this.f14992c);
        cVar.onSubscribe(bVar);
        bVar.d();
        this.f14991b.subscribe(bVar.f14997d);
        this.a.subscribe((h.c.m) bVar);
    }
}