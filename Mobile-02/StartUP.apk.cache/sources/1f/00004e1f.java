package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ObservableUnsubscribeOn.java */
/* loaded from: classes3.dex */
public final class b4<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.a0 f15527b;

    /* compiled from: ObservableUnsubscribeOn.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicBoolean implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.a0 f15528b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f15529c;

        /* compiled from: ObservableUnsubscribeOn.java */
        /* renamed from: h.c.n0.e.e.b4$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class RunnableC0376a implements Runnable {
            RunnableC0376a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f15529c.dispose();
            }
        }

        a(h.c.z<? super T> zVar, h.c.a0 a0Var) {
            this.a = zVar;
            this.f15528b = a0Var;
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f15528b.c(new RunnableC0376a());
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (get()) {
                return;
            }
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (get()) {
                h.c.r0.a.u(th);
            } else {
                this.a.onError(th);
            }
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.a.onNext(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15529c, bVar)) {
                this.f15529c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public b4(h.c.x<T> xVar, h.c.a0 a0Var) {
        super(xVar);
        this.f15527b = a0Var;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f15527b));
    }
}