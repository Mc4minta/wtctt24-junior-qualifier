package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableWithLatestFrom.java */
/* loaded from: classes3.dex */
public final class w4<T, U, R> extends h.c.n0.e.b.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.c<? super T, ? super U, ? extends R> f15193b;

    /* renamed from: c  reason: collision with root package name */
    final k.a.b<? extends U> f15194c;

    /* compiled from: FlowableWithLatestFrom.java */
    /* loaded from: classes3.dex */
    final class a implements h.c.m<U> {
        private final b<T, U, R> a;

        a(b<T, U, R> bVar) {
            this.a = bVar;
        }

        @Override // k.a.c
        public void onComplete() {
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.a.a(th);
        }

        @Override // k.a.c
        public void onNext(U u) {
            this.a.lazySet(u);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (this.a.b(dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    /* compiled from: FlowableWithLatestFrom.java */
    /* loaded from: classes3.dex */
    static final class b<T, U, R> extends AtomicReference<U> implements h.c.n0.c.a<T>, k.a.d {
        final k.a.c<? super R> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.c<? super T, ? super U, ? extends R> f15196b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<k.a.d> f15197c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        final AtomicLong f15198d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<k.a.d> f15199e = new AtomicReference<>();

        b(k.a.c<? super R> cVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar2) {
            this.a = cVar;
            this.f15196b = cVar2;
        }

        public void a(Throwable th) {
            h.c.n0.i.g.h(this.f15197c);
            this.a.onError(th);
        }

        public boolean b(k.a.d dVar) {
            return h.c.n0.i.g.z(this.f15199e, dVar);
        }

        @Override // k.a.d
        public void cancel() {
            h.c.n0.i.g.h(this.f15197c);
            h.c.n0.i.g.h(this.f15199e);
        }

        @Override // h.c.n0.c.a
        public boolean h(T t) {
            U u = get();
            if (u != null) {
                try {
                    this.a.onNext(h.c.n0.b.b.e(this.f15196b.apply(t, u), "The combiner returned a null value"));
                    return true;
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    cancel();
                    this.a.onError(th);
                }
            }
            return false;
        }

        @Override // k.a.c
        public void onComplete() {
            h.c.n0.i.g.h(this.f15199e);
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            h.c.n0.i.g.h(this.f15199e);
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (h(t)) {
                return;
            }
            this.f15197c.get().request(1L);
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            h.c.n0.i.g.q(this.f15197c, this.f15198d, dVar);
        }

        @Override // k.a.d
        public void request(long j2) {
            h.c.n0.i.g.n(this.f15197c, this.f15198d, j2);
        }
    }

    public w4(h.c.h<T> hVar, h.c.m0.c<? super T, ? super U, ? extends R> cVar, k.a.b<? extends U> bVar) {
        super(hVar);
        this.f15193b = cVar;
        this.f15194c = bVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super R> cVar) {
        h.c.w0.d dVar = new h.c.w0.d(cVar);
        b bVar = new b(dVar, this.f15193b);
        dVar.onSubscribe(bVar);
        this.f15194c.subscribe(new a(bVar));
        this.a.subscribe((h.c.m) bVar);
    }
}