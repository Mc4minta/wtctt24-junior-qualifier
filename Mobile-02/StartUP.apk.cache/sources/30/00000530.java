package c.h.e;

import android.graphics.Color;

/* compiled from: ColorUtils.java */
/* loaded from: classes.dex */
public final class a {
    private static final ThreadLocal<double[]> a = new ThreadLocal<>();

    public static void a(int i2, int i3, int i4, double[] dArr) {
        if (dArr.length == 3) {
            double d2 = i2 / 255.0d;
            double pow = d2 < 0.04045d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
            double d3 = i3 / 255.0d;
            double pow2 = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
            double d4 = i4 / 255.0d;
            double pow3 = d4 < 0.04045d ? d4 / 12.92d : Math.pow((d4 + 0.055d) / 1.055d, 2.4d);
            dArr[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * 100.0d;
            dArr[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * 100.0d;
            dArr[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (pow3 * 0.9505d)) * 100.0d;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static double b(int i2) {
        double[] g2 = g();
        c(i2, g2);
        return g2[1] / 100.0d;
    }

    public static void c(int i2, double[] dArr) {
        a(Color.red(i2), Color.green(i2), Color.blue(i2), dArr);
    }

    private static int d(int i2, int i3) {
        return 255 - (((255 - i3) * (255 - i2)) / 255);
    }

    public static int e(int i2, int i3) {
        int alpha = Color.alpha(i3);
        int alpha2 = Color.alpha(i2);
        int d2 = d(alpha2, alpha);
        return Color.argb(d2, f(Color.red(i2), alpha2, Color.red(i3), alpha, d2), f(Color.green(i2), alpha2, Color.green(i3), alpha, d2), f(Color.blue(i2), alpha2, Color.blue(i3), alpha, d2));
    }

    private static int f(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            return 0;
        }
        return (((i2 * 255) * i3) + ((i4 * i5) * (255 - i3))) / (i6 * 255);
    }

    private static double[] g() {
        ThreadLocal<double[]> threadLocal = a;
        double[] dArr = threadLocal.get();
        if (dArr == null) {
            double[] dArr2 = new double[3];
            threadLocal.set(dArr2);
            return dArr2;
        }
        return dArr;
    }

    public static int h(int i2, int i3) {
        if (i3 < 0 || i3 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i2 & 16777215) | (i3 << 24);
    }
}