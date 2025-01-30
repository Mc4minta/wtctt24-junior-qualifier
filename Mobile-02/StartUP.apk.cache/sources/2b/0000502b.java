package h.c.n0.h;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: StrictSubscriber.java */
/* loaded from: classes3.dex */
public class t<T> extends AtomicInteger implements h.c.m<T>, k.a.d {
    final k.a.c<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.n0.j.c f16748b = new h.c.n0.j.c();

    /* renamed from: c  reason: collision with root package name */
    final AtomicLong f16749c = new AtomicLong();

    /* renamed from: d  reason: collision with root package name */
    final AtomicReference<k.a.d> f16750d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    final AtomicBoolean f16751e = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f16752f;

    public t(k.a.c<? super T> cVar) {
        this.a = cVar;
    }

    @Override // k.a.d
    public void cancel() {
        if (this.f16752f) {
            return;
        }
        h.c.n0.i.g.h(this.f16750d);
    }

    @Override // k.a.c
    public void onComplete() {
        this.f16752f = true;
        h.c.n0.j.k.b(this.a, this, this.f16748b);
    }

    @Override // k.a.c
    public void onError(Throwable th) {
        this.f16752f = true;
        h.c.n0.j.k.d(this.a, th, this, this.f16748b);
    }

    @Override // k.a.c
    public void onNext(T t) {
        h.c.n0.j.k.f(this.a, t, this, this.f16748b);
    }

    @Override // h.c.m, k.a.c
    public void onSubscribe(k.a.d dVar) {
        if (this.f16751e.compareAndSet(false, true)) {
            this.a.onSubscribe(this);
            h.c.n0.i.g.q(this.f16750d, this.f16749c, dVar);
            return;
        }
        dVar.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    @Override // k.a.d
    public void request(long j2) {
        if (j2 <= 0) {
            cancel();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j2));
            return;
        }
        h.c.n0.i.g.n(this.f16750d, this.f16749c, j2);
    }
}