package h.c.n0.e.e;

import java.util.Iterator;

/* compiled from: ObservableFromIterable.java */
/* loaded from: classes3.dex */
public final class e1<T> extends h.c.s<T> {
    final Iterable<? extends T> a;

    /* compiled from: ObservableFromIterable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.d.c<T> {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final Iterator<? extends T> f15623b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f15624c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15625d;

        /* renamed from: e  reason: collision with root package name */
        boolean f15626e;

        /* renamed from: f  reason: collision with root package name */
        boolean f15627f;

        a(h.c.z<? super T> zVar, Iterator<? extends T> it) {
            this.a = zVar;
            this.f15623b = it;
        }

        void a() {
            while (!isDisposed()) {
                try {
                    this.a.onNext(h.c.n0.b.b.e(this.f15623b.next(), "The iterator returned a null value"));
                    if (isDisposed()) {
                        return;
                    }
                    try {
                        if (!this.f15623b.hasNext()) {
                            if (isDisposed()) {
                                return;
                            }
                            this.a.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.a.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.a.onError(th2);
                    return;
                }
            }
        }

        @Override // h.c.n0.c.j
        public void clear() {
            this.f15626e = true;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15624c = true;
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15624c;
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return this.f15626e;
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            if ((i2 & 1) != 0) {
                this.f15625d = true;
                return 1;
            }
            return 0;
        }

        @Override // h.c.n0.c.j
        public T poll() {
            if (this.f15626e) {
                return null;
            }
            if (this.f15627f) {
                if (!this.f15623b.hasNext()) {
                    this.f15626e = true;
                    return null;
                }
            } else {
                this.f15627f = true;
            }
            return (T) h.c.n0.b.b.e(this.f15623b.next(), "The iterator returned a null value");
        }
    }

    public e1(Iterable<? extends T> iterable) {
        this.a = iterable;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            try {
                if (!it.hasNext()) {
                    h.c.n0.a.d.q(zVar);
                    return;
                }
                a aVar = new a(zVar, it);
                zVar.onSubscribe(aVar);
                if (aVar.f15625d) {
                    return;
                }
                aVar.a();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.n0.a.d.y(th, zVar);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            h.c.n0.a.d.y(th2, zVar);
        }
    }
}