package h.c.n0.e.b;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.Callable;

/* compiled from: FlowableMapNotification.java */
/* loaded from: classes3.dex */
public final class b2<T, R> extends h.c.n0.e.b.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends R> f14231b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.n<? super Throwable, ? extends R> f14232c;

    /* renamed from: d  reason: collision with root package name */
    final Callable<? extends R> f14233d;

    /* compiled from: FlowableMapNotification.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends h.c.n0.h.s<T, R> {

        /* renamed from: e  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends R> f14234e;

        /* renamed from: f  reason: collision with root package name */
        final h.c.m0.n<? super Throwable, ? extends R> f14235f;

        /* renamed from: g  reason: collision with root package name */
        final Callable<? extends R> f14236g;

        a(k.a.c<? super R> cVar, h.c.m0.n<? super T, ? extends R> nVar, h.c.m0.n<? super Throwable, ? extends R> nVar2, Callable<? extends R> callable) {
            super(cVar);
            this.f14234e = nVar;
            this.f14235f = nVar2;
            this.f14236g = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // k.a.c
        public void onComplete() {
            try {
                a(h.c.n0.b.b.e(this.f14236g.call(), "The onComplete publisher returned is null"));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.a.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // k.a.c
        public void onError(Throwable th) {
            try {
                a(h.c.n0.b.b.e(this.f14235f.apply(th), "The onError publisher returned is null"));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.a.onError(new CompositeException(th, th2));
            }
        }

        @Override // k.a.c
        public void onNext(T t) {
            try {
                Object e2 = h.c.n0.b.b.e(this.f14234e.apply(t), "The onNext publisher returned is null");
                this.f16747d++;
                this.a.onNext(e2);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.a.onError(th);
            }
        }
    }

    public b2(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends R> nVar, h.c.m0.n<? super Throwable, ? extends R> nVar2, Callable<? extends R> callable) {
        super(hVar);
        this.f14231b = nVar;
        this.f14232c = nVar2;
        this.f14233d = callable;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14231b, this.f14232c, this.f14233d));
    }
}