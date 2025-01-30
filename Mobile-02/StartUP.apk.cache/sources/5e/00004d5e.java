package h.c.n0.e.b;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableWindow.java */
/* loaded from: classes3.dex */
public final class r4<T> extends h.c.n0.e.b.a<T, h.c.h<T>> {

    /* renamed from: b  reason: collision with root package name */
    final long f14936b;

    /* renamed from: c  reason: collision with root package name */
    final long f14937c;

    /* renamed from: d  reason: collision with root package name */
    final int f14938d;

    /* compiled from: FlowableWindow.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.m<T>, k.a.d, Runnable {
        final k.a.c<? super h.c.h<T>> a;

        /* renamed from: b  reason: collision with root package name */
        final long f14939b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicBoolean f14940c;

        /* renamed from: d  reason: collision with root package name */
        final int f14941d;

        /* renamed from: e  reason: collision with root package name */
        long f14942e;

        /* renamed from: f  reason: collision with root package name */
        k.a.d f14943f;

        /* renamed from: g  reason: collision with root package name */
        h.c.s0.c<T> f14944g;

        a(k.a.c<? super h.c.h<T>> cVar, long j2, int i2) {
            super(1);
            this.a = cVar;
            this.f14939b = j2;
            this.f14940c = new AtomicBoolean();
            this.f14941d = i2;
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f14940c.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // k.a.c
        public void onComplete() {
            h.c.s0.c<T> cVar = this.f14944g;
            if (cVar != null) {
                this.f14944g = null;
                cVar.onComplete();
            }
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            h.c.s0.c<T> cVar = this.f14944g;
            if (cVar != null) {
                this.f14944g = null;
                cVar.onError(th);
            }
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            long j2 = this.f14942e;
            h.c.s0.c<T> cVar = this.f14944g;
            if (j2 == 0) {
                getAndIncrement();
                cVar = h.c.s0.c.f(this.f14941d, this);
                this.f14944g = cVar;
                this.a.onNext(cVar);
            }
            long j3 = j2 + 1;
            cVar.onNext(t);
            if (j3 == this.f14939b) {
                this.f14942e = 0L;
                this.f14944g = null;
                cVar.onComplete();
                return;
            }
            this.f14942e = j3;
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14943f, dVar)) {
                this.f14943f = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                this.f14943f.request(h.c.n0.j.d.d(this.f14939b, j2));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.f14943f.cancel();
            }
        }
    }

    /* compiled from: FlowableWindow.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends AtomicInteger implements h.c.m<T>, k.a.d, Runnable {
        final k.a.c<? super h.c.h<T>> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.f.c<h.c.s0.c<T>> f14945b;

        /* renamed from: c  reason: collision with root package name */
        final long f14946c;

        /* renamed from: d  reason: collision with root package name */
        final long f14947d;

        /* renamed from: e  reason: collision with root package name */
        final ArrayDeque<h.c.s0.c<T>> f14948e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicBoolean f14949f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicBoolean f14950g;

        /* renamed from: h  reason: collision with root package name */
        final AtomicLong f14951h;

        /* renamed from: j  reason: collision with root package name */
        final AtomicInteger f14952j;

        /* renamed from: k  reason: collision with root package name */
        final int f14953k;

        /* renamed from: l  reason: collision with root package name */
        long f14954l;
        long m;
        k.a.d n;
        volatile boolean p;
        Throwable q;
        volatile boolean t;

        b(k.a.c<? super h.c.h<T>> cVar, long j2, long j3, int i2) {
            super(1);
            this.a = cVar;
            this.f14946c = j2;
            this.f14947d = j3;
            this.f14945b = new h.c.n0.f.c<>(i2);
            this.f14948e = new ArrayDeque<>();
            this.f14949f = new AtomicBoolean();
            this.f14950g = new AtomicBoolean();
            this.f14951h = new AtomicLong();
            this.f14952j = new AtomicInteger();
            this.f14953k = i2;
        }

        boolean a(boolean z, boolean z2, k.a.c<?> cVar, h.c.n0.f.c<?> cVar2) {
            if (this.t) {
                cVar2.clear();
                return true;
            } else if (z) {
                Throwable th = this.q;
                if (th != null) {
                    cVar2.clear();
                    cVar.onError(th);
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

        /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
            if (r10 != 0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
            if (a(r14.p, r1.isEmpty(), r0, r1) == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
            if (r8 == 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
            if (r4 == Long.MAX_VALUE) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
            r14.f14951h.addAndGet(-r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
            r3 = r14.f14952j.addAndGet(-r3);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void b() {
            /*
                r14 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r14.f14952j
                int r0 = r0.getAndIncrement()
                if (r0 == 0) goto L9
                return
            L9:
                k.a.c<? super h.c.h<T>> r0 = r14.a
                h.c.n0.f.c<h.c.s0.c<T>> r1 = r14.f14945b
                r2 = 1
                r3 = r2
            Lf:
                java.util.concurrent.atomic.AtomicLong r4 = r14.f14951h
                long r4 = r4.get()
                r6 = 0
                r8 = r6
            L18:
                int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r10 == 0) goto L3a
                boolean r11 = r14.p
                java.lang.Object r12 = r1.poll()
                h.c.s0.c r12 = (h.c.s0.c) r12
                if (r12 != 0) goto L28
                r13 = r2
                goto L29
            L28:
                r13 = 0
            L29:
                boolean r11 = r14.a(r11, r13, r0, r1)
                if (r11 == 0) goto L30
                return
            L30:
                if (r13 == 0) goto L33
                goto L3a
            L33:
                r0.onNext(r12)
                r10 = 1
                long r8 = r8 + r10
                goto L18
            L3a:
                if (r10 != 0) goto L49
                boolean r10 = r14.p
                boolean r11 = r1.isEmpty()
                boolean r10 = r14.a(r10, r11, r0, r1)
                if (r10 == 0) goto L49
                return
            L49:
                int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r6 == 0) goto L5c
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 == 0) goto L5c
                java.util.concurrent.atomic.AtomicLong r4 = r14.f14951h
                long r5 = -r8
                r4.addAndGet(r5)
            L5c:
                java.util.concurrent.atomic.AtomicInteger r4 = r14.f14952j
                int r3 = -r3
                int r3 = r4.addAndGet(r3)
                if (r3 != 0) goto Lf
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.b.r4.b.b():void");
        }

        @Override // k.a.d
        public void cancel() {
            this.t = true;
            if (this.f14949f.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.p) {
                return;
            }
            Iterator<h.c.s0.c<T>> it = this.f14948e.iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.f14948e.clear();
            this.p = true;
            b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.p) {
                h.c.r0.a.u(th);
                return;
            }
            Iterator<h.c.s0.c<T>> it = this.f14948e.iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.f14948e.clear();
            this.q = th;
            this.p = true;
            b();
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.p) {
                return;
            }
            long j2 = this.f14954l;
            if (j2 == 0 && !this.t) {
                getAndIncrement();
                h.c.s0.c<T> f2 = h.c.s0.c.f(this.f14953k, this);
                this.f14948e.offer(f2);
                this.f14945b.offer(f2);
                b();
            }
            long j3 = j2 + 1;
            Iterator<h.c.s0.c<T>> it = this.f14948e.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            long j4 = this.m + 1;
            if (j4 == this.f14946c) {
                this.m = j4 - this.f14947d;
                h.c.s0.c<T> poll = this.f14948e.poll();
                if (poll != null) {
                    poll.onComplete();
                }
            } else {
                this.m = j4;
            }
            if (j3 == this.f14947d) {
                this.f14954l = 0L;
            } else {
                this.f14954l = j3;
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.n, dVar)) {
                this.n = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f14951h, j2);
                if (!this.f14950g.get() && this.f14950g.compareAndSet(false, true)) {
                    this.n.request(h.c.n0.j.d.c(this.f14946c, h.c.n0.j.d.d(this.f14947d, j2 - 1)));
                } else {
                    this.n.request(h.c.n0.j.d.d(this.f14947d, j2));
                }
                b();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.n.cancel();
            }
        }
    }

    /* compiled from: FlowableWindow.java */
    /* loaded from: classes3.dex */
    static final class c<T> extends AtomicInteger implements h.c.m<T>, k.a.d, Runnable {
        final k.a.c<? super h.c.h<T>> a;

        /* renamed from: b  reason: collision with root package name */
        final long f14955b;

        /* renamed from: c  reason: collision with root package name */
        final long f14956c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicBoolean f14957d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicBoolean f14958e;

        /* renamed from: f  reason: collision with root package name */
        final int f14959f;

        /* renamed from: g  reason: collision with root package name */
        long f14960g;

        /* renamed from: h  reason: collision with root package name */
        k.a.d f14961h;

        /* renamed from: j  reason: collision with root package name */
        h.c.s0.c<T> f14962j;

        c(k.a.c<? super h.c.h<T>> cVar, long j2, long j3, int i2) {
            super(1);
            this.a = cVar;
            this.f14955b = j2;
            this.f14956c = j3;
            this.f14957d = new AtomicBoolean();
            this.f14958e = new AtomicBoolean();
            this.f14959f = i2;
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f14957d.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // k.a.c
        public void onComplete() {
            h.c.s0.c<T> cVar = this.f14962j;
            if (cVar != null) {
                this.f14962j = null;
                cVar.onComplete();
            }
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            h.c.s0.c<T> cVar = this.f14962j;
            if (cVar != null) {
                this.f14962j = null;
                cVar.onError(th);
            }
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            long j2 = this.f14960g;
            h.c.s0.c<T> cVar = this.f14962j;
            if (j2 == 0) {
                getAndIncrement();
                cVar = h.c.s0.c.f(this.f14959f, this);
                this.f14962j = cVar;
                this.a.onNext(cVar);
            }
            long j3 = j2 + 1;
            if (cVar != null) {
                cVar.onNext(t);
            }
            if (j3 == this.f14955b) {
                this.f14962j = null;
                cVar.onComplete();
            }
            if (j3 == this.f14956c) {
                this.f14960g = 0L;
            } else {
                this.f14960g = j3;
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14961h, dVar)) {
                this.f14961h = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                if (!this.f14958e.get() && this.f14958e.compareAndSet(false, true)) {
                    this.f14961h.request(h.c.n0.j.d.c(h.c.n0.j.d.d(this.f14955b, j2), h.c.n0.j.d.d(this.f14956c - this.f14955b, j2 - 1)));
                    return;
                }
                this.f14961h.request(h.c.n0.j.d.d(this.f14956c, j2));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.f14961h.cancel();
            }
        }
    }

    public r4(h.c.h<T> hVar, long j2, long j3, int i2) {
        super(hVar);
        this.f14936b = j2;
        this.f14937c = j3;
        this.f14938d = i2;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super h.c.h<T>> cVar) {
        long j2 = this.f14937c;
        long j3 = this.f14936b;
        if (j2 == j3) {
            this.a.subscribe((h.c.m) new a(cVar, this.f14936b, this.f14938d));
        } else if (j2 > j3) {
            this.a.subscribe((h.c.m) new c(cVar, this.f14936b, this.f14937c, this.f14938d));
        } else {
            this.a.subscribe((h.c.m) new b(cVar, this.f14936b, this.f14937c, this.f14938d));
        }
    }
}