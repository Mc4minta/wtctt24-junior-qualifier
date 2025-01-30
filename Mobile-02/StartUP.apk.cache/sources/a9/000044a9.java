package e.a.a.w.j;

import android.graphics.PointF;
import java.util.List;

/* compiled from: AnimatablePathValue.java */
/* loaded from: classes.dex */
public class e implements m<PointF, PointF> {
    private final List<e.a.a.a0.a<PointF>> a;

    public e(List<e.a.a.a0.a<PointF>> list) {
        this.a = list;
    }

    @Override // e.a.a.w.j.m
    public e.a.a.u.c.a<PointF, PointF> a() {
        if (this.a.get(0).h()) {
            return new e.a.a.u.c.j(this.a);
        }
        return new e.a.a.u.c.i(this.a);
    }

    @Override // e.a.a.w.j.m
    public List<e.a.a.a0.a<PointF>> b() {
        return this.a;
    }

    @Override // e.a.a.w.j.m
    public boolean isStatic() {
        return this.a.size() == 1 && this.a.get(0).h();
    }
}