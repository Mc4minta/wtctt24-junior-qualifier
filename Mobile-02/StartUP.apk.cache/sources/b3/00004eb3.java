package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSwitchMap.java */
/* loaded from: classes3.dex */
public final class l3<T, R> extends h.c.n0.e.e.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.x<? extends R>> f15914b;

    /* renamed from: c  reason: collision with root package name */
    final int f15915c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f15916d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableSwitchMap.java */
    /* loaded from: classes3.dex */
    public static final class a<T, R> extends AtomicReference<h.c.k0.b> implements h.c.z<R> {
        final b<T, R> a;

        /* renamed from: b  reason: collision with root package name */
        final long f15917b;

        /* renamed from: c  reason: collision with root package name */
        final int f15918c;

        /* renamed from: d  reason: collision with root package name */
        volatile h.c.n0.c.j<R> f15919d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f15920e;

        a(b<T, R> bVar, long j2, int i2) {
            this.a = bVar;
            this.f15917b = j2;
            this.f15918c = i2;
        }

        public void a() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15917b == this.a.f15930l) {
                this.f15920e = true;
                this.a.b();
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.a.c(this, th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(R r) {
            if (this.f15917b == this.a.f15930l) {
                if (r != null) {
                    this.f15919d.offer(r);
                }
                this.a.b();
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.z(this, bVar)) {
                if (bVar instanceof h.c.n0.c.e) {
                    h.c.n0.c.e eVar = (h.c.n0.c.e) bVar;
                    int n = eVar.n(7);
                    if (n == 1) {
                        this.f15919d = eVar;
                        this.f15920e = true;
                        this.a.b();
                        return;
                    } else if (n == 2) {
                        this.f15919d = eVar;
                        return;
                    }
                }
                this.f15919d = new h.c.n0.f.c(this.f15918c);
            }
        }
    }

    /* compiled from: ObservableSwitchMap.java */
    /* loaded from: classes3.dex */
    static final class b<T, R> extends AtomicInteger implements h.c.z<T>, h.c.k0.b {
        static final a<Object, Object> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.z<? super R> f15921b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.x<? extends R>> f15922c;

        /* renamed from: d  reason: collision with root package name */
        final int f15923d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f15924e;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f15926g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f15927h;

        /* renamed from: j  reason: collision with root package name */
        h.c.k0.b f15928j;

        /* renamed from: l  reason: collision with root package name */
        volatile long f15930l;

        /* renamed from: k  reason: collision with root package name */
        final AtomicReference<a<T, R>> f15929k = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        final h.c.n0.j.c f15925f = new h.c.n0.j.c();

        static {
            a<Object, Object> aVar = new a<>(null, -1L, 1);
            a = aVar;
            aVar.a();
        }

        b(h.c.z<? super R> zVar, h.c.m0.n<? super T, ? extends h.c.x<? extends R>> nVar, int i2, boolean z) {
            this.f15921b = zVar;
            this.f15922c = nVar;
            this.f15923d = i2;
            this.f15924e = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            a<Object, Object> aVar;
            a<T, R> aVar2 = this.f15929k.get();
            a<Object, Object> aVar3 = a;
            if (aVar2 == aVar3 || (aVar = (a) this.f15929k.getAndSet(aVar3)) == aVar3 || aVar == null) {
                return;
            }
            aVar.a();
        }

        /* JADX WARN: Removed duplicated region for block: B:101:0x000f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:93:0x00e9 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void b() {
            /*
                Method dump skipped, instructions count: 241
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.e.l3.b.b():void");
        }

        void c(a<T, R> aVar, Throwable th) {
            if (aVar.f15917b == this.f15930l && this.f15925f.a(th)) {
                if (!this.f15924e) {
                    this.f15928j.dispose();
                }
                aVar.f15920e = true;
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f15927h) {
                return;
            }
            this.f15927h = true;
            this.f15928j.dispose();
            a();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15927h;
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15926g) {
                return;
            }
            this.f15926g = true;
            b();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (!this.f15926g && this.f15925f.a(th)) {
                if (!this.f15924e) {
                    a();
                }
                this.f15926g = true;
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            a<T, R> aVar;
            long j2 = this.f15930l + 1;
            this.f15930l = j2;
            a<T, R> aVar2 = this.f15929k.get();
            if (aVar2 != null) {
                aVar2.a();
            }
            try {
                h.c.x xVar = (h.c.x) h.c.n0.b.b.e(this.f15922c.apply(t), "The ObservableSource returned is null");
                a<T, R> aVar3 = new a<>(this, j2, this.f15923d);
                do {
                    aVar = this.f15929k.get();
                    if (aVar == a) {
                        return;
                    }
                } while (!this.f15929k.compareAndSet(aVar, aVar3));
                xVar.subscribe(aVar3);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15928j.dispose();
                onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15928j, bVar)) {
                this.f15928j = bVar;
                this.f15921b.onSubscribe(this);
            }
        }
    }

    public l3(h.c.x<T> xVar, h.c.m0.n<? super T, ? extends h.c.x<? extends R>> nVar, int i2, boolean z) {
        super(xVar);
        this.f15914b = nVar;
        this.f15915c = i2;
        this.f15916d = z;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super R> zVar) {
        if (w2.b(this.a, zVar, this.f15914b)) {
            return;
        }
        this.a.subscribe(new b(zVar, this.f15914b, this.f15915c, this.f15916d));
    }
}