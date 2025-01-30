package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.p;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import e.f.d.c.i;

/* compiled from: KitKatPurgeableDecoder.java */
@TargetApi(19)
/* loaded from: classes2.dex */
public class d extends DalvikPurgeableDecoder {

    /* renamed from: c  reason: collision with root package name */
    private final p f4635c;

    public d(p pVar) {
        this.f4635c = pVar;
    }

    private static void i(byte[] bArr, int i2) {
        bArr[i2] = -1;
        bArr[i2 + 1] = -39;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    protected Bitmap d(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options) {
        PooledByteBuffer n = aVar.n();
        int size = n.size();
        com.facebook.common.references.a<byte[]> a = this.f4635c.a(size);
        try {
            byte[] n2 = a.n();
            n.l(0, n2, 0, size);
            return (Bitmap) i.h(BitmapFactory.decodeByteArray(n2, 0, size, options), "BitmapFactory returned null");
        } finally {
            com.facebook.common.references.a.f(a);
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    protected Bitmap e(com.facebook.common.references.a<PooledByteBuffer> aVar, int i2, BitmapFactory.Options options) {
        byte[] bArr = DalvikPurgeableDecoder.f(aVar, i2) ? null : DalvikPurgeableDecoder.a;
        PooledByteBuffer n = aVar.n();
        i.b(i2 <= n.size());
        int i3 = i2 + 2;
        com.facebook.common.references.a<byte[]> a = this.f4635c.a(i3);
        try {
            byte[] n2 = a.n();
            n.l(0, n2, 0, i2);
            if (bArr != null) {
                i(n2, i2);
                i2 = i3;
            }
            return (Bitmap) i.h(BitmapFactory.decodeByteArray(n2, 0, i2, options), "BitmapFactory returned null");
        } finally {
            com.facebook.common.references.a.f(a);
        }
    }
}