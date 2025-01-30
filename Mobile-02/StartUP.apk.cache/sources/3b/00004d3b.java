package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowablePublish.java */
/* loaded from: classes3.dex */
public final class q2<T> extends h.c.l0.a<T> {
    final h.c.h<T> a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<c<T>> f14864b;

    /* renamed from: c  reason: collision with root package name */
    final int f14865c;

    /* renamed from: d  reason: collision with root package name */
    final k.a.b<T> f14866d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowablePublish.java */
    /* loaded from: classes3.dex */
    public static final class a<T> implements k.a.b<T> {
        private final AtomicReference<c<T>> a;

        /* renamed from: b  reason: collision with root package name */
        private final int f14867b;

        a(AtomicReference<c<T>> atomicReference, int i2) {
            this.a = atomicReference;
            this.f14867b = i2;
        }

        @Override // k.a.b
        public void subscribe(k.a.c<? super T> cVar) {
            c<T> cVar2;
            b<T> bVar = new b<>(cVar);
            cVar.onSubscribe(bVar);
            while (true) {
                cVar2 = this.a.get();
                if (cVar2 == null || cVar2.isDisposed()) {
                    c<T> cVar3 = new c<>(this.a, this.f14867b);
                    if (this.a.compareAndSet(cVar2, cVar3)) {
                        cVar2 = cVar3;
                    } else {
                        continue;
                    }
                }
                if (cVar2.a(bVar)) {
                    break;
                }
            }
            if (bVar.get() == Long.MIN_VALUE) {
                cVar2.d(bVar);
            } else {
                bVar.f14868b = cVar2;
            }
            cVar2.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowablePublish.java */
    /* loaded from: classes3.dex */
    public static final class b<T> extends AtomicLong implements k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        volatile c<T> f14868b;

        /* renamed from: c  reason: collision with root package name */
        long f14869c;

        b(k.a.c<? super T> cVar) {
            this.a = cVar;
        }

        @Override // k.a.d
        public void cancel() {
            c<T> cVar;
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE || (cVar = this.f14868b) == null) {
                return;
            }
            cVar.d(this);
            cVar.c();
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.b(this, j2);
                c<T> cVar = this.f14868b;
                if (cVar != null) {
                    cVar.c();
                }
            }
        }
    }

    /* compiled from: FlowablePublish.java */
    /* loaded from: classes3.dex */
    static final class c<T> extends AtomicInteger implements h.c.m<T>, h.c.k0.b {
        static final b[] a = new b[0];

        /* renamed from: b  reason: collision with root package name */
        static final b[] f14870b = new b[0];

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<c<T>> f14871c;

        /* renamed from: d  reason: collision with root package name */
        final int f14872d;

        /* renamed from: h  reason: collision with root package name */
        volatile Object f14876h;

        /* renamed from: j  reason: collision with root package name */
        int f14877j;

        /* renamed from: k  reason: collision with root package name */
        volatile h.c.n0.c.j<T> f14878k;

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<k.a.d> f14875g = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<b<T>[]> f14873e = new AtomicReference<>(a);

        /* renamed from: f  reason: collision with root package name */
        final AtomicBoolean f14874f = new AtomicBoolean();

        c(AtomicReference<c<T>> atomicReference, int i2) {
            this.f14871c = atomicReference;
            this.f14872d = i2;
        }

        boolean a(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f14873e.get();
                if (bVarArr == f14870b) {
                    return false;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!this.f14873e.compareAndSet(bVarArr, bVarArr2));
            return true;
        }

        boolean b(Object obj, boolean z) {
            int i2 = 0;
            if (obj != null) {
                if (!h.c.n0.j.m.D(obj)) {
                    Throwable B = h.c.n0.j.m.B(obj);
                    this.f14871c.compareAndSet(this, null);
                    b<T>[] andSet = this.f14873e.getAndSet(f14870b);
                    if (andSet.length != 0) {
                        int length = andSet.length;
                        while (i2 < length) {
                            andSet[i2].a.onError(B);
                            i2++;
                        }
                    } else {
                        h.c.r0.a.u(B);
                    }
                    return true;
                } else if (z) {
                    this.f14871c.compareAndSet(this, null);
                    b<T>[] andSet2 = this.f14873e.getAndSet(f14870b);
                    int length2 = andSet2.length;
                    while (i2 < length2) {
                        andSet2[i2].a.onComplete();
                        i2++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:111:0x0014, code lost:
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0124, code lost:
            if (r11 == 0) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0129, code lost:
            if (r25.f14877j == 1) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x012b, code lost:
            r25.f14875g.get().request(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0137, code lost:
            r4 = r0;
            r3 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x013b, code lost:
            if (r11 == 0) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x013d, code lost:
            r3 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x0140, code lost:
            if (r25.f14877j == 1) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0142, code lost:
            r25.f14875g.get().request(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x014e, code lost:
            r3 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0153, code lost:
            if (r14 == 0) goto L83;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x0155, code lost:
            if (r8 != false) goto L75;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void c() {
            /*
                Method dump skipped, instructions count: 362
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.b.q2.c.c():void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        void d(b<T> bVar) {
            b<T>[] bVarArr;
            b[] bVarArr2;
            do {
                bVarArr = this.f14873e.get();
                int length = bVarArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (bVarArr[i3].equals(bVar)) {
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
            } while (!this.f14873e.compareAndSet(bVarArr, bVarArr2));
        }

        @Override // h.c.k0.b
        public void dispose() {
            b<T>[] bVarArr = this.f14873e.get();
            b<T>[] bVarArr2 = f14870b;
            if (bVarArr == bVarArr2 || this.f14873e.getAndSet(bVarArr2) == bVarArr2) {
                return;
            }
            this.f14871c.compareAndSet(this, null);
            h.c.n0.i.g.h(this.f14875g);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14873e.get() == f14870b;
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14876h == null) {
                this.f14876h = h.c.n0.j.m.y();
                c();
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14876h == null) {
                this.f14876h = h.c.n0.j.m.A(th);
                c();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14877j == 0 && !this.f14878k.offer(t)) {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            } else {
                c();
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.z(this.f14875g, dVar)) {
                if (dVar instanceof h.c.n0.c.g) {
                    h.c.n0.c.g gVar = (h.c.n0.c.g) dVar;
                    int n = gVar.n(7);
                    if (n == 1) {
                        this.f14877j = n;
                        this.f14878k = gVar;
                        this.f14876h = h.c.n0.j.m.y();
                        c();
                        return;
                    } else if (n == 2) {
                        this.f14877j = n;
                        this.f14878k = gVar;
                        dVar.request(this.f14872d);
                        return;
                    }
                }
                this.f14878k = new h.c.n0.f.b(this.f14872d);
                dVar.request(this.f14872d);
            }
        }
    }

    private q2(k.a.b<T> bVar, h.c.h<T> hVar, AtomicReference<c<T>> atomicReference, int i2) {
        this.f14866d = bVar;
        this.a = hVar;
        this.f14864b = atomicReference;
        this.f14865c = i2;
    }

    public static <T> h.c.l0.a<T> d(h.c.h<T> hVar, int i2) {
        AtomicReference atomicReference = new AtomicReference();
        return h.c.r0.a.p(new q2(new a(atomicReference, i2), hVar, atomicReference, i2));
    }

    @Override // h.c.l0.a
    public void b(h.c.m0.f<? super h.c.k0.b> fVar) {
        c<T> cVar;
        while (true) {
            cVar = this.f14864b.get();
            if (cVar != null && !cVar.isDisposed()) {
                break;
            }
            c<T> cVar2 = new c<>(this.f14864b, this.f14865c);
            if (this.f14864b.compareAndSet(cVar, cVar2)) {
                cVar = cVar2;
                break;
            }
        }
        boolean z = true;
        if (cVar.f14874f.get() || !cVar.f14874f.compareAndSet(false, true)) {
            z = false;
        }
        try {
            fVar.accept(cVar);
            if (z) {
                this.a.subscribe((h.c.m) cVar);
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            throw h.c.n0.j.j.e(th);
        }
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.f14866d.subscribe(cVar);
    }
}