package com.uber.autodispose;

import h.c.e0;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AutoDisposingSingleObserverImpl.java */
/* loaded from: classes2.dex */
final class p<T> implements e0, h.c.k0.b {
    final AtomicReference<h.c.k0.b> a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<h.c.k0.b> f11446b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    private final h.c.f f11447c;

    /* renamed from: d  reason: collision with root package name */
    private final e0<? super T> f11448d;

    /* compiled from: AutoDisposingSingleObserverImpl.java */
    /* loaded from: classes2.dex */
    class a extends h.c.p0.c {
        a() {
        }

        @Override // h.c.e
        public void onComplete() {
            p.this.f11446b.lazySet(c.DISPOSED);
            c.h(p.this.a);
        }

        @Override // h.c.e
        public void onError(Throwable th) {
            p.this.f11446b.lazySet(c.DISPOSED);
            p.this.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(h.c.f fVar, e0<? super T> e0Var) {
        this.f11447c = fVar;
        this.f11448d = e0Var;
    }

    @Override // h.c.k0.b
    public void dispose() {
        c.h(this.f11446b);
        c.h(this.a);
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return this.a.get() == c.DISPOSED;
    }

    @Override // h.c.e0
    public void onError(Throwable th) {
        if (isDisposed()) {
            return;
        }
        this.a.lazySet(c.DISPOSED);
        c.h(this.f11446b);
        this.f11448d.onError(th);
    }

    @Override // h.c.e0
    public void onSubscribe(h.c.k0.b bVar) {
        a aVar = new a();
        if (h.c(this.f11446b, aVar, p.class)) {
            this.f11448d.onSubscribe(this);
            this.f11447c.c(aVar);
            h.c(this.a, bVar, p.class);
        }
    }

    @Override // h.c.e0
    public void onSuccess(T t) {
        if (isDisposed()) {
            return;
        }
        this.a.lazySet(c.DISPOSED);
        c.h(this.f11446b);
        this.f11448d.onSuccess(t);
    }
}