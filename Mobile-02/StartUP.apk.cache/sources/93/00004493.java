package e.a.a.u.c;

import java.util.List;

/* compiled from: ScaleKeyframeAnimation.java */
/* loaded from: classes.dex */
public class k extends f<e.a.a.a0.d> {

    /* renamed from: i  reason: collision with root package name */
    private final e.a.a.a0.d f11711i;

    public k(List<e.a.a.a0.a<e.a.a.a0.d>> list) {
        super(list);
        this.f11711i = new e.a.a.a0.d();
    }

    @Override // e.a.a.u.c.a
    /* renamed from: o */
    public e.a.a.a0.d i(e.a.a.a0.a<e.a.a.a0.d> aVar, float f2) {
        e.a.a.a0.d dVar;
        e.a.a.a0.d dVar2;
        e.a.a.a0.d dVar3 = aVar.f11473b;
        if (dVar3 != null && (dVar = aVar.f11474c) != null) {
            e.a.a.a0.d dVar4 = dVar3;
            e.a.a.a0.d dVar5 = dVar;
            e.a.a.a0.c<A> cVar = this.f11695e;
            if (cVar == 0 || (dVar2 = (e.a.a.a0.d) cVar.b(aVar.f11476e, aVar.f11477f.floatValue(), dVar4, dVar5, f2, e(), f())) == null) {
                this.f11711i.d(e.a.a.z.g.k(dVar4.b(), dVar5.b(), f2), e.a.a.z.g.k(dVar4.c(), dVar5.c(), f2));
                return this.f11711i;
            }
            return dVar2;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}