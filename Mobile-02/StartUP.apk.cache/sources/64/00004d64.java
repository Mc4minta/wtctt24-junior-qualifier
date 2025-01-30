package h.c.n0.e.b;

import java.util.NoSuchElementException;

/* compiled from: FlowableElementAt.java */
/* loaded from: classes3.dex */
public final class s0<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f14969b;

    /* renamed from: c  reason: collision with root package name */
    final T f14970c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f14971d;

    /* compiled from: FlowableElementAt.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.i.c<T> implements h.c.m<T> {

        /* renamed from: c  reason: collision with root package name */
        final long f14972c;

        /* renamed from: d  reason: collision with root package name */
        final T f14973d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f14974e;

        /* renamed from: f  reason: collision with root package name */
        k.a.d f14975f;

        /* renamed from: g  reason: collision with root package name */
        long f14976g;

        /* renamed from: h  reason: collision with root package name */
        boolean f14977h;

        a(k.a.c<? super T> cVar, long j2, T t, boolean z) {
            super(cVar);
            this.f14972c = j2;
            this.f14973d = t;
            this.f14974e = z;
        }

        @Override // h.c.n0.i.c, k.a.d
        public void cancel() {
            super.cancel();
            this.f14975f.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14977h) {
                return;
            }
            this.f14977h = true;
            T t = this.f14973d;
            if (t == null) {
                if (this.f14974e) {
                    this.a.onError(new NoSuchElementException());
                    return;
                } else {
                    this.a.onComplete();
                    return;
                }
            }
            c(t);
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14977h) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14977h = true;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14977h) {
                return;
            }
            long j2 = this.f14976g;
            if (j2 == this.f14972c) {
                this.f14977h = true;
                this.f14975f.cancel();
                c(t);
                return;
            }
            this.f14976g = j2 + 1;
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14975f, dVar)) {
                this.f14975f = dVar;
                this.a.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public s0(h.c.h<T> hVar, long j2, T t, boolean z) {
        super(hVar);
        this.f14969b = j2;
        this.f14970c = t;
        this.f14971d = z;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f14969b, this.f14970c, this.f14971d));
    }
}