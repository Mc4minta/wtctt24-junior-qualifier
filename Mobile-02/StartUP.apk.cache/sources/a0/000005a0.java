package c.h.k;

import android.os.Build;
import android.view.ViewGroup;

/* compiled from: MarginLayoutParamsCompat.java */
/* loaded from: classes.dex */
public final class g {
    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (Build.VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginEnd();
        }
        return marginLayoutParams.rightMargin;
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (Build.VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginStart();
        }
        return marginLayoutParams.leftMargin;
    }

    public static void c(ViewGroup.MarginLayoutParams marginLayoutParams, int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginEnd(i2);
        } else {
            marginLayoutParams.rightMargin = i2;
        }
    }
}