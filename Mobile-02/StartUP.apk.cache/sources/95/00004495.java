package e.a.a.u.c;

import android.graphics.PointF;
import java.util.Collections;

/* compiled from: SplitDimensionPathKeyframeAnimation.java */
/* loaded from: classes.dex */
public class m extends a<PointF, PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f11714i;

    /* renamed from: j  reason: collision with root package name */
    private final a<Float, Float> f11715j;

    /* renamed from: k  reason: collision with root package name */
    private final a<Float, Float> f11716k;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f11714i = new PointF();
        this.f11715j = aVar;
        this.f11716k = aVar2;
        l(f());
    }

    @Override // e.a.a.u.c.a
    public void l(float f2) {
        this.f11715j.l(f2);
        this.f11716k.l(f2);
        this.f11714i.set(this.f11715j.h().floatValue(), this.f11716k.h().floatValue());
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).a();
        }
    }

    @Override // e.a.a.u.c.a
    /* renamed from: o */
    public PointF h() {
        return i(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.a.a.u.c.a
    /* renamed from: p */
    public PointF i(e.a.a.a0.a<PointF> aVar, float f2) {
        return this.f11714i;
    }
}