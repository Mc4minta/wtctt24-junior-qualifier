package h.c.n0.e.e;

import h.c.a0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableThrottleLatest.java */
/* loaded from: classes3.dex */
public final class u3<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f16271b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f16272c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.a0 f16273d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f16274e;

    /* compiled from: ObservableThrottleLatest.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.z<T>, h.c.k0.b, Runnable {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f16275b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f16276c;

        /* renamed from: d  reason: collision with root package name */
        final a0.c f16277d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f16278e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<T> f16279f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        h.c.k0.b f16280g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f16281h;

        /* renamed from: j  reason: collision with root package name */
        Throwable f16282j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f16283k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f16284l;
        boolean m;

        a(h.c.z<? super T> zVar, long j2, TimeUnit timeUnit, a0.c cVar, boolean z) {
            this.a = zVar;
            this.f16275b = j2;
            this.f16276c = timeUnit;
            this.f16277d = cVar;
            this.f16278e = z;
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<T> atomicReference = this.f16279f;
            h.c.z<? super T> zVar = this.a;
            int i2 = 1;
            while (!this.f16283k) {
                boolean z = this.f16281h;
                if (z && this.f16282j != null) {
                    atomicReference.lazySet(null);
                    zVar.onError(this.f16282j);
                    this.f16277d.dispose();
                    return;
                }
                boolean z2 = atomicReference.get() == null;
                if (z) {
                    T andSet = atomicReference.getAndSet(null);
                    if (!z2 && this.f16278e) {
                        zVar.onNext(andSet);
                    }
                    zVar.onComplete();
                    this.f16277d.dispose();
                    return;
                }
                if (z2) {
                    if (this.f16284l) {
                        this.m = false;
                        this.f16284l = false;
                    }
                } else if (!this.m || this.f16284l) {
                    zVar.onNext(atomicReference.getAndSet(null));
                    this.f16284l = false;
                    this.m = true;
                    this.f16277d.c(this, this.f16275b, this.f16276c);
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16283k = true;
            this.f16280g.dispose();
            this.f16277d.dispose();
            if (getAndIncrement() == 0) {
                this.f16279f.lazySet(null);
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16283k;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f16281h = true;
            a();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f16282j = th;
            this.f16281h = true;
            a();
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.f16279f.set(t);
            a();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16280g, bVar)) {
                this.f16280g = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f16284l = true;
            a();
        }
    }

    public u3(h.c.s<T> sVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var, boolean z) {
        super(sVar);
        this.f16271b = j2;
        this.f16272c = timeUnit;
        this.f16273d = a0Var;
        this.f16274e = z;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f16271b, this.f16272c, this.f16273d.a(), this.f16274e));
    }
}