package e.a.a.y;

import e.a.a.y.k0.c;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeGroupParser.java */
/* loaded from: classes.dex */
public class f0 {
    private static c.a a = c.a.a("nm", "hd", "it");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e.a.a.w.k.n a(e.a.a.y.k0.c cVar, e.a.a.e eVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z = false;
        while (cVar.f()) {
            int K = cVar.K(a);
            if (K == 0) {
                str = cVar.v();
            } else if (K == 1) {
                z = cVar.g();
            } else if (K != 2) {
                cVar.O();
            } else {
                cVar.b();
                while (cVar.f()) {
                    e.a.a.w.k.b a2 = g.a(cVar, eVar);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                cVar.d();
            }
        }
        return new e.a.a.w.k.n(str, arrayList, z);
    }
}