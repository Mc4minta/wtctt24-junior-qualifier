package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableMergeWithCompletable.java */
/* loaded from: classes3.dex */
public final class y1<T> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.f f16412b;

    /* compiled from: ObservableMergeWithCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f16413b = new AtomicReference<>();

        /* renamed from: c  reason: collision with root package name */
        final C0390a f16414c = new C0390a(this);

        /* renamed from: d  reason: collision with root package name */
        final h.c.n0.j.c f16415d = new h.c.n0.j.c();

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f16416e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f16417f;

        /* compiled from: ObservableMergeWithCompletable.java */
        /* renamed from: h.c.n0.e.e.y1$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0390a extends AtomicReference<h.c.k0.b> implements h.c.e {
            final a<?> a;

            C0390a(a<?> aVar) {
                this.a = aVar;
            }

            @Override // h.c.e
            public void onComplete() {
                this.a.a();
            }

            @Override // h.c.e
            public void onError(Throwable th) {
                this.a.b(th);
            }

            @Override // h.c.e
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.z(this, bVar);
            }
        }

        a(h.c.z<? super T> zVar) {
            this.a = zVar;
        }

        void a() {
            this.f16417f = true;
            if (this.f16416e) {
                h.c.n0.j.k.a(this.a, this, this.f16415d);
            }
        }

        void b(Throwable th) {
            h.c.n0.a.c.h(this.f16413b);
            h.c.n0.j.k.c(this.a, th, this, this.f16415d);
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this.f16413b);
            h.c.n0.a.c.h(this.f16414c);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(this.f16413b.get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f16416e = true;
            if (this.f16417f) {
                h.c.n0.j.k.a(this.a, this, this.f16415d);
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            h.c.n0.a.c.h(this.f16413b);
            h.c.n0.j.k.c(this.a, th, this, this.f16415d);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            h.c.n0.j.k.e(this.a, t, this, this.f16415d);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this.f16413b, bVar);
        }
    }

    public y1(h.c.s<T> sVar, h.c.f fVar) {
        super(sVar);
        this.f16412b = fVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        a aVar = new a(zVar);
        zVar.onSubscribe(aVar);
        this.a.subscribe(aVar);
        this.f16412b.c(aVar.f16414c);
    }
}