package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableFlatMapCompletableCompletable.java */
/* loaded from: classes3.dex */
public final class x0<T> extends h.c.c implements h.c.n0.c.d<T> {
    final h.c.x<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.f> f16367b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f16368c;

    /* compiled from: ObservableFlatMapCompletableCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.k0.b, h.c.z<T> {
        final h.c.e a;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.f> f16370c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f16371d;

        /* renamed from: f  reason: collision with root package name */
        h.c.k0.b f16373f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f16374g;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.j.c f16369b = new h.c.n0.j.c();

        /* renamed from: e  reason: collision with root package name */
        final h.c.k0.a f16372e = new h.c.k0.a();

        /* compiled from: ObservableFlatMapCompletableCompletable.java */
        /* renamed from: h.c.n0.e.e.x0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class C0388a extends AtomicReference<h.c.k0.b> implements h.c.e, h.c.k0.b {
            C0388a() {
            }

            @Override // h.c.k0.b
            public void dispose() {
                h.c.n0.a.c.h(this);
            }

            @Override // h.c.k0.b
            public boolean isDisposed() {
                return h.c.n0.a.c.n(get());
            }

            @Override // h.c.e
            public void onComplete() {
                a.this.a(this);
            }

            @Override // h.c.e
            public void onError(Throwable th) {
                a.this.b(this, th);
            }

            @Override // h.c.e
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.z(this, bVar);
            }
        }

        a(h.c.e eVar, h.c.m0.n<? super T, ? extends h.c.f> nVar, boolean z) {
            this.a = eVar;
            this.f16370c = nVar;
            this.f16371d = z;
            lazySet(1);
        }

        void a(a<T>.C0388a c0388a) {
            this.f16372e.c(c0388a);
            onComplete();
        }

        void b(a<T>.C0388a c0388a, Throwable th) {
            this.f16372e.c(c0388a);
            onError(th);
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16374g = true;
            this.f16373f.dispose();
            this.f16372e.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16373f.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable b2 = this.f16369b.b();
                if (b2 != null) {
                    this.a.onError(b2);
                } else {
                    this.a.onComplete();
                }
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16369b.a(th)) {
                if (this.f16371d) {
                    if (decrementAndGet() == 0) {
                        this.a.onError(this.f16369b.b());
                        return;
                    }
                    return;
                }
                dispose();
                if (getAndSet(0) > 0) {
                    this.a.onError(this.f16369b.b());
                    return;
                }
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            try {
                h.c.f fVar = (h.c.f) h.c.n0.b.b.e(this.f16370c.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0388a c0388a = new C0388a();
                if (this.f16374g || !this.f16372e.b(c0388a)) {
                    return;
                }
                fVar.c(c0388a);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f16373f.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16373f, bVar)) {
                this.f16373f = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public x0(h.c.x<T> xVar, h.c.m0.n<? super T, ? extends h.c.f> nVar, boolean z) {
        this.a = xVar;
        this.f16367b = nVar;
        this.f16368c = z;
    }

    @Override // h.c.n0.c.d
    public h.c.s<T> a() {
        return h.c.r0.a.n(new w0(this.a, this.f16367b, this.f16368c));
    }

    @Override // h.c.c
    protected void t(h.c.e eVar) {
        this.a.subscribe(new a(eVar, this.f16367b, this.f16368c));
    }
}