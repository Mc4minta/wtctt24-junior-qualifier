package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.x;

/* compiled from: ThreadSafeHeap.kt */
/* loaded from: classes3.dex */
public class t<T extends u & Comparable<? super T>> {
    private volatile int _size = 0;
    private T[] a;

    private final T[] f() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new u[4];
            this.a = tArr2;
            return tArr2;
        } else if (c() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, c() * 2);
            kotlin.jvm.internal.m.f(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            T[] tArr3 = (T[]) ((u[]) copyOf);
            this.a = tArr3;
            return tArr3;
        } else {
            return tArr;
        }
    }

    private final void j(int i2) {
        this._size = i2;
    }

    private final void k(int i2) {
        while (true) {
            int i3 = (i2 * 2) + 1;
            if (i3 >= c()) {
                return;
            }
            T[] tArr = this.a;
            kotlin.jvm.internal.m.e(tArr);
            int i4 = i3 + 1;
            if (i4 < c()) {
                T t = tArr[i4];
                kotlin.jvm.internal.m.e(t);
                T t2 = tArr[i3];
                kotlin.jvm.internal.m.e(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    i3 = i4;
                }
            }
            T t3 = tArr[i2];
            kotlin.jvm.internal.m.e(t3);
            T t4 = tArr[i3];
            kotlin.jvm.internal.m.e(t4);
            if (((Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            m(i2, i3);
            i2 = i3;
        }
    }

    private final void l(int i2) {
        while (i2 > 0) {
            T[] tArr = this.a;
            kotlin.jvm.internal.m.e(tArr);
            int i3 = (i2 - 1) / 2;
            T t = tArr[i3];
            kotlin.jvm.internal.m.e(t);
            T t2 = tArr[i2];
            kotlin.jvm.internal.m.e(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            m(i2, i3);
            i2 = i3;
        }
    }

    private final void m(int i2, int i3) {
        T[] tArr = this.a;
        kotlin.jvm.internal.m.e(tArr);
        T t = tArr[i3];
        kotlin.jvm.internal.m.e(t);
        T t2 = tArr[i2];
        kotlin.jvm.internal.m.e(t2);
        tArr[i2] = t;
        tArr[i3] = t2;
        t.s(i2);
        t2.s(i3);
    }

    public final void a(T t) {
        if (x.a()) {
            if (!(t.q() == null)) {
                throw new AssertionError();
            }
        }
        t.h(this);
        T[] f2 = f();
        int c2 = c();
        j(c2 + 1);
        f2[c2] = t;
        t.s(c2);
        l(c2);
    }

    public final T b() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return this._size;
    }

    public final boolean d() {
        return c() == 0;
    }

    public final T e() {
        T b2;
        synchronized (this) {
            b2 = b();
        }
        return b2;
    }

    public final boolean g(T t) {
        boolean z;
        synchronized (this) {
            z = true;
            if (t.q() == null) {
                z = false;
            } else {
                int index = t.getIndex();
                if (x.a()) {
                    if (!(index >= 0)) {
                        throw new AssertionError();
                    }
                }
                h(index);
            }
        }
        return z;
    }

    public final T h(int i2) {
        if (x.a()) {
            if (!(c() > 0)) {
                throw new AssertionError();
            }
        }
        T[] tArr = this.a;
        kotlin.jvm.internal.m.e(tArr);
        j(c() - 1);
        if (i2 < c()) {
            m(i2, c());
            int i3 = (i2 - 1) / 2;
            if (i2 > 0) {
                T t = tArr[i2];
                kotlin.jvm.internal.m.e(t);
                T t2 = tArr[i3];
                kotlin.jvm.internal.m.e(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    m(i2, i3);
                    l(i3);
                }
            }
            k(i2);
        }
        T t3 = tArr[c()];
        kotlin.jvm.internal.m.e(t3);
        if (x.a()) {
            if (!(t3.q() == this)) {
                throw new AssertionError();
            }
        }
        t3.h(null);
        t3.s(-1);
        tArr[c()] = null;
        return t3;
    }

    public final T i() {
        T h2;
        synchronized (this) {
            h2 = c() > 0 ? h(0) : null;
        }
        return h2;
    }
}