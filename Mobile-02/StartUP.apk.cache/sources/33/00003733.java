package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class g<TResult> {
    public g<TResult> a(Executor executor, b bVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    public g<TResult> b(c<TResult> cVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public g<TResult> c(Executor executor, c<TResult> cVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract g<TResult> d(d dVar);

    public abstract g<TResult> e(Executor executor, d dVar);

    public abstract g<TResult> f(e<? super TResult> eVar);

    public abstract g<TResult> g(Executor executor, e<? super TResult> eVar);

    public <TContinuationResult> g<TContinuationResult> h(a<TResult, TContinuationResult> aVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> g<TContinuationResult> i(Executor executor, a<TResult, TContinuationResult> aVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> g<TContinuationResult> j(a<TResult, g<TContinuationResult>> aVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public <TContinuationResult> g<TContinuationResult> k(Executor executor, a<TResult, g<TContinuationResult>> aVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public abstract Exception l();

    public abstract TResult m();

    public abstract <X extends Throwable> TResult n(Class<X> cls) throws Throwable;

    public abstract boolean o();

    public abstract boolean p();

    public abstract boolean q();

    public <TContinuationResult> g<TContinuationResult> r(f<TResult, TContinuationResult> fVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    public <TContinuationResult> g<TContinuationResult> s(Executor executor, f<TResult, TContinuationResult> fVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }
}