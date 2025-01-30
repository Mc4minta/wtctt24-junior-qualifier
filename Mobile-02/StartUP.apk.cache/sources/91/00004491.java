package e.a.a.u.c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* compiled from: PathKeyframeAnimation.java */
/* loaded from: classes.dex */
public class i extends f<PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f11706i;

    /* renamed from: j  reason: collision with root package name */
    private final float[] f11707j;

    /* renamed from: k  reason: collision with root package name */
    private h f11708k;

    /* renamed from: l  reason: collision with root package name */
    private PathMeasure f11709l;

    public i(List<? extends e.a.a.a0.a<PointF>> list) {
        super(list);
        this.f11706i = new PointF();
        this.f11707j = new float[2];
        this.f11709l = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.a.a.u.c.a
    /* renamed from: o */
    public PointF i(e.a.a.a0.a<PointF> aVar, float f2) {
        PointF pointF;
        h hVar = (h) aVar;
        Path j2 = hVar.j();
        if (j2 == null) {
            return aVar.f11473b;
        }
        e.a.a.a0.c<A> cVar = this.f11695e;
        if (cVar == 0 || (pointF = (PointF) cVar.b(hVar.f11476e, hVar.f11477f.floatValue(), hVar.f11473b, hVar.f11474c, e(), f2, f())) == null) {
            if (this.f11708k != hVar) {
                this.f11709l.setPath(j2, false);
                this.f11708k = hVar;
            }
            PathMeasure pathMeasure = this.f11709l;
            pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f11707j, null);
            PointF pointF2 = this.f11706i;
            float[] fArr = this.f11707j;
            pointF2.set(fArr[0], fArr[1]);
            return this.f11706i;
        }
        return pointF;
    }
}