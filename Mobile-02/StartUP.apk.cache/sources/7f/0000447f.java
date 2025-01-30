package e.a.a.u.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import e.a.a.u.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* compiled from: RepeaterContent.java */
/* loaded from: classes.dex */
public class p implements e, m, j, a.b, k {
    private final Matrix a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Path f11671b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final e.a.a.g f11672c;

    /* renamed from: d  reason: collision with root package name */
    private final e.a.a.w.l.a f11673d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11674e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f11675f;

    /* renamed from: g  reason: collision with root package name */
    private final e.a.a.u.c.a<Float, Float> f11676g;

    /* renamed from: h  reason: collision with root package name */
    private final e.a.a.u.c.a<Float, Float> f11677h;

    /* renamed from: i  reason: collision with root package name */
    private final e.a.a.u.c.o f11678i;

    /* renamed from: j  reason: collision with root package name */
    private d f11679j;

    public p(e.a.a.g gVar, e.a.a.w.l.a aVar, e.a.a.w.k.k kVar) {
        this.f11672c = gVar;
        this.f11673d = aVar;
        this.f11674e = kVar.c();
        this.f11675f = kVar.f();
        e.a.a.u.c.a<Float, Float> a = kVar.b().a();
        this.f11676g = a;
        aVar.i(a);
        a.a(this);
        e.a.a.u.c.a<Float, Float> a2 = kVar.d().a();
        this.f11677h = a2;
        aVar.i(a2);
        a2.a(this);
        e.a.a.u.c.o b2 = kVar.e().b();
        this.f11678i = b2;
        b2.a(aVar);
        b2.b(this);
    }

    @Override // e.a.a.u.c.a.b
    public void a() {
        this.f11672c.invalidateSelf();
    }

    @Override // e.a.a.u.b.c
    public void b(List<c> list, List<c> list2) {
        this.f11679j.b(list, list2);
    }

    @Override // e.a.a.w.f
    public void c(e.a.a.w.e eVar, int i2, List<e.a.a.w.e> list, e.a.a.w.e eVar2) {
        e.a.a.z.g.m(eVar, i2, list, eVar2, this);
    }

    @Override // e.a.a.u.b.e
    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.f11679j.d(rectF, matrix, z);
    }

    @Override // e.a.a.u.b.j
    public void e(ListIterator<c> listIterator) {
        if (this.f11679j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f11679j = new d(this.f11672c, this.f11673d, "Repeater", this.f11675f, arrayList, null);
    }

    @Override // e.a.a.u.b.e
    public void f(Canvas canvas, Matrix matrix, int i2) {
        float floatValue = this.f11676g.h().floatValue();
        float floatValue2 = this.f11677h.h().floatValue();
        float floatValue3 = this.f11678i.i().h().floatValue() / 100.0f;
        float floatValue4 = this.f11678i.e().h().floatValue() / 100.0f;
        for (int i3 = ((int) floatValue) - 1; i3 >= 0; i3--) {
            this.a.set(matrix);
            float f2 = i3;
            this.a.preConcat(this.f11678i.g(f2 + floatValue2));
            this.f11679j.f(canvas, this.a, (int) (i2 * e.a.a.z.g.k(floatValue3, floatValue4, f2 / floatValue)));
        }
    }

    @Override // e.a.a.w.f
    public <T> void g(T t, e.a.a.a0.c<T> cVar) {
        if (this.f11678i.c(t, cVar)) {
            return;
        }
        if (t == e.a.a.l.q) {
            this.f11676g.m(cVar);
        } else if (t == e.a.a.l.r) {
            this.f11677h.m(cVar);
        }
    }

    @Override // e.a.a.u.b.c
    public String getName() {
        return this.f11674e;
    }

    @Override // e.a.a.u.b.m
    public Path getPath() {
        Path path = this.f11679j.getPath();
        this.f11671b.reset();
        float floatValue = this.f11676g.h().floatValue();
        float floatValue2 = this.f11677h.h().floatValue();
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.a.set(this.f11678i.g(i2 + floatValue2));
            this.f11671b.addPath(path, this.a);
        }
        return this.f11671b;
    }
}