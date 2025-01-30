package h.c.n0.d;

import h.c.e0;
import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingMultiObserver.java */
/* loaded from: classes.dex */
public final class h<T> extends CountDownLatch implements e0<T>, h.c.e, h.c.p<T> {
    T a;

    /* renamed from: b  reason: collision with root package name */
    Throwable f14119b;

    /* renamed from: c  reason: collision with root package name */
    h.c.k0.b f14120c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f14121d;

    public h() {
        super(1);
    }

    public T a() {
        if (getCount() != 0) {
            try {
                h.c.n0.j.e.b();
                await();
            } catch (InterruptedException e2) {
                b();
                throw h.c.n0.j.j.e(e2);
            }
        }
        Throwable th = this.f14119b;
        if (th == null) {
            return this.a;
        }
        throw h.c.n0.j.j.e(th);
    }

    void b() {
        this.f14121d = true;
        h.c.k0.b bVar = this.f14120c;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    @Override // h.c.e
    public void onComplete() {
        countDown();
    }

    @Override // h.c.e0
    public void onError(Throwable th) {
        this.f14119b = th;
        countDown();
    }

    @Override // h.c.e0
    public void onSubscribe(h.c.k0.b bVar) {
        this.f14120c = bVar;
        if (this.f14121d) {
            bVar.dispose();
        }
    }

    @Override // h.c.e0
    public void onSuccess(T t) {
        this.a = t;
        countDown();
    }
}