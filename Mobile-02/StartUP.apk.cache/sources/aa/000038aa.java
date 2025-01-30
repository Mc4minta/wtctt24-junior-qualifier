package com.google.common.base;

import java.util.Arrays;

/* compiled from: Objects.java */
/* loaded from: classes2.dex */
public final class i extends e {
    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}