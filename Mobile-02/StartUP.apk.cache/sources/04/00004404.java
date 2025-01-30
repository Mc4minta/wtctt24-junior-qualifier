package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AutoDisposingCompletableObserverImpl.java */
/* loaded from: classes2.dex */
final class n implements h.c.e, h.c.k0.b {
    final AtomicReference<h.c.k0.b> a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<h.c.k0.b> f11437b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    private final h.c.f f11438c;

    /* renamed from: d  reason: collision with root package name */
    private final h.c.e f11439d;

    /* compiled from: AutoDisposingCompletableObserverImpl.java */
    /* loaded from: classes2.dex */
    class a extends h.c.p0.c {
        a() {
        }

        @Override // h.c.e
        public void onComplete() {
            n.this.f11437b.lazySet(c.DISPOSED);
            c.h(n.this.a);
        }

        @Override // h.c.e
        public void onError(Throwable th) {
            n.this.f11437b.lazySet(c.DISPOSED);
            n.this.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(h.c.f fVar, h.c.e eVar) {
        this.f11438c = fVar;
        this.f11439d = eVar;
    }

    @Override // h.c.k0.b
    public void dispose() {
        c.h(this.f11437b);
        c.h(this.a);
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return this.a.get() == c.DISPOSED;
    }

    @Override // h.c.e
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        this.a.lazySet(c.DISPOSED);
        c.h(this.f11437b);
        this.f11439d.onComplete();
    }

    @Override // h.c.e
    public void onError(Throwable th) {
        if (isDisposed()) {
            return;
        }
        this.a.lazySet(c.DISPOSED);
        c.h(this.f11437b);
        this.f11439d.onError(th);
    }

    @Override // h.c.e
    public void onSubscribe(h.c.k0.b bVar) {
        a aVar = new a();
        if (h.c(this.f11437b, aVar, n.class)) {
            this.f11439d.onSubscribe(this);
            this.f11438c.c(aVar);
            h.c(this.a, bVar, n.class);
        }
    }
}