package h.c.n0.d;

/* compiled from: QueueDrainObserver.java */
/* loaded from: classes.dex */
public abstract class u<T, U, V> extends w implements h.c.z<T>, h.c.n0.j.n<U, V> {

    /* renamed from: b  reason: collision with root package name */
    protected final h.c.z<? super V> f14143b;

    /* renamed from: c  reason: collision with root package name */
    protected final h.c.n0.c.i<U> f14144c;

    /* renamed from: d  reason: collision with root package name */
    protected volatile boolean f14145d;

    /* renamed from: e  reason: collision with root package name */
    protected volatile boolean f14146e;

    /* renamed from: f  reason: collision with root package name */
    protected Throwable f14147f;

    public u(h.c.z<? super V> zVar, h.c.n0.c.i<U> iVar) {
        this.f14143b = zVar;
        this.f14144c = iVar;
    }

    @Override // h.c.n0.j.n
    public final boolean a() {
        return this.f14146e;
    }

    @Override // h.c.n0.j.n
    public final Throwable b() {
        return this.f14147f;
    }

    @Override // h.c.n0.j.n
    public final int c(int i2) {
        return this.a.addAndGet(i2);
    }

    @Override // h.c.n0.j.n
    public final boolean cancelled() {
        return this.f14145d;
    }

    @Override // h.c.n0.j.n
    public void d(h.c.z<? super V> zVar, U u) {
    }

    public final boolean e() {
        return this.a.getAndIncrement() == 0;
    }

    public final boolean f() {
        return this.a.get() == 0 && this.a.compareAndSet(0, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(U u, boolean z, h.c.k0.b bVar) {
        h.c.z<? super V> zVar = this.f14143b;
        h.c.n0.c.i<U> iVar = this.f14144c;
        if (this.a.get() == 0 && this.a.compareAndSet(0, 1)) {
            d(zVar, u);
            if (c(-1) == 0) {
                return;
            }
        } else {
            iVar.offer(u);
            if (!e()) {
                return;
            }
        }
        h.c.n0.j.r.d(iVar, zVar, z, bVar, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(U u, boolean z, h.c.k0.b bVar) {
        h.c.z<? super V> zVar = this.f14143b;
        h.c.n0.c.i<U> iVar = this.f14144c;
        if (this.a.get() == 0 && this.a.compareAndSet(0, 1)) {
            if (iVar.isEmpty()) {
                d(zVar, u);
                if (c(-1) == 0) {
                    return;
                }
            } else {
                iVar.offer(u);
            }
        } else {
            iVar.offer(u);
            if (!e()) {
                return;
            }
        }
        h.c.n0.j.r.d(iVar, zVar, z, bVar, this);
    }
}