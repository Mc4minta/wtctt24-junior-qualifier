package e.f.m.b0.b;

import e.f.j.e.h;
import e.f.j.e.k;
import java.util.List;

/* compiled from: MultiSourceHelper.java */
/* loaded from: classes2.dex */
public class b {

    /* compiled from: MultiSourceHelper.java */
    /* renamed from: e.f.m.b0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0283b {
        private final e.f.m.b0.b.a a;

        /* renamed from: b  reason: collision with root package name */
        private final e.f.m.b0.b.a f12816b;

        public e.f.m.b0.b.a a() {
            return this.a;
        }

        public e.f.m.b0.b.a b() {
            return this.f12816b;
        }

        private C0283b(e.f.m.b0.b.a aVar, e.f.m.b0.b.a aVar2) {
            this.a = aVar;
            this.f12816b = aVar2;
        }
    }

    public static C0283b a(int i2, int i3, List<e.f.m.b0.b.a> list) {
        return b(i2, i3, list, 1.0d);
    }

    public static C0283b b(int i2, int i3, List<e.f.m.b0.b.a> list, double d2) {
        if (list.isEmpty()) {
            return new C0283b(null, null);
        }
        if (list.size() == 1) {
            return new C0283b(list.get(0), null);
        }
        if (i2 > 0 && i3 > 0) {
            h i4 = k.k().i();
            double d3 = i2 * i3 * d2;
            double d4 = Double.MAX_VALUE;
            double d5 = Double.MAX_VALUE;
            e.f.m.b0.b.a aVar = null;
            e.f.m.b0.b.a aVar2 = null;
            for (e.f.m.b0.b.a aVar3 : list) {
                double abs = Math.abs(1.0d - (aVar3.c() / d3));
                if (abs < d4) {
                    aVar2 = aVar3;
                    d4 = abs;
                }
                if (abs < d5 && (i4.l(aVar3.e()) || i4.n(aVar3.e()))) {
                    aVar = aVar3;
                    d5 = abs;
                }
            }
            if (aVar != null && aVar2 != null && aVar.d().equals(aVar2.d())) {
                aVar = null;
            }
            return new C0283b(aVar2, aVar);
        }
        return new C0283b(null, null);
    }
}