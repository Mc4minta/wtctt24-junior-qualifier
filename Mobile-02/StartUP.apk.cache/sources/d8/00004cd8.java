package h.c.n0.e.b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableScanSeed.java */
/* loaded from: classes3.dex */
public final class k3<T, R> extends h.c.n0.e.b.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.c<R, ? super T, R> f14578b;

    /* renamed from: c  reason: collision with root package name */
    final Callable<R> f14579c;

    /* compiled from: FlowableScanSeed.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements h.c.m<T>, k.a.d {
        final k.a.c<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.c<R, ? super T, R> f14580b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.n0.c.i<R> f14581c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicLong f14582d;

        /* renamed from: e  reason: collision with root package name */
        final int f14583e;

        /* renamed from: f  reason: collision with root package name */
        final int f14584f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f14585g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f14586h;

        /* renamed from: j  reason: collision with root package name */
        Throwable f14587j;

        /* renamed from: k  reason: collision with root package name */
        k.a.d f14588k;

        /* renamed from: l  reason: collision with root package name */
        R f14589l;
        int m;

        a(k.a.c<? super R> cVar, h.c.m0.c<R, ? super T, R> cVar2, R r, int i2) {
            this.a = cVar;
            this.f14580b = cVar2;
            this.f14589l = r;
            this.f14583e = i2;
            this.f14584f = i2 - (i2 >> 2);
            h.c.n0.f.b bVar = new h.c.n0.f.b(i2);
            this.f14581c = bVar;
            bVar.offer(r);
            this.f14582d = new AtomicLong();
        }

        void a() {
            int i2;
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            k.a.c<? super R> cVar = this.a;
            h.c.n0.c.i<R> iVar = this.f14581c;
            int i3 = this.f14584f;
            int i4 = this.m;
            int i5 = 1;
            do {
                long j2 = this.f14582d.get();
                long j3 = 0;
                while (true) {
                    i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (this.f14585g) {
                        iVar.clear();
                        return;
                    } else {
                        boolean z = this.f14586h;
                        if (z && (th = this.f14587j) != null) {
                            iVar.clear();
                            cVar.onError(th);
                            return;
                        }
                        Object obj = (R) iVar.poll();
                        boolean z2 = obj == null;
                        if (z && z2) {
                            cVar.onComplete();
                            return;
                        } else if (z2) {
                            break;
                        } else {
                            cVar.onNext(obj);
                            j3++;
                            i4++;
                            if (i4 == i3) {
                                this.f14588k.request(i3);
                                i4 = 0;
                            }
                        }
                    }
                }
                if (i2 == 0 && this.f14586h) {
                    Throwable th2 = this.f14587j;
                    if (th2 != null) {
                        iVar.clear();
                        cVar.onError(th2);
                        return;
                    } else if (iVar.isEmpty()) {
                        cVar.onComplete();
                        return;
                    }
                }
                if (j3 != 0) {
                    h.c.n0.j.d.e(this.f14582d, j3);
                }
                this.m = i4;
                i5 = addAndGet(-i5);
            } while (i5 != 0);
        }

        @Override // k.a.d
        public void cancel() {
            this.f14585g = true;
            this.f14588k.cancel();
            if (getAndIncrement() == 0) {
                this.f14581c.clear();
            }
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14586h) {
                return;
            }
            this.f14586h = true;
            a();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14586h) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14587j = th;
            this.f14586h = true;
            a();
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14586h) {
                return;
            }
            try {
                R r = (R) h.c.n0.b.b.e(this.f14580b.apply(this.f14589l, t), "The accumulator returned a null value");
                this.f14589l = r;
                this.f14581c.offer(r);
                a();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f14588k.cancel();
                onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14588k, dVar)) {
                this.f14588k = dVar;
                this.a.onSubscribe(this);
                dVar.request(this.f14583e - 1);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f14582d, j2);
                a();
            }
        }
    }

    public k3(h.c.h<T> hVar, Callable<R> callable, h.c.m0.c<R, ? super T, R> cVar) {
        super(hVar);
        this.f14578b = cVar;
        this.f14579c = callable;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        try {
            this.a.subscribe((h.c.m) new a(cVar, this.f14578b, h.c.n0.b.b.e(this.f14579c.call(), "The seed supplied is null"), h.c.h.bufferSize()));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.i.d.q(th, cVar);
        }
    }
}