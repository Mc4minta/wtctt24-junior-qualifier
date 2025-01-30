package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableOnBackpressureBufferStrategy.java */
/* loaded from: classes3.dex */
public final class k2<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f14566b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.a f14567c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.a f14568d;

    /* compiled from: FlowableOnBackpressureBufferStrategy.java */
    /* loaded from: classes3.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[h.c.a.values().length];
            a = iArr;
            try {
                iArr[h.c.a.DROP_LATEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.c.a.DROP_OLDEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: FlowableOnBackpressureBufferStrategy.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends AtomicInteger implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.a f14569b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.a f14570c;

        /* renamed from: d  reason: collision with root package name */
        final long f14571d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicLong f14572e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        final Deque<T> f14573f = new ArrayDeque();

        /* renamed from: g  reason: collision with root package name */
        k.a.d f14574g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f14575h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f14576j;

        /* renamed from: k  reason: collision with root package name */
        Throwable f14577k;

        b(k.a.c<? super T> cVar, h.c.m0.a aVar, h.c.a aVar2, long j2) {
            this.a = cVar;
            this.f14569b = aVar;
            this.f14570c = aVar2;
            this.f14571d = j2;
        }

        void a(Deque<T> deque) {
            synchronized (deque) {
                deque.clear();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x004f, code lost:
            if (r10 != 0) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0053, code lost:
            if (r14.f14575h == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0055, code lost:
            a(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0058, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0059, code lost:
            r4 = r14.f14576j;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x005b, code lost:
            monitor-enter(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x005c, code lost:
            r5 = r0.isEmpty();
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0060, code lost:
            monitor-exit(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0061, code lost:
            if (r4 == false) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0063, code lost:
            r4 = r14.f14577k;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0065, code lost:
            if (r4 == null) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0067, code lost:
            a(r0);
            r1.onError(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x006d, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x006e, code lost:
            if (r5 == false) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0070, code lost:
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0073, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0079, code lost:
            if (r8 == 0) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x007b, code lost:
            h.c.n0.j.d.e(r14.f14572e, r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0080, code lost:
            r3 = addAndGet(-r3);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void b() {
            /*
                r14 = this;
                int r0 = r14.getAndIncrement()
                if (r0 == 0) goto L7
                return
            L7:
                java.util.Deque<T> r0 = r14.f14573f
                k.a.c<? super T> r1 = r14.a
                r2 = 1
                r3 = r2
            Ld:
                java.util.concurrent.atomic.AtomicLong r4 = r14.f14572e
                long r4 = r4.get()
                r6 = 0
                r8 = r6
            L16:
                int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r10 == 0) goto L4f
                boolean r11 = r14.f14575h
                if (r11 == 0) goto L22
                r14.a(r0)
                return
            L22:
                boolean r11 = r14.f14576j
                monitor-enter(r0)
                java.lang.Object r12 = r0.poll()     // Catch: java.lang.Throwable -> L4c
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L4c
                if (r12 != 0) goto L2e
                r13 = r2
                goto L2f
            L2e:
                r13 = 0
            L2f:
                if (r11 == 0) goto L42
                java.lang.Throwable r11 = r14.f14577k
                if (r11 == 0) goto L3c
                r14.a(r0)
                r1.onError(r11)
                return
            L3c:
                if (r13 == 0) goto L42
                r1.onComplete()
                return
            L42:
                if (r13 == 0) goto L45
                goto L4f
            L45:
                r1.onNext(r12)
                r10 = 1
                long r8 = r8 + r10
                goto L16
            L4c:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L4c
                throw r1
            L4f:
                if (r10 != 0) goto L77
                boolean r4 = r14.f14575h
                if (r4 == 0) goto L59
                r14.a(r0)
                return
            L59:
                boolean r4 = r14.f14576j
                monitor-enter(r0)
                boolean r5 = r0.isEmpty()     // Catch: java.lang.Throwable -> L74
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L74
                if (r4 == 0) goto L77
                java.lang.Throwable r4 = r14.f14577k
                if (r4 == 0) goto L6e
                r14.a(r0)
                r1.onError(r4)
                return
            L6e:
                if (r5 == 0) goto L77
                r1.onComplete()
                return
            L74:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L74
                throw r1
            L77:
                int r4 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r4 == 0) goto L80
                java.util.concurrent.atomic.AtomicLong r4 = r14.f14572e
                h.c.n0.j.d.e(r4, r8)
            L80:
                int r3 = -r3
                int r3 = r14.addAndGet(r3)
                if (r3 != 0) goto Ld
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.b.k2.b.b():void");
        }

        @Override // k.a.d
        public void cancel() {
            this.f14575h = true;
            this.f14574g.cancel();
            if (getAndIncrement() == 0) {
                a(this.f14573f);
            }
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14576j = true;
            b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14576j) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14577k = th;
            this.f14576j = true;
            b();
        }

        @Override // k.a.c
        public void onNext(T t) {
            boolean z;
            boolean z2;
            if (this.f14576j) {
                return;
            }
            Deque<T> deque = this.f14573f;
            synchronized (deque) {
                z = false;
                z2 = true;
                if (deque.size() == this.f14571d) {
                    int i2 = a.a[this.f14570c.ordinal()];
                    if (i2 == 1) {
                        deque.pollLast();
                        deque.offer(t);
                    } else if (i2 == 2) {
                        deque.poll();
                        deque.offer(t);
                    }
                    z2 = false;
                    z = true;
                } else {
                    deque.offer(t);
                    z2 = false;
                }
            }
            if (!z) {
                if (z2) {
                    this.f14574g.cancel();
                    onError(new MissingBackpressureException());
                    return;
                }
                b();
                return;
            }
            h.c.m0.a aVar = this.f14569b;
            if (aVar != null) {
                try {
                    aVar.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f14574g.cancel();
                    onError(th);
                }
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14574g, dVar)) {
                this.f14574g = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f14572e, j2);
                b();
            }
        }
    }

    public k2(h.c.h<T> hVar, long j2, h.c.m0.a aVar, h.c.a aVar2) {
        super(hVar);
        this.f14566b = j2;
        this.f14567c = aVar;
        this.f14568d = aVar2;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new b(cVar, this.f14567c, this.f14568d, this.f14566b));
    }
}