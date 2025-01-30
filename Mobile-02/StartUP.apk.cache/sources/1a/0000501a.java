package h.c.n0.h;

import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingBaseSubscriber.java */
/* loaded from: classes3.dex */
public abstract class c<T> extends CountDownLatch implements h.c.m<T> {
    T a;

    /* renamed from: b  reason: collision with root package name */
    Throwable f16715b;

    /* renamed from: c  reason: collision with root package name */
    k.a.d f16716c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f16717d;

    public c() {
        super(1);
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                h.c.n0.j.e.b();
                await();
            } catch (InterruptedException e2) {
                k.a.d dVar = this.f16716c;
                this.f16716c = h.c.n0.i.g.CANCELLED;
                if (dVar != null) {
                    dVar.cancel();
                }
                throw h.c.n0.j.j.e(e2);
            }
        }
        Throwable th = this.f16715b;
        if (th == null) {
            return this.a;
        }
        throw h.c.n0.j.j.e(th);
    }

    @Override // k.a.c
    public final void onComplete() {
        countDown();
    }

    @Override // h.c.m, k.a.c
    public final void onSubscribe(k.a.d dVar) {
        if (h.c.n0.i.g.C(this.f16716c, dVar)) {
            this.f16716c = dVar;
            if (this.f16717d) {
                return;
            }
            dVar.request(Long.MAX_VALUE);
            if (this.f16717d) {
                this.f16716c = h.c.n0.i.g.CANCELLED;
                dVar.cancel();
            }
        }
    }
}