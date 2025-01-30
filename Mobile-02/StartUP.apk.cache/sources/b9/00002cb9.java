package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.BasePool;

/* compiled from: MemoryChunkPool.java */
/* loaded from: classes2.dex */
public abstract class u extends BasePool<t> {

    /* renamed from: j  reason: collision with root package name */
    private final int[] f4621j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(com.facebook.common.memory.c cVar, e0 e0Var, f0 f0Var) {
        super(cVar, e0Var, f0Var);
        SparseIntArray sparseIntArray = e0Var.f4602c;
        this.f4621j = new int[sparseIntArray.size()];
        int i2 = 0;
        while (true) {
            int[] iArr = this.f4621j;
            if (i2 < iArr.length) {
                iArr[i2] = sparseIntArray.keyAt(i2);
                i2++;
            } else {
                m();
                return;
            }
        }
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int h(int i2) {
        int[] iArr;
        if (i2 > 0) {
            for (int i3 : this.f4621j) {
                if (i3 >= i2) {
                    return i3;
                }
            }
            return i2;
        }
        throw new BasePool.InvalidSizeException(Integer.valueOf(i2));
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int j(int i2) {
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: u */
    public abstract t a(int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: v */
    public void e(t tVar) {
        e.f.d.c.i.g(tVar);
        tVar.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: w */
    public int i(t tVar) {
        e.f.d.c.i.g(tVar);
        return tVar.getSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x() {
        return this.f4621j[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* renamed from: y */
    public boolean o(t tVar) {
        e.f.d.c.i.g(tVar);
        return !tVar.isClosed();
    }
}