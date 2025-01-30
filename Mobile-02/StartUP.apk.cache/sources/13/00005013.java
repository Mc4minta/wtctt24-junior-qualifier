package h.c.n0.g;

import h.c.a0;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TrampolineScheduler.java */
/* loaded from: classes3.dex */
public final class q extends a0 {

    /* renamed from: b  reason: collision with root package name */
    private static final q f16697b = new q();

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes3.dex */
    static final class a implements Runnable {
        private final Runnable a;

        /* renamed from: b  reason: collision with root package name */
        private final c f16698b;

        /* renamed from: c  reason: collision with root package name */
        private final long f16699c;

        a(Runnable runnable, c cVar, long j2) {
            this.a = runnable;
            this.f16698b = cVar;
            this.f16699c = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f16698b.f16705d) {
                return;
            }
            long a = this.f16698b.a(TimeUnit.MILLISECONDS);
            long j2 = this.f16699c;
            if (j2 > a) {
                try {
                    Thread.sleep(j2 - a);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    h.c.r0.a.u(e2);
                    return;
                }
            }
            if (this.f16698b.f16705d) {
                return;
            }
            this.a.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes3.dex */
    public static final class b implements Comparable<b> {
        final Runnable a;

        /* renamed from: b  reason: collision with root package name */
        final long f16700b;

        /* renamed from: c  reason: collision with root package name */
        final int f16701c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f16702d;

        b(Runnable runnable, Long l2, int i2) {
            this.a = runnable;
            this.f16700b = l2.longValue();
            this.f16701c = i2;
        }

        @Override // java.lang.Comparable
        /* renamed from: h */
        public int compareTo(b bVar) {
            int b2 = h.c.n0.b.b.b(this.f16700b, bVar.f16700b);
            return b2 == 0 ? h.c.n0.b.b.a(this.f16701c, bVar.f16701c) : b2;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes3.dex */
    static final class c extends a0.c implements h.c.k0.b {
        final PriorityBlockingQueue<b> a = new PriorityBlockingQueue<>();

        /* renamed from: b  reason: collision with root package name */
        private final AtomicInteger f16703b = new AtomicInteger();

        /* renamed from: c  reason: collision with root package name */
        final AtomicInteger f16704c = new AtomicInteger();

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f16705d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TrampolineScheduler.java */
        /* loaded from: classes3.dex */
        public final class a implements Runnable {
            final b a;

            a(b bVar) {
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.f16702d = true;
                c.this.a.remove(this.a);
            }
        }

        c() {
        }

        @Override // h.c.a0.c
        public h.c.k0.b b(Runnable runnable) {
            return e(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // h.c.a0.c
        public h.c.k0.b c(Runnable runnable, long j2, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j2);
            return e(new a(runnable, this, a2), a2);
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16705d = true;
        }

        h.c.k0.b e(Runnable runnable, long j2) {
            if (this.f16705d) {
                return h.c.n0.a.d.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j2), this.f16704c.incrementAndGet());
            this.a.add(bVar);
            if (this.f16703b.getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f16705d) {
                    b poll = this.a.poll();
                    if (poll == null) {
                        i2 = this.f16703b.addAndGet(-i2);
                        if (i2 == 0) {
                            return h.c.n0.a.d.INSTANCE;
                        }
                    } else if (!poll.f16702d) {
                        poll.a.run();
                    }
                }
                this.a.clear();
                return h.c.n0.a.d.INSTANCE;
            }
            return h.c.k0.c.c(new a(bVar));
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16705d;
        }
    }

    q() {
    }

    public static q f() {
        return f16697b;
    }

    @Override // h.c.a0
    public a0.c a() {
        return new c();
    }

    @Override // h.c.a0
    public h.c.k0.b c(Runnable runnable) {
        h.c.r0.a.w(runnable).run();
        return h.c.n0.a.d.INSTANCE;
    }

    @Override // h.c.a0
    public h.c.k0.b d(Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j2);
            h.c.r0.a.w(runnable).run();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            h.c.r0.a.u(e2);
        }
        return h.c.n0.a.d.INSTANCE;
    }
}