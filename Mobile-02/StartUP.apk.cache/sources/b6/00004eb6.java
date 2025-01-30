package h.c.n0.e.e;

import java.util.Iterator;

/* compiled from: ObservableZipIterable.java */
/* loaded from: classes3.dex */
public final class l4<T, U, V> extends h.c.s<V> {
    final h.c.s<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<U> f15931b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.c<? super T, ? super U, ? extends V> f15932c;

    /* compiled from: ObservableZipIterable.java */
    /* loaded from: classes3.dex */
    static final class a<T, U, V> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super V> a;

        /* renamed from: b  reason: collision with root package name */
        final Iterator<U> f15933b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.c<? super T, ? super U, ? extends V> f15934c;

        /* renamed from: d  reason: collision with root package name */
        h.c.k0.b f15935d;

        /* renamed from: e  reason: collision with root package name */
        boolean f15936e;

        a(h.c.z<? super V> zVar, Iterator<U> it, h.c.m0.c<? super T, ? super U, ? extends V> cVar) {
            this.a = zVar;
            this.f15933b = it;
            this.f15934c = cVar;
        }

        void a(Throwable th) {
            this.f15936e = true;
            this.f15935d.dispose();
            this.a.onError(th);
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15935d.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15935d.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15936e) {
                return;
            }
            this.f15936e = true;
            this.a.onComplete();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15936e) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15936e = true;
            this.a.onError(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            if (this.f15936e) {
                return;
            }
            try {
                try {
                    this.a.onNext(h.c.n0.b.b.e(this.f15934c.apply(t, h.c.n0.b.b.e(this.f15933b.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.f15933b.hasNext()) {
                            return;
                        }
                        this.f15936e = true;
                        this.f15935d.dispose();
                        this.a.onComplete();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        a(th);
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    a(th2);
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                a(th3);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15935d, bVar)) {
                this.f15935d = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public l4(h.c.s<? extends T> sVar, Iterable<U> iterable, h.c.m0.c<? super T, ? super U, ? extends V> cVar) {
        this.a = sVar;
        this.f15931b = iterable;
        this.f15932c = cVar;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super V> zVar) {
        try {
            Iterator it = (Iterator) h.c.n0.b.b.e(this.f15931b.iterator(), "The iterator returned by other is null");
            try {
                if (!it.hasNext()) {
                    h.c.n0.a.d.q(zVar);
                } else {
                    this.a.subscribe(new a(zVar, it, this.f15932c));
                }
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