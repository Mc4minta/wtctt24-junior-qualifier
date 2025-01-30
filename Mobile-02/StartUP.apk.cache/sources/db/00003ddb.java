package com.horcrux.svg;

import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;

/* compiled from: PathParser.java */
/* loaded from: classes2.dex */
class s {
    static float a;

    /* renamed from: b  reason: collision with root package name */
    private static int f10298b;

    /* renamed from: c  reason: collision with root package name */
    private static int f10299c;

    /* renamed from: d  reason: collision with root package name */
    private static String f10300d;

    /* renamed from: e  reason: collision with root package name */
    private static Path f10301e;

    /* renamed from: f  reason: collision with root package name */
    static ArrayList<r> f10302f;

    /* renamed from: g  reason: collision with root package name */
    private static float f10303g;

    /* renamed from: h  reason: collision with root package name */
    private static float f10304h;

    /* renamed from: i  reason: collision with root package name */
    private static float f10305i;

    /* renamed from: j  reason: collision with root package name */
    private static float f10306j;

    /* renamed from: k  reason: collision with root package name */
    private static float f10307k;

    /* renamed from: l  reason: collision with root package name */
    private static float f10308l;
    private static boolean m;

    private static void A(float f2, float f3, float f4, float f5) {
        f10305i = f2;
        f10306j = f3;
        e((f10303g * 2.0f) - f10305i, (f10304h * 2.0f) - f10306j, f2, f3, f4, f5);
    }

    private static void B(float f2, float f3) {
        C(f2 + f10303g, f3 + f10304h);
    }

    private static void C(float f2, float f3) {
        u((f10303g * 2.0f) - f10305i, (f10304h * 2.0f) - f10306j, f2, f3);
    }

    private static void a(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
        b(f2, f3, f4, z, z2, f5 + f10303g, f6 + f10304h);
    }

