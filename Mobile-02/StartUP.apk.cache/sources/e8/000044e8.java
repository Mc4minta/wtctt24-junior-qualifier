package e.a.a.y;

import android.graphics.Color;
import e.a.a.y.k0.c;
import java.io.IOException;

/* compiled from: ColorParser.java */
/* loaded from: classes.dex */
public class f implements j0<Integer> {
    public static final f a = new f();

    private f() {
    }

    @Override // e.a.a.y.j0
    /* renamed from: b */
    public Integer a(e.a.a.y.k0.c cVar, float f2) throws IOException {
        boolean z = cVar.A() == c.b.BEGIN_ARRAY;
        if (z) {
            cVar.b();
        }
        double j2 = cVar.j();
        double j3 = cVar.j();
        double j4 = cVar.j();
        double j5 = cVar.A() == c.b.NUMBER ? cVar.j() : 1.0d;
        if (z) {
            cVar.d();
        }
        if (j2 <= 1.0d && j3 <= 1.0d && j4 <= 1.0d) {
            j2 *= 255.0d;
            j3 *= 255.0d;
            j4 *= 255.0d;
            if (j5 <= 1.0d) {
                j5 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) j5, (int) j2, (int) j3, (int) j4));
    }
}