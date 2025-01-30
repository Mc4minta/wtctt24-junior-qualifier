package h.c.n0.e.e;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableCreate.java */
/* loaded from: classes3.dex */
public final class b0<T> extends h.c.s<T> {
    final h.c.v<T> a;

    /* compiled from: ObservableCreate.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<h.c.k0.b> implements h.c.u<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        a(h.c.z<? super T> zVar) {
            this.a = zVar;
        }

        public void a(Throwable th) {
            if (b(th)) {
                return;
            }
            h.c.r0.a.u(th);
        }

        public boolean b(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.a.onError(th);
                dispose();
                return true;
            } catch (Throwable th2) {
                dispose();
                throw th2;
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.g
        public void onComplete() {
            if (isDisposed()) {
                return;
            }
            try {
                this.a.onComplete();
            } finally {
                dispose();
            }
        }

        @Override // h.c.g
        public void onNext(T t) {
            if (t == null) {
                a(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (isDisposed()) {
            } else {
                this.a.onNext(t);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", a.class.getSimpleName(), super.toString());
        }
    }

    public b0(h.c.v<T> vVar) {
        this.a = vVar;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        a aVar = new a(zVar);
        zVar.onSubscribe(aVar);
        try {
            this.a.a(aVar);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            aVar.a(th);
        }
    }
}