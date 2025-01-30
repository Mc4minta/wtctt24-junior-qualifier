package h.c.n0.h;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BoundedSubscriber.java */
/* loaded from: classes3.dex */
public final class g<T> extends AtomicReference<k.a.d> implements h.c.m<T>, k.a.d, h.c.k0.b {
    final h.c.m0.f<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.f<? super Throwable> f16719b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.a f16720c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.m0.f<? super k.a.d> f16721d;

    /* renamed from: e  reason: collision with root package name */
    final int f16722e;

    /* renamed from: f  reason: collision with root package name */
    int f16723f;

    /* renamed from: g  reason: collision with root package name */
    final int f16724g;

    public g(h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar, h.c.m0.f<? super k.a.d> fVar3, int i2) {
        this.a = fVar;
        this.f16719b = fVar2;
        this.f16720c = aVar;
        this.f16721d = fVar3;
        this.f16722e = i2;
        this.f16724g = i2 - (i2 >> 2);
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
                this.f16720c.run();
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
                this.f16719b.accept(th);
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
            int i2 = this.f16723f + 1;
            if (i2 == this.f16724g) {
                this.f16723f = 0;
                get().request(this.f16724g);
            } else {
                this.f16723f = i2;
            }
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
                this.f16721d.accept(this);
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