package e.a.a.u.c;

import android.graphics.PointF;
import java.util.List;

/* compiled from: PointKeyframeAnimation.java */
/* loaded from: classes.dex */
public class j extends f<PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f11710i;

    public j(List<e.a.a.a0.a<PointF>> list) {
        super(list);
        this.f11710i = new PointF();
    }

    @Override // e.a.a.u.c.a
    /* renamed from: o */
    public PointF i(e.a.a.a0.a<PointF> aVar, float f2) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = aVar.f11473b;
        if (pointF3 != null && (pointF = aVar.f11474c) != null) {
            PointF pointF4 = pointF3;
            PointF pointF5 = pointF;
            e.a.a.a0.c<A> cVar = this.f11695e;
            if (cVar == 0 || (pointF2 = (PointF) cVar.b(aVar.f11476e, aVar.f11477f.floatValue(), pointF4, pointF5, f2, e(), f())) == null) {
                PointF pointF6 = this.f11710i;
                float f3 = pointF4.x;
                float f4 = pointF4.y;
                pointF6.set(f3 + ((pointF5.x - f3) * f2), f4 + (f2 * (pointF5.y - f4)));
                return this.f11710i;
            }
            return pointF2;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}