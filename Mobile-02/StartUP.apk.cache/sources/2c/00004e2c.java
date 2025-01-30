package h.c.n0.e.e;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ObservableUsing.java */
/* loaded from: classes3.dex */
public final class c4<T, D> extends h.c.s<T> {
    final Callable<? extends D> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super D, ? extends h.c.x<? extends T>> f15560b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.f<? super D> f15561c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f15562d;

    /* compiled from: ObservableUsing.java */
    /* loaded from: classes3.dex */
    static final class a<T, D> extends AtomicBoolean implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final D f15563b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.f<? super D> f15564c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f15565d;

        /* renamed from: e  reason: collision with root package name */
        h.c.k0.b f15566e;

        a(h.c.z<? super T> zVar, D d2, h.c.m0.f<? super D> fVar, boolean z) {
            this.a = zVar;
            this.f15563b = d2;
            this.f15564c = fVar;
            this.f15565d = z;
        }

        void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.f15564c.accept((D) this.f15563b);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    h.c.r0.a.u(th);
                }
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            a();
            this.f15566e.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return get();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f15565d) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f15564c.accept((D) this.f15563b);
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.a.onError(th);
                        return;
                    }
                }
                this.f15566e.dispose();
                this.a.onComplete();
                return;
            }
            this.a.onComplete();
            this.f15566e.dispose();
            a();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f15565d) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f15564c.accept((D) this.f15563b);
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                this.f15566e.dispose();
                this.a.onError(th);
                return;
            }
            this.a.onError(th);
            this.f15566e.dispose();
            a();
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15566e, bVar)) {
                this.f15566e = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public c4(Callable<? extends D> callable, h.c.m0.n<? super D, ? extends h.c.x<? extends T>> nVar, h.c.m0.f<? super D> fVar, boolean z) {
        this.a = callable;
        this.f15560b = nVar;
        this.f15561c = fVar;
        this.f15562d = z;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        try {
            D call = this.a.call();
            try {
                ((h.c.x) h.c.n0.b.b.e(this.f15560b.apply(call), "The sourceSupplier returned a null ObservableSource")).subscribe(new a(zVar, call, this.f15561c, this.f15562d));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                try {
                    this.f15561c.accept(call);
                    h.c.n0.a.d.y(th, zVar);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    h.c.n0.a.d.y(new CompositeException(th, th2), zVar);
                }
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            h.c.n0.a.d.y(th3, zVar);
        }
    }
}