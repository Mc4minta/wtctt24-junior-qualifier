package e.a.a.y;

import android.graphics.Path;
import e.a.a.y.k0.c;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientFillParser.java */
/* loaded from: classes.dex */
public class m {
    private static final c.a a = c.a.a("nm", "g", "o", "t", "s", "e", "r", "hd");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f11945b = c.a.a("p", "k");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e.a.a.w.k.d a(e.a.a.y.k0.c cVar, e.a.a.e eVar) throws IOException {
        e.a.a.w.j.d dVar = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        e.a.a.w.k.f fVar = null;
        e.a.a.w.j.c cVar2 = null;
        e.a.a.w.j.f fVar2 = null;
        e.a.a.w.j.f fVar3 = null;
        boolean z = false;
        while (cVar.f()) {
            switch (cVar.K(a)) {
                case 0:
                    str = cVar.v();
                    break;
                case 1:
                    int i2 = -1;
                    cVar.c();
                    while (cVar.f()) {
                        int K = cVar.K(f11945b);
                        if (K == 0) {
                            i2 = cVar.m();
                        } else if (K != 1) {
                            cVar.N();
                            cVar.O();
                        } else {
                            cVar2 = d.g(cVar, eVar, i2);
                        }
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
                    fillType = cVar.m() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    z = cVar.g();
                    break;
                default:
                    cVar.N();
                    cVar.O();
                    break;
            }
        }
        return new e.a.a.w.k.d(str, fVar, fillType, cVar2, dVar == null ? new e.a.a.w.j.d(Collections.singletonList(new e.a.a.a0.a(100))) : dVar, fVar2, fVar3, null, null, z);
    }
}