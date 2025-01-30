package h.c.n0.e.b;

import java.util.ArrayDeque;

/* compiled from: FlowableSkipLast.java */
/* loaded from: classes3.dex */
public final class s3<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final int f14988b;

    /* compiled from: FlowableSkipLast.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends ArrayDeque<T> implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final int f14989b;

        /* renamed from: c  reason: collision with root package name */
        k.a.d f14990c;

        a(k.a.c<? super T> cVar, int i2) {
            super(i2);
            this.a = cVar;
            this.f14989b = i2;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14990c.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14989b == size()) {
                this.a.onNext((T) poll());
            } else {
                this.f14990c.request(1L);
            }
            offer(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14990c, dVar)) {
                this.f14990c = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            this.f14990c.request(j2);
        }
    }

    public s3(h.c.h<T> hVar, int i2) {
        super(hVar);
        this.f14988b = i2;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14988b));
    }
}