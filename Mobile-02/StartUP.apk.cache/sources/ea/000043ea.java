package com.uber.autodispose.b0.b;

import android.os.Looper;
import h.c.m0.e;

/* compiled from: AutoDisposeAndroidUtil.java */
/* loaded from: classes2.dex */
public class c {
    private static final e a = new e() { // from class: com.uber.autodispose.b0.b.b
        @Override // h.c.m0.e
        public final boolean a() {
            return c.b();
        }
    };

    public static boolean a() {
        return com.uber.autodispose.b0.a.a(a);
    }

    public static /* synthetic */ boolean b() throws Exception {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}