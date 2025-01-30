package h.c.n0.h;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LambdaSubscriber.java */
/* loaded from: classes3.dex */
public final class l<T> extends AtomicReference<k.a.d> implements h.c.m<T>, k.a.d, h.c.k0.b {
    final h.c.m0.f<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.f<? super Throwable> f16736b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.a f16737c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.m0.f<? super k.a.d> f16738d;

    public l(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar, h.c.m0.f<? super k.a.d> fVar3) {
        this.a = fVar;
        this.f16736b = fVar2;
        this.f16737c = aVar;
        this.f16738d = fVar3;
    }

    @Override // k.a.d
    public void cancel() {
        h.c.n0.i.g.h(this);
    }

    @Override // h.c.k0.b
    public void dispose() {
        cancel();
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return get() == h.c.n0.i.g.CANCELLED;
    }

    @Override // k.a.c
    public void onComplete() {
        k.a.d dVar = get();
        h.c.n0.i.g gVar = h.c.n0.i.g.CANCELLED;
        if (dVar != gVar) {
            lazySet(gVar);
            try {
                this.f16737c.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.r0.a.u(th);
            }
        }
    }

    @Override // k.a.c
    public void onError(Throwable th) {
        k.a.d dVar = get();
        h.c.n0.i.g gVar = h.c.n0.i.g.CANCELLED;
        if (dVar != gVar) {
            lazySet(gVar);
            try {
                this.f16736b.accept(th);
                return;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                h.c.r0.a.u(new CompositeException(th, th2));
                return;
            }
        }
        h.c.r0.a.u(th);
    }

    @Override // k.a.c
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.a.accept(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            get().cancel();
            onError(th);
        }
    }

    @Override // h.c.m, k.a.c
    public void onSubscribe(k.a.d dVar) {
        if (h.c.n0.i.g.z(this, dVar)) {
            try {
                this.f16738d.accept(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                dVar.cancel();
                onError(th);
            }
        }
    }

    @Override // k.a.d
    public void request(long j2) {
        get().request(j2);
    }
}