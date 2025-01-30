package h.c.n0.e.b;

import h.c.a0;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableThrottleLatest.java */
/* loaded from: classes3.dex */
public final class i4<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f14515b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f14516c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.a0 f14517d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f14518e;

    /* compiled from: FlowableThrottleLatest.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.m<T>, k.a.d, Runnable {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f14519b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f14520c;

        /* renamed from: d  reason: collision with root package name */
        final a0.c f14521d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f14522e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<T> f14523f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        final AtomicLong f14524g = new AtomicLong();

        /* renamed from: h  reason: collision with root package name */
        k.a.d f14525h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f14526j;

        /* renamed from: k  reason: collision with root package name */
        Throwable f14527k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f14528l;
        volatile boolean m;
        long n;
        boolean p;

        a(k.a.c<? super T> cVar, long j2, TimeUnit timeUnit, a0.c cVar2, boolean z) {
            this.a = cVar;
            this.f14519b = j2;
            this.f14520c = timeUnit;
            this.f14521d = cVar2;
            this.f14522e = z;
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<T> atomicReference = this.f14523f;
            AtomicLong atomicLong = this.f14524g;
            k.a.c<? super T> cVar = this.a;
            int i2 = 1;
            while (!this.f14528l) {
                boolean z = this.f14526j;
                if (z && this.f14527k != null) {
                    atomicReference.lazySet(null);
                    cVar.onError(this.f14527k);
                    this.f14521d.dispose();
                    return;
                }
                boolean z2 = atomicReference.get() == null;
                if (z) {
                    if (!z2 && this.f14522e) {
                        T andSet = atomicReference.getAndSet(null);
                        long j2 = this.n;
                        if (j2 != atomicLong.get()) {
                            this.n = j2 + 1;
                            cVar.onNext(andSet);
                            cVar.onComplete();
                        } else {
                            cVar.onError(new MissingBackpressureException("Could not emit final value due to lack of requests"));
                        }
                    } else {
                        atomicReference.lazySet(null);
                        cVar.onComplete();
                    }
                    this.f14521d.dispose();
                    return;
                }
                if (z2) {
                    if (this.m) {
                        this.p = false;
                        this.m = false;
                    }
                } else if (!this.p || this.m) {
                    T andSet2 = atomicReference.getAndSet(null);
                    long j3 = this.n;
                    if (j3 != atomicLong.get()) {
                        cVar.onNext(andSet2);
                        this.n = j3 + 1;
                        this.m = false;
                        this.p = true;
                        this.f14521d.c(this, this.f14519b, this.f14520c);
                    } else {
                        this.f14525h.cancel();
                        cVar.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
                        this.f14521d.dispose();
                        return;
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // k.a.d
        public void cancel() {
            this.f14528l = true;
            this.f14525h.cancel();
            this.f14521d.dispose();
            if (getAndIncrement() == 0) {
                this.f14523f.lazySet(null);
            }
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14526j = true;
            a();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f14527k = th;
            this.f14526j = true;
            a();
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.f14523f.set(t);
            a();
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14525h, dVar)) {
                this.f14525h = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f14524g, j2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.m = true;
            a();
        }
    }

    public i4(h.c.h<T> hVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var, boolean z) {
        super(hVar);
        this.f14515b = j2;
        this.f14516c = timeUnit;
        this.f14517d = a0Var;
        this.f14518e = z;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14515b, this.f14516c, this.f14517d.a(), this.f14518e));
    }
}