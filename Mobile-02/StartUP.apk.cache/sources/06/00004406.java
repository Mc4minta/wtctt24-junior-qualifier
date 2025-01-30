package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AutoDisposingObserverImpl.java */
/* loaded from: classes2.dex */
final class o<T> extends AtomicInteger implements h.c.z, h.c.k0.b {
    final AtomicReference<h.c.k0.b> a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<h.c.k0.b> f11441b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    private final b f11442c = new b();

    /* renamed from: d  reason: collision with root package name */
    private final h.c.f f11443d;

    /* renamed from: e  reason: collision with root package name */
    private final h.c.z<? super T> f11444e;

    /* compiled from: AutoDisposingObserverImpl.java */
    /* loaded from: classes2.dex */
    class a extends h.c.p0.c {
        a() {
        }

        @Override // h.c.e
        public void onComplete() {
            o.this.f11441b.lazySet(c.DISPOSED);
            c.h(o.this.a);
        }

        @Override // h.c.e
        public void onError(Throwable th) {
            o.this.f11441b.lazySet(c.DISPOSED);
            o.this.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(h.c.f fVar, h.c.z<? super T> zVar) {
        this.f11443d = fVar;
        this.f11444e = zVar;
    }

    @Override // h.c.k0.b
    public void dispose() {
        c.h(this.f11441b);
        c.h(this.a);
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return this.a.get() == c.DISPOSED;
    }

    @Override // h.c.z, k.a.c
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        this.a.lazySet(c.DISPOSED);
        c.h(this.f11441b);
        v.a(this.f11444e, this, this.f11442c);
    }

    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        if (isDisposed()) {
            return;
        }
        this.a.lazySet(c.DISPOSED);
        c.h(this.f11441b);
        v.c(this.f11444e, th, this, this.f11442c);
    }

    @Override // h.c.z, k.a.c
    public void onNext(T t) {
        if (isDisposed() || !v.e(this.f11444e, t, this, this.f11442c)) {
            return;
        }
        this.a.lazySet(c.DISPOSED);
        c.h(this.f11441b);
    }

    @Override // h.c.z
    public void onSubscribe(h.c.k0.b bVar) {
        a aVar = new a();
        if (h.c(this.f11441b, aVar, o.class)) {
            this.f11444e.onSubscribe(this);
            this.f11443d.c(aVar);
            h.c(this.a, bVar, o.class);
        }
    }
}