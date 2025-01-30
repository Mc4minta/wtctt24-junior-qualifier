package h.c.n0.e.b;

/* compiled from: FlowableFlatMapPublisher.java */
/* loaded from: classes3.dex */
public final class c1<T, U> extends h.c.h<U> {
    final k.a.b<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends k.a.b<? extends U>> f14250b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f14251c;

    /* renamed from: d  reason: collision with root package name */
    final int f14252d;

    /* renamed from: e  reason: collision with root package name */
    final int f14253e;

    public c1(k.a.b<T> bVar, h.c.m0.n<? super T, ? extends k.a.b<? extends U>> nVar, boolean z, int i2, int i3) {
        this.a = bVar;
        this.f14250b = nVar;
        this.f14251c = z;
        this.f14252d = i2;
        this.f14253e = i3;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super U> cVar) {
        if (i3.b(this.a, cVar, this.f14250b)) {
            return;
        }
        this.a.subscribe(y0.b(cVar, this.f14250b, this.f14251c, this.f14252d, this.f14253e));
    }
}