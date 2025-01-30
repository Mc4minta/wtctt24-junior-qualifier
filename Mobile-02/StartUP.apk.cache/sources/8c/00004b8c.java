package h.c;

import java.util.concurrent.TimeUnit;

/* compiled from: Scheduler.java */
/* loaded from: classes2.dex */
public abstract class a0 {
    static final long a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Scheduler.java */
    /* loaded from: classes2.dex */
    public static final class a implements h.c.k0.b, Runnable {
        final Runnable a;

        /* renamed from: b  reason: collision with root package name */
        final c f14068b;

        /* renamed from: c  reason: collision with root package name */
        Thread f14069c;

        a(Runnable runnable, c cVar) {
            this.a = runnable;
            this.f14068b = cVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f14069c == Thread.currentThread()) {
                c cVar = this.f14068b;
                if (cVar instanceof h.c.n0.g.i) {
                    ((h.c.n0.g.i) cVar).h();
                    return;
                }
            }
            this.f14068b.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14068b.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14069c = Thread.currentThread();
            try {
                this.a.run();
            } finally {
                dispose();
                this.f14069c = null;
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* loaded from: classes2.dex */
    static final class b implements h.c.k0.b, Runnable {
        final Runnable a;

        /* renamed from: b  reason: collision with root package name */
        final c f14070b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f14071c;

        b(Runnable runnable, c cVar) {
            this.a = runnable;
            this.f14070b = cVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f14071c = true;
            this.f14070b.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14071c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14071c) {
                return;
            }
            try {
                this.a.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f14070b.dispose();
                throw h.c.n0.j.j.e(th);
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* loaded from: classes2.dex */
    public static abstract class c implements h.c.k0.b {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Scheduler.java */
        /* loaded from: classes2.dex */
        public final class a implements Runnable {
            final Runnable a;

            /* renamed from: b  reason: collision with root package name */
            final h.c.n0.a.g f14072b;

            /* renamed from: c  reason: collision with root package name */
            final long f14073c;

            /* renamed from: d  reason: collision with root package name */
            long f14074d;

            /* renamed from: e  reason: collision with root package name */
            long f14075e;

            /* renamed from: f  reason: collision with root package name */
            long f14076f;

            a(long j2, Runnable runnable, long j3, h.c.n0.a.g gVar, long j4) {
                this.a = runnable;
                this.f14072b = gVar;
                this.f14073c = j4;
                this.f14075e = j3;
                this.f14076f = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j2;
                this.a.run();
                if (this.f14072b.isDisposed()) {
                    return;
                }
                c cVar = c.this;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                long a = cVar.a(timeUnit);
                long j3 = a0.a;
                long j4 = this.f14075e;
                if (a + j3 >= j4) {
                    long j5 = this.f14073c;
                    if (a < j4 + j5 + j3) {
                        long j6 = this.f14076f;
                        long j7 = this.f14074d + 1;
                        this.f14074d = j7;
                        j2 = j6 + (j7 * j5);
                        this.f14075e = a;
                        this.f14072b.a(c.this.c(this, j2 - a, timeUnit));
                    }
                }
                long j8 = this.f14073c;
                long j9 = a + j8;
                long j10 = this.f14074d + 1;
                this.f14074d = j10;
                this.f14076f = j9 - (j8 * j10);
                j2 = j9;
                this.f14075e = a;
                this.f14072b.a(c.this.c(this, j2 - a, timeUnit));
            }
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public h.c.k0.b b(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract h.c.k0.b c(Runnable runnable, long j2, TimeUnit timeUnit);

        public h.c.k0.b d(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
            h.c.n0.a.g gVar = new h.c.n0.a.g();
            h.c.n0.a.g gVar2 = new h.c.n0.a.g(gVar);
            Runnable w = h.c.r0.a.w(runnable);
            long nanos = timeUnit.toNanos(j3);
            long a2 = a(TimeUnit.NANOSECONDS);
            h.c.k0.b c2 = c(new a(a2 + timeUnit.toNanos(j2), w, a2, gVar2, nanos), j2, timeUnit);
            if (c2 == h.c.n0.a.d.INSTANCE) {
                return c2;
            }
            gVar.a(c2);
            return gVar2;
        }
    }

    public abstract c a();

    public long b(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public h.c.k0.b c(Runnable runnable) {
        return d(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public h.c.k0.b d(Runnable runnable, long j2, TimeUnit timeUnit) {
        c a2 = a();
        a aVar = new a(h.c.r0.a.w(runnable), a2);
        a2.c(aVar, j2, timeUnit);
        return aVar;
    }

    public h.c.k0.b e(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        c a2 = a();
        b bVar = new b(h.c.r0.a.w(runnable), a2);
        h.c.k0.b d2 = a2.d(bVar, j2, j3, timeUnit);
        return d2 == h.c.n0.a.d.INSTANCE ? d2 : bVar;
    }
}