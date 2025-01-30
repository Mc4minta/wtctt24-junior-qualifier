package h.c.n0.i;

/* compiled from: DeferredScalarSubscription.java */
/* loaded from: classes3.dex */
public class c<T> extends a<T> {
    protected final k.a.c<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    protected T f16754b;

    public c(k.a.c<? super T> cVar) {
        this.a = cVar;
    }

    public final void c(T t) {
        int i2 = get();
        while (i2 != 8) {
            if ((i2 & (-3)) != 0) {
                return;
            }
            if (i2 == 2) {
                lazySet(3);
                k.a.c<? super T> cVar = this.a;
                cVar.onNext(t);
                if (get() != 4) {
                    cVar.onComplete();
                    return;
                }
                return;
            }
            this.f16754b = t;
            if (compareAndSet(0, 1)) {
                return;
            }
            i2 = get();
            if (i2 == 4) {
                this.f16754b = null;
                return;
            }
        }
        this.f16754b = t;
        lazySet(16);
        k.a.c<? super T> cVar2 = this.a;
        cVar2.onNext(t);
        if (get() != 4) {
            cVar2.onComplete();
        }
    }

    public void cancel() {
        set(4);
        this.f16754b = null;
    }

    @Override // h.c.n0.c.j
    public final void clear() {
        lazySet(32);
        this.f16754b = null;
    }

    public final boolean d() {
        return get() == 4;
    }

    @Override // h.c.n0.c.j
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // h.c.n0.c.f
    public final int n(int i2) {
        if ((i2 & 2) != 0) {
            lazySet(8);
            return 2;
        }
        return 0;
    }

    @Override // h.c.n0.c.j
    public final T poll() {
        if (get() == 16) {
            lazySet(32);
            T t = this.f16754b;
            this.f16754b = null;
            return t;
        }
        return null;
    }

    @Override // k.a.d
    public final void request(long j2) {
        T t;
        if (g.B(j2)) {
            do {
                int i2 = get();
                if ((i2 & (-2)) != 0) {
                    return;
                }
                if (i2 == 1) {
                    if (!compareAndSet(1, 3) || (t = this.f16754b) == null) {
                        return;
                    }
                    this.f16754b = null;
                    k.a.c<? super T> cVar = this.a;
                    cVar.onNext(t);
                    if (get() != 4) {
                        cVar.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }
}