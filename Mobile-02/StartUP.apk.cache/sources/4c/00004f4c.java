package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableConcatWithCompletable.java */
/* loaded from: classes3.dex */
public final class w<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.f f16332b;

    /* compiled from: ObservableConcatWithCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<h.c.k0.b> implements h.c.z<T>, h.c.e, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.f f16333b;

        /* renamed from: c  reason: collision with root package name */
        boolean f16334c;

        a(h.c.z<? super T> zVar, h.c.f fVar) {
            this.a = zVar;
            this.f16333b = fVar;
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
            if (this.f16334c) {
                this.a.onComplete();
                return;
            }
            this.f16334c = true;
            h.c.n0.a.c.q(this, null);
            h.c.f fVar = this.f16333b;
            this.f16333b = null;
            fVar.c(this);
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
            if (!h.c.n0.a.c.z(this, bVar) || this.f16334c) {
                return;
            }
            this.a.onSubscribe(this);
        }
    }

    public w(h.c.s<T> sVar, h.c.f fVar) {
        super(sVar);
        this.f16332b = fVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f16332b));
    }
}