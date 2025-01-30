package e.a.a.y;

import android.graphics.PointF;
import e.a.a.y.k0.c;
import java.io.IOException;

/* compiled from: PointFParser.java */
/* loaded from: classes.dex */
public class y implements j0<PointF> {
    public static final y a = new y();

    private y() {
    }

    @Override // e.a.a.y.j0
    /* renamed from: b */
    public PointF a(e.a.a.y.k0.c cVar, float f2) throws IOException {
        c.b A = cVar.A();
        if (A == c.b.BEGIN_ARRAY) {
            return p.e(cVar, f2);
        }
        if (A == c.b.BEGIN_OBJECT) {
            return p.e(cVar, f2);
        }
        if (A == c.b.NUMBER) {
            PointF pointF = new PointF(((float) cVar.j()) * f2, ((float) cVar.j()) * f2);
            while (cVar.f()) {
                cVar.O();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + A);
    }
}