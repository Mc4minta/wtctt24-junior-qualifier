package com.facebook.react.views.art;

import com.facebook.react.bridge.ReadableArray;

/* compiled from: PropHelper.java */
/* loaded from: classes2.dex */
class g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(ReadableArray readableArray, float[] fArr) {
        int length = readableArray.size() > fArr.length ? fArr.length : readableArray.size();
        for (int i2 = 0; i2 < length; i2++) {
            fArr[i2] = (float) readableArray.getDouble(i2);
        }
        return readableArray.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float[] b(ReadableArray readableArray) {
        if (readableArray != null) {
            float[] fArr = new float[readableArray.size()];
            a(readableArray, fArr);
            return fArr;
        }
        return null;
    }
}