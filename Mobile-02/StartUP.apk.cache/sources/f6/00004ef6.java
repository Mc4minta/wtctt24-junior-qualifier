package h.c.n0.e.e;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ObservableTakeLastTimed.java */
/* loaded from: classes3.dex */
public final class p3<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f16080b;

    /* renamed from: c  reason: collision with root package name */
    final long f16081c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f16082d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.a0 f16083e;

    /* renamed from: f  reason: collision with root package name */
    final int f16084f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f16085g;

    /* compiled from: ObservableTakeLastTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicBoolean implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f16086b;

        /* renamed from: c  reason: collision with root package name */
        final long f16087c;

        /* renamed from: d  reason: collision with root package name */
        final TimeUnit f16088d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.a0 f16089e;

        /* renamed from: f  reason: collision with root package name */
        final h.c.n0.f.c<Object> f16090f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f16091g;

        /* renamed from: h  reason: collision with root package name */
        h.c.k0.b f16092h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f16093j;

        /* renamed from: k  reason: collision with root package name */
        Throwable f16094k;

        a(h.c.z<? super T> zVar, long j2, long j3, TimeUnit timeUnit, h.c.a0 a0Var, int i2, boolean z) {
            this.a = zVar;
            this.f16086b = j2;
            this.f16087c = j3;
            this.f16088d = timeUnit;
            this.f16089e = a0Var;
            this.f16090f = new h.c.n0.f.c<>(i2);
            this.f16091g = z;
        }

        void a() {
            Throwable th;
            if (compareAndSet(false, true)) {
                h.c.z<? super T> zVar = this.a;
                h.c.n0.f.c<Object> cVar = this.f16090f;
                boolean z = this.f16091g;
                while (!this.f16093j) {
                    if (!z && (th = this.f16094k) != null) {
                        cVar.clear();
                        zVar.onError(th);
                        return;
                    }
                    Object poll = cVar.poll();
                    if (poll == null) {
                        Throwable th2 = this.f16094k;
                        if (th2 != null) {
                            zVar.onError(th2);
                            return;
                        } else {
                            zVar.onComplete();
                            return;
                        }
                    }
                    Object poll2 = cVar.poll();
                    if (((Long) poll).longValue() >= this.f16089e.b(this.f16088d) - this.f16087c) {
                        zVar.onNext(poll2);
                    }
                }
                cVar.clear();
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f16093j) {
                return;
            }
            this.f16093j = true;
            this.f16092h.dispose();
            if (compareAndSet(false, true)) {
                this.f16090f.clear();
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16093j;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            a();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f16094k = th;
            a();
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            h.c.n0.f.c<Object> cVar = this.f16090f;
            long b2 = this.f16089e.b(this.f16088d);
            long j2 = this.f16087c;
            long j3 = this.f16086b;
            boolean z = j3 == Long.MAX_VALUE;
            cVar.l(Long.valueOf(b2), t);
            while (!cVar.isEmpty()) {
                if (((Long) cVar.m()).longValue() > b2 - j2 && (z || (cVar.p() >> 1) <= j3)) {
                    return;
                }
                cVar.poll();
                cVar.poll();
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16092h, bVar)) {
                this.f16092h = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public p3(h.c.x<T> xVar, long j2, long j3, TimeUnit timeUnit, h.c.a0 a0Var, int i2, boolean z) {
        super(xVar);
        this.f16080b = j2;
        this.f16081c = j3;
        this.f16082d = timeUnit;
        this.f16083e = a0Var;
        this.f16084f = i2;
        this.f16085g = z;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f16080b, this.f16081c, this.f16082d, this.f16083e, this.f16084f, this.f16085g));
    }
}