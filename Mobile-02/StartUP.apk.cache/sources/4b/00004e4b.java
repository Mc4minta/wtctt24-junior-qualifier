package h.c.n0.e.e;

import h.c.a0;
import java.util.concurrent.TimeUnit;

/* compiled from: ObservableDelay.java */
/* loaded from: classes3.dex */
public final class f0<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f15652b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f15653c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.a0 f15654d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f15655e;

    /* compiled from: ObservableDelay.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f15656b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f15657c;

        /* renamed from: d  reason: collision with root package name */
        final a0.c f15658d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f15659e;

        /* renamed from: f  reason: collision with root package name */
        h.c.k0.b f15660f;

        /* compiled from: ObservableDelay.java */
        /* renamed from: h.c.n0.e.e.f0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class RunnableC0379a implements Runnable {
            RunnableC0379a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a.onComplete();
                } finally {
                    a.this.f15658d.dispose();
                }
            }
        }

        /* compiled from: ObservableDelay.java */
        /* loaded from: classes3.dex */
        final class b implements Runnable {
            private final Throwable a;

            b(Throwable th) {
                this.a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a.onError(this.a);
                } finally {
                    a.this.f15658d.dispose();
                }
            }
        }

        /* compiled from: ObservableDelay.java */
        /* loaded from: classes3.dex */
        final class c implements Runnable {
            private final T a;

            c(T t) {
                this.a = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.onNext((T) this.a);
            }
        }

        a(h.c.z<? super T> zVar, long j2, TimeUnit timeUnit, a0.c cVar, boolean z) {
            this.a = zVar;
            this.f15656b = j2;
            this.f15657c = timeUnit;
            this.f15658d = cVar;
            this.f15659e = z;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15660f.dispose();
            this.f15658d.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15658d.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15658d.c(new RunnableC0379a(), this.f15656b, this.f15657c);
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f15658d.c(new b(th), this.f15659e ? this.f15656b : 0L, this.f15657c);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.f15658d.c(new c(t), this.f15656b, this.f15657c);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15660f, bVar)) {
                this.f15660f = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public f0(h.c.x<T> xVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var, boolean z) {
        super(xVar);
        this.f15652b = j2;
        this.f15653c = timeUnit;
        this.f15654d = a0Var;
        this.f15655e = z;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(this.f15655e ? zVar : new h.c.p0.f(zVar), this.f15652b, this.f15653c, this.f15654d.a(), this.f15655e));
    }
}