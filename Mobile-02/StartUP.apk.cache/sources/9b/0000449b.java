package e.a.a.w;

import android.graphics.PointF;

/* compiled from: CubicCurveData.java */
/* loaded from: classes.dex */
public class a {
    private final PointF a;

    /* renamed from: b  reason: collision with root package name */
    private final PointF f11739b;

    /* renamed from: c  reason: collision with root package name */
    private final PointF f11740c;

    public a() {
        this.a = new PointF();
        this.f11739b = new PointF();
        this.f11740c = new PointF();
    }

    public PointF a() {
        return this.a;
    }

    public PointF b() {
        return this.f11739b;
    }

    public PointF c() {
        return this.f11740c;
    }

    public void d(float f2, float f3) {
        this.a.set(f2, f3);
    }

    public void e(float f2, float f3) {
        this.f11739b.set(f2, f3);
    }

    public void f(float f2, float f3) {
        this.f11740c.set(f2, f3);
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.a = pointF;
        this.f11739b = pointF2;
        this.f11740c = pointF3;
    }
}