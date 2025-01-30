package h.c.n0.d;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ForEachWhileObserver.java */
/* loaded from: classes.dex */
public final class o<T> extends AtomicReference<h.c.k0.b> implements h.c.z<T>, h.c.k0.b {
    final h.c.m0.p<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.f<? super Throwable> f14129b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.a f14130c;

    /* renamed from: d  reason: collision with root package name */
    boolean f14131d;

    public o(h.c.m0.p<? super T> pVar, h.c.m0.f<? super Throwable> fVar, h.c.m0.a aVar) {
        this.a = pVar;
        this.f14129b = fVar;
        this.f14130c = aVar;
    }

    @Override // h.c.k0.b
    public void dispose() {
        h.c.n0.a.c.h(this);
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return h.c.n0.a.c.n(get());
    }

    @Override // h.c.z, k.a.c
    public void onComplete() {
        if (this.f14131d) {
            return;
        }
        this.f14131d = true;
        try {
            this.f14130c.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.r0.a.u(th);
        }
    }

    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        if (this.f14131d) {
            h.c.r0.a.u(th);
            return;
        }
        this.f14131d = true;
        try {
            this.f14129b.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            h.c.r0.a.u(new CompositeException(th, th2));
        }
    }

    @Override // h.c.z, k.a.c
    public void onNext(T t) {
        if (this.f14131d) {
            return;
        }
        try {
            if (this.a.test(t)) {
                return;
            }
            dispose();
            onComplete();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            dispose();
            onError(th);
        }
    }

    @Override // h.c.z
    public void onSubscribe(h.c.k0.b bVar) {
        h.c.n0.a.c.z(this, bVar);
    }
}