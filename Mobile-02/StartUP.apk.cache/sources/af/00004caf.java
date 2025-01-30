package h.c.n0.e.b;

import h.c.a0;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableThrottleFirstTimed.java */
/* loaded from: classes3.dex */
public final class h4<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f14472b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f14473c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.a0 f14474d;

    /* compiled from: FlowableThrottleFirstTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicLong implements h.c.m<T>, k.a.d, Runnable {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f14475b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f14476c;

        /* renamed from: d  reason: collision with root package name */
        final a0.c f14477d;

        /* renamed from: e  reason: collision with root package name */
        k.a.d f14478e;

        /* renamed from: f  reason: collision with root package name */
        final h.c.n0.a.g f14479f = new h.c.n0.a.g();

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f14480g;

        /* renamed from: h  reason: collision with root package name */
        boolean f14481h;

        a(k.a.c<? super T> cVar, long j2, TimeUnit timeUnit, a0.c cVar2) {
            this.a = cVar;
            this.f14475b = j2;
            this.f14476c = timeUnit;
            this.f14477d = cVar2;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14478e.cancel();
            this.f14477d.dispose();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14481h) {
                return;
            }
            this.f14481h = true;
            this.a.onComplete();
            this.f14477d.dispose();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14481h) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14481h = true;
            this.a.onError(th);
            this.f14477d.dispose();
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14481h || this.f14480g) {
                return;
            }
            this.f14480g = true;
            if (get() != 0) {
                this.a.onNext(t);
                h.c.n0.j.d.e(this, 1L);
                h.c.k0.b bVar = this.f14479f.get();
                if (bVar != null) {
                    bVar.dispose();
                }
                this.f14479f.a(this.f14477d.c(this, this.f14475b, this.f14476c));
                return;
            }
            this.f14481h = true;
            cancel();
            this.a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14478e, dVar)) {
                this.f14478e = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this, j2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14480g = false;
        }
    }

    public h4(h.c.h<T> hVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
        super(hVar);
        this.f14472b = j2;
        this.f14473c = timeUnit;
        this.f14474d = a0Var;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(new h.c.w0.d(cVar), this.f14472b, this.f14473c, this.f14474d.a()));
    }
}