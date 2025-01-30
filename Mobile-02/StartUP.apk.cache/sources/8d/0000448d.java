package e.a.a.u.c;

import java.util.List;

/* compiled from: IntegerKeyframeAnimation.java */
/* loaded from: classes.dex */
public class e extends f<Integer> {
    public e(List<e.a.a.a0.a<Integer>> list) {
        super(list);
    }

    public int o() {
        return p(b(), d());
    }

    int p(e.a.a.a0.a<Integer> aVar, float f2) {
        Integer num;
        if (aVar.f11473b != null && aVar.f11474c != null) {
            e.a.a.a0.c<A> cVar = this.f11695e;
            if (cVar != 0 && (num = (Integer) cVar.b(aVar.f11476e, aVar.f11477f.floatValue(), aVar.f11473b, aVar.f11474c, f2, e(), f())) != null) {
                return num.intValue();
            }
            return e.a.a.z.g.l(aVar.g(), aVar.d(), f2);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.a.a.u.c.a
    /* renamed from: q */
    public Integer i(e.a.a.a0.a<Integer> aVar, float f2) {
        return Integer.valueOf(p(aVar, f2));
    }
}