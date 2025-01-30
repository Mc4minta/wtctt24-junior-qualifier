package h.c.w0;

import h.c.m;
import h.c.n0.i.g;
import io.reactivex.exceptions.CompositeException;

/* compiled from: SafeSubscriber.java */
/* loaded from: classes3.dex */
public final class c<T> implements m<T>, k.a.d {
    final k.a.c<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    k.a.d f16879b;

    /* renamed from: c  reason: collision with root package name */
    boolean f16880c;

    public c(k.a.c<? super T> cVar) {
        this.a = cVar;
    }

    void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.a.onSubscribe(h.c.n0.i.d.INSTANCE);
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
        this.f16880c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.a.onSubscribe(h.c.n0.i.d.INSTANCE);
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

    @Override // k.a.d
    public void cancel() {
        try {
            this.f16879b.cancel();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.r0.a.u(th);
        }
    }

    @Override // k.a.c
    public void onComplete() {
        if (this.f16880c) {
            return;
        }
        this.f16880c = true;
        if (this.f16879b == null) {
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

    @Override // k.a.c
    public void onError(Throwable th) {
        if (this.f16880c) {
            h.c.r0.a.u(th);
            return;
        }
        this.f16880c = true;
        if (this.f16879b == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.a.onSubscribe(h.c.n0.i.d.INSTANCE);
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

    @Override // k.a.c
    public void onNext(T t) {
        if (this.f16880c) {
            return;
        }
        if (this.f16879b == null) {
            b();
        } else if (t == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f16879b.cancel();
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
                    this.f16879b.cancel();
                    onError(th2);
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    onError(new CompositeException(th2, th3));
                }
            }
        }
    }

    @Override // h.c.m, k.a.c
    public void onSubscribe(k.a.d dVar) {
        if (g.C(this.f16879b, dVar)) {
            this.f16879b = dVar;
            try {
                this.a.onSubscribe(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f16880c = true;
                try {
                    dVar.cancel();
                    h.c.r0.a.u(th);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    h.c.r0.a.u(new CompositeException(th, th2));
                }
            }
        }
    }

    @Override // k.a.d
    public void request(long j2) {
        try {
            this.f16879b.request(j2);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            try {
                this.f16879b.cancel();
                h.c.r0.a.u(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                h.c.r0.a.u(new CompositeException(th, th2));
            }
        }
    }
}