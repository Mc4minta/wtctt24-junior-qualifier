package h.c.n0.e.b;

import java.util.Iterator;

/* compiled from: FlowableZipIterable.java */
/* loaded from: classes3.dex */
public final class z4<T, U, V> extends h.c.n0.e.b.a<T, V> {

    /* renamed from: b  reason: collision with root package name */
    final Iterable<U> f15328b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.c<? super T, ? super U, ? extends V> f15329c;

    /* compiled from: FlowableZipIterable.java */
    /* loaded from: classes3.dex */
    static final class a<T, U, V> implements h.c.m<T>, k.a.d {
        final k.a.c<? super V> a;

        /* renamed from: b  reason: collision with root package name */
        final Iterator<U> f15330b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.c<? super T, ? super U, ? extends V> f15331c;

        /* renamed from: d  reason: collision with root package name */
        k.a.d f15332d;

        /* renamed from: e  reason: collision with root package name */
        boolean f15333e;

        a(k.a.c<? super V> cVar, Iterator<U> it, h.c.m0.c<? super T, ? super U, ? extends V> cVar2) {
            this.a = cVar;
            this.f15330b = it;
            this.f15331c = cVar2;
        }

        void a(Throwable th) {
            io.reactivex.exceptions.a.b(th);
            this.f15333e = true;
            this.f15332d.cancel();
            this.a.onError(th);
        }

        @Override // k.a.d
        public void cancel() {
            this.f15332d.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f15333e) {
                return;
            }
            this.f15333e = true;
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f15333e) {
                h.c.r0.a.u(th);
                return;
            }
            this.f15333e = true;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f15333e) {
                return;
            }
            try {
                try {
                    this.a.onNext(h.c.n0.b.b.e(this.f15331c.apply(t, h.c.n0.b.b.e(this.f15330b.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.f15330b.hasNext()) {
                            return;
                        }
                        this.f15333e = true;
                        this.f15332d.cancel();
                        this.a.onComplete();
                    } catch (Throwable th) {
                        a(th);
                    }
                } catch (Throwable th2) {
                    a(th2);
                }
            } catch (Throwable th3) {
                a(th3);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15332d, dVar)) {
                this.f15332d = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            this.f15332d.request(j2);
        }
    }

    public z4(h.c.h<T> hVar, Iterable<U> iterable, h.c.m0.c<? super T, ? super U, ? extends V> cVar) {
        super(hVar);
        this.f15328b = iterable;
        this.f15329c = cVar;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super V> cVar) {
        try {
            Iterator it = (Iterator) h.c.n0.b.b.e(this.f15328b.iterator(), "The iterator returned by other is null");
            try {
                if (!it.hasNext()) {
                    h.c.n0.i.d.h(cVar);
                } else {
                    this.a.subscribe((h.c.m) new a(cVar, it, this.f15329c));
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                h.c.n0.i.d.q(th, cVar);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            h.c.n0.i.d.q(th2, cVar);
        }
    }
}