package h.c.n0.e.e;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableRefCount.java */
/* loaded from: classes3.dex */
public final class m2<T> extends h.c.s<T> {
    final h.c.o0.a<T> a;

    /* renamed from: b  reason: collision with root package name */
    final int f15957b;

    /* renamed from: c  reason: collision with root package name */
    final long f15958c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f15959d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.a0 f15960e;

    /* renamed from: f  reason: collision with root package name */
    a f15961f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableRefCount.java */
    /* loaded from: classes3.dex */
    public static final class a extends AtomicReference<h.c.k0.b> implements Runnable, h.c.m0.f<h.c.k0.b> {
        final m2<?> a;

        /* renamed from: b  reason: collision with root package name */
        h.c.k0.b f15962b;

        /* renamed from: c  reason: collision with root package name */
        long f15963c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15964d;

        /* renamed from: e  reason: collision with root package name */
        boolean f15965e;

        a(m2<?> m2Var) {
            this.a = m2Var;
        }

        @Override // h.c.m0.f
        /* renamed from: a */
        public void accept(h.c.k0.b bVar) throws Exception {
            h.c.n0.a.c.q(this, bVar);
            synchronized (this.a) {
                if (this.f15965e) {
                    ((h.c.n0.a.f) this.a.a).a(bVar);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.d(this);
        }
    }

    /* compiled from: ObservableRefCount.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends AtomicBoolean implements h.c.z<T>, h.c.k0.b {
        final h.c.z<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final m2<T> f15966b;

        /* renamed from: c  reason: collision with root package name */
        final a f15967c;

        /* renamed from: d  reason: collision with root package name */
        h.c.k0.b f15968d;

        b(h.c.z<? super T> zVar, m2<T> m2Var, a aVar) {
            this.a = zVar;
            this.f15966b = m2Var;
            this.f15967c = aVar;
        }

        @Override // h.c.k0.b
        public void dispose() {
            this.f15968d.dispose();
            if (compareAndSet(false, true)) {
                this.f15966b.b(this.f15967c);
            }
        }

        @Override // h.c.k0.b
        public boolean isDisposed() {
            return this.f15968d.isDisposed();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.f15966b.c(this.f15967c);
                this.a.onComplete();
            }
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.f15966b.c(this.f15967c);
                this.a.onError(th);
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.z
        public void onSubscribe(h.c.k0.b bVar) {
            if (h.c.n0.a.c.B(this.f15968d, bVar)) {
                this.f15968d = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public m2(h.c.o0.a<T> aVar) {
        this(aVar, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    void b(a aVar) {
        synchronized (this) {
            a aVar2 = this.f15961f;
            if (aVar2 != null && aVar2 == aVar) {
                long j2 = aVar.f15963c - 1;
                aVar.f15963c = j2;
                if (j2 == 0 && aVar.f15964d) {
                    if (this.f15958c == 0) {
                        d(aVar);
                        return;
                    }
                    h.c.n0.a.g gVar = new h.c.n0.a.g();
                    aVar.f15962b = gVar;
                    gVar.a(this.f15960e.d(aVar, this.f15958c, this.f15959d));
                }
            }
        }
    }

    void c(a aVar) {
        synchronized (this) {
            a aVar2 = this.f15961f;
            if (aVar2 != null && aVar2 == aVar) {
                this.f15961f = null;
                h.c.k0.b bVar = aVar.f15962b;
                if (bVar != null) {
                    bVar.dispose();
                }
            }
            long j2 = aVar.f15963c - 1;
            aVar.f15963c = j2;
            if (j2 == 0) {
                h.c.o0.a<T> aVar3 = this.a;
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
            if (aVar.f15963c == 0 && aVar == this.f15961f) {
                this.f15961f = null;
                h.c.k0.b bVar = aVar.get();
                h.c.n0.a.c.h(aVar);
                h.c.o0.a<T> aVar2 = this.a;
                if (aVar2 instanceof h.c.k0.b) {
                    ((h.c.k0.b) aVar2).dispose();
                } else if (aVar2 instanceof h.c.n0.a.f) {
                    if (bVar == null) {
                        aVar.f15965e = true;
                    } else {
                        ((h.c.n0.a.f) aVar2).a(bVar);
                    }
                }
            }
        }
    }

    @Override // h.c.s
    protected void subscribeActual(h.c.z<? super T> zVar) {
        a aVar;
        boolean z;
        h.c.k0.b bVar;
        synchronized (this) {
            aVar = this.f15961f;
            if (aVar == null) {
                aVar = new a(this);
                this.f15961f = aVar;
            }
            long j2 = aVar.f15963c;
            if (j2 == 0 && (bVar = aVar.f15962b) != null) {
                bVar.dispose();
            }
            long j3 = j2 + 1;
            aVar.f15963c = j3;
            z = true;
            if (aVar.f15964d || j3 != this.f15957b) {
                z = false;
            } else {
                aVar.f15964d = true;
            }
        }
        this.a.subscribe(new b(zVar, this, aVar));
        if (z) {
            this.a.b(aVar);
        }
    }

    public m2(h.c.o0.a<T> aVar, int i2, long j2, TimeUnit timeUnit, h.c.a0 a0Var) {
        this.a = aVar;
        this.f15957b = i2;
        this.f15958c = j2;
        this.f15959d = timeUnit;
        this.f15960e = a0Var;
    }
}