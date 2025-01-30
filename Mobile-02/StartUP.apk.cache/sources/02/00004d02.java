package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableTimer.java */
/* loaded from: classes3.dex */
public final class m4 extends h.c.h<Long> {
    final h.c.a0 a;

    /* renamed from: b  reason: collision with root package name */
    final long f14726b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f14727c;

    /* compiled from: FlowableTimer.java */
    /* loaded from: classes3.dex */
    static final class a extends AtomicReference<h.c.k0.b> implements k.a.d, Runnable {
        final k.a.c<? super Long> a;

        /* renamed from: b  reason: collision with root package name */
        volatile boolean f14728b;

        a(k.a.c<? super Long> cVar) {
            this.a = cVar;
        }

        public void a(h.c.k0.b bVar) {
            h.c.n0.a.c.A(this, bVar);
        }

        @Override // k.a.d
        public void cancel() {
            h.c.n0.a.c.h(this);
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                this.f14728b = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != h.c.n0.a.c.DISPOSED) {
                if (this.f14728b) {
                    this.a.onNext(0L);
                    lazySet(h.c.n0.a.d.INSTANCE);
                    this.a.onComplete();
                    return;
                }
                lazySet(h.c.n0.a.d.INSTANCE);
                this.a.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
            }
        }
    }

    public m4(long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
        this.f14726b = j2;
        this.f14727c = timeUnit;
        this.a = a0Var;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super Long> cVar) {
        a aVar = new a(cVar);
        cVar.onSubscribe(aVar);
        aVar.a(this.a.d(aVar, this.f14726b, this.f14727c));
    }
}