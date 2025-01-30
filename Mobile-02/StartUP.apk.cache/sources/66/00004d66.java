package h.c.n0.e.b;

import h.c.a0;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableInterval.java */
/* loaded from: classes3.dex */
public final class s1 extends h.c.h<Long> {
    final h.c.a0 a;

    /* renamed from: b  reason: collision with root package name */
    final long f14978b;

    /* renamed from: c  reason: collision with root package name */
    final long f14979c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f14980d;

    /* compiled from: FlowableInterval.java */
    /* loaded from: classes3.dex */
    static final class a extends AtomicLong implements k.a.d, Runnable {
        final k.a.c<? super Long> a;

        /* renamed from: b  reason: collision with root package name */
        long f14981b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f14982c = new AtomicReference<>();

        a(k.a.c<? super Long> cVar) {
            this.a = cVar;
        }

        public void a(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this.f14982c, bVar);
        }

        @Override // k.a.d
        public void cancel() {
            h.c.n0.a.c.h(this.f14982c);
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this, j2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14982c.get() != h.c.n0.a.c.DISPOSED) {
                if (get() != 0) {
                    k.a.c<? super Long> cVar = this.a;
                    long j2 = this.f14981b;
                    this.f14981b = j2 + 1;
                    cVar.onNext(Long.valueOf(j2));
                    h.c.n0.j.d.e(this, 1L);
                    return;
                }
                k.a.c<? super Long> cVar2 = this.a;
                cVar2.onError(new MissingBackpressureException("Can't deliver value " + this.f14981b + " due to lack of requests"));
                h.c.n0.a.c.h(this.f14982c);
            }
        }
    }

    public s1(long j2, long j3, TimeUnit timeUnit, h.c.a0 a0Var) {
        this.f14978b = j2;
        this.f14979c = j3;
        this.f14980d = timeUnit;
        this.a = a0Var;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super Long> cVar) {
        a aVar = new a(cVar);
        cVar.onSubscribe(aVar);
        h.c.a0 a0Var = this.a;
        if (a0Var instanceof h.c.n0.g.q) {
            a0.c a2 = a0Var.a();
            aVar.a(a2);
            a2.d(aVar, this.f14978b, this.f14979c, this.f14980d);
            return;
        }
        aVar.a(a0Var.e(aVar, this.f14978b, this.f14979c, this.f14980d));
    }
}