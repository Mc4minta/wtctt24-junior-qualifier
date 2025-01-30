package h.c.n0.i;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ScalarSubscription.java */
/* loaded from: classes3.dex */
public final class e<T> extends AtomicInteger implements h.c.n0.c.g<T> {
    final T a;

    /* renamed from: b  reason: collision with root package name */
    final k.a.c<? super T> f16756b;

    public e(k.a.c<? super T> cVar, T t) {
        this.f16756b = cVar;
        this.a = t;
    }

    @Override // k.a.d
    public void cancel() {
        lazySet(2);
    }

    @Override // h.c.n0.c.j
    public void clear() {
        lazySet(1);
    }

    @Override // h.c.n0.c.j
    public boolean isEmpty() {
        return get() != 0;
    }

    @Override // h.c.n0.c.f
    public int n(int i2) {
        return i2 & 1;
    }

    @Override // h.c.n0.c.j
    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // h.c.n0.c.j
    public T poll() {
        if (get() == 0) {
            lazySet(1);
            return this.a;
        }
        return null;
    }

    @Override // k.a.d
    public void request(long j2) {
        if (g.B(j2) && compareAndSet(0, 1)) {
            k.a.c<? super T> cVar = this.f16756b;
            cVar.onNext((T) this.a);
            if (get() != 2) {
                cVar.onComplete();
            }
        }
    }
}