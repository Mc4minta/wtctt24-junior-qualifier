package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: CollectPreconditions.java */
/* loaded from: classes2.dex */
final class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        } else if (obj2 != null) {
        } else {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static int b(int i2, String str) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(boolean z) {
        com.google.common.base.l.p(z, "no calls to next() since the last call to remove()");
    }
}