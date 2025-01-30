package e.a.a.u.c;

import android.graphics.Path;
import java.util.List;

/* compiled from: ShapeKeyframeAnimation.java */
/* loaded from: classes.dex */
public class l extends a<e.a.a.w.k.l, Path> {

    /* renamed from: i  reason: collision with root package name */
    private final e.a.a.w.k.l f11712i;

    /* renamed from: j  reason: collision with root package name */
    private final Path f11713j;

    public l(List<e.a.a.a0.a<e.a.a.w.k.l>> list) {
        super(list);
        this.f11712i = new e.a.a.w.k.l();
        this.f11713j = new Path();
    }

    @Override // e.a.a.u.c.a
    /* renamed from: o */
    public Path i(e.a.a.a0.a<e.a.a.w.k.l> aVar, float f2) {
        this.f11712i.c(aVar.f11473b, aVar.f11474c, f2);
        e.a.a.z.g.i(this.f11712i, this.f11713j);
        return this.f11713j;
    }
}