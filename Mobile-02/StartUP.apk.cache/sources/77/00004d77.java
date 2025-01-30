package h.c.n0.e.b;

import h.c.a0;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableIntervalRange.java */
/* loaded from: classes3.dex */
public final class t1 extends h.c.h<Long> {
    final h.c.a0 a;

    /* renamed from: b  reason: collision with root package name */
    final long f15028b;

    /* renamed from: c  reason: collision with root package name */
    final long f15029c;

    /* renamed from: d  reason: collision with root package name */
    final long f15030d;

    /* renamed from: e  reason: collision with root package name */
    final long f15031e;

    /* renamed from: f  reason: collision with root package name */
    final TimeUnit f15032f;

    /* compiled from: FlowableIntervalRange.java */
    /* loaded from: classes3.dex */
    static final class a extends AtomicLong implements k.a.d, Runnable {
        final k.a.c<? super Long> a;

        /* renamed from: b  reason: collision with root package name */
        final long f15033b;

        /* renamed from: c  reason: collision with root package name */
        long f15034c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f15035d = new AtomicReference<>();

        a(k.a.c<? super Long> cVar, long j2, long j3) {
            this.a = cVar;
            this.f15034c = j2;
            this.f15033b = j3;
        }

        public void a(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this.f15035d, bVar);
        }

        @Override // k.a.d
        public void cancel() {
            h.c.n0.a.c.h(this.f15035d);
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this, j2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            h.c.k0.b bVar = this.f15035d.get();
            h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
            if (bVar != cVar) {
                long j2 = get();
                if (j2 != 0) {
                    long j3 = this.f15034c;
                    this.a.onNext(Long.valueOf(j3));
                    if (j3 == this.f15033b) {
                        if (this.f15035d.get() != cVar) {
                            this.a.onComplete();
                        }
                        h.c.n0.a.c.h(this.f15035d);
                        return;
                    }
                    this.f15034c = j3 + 1;
                    if (j2 != Long.MAX_VALUE) {
                        decrementAndGet();
                        return;
                    }
                    return;
                }
                k.a.c<? super Long> cVar2 = this.a;
                cVar2.onError(new MissingBackpressureException("Can't deliver value " + this.f15034c + " due to lack of requests"));
                h.c.n0.a.c.h(this.f15035d);
            }
        }
    }

    public t1(long j2, long j3, long j4, long j5, TimeUnit timeUnit, h.c.a0 a0Var) {
        this.f15030d = j4;
        this.f15031e = j5;
        this.f15032f = timeUnit;
        this.a = a0Var;
        this.f15028b = j2;
        this.f15029c = j3;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super Long> cVar) {
        a aVar = new a(cVar, this.f15028b, this.f15029c);
        cVar.onSubscribe(aVar);
        h.c.a0 a0Var = this.a;
        if (a0Var instanceof h.c.n0.g.q) {
            a0.c a2 = a0Var.a();
            aVar.a(a2);
            a2.d(aVar, this.f15030d, this.f15031e, this.f15032f);
            return;
        }
        aVar.a(a0Var.e(aVar, this.f15030d, this.f15031e, this.f15032f));
    }
}