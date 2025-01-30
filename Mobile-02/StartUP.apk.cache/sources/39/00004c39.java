package h.c.n0.e.b;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableTakeLast.java */
/* loaded from: classes3.dex */
public final class a4<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final int f14200b;

    /* compiled from: FlowableTakeLast.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends ArrayDeque<T> implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final int f14201b;

        /* renamed from: c  reason: collision with root package name */
        k.a.d f14202c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f14203d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f14204e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicLong f14205f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        final AtomicInteger f14206g = new AtomicInteger();

        a(k.a.c<? super T> cVar, int i2) {
            this.a = cVar;
            this.f14201b = i2;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14204e = true;
            this.f14202c.cancel();
        }

        void i() {
            if (this.f14206g.getAndIncrement() == 0) {
                k.a.c<? super T> cVar = this.a;
                long j2 = this.f14205f.get();
                while (!this.f14204e) {
                    if (this.f14203d) {
                        long j3 = 0;
                        while (j3 != j2) {
                            if (this.f14204e) {
                                return;
                            }
                            Object obj = (T) poll();
                            if (obj == null) {
                                cVar.onComplete();
                                return;
                            } else {
                                cVar.onNext(obj);
                                j3++;
                            }
                        }
                        if (j3 != 0 && j2 != Long.MAX_VALUE) {
                            j2 = this.f14205f.addAndGet(-j3);
                        }
                    }
                    if (this.f14206g.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14203d = true;
            i();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14201b == size()) {
                poll();
            }
            offer(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14202c, dVar)) {
                this.f14202c = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this.f14205f, j2);
                i();
            }
        }
    }

    public a4(h.c.h<T> hVar, int i2) {
        super(hVar);
        this.f14200b = i2;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14200b));
    }
}