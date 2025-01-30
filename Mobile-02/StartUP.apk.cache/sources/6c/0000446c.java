package e.a.a.u.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import e.a.a.u.c.a;
import e.a.a.w.k.q;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseStrokeContent.java */
/* loaded from: classes.dex */
public abstract class a implements a.b, k, e {

    /* renamed from: e  reason: collision with root package name */
    private final e.a.a.g f11600e;

    /* renamed from: f  reason: collision with root package name */
    protected final e.a.a.w.l.a f11601f;

    /* renamed from: h  reason: collision with root package name */
    private final float[] f11603h;

    /* renamed from: i  reason: collision with root package name */
    final Paint f11604i;

    /* renamed from: j  reason: collision with root package name */
    private final e.a.a.u.c.a<?, Float> f11605j;

    /* renamed from: k  reason: collision with root package name */
    private final e.a.a.u.c.a<?, Integer> f11606k;

    /* renamed from: l  reason: collision with root package name */
    private final List<e.a.a.u.c.a<?, Float>> f11607l;
    private final e.a.a.u.c.a<?, Float> m;
    private e.a.a.u.c.a<ColorFilter, ColorFilter> n;
    private final PathMeasure a = new PathMeasure();

    /* renamed from: b  reason: collision with root package name */
    private final Path f11597b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f11598c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final RectF f11599d = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final List<b> f11602g = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseStrokeContent.java */
    /* loaded from: classes.dex */
    public static final class b {
        private final List<m> a;

        /* renamed from: b  reason: collision with root package name */
        private final s f11608b;

        private b(s sVar) {
            this.a = new ArrayList();
            this.f11608b = sVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(e.a.a.g gVar, e.a.a.w.l.a aVar, Paint.Cap cap, Paint.Join join, float f2, e.a.a.w.j.d dVar, e.a.a.w.j.b bVar, List<e.a.a.w.j.b> list, e.a.a.w.j.b bVar2) {
        e.a.a.u.a aVar2 = new e.a.a.u.a(1);
        this.f11604i = aVar2;
        this.f11600e = gVar;
        this.f11601f = aVar;
        aVar2.setStyle(Paint.Style.STROKE);
        aVar2.setStrokeCap(cap);
        aVar2.setStrokeJoin(join);
        aVar2.setStrokeMiter(f2);
        this.f11606k = dVar.a();
        this.f11605j = bVar.a();
        if (bVar2 == null) {
            this.m = null;
        } else {
            this.m = bVar2.a();
        }
        this.f11607l = new ArrayList(list.size());
        this.f11603h = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f11607l.add(list.get(i2).a());
        }
        aVar.i(this.f11606k);
        aVar.i(this.f11605j);
        for (int i3 = 0; i3 < this.f11607l.size(); i3++) {
            aVar.i(this.f11607l.get(i3));
        }
        e.a.a.u.c.a<?, Float> aVar3 = this.m;
        if (aVar3 != null) {
            aVar.i(aVar3);
        }
        this.f11606k.a(this);
        this.f11605j.a(this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f11607l.get(i4).a(this);
        }
        e.a.a.u.c.a<?, Float> aVar4 = this.m;
        if (aVar4 != null) {
            aVar4.a(this);
        }
    }

    private void e(Matrix matrix) {
        e.a.a.c.a("StrokeContent#applyDashPattern");
        if (this.f11607l.isEmpty()) {
            e.a.a.c.b("StrokeContent#applyDashPattern");
            return;
        }
        float g2 = e.a.a.z.h.g(matrix);
        for (int i2 = 0; i2 < this.f11607l.size(); i2++) {
            this.f11603h[i2] = this.f11607l.get(i2).h().floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.f11603h;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f11603h;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.f11603h;
            fArr3[i2] = fArr3[i2] * g2;
        }
        e.a.a.u.c.a<?, Float> aVar = this.m;
        this.f11604i.setPathEffect(new DashPathEffect(this.f11603h, aVar == null ? 0.0f : g2 * aVar.h().floatValue()));
        e.a.a.c.b("StrokeContent#applyDashPattern");
    }

    private void h(Canvas canvas, b bVar, Matrix matrix) {
        e.a.a.c.a("StrokeContent#applyTrimPath");
        if (bVar.f11608b == null) {
            e.a.a.c.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f11597b.reset();
        for (int size = bVar.a.size() - 1; size >= 0; size--) {
            this.f11597b.addPath(((m) bVar.a.get(size)).getPath(), matrix);
        }
        this.a.setPath(this.f11597b, false);
        float length = this.a.getLength();
        while (this.a.nextContour()) {
            length += this.a.getLength();
        }
        float floatValue = (bVar.f11608b.g().h().floatValue() * length) / 360.0f;
        float floatValue2 = ((bVar.f11608b.h().h().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((bVar.f11608b.e().h().floatValue() * length) / 100.0f) + floatValue;
        float f2 = 0.0f;
        for (int size2 = bVar.a.size() - 1; size2 >= 0; size2--) {
            this.f11598c.set(((m) bVar.a.get(size2)).getPath());
            this.f11598c.transform(matrix);
            this.a.setPath(this.f11598c, false);
            float length2 = this.a.getLength();
            if (floatValue3 > length) {
                float f3 = floatValue3 - length;
                if (f3 < f2 + length2 && f2 < f3) {
                    e.a.a.z.h.a(this.f11598c, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f3 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f11598c, this.f11604i);
                    f2 += length2;
                }
            }
            float f4 = f2 + length2;
            if (f4 >= floatValue2 && f2 <= floatValue3) {
                if (f4 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.f11598c, this.f11604i);
                } else {
                    e.a.a.z.h.a(this.f11598c, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 <= f4 ? (floatValue3 - f2) / length2 : 1.0f, 0.0f);
                    canvas.drawPath(this.f11598c, this.f11604i);
                }
            }
            f2 += length2;
        }
        e.a.a.c.b("StrokeContent#applyTrimPath");
    }

    @Override // e.a.a.u.c.a.b
    public void a() {
        this.f11600e.invalidateSelf();
    }

    @Override // e.a.a.u.b.c
    public void b(List<c> list, List<c> list2) {
        s sVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof s) {
                s sVar2 = (s) cVar;
                if (sVar2.i() == q.a.INDIVIDUALLY) {
                    sVar = sVar2;
                }
            }
        }
        if (sVar != null) {
            sVar.c(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = list2.get(size2);
            if (cVar2 instanceof s) {
                s sVar3 = (s) cVar2;
                if (sVar3.i() == q.a.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f11602g.add(bVar);
                    }
                    bVar = new b(sVar3);
                    sVar3.c(this);
                }
            }
            if (cVar2 instanceof m) {
                if (bVar == null) {
                    bVar = new b(sVar);
                }
                bVar.a.add((m) cVar2);
            }
        }
        if (bVar != null) {
            this.f11602g.add(bVar);
        }
    }

    @Override // e.a.a.w.f
    public void c(e.a.a.w.e eVar, int i2, List<e.a.a.w.e> list, e.a.a.w.e eVar2) {
        e.a.a.z.g.m(eVar, i2, list, eVar2, this);
    }

    @Override // e.a.a.u.b.e
    public void d(RectF rectF, Matrix matrix, boolean z) {
        e.a.a.c.a("StrokeContent#getBounds");
        this.f11597b.reset();
        for (int i2 = 0; i2 < this.f11602g.size(); i2++) {
            b bVar = this.f11602g.get(i2);
            for (int i3 = 0; i3 < bVar.a.size(); i3++) {
                this.f11597b.addPath(((m) bVar.a.get(i3)).getPath(), matrix);
            }
        }
        this.f11597b.computeBounds(this.f11599d, false);
        float o = ((e.a.a.u.c.c) this.f11605j).o();
        RectF rectF2 = this.f11599d;
        float f2 = o / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.f11599d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        e.a.a.c.b("StrokeContent#getBounds");
    }

    @Override // e.a.a.u.b.e
    public void f(Canvas canvas, Matrix matrix, int i2) {
        e.a.a.c.a("StrokeContent#draw");
        if (e.a.a.z.h.h(matrix)) {
            e.a.a.c.b("StrokeContent#draw");
            return;
        }
        this.f11604i.setAlpha(e.a.a.z.g.d((int) ((((i2 / 255.0f) * ((e.a.a.u.c.e) this.f11606k).o()) / 100.0f) * 255.0f), 0, 255));
        this.f11604i.setStrokeWidth(((e.a.a.u.c.c) this.f11605j).o() * e.a.a.z.h.g(matrix));
        if (this.f11604i.getStrokeWidth() <= 0.0f) {
            e.a.a.c.b("StrokeContent#draw");
            return;
        }
        e(matrix);
        e.a.a.u.c.a<ColorFilter, ColorFilter> aVar = this.n;
        if (aVar != null) {
            this.f11604i.setColorFilter(aVar.h());
        }
        for (int i3 = 0; i3 < this.f11602g.size(); i3++) {
            b bVar = this.f11602g.get(i3);
            if (bVar.f11608b != null) {
                h(canvas, bVar, matrix);
            } else {
                e.a.a.c.a("StrokeContent#buildPath");
                this.f11597b.reset();
                for (int size = bVar.a.size() - 1; size >= 0; size--) {
                    this.f11597b.addPath(((m) bVar.a.get(size)).getPath(), matrix);
                }
                e.a.a.c.b("StrokeContent#buildPath");
                e.a.a.c.a("StrokeContent#drawPath");
                canvas.drawPath(this.f11597b, this.f11604i);
                e.a.a.c.b("StrokeContent#drawPath");
            }
        }
        e.a.a.c.b("StrokeContent#draw");
    }

    @Override // e.a.a.w.f
    public <T> void g(T t, e.a.a.a0.c<T> cVar) {
        if (t == e.a.a.l.f11566d) {
            this.f11606k.m(cVar);
        } else if (t == e.a.a.l.o) {
            this.f11605j.m(cVar);
        } else if (t == e.a.a.l.C) {
            e.a.a.u.c.a<ColorFilter, ColorFilter> aVar = this.n;
            if (aVar != null) {
                this.f11601f.C(aVar);
            }
            if (cVar == null) {
                this.n = null;
                return;
            }
            e.a.a.u.c.p pVar = new e.a.a.u.c.p(cVar);
            this.n = pVar;
            pVar.a(this);
            this.f11601f.i(this.n);
        }
    }
}