package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableRepeatWhen.java */
/* loaded from: classes3.dex */
public final class b3<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super h.c.h<Object>, ? extends k.a.b<?>> f14237b;

    /* compiled from: FlowableRepeatWhen.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends c<T, Object> {
        a(k.a.c<? super T> cVar, h.c.s0.a<Object> aVar, k.a.d dVar) {
            super(cVar, aVar, dVar);
        }

        @Override // k.a.c
        public void onComplete() {
            j(0);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f14243l.cancel();
            this.f14241j.onError(th);
        }
    }

    /* compiled from: FlowableRepeatWhen.java */
    /* loaded from: classes3.dex */
    static final class b<T, U> extends AtomicInteger implements h.c.m<Object>, k.a.d {
        final k.a.b<T> a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<k.a.d> f14238b = new AtomicReference<>();

        /* renamed from: c  reason: collision with root package name */
        final AtomicLong f14239c = new AtomicLong();

        /* renamed from: d  reason: collision with root package name */
        c<T, U> f14240d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(k.a.b<T> bVar) {
            this.a = bVar;
        }

        @Override // k.a.d
        public void cancel() {
            h.c.n0.i.g.h(this.f14238b);
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14240d.cancel();
            this.f14240d.f14241j.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f14240d.cancel();
            this.f14240d.f14241j.onError(th);
        }

        @Override // k.a.c
        public void onNext(Object obj) {
            if (getAndIncrement() == 0) {
                while (this.f14238b.get() != h.c.n0.i.g.CANCELLED) {
                    this.a.subscribe(this.f14240d);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.q(this.f14238b, this.f14239c, dVar);
        }

        @Override // k.a.d
        public void request(long j2) {
            h.c.n0.i.g.n(this.f14238b, this.f14239c, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableRepeatWhen.java */
    /* loaded from: classes3.dex */
    public static abstract class c<T, U> extends h.c.n0.i.f implements h.c.m<T> {

        /* renamed from: j  reason: collision with root package name */
        protected final k.a.c<? super T> f14241j;

        /* renamed from: k  reason: collision with root package name */
        protected final h.c.s0.a<U> f14242k;

        /* renamed from: l  reason: collision with root package name */
        protected final k.a.d f14243l;
        private long m;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(k.a.c<? super T> cVar, h.c.s0.a<U> aVar, k.a.d dVar) {
            super(false);
            this.f14241j = cVar;
            this.f14242k = aVar;
            this.f14243l = dVar;
        }

        @Override // h.c.n0.i.f, k.a.d
        public final void cancel() {
            super.cancel();
            this.f14243l.cancel();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void j(U u) {
            i(h.c.n0.i.d.INSTANCE);
            long j2 = this.m;
            if (j2 != 0) {
                this.m = 0L;
                g(j2);
            }
            this.f14243l.request(1L);
            this.f14242k.onNext(u);
        }

        @Override // k.a.c
        public final void onNext(T t) {
            this.m++;
            this.f14241j.onNext(t);
        }

        @Override // h.c.m, k.a.c
        public final void onSubscribe(k.a.d dVar) {
            i(dVar);
        }
    }

    public b3(h.c.h<T> hVar, h.c.m0.n<? super h.c.h<Object>, ? extends k.a.b<?>> nVar) {
        super(hVar);
        this.f14237b = nVar;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        h.c.w0.d dVar = new h.c.w0.d(cVar);
        h.c.s0.a<T> b2 = h.c.s0.c.e(8).b();
        try {
            k.a.b bVar = (k.a.b) h.c.n0.b.b.e(this.f14237b.apply(b2), "handler returned a null Publisher");
            b bVar2 = new b(this.a);
            a aVar = new a(dVar, b2, bVar2);
            bVar2.f14240d = aVar;
            cVar.onSubscribe(aVar);
            bVar.subscribe(bVar2);
            bVar2.onNext(0);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.i.d.q(th, cVar);
        }
    }
}