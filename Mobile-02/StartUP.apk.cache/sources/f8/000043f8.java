package com.uber.autodispose;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoDisposeObservable.java */
/* loaded from: classes2.dex */
public final class j<T> extends h.c.s<T> implements x<T> {
    private final h.c.x<T> a;

    /* renamed from: b  reason: collision with root package name */
    private final h.c.f f11432b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h.c.x<T> xVar, h.c.f fVar) {
        this.a = xVar;
        this.f11432b = fVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new o(this.f11432b, zVar));
    }
}