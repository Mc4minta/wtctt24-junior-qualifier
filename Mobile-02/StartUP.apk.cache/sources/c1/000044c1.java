package e.a.a.w.k;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapeData.java */
/* loaded from: classes.dex */
public class l {
    private final List<e.a.a.w.a> a;

    /* renamed from: b  reason: collision with root package name */
    private PointF f11842b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11843c;

    public l(PointF pointF, boolean z, List<e.a.a.w.a> list) {
        this.f11842b = pointF;
        this.f11843c = z;
        this.a = new ArrayList(list);
    }

    private void e(float f2, float f3) {
        if (this.f11842b == null) {
            this.f11842b = new PointF();
        }
        this.f11842b.set(f2, f3);
    }

    public List<e.a.a.w.a> a() {
        return this.a;
    }

    public PointF b() {
        return this.f11842b;
    }

    public void c(l lVar, l lVar2, float f2) {
        if (this.f11842b == null) {
            this.f11842b = new PointF();
        }
        this.f11843c = lVar.d() || lVar2.d();
        if (lVar.a().size() != lVar2.a().size()) {
            e.a.a.z.d.c("Curves must have the same number of control points. Shape 1: " + lVar.a().size() + "\tShape 2: " + lVar2.a().size());
        }
        int min = Math.min(lVar.a().size(), lVar2.a().size());
        if (this.a.size() < min) {
            for (int size = this.a.size(); size < min; size++) {
                this.a.add(new e.a.a.w.a());
            }
        } else if (this.a.size() > min) {
            for (int size2 = this.a.size() - 1; size2 >= min; size2--) {
                List<e.a.a.w.a> list = this.a;
                list.remove(list.size() - 1);
            }
        }
        PointF b2 = lVar.b();
        PointF b3 = lVar2.b();
        e(e.a.a.z.g.k(b2.x, b3.x, f2), e.a.a.z.g.k(b2.y, b3.y, f2));
        for (int size3 = this.a.size() - 1; size3 >= 0; size3--) {
            e.a.a.w.a aVar = lVar.a().get(size3);
            e.a.a.w.a aVar2 = lVar2.a().get(size3);
            PointF a = aVar.a();
            PointF b4 = aVar.b();
            PointF c2 = aVar.c();
            PointF a2 = aVar2.a();
            PointF b5 = aVar2.b();
            PointF c3 = aVar2.c();
            this.a.get(size3).d(e.a.a.z.g.k(a.x, a2.x, f2), e.a.a.z.g.k(a.y, a2.y, f2));
            this.a.get(size3).e(e.a.a.z.g.k(b4.x, b5.x, f2), e.a.a.z.g.k(b4.y, b5.y, f2));
            this.a.get(size3).f(e.a.a.z.g.k(c2.x, c3.x, f2), e.a.a.z.g.k(c2.y, c3.y, f2));
        }
    }

    public boolean d() {
        return this.f11843c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.f11843c + '}';
    }

    public l() {
        this.a = new ArrayList();
    }
}