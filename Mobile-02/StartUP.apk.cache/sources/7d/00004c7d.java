package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableMergeWithCompletable.java */
/* loaded from: classes3.dex */
public final class e2<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.f f14358b;

    /* compiled from: FlowableMergeWithCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<k.a.d> f14359b = new AtomicReference<>();

        /* renamed from: c  reason: collision with root package name */
        final C0348a f14360c = new C0348a(this);

        /* renamed from: d  reason: collision with root package name */
        final h.c.n0.j.c f14361d = new h.c.n0.j.c();

        /* renamed from: e  reason: collision with root package name */
        final AtomicLong f14362e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f14363f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f14364g;

        /* compiled from: FlowableMergeWithCompletable.java */
        /* renamed from: h.c.n0.e.b.e2$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0348a extends AtomicReference<h.c.k0.b> implements h.c.e {
            final a<?> a;

            C0348a(a<?> aVar) {
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

        a(k.a.c<? super T> cVar) {
            this.a = cVar;
        }

        void a() {
            this.f14364g = true;
            if (this.f14363f) {
                h.c.n0.j.k.b(this.a, this, this.f14361d);
            }
        }

        void b(Throwable th) {
            h.c.n0.i.g.h(this.f14359b);
            h.c.n0.j.k.d(this.a, th, this, this.f14361d);
        }

        @Override // k.a.d
        public void cancel() {
            h.c.n0.i.g.h(this.f14359b);
            h.c.n0.a.c.h(this.f14360c);
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14363f = true;
            if (this.f14364g) {
                h.c.n0.j.k.b(this.a, this, this.f14361d);
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            h.c.n0.i.g.h(this.f14359b);
            h.c.n0.j.k.d(this.a, th, this, this.f14361d);
        }

        @Override // k.a.c
        public void onNext(T t) {
            h.c.n0.j.k.f(this.a, t, this, this.f14361d);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.q(this.f14359b, this.f14362e, dVar);
        }

        @Override // k.a.d
        public void request(long j2) {
            h.c.n0.i.g.n(this.f14359b, this.f14362e, j2);
        }
    }

    public e2(h.c.h<T> hVar, h.c.f fVar) {
        super(hVar);
        this.f14358b = fVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        a aVar = new a(cVar);
        cVar.onSubscribe(aVar);
        this.a.subscribe((h.c.m) aVar);
        this.f14358b.c(aVar.f14360c);
    }
}