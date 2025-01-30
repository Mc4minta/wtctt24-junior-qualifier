package e.a.a.u.b;

import android.graphics.Path;
import android.graphics.PointF;
import e.a.a.u.c.a;
import e.a.a.w.k.q;
import java.util.List;

/* compiled from: EllipseContent.java */
/* loaded from: classes.dex */
public class f implements m, a.b, k {

    /* renamed from: b  reason: collision with root package name */
    private final String f11619b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a.a.g f11620c;

    /* renamed from: d  reason: collision with root package name */
    private final e.a.a.u.c.a<?, PointF> f11621d;

    /* renamed from: e  reason: collision with root package name */
    private final e.a.a.u.c.a<?, PointF> f11622e;

    /* renamed from: f  reason: collision with root package name */
    private final e.a.a.w.k.a f11623f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11625h;
    private final Path a = new Path();

    /* renamed from: g  reason: collision with root package name */
    private b f11624g = new b();

    public f(e.a.a.g gVar, e.a.a.w.l.a aVar, e.a.a.w.k.a aVar2) {
        this.f11619b = aVar2.b();
        this.f11620c = gVar;
        e.a.a.u.c.a<PointF, PointF> a = aVar2.d().a();
        this.f11621d = a;
        e.a.a.u.c.a<PointF, PointF> a2 = aVar2.c().a();
        this.f11622e = a2;
        this.f11623f = aVar2;
        aVar.i(a);
        aVar.i(a2);
        a.a(this);
        a2.a(this);
    }

    private void e() {
        this.f11625h = false;
        this.f11620c.invalidateSelf();
    }

    @Override // e.a.a.u.c.a.b
    public void a() {
        e();
    }

    @Override // e.a.a.u.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.i() == q.a.SIMULTANEOUSLY) {
                    this.f11624g.a(sVar);
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
        if (t == e.a.a.l.f11569g) {
            this.f11621d.m(cVar);
        } else if (t == e.a.a.l.f11572j) {
            this.f11622e.m(cVar);
        }
    }

    @Override // e.a.a.u.b.c
    public String getName() {
        return this.f11619b;
    }

    @Override // e.a.a.u.b.m
    public Path getPath() {
        if (this.f11625h) {
            return this.a;
        }
        this.a.reset();
        if (this.f11623f.e()) {
            this.f11625h = true;
            return this.a;
        }
        PointF h2 = this.f11621d.h();
        float f2 = h2.x / 2.0f;
        float f3 = h2.y / 2.0f;
        float f4 = f2 * 0.55228f;
        float f5 = 0.55228f * f3;
        this.a.reset();
        if (this.f11623f.f()) {
            float f6 = -f3;
            this.a.moveTo(0.0f, f6);
            float f7 = 0.0f - f4;
            float f8 = -f2;
            float f9 = 0.0f - f5;
            this.a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
            float f10 = f5 + 0.0f;
            this.a.cubicTo(f8, f10, f7, f3, 0.0f, f3);
            float f11 = f4 + 0.0f;
            this.a.cubicTo(f11, f3, f2, f10, f2, 0.0f);
            this.a.cubicTo(f2, f9, f11, f6, 0.0f, f6);
        } else {
            float f12 = -f3;
            this.a.moveTo(0.0f, f12);
            float f13 = f4 + 0.0f;
            float f14 = 0.0f - f5;
            this.a.cubicTo(f13, f12, f2, f14, f2, 0.0f);
            float f15 = f5 + 0.0f;
            this.a.cubicTo(f2, f15, f13, f3, 0.0f, f3);
            float f16 = 0.0f - f4;
            float f17 = -f2;
            this.a.cubicTo(f16, f3, f17, f15, f17, 0.0f);
            this.a.cubicTo(f17, f14, f16, f12, 0.0f, f12);
        }
        PointF h3 = this.f11622e.h();
        this.a.offset(h3.x, h3.y);
        this.a.close();
        this.f11624g.b(this.a);
        this.f11625h = true;
        return this.a;
    }
}