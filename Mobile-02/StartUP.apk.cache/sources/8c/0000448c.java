package e.a.a.u.c;

import java.util.List;

/* compiled from: GradientColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public class d extends f<e.a.a.w.k.c> {

    /* renamed from: i  reason: collision with root package name */
    private final e.a.a.w.k.c f11703i;

    public d(List<e.a.a.a0.a<e.a.a.w.k.c>> list) {
        super(list);
        e.a.a.w.k.c cVar = list.get(0).f11473b;
        int c2 = cVar != null ? cVar.c() : 0;
        this.f11703i = new e.a.a.w.k.c(new float[c2], new int[c2]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.a.a.u.c.a
    /* renamed from: o */
    public e.a.a.w.k.c i(e.a.a.a0.a<e.a.a.w.k.c> aVar, float f2) {
        this.f11703i.d(aVar.f11473b, aVar.f11474c, f2);
        return this.f11703i;
    }
}