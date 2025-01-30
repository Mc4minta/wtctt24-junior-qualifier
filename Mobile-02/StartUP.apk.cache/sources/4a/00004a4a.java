package e.j.l.r;

import android.graphics.Color;

/* compiled from: ColorTransforms.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final int a(double d2, double d3, double d4) {
        double d5 = 360.0f;
        double d6 = (d2 % d5) / d5;
        double d7 = 100.0f;
        double d8 = d3 / d7;
        double d9 = d4 / d7;
        double d10 = d9 < 0.5d ? (1 + d8) * d9 : (d9 + d8) - (d8 * d9);
        double d11 = (2 * d9) - d10;
        double d12 = 0.33333334f;
        double d13 = d10;
        double max = Math.max(0.0d, b(d11, d13, d6 + d12));
        double max2 = Math.max(0.0d, b(d11, d13, d6));
        double max3 = Math.max(0.0d, b(d11, d13, d6 - d12));
        double d14 = 255;
        return Color.rgb((int) (Math.min(max, 1.0d) * d14), (int) (Math.min(max2, 1.0d) * d14), (int) (Math.min(max3, 1.0d) * d14));
    }

    public static final double b(double d2, double d3, double d4) {
        double d5;
        if (d4 < 0.0d) {
            d4 += 1.0f;
        }
        if (d4 > 1.0d) {
            d4 -= 1.0f;
        }
        if (6 * d4 < 1.0d) {
            d5 = (d3 - d2) * 6.0f * d4;
        } else if (2 * d4 < 1.0d) {
            return d3;
        } else {
            if (3 * d4 >= 2.0d) {
                return d2;
            }
            d5 = (d3 - d2) * 6.0f * (0.6666667f - d4);
        }
        return d2 + d5;
    }
}