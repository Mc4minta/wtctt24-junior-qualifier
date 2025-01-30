package com.google.common.collect;

/* compiled from: Hashing.java */
/* loaded from: classes2.dex */
final class g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i2, double d2) {
        int max = Math.max(i2, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max > ((int) (d2 * highestOneBit))) {
            int i3 = highestOneBit << 1;
            if (i3 > 0) {
                return i3;
            }
            return 1073741824;
        }
        return highestOneBit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i2) {
        return Integer.rotateLeft(i2 * (-862048943), 15) * 461845907;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(Object obj) {
        return b(obj == null ? 0 : obj.hashCode());
    }
}