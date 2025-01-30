package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import e.f.d.c.i;

@e.f.d.c.d
/* loaded from: classes2.dex */
public class NativeBlurFilter {
    static {
        b.a();
    }

    public static void a(Bitmap bitmap, int i2, int i3) {
        i.g(bitmap);
        i.b(i2 > 0);
        i.b(i3 > 0);
        nativeIterativeBoxBlur(bitmap, i2, i3);
    }

    @e.f.d.c.d
    private static native void nativeIterativeBoxBlur(Bitmap bitmap, int i2, int i3);
}