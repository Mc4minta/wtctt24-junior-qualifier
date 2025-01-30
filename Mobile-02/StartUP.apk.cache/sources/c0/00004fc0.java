package h.c.n0.e.g;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleResumeNext.java */
/* loaded from: classes3.dex */
public final class p0<T> extends h.c.b0<T> {
    final h.c.h0<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super Throwable, ? extends h.c.h0<? extends T>> f16546b;

    /* compiled from: SingleResumeNext.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<h.c.k0.b> implements h.c.e0<T>, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super Throwable, ? extends h.c.h0<? extends T>> f16547b;

        a(h.c.e0<? super T> e0Var, h.c.m0.n<? super Throwable, ? extends h.c.h0<? extends T>> nVar) {
            this.a = e0Var;
            this.f16547b = nVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            try {
                ((h.c.h0) h.c.n0.b.b.e(this.f16547b.apply(th), "The nextFunction returned a null SingleSource.")).subscribe(new h.c.n0.d.y(this, this.a));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.a.onError(new CompositeException(th, th2));
            }
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.z(this, bVar)) {
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            this.a.onSuccess(t);
        }
    }

    public p0(h.c.h0<? extends T> h0Var, h.c.m0.n<? super Throwable, ? extends h.c.h0<? extends T>> nVar) {
        this.a = h0Var;
        this.f16546b = nVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var, this.f16546b));
    }
}