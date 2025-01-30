package h.c.n0.d;

/* compiled from: SubscriberCompletableObserver.java */
/* loaded from: classes.dex */
public final class z<T> implements h.c.e, k.a.d {
    final k.a.c<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    h.c.k0.b f14149b;

    public z(k.a.c<? super T> cVar) {
        this.a = cVar;
    }

    @Override // k.a.d
    public void cancel() {
        this.f14149b.dispose();
    }

    @Override // h.c.e
    public void onComplete() {
        this.a.onComplete();
    }

    @Override // h.c.e
    public void onError(Throwable th) {
        this.a.onError(th);
    }

    @Override // h.c.e
    public void onSubscribe(h.c.k0.b bVar) {
        if (h.c.n0.a.c.B(this.f14149b, bVar)) {
            this.f14149b = bVar;
            this.a.onSubscribe(this);
        }
    }

    @Override // k.a.d
    public void request(long j2) {
    }
}