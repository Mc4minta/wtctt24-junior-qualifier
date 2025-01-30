package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;

/* compiled from: BitmapPoolBackend.java */
/* loaded from: classes2.dex */
public class d extends s<Bitmap> {
    @Override // com.facebook.imagepipeline.memory.s, com.facebook.imagepipeline.memory.b0
    /* renamed from: c */
    public Bitmap get(int i2) {
        Bitmap bitmap = (Bitmap) super.get(i2);
        if (bitmap == null || !e(bitmap)) {
            return null;
        }
        bitmap.eraseColor(0);
        return bitmap;
    }

    @Override // com.facebook.imagepipeline.memory.b0
    /* renamed from: d */
    public int a(Bitmap bitmap) {
        return com.facebook.imageutils.a.e(bitmap);
    }

    protected boolean e(Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        if (bitmap.isRecycled()) {
            e.f.d.d.a.H("BitmapPoolBackend", "Cannot reuse a recycled bitmap: %s", bitmap);
            return false;
        } else if (bitmap.isMutable()) {
            return true;
        } else {
            e.f.d.d.a.H("BitmapPoolBackend", "Cannot reuse an immutable bitmap: %s", bitmap);
            return false;
        }
    }

    @Override // com.facebook.imagepipeline.memory.s, com.facebook.imagepipeline.memory.b0
    /* renamed from: f */
    public void put(Bitmap bitmap) {
        if (e(bitmap)) {
            super.put(bitmap);
        }
    }
}