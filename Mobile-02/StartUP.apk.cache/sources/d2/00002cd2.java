package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.Rect;

/* compiled from: PlatformDecoder.java */
/* loaded from: classes2.dex */
public interface f {
    com.facebook.common.references.a<Bitmap> a(e.f.j.i.d dVar, Bitmap.Config config, Rect rect, ColorSpace colorSpace);

    com.facebook.common.references.a<Bitmap> b(e.f.j.i.d dVar, Bitmap.Config config, Rect rect, int i2);

    com.facebook.common.references.a<Bitmap> c(e.f.j.i.d dVar, Bitmap.Config config, Rect rect, int i2, ColorSpace colorSpace);
}