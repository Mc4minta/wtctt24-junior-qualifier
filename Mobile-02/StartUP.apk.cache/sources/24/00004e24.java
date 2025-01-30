package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableDebounce.java */
/* loaded from: classes3.dex */
public final class c0<T, U> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.x<U>> f15533b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableDebounce.java */
    /* loaded from: classes3.dex */
    public static final class a<T, U> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.x<U>> f15534b;

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f15535c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f15536d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        volatile long f15537e;

        /* renamed from: f  reason: collision with root package name */
        boolean f15538f;

        /* compiled from: ObservableDebounce.java */
        /* renamed from: h.c.n0.e.e.c0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0377a<T, U> extends h.c.p0.d<U> {

            /* renamed from: b  reason: collision with root package name */
            final a<T, U> f15539b;

            /* renamed from: c  reason: collision with root package name */
            final long f15540c;

            /* renamed from: d  reason: collision with root package name */
            final T f15541d;

            /* renamed from: e  reason: collision with root package name */
            boolean f15542e;

            /* renamed from: f  reason: collision with root package name */
            final AtomicBoolean f15543f = new AtomicBoolean();

            C0377a(a<T, U> aVar, long j2, T t) {
                this.f15539b = aVar;
                this.f15540c = j2;
                this.f15541d = t;
            }

            void c() {
                if (this.f15543f.compareAndSet(false, true)) {
                    this.f15539b.a(this.f15540c, this.f15541d);
                }
            }

            @Override // h.c.z, k.a.c
            public void onComplete() {
                if (this.f15542e) {
                    return;
                }
                this.f15542e = true;
                c();
            }

            @Override // h.c.z, k.a.c
            public void onError(Throwable th) {
                if (this.f15542e) {
                    h.c.r0.a.u(th);
                    return;
                }
                this.f15542e = true;
                this.f15539b.onError(th);
            }

            @Override // h.c.z, k.a.c
            public void onNext(U u) {
                if (this.f15542e) {
                    return;
                }
                this.f15542e = true;
                dispose();
                c();
            }
        }

        a(h.c.z<? super T> zVar, h.c.m0.n<? super T, ? extends h.c.x<U>> nVar) {
            this.a = zVar;
            this.f15534b = nVar;
        }

        void a(long j2, T t) {
            if (j2 == this.f15537e) {
                this.a.onNext(t);
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15535c.dispose();
            h.c.n0.a.c.h(this.f15536d);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15535c.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15538f) {
                return;
            }
            this.f15538f = true;
            h.c.k0.b bVar = this.f15536d.get();
            if (bVar != h.c.n0.a.c.DISPOSED) {
                ((C0377a) bVar).c();
                h.c.n0.a.c.h(this.f15536d);
                this.a.onComplete();
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            h.c.n0.a.c.h(this.f15536d);
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15538f) {
                return;
            }
            long j2 = this.f15537e + 1;
            this.f15537e = j2;
            h.c.k0.b bVar = this.f15536d.get();
            if (bVar != null) {
                bVar.dispose();
            }
            try {
                h.c.x xVar = (h.c.x) h.c.n0.b.b.e(this.f15534b.apply(t), "The ObservableSource supplied is null");
                C0377a c0377a = new C0377a(this, j2, t);
                if (this.f15536d.compareAndSet(bVar, c0377a)) {
                    xVar.subscribe(c0377a);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                dispose();
                this.a.onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15535c, bVar)) {
                this.f15535c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public c0(h.c.x<T> xVar, h.c.m0.n<? super T, ? extends h.c.x<U>> nVar) {
        super(xVar);
        this.f15533b = nVar;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(new h.c.p0.f(zVar), this.f15533b));
    }
}