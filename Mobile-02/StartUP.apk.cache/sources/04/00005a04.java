package kotlinx.coroutines.internal;

import java.util.Objects;

/* compiled from: ArrayQueue.kt */
/* loaded from: classes3.dex */
public class a<T> {
    private Object[] a = new Object[16];

    /* renamed from: b  reason: collision with root package name */
    private int f17484b;

    /* renamed from: c  reason: collision with root package name */
    private int f17485c;

    private final void b() {
        Object[] objArr = this.a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        kotlin.a0.j.g(objArr, objArr2, 0, this.f17484b, 0, 10, null);
        Object[] objArr3 = this.a;
        int length2 = objArr3.length;
        int i2 = this.f17484b;
        kotlin.a0.j.g(objArr3, objArr2, length2 - i2, 0, i2, 4, null);
        this.a = objArr2;
        this.f17484b = 0;
        this.f17485c = length;
    }

    public final void a(T t) {
        Object[] objArr = this.a;
        int i2 = this.f17485c;
        objArr[i2] = t;
        int length = (objArr.length - 1) & (i2 + 1);
        this.f17485c = length;
        if (length == this.f17484b) {
            b();
        }
    }

    public final boolean c() {
        return this.f17484b == this.f17485c;
    }

    public final T d() {
        int i2 = this.f17484b;
        if (i2 == this.f17485c) {
            return null;
        }
        Object[] objArr = this.a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.f17484b = (i2 + 1) & (objArr.length - 1);
        Objects.requireNonNull(t, "null cannot be cast to non-null type T");
        return t;
    }
}