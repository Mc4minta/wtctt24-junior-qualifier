package h.c.n0.e.b;

import h.c.n0.e.b.a2;

/* compiled from: FlowableMapPublisher.java */
/* loaded from: classes3.dex */
public final class c2<T, U> extends h.c.h<U> {
    final k.a.b<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends U> f14254b;

    public c2(k.a.b<T> bVar, h.c.m0.n<? super T, ? extends U> nVar) {
        this.a = bVar;
        this.f14254b = nVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super U> cVar) {
        this.a.subscribe(new a2.b(cVar, this.f14254b));
    }
}