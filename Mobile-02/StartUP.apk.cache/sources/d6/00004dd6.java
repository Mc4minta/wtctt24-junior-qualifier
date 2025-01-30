package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FlowableRepeat.java */
/* loaded from: classes3.dex */
public final class z2<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f15318b;

    /* compiled from: FlowableRepeat.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.m<T> {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.i.f f15319b;

        /* renamed from: c  reason: collision with root package name */
        final k.a.b<? extends T> f15320c;

        /* renamed from: d  reason: collision with root package name */
        long f15321d;

        /* renamed from: e  reason: collision with root package name */
        long f15322e;

        a(k.a.c<? super T> cVar, long j2, h.c.n0.i.f fVar, k.a.b<? extends T> bVar) {
            this.a = cVar;
            this.f15319b = fVar;
            this.f15320c = bVar;
            this.f15321d = j2;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f15319b.e()) {
                    long j2 = this.f15322e;
                    if (j2 != 0) {
                        this.f15322e = 0L;
                        this.f15319b.g(j2);
                    }
                    this.f15320c.subscribe(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // k.a.c
        public void onComplete() {
            long j2 = this.f15321d;
            if (j2 != Long.MAX_VALUE) {
                this.f15321d = j2 - 1;
            }
            if (j2 != 0) {
                a();
            } else {
                this.a.onComplete();
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.f15322e++;
            this.a.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            this.f15319b.i(dVar);
        }
    }

    public z2(h.c.h<T> hVar, long j2) {
        super(hVar);
        this.f15318b = j2;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        h.c.n0.i.f fVar = new h.c.n0.i.f(false);
        cVar.onSubscribe(fVar);
        long j2 = this.f15318b;
        new a(cVar, j2 != Long.MAX_VALUE ? j2 - 1 : Long.MAX_VALUE, fVar, this.a).a();
    }
}