    private static void b(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13 = f10303g;
        float f14 = f10304h;
        float abs = Math.abs(f3 == 0.0f ? f2 == 0.0f ? f6 - f14 : f2 : f3);
        float abs2 = Math.abs(f2 == 0.0f ? f5 - f13 : f2);
        if (abs2 != 0.0f && abs != 0.0f && (f5 != f13 || f6 != f14)) {
            float radians = (float) Math.toRadians(f4);
            double d2 = radians;
            float cos = (float) Math.cos(d2);
            float sin = (float) Math.sin(d2);
            float f15 = f5 - f13;
            float f16 = f6 - f14;
            float f17 = ((cos * f15) / 2.0f) + ((sin * f16) / 2.0f);
            float f18 = -sin;
            float f19 = ((f18 * f15) / 2.0f) + ((cos * f16) / 2.0f);
            float f20 = abs2 * abs2;
            float f21 = abs * abs * f17 * f17;
            if ((((f20 * abs) * abs) - ((f20 * f19) * f19)) - f21 < 0.0f) {
                f10 = f18;
                float sqrt = (float) Math.sqrt(1.0f - (f9 / f7));
                abs2 *= sqrt;
                abs *= sqrt;
                f11 = f15 / 2.0f;
                f12 = f16 / 2.0f;
            } else {
                f10 = f18;
                float sqrt2 = (float) Math.sqrt(f9 / (f8 + f21));
                if (z == z2) {
                    sqrt2 = -sqrt2;
                }
                float f22 = (((-sqrt2) * f19) * abs2) / abs;
                float f23 = ((sqrt2 * f17) * abs) / abs2;
                f11 = ((cos * f22) - (sin * f23)) + (f15 / 2.0f);
                f12 = (f16 / 2.0f) + (f22 * sin) + (f23 * cos);
            }
            float f24 = cos / abs2;
            float f25 = sin / abs2;
            float f26 = f10 / abs;
            float f27 = cos / abs;
            float f28 = -f11;
            float f29 = -f12;
            float f30 = abs;
            float f31 = abs2;
            float atan2 = (float) Math.atan2((f26 * f28) + (f27 * f29), (f28 * f24) + (f29 * f25));
            float f32 = f15 - f11;
            float f33 = f16 - f12;
            float atan22 = (float) Math.atan2((f26 * f32) + (f27 * f33), (f24 * f32) + (f25 * f33));
            float f34 = f11 + f13;
            float f35 = f12 + f14;
            float f36 = f15 + f13;
            float f37 = f16 + f14;
            w();
            f10305i = f36;
            f10303g = f36;
            f10306j = f37;
            f10304h = f37;
            if (f31 == f30 && radians == 0.0f) {
                float degrees = (float) Math.toDegrees(atan2);
                float abs3 = Math.abs((degrees - ((float) Math.toDegrees(atan22))) % 360.0f);
                if (!z ? abs3 > 180.0f : abs3 < 180.0f) {
                    abs3 = 360.0f - abs3;
                }
                if (!z2) {
                    abs3 = -abs3;
                }
                float f38 = a;
                f10301e.arcTo(new RectF((f34 - f31) * f38, (f35 - f31) * f38, (f34 + f31) * f38, (f35 + f31) * f38), degrees, abs3);
                f10302f.add(new r(f.kCGPathElementAddCurveToPoint, new v[]{new v(f36, f37)}));
                return;
            }
            c(f34, f35, f31, f30, atan2, atan22, z2, radians);
            return;
        }
        l(f5, f6);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0067 A[LOOP:0: B:12:0x0065->B:13:0x0067, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(float r24, float r25, float r26, float r27, float r28, float r29, boolean r30, float r31) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.s.c(float, float, float, float, float, float, boolean, float):void");
    }

    private static void d() {
        if (m) {
            f10303g = f10307k;
            f10304h = f10308l;
            m = false;
            f10301e.close();
            f10302f.add(new r(f.kCGPathElementCloseSubpath, new v[]{new v(f10303g, f10304h)}));
        }
    }

    private static void e(float f2, float f3, float f4, float f5, float f6, float f7) {
        w();
        f10303g = f6;
        f10304h = f7;
        Path path = f10301e;
        float f8 = a;
        path.cubicTo(f2 * f8, f3 * f8, f4 * f8, f5 * f8, f6 * f8, f7 * f8);
        f10302f.add(new r(f.kCGPathElementAddCurveToPoint, new v[]{new v(f2, f3), new v(f4, f5), new v(f6, f7)}));
    }

    private static void f(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f10303g;
        float f9 = f10304h;
        g(f2 + f8, f3 + f9, f4 + f8, f5 + f9, f6 + f8, f7 + f9);
    }

    private static void g(float f2, float f3, float f4, float f5, float f6, float f7) {
        f10305i = f4;
        f10306j = f5;
        e(f2, f3, f4, f5, f6, f7);
    }

    private static boolean h(char c2) {
        return Character.isUpperCase(c2);
    }

    private static boolean i(char c2) {
        switch (c2) {
            case 'A':
            case 'C':
            case 'H':
            case 'L':
            case 'M':
            case 'Q':
            case 'S':
            case 'T':
            case 'V':
            case 'Z':
            case 'a':
            case 'c':
            case 'h':
            case 'l':
            case 'm':
            case 'q':
            case 's':
            case 't':
            case 'v':
            case 'z':
                return true;
            default:
                return false;
        }
    }

    private static boolean j(char c2) {
        return (c2 >= '0' && c2 <= '9') || c2 == '.' || c2 == '-' || c2 == '+';
    }

    private static void k(float f2, float f3) {
        l(f2 + f10303g, f3 + f10304h);
    }

    private static void l(float f2, float f3) {
        w();
        f10303g = f2;
        f10305i = f2;
        f10304h = f3;
        f10306j = f3;
        Path path = f10301e;
        float f4 = a;
        path.lineTo(f2 * f4, f4 * f3);
        f10302f.add(new r(f.kCGPathElementAddLineToPoint, new v[]{new v(f2, f3)}));
    }

    private static void m(float f2, float f3) {
        n(f2 + f10303g, f3 + f10304h);
    }

    private static void n(float f2, float f3) {
        f10303g = f2;
        f10305i = f2;
        f10307k = f2;
        f10304h = f3;
        f10306j = f3;
        f10308l = f3;
        Path path = f10301e;
        float f4 = a;
        path.moveTo(f2 * f4, f4 * f3);
        f10302f.add(new r(f.kCGPathElementMoveToPoint, new v[]{new v(f2, f3)}));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x020a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x002e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Path o(java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 664
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.s.o(java.lang.String):android.graphics.Path");
    }

    private static boolean p() {
        y();
        char charAt = f10300d.charAt(f10298b);
        if (charAt != '0' && charAt != '1') {
            throw new Error(String.format("Unexpected flag '%c' (i=%d, s=%s)", Character.valueOf(charAt), Integer.valueOf(f10298b), f10300d));
        }
        int i2 = f10298b + 1;
        f10298b = i2;
        if (i2 < f10299c && f10300d.charAt(i2) == ',') {
            f10298b++;
        }
        y();
        return charAt == '1';
    }

    private static float q() {
        if (f10298b != f10299c) {
            float s = s();
            y();
            r();
            return s;
        }
        throw new Error(String.format("Unexpected end (s=%s)", f10300d));
    }

    private static void r() {
        int i2 = f10298b;
        if (i2 >= f10299c || f10300d.charAt(i2) != ',') {
            return;
        }
        f10298b++;
    }

    private static float s() {
        char charAt;
        y();
        int i2 = f10298b;
        if (i2 != f10299c) {
            char charAt2 = f10300d.charAt(i2);
            if (charAt2 == '-' || charAt2 == '+') {
                int i3 = f10298b + 1;
                f10298b = i3;
                charAt2 = f10300d.charAt(i3);
            }
            if (charAt2 >= '0' && charAt2 <= '9') {
                x();
                int i4 = f10298b;
                if (i4 < f10299c) {
                    charAt2 = f10300d.charAt(i4);
                }
            } else if (charAt2 != '.') {
                throw new Error(String.format("Invalid number formating character '%c' (i=%d, s=%s)", Character.valueOf(charAt2), Integer.valueOf(f10298b), f10300d));
            }
            if (charAt2 == '.') {
                f10298b++;
                x();
                int i5 = f10298b;
                if (i5 < f10299c) {
                    charAt2 = f10300d.charAt(i5);
                }
            }
            if (charAt2 == 'e' || charAt2 == 'E') {
                int i6 = f10298b;
                if (i6 + 1 < f10299c && (charAt = f10300d.charAt(i6 + 1)) != 'm' && charAt != 'x') {
                    int i7 = f10298b + 1;
                    f10298b = i7;
                    char charAt3 = f10300d.charAt(i7);
                    if (charAt3 == '+' || charAt3 == '-') {
                        f10298b++;
                        x();
                    } else if (charAt3 >= '0' && charAt3 <= '9') {
                        x();
                    } else {
                        throw new Error(String.format("Invalid number formating character '%c' (i=%d, s=%s)", Character.valueOf(charAt3), Integer.valueOf(f10298b), f10300d));
                    }
                }
            }
            String substring = f10300d.substring(i2, f10298b);
            float parseFloat = Float.parseFloat(substring);
            if (Float.isInfinite(parseFloat) || Float.isNaN(parseFloat)) {
                throw new Error(String.format("Invalid number '%s' (start=%d, i=%d, s=%s)", substring, Integer.valueOf(i2), Integer.valueOf(f10298b), f10300d));
            }
            return parseFloat;
        }
        throw new Error(String.format("Unexpected end (s=%s)", f10300d));
    }

    private static void t(float f2, float f3, float f4, float f5) {
        float f6 = f10303g;
        float f7 = f10304h;
        u(f2 + f6, f3 + f7, f4 + f6, f5 + f7);
    }

    private static void u(float f2, float f3, float f4, float f5) {
        f10305i = f2;
        f10306j = f3;
        float f6 = f2 * 2.0f;
        float f7 = f3 * 2.0f;
        float f8 = (f10303g + f6) / 3.0f;
        float f9 = (f10304h + f7) / 3.0f;
        e(f8, f9, (f4 + f6) / 3.0f, (f5 + f7) / 3.0f, f4, f5);
    }

    private static double v(double d2) {
        double pow = Math.pow(10.0d, 4.0d);
        return Math.round(d2 * pow) / pow;
    }

    private static void w() {
        if (m) {
            return;
        }
        f10307k = f10303g;
        f10308l = f10304h;
        m = true;
    }

    private static void x() {
        while (true) {
            int i2 = f10298b;
            if (i2 >= f10299c || !Character.isDigit(f10300d.charAt(i2))) {
                return;
            }
            f10298b++;
        }
    }

    private static void y() {
        while (true) {
            int i2 = f10298b;
            if (i2 >= f10299c || !Character.isWhitespace(f10300d.charAt(i2))) {
                return;
            }
            f10298b++;
        }
    }

    private static void z(float f2, float f3, float f4, float f5) {
        float f6 = f10303g;
        float f7 = f10304h;
        A(f2 + f6, f3 + f7, f4 + f6, f5 + f7);
    }
}