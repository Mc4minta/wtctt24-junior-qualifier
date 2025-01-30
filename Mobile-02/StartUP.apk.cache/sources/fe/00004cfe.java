package h.c.n0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableOnBackpressureError.java */
/* loaded from: classes3.dex */
public final class m2<T> extends h.c.n0.e.b.a<T, T> {

    /* compiled from: FlowableOnBackpressureError.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicLong implements h.c.m<T>, k.a.d {
        final k.a.c<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        k.a.d f14715b;

        /* renamed from: c  reason: collision with root package name */
        boolean f14716c;

        a(k.a.c<? super T> cVar) {
            this.a = cVar;
        }

        @Override // k.a.d
        public void cancel() {
            this.f14715b.cancel();
        }

        @Override // k.a.c
        public void onComplete() {
            if (this.f14716c) {
                return;
            }
            this.f14716c = true;
            this.a.onComplete();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            if (this.f14716c) {
                h.c.r0.a.u(th);
                return;
            }
            this.f14716c = true;
            this.a.onError(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            if (this.f14716c) {
                return;
            }
            if (get() != 0) {
                this.a.onNext(t);
                h.c.n0.j.d.e(this, 1L);
                return;
            }
            onError(new MissingBackpressureException("could not emit value due to lack of requests"));
        }

        @Override // h.c.m, k.a.c
        public void onSubscribe(k.a.d dVar) {
            if (h.c.n0.i.g.C(this.f14715b, dVar)) {
                this.f14715b = dVar;
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

    public m2(h.c.h<T> hVar) {
        super(hVar);
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe((h.c.m) new a(cVar));
    }
}