package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;

/* compiled from: BucketsBitmapPool.java */
@TargetApi(21)
/* loaded from: classes2.dex */
public class g extends BasePool<Bitmap> implements c {
    public g(com.facebook.common.memory.c cVar, e0 e0Var, f0 f0Var) {
        super(cVar, e0Var, f0Var);
        m();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int h(int i2) {
        return i2;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int j(int i2) {
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: u */
    public Bitmap a(int i2) {
        return Bitmap.createBitmap(1, (int) Math.ceil(i2 / 2.0d), Bitmap.Config.RGB_565);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: v */
    public void e(Bitmap bitmap) {
        e.f.d.c.i.g(bitmap);
        bitmap.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: w */
    public int i(Bitmap bitmap) {
        e.f.d.c.i.g(bitmap);
        return bitmap.getAllocationByteCount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: x */
    public Bitmap k(e<Bitmap> eVar) {
        Bitmap bitmap = (Bitmap) super.k(eVar);
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: y */
    public boolean o(Bitmap bitmap) {
        e.f.d.c.i.g(bitmap);
        return !bitmap.isRecycled() && bitmap.isMutable();
    }
}