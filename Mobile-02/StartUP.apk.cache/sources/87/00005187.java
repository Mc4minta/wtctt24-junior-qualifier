package kotlin.a0.w0;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.m;

/* compiled from: ListBuilder.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final <E> E[] a(int i2) {
        if (i2 >= 0) {
            return (E[]) new Object[i2];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final <T> T[] b(T[] copyOfUninitializedElements, int i2) {
        m.g(copyOfUninitializedElements, "$this$copyOfUninitializedElements");
        T[] tArr = (T[]) Arrays.copyOf(copyOfUninitializedElements, i2);
        m.f(tArr, "java.util.Arrays.copyOf(this, newSize)");
        Objects.requireNonNull(tArr, "null cannot be cast to non-null type kotlin.Array<T>");
        return tArr;
    }

    public static final <E> void c(E[] resetAt, int i2) {
        m.g(resetAt, "$this$resetAt");
        resetAt[i2] = null;
    }

    public static final <E> void d(E[] resetRange, int i2, int i3) {
        m.g(resetRange, "$this$resetRange");
        while (i2 < i3) {
            c(resetRange, i2);
            i2++;
        }
    }
}