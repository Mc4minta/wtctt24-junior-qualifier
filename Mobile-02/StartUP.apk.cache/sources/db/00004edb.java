package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableRepeat.java */
/* loaded from: classes3.dex */
public final class n2<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f16004b;

    /* compiled from: ObservableRepeat.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.z<T> {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.a.g f16005b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.x<? extends T> f16006c;

        /* renamed from: d  reason: collision with root package name */
        long f16007d;

        a(h.c.z<? super T> zVar, long j2, h.c.n0.a.g gVar, h.c.x<? extends T> xVar) {
            this.a = zVar;
            this.f16005b = gVar;
            this.f16006c = xVar;
            this.f16007d = j2;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f16005b.isDisposed()) {
                    this.f16006c.subscribe(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            long j2 = this.f16007d;
            if (j2 != Long.MAX_VALUE) {
                this.f16007d = j2 - 1;
            }
            if (j2 != 0) {
                a();
            } else {
                this.a.onComplete();
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
            this.f16005b.a(bVar);
        }
    }

    public n2(h.c.s<T> sVar, long j2) {
        super(sVar);
        this.f16004b = j2;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        h.c.n0.a.g gVar = new h.c.n0.a.g();
        zVar.onSubscribe(gVar);
        long j2 = this.f16004b;
        new a(zVar, j2 != Long.MAX_VALUE ? j2 - 1 : Long.MAX_VALUE, gVar, this.a).a();
    }
}