package h.c.n0.e.b;

import h.c.a0;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableSubscribeOn.java */
/* loaded from: classes3.dex */
public final class w3<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.a0 f15185b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f15186c;

    /* compiled from: FlowableSubscribeOn.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<Thread> implements h.c.m<T>, k.a.d, Runnable {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final a0.c f15187b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<k.a.d> f15188c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        final AtomicLong f15189d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        final boolean f15190e;

        /* renamed from: f  reason: collision with root package name */
        k.a.b<T> f15191f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FlowableSubscribeOn.java */
        /* renamed from: h.c.n0.e.b.w3$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class RunnableC0359a implements Runnable {
            final k.a.d a;

            /* renamed from: b  reason: collision with root package name */
            final long f15192b;

            RunnableC0359a(k.a.d dVar, long j2) {
                this.a = dVar;
                this.f15192b = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.request(this.f15192b);
            }
        }

        a(k.a.c<? super T> cVar, a0.c cVar2, k.a.b<T> bVar, boolean z) {
            this.a = cVar;
            this.f15187b = cVar2;
            this.f15191f = bVar;
            this.f15190e = !z;
        }

        void a(long j2, k.a.d dVar) {
            if (!this.f15190e && Thread.currentThread() != get()) {
                this.f15187b.b(new RunnableC0359a(dVar, j2));
            } else {
                dVar.request(j2);
            }
        }

        @Override // k.a.d
        public void cancel() {
            h.c.n0.i.g.h(this.f15188c);
            this.f15187b.dispose();
        }

        @Override // k.a.c
        public void onComplete() {
            this.a.onComplete();
            this.f15187b.dispose();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
            this.f15187b.dispose();
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.z(this.f15188c, dVar)) {
                long andSet = this.f15189d.getAndSet(0L);
                if (andSet != 0) {
                    a(andSet, dVar);
                }
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                k.a.d dVar = this.f15188c.get();
                if (dVar != null) {
                    a(j2, dVar);
                    return;
                }
                h.c.n0.j.d.a(this.f15189d, j2);
                k.a.d dVar2 = this.f15188c.get();
                if (dVar2 != null) {
                    long andSet = this.f15189d.getAndSet(0L);
                    if (andSet != 0) {
                        a(andSet, dVar2);
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            k.a.b<T> bVar = this.f15191f;
            this.f15191f = null;
            bVar.subscribe(this);
        }
    }

    public w3(h.c.h<T> hVar, h.c.a0 a0Var, boolean z) {
        super(hVar);
        this.f15185b = a0Var;
        this.f15186c = z;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        a0.c a2 = this.f15185b.a();
        a aVar = new a(cVar, a2, this.a, this.f15186c);
        cVar.onSubscribe(aVar);
        a2.b(aVar);
    }
}