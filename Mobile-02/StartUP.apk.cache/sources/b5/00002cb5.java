package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.BasePool;

/* compiled from: GenericByteArrayPool.java */
/* loaded from: classes2.dex */
public class q extends BasePool<byte[]> implements com.facebook.common.memory.a {

    /* renamed from: j  reason: collision with root package name */
    private final int[] f4615j;

    public q(com.facebook.common.memory.c cVar, e0 e0Var, f0 f0Var) {
        super(cVar, e0Var, f0Var);
        SparseIntArray sparseIntArray = e0Var.f4602c;
        this.f4615j = new int[sparseIntArray.size()];
        for (int i2 = 0; i2 < sparseIntArray.size(); i2++) {
            this.f4615j[i2] = sparseIntArray.keyAt(i2);
        }
        m();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int h(int i2) {
        int[] iArr;
        if (i2 > 0) {
            for (int i3 : this.f4615j) {
                if (i3 >= i2) {
                    return i3;
                }
            }
            return i2;
        }
        throw new BasePool.InvalidSizeException(Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public int j(int i2) {
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: u */
    public byte[] a(int i2) {
        return new byte[i2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: v */
    public void e(byte[] bArr) {
        e.f.d.c.i.g(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: w */
    public int i(byte[] bArr) {
        e.f.d.c.i.g(bArr);
        return bArr.length;
    }
}