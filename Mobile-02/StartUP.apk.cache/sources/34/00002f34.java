package com.facebook.react.uimanager;

import android.util.DisplayMetrics;
import android.util.TypedValue;

/* compiled from: PixelUtil.java */
/* loaded from: classes2.dex */
public class o {
    public static float a(float f2) {
        return f2 / c.f().density;
    }

    public static float b(double d2) {
        return c((float) d2);
    }

    public static float c(float f2) {
        return TypedValue.applyDimension(1, f2, c.f());
    }

    public static float d(double d2) {
        return e((float) d2);
    }

    public static float e(float f2) {
        return f(f2, Float.NaN);
    }

    public static float f(float f2, float f3) {
        DisplayMetrics f4 = c.f();
        float f5 = f4.scaledDensity;
        float f6 = f4.density;
        float f7 = f5 / f6;
        if (f3 >= 1.0f && f3 < f7) {
            f5 = f6 * f3;
        }
        return f2 * f5;
    }

    public static float g(float f2) {
        return f2 / c.e().scaledDensity;
    }
}