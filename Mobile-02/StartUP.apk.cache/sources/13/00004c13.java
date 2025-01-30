package h.c.n0.d;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LambdaObserver.java */
/* loaded from: classes.dex */
public final class t<T> extends AtomicReference<h.c.k0.b> implements h.c.z<T>, h.c.k0.b {
    final h.c.m0.f<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.f<? super Throwable> f14140b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.a f14141c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.m0.f<? super h.c.k0.b> f14142d;

    public t(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar, h.c.m0.f<? super h.c.k0.b> fVar3) {
        this.a = fVar;
        this.f14140b = fVar2;
        this.f14141c = aVar;
        this.f14142d = fVar3;
    }

    @Override // h.c.k0.b
    public void dispose() {
        h.c.n0.a.c.h(this);
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return get() == h.c.n0.a.c.DISPOSED;
    }

    @Override // h.c.z, k.a.c
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(h.c.n0.a.c.DISPOSED);
        try {
            this.f14141c.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.r0.a.u(th);
        }
    }

    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        if (!isDisposed()) {
            lazySet(h.c.n0.a.c.DISPOSED);
            try {
                this.f14140b.accept(th);
                return;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                h.c.r0.a.u(new CompositeException(th, th2));
                return;
            }
        }
        h.c.r0.a.u(th);
    }

    @Override // h.c.z, k.a.c
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.a.accept(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // h.c.z
    public void onSubscribe(h.c.k0.b bVar) {
        if (h.c.n0.a.c.z(this, bVar)) {
            try {
                this.f14142d.accept(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                bVar.dispose();
                onError(th);
            }
        }
    }
}