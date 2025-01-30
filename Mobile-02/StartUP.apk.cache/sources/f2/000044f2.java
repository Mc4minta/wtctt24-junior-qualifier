package e.a.a.y;

import e.a.a.y.k0.c;
import java.io.IOException;

/* compiled from: FontParser.java */
/* loaded from: classes.dex */
class k {
    private static final c.a a = c.a.a("fFamily", "fName", "fStyle", "ascent");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e.a.a.w.c a(e.a.a.y.k0.c cVar) throws IOException {
        cVar.c();
        String str = null;
        String str2 = null;
        float f2 = 0.0f;
        String str3 = null;
        while (cVar.f()) {
            int K = cVar.K(a);
            if (K == 0) {
                str = cVar.v();
            } else if (K == 1) {
                str3 = cVar.v();
            } else if (K == 2) {
                str2 = cVar.v();
            } else if (K != 3) {
                cVar.N();
                cVar.O();
            } else {
                f2 = (float) cVar.j();
            }
        }
        cVar.e();
        return new e.a.a.w.c(str, str3, str2, f2);
    }
}