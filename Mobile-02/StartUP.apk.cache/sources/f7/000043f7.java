package com.uber.autodispose;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoDisposeFlowable.java */
/* loaded from: classes2.dex */
public final class i<T> extends h.c.h<T> implements u<T> {
    private final k.a.b<T> a;

    /* renamed from: b  reason: collision with root package name */
    private final h.c.f f11431b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(k.a.b<T> bVar, h.c.f fVar) {
        this.a = bVar;
        this.f11431b = fVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe(new q(this.f11431b, cVar));
    }
}