package e.f.j.l;

/* compiled from: DelegatingConsumer.java */
/* loaded from: classes2.dex */
public abstract class n<I, O> extends b<I> {

    /* renamed from: b  reason: collision with root package name */
    private final k<O> f12690b;

    public n(k<O> kVar) {
        this.f12690b = kVar;
    }

    @Override // e.f.j.l.b
    protected void f() {
        this.f12690b.a();
    }

    @Override // e.f.j.l.b
    protected void g(Throwable th) {
        this.f12690b.onFailure(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.j.l.b
    public void i(float f2) {
        this.f12690b.b(f2);
    }

    public k<O> o() {
        return this.f12690b;
    }
}