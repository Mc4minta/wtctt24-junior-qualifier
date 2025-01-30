package h.c.n0.e.e;

import h.c.a0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableDebounceTimed.java */
/* loaded from: classes3.dex */
public final class d0<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f15570b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f15571c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.a0 f15572d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableDebounceTimed.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends AtomicReference<h.c.k0.b> implements Runnable, h.c.k0.b {
        final T a;

        /* renamed from: b  reason: collision with root package name */
        final long f15573b;

        /* renamed from: c  reason: collision with root package name */
        final b<T> f15574c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicBoolean f15575d = new AtomicBoolean();

        a(T t, long j2, b<T> bVar) {
            this.a = t;
            this.f15573b = j2;
            this.f15574c = bVar;
        }

        public void a(h.c.k0.b bVar) {
            h.c.n0.a.c.q(this, bVar);
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get() == h.c.n0.a.c.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f15575d.compareAndSet(false, true)) {
                this.f15574c.a(this.f15573b, this.a, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableDebounceTimed.java */
    /* loaded from: classes3.dex */
    public static final class b<T> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f15576b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f15577c;

        /* renamed from: d  reason: collision with root package name */
        final a0.c f15578d;

        /* renamed from: e  reason: collision with root package name */
        h.c.k0.b f15579e;

        /* renamed from: f  reason: collision with root package name */
        h.c.k0.b f15580f;

        /* renamed from: g  reason: collision with root package name */
        volatile long f15581g;

        /* renamed from: h  reason: collision with root package name */
        boolean f15582h;

        b(h.c.z<? super T> zVar, long j2, TimeUnit timeUnit, a0.c cVar) {
            this.a = zVar;
            this.f15576b = j2;
            this.f15577c = timeUnit;
            this.f15578d = cVar;
        }

        void a(long j2, T t, a<T> aVar) {
            if (j2 == this.f15581g) {
                this.a.onNext(t);
                aVar.dispose();
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15579e.dispose();
            this.f15578d.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15578d.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15582h) {
                return;
            }
            this.f15582h = true;
            h.c.k0.b bVar = this.f15580f;
            if (bVar != null) {
                bVar.dispose();
            }
            a aVar = (a) bVar;
            if (aVar != null) {
                aVar.run();
            }
            this.a.onComplete();
            this.f15578d.dispose();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15582h) {
                h.c.r0.a.u(th);
                return;
            }
            h.c.k0.b bVar = this.f15580f;
            if (bVar != null) {
                bVar.dispose();
            }
            this.f15582h = true;
            this.a.onError(th);
            this.f15578d.dispose();
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15582h) {
                return;
            }
            long j2 = this.f15581g + 1;
            this.f15581g = j2;
            h.c.k0.b bVar = this.f15580f;
            if (bVar != null) {
                bVar.dispose();
            }
            a aVar = new a(t, j2, this);
            this.f15580f = aVar;
            aVar.a(this.f15578d.c(aVar, this.f15576b, this.f15577c));
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15579e, bVar)) {
                this.f15579e = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public d0(h.c.x<T> xVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
        super(xVar);
        this.f15570b = j2;
        this.f15571c = timeUnit;
        this.f15572d = a0Var;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new b(new h.c.p0.f(zVar), this.f15570b, this.f15571c, this.f15572d.a()));
    }
}