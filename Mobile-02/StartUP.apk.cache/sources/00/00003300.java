package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class v0<FieldDescriptorType extends y0<FieldDescriptorType>> {
    private static final v0 a = new v0(true);

    /* renamed from: c  reason: collision with root package name */
    private boolean f6575c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6576d = false;

    /* renamed from: b  reason: collision with root package name */
    private final c3<FieldDescriptorType, Object> f6574b = c3.f(16);

    private v0() {
    }

    private v0(boolean z) {
        t();
    }

    static int f(f4 f4Var, int i2, Object obj) {
        int B0 = zzbn.B0(i2);
        if (f4Var == f4.f6440k) {
            g1.i((i2) obj);
            B0 <<= 1;
        }
        return B0 + o(f4Var, obj);
    }

    private final Object g(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f6574b.get(fielddescriptortype);
        return obj instanceof l1 ? l1.e() : obj;
    }

    private final void i(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.r()) {
            j(fielddescriptortype.u(), obj);
        } else if (!(obj instanceof List)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj2 = arrayList.get(i2);
                i2++;
                j(fielddescriptortype.u(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof l1) {
            this.f6576d = true;
        }
        this.f6574b.put(fielddescriptortype, obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        if ((r3 instanceof com.google.android.gms.internal.clearcut.h1) == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
        if ((r3 instanceof byte[]) == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.clearcut.l1) == false) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(com.google.android.gms.internal.clearcut.f4 r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.clearcut.g1.a(r3)
            int[] r0 = com.google.android.gms.internal.clearcut.w0.a
            com.google.android.gms.internal.clearcut.k4 r2 = r2.h()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L41;
                case 2: goto L3e;
                case 3: goto L3b;
                case 4: goto L38;
                case 5: goto L35;
                case 6: goto L32;
                case 7: goto L29;
                case 8: goto L20;
                case 9: goto L15;
                default: goto L14;
            }
        L14:
            goto L44
        L15:
            boolean r2 = r3 instanceof com.google.android.gms.internal.clearcut.i2
            if (r2 != 0) goto L43
            boolean r2 = r3 instanceof com.google.android.gms.internal.clearcut.l1
            if (r2 == 0) goto L1e
            goto L43
        L1e:
            r0 = r1
            goto L43
        L20:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L43
            boolean r2 = r3 instanceof com.google.android.gms.internal.clearcut.h1
            if (r2 == 0) goto L1e
            goto L43
        L29:
            boolean r2 = r3 instanceof com.google.android.gms.internal.clearcut.a0
            if (r2 != 0) goto L43
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L1e
            goto L43
        L32:
            boolean r0 = r3 instanceof java.lang.String
            goto L43
        L35:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L43
        L38:
            boolean r0 = r3 instanceof java.lang.Double
            goto L43
        L3b:
            boolean r0 = r3 instanceof java.lang.Float
            goto L43
        L3e:
            boolean r0 = r3 instanceof java.lang.Long
            goto L43
        L41:
            boolean r0 = r3 instanceof java.lang.Integer
        L43:
            r1 = r0
        L44:
            if (r1 == 0) goto L47
            return
        L47:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.v0.j(com.google.android.gms.internal.clearcut.f4, java.lang.Object):void");
    }

    public static <T extends y0<T>> v0<T> k() {
        return a;
    }

    private static int n(y0<?> y0Var, Object obj) {
        f4 u = y0Var.u();
        int c2 = y0Var.c();
        if (y0Var.r()) {
            int i2 = 0;
            List<Object> list = (List) obj;
            if (y0Var.j()) {
                for (Object obj2 : list) {
                    i2 += o(u, obj2);
                }
                return zzbn.B0(c2) + i2 + zzbn.J0(i2);
            }
            for (Object obj3 : list) {
                i2 += f(u, c2, obj3);
            }
            return i2;
        }
        return f(u, c2, obj);
    }

    private static int o(f4 f4Var, Object obj) {
        switch (w0.f6601b[f4Var.ordinal()]) {
            case 1:
                return zzbn.w(((Double) obj).doubleValue());
            case 2:
                return zzbn.x(((Float) obj).floatValue());
            case 3:
                return zzbn.e0(((Long) obj).longValue());
            case 4:
                return zzbn.h0(((Long) obj).longValue());
            case 5:
                return zzbn.C0(((Integer) obj).intValue());
            case 6:
                return zzbn.p0(((Long) obj).longValue());
            case 7:
                return zzbn.F0(((Integer) obj).intValue());
            case 8:
                return zzbn.F(((Boolean) obj).booleanValue());
            case 9:
                return zzbn.Z((i2) obj);
            case 10:
                return obj instanceof l1 ? zzbn.e((l1) obj) : zzbn.R((i2) obj);
            case 11:
                return obj instanceof a0 ? zzbn.D((a0) obj) : zzbn.q0((String) obj);
            case 12:
                return obj instanceof a0 ? zzbn.D((a0) obj) : zzbn.a0((byte[]) obj);
            case 13:
                return zzbn.D0(((Integer) obj).intValue());
            case 14:
                return zzbn.G0(((Integer) obj).intValue());
            case 15:
                return zzbn.s0(((Long) obj).longValue());
            case 16:
                return zzbn.E0(((Integer) obj).intValue());
            case 17:
                return zzbn.l0(((Long) obj).longValue());
            case 18:
                return obj instanceof h1 ? zzbn.H0(((h1) obj).c()) : zzbn.H0(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static boolean p(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.o() == k4.MESSAGE) {
            boolean r = key.r();
            Object value = entry.getValue();
            if (r) {
                for (i2 i2Var : (List) value) {
                    if (!i2Var.isInitialized()) {
                        return false;
                    }
                }
            } else if (!(value instanceof i2)) {
                if (value instanceof l1) {
                    return true;
                }
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            } else if (!((i2) value).isInitialized()) {
                return false;
            }
        }
        return true;
    }

    private final void q(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof l1) {
            value = l1.e();
        }
        if (key.r()) {
            Object g2 = g(key);
            if (g2 == null) {
                g2 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) g2).add(s(obj));
            }
            this.f6574b.put(key, g2);
        } else if (key.o() != k4.MESSAGE) {
            this.f6574b.put(key, s(value));
        } else {
            Object g3 = g(key);
            if (g3 == null) {
                this.f6574b.put(key, s(value));
            } else {
                this.f6574b.put(key, g3 instanceof o2 ? key.v((o2) g3, (o2) value) : key.g(((i2) g3).h(), (i2) value).z());
            }
        }
    }

    private static int r(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.o() != k4.MESSAGE || key.r() || key.j()) {
            return n(key, value);
        }
        boolean z = value instanceof l1;
        int c2 = entry.getKey().c();
        return z ? zzbn.A(c2, (l1) value) : zzbn.Y(c2, (i2) value);
    }

    private static Object s(Object obj) {
        if (obj instanceof o2) {
            return ((o2) obj).w0();
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> a() {
        return this.f6576d ? new o1(this.f6574b.o().iterator()) : this.f6574b.o().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        return this.f6574b.isEmpty();
    }

    public final boolean c() {
        return this.f6575c;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        v0 v0Var = new v0();
        for (int i2 = 0; i2 < this.f6574b.m(); i2++) {
            Map.Entry<FieldDescriptorType, Object> g2 = this.f6574b.g(i2);
            v0Var.i(g2.getKey(), g2.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f6574b.n()) {
            v0Var.i(entry.getKey(), entry.getValue());
        }
        v0Var.f6576d = this.f6576d;
        return v0Var;
    }

    public final boolean d() {
        for (int i2 = 0; i2 < this.f6574b.m(); i2++) {
            if (!p(this.f6574b.g(i2))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f6574b.n()) {
            if (!p(entry)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> e() {
        return this.f6576d ? new o1(this.f6574b.entrySet().iterator()) : this.f6574b.entrySet().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof v0) {
            return this.f6574b.equals(((v0) obj).f6574b);
        }
        return false;
    }

    public final void h(v0<FieldDescriptorType> v0Var) {
        for (int i2 = 0; i2 < v0Var.f6574b.m(); i2++) {
            q(v0Var.f6574b.g(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : v0Var.f6574b.n()) {
            q(entry);
        }
    }

    public final int hashCode() {
        return this.f6574b.hashCode();
    }

    public final int l() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f6574b.m(); i3++) {
            Map.Entry<FieldDescriptorType, Object> g2 = this.f6574b.g(i3);
            i2 += n(g2.getKey(), g2.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f6574b.n()) {
            i2 += n(entry.getKey(), entry.getValue());
        }
        return i2;
    }

    public final int m() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f6574b.m(); i3++) {
            i2 += r(this.f6574b.g(i3));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f6574b.n()) {
            i2 += r(entry);
        }
        return i2;
    }

    public final void t() {
        if (this.f6575c) {
            return;
        }
        this.f6574b.r();
        this.f6575c = true;
    }
}