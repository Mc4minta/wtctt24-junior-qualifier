package com.google.zxing.r.c;

import com.google.zxing.NotFoundException;
import com.google.zxing.m;
import com.google.zxing.q.g;
import com.google.zxing.q.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Detector.java */
/* loaded from: classes2.dex */
public final class a {
    private final com.google.zxing.q.b a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.zxing.q.m.b f9981b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Detector.java */
    /* loaded from: classes2.dex */
    public static final class b {
        private final m a;

        /* renamed from: b  reason: collision with root package name */
        private final m f9982b;

        /* renamed from: c  reason: collision with root package name */
        private final int f9983c;

        m a() {
            return this.a;
        }

        m b() {
            return this.f9982b;
        }

        int c() {
            return this.f9983c;
        }

        public String toString() {
            return this.a + "/" + this.f9982b + '/' + this.f9983c;
        }

        private b(m mVar, m mVar2, int i2) {
            this.a = mVar;
            this.f9982b = mVar2;
            this.f9983c = i2;
        }
    }

    /* compiled from: Detector.java */
    /* loaded from: classes2.dex */
    private static final class c implements Serializable, Comparator<b> {
        private c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            return bVar.c() - bVar2.c();
        }
    }

    public a(com.google.zxing.q.b bVar) throws NotFoundException {
        this.a = bVar;
        this.f9981b = new com.google.zxing.q.m.b(bVar);
    }

    private m a(m mVar, m mVar2, m mVar3, m mVar4, int i2) {
        float f2 = i2;
        float d2 = d(mVar, mVar2) / f2;
        float d3 = d(mVar3, mVar4);
        m mVar5 = new m(mVar4.c() + (((mVar4.c() - mVar3.c()) / d3) * d2), mVar4.d() + (d2 * ((mVar4.d() - mVar3.d()) / d3)));
        float d4 = d(mVar, mVar3) / f2;
        float d5 = d(mVar2, mVar4);
        m mVar6 = new m(mVar4.c() + (((mVar4.c() - mVar2.c()) / d5) * d4), mVar4.d() + (d4 * ((mVar4.d() - mVar2.d()) / d5)));
        if (f(mVar5)) {
            return (f(mVar6) && Math.abs(h(mVar3, mVar5).c() - h(mVar2, mVar5).c()) > Math.abs(h(mVar3, mVar6).c() - h(mVar2, mVar6).c())) ? mVar6 : mVar5;
        } else if (f(mVar6)) {
            return mVar6;
        } else {
            return null;
        }
    }

    private m b(m mVar, m mVar2, m mVar3, m mVar4, int i2, int i3) {
        float d2 = d(mVar, mVar2) / i2;
        float d3 = d(mVar3, mVar4);
        m mVar5 = new m(mVar4.c() + (((mVar4.c() - mVar3.c()) / d3) * d2), mVar4.d() + (d2 * ((mVar4.d() - mVar3.d()) / d3)));
        float d4 = d(mVar, mVar3) / i3;
        float d5 = d(mVar2, mVar4);
        m mVar6 = new m(mVar4.c() + (((mVar4.c() - mVar2.c()) / d5) * d4), mVar4.d() + (d4 * ((mVar4.d() - mVar2.d()) / d5)));
        if (f(mVar5)) {
            return (f(mVar6) && Math.abs(i2 - h(mVar3, mVar5).c()) + Math.abs(i3 - h(mVar2, mVar5).c()) > Math.abs(i2 - h(mVar3, mVar6).c()) + Math.abs(i3 - h(mVar2, mVar6).c())) ? mVar6 : mVar5;
        } else if (f(mVar6)) {
            return mVar6;
        } else {
            return null;
        }
    }

    private static int d(m mVar, m mVar2) {
        return com.google.zxing.q.m.a.c(m.b(mVar, mVar2));
    }

    private static void e(Map<m, Integer> map, m mVar) {
        Integer num = map.get(mVar);
        map.put(mVar, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    private boolean f(m mVar) {
        return mVar.c() >= 0.0f && mVar.c() < ((float) this.a.n()) && mVar.d() > 0.0f && mVar.d() < ((float) this.a.i());
    }

    private static com.google.zxing.q.b g(com.google.zxing.q.b bVar, m mVar, m mVar2, m mVar3, m mVar4, int i2, int i3) throws NotFoundException {
        float f2 = i2 - 0.5f;
        float f3 = i3 - 0.5f;
        return i.b().c(bVar, i2, i3, 0.5f, 0.5f, f2, 0.5f, f2, f3, 0.5f, f3, mVar.c(), mVar.d(), mVar4.c(), mVar4.d(), mVar3.c(), mVar3.d(), mVar2.c(), mVar2.d());
    }

    private b h(m mVar, m mVar2) {
        int c2 = (int) mVar.c();
        int d2 = (int) mVar.d();
        int c3 = (int) mVar2.c();
        int d3 = (int) mVar2.d();
        int i2 = 0;
        boolean z = Math.abs(d3 - d2) > Math.abs(c3 - c2);
        if (z) {
            d2 = c2;
            c2 = d2;
            d3 = c3;
            c3 = d3;
        }
        int abs = Math.abs(c3 - c2);
        int abs2 = Math.abs(d3 - d2);
        int i3 = (-abs) / 2;
        int i4 = d2 < d3 ? 1 : -1;
        int i5 = c2 >= c3 ? -1 : 1;
        boolean e2 = this.a.e(z ? d2 : c2, z ? c2 : d2);
        while (c2 != c3) {
            boolean e3 = this.a.e(z ? d2 : c2, z ? c2 : d2);
            if (e3 != e2) {
                i2++;
                e2 = e3;
            }
            i3 += abs2;
            if (i3 > 0) {
                if (d2 == d3) {
                    break;
                }
                d2 += i4;
                i3 -= abs;
            }
            c2 += i5;
        }
        return new b(mVar, mVar2, i2);
    }

    public g c() throws NotFoundException {
        m mVar;
        m mVar2;
        com.google.zxing.q.b g2;
        m[] c2 = this.f9981b.c();
        m mVar3 = c2[0];
        m mVar4 = c2[1];
        m mVar5 = c2[2];
        m mVar6 = c2[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(h(mVar3, mVar4));
        arrayList.add(h(mVar3, mVar5));
        arrayList.add(h(mVar4, mVar6));
        arrayList.add(h(mVar5, mVar6));
        m mVar7 = null;
        Collections.sort(arrayList, new c());
        b bVar = (b) arrayList.get(0);
        b bVar2 = (b) arrayList.get(1);
        HashMap hashMap = new HashMap();
        e(hashMap, bVar.a());
        e(hashMap, bVar.b());
        e(hashMap, bVar2.a());
        e(hashMap, bVar2.b());
        m mVar8 = null;
        m mVar9 = null;
        for (Map.Entry entry : hashMap.entrySet()) {
            m mVar10 = (m) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                mVar8 = mVar10;
            } else if (mVar7 == null) {
                mVar7 = mVar10;
            } else {
                mVar9 = mVar10;
            }
        }
        if (mVar7 != null && mVar8 != null && mVar9 != null) {
            m[] mVarArr = {mVar7, mVar8, mVar9};
            m.e(mVarArr);
            m mVar11 = mVarArr[0];
            m mVar12 = mVarArr[1];
            m mVar13 = mVarArr[2];
            if (!hashMap.containsKey(mVar3)) {
                mVar = mVar3;
            } else if (hashMap.containsKey(mVar4)) {
                mVar = !hashMap.containsKey(mVar5) ? mVar5 : mVar6;
            } else {
                mVar = mVar4;
            }
            int c3 = h(mVar13, mVar).c();
            int c4 = h(mVar11, mVar).c();
            if ((c3 & 1) == 1) {
                c3++;
            }
            int i2 = c3 + 2;
            if ((c4 & 1) == 1) {
                c4++;
            }
            int i3 = c4 + 2;
            if (i2 * 4 < i3 * 7 && i3 * 4 < i2 * 7) {
                m a = a(mVar12, mVar11, mVar13, mVar, Math.min(i3, i2));
                if (a != null) {
                    mVar = a;
                }
                int max = Math.max(h(mVar13, mVar).c(), h(mVar11, mVar).c()) + 1;
                if ((max & 1) == 1) {
                    max++;
                }
                int i4 = max;
                g2 = g(this.a, mVar13, mVar12, mVar11, mVar, i4, i4);
                mVar2 = mVar13;
            } else {
                mVar2 = mVar13;
                m b2 = b(mVar12, mVar11, mVar13, mVar, i2, i3);
                if (b2 != null) {
                    mVar = b2;
                }
                int c5 = h(mVar2, mVar).c();
                int c6 = h(mVar11, mVar).c();
                if ((c5 & 1) == 1) {
                    c5++;
                }
                int i5 = c5;
                if ((c6 & 1) == 1) {
                    c6++;
                }
                g2 = g(this.a, mVar2, mVar12, mVar11, mVar, i5, c6);
            }
            return new g(g2, new m[]{mVar2, mVar12, mVar11, mVar});
        }
        throw NotFoundException.a();
    }
}