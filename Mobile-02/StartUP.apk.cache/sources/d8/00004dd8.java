package h.c.n0.e.b;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: FlowableTake.java */
/* loaded from: classes3.dex */
public final class z3<T> extends h.c.n0.e.b.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f15323b;

    /* compiled from: FlowableTake.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicBoolean implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final long f15324b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15325c;

        /* renamed from: d  reason: collision with root package name */
        k.a.d f15326d;

        /* renamed from: e  reason: collision with root package name */
        long f15327e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(k.a.c<? super T> cVar, long j2) {
            this.a = cVar;
            this.f15324b = j2;
            this.f15327e = j2;
        }

        @Override // k.a.d
        public void cancel() {
            this.f15326d.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f15325c) {
                return;
            }
            this.f15325c = true;
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (!this.f15325c) {
                this.f15325c = true;
                this.f15326d.cancel();
                this.a.onError(th);
                return;
            }
            h.c.r0.a.u(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f15325c) {
                return;
            }
            long j2 = this.f15327e;
            long j3 = j2 - 1;
            this.f15327e = j3;
            if (j2 > 0) {
                boolean z = j3 == 0;
                this.a.onNext(t);
                if (z) {
                    this.f15326d.cancel();
                    onComplete();
                }
            }
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f15326d, dVar)) {
                this.f15326d = dVar;
                if (this.f15324b == 0) {
                    dVar.cancel();
                    this.f15325c = true;
                    h.c.n0.i.d.h(this.a);
                    return;
                }
                this.a.onSubscribe(this);
            }
        }

        @Override // k.a.d
        public void request(long j2) {
            if (h.c.n0.i.g.B(j2)) {
                if (!get() && compareAndSet(false, true) && j2 >= this.f15324b) {
                    this.f15326d.request(Long.MAX_VALUE);
                } else {
                    this.f15326d.request(j2);
                }
            }
        }
    }

    public z3(h.c.h<T> hVar, long j2) {
        super(hVar);
        this.f15323b = j2;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar, this.f15323b));
    }
}