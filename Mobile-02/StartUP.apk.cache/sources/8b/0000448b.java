package e.a.a.u.c;

import java.util.List;

/* compiled from: FloatKeyframeAnimation.java */
/* loaded from: classes.dex */
public class c extends f<Float> {
    public c(List<e.a.a.a0.a<Float>> list) {
        super(list);
    }

    public float o() {
        return p(b(), d());
    }

    float p(e.a.a.a0.a<Float> aVar, float f2) {
        Float f3;
        if (aVar.f11473b != null && aVar.f11474c != null) {
            e.a.a.a0.c<A> cVar = this.f11695e;
            if (cVar != 0 && (f3 = (Float) cVar.b(aVar.f11476e, aVar.f11477f.floatValue(), aVar.f11473b, aVar.f11474c, f2, e(), f())) != null) {
                return f3.floatValue();
            }
            return e.a.a.z.g.k(aVar.f(), aVar.c(), f2);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.a.a.u.c.a
    /* renamed from: q */
    public Float i(e.a.a.a0.a<Float> aVar, float f2) {
        return Float.valueOf(p(aVar, f2));
    }
}