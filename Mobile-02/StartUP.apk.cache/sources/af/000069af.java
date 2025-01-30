package retrofit2.adapter.rxjava2;

import h.c.s;
import h.c.z;
import io.reactivex.exceptions.CompositeException;

/* compiled from: ResultObservable.java */
/* loaded from: classes3.dex */
final class e<T> extends s<d<T>> {
    private final s<retrofit2.s<T>> a;

    /* compiled from: ResultObservable.java */
    /* loaded from: classes3.dex */
    private static class a<R> implements z<retrofit2.s<R>> {
        private final z<? super d<R>> a;

        a(z<? super d<R>> zVar) {
            this.a = zVar;
        }

        @Override // h.c.z, k.a.c
        /* renamed from: a */
        public void onNext(retrofit2.s<R> sVar) {
            this.a.onNext(d.b(sVar));
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            try {
                this.a.onNext(d.a(th));
                this.a.onComplete();
            } catch (Throwable th2) {
                try {
                    this.a.onError(th2);
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    h.c.r0.a.u(new CompositeException(th2, th3));
                }
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            this.a.onSubscribe(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(s<retrofit2.s<T>> sVar) {
        this.a = sVar;
    }

    @Override // h.c.s
    protected void subscribeActual(z<? super d<T>> zVar) {
        this.a.subscribe(new a(zVar));
    }
}