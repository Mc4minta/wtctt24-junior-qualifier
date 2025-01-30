package h.c.n0.e.b;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: FlowableFromFuture.java */
/* loaded from: classes3.dex */
public final class h1<T> extends h.c.h<T> {
    final Future<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final long f14459b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f14460c;

    public h1(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        this.a = future;
        this.f14459b = j2;
        this.f14460c = timeUnit;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super T> cVar) {
        h.c.n0.i.c cVar2 = new h.c.n0.i.c(cVar);
        cVar.onSubscribe(cVar2);
        try {
            TimeUnit timeUnit = this.f14460c;
            T t = timeUnit != null ? this.a.get(this.f14459b, timeUnit) : this.a.get();
            if (t == null) {
                cVar.onError(new NullPointerException("The future returned null"));
            } else {
                cVar2.c(t);
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            if (cVar2.d()) {
                return;
            }
            cVar.onError(th);
        }
    }
}