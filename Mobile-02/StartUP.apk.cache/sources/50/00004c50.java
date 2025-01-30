package h.c.n0.e.b;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableReplay.java */
/* loaded from: classes3.dex */
public final class c3<T> extends h.c.l0.a<T> implements h.c.n0.a.f {
    static final Callable a = new c();

    /* renamed from: b  reason: collision with root package name */
    final h.c.h<T> f14255b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<j<T>> f14256c;

    /* renamed from: d  reason: collision with root package name */
    final Callable<? extends g<T>> f14257d;

    /* renamed from: e  reason: collision with root package name */
    final k.a.b<T> f14258e;

    /* compiled from: FlowableReplay.java */
    /* loaded from: classes3.dex */
    static class a<T> extends AtomicReference<f> implements g<T> {
        f a;

        /* renamed from: b  reason: collision with root package name */
        int f14259b;

        /* renamed from: c  reason: collision with root package name */
        long f14260c;

        a() {
            f fVar = new f(null, 0L);
            this.a = fVar;
            set(fVar);
        }

        final void a(f fVar) {
            this.a.set(fVar);
            this.a = fVar;
            this.f14259b++;
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
            f fVar = get().get();
            if (fVar != null) {
                this.f14259b--;
                f(fVar);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        final void f(f fVar) {
            set(fVar);
        }

        final void g() {
            f fVar = get();
            if (fVar.a != null) {
                f fVar2 = new f(null, 0L);
                fVar2.lazySet(fVar.get());
                set(fVar2);
            }
        }

        @Override // h.c.n0.e.b.c3.g
        public final void h() {
            Object b2 = b(h.c.n0.j.m.y());
            long j2 = this.f14260c + 1;
            this.f14260c = j2;
            a(new f(b2, j2));
            m();
        }

        @Override // h.c.n0.e.b.c3.g
        public final void i(T t) {
            Object b2 = b(h.c.n0.j.m.F(t));
            long j2 = this.f14260c + 1;
            this.f14260c = j2;
            a(new f(b2, j2));
            j();
        }

        void j() {
            throw null;
        }

        @Override // h.c.n0.e.b.c3.g
        public final void k(Throwable th) {
            Object b2 = b(h.c.n0.j.m.A(th));
            long j2 = this.f14260c + 1;
            this.f14260c = j2;
            a(new f(b2, j2));
            m();
        }

        @Override // h.c.n0.e.b.c3.g
        public final void l(d<T> dVar) {
            f fVar;
            synchronized (dVar) {
                if (dVar.f14265e) {
                    dVar.f14266f = true;
                    return;
                }
                dVar.f14265e = true;
                while (!dVar.isDisposed()) {
                    long j2 = dVar.get();
                    boolean z = j2 == Long.MAX_VALUE;
                    f fVar2 = (f) dVar.a();
                    if (fVar2 == null) {
                        fVar2 = c();
                        dVar.f14263c = fVar2;
                        h.c.n0.j.d.a(dVar.f14264d, fVar2.f14269b);
                    }
                    long j3 = 0;
                    while (j2 != 0 && (fVar = fVar2.get()) != null) {
                        Object d2 = d(fVar.a);
                        try {
                            if (h.c.n0.j.m.n(d2, dVar.f14262b)) {
                                dVar.f14263c = null;
                                return;
                            }
                            j3++;
                            j2--;
                            if (dVar.isDisposed()) {
                                dVar.f14263c = null;
                                return;
                            }
                            fVar2 = fVar;
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.b(th);
                            dVar.f14263c = null;
                            dVar.dispose();
                            if (h.c.n0.j.m.E(d2) || h.c.n0.j.m.D(d2)) {
                                return;
                            }
                            dVar.f14262b.onError(th);
                            return;
                        }
                    }
                    if (j3 != 0) {
                        dVar.f14263c = fVar2;
                        if (!z) {
                            dVar.b(j3);
                        }
                    }
                    synchronized (dVar) {
                        if (!dVar.f14266f) {
                            dVar.f14265e = false;
                            return;
                        }
                        dVar.f14266f = false;
                    }
                }
                dVar.f14263c = null;
            }
        }

        void m() {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableReplay.java */
    /* loaded from: classes3.dex */
    public static final class b<T> extends h.c.l0.a<T> {
        private final h.c.l0.a<T> a;

        /* renamed from: b  reason: collision with root package name */
        private final h.c.h<T> f14261b;

        b(h.c.l0.a<T> aVar, h.c.h<T> hVar) {
            this.a = aVar;
            this.f14261b = hVar;
        }

        @Override // h.c.l0.a
        public void b(h.c.m0.f<? super h.c.k0.b> fVar) {
            this.a.b(fVar);
        }

        @Override // h.c.h
        protected void subscribeActual(k.a.c<? super T> cVar) {
            this.f14261b.subscribe(cVar);
        }
    }

    /* compiled from: FlowableReplay.java */
    /* loaded from: classes3.dex */
    static final class c implements Callable<Object> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return new n(16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableReplay.java */
    /* loaded from: classes3.dex */
    public static final class d<T> extends AtomicLong implements k.a.d, h.c.k0.b {
        final j<T> a;

        /* renamed from: b  reason: collision with root package name */
        final k.a.c<? super T> f14262b;

        /* renamed from: c  reason: collision with root package name */
        Object f14263c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicLong f14264d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        boolean f14265e;

        /* renamed from: f  reason: collision with root package name */
        boolean f14266f;

        d(j<T> jVar, k.a.c<? super T> cVar) {
            this.a = jVar;
            this.f14262b = cVar;
        }

        <U> U a() {
            return (U) this.f14263c;
        }

        public long b(long j2) {
            return h.c.n0.j.d.f(this, j2);
        }

        @Override // k.a.d
        public void cancel() {
            dispose();
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.a.c(this);
                this.a.b();
                this.f14263c = null;
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // k.a.d
        public void request(long j2) {
            if (!h.c.n0.i.g.B(j2) || h.c.n0.j.d.b(this, j2) == Long.MIN_VALUE) {
                return;
            }
            h.c.n0.j.d.a(this.f14264d, j2);
            this.a.b();
            this.a.f14272c.l(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableReplay.java */
    /* loaded from: classes3.dex */
    public static final class e<R, U> extends h.c.h<R> {
        private final Callable<? extends h.c.l0.a<U>> a;

        /* renamed from: b  reason: collision with root package name */
        private final h.c.m0.n<? super h.c.h<U>, ? extends k.a.b<R>> f14267b;

        /* compiled from: FlowableReplay.java */
        /* loaded from: classes3.dex */
        final class a implements h.c.m0.f<h.c.k0.b> {
            private final h.c.n0.h.u<R> a;

            a(h.c.n0.h.u<R> uVar) {
                this.a = uVar;
            }

            @Override // h.c.m0.f
            /* renamed from: a */
            public void accept(h.c.k0.b bVar) {
                this.a.a(bVar);
            }
        }

        e(Callable<? extends h.c.l0.a<U>> callable, h.c.m0.n<? super h.c.h<U>, ? extends k.a.b<R>> nVar) {
            this.a = callable;
            this.f14267b = nVar;
        }

        @Override // h.c.h
        protected void subscribeActual(k.a.c<? super R> cVar) {
            try {
                h.c.l0.a aVar = (h.c.l0.a) h.c.n0.b.b.e(this.a.call(), "The connectableFactory returned null");
                try {
                    k.a.b bVar = (k.a.b) h.c.n0.b.b.e(this.f14267b.apply(aVar), "The selector returned a null Publisher");
                    h.c.n0.h.u uVar = new h.c.n0.h.u(cVar);
                    bVar.subscribe(uVar);
                    aVar.b(new a(uVar));
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    h.c.n0.i.d.q(th, cVar);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                h.c.n0.i.d.q(th2, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableReplay.java */
    /* loaded from: classes3.dex */
    public static final class f extends AtomicReference<f> {
        final Object a;

        /* renamed from: b  reason: collision with root package name */
        final long f14269b;

        f(Object obj, long j2) {
            this.a = obj;
            this.f14269b = j2;
        }
    }

    /* compiled from: FlowableReplay.java */
    /* loaded from: classes3.dex */
    interface g<T> {
        void h();

        void i(T t);

        void k(Throwable th);

        void l(d<T> dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableReplay.java */
    /* loaded from: classes3.dex */
    public static final class h<T> implements Callable<g<T>> {
        private final int a;

        h(int i2) {
            this.a = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public g<T> call() {
            return new m(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableReplay.java */
    /* loaded from: classes3.dex */
    public static final class i<T> implements k.a.b<T> {
        private final AtomicReference<j<T>> a;

        /* renamed from: b  reason: collision with root package name */
        private final Callable<? extends g<T>> f14270b;

        i(AtomicReference<j<T>> atomicReference, Callable<? extends g<T>> callable) {
            this.a = atomicReference;
            this.f14270b = callable;
        }

        @Override // k.a.b
        public void subscribe(k.a.c<? super T> cVar) {
            j<T> jVar;
            while (true) {
                jVar = this.a.get();
                if (jVar != null) {
                    break;
                }
                try {
                    j<T> jVar2 = new j<>(this.f14270b.call());
                    if (this.a.compareAndSet(null, jVar2)) {
                        jVar = jVar2;
                        break;
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    h.c.n0.i.d.q(th, cVar);
                    return;
                }
            }
            d<T> dVar = new d<>(jVar, cVar);
            cVar.onSubscribe(dVar);
            jVar.a(dVar);
            if (dVar.isDisposed()) {
                jVar.c(dVar);
                return;
            }
            jVar.b();
            jVar.f14272c.l(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableReplay.java */
    /* loaded from: classes3.dex */
    public static final class j<T> extends AtomicReference<k.a.d> implements h.c.m<T>, h.c.k0.b {
        static final d[] a = new d[0];

        /* renamed from: b  reason: collision with root package name */
        static final d[] f14271b = new d[0];

        /* renamed from: c  reason: collision with root package name */
        final g<T> f14272c;

        /* renamed from: d  reason: collision with root package name */
        boolean f14273d;

        /* renamed from: h  reason: collision with root package name */
        long f14277h;

        /* renamed from: j  reason: collision with root package name */
        long f14278j;

        /* renamed from: g  reason: collision with root package name */
        final AtomicInteger f14276g = new AtomicInteger();

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<d<T>[]> f14274e = new AtomicReference<>(a);

        /* renamed from: f  reason: collision with root package name */
        final AtomicBoolean f14275f = new AtomicBoolean();

        j(g<T> gVar) {
            this.f14272c = gVar;
        }

        boolean a(d<T> dVar) {
            d<T>[] dVarArr;
            d<T>[] dVarArr2;
            Objects.requireNonNull(dVar);
            do {
                dVarArr = this.f14274e.get();
                if (dVarArr == f14271b) {
                    return false;
                }
                int length = dVarArr.length;
                dVarArr2 = new d[length + 1];
                System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                dVarArr2[length] = dVar;
            } while (!this.f14274e.compareAndSet(dVarArr, dVarArr2));
            return true;
        }

        void b() {
            if (this.f14276g.getAndIncrement() != 0) {
                return;
            }
            int i2 = 1;
            while (!isDisposed()) {
                d<T>[] dVarArr = this.f14274e.get();
                long j2 = this.f14277h;
                long j3 = j2;
                for (d<T> dVar : dVarArr) {
                    j3 = Math.max(j3, dVar.f14264d.get());
                }
                long j4 = this.f14278j;
                k.a.d dVar2 = get();
                long j5 = j3 - j2;
                if (j5 != 0) {
                    this.f14277h = j3;
                    if (dVar2 == null) {
                        long j6 = j4 + j5;
                        if (j6 < 0) {
                            j6 = Long.MAX_VALUE;
                        }
                        this.f14278j = j6;
                    } else if (j4 != 0) {
                        this.f14278j = 0L;
                        dVar2.request(j4 + j5);
                    } else {
                        dVar2.request(j5);
                    }
                } else if (j4 != 0 && dVar2 != null) {
                    this.f14278j = 0L;
                    dVar2.request(j4);
                }
                i2 = this.f14276g.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void c(d<T> dVar) {
            d<T>[] dVarArr;
            d[] dVarArr2;
            do {
                dVarArr = this.f14274e.get();
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
            } while (!this.f14274e.compareAndSet(dVarArr, dVarArr2));
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f14274e.set(f14271b);
            h.c.n0.i.g.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f14274e.get() == f14271b;
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14273d) {
                return;
            }
            this.f14273d = true;
            this.f14272c.h();
            for (d<T> dVar : this.f14274e.getAndSet(f14271b)) {
                this.f14272c.l(dVar);
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (!this.f14273d) {
                this.f14273d = true;
                this.f14272c.k(th);
                for (d<T> dVar : this.f14274e.getAndSet(f14271b)) {
                    this.f14272c.l(dVar);
                }
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14273d) {
                return;
            }
            this.f14272c.i(t);
            for (d<T> dVar : this.f14274e.get()) {
                this.f14272c.l(dVar);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.z(this, dVar)) {
                b();
                for (d<T> dVar2 : this.f14274e.get()) {
                    this.f14272c.l(dVar2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableReplay.java */
    /* loaded from: classes3.dex */
    public static final class k<T> implements Callable<g<T>> {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final long f14279b;

        /* renamed from: c  reason: collision with root package name */
        private final TimeUnit f14280c;

        /* renamed from: d  reason: collision with root package name */
        private final h.c.a0 f14281d;

        k(int i2, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
            this.a = i2;
            this.f14279b = j2;
            this.f14280c = timeUnit;
            this.f14281d = a0Var;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public g<T> call() {
            return new l(this.a, this.f14279b, this.f14280c, this.f14281d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableReplay.java */
    /* loaded from: classes3.dex */
    public static final class l<T> extends a<T> {

        /* renamed from: d  reason: collision with root package name */
        final h.c.a0 f14282d;

        /* renamed from: e  reason: collision with root package name */
        final long f14283e;

        /* renamed from: f  reason: collision with root package name */
        final TimeUnit f14284f;

        /* renamed from: g  reason: collision with root package name */
        final int f14285g;

        l(int i2, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
            this.f14282d = a0Var;
            this.f14285g = i2;
            this.f14283e = j2;
            this.f14284f = timeUnit;
        }

        @Override // h.c.n0.e.b.c3.a
        Object b(Object obj) {
            return new h.c.u0.b(obj, this.f14282d.b(this.f14284f), this.f14284f);
        }

        @Override // h.c.n0.e.b.c3.a
        f c() {
            f fVar;
            long b2 = this.f14282d.b(this.f14284f) - this.f14283e;
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

        @Override // h.c.n0.e.b.c3.a
        Object d(Object obj) {
            return ((h.c.u0.b) obj).b();
        }

        @Override // h.c.n0.e.b.c3.a
        void j() {
            f fVar;
            long b2 = this.f14282d.b(this.f14284f) - this.f14283e;
            f fVar2 = get();
            f fVar3 = fVar2.get();
            int i2 = 0;
            while (true) {
                f fVar4 = fVar3;
                fVar = fVar2;
                fVar2 = fVar4;
                if (fVar2 != null) {
                    int i3 = this.f14259b;
                    if (i3 > this.f14285g) {
                        i2++;
                        this.f14259b = i3 - 1;
                        fVar3 = fVar2.get();
                    } else if (((h.c.u0.b) fVar2.a).a() > b2) {
                        break;
                    } else {
                        i2++;
                        this.f14259b--;
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
        @Override // h.c.n0.e.b.c3.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void m() {
            /*
                r10 = this;
                h.c.a0 r0 = r10.f14282d
                java.util.concurrent.TimeUnit r1 = r10.f14284f
                long r0 = r0.b(r1)
                long r2 = r10.f14283e
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                h.c.n0.e.b.c3$f r2 = (h.c.n0.e.b.c3.f) r2
                java.lang.Object r3 = r2.get()
                h.c.n0.e.b.c3$f r3 = (h.c.n0.e.b.c3.f) r3
                r4 = 0
            L18:
                r9 = r3
                r3 = r2
                r2 = r9
                if (r2 == 0) goto L3c
                int r5 = r10.f14259b
                r6 = 1
                if (r5 <= r6) goto L3c
                java.lang.Object r5 = r2.a
                h.c.u0.b r5 = (h.c.u0.b) r5
                long r7 = r5.a()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L3c
                int r4 = r4 + 1
                int r3 = r10.f14259b
                int r3 = r3 - r6
                r10.f14259b = r3
                java.lang.Object r3 = r2.get()
                h.c.n0.e.b.c3$f r3 = (h.c.n0.e.b.c3.f) r3
                goto L18
            L3c:
                if (r4 == 0) goto L41
                r10.f(r3)
            L41:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.b.c3.l.m():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableReplay.java */
    /* loaded from: classes3.dex */
    public static final class m<T> extends a<T> {

        /* renamed from: d  reason: collision with root package name */
        final int f14286d;

        m(int i2) {
            this.f14286d = i2;
        }

        @Override // h.c.n0.e.b.c3.a
        void j() {
            if (this.f14259b > this.f14286d) {
                e();
            }
        }
    }

    /* compiled from: FlowableReplay.java */
    /* loaded from: classes3.dex */
    static final class n<T> extends ArrayList<Object> implements g<T> {
        volatile int a;

        n(int i2) {
            super(i2);
        }

        @Override // h.c.n0.e.b.c3.g
        public void h() {
            add(h.c.n0.j.m.y());
            this.a++;
        }

        @Override // h.c.n0.e.b.c3.g
        public void i(T t) {
            add(h.c.n0.j.m.F(t));
            this.a++;
        }

        @Override // h.c.n0.e.b.c3.g
        public void k(Throwable th) {
            add(h.c.n0.j.m.A(th));
            this.a++;
        }

        @Override // h.c.n0.e.b.c3.g
        public void l(d<T> dVar) {
            synchronized (dVar) {
                if (dVar.f14265e) {
                    dVar.f14266f = true;
                    return;
                }
                dVar.f14265e = true;
                k.a.c<? super T> cVar = dVar.f14262b;
                while (!dVar.isDisposed()) {
                    int i2 = this.a;
                    Integer num = (Integer) dVar.a();
                    int intValue = num != null ? num.intValue() : 0;
                    long j2 = dVar.get();
                    long j3 = j2;
                    long j4 = 0;
                    while (j3 != 0 && intValue < i2) {
                        Object obj = get(intValue);
                        try {
                            if (h.c.n0.j.m.n(obj, cVar) || dVar.isDisposed()) {
                                return;
                            }
                            intValue++;
                            j3--;
                            j4++;
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.b(th);
                            dVar.dispose();
                            if (h.c.n0.j.m.E(obj) || h.c.n0.j.m.D(obj)) {
                                return;
                            }
                            cVar.onError(th);
                            return;
                        }
                    }
                    if (j4 != 0) {
                        dVar.f14263c = Integer.valueOf(intValue);
                        if (j2 != Long.MAX_VALUE) {
                            dVar.b(j4);
                        }
                    }
                    synchronized (dVar) {
                        if (!dVar.f14266f) {
                            dVar.f14265e = false;
                            return;
                        }
                        dVar.f14266f = false;
                    }
                }
            }
        }
    }

    private c3(k.a.b<T> bVar, h.c.h<T> hVar, AtomicReference<j<T>> atomicReference, Callable<? extends g<T>> callable) {
        this.f14258e = bVar;
        this.f14255b = hVar;
        this.f14256c = atomicReference;
        this.f14257d = callable;
    }

    public static <T> h.c.l0.a<T> d(h.c.h<T> hVar, int i2) {
        if (i2 == Integer.MAX_VALUE) {
            return i(hVar);
        }
        return g(hVar, new h(i2));
    }

    public static <T> h.c.l0.a<T> e(h.c.h<T> hVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
        return f(hVar, j2, timeUnit, a0Var, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
    }

    public static <T> h.c.l0.a<T> f(h.c.h<T> hVar, long j2, TimeUnit timeUnit, h.c.a0 a0Var, int i2) {
        return g(hVar, new k(i2, j2, timeUnit, a0Var));
    }

    static <T> h.c.l0.a<T> g(h.c.h<T> hVar, Callable<? extends g<T>> callable) {
        AtomicReference atomicReference = new AtomicReference();
        return h.c.r0.a.p(new c3(new i(atomicReference, callable), hVar, atomicReference, callable));
    }

    public static <T> h.c.l0.a<T> i(h.c.h<? extends T> hVar) {
        return g(hVar, a);
    }

    public static <U, R> h.c.h<R> j(Callable<? extends h.c.l0.a<U>> callable, h.c.m0.n<? super h.c.h<U>, ? extends k.a.b<R>> nVar) {
        return new e(callable, nVar);
    }

    public static <T> h.c.l0.a<T> k(h.c.l0.a<T> aVar, h.c.a0 a0Var) {
        return h.c.r0.a.p(new b(aVar, aVar.observeOn(a0Var)));
    }

    @Override // h.c.n0.a.f
    public void a(h.c.k0.b bVar) {
        this.f14256c.compareAndSet((j) bVar, null);
    }

    @Override // h.c.l0.a
    public void b(h.c.m0.f<? super h.c.k0.b> fVar) {
        j<T> jVar;
        while (true) {
            jVar = this.f14256c.get();
            if (jVar != null && !jVar.isDisposed()) {
                break;
            }
            try {
                j<T> jVar2 = new j<>(this.f14257d.call());
                if (this.f14256c.compareAndSet(jVar, jVar2)) {
                    jVar = jVar2;
                    break;
                }
            } finally {
                io.reactivex.exceptions.a.b(th);
                RuntimeException e2 = h.c.n0.j.j.e(th);
            }
        }
        boolean z = !jVar.f14275f.get() && jVar.f14275f.compareAndSet(false, true);
        try {
            fVar.accept(jVar);
            if (z) {
                this.f14255b.subscribe((h.c.m) jVar);
            }
        } catch (Throwable th) {
            if (z) {
                jVar.f14275f.compareAndSet(true, false);
            }
            throw h.c.n0.j.j.e(th);
        }
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.f14258e.subscribe(cVar);
    }
}