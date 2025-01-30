package e.a.a.u.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import e.a.a.u.c.a;
import e.a.a.w.k.q;
import java.util.List;

/* compiled from: RectangleContent.java */
/* loaded from: classes.dex */
public class o implements a.b, k, m {

    /* renamed from: c  reason: collision with root package name */
    private final String f11663c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f11664d;

    /* renamed from: e  reason: collision with root package name */
    private final e.a.a.g f11665e;

    /* renamed from: f  reason: collision with root package name */
    private final e.a.a.u.c.a<?, PointF> f11666f;

    /* renamed from: g  reason: collision with root package name */
    private final e.a.a.u.c.a<?, PointF> f11667g;

    /* renamed from: h  reason: collision with root package name */
    private final e.a.a.u.c.a<?, Float> f11668h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11670j;
    private final Path a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f11662b = new RectF();

    /* renamed from: i  reason: collision with root package name */
    private b f11669i = new b();

    public o(e.a.a.g gVar, e.a.a.w.l.a aVar, e.a.a.w.k.j jVar) {
        this.f11663c = jVar.c();
        this.f11664d = jVar.f();
        this.f11665e = gVar;
        e.a.a.u.c.a<PointF, PointF> a = jVar.d().a();
        this.f11666f = a;
        e.a.a.u.c.a<PointF, PointF> a2 = jVar.e().a();
        this.f11667g = a2;
        e.a.a.u.c.a<Float, Float> a3 = jVar.b().a();
        this.f11668h = a3;
        aVar.i(a);
        aVar.i(a2);
        aVar.i(a3);
        a.a(this);
        a2.a(this);
        a3.a(this);
    }

    private void e() {
        this.f11670j = false;
        this.f11665e.invalidateSelf();
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
                    this.f11669i.a(sVar);
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
        if (t == e.a.a.l.f11570h) {
            this.f11667g.m(cVar);
        } else if (t == e.a.a.l.f11572j) {
            this.f11666f.m(cVar);
        } else if (t == e.a.a.l.f11571i) {
            this.f11668h.m(cVar);
        }
    }

    @Override // e.a.a.u.b.c
    public String getName() {
        return this.f11663c;
    }

    @Override // e.a.a.u.b.m
    public Path getPath() {
        if (this.f11670j) {
            return this.a;
        }
        this.a.reset();
        if (this.f11664d) {
            this.f11670j = true;
            return this.a;
        }
        PointF h2 = this.f11667g.h();
        float f2 = h2.x / 2.0f;
        float f3 = h2.y / 2.0f;
        e.a.a.u.c.a<?, Float> aVar = this.f11668h;
        float o = aVar == null ? 0.0f : ((e.a.a.u.c.c) aVar).o();
        float min = Math.min(f2, f3);
        if (o > min) {
            o = min;
        }
        PointF h3 = this.f11666f.h();
        this.a.moveTo(h3.x + f2, (h3.y - f3) + o);
        this.a.lineTo(h3.x + f2, (h3.y + f3) - o);
        int i2 = (o > 0.0f ? 1 : (o == 0.0f ? 0 : -1));
        if (i2 > 0) {
            RectF rectF = this.f11662b;
            float f4 = h3.x;
            float f5 = o * 2.0f;
            float f6 = h3.y;
            rectF.set((f4 + f2) - f5, (f6 + f3) - f5, f4 + f2, f6 + f3);
            this.a.arcTo(this.f11662b, 0.0f, 90.0f, false);
        }
        this.a.lineTo((h3.x - f2) + o, h3.y + f3);
        if (i2 > 0) {
            RectF rectF2 = this.f11662b;
            float f7 = h3.x;
            float f8 = h3.y;
            float f9 = o * 2.0f;
            rectF2.set(f7 - f2, (f8 + f3) - f9, (f7 - f2) + f9, f8 + f3);
            this.a.arcTo(this.f11662b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(h3.x - f2, (h3.y - f3) + o);
        if (i2 > 0) {
            RectF rectF3 = this.f11662b;
            float f10 = h3.x;
            float f11 = h3.y;
            float f12 = o * 2.0f;
            rectF3.set(f10 - f2, f11 - f3, (f10 - f2) + f12, (f11 - f3) + f12);
            this.a.arcTo(this.f11662b, 180.0f, 90.0f, false);
        }
        this.a.lineTo((h3.x + f2) - o, h3.y - f3);
        if (i2 > 0) {
            RectF rectF4 = this.f11662b;
            float f13 = h3.x;
            float f14 = o * 2.0f;
            float f15 = h3.y;
            rectF4.set((f13 + f2) - f14, f15 - f3, f13 + f2, (f15 - f3) + f14);
            this.a.arcTo(this.f11662b, 270.0f, 90.0f, false);
        }
        this.a.close();
        this.f11669i.b(this.a);
        this.f11670j = true;
        return this.a;
    }
}