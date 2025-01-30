package h.c.n0.h;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BlockingSubscriber.java */
/* loaded from: classes3.dex */
public final class f<T> extends AtomicReference<k.a.d> implements h.c.m<T>, k.a.d {
    public static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    final Queue<Object> f16718b;

    public f(Queue<Object> queue) {
        this.f16718b = queue;
    }

    public boolean a() {
        return get() == h.c.n0.i.g.CANCELLED;
    }

    @Override // k.a.d
    public void cancel() {
        if (h.c.n0.i.g.h(this)) {
            this.f16718b.offer(a);
        }
    }

    @Override // k.a.c
    public void onComplete() {
        this.f16718b.offer(h.c.n0.j.m.y());
    }

    @Override // k.a.c
    public void onError(Throwable th) {
        this.f16718b.offer(h.c.n0.j.m.A(th));
    }

    @Override // k.a.c
    public void onNext(T t) {
        this.f16718b.offer(h.c.n0.j.m.F(t));
    }

    @Override // h.c.m, k.a.c
    public void onSubscribe(k.a.d dVar) {
        if (h.c.n0.i.g.z(this, dVar)) {
            this.f16718b.offer(h.c.n0.j.m.G(this));
        }
    }

    @Override // k.a.d
    public void request(long j2) {
        get().request(j2);
    }
}