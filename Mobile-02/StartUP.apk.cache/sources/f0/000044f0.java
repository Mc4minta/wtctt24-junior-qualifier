package e.a.a.y;

import e.a.a.y.k0.c;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontCharacterParser.java */
/* loaded from: classes.dex */
public class j {
    private static final c.a a = c.a.a("ch", "size", "w", "style", "fFamily", "data");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f11923b = c.a.a("shapes");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e.a.a.w.d a(e.a.a.y.k0.c cVar, e.a.a.e eVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        cVar.c();
        String str = null;
        String str2 = null;
        double d2 = 0.0d;
        double d3 = 0.0d;
        char c2 = 0;
        while (cVar.f()) {
            int K = cVar.K(a);
            if (K == 0) {
                c2 = cVar.v().charAt(0);
            } else if (K == 1) {
                d2 = cVar.j();
            } else if (K == 2) {
                d3 = cVar.j();
            } else if (K == 3) {
                str = cVar.v();
            } else if (K == 4) {
                str2 = cVar.v();
            } else if (K != 5) {
                cVar.N();
                cVar.O();
            } else {
                cVar.c();
                while (cVar.f()) {
                    if (cVar.K(f11923b) != 0) {
                        cVar.N();
                        cVar.O();
                    } else {
                        cVar.b();
                        while (cVar.f()) {
                            arrayList.add((e.a.a.w.k.n) g.a(cVar, eVar));
                        }
                        cVar.d();
                    }
                }
                cVar.e();
            }
        }
        cVar.e();
        return new e.a.a.w.d(arrayList, c2, d2, d3, str, str2);
    }
}