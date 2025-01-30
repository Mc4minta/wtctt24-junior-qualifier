package h.c.n0.e.b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableSkipLastTimed.java */
/* loaded from: classes3.dex */
public final class t3<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f15041b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f15042c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.a0 f15043d;

    /* renamed from: e  reason: collision with root package name */
    final int f15044e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f15045f;

    /* compiled from: FlowableSkipLastTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f15046b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f15047c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.a0 f15048d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.f.c<Object> f15049e;

        /* renamed from: f  reason: collision with root package name */
        final boolean f15050f;

        /* renamed from: g  reason: collision with root package name */
        k.a.d f15051g;

        /* renamed from: h  reason: collision with root package name */
        final AtomicLong f15052h = new AtomicLong();

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f15053j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f15054k;

        /* renamed from: l  reason: collision with root package name */
        Throwable f15055l;

        a(k.a.c<? super T> cVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var, int i2, boolean z) {
            this.a = cVar;
            this.f15046b = j2;
            this.f15047c = timeUnit;
            this.f15048d = a0Var;
            this.f15049e = new h.c.n0.f.c<>(i2);
            this.f15050f = z;
        }

        boolean a(boolean z, boolean z2, k.a.c<? super T> cVar, boolean z3) {
            if (this.f15053j) {
                this.f15049e.clear();
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.f15055l;
                        if (th != null) {
                            cVar.onError(th);
                        } else {
                            cVar.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.f15055l;
                if (th2 != null) {
                    this.f15049e.clear();
                    cVar.onError(th2);
                    return true;
                } else if (z2) {
                    cVar.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            k.a.c<? super T> cVar = this.a;
            h.c.n0.f.c<Object> cVar2 = this.f15049e;
            boolean z = this.f15050f;
            TimeUnit timeUnit = this.f15047c;
            h.c.a0 a0Var = this.f15048d;
            long j2 = this.f15046b;
            int i2 = 1;
            do {
                long j3 = this.f15052h.get();
                long j4 = 0;
                while (j4 != j3) {
                    boolean z2 = this.f15054k;
                    Long l2 = (Long) cVar2.m();
                    boolean z3 = l2 == null;
                    boolean z4 = (z3 || l2.longValue() <= a0Var.b(timeUnit) - j2) ? z3 : true;
                    if (a(z2, z4, cVar, z)) {
                        return;
                    }
                    if (z4) {
                        break;
                    }
                    cVar2.poll();
                    cVar.onNext(cVar2.poll());
                    j4++;
                }
                if (j4 != 0) {
                    h.c.n0.j.d.e(this.f15052h, j4);
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f15053j) {
                return;
            }
            this.f15053j = true;
            this.f15051g.cancel();
            if (getAndIncrement() == 0) {
                this.f15049e.clear();
            }
        }

        @Override // k.a.c
        public void onComplete() {
            this.f15054k = true;
            b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f15055l = th;
            this.f15054k = true;
            b();
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.f15049e.l(Long.valueOf(this.f15048d.b(this.f15047c)), t);
            b();
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15051g, dVar)) {
                this.f15051g = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f15052h, j2);
                b();
            }
        }
    }

    public t3(h.c.h<T> hVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var, int i2, boolean z) {
        super(hVar);
        this.f15041b = j2;
        this.f15042c = timeUnit;
        this.f15043d = a0Var;
        this.f15044e = i2;
        this.f15045f = z;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f15041b, this.f15042c, this.f15043d, this.f15044e, this.f15045f));
    }
}