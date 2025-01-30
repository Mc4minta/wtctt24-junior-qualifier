package com.facebook.react.views.view;

/* compiled from: ColorUtil.java */
/* loaded from: classes2.dex */
public class a {
    public static int a(int i2) {
        int i3 = i2 >>> 24;
        if (i3 == 255) {
            return -1;
        }
        return i3 == 0 ? -2 : -3;
    }

    public static int b(int i2, int i3) {
        if (i3 == 255) {
            return i2;
        }
        if (i3 == 0) {
            return i2 & 16777215;
        }
        return (i2 & 16777215) | ((((i2 >>> 24) * (i3 + (i3 >> 7))) >> 8) << 24);
    }
}