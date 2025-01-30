package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableConcatWithMaybe.java */
/* loaded from: classes3.dex */
public final class x<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.q<? extends T> f16364b;

    /* compiled from: ObservableConcatWithMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<h.c.k0.b> implements h.c.z<T>, h.c.p<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.q<? extends T> f16365b;

        /* renamed from: c  reason: collision with root package name */
        boolean f16366c;

        a(h.c.z<? super T> zVar, h.c.q<? extends T> qVar) {
            this.a = zVar;
            this.f16365b = qVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f16366c) {
                this.a.onComplete();
                return;
            }
            this.f16366c = true;
            h.c.n0.a.c.q(this, null);
            h.c.q<? extends T> qVar = this.f16365b;
            this.f16365b = null;
            qVar.b(this);
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
            if (!h.c.n0.a.c.z(this, bVar) || this.f16366c) {
                return;
            }
            this.a.onSubscribe(this);
        }

        @Override // h.c.p
        public void onSuccess(T t) {
            this.a.onNext(t);
            this.a.onComplete();
        }
    }

    public x(h.c.s<T> sVar, h.c.q<? extends T> qVar) {
        super(sVar);
        this.f16364b = qVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f16364b));
    }
}