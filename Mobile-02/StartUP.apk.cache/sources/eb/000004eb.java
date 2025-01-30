package c.f.a.a;

import android.util.Log;
import java.util.Arrays;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.protocol.HTTP;

/* compiled from: Easing.java */
/* loaded from: classes.dex */
public class c {
    static c a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static String[] f2675b = {CookieSpecs.STANDARD, "accelerate", "decelerate", "linear"};

    /* renamed from: c  reason: collision with root package name */
    String f2676c = HTTP.IDENTITY_CODING;

    /* compiled from: Easing.java */
    /* loaded from: classes.dex */
    static class a extends c {

        /* renamed from: d  reason: collision with root package name */
        private static double f2677d = 0.01d;

        /* renamed from: e  reason: collision with root package name */
        private static double f2678e = 1.0E-4d;

        /* renamed from: f  reason: collision with root package name */
        double f2679f;

        /* renamed from: g  reason: collision with root package name */
        double f2680g;

        /* renamed from: h  reason: collision with root package name */
        double f2681h;

        /* renamed from: i  reason: collision with root package name */
        double f2682i;

        a(String str) {
            this.f2676c = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.f2679f = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i2 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i2);
            this.f2680g = Double.parseDouble(str.substring(i2, indexOf3).trim());
            int i3 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i3);
            this.f2681h = Double.parseDouble(str.substring(i3, indexOf4).trim());
            int i4 = indexOf4 + 1;
            this.f2682i = Double.parseDouble(str.substring(i4, str.indexOf(41, i4)).trim());
        }

        private double d(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            return (this.f2679f * d3 * d4 * d2) + (this.f2681h * d4 * d2 * d2) + (d2 * d2 * d2);
        }

        private double e(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            return (this.f2680g * d3 * d4 * d2) + (this.f2682i * d4 * d2 * d2) + (d2 * d2 * d2);
        }

        @Override // c.f.a.a.c
        public double a(double d2) {
            if (d2 <= 0.0d) {
                return 0.0d;
            }
            if (d2 >= 1.0d) {
                return 1.0d;
            }
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > f2677d) {
                d3 *= 0.5d;
                d4 = d(d4) < d2 ? d4 + d3 : d4 - d3;
            }
            double d5 = d4 - d3;
            double d6 = d(d5);
            double d7 = d4 + d3;
            double d8 = d(d7);
            double e2 = e(d5);
            return (((e(d7) - e2) * (d2 - d6)) / (d8 - d6)) + e2;
        }

        @Override // c.f.a.a.c
        public double b(double d2) {
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > f2678e) {
                d3 *= 0.5d;
                d4 = d(d4) < d2 ? d4 + d3 : d4 - d3;
            }
            double d5 = d4 - d3;
            double d6 = d4 + d3;
            return (e(d6) - e(d5)) / (d(d6) - d(d5));
        }
    }

    public static c c(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new a(str);
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals("accelerate")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals("decelerate")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals(CookieSpecs.STANDARD)) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new a("cubic(0.4, 0.05, 0.8, 0.7)");
            case 1:
                return new a("cubic(0.0, 0.0, 0.2, 0.95)");
            case 2:
                return new a("cubic(1, 1, 0, 0)");
            case 3:
                return new a("cubic(0.4, 0.0, 0.2, 1)");
            default:
                Log.e("ConstraintSet", "transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(f2675b));
                return a;
        }
    }

    public double a(double d2) {
        return d2;
    }

    public double b(double d2) {
        return 1.0d;
    }

    public String toString() {
        return this.f2676c;
    }
}