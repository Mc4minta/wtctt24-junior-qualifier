package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableOnBackpressureDrop.java */
/* loaded from: classes3.dex */
public final class l2<T> extends h.c.n0.e.b.a<T, T> implements h.c.m0.f<T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.f<? super T> f14636b;

    /* compiled from: FlowableOnBackpressureDrop.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicLong implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.f<? super T> f14637b;

        /* renamed from: c  reason: collision with root package name */
        k.a.d f14638c;

        /* renamed from: d  reason: collision with root package name */
        boolean f14639d;

        a(k.a.c<? super T> cVar, h.c.m0.f<? super T> fVar) {
            this.a = cVar;
            this.f14637b = fVar;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14638c.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14639d) {
                return;
            }
            this.f14639d = true;
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14639d) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14639d = true;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14639d) {
                return;
            }
            if (get() != 0) {
                this.a.onNext(t);
                h.c.n0.j.d.e(this, 1L);
                return;
            }
            try {
                this.f14637b.accept(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                cancel();
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14638c, dVar)) {
                this.f14638c = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this, j2);
            }
        }
    }

    public l2(h.c.h<T> hVar) {
        super(hVar);
        this.f14636b = this;
    }

    @Override // h.c.m0.f
    public void accept(T t) {
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14636b));
    }

    public l2(h.c.h<T> hVar, h.c.m0.f<? super T> fVar) {
        super(hVar);
        this.f14636b = fVar;
    }
}