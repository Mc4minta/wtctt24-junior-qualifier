package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableLimit.java */
/* loaded from: classes3.dex */
public final class z1<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f15315b;

    /* compiled from: FlowableLimit.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicLong implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        long f15316b;

        /* renamed from: c  reason: collision with root package name */
        k.a.d f15317c;

        a(k.a.c<? super T> cVar, long j2) {
            this.a = cVar;
            this.f15316b = j2;
            lazySet(j2);
        }

        @Override // k.a.d
        public void cancel() {
            this.f15317c.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f15316b > 0) {
                this.f15316b = 0L;
                this.a.onComplete();
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15316b > 0) {
                this.f15316b = 0L;
                this.a.onError(th);
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            long j2 = this.f15316b;
            if (j2 > 0) {
                long j3 = j2 - 1;
                this.f15316b = j3;
                this.a.onNext(t);
                if (j3 == 0) {
                    this.f15317c.cancel();
                    this.a.onComplete();
                }
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15317c, dVar)) {
                if (this.f15316b == 0) {
                    dVar.cancel();
                    h.c.n0.i.d.h(this.a);
                    return;
                }
                this.f15317c = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            long j3;
            long j4;
            if (h.c.n0.i.g.B(j2)) {
                do {
                    j3 = get();
                    if (j3 == 0) {
                        return;
                    }
                    j4 = j3 <= j2 ? j3 : j2;
                } while (!compareAndSet(j3, j3 - j4));
                this.f15317c.request(j4);
            }
        }
    }

    public z1(h.c.h<T> hVar, long j2) {
        super(hVar);
        this.f15315b = j2;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f15315b));
    }
}