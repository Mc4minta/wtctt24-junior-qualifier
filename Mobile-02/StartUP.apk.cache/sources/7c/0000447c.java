package e.a.a.u.b;

import android.graphics.Path;
import android.graphics.PointF;
import e.a.a.u.c.a;
import e.a.a.w.k.i;
import e.a.a.w.k.q;
import java.util.List;

/* compiled from: PolystarContent.java */
/* loaded from: classes.dex */
public class n implements m, a.b, k {

    /* renamed from: b  reason: collision with root package name */
    private final String f11651b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a.a.g f11652c;

    /* renamed from: d  reason: collision with root package name */
    private final i.a f11653d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f11654e;

    /* renamed from: f  reason: collision with root package name */
    private final e.a.a.u.c.a<?, Float> f11655f;

    /* renamed from: g  reason: collision with root package name */
    private final e.a.a.u.c.a<?, PointF> f11656g;

    /* renamed from: h  reason: collision with root package name */
    private final e.a.a.u.c.a<?, Float> f11657h;

    /* renamed from: i  reason: collision with root package name */
    private final e.a.a.u.c.a<?, Float> f11658i;

    /* renamed from: j  reason: collision with root package name */
    private final e.a.a.u.c.a<?, Float> f11659j;

    /* renamed from: k  reason: collision with root package name */
    private final e.a.a.u.c.a<?, Float> f11660k;

    /* renamed from: l  reason: collision with root package name */
    private final e.a.a.u.c.a<?, Float> f11661l;
    private boolean n;
    private final Path a = new Path();
    private b m = new b();

