package e.a.a.u.c;

import android.graphics.Path;
import android.graphics.PointF;

/* compiled from: PathKeyframe.java */
/* loaded from: classes.dex */
public class h extends e.a.a.a0.a<PointF> {
    private Path o;
    private final e.a.a.a0.a<PointF> p;

    public h(e.a.a.e eVar, e.a.a.a0.a<PointF> aVar) {
        super(eVar, aVar.f11473b, aVar.f11474c, aVar.f11475d, aVar.f11476e, aVar.f11477f);
        this.p = aVar;
        i();
    }

    public void i() {
        T t;
        T t2 = this.f11474c;
        boolean z = (t2 == 0 || (t = this.f11473b) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
        T t3 = this.f11474c;
        if (t3 == 0 || z) {
            return;
        }
        e.a.a.a0.a<PointF> aVar = this.p;
        this.o = e.a.a.z.h.d((PointF) this.f11473b, (PointF) t3, aVar.m, aVar.n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path j() {
        return this.o;
    }
}