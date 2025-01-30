package com.facebook.imagepipeline.platform;

import android.os.Build;
import com.facebook.imagepipeline.memory.d0;

/* compiled from: PlatformDecoderFactory.java */
/* loaded from: classes2.dex */
public class g {
    public static f a(d0 d0Var, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            int d2 = d0Var.d();
            return new e(d0Var.a(), d2, new androidx.core.util.g(d2));
        } else if (i2 >= 21) {
            int d3 = d0Var.d();
            return new a(d0Var.a(), d3, new androidx.core.util.g(d3));
        } else if (z && i2 < 19) {
            return new c();
        } else {
            return new d(d0Var.c());
        }
    }
}