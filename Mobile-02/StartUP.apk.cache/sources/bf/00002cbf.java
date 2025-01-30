package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import e.f.d.c.i;

@e.f.d.c.d
/* loaded from: classes2.dex */
public class Bitmaps {
    static {
        a.a();
    }

    public static void a(Bitmap bitmap, Bitmap bitmap2) {
        i.b(bitmap2.getConfig() == bitmap.getConfig());
        i.b(bitmap.isMutable());
        i.b(bitmap.getWidth() == bitmap2.getWidth());
        i.b(bitmap.getHeight() == bitmap2.getHeight());
        nativeCopyBitmap(bitmap, bitmap.getRowBytes(), bitmap2, bitmap2.getRowBytes(), bitmap.getHeight());
    }

    @e.f.d.c.d
    private static native void nativeCopyBitmap(Bitmap bitmap, int i2, Bitmap bitmap2, int i3, int i4);
}