package h.c.n0.d;

import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingBaseObserver.java */
/* loaded from: classes.dex */
public abstract class e<T> extends CountDownLatch implements h.c.z<T>, h.c.k0.b {
    T a;

    /* renamed from: b  reason: collision with root package name */
    Throwable f14116b;

    /* renamed from: c  reason: collision with root package name */
    h.c.k0.b f14117c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f14118d;

    public e() {
        super(1);
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                h.c.n0.j.e.b();
                await();
            } catch (InterruptedException e2) {
                dispose();
                throw h.c.n0.j.j.e(e2);
            }
        }
        Throwable th = this.f14116b;
        if (th == null) {
            return this.a;
        }
        throw h.c.n0.j.j.e(th);
    }

    @Override // h.c.k0.b
    public final void dispose() {
        this.f14118d = true;
        h.c.k0.b bVar = this.f14117c;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    @Override // h.c.k0.b
    public final boolean isDisposed() {
        return this.f14118d;
    }

    @Override // h.c.z, k.a.c
    public final void onComplete() {
        countDown();
    }

    @Override // h.c.z
    public final void onSubscribe(h.c.k0.b bVar) {
        this.f14117c = bVar;
        if (this.f14118d) {
            bVar.dispose();
        }
    }
}