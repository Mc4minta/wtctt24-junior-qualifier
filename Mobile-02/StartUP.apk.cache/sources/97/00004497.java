package e.a.a.u.c;

import android.graphics.Matrix;
import android.graphics.PointF;
import e.a.a.u.c.a;
import java.util.Collections;

/* compiled from: TransformKeyframeAnimation.java */
/* loaded from: classes.dex */
public class o {
    private final Matrix a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f11717b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f11718c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f11719d;

    /* renamed from: e  reason: collision with root package name */
    private final float[] f11720e;

    /* renamed from: f  reason: collision with root package name */
    private a<PointF, PointF> f11721f;

    /* renamed from: g  reason: collision with root package name */
    private a<?, PointF> f11722g;

    /* renamed from: h  reason: collision with root package name */
    private a<e.a.a.a0.d, e.a.a.a0.d> f11723h;

    /* renamed from: i  reason: collision with root package name */
    private a<Float, Float> f11724i;

    /* renamed from: j  reason: collision with root package name */
    private a<Integer, Integer> f11725j;

    /* renamed from: k  reason: collision with root package name */
    private c f11726k;

    /* renamed from: l  reason: collision with root package name */
    private c f11727l;
    private a<?, Float> m;
    private a<?, Float> n;

    public o(e.a.a.w.j.l lVar) {
        this.f11721f = lVar.c() == null ? null : lVar.c().a();
        this.f11722g = lVar.f() == null ? null : lVar.f().a();
        this.f11723h = lVar.h() == null ? null : lVar.h().a();
        this.f11724i = lVar.g() == null ? null : lVar.g().a();
        c cVar = lVar.i() == null ? null : (c) lVar.i().a();
        this.f11726k = cVar;
        if (cVar != null) {
            this.f11717b = new Matrix();
            this.f11718c = new Matrix();
            this.f11719d = new Matrix();
            this.f11720e = new float[9];
        } else {
            this.f11717b = null;
            this.f11718c = null;
            this.f11719d = null;
            this.f11720e = null;
        }
        this.f11727l = lVar.j() == null ? null : (c) lVar.j().a();
        if (lVar.e() != null) {
            this.f11725j = lVar.e().a();
        }
        if (lVar.k() != null) {
            this.m = lVar.k().a();
        } else {
            this.m = null;
        }
        if (lVar.d() != null) {
            this.n = lVar.d().a();
        } else {
            this.n = null;
        }
    }

    private void d() {
        for (int i2 = 0; i2 < 9; i2++) {
            this.f11720e[i2] = 0.0f;
        }
    }

    public void a(e.a.a.w.l.a aVar) {
        aVar.i(this.f11725j);
        aVar.i(this.m);
        aVar.i(this.n);
        aVar.i(this.f11721f);
        aVar.i(this.f11722g);
        aVar.i(this.f11723h);
        aVar.i(this.f11724i);
        aVar.i(this.f11726k);
        aVar.i(this.f11727l);
    }

