package com.rd.e;

import android.os.Build;
import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: IdUtils.java */
/* loaded from: classes2.dex */
public class c {
    private static final AtomicInteger a = new AtomicInteger(1);

    private static int a() {
        AtomicInteger atomicInteger;
        int i2;
        int i3;
        do {
            atomicInteger = a;
            i2 = atomicInteger.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!atomicInteger.compareAndSet(i2, i3));
        return i2;
    }

    public static int b() {
        if (Build.VERSION.SDK_INT < 17) {
            return a();
        }
        return View.generateViewId();
    }
}