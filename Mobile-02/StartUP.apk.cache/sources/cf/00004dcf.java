package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableConcatWithCompletable.java */
/* loaded from: classes3.dex */
public final class z<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.f f15301b;

    public z(h.c.h<T> hVar, h.c.f fVar) {
        super(hVar);
        this.f15301b = fVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f15301b));
    }

    /* compiled from: FlowableConcatWithCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<h.c.k0.b> implements h.c.m<T>, h.c.e, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        k.a.d f15302b;

        /* renamed from: c  reason: collision with root package name */
        h.c.f f15303c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15304d;

        a(k.a.c<? super T> cVar, h.c.f fVar) {
            this.a = cVar;
            this.f15303c = fVar;
        }

        @Override // k.a.d
        public void cancel() {
            this.f15302b.cancel();
            h.c.n0.a.c.h(this);
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f15304d) {
                this.a.onComplete();
                return;
            }
            this.f15304d = true;
            this.f15302b = h.c.n0.i.g.CANCELLED;
            h.c.f fVar = this.f15303c;
            this.f15303c = null;
            fVar.c(this);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15302b, dVar)) {
                this.f15302b = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            this.f15302b.request(j2);
        }

        @Override // h.c.e
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this, bVar);
        }
    }
}