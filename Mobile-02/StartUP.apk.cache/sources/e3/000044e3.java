package e.a.a.y;

import e.a.a.y.k0.c;
import java.io.IOException;

/* compiled from: ScaleXYParser.java */
/* loaded from: classes.dex */
public class c0 implements j0<e.a.a.a0.d> {
    public static final c0 a = new c0();

    private c0() {
    }

    @Override // e.a.a.y.j0
    /* renamed from: b */
    public e.a.a.a0.d a(e.a.a.y.k0.c cVar, float f2) throws IOException {
        boolean z = cVar.A() == c.b.BEGIN_ARRAY;
        if (z) {
            cVar.b();
        }
        float j2 = (float) cVar.j();
        float j3 = (float) cVar.j();
        while (cVar.f()) {
            cVar.O();
        }
        if (z) {
            cVar.d();
        }
        return new e.a.a.a0.d((j2 / 100.0f) * f2, (j3 / 100.0f) * f2);
    }
}