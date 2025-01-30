package h.c.n0.h;

import io.reactivex.exceptions.MissingBackpressureException;

/* compiled from: QueueDrainSubscriber.java */
/* loaded from: classes3.dex */
public abstract class m<T, U, V> extends q implements h.c.m<T>, h.c.n0.j.q<U, V> {

    /* renamed from: c  reason: collision with root package name */
    protected final k.a.c<? super V> f16739c;

    /* renamed from: d  reason: collision with root package name */
    protected final h.c.n0.c.i<U> f16740d;

    /* renamed from: e  reason: collision with root package name */
    protected volatile boolean f16741e;

    /* renamed from: f  reason: collision with root package name */
    protected volatile boolean f16742f;

    /* renamed from: g  reason: collision with root package name */
    protected Throwable f16743g;

    public m(k.a.c<? super V> cVar, h.c.n0.c.i<U> iVar) {
        this.f16739c = cVar;
        this.f16740d = iVar;
    }

    @Override // h.c.n0.j.q
    public final boolean a() {
        return this.f16742f;
    }

    @Override // h.c.n0.j.q
    public final Throwable b() {
        return this.f16743g;
    }

    @Override // h.c.n0.j.q
    public final int c(int i2) {
        return this.a.addAndGet(i2);
    }

    @Override // h.c.n0.j.q
    public final boolean cancelled() {
        return this.f16741e;
    }

    @Override // h.c.n0.j.q
    public final long d() {
        return this.f16744b.get();
    }

    public boolean e(k.a.c<? super V> cVar, U u) {
        return false;
    }

    @Override // h.c.n0.j.q
    public final long f(long j2) {
        return this.f16744b.addAndGet(-j2);
    }

    public final boolean g() {
        return this.a.getAndIncrement() == 0;
    }

    public final boolean i() {
        return this.a.get() == 0 && this.a.compareAndSet(0, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j(U u, boolean z, h.c.k0.b bVar) {
        k.a.c<? super V> cVar = this.f16739c;
        h.c.n0.c.i<U> iVar = this.f16740d;
        if (i()) {
            long j2 = this.f16744b.get();
            if (j2 != 0) {
                if (e(cVar, u) && j2 != Long.MAX_VALUE) {
                    f(1L);
                }
                if (c(-1) == 0) {
                    return;
                }
            } else {
                bVar.dispose();
                cVar.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            }
        } else {
            iVar.offer(u);
            if (!g()) {
                return;
            }
        }
        h.c.n0.j.r.e(iVar, cVar, z, bVar, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k(U u, boolean z, h.c.k0.b bVar) {
        k.a.c<? super V> cVar = this.f16739c;
        h.c.n0.c.i<U> iVar = this.f16740d;
        if (i()) {
            long j2 = this.f16744b.get();
            if (j2 != 0) {
                if (iVar.isEmpty()) {
                    if (e(cVar, u) && j2 != Long.MAX_VALUE) {
                        f(1L);
                    }
                    if (c(-1) == 0) {
                        return;
                    }
                } else {
                    iVar.offer(u);
                }
            } else {
                this.f16741e = true;
                bVar.dispose();
                cVar.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            }
        } else {
            iVar.offer(u);
            if (!g()) {
                return;
            }
        }
        h.c.n0.j.r.e(iVar, cVar, z, bVar, this);
    }

    public final void l(long j2) {
        if (h.c.n0.i.g.B(j2)) {
            h.c.n0.j.d.a(this.f16744b, j2);
        }
    }
}