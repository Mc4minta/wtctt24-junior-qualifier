package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

/* compiled from: DefaultBitmapPoolParams.java */
/* loaded from: classes2.dex */
public class j {
    private static final SparseIntArray a = new SparseIntArray(0);

    public static e0 a() {
        return new e0(0, b(), a);
    }

    private static int b() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min > 16777216) {
            return (min / 4) * 3;
        }
        return min / 2;
    }
}