    public void b(a.b bVar) {
        a<Integer, Integer> aVar = this.f11725j;
        if (aVar != null) {
            aVar.a(bVar);
        }
        a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.a(bVar);
        }
        a<?, Float> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.a(bVar);
        }
        a<PointF, PointF> aVar4 = this.f11721f;
        if (aVar4 != null) {
            aVar4.a(bVar);
        }
        a<?, PointF> aVar5 = this.f11722g;
        if (aVar5 != null) {
            aVar5.a(bVar);
        }
        a<e.a.a.a0.d, e.a.a.a0.d> aVar6 = this.f11723h;
        if (aVar6 != null) {
            aVar6.a(bVar);
        }
        a<Float, Float> aVar7 = this.f11724i;
        if (aVar7 != null) {
            aVar7.a(bVar);
        }
        c cVar = this.f11726k;
        if (cVar != null) {
            cVar.a(bVar);
        }
        c cVar2 = this.f11727l;
        if (cVar2 != null) {
            cVar2.a(bVar);
        }
    }

    public <T> boolean c(T t, e.a.a.a0.c<T> cVar) {
        c cVar2;
        c cVar3;
        a<?, Float> aVar;
        a<?, Float> aVar2;
        if (t == e.a.a.l.f11567e) {
            a<PointF, PointF> aVar3 = this.f11721f;
            if (aVar3 == null) {
                this.f11721f = new p(cVar, new PointF());
                return true;
            }
            aVar3.m(cVar);
            return true;
        } else if (t == e.a.a.l.f11568f) {
            a<?, PointF> aVar4 = this.f11722g;
            if (aVar4 == null) {
                this.f11722g = new p(cVar, new PointF());
                return true;
            }
            aVar4.m(cVar);
            return true;
        } else if (t == e.a.a.l.f11573k) {
            a<e.a.a.a0.d, e.a.a.a0.d> aVar5 = this.f11723h;
            if (aVar5 == null) {
                this.f11723h = new p(cVar, new e.a.a.a0.d());
                return true;
            }
            aVar5.m(cVar);
            return true;
        } else if (t == e.a.a.l.f11574l) {
            a<Float, Float> aVar6 = this.f11724i;
            if (aVar6 == null) {
                this.f11724i = new p(cVar, Float.valueOf(0.0f));
                return true;
            }
            aVar6.m(cVar);
            return true;
        } else if (t == e.a.a.l.f11565c) {
            a<Integer, Integer> aVar7 = this.f11725j;
            if (aVar7 == null) {
                this.f11725j = new p(cVar, 100);
                return true;
            }
            aVar7.m(cVar);
            return true;
        } else if (t == e.a.a.l.y && (aVar2 = this.m) != null) {
            if (aVar2 == null) {
                this.m = new p(cVar, 100);
                return true;
            }
            aVar2.m(cVar);
            return true;
        } else if (t == e.a.a.l.z && (aVar = this.n) != null) {
            if (aVar == null) {
                this.n = new p(cVar, 100);
                return true;
            }
            aVar.m(cVar);
            return true;
        } else if (t == e.a.a.l.m && (cVar3 = this.f11726k) != null) {
            if (cVar3 == null) {
                this.f11726k = new c(Collections.singletonList(new e.a.a.a0.a(Float.valueOf(0.0f))));
            }
            this.f11726k.m(cVar);
            return true;
        } else if (t != e.a.a.l.n || (cVar2 = this.f11727l) == null) {
            return false;
        } else {
            if (cVar2 == null) {
                this.f11727l = new c(Collections.singletonList(new e.a.a.a0.a(Float.valueOf(0.0f))));
            }
            this.f11727l.m(cVar);
            return true;
        }
    }

    public a<?, Float> e() {
        return this.n;
    }

    public Matrix f() {
        float o;
        this.a.reset();
        a<?, PointF> aVar = this.f11722g;
        if (aVar != null) {
            PointF h2 = aVar.h();
            float f2 = h2.x;
            if (f2 != 0.0f || h2.y != 0.0f) {
                this.a.preTranslate(f2, h2.y);
            }
        }
        a<Float, Float> aVar2 = this.f11724i;
        if (aVar2 != null) {
            if (aVar2 instanceof p) {
                o = aVar2.h().floatValue();
            } else {
                o = ((c) aVar2).o();
            }
            if (o != 0.0f) {
                this.a.preRotate(o);
            }
        }
        if (this.f11726k != null) {
            c cVar = this.f11727l;
            float cos = cVar == null ? 0.0f : (float) Math.cos(Math.toRadians((-cVar.o()) + 90.0f));
            c cVar2 = this.f11727l;
            float sin = cVar2 == null ? 1.0f : (float) Math.sin(Math.toRadians((-cVar2.o()) + 90.0f));
            d();
            float[] fArr = this.f11720e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f3 = -sin;
            fArr[3] = f3;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f11717b.setValues(fArr);
            d();
            float[] fArr2 = this.f11720e;
            fArr2[0] = 1.0f;
            fArr2[3] = (float) Math.tan(Math.toRadians(this.f11726k.o()));
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f11718c.setValues(fArr2);
            d();
            float[] fArr3 = this.f11720e;
            fArr3[0] = cos;
            fArr3[1] = f3;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f11719d.setValues(fArr3);
            this.f11718c.preConcat(this.f11717b);
            this.f11719d.preConcat(this.f11718c);
            this.a.preConcat(this.f11719d);
        }
        a<e.a.a.a0.d, e.a.a.a0.d> aVar3 = this.f11723h;
        if (aVar3 != null) {
            e.a.a.a0.d h3 = aVar3.h();
            if (h3.b() != 1.0f || h3.c() != 1.0f) {
                this.a.preScale(h3.b(), h3.c());
            }
        }
        a<PointF, PointF> aVar4 = this.f11721f;
        if (aVar4 != null) {
            PointF h4 = aVar4.h();
            float f4 = h4.x;
            if (f4 != 0.0f || h4.y != 0.0f) {
                this.a.preTranslate(-f4, -h4.y);
            }
        }
        return this.a;
    }

    public Matrix g(float f2) {
        a<?, PointF> aVar = this.f11722g;
        PointF h2 = aVar == null ? null : aVar.h();
        a<e.a.a.a0.d, e.a.a.a0.d> aVar2 = this.f11723h;
        e.a.a.a0.d h3 = aVar2 == null ? null : aVar2.h();
        this.a.reset();
        if (h2 != null) {
            this.a.preTranslate(h2.x * f2, h2.y * f2);
        }
        if (h3 != null) {
            double d2 = f2;
            this.a.preScale((float) Math.pow(h3.b(), d2), (float) Math.pow(h3.c(), d2));
        }
        a<Float, Float> aVar3 = this.f11724i;
        if (aVar3 != null) {
            float floatValue = aVar3.h().floatValue();
            a<PointF, PointF> aVar4 = this.f11721f;
            PointF h4 = aVar4 != null ? aVar4.h() : null;
            this.a.preRotate(floatValue * f2, h4 == null ? 0.0f : h4.x, h4 != null ? h4.y : 0.0f);
        }
        return this.a;
    }

    public a<?, Integer> h() {
        return this.f11725j;
    }

    public a<?, Float> i() {
        return this.m;
    }

    public void j(float f2) {
        a<Integer, Integer> aVar = this.f11725j;
        if (aVar != null) {
            aVar.l(f2);
        }
        a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.l(f2);
        }
        a<?, Float> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.l(f2);
        }
        a<PointF, PointF> aVar4 = this.f11721f;
        if (aVar4 != null) {
            aVar4.l(f2);
        }
        a<?, PointF> aVar5 = this.f11722g;
        if (aVar5 != null) {
            aVar5.l(f2);
        }
        a<e.a.a.a0.d, e.a.a.a0.d> aVar6 = this.f11723h;
        if (aVar6 != null) {
            aVar6.l(f2);
        }
        a<Float, Float> aVar7 = this.f11724i;
        if (aVar7 != null) {
            aVar7.l(f2);
        }
        c cVar = this.f11726k;
        if (cVar != null) {
            cVar.l(f2);
        }
        c cVar2 = this.f11727l;
        if (cVar2 != null) {
            cVar2.l(f2);
        }
    }
}