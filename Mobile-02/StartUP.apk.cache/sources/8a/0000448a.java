package e.a.a.u.c;

import java.util.List;

/* compiled from: ColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public class b extends f<Integer> {
    public b(List<e.a.a.a0.a<Integer>> list) {
        super(list);
    }

    public int o() {
        return p(b(), d());
    }

    public int p(e.a.a.a0.a<Integer> aVar, float f2) {
        Integer num;
        Integer num2 = aVar.f11473b;
        if (num2 != null && aVar.f11474c != null) {
            int intValue = num2.intValue();
            int intValue2 = aVar.f11474c.intValue();
            e.a.a.a0.c<A> cVar = this.f11695e;
            if (cVar != 0 && (num = (Integer) cVar.b(aVar.f11476e, aVar.f11477f.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f2, e(), f())) != null) {
                return num.intValue();
            }
            return e.a.a.z.b.c(e.a.a.z.g.c(f2, 0.0f, 1.0f), intValue, intValue2);
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