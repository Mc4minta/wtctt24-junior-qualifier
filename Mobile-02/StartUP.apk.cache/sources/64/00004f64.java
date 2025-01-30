package h.c.n0.e.e;

import h.c.a0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableTimeoutTimed.java */
/* loaded from: classes3.dex */
public final class x3<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f16381b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f16382c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.a0 f16383d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.x<? extends T> f16384e;

    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.z<T> {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f16385b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(h.c.z<? super T> zVar, AtomicReference<h.c.k0.b> atomicReference) {
            this.a = zVar;
            this.f16385b = atomicReference;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.q(this.f16385b, bVar);
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends AtomicReference<h.c.k0.b> implements h.c.z<T>, h.c.k0.b, d {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f16386b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f16387c;

        /* renamed from: d  reason: collision with root package name */
        final a0.c f16388d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.a.g f16389e = new h.c.n0.a.g();

        /* renamed from: f  reason: collision with root package name */
        final AtomicLong f16390f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f16391g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        h.c.x<? extends T> f16392h;

        b(h.c.z<? super T> zVar, long j2, TimeUnit timeUnit, a0.c cVar, h.c.x<? extends T> xVar) {
            this.a = zVar;
            this.f16386b = j2;
            this.f16387c = timeUnit;
            this.f16388d = cVar;
            this.f16392h = xVar;
        }

        @Override // h.c.n0.e.e.x3.d
        public void a(long j2) {
            if (this.f16390f.compareAndSet(j2, Long.MAX_VALUE)) {
                h.c.n0.a.c.h(this.f16391g);
                h.c.x<? extends T> xVar = this.f16392h;
                this.f16392h = null;
                xVar.subscribe(new a(this.a, this));
                this.f16388d.dispose();
            }
        }

        void c(long j2) {
            this.f16389e.a(this.f16388d.c(new e(j2, this), this.f16386b, this.f16387c));
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this.f16391g);
            h.c.n0.a.c.h(this);
            this.f16388d.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f16390f.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f16389e.dispose();
                this.a.onComplete();
                this.f16388d.dispose();
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16390f.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f16389e.dispose();
                this.a.onError(th);
                this.f16388d.dispose();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            long j2 = this.f16390f.get();
            if (j2 != Long.MAX_VALUE) {
                long j3 = 1 + j2;
                if (this.f16390f.compareAndSet(j2, j3)) {
                    this.f16389e.get().dispose();
                    this.a.onNext(t);
                    c(j3);
                }
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this.f16391g, bVar);
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes3.dex */
    static final class c<T> extends AtomicLong implements h.c.z<T>, h.c.k0.b, d {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f16393b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f16394c;

        /* renamed from: d  reason: collision with root package name */
        final a0.c f16395d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.a.g f16396e = new h.c.n0.a.g();

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f16397f = new AtomicReference<>();

        c(h.c.z<? super T> zVar, long j2, TimeUnit timeUnit, a0.c cVar) {
            this.a = zVar;
            this.f16393b = j2;
            this.f16394c = timeUnit;
            this.f16395d = cVar;
        }

        @Override // h.c.n0.e.e.x3.d
        public void a(long j2) {
            if (compareAndSet(j2, Long.MAX_VALUE)) {
                h.c.n0.a.c.h(this.f16397f);
                this.a.onError(new TimeoutException(h.c.n0.j.j.d(this.f16393b, this.f16394c)));
                this.f16395d.dispose();
            }
        }

        void c(long j2) {
            this.f16396e.a(this.f16395d.c(new e(j2, this), this.f16393b, this.f16394c));
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this.f16397f);
            this.f16395d.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(this.f16397f.get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f16396e.dispose();
                this.a.onComplete();
                this.f16395d.dispose();
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f16396e.dispose();
                this.a.onError(th);
                this.f16395d.dispose();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            long j2 = get();
            if (j2 != Long.MAX_VALUE) {
                long j3 = 1 + j2;
                if (compareAndSet(j2, j3)) {
                    this.f16396e.get().dispose();
                    this.a.onNext(t);
                    c(j3);
                }
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this.f16397f, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes3.dex */
    public interface d {
        void a(long j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes3.dex */
    public static final class e implements Runnable {
        final d a;

        /* renamed from: b  reason: collision with root package name */
        final long f16398b;

        e(long j2, d dVar) {
            this.f16398b = j2;
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.f16398b);
        }
    }

    public x3(h.c.s<T> sVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var, h.c.x<? extends T> xVar) {
        super(sVar);
        this.f16381b = j2;
        this.f16382c = timeUnit;
        this.f16383d = a0Var;
        this.f16384e = xVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        if (this.f16384e == null) {
            c cVar = new c(zVar, this.f16381b, this.f16382c, this.f16383d.a());
            zVar.onSubscribe(cVar);
            cVar.c(0L);
            this.a.subscribe(cVar);
            return;
        }
        b bVar = new b(zVar, this.f16381b, this.f16382c, this.f16383d.a(), this.f16384e);
        zVar.onSubscribe(bVar);
        bVar.c(0L);
        this.a.subscribe(bVar);
    }
}