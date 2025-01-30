package h.c.n0.e.b;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FlowableRetryPredicate.java */
/* loaded from: classes3.dex */
public final class e3<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.p<? super Throwable> f14365b;

    /* renamed from: c  reason: collision with root package name */
    final long f14366c;

    /* compiled from: FlowableRetryPredicate.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.m<T> {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.i.f f14367b;

        /* renamed from: c  reason: collision with root package name */
        final k.a.b<? extends T> f14368c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.m0.p<? super Throwable> f14369d;

        /* renamed from: e  reason: collision with root package name */
        long f14370e;

        /* renamed from: f  reason: collision with root package name */
        long f14371f;

        a(k.a.c<? super T> cVar, long j2, h.c.m0.p<? super Throwable> pVar, h.c.n0.i.f fVar, k.a.b<? extends T> bVar) {
            this.a = cVar;
            this.f14367b = fVar;
            this.f14368c = bVar;
            this.f14369d = pVar;
            this.f14370e = j2;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f14367b.e()) {
                    long j2 = this.f14371f;
                    if (j2 != 0) {
                        this.f14371f = 0L;
                        this.f14367b.g(j2);
                    }
                    this.f14368c.subscribe(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            long j2 = this.f14370e;
            if (j2 != Long.MAX_VALUE) {
                this.f14370e = j2 - 1;
            }
            if (j2 == 0) {
                this.a.onError(th);
                return;
            }
            try {
                if (!this.f14369d.test(th)) {
                    this.a.onError(th);
                } else {
                    a();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.a.onError(new CompositeException(th, th2));
            }
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.f14371f++;
            this.a.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            this.f14367b.i(dVar);
        }
    }

    public e3(h.c.h<T> hVar, long j2, h.c.m0.p<? super Throwable> pVar) {
        super(hVar);
        this.f14365b = pVar;
        this.f14366c = j2;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        h.c.n0.i.f fVar = new h.c.n0.i.f(false);
        cVar.onSubscribe(fVar);
        new a(cVar, this.f14366c, this.f14365b, fVar, this.a).a();
    }
}