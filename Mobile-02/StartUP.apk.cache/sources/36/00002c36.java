package com.facebook.common.util;

/* compiled from: HashCodeUtil.java */
/* loaded from: classes2.dex */
public class a {
    public static int a(int i2, int i3) {
        return ((i2 + 31) * 31) + i3;
    }

    public static int b(int i2, int i3, int i4, int i5, int i6, int i7) {
        return ((((((((((i2 + 31) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i6) * 31) + i7;
    }

    public static int c(Object obj, Object obj2) {
        return a(obj == null ? 0 : obj.hashCode(), obj2 != null ? obj2.hashCode() : 0);
    }

    public static int d(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return b(obj == null ? 0 : obj.hashCode(), obj2 == null ? 0 : obj2.hashCode(), obj3 == null ? 0 : obj3.hashCode(), obj4 == null ? 0 : obj4.hashCode(), obj5 == null ? 0 : obj5.hashCode(), obj6 != null ? obj6.hashCode() : 0);
    }
}