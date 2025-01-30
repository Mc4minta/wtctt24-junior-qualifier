package h.c.n0.e.e;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableSkipLastTimed.java */
/* loaded from: classes3.dex */
public final class g3<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f15698b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f15699c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.a0 f15700d;

    /* renamed from: e  reason: collision with root package name */
    final int f15701e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f15702f;

    /* compiled from: ObservableSkipLastTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f15703b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f15704c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.a0 f15705d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.f.c<Object> f15706e;

        /* renamed from: f  reason: collision with root package name */
        final boolean f15707f;

        /* renamed from: g  reason: collision with root package name */
        h.c.k0.b f15708g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f15709h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f15710j;

        /* renamed from: k  reason: collision with root package name */
        Throwable f15711k;

        a(h.c.z<? super T> zVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var, int i2, boolean z) {
            this.a = zVar;
            this.f15703b = j2;
            this.f15704c = timeUnit;
            this.f15705d = a0Var;
            this.f15706e = new h.c.n0.f.c<>(i2);
            this.f15707f = z;
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            h.c.z<? super T> zVar = this.a;
            h.c.n0.f.c<Object> cVar = this.f15706e;
            boolean z = this.f15707f;
            TimeUnit timeUnit = this.f15704c;
            h.c.a0 a0Var = this.f15705d;
            long j2 = this.f15703b;
            int i2 = 1;
            while (!this.f15709h) {
                boolean z2 = this.f15710j;
                Long l2 = (Long) cVar.m();
                boolean z3 = l2 == null;
                long b2 = a0Var.b(timeUnit);
                if (!z3 && l2.longValue() > b2 - j2) {
                    z3 = true;
                }
                if (z2) {
                    if (!z) {
                        Throwable th = this.f15711k;
                        if (th != null) {
                            this.f15706e.clear();
                            zVar.onError(th);
                            return;
                        } else if (z3) {
                            zVar.onComplete();
                            return;
                        }
                    } else if (z3) {
                        Throwable th2 = this.f15711k;
                        if (th2 != null) {
                            zVar.onError(th2);
                            return;
                        } else {
                            zVar.onComplete();
                            return;
                        }
                    }
                }
                if (z3) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    cVar.poll();
                    zVar.onNext(cVar.poll());
                }
            }
            this.f15706e.clear();
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f15709h) {
                return;
            }
            this.f15709h = true;
            this.f15708g.dispose();
            if (getAndIncrement() == 0) {
                this.f15706e.clear();
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15709h;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15710j = true;
            a();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f15711k = th;
            this.f15710j = true;
            a();
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.f15706e.l(Long.valueOf(this.f15705d.b(this.f15704c)), t);
            a();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15708g, bVar)) {
                this.f15708g = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public g3(h.c.x<T> xVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var, int i2, boolean z) {
        super(xVar);
        this.f15698b = j2;
        this.f15699c = timeUnit;
        this.f15700d = a0Var;
        this.f15701e = i2;
        this.f15702f = z;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new a(zVar, this.f15698b, this.f15699c, this.f15700d, this.f15701e, this.f15702f));
    }
}