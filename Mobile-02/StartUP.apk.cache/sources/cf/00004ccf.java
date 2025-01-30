package h.c.n0.e.b;

import java.util.concurrent.TimeUnit;

/* compiled from: FlowableTimeInterval.java */
/* loaded from: classes3.dex */
public final class j4<T> extends h.c.n0.e.b.a<T, h.c.u0.b<T>> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.a0 f14556b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f14557c;

    /* compiled from: FlowableTimeInterval.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.m<T>, k.a.d {
        final k.a.c<? super h.c.u0.b<T>> a;

        /* renamed from: b  reason: collision with root package name */
        final TimeUnit f14558b;

        /* renamed from: c  reason: collision with root package name */
        final h.c.a0 f14559c;

        /* renamed from: d  reason: collision with root package name */
        k.a.d f14560d;

        /* renamed from: e  reason: collision with root package name */
        long f14561e;

        a(k.a.c<? super h.c.u0.b<T>> cVar, TimeUnit timeUnit, h.c.a0 a0Var) {
            this.a = cVar;
            this.f14559c = a0Var;
            this.f14558b = timeUnit;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14560d.cancel();
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
            long b2 = this.f14559c.b(this.f14558b);
            long j2 = this.f14561e;
            this.f14561e = b2;
            this.a.onNext(new h.c.u0.b(t, b2 - j2, this.f14558b));
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14560d, dVar)) {
                this.f14561e = this.f14559c.b(this.f14558b);
                this.f14560d = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            this.f14560d.request(j2);
        }
    }

    public j4(h.c.h<T> hVar, TimeUnit timeUnit, h.c.a0 a0Var) {
        super(hVar);
        this.f14556b = a0Var;
        this.f14557c = timeUnit;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super h.c.u0.b<T>> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14557c, this.f14556b));
    }
}