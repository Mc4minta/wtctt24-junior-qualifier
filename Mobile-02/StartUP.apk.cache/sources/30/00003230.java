package com.google.android.gms.common.util;

import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class b {
    public static <T> T[] a(T[]... tArr) {
        if (tArr.length == 0) {
            return (T[]) ((Object[]) Array.newInstance(tArr.getClass(), 0));
        }
        int i2 = 0;
        for (T[] tArr2 : tArr) {
            i2 += tArr2.length;
        }
        T[] tArr3 = (T[]) Arrays.copyOf(tArr[0], i2);
        int length = tArr[0].length;
        for (int i3 = 1; i3 < tArr.length; i3++) {
            T[] tArr4 = tArr[i3];
            System.arraycopy(tArr4, 0, tArr3, length, tArr4.length);
            length += tArr4.length;
        }
        return tArr3;
    }

    public static <T> boolean b(T[] tArr, T t) {
        int length = tArr != null ? tArr.length : 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (com.google.android.gms.common.internal.r.a(tArr[i2], t)) {
                break;
            } else {
                i2++;
            }
        }
        return i2 >= 0;
    }
}