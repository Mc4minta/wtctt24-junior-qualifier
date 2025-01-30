package h.c.n0.e.b;

import java.util.concurrent.Callable;

/* compiled from: FlowableScalarXMap.java */
/* loaded from: classes3.dex */
public final class i3 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableScalarXMap.java */
    /* loaded from: classes3.dex */
    public static final class a<T, R> extends h.c.h<R> {
        final T a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends k.a.b<? extends R>> f14514b;

        a(T t, h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar) {
            this.a = t;
            this.f14514b = nVar;
        }

        @Override // h.c.h
        public void subscribeActual(k.a.c<? super R> cVar) {
            try {
                k.a.b bVar = (k.a.b) h.c.n0.b.b.e(this.f14514b.apply((T) this.a), "The mapper returned a null Publisher");
                if (bVar instanceof Callable) {
                    try {
                        Object call = ((Callable) bVar).call();
                        if (call == null) {
                            h.c.n0.i.d.h(cVar);
                            return;
                        } else {
                            cVar.onSubscribe(new h.c.n0.i.e(cVar, call));
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        h.c.n0.i.d.q(th, cVar);
                        return;
                    }
                }
                bVar.subscribe(cVar);
            } catch (Throwable th2) {
                h.c.n0.i.d.q(th2, cVar);
            }
        }
    }

    public static <T, U> h.c.h<U> a(T t, h.c.m0.n<? super T, ? extends k.a.b<? extends U>> nVar) {
        return h.c.r0.a.l(new a(t, nVar));
    }

    public static <T, R> boolean b(k.a.b<T> bVar, k.a.c<? super R> cVar, h.c.m0.n<? super T, ? extends k.a.b<? extends R>> nVar) {
        if (bVar instanceof Callable) {
            try {
                Object obj = (Object) ((Callable) bVar).call();
                if (obj == 0) {
                    h.c.n0.i.d.h(cVar);
                    return true;
                }
                try {
                    k.a.b bVar2 = (k.a.b) h.c.n0.b.b.e(nVar.apply(obj), "The mapper returned a null Publisher");
                    if (bVar2 instanceof Callable) {
                        try {
                            Object call = ((Callable) bVar2).call();
                            if (call == null) {
                                h.c.n0.i.d.h(cVar);
                                return true;
                            }
                            cVar.onSubscribe(new h.c.n0.i.e(cVar, call));
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.b(th);
                            h.c.n0.i.d.q(th, cVar);
                            return true;
                        }
                    } else {
                        bVar2.subscribe(cVar);
                    }
                    return true;
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    h.c.n0.i.d.q(th2, cVar);
                    return true;
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                h.c.n0.i.d.q(th3, cVar);
                return true;
            }
        }
        return false;
    }
}