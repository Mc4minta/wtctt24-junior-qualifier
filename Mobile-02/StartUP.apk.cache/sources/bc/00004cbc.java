package h.c.n0.e.b;

import h.c.a0;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableObserveOn.java */
/* loaded from: classes3.dex */
public final class i2<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.a0 f14501b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f14502c;

    /* renamed from: d  reason: collision with root package name */
    final int f14503d;

    /* compiled from: FlowableObserveOn.java */
    /* loaded from: classes3.dex */
    static abstract class a<T> extends h.c.n0.i.a<T> implements h.c.m<T>, Runnable {
        final a0.c a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f14504b;

        /* renamed from: c  reason: collision with root package name */
        final int f14505c;

        /* renamed from: d  reason: collision with root package name */
        final int f14506d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicLong f14507e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        k.a.d f14508f;

        /* renamed from: g  reason: collision with root package name */
        h.c.n0.c.j<T> f14509g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f14510h;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f14511j;

        /* renamed from: k  reason: collision with root package name */
        Throwable f14512k;

        /* renamed from: l  reason: collision with root package name */
        int f14513l;
        long m;
        boolean n;

        a(a0.c cVar, boolean z, int i2) {
            this.a = cVar;
            this.f14504b = z;
            this.f14505c = i2;
            this.f14506d = i2 - (i2 >> 2);
        }

        final boolean c(boolean z, boolean z2, k.a.c<?> cVar) {
            if (this.f14510h) {
                clear();
                return true;
            } else if (z) {
                if (this.f14504b) {
                    if (z2) {
                        this.f14510h = true;
                        Throwable th = this.f14512k;
                        if (th != null) {
                            cVar.onError(th);
                        } else {
                            cVar.onComplete();
                        }
                        this.a.dispose();
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.f14512k;
                if (th2 != null) {
                    this.f14510h = true;
                    clear();
                    cVar.onError(th2);
                    this.a.dispose();
                    return true;
                } else if (z2) {
                    this.f14510h = true;
                    cVar.onComplete();
                    this.a.dispose();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override // k.a.d
        public final void cancel() {
            if (this.f14510h) {
                return;
            }
            this.f14510h = true;
            this.f14508f.cancel();
            this.a.dispose();
            if (getAndIncrement() == 0) {
                this.f14509g.clear();
            }
        }

        @Override // h.c.n0.c.j
        public final void clear() {
            this.f14509g.clear();
        }

        abstract void d();

        abstract void e();

        abstract void f();

        final void g() {
            if (getAndIncrement() != 0) {
                return;
            }
            this.a.b(this);
        }

        @Override // h.c.n0.c.j
        public final boolean isEmpty() {
            return this.f14509g.isEmpty();
        }

        @Override // h.c.n0.c.f
        public final int n(int i2) {
            if ((i2 & 2) != 0) {
                this.n = true;
                return 2;
            }
            return 0;
        }

        @Override // k.a.c
        public final void onComplete() {
            if (this.f14511j) {
                return;
            }
            this.f14511j = true;
            g();
        }

        @Override // k.a.c
        public final void onError(Throwable th) {
            if (this.f14511j) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14512k = th;
            this.f14511j = true;
            g();
        }

        @Override // k.a.c
        public final void onNext(T t) {
            if (this.f14511j) {
                return;
            }
            if (this.f14513l == 2) {
                g();
                return;
            }
            if (!this.f14509g.offer(t)) {
                this.f14508f.cancel();
                this.f14512k = new MissingBackpressureException("Queue is full?!");
                this.f14511j = true;
            }
            g();
        }

        @Override // k.a.d
        public final void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f14507e, j2);
                g();
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.n) {
                e();
            } else if (this.f14513l == 1) {
                f();
            } else {
                d();
            }
        }
    }

    /* compiled from: FlowableObserveOn.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends a<T> {
        final h.c.n0.c.a<? super T> p;
        long q;

        b(h.c.n0.c.a<? super T> aVar, a0.c cVar, boolean z, int i2) {
            super(cVar, z, i2);
            this.p = aVar;
        }

        @Override // h.c.n0.e.b.i2.a
        void d() {
            int i2;
            h.c.n0.c.a<? super T> aVar = this.p;
            h.c.n0.c.j<T> jVar = this.f14509g;
            long j2 = this.m;
            long j3 = this.q;
            int i3 = 1;
            while (true) {
                long j4 = this.f14507e.get();
                while (true) {
                    i2 = (j2 > j4 ? 1 : (j2 == j4 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    }
                    boolean z = this.f14511j;
                    try {
                        Object obj = (T) jVar.poll();
                        boolean z2 = obj == null;
                        if (c(z, z2, aVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        if (aVar.h(obj)) {
                            j2++;
                        }
                        j3++;
                        if (j3 == this.f14506d) {
                            this.f14508f.request(j3);
                            j3 = 0;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f14510h = true;
                        this.f14508f.cancel();
                        jVar.clear();
                        aVar.onError(th);
                        this.a.dispose();
                        return;
                    }
                }
                if (i2 == 0 && c(this.f14511j, jVar.isEmpty(), aVar)) {
                    return;
                }
                int i4 = get();
                if (i3 == i4) {
                    this.m = j2;
                    this.q = j3;
                    i3 = addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                } else {
                    i3 = i4;
                }
            }
        }

        @Override // h.c.n0.e.b.i2.a
        void e() {
            int i2 = 1;
            while (!this.f14510h) {
                boolean z = this.f14511j;
                this.p.onNext(null);
                if (z) {
                    this.f14510h = true;
                    Throwable th = this.f14512k;
                    if (th != null) {
                        this.p.onError(th);
                    } else {
                        this.p.onComplete();
                    }
                    this.a.dispose();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        @Override // h.c.n0.e.b.i2.a
        void f() {
            h.c.n0.c.a<? super T> aVar = this.p;
            h.c.n0.c.j<T> jVar = this.f14509g;
            long j2 = this.m;
            int i2 = 1;
            while (true) {
                long j3 = this.f14507e.get();
                while (j2 != j3) {
                    try {
                        Object obj = (T) jVar.poll();
                        if (this.f14510h) {
                            return;
                        }
                        if (obj == null) {
                            this.f14510h = true;
                            aVar.onComplete();
                            this.a.dispose();
                            return;
                        } else if (aVar.h(obj)) {
                            j2++;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f14510h = true;
                        this.f14508f.cancel();
                        aVar.onError(th);
                        this.a.dispose();
                        return;
                    }
                }
                if (this.f14510h) {
                    return;
                }
                if (jVar.isEmpty()) {
                    this.f14510h = true;
                    aVar.onComplete();
                    this.a.dispose();
                    return;
                }
                int i3 = get();
                if (i2 == i3) {
                    this.m = j2;
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    i2 = i3;
                }
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14508f, dVar)) {
                this.f14508f = dVar;
                if (dVar instanceof h.c.n0.c.g) {
                    h.c.n0.c.g gVar = (h.c.n0.c.g) dVar;
                    int n = gVar.n(7);
                    if (n == 1) {
                        this.f14513l = 1;
                        this.f14509g = gVar;
                        this.f14511j = true;
                        this.p.onSubscribe(this);
                        return;
                    } else if (n == 2) {
                        this.f14513l = 2;
                        this.f14509g = gVar;
                        this.p.onSubscribe(this);
                        dVar.request(this.f14505c);
                        return;
                    }
                }
                this.f14509g = new h.c.n0.f.b(this.f14505c);
                this.p.onSubscribe(this);
                dVar.request(this.f14505c);
            }
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            T poll = this.f14509g.poll();
            if (poll != null && this.f14513l != 1) {
                long j2 = this.q + 1;
                if (j2 == this.f14506d) {
                    this.q = 0L;
                    this.f14508f.request(j2);
                } else {
                    this.q = j2;
                }
            }
            return poll;
        }
    }

    /* compiled from: FlowableObserveOn.java */
    /* loaded from: classes3.dex */
    static final class c<T> extends a<T> implements h.c.m<T> {
        final k.a.c<? super T> p;

        c(k.a.c<? super T> cVar, a0.c cVar2, boolean z, int i2) {
            super(cVar2, z, i2);
            this.p = cVar;
        }

        @Override // h.c.n0.e.b.i2.a
        void d() {
            int i2;
            k.a.c<? super T> cVar = this.p;
            h.c.n0.c.j<T> jVar = this.f14509g;
            long j2 = this.m;
            int i3 = 1;
            while (true) {
                long j3 = this.f14507e.get();
                while (true) {
                    i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    }
                    boolean z = this.f14511j;
                    try {
                        Object obj = (T) jVar.poll();
                        boolean z2 = obj == null;
                        if (c(z, z2, cVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        cVar.onNext(obj);
                        j2++;
                        if (j2 == this.f14506d) {
                            if (j3 != Long.MAX_VALUE) {
                                j3 = this.f14507e.addAndGet(-j2);
                            }
                            this.f14508f.request(j2);
                            j2 = 0;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f14510h = true;
                        this.f14508f.cancel();
                        jVar.clear();
                        cVar.onError(th);
                        this.a.dispose();
                        return;
                    }
                }
                if (i2 == 0 && c(this.f14511j, jVar.isEmpty(), cVar)) {
                    return;
                }
                int i4 = get();
                if (i3 == i4) {
                    this.m = j2;
                    i3 = addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                } else {
                    i3 = i4;
                }
            }
        }

        @Override // h.c.n0.e.b.i2.a
        void e() {
            int i2 = 1;
            while (!this.f14510h) {
                boolean z = this.f14511j;
                this.p.onNext(null);
                if (z) {
                    this.f14510h = true;
                    Throwable th = this.f14512k;
                    if (th != null) {
                        this.p.onError(th);
                    } else {
                        this.p.onComplete();
                    }
                    this.a.dispose();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        @Override // h.c.n0.e.b.i2.a
        void f() {
            k.a.c<? super T> cVar = this.p;
            h.c.n0.c.j<T> jVar = this.f14509g;
            long j2 = this.m;
            int i2 = 1;
            while (true) {
                long j3 = this.f14507e.get();
                while (j2 != j3) {
                    try {
                        Object obj = (T) jVar.poll();
                        if (this.f14510h) {
                            return;
                        }
                        if (obj == null) {
                            this.f14510h = true;
                            cVar.onComplete();
                            this.a.dispose();
                            return;
                        }
                        cVar.onNext(obj);
                        j2++;
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f14510h = true;
                        this.f14508f.cancel();
                        cVar.onError(th);
                        this.a.dispose();
                        return;
                    }
                }
                if (this.f14510h) {
                    return;
                }
                if (jVar.isEmpty()) {
                    this.f14510h = true;
                    cVar.onComplete();
                    this.a.dispose();
                    return;
                }
                int i3 = get();
                if (i2 == i3) {
                    this.m = j2;
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    i2 = i3;
                }
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14508f, dVar)) {
                this.f14508f = dVar;
                if (dVar instanceof h.c.n0.c.g) {
                    h.c.n0.c.g gVar = (h.c.n0.c.g) dVar;
                    int n = gVar.n(7);
                    if (n == 1) {
                        this.f14513l = 1;
                        this.f14509g = gVar;
                        this.f14511j = true;
                        this.p.onSubscribe(this);
                        return;
                    } else if (n == 2) {
                        this.f14513l = 2;
                        this.f14509g = gVar;
                        this.p.onSubscribe(this);
                        dVar.request(this.f14505c);
                        return;
                    }
                }
                this.f14509g = new h.c.n0.f.b(this.f14505c);
                this.p.onSubscribe(this);
                dVar.request(this.f14505c);
            }
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            T poll = this.f14509g.poll();
            if (poll != null && this.f14513l != 1) {
                long j2 = this.m + 1;
                if (j2 == this.f14506d) {
                    this.m = 0L;
                    this.f14508f.request(j2);
                } else {
                    this.m = j2;
                }
            }
            return poll;
        }
    }

    public i2(h.c.h<T> hVar, h.c.a0 a0Var, boolean z, int i2) {
        super(hVar);
        this.f14501b = a0Var;
        this.f14502c = z;
        this.f14503d = i2;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        a0.c a2 = this.f14501b.a();
        if (cVar instanceof h.c.n0.c.a) {
            this.a.subscribe((h.c.m) new b((h.c.n0.c.a) cVar, a2, this.f14502c, this.f14503d));
        } else {
            this.a.subscribe((h.c.m) new c(cVar, a2, this.f14502c, this.f14503d));
        }
    }
}