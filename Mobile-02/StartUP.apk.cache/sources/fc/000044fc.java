package e.a.a.y;

import e.a.a.w.k.p;
import e.a.a.y.k0.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientStrokeParser.java */
/* loaded from: classes.dex */
public class n {
    private static c.a a = c.a.a("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f11946b = c.a.a("p", "k");

    /* renamed from: c  reason: collision with root package name */
    private static final c.a f11947c = c.a.a("n", "v");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e.a.a.w.k.e a(e.a.a.y.k0.c cVar, e.a.a.e eVar) throws IOException {
        e.a.a.w.j.c cVar2;
        ArrayList arrayList = new ArrayList();
        float f2 = 0.0f;
        String str = null;
        e.a.a.w.k.f fVar = null;
        e.a.a.w.j.c cVar3 = null;
        e.a.a.w.j.f fVar2 = null;
        e.a.a.w.j.f fVar3 = null;
        e.a.a.w.j.b bVar = null;
        p.b bVar2 = null;
        p.c cVar4 = null;
        e.a.a.w.j.b bVar3 = null;
        boolean z = false;
        e.a.a.w.j.d dVar = null;
        while (cVar.f()) {
            switch (cVar.K(a)) {
                case 0:
                    str = cVar.v();
                    break;
                case 1:
                    int i2 = -1;
                    cVar.c();
                    while (cVar.f()) {
                        int K = cVar.K(f11946b);
                        if (K != 0) {
                            cVar2 = cVar3;
                            if (K != 1) {
                                cVar.N();
                                cVar.O();
                            } else {
                                cVar3 = d.g(cVar, eVar, i2);
                            }
                        } else {
                            cVar2 = cVar3;
                            i2 = cVar.m();
                        }
                        cVar3 = cVar2;
                    }
                    cVar.e();
                    break;
                case 2:
                    dVar = d.h(cVar, eVar);
                    break;
                case 3:
                    fVar = cVar.m() == 1 ? e.a.a.w.k.f.LINEAR : e.a.a.w.k.f.RADIAL;
                    break;
                case 4:
                    fVar2 = d.i(cVar, eVar);
                    break;
                case 5:
                    fVar3 = d.i(cVar, eVar);
                    break;
                case 6:
                    bVar = d.e(cVar, eVar);
                    break;
                case 7:
                    bVar2 = p.b.values()[cVar.m() - 1];
                    break;
                case 8:
                    cVar4 = p.c.values()[cVar.m() - 1];
                    break;
                case 9:
                    f2 = (float) cVar.j();
                    break;
                case 10:
                    z = cVar.g();
                    break;
                case 11:
                    cVar.b();
                    while (cVar.f()) {
                        cVar.c();
                        String str2 = null;
                        e.a.a.w.j.b bVar4 = null;
                        while (cVar.f()) {
                            int K2 = cVar.K(f11947c);
                            if (K2 != 0) {
                                e.a.a.w.j.b bVar5 = bVar3;
                                if (K2 != 1) {
                                    cVar.N();
                                    cVar.O();
                                } else {
                                    bVar4 = d.e(cVar, eVar);
                                }
                                bVar3 = bVar5;
                            } else {
                                str2 = cVar.v();
                            }
                        }
                        e.a.a.w.j.b bVar6 = bVar3;
                        cVar.e();
                        if (str2.equals("o")) {
                            bVar3 = bVar4;
                        } else {
                            if (str2.equals("d") || str2.equals("g")) {
                                eVar.t(true);
                                arrayList.add(bVar4);
                            }
                            bVar3 = bVar6;
                        }
                    }
                    e.a.a.w.j.b bVar7 = bVar3;
                    cVar.d();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    bVar3 = bVar7;
                    break;
                default:
                    cVar.N();
                    cVar.O();
                    break;
            }
        }
        if (dVar == null) {
            dVar = new e.a.a.w.j.d(Collections.singletonList(new e.a.a.a0.a(100)));
        }
        return new e.a.a.w.k.e(str, fVar, cVar3, dVar, fVar2, fVar3, bVar, bVar2, cVar4, f2, arrayList, bVar3, z);
    }
}