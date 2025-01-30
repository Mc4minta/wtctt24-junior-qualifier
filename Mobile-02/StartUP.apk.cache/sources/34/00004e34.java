package h.c.n0.e.e;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: ObservableFromFuture.java */
/* loaded from: classes3.dex */
public final class d1<T> extends h.c.s<T> {
    final Future<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    final long f15583b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f15584c;

    public d1(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        this.a = future;
        this.f15583b = j2;
        this.f15584c = timeUnit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.c.s
    public void subscribeActual(h.c.z<? super T> zVar) {
        h.c.n0.d.l lVar = new h.c.n0.d.l(zVar);
        zVar.onSubscribe(lVar);
        if (lVar.isDisposed()) {
            return;
        }
        try {
            TimeUnit timeUnit = this.f15584c;
            lVar.b(h.c.n0.b.b.e(timeUnit != null ? this.a.get(this.f15583b, timeUnit) : this.a.get(), "Future returned null"));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            if (lVar.isDisposed()) {
                return;
            }
            zVar.onError(th);
        }
    }
}