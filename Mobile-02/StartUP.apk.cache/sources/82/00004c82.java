package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableTakeUntil.java */
/* loaded from: classes3.dex */
public final class e4<T, U> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final k.a.b<? extends U> f14372b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableTakeUntil.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends AtomicInteger implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicLong f14373b = new AtomicLong();

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<k.a.d> f14374c = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        final a<T>.C0349a f14376e = new C0349a();

        /* renamed from: d  reason: collision with root package name */
        final h.c.n0.j.c f14375d = new h.c.n0.j.c();

        /* compiled from: FlowableTakeUntil.java */
        /* renamed from: h.c.n0.e.b.e4$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class C0349a extends AtomicReference<k.a.d> implements h.c.m<Object> {
            C0349a() {
            }

            @Override // k.a.c
            public void onComplete() {
                h.c.n0.i.g.h(a.this.f14374c);
                a aVar = a.this;
                h.c.n0.j.k.b(aVar.a, aVar, aVar.f14375d);
            }

            @Override // k.a.c
            public void onError(Throwable th) {
                h.c.n0.i.g.h(a.this.f14374c);
                a aVar = a.this;
                h.c.n0.j.k.d(aVar.a, th, aVar, aVar.f14375d);
            }

            @Override // k.a.c
            public void onNext(Object obj) {
                h.c.n0.i.g.h(this);
                onComplete();
            }

            @Override // h.c.m, k.a.c
            public void onSubscribe(k.a.d dVar) {
                h.c.n0.i.g.A(this, dVar, Long.MAX_VALUE);
            }
        }

        a(k.a.c<? super T> cVar) {
            this.a = cVar;
        }

        @Override // k.a.d
        public void cancel() {
            h.c.n0.i.g.h(this.f14374c);
            h.c.n0.i.g.h(this.f14376e);
        }

        @Override // k.a.c
        public void onComplete() {
            h.c.n0.i.g.h(this.f14376e);
            h.c.n0.j.k.b(this.a, this, this.f14375d);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            h.c.n0.i.g.h(this.f14376e);
            h.c.n0.j.k.d(this.a, th, this, this.f14375d);
        }

        @Override // k.a.c
        public void onNext(T t) {
            h.c.n0.j.k.f(this.a, t, this, this.f14375d);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.q(this.f14374c, this.f14373b, dVar);
        }

        @Override // k.a.d
        public void request(long j2) {
            h.c.n0.i.g.n(this.f14374c, this.f14373b, j2);
        }
    }

    public e4(h.c.h<T> hVar, k.a.b<? extends U> bVar) {
        super(hVar);
        this.f14372b = bVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        a aVar = new a(cVar);
        cVar.onSubscribe(aVar);
        this.f14372b.subscribe(aVar.f14376e);
        this.a.subscribe((h.c.m) aVar);
    }
}