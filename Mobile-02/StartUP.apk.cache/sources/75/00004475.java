package e.a.a.u.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import e.a.a.u.c.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientFillContent.java */
/* loaded from: classes.dex */
public class h implements e, a.b, k {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11635b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a.a.w.l.a f11636c;

    /* renamed from: d  reason: collision with root package name */
    private final c.e.d<LinearGradient> f11637d = new c.e.d<>();

    /* renamed from: e  reason: collision with root package name */
    private final c.e.d<RadialGradient> f11638e = new c.e.d<>();

    /* renamed from: f  reason: collision with root package name */
    private final Path f11639f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f11640g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f11641h;

    /* renamed from: i  reason: collision with root package name */
    private final List<m> f11642i;

    /* renamed from: j  reason: collision with root package name */
    private final e.a.a.w.k.f f11643j;

    /* renamed from: k  reason: collision with root package name */
    private final e.a.a.u.c.a<e.a.a.w.k.c, e.a.a.w.k.c> f11644k;

    /* renamed from: l  reason: collision with root package name */
    private final e.a.a.u.c.a<Integer, Integer> f11645l;
    private final e.a.a.u.c.a<PointF, PointF> m;
    private final e.a.a.u.c.a<PointF, PointF> n;
    private e.a.a.u.c.a<ColorFilter, ColorFilter> o;
    private e.a.a.u.c.p p;
    private final e.a.a.g q;
    private final int r;

    public h(e.a.a.g gVar, e.a.a.w.l.a aVar, e.a.a.w.k.d dVar) {
        Path path = new Path();
        this.f11639f = path;
        this.f11640g = new e.a.a.u.a(1);
        this.f11641h = new RectF();
        this.f11642i = new ArrayList();
        this.f11636c = aVar;
        this.a = dVar.f();
        this.f11635b = dVar.i();
        this.q = gVar;
        this.f11643j = dVar.e();
        path.setFillType(dVar.c());
        this.r = (int) (gVar.n().d() / 32.0f);
        e.a.a.u.c.a<e.a.a.w.k.c, e.a.a.w.k.c> a = dVar.d().a();
        this.f11644k = a;
        a.a(this);
        aVar.i(a);
        e.a.a.u.c.a<Integer, Integer> a2 = dVar.g().a();
        this.f11645l = a2;
        a2.a(this);
        aVar.i(a2);
        e.a.a.u.c.a<PointF, PointF> a3 = dVar.h().a();
        this.m = a3;
        a3.a(this);
        aVar.i(a3);
        e.a.a.u.c.a<PointF, PointF> a4 = dVar.b().a();
        this.n = a4;
        a4.a(this);
        aVar.i(a4);
    }

    private int[] e(int[] iArr) {
        e.a.a.u.c.p pVar = this.p;
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

    private int h() {
        int round = Math.round(this.m.f() * this.r);
        int round2 = Math.round(this.n.f() * this.r);
        int round3 = Math.round(this.f11644k.f() * this.r);
        int i2 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    private LinearGradient i() {
        long h2 = h();
        LinearGradient h3 = this.f11637d.h(h2);
        if (h3 != null) {
            return h3;
        }
        PointF h4 = this.m.h();
        PointF h5 = this.n.h();
        e.a.a.w.k.c h6 = this.f11644k.h();
        LinearGradient linearGradient = new LinearGradient(h4.x, h4.y, h5.x, h5.y, e(h6.a()), h6.b(), Shader.TileMode.CLAMP);
        this.f11637d.n(h2, linearGradient);
        return linearGradient;
    }

    private RadialGradient j() {
        long h2 = h();
        RadialGradient h3 = this.f11638e.h(h2);
        if (h3 != null) {
            return h3;
        }
        PointF h4 = this.m.h();
        PointF h5 = this.n.h();
        e.a.a.w.k.c h6 = this.f11644k.h();
        int[] e2 = e(h6.a());
        float[] b2 = h6.b();
        float f2 = h4.x;
        float f3 = h4.y;
        float hypot = (float) Math.hypot(h5.x - f2, h5.y - f3);
        if (hypot <= 0.0f) {
            hypot = 0.001f;
        }
        RadialGradient radialGradient = new RadialGradient(f2, f3, hypot, e2, b2, Shader.TileMode.CLAMP);
        this.f11638e.n(h2, radialGradient);
        return radialGradient;
    }

    @Override // e.a.a.u.c.a.b
    public void a() {
        this.q.invalidateSelf();
    }

    @Override // e.a.a.u.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            c cVar = list2.get(i2);
            if (cVar instanceof m) {
                this.f11642i.add((m) cVar);
            }
        }
    }

    @Override // e.a.a.w.f
    public void c(e.a.a.w.e eVar, int i2, List<e.a.a.w.e> list, e.a.a.w.e eVar2) {
        e.a.a.z.g.m(eVar, i2, list, eVar2, this);
    }

    @Override // e.a.a.u.b.e
    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.f11639f.reset();
        for (int i2 = 0; i2 < this.f11642i.size(); i2++) {
            this.f11639f.addPath(this.f11642i.get(i2).getPath(), matrix);
        }
        this.f11639f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // e.a.a.u.b.e
    public void f(Canvas canvas, Matrix matrix, int i2) {
        Shader j2;
        if (this.f11635b) {
            return;
        }
        e.a.a.c.a("GradientFillContent#draw");
        this.f11639f.reset();
        for (int i3 = 0; i3 < this.f11642i.size(); i3++) {
            this.f11639f.addPath(this.f11642i.get(i3).getPath(), matrix);
        }
        this.f11639f.computeBounds(this.f11641h, false);
        if (this.f11643j == e.a.a.w.k.f.LINEAR) {
            j2 = i();
        } else {
            j2 = j();
        }
        j2.setLocalMatrix(matrix);
        this.f11640g.setShader(j2);
        e.a.a.u.c.a<ColorFilter, ColorFilter> aVar = this.o;
        if (aVar != null) {
            this.f11640g.setColorFilter(aVar.h());
        }
        this.f11640g.setAlpha(e.a.a.z.g.d((int) ((((i2 / 255.0f) * this.f11645l.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f11639f, this.f11640g);
        e.a.a.c.b("GradientFillContent#draw");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.a.a.w.f
    public <T> void g(T t, e.a.a.a0.c<T> cVar) {
        if (t == e.a.a.l.f11566d) {
            this.f11645l.m(cVar);
        } else if (t == e.a.a.l.C) {
            e.a.a.u.c.a<ColorFilter, ColorFilter> aVar = this.o;
            if (aVar != null) {
                this.f11636c.C(aVar);
            }
            if (cVar == null) {
                this.o = null;
                return;
            }
            e.a.a.u.c.p pVar = new e.a.a.u.c.p(cVar);
            this.o = pVar;
            pVar.a(this);
            this.f11636c.i(this.o);
        } else if (t == e.a.a.l.D) {
            e.a.a.u.c.p pVar2 = this.p;
            if (pVar2 != null) {
                this.f11636c.C(pVar2);
            }
            if (cVar == null) {
                this.p = null;
                return;
            }
            this.f11637d.c();
            this.f11638e.c();
            e.a.a.u.c.p pVar3 = new e.a.a.u.c.p(cVar);
            this.p = pVar3;
            pVar3.a(this);
            this.f11636c.i(this.p);
        }
    }

    @Override // e.a.a.u.b.c
    public String getName() {
        return this.a;
    }
}