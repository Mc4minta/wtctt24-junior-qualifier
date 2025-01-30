package h.c.n0.e.g;

import java.util.NoSuchElementException;

/* compiled from: SingleFromPublisher.java */
/* loaded from: classes3.dex */
public final class e0<T> extends h.c.b0<T> {
    final k.a.b<? extends T> a;

    /* compiled from: SingleFromPublisher.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        k.a.d f16494b;

        /* renamed from: c  reason: collision with root package name */
        T f16495c;

        /* renamed from: d  reason: collision with root package name */
        boolean f16496d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f16497e;

        a(h.c.e0<? super T> e0Var) {
            this.a = e0Var;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16497e = true;
            this.f16494b.cancel();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16497e;
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f16496d) {
                return;
            }
            this.f16496d = true;
            T t = this.f16495c;
            this.f16495c = null;
            if (t == null) {
                this.a.onError(new NoSuchElementException("The source Publisher is empty"));
            } else {
                this.a.onSuccess(t);
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f16496d) {
                h.c.r0.a.u(th);
                return;
            }
            this.f16496d = true;
            this.f16495c = null;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f16496d) {
                return;
            }
            if (this.f16495c != null) {
                this.f16494b.cancel();
                this.f16496d = true;
                this.f16495c = null;
                this.a.onError(new IndexOutOfBoundsException("Too many elements in the Publisher"));
                return;
            }
            this.f16495c = t;
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f16494b, dVar)) {
                this.f16494b = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public e0(k.a.b<? extends T> bVar) {
        this.a = bVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var));
    }
}