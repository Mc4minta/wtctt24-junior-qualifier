package com.facebook.react.common;

import android.os.SystemClock;

/* compiled from: SystemClock.java */
/* loaded from: classes2.dex */
public class f {
    public static long a() {
        return System.currentTimeMillis();
    }

    public static long b() {
        return System.nanoTime();
    }

    public static long c() {
        return SystemClock.uptimeMillis();
    }
}