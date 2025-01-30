package com.google.zxing.v.c;

import com.google.zxing.m;

/* compiled from: QRCodeDecoderMetaData.java */
/* loaded from: classes2.dex */
public final class i {
    private final boolean a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(boolean z) {
        this.a = z;
    }

    public void a(m[] mVarArr) {
        if (!this.a || mVarArr == null || mVarArr.length < 3) {
            return;
        }
        m mVar = mVarArr[0];
        mVarArr[0] = mVarArr[2];
        mVarArr[2] = mVar;
    }
}