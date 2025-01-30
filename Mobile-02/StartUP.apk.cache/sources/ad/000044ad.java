package e.a.a.w.j;

import android.graphics.PointF;
import java.util.List;

/* compiled from: AnimatableSplitDimensionPathValue.java */
/* loaded from: classes.dex */
public class i implements m<PointF, PointF> {
    private final b a;

    /* renamed from: b  reason: collision with root package name */
    private final b f11769b;

    public i(b bVar, b bVar2) {
        this.a = bVar;
        this.f11769b = bVar2;
    }

    @Override // e.a.a.w.j.m
    public e.a.a.u.c.a<PointF, PointF> a() {
        return new e.a.a.u.c.m(this.a.a(), this.f11769b.a());
    }

    @Override // e.a.a.w.j.m
    public List<e.a.a.a0.a<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // e.a.a.w.j.m
    public boolean isStatic() {
        return this.a.isStatic() && this.f11769b.isStatic();
    }
}