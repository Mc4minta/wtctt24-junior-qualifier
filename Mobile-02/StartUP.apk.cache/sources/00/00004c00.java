package h.c.n0.d;

/* compiled from: BasicFuseableObserver.java */
/* loaded from: classes.dex */
public abstract class a<T, R> implements h.c.z<T>, h.c.n0.c.e<R> {
    protected final h.c.z<? super R> a;

    /* renamed from: b  reason: collision with root package name */
    protected h.c.k0.b f14112b;

    /* renamed from: c  reason: collision with root package name */
    protected h.c.n0.c.e<T> f14113c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f14114d;

    /* renamed from: e  reason: collision with root package name */
    protected int f14115e;

    public a(h.c.z<? super R> zVar) {
        this.a = zVar;
    }

    protected void a() {
    }

    protected boolean b() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(Throwable th) {
        io.reactivex.exceptions.a.b(th);
        this.f14112b.dispose();
        onError(th);
    }

    @Override // h.c.n0.c.j
    public void clear() {
        this.f14113c.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int d(int i2) {
        h.c.n0.c.e<T> eVar = this.f14113c;
        if (eVar == null || (i2 & 4) != 0) {
            return 0;
        }
        int n = eVar.n(i2);
        if (n != 0) {
            this.f14115e = n;
        }
        return n;
    }

    @Override // h.c.k0.b
    public void dispose() {
        this.f14112b.dispose();
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return this.f14112b.isDisposed();
    }

    @Override // h.c.n0.c.j
    public boolean isEmpty() {
        return this.f14113c.isEmpty();
    }

    @Override // h.c.n0.c.j
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // h.c.z, k.a.c
    public void onComplete() {
        if (this.f14114d) {
            return;
        }
        this.f14114d = true;
        this.a.onComplete();
    }

    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        if (this.f14114d) {
            h.c.r0.a.u(th);
            return;
        }
        this.f14114d = true;
        this.a.onError(th);
    }

    @Override // h.c.z
    public final void onSubscribe(h.c.k0.b bVar) {
        if (h.c.n0.a.c.B(this.f14112b, bVar)) {
            this.f14112b = bVar;
            if (bVar instanceof h.c.n0.c.e) {
                this.f14113c = (h.c.n0.c.e) bVar;
            }
            if (b()) {
                this.a.onSubscribe(this);
                a();
            }
        }
    }
}