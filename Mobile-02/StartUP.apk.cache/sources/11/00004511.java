package e.a.a.z;

import android.graphics.Path;
import android.graphics.PointF;
import e.a.a.u.b.k;
import e.a.a.w.k.l;
import java.util.List;

/* compiled from: MiscUtils.java */
/* loaded from: classes.dex */
public class g {
    private static PointF a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static double b(double d2, double d3, double d4) {
        return Math.max(d3, Math.min(d4, d2));
    }

    public static float c(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f4, f2));
    }

    public static int d(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i4, i2));
    }

    public static boolean e(float f2, float f3, float f4) {
        return f2 >= f3 && f2 <= f4;
    }

    private static int f(int i2, int i3) {
        int i4 = i2 / i3;
        return (((i2 ^ i3) >= 0) || i2 % i3 == 0) ? i4 : i4 - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(float f2, float f3) {
        return h((int) f2, (int) f3);
    }

    private static int h(int i2, int i3) {
        return i2 - (i3 * f(i2, i3));
    }

    public static void i(l lVar, Path path) {
        path.reset();
        PointF b2 = lVar.b();
        path.moveTo(b2.x, b2.y);
        a.set(b2.x, b2.y);
        for (int i2 = 0; i2 < lVar.a().size(); i2++) {
            e.a.a.w.a aVar = lVar.a().get(i2);
            PointF a2 = aVar.a();
            PointF b3 = aVar.b();
            PointF c2 = aVar.c();
            if (a2.equals(a) && b3.equals(c2)) {
                path.lineTo(c2.x, c2.y);
            } else {
                path.cubicTo(a2.x, a2.y, b3.x, b3.y, c2.x, c2.y);
            }
            a.set(c2.x, c2.y);
        }
        if (lVar.d()) {
            path.close();
        }
    }

    public static double j(double d2, double d3, double d4) {
        return d2 + (d4 * (d3 - d2));
    }

    public static float k(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int l(int i2, int i3, float f2) {
        return (int) (i2 + (f2 * (i3 - i2)));
    }

    public static void m(e.a.a.w.e eVar, int i2, List<e.a.a.w.e> list, e.a.a.w.e eVar2, k kVar) {
        if (eVar.c(kVar.getName(), i2)) {
            list.add(eVar2.a(kVar.getName()).i(kVar));
        }
    }
}