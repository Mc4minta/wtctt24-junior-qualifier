package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableRepeatUntil.java */
/* loaded from: classes3.dex */
public final class o2<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.e f16026b;

    /* compiled from: ObservableRepeatUntil.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.z<T> {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.a.g f16027b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.x<? extends T> f16028c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.m0.e f16029d;

        a(h.c.z<? super T> zVar, h.c.m0.e eVar, h.c.n0.a.g gVar, h.c.x<? extends T> xVar) {
            this.a = zVar;
            this.f16027b = gVar;
            this.f16028c = xVar;
            this.f16029d = eVar;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    this.f16028c.subscribe(this);
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            try {
                if (this.f16029d.a()) {
                    this.a.onComplete();
                } else {
                    a();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.a.onError(th);
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            this.f16027b.a(bVar);
        }
    }

    public o2(h.c.s<T> sVar, h.c.m0.e eVar) {
        super(sVar);
        this.f16026b = eVar;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        h.c.n0.a.g gVar = new h.c.n0.a.g();
        zVar.onSubscribe(gVar);
        new a(zVar, this.f16026b, gVar, this.a).a();
    }
}