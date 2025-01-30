package h.c.n0.h;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SubscriberResourceWrapper.java */
/* loaded from: classes3.dex */
public final class u<T> extends AtomicReference<h.c.k0.b> implements h.c.m<T>, h.c.k0.b, k.a.d {
    final k.a.c<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<k.a.d> f16753b = new AtomicReference<>();

    public u(k.a.c<? super T> cVar) {
        this.a = cVar;
    }

    public void a(h.c.k0.b bVar) {
        h.c.n0.a.c.y(this, bVar);
    }

    @Override // k.a.d
    public void cancel() {
        dispose();
    }

    @Override // h.c.k0.b
    public void dispose() {
        h.c.n0.i.g.h(this.f16753b);
        h.c.n0.a.c.h(this);
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return this.f16753b.get() == h.c.n0.i.g.CANCELLED;
    }

    @Override // k.a.c
    public void onComplete() {
        h.c.n0.a.c.h(this);
        this.a.onComplete();
    }

    @Override // k.a.c
    public void onError(Throwable th) {
        h.c.n0.a.c.h(this);
        this.a.onError(th);
    }

    @Override // k.a.c
    public void onNext(T t) {
        this.a.onNext(t);
    }

    @Override // h.c.m, k.a.c
    public void onSubscribe(k.a.d dVar) {
        if (h.c.n0.i.g.z(this.f16753b, dVar)) {
            this.a.onSubscribe(this);
        }
    }

    @Override // k.a.d
    public void request(long j2) {
        if (h.c.n0.i.g.B(j2)) {
            this.f16753b.get().request(j2);
        }
    }
}