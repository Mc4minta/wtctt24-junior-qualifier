package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableMergeWithSingle.java */
/* loaded from: classes3.dex */
public final class g2<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.h0<? extends T> f14429b;

    /* compiled from: FlowableMergeWithSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<k.a.d> f14430b = new AtomicReference<>();

        /* renamed from: c  reason: collision with root package name */
        final C0352a<T> f14431c = new C0352a<>(this);

        /* renamed from: d  reason: collision with root package name */
        final h.c.n0.j.c f14432d = new h.c.n0.j.c();

        /* renamed from: e  reason: collision with root package name */
        final AtomicLong f14433e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        final int f14434f;

        /* renamed from: g  reason: collision with root package name */
        final int f14435g;

        /* renamed from: h  reason: collision with root package name */
        volatile h.c.n0.c.i<T> f14436h;

        /* renamed from: j  reason: collision with root package name */
        T f14437j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f14438k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f14439l;
        volatile int m;
        long n;
        int p;

        /* compiled from: FlowableMergeWithSingle.java */
        /* renamed from: h.c.n0.e.b.g2$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0352a<T> extends AtomicReference<h.c.k0.b> implements h.c.e0<T> {
            final a<T> a;

            C0352a(a<T> aVar) {
                this.a = aVar;
            }

            @Override // h.c.e0
            public void onError(Throwable th) {
                this.a.d(th);
            }

            @Override // h.c.e0
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.z(this, bVar);
            }

            @Override // h.c.e0
            public void onSuccess(T t) {
                this.a.e(t);
            }
        }

        a(k.a.c<? super T> cVar) {
            this.a = cVar;
            int bufferSize = h.c.h.bufferSize();
            this.f14434f = bufferSize;
            this.f14435g = bufferSize - (bufferSize >> 2);
        }

        void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0081, code lost:
            if (r10 != 0) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0085, code lost:
            if (r18.f14438k == false) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:
            r18.f14437j = null;
            r18.f14436h = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x008b, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0092, code lost:
            if (r18.f14432d.get() == null) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0094, code lost:
            r18.f14437j = null;
            r18.f14436h = null;
            r1.onError(r18.f14432d.b());
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00a1, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00a2, code lost:
            r6 = r18.f14439l;
            r8 = r18.f14436h;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00a6, code lost:
            if (r8 == null) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00ac, code lost:
            if (r8.isEmpty() == false) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00af, code lost:
            r11 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00b1, code lost:
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00b2, code lost:
            if (r6 == false) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00b4, code lost:
            if (r11 == false) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00b8, code lost:
            if (r18.m != 2) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00ba, code lost:
            r18.f14436h = null;
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00bf, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00c0, code lost:
            r18.n = r2;
            r18.p = r4;
            r7 = addAndGet(-r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00c9, code lost:
            if (r7 != 0) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00cb, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void b() {
            /*
                Method dump skipped, instructions count: 207
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.b.g2.a.b():void");
        }

        h.c.n0.c.i<T> c() {
            h.c.n0.c.i<T> iVar = this.f14436h;
            if (iVar == null) {
                h.c.n0.f.b bVar = new h.c.n0.f.b(h.c.h.bufferSize());
                this.f14436h = bVar;
                return bVar;
            }
            return iVar;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14438k = true;
            h.c.n0.i.g.h(this.f14430b);
            h.c.n0.a.c.h(this.f14431c);
            if (getAndIncrement() == 0) {
                this.f14436h = null;
                this.f14437j = null;
            }
        }

        void d(Throwable th) {
            if (this.f14432d.a(th)) {
                h.c.n0.i.g.h(this.f14430b);
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        void e(T t) {
            if (compareAndSet(0, 1)) {
                long j2 = this.n;
                if (this.f14433e.get() != j2) {
                    this.n = j2 + 1;
                    this.a.onNext(t);
                    this.m = 2;
                } else {
                    this.f14437j = t;
                    this.m = 1;
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            } else {
                this.f14437j = t;
                this.m = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14439l = true;
            a();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14432d.a(th)) {
                h.c.n0.i.g.h(this.f14430b);
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                long j2 = this.n;
                if (this.f14433e.get() != j2) {
                    h.c.n0.c.i<T> iVar = this.f14436h;
                    if (iVar != null && !iVar.isEmpty()) {
                        iVar.offer(t);
                    } else {
                        this.n = j2 + 1;
                        this.a.onNext(t);
                        int i2 = this.p + 1;
                        if (i2 == this.f14435g) {
                            this.p = 0;
                            this.f14430b.get().request(i2);
                        } else {
                            this.p = i2;
                        }
                    }
                } else {
                    c().offer(t);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                c().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.A(this.f14430b, dVar, this.f14434f);
        }

        @Override // k.a.d
        public void request(long j2) {
            h.c.n0.j.d.a(this.f14433e, j2);
            a();
        }
    }

    public g2(h.c.h<T> hVar, h.c.h0<? extends T> h0Var) {
        super(hVar);
        this.f14429b = h0Var;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        a aVar = new a(cVar);
        cVar.onSubscribe(aVar);
        this.a.subscribe((h.c.m) aVar);
        this.f14429b.subscribe(aVar.f14431c);
    }
}