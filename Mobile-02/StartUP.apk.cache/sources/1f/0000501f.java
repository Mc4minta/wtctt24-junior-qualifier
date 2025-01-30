package h.c.n0.h;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ForEachWhileSubscriber.java */
/* loaded from: classes3.dex */
public final class h<T> extends AtomicReference<k.a.d> implements h.c.m<T>, h.c.k0.b {
    final h.c.m0.p<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.f<? super Throwable> f16725b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.a f16726c;

    /* renamed from: d  reason: collision with root package name */
    boolean f16727d;

    public h(h.c.m0.p<? super T> pVar, h.c.m0.f<? super Throwable> fVar, h.c.m0.a aVar) {
        this.a = pVar;
        this.f16725b = fVar;
        this.f16726c = aVar;
    }

    @Override // h.c.k0.b
    public void dispose() {
        h.c.n0.i.g.h(this);
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return get() == h.c.n0.i.g.CANCELLED;
    }

    @Override // k.a.c
    public void onComplete() {
        if (this.f16727d) {
            return;
        }
        this.f16727d = true;
        try {
            this.f16726c.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.r0.a.u(th);
        }
    }

    @Override // k.a.c
    public void onError(Throwable th) {
        if (this.f16727d) {
            h.c.r0.a.u(th);
            return;
        }
        this.f16727d = true;
        try {
            this.f16725b.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            h.c.r0.a.u(new CompositeException(th, th2));
        }
    }

    @Override // k.a.c
    public void onNext(T t) {
        if (this.f16727d) {
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

    @Override // h.c.m, k.a.c
    public void onSubscribe(k.a.d dVar) {
        h.c.n0.i.g.A(this, dVar, Long.MAX_VALUE);
    }
}