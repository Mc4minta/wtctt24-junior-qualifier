package h.c;

/* compiled from: Maybe.java */
/* loaded from: classes2.dex */
public abstract class o<T> implements q<T> {
    @Override // h.c.q
    public final void b(p<? super T> pVar) {
        h.c.n0.b.b.e(pVar, "observer is null");
        p<? super T> z = h.c.r0.a.z(this, pVar);
        h.c.n0.b.b.e(z, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            d(z);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final T c() {
        h.c.n0.d.h hVar = new h.c.n0.d.h();
        b(hVar);
        return (T) hVar.a();
    }

    protected abstract void d(p<? super T> pVar);
}