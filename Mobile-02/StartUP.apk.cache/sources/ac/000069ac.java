package retrofit2.adapter.rxjava2;

import h.c.s;
import h.c.z;
import io.reactivex.exceptions.CompositeException;

/* compiled from: CallExecuteObservable.java */
/* loaded from: classes3.dex */
final class c<T> extends s<retrofit2.s<T>> {
    private final retrofit2.d<T> a;

    /* compiled from: CallExecuteObservable.java */
    /* loaded from: classes3.dex */
    private static final class a implements h.c.k0.b {
        private final retrofit2.d<?> a;

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f17888b;

        a(retrofit2.d<?> dVar) {
            this.a = dVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f17888b = true;
            this.a.cancel();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f17888b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(retrofit2.d<T> dVar) {
        this.a = dVar;
    }

    @Override // h.c.s
    protected void subscribeActual(z<? super retrofit2.s<T>> zVar) {
        boolean z;
        retrofit2.d<T> mo2365clone = this.a.mo2365clone();
        a aVar = new a(mo2365clone);
        zVar.onSubscribe(aVar);
        if (aVar.isDisposed()) {
            return;
        }
        try {
            retrofit2.s<T> execute = mo2365clone.execute();
            if (!aVar.isDisposed()) {
                zVar.onNext(execute);
            }
            if (aVar.isDisposed()) {
                return;
            }
            try {
                zVar.onComplete();
            } catch (Throwable th) {
                th = th;
                z = true;
                io.reactivex.exceptions.a.b(th);
                if (z) {
                    h.c.r0.a.u(th);
                } else if (aVar.isDisposed()) {
                } else {
                    try {
                        zVar.onError(th);
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        h.c.r0.a.u(new CompositeException(th, th2));
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }
}