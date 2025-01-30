package e.a.a.y;

import com.appsflyer.share.Constants;
import e.a.a.y.k0.c;
import java.io.IOException;

/* compiled from: RepeaterParser.java */
/* loaded from: classes.dex */
class b0 {
    private static c.a a = c.a.a("nm", Constants.URL_CAMPAIGN, "o", "tr", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e.a.a.w.k.k a(e.a.a.y.k0.c cVar, e.a.a.e eVar) throws IOException {
        boolean z = false;
        String str = null;
        e.a.a.w.j.b bVar = null;
        e.a.a.w.j.b bVar2 = null;
        e.a.a.w.j.l lVar = null;
        while (cVar.f()) {
            int K = cVar.K(a);
            if (K == 0) {
                str = cVar.v();
            } else if (K == 1) {
                bVar = d.f(cVar, eVar, false);
            } else if (K == 2) {
                bVar2 = d.f(cVar, eVar, false);
            } else if (K == 3) {
                lVar = c.g(cVar, eVar);
            } else if (K != 4) {
                cVar.O();
            } else {
                z = cVar.g();
            }
        }
        return new e.a.a.w.k.k(str, bVar, bVar2, lVar, z);
    }
}