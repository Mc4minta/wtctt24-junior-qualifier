package h.c.n0.e.d;

import h.c.p;
import h.c.q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableSwitchMapMaybe.java */
/* loaded from: classes3.dex */
public final class e<T, R> extends h.c.h<R> {
    final h.c.h<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends q<? extends R>> f15387b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f15388c;

    /* compiled from: FlowableSwitchMapMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements h.c.m<T>, k.a.d {
        static final C0367a<Object> a = new C0367a<>(null);

        /* renamed from: b  reason: collision with root package name */
        final k.a.c<? super R> f15389b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends q<? extends R>> f15390c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f15391d;

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.j.c f15392e = new h.c.n0.j.c();

        /* renamed from: f  reason: collision with root package name */
        final AtomicLong f15393f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<C0367a<R>> f15394g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        k.a.d f15395h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f15396j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f15397k;

        /* renamed from: l  reason: collision with root package name */
        long f15398l;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FlowableSwitchMapMaybe.java */
        /* renamed from: h.c.n0.e.d.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0367a<R> extends AtomicReference<h.c.k0.b> implements p<R> {
            final a<?, R> a;

            /* renamed from: b  reason: collision with root package name */
            volatile R f15399b;

            C0367a(a<?, R> aVar) {
                this.a = aVar;
            }

            void a() {
                h.c.n0.a.c.h(this);
            }

            @Override // h.c.p
            public void onComplete() {
                this.a.c(this);
            }

            @Override // h.c.p
            public void onError(Throwable th) {
                this.a.d(this, th);
            }

            @Override // h.c.p
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.z(this, bVar);
            }

            @Override // h.c.p
            public void onSuccess(R r) {
                this.f15399b = r;
                this.a.b();
            }
        }

        a(k.a.c<? super R> cVar, h.c.m0.n<? super T, ? extends q<? extends R>> nVar, boolean z) {
            this.f15389b = cVar;
            this.f15390c = nVar;
            this.f15391d = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            C0367a<Object> c0367a = a;
            C0367a<Object> c0367a2 = (C0367a) this.f15394g.getAndSet(c0367a);
            if (c0367a2 == null || c0367a2 == c0367a) {
                return;
            }
            c0367a2.a();
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            k.a.c<? super R> cVar = this.f15389b;
            h.c.n0.j.c cVar2 = this.f15392e;
            AtomicReference<C0367a<R>> atomicReference = this.f15394g;
            AtomicLong atomicLong = this.f15393f;
            long j2 = this.f15398l;
            int i2 = 1;
            while (!this.f15397k) {
                if (cVar2.get() != null && !this.f15391d) {
                    cVar.onError(cVar2.b());
                    return;
                }
                boolean z = this.f15396j;
                C0367a<R> c0367a = atomicReference.get();
                boolean z2 = c0367a == null;
                if (z && z2) {
                    Throwable b2 = cVar2.b();
                    if (b2 != null) {
                        cVar.onError(b2);
                        return;
                    } else {
                        cVar.onComplete();
                        return;
                    }
                } else if (!z2 && c0367a.f15399b != null && j2 != atomicLong.get()) {
                    atomicReference.compareAndSet(c0367a, null);
                    cVar.onNext((R) c0367a.f15399b);
                    j2++;
                } else {
                    this.f15398l = j2;
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        void c(C0367a<R> c0367a) {
            if (this.f15394g.compareAndSet(c0367a, null)) {
                b();
            }
        }

        @Override // k.a.d
        public void cancel() {
            this.f15397k = true;
            this.f15395h.cancel();
            a();
        }

        void d(C0367a<R> c0367a, Throwable th) {
            if (this.f15394g.compareAndSet(c0367a, null) && this.f15392e.a(th)) {
                if (!this.f15391d) {
                    this.f15395h.cancel();
                    a();
                }
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onComplete() {
            this.f15396j = true;
            b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15392e.a(th)) {
                if (!this.f15391d) {
                    a();
                }
                this.f15396j = true;
                b();
                return;
            }
            h.c.r0.a.u(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // k.a.c
        public void onNext(T t) {
            C0367a<R> c0367a;
            C0367a<R> c0367a2 = this.f15394g.get();
            if (c0367a2 != null) {
                c0367a2.a();
            }
            try {
                q qVar = (q) h.c.n0.b.b.e(this.f15390c.apply(t), "The mapper returned a null MaybeSource");
                C0367a<R> c0367a3 = new C0367a<>(this);
                do {
                    c0367a = this.f15394g.get();
                    if (c0367a == a) {
                        return;
                    }
                } while (!this.f15394g.compareAndSet(c0367a, c0367a3));
                qVar.b(c0367a3);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15395h.cancel();
                this.f15394g.getAndSet(a);
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15395h, dVar)) {
                this.f15395h = dVar;
                this.f15389b.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            h.c.n0.j.d.a(this.f15393f, j2);
            b();
        }
    }

    public e(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends q<? extends R>> nVar, boolean z) {
        this.a = hVar;
        this.f15387b = nVar;
        this.f15388c = z;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f15387b, this.f15388c));
    }
}