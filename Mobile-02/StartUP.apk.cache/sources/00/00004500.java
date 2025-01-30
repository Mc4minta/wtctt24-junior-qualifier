package e.a.a.y;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.coinbase.ApiConstants;
import e.a.a.y.k0.c;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: KeyframeParser.java */
/* loaded from: classes.dex */
class q {

    /* renamed from: b  reason: collision with root package name */
    private static c.e.h<WeakReference<Interpolator>> f11948b;
    private static final Interpolator a = new LinearInterpolator();

    /* renamed from: c  reason: collision with root package name */
    static c.a f11949c = c.a.a("t", "s", "e", "o", "i", "h", ApiConstants.TO, "ti");

    q() {
    }

    private static WeakReference<Interpolator> a(int i2) {
        WeakReference<Interpolator> f2;
        synchronized (q.class) {
            f2 = e().f(i2);
        }
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> e.a.a.a0.a<T> b(e.a.a.y.k0.c cVar, e.a.a.e eVar, float f2, j0<T> j0Var, boolean z) throws IOException {
        if (z) {
            return c(eVar, cVar, f2, j0Var);
        }
        return d(cVar, f2, j0Var);
    }

    private static <T> e.a.a.a0.a<T> c(e.a.a.e eVar, e.a.a.y.k0.c cVar, float f2, j0<T> j0Var) throws IOException {
        Interpolator interpolator;
        T t;
        Interpolator linearInterpolator;
        cVar.c();
        boolean z = false;
        float f3 = 0.0f;
        PointF pointF = null;
        PointF pointF2 = null;
        T t2 = null;
        T t3 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        while (cVar.f()) {
            switch (cVar.K(f11949c)) {
                case 0:
                    f3 = (float) cVar.j();
                    break;
                case 1:
                    t3 = j0Var.a(cVar, f2);
                    break;
                case 2:
                    t2 = j0Var.a(cVar, f2);
                    break;
                case 3:
                    pointF = p.e(cVar, f2);
                    break;
                case 4:
                    pointF2 = p.e(cVar, f2);
                    break;
                case 5:
                    if (cVar.m() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointF4 = p.e(cVar, f2);
                    break;
                case 7:
                    pointF3 = p.e(cVar, f2);
                    break;
                default:
                    cVar.O();
                    break;
            }
        }
        cVar.e();
        if (z) {
            interpolator = a;
            t = t3;
        } else {
            if (pointF != null && pointF2 != null) {
                float f4 = -f2;
                pointF.x = e.a.a.z.g.c(pointF.x, f4, f2);
                pointF.y = e.a.a.z.g.c(pointF.y, -100.0f, 100.0f);
                pointF2.x = e.a.a.z.g.c(pointF2.x, f4, f2);
                float c2 = e.a.a.z.g.c(pointF2.y, -100.0f, 100.0f);
                pointF2.y = c2;
                int i2 = e.a.a.z.h.i(pointF.x, pointF.y, pointF2.x, c2);
                WeakReference<Interpolator> a2 = a(i2);
                Interpolator interpolator2 = a2 != null ? a2.get() : null;
                if (a2 == null || interpolator2 == null) {
                    pointF.x /= f2;
                    pointF.y /= f2;
                    float f5 = pointF2.x / f2;
                    pointF2.x = f5;
                    float f6 = pointF2.y / f2;
                    pointF2.y = f6;
                    try {
                        linearInterpolator = c.h.k.f0.b.a(pointF.x, pointF.y, f5, f6);
                    } catch (IllegalArgumentException e2) {
                        if (e2.getMessage().equals("The Path cannot loop back on itself.")) {
                            linearInterpolator = c.h.k.f0.b.a(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                        } else {
                            linearInterpolator = new LinearInterpolator();
                        }
                    }
                    interpolator2 = linearInterpolator;
                    try {
                        f(i2, new WeakReference(interpolator2));
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
                interpolator = interpolator2;
            } else {
                interpolator = a;
            }
            t = t2;
        }
        e.a.a.a0.a<T> aVar = new e.a.a.a0.a<>(eVar, t3, t, interpolator, f3, null);
        aVar.m = pointF4;
        aVar.n = pointF3;
        return aVar;
    }

    private static <T> e.a.a.a0.a<T> d(e.a.a.y.k0.c cVar, float f2, j0<T> j0Var) throws IOException {
        return new e.a.a.a0.a<>(j0Var.a(cVar, f2));
    }

    private static c.e.h<WeakReference<Interpolator>> e() {
        if (f11948b == null) {
            f11948b = new c.e.h<>();
        }
        return f11948b;
    }

    private static void f(int i2, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            f11948b.l(i2, weakReference);
        }
    }
}