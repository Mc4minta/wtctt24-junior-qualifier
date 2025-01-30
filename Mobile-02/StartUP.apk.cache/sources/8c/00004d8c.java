package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableSkipUntil.java */
/* loaded from: classes3.dex */
public final class u3<T, U> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final k.a.b<U> f15096b;

    /* compiled from: FlowableSkipUntil.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.n0.c.a<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<k.a.d> f15097b = new AtomicReference<>();

        /* renamed from: c  reason: collision with root package name */
        final AtomicLong f15098c = new AtomicLong();

        /* renamed from: d  reason: collision with root package name */
        final a<T>.C0357a f15099d = new C0357a();

        /* renamed from: e  reason: collision with root package name */
        final h.c.n0.j.c f15100e = new h.c.n0.j.c();

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f15101f;

        /* compiled from: FlowableSkipUntil.java */
        /* renamed from: h.c.n0.e.b.u3$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class C0357a extends AtomicReference<k.a.d> implements h.c.m<Object> {
            C0357a() {
            }

            @Override // k.a.c
            public void onComplete() {
                a.this.f15101f = true;
            }

            @Override // k.a.c
            public void onError(Throwable th) {
                h.c.n0.i.g.h(a.this.f15097b);
                a aVar = a.this;
                h.c.n0.j.k.d(aVar.a, th, aVar, aVar.f15100e);
            }

            @Override // k.a.c
            public void onNext(Object obj) {
                a.this.f15101f = true;
                get().cancel();
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
            h.c.n0.i.g.h(this.f15097b);
            h.c.n0.i.g.h(this.f15099d);
        }

        @Override // h.c.n0.c.a
        public boolean h(T t) {
            if (this.f15101f) {
                h.c.n0.j.k.f(this.a, t, this, this.f15100e);
                return true;
            }
            return false;
        }

        @Override // k.a.c
        public void onComplete() {
            h.c.n0.i.g.h(this.f15099d);
            h.c.n0.j.k.b(this.a, this, this.f15100e);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            h.c.n0.i.g.h(this.f15099d);
            h.c.n0.j.k.d(this.a, th, this, this.f15100e);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (h(t)) {
                return;
            }
            this.f15097b.get().request(1L);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.q(this.f15097b, this.f15098c, dVar);
        }

        @Override // k.a.d
        public void request(long j2) {
            h.c.n0.i.g.n(this.f15097b, this.f15098c, j2);
        }
    }

    public u3(h.c.h<T> hVar, k.a.b<U> bVar) {
        super(hVar);
        this.f15096b = bVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        a aVar = new a(cVar);
        cVar.onSubscribe(aVar);
        this.f15096b.subscribe(aVar.f15099d);
        this.a.subscribe((h.c.m) aVar);
    }
}