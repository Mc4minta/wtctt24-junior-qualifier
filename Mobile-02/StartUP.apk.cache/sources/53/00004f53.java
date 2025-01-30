package h.c.n0.e.e;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableScalarXMap.java */
/* loaded from: classes3.dex */
public final class w2 {

    /* compiled from: ObservableScalarXMap.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends AtomicInteger implements h.c.n0.c.e<T>, Runnable {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final T f16350b;

        public a(h.c.z<? super T> zVar, T t) {
            this.a = zVar;
            this.f16350b = t;
        }

        @Override // h.c.n0.c.j
        public void clear() {
            lazySet(3);
        }

        @Override // h.c.k0.b
        public void dispose() {
            set(3);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get() == 3;
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            if ((i2 & 1) != 0) {
                lazySet(1);
                return 1;
            }
            return 0;
        }

        @Override // h.c.n0.c.j
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            if (get() == 1) {
                lazySet(3);
                return this.f16350b;
            }
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.a.onNext((T) this.f16350b);
                if (get() == 2) {
                    lazySet(3);
                    this.a.onComplete();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableScalarXMap.java */
    /* loaded from: classes3.dex */
    public static final class b<T, R> extends h.c.s<R> {
        final T a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.x<? extends R>> f16351b;

        b(T t, h.c.m0.n<? super T, ? extends h.c.x<? extends R>> nVar) {
            this.a = t;
            this.f16351b = nVar;
        }

        @Override // h.c.s
        public void subscribeActual(h.c.z<? super R> zVar) {
            try {
                h.c.x xVar = (h.c.x) h.c.n0.b.b.e(this.f16351b.apply((T) this.a), "The mapper returned a null ObservableSource");
                if (xVar instanceof Callable) {
                    try {
                        Object call = ((Callable) xVar).call();
                        if (call == null) {
                            h.c.n0.a.d.q(zVar);
                            return;
                        }
                        a aVar = new a(zVar, call);
                        zVar.onSubscribe(aVar);
                        aVar.run();
                        return;
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        h.c.n0.a.d.y(th, zVar);
                        return;
                    }
                }
                xVar.subscribe(zVar);
            } catch (Throwable th2) {
                h.c.n0.a.d.y(th2, zVar);
            }
        }
    }

    public static <T, U> h.c.s<U> a(T t, h.c.m0.n<? super T, ? extends h.c.x<? extends U>> nVar) {
        return h.c.r0.a.n(new b(t, nVar));
    }

    public static <T, R> boolean b(h.c.x<T> xVar, h.c.z<? super R> zVar, h.c.m0.n<? super T, ? extends h.c.x<? extends R>> nVar) {
        if (xVar instanceof Callable) {
            try {
                Object obj = (Object) ((Callable) xVar).call();
                if (obj == 0) {
                    h.c.n0.a.d.q(zVar);
                    return true;
                }
                try {
                    h.c.x xVar2 = (h.c.x) h.c.n0.b.b.e(nVar.apply(obj), "The mapper returned a null ObservableSource");
                    if (xVar2 instanceof Callable) {
                        try {
                            Object call = ((Callable) xVar2).call();
                            if (call == null) {
                                h.c.n0.a.d.q(zVar);
                                return true;
                            }
                            a aVar = new a(zVar, call);
                            zVar.onSubscribe(aVar);
                            aVar.run();
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.b(th);
                            h.c.n0.a.d.y(th, zVar);
                            return true;
                        }
                    } else {
                        xVar2.subscribe(zVar);
                    }
                    return true;
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    h.c.n0.a.d.y(th2, zVar);
                    return true;
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                h.c.n0.a.d.y(th3, zVar);
                return true;
            }
        }
        return false;
    }
}