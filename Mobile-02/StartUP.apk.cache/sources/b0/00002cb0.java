package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;

/* compiled from: DummyBitmapPool.java */
/* loaded from: classes2.dex */
public class n implements c {
    @Override // com.facebook.common.memory.e
    /* renamed from: a */
    public Bitmap get(int i2) {
        return Bitmap.createBitmap(1, (int) Math.ceil(i2 / 2.0d), Bitmap.Config.RGB_565);
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    /* renamed from: b */
    public void release(Bitmap bitmap) {
        e.f.d.c.i.g(bitmap);
        bitmap.recycle();
    }
}