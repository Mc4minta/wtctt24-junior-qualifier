package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: ObjectArrays.java */
/* loaded from: classes2.dex */
public final class y {
    static final Object[] a = new Object[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] a(T[] tArr, int i2) {
        T[] tArr2 = (T[]) c(tArr, i2);
        System.arraycopy(tArr, 0, tArr2, 0, Math.min(tArr.length, i2));
        return tArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static Object b(Object obj, int i2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i2);
    }

    public static <T> T[] c(T[] tArr, int i2) {
        return (T[]) a0.a(tArr, i2);
    }
}