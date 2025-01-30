package h.c.n0.e.c;

import h.c.n0.d.l;
import h.c.p;
import h.c.s;
import h.c.z;

/* compiled from: MaybeToObservable.java */
/* loaded from: classes3.dex */
public final class c<T> extends s<T> {

    /* compiled from: MaybeToObservable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends l<T> implements p<T> {

        /* renamed from: c  reason: collision with root package name */
        h.c.k0.b f15338c;

        a(z<? super T> zVar) {
            super(zVar);
        }

        @Override // h.c.n0.d.l, h.c.k0.b
        public void dispose() {
            super.dispose();
            this.f15338c.dispose();
        }

        @Override // h.c.p
        public void onComplete() {
            a();
        }

        @Override // h.c.p
        public void onError(Throwable th) {
            c(th);
        }

        @Override // h.c.p
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15338c, bVar)) {
                this.f15338c = bVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // h.c.p
        public void onSuccess(T t) {
            b(t);
        }
    }

    public static <T> p<T> b(z<? super T> zVar) {
        return new a(zVar);
    }
}