package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableZip.java */
/* loaded from: classes3.dex */
public final class y4<T, R> extends h.c.h<R> {
    final k.a.b<? extends T>[] a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends k.a.b<? extends T>> f15284b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.n<? super Object[], ? extends R> f15285c;

    /* renamed from: d  reason: collision with root package name */
    final int f15286d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f15287e;

    /* compiled from: FlowableZip.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements k.a.d {
        final k.a.c<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final b<T, R>[] f15288b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.n<? super Object[], ? extends R> f15289c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicLong f15290d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.j.c f15291e;

        /* renamed from: f  reason: collision with root package name */
        final boolean f15292f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f15293g;

        /* renamed from: h  reason: collision with root package name */
        final Object[] f15294h;

        a(k.a.c<? super R> cVar, h.c.m0.n<? super Object[], ? extends R> nVar, int i2, int i3, boolean z) {
            this.a = cVar;
            this.f15289c = nVar;
            this.f15292f = z;
            b<T, R>[] bVarArr = new b[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                bVarArr[i4] = new b<>(this, i3);
            }
            this.f15294h = new Object[i2];
            this.f15288b = bVarArr;
            this.f15290d = new AtomicLong();
            this.f15291e = new h.c.n0.j.c();
        }

        void a() {
            for (b<T, R> bVar : this.f15288b) {
                bVar.cancel();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:127:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00d2, code lost:
            if (r14 != 0) goto L109;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00d6, code lost:
            if (r18.f15293g == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00d8, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00db, code lost:
            if (r18.f15292f != false) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00e3, code lost:
            if (r18.f15291e.get() == null) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00e5, code lost:
            a();
            r2.onError(r18.f15291e.b());
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00f1, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00f2, code lost:
            r6 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00f4, code lost:
            if (r6 >= r4) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00f6, code lost:
            r0 = r3[r6];
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00fa, code lost:
            if (r5[r6] != null) goto L105;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00fc, code lost:
            r10 = r0.f15299f;
            r0 = r0.f15297d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0100, code lost:
            if (r0 == null) goto L97;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x0102, code lost:
            r0 = r0.poll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0107, code lost:
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0108, code lost:
            if (r0 != null) goto L96;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x010a, code lost:
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x010c, code lost:
            r11 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x010e, code lost:
            if (r10 == false) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0110, code lost:
            if (r11 == false) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x0112, code lost:
            a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x011d, code lost:
            if (r18.f15291e.get() == null) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x011f, code lost:
            r2.onError(r18.f15291e.b());
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x0129, code lost:
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x012c, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x012d, code lost:
            if (r11 != false) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x012f, code lost:
            r5[r6] = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0132, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x0133, code lost:
            io.reactivex.exceptions.a.b(r0);
            r18.f15291e.a(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x013d, code lost:
            if (r18.f15292f == false) goto L101;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x013f, code lost:
            a();
            r2.onError(r18.f15291e.b());
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x014b, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x014c, code lost:
            r6 = r6 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0153, code lost:
            if (r12 == 0) goto L118;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x0155, code lost:
            r0 = r3.length;
            r6 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0158, code lost:
            if (r6 >= r0) goto L114;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x015a, code lost:
            r3[r6].request(r12);
            r6 = r6 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0169, code lost:
            if (r8 == Long.MAX_VALUE) goto L118;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x016b, code lost:
            r18.f15290d.addAndGet(-r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0171, code lost:
            r7 = addAndGet(-r7);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void b() {
            /*
                Method dump skipped, instructions count: 377
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.b.y4.a.b():void");
        }

        void c(b<T, R> bVar, Throwable th) {
            if (this.f15291e.a(th)) {
                bVar.f15299f = true;
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f15293g) {
                return;
            }
            this.f15293g = true;
            a();
        }

        void d(k.a.b<? extends T>[] bVarArr, int i2) {
            b<T, R>[] bVarArr2 = this.f15288b;
            for (int i3 = 0; i3 < i2 && !this.f15293g; i3++) {
                if (!this.f15292f && this.f15291e.get() != null) {
                    return;
                }
                bVarArr[i3].subscribe(bVarArr2[i3]);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f15290d, j2);
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableZip.java */
    /* loaded from: classes3.dex */
    public static final class b<T, R> extends AtomicReference<k.a.d> implements h.c.m<T>, k.a.d {
        final a<T, R> a;

        /* renamed from: b  reason: collision with root package name */
        final int f15295b;

        /* renamed from: c  reason: collision with root package name */
        final int f15296c;

        /* renamed from: d  reason: collision with root package name */
        h.c.n0.c.j<T> f15297d;

        /* renamed from: e  reason: collision with root package name */
        long f15298e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f15299f;

        /* renamed from: g  reason: collision with root package name */
        int f15300g;

        b(a<T, R> aVar, int i2) {
            this.a = aVar;
            this.f15295b = i2;
            this.f15296c = i2 - (i2 >> 2);
        }

        @Override // k.a.d
        public void cancel() {
            h.c.n0.i.g.h(this);
        }

        @Override // k.a.c
        public void onComplete() {
            this.f15299f = true;
            this.a.b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.c(this, th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f15300g != 2) {
                this.f15297d.offer(t);
            }
            this.a.b();
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.z(this, dVar)) {
                if (dVar instanceof h.c.n0.c.g) {
                    h.c.n0.c.g gVar = (h.c.n0.c.g) dVar;
                    int n = gVar.n(7);
                    if (n == 1) {
                        this.f15300g = n;
                        this.f15297d = gVar;
                        this.f15299f = true;
                        this.a.b();
                        return;
                    } else if (n == 2) {
                        this.f15300g = n;
                        this.f15297d = gVar;
                        dVar.request(this.f15295b);
                        return;
                    }
                }
                this.f15297d = new h.c.n0.f.b(this.f15295b);
                dVar.request(this.f15295b);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (this.f15300g != 1) {
                long j3 = this.f15298e + j2;
                if (j3 >= this.f15296c) {
                    this.f15298e = 0L;
                    get().request(j3);
                    return;
                }
                this.f15298e = j3;
            }
        }
    }

    public y4(k.a.b<? extends T>[] bVarArr, Iterable<? extends k.a.b<? extends T>> iterable, h.c.m0.n<? super Object[], ? extends R> nVar, int i2, boolean z) {
        this.a = bVarArr;
        this.f15284b = iterable;
        this.f15285c = nVar;
        this.f15286d = i2;
        this.f15287e = z;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super R> cVar) {
        int length;
        k.a.b<? extends T>[] bVarArr = this.a;
        if (bVarArr == null) {
            bVarArr = new k.a.b[8];
            length = 0;
            for (k.a.b<? extends T> bVar : this.f15284b) {
                if (length == bVarArr.length) {
                    k.a.b<? extends T>[] bVarArr2 = new k.a.b[(length >> 2) + length];
                    System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                    bVarArr = bVarArr2;
                }
                bVarArr[length] = bVar;
                length++;
            }
        } else {
            length = bVarArr.length;
        }
        int i2 = length;
        if (i2 == 0) {
            h.c.n0.i.d.h(cVar);
            return;
        }
        a aVar = new a(cVar, this.f15285c, i2, this.f15286d, this.f15287e);
        cVar.onSubscribe(aVar);
        aVar.d(bVarArr, i2);
    }
}