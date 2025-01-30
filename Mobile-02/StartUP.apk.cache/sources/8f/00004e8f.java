package h.c.n0.e.e;

import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableDistinct.java */
/* loaded from: classes3.dex */
public final class j0<T, K> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, K> f15826b;

    /* renamed from: c  reason: collision with root package name */
    final Callable<? extends Collection<? super K>> f15827c;

    /* compiled from: ObservableDistinct.java */
    /* loaded from: classes3.dex */
    static final class a<T, K> extends h.c.n0.d.a<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final Collection<? super K> f15828f;

        /* renamed from: g  reason: collision with root package name */
        final h.c.m0.n<? super T, K> f15829g;

        a(h.c.z<? super T> zVar, h.c.m0.n<? super T, K> nVar, Collection<? super K> collection) {
            super(zVar);
            this.f15829g = nVar;
            this.f15828f = collection;
        }

        @Override // h.c.n0.d.a, h.c.n0.c.j
        public void clear() {
            this.f15828f.clear();
            super.clear();
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            return d(i2);
        }

        @Override // h.c.n0.d.a, h.c.z, k.a.c
        public void onComplete() {
            if (this.f14114d) {
                return;
            }
            this.f14114d = true;
            this.f15828f.clear();
            this.a.onComplete();
        }

        @Override // h.c.n0.d.a, h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f14114d) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14114d = true;
            this.f15828f.clear();
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f14114d) {
                return;
            }
            if (this.f14115e == 0) {
                try {
                    if (this.f15828f.add(h.c.n0.b.b.e(this.f15829g.apply(t), "The keySelector returned a null key"))) {
                        this.a.onNext(t);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    c(th);
                    return;
                }
            }
            this.a.onNext(null);
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            T poll;
            do {
                poll = this.f14113c.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.f15828f.add((Object) h.c.n0.b.b.e(this.f15829g.apply(poll), "The keySelector returned a null key")));
            return poll;
        }
    }

    public j0(h.c.x<T> xVar, h.c.m0.n<? super T, K> nVar, Callable<? extends Collection<? super K>> callable) {
        super(xVar);
        this.f15826b = nVar;
        this.f15827c = callable;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        try {
            this.a.subscribe(new a(zVar, this.f15826b, (Collection) h.c.n0.b.b.e(this.f15827c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.a.d.y(th, zVar);
        }
    }
}