package h.c.n0.e.d;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableConcatMapCompletable.java */
/* loaded from: classes3.dex */
public final class a<T> extends h.c.c {
    final h.c.h<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.f> f15339b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.n0.j.i f15340c;

    /* renamed from: d  reason: collision with root package name */
    final int f15341d;

    /* compiled from: FlowableConcatMapCompletable.java */
    /* renamed from: h.c.n0.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0362a<T> extends AtomicInteger implements h.c.m<T>, h.c.k0.b {
        final h.c.e a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.f> f15342b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.n0.j.i f15343c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.n0.j.c f15344d = new h.c.n0.j.c();

        /* renamed from: e  reason: collision with root package name */
        final C0363a f15345e = new C0363a(this);

        /* renamed from: f  reason: collision with root package name */
        final int f15346f;

        /* renamed from: g  reason: collision with root package name */
        final h.c.n0.c.i<T> f15347g;

        /* renamed from: h  reason: collision with root package name */
        k.a.d f15348h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f15349j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f15350k;

        /* renamed from: l  reason: collision with root package name */
        volatile boolean f15351l;
        int m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FlowableConcatMapCompletable.java */
        /* renamed from: h.c.n0.e.d.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0363a extends AtomicReference<h.c.k0.b> implements h.c.e {
            final C0362a<?> a;

            C0363a(C0362a<?> c0362a) {
                this.a = c0362a;
            }

            void a() {
                h.c.n0.a.c.h(this);
            }

            @Override // h.c.e
            public void onComplete() {
                this.a.b();
            }

            @Override // h.c.e
            public void onError(Throwable th) {
                this.a.c(th);
            }

            @Override // h.c.e
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.q(this, bVar);
            }
        }

        C0362a(h.c.e eVar, h.c.m0.n<? super T, ? extends h.c.f> nVar, h.c.n0.j.i iVar, int i2) {
            this.a = eVar;
            this.f15342b = nVar;
            this.f15343c = iVar;
            this.f15346f = i2;
            this.f15347g = new h.c.n0.f.b(i2);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.f15351l) {
                if (!this.f15349j) {
                    if (this.f15343c == h.c.n0.j.i.BOUNDARY && this.f15344d.get() != null) {
                        this.f15347g.clear();
                        this.a.onError(this.f15344d.b());
                        return;
                    }
                    boolean z = this.f15350k;
                    T poll = this.f15347g.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable b2 = this.f15344d.b();
                        if (b2 != null) {
                            this.a.onError(b2);
                            return;
                        } else {
                            this.a.onComplete();
                            return;
                        }
                    } else if (!z2) {
                        int i2 = this.f15346f;
                        int i3 = i2 - (i2 >> 1);
                        int i4 = this.m + 1;
                        if (i4 == i3) {
                            this.m = 0;
                            this.f15348h.request(i3);
                        } else {
                            this.m = i4;
                        }
                        try {
                            h.c.f fVar = (h.c.f) h.c.n0.b.b.e(this.f15342b.apply(poll), "The mapper returned a null CompletableSource");
                            this.f15349j = true;
                            fVar.c(this.f15345e);
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.b(th);
                            this.f15347g.clear();
                            this.f15348h.cancel();
                            this.f15344d.a(th);
                            this.a.onError(this.f15344d.b());
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f15347g.clear();
        }

        void b() {
            this.f15349j = false;
            a();
        }

        void c(Throwable th) {
            if (this.f15344d.a(th)) {
                if (this.f15343c == h.c.n0.j.i.IMMEDIATE) {
                    this.f15348h.cancel();
                    Throwable b2 = this.f15344d.b();
                    if (b2 != h.c.n0.j.j.a) {
                        this.a.onError(b2);
                    }
                    if (getAndIncrement() == 0) {
                        this.f15347g.clear();
                        return;
                    }
                    return;
                }
                this.f15349j = false;
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15351l = true;
            this.f15348h.cancel();
            this.f15345e.a();
            if (getAndIncrement() == 0) {
                this.f15347g.clear();
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15351l;
        }

        @Override // k.a.c
        public void onComplete() {
            this.f15350k = true;
            a();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15344d.a(th)) {
                if (this.f15343c == h.c.n0.j.i.IMMEDIATE) {
                    this.f15345e.a();
                    Throwable b2 = this.f15344d.b();
                    if (b2 != h.c.n0.j.j.a) {
                        this.a.onError(b2);
                    }
                    if (getAndIncrement() == 0) {
                        this.f15347g.clear();
                        return;
                    }
                    return;
                }
                this.f15350k = true;
                a();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f15347g.offer(t)) {
                a();
                return;
            }
            this.f15348h.cancel();
            onError(new MissingBackpressureException("Queue full?!"));
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15348h, dVar)) {
                this.f15348h = dVar;
                this.a.onSubscribe(this);
                dVar.request(this.f15346f);
            }
        }
    }

    public a(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends h.c.f> nVar, h.c.n0.j.i iVar, int i2) {
        this.a = hVar;
        this.f15339b = nVar;
        this.f15340c = iVar;
        this.f15341d = i2;
    }

    @Override // h.c.c
    protected void t(h.c.e eVar) {
        this.a.subscribe((h.c.m) new C0362a(eVar, this.f15339b, this.f15340c, this.f15341d));
    }
}