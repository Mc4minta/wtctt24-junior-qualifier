package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import java.util.Set;

/* compiled from: DummyTrackingInUseBitmapPool.java */
/* loaded from: classes2.dex */
public class o implements c {
    private final Set<Bitmap> a = e.f.d.c.k.b();

    @Override // com.facebook.common.memory.e
    /* renamed from: a */
    public Bitmap get(int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(1, (int) Math.ceil(i2 / 2.0d), Bitmap.Config.RGB_565);
        this.a.add(createBitmap);
        return createBitmap;
    }

    @Override // com.facebook.common.memory.e, com.facebook.common.references.c
    /* renamed from: b */
    public void release(Bitmap bitmap) {
        e.f.d.c.i.g(bitmap);
        this.a.remove(bitmap);
        bitmap.recycle();
    }
}