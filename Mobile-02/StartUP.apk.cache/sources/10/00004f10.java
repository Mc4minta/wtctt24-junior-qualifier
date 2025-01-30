package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableTakeUntil.java */
/* loaded from: classes3.dex */
public final class q3<T, U> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.x<? extends U> f16154b;

    /* compiled from: ObservableTakeUntil.java */
    /* loaded from: classes3.dex */
    static final class a<T, U> extends AtomicInteger implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f16155b = new AtomicReference<>();

        /* renamed from: c  reason: collision with root package name */
        final a<T, U>.C0384a f16156c = new C0384a();

        /* renamed from: d  reason: collision with root package name */
        final h.c.n0.j.c f16157d = new h.c.n0.j.c();

        /* compiled from: ObservableTakeUntil.java */
        /* renamed from: h.c.n0.e.e.q3$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class C0384a extends AtomicReference<h.c.k0.b> implements h.c.z<U> {
            C0384a() {
            }

            @Override // h.c.z, k.a.c
            public void onComplete() {
                a.this.a();
            }

            @Override // h.c.z, k.a.c
            public void onError(Throwable th) {
                a.this.b(th);
            }

            @Override // h.c.z, k.a.c
            public void onNext(U u) {
                h.c.n0.a.c.h(this);
                a.this.a();
            }

            @Override // h.c.z
            public void onSubscribe(h.c.k0.b bVar) {
                h.c.n0.a.c.z(this, bVar);
            }
        }

        a(h.c.z<? super T> zVar) {
            this.a = zVar;
        }

        void a() {
            h.c.n0.a.c.h(this.f16155b);
            h.c.n0.j.k.a(this.a, this, this.f16157d);
        }

        void b(Throwable th) {
            h.c.n0.a.c.h(this.f16155b);
            h.c.n0.j.k.c(this.a, th, this, this.f16157d);
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this.f16155b);
            h.c.n0.a.c.h(this.f16156c);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(this.f16155b.get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            h.c.n0.a.c.h(this.f16156c);
            h.c.n0.j.k.a(this.a, this, this.f16157d);
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            h.c.n0.a.c.h(this.f16156c);
            h.c.n0.j.k.c(this.a, th, this, this.f16157d);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            h.c.n0.j.k.e(this.a, t, this, this.f16157d);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this.f16155b, bVar);
        }
    }

    public q3(h.c.x<T> xVar, h.c.x<? extends U> xVar2) {
        super(xVar);
        this.f16154b = xVar2;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        a aVar = new a(zVar);
        zVar.onSubscribe(aVar);
        this.f16154b.subscribe(aVar.f16156c);
        this.a.subscribe(aVar);
    }
}