    /* compiled from: PolystarContent.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.a.values().length];
            a = iArr;
            try {
                iArr[i.a.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i.a.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public n(e.a.a.g gVar, e.a.a.w.l.a aVar, e.a.a.w.k.i iVar) {
        this.f11652c = gVar;
        this.f11651b = iVar.d();
        i.a j2 = iVar.j();
        this.f11653d = j2;
        this.f11654e = iVar.k();
        e.a.a.u.c.a<Float, Float> a2 = iVar.g().a();
        this.f11655f = a2;
        e.a.a.u.c.a<PointF, PointF> a3 = iVar.h().a();
        this.f11656g = a3;
        e.a.a.u.c.a<Float, Float> a4 = iVar.i().a();
        this.f11657h = a4;
        e.a.a.u.c.a<Float, Float> a5 = iVar.e().a();
        this.f11659j = a5;
        e.a.a.u.c.a<Float, Float> a6 = iVar.f().a();
        this.f11661l = a6;
        i.a aVar2 = i.a.STAR;
        if (j2 == aVar2) {
            this.f11658i = iVar.b().a();
            this.f11660k = iVar.c().a();
        } else {
            this.f11658i = null;
            this.f11660k = null;
        }
        aVar.i(a2);
        aVar.i(a3);
        aVar.i(a4);
        aVar.i(a5);
        aVar.i(a6);
        if (j2 == aVar2) {
            aVar.i(this.f11658i);
            aVar.i(this.f11660k);
        }
        a2.a(this);
        a3.a(this);
        a4.a(this);
        a5.a(this);
        a6.a(this);
        if (j2 == aVar2) {
            this.f11658i.a(this);
            this.f11660k.a(this);
        }
    }

    private void e() {
        e.a.a.u.c.a<?, Float> aVar;
        double d2;
        double d3;
        double d4;
        int i2;
        int floor = (int) Math.floor(this.f11655f.h().floatValue());
        double radians = Math.toRadians((this.f11657h == null ? 0.0d : aVar.h().floatValue()) - 90.0d);
        double d5 = floor;
        float floatValue = this.f11661l.h().floatValue() / 100.0f;
        float floatValue2 = this.f11659j.h().floatValue();
        double d6 = floatValue2;
        float cos = (float) (Math.cos(radians) * d6);
        float sin = (float) (Math.sin(radians) * d6);
        this.a.moveTo(cos, sin);
        double d7 = (float) (6.283185307179586d / d5);
        double d8 = radians + d7;
        double ceil = Math.ceil(d5);
        int i3 = 0;
        while (i3 < ceil) {
            float cos2 = (float) (Math.cos(d8) * d6);
            double d9 = ceil;
            float sin2 = (float) (d6 * Math.sin(d8));
            if (floatValue != 0.0f) {
                d3 = d6;
                i2 = i3;
                d2 = d8;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                d4 = d7;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f2 = floatValue2 * floatValue * 0.25f;
                this.a.cubicTo(cos - (cos3 * f2), sin - (((float) Math.sin(atan2)) * f2), cos2 + (((float) Math.cos(atan22)) * f2), sin2 + (f2 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                d2 = d8;
                d3 = d6;
                d4 = d7;
                i2 = i3;
                this.a.lineTo(cos2, sin2);
            }
            d8 = d2 + d4;
            i3 = i2 + 1;
            sin = sin2;
            cos = cos2;
            ceil = d9;
            d6 = d3;
            d7 = d4;
        }
        PointF h2 = this.f11656g.h();
        this.a.offset(h2.x, h2.y);
        this.a.close();
    }

    private void h() {
        e.a.a.u.c.a<?, Float> aVar;
        double d2;
        int i2;
        double d3;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        double d4;
        float f8;
        float f9;
        float f10;
        float floatValue = this.f11655f.h().floatValue();
        double radians = Math.toRadians((this.f11657h == null ? 0.0d : aVar.h().floatValue()) - 90.0d);
        double d5 = floatValue;
        float f11 = (float) (6.283185307179586d / d5);
        float f12 = f11 / 2.0f;
        float f13 = floatValue - ((int) floatValue);
        int i3 = (f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            radians += (1.0f - f13) * f12;
        }
        float floatValue2 = this.f11659j.h().floatValue();
        float floatValue3 = this.f11658i.h().floatValue();
        e.a.a.u.c.a<?, Float> aVar2 = this.f11660k;
        float floatValue4 = aVar2 != null ? aVar2.h().floatValue() / 100.0f : 0.0f;
        e.a.a.u.c.a<?, Float> aVar3 = this.f11661l;
        float floatValue5 = aVar3 != null ? aVar3.h().floatValue() / 100.0f : 0.0f;
        if (i3 != 0) {
            f4 = ((floatValue2 - floatValue3) * f13) + floatValue3;
            i2 = i3;
            double d6 = f4;
            d2 = d5;
            f2 = (float) (d6 * Math.cos(radians));
            f3 = (float) (d6 * Math.sin(radians));
            this.a.moveTo(f2, f3);
            d3 = radians + ((f11 * f13) / 2.0f);
        } else {
            d2 = d5;
            i2 = i3;
            double d7 = floatValue2;
            float cos = (float) (Math.cos(radians) * d7);
            float sin = (float) (d7 * Math.sin(radians));
            this.a.moveTo(cos, sin);
            d3 = radians + f12;
            f2 = cos;
            f3 = sin;
            f4 = 0.0f;
        }
        double ceil = Math.ceil(d2) * 2.0d;
        int i4 = 0;
        boolean z = false;
        while (true) {
            double d8 = i4;
            if (d8 < ceil) {
                float f14 = z ? floatValue2 : floatValue3;
                int i5 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
                if (i5 == 0 || d8 != ceil - 2.0d) {
                    f5 = f11;
                    f6 = f12;
                } else {
                    f5 = f11;
                    f6 = (f11 * f13) / 2.0f;
                }
                if (i5 == 0 || d8 != ceil - 1.0d) {
                    f7 = f12;
                    d4 = d8;
                    f8 = f14;
                } else {
                    f7 = f12;
                    d4 = d8;
                    f8 = f4;
                }
                double d9 = f8;
                double d10 = ceil;
                float cos2 = (float) (d9 * Math.cos(d3));
                float sin2 = (float) (d9 * Math.sin(d3));
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.a.lineTo(cos2, sin2);
                    f9 = floatValue4;
                    f10 = f4;
                } else {
                    f9 = floatValue4;
                    f10 = f4;
                    double atan2 = (float) (Math.atan2(f3, f2) - 1.5707963267948966d);
                    float cos3 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    float f15 = z ? f9 : floatValue5;
                    float f16 = z ? floatValue5 : f9;
                    float f17 = (z ? floatValue3 : floatValue2) * f15 * 0.47829f;
                    float f18 = cos3 * f17;
                    float f19 = f17 * sin3;
                    float f20 = (z ? floatValue2 : floatValue3) * f16 * 0.47829f;
                    float f21 = cos4 * f20;
                    float f22 = f20 * sin4;
                    if (i2 != 0) {
                        if (i4 == 0) {
                            f18 *= f13;
                            f19 *= f13;
                        } else if (d4 == d10 - 1.0d) {
                            f21 *= f13;
                            f22 *= f13;
                        }
                    }
                    this.a.cubicTo(f2 - f18, f3 - f19, cos2 + f21, sin2 + f22, cos2, sin2);
                }
                d3 += f6;
                z = !z;
                i4++;
                f2 = cos2;
                f3 = sin2;
                floatValue4 = f9;
                f4 = f10;
                f12 = f7;
                f11 = f5;
                ceil = d10;
            } else {
                PointF h2 = this.f11656g.h();
                this.a.offset(h2.x, h2.y);
                this.a.close();
                return;
            }
        }
    }

    private void i() {
        this.n = false;
        this.f11652c.invalidateSelf();
    }

    @Override // e.a.a.u.c.a.b
    public void a() {
        i();
    }

    @Override // e.a.a.u.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.i() == q.a.SIMULTANEOUSLY) {
                    this.m.a(sVar);
                    sVar.c(this);
                }
            }
        }
    }

    @Override // e.a.a.w.f
    public void c(e.a.a.w.e eVar, int i2, List<e.a.a.w.e> list, e.a.a.w.e eVar2) {
        e.a.a.z.g.m(eVar, i2, list, eVar2, this);
    }

    @Override // e.a.a.w.f
    public <T> void g(T t, e.a.a.a0.c<T> cVar) {
        e.a.a.u.c.a<?, Float> aVar;
        e.a.a.u.c.a<?, Float> aVar2;
        if (t == e.a.a.l.s) {
            this.f11655f.m(cVar);
        } else if (t == e.a.a.l.t) {
            this.f11657h.m(cVar);
        } else if (t == e.a.a.l.f11572j) {
            this.f11656g.m(cVar);
        } else if (t == e.a.a.l.u && (aVar2 = this.f11658i) != null) {
            aVar2.m(cVar);
        } else if (t == e.a.a.l.v) {
            this.f11659j.m(cVar);
        } else if (t == e.a.a.l.w && (aVar = this.f11660k) != null) {
            aVar.m(cVar);
        } else if (t == e.a.a.l.x) {
            this.f11661l.m(cVar);
        }
    }

    @Override // e.a.a.u.b.c
    public String getName() {
        return this.f11651b;
    }

    @Override // e.a.a.u.b.m
    public Path getPath() {
        if (this.n) {
            return this.a;
        }
        this.a.reset();
        if (this.f11654e) {
            this.n = true;
            return this.a;
        }
        int i2 = a.a[this.f11653d.ordinal()];
        if (i2 == 1) {
            h();
        } else if (i2 == 2) {
            e();
        }
        this.a.close();
        this.m.b(this.a);
        this.n = true;
        return this.a;
    }
}