package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: FlowableUnsubscribeOn.java */
/* loaded from: classes3.dex */
public final class p4<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.a0 f14832b;

    /* compiled from: FlowableUnsubscribeOn.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicBoolean implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.a0 f14833b;

        /* renamed from: c  reason: collision with root package name */
        k.a.d f14834c;

        /* compiled from: FlowableUnsubscribeOn.java */
        /* renamed from: h.c.n0.e.b.p4$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class RunnableC0356a implements Runnable {
            RunnableC0356a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f14834c.cancel();
            }
        }

        a(k.a.c<? super T> cVar, h.c.a0 a0Var) {
            this.a = cVar;
            this.f14833b = a0Var;
        }

        @Override // k.a.d
        public void cancel() {
            if (compareAndSet(false, true)) {
                this.f14833b.c(new RunnableC0356a());
            }
        }

        @Override // k.a.c
        public void onComplete() {
            if (get()) {
                return;
            }
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (get()) {
                h.c.r0.a.u(th);
            } else {
                this.a.onError(th);
            }
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.a.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14834c, dVar)) {
                this.f14834c = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            this.f14834c.request(j2);
        }
    }

    public p4(h.c.h<T> hVar, h.c.a0 a0Var) {
        super(hVar);
        this.f14832b = a0Var;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14832b));
    }
}