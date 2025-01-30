package h.c.n0.d;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CallbackCompletableObserver.java */
/* loaded from: classes.dex */
public final class j extends AtomicReference<h.c.k0.b> implements h.c.e, h.c.k0.b, h.c.m0.f<Throwable> {
    final h.c.m0.f<? super Throwable> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.a f14123b;

    public j(h.c.m0.a aVar) {
        this.a = this;
        this.f14123b = aVar;
    }

    @Override // h.c.m0.f
    /* renamed from: a */
    public void accept(Throwable th) {
        h.c.r0.a.u(new OnErrorNotImplementedException(th));
    }

    @Override // h.c.k0.b
    public void dispose() {
        h.c.n0.a.c.h(this);
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return get() == h.c.n0.a.c.DISPOSED;
    }

    @Override // h.c.e
    public void onComplete() {
        try {
            this.f14123b.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.r0.a.u(th);
        }
        lazySet(h.c.n0.a.c.DISPOSED);
    }

    @Override // h.c.e
    public void onError(Throwable th) {
        try {
            this.a.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            h.c.r0.a.u(th2);
        }
        lazySet(h.c.n0.a.c.DISPOSED);
    }

    @Override // h.c.e
    public void onSubscribe(h.c.k0.b bVar) {
        h.c.n0.a.c.z(this, bVar);
    }

    public j(h.c.m0.f<? super Throwable> fVar, h.c.m0.a aVar) {
        this.a = fVar;
        this.f14123b = aVar;
    }
}