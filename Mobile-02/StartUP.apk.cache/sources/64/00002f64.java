package com.facebook.react.uimanager;

/* compiled from: ReactRootViewTagGenerator.java */
/* loaded from: classes2.dex */
public class x {
    private static int a = 1;

    public static synchronized int a() {
        int i2;
        synchronized (x.class) {
            i2 = a;
            a = i2 + 10;
        }
        return i2;
    }
}