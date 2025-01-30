package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableSequenceEqualSingle.java */
/* loaded from: classes3.dex */
public final class a3<T> extends h.c.b0<Boolean> implements h.c.n0.c.d<Boolean> {
    final h.c.x<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.x<? extends T> f15500b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.d<? super T, ? super T> f15501c;

    /* renamed from: d  reason: collision with root package name */
    final int f15502d;

    /* compiled from: ObservableSequenceEqualSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.k0.b {
        final h.c.e0<? super Boolean> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.d<? super T, ? super T> f15503b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.n0.a.a f15504c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.x<? extends T> f15505d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.x<? extends T> f15506e;

        /* renamed from: f  reason: collision with root package name */
        final b<T>[] f15507f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f15508g;

        /* renamed from: h  reason: collision with root package name */
        T f15509h;

        /* renamed from: j  reason: collision with root package name */
        T f15510j;

        a(h.c.e0<? super Boolean> e0Var, int i2, h.c.x<? extends T> xVar, h.c.x<? extends T> xVar2, h.c.m0.d<? super T, ? super T> dVar) {
            this.a = e0Var;
            this.f15505d = xVar;
            this.f15506e = xVar2;
            this.f15503b = dVar;
            this.f15507f = r3;
            b<T>[] bVarArr = {new b<>(this, 0, i2), new b<>(this, 1, i2)};
            this.f15504c = new h.c.n0.a.a(2);
        }

        void a(h.c.n0.f.c<T> cVar, h.c.n0.f.c<T> cVar2) {
            this.f15508g = true;
            cVar.clear();
            cVar2.clear();
        }

        void b() {
            Throwable th;
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            b<T>[] bVarArr = this.f15507f;
            b<T> bVar = bVarArr[0];
            h.c.n0.f.c<T> cVar = bVar.f15511b;
            b<T> bVar2 = bVarArr[1];
            h.c.n0.f.c<T> cVar2 = bVar2.f15511b;
            int i2 = 1;
            while (!this.f15508g) {
                boolean z = bVar.f15513d;
                if (z && (th2 = bVar.f15514e) != null) {
                    a(cVar, cVar2);
                    this.a.onError(th2);
                    return;
                }
                boolean z2 = bVar2.f15513d;
                if (z2 && (th = bVar2.f15514e) != null) {
                    a(cVar, cVar2);
                    this.a.onError(th);
                    return;
                }
                if (this.f15509h == null) {
                    this.f15509h = cVar.poll();
                }
                boolean z3 = this.f15509h == null;
                if (this.f15510j == null) {
                    this.f15510j = cVar2.poll();
                }
                T t = this.f15510j;
                boolean z4 = t == null;
                if (z && z2 && z3 && z4) {
                    this.a.onSuccess(Boolean.TRUE);
                    return;
                } else if (z && z2 && z3 != z4) {
                    a(cVar, cVar2);
                    this.a.onSuccess(Boolean.FALSE);
                    return;
                } else {
                    if (!z3 && !z4) {
                        try {
                            if (!this.f15503b.a((T) this.f15509h, t)) {
                                a(cVar, cVar2);
                                this.a.onSuccess(Boolean.FALSE);
                                return;
                            }
                            this.f15509h = null;
                            this.f15510j = null;
                        } catch (Throwable th3) {
                            io.reactivex.exceptions.a.b(th3);
                            a(cVar, cVar2);
                            this.a.onError(th3);
                            return;
                        }
                    }
                    if (z3 || z4) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                }
            }
            cVar.clear();
            cVar2.clear();
        }

        boolean c(h.c.k0.b bVar, int i2) {
            return this.f15504c.a(i2, bVar);
        }

        void d() {
            b<T>[] bVarArr = this.f15507f;
            this.f15505d.subscribe(bVarArr[0]);
            this.f15506e.subscribe(bVarArr[1]);
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f15508g) {
                return;
            }
            this.f15508g = true;
            this.f15504c.dispose();
            if (getAndIncrement() == 0) {
                b<T>[] bVarArr = this.f15507f;
                bVarArr[0].f15511b.clear();
                bVarArr[1].f15511b.clear();
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15508g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableSequenceEqualSingle.java */
    /* loaded from: classes3.dex */
    public static final class b<T> implements h.c.z<T> {
        final a<T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.f.c<T> f15511b;

        /* renamed from: c  reason: collision with root package name */
        final int f15512c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f15513d;

        /* renamed from: e  reason: collision with root package name */
        Throwable f15514e;

        b(a<T> aVar, int i2, int i3) {
            this.a = aVar;
            this.f15512c = i2;
            this.f15511b = new h.c.n0.f.c<>(i3);
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15513d = true;
            this.a.b();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f15514e = th;
            this.f15513d = true;
            this.a.b();
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.f15511b.offer(t);
            this.a.b();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            this.a.c(bVar, this.f15512c);
        }
    }

    public a3(h.c.x<? extends T> xVar, h.c.x<? extends T> xVar2, h.c.m0.d<? super T, ? super T> dVar, int i2) {
        this.a = xVar;
        this.f15500b = xVar2;
        this.f15501c = dVar;
        this.f15502d = i2;
    }

    @Override // h.c.n0.c.d
    public h.c.s<Boolean> a() {
        return h.c.r0.a.n(new z2(this.a, this.f15500b, this.f15501c, this.f15502d));
    }

    @Override // h.c.b0
    public void subscribeActual(h.c.e0<? super Boolean> e0Var) {
        a aVar = new a(e0Var, this.f15502d, this.a, this.f15500b, this.f15501c);
        e0Var.onSubscribe(aVar);
        aVar.d();
    }
}