package e.f.j.n;

import android.graphics.Matrix;

/* compiled from: JpegTranscoderUtils.java */
/* loaded from: classes2.dex */
public class e {
    public static final e.f.d.c.e<Integer> a = e.f.d.c.e.h(2, 7, 4, 5);

    public static int a(int i2) {
        return Math.max(1, 8 / i2);
    }

    public static float b(com.facebook.imagepipeline.common.e eVar, int i2, int i3) {
        if (eVar == null) {
            return 1.0f;
        }
        float f2 = i2;
        float f3 = i3;
        float max = Math.max(eVar.a / f2, eVar.f4529b / f3);
        float f4 = eVar.f4530c;
        if (f2 * max > f4) {
            max = f4 / f2;
        }
        return f3 * max > f4 ? f4 / f3 : max;
    }

    private static int c(e.f.j.i.d dVar) {
        int A = dVar.A();
        if (A == 90 || A == 180 || A == 270) {
            return dVar.A();
        }
        return 0;
    }

    public static int d(com.facebook.imagepipeline.common.f fVar, e.f.j.i.d dVar) {
        int j2 = dVar.j();
        e.f.d.c.e<Integer> eVar = a;
        int indexOf = eVar.indexOf(Integer.valueOf(j2));
        if (indexOf >= 0) {
            return eVar.get((indexOf + ((fVar.g() ? 0 : fVar.e()) / 90)) % eVar.size()).intValue();
        }
        throw new IllegalArgumentException("Only accepts inverted exif orientations");
    }

    public static int e(com.facebook.imagepipeline.common.f fVar, e.f.j.i.d dVar) {
        if (fVar.f()) {
            int c2 = c(dVar);
            return fVar.g() ? c2 : (c2 + fVar.e()) % 360;
        }
        return 0;
    }

    public static int f(com.facebook.imagepipeline.common.f fVar, com.facebook.imagepipeline.common.e eVar, e.f.j.i.d dVar, boolean z) {
        if (z && eVar != null) {
            int e2 = e(fVar, dVar);
            boolean z2 = false;
            int d2 = a.contains(Integer.valueOf(dVar.j())) ? d(fVar, dVar) : 0;
            if (e2 == 90 || e2 == 270 || d2 == 5 || d2 == 7) {
                z2 = true;
            }
            int k2 = k(b(eVar, z2 ? dVar.n() : dVar.N(), z2 ? dVar.N() : dVar.n()), eVar.f4531d);
            if (k2 > 8) {
                return 8;
            }
            if (k2 < 1) {
                return 1;
            }
            return k2;
        }
        return 8;
    }

    public static Matrix g(e.f.j.i.d dVar, com.facebook.imagepipeline.common.f fVar) {
        if (a.contains(Integer.valueOf(dVar.j()))) {
            return h(d(fVar, dVar));
        }
        int e2 = e(fVar, dVar);
        if (e2 != 0) {
            Matrix matrix = new Matrix();
            matrix.setRotate(e2);
            return matrix;
        }
        return null;
    }

    private static Matrix h(int i2) {
        Matrix matrix = new Matrix();
        if (i2 == 2) {
            matrix.setScale(-1.0f, 1.0f);
        } else if (i2 == 7) {
            matrix.setRotate(-90.0f);
            matrix.postScale(-1.0f, 1.0f);
        } else if (i2 == 4) {
            matrix.setRotate(180.0f);
            matrix.postScale(-1.0f, 1.0f);
        } else if (i2 != 5) {
            return null;
        } else {
            matrix.setRotate(90.0f);
            matrix.postScale(-1.0f, 1.0f);
        }
        return matrix;
    }

    public static boolean i(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static boolean j(int i2) {
        return i2 >= 0 && i2 <= 270 && i2 % 90 == 0;
    }

    public static int k(float f2, float f3) {
        return (int) (f3 + (f2 * 8.0f));
    }
}