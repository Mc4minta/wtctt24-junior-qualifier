package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableDelaySubscriptionOther.java */
/* loaded from: classes3.dex */
public final class j0<T, U> extends h.c.h<T> {
    final k.a.b<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final k.a.b<U> f14533b;

    /* compiled from: FlowableDelaySubscriptionOther.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicLong implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final k.a.b<? extends T> f14534b;

        /* renamed from: c  reason: collision with root package name */
        final a<T>.C0354a f14535c = new C0354a();

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<k.a.d> f14536d = new AtomicReference<>();

        /* compiled from: FlowableDelaySubscriptionOther.java */
        /* renamed from: h.c.n0.e.b.j0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class C0354a extends AtomicReference<k.a.d> implements h.c.m<Object> {
            C0354a() {
            }

            @Override // k.a.c
            public void onComplete() {
                if (get() != h.c.n0.i.g.CANCELLED) {
                    a.this.a();
                }
            }

            @Override // k.a.c
            public void onError(Throwable th) {
                if (get() != h.c.n0.i.g.CANCELLED) {
                    a.this.a.onError(th);
                } else {
                    h.c.r0.a.u(th);
                }
            }

            @Override // k.a.c
            public void onNext(Object obj) {
                k.a.d dVar = get();
                h.c.n0.i.g gVar = h.c.n0.i.g.CANCELLED;
                if (dVar != gVar) {
                    lazySet(gVar);
                    dVar.cancel();
                    a.this.a();
                }
            }

            @Override // h.c.m, k.a.c
            public void onSubscribe(k.a.d dVar) {
                if (h.c.n0.i.g.z(this, dVar)) {
                    dVar.request(Long.MAX_VALUE);
                }
            }
        }

        a(k.a.c<? super T> cVar, k.a.b<? extends T> bVar) {
            this.a = cVar;
            this.f14534b = bVar;
        }

        void a() {
            this.f14534b.subscribe(this);
        }

        @Override // k.a.d
        public void cancel() {
            h.c.n0.i.g.h(this.f14535c);
            h.c.n0.i.g.h(this.f14536d);
        }

        @Override // k.a.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.q(this.f14536d, this, dVar);
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.i.g.n(this.f14536d, this, j2);
            }
        }
    }

    public j0(k.a.b<? extends T> bVar, k.a.b<U> bVar2) {
        this.a = bVar;
        this.f14533b = bVar2;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        a aVar = new a(cVar, this.a);
        cVar.onSubscribe(aVar);
        this.f14533b.subscribe(aVar.f14535c);
    }
}