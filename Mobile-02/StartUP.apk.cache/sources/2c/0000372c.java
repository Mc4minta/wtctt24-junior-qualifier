package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b0<TResult> extends g<TResult> {
    private final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final z<TResult> f7983b = new z<>();

    /* renamed from: c  reason: collision with root package name */
    private boolean f7984c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f7985d;

    /* renamed from: e  reason: collision with root package name */
    private TResult f7986e;

    /* renamed from: f  reason: collision with root package name */
    private Exception f7987f;

    private final void A() {
        if (this.f7985d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void B() {
        synchronized (this.a) {
            if (this.f7984c) {
                this.f7983b.a(this);
            }
        }
    }

    private final void y() {
        com.google.android.gms.common.internal.t.o(this.f7984c, "Task is not yet complete");
    }

    private final void z() {
        com.google.android.gms.common.internal.t.o(!this.f7984c, "Task is already complete");
    }

    @Override // com.google.android.gms.tasks.g
    public final g<TResult> a(Executor executor, b bVar) {
        this.f7983b.b(new o(executor, bVar));
        B();
        return this;
    }

    @Override // com.google.android.gms.tasks.g
    public final g<TResult> b(c<TResult> cVar) {
        return c(i.a, cVar);
    }

    @Override // com.google.android.gms.tasks.g
    public final g<TResult> c(Executor executor, c<TResult> cVar) {
        this.f7983b.b(new q(executor, cVar));
        B();
        return this;
    }

    @Override // com.google.android.gms.tasks.g
    public final g<TResult> d(d dVar) {
        return e(i.a, dVar);
    }

    @Override // com.google.android.gms.tasks.g
    public final g<TResult> e(Executor executor, d dVar) {
        this.f7983b.b(new s(executor, dVar));
        B();
        return this;
    }

    @Override // com.google.android.gms.tasks.g
    public final g<TResult> f(e<? super TResult> eVar) {
        return g(i.a, eVar);
    }

    @Override // com.google.android.gms.tasks.g
    public final g<TResult> g(Executor executor, e<? super TResult> eVar) {
        this.f7983b.b(new u(executor, eVar));
        B();
        return this;
    }

    @Override // com.google.android.gms.tasks.g
    public final <TContinuationResult> g<TContinuationResult> h(a<TResult, TContinuationResult> aVar) {
        return i(i.a, aVar);
    }

    @Override // com.google.android.gms.tasks.g
    public final <TContinuationResult> g<TContinuationResult> i(Executor executor, a<TResult, TContinuationResult> aVar) {
        b0 b0Var = new b0();
        this.f7983b.b(new k(executor, aVar, b0Var));
        B();
        return b0Var;
    }

    @Override // com.google.android.gms.tasks.g
    public final <TContinuationResult> g<TContinuationResult> j(a<TResult, g<TContinuationResult>> aVar) {
        return k(i.a, aVar);
    }

    @Override // com.google.android.gms.tasks.g
    public final <TContinuationResult> g<TContinuationResult> k(Executor executor, a<TResult, g<TContinuationResult>> aVar) {
        b0 b0Var = new b0();
        this.f7983b.b(new m(executor, aVar, b0Var));
        B();
        return b0Var;
    }

    @Override // com.google.android.gms.tasks.g
    public final Exception l() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f7987f;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.g
    public final TResult m() {
        TResult tresult;
        synchronized (this.a) {
            y();
            A();
            if (this.f7987f == null) {
                tresult = this.f7986e;
            } else {
                throw new RuntimeExecutionException(this.f7987f);
            }
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.g
    public final <X extends Throwable> TResult n(Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.a) {
            y();
            A();
            if (!cls.isInstance(this.f7987f)) {
                if (this.f7987f == null) {
                    tresult = this.f7986e;
                } else {
                    throw new RuntimeExecutionException(this.f7987f);
                }
            } else {
                throw cls.cast(this.f7987f);
            }
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.g
    public final boolean o() {
        return this.f7985d;
    }

    @Override // com.google.android.gms.tasks.g
    public final boolean p() {
        boolean z;
        synchronized (this.a) {
            z = this.f7984c;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.g
    public final boolean q() {
        boolean z;
        synchronized (this.a) {
            z = this.f7984c && !this.f7985d && this.f7987f == null;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.g
    public final <TContinuationResult> g<TContinuationResult> r(f<TResult, TContinuationResult> fVar) {
        return s(i.a, fVar);
    }

    @Override // com.google.android.gms.tasks.g
    public final <TContinuationResult> g<TContinuationResult> s(Executor executor, f<TResult, TContinuationResult> fVar) {
        b0 b0Var = new b0();
        this.f7983b.b(new w(executor, fVar, b0Var));
        B();
        return b0Var;
    }

    public final void t(Exception exc) {
        com.google.android.gms.common.internal.t.l(exc, "Exception must not be null");
        synchronized (this.a) {
            z();
            this.f7984c = true;
            this.f7987f = exc;
        }
        this.f7983b.a(this);
    }

    public final void u(TResult tresult) {
        synchronized (this.a) {
            z();
            this.f7984c = true;
            this.f7986e = tresult;
        }
        this.f7983b.a(this);
    }

    public final boolean v(Exception exc) {
        com.google.android.gms.common.internal.t.l(exc, "Exception must not be null");
        synchronized (this.a) {
            if (this.f7984c) {
                return false;
            }
            this.f7984c = true;
            this.f7987f = exc;
            this.f7983b.a(this);
            return true;
        }
    }

    public final boolean w(TResult tresult) {
        synchronized (this.a) {
            if (this.f7984c) {
                return false;
            }
            this.f7984c = true;
            this.f7986e = tresult;
            this.f7983b.a(this);
            return true;
        }
    }

    public final boolean x() {
        synchronized (this.a) {
            if (this.f7984c) {
                return false;
            }
            this.f7984c = true;
            this.f7985d = true;
            this.f7983b.a(this);
            return true;
        }
    }
}