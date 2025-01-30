package h.c.n0.e.d;

import h.c.e0;
import h.c.h0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableSwitchMapSingle.java */
/* loaded from: classes3.dex */
public final class f<T, R> extends h.c.h<R> {
    final h.c.h<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h0<? extends R>> f15400b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f15401c;

    /* compiled from: FlowableSwitchMapSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements h.c.m<T>, k.a.d {
        static final C0368a<Object> a = new C0368a<>(null);

        /* renamed from: b  reason: collision with root package name */
        final k.a.c<? super R> f15402b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h0<? extends R>> f15403c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f15404d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.j.c f15405e = new h.c.n0.j.c();

        /* renamed from: f  reason: collision with root package name */
        final AtomicLong f15406f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<C0368a<R>> f15407g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        k.a.d f15408h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f15409j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f15410k;

        /* renamed from: l  reason: collision with root package name */
        long f15411l;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FlowableSwitchMapSingle.java */
        /* renamed from: h.c.n0.e.d.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0368a<R> extends AtomicReference<h.c.k0.b> implements e0<R> {
            final a<?, R> a;

            /* renamed from: b  reason: collision with root package name */
            volatile R f15412b;

            C0368a(a<?, R> aVar) {
                this.a = aVar;
            }

            void a() {
                h.c.n0.a.c.h(this);
            }

            @Override // h.c.e0
            public void onError(Throwable th) {
                this.a.c(this, th);
            }

            @Override // h.c.e0
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.z(this, bVar);
            }

            @Override // h.c.e0
            public void onSuccess(R r) {
                this.f15412b = r;
                this.a.b();
            }
        }

        a(k.a.c<? super R> cVar, h.c.m0.n<? super T, ? extends h0<? extends R>> nVar, boolean z) {
            this.f15402b = cVar;
            this.f15403c = nVar;
            this.f15404d = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            C0368a<Object> c0368a = a;
            C0368a<Object> c0368a2 = (C0368a) this.f15407g.getAndSet(c0368a);
            if (c0368a2 == null || c0368a2 == c0368a) {
                return;
            }
            c0368a2.a();
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            k.a.c<? super R> cVar = this.f15402b;
            h.c.n0.j.c cVar2 = this.f15405e;
            AtomicReference<C0368a<R>> atomicReference = this.f15407g;
            AtomicLong atomicLong = this.f15406f;
            long j2 = this.f15411l;
            int i2 = 1;
            while (!this.f15410k) {
                if (cVar2.get() != null && !this.f15404d) {
                    cVar.onError(cVar2.b());
                    return;
                }
                boolean z = this.f15409j;
                C0368a<R> c0368a = atomicReference.get();
                boolean z2 = c0368a == null;
                if (z && z2) {
                    Throwable b2 = cVar2.b();
                    if (b2 != null) {
                        cVar.onError(b2);
                        return;
                    } else {
                        cVar.onComplete();
                        return;
                    }
                } else if (!z2 && c0368a.f15412b != null && j2 != atomicLong.get()) {
                    atomicReference.compareAndSet(c0368a, null);
                    cVar.onNext((R) c0368a.f15412b);
                    j2++;
                } else {
                    this.f15411l = j2;
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        void c(C0368a<R> c0368a, Throwable th) {
            if (this.f15407g.compareAndSet(c0368a, null) && this.f15405e.a(th)) {
                if (!this.f15404d) {
                    this.f15408h.cancel();
                    a();
                }
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.d
        public void cancel() {
            this.f15410k = true;
            this.f15408h.cancel();
            a();
        }

        @Override // k.a.c
        public void onComplete() {
            this.f15409j = true;
            b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15405e.a(th)) {
                if (!this.f15404d) {
                    a();
                }
                this.f15409j = true;
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // k.a.c
        public void onNext(T t) {
            C0368a<R> c0368a;
            C0368a<R> c0368a2 = this.f15407g.get();
            if (c0368a2 != null) {
                c0368a2.a();
            }
            try {
                h0 h0Var = (h0) h.c.n0.b.b.e(this.f15403c.apply(t), "The mapper returned a null SingleSource");
                C0368a<R> c0368a3 = new C0368a<>(this);
                do {
                    c0368a = this.f15407g.get();
                    if (c0368a == a) {
                        return;
                    }
                } while (!this.f15407g.compareAndSet(c0368a, c0368a3));
                h0Var.subscribe(c0368a3);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15408h.cancel();
                this.f15407g.getAndSet(a);
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15408h, dVar)) {
                this.f15408h = dVar;
                this.f15402b.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            h.c.n0.j.d.a(this.f15406f, j2);
            b();
        }
    }

    public f(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends h0<? extends R>> nVar, boolean z) {
        this.a = hVar;
        this.f15400b = nVar;
        this.f15401c = z;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f15400b, this.f15401c));
    }
}