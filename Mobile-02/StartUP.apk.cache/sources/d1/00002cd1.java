package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;

/* compiled from: OreoDecoder.java */
@TargetApi(26)
/* loaded from: classes2.dex */
public class e extends b {
    public e(com.facebook.imagepipeline.memory.c cVar, int i2, androidx.core.util.g gVar) {
        super(cVar, i2, gVar);
    }

    private static boolean g(BitmapFactory.Options options) {
        ColorSpace colorSpace = options.outColorSpace;
        return (colorSpace == null || !colorSpace.isWideGamut() || options.inPreferredConfig == Bitmap.Config.RGBA_F16) ? false : true;
    }

    @Override // com.facebook.imagepipeline.platform.b
    public int e(int i2, int i3, BitmapFactory.Options options) {
        return g(options) ? i2 * i3 * 8 : com.facebook.imageutils.a.d(i2, i3, options.inPreferredConfig);
    }
}