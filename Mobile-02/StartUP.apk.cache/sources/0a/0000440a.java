package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AutoDisposingSubscriberImpl.java */
/* loaded from: classes2.dex */
final class q<T> extends AtomicInteger implements h.c.m, k.a.d, h.c.k0.b {
    final AtomicReference<k.a.d> a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<h.c.k0.b> f11450b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    private final b f11451c = new b();

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReference<k.a.d> f11452d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    private final AtomicLong f11453e = new AtomicLong();

    /* renamed from: f  reason: collision with root package name */
    private final h.c.f f11454f;

    /* renamed from: g  reason: collision with root package name */
    private final k.a.c<? super T> f11455g;

    /* compiled from: AutoDisposingSubscriberImpl.java */
    /* loaded from: classes2.dex */
    class a extends h.c.p0.c {
        a() {
        }

        @Override // h.c.e
        public void onComplete() {
            q.this.f11450b.lazySet(c.DISPOSED);
            r.h(q.this.a);
        }

        @Override // h.c.e
        public void onError(Throwable th) {
            q.this.f11450b.lazySet(c.DISPOSED);
            q.this.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(h.c.f fVar, k.a.c<? super T> cVar) {
        this.f11454f = fVar;
        this.f11455g = cVar;
    }

    @Override // k.a.d
    public void cancel() {
        c.h(this.f11450b);
        r.h(this.a);
    }

    @Override // h.c.k0.b
    public void dispose() {
        cancel();
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return this.a.get() == r.CANCELLED;
    }

    @Override // k.a.c
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        this.a.lazySet(r.CANCELLED);
        c.h(this.f11450b);
        v.b(this.f11455g, this, this.f11451c);
    }

    @Override // k.a.c
    public void onError(Throwable th) {
        if (isDisposed()) {
            return;
        }
        this.a.lazySet(r.CANCELLED);
        c.h(this.f11450b);
        v.d(this.f11455g, th, this, this.f11451c);
    }

    @Override // k.a.c
    public void onNext(T t) {
        if (isDisposed() || !v.f(this.f11455g, t, this, this.f11451c)) {
            return;
        }
        this.a.lazySet(r.CANCELLED);
        c.h(this.f11450b);
    }

    @Override // h.c.m, k.a.c
    public void onSubscribe(k.a.d dVar) {
        a aVar = new a();
        if (h.c(this.f11450b, aVar, q.class)) {
            this.f11455g.onSubscribe(this);
            this.f11454f.c(aVar);
            if (h.d(this.a, dVar, q.class)) {
                r.q(this.f11452d, this.f11453e, dVar);
            }
        }
    }

    @Override // k.a.d
    public void request(long j2) {
        r.n(this.f11452d, this.f11453e, j2);
    }
}