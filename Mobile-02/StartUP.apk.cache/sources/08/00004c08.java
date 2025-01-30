package h.c.n0.d;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BlockingObserver.java */
/* loaded from: classes.dex */
public final class i<T> extends AtomicReference<h.c.k0.b> implements h.c.z<T>, h.c.k0.b {
    public static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    final Queue<Object> f14122b;

    public i(Queue<Object> queue) {
        this.f14122b = queue;
    }

    @Override // h.c.k0.b
    public void dispose() {
        if (h.c.n0.a.c.h(this)) {
            this.f14122b.offer(a);
        }
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return get() == h.c.n0.a.c.DISPOSED;
    }

    @Override // h.c.z, k.a.c
    public void onComplete() {
        this.f14122b.offer(h.c.n0.j.m.y());
    }

    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        this.f14122b.offer(h.c.n0.j.m.A(th));
    }

    @Override // h.c.z, k.a.c
    public void onNext(T t) {
        this.f14122b.offer(h.c.n0.j.m.F(t));
    }

    @Override // h.c.z
    public void onSubscribe(h.c.k0.b bVar) {
        h.c.n0.a.c.z(this, bVar);
    }
}