package e.a.a.y;

import android.graphics.Rect;
import e.a.a.w.l.d;
import e.a.a.y.k0.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LottieCompositionMoshiParser.java */
/* loaded from: classes.dex */
public class t {
    private static final c.a a = c.a.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b  reason: collision with root package name */
    static c.a f11952b = c.a.a("id", "layers", "w", "h", "p", "u");

    /* renamed from: c  reason: collision with root package name */
    private static final c.a f11953c = c.a.a("list");

    /* renamed from: d  reason: collision with root package name */
    private static final c.a f11954d = c.a.a("cm", "tm", "dr");

    public static e.a.a.e a(e.a.a.y.k0.c cVar) throws IOException {
        HashMap hashMap;
        ArrayList arrayList;
        e.a.a.y.k0.c cVar2 = cVar;
        float e2 = e.a.a.z.h.e();
        c.e.d<e.a.a.w.l.d> dVar = new c.e.d<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        c.e.h<e.a.a.w.d> hVar = new c.e.h<>();
        e.a.a.e eVar = new e.a.a.e();
        cVar.c();
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        while (cVar.f()) {
            switch (cVar2.K(a)) {
                case 0:
                    i2 = cVar.m();
                    continue;
                    cVar2 = cVar;
                case 1:
                    i3 = cVar.m();
                    continue;
                    cVar2 = cVar;
                case 2:
                    f2 = (float) cVar.j();
                    continue;
                    cVar2 = cVar;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f3 = ((float) cVar.j()) - 0.01f;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f4 = (float) cVar.j();
                    break;
                case 5:
                    String[] split = cVar.v().split("\\.");
                    if (!e.a.a.z.h.j(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        eVar.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 6:
                    e(cVar2, eVar, arrayList2, dVar);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 7:
                    b(cVar2, eVar, hashMap2, hashMap3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 8:
                    d(cVar2, hashMap4);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 9:
                    c(cVar2, eVar, hVar);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 10:
                    f(cVar2, eVar, arrayList3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                default:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    cVar.N();
                    cVar.O();
                    break;
            }
            hashMap4 = hashMap;
            arrayList3 = arrayList;
            cVar2 = cVar;
        }
        eVar.r(new Rect(0, 0, (int) (i2 * e2), (int) (i3 * e2)), f2, f3, f4, arrayList2, dVar, hashMap2, hashMap3, hVar, hashMap4, arrayList3);
        return eVar;
    }

    private static void b(e.a.a.y.k0.c cVar, e.a.a.e eVar, Map<String, List<e.a.a.w.l.d>> map, Map<String, e.a.a.h> map2) throws IOException {
        cVar.b();
        while (cVar.f()) {
            ArrayList arrayList = new ArrayList();
            c.e.d dVar = new c.e.d();
            cVar.c();
            int i2 = 0;
            int i3 = 0;
            String str = null;
            String str2 = null;
            String str3 = null;
            while (cVar.f()) {
                int K = cVar.K(f11952b);
                if (K == 0) {
                    str = cVar.v();
                } else if (K == 1) {
                    cVar.b();
                    while (cVar.f()) {
                        e.a.a.w.l.d b2 = s.b(cVar, eVar);
                        dVar.n(b2.b(), b2);
                        arrayList.add(b2);
                    }
                    cVar.d();
                } else if (K == 2) {
                    i2 = cVar.m();
                } else if (K == 3) {
                    i3 = cVar.m();
                } else if (K == 4) {
                    str2 = cVar.v();
                } else if (K != 5) {
                    cVar.N();
                    cVar.O();
                } else {
                    str3 = cVar.v();
                }
            }
            cVar.e();
            if (str2 != null) {
                e.a.a.h hVar = new e.a.a.h(i2, i3, str, str2, str3);
                map2.put(hVar.d(), hVar);
            } else {
                map.put(str, arrayList);
            }
        }
        cVar.d();
    }

    private static void c(e.a.a.y.k0.c cVar, e.a.a.e eVar, c.e.h<e.a.a.w.d> hVar) throws IOException {
        cVar.b();
        while (cVar.f()) {
            e.a.a.w.d a2 = j.a(cVar, eVar);
            hVar.l(a2.hashCode(), a2);
        }
        cVar.d();
    }

    private static void d(e.a.a.y.k0.c cVar, Map<String, e.a.a.w.c> map) throws IOException {
        cVar.c();
        while (cVar.f()) {
            if (cVar.K(f11953c) != 0) {
                cVar.N();
                cVar.O();
            } else {
                cVar.b();
                while (cVar.f()) {
                    e.a.a.w.c a2 = k.a(cVar);
                    map.put(a2.b(), a2);
                }
                cVar.d();
            }
        }
        cVar.e();
    }

    private static void e(e.a.a.y.k0.c cVar, e.a.a.e eVar, List<e.a.a.w.l.d> list, c.e.d<e.a.a.w.l.d> dVar) throws IOException {
        cVar.b();
        int i2 = 0;
        while (cVar.f()) {
            e.a.a.w.l.d b2 = s.b(cVar, eVar);
            if (b2.d() == d.a.IMAGE) {
                i2++;
            }
            list.add(b2);
            dVar.n(b2.b(), b2);
            if (i2 > 4) {
                e.a.a.z.d.c("You have " + i2 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        cVar.d();
    }

    private static void f(e.a.a.y.k0.c cVar, e.a.a.e eVar, List<e.a.a.w.h> list) throws IOException {
        cVar.b();
        while (cVar.f()) {
            String str = null;
            cVar.c();
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (cVar.f()) {
                int K = cVar.K(f11954d);
                if (K == 0) {
                    str = cVar.v();
                } else if (K == 1) {
                    f2 = (float) cVar.j();
                } else if (K != 2) {
                    cVar.N();
                    cVar.O();
                } else {
                    f3 = (float) cVar.j();
                }
            }
            cVar.e();
            list.add(new e.a.a.w.h(str, f2, f3));
        }
        cVar.d();
    }
}