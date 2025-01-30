package e.f.b.a;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CacheKeyUtil.java */
/* loaded from: classes2.dex */
public final class e {
    public static String a(d dVar) {
        try {
            if (dVar instanceof f) {
                return c(((f) dVar).c().get(0));
            }
            return c(dVar);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static List<String> b(d dVar) {
        try {
            if (dVar instanceof f) {
                List<d> c2 = ((f) dVar).c();
                ArrayList arrayList = new ArrayList(c2.size());
                for (int i2 = 0; i2 < c2.size(); i2++) {
                    arrayList.add(c(c2.get(i2)));
                }
                return arrayList;
            }
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(c(dVar));
            return arrayList2;
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static String c(d dVar) throws UnsupportedEncodingException {
        return com.facebook.common.util.b.a(dVar.b().getBytes("UTF-8"));
    }
}