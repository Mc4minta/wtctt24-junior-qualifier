package e.f.j.n;

import e.f.d.c.i;

/* compiled from: DownsampleUtil.java */
/* loaded from: classes2.dex */
public class a {
    public static float a(com.facebook.imagepipeline.common.f fVar, com.facebook.imagepipeline.common.e eVar, e.f.j.i.d dVar) {
        i.b(e.f.j.i.d.V(dVar));
        if (eVar == null || eVar.f4529b <= 0 || eVar.a <= 0 || dVar.N() == 0 || dVar.n() == 0) {
            return 1.0f;
        }
        int c2 = c(fVar, dVar);
        boolean z = c2 == 90 || c2 == 270;
        int n = z ? dVar.n() : dVar.N();
        int N = z ? dVar.N() : dVar.n();
        float f2 = eVar.a / n;
        float f3 = eVar.f4529b / N;
        float max = Math.max(f2, f3);
        e.f.d.d.a.v("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f", Integer.valueOf(eVar.a), Integer.valueOf(eVar.f4529b), Integer.valueOf(n), Integer.valueOf(N), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(max));
        return max;
    }

    public static int b(com.facebook.imagepipeline.common.f fVar, com.facebook.imagepipeline.common.e eVar, e.f.j.i.d dVar, int i2) {
        int d2;
        if (e.f.j.i.d.V(dVar)) {
            float a = a(fVar, eVar, dVar);
            if (dVar.v() == e.f.i.b.a) {
                d2 = e(a);
            } else {
                d2 = d(a);
            }
            int max = Math.max(dVar.n(), dVar.N());
            float f2 = eVar != null ? eVar.f4530c : i2;
            while (max / d2 > f2) {
                d2 = dVar.v() == e.f.i.b.a ? d2 * 2 : d2 + 1;
            }
            return d2;
        }
        return 1;
    }

    private static int c(com.facebook.imagepipeline.common.f fVar, e.f.j.i.d dVar) {
        boolean z = false;
        if (fVar.g()) {
            int A = dVar.A();
            i.b((A == 0 || A == 90 || A == 180 || A == 270) ? true : true);
            return A;
        }
        return 0;
    }

    public static int d(float f2) {
        if (f2 > 0.6666667f) {
            return 1;
        }
        int i2 = 2;
        while (true) {
            double d2 = i2;
            if ((1.0d / d2) + ((1.0d / (Math.pow(d2, 2.0d) - d2)) * 0.3333333432674408d) <= f2) {
                return i2 - 1;
            }
            i2++;
        }
    }

    public static int e(float f2) {
        if (f2 > 0.6666667f) {
            return 1;
        }
        int i2 = 2;
        while (true) {
            int i3 = i2 * 2;
            double d2 = 1.0d / i3;
            if (d2 + (0.3333333432674408d * d2) <= f2) {
                return i2;
            }
            i2 = i3;
        }
    }
}