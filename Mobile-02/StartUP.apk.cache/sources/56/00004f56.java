package h.c.n0.e.e;

import h.c.n0.e.e.x3;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableTimeout.java */
/* loaded from: classes3.dex */
public final class w3<T, U, V> extends h.c.n0.e.e.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.x<U> f16352b;

    /* renamed from: c  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends h.c.x<V>> f16353c;

    /* renamed from: d  reason: collision with root package name */
    final h.c.x<? extends T> f16354d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableTimeout.java */
    /* loaded from: classes3.dex */
    public static final class a extends AtomicReference<h.c.k0.b> implements h.c.z<Object>, h.c.k0.b {
        final d a;

        /* renamed from: b  reason: collision with root package name */
        final long f16355b;

        a(long j2, d dVar) {
            this.f16355b = j2;
            this.a = dVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this);
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            Object obj = get();
            h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
            if (obj != cVar) {
                lazySet(cVar);
                this.a.a(this.f16355b);
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            Object obj = get();
            h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
            if (obj != cVar) {
                lazySet(cVar);
                this.a.b(this.f16355b, th);
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(Object obj) {
            h.c.k0.b bVar = (h.c.k0.b) get();
            h.c.n0.a.c cVar = h.c.n0.a.c.DISPOSED;
            if (bVar != cVar) {
                bVar.dispose();
                lazySet(cVar);
                this.a.a(this.f16355b);
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this, bVar);
        }
    }

    /* compiled from: ObservableTimeout.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends AtomicReference<h.c.k0.b> implements h.c.z<T>, h.c.k0.b, d {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.x<?>> f16356b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.n0.a.g f16357c = new h.c.n0.a.g();

        /* renamed from: d  reason: collision with root package name */
        final AtomicLong f16358d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f16359e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        h.c.x<? extends T> f16360f;

        b(h.c.z<? super T> zVar, h.c.m0.n<? super T, ? extends h.c.x<?>> nVar, h.c.x<? extends T> xVar) {
            this.a = zVar;
            this.f16356b = nVar;
            this.f16360f = xVar;
        }

        @Override // h.c.n0.e.e.x3.d
        public void a(long j2) {
            if (this.f16358d.compareAndSet(j2, Long.MAX_VALUE)) {
                h.c.n0.a.c.h(this.f16359e);
                h.c.x<? extends T> xVar = this.f16360f;
                this.f16360f = null;
                xVar.subscribe(new x3.a(this.a, this));
            }
        }

        @Override // h.c.n0.e.e.w3.d
        public void b(long j2, Throwable th) {
            if (this.f16358d.compareAndSet(j2, Long.MAX_VALUE)) {
                h.c.n0.a.c.h(this);
                this.a.onError(th);
                return;
            }
            h.c.r0.a.u(th);
        }

        void c(h.c.x<?> xVar) {
            if (xVar != null) {
                a aVar = new a(0L, this);
                if (this.f16357c.a(aVar)) {
                    xVar.subscribe(aVar);
                }
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this.f16359e);
            h.c.n0.a.c.h(this);
            this.f16357c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (this.f16358d.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f16357c.dispose();
                this.a.onComplete();
                this.f16357c.dispose();
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (this.f16358d.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f16357c.dispose();
                this.a.onError(th);
                this.f16357c.dispose();
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            long j2 = this.f16358d.get();
            if (j2 != Long.MAX_VALUE) {
                long j3 = 1 + j2;
                if (this.f16358d.compareAndSet(j2, j3)) {
                    h.c.k0.b bVar = this.f16357c.get();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    this.a.onNext(t);
                    try {
                        h.c.x xVar = (h.c.x) h.c.n0.b.b.e(this.f16356b.apply(t), "The itemTimeoutIndicator returned a null ObservableSource.");
                        a aVar = new a(j3, this);
                        if (this.f16357c.a(aVar)) {
                            xVar.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f16359e.get().dispose();
                        this.f16358d.getAndSet(Long.MAX_VALUE);
                        this.a.onError(th);
                    }
                }
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this.f16359e, bVar);
        }
    }

    /* compiled from: ObservableTimeout.java */
    /* loaded from: classes3.dex */
    static final class c<T> extends AtomicLong implements h.c.z<T>, h.c.k0.b, d {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends h.c.x<?>> f16361b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.n0.a.g f16362c = new h.c.n0.a.g();

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f16363d = new AtomicReference<>();

        c(h.c.z<? super T> zVar, h.c.m0.n<? super T, ? extends h.c.x<?>> nVar) {
            this.a = zVar;
            this.f16361b = nVar;
        }

        @Override // h.c.n0.e.e.x3.d
        public void a(long j2) {
            if (compareAndSet(j2, Long.MAX_VALUE)) {
                h.c.n0.a.c.h(this.f16363d);
                this.a.onError(new TimeoutException());
            }
        }

        @Override // h.c.n0.e.e.w3.d
        public void b(long j2, Throwable th) {
            if (compareAndSet(j2, Long.MAX_VALUE)) {
                h.c.n0.a.c.h(this.f16363d);
                this.a.onError(th);
                return;
            }
            h.c.r0.a.u(th);
        }

        void c(h.c.x<?> xVar) {
            if (xVar != null) {
                a aVar = new a(0L, this);
                if (this.f16362c.a(aVar)) {
                    xVar.subscribe(aVar);
                }
            }
        }

        @Override // h.c.k0.b
        public void dispose() {
            h.c.n0.a.c.h(this.f16363d);
            this.f16362c.dispose();
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return h.c.n0.a.c.n(this.f16363d.get());
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f16362c.dispose();
                this.a.onComplete();
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f16362c.dispose();
                this.a.onError(th);
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            long j2 = get();
            if (j2 != Long.MAX_VALUE) {
                long j3 = 1 + j2;
                if (compareAndSet(j2, j3)) {
                    h.c.k0.b bVar = this.f16362c.get();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    this.a.onNext(t);
                    try {
                        h.c.x xVar = (h.c.x) h.c.n0.b.b.e(this.f16361b.apply(t), "The itemTimeoutIndicator returned a null ObservableSource.");
                        a aVar = new a(j3, this);
                        if (this.f16362c.a(aVar)) {
                            xVar.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f16363d.get().dispose();
                        getAndSet(Long.MAX_VALUE);
                        this.a.onError(th);
                    }
                }
            }
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            h.c.n0.a.c.z(this.f16363d, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableTimeout.java */
    /* loaded from: classes3.dex */
    public interface d extends x3.d {
        void b(long j2, Throwable th);
    }

    public w3(h.c.s<T> sVar, h.c.x<U> xVar, h.c.m0.n<? super T, ? extends h.c.x<V>> nVar, h.c.x<? extends T> xVar2) {
        super(sVar);
        this.f16352b = xVar;
        this.f16353c = nVar;
        this.f16354d = xVar2;
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        if (this.f16354d == null) {
            c cVar = new c(zVar, this.f16353c);
            zVar.onSubscribe(cVar);
            cVar.c(this.f16352b);
            this.a.subscribe(cVar);
            return;
        }
        b bVar = new b(zVar, this.f16353c, this.f16354d);
        zVar.onSubscribe(bVar);
        bVar.c(this.f16352b);
        this.a.subscribe(bVar);
    }
}