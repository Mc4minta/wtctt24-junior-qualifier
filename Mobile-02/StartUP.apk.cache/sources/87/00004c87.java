package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableDebounce.java */
/* loaded from: classes3.dex */
public final class f0<T, U> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.n<? super T, ? extends k.a.b<U>> f14381b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableDebounce.java */
    /* loaded from: classes3.dex */
    public static final class a<T, U> extends AtomicLong implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.n<? super T, ? extends k.a.b<U>> f14382b;

        /* renamed from: c  reason: collision with root package name */
        k.a.d f14383c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<h.c.k0.b> f14384d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        volatile long f14385e;

        /* renamed from: f  reason: collision with root package name */
        boolean f14386f;

        /* compiled from: FlowableDebounce.java */
        /* renamed from: h.c.n0.e.b.f0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0350a<T, U> extends h.c.w0.b<U> {

            /* renamed from: b  reason: collision with root package name */
            final a<T, U> f14387b;

            /* renamed from: c  reason: collision with root package name */
            final long f14388c;

            /* renamed from: d  reason: collision with root package name */
            final T f14389d;

            /* renamed from: e  reason: collision with root package name */
            boolean f14390e;

            /* renamed from: f  reason: collision with root package name */
            final AtomicBoolean f14391f = new AtomicBoolean();

            C0350a(a<T, U> aVar, long j2, T t) {
                this.f14387b = aVar;
                this.f14388c = j2;
                this.f14389d = t;
            }

            void d() {
                if (this.f14391f.compareAndSet(false, true)) {
                    this.f14387b.a(this.f14388c, this.f14389d);
                }
            }

            @Override // k.a.c
            public void onComplete() {
                if (this.f14390e) {
                    return;
                }
                this.f14390e = true;
                d();
            }

            @Override // k.a.c
            public void onError(Throwable th) {
                if (this.f14390e) {
                    h.c.r0.a.u(th);
                    return;
                }
                this.f14390e = true;
                this.f14387b.onError(th);
            }

            @Override // k.a.c
            public void onNext(U u) {
                if (this.f14390e) {
                    return;
                }
                this.f14390e = true;
                b();
                d();
            }
        }

        a(k.a.c<? super T> cVar, h.c.m0.n<? super T, ? extends k.a.b<U>> nVar) {
            this.a = cVar;
            this.f14382b = nVar;
        }

        void a(long j2, T t) {
            if (j2 == this.f14385e) {
                if (get() != 0) {
                    this.a.onNext(t);
                    h.c.n0.j.d.e(this, 1L);
                    return;
                }
                cancel();
                this.a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            }
        }

        @Override // k.a.d
        public void cancel() {
            this.f14383c.cancel();
            h.c.n0.a.c.h(this.f14384d);
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14386f) {
                return;
            }
            this.f14386f = true;
            h.c.k0.b bVar = this.f14384d.get();
            if (h.c.n0.a.c.n(bVar)) {
                return;
            }
            ((C0350a) bVar).d();
            h.c.n0.a.c.h(this.f14384d);
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            h.c.n0.a.c.h(this.f14384d);
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14386f) {
                return;
            }
            long j2 = this.f14385e + 1;
            this.f14385e = j2;
            h.c.k0.b bVar = this.f14384d.get();
            if (bVar != null) {
                bVar.dispose();
            }
            try {
                k.a.b bVar2 = (k.a.b) h.c.n0.b.b.e(this.f14382b.apply(t), "The publisher supplied is null");
                C0350a c0350a = new C0350a(this, j2, t);
                if (this.f14384d.compareAndSet(bVar, c0350a)) {
                    bVar2.subscribe(c0350a);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                cancel();
                this.a.onError(th);
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14383c, dVar)) {
                this.f14383c = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                h.c.n0.j.d.a(this, j2);
            }
        }
    }

    public f0(h.c.h<T> hVar, h.c.m0.n<? super T, ? extends k.a.b<U>> nVar) {
        super(hVar);
        this.f14381b = nVar;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(new h.c.w0.d(cVar), this.f14381b));
    }
}