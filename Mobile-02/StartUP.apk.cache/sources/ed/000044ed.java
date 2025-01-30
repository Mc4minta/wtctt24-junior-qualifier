package e.a.a.y;

import com.appsflyer.share.Constants;
import e.a.a.w.k.p;
import e.a.a.y.k0.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeStrokeParser.java */
/* loaded from: classes.dex */
public class h0 {
    private static c.a a = c.a.a("nm", Constants.URL_CAMPAIGN, "w", "o", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f11922b = c.a.a("n", "v");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static e.a.a.w.k.p a(e.a.a.y.k0.c cVar, e.a.a.e eVar) throws IOException {
        char c2;
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        float f2 = 0.0f;
        String str = null;
        e.a.a.w.j.b bVar = null;
        e.a.a.w.j.a aVar = null;
        e.a.a.w.j.b bVar2 = null;
        p.b bVar3 = null;
        p.c cVar2 = null;
        e.a.a.w.j.d dVar = null;
        while (cVar.f()) {
            switch (cVar.K(a)) {
                case 0:
                    str = cVar.v();
                    break;
                case 1:
                    aVar = d.c(cVar, eVar);
                    break;
                case 2:
                    bVar2 = d.e(cVar, eVar);
                    break;
                case 3:
                    dVar = d.h(cVar, eVar);
                    break;
                case 4:
                    bVar3 = p.b.values()[cVar.m() - 1];
                    break;
                case 5:
                    cVar2 = p.c.values()[cVar.m() - 1];
                    break;
                case 6:
                    f2 = (float) cVar.j();
                    break;
                case 7:
                    z = cVar.g();
                    break;
                case 8:
                    cVar.b();
                    while (cVar.f()) {
                        cVar.c();
                        String str2 = null;
                        e.a.a.w.j.b bVar4 = null;
                        while (cVar.f()) {
                            int K = cVar.K(f11922b);
                            if (K == 0) {
                                str2 = cVar.v();
                            } else if (K != 1) {
                                cVar.N();
                                cVar.O();
                            } else {
                                bVar4 = d.e(cVar, eVar);
                            }
                        }
                        cVar.e();
                        str2.hashCode();
                        switch (str2.hashCode()) {
                            case 100:
                                if (str2.equals("d")) {
                                    c2 = 0;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 103:
                                if (str2.equals("g")) {
                                    c2 = 1;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 111:
                                if (str2.equals("o")) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                c2 = 65535;
                                break;
                        }
                        switch (c2) {
                            case 0:
                            case 1:
                                eVar.t(true);
                                arrayList.add(bVar4);
                                break;
                            case 2:
                                bVar = bVar4;
                                break;
                        }
                    }
                    cVar.d();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                    break;
                default:
                    cVar.O();
                    break;
            }
        }
        if (dVar == null) {
            dVar = new e.a.a.w.j.d(Collections.singletonList(new e.a.a.a0.a(100)));
        }
        return new e.a.a.w.k.p(str, bVar, arrayList, aVar, dVar, bVar2, bVar3, cVar2, f2, z);
    }
}