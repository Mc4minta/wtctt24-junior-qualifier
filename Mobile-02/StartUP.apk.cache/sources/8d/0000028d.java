package androidx.core.util;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class g<T> extends Pools$SimplePool<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Object f1542c;

    public g(int i2) {
        super(i2);
        this.f1542c = new Object();
    }

    @Override // androidx.core.util.Pools$SimplePool, androidx.core.util.f
    public T acquire() {
        T t;
        synchronized (this.f1542c) {
            t = (T) super.acquire();
        }
        return t;
    }

    @Override // androidx.core.util.Pools$SimplePool, androidx.core.util.f
    public boolean release(T t) {
        boolean release;
        synchronized (this.f1542c) {
            release = super.release(t);
        }
        return release;
    }
}