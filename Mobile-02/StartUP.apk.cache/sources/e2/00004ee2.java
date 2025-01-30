package h.c.n0.e.e;

/* compiled from: ObservableDoOnLifecycle.java */
/* loaded from: classes3.dex */
public final class o0<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    private final h.c.m0.f<? super h.c.k0.b> f16020b;

    /* renamed from: c  reason: collision with root package name */
    private final h.c.m0.a f16021c;

    public o0(h.c.s<T> sVar, h.c.m0.f<? super h.c.k0.b> fVar, h.c.m0.a aVar) {
        super(sVar);
        this.f16020b = fVar;
        this.f16021c = aVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        this.a.subscribe(new h.c.n0.d.m(zVar, this.f16020b, this.f16021c));
    }
}