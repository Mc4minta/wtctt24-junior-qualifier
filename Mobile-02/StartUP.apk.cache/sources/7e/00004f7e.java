package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableSequenceEqual.java */
/* loaded from: classes3.dex */
public final class z2<T> extends h.c.s<Boolean> {
    final h.c.x<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.x<? extends T> f16447b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.d<? super T, ? super T> f16448c;

    /* renamed from: d  reason: collision with root package name */
    final int f16449d;

    /* compiled from: ObservableSequenceEqual.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.k0.b {
        final h.c.z<? super Boolean> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.d<? super T, ? super T> f16450b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.n0.a.a f16451c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.x<? extends T> f16452d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.x<? extends T> f16453e;

        /* renamed from: f  reason: collision with root package name */
        final b<T>[] f16454f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f16455g;

        /* renamed from: h  reason: collision with root package name */
        T f16456h;

        /* renamed from: j  reason: collision with root package name */
        T f16457j;

        a(h.c.z<? super Boolean> zVar, int i2, h.c.x<? extends T> xVar, h.c.x<? extends T> xVar2, h.c.m0.d<? super T, ? super T> dVar) {
            this.a = zVar;
            this.f16452d = xVar;
            this.f16453e = xVar2;
            this.f16450b = dVar;
            this.f16454f = r3;
            b<T>[] bVarArr = {new b<>(this, 0, i2), new b<>(this, 1, i2)};
            this.f16451c = new h.c.n0.a.a(2);
        }

        void a(h.c.n0.f.c<T> cVar, h.c.n0.f.c<T> cVar2) {
            this.f16455g = true;
            cVar.clear();
            cVar2.clear();
        }

        void b() {
            Throwable th;
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            b<T>[] bVarArr = this.f16454f;
            b<T> bVar = bVarArr[0];
            h.c.n0.f.c<T> cVar = bVar.f16458b;
            b<T> bVar2 = bVarArr[1];
            h.c.n0.f.c<T> cVar2 = bVar2.f16458b;
            int i2 = 1;
            while (!this.f16455g) {
                boolean z = bVar.f16460d;
                if (z && (th2 = bVar.f16461e) != null) {
                    a(cVar, cVar2);
                    this.a.onError(th2);
                    return;
                }
                boolean z2 = bVar2.f16460d;
                if (z2 && (th = bVar2.f16461e) != null) {
                    a(cVar, cVar2);
                    this.a.onError(th);
                    return;
                }
                if (this.f16456h == null) {
                    this.f16456h = cVar.poll();
                }
                boolean z3 = this.f16456h == null;
                if (this.f16457j == null) {
                    this.f16457j = cVar2.poll();
                }
                T t = this.f16457j;
                boolean z4 = t == null;
                if (z && z2 && z3 && z4) {
                    this.a.onNext(Boolean.TRUE);
                    this.a.onComplete();
                    return;
                } else if (z && z2 && z3 != z4) {
                    a(cVar, cVar2);
                    this.a.onNext(Boolean.FALSE);
                    this.a.onComplete();
                    return;
                } else {
                    if (!z3 && !z4) {
                        try {
                            if (!this.f16450b.a((T) this.f16456h, t)) {
                                a(cVar, cVar2);
                                this.a.onNext(Boolean.FALSE);
                                this.a.onComplete();
                                return;
                            }
                            this.f16456h = null;
                            this.f16457j = null;
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
            return this.f16451c.a(i2, bVar);
        }

        void d() {
            b<T>[] bVarArr = this.f16454f;
            this.f16452d.subscribe(bVarArr[0]);
            this.f16453e.subscribe(bVarArr[1]);
        }

        @Override // h.c.k0.b
        public void dispose() {
            if (this.f16455g) {
                return;
            }
            this.f16455g = true;
            this.f16451c.dispose();
            if (getAndIncrement() == 0) {
                b<T>[] bVarArr = this.f16454f;
                bVarArr[0].f16458b.clear();
                bVarArr[1].f16458b.clear();
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16455g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableSequenceEqual.java */
    /* loaded from: classes3.dex */
    public static final class b<T> implements h.c.z<T> {
        final a<T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.f.c<T> f16458b;

        /* renamed from: c  reason: collision with root package name */
        final int f16459c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f16460d;

        /* renamed from: e  reason: collision with root package name */
        Throwable f16461e;

        b(a<T> aVar, int i2, int i3) {
            this.a = aVar;
            this.f16459c = i2;
            this.f16458b = new h.c.n0.f.c<>(i3);
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f16460d = true;
            this.a.b();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f16461e = th;
            this.f16460d = true;
            this.a.b();
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.f16458b.offer(t);
            this.a.b();
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            this.a.c(bVar, this.f16459c);
        }
    }

    public z2(h.c.x<? extends T> xVar, h.c.x<? extends T> xVar2, h.c.m0.d<? super T, ? super T> dVar, int i2) {
        this.a = xVar;
        this.f16447b = xVar2;
        this.f16448c = dVar;
        this.f16449d = i2;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super Boolean> zVar) {
        a aVar = new a(zVar, this.f16449d, this.a, this.f16447b, this.f16448c);
        zVar.onSubscribe(aVar);
        aVar.d();
    }
}