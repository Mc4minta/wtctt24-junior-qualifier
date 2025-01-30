package androidx.core.util;

/* loaded from: classes.dex */
public class Pools$SimplePool<T> implements f<T> {
    private final Object[] a;

    /* renamed from: b  reason: collision with root package name */
    private int f1539b;

    public Pools$SimplePool(int i2) {
        if (i2 > 0) {
            this.a = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    private boolean a(T t) {
        for (int i2 = 0; i2 < this.f1539b; i2++) {
            if (this.a[i2] == t) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.util.f
    public T acquire() {
        int i2 = this.f1539b;
        if (i2 > 0) {
            int i3 = i2 - 1;
            Object[] objArr = this.a;
            T t = (T) objArr[i3];
            objArr[i3] = null;
            this.f1539b = i2 - 1;
            return t;
        }
        return null;
    }

    @Override // androidx.core.util.f
    public boolean release(T t) {
        if (!a(t)) {
            int i2 = this.f1539b;
            Object[] objArr = this.a;
            if (i2 < objArr.length) {
                objArr[i2] = t;
                this.f1539b = i2 + 1;
                return true;
            }
            return false;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}