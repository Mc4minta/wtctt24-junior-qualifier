package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;

@e.f.d.c.d
/* loaded from: classes2.dex */
public class NativeRoundingFilter {
    static {
        b.a();
    }

    @e.f.d.c.d
    private static native void nativeToCircleFilter(Bitmap bitmap, boolean z);

    @e.f.d.c.d
    private static native void nativeToCircleWithBorderFilter(Bitmap bitmap, int i2, int i3, boolean z);
}