package h.c.n0.h;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: SinglePostCompleteSubscriber.java */
/* loaded from: classes3.dex */
public abstract class s<T, R> extends AtomicLong implements h.c.m<T>, k.a.d {
    protected final k.a.c<? super R> a;

    /* renamed from: b  reason: collision with root package name */
    protected k.a.d f16745b;

    /* renamed from: c  reason: collision with root package name */
    protected R f16746c;

    /* renamed from: d  reason: collision with root package name */
    protected long f16747d;

    public s(k.a.c<? super R> cVar) {
        this.a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(R r) {
        long j2 = this.f16747d;
        if (j2 != 0) {
            h.c.n0.j.d.e(this, j2);
        }
        while (true) {
            long j3 = get();
            if ((j3 & Long.MIN_VALUE) != 0) {
                b(r);
                return;
            } else if ((j3 & Long.MAX_VALUE) != 0) {
                lazySet(-9223372036854775807L);
                this.a.onNext(r);
                this.a.onComplete();
                return;
            } else {
                this.f16746c = r;
                if (compareAndSet(0L, Long.MIN_VALUE)) {
                    return;
                }
                this.f16746c = null;
            }
        }
    }

    protected void b(R r) {
    }

    public void cancel() {
        this.f16745b.cancel();
    }

    @Override // h.c.m, k.a.c
    public void onSubscribe(k.a.d dVar) {
        if (h.c.n0.i.g.C(this.f16745b, dVar)) {
            this.f16745b = dVar;
            this.a.onSubscribe(this);
        }
    }

    @Override // k.a.d
    public final void request(long j2) {
        long j3;
        if (h.c.n0.i.g.B(j2)) {
            do {
                j3 = get();
                if ((j3 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) {
                        this.a.onNext((R) this.f16746c);
                        this.a.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j3, h.c.n0.j.d.c(j3, j2)));
            this.f16745b.request(j2);
        }
    }
}