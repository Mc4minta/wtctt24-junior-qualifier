package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObserverResourceWrapper.java */
/* loaded from: classes3.dex */
public final class m4<T> extends AtomicReference<h.c.k0.b> implements h.c.z<T>, h.c.k0.b {
    final h.c.z<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<h.c.k0.b> f15973b = new AtomicReference<>();

    public m4(h.c.z<? super T> zVar) {
        this.a = zVar;
    }

    public void a(h.c.k0.b bVar) {
        h.c.n0.a.c.y(this, bVar);
    }

    @Override // h.c.k0.b
    public void dispose() {
        h.c.n0.a.c.h(this.f15973b);
        h.c.n0.a.c.h(this);
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return this.f15973b.get() == h.c.n0.a.c.DISPOSED;
    }

    @Override // h.c.z, k.a.c
    public void onComplete() {
        dispose();
        this.a.onComplete();
    }

    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        dispose();
        this.a.onError(th);
    }

    @Override // h.c.z, k.a.c
    public void onNext(T t) {
        this.a.onNext(t);
    }

    @Override // h.c.z
    public void onSubscribe(h.c.k0.b bVar) {
        if (h.c.n0.a.c.z(this.f15973b, bVar)) {
            this.a.onSubscribe(this);
        }
    }
}