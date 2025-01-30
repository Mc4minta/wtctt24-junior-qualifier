package h.c.n0.e.b;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FlowableRetryBiPredicate.java */
/* loaded from: classes3.dex */
public final class d3<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.d<? super Integer, ? super Throwable> f14321b;

    /* compiled from: FlowableRetryBiPredicate.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.m<T> {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.i.f f14322b;

        /* renamed from: c  reason: collision with root package name */
        final k.a.b<? extends T> f14323c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.m0.d<? super Integer, ? super Throwable> f14324d;

        /* renamed from: e  reason: collision with root package name */
        int f14325e;

        /* renamed from: f  reason: collision with root package name */
        long f14326f;

        a(k.a.c<? super T> cVar, h.c.m0.d<? super Integer, ? super Throwable> dVar, h.c.n0.i.f fVar, k.a.b<? extends T> bVar) {
            this.a = cVar;
            this.f14322b = fVar;
            this.f14323c = bVar;
            this.f14324d = dVar;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f14322b.e()) {
                    long j2 = this.f14326f;
                    if (j2 != 0) {
                        this.f14326f = 0L;
                        this.f14322b.g(j2);
                    }
                    this.f14323c.subscribe(this);
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
            try {
                h.c.m0.d<? super Integer, ? super Throwable> dVar = this.f14324d;
                int i2 = this.f14325e + 1;
                this.f14325e = i2;
                if (!dVar.a(Integer.valueOf(i2), th)) {
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
            this.f14326f++;
            this.a.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            this.f14322b.i(dVar);
        }
    }

    public d3(h.c.h<T> hVar, h.c.m0.d<? super Integer, ? super Throwable> dVar) {
        super(hVar);
        this.f14321b = dVar;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        h.c.n0.i.f fVar = new h.c.n0.i.f(false);
        cVar.onSubscribe(fVar);
        new a(cVar, this.f14321b, fVar, this.a).a();
    }
}