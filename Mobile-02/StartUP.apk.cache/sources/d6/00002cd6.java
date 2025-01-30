package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import e.f.j.c.f;

/* compiled from: BasePostprocessor.java */
/* loaded from: classes2.dex */
public abstract class a implements c {
    public static final Bitmap.Config a = Bitmap.Config.ARGB_8888;

    private static void d(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap.getConfig() == bitmap2.getConfig()) {
            Bitmaps.a(bitmap, bitmap2);
        } else {
            new Canvas(bitmap).drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // com.facebook.imagepipeline.request.c
    public com.facebook.common.references.a<Bitmap> b(Bitmap bitmap, f fVar) {
        Bitmap.Config config = bitmap.getConfig();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (config == null) {
            config = a;
        }
        com.facebook.common.references.a<Bitmap> d2 = fVar.d(width, height, config);
        try {
            f(d2.n(), bitmap);
            return com.facebook.common.references.a.e(d2);
        } finally {
            com.facebook.common.references.a.f(d2);
        }
    }

    @Override // com.facebook.imagepipeline.request.c
    public e.f.b.a.d c() {
        return null;
    }

    public void e(Bitmap bitmap) {
    }

    public void f(Bitmap bitmap, Bitmap bitmap2) {
        d(bitmap, bitmap2);
        e(bitmap);
    }

    @Override // com.facebook.imagepipeline.request.c
    public String getName() {
        return "Unknown postprocessor";
    }
}