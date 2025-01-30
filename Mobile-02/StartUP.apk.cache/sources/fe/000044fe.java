package e.a.a.y;

import android.graphics.Color;
import android.graphics.PointF;
import e.a.a.y.k0.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonUtils.java */
/* loaded from: classes.dex */
class p {
    private static final c.a a = c.a.a("x", "y");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JsonUtils.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.b.values().length];
            a = iArr;
            try {
                iArr[c.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.b.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static PointF a(e.a.a.y.k0.c cVar, float f2) throws IOException {
        cVar.b();
        float j2 = (float) cVar.j();
        float j3 = (float) cVar.j();
        while (cVar.A() != c.b.END_ARRAY) {
            cVar.O();
        }
        cVar.d();
        return new PointF(j2 * f2, j3 * f2);
    }

    private static PointF b(e.a.a.y.k0.c cVar, float f2) throws IOException {
        float j2 = (float) cVar.j();
        float j3 = (float) cVar.j();
        while (cVar.f()) {
            cVar.O();
        }
        return new PointF(j2 * f2, j3 * f2);
    }

    private static PointF c(e.a.a.y.k0.c cVar, float f2) throws IOException {
        cVar.c();
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (cVar.f()) {
            int K = cVar.K(a);
            if (K == 0) {
                f3 = g(cVar);
            } else if (K != 1) {
                cVar.N();
                cVar.O();
            } else {
                f4 = g(cVar);
            }
        }
        cVar.e();
        return new PointF(f3 * f2, f4 * f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(e.a.a.y.k0.c cVar) throws IOException {
        cVar.b();
        int j2 = (int) (cVar.j() * 255.0d);
        int j3 = (int) (cVar.j() * 255.0d);
        int j4 = (int) (cVar.j() * 255.0d);
        while (cVar.f()) {
            cVar.O();
        }
        cVar.d();
        return Color.argb(255, j2, j3, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PointF e(e.a.a.y.k0.c cVar, float f2) throws IOException {
        int i2 = a.a[cVar.A().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return c(cVar, f2);
                }
                throw new IllegalArgumentException("Unknown point starts with " + cVar.A());
            }
            return a(cVar, f2);
        }
        return b(cVar, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<PointF> f(e.a.a.y.k0.c cVar, float f2) throws IOException {
        ArrayList arrayList = new ArrayList();
        cVar.b();
        while (cVar.A() == c.b.BEGIN_ARRAY) {
            cVar.b();
            arrayList.add(e(cVar, f2));
            cVar.d();
        }
        cVar.d();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float g(e.a.a.y.k0.c cVar) throws IOException {
        c.b A = cVar.A();
        int i2 = a.a[A.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                cVar.b();
                float j2 = (float) cVar.j();
                while (cVar.f()) {
                    cVar.O();
                }
                cVar.d();
                return j2;
            }
            throw new IllegalArgumentException("Unknown value for token of type " + A);
        }
        return (float) cVar.j();
    }
}