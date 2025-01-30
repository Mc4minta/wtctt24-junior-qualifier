package h.c.p0;

import h.c.z;
import io.reactivex.exceptions.CompositeException;

/* compiled from: SafeObserver.java */
/* loaded from: classes3.dex */
public final class e<T> implements z<T>, h.c.k0.b {
    final z<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    h.c.k0.b f16786b;

    /* renamed from: c  reason: collision with root package name */
    boolean f16787c;

    public e(z<? super T> zVar) {
        this.a = zVar;
    }

    void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.a.onSubscribe(h.c.n0.a.d.INSTANCE);
            try {
                this.a.onError(nullPointerException);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.r0.a.u(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            h.c.r0.a.u(new CompositeException(nullPointerException, th2));
        }
    }

    void b() {
        this.f16787c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.a.onSubscribe(h.c.n0.a.d.INSTANCE);
            try {
                this.a.onError(nullPointerException);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.r0.a.u(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            h.c.r0.a.u(new CompositeException(nullPointerException, th2));
        }
    }

    @Override // h.c.k0.b
    public void dispose() {
        this.f16786b.dispose();
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return this.f16786b.isDisposed();
    }

    @Override // h.c.z, k.a.c
    public void onComplete() {
        if (this.f16787c) {
            return;
        }
        this.f16787c = true;
        if (this.f16786b == null) {
            a();
            return;
        }
        try {
            this.a.onComplete();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.r0.a.u(th);
        }
    }

    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        if (this.f16787c) {
            h.c.r0.a.u(th);
            return;
        }
        this.f16787c = true;
        if (this.f16786b == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.a.onSubscribe(h.c.n0.a.d.INSTANCE);
                try {
                    this.a.onError(new CompositeException(th, nullPointerException));
                    return;
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    h.c.r0.a.u(new CompositeException(th, nullPointerException, th2));
                    return;
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                h.c.r0.a.u(new CompositeException(th, nullPointerException, th3));
                return;
            }
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        try {
            this.a.onError(th);
        } catch (Throwable th4) {
            io.reactivex.exceptions.a.b(th4);
            h.c.r0.a.u(new CompositeException(th, th4));
        }
    }

    @Override // h.c.z, k.a.c
    public void onNext(T t) {
        if (this.f16787c) {
            return;
        }
        if (this.f16786b == null) {
            b();
        } else if (t == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f16786b.dispose();
                onError(nullPointerException);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                onError(new CompositeException(nullPointerException, th));
            }
        } else {
            try {
                this.a.onNext(t);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                try {
                    this.f16786b.dispose();
                    onError(th2);
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    onError(new CompositeException(th2, th3));
                }
            }
        }
    }

    @Override // h.c.z
    public void onSubscribe(h.c.k0.b bVar) {
        if (h.c.n0.a.c.B(this.f16786b, bVar)) {
            this.f16786b = bVar;
            try {
                this.a.onSubscribe(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f16787c = true;
                try {
                    bVar.dispose();
                    h.c.r0.a.u(th);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    h.c.r0.a.u(new CompositeException(th, th2));
                }
            }
        }
    }
}