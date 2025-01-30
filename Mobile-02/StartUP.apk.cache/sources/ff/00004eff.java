package h.c.n0.e.e;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableReplay.java */
/* loaded from: classes3.dex */
public final class q2<T> extends h.c.o0.a<T> implements h.c.n0.a.f {
    static final b a = new o();

    /* renamed from: b  reason: collision with root package name */
    final h.c.x<T> f16130b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<j<T>> f16131c;

    /* renamed from: d  reason: collision with root package name */
    final b<T> f16132d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.x<T> f16133e;

    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    static abstract class a<T> extends AtomicReference<f> implements h<T> {
        f a;

        /* renamed from: b  reason: collision with root package name */
        int f16134b;

        a() {
            f fVar = new f(null);
            this.a = fVar;
            set(fVar);
        }

        final void a(f fVar) {
            this.a.set(fVar);
            this.a = fVar;
            this.f16134b++;
        }

        Object b(Object obj) {
            return obj;
        }

        f c() {
            return get();
        }

        Object d(Object obj) {
            return obj;
        }

        final void e() {
            this.f16134b--;
            f(get().get());
        }

        final void f(f fVar) {
            set(fVar);
        }

        final void g() {
            f fVar = get();
            if (fVar.a != null) {
                f fVar2 = new f(null);
                fVar2.lazySet(fVar.get());
                set(fVar2);
            }
        }

        @Override // h.c.n0.e.e.q2.h
        public final void h() {
            a(new f(b(h.c.n0.j.m.y())));
            m();
        }

        @Override // h.c.n0.e.e.q2.h
        public final void i(T t) {
            a(new f(b(h.c.n0.j.m.F(t))));
            j();
        }

        abstract void j();

        @Override // h.c.n0.e.e.q2.h
        public final void k(Throwable th) {
            a(new f(b(h.c.n0.j.m.A(th))));
            m();
        }

        @Override // h.c.n0.e.e.q2.h
        public final void l(d<T> dVar) {
            if (dVar.getAndIncrement() != 0) {
                return;
            }
            int i2 = 1;
            do {
                f fVar = (f) dVar.a();
                if (fVar == null) {
                    fVar = c();
                    dVar.f16136c = fVar;
                }
                while (!dVar.isDisposed()) {
                    f fVar2 = fVar.get();
                    if (fVar2 != null) {
                        if (h.c.n0.j.m.h(d(fVar2.a), dVar.f16135b)) {
                            dVar.f16136c = null;
                            return;
                        }
                        fVar = fVar2;
                    } else {
                        dVar.f16136c = fVar;
                        i2 = dVar.addAndGet(-i2);
                    }
                }
                dVar.f16136c = null;
                return;
            } while (i2 != 0);
        }

        void m() {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    public interface b<T> {
        h<T> call();
    }

    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    static final class c<R> implements h.c.m0.f<h.c.k0.b> {
        private final m4<R> a;

        c(m4<R> m4Var) {
            this.a = m4Var;
        }

        @Override // h.c.m0.f
        /* renamed from: a */
        public void accept(h.c.k0.b bVar) {
            this.a.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    public static final class d<T> extends AtomicInteger implements h.c.k0.b {
        final j<T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.z<? super T> f16135b;

        /* renamed from: c  reason: collision with root package name */
        Object f16136c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f16137d;

        d(j<T> jVar, h.c.z<? super T> zVar) {
            this.a = jVar;
            this.f16135b = zVar;
        }

        <U> U a() {
            return (U) this.f16136c;
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f16137d) {
                return;
            }
            this.f16137d = true;
            this.a.b(this);
            this.f16136c = null;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16137d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    public static final class e<R, U> extends h.c.s<R> {
        private final Callable<? extends h.c.o0.a<U>> a;

        /* renamed from: b  reason: collision with root package name */
        private final h.c.m0.n<? super h.c.s<U>, ? extends h.c.x<R>> f16138b;

        e(Callable<? extends h.c.o0.a<U>> callable, h.c.m0.n<? super h.c.s<U>, ? extends h.c.x<R>> nVar) {
            this.a = callable;
            this.f16138b = nVar;
        }

        @Override // h.c.s
        protected void subscribeActual(h.c.z<? super R> zVar) {
            try {
                h.c.o0.a aVar = (h.c.o0.a) h.c.n0.b.b.e(this.a.call(), "The connectableFactory returned a null ConnectableObservable");
                h.c.x xVar = (h.c.x) h.c.n0.b.b.e(this.f16138b.apply(aVar), "The selector returned a null ObservableSource");
                m4 m4Var = new m4(zVar);
                xVar.subscribe(m4Var);
                aVar.b(new c(m4Var));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.n0.a.d.y(th, zVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    public static final class f extends AtomicReference<f> {
        final Object a;

        f(Object obj) {
            this.a = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    public static final class g<T> extends h.c.o0.a<T> {
        private final h.c.o0.a<T> a;

        /* renamed from: b  reason: collision with root package name */
        private final h.c.s<T> f16139b;

        g(h.c.o0.a<T> aVar, h.c.s<T> sVar) {
            this.a = aVar;
            this.f16139b = sVar;
        }

        @Override // h.c.o0.a
        public void b(h.c.m0.f<? super h.c.k0.b> fVar) {
            this.a.b(fVar);
        }

        @Override // h.c.s
        protected void subscribeActual(h.c.z<? super T> zVar) {
            this.f16139b.subscribe(zVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    public interface h<T> {
        void h();

        void i(T t);

        void k(Throwable th);

        void l(d<T> dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    public static final class i<T> implements b<T> {
        private final int a;

        i(int i2) {
            this.a = i2;
        }

        @Override // h.c.n0.e.e.q2.b
        public h<T> call() {
            return new n(this.a);
        }
    }

    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    static final class j<T> extends AtomicReference<h.c.k0.b> implements h.c.z<T>, h.c.k0.b {
        static final d[] a = new d[0];

        /* renamed from: b  reason: collision with root package name */
        static final d[] f16140b = new d[0];

        /* renamed from: c  reason: collision with root package name */
        final h<T> f16141c;

        /* renamed from: d  reason: collision with root package name */
        boolean f16142d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<d[]> f16143e = new AtomicReference<>(a);

        /* renamed from: f  reason: collision with root package name */
        final AtomicBoolean f16144f = new AtomicBoolean();

        j(h<T> hVar) {
            this.f16141c = hVar;
        }

        boolean a(d<T> dVar) {
            d[] dVarArr;
            d[] dVarArr2;
            do {
                dVarArr = this.f16143e.get();
                if (dVarArr == f16140b) {
                    return false;
                }
                int length = dVarArr.length;
                dVarArr2 = new d[length + 1];
                System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                dVarArr2[length] = dVar;
            } while (!this.f16143e.compareAndSet(dVarArr, dVarArr2));
            return true;
        }

        void b(d<T> dVar) {
            d[] dVarArr;
            d[] dVarArr2;
            do {
                dVarArr = this.f16143e.get();
                int length = dVarArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (dVarArr[i3].equals(dVar)) {
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
                    dVarArr2 = a;
                } else {
                    d[] dVarArr3 = new d[length - 1];
                    System.arraycopy(dVarArr, 0, dVarArr3, 0, i2);
                    System.arraycopy(dVarArr, i2 + 1, dVarArr3, i2, (length - i2) - 1);
                    dVarArr2 = dVarArr3;
                }
            } while (!this.f16143e.compareAndSet(dVarArr, dVarArr2));
        }

        void c() {
            for (d<T> dVar : this.f16143e.get()) {
                this.f16141c.l(dVar);
            }
        }

        void d() {
            for (d<T> dVar : this.f16143e.getAndSet(f16140b)) {
                this.f16141c.l(dVar);
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16143e.set(f16140b);
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16143e.get() == f16140b;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f16142d) {
                return;
            }
            this.f16142d = true;
            this.f16141c.h();
            d();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (!this.f16142d) {
                this.f16142d = true;
                this.f16141c.k(th);
                d();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f16142d) {
                return;
            }
            this.f16141c.i(t);
            c();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.z(this, bVar)) {
                c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    public static final class k<T> implements h.c.x<T> {
        private final AtomicReference<j<T>> a;

        /* renamed from: b  reason: collision with root package name */
        private final b<T> f16145b;

        k(AtomicReference<j<T>> atomicReference, b<T> bVar) {
            this.a = atomicReference;
            this.f16145b = bVar;
        }

        @Override // h.c.x
        public void subscribe(h.c.z<? super T> zVar) {
            j<T> jVar;
            while (true) {
                jVar = this.a.get();
                if (jVar != null) {
                    break;
                }
                j<T> jVar2 = new j<>(this.f16145b.call());
                if (this.a.compareAndSet(null, jVar2)) {
                    jVar = jVar2;
                    break;
                }
            }
            d<T> dVar = new d<>(jVar, zVar);
            zVar.onSubscribe(dVar);
            jVar.a(dVar);
            if (dVar.isDisposed()) {
                jVar.b(dVar);
            } else {
                jVar.f16141c.l(dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    public static final class l<T> implements b<T> {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final long f16146b;

        /* renamed from: c  reason: collision with root package name */
        private final TimeUnit f16147c;

        /* renamed from: d  reason: collision with root package name */
        private final h.c.a0 f16148d;

        l(int i2, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
            this.a = i2;
            this.f16146b = j2;
            this.f16147c = timeUnit;
            this.f16148d = a0Var;
        }

        @Override // h.c.n0.e.e.q2.b
        public h<T> call() {
            return new m(this.a, this.f16146b, this.f16147c, this.f16148d);
        }
    }

    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    static final class m<T> extends a<T> {

        /* renamed from: c  reason: collision with root package name */
        final h.c.a0 f16149c;

        /* renamed from: d  reason: collision with root package name */
        final long f16150d;

        /* renamed from: e  reason: collision with root package name */
        final TimeUnit f16151e;

        /* renamed from: f  reason: collision with root package name */
        final int f16152f;

        m(int i2, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
            this.f16149c = a0Var;
            this.f16152f = i2;
            this.f16150d = j2;
            this.f16151e = timeUnit;
        }

        @Override // h.c.n0.e.e.q2.a
        Object b(Object obj) {
            return new h.c.u0.b(obj, this.f16149c.b(this.f16151e), this.f16151e);
        }

        @Override // h.c.n0.e.e.q2.a
        f c() {
            f fVar;
            long b2 = this.f16149c.b(this.f16151e) - this.f16150d;
            f fVar2 = get();
            f fVar3 = fVar2.get();
            while (true) {
                f fVar4 = fVar3;
                fVar = fVar2;
                fVar2 = fVar4;
                if (fVar2 != null) {
                    h.c.u0.b bVar = (h.c.u0.b) fVar2.a;
                    if (h.c.n0.j.m.D(bVar.b()) || h.c.n0.j.m.E(bVar.b()) || bVar.a() > b2) {
                        break;
                    }
                    fVar3 = fVar2.get();
                } else {
                    break;
                }
            }
            return fVar;
        }

        @Override // h.c.n0.e.e.q2.a
        Object d(Object obj) {
            return ((h.c.u0.b) obj).b();
        }

        @Override // h.c.n0.e.e.q2.a
        void j() {
            f fVar;
            long b2 = this.f16149c.b(this.f16151e) - this.f16150d;
            f fVar2 = get();
            f fVar3 = fVar2.get();
            int i2 = 0;
            while (true) {
                f fVar4 = fVar3;
                fVar = fVar2;
                fVar2 = fVar4;
                if (fVar2 != null) {
                    int i3 = this.f16134b;
                    if (i3 > this.f16152f) {
                        i2++;
                        this.f16134b = i3 - 1;
                        fVar3 = fVar2.get();
                    } else if (((h.c.u0.b) fVar2.a).a() > b2) {
                        break;
                    } else {
                        i2++;
                        this.f16134b--;
                        fVar3 = fVar2.get();
                    }
                } else {
                    break;
                }
            }
            if (i2 != 0) {
                f(fVar);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
            f(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
            return;
         */
        @Override // h.c.n0.e.e.q2.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void m() {
            /*
                r10 = this;
                h.c.a0 r0 = r10.f16149c
                java.util.concurrent.TimeUnit r1 = r10.f16151e
                long r0 = r0.b(r1)
                long r2 = r10.f16150d
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                h.c.n0.e.e.q2$f r2 = (h.c.n0.e.e.q2.f) r2
                java.lang.Object r3 = r2.get()
                h.c.n0.e.e.q2$f r3 = (h.c.n0.e.e.q2.f) r3
                r4 = 0
            L18:
                r9 = r3
                r3 = r2
                r2 = r9
                if (r2 == 0) goto L3c
                int r5 = r10.f16134b
                r6 = 1
                if (r5 <= r6) goto L3c
                java.lang.Object r5 = r2.a
                h.c.u0.b r5 = (h.c.u0.b) r5
                long r7 = r5.a()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L3c
                int r4 = r4 + 1
                int r3 = r10.f16134b
                int r3 = r3 - r6
                r10.f16134b = r3
                java.lang.Object r3 = r2.get()
                h.c.n0.e.e.q2$f r3 = (h.c.n0.e.e.q2.f) r3
                goto L18
            L3c:
                if (r4 == 0) goto L41
                r10.f(r3)
            L41:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.e.q2.m.m():void");
        }
    }

    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    static final class n<T> extends a<T> {

        /* renamed from: c  reason: collision with root package name */
        final int f16153c;

        n(int i2) {
            this.f16153c = i2;
        }

        @Override // h.c.n0.e.e.q2.a
        void j() {
            if (this.f16134b > this.f16153c) {
                e();
            }
        }
    }

    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    static final class o implements b<Object> {
        o() {
        }

        @Override // h.c.n0.e.e.q2.b
        public h<Object> call() {
            return new p(16);
        }
    }

    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    static final class p<T> extends ArrayList<Object> implements h<T> {
        volatile int a;

        p(int i2) {
            super(i2);
        }

        @Override // h.c.n0.e.e.q2.h
        public void h() {
            add(h.c.n0.j.m.y());
            this.a++;
        }

        @Override // h.c.n0.e.e.q2.h
        public void i(T t) {
            add(h.c.n0.j.m.F(t));
            this.a++;
        }

        @Override // h.c.n0.e.e.q2.h
        public void k(Throwable th) {
            add(h.c.n0.j.m.A(th));
            this.a++;
        }

        @Override // h.c.n0.e.e.q2.h
        public void l(d<T> dVar) {
            if (dVar.getAndIncrement() != 0) {
                return;
            }
            h.c.z<? super T> zVar = dVar.f16135b;
            int i2 = 1;
            while (!dVar.isDisposed()) {
                int i3 = this.a;
                Integer num = (Integer) dVar.a();
                int intValue = num != null ? num.intValue() : 0;
                while (intValue < i3) {
                    if (h.c.n0.j.m.h(get(intValue), zVar) || dVar.isDisposed()) {
                        return;
                    }
                    intValue++;
                }
                dVar.f16136c = Integer.valueOf(intValue);
                i2 = dVar.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }
    }

    private q2(h.c.x<T> xVar, h.c.x<T> xVar2, AtomicReference<j<T>> atomicReference, b<T> bVar) {
        this.f16133e = xVar;
        this.f16130b = xVar2;
        this.f16131c = atomicReference;
        this.f16132d = bVar;
    }

    public static <T> h.c.o0.a<T> d(h.c.x<T> xVar, int i2) {
        if (i2 == Integer.MAX_VALUE) {
            return h(xVar);
        }
        return g(xVar, new i(i2));
    }

    public static <T> h.c.o0.a<T> e(h.c.x<T> xVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
        return f(xVar, j2, timeUnit, a0Var, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
    }

    public static <T> h.c.o0.a<T> f(h.c.x<T> xVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var, int i2) {
        return g(xVar, new l(i2, j2, timeUnit, a0Var));
    }

    static <T> h.c.o0.a<T> g(h.c.x<T> xVar, b<T> bVar) {
        AtomicReference atomicReference = new AtomicReference();
        return h.c.r0.a.q(new q2(new k(atomicReference, bVar), xVar, atomicReference, bVar));
    }

    public static <T> h.c.o0.a<T> h(h.c.x<? extends T> xVar) {
        return g(xVar, a);
    }

    public static <U, R> h.c.s<R> i(Callable<? extends h.c.o0.a<U>> callable, h.c.m0.n<? super h.c.s<U>, ? extends h.c.x<R>> nVar) {
        return h.c.r0.a.n(new e(callable, nVar));
    }

    public static <T> h.c.o0.a<T> j(h.c.o0.a<T> aVar, h.c.a0 a0Var) {
        return h.c.r0.a.q(new g(aVar, aVar.observeOn(a0Var)));
    }

    @Override // h.c.n0.a.f
    public void a(h.c.k0.b bVar) {
        this.f16131c.compareAndSet((j) bVar, null);
    }

    @Override // h.c.o0.a
    public void b(h.c.m0.f<? super h.c.k0.b> fVar) {
        j<T> jVar;
        while (true) {
            jVar = this.f16131c.get();
            if (jVar != null && !jVar.isDisposed()) {
                break;
            }
            j<T> jVar2 = new j<>(this.f16132d.call());
            if (this.f16131c.compareAndSet(jVar, jVar2)) {
                jVar = jVar2;
                break;
            }
        }
        boolean z = !jVar.f16144f.get() && jVar.f16144f.compareAndSet(false, true);
        try {
            fVar.accept(jVar);
            if (z) {
                this.f16130b.subscribe(jVar);
            }
        } catch (Throwable th) {
            if (z) {
                jVar.f16144f.compareAndSet(true, false);
            }
            io.reactivex.exceptions.a.b(th);
            throw h.c.n0.j.j.e(th);
        }
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        this.f16133e.subscribe(zVar);
    }
}