package h.c.n0.e.g;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleUsing.java */
/* loaded from: classes3.dex */
public final class x0<T, U> extends h.c.b0<T> {
    final Callable<U> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super U, ? extends h.c.h0<? extends T>> f16588b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.f<? super U> f16589c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f16590d;

    /* compiled from: SingleUsing.java */
    /* loaded from: classes3.dex */
    static final class a<T, U> extends AtomicReference<Object> implements h.c.e0<T>, h.c.k0.b {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.f<? super U> f16591b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f16592c;

        /* renamed from: d  reason: collision with root package name */
        h.c.k0.b f16593d;

        a(h.c.e0<? super T> e0Var, U u, boolean z, h.c.m0.f<? super U> fVar) {
            super(u);
            this.a = e0Var;
            this.f16592c = z;
            this.f16591b = fVar;
        }

        void a() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f16591b.accept(andSet);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    h.c.r0.a.u(th);
                }
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16593d.dispose();
            this.f16593d = h.c.n0.a.c.DISPOSED;
            a();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16593d.isDisposed();
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            this.f16593d = h.c.n0.a.c.DISPOSED;
            if (this.f16592c) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.f16591b.accept(andSet);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    th = new CompositeException(th, th2);
                }
            }
            this.a.onError(th);
            if (this.f16592c) {
                return;
            }
            a();
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16593d, bVar)) {
                this.f16593d = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            this.f16593d = h.c.n0.a.c.DISPOSED;
            if (this.f16592c) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.f16591b.accept(andSet);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.a.onError(th);
                    return;
                }
            }
            this.a.onSuccess(t);
            if (this.f16592c) {
                return;
            }
            a();
        }
    }

    public x0(Callable<U> callable, h.c.m0.n<? super U, ? extends h.c.h0<? extends T>> nVar, h.c.m0.f<? super U> fVar, boolean z) {
        this.a = callable;
        this.f16588b = nVar;
        this.f16589c = fVar;
        this.f16590d = z;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        try {
            U call = this.a.call();
            try {
                ((h.c.h0) h.c.n0.b.b.e(this.f16588b.apply(call), "The singleFunction returned a null SingleSource")).subscribe(new a(e0Var, call, this.f16590d, this.f16589c));
            } catch (Throwable th) {
                th = th;
                io.reactivex.exceptions.a.b(th);
                if (this.f16590d) {
                    try {
                        this.f16589c.accept(call);
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                h.c.n0.a.d.z(th, e0Var);
                if (this.f16590d) {
                    return;
                }
                try {
                    this.f16589c.accept(call);
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    h.c.r0.a.u(th3);
                }
            }
        } catch (Throwable th4) {
            io.reactivex.exceptions.a.b(th4);
            h.c.n0.a.d.z(th4, e0Var);
        }
    }
}