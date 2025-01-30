package h.c.n0.e.b;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: FlowableUsing.java */
/* loaded from: classes3.dex */
public final class q4<T, D> extends h.c.h<T> {
    final Callable<? extends D> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super D, ? extends k.a.b<? extends T>> f14884b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.f<? super D> f14885c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f14886d;

    /* compiled from: FlowableUsing.java */
    /* loaded from: classes3.dex */
    static final class a<T, D> extends AtomicBoolean implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final D f14887b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.f<? super D> f14888c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f14889d;

        /* renamed from: e  reason: collision with root package name */
        k.a.d f14890e;

        a(k.a.c<? super T> cVar, D d2, h.c.m0.f<? super D> fVar, boolean z) {
            this.a = cVar;
            this.f14887b = d2;
            this.f14888c = fVar;
            this.f14889d = z;
        }

        void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.f14888c.accept((D) this.f14887b);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    h.c.r0.a.u(th);
                }
            }
        }

        @Override // k.a.d
        public void cancel() {
            a();
            this.f14890e.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14889d) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f14888c.accept((D) this.f14887b);
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.a.onError(th);
                        return;
                    }
                }
                this.f14890e.cancel();
                this.a.onComplete();
                return;
            }
            this.a.onComplete();
            this.f14890e.cancel();
            a();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14889d) {
                Throwable th2 = null;
                if (compareAndSet(false, true)) {
                    try {
                        this.f14888c.accept((D) this.f14887b);
                    } catch (Throwable th3) {
                        th2 = th3;
                        io.reactivex.exceptions.a.b(th2);
                    }
                }
                this.f14890e.cancel();
                if (th2 != null) {
                    this.a.onError(new CompositeException(th, th2));
                    return;
                } else {
                    this.a.onError(th);
                    return;
                }
            }
            this.a.onError(th);
            this.f14890e.cancel();
            a();
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14890e, dVar)) {
                this.f14890e = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            this.f14890e.request(j2);
        }
    }

    public q4(Callable<? extends D> callable, h.c.m0.n<? super D, ? extends k.a.b<? extends T>> nVar, h.c.m0.f<? super D> fVar, boolean z) {
        this.a = callable;
        this.f14884b = nVar;
        this.f14885c = fVar;
        this.f14886d = z;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        try {
            D call = this.a.call();
            try {
                ((k.a.b) h.c.n0.b.b.e(this.f14884b.apply(call), "The sourceSupplier returned a null Publisher")).subscribe(new a(cVar, call, this.f14885c, this.f14886d));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                try {
                    this.f14885c.accept(call);
                    h.c.n0.i.d.q(th, cVar);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    h.c.n0.i.d.q(new CompositeException(th, th2), cVar);
                }
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            h.c.n0.i.d.q(th3, cVar);
        }
    }
}