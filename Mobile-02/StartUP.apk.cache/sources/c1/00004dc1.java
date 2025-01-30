package h.c.n0.e.b;

/* compiled from: FlowableConcatMapPublisher.java */
/* loaded from: classes3.dex */
public final class y<T, R> extends h.c.h<R> {
    final k.a.b<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends k.a.b<? extends R>> f15229b;

    /* renamed from: c  reason: collision with root package name */
    final int f15230c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.n0.j.i f15231d;

    public y(k.a.b<T> bVar, h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar, int i2, h.c.n0.j.i iVar) {
        this.a = bVar;
        this.f15229b = nVar;
        this.f15230c = i2;
        this.f15231d = iVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        if (i3.b(this.a, cVar, this.f15229b)) {
            return;
        }
        this.a.subscribe(v.b(cVar, this.f15229b, this.f15230c, this.f15231d));
    }
}