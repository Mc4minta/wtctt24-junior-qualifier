package retrofit2.adapter.rxjava2;

import h.c.s;
import h.c.z;
import io.reactivex.exceptions.CompositeException;

/* compiled from: CallEnqueueObservable.java */
/* loaded from: classes3.dex */
final class b<T> extends s<retrofit2.s<T>> {
    private final retrofit2.d<T> a;

    /* compiled from: CallEnqueueObservable.java */
    /* loaded from: classes3.dex */
    private static final class a<T> implements h.c.k0.b, retrofit2.f<T> {
        private final retrofit2.d<?> a;

        /* renamed from: b  reason: collision with root package name */
        private final z<? super retrofit2.s<T>> f17885b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f17886c;

        /* renamed from: d  reason: collision with root package name */
        boolean f17887d = false;

        a(retrofit2.d<?> dVar, z<? super retrofit2.s<T>> zVar) {
            this.a = dVar;
            this.f17885b = zVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f17886c = true;
            this.a.cancel();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f17886c;
        }

        @Override // retrofit2.f
        public void onFailure(retrofit2.d<T> dVar, Throwable th) {
            if (dVar.isCanceled()) {
                return;
            }
            try {
                this.f17885b.onError(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                h.c.r0.a.u(new CompositeException(th, th2));
            }
        }

        @Override // retrofit2.f
        public void onResponse(retrofit2.d<T> dVar, retrofit2.s<T> sVar) {
            if (this.f17886c) {
                return;
            }
            try {
                this.f17885b.onNext(sVar);
                if (this.f17886c) {
                    return;
                }
                this.f17887d = true;
                this.f17885b.onComplete();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                if (this.f17887d) {
                    h.c.r0.a.u(th);
                } else if (this.f17886c) {
                } else {
                    try {
                        this.f17885b.onError(th);
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        h.c.r0.a.u(new CompositeException(th, th2));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(retrofit2.d<T> dVar) {
        this.a = dVar;
    }

    @Override // h.c.s
    protected void subscribeActual(z<? super retrofit2.s<T>> zVar) {
        retrofit2.d<T> mo2365clone = this.a.mo2365clone();
        a aVar = new a(mo2365clone, zVar);
        zVar.onSubscribe(aVar);
        if (aVar.isDisposed()) {
            return;
        }
        mo2365clone.d0(aVar);
    }
}