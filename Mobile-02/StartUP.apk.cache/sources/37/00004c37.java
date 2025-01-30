package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FlowableRepeatUntil.java */
/* loaded from: classes3.dex */
public final class a3<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.e f14195b;

    /* compiled from: FlowableRepeatUntil.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements h.c.m<T> {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.n0.i.f f14196b;

        /* renamed from: c  reason: collision with root package name */
        final k.a.b<? extends T> f14197c;

        /* renamed from: d  reason: collision with root package name */
        final h.c.m0.e f14198d;

        /* renamed from: e  reason: collision with root package name */
        long f14199e;

        a(k.a.c<? super T> cVar, h.c.m0.e eVar, h.c.n0.i.f fVar, k.a.b<? extends T> bVar) {
            this.a = cVar;
            this.f14196b = fVar;
            this.f14197c = bVar;
            this.f14198d = eVar;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f14196b.e()) {
                    long j2 = this.f14199e;
                    if (j2 != 0) {
                        this.f14199e = 0L;
                        this.f14196b.g(j2);
                    }
                    this.f14197c.subscribe(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // k.a.c
        public void onComplete() {
            try {
                if (this.f14198d.a()) {
                    this.a.onComplete();
                } else {
                    a();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.a.onError(th);
            }
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.f14199e++;
            this.a.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            this.f14196b.i(dVar);
        }
    }

    public a3(h.c.h<T> hVar, h.c.m0.e eVar) {
        super(hVar);
        this.f14195b = eVar;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        h.c.n0.i.f fVar = new h.c.n0.i.f(false);
        cVar.onSubscribe(fVar);
        new a(cVar, this.f14195b, fVar, this.a).a();
    }
}