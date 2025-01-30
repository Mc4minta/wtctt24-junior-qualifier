package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.a1;
import com.google.android.gms.internal.measurement.r0;
import com.google.android.gms.internal.measurement.z0;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class ca {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7524b;

    /* renamed from: c  reason: collision with root package name */
    private com.google.android.gms.internal.measurement.z0 f7525c;

    /* renamed from: d  reason: collision with root package name */
    private BitSet f7526d;

    /* renamed from: e  reason: collision with root package name */
    private BitSet f7527e;

    /* renamed from: f  reason: collision with root package name */
    private Map<Integer, Long> f7528f;

    /* renamed from: g  reason: collision with root package name */
    private Map<Integer, List<Long>> f7529g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ aa f7530h;

    private ca(aa aaVar, String str) {
        this.f7530h = aaVar;
        this.a = str;
        this.f7524b = true;
        this.f7526d = new BitSet();
        this.f7527e = new BitSet();
        this.f7528f = new c.e.a();
        this.f7529g = new c.e.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ BitSet b(ca caVar) {
        return caVar.f7526d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Iterable] */
    public final com.google.android.gms.internal.measurement.r0 a(int i2) {
        ArrayList arrayList;
        ?? arrayList2;
        r0.a Q = com.google.android.gms.internal.measurement.r0.Q();
        Q.u(i2);
        Q.x(this.f7524b);
        com.google.android.gms.internal.measurement.z0 z0Var = this.f7525c;
        if (z0Var != null) {
            Q.w(z0Var);
        }
        z0.a w = com.google.android.gms.internal.measurement.z0.Z().A(r9.G(this.f7526d)).w(r9.G(this.f7527e));
        if (this.f7528f == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.f7528f.size());
            for (Integer num : this.f7528f.keySet()) {
                int intValue = num.intValue();
                arrayList.add((com.google.android.gms.internal.measurement.s0) ((com.google.android.gms.internal.measurement.n4) com.google.android.gms.internal.measurement.s0.J().u(intValue).v(this.f7528f.get(Integer.valueOf(intValue)).longValue()).j()));
            }
        }
        w.B(arrayList);
        if (this.f7529g == null) {
            arrayList2 = Collections.emptyList();
        } else {
            arrayList2 = new ArrayList(this.f7529g.size());
            for (Integer num2 : this.f7529g.keySet()) {
                a1.a u = com.google.android.gms.internal.measurement.a1.K().u(num2.intValue());
                List<Long> list = this.f7529g.get(num2);
                if (list != null) {
                    Collections.sort(list);
                    u.v(list);
                }
                arrayList2.add((com.google.android.gms.internal.measurement.a1) ((com.google.android.gms.internal.measurement.n4) u.j()));
            }
        }
        w.C(arrayList2);
        Q.v(w);
        return (com.google.android.gms.internal.measurement.r0) ((com.google.android.gms.internal.measurement.n4) Q.j());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(ha haVar) {
        int a = haVar.a();
        Boolean bool = haVar.f7629c;
        if (bool != null) {
            this.f7527e.set(a, bool.booleanValue());
        }
        Boolean bool2 = haVar.f7630d;
        if (bool2 != null) {
            this.f7526d.set(a, bool2.booleanValue());
        }
        if (haVar.f7631e != null) {
            Long l2 = this.f7528f.get(Integer.valueOf(a));
            long longValue = haVar.f7631e.longValue() / 1000;
            if (l2 == null || longValue > l2.longValue()) {
                this.f7528f.put(Integer.valueOf(a), Long.valueOf(longValue));
            }
        }
        if (haVar.f7632f != null) {
            List<Long> list = this.f7529g.get(Integer.valueOf(a));
            if (list == null) {
                list = new ArrayList<>();
                this.f7529g.put(Integer.valueOf(a), list);
            }
            if (haVar.i()) {
                list.clear();
            }
            if (com.google.android.gms.internal.measurement.f9.b() && this.f7530h.o().A(this.a, r.j0) && haVar.j()) {
                list.clear();
            }
            if (com.google.android.gms.internal.measurement.f9.b() && this.f7530h.o().A(this.a, r.j0)) {
                long longValue2 = haVar.f7632f.longValue() / 1000;
                if (list.contains(Long.valueOf(longValue2))) {
                    return;
                }
                list.add(Long.valueOf(longValue2));
                return;
            }
            list.add(Long.valueOf(haVar.f7632f.longValue() / 1000));
        }
    }

    private ca(aa aaVar, String str, com.google.android.gms.internal.measurement.z0 z0Var, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.f7530h = aaVar;
        this.a = str;
        this.f7526d = bitSet;
        this.f7527e = bitSet2;
        this.f7528f = map;
        this.f7529g = new c.e.a();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(num));
                this.f7529g.put(num, arrayList);
            }
        }
        this.f7524b = false;
        this.f7525c = z0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ca(aa aaVar, String str, com.google.android.gms.internal.measurement.z0 z0Var, BitSet bitSet, BitSet bitSet2, Map map, Map map2, da daVar) {
        this(aaVar, str, z0Var, bitSet, bitSet2, map, map2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ca(aa aaVar, String str, da daVar) {
        this(aaVar, str);
    }
}