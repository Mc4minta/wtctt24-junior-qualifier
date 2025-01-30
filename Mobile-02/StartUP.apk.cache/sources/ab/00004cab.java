package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableSampleTimed.java */
/* loaded from: classes3.dex */
public final class h3<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f14461b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f14462c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.a0 f14463d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f14464e;

    /* compiled from: FlowableSampleTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends c<T> {

        /* renamed from: h  reason: collision with root package name */
        final AtomicInteger f14465h;

        a(k.a.c<? super T> cVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
            super(cVar, j2, timeUnit, a0Var);
            this.f14465h = new AtomicInteger(1);
        }

        @Override // h.c.n0.e.b.h3.c
        void b() {
            c();
            if (this.f14465h.decrementAndGet() == 0) {
                this.a.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14465h.incrementAndGet() == 2) {
                c();
                if (this.f14465h.decrementAndGet() == 0) {
                    this.a.onComplete();
                }
            }
        }
    }

    /* compiled from: FlowableSampleTimed.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends c<T> {
        b(k.a.c<? super T> cVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
            super(cVar, j2, timeUnit, a0Var);
        }

        @Override // h.c.n0.e.b.h3.c
        void b() {
            this.a.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            c();
        }
    }

    /* compiled from: FlowableSampleTimed.java */
    /* loaded from: classes3.dex */
    static abstract class c<T> extends AtomicReference<T> implements h.c.m<T>, k.a.d, Runnable {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f14466b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f14467c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.a0 f14468d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicLong f14469e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        final h.c.n0.a.g f14470f = new h.c.n0.a.g();

        /* renamed from: g  reason: collision with root package name */
        k.a.d f14471g;

        c(k.a.c<? super T> cVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
            this.a = cVar;
            this.f14466b = j2;
            this.f14467c = timeUnit;
            this.f14468d = a0Var;
        }

        void a() {
            h.c.n0.a.c.h(this.f14470f);
        }

        abstract void b();

        void c() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.f14469e.get() != 0) {
                    this.a.onNext(andSet);
                    h.c.n0.j.d.e(this.f14469e, 1L);
                    return;
                }
                cancel();
                this.a.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
            }
        }

        @Override // k.a.d
        public void cancel() {
            a();
            this.f14471g.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            a();
            b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            a();
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14471g, dVar)) {
                this.f14471g = dVar;
                this.a.onSubscribe(this);
                h.c.n0.a.g gVar = this.f14470f;
                h.c.a0 a0Var = this.f14468d;
                long j2 = this.f14466b;
                gVar.a(a0Var.e(this, j2, j2, this.f14467c));
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f14469e, j2);
            }
        }
    }

    public h3(h.c.h<T> hVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var, boolean z) {
        super(hVar);
        this.f14461b = j2;
        this.f14462c = timeUnit;
        this.f14463d = a0Var;
        this.f14464e = z;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        h.c.w0.d dVar = new h.c.w0.d(cVar);
        if (this.f14464e) {
            this.a.subscribe((h.c.m) new a(dVar, this.f14461b, this.f14462c, this.f14463d));
        } else {
            this.a.subscribe((h.c.m) new b(dVar, this.f14461b, this.f14462c, this.f14463d));
        }
    }
}