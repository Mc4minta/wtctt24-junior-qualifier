package e.a.a.y;

import android.graphics.Path;
import com.appsflyer.share.Constants;
import e.a.a.y.k0.c;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeFillParser.java */
/* loaded from: classes.dex */
public class e0 {
    private static final c.a a = c.a.a("nm", Constants.URL_CAMPAIGN, "o", "fillEnabled", "r", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e.a.a.w.k.m a(e.a.a.y.k0.c cVar, e.a.a.e eVar) throws IOException {
        e.a.a.w.j.d dVar = null;
        boolean z = false;
        boolean z2 = false;
        int i2 = 1;
        String str = null;
        e.a.a.w.j.a aVar = null;
        while (cVar.f()) {
            int K = cVar.K(a);
            if (K == 0) {
                str = cVar.v();
            } else if (K == 1) {
                aVar = d.c(cVar, eVar);
            } else if (K == 2) {
                dVar = d.h(cVar, eVar);
            } else if (K == 3) {
                z = cVar.g();
            } else if (K == 4) {
                i2 = cVar.m();
            } else if (K != 5) {
                cVar.N();
                cVar.O();
            } else {
                z2 = cVar.g();
            }
        }
        return new e.a.a.w.k.m(str, z, i2 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar, dVar == null ? new e.a.a.w.j.d(Collections.singletonList(new e.a.a.a0.a(100))) : dVar, z2);
    }
}