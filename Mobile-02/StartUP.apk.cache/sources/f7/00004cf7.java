package h.c.n0.e.b;

import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: FlowableDistinct.java */
/* loaded from: classes3.dex */
public final class m0<T, K> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, K> f14685b;

    /* renamed from: c  reason: collision with root package name */
    final Callable<? extends Collection<? super K>> f14686c;

    /* compiled from: FlowableDistinct.java */
    /* loaded from: classes3.dex */
    static final class a<T, K> extends h.c.n0.h.b<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final Collection<? super K> f14687f;

        /* renamed from: g  reason: collision with root package name */
        final h.c.m0.n<? super T, K> f14688g;

        a(k.a.c<? super T> cVar, h.c.m0.n<? super T, K> nVar, Collection<? super K> collection) {
            super(cVar);
            this.f14688g = nVar;
            this.f14687f = collection;
        }

        @Override // h.c.n0.h.b, h.c.n0.c.j
        public void clear() {
            this.f14687f.clear();
            super.clear();
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            return d(i2);
        }

        @Override // h.c.n0.h.b, k.a.c
        public void onComplete() {
            if (this.f16713d) {
                return;
            }
            this.f16713d = true;
            this.f14687f.clear();
            this.a.onComplete();
        }

        @Override // h.c.n0.h.b, k.a.c
        public void onError(Throwable th) {
            if (this.f16713d) {
                h.c.r0.a.u(th);
                return;
            }
            this.f16713d = true;
            this.f14687f.clear();
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f16713d) {
                return;
            }
            if (this.f16714e == 0) {
                try {
                    if (this.f14687f.add(h.c.n0.b.b.e(this.f14688g.apply(t), "The keySelector returned a null key"))) {
                        this.a.onNext(t);
                        return;
                    } else {
                        this.f16711b.request(1L);
                        return;
                    }
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
            while (true) {
                poll = this.f16712c.poll();
                if (poll == null || this.f14687f.add((Object) h.c.n0.b.b.e(this.f14688g.apply(poll), "The keySelector returned a null key"))) {
                    break;
                } else if (this.f16714e == 2) {
                    this.f16711b.request(1L);
                }
            }
            return poll;
        }
    }

    public m0(h.c.h<T> hVar, h.c.m0.n<? super T, K> nVar, Callable<? extends Collection<? super K>> callable) {
        super(hVar);
        this.f14685b = nVar;
        this.f14686c = callable;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        try {
            this.a.subscribe((h.c.m) new a(cVar, this.f14685b, (Collection) h.c.n0.b.b.e(this.f14686c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.i.d.q(th, cVar);
        }
    }
}