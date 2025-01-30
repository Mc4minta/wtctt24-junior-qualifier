package h.c.n0.d;

/* compiled from: DisposableLambdaObserver.java */
/* loaded from: classes.dex */
public final class m<T> implements h.c.z<T>, h.c.k0.b {
    final h.c.z<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.f<? super h.c.k0.b> f14126b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.a f14127c;

    /* renamed from: d  reason: collision with root package name */
    h.c.k0.b f14128d;

    public m(h.c.z<? super T> zVar, h.c.m0.f<? super h.c.k0.b> fVar, h.c.m0.a aVar) {
        this.a = zVar;
        this.f14126b = fVar;
        this.f14127c = aVar;
    }

    @Override // h.c.k0.b
    public void dispose() {
        h.c.k0.b bVar = this.f14128d;
        h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
        if (bVar != cVar) {
            this.f14128d = cVar;
            try {
                this.f14127c.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.r0.a.u(th);
            }
            bVar.dispose();
        }
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return this.f14128d.isDisposed();
    }

    @Override // h.c.z, k.a.c
    public void onComplete() {
        h.c.k0.b bVar = this.f14128d;
        h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
        if (bVar != cVar) {
            this.f14128d = cVar;
            this.a.onComplete();
        }
    }

    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        h.c.k0.b bVar = this.f14128d;
        h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
        if (bVar != cVar) {
            this.f14128d = cVar;
            this.a.onError(th);
            return;
        }
        h.c.r0.a.u(th);
    }

    @Override // h.c.z, k.a.c
    public void onNext(T t) {
        this.a.onNext(t);
    }

    @Override // h.c.z
    public void onSubscribe(h.c.k0.b bVar) {
        try {
            this.f14126b.accept(bVar);
            if (h.c.n0.a.c.B(this.f14128d, bVar)) {
                this.f14128d = bVar;
                this.a.onSubscribe(this);
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            bVar.dispose();
            this.f14128d = h.c.n0.a.c.DISPOSED;
            h.c.n0.a.d.y(th, this.a);
        }
    }
}