package e.a.a.u.b;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;

/* compiled from: GradientStrokeContent.java */
/* loaded from: classes.dex */
public class i extends a {
    private final String o;
    private final boolean p;
    private final c.e.d<LinearGradient> q;
    private final c.e.d<RadialGradient> r;
    private final RectF s;
    private final e.a.a.w.k.f t;
    private final int u;
    private final e.a.a.u.c.a<e.a.a.w.k.c, e.a.a.w.k.c> v;
    private final e.a.a.u.c.a<PointF, PointF> w;
    private final e.a.a.u.c.a<PointF, PointF> x;
    private e.a.a.u.c.p y;

    public i(e.a.a.g gVar, e.a.a.w.l.a aVar, e.a.a.w.k.e eVar) {
        super(gVar, aVar, eVar.b().h(), eVar.g().h(), eVar.i(), eVar.k(), eVar.m(), eVar.h(), eVar.c());
        this.q = new c.e.d<>();
        this.r = new c.e.d<>();
        this.s = new RectF();
        this.o = eVar.j();
        this.t = eVar.f();
        this.p = eVar.n();
        this.u = (int) (gVar.n().d() / 32.0f);
        e.a.a.u.c.a<e.a.a.w.k.c, e.a.a.w.k.c> a = eVar.e().a();
        this.v = a;
        a.a(this);
        aVar.i(a);
        e.a.a.u.c.a<PointF, PointF> a2 = eVar.l().a();
        this.w = a2;
        a2.a(this);
        aVar.i(a2);
        e.a.a.u.c.a<PointF, PointF> a3 = eVar.d().a();
        this.x = a3;
        a3.a(this);
        aVar.i(a3);
    }

    private int[] i(int[] iArr) {
        e.a.a.u.c.p pVar = this.y;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.h();
            int i2 = 0;
            if (iArr.length == numArr.length) {
                while (i2 < iArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i2 < numArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            }
        }
        return iArr;
    }

    private int j() {
        int round = Math.round(this.w.f() * this.u);
        int round2 = Math.round(this.x.f() * this.u);
        int round3 = Math.round(this.v.f() * this.u);
        int i2 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    private LinearGradient k() {
        long j2 = j();
        LinearGradient h2 = this.q.h(j2);
        if (h2 != null) {
            return h2;
        }
        PointF h3 = this.w.h();
        PointF h4 = this.x.h();
        e.a.a.w.k.c h5 = this.v.h();
        LinearGradient linearGradient = new LinearGradient(h3.x, h3.y, h4.x, h4.y, i(h5.a()), h5.b(), Shader.TileMode.CLAMP);
        this.q.n(j2, linearGradient);
        return linearGradient;
    }

    private RadialGradient l() {
        float f2;
        float f3;
        long j2 = j();
        RadialGradient h2 = this.r.h(j2);
        if (h2 != null) {
            return h2;
        }
        PointF h3 = this.w.h();
        PointF h4 = this.x.h();
        e.a.a.w.k.c h5 = this.v.h();
        int[] i2 = i(h5.a());
        float[] b2 = h5.b();
        RadialGradient radialGradient = new RadialGradient(h3.x, h3.y, (float) Math.hypot(h4.x - f2, h4.y - f3), i2, b2, Shader.TileMode.CLAMP);
        this.r.n(j2, radialGradient);
        return radialGradient;
    }

    @Override // e.a.a.u.b.a, e.a.a.u.b.e
    public void f(Canvas canvas, Matrix matrix, int i2) {
        Shader l2;
        if (this.p) {
            return;
        }
        d(this.s, matrix, false);
        if (this.t == e.a.a.w.k.f.LINEAR) {
            l2 = k();
        } else {
            l2 = l();
        }
        l2.setLocalMatrix(matrix);
        this.f11604i.setShader(l2);
        super.f(canvas, matrix, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.a.a.u.b.a, e.a.a.w.f
    public <T> void g(T t, e.a.a.a0.c<T> cVar) {
        super.g(t, cVar);
        if (t == e.a.a.l.D) {
            e.a.a.u.c.p pVar = this.y;
            if (pVar != null) {
                this.f11601f.C(pVar);
            }
            if (cVar == null) {
                this.y = null;
                return;
            }
            e.a.a.u.c.p pVar2 = new e.a.a.u.c.p(cVar);
            this.y = pVar2;
            pVar2.a(this);
            this.f11601f.i(this.y);
        }
    }

    @Override // e.a.a.u.b.c
    public String getName() {
        return this.o;
    }
}