package h.c.n0.e.b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableRefCount.java */
/* loaded from: classes3.dex */
public final class y2<T> extends h.c.h<T> {
    final h.c.l0.a<T> a;

    /* renamed from: b  reason: collision with root package name */
    final int f15254b;

    /* renamed from: c  reason: collision with root package name */
    final long f15255c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f15256d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.a0 f15257e;

    /* renamed from: f  reason: collision with root package name */
    a f15258f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableRefCount.java */
    /* loaded from: classes3.dex */
    public static final class a extends AtomicReference<h.c.k0.b> implements Runnable, h.c.m0.f<h.c.k0.b> {
        final y2<?> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f15259b;

        /* renamed from: c  reason: collision with root package name */
        long f15260c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15261d;

        /* renamed from: e  reason: collision with root package name */
        boolean f15262e;

        a(y2<?> y2Var) {
            this.a = y2Var;
        }

        @Override // h.c.m0.f
        /* renamed from: a */
        public void accept(h.c.k0.b bVar) throws Exception {
            h.c.n0.a.c.q(this, bVar);
            synchronized (this.a) {
                if (this.f15262e) {
                    ((h.c.n0.a.f) this.a.a).a(bVar);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.d(this);
        }
    }

    /* compiled from: FlowableRefCount.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends AtomicBoolean implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final y2<T> f15263b;

        /* renamed from: c  reason: collision with root package name */
        final a f15264c;

        /* renamed from: d  reason: collision with root package name */
        k.a.d f15265d;

        b(k.a.c<? super T> cVar, y2<T> y2Var, a aVar) {
            this.a = cVar;
            this.f15263b = y2Var;
            this.f15264c = aVar;
        }

        @Override // k.a.d
        public void cancel() {
            this.f15265d.cancel();
            if (compareAndSet(false, true)) {
                this.f15263b.b(this.f15264c);
            }
        }

        @Override // k.a.c
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.f15263b.c(this.f15264c);
                this.a.onComplete();
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.f15263b.c(this.f15264c);
                this.a.onError(th);
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15265d, dVar)) {
                this.f15265d = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            this.f15265d.request(j2);
        }
    }

    public y2(h.c.l0.a<T> aVar) {
        this(aVar, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    void b(a aVar) {
        synchronized (this) {
            a aVar2 = this.f15258f;
            if (aVar2 != null && aVar2 == aVar) {
                long j2 = aVar.f15260c - 1;
                aVar.f15260c = j2;
                if (j2 == 0 && aVar.f15261d) {
                    if (this.f15255c == 0) {
                        d(aVar);
                        return;
                    }
                    h.c.n0.a.g gVar = new h.c.n0.a.g();
                    aVar.f15259b = gVar;
                    gVar.a(this.f15257e.d(aVar, this.f15255c, this.f15256d));
                }
            }
        }
    }

    void c(a aVar) {
        synchronized (this) {
            a aVar2 = this.f15258f;
            if (aVar2 != null && aVar2 == aVar) {
                this.f15258f = null;
                h.c.k0.b bVar = aVar.f15259b;
                if (bVar != null) {
                    bVar.dispose();
                }
            }
            long j2 = aVar.f15260c - 1;
            aVar.f15260c = j2;
            if (j2 == 0) {
                h.c.l0.a<T> aVar3 = this.a;
                if (aVar3 instanceof h.c.k0.b) {
                    ((h.c.k0.b) aVar3).dispose();
                } else if (aVar3 instanceof h.c.n0.a.f) {
                    ((h.c.n0.a.f) aVar3).a(aVar.get());
                }
            }
        }
    }

    void d(a aVar) {
        synchronized (this) {
            if (aVar.f15260c == 0 && aVar == this.f15258f) {
                this.f15258f = null;
                h.c.k0.b bVar = aVar.get();
                h.c.n0.a.c.h(aVar);
                h.c.l0.a<T> aVar2 = this.a;
                if (aVar2 instanceof h.c.k0.b) {
                    ((h.c.k0.b) aVar2).dispose();
                } else if (aVar2 instanceof h.c.n0.a.f) {
                    if (bVar == null) {
                        aVar.f15262e = true;
                    } else {
                        ((h.c.n0.a.f) aVar2).a(bVar);
                    }
                }
            }
        }
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        a aVar;
        boolean z;
        h.c.k0.b bVar;
        synchronized (this) {
            aVar = this.f15258f;
            if (aVar == null) {
                aVar = new a(this);
                this.f15258f = aVar;
            }
            long j2 = aVar.f15260c;
            if (j2 == 0 && (bVar = aVar.f15259b) != null) {
                bVar.dispose();
            }
            long j3 = j2 + 1;
            aVar.f15260c = j3;
            z = true;
            if (aVar.f15261d || j3 != this.f15254b) {
                z = false;
            } else {
                aVar.f15261d = true;
            }
        }
        this.a.subscribe((h.c.m) new b(cVar, this, aVar));
        if (z) {
            this.a.b(aVar);
        }
    }

    public y2(h.c.l0.a<T> aVar, int i2, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
        this.a = aVar;
        this.f15254b = i2;
        this.f15255c = j2;
        this.f15256d = timeUnit;
        this.f15257e = a0Var;
    }
}