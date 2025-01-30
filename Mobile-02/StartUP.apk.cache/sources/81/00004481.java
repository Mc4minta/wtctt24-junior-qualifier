package e.a.a.u.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;

/* compiled from: StrokeContent.java */
/* loaded from: classes.dex */
public class r extends a {
    private final e.a.a.w.l.a o;
    private final String p;
    private final boolean q;
    private final e.a.a.u.c.a<Integer, Integer> r;
    private e.a.a.u.c.a<ColorFilter, ColorFilter> s;

    public r(e.a.a.g gVar, e.a.a.w.l.a aVar, e.a.a.w.k.p pVar) {
        super(gVar, aVar, pVar.b().h(), pVar.e().h(), pVar.g(), pVar.i(), pVar.j(), pVar.f(), pVar.d());
        this.o = aVar;
        this.p = pVar.h();
        this.q = pVar.k();
        e.a.a.u.c.a<Integer, Integer> a = pVar.c().a();
        this.r = a;
        a.a(this);
        aVar.i(a);
    }

    @Override // e.a.a.u.b.a, e.a.a.u.b.e
    public void f(Canvas canvas, Matrix matrix, int i2) {
        if (this.q) {
            return;
        }
        this.f11604i.setColor(((e.a.a.u.c.b) this.r).o());
        e.a.a.u.c.a<ColorFilter, ColorFilter> aVar = this.s;
        if (aVar != null) {
            this.f11604i.setColorFilter(aVar.h());
        }
        super.f(canvas, matrix, i2);
    }

    @Override // e.a.a.u.b.a, e.a.a.w.f
    public <T> void g(T t, e.a.a.a0.c<T> cVar) {
        super.g(t, cVar);
        if (t == e.a.a.l.f11564b) {
            this.r.m(cVar);
        } else if (t == e.a.a.l.C) {
            e.a.a.u.c.a<ColorFilter, ColorFilter> aVar = this.s;
            if (aVar != null) {
                this.o.C(aVar);
            }
            if (cVar == null) {
                this.s = null;
                return;
            }
            e.a.a.u.c.p pVar = new e.a.a.u.c.p(cVar);
            this.s = pVar;
            pVar.a(this);
            this.o.i(this.r);
        }
    }

    @Override // e.a.a.u.b.c
    public String getName() {
        return this.p;
    }
}