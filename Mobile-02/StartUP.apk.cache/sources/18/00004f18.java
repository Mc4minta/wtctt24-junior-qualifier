package h.c.n0.e.e;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableRetryBiPredicate.java */
/* loaded from: classes3.dex */
public final class r2<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.d<? super Integer, ? super Throwable> f16171b;

    /* compiled from: ObservableRetryBiPredicate.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.z<T> {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.a.g f16172b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.x<? extends T> f16173c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.m0.d<? super Integer, ? super Throwable> f16174d;

        /* renamed from: e  reason: collision with root package name */
        int f16175e;

        a(h.c.z<? super T> zVar, h.c.m0.d<? super Integer, ? super Throwable> dVar, h.c.n0.a.g gVar, h.c.x<? extends T> xVar) {
            this.a = zVar;
            this.f16172b = gVar;
            this.f16173c = xVar;
            this.f16174d = dVar;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f16172b.isDisposed()) {
                    this.f16173c.subscribe(this);
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
            try {
                h.c.m0.d<? super Integer, ? super Throwable> dVar = this.f16174d;
                int i2 = this.f16175e + 1;
                this.f16175e = i2;
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

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            this.f16172b.a(bVar);
        }
    }

    public r2(h.c.s<T> sVar, h.c.m0.d<? super Integer, ? super Throwable> dVar) {
        super(sVar);
        this.f16171b = dVar;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        h.c.n0.a.g gVar = new h.c.n0.a.g();
        zVar.onSubscribe(gVar);
        new a(zVar, this.f16171b, gVar, this.a).a();
    }
}