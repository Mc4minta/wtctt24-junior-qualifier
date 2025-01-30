package h.c.n0.d;

/* compiled from: DeferredScalarDisposable.java */
/* loaded from: classes.dex */
public class l<T> extends b<T> {
    protected final h.c.z<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    protected T f14125b;

    public l(h.c.z<? super T> zVar) {
        this.a = zVar;
    }

    public final void a() {
        if ((get() & 54) != 0) {
            return;
        }
        lazySet(2);
        this.a.onComplete();
    }

    public final void b(T t) {
        int i2 = get();
        if ((i2 & 54) != 0) {
            return;
        }
        h.c.z<? super T> zVar = this.a;
        if (i2 == 8) {
            this.f14125b = t;
            lazySet(16);
            zVar.onNext(null);
        } else {
            lazySet(2);
            zVar.onNext(t);
        }
        if (get() != 4) {
            zVar.onComplete();
        }
    }

    public final void c(Throwable th) {
        if ((get() & 54) != 0) {
            h.c.r0.a.u(th);
            return;
        }
        lazySet(2);
        this.a.onError(th);
    }

    @Override // h.c.n0.c.j
    public final void clear() {
        lazySet(32);
        this.f14125b = null;
    }

    @Override // h.c.k0.b
    public void dispose() {
        set(4);
        this.f14125b = null;
    }

    @Override // h.c.k0.b
    public final boolean isDisposed() {
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
    public final T poll() throws Exception {
        if (get() == 16) {
            T t = this.f14125b;
            this.f14125b = null;
            lazySet(32);
            return t;
        }
        return null;
    }
}