package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableSamplePublisher.java */
/* loaded from: classes3.dex */
public final class g3<T> extends h.c.h<T> {
    final k.a.b<T> a;

    /* renamed from: b  reason: collision with root package name */
    final k.a.b<?> f14440b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f14441c;

    /* compiled from: FlowableSamplePublisher.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends c<T> {

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f14442f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f14443g;

        a(k.a.c<? super T> cVar, k.a.b<?> bVar) {
            super(cVar, bVar);
            this.f14442f = new AtomicInteger();
        }

        @Override // h.c.n0.e.b.g3.c
        void b() {
            this.f14443g = true;
            if (this.f14442f.getAndIncrement() == 0) {
                c();
                this.a.onComplete();
            }
        }

        @Override // h.c.n0.e.b.g3.c
        void e() {
            if (this.f14442f.getAndIncrement() == 0) {
                do {
                    boolean z = this.f14443g;
                    c();
                    if (z) {
                        this.a.onComplete();
                        return;
                    }
                } while (this.f14442f.decrementAndGet() != 0);
            }
        }
    }

    /* compiled from: FlowableSamplePublisher.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends c<T> {
        b(k.a.c<? super T> cVar, k.a.b<?> bVar) {
            super(cVar, bVar);
        }

        @Override // h.c.n0.e.b.g3.c
        void b() {
            this.a.onComplete();
        }

        @Override // h.c.n0.e.b.g3.c
        void e() {
            c();
        }
    }

    /* compiled from: FlowableSamplePublisher.java */
    /* loaded from: classes3.dex */
    static abstract class c<T> extends AtomicReference<T> implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final k.a.b<?> f14444b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicLong f14445c = new AtomicLong();

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<k.a.d> f14446d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        k.a.d f14447e;

        c(k.a.c<? super T> cVar, k.a.b<?> bVar) {
            this.a = cVar;
            this.f14444b = bVar;
        }

        public void a() {
            this.f14447e.cancel();
            b();
        }

        abstract void b();

        void c() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.f14445c.get() != 0) {
                    this.a.onNext(andSet);
                    h.c.n0.j.d.e(this.f14445c, 1L);
                    return;
                }
                cancel();
                this.a.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
            }
        }

        @Override // k.a.d
        public void cancel() {
            h.c.n0.i.g.h(this.f14446d);
            this.f14447e.cancel();
        }

        public void d(Throwable th) {
            this.f14447e.cancel();
            this.a.onError(th);
        }

        abstract void e();

        void f(k.a.d dVar) {
            h.c.n0.i.g.A(this.f14446d, dVar, Long.MAX_VALUE);
        }

        @Override // k.a.c
        public void onComplete() {
            h.c.n0.i.g.h(this.f14446d);
            b();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            h.c.n0.i.g.h(this.f14446d);
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14447e, dVar)) {
                this.f14447e = dVar;
                this.a.onSubscribe(this);
                if (this.f14446d.get() == null) {
                    this.f14444b.subscribe(new d(this));
                    dVar.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f14445c, j2);
            }
        }
    }

    /* compiled from: FlowableSamplePublisher.java */
    /* loaded from: classes3.dex */
    static final class d<T> implements h.c.m<Object> {
        final c<T> a;

        d(c<T> cVar) {
            this.a = cVar;
        }

        @Override // k.a.c
        public void onComplete() {
            this.a.a();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.d(th);
        }

        @Override // k.a.c
        public void onNext(Object obj) {
            this.a.e();
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            this.a.f(dVar);
        }
    }

    public g3(k.a.b<T> bVar, k.a.b<?> bVar2, boolean z) {
        this.a = bVar;
        this.f14440b = bVar2;
        this.f14441c = z;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        h.c.w0.d dVar = new h.c.w0.d(cVar);
        if (this.f14441c) {
            this.a.subscribe(new a(dVar, this.f14440b));
        } else {
            this.a.subscribe(new b(dVar, this.f14440b));
        }
    }
}