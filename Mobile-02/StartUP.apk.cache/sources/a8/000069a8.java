package retrofit2.adapter.rxjava2;

import h.c.s;
import h.c.z;
import io.reactivex.exceptions.CompositeException;

/* compiled from: BodyObservable.java */
/* loaded from: classes3.dex */
final class a<T> extends s<T> {
    private final s<retrofit2.s<T>> a;

    /* compiled from: BodyObservable.java */
    /* renamed from: retrofit2.adapter.rxjava2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0431a<R> implements z<retrofit2.s<R>> {
        private final z<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f17884b;

        C0431a(z<? super R> zVar) {
            this.a = zVar;
        }

        @Override // h.c.z, k.a.c
        /* renamed from: a */
        public void onNext(retrofit2.s<R> sVar) {
            if (sVar.e()) {
                this.a.onNext(sVar.a());
                return;
            }
            this.f17884b = true;
            HttpException httpException = new HttpException(sVar);
            try {
                this.a.onError(httpException);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.r0.a.u(new CompositeException(httpException, th));
            }
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f17884b) {
                return;
            }
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (!this.f17884b) {
                this.a.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            h.c.r0.a.u(assertionError);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            this.a.onSubscribe(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(s<retrofit2.s<T>> sVar) {
        this.a = sVar;
    }

    @Override // h.c.s
    protected void subscribeActual(z<? super T> zVar) {
        this.a.subscribe(new C0431a(zVar));
    }
}