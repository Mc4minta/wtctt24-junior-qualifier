package e.a.a.u.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import e.a.a.u.c.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FillContent.java */
/* loaded from: classes.dex */
public class g implements e, a.b, k {
    private final Path a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f11626b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a.a.w.l.a f11627c;

    /* renamed from: d  reason: collision with root package name */
    private final String f11628d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f11629e;

    /* renamed from: f  reason: collision with root package name */
    private final List<m> f11630f;

    /* renamed from: g  reason: collision with root package name */
    private final e.a.a.u.c.a<Integer, Integer> f11631g;

    /* renamed from: h  reason: collision with root package name */
    private final e.a.a.u.c.a<Integer, Integer> f11632h;

    /* renamed from: i  reason: collision with root package name */
    private e.a.a.u.c.a<ColorFilter, ColorFilter> f11633i;

    /* renamed from: j  reason: collision with root package name */
    private final e.a.a.g f11634j;

    public g(e.a.a.g gVar, e.a.a.w.l.a aVar, e.a.a.w.k.m mVar) {
        Path path = new Path();
        this.a = path;
        this.f11626b = new e.a.a.u.a(1);
        this.f11630f = new ArrayList();
        this.f11627c = aVar;
        this.f11628d = mVar.d();
        this.f11629e = mVar.f();
        this.f11634j = gVar;
        if (mVar.b() != null && mVar.e() != null) {
            path.setFillType(mVar.c());
            e.a.a.u.c.a<Integer, Integer> a = mVar.b().a();
            this.f11631g = a;
            a.a(this);
            aVar.i(a);
            e.a.a.u.c.a<Integer, Integer> a2 = mVar.e().a();
            this.f11632h = a2;
            a2.a(this);
            aVar.i(a2);
            return;
        }
        this.f11631g = null;
        this.f11632h = null;
    }

    @Override // e.a.a.u.c.a.b
    public void a() {
        this.f11634j.invalidateSelf();
    }

    @Override // e.a.a.u.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            c cVar = list2.get(i2);
            if (cVar instanceof m) {
                this.f11630f.add((m) cVar);
            }
        }
    }

    @Override // e.a.a.w.f
    public void c(e.a.a.w.e eVar, int i2, List<e.a.a.w.e> list, e.a.a.w.e eVar2) {
        e.a.a.z.g.m(eVar, i2, list, eVar2, this);
    }

    @Override // e.a.a.u.b.e
    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.a.reset();
        for (int i2 = 0; i2 < this.f11630f.size(); i2++) {
            this.a.addPath(this.f11630f.get(i2).getPath(), matrix);
        }
        this.a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // e.a.a.u.b.e
    public void f(Canvas canvas, Matrix matrix, int i2) {
        if (this.f11629e) {
            return;
        }
        e.a.a.c.a("FillContent#draw");
        this.f11626b.setColor(((e.a.a.u.c.b) this.f11631g).o());
        this.f11626b.setAlpha(e.a.a.z.g.d((int) ((((i2 / 255.0f) * this.f11632h.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        e.a.a.u.c.a<ColorFilter, ColorFilter> aVar = this.f11633i;
        if (aVar != null) {
            this.f11626b.setColorFilter(aVar.h());
        }
        this.a.reset();
        for (int i3 = 0; i3 < this.f11630f.size(); i3++) {
            this.a.addPath(this.f11630f.get(i3).getPath(), matrix);
        }
        canvas.drawPath(this.a, this.f11626b);
        e.a.a.c.b("FillContent#draw");
    }

    @Override // e.a.a.w.f
    public <T> void g(T t, e.a.a.a0.c<T> cVar) {
        if (t == e.a.a.l.a) {
            this.f11631g.m(cVar);
        } else if (t == e.a.a.l.f11566d) {
            this.f11632h.m(cVar);
        } else if (t == e.a.a.l.C) {
            e.a.a.u.c.a<ColorFilter, ColorFilter> aVar = this.f11633i;
            if (aVar != null) {
                this.f11627c.C(aVar);
            }
            if (cVar == null) {
                this.f11633i = null;
                return;
            }
            e.a.a.u.c.p pVar = new e.a.a.u.c.p(cVar);
            this.f11633i = pVar;
            pVar.a(this);
            this.f11627c.i(this.f11633i);
        }
    }

    @Override // e.a.a.u.b.c
    public String getName() {
        return this.f11628d;
    }
}