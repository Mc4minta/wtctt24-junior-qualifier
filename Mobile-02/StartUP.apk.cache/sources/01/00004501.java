package e.a.a.y;

import e.a.a.y.k0.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: KeyframesParser.java */
/* loaded from: classes.dex */
class r {
    static c.a a = c.a.a("k");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<e.a.a.a0.a<T>> a(e.a.a.y.k0.c cVar, e.a.a.e eVar, float f2, j0<T> j0Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (cVar.A() == c.b.STRING) {
            eVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        cVar.c();
        while (cVar.f()) {
            if (cVar.K(a) != 0) {
                cVar.O();
            } else if (cVar.A() == c.b.BEGIN_ARRAY) {
                cVar.b();
                if (cVar.A() == c.b.NUMBER) {
                    arrayList.add(q.b(cVar, eVar, f2, j0Var, false));
                } else {
                    while (cVar.f()) {
                        arrayList.add(q.b(cVar, eVar, f2, j0Var, true));
                    }
                }
                cVar.d();
            } else {
                arrayList.add(q.b(cVar, eVar, f2, j0Var, false));
            }
        }
        cVar.e();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends e.a.a.a0.a<T>> list) {
        int i2;
        T t;
        int size = list.size();
        int i3 = 0;
        while (true) {
            i2 = size - 1;
            if (i3 >= i2) {
                break;
            }
            e.a.a.a0.a<T> aVar = list.get(i3);
            i3++;
            e.a.a.a0.a<T> aVar2 = list.get(i3);
            aVar.f11477f = Float.valueOf(aVar2.f11476e);
            if (aVar.f11474c == null && (t = aVar2.f11473b) != null) {
                aVar.f11474c = t;
                if (aVar instanceof e.a.a.u.c.h) {
                    ((e.a.a.u.c.h) aVar).i();
                }
            }
        }
        e.a.a.a0.a<T> aVar3 = list.get(i2);
        if ((aVar3.f11473b == null || aVar3.f11474c == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}