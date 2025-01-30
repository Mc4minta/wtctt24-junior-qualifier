package h.c.n0.e.b;

import h.c.n0.e.b.w;

/* compiled from: FlowableConcatMapEagerPublisher.java */
/* loaded from: classes3.dex */
public final class x<T, R> extends h.c.h<R> {
    final k.a.b<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends k.a.b<? extends R>> f15200b;

    /* renamed from: c  reason: collision with root package name */
    final int f15201c;

    /* renamed from: d  reason: collision with root package name */
    final int f15202d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.n0.j.i f15203e;

    public x(k.a.b<T> bVar, h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2, int i3, h.c.n0.j.i iVar) {
        this.a = bVar;
        this.f15200b = nVar;
        this.f15201c = i2;
        this.f15202d = i3;
        this.f15203e = iVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        this.a.subscribe(new w.a(cVar, this.f15200b, this.f15201c, this.f15202d, this.f15203e));
    }
}