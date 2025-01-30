package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowablePublishMulticast.java */
/* loaded from: classes3.dex */
public final class r2<T, R> extends h.c.n0.e.b.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super h.c.h<T>, ? extends k.a.b<? extends R>> f14916b;

    /* renamed from: c  reason: collision with root package name */
    final int f14917c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f14918d;

    /* compiled from: FlowablePublishMulticast.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.h<T> implements h.c.m<T>, h.c.k0.b {
        static final b[] a = new b[0];

        /* renamed from: b  reason: collision with root package name */
        static final b[] f14919b = new b[0];

        /* renamed from: e  reason: collision with root package name */
        final int f14922e;

        /* renamed from: f  reason: collision with root package name */
        final int f14923f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f14924g;

        /* renamed from: j  reason: collision with root package name */
        volatile h.c.n0.c.j<T> f14926j;

        /* renamed from: k  reason: collision with root package name */
        int f14927k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f14928l;
        Throwable m;
        int n;

        /* renamed from: c  reason: collision with root package name */
        final AtomicInteger f14920c = new AtomicInteger();

        /* renamed from: h  reason: collision with root package name */
        final AtomicReference<k.a.d> f14925h = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<b<T>[]> f14921d = new AtomicReference<>(a);

        a(int i2, boolean z) {
            this.f14922e = i2;
            this.f14923f = i2 - (i2 >> 2);
            this.f14924g = z;
        }

        boolean b(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f14921d.get();
                if (bVarArr == f14919b) {
                    return false;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!this.f14921d.compareAndSet(bVarArr, bVarArr2));
            return true;
        }

        void c() {
            b<T>[] andSet;
            for (b<T> bVar : this.f14921d.getAndSet(f14919b)) {
                if (bVar.get() != Long.MIN_VALUE) {
                    bVar.a.onComplete();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:131:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x00e8, code lost:
            r8 = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x00f8, code lost:
            if (r7 != 0) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x00fe, code lost:
            if (isDisposed() == false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0100, code lost:
            r0.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0103, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0104, code lost:
            r5 = r24.f14928l;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0106, code lost:
            if (r5 == false) goto L98;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x010a, code lost:
            if (r24.f14924g != false) goto L98;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x010c, code lost:
            r6 = r24.m;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x010e, code lost:
            if (r6 == null) goto L98;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x0110, code lost:
            e(r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0113, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0114, code lost:
            if (r5 == false) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x011a, code lost:
            if (r0.isEmpty() == false) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x011c, code lost:
            r0 = r24.m;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x011e, code lost:
            if (r0 == null) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0120, code lost:
            e(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x0124, code lost:
            c();
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0127, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void d() {
            /*
                Method dump skipped, instructions count: 326
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.b.r2.a.d():void");
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.c.j<T> jVar;
            h.c.n0.i.g.h(this.f14925h);
            if (this.f14920c.getAndIncrement() != 0 || (jVar = this.f14926j) == null) {
                return;
            }
            jVar.clear();
        }

        void e(Throwable th) {
            b<T>[] andSet;
            for (b<T> bVar : this.f14921d.getAndSet(f14919b)) {
                if (bVar.get() != Long.MIN_VALUE) {
                    bVar.a.onError(th);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void f(b<T> bVar) {
            b<T>[] bVarArr;
            b[] bVarArr2;
            do {
                bVarArr = this.f14921d.get();
                int length = bVarArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (bVarArr[i3] == bVar) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    bVarArr2 = a;
                } else {
                    b[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i2);
                    System.arraycopy(bVarArr, i2 + 1, bVarArr3, i2, (length - i2) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!this.f14921d.compareAndSet(bVarArr, bVarArr2));
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14925h.get() == h.c.n0.i.g.CANCELLED;
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14928l) {
                return;
            }
            this.f14928l = true;
            d();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14928l) {
                h.c.r0.a.u(th);
                return;
            }
            this.m = th;
            this.f14928l = true;
            d();
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14928l) {
                return;
            }
            if (this.f14927k == 0 && !this.f14926j.offer(t)) {
                this.f14925h.get().cancel();
                onError(new MissingBackpressureException());
                return;
            }
            d();
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.z(this.f14925h, dVar)) {
                if (dVar instanceof h.c.n0.c.g) {
                    h.c.n0.c.g gVar = (h.c.n0.c.g) dVar;
                    int n = gVar.n(3);
                    if (n == 1) {
                        this.f14927k = n;
                        this.f14926j = gVar;
                        this.f14928l = true;
                        d();
                        return;
                    } else if (n == 2) {
                        this.f14927k = n;
                        this.f14926j = gVar;
                        h.c.n0.j.r.j(dVar, this.f14922e);
                        return;
                    }
                }
                this.f14926j = h.c.n0.j.r.c(this.f14922e);
                h.c.n0.j.r.j(dVar, this.f14922e);
            }
        }

        @Override // h.c.h
        protected void subscribeActual(k.a.c<? super T> cVar) {
            b<T> bVar = new b<>(cVar, this);
            cVar.onSubscribe(bVar);
            if (b(bVar)) {
                if (bVar.a()) {
                    f(bVar);
                    return;
                } else {
                    d();
                    return;
                }
            }
            Throwable th = this.m;
            if (th != null) {
                cVar.onError(th);
            } else {
                cVar.onComplete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowablePublishMulticast.java */
    /* loaded from: classes3.dex */
    public static final class b<T> extends AtomicLong implements k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final a<T> f14929b;

        /* renamed from: c  reason: collision with root package name */
        long f14930c;

        b(k.a.c<? super T> cVar, a<T> aVar) {
            this.a = cVar;
            this.f14929b = aVar;
        }

        public boolean a() {
            return get() == Long.MIN_VALUE;
        }

        @Override // k.a.d
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f14929b.f(this);
                this.f14929b.d();
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.b(this, j2);
                this.f14929b.d();
            }
        }
    }

    /* compiled from: FlowablePublishMulticast.java */
    /* loaded from: classes3.dex */
    static final class c<R> implements h.c.m<R>, k.a.d {
        final k.a.c<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final a<?> f14931b;

        /* renamed from: c  reason: collision with root package name */
        k.a.d f14932c;

        c(k.a.c<? super R> cVar, a<?> aVar) {
            this.a = cVar;
            this.f14931b = aVar;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14932c.cancel();
            this.f14931b.dispose();
        }

        @Override // k.a.c
        public void onComplete() {
            this.a.onComplete();
            this.f14931b.dispose();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
            this.f14931b.dispose();
        }

        @Override // k.a.c
        public void onNext(R r) {
            this.a.onNext(r);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14932c, dVar)) {
                this.f14932c = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            this.f14932c.request(j2);
        }
    }

    public r2(h.c.h<T> hVar, h.c.m0.n<? super h.c.h<T>, ? extends k.a.b<? extends R>> nVar, int i2, boolean z) {
        super(hVar);
        this.f14916b = nVar;
        this.f14917c = i2;
        this.f14918d = z;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        a aVar = new a(this.f14917c, this.f14918d);
        try {
            ((k.a.b) h.c.n0.b.b.e(this.f14916b.apply(aVar), "selector returned a null Publisher")).subscribe(new c(cVar, aVar));
            this.a.subscribe((h.c.m) aVar);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.i.d.q(th, cVar);
        }
    }
}