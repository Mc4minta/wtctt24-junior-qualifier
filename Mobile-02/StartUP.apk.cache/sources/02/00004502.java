package e.a.a.y;

import android.graphics.Color;
import android.graphics.Rect;
import e.a.a.w.l.d;
import e.a.a.y.k0.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: LayerParser.java */
/* loaded from: classes.dex */
public class s {
    private static final c.a a = c.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f11950b = c.a.a("d", "a");

    /* renamed from: c  reason: collision with root package name */
    private static final c.a f11951c = c.a.a("nm");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LayerParser.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.b.values().length];
            a = iArr;
            try {
                iArr[d.b.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.b.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static e.a.a.w.l.d a(e.a.a.e eVar) {
        Rect b2 = eVar.b();
        return new e.a.a.w.l.d(Collections.emptyList(), eVar, "__container", -1L, d.a.PRE_COMP, -1L, null, Collections.emptyList(), new e.a.a.w.j.l(), 0, 0, 0, 0.0f, 0.0f, b2.width(), b2.height(), null, null, Collections.emptyList(), d.b.NONE, null, false);
    }

    public static e.a.a.w.l.d b(e.a.a.y.k0.c cVar, e.a.a.e eVar) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        float f2;
        d.b bVar = d.b.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        cVar.c();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        d.b bVar2 = bVar;
        float f3 = 1.0f;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        d.a aVar = null;
        String str = null;
        e.a.a.w.j.l lVar = null;
        e.a.a.w.j.j jVar = null;
        e.a.a.w.j.k kVar = null;
        e.a.a.w.j.b bVar3 = null;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        long j2 = -1;
        long j3 = 0;
        String str2 = null;
        String str3 = "UNSET";
        while (cVar.f()) {
            switch (cVar.K(a)) {
                case 0:
                    str3 = cVar.v();
                    break;
                case 1:
                    j3 = cVar.m();
                    break;
                case 2:
                    str = cVar.v();
                    break;
                case 3:
                    int m = cVar.m();
                    aVar = d.a.UNKNOWN;
                    if (m >= aVar.ordinal()) {
                        break;
                    } else {
                        aVar = d.a.values()[m];
                        break;
                    }
                case 4:
                    j2 = cVar.m();
                    break;
                case 5:
                    i2 = (int) (cVar.m() * e.a.a.z.h.e());
                    break;
                case 6:
                    i3 = (int) (cVar.m() * e.a.a.z.h.e());
                    break;
                case 7:
                    i4 = Color.parseColor(cVar.v());
                    break;
                case 8:
                    lVar = c.g(cVar, eVar);
                    break;
                case 9:
                    int m2 = cVar.m();
                    if (m2 >= d.b.values().length) {
                        eVar.a("Unsupported matte type: " + m2);
                        break;
                    } else {
                        bVar2 = d.b.values()[m2];
                        int i7 = a.a[bVar2.ordinal()];
                        if (i7 == 1) {
                            eVar.a("Unsupported matte type: Luma");
                        } else if (i7 == 2) {
                            eVar.a("Unsupported matte type: Luma Inverted");
                        }
                        eVar.q(1);
                        break;
                    }
                case 10:
                    cVar.b();
                    while (cVar.f()) {
                        arrayList3.add(u.a(cVar, eVar));
                    }
                    eVar.q(arrayList3.size());
                    cVar.d();
                    break;
                case 11:
                    cVar.b();
                    while (cVar.f()) {
                        e.a.a.w.k.b a2 = g.a(cVar, eVar);
                        if (a2 != null) {
                            arrayList4.add(a2);
                        }
                    }
                    cVar.d();
                    break;
                case 12:
                    cVar.c();
                    while (cVar.f()) {
                        int K = cVar.K(f11950b);
                        if (K == 0) {
                            jVar = d.d(cVar, eVar);
                        } else if (K != 1) {
                            cVar.N();
                            cVar.O();
                        } else {
                            cVar.b();
                            if (cVar.f()) {
                                kVar = b.a(cVar, eVar);
                            }
                            while (cVar.f()) {
                                cVar.O();
                            }
                            cVar.d();
                        }
                    }
                    cVar.e();
                    break;
                case 13:
                    cVar.b();
                    ArrayList arrayList5 = new ArrayList();
                    while (cVar.f()) {
                        cVar.c();
                        while (cVar.f()) {
                            if (cVar.K(f11951c) != 0) {
                                cVar.N();
                                cVar.O();
                            } else {
                                arrayList5.add(cVar.v());
                            }
                        }
                        cVar.e();
                    }
                    cVar.d();
                    eVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f3 = (float) cVar.j();
                    break;
                case 15:
                    f6 = (float) cVar.j();
                    break;
                case 16:
                    i5 = (int) (cVar.m() * e.a.a.z.h.e());
                    break;
                case 17:
                    i6 = (int) (cVar.m() * e.a.a.z.h.e());
                    break;
                case 18:
                    f4 = (float) cVar.j();
                    break;
                case 19:
                    f5 = (float) cVar.j();
                    break;
                case 20:
                    bVar3 = d.f(cVar, eVar, false);
                    break;
                case 21:
                    str2 = cVar.v();
                    break;
                case 22:
                    z = cVar.g();
                    break;
                default:
                    cVar.N();
                    cVar.O();
                    break;
            }
        }
        cVar.e();
        float f7 = f4 / f3;
        float f8 = f5 / f3;
        ArrayList arrayList6 = new ArrayList();
        if (f7 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new e.a.a.a0.a(eVar, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f7)));
            f2 = 0.0f;
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            f2 = 0.0f;
        }
        if (f8 <= f2) {
            f8 = eVar.f();
        }
        arrayList2.add(new e.a.a.a0.a(eVar, valueOf, valueOf, null, f7, Float.valueOf(f8)));
        arrayList2.add(new e.a.a.a0.a(eVar, valueOf2, valueOf2, null, f8, Float.valueOf(Float.MAX_VALUE)));
        if (str3.endsWith(".ai") || "ai".equals(str2)) {
            eVar.a("Convert your Illustrator layers to shape layers.");
        }
        return new e.a.a.w.l.d(arrayList4, eVar, str3, j3, aVar, j2, str, arrayList, lVar, i2, i3, i4, f3, f6, i5, i6, jVar, kVar, arrayList2, bVar2, bVar3, z);
    }
}