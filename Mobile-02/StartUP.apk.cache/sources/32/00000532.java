package c.h.e;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: PathParser.java */
/* loaded from: classes.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PathParser.java */
    /* loaded from: classes.dex */
    public static class a {
        int a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2929b;

        a() {
        }
    }

    private static void a(ArrayList<b> arrayList, char c2, float[] fArr) {
        arrayList.add(new b(c2, fArr));
    }

    public static boolean b(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            if (bVarArr[i2].a != bVarArr2[i2].a || bVarArr[i2].f2930b.length != bVarArr2[i2].f2930b.length) {
                return false;
            }
        }
        return true;
    }

    static float[] c(float[] fArr, int i2, int i3) {
        if (i2 <= i3) {
            int length = fArr.length;
            if (i2 >= 0 && i2 <= length) {
                int i4 = i3 - i2;
                int min = Math.min(i4, length - i2);
                float[] fArr2 = new float[i4];
                System.arraycopy(fArr, i2, fArr2, 0, min);
                return fArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    public static b[] d(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i3 = 0;
        while (i2 < str.length()) {
            int i4 = i(str, i2);
            String trim = str.substring(i3, i4).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), h(trim));
            }
            i3 = i4;
            i2 = i4 + 1;
        }
        if (i2 - i3 == 1 && i3 < str.length()) {
            a(arrayList, str.charAt(i3), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    public static Path e(String str) {
        Path path = new Path();
        b[] d2 = d(str);
        if (d2 != null) {
            try {
                b.e(d2, path);
                return path;
            } catch (RuntimeException e2) {
                throw new RuntimeException("Error in parsing " + str, e2);
            }
        }
        return null;
    }

    public static b[] f(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            bVarArr2[i2] = new b(bVarArr[i2]);
        }
        return bVarArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003a A[LOOP:0: B:3:0x0007->B:24:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(java.lang.String r8, int r9, c.h.e.c.a r10) {
        /*
            r0 = 0
            r10.f2929b = r0
            r1 = r9
            r2 = r0
            r3 = r2
            r4 = r3
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3d
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L35
            r6 = 69
            if (r5 == r6) goto L33
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L33
            switch(r5) {
                case 44: goto L35;
                case 45: goto L2a;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L31
        L22:
            if (r3 != 0) goto L27
            r2 = r0
            r3 = r7
            goto L37
        L27:
            r10.f2929b = r7
            goto L35
        L2a:
            if (r1 == r9) goto L31
            if (r2 != 0) goto L31
            r10.f2929b = r7
            goto L35
        L31:
            r2 = r0
            goto L37
        L33:
            r2 = r7
            goto L37
        L35:
            r2 = r0
            r4 = r7
        L37:
            if (r4 == 0) goto L3a
            goto L3d
        L3a:
            int r1 = r1 + 1
            goto L7
        L3d:
            r10.a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.h.e.c.g(java.lang.String, int, c.h.e.c$a):void");
    }

    private static float[] h(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i2 = 1;
            int i3 = 0;
            while (i2 < length) {
                g(str, i2, aVar);
                int i4 = aVar.a;
                if (i2 < i4) {
                    fArr[i3] = Float.parseFloat(str.substring(i2, i4));
                    i3++;
                }
                i2 = aVar.f2929b ? i4 : i4 + 1;
            }
            return c(fArr, 0, i3);
        } catch (NumberFormatException e2) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e2);
        }
    }

    private static int i(String str, int i2) {
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i2;
            }
            i2++;
        }
        return i2;
    }

    public static void j(b[] bVarArr, b[] bVarArr2) {
        for (int i2 = 0; i2 < bVarArr2.length; i2++) {
            bVarArr[i2].a = bVarArr2[i2].a;
            for (int i3 = 0; i3 < bVarArr2[i2].f2930b.length; i3++) {
                bVarArr[i2].f2930b[i3] = bVarArr2[i2].f2930b[i3];
            }
        }
    }

    /* compiled from: PathParser.java */
    /* loaded from: classes.dex */
    public static class b {
        public char a;

        /* renamed from: b  reason: collision with root package name */
        public float[] f2930b;

        b(char c2, float[] fArr) {
            this.a = c2;
            this.f2930b = fArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void a(Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            int i2;
            int i3;
            int i4;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            char c4 = c3;
            char c5 = 0;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            float f13 = fArr[3];
            float f14 = fArr[4];
            float f15 = fArr[5];
            switch (c4) {
                case 'A':
                case 'a':
                    i2 = 7;
                    i3 = i2;
                    break;
                case 'C':
                case 'c':
                    i2 = 6;
                    i3 = i2;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i3 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i3 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i3 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f14, f15);
                    f10 = f14;
                    f12 = f10;
                    f11 = f15;
                    f13 = f11;
                    i3 = 2;
                    break;
            }
            float f16 = f10;
            float f17 = f11;
            float f18 = f14;
            float f19 = f15;
            int i5 = 0;
            char c6 = c2;
            while (i5 < fArr2.length) {
                if (c4 != 'A') {
                    if (c4 == 'C') {
                        i4 = i5;
                        int i6 = i4 + 2;
                        int i7 = i4 + 3;
                        int i8 = i4 + 4;
                        int i9 = i4 + 5;
                        path.cubicTo(fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i6], fArr2[i7], fArr2[i8], fArr2[i9]);
                        f16 = fArr2[i8];
                        float f20 = fArr2[i9];
                        float f21 = fArr2[i6];
                        float f22 = fArr2[i7];
                        f17 = f20;
                        f13 = f22;
                        f12 = f21;
                    } else if (c4 == 'H') {
                        i4 = i5;
                        int i10 = i4 + 0;
                        path.lineTo(fArr2[i10], f17);
                        f16 = fArr2[i10];
                    } else if (c4 == 'Q') {
                        i4 = i5;
                        int i11 = i4 + 0;
                        int i12 = i4 + 1;
                        int i13 = i4 + 2;
                        int i14 = i4 + 3;
                        path.quadTo(fArr2[i11], fArr2[i12], fArr2[i13], fArr2[i14]);
                        float f23 = fArr2[i11];
                        float f24 = fArr2[i12];
                        f16 = fArr2[i13];
                        f17 = fArr2[i14];
                        f12 = f23;
                        f13 = f24;
                    } else if (c4 == 'V') {
                        i4 = i5;
                        int i15 = i4 + 0;
                        path.lineTo(f16, fArr2[i15]);
                        f17 = fArr2[i15];
                    } else if (c4 != 'a') {
                        if (c4 != 'c') {
                            if (c4 == 'h') {
                                int i16 = i5 + 0;
                                path.rLineTo(fArr2[i16], 0.0f);
                                f16 += fArr2[i16];
                            } else if (c4 != 'q') {
                                if (c4 == 'v') {
                                    int i17 = i5 + 0;
                                    path.rLineTo(0.0f, fArr2[i17]);
                                    f5 = fArr2[i17];
                                } else if (c4 == 'L') {
                                    int i18 = i5 + 0;
                                    int i19 = i5 + 1;
                                    path.lineTo(fArr2[i18], fArr2[i19]);
                                    f16 = fArr2[i18];
                                    f17 = fArr2[i19];
                                } else if (c4 == 'M') {
                                    int i20 = i5 + 0;
                                    f16 = fArr2[i20];
                                    int i21 = i5 + 1;
                                    f17 = fArr2[i21];
                                    if (i5 > 0) {
                                        path.lineTo(fArr2[i20], fArr2[i21]);
                                    } else {
                                        path.moveTo(fArr2[i20], fArr2[i21]);
                                        i4 = i5;
                                        f19 = f17;
                                        f18 = f16;
                                    }
                                } else if (c4 == 'S') {
                                    if (c6 == 'c' || c6 == 's' || c6 == 'C' || c6 == 'S') {
                                        f16 = (f16 * 2.0f) - f12;
                                        f17 = (f17 * 2.0f) - f13;
                                    }
                                    float f25 = f17;
                                    int i22 = i5 + 0;
                                    int i23 = i5 + 1;
                                    int i24 = i5 + 2;
                                    int i25 = i5 + 3;
                                    path.cubicTo(f16, f25, fArr2[i22], fArr2[i23], fArr2[i24], fArr2[i25]);
                                    f2 = fArr2[i22];
                                    f3 = fArr2[i23];
                                    f16 = fArr2[i24];
                                    f17 = fArr2[i25];
                                    f12 = f2;
                                    f13 = f3;
                                } else if (c4 == 'T') {
                                    if (c6 == 'q' || c6 == 't' || c6 == 'Q' || c6 == 'T') {
                                        f16 = (f16 * 2.0f) - f12;
                                        f17 = (f17 * 2.0f) - f13;
                                    }
                                    int i26 = i5 + 0;
                                    int i27 = i5 + 1;
                                    path.quadTo(f16, f17, fArr2[i26], fArr2[i27]);
                                    float f26 = fArr2[i26];
                                    float f27 = fArr2[i27];
                                    i4 = i5;
                                    f13 = f17;
                                    f12 = f16;
                                    f16 = f26;
                                    f17 = f27;
                                } else if (c4 == 'l') {
                                    int i28 = i5 + 0;
                                    int i29 = i5 + 1;
                                    path.rLineTo(fArr2[i28], fArr2[i29]);
                                    f16 += fArr2[i28];
                                    f5 = fArr2[i29];
                                } else if (c4 == 'm') {
                                    int i30 = i5 + 0;
                                    f16 += fArr2[i30];
                                    int i31 = i5 + 1;
                                    f17 += fArr2[i31];
                                    if (i5 > 0) {
                                        path.rLineTo(fArr2[i30], fArr2[i31]);
                                    } else {
                                        path.rMoveTo(fArr2[i30], fArr2[i31]);
                                        i4 = i5;
                                        f19 = f17;
                                        f18 = f16;
                                    }
                                } else if (c4 == 's') {
                                    if (c6 == 'c' || c6 == 's' || c6 == 'C' || c6 == 'S') {
                                        float f28 = f16 - f12;
                                        f6 = f17 - f13;
                                        f7 = f28;
                                    } else {
                                        f7 = 0.0f;
                                        f6 = 0.0f;
                                    }
                                    int i32 = i5 + 0;
                                    int i33 = i5 + 1;
                                    int i34 = i5 + 2;
                                    int i35 = i5 + 3;
                                    path.rCubicTo(f7, f6, fArr2[i32], fArr2[i33], fArr2[i34], fArr2[i35]);
                                    f2 = fArr2[i32] + f16;
                                    f3 = fArr2[i33] + f17;
                                    f16 += fArr2[i34];
                                    f4 = fArr2[i35];
                                } else if (c4 == 't') {
                                    if (c6 == 'q' || c6 == 't' || c6 == 'Q' || c6 == 'T') {
                                        f8 = f16 - f12;
                                        f9 = f17 - f13;
                                    } else {
                                        f9 = 0.0f;
                                        f8 = 0.0f;
                                    }
                                    int i36 = i5 + 0;
                                    int i37 = i5 + 1;
                                    path.rQuadTo(f8, f9, fArr2[i36], fArr2[i37]);
                                    float f29 = f8 + f16;
                                    float f30 = f9 + f17;
                                    f16 += fArr2[i36];
                                    f17 += fArr2[i37];
                                    f13 = f30;
                                    f12 = f29;
                                }
                                f17 += f5;
                            } else {
                                int i38 = i5 + 0;
                                int i39 = i5 + 1;
                                int i40 = i5 + 2;
                                int i41 = i5 + 3;
                                path.rQuadTo(fArr2[i38], fArr2[i39], fArr2[i40], fArr2[i41]);
                                f2 = fArr2[i38] + f16;
                                f3 = fArr2[i39] + f17;
                                f16 += fArr2[i40];
                                f4 = fArr2[i41];
                            }
                            i4 = i5;
                        } else {
                            int i42 = i5 + 2;
                            int i43 = i5 + 3;
                            int i44 = i5 + 4;
                            int i45 = i5 + 5;
                            path.rCubicTo(fArr2[i5 + 0], fArr2[i5 + 1], fArr2[i42], fArr2[i43], fArr2[i44], fArr2[i45]);
                            f2 = fArr2[i42] + f16;
                            f3 = fArr2[i43] + f17;
                            f16 += fArr2[i44];
                            f4 = fArr2[i45];
                        }
                        f17 += f4;
                        f12 = f2;
                        f13 = f3;
                        i4 = i5;
                    } else {
                        int i46 = i5 + 5;
                        int i47 = i5 + 6;
                        i4 = i5;
                        c(path, f16, f17, fArr2[i46] + f16, fArr2[i47] + f17, fArr2[i5 + 0], fArr2[i5 + 1], fArr2[i5 + 2], fArr2[i5 + 3] != 0.0f, fArr2[i5 + 4] != 0.0f);
                        f16 += fArr2[i46];
                        f17 += fArr2[i47];
                    }
                    i5 = i4 + i3;
                    c6 = c3;
                    c4 = c6;
                    c5 = 0;
                } else {
                    i4 = i5;
                    int i48 = i4 + 5;
                    int i49 = i4 + 6;
                    c(path, f16, f17, fArr2[i48], fArr2[i49], fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3] != 0.0f, fArr2[i4 + 4] != 0.0f);
                    f16 = fArr2[i48];
                    f17 = fArr2[i49];
                }
                f13 = f17;
                f12 = f16;
                i5 = i4 + i3;
                c6 = c3;
                c4 = c6;
                c5 = 0;
            }
            fArr[c5] = f16;
            fArr[1] = f17;
            fArr[2] = f12;
            fArr[3] = f13;
            fArr[4] = f18;
            fArr[5] = f19;
        }

        private static void b(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            double d11 = d4;
            int ceil = (int) Math.ceil(Math.abs((d10 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d8);
            double sin = Math.sin(d8);
            double cos2 = Math.cos(d9);
            double sin2 = Math.sin(d9);
            double d12 = -d11;
            double d13 = d12 * cos;
            double d14 = d5 * sin;
            double d15 = (d13 * sin2) - (d14 * cos2);
            double d16 = d12 * sin;
            double d17 = d5 * cos;
            double d18 = (sin2 * d16) + (cos2 * d17);
            double d19 = d10 / ceil;
            double d20 = d18;
            double d21 = d15;
            int i2 = 0;
            double d22 = d6;
            double d23 = d7;
            double d24 = d9;
            while (i2 < ceil) {
                double d25 = d24 + d19;
                double sin3 = Math.sin(d25);
                double cos3 = Math.cos(d25);
                double d26 = (d2 + ((d11 * cos) * cos3)) - (d14 * sin3);
                double d27 = d3 + (d11 * sin * cos3) + (d17 * sin3);
                double d28 = (d13 * sin3) - (d14 * cos3);
                double d29 = (sin3 * d16) + (cos3 * d17);
                double d30 = d25 - d24;
                double tan = Math.tan(d30 / 2.0d);
                double sin4 = (Math.sin(d30) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d31 = d22 + (d21 * sin4);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d31, (float) (d23 + (d20 * sin4)), (float) (d26 - (sin4 * d28)), (float) (d27 - (sin4 * d29)), (float) d26, (float) d27);
                i2++;
                d19 = d19;
                sin = sin;
                d22 = d26;
                d16 = d16;
                cos = cos;
                d24 = d25;
                d20 = d29;
                d21 = d28;
                ceil = ceil;
                d23 = d27;
                d11 = d4;
            }
        }

        private static void c(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
            double d2;
            double d3;
            double radians = Math.toRadians(f8);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d4 = f2;
            double d5 = d4 * cos;
            double d6 = f3;
            double d7 = f6;
            double d8 = (d5 + (d6 * sin)) / d7;
            double d9 = f7;
            double d10 = (((-f2) * sin) + (d6 * cos)) / d9;
            double d11 = f5;
            double d12 = ((f4 * cos) + (d11 * sin)) / d7;
            double d13 = (((-f4) * sin) + (d11 * cos)) / d9;
            double d14 = d8 - d12;
            double d15 = d10 - d13;
            double d16 = (d8 + d12) / 2.0d;
            double d17 = (d10 + d13) / 2.0d;
            double d18 = (d14 * d14) + (d15 * d15);
            if (d18 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d19 = (1.0d / d18) - 0.25d;
            if (d19 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d18);
                float sqrt = (float) (Math.sqrt(d18) / 1.99999d);
                c(path, f2, f3, f4, f5, f6 * sqrt, f7 * sqrt, f8, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d19);
            double d20 = d14 * sqrt2;
            double d21 = sqrt2 * d15;
            if (z == z2) {
                d2 = d16 - d21;
                d3 = d17 + d20;
            } else {
                d2 = d16 + d21;
                d3 = d17 - d20;
            }
            double atan2 = Math.atan2(d10 - d3, d8 - d2);
            double atan22 = Math.atan2(d13 - d3, d12 - d2) - atan2;
            int i2 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (z2 != (i2 >= 0)) {
                atan22 = i2 > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d22 = d2 * d7;
            double d23 = d3 * d9;
            b(path, (d22 * cos) - (d23 * sin), (d22 * sin) + (d23 * cos), d7, d9, d4, d6, radians, atan2, atan22);
        }

        public static void e(b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c2 = 'm';
            for (int i2 = 0; i2 < bVarArr.length; i2++) {
                a(path, fArr, c2, bVarArr[i2].a, bVarArr[i2].f2930b);
                c2 = bVarArr[i2].a;
            }
        }

        public void d(b bVar, b bVar2, float f2) {
            this.a = bVar.a;
            int i2 = 0;
            while (true) {
                float[] fArr = bVar.f2930b;
                if (i2 >= fArr.length) {
                    return;
                }
                this.f2930b[i2] = (fArr[i2] * (1.0f - f2)) + (bVar2.f2930b[i2] * f2);
                i2++;
            }
        }

        b(b bVar) {
            this.a = bVar.a;
            float[] fArr = bVar.f2930b;
            this.f2930b = c.c(fArr, 0, fArr.length);
        }
    }
}