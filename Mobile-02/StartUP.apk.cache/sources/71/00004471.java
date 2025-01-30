package e.a.a.u.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import e.a.a.u.c.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ContentGroup.java */
/* loaded from: classes.dex */
public class d implements e, m, a.b, e.a.a.w.f {
    private Paint a;

    /* renamed from: b  reason: collision with root package name */
    private RectF f11609b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f11610c;

    /* renamed from: d  reason: collision with root package name */
    private final Path f11611d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f11612e;

    /* renamed from: f  reason: collision with root package name */
    private final String f11613f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f11614g;

    /* renamed from: h  reason: collision with root package name */
    private final List<c> f11615h;

    /* renamed from: i  reason: collision with root package name */
    private final e.a.a.g f11616i;

    /* renamed from: j  reason: collision with root package name */
    private List<m> f11617j;

    /* renamed from: k  reason: collision with root package name */
    private e.a.a.u.c.o f11618k;

    public d(e.a.a.g gVar, e.a.a.w.l.a aVar, e.a.a.w.k.n nVar) {
        this(gVar, aVar, nVar.c(), nVar.d(), e(gVar, aVar, nVar.b()), h(nVar.b()));
    }

    private static List<c> e(e.a.a.g gVar, e.a.a.w.l.a aVar, List<e.a.a.w.k.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            c a = list.get(i2).a(gVar, aVar);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    static e.a.a.w.j.l h(List<e.a.a.w.k.b> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            e.a.a.w.k.b bVar = list.get(i2);
            if (bVar instanceof e.a.a.w.j.l) {
                return (e.a.a.w.j.l) bVar;
            }
        }
        return null;
    }

    private boolean k() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f11615h.size(); i3++) {
            if ((this.f11615h.get(i3) instanceof e) && (i2 = i2 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // e.a.a.u.c.a.b
    public void a() {
        this.f11616i.invalidateSelf();
    }

    @Override // e.a.a.u.b.c
    public void b(List<c> list, List<c> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f11615h.size());
        arrayList.addAll(list);
        for (int size = this.f11615h.size() - 1; size >= 0; size--) {
            c cVar = this.f11615h.get(size);
            cVar.b(arrayList, this.f11615h.subList(0, size));
            arrayList.add(cVar);
        }
    }

    @Override // e.a.a.w.f
    public void c(e.a.a.w.e eVar, int i2, List<e.a.a.w.e> list, e.a.a.w.e eVar2) {
        if (eVar.g(getName(), i2)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.a(getName());
                if (eVar.c(getName(), i2)) {
                    list.add(eVar2.i(this));
                }
            }
            if (eVar.h(getName(), i2)) {
                int e2 = i2 + eVar.e(getName(), i2);
                for (int i3 = 0; i3 < this.f11615h.size(); i3++) {
                    c cVar = this.f11615h.get(i3);
                    if (cVar instanceof e.a.a.w.f) {
                        ((e.a.a.w.f) cVar).c(eVar, e2, list, eVar2);
                    }
                }
            }
        }
    }

    @Override // e.a.a.u.b.e
    public void d(RectF rectF, Matrix matrix, boolean z) {
        this.f11610c.set(matrix);
        e.a.a.u.c.o oVar = this.f11618k;
        if (oVar != null) {
            this.f11610c.preConcat(oVar.f());
        }
        this.f11612e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f11615h.size() - 1; size >= 0; size--) {
            c cVar = this.f11615h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).d(this.f11612e, this.f11610c, z);
                rectF.union(this.f11612e);
            }
        }
    }

    @Override // e.a.a.u.b.e
    public void f(Canvas canvas, Matrix matrix, int i2) {
        if (this.f11614g) {
            return;
        }
        this.f11610c.set(matrix);
        e.a.a.u.c.o oVar = this.f11618k;
        if (oVar != null) {
            this.f11610c.preConcat(oVar.f());
            i2 = (int) (((((this.f11618k.h() == null ? 100 : this.f11618k.h().h().intValue()) / 100.0f) * i2) / 255.0f) * 255.0f);
        }
        boolean z = this.f11616i.G() && k() && i2 != 255;
        if (z) {
            this.f11609b.set(0.0f, 0.0f, 0.0f, 0.0f);
            d(this.f11609b, this.f11610c, true);
            this.a.setAlpha(i2);
            e.a.a.z.h.m(canvas, this.f11609b, this.a);
        }
        if (z) {
            i2 = 255;
        }
        for (int size = this.f11615h.size() - 1; size >= 0; size--) {
            c cVar = this.f11615h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).f(canvas, this.f11610c, i2);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    @Override // e.a.a.w.f
    public <T> void g(T t, e.a.a.a0.c<T> cVar) {
        e.a.a.u.c.o oVar = this.f11618k;
        if (oVar != null) {
            oVar.c(t, cVar);
        }
    }

    @Override // e.a.a.u.b.c
    public String getName() {
        return this.f11613f;
    }

    @Override // e.a.a.u.b.m
    public Path getPath() {
        this.f11610c.reset();
        e.a.a.u.c.o oVar = this.f11618k;
        if (oVar != null) {
            this.f11610c.set(oVar.f());
        }
        this.f11611d.reset();
        if (this.f11614g) {
            return this.f11611d;
        }
        for (int size = this.f11615h.size() - 1; size >= 0; size--) {
            c cVar = this.f11615h.get(size);
            if (cVar instanceof m) {
                this.f11611d.addPath(((m) cVar).getPath(), this.f11610c);
            }
        }
        return this.f11611d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<m> i() {
        if (this.f11617j == null) {
            this.f11617j = new ArrayList();
            for (int i2 = 0; i2 < this.f11615h.size(); i2++) {
                c cVar = this.f11615h.get(i2);
                if (cVar instanceof m) {
                    this.f11617j.add((m) cVar);
                }
            }
        }
        return this.f11617j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix j() {
        e.a.a.u.c.o oVar = this.f11618k;
        if (oVar != null) {
            return oVar.f();
        }
        this.f11610c.reset();
        return this.f11610c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e.a.a.g gVar, e.a.a.w.l.a aVar, String str, boolean z, List<c> list, e.a.a.w.j.l lVar) {
        this.a = new e.a.a.u.a();
        this.f11609b = new RectF();
        this.f11610c = new Matrix();
        this.f11611d = new Path();
        this.f11612e = new RectF();
        this.f11613f = str;
        this.f11616i = gVar;
        this.f11614g = z;
        this.f11615h = list;
        if (lVar != null) {
            e.a.a.u.c.o b2 = lVar.b();
            this.f11618k = b2;
            b2.a(aVar);
            this.f11618k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).e(list.listIterator(list.size()));
        }
    }
}