package com.rd.e;

import android.content.res.Resources;
import android.util.TypedValue;

/* compiled from: DensityUtils.java */
/* loaded from: classes2.dex */
public class b {
    public static int a(int i2) {
        return (int) TypedValue.applyDimension(1, i2, Resources.getSystem().getDisplayMetrics());
    }
}