package e.f.h.f;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import e.f.d.c.i;
import e.f.h.e.f;
import e.f.h.e.g;
import e.f.h.e.h;
import e.f.h.e.p;
import e.f.h.e.q;

/* compiled from: GenericDraweeHierarchy.java */
/* loaded from: classes2.dex */
public class a implements e.f.h.h.c {
    private final Drawable a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f12330b;

    /* renamed from: c  reason: collision with root package name */
    private d f12331c;

    /* renamed from: d  reason: collision with root package name */
    private final c f12332d;

    /* renamed from: e  reason: collision with root package name */
    private final f f12333e;

    /* renamed from: f  reason: collision with root package name */
    private final g f12334f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        int i2 = 0;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        this.a = colorDrawable;
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("GenericDraweeHierarchy()");
        }
        this.f12330b = bVar.o();
        this.f12331c = bVar.r();
        g gVar = new g(colorDrawable);
        this.f12334f = gVar;
        int i3 = 1;
        int size = (bVar.i() != null ? bVar.i().size() : 1) + (bVar.l() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[size + 6];
        drawableArr[0] = h(bVar.e(), null);
        drawableArr[1] = h(bVar.j(), bVar.k());
        drawableArr[2] = g(gVar, bVar.d(), bVar.c(), bVar.b());
        drawableArr[3] = h(bVar.m(), bVar.n());
        drawableArr[4] = h(bVar.p(), bVar.q());
        drawableArr[5] = h(bVar.g(), bVar.h());
        if (size > 0) {
            if (bVar.i() != null) {
                for (Drawable drawable : bVar.i()) {
                    drawableArr[i2 + 6] = h(drawable, null);
                    i2++;
                }
                i3 = i2;
            }
            if (bVar.l() != null) {
                drawableArr[i3 + 6] = h(bVar.l(), null);
            }
        }
        f fVar = new f(drawableArr);
        this.f12333e = fVar;
        fVar.r(bVar.f());
        c cVar = new c(e.e(fVar, this.f12331c));
        this.f12332d = cVar;
        cVar.mutate();
        p();
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
    }

    private Drawable g(Drawable drawable, q.b bVar, PointF pointF, ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return e.g(drawable, bVar, pointF);
    }

    private Drawable h(Drawable drawable, q.b bVar) {
        return e.f(e.d(drawable, this.f12331c, this.f12330b), bVar);
    }

    private void i(int i2) {
        if (i2 >= 0) {
            this.f12333e.m(i2);
        }
    }

    private void j() {
        k(1);
        k(2);
        k(3);
        k(4);
        k(5);
    }

    private void k(int i2) {
        if (i2 >= 0) {
            this.f12333e.n(i2);
        }
    }

    private e.f.h.e.c l(int i2) {
        e.f.h.e.c e2 = this.f12333e.e(i2);
        if (e2.k() instanceof h) {
            e2 = (h) e2.k();
        }
        return e2.k() instanceof p ? (p) e2.k() : e2;
    }

    private p n(int i2) {
        e.f.h.e.c l2 = l(i2);
        if (l2 instanceof p) {
            return (p) l2;
        }
        return e.k(l2, q.b.a);
    }

    private void o() {
        this.f12334f.setDrawable(this.a);
    }

    private void p() {
        f fVar = this.f12333e;
        if (fVar != null) {
            fVar.i();
            this.f12333e.l();
            j();
            i(1);
            this.f12333e.o();
            this.f12333e.k();
        }
    }

    private void s(int i2, Drawable drawable) {
        if (drawable == null) {
            this.f12333e.h(i2, null);
            return;
        }
        l(i2).setDrawable(e.d(drawable, this.f12331c, this.f12330b));
    }

    private void v(float f2) {
        Drawable c2 = this.f12333e.c(3);
        if (c2 == null) {
            return;
        }
        if (f2 >= 0.999f) {
            if (c2 instanceof Animatable) {
                ((Animatable) c2).stop();
            }
            k(3);
        } else {
            if (c2 instanceof Animatable) {
                ((Animatable) c2).start();
            }
            i(3);
        }
        c2.setLevel(Math.round(f2 * 10000.0f));
    }

    @Override // e.f.h.h.c
    public void a(Drawable drawable) {
        this.f12332d.p(drawable);
    }

    @Override // e.f.h.h.c
    public void b(Throwable th) {
        this.f12333e.i();
        j();
        if (this.f12333e.c(4) != null) {
            i(4);
        } else {
            i(1);
        }
        this.f12333e.k();
    }

    @Override // e.f.h.h.c
    public void c(Throwable th) {
        this.f12333e.i();
        j();
        if (this.f12333e.c(5) != null) {
            i(5);
        } else {
            i(1);
        }
        this.f12333e.k();
    }

    @Override // e.f.h.h.c
    public void d(float f2, boolean z) {
        if (this.f12333e.c(3) == null) {
            return;
        }
        this.f12333e.i();
        v(f2);
        if (z) {
            this.f12333e.o();
        }
        this.f12333e.k();
    }

    @Override // e.f.h.h.b
    public Drawable e() {
        return this.f12332d;
    }

    @Override // e.f.h.h.c
    public void f(Drawable drawable, float f2, boolean z) {
        Drawable d2 = e.d(drawable, this.f12331c, this.f12330b);
        d2.mutate();
        this.f12334f.setDrawable(d2);
        this.f12333e.i();
        j();
        i(2);
        v(f2);
        if (z) {
            this.f12333e.o();
        }
        this.f12333e.k();
    }

    public d m() {
        return this.f12331c;
    }

    public void q(q.b bVar) {
        i.g(bVar);
        n(2).t(bVar);
    }

    public void r(Drawable drawable) {
        s(0, drawable);
    }

    @Override // e.f.h.h.c
    public void reset() {
        o();
        p();
    }

    public void t(int i2) {
        this.f12333e.r(i2);
    }

    public void u(Drawable drawable, q.b bVar) {
        s(1, drawable);
        n(1).t(bVar);
    }

    public void w(d dVar) {
        this.f12331c = dVar;
        e.j(this.f12332d, dVar);
        for (int i2 = 0; i2 < this.f12333e.f(); i2++) {
            e.i(l(i2), this.f12331c, this.f12330b);
        }
    }
}