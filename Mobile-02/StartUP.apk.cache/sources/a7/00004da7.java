package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableConcatMapEager.java */
/* loaded from: classes3.dex */
public final class w<T, R> extends h.c.n0.e.b.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends k.a.b<? extends R>> f15164b;

    /* renamed from: c  reason: collision with root package name */
    final int f15165c;

    /* renamed from: d  reason: collision with root package name */
    final int f15166d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.n0.j.i f15167e;

    /* compiled from: FlowableConcatMapEager.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements h.c.m<T>, k.a.d, h.c.n0.h.k<R> {
        final k.a.c<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends k.a.b<? extends R>> f15168b;

        /* renamed from: c  reason: collision with root package name */
        final int f15169c;

        /* renamed from: d  reason: collision with root package name */
        final int f15170d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.j.i f15171e;

        /* renamed from: f  reason: collision with root package name */
        final h.c.n0.j.c f15172f = new h.c.n0.j.c();

        /* renamed from: g  reason: collision with root package name */
        final AtomicLong f15173g = new AtomicLong();

        /* renamed from: h  reason: collision with root package name */
        final h.c.n0.f.c<h.c.n0.h.j<R>> f15174h;

        /* renamed from: j  reason: collision with root package name */
        k.a.d f15175j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f15176k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f15177l;
        volatile h.c.n0.h.j<R> m;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(k.a.c<? super R> cVar, h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2, int i3, h.c.n0.j.i iVar) {
            this.a = cVar;
            this.f15168b = nVar;
            this.f15169c = i2;
            this.f15170d = i3;
            this.f15171e = iVar;
            this.f15174h = new h.c.n0.f.c<>(Math.min(i3, i2));
        }

        @Override // h.c.n0.h.k
        public void a(h.c.n0.h.j<R> jVar) {
            jVar.d();
            b();
        }

        /* JADX WARN: Code restructure failed: missing block: B:56:0x00cb, code lost:
            r0 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00cc, code lost:
            if (r15 != 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00d0, code lost:
            if (r17.f15176k == false) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00d2, code lost:
            e();
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00d5, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00d8, code lost:
            if (r3 != h.c.n0.j.i.IMMEDIATE) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00e2, code lost:
            if (r17.f15172f.get() == null) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00e4, code lost:
            r17.m = null;
            r8.cancel();
            e();
            r2.onError(r17.f15172f.b());
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00f5, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00f6, code lost:
            r9 = r8.a();
            r10 = r12.isEmpty();
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00fe, code lost:
            if (r9 == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0100, code lost:
            if (r10 == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0102, code lost:
            r17.m = null;
            r17.f15175j.request(1);
            r8 = null;
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x010b, code lost:
            r4 = 0;
         */
        @Override // h.c.n0.h.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void b() {
            /*
                Method dump skipped, instructions count: 316
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.b.w.a.b():void");
        }

        @Override // h.c.n0.h.k
        public void c(h.c.n0.h.j<R> jVar, R r) {
            if (jVar.b().offer(r)) {
                b();
                return;
            }
            jVar.cancel();
            d(jVar, new MissingBackpressureException());
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f15176k) {
                return;
            }
            this.f15176k = true;
            this.f15175j.cancel();
            f();
        }

        @Override // h.c.n0.h.k
        public void d(h.c.n0.h.j<R> jVar, Throwable th) {
            if (this.f15172f.a(th)) {
                jVar.d();
                if (this.f15171e != h.c.n0.j.i.END) {
                    this.f15175j.cancel();
                }
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        void e() {
            h.c.n0.h.j<R> jVar = this.m;
            this.m = null;
            if (jVar != null) {
                jVar.cancel();
            }
            while (true) {
                h.c.n0.h.j<R> poll = this.f15174h.poll();
                if (poll == null) {
                    return;
                }
                poll.cancel();
            }
        }

        void f() {
            if (getAndIncrement() == 0) {
                do {
                    e();
                } while (decrementAndGet() != 0);
            }
        }

        @Override // k.a.c
        public void onComplete() {
            this.f15177l = true;
            b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15172f.a(th)) {
                this.f15177l = true;
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            try {
                k.a.b bVar = (k.a.b) h.c.n0.b.b.e(this.f15168b.apply(t), "The mapper returned a null Publisher");
                h.c.n0.h.j<R> jVar = new h.c.n0.h.j<>(this, this.f15170d);
                if (this.f15176k) {
                    return;
                }
                this.f15174h.offer(jVar);
                bVar.subscribe(jVar);
                if (this.f15176k) {
                    jVar.cancel();
                    f();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15175j.cancel();
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15175j, dVar)) {
                this.f15175j = dVar;
                this.a.onSubscribe(this);
                int i2 = this.f15169c;
                dVar.request(i2 == Integer.MAX_VALUE ? Long.MAX_VALUE : i2);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f15173g, j2);
                b();
            }
        }
    }

    public w(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2, int i3, h.c.n0.j.i iVar) {
        super(hVar);
        this.f15164b = nVar;
        this.f15165c = i2;
        this.f15166d = i3;
        this.f15167e = iVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f15164b, this.f15165c, this.f15166d, this.f15167e));
    }
}