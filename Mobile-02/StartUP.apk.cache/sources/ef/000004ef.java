package c.f.a.a;

import java.util.Arrays;

/* compiled from: Oscillator.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    double[] f2688c;

    /* renamed from: d  reason: collision with root package name */
    int f2689d;
    float[] a = new float[0];

    /* renamed from: b  reason: collision with root package name */
    double[] f2687b = new double[0];

    /* renamed from: e  reason: collision with root package name */
    double f2690e = 6.283185307179586d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2691f = false;

    public void a(double d2, float f2) {
        int length = this.a.length + 1;
        int binarySearch = Arrays.binarySearch(this.f2687b, d2);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.f2687b = Arrays.copyOf(this.f2687b, length);
        this.a = Arrays.copyOf(this.a, length);
        this.f2688c = new double[length];
        double[] dArr = this.f2687b;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.f2687b[binarySearch] = d2;
        this.a[binarySearch] = f2;
        this.f2691f = false;
    }

    double b(double d2) {
        if (d2 <= 0.0d) {
            d2 = 1.0E-5d;
        } else if (d2 >= 1.0d) {
            d2 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.f2687b, d2);
        if (binarySearch <= 0 && binarySearch != 0) {
            int i2 = (-binarySearch) - 1;
            float[] fArr = this.a;
            int i3 = i2 - 1;
            double d3 = fArr[i2] - fArr[i3];
            double[] dArr = this.f2687b;
            double d4 = d3 / (dArr[i2] - dArr[i3]);
            return (fArr[i3] - (d4 * dArr[i3])) + (d2 * d4);
        }
        return 0.0d;
    }

    double c(double d2) {
        if (d2 < 0.0d) {
            d2 = 0.0d;
        } else if (d2 > 1.0d) {
            d2 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.f2687b, d2);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch != 0) {
            int i2 = (-binarySearch) - 1;
            float[] fArr = this.a;
            int i3 = i2 - 1;
            double d3 = fArr[i2] - fArr[i3];
            double[] dArr = this.f2687b;
            double d4 = d3 / (dArr[i2] - dArr[i3]);
            return this.f2688c[i3] + ((fArr[i3] - (dArr[i3] * d4)) * (d2 - dArr[i3])) + ((d4 * ((d2 * d2) - (dArr[i3] * dArr[i3]))) / 2.0d);
        }
        return 0.0d;
    }

    public double d(double d2) {
        double b2;
        double signum;
        double b3;
        double b4;
        double sin;
        switch (this.f2689d) {
            case 1:
                return 0.0d;
            case 2:
                b2 = b(d2) * 4.0d;
                signum = Math.signum((((c(d2) * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                return b2 * signum;
            case 3:
                b3 = b(d2);
                return b3 * 2.0d;
            case 4:
                b3 = -b(d2);
                return b3 * 2.0d;
            case 5:
                b4 = (-this.f2690e) * b(d2);
                sin = Math.sin(this.f2690e * c(d2));
                return b4 * sin;
            case 6:
                b2 = b(d2) * 4.0d;
                signum = (((c(d2) * 4.0d) + 2.0d) % 4.0d) - 2.0d;
                return b2 * signum;
            default:
                b4 = this.f2690e * b(d2);
                sin = Math.cos(this.f2690e * c(d2));
                return b4 * sin;
        }
    }

    public double e(double d2) {
        double abs;
        switch (this.f2689d) {
            case 1:
                return Math.signum(0.5d - (c(d2) % 1.0d));
            case 2:
                abs = Math.abs((((c(d2) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((c(d2) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((c(d2) * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.f2690e * c(d2));
            case 6:
                double abs2 = 1.0d - Math.abs(((c(d2) * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            default:
                return Math.sin(this.f2690e * c(d2));
        }
        return 1.0d - abs;
    }

    public void f() {
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        int i2;
        int i3 = 0;
        double d2 = 0.0d;
        while (true) {
            if (i3 >= this.a.length) {
                break;
            }
            d2 += fArr[i3];
            i3++;
        }
        double d3 = 0.0d;
        int i4 = 1;
        while (true) {
            if (i4 >= this.a.length) {
                break;
            }
            double[] dArr = this.f2687b;
            d3 += (dArr[i4] - dArr[i4 - 1]) * ((fArr2[i2] + fArr2[i4]) / 2.0f);
            i4++;
        }
        int i5 = 0;
        while (true) {
            float[] fArr4 = this.a;
            if (i5 >= fArr4.length) {
                break;
            }
            fArr4[i5] = (float) (fArr4[i5] * (d2 / d3));
            i5++;
        }
        this.f2688c[0] = 0.0d;
        int i6 = 1;
        while (true) {
            if (i6 < this.a.length) {
                int i7 = i6 - 1;
                double[] dArr2 = this.f2687b;
                double d4 = dArr2[i6] - dArr2[i7];
                double[] dArr3 = this.f2688c;
                dArr3[i6] = dArr3[i7] + (d4 * ((fArr3[i7] + fArr3[i6]) / 2.0f));
                i6++;
            } else {
                this.f2691f = true;
                return;
            }
        }
    }

    public void g(int i2) {
        this.f2689d = i2;
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.f2687b) + " period=" + Arrays.toString(this.a);
    }
}