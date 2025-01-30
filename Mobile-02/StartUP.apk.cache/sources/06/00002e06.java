package com.facebook.react.fabric.e;

import android.view.View;
import com.facebook.react.uimanager.o;
import com.facebook.yoga.n;

/* compiled from: LayoutMetricsConversions.java */
/* loaded from: classes2.dex */
public class a {
    public static float a(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            return Float.POSITIVE_INFINITY;
        }
        return size;
    }

    public static float b(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        return 0.0f;
    }

    public static n c(float f2, float f3) {
        if (f2 == f3) {
            return n.EXACTLY;
        }
        if (Float.isInfinite(f3)) {
            return n.UNDEFINED;
        }
        return n.AT_MOST;
    }

    public static float d(float f2, float f3) {
        if (f2 == f3) {
            return o.c(f3);
        }
        if (Float.isInfinite(f3)) {
            return Float.POSITIVE_INFINITY;
        }
        return o.c(f3);
    }
}