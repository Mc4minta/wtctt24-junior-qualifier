package h.c.n0.e.e;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableRetryPredicate.java */
/* loaded from: classes3.dex */
public final class s2<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.p<? super Throwable> f16188b;

    /* renamed from: c  reason: collision with root package name */
    final long f16189c;

    /* compiled from: ObservableRetryPredicate.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.z<T> {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.a.g f16190b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.x<? extends T> f16191c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.m0.p<? super Throwable> f16192d;

        /* renamed from: e  reason: collision with root package name */
        long f16193e;

        a(h.c.z<? super T> zVar, long j2, h.c.m0.p<? super Throwable> pVar, h.c.n0.a.g gVar, h.c.x<? extends T> xVar) {
            this.a = zVar;
            this.f16190b = gVar;
            this.f16191c = xVar;
            this.f16192d = pVar;
            this.f16193e = j2;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f16190b.isDisposed()) {
                    this.f16191c.subscribe(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            long j2 = this.f16193e;
            if (j2 != Long.MAX_VALUE) {
                this.f16193e = j2 - 1;
            }
            if (j2 == 0) {
                this.a.onError(th);
                return;
            }
            try {
                if (!this.f16192d.test(th)) {
                    this.a.onError(th);
                } else {
                    a();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.a.onError(new CompositeException(th, th2));
            }
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            this.f16190b.a(bVar);
        }
    }

    public s2(h.c.s<T> sVar, long j2, h.c.m0.p<? super Throwable> pVar) {
        super(sVar);
        this.f16188b = pVar;
        this.f16189c = j2;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        h.c.n0.a.g gVar = new h.c.n0.a.g();
        zVar.onSubscribe(gVar);
        new a(zVar, this.f16189c, this.f16188b, gVar, this.a).a();
    }
}