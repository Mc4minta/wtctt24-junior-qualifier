package e.a.a.y;

import android.graphics.PointF;
import com.appsflyer.share.Constants;
import e.a.a.y.k0.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeDataParser.java */
/* loaded from: classes.dex */
public class d0 implements j0<e.a.a.w.k.l> {
    public static final d0 a = new d0();

    /* renamed from: b  reason: collision with root package name */
    private static final c.a f11920b = c.a.a(Constants.URL_CAMPAIGN, "v", "i", "o");

    private d0() {
    }

    @Override // e.a.a.y.j0
    /* renamed from: b */
    public e.a.a.w.k.l a(e.a.a.y.k0.c cVar, float f2) throws IOException {
        if (cVar.A() == c.b.BEGIN_ARRAY) {
            cVar.b();
        }
        cVar.c();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (cVar.f()) {
            int K = cVar.K(f11920b);
            if (K == 0) {
                z = cVar.g();
            } else if (K == 1) {
                list = p.f(cVar, f2);
            } else if (K == 2) {
                list2 = p.f(cVar, f2);
            } else if (K != 3) {
                cVar.N();
                cVar.O();
            } else {
                list3 = p.f(cVar, f2);
            }
        }
        cVar.e();
        if (cVar.A() == c.b.END_ARRAY) {
            cVar.d();
        }
        if (list != null && list2 != null && list3 != null) {
            if (list.isEmpty()) {
                return new e.a.a.w.k.l(new PointF(), false, Collections.emptyList());
            }
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 1; i2 < size; i2++) {
                PointF pointF2 = list.get(i2);
                int i3 = i2 - 1;
                arrayList.add(new e.a.a.w.a(e.a.a.z.g.a(list.get(i3), list3.get(i3)), e.a.a.z.g.a(pointF2, list2.get(i2)), pointF2));
            }
            if (z) {
                PointF pointF3 = list.get(0);
                int i4 = size - 1;
                arrayList.add(new e.a.a.w.a(e.a.a.z.g.a(list.get(i4), list3.get(i4)), e.a.a.z.g.a(pointF3, list2.get(0)), pointF3));
            }
            return new e.a.a.w.k.l(pointF, z, arrayList);
        }
        throw new IllegalArgumentException("Shape data was missing information.");
    }
}