package h.c.n0.e.b;

import h.c.a0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableTimeoutTimed.java */
/* loaded from: classes3.dex */
public final class l4<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f14656b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f14657c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.a0 f14658d;

    /* renamed from: e  reason: collision with root package name */
    final k.a.b<? extends T> f14659e;

    /* compiled from: FlowableTimeoutTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T> {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.i.f f14660b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(k.a.c<? super T> cVar, h.c.n0.i.f fVar) {
            this.a = cVar;
            this.f14660b = fVar;
        }

        @Override // k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            this.f14660b.i(dVar);
        }
    }

    /* compiled from: FlowableTimeoutTimed.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends h.c.n0.i.f implements h.c.m<T>, d {

        /* renamed from: j  reason: collision with root package name */
        final k.a.c<? super T> f14661j;

        /* renamed from: k  reason: collision with root package name */
        final long f14662k;

        /* renamed from: l  reason: collision with root package name */
        final TimeUnit f14663l;
        final a0.c m;
        final h.c.n0.a.g n;
        final AtomicReference<k.a.d> p;
        final AtomicLong q;
        long t;
        k.a.b<? extends T> u;

        b(k.a.c<? super T> cVar, long j2, TimeUnit timeUnit, a0.c cVar2, k.a.b<? extends T> bVar) {
            super(true);
            this.f14661j = cVar;
            this.f14662k = j2;
            this.f14663l = timeUnit;
            this.m = cVar2;
            this.u = bVar;
            this.n = new h.c.n0.a.g();
            this.p = new AtomicReference<>();
            this.q = new AtomicLong();
        }

        @Override // h.c.n0.e.b.l4.d
        public void a(long j2) {
            if (this.q.compareAndSet(j2, Long.MAX_VALUE)) {
                h.c.n0.i.g.h(this.p);
                long j3 = this.t;
                if (j3 != 0) {
                    g(j3);
                }
                k.a.b<? extends T> bVar = this.u;
                this.u = null;
                bVar.subscribe(new a(this.f14661j, this));
                this.m.dispose();
            }
        }

        @Override // h.c.n0.i.f, k.a.d
        public void cancel() {
            super.cancel();
            this.m.dispose();
        }

        void j(long j2) {
            this.n.a(this.m.c(new e(j2, this), this.f14662k, this.f14663l));
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.q.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.n.dispose();
                this.f14661j.onComplete();
                this.m.dispose();
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.q.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.n.dispose();
                this.f14661j.onError(th);
                this.m.dispose();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            long j2 = this.q.get();
            if (j2 != Long.MAX_VALUE) {
                long j3 = j2 + 1;
                if (this.q.compareAndSet(j2, j3)) {
                    this.n.get().dispose();
                    this.t++;
                    this.f14661j.onNext(t);
                    j(j3);
                }
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.z(this.p, dVar)) {
                i(dVar);
            }
        }
    }

    /* compiled from: FlowableTimeoutTimed.java */
    /* loaded from: classes3.dex */
    static final class c<T> extends AtomicLong implements h.c.m<T>, k.a.d, d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f14664b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f14665c;

        /* renamed from: d  reason: collision with root package name */
        final a0.c f14666d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.a.g f14667e = new h.c.n0.a.g();

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<k.a.d> f14668f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        final AtomicLong f14669g = new AtomicLong();

        c(k.a.c<? super T> cVar, long j2, TimeUnit timeUnit, a0.c cVar2) {
            this.a = cVar;
            this.f14664b = j2;
            this.f14665c = timeUnit;
            this.f14666d = cVar2;
        }

        @Override // h.c.n0.e.b.l4.d
        public void a(long j2) {
            if (compareAndSet(j2, Long.MAX_VALUE)) {
                h.c.n0.i.g.h(this.f14668f);
                this.a.onError(new TimeoutException(h.c.n0.j.j.d(this.f14664b, this.f14665c)));
                this.f14666d.dispose();
            }
        }

        void c(long j2) {
            this.f14667e.a(this.f14666d.c(new e(j2, this), this.f14664b, this.f14665c));
        }

        @Override // k.a.d
        public void cancel() {
            h.c.n0.i.g.h(this.f14668f);
            this.f14666d.dispose();
        }

        @Override // k.a.c
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f14667e.dispose();
                this.a.onComplete();
                this.f14666d.dispose();
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f14667e.dispose();
                this.a.onError(th);
                this.f14666d.dispose();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            long j2 = get();
            if (j2 != Long.MAX_VALUE) {
                long j3 = 1 + j2;
                if (compareAndSet(j2, j3)) {
                    this.f14667e.get().dispose();
                    this.a.onNext(t);
                    c(j3);
                }
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.q(this.f14668f, this.f14669g, dVar);
        }

        @Override // k.a.d
        public void request(long j2) {
            h.c.n0.i.g.n(this.f14668f, this.f14669g, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableTimeoutTimed.java */
    /* loaded from: classes3.dex */
    public interface d {
        void a(long j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableTimeoutTimed.java */
    /* loaded from: classes3.dex */
    public static final class e implements Runnable {
        final d a;

        /* renamed from: b  reason: collision with root package name */
        final long f14670b;

        e(long j2, d dVar) {
            this.f14670b = j2;
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.f14670b);
        }
    }

    public l4(h.c.h<T> hVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var, k.a.b<? extends T> bVar) {
        super(hVar);
        this.f14656b = j2;
        this.f14657c = timeUnit;
        this.f14658d = a0Var;
        this.f14659e = bVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        if (this.f14659e == null) {
            c cVar2 = new c(cVar, this.f14656b, this.f14657c, this.f14658d.a());
            cVar.onSubscribe(cVar2);
            cVar2.c(0L);
            this.a.subscribe((h.c.m) cVar2);
            return;
        }
        b bVar = new b(cVar, this.f14656b, this.f14657c, this.f14658d.a(), this.f14659e);
        cVar.onSubscribe(bVar);
        bVar.j(0L);
        this.a.subscribe((h.c.m) bVar);
    }
}