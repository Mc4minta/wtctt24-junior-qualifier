package h.c.n0.e.e;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.Callable;

/* compiled from: ObservableMapNotification.java */
/* loaded from: classes3.dex */
public final class w1<T, R> extends h.c.n0.e.e.a<T, h.c.x<? extends R>> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.x<? extends R>> f16343b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.n<? super Throwable, ? extends h.c.x<? extends R>> f16344c;

    /* renamed from: d  reason: collision with root package name */
    final Callable<? extends h.c.x<? extends R>> f16345d;

    /* compiled from: ObservableMapNotification.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super h.c.x<? extends R>> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.x<? extends R>> f16346b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.m0.n<? super Throwable, ? extends h.c.x<? extends R>> f16347c;

        /* renamed from: d  reason: collision with root package name */
        final Callable<? extends h.c.x<? extends R>> f16348d;

        /* renamed from: e  reason: collision with root package name */
        h.c.k0.b f16349e;

        a(h.c.z<? super h.c.x<? extends R>> zVar, h.c.m0.n<? super T, ? extends h.c.x<? extends R>> nVar, h.c.m0.n<? super Throwable, ? extends h.c.x<? extends R>> nVar2, Callable<? extends h.c.x<? extends R>> callable) {
            this.a = zVar;
            this.f16346b = nVar;
            this.f16347c = nVar2;
            this.f16348d = callable;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f16349e.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f16349e.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            try {
                this.a.onNext((h.c.x) h.c.n0.b.b.e(this.f16348d.call(), "The onComplete ObservableSource returned is null"));
                this.a.onComplete();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.a.onError(th);
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            try {
                this.a.onNext((h.c.x) h.c.n0.b.b.e(this.f16347c.apply(th), "The onError ObservableSource returned is null"));
                this.a.onComplete();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.a.onError(new CompositeException(th, th2));
            }
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            try {
                this.a.onNext((h.c.x) h.c.n0.b.b.e(this.f16346b.apply(t), "The onNext ObservableSource returned is null"));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.a.onError(th);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f16349e, bVar)) {
                this.f16349e = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public w1(h.c.x<T> xVar, h.c.m0.n<? super T, ? extends h.c.x<? extends R>> nVar, h.c.m0.n<? super Throwable, ? extends h.c.x<? extends R>> nVar2, Callable<? extends h.c.x<? extends R>> callable) {
        super(xVar);
        this.f16343b = nVar;
        this.f16344c = nVar2;
        this.f16345d = callable;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super h.c.x<? extends R>> zVar) {
        this.a.subscribe(new a(zVar, this.f16343b, this.f16344c, this.f16345d));
    }
}