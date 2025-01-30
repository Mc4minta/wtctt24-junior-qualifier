package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableOnBackpressureBuffer.java */
/* loaded from: classes3.dex */
public final class j2<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final int f14538b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f14539c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f14540d;

    /* renamed from: e  reason: collision with root package name */
    final h.c.m0.a f14541e;

    /* compiled from: FlowableOnBackpressureBuffer.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.i.a<T> implements h.c.m<T> {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.c.i<T> f14542b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f14543c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.m0.a f14544d;

        /* renamed from: e  reason: collision with root package name */
        k.a.d f14545e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f14546f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f14547g;

        /* renamed from: h  reason: collision with root package name */
        Throwable f14548h;

        /* renamed from: j  reason: collision with root package name */
        final AtomicLong f14549j = new AtomicLong();

        /* renamed from: k  reason: collision with root package name */
        boolean f14550k;

        a(k.a.c<? super T> cVar, int i2, boolean z, boolean z2, h.c.m0.a aVar) {
            h.c.n0.c.i<T> bVar;
            this.a = cVar;
            this.f14544d = aVar;
            this.f14543c = z2;
            if (z) {
                bVar = new h.c.n0.f.c<>(i2);
            } else {
                bVar = new h.c.n0.f.b<>(i2);
            }
            this.f14542b = bVar;
        }

        void b() {
            int i2;
            if (getAndIncrement() == 0) {
                h.c.n0.c.i<T> iVar = this.f14542b;
                k.a.c<? super T> cVar = this.a;
                int i3 = 1;
                while (!c(this.f14547g, iVar.isEmpty(), cVar)) {
                    long j2 = this.f14549j.get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z = this.f14547g;
                        Object obj = (T) iVar.poll();
                        boolean z2 = obj == null;
                        if (c(z, z2, cVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        cVar.onNext(obj);
                        j3++;
                    }
                    if (i2 == 0 && c(this.f14547g, iVar.isEmpty(), cVar)) {
                        return;
                    }
                    if (j3 != 0 && j2 != Long.MAX_VALUE) {
                        this.f14549j.addAndGet(-j3);
                    }
                    i3 = addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                }
            }
        }

        boolean c(boolean z, boolean z2, k.a.c<? super T> cVar) {
            if (this.f14546f) {
                this.f14542b.clear();
                return true;
            } else if (z) {
                if (this.f14543c) {
                    if (z2) {
                        Throwable th = this.f14548h;
                        if (th != null) {
                            cVar.onError(th);
                        } else {
                            cVar.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.f14548h;
                if (th2 != null) {
                    this.f14542b.clear();
                    cVar.onError(th2);
                    return true;
                } else if (z2) {
                    cVar.onComplete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override // k.a.d
        public void cancel() {
            if (this.f14546f) {
                return;
            }
            this.f14546f = true;
            this.f14545e.cancel();
            if (getAndIncrement() == 0) {
                this.f14542b.clear();
            }
        }

        @Override // h.c.n0.c.j
        public void clear() {
            this.f14542b.clear();
        }

        @Override // h.c.n0.c.j
        public boolean isEmpty() {
            return this.f14542b.isEmpty();
        }

        @Override // h.c.n0.c.f
        public int n(int i2) {
            if ((i2 & 2) != 0) {
                this.f14550k = true;
                return 2;
            }
            return 0;
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14547g = true;
            if (this.f14550k) {
                this.a.onComplete();
            } else {
                b();
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f14548h = th;
            this.f14547g = true;
            if (this.f14550k) {
                this.a.onError(th);
            } else {
                b();
            }
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (!this.f14542b.offer(t)) {
                this.f14545e.cancel();
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
                try {
                    this.f14544d.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    missingBackpressureException.initCause(th);
                }
                onError(missingBackpressureException);
            } else if (this.f14550k) {
                this.a.onNext(null);
            } else {
                b();
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14545e, dVar)) {
                this.f14545e = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // h.c.n0.c.j
        public T poll() throws Exception {
            return this.f14542b.poll();
        }

        @Override // k.a.d
        public void request(long j2) {
            if (this.f14550k || !h.c.n0.i.g.B(j2)) {
                return;
            }
            h.c.n0.j.d.a(this.f14549j, j2);
            b();
        }
    }

    public j2(h.c.h<T> hVar, int i2, boolean z, boolean z2, h.c.m0.a aVar) {
        super(hVar);
        this.f14538b = i2;
        this.f14539c = z;
        this.f14540d = z2;
        this.f14541e = aVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14538b, this.f14539c, this.f14540d, this.f14541e));
    }
}