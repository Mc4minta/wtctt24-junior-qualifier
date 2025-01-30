package h.c.n0.e.b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableTakeLastTimed.java */
/* loaded from: classes3.dex */
public final class c4<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f14287b;

    /* renamed from: c  reason: collision with root package name */
    final long f14288c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f14289d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.a0 f14290e;

    /* renamed from: f  reason: collision with root package name */
    final int f14291f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f14292g;

    /* compiled from: FlowableTakeLastTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f14293b;

        /* renamed from: c  reason: collision with root package name */
        final long f14294c;

        /* renamed from: d  reason: collision with root package name */
        final TimeUnit f14295d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.a0 f14296e;

        /* renamed from: f  reason: collision with root package name */
        final h.c.n0.f.c<Object> f14297f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f14298g;

        /* renamed from: h  reason: collision with root package name */
        k.a.d f14299h;

        /* renamed from: j  reason: collision with root package name */
        final AtomicLong f14300j = new AtomicLong();

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f14301k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f14302l;
        Throwable m;

        a(k.a.c<? super T> cVar, long j2, long j3, TimeUnit timeUnit, h.c.a0 a0Var, int i2, boolean z) {
            this.a = cVar;
            this.f14293b = j2;
            this.f14294c = j3;
            this.f14295d = timeUnit;
            this.f14296e = a0Var;
            this.f14297f = new h.c.n0.f.c<>(i2);
            this.f14298g = z;
        }

        boolean a(boolean z, k.a.c<? super T> cVar, boolean z2) {
            if (this.f14301k) {
                this.f14297f.clear();
                return true;
            } else if (z2) {
                if (z) {
                    Throwable th = this.m;
                    if (th != null) {
                        cVar.onError(th);
                    } else {
                        cVar.onComplete();
                    }
                    return true;
                }
                return false;
            } else {
                Throwable th2 = this.m;
                if (th2 != null) {
                    this.f14297f.clear();
                    cVar.onError(th2);
                    return true;
                } else if (z) {
                    cVar.onComplete();
                    return true;
                } else {
                    return false;
                }
            }
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            k.a.c<? super T> cVar = this.a;
            h.c.n0.f.c<Object> cVar2 = this.f14297f;
            boolean z = this.f14298g;
            int i2 = 1;
            do {
                if (this.f14302l) {
                    if (a(cVar2.isEmpty(), cVar, z)) {
                        return;
                    }
                    long j2 = this.f14300j.get();
                    long j3 = 0;
                    while (true) {
                        if (a(cVar2.m() == null, cVar, z)) {
                            return;
                        }
                        if (j2 != j3) {
                            cVar2.poll();
                            cVar.onNext(cVar2.poll());
                            j3++;
                        } else if (j3 != 0) {
                            h.c.n0.j.d.e(this.f14300j, j3);
                        }
                    }
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }

        void c(long j2, h.c.n0.f.c<Object> cVar) {
            long j3 = this.f14294c;
            long j4 = this.f14293b;
            boolean z = j4 == Long.MAX_VALUE;
            while (!cVar.isEmpty()) {
                if (((Long) cVar.m()).longValue() >= j2 - j3 && (z || (cVar.p() >> 1) <= j4)) {
                    return;
                }
                cVar.poll();
                cVar.poll();
            }
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f14301k) {
                return;
            }
            this.f14301k = true;
            this.f14299h.cancel();
            if (getAndIncrement() == 0) {
                this.f14297f.clear();
            }
        }

        @Override // k.a.c
        public void onComplete() {
            c(this.f14296e.b(this.f14295d), this.f14297f);
            this.f14302l = true;
            b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14298g) {
                c(this.f14296e.b(this.f14295d), this.f14297f);
            }
            this.m = th;
            this.f14302l = true;
            b();
        }

        @Override // k.a.c
        public void onNext(T t) {
            h.c.n0.f.c<Object> cVar = this.f14297f;
            long b2 = this.f14296e.b(this.f14295d);
            cVar.l(Long.valueOf(b2), t);
            c(b2, cVar);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14299h, dVar)) {
                this.f14299h = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f14300j, j2);
                b();
            }
        }
    }

    public c4(h.c.h<T> hVar, long j2, long j3, TimeUnit timeUnit, h.c.a0 a0Var, int i2, boolean z) {
        super(hVar);
        this.f14287b = j2;
        this.f14288c = j3;
        this.f14289d = timeUnit;
        this.f14290e = a0Var;
        this.f14291f = i2;
        this.f14292g = z;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14287b, this.f14288c, this.f14289d, this.f14290e, this.f14291f, this.f14292g));
    }
}