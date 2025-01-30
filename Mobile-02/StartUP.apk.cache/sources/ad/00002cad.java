package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: DefaultByteArrayPoolParams.java */
/* loaded from: classes2.dex */
public class k {
    public static e0 a() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(16384, 5);
        return new e0(81920, PKIFailureInfo.badCertTemplate, sparseIntArray);
    }
}