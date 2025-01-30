package h.c.n0.e.g;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleFlatMapPublisher.java */
/* loaded from: classes3.dex */
public final class c0<T, R> extends h.c.h<R> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends k.a.b<? extends R>> f16490b;

    public c0(h.c.h0<T> h0Var, h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar) {
        this.a = h0Var;
        this.f16490b = nVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        this.a.subscribe(new a(cVar, this.f16490b));
    }

    /* compiled from: SingleFlatMapPublisher.java */
    /* loaded from: classes3.dex */
    static final class a<S, T> extends AtomicLong implements h.c.e0<S>, h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super S, ? extends k.a.b<? extends T>> f16491b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<k.a.d> f16492c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        h.c.k0.b f16493d;

        a(k.a.c<? super T> cVar, h.c.m0.n<? super S, ? extends k.a.b<? extends T>> nVar) {
            this.a = cVar;
            this.f16491b = nVar;
        }

        @Override // k.a.d
        public void cancel() {
            this.f16493d.dispose();
            h.c.n0.i.g.h(this.f16492c);
        }

        @Override // k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            this.f16493d = bVar;
            this.a.onSubscribe(this);
        }

        @Override // h.c.e0
        public void onSuccess(S s) {
            try {
                ((k.a.b) h.c.n0.b.b.e(this.f16491b.apply(s), "the mapper returned a null Publisher")).subscribe(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.a.onError(th);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            h.c.n0.i.g.n(this.f16492c, this, j2);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.q(this.f16492c, this, dVar);
        }
    }
}