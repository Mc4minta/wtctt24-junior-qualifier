package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.e4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class c4<T extends e4<T>> {
    private static final c4 a = new c4(true);

    /* renamed from: b  reason: collision with root package name */
    final n6<T, Object> f7070b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7071c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7072d;

    private c4() {
        this.f7070b = n6.b(16);
    }

    public static int a(e4<?> e4Var, Object obj) {
        q7 b2 = e4Var.b();
        int a2 = e4Var.a();
        if (e4Var.d()) {
            int i2 = 0;
            if (e4Var.e()) {
                for (Object obj2 : (List) obj) {
                    i2 += i(b2, obj2);
                }
                return zzel.g0(a2) + i2 + zzel.D0(i2);
            }
            for (Object obj3 : (List) obj) {
                i2 += b(b2, a2, obj3);
            }
            return i2;
        }
        return b(b2, a2, obj);
    }

    static int b(q7 q7Var, int i2, Object obj) {
        int g0 = zzel.g0(i2);
        if (q7Var == q7.f7326k) {
            q4.g((u5) obj);
            g0 <<= 1;
        }
        return g0 + i(q7Var, obj);
    }

    public static <T extends e4<T>> c4<T> c() {
        return a;
    }

    private final Object d(T t) {
        Object obj = this.f7070b.get(t);
        if (obj instanceof y4) {
            y4 y4Var = (y4) obj;
            return y4.e();
        }
        return obj;
    }

    private static Object e(Object obj) {
        if (obj instanceof c6) {
            return ((c6) obj).a();
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.p4) == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.y4) == false) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(com.google.android.gms.internal.measurement.q7 r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.q4.d(r3)
            int[] r0 = com.google.android.gms.internal.measurement.f4.a
            com.google.android.gms.internal.measurement.x7 r2 = r2.h()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L31;
                case 7: goto L28;
                case 8: goto L1f;
                case 9: goto L16;
                default: goto L14;
            }
        L14:
            r0 = r1
            goto L42
        L16:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.u5
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.y4
            if (r2 == 0) goto L14
            goto L42
        L1f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.p4
            if (r2 == 0) goto L14
            goto L42
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.h3
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L14
            goto L42
        L31:
            boolean r0 = r3 instanceof java.lang.String
            goto L42
        L34:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r0 = r3 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L42
        L40:
            boolean r0 = r3 instanceof java.lang.Integer
        L42:
            if (r0 == 0) goto L45
            return
        L45:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.c4.g(com.google.android.gms.internal.measurement.q7, java.lang.Object):void");
    }

    private static <T extends e4<T>> boolean h(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.c() == x7.MESSAGE) {
            if (key.d()) {
                for (u5 u5Var : (List) entry.getValue()) {
                    if (!u5Var.h()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof u5) {
                    if (!((u5) value).h()) {
                        return false;
                    }
                } else if (value instanceof y4) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private static int i(q7 q7Var, Object obj) {
        switch (f4.f7131b[q7Var.ordinal()]) {
            case 1:
                return zzel.z(((Double) obj).doubleValue());
            case 2:
                return zzel.A(((Float) obj).floatValue());
            case 3:
                return zzel.d0(((Long) obj).longValue());
            case 4:
                return zzel.i0(((Long) obj).longValue());
            case 5:
                return zzel.k0(((Integer) obj).intValue());
            case 6:
                return zzel.r0(((Long) obj).longValue());
            case 7:
                return zzel.w0(((Integer) obj).intValue());
            case 8:
                return zzel.L(((Boolean) obj).booleanValue());
            case 9:
                return zzel.V((u5) obj);
            case 10:
                if (obj instanceof y4) {
                    return zzel.d((y4) obj);
                }
                return zzel.J((u5) obj);
            case 11:
                if (obj instanceof h3) {
                    return zzel.I((h3) obj);
                }
                return zzel.K((String) obj);
            case 12:
                if (obj instanceof h3) {
                    return zzel.I((h3) obj);
                }
                return zzel.M((byte[]) obj);
            case 13:
                return zzel.o0(((Integer) obj).intValue());
            case 14:
                return zzel.z0(((Integer) obj).intValue());
            case 15:
                return zzel.v0(((Long) obj).longValue());
            case 16:
                return zzel.s0(((Integer) obj).intValue());
            case 17:
                return zzel.n0(((Long) obj).longValue());
            case 18:
                if (obj instanceof p4) {
                    return zzel.B0(((p4) obj).a());
                }
                return zzel.B0(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private final void k(T t, Object obj) {
        if (t.d()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    g(t.b(), obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            g(t.b(), obj);
        }
        if (obj instanceof y4) {
            this.f7072d = true;
        }
        this.f7070b.put(t, obj);
    }

    private final void l(Map.Entry<T, Object> entry) {
        u5 j2;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof y4) {
            y4 y4Var = (y4) value;
            value = y4.e();
        }
        if (key.d()) {
            Object d2 = d(key);
            if (d2 == null) {
                d2 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) d2).add(e(obj));
            }
            this.f7070b.put(key, d2);
        } else if (key.c() == x7.MESSAGE) {
            Object d3 = d(key);
            if (d3 == null) {
                this.f7070b.put(key, e(value));
                return;
            }
            if (d3 instanceof c6) {
                j2 = key.l((c6) d3, (c6) value);
            } else {
                j2 = key.i(((u5) d3).c(), (u5) value).j();
            }
            this.f7070b.put(key, j2);
        } else {
            this.f7070b.put(key, e(value));
        }
    }

    private static int m(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.c() == x7.MESSAGE && !key.d() && !key.e()) {
            if (value instanceof y4) {
                return zzel.D(entry.getKey().a(), (y4) value);
            }
            return zzel.E(entry.getKey().a(), (u5) value);
        }
        return a(key, value);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        c4 c4Var = new c4();
        for (int i2 = 0; i2 < this.f7070b.k(); i2++) {
            Map.Entry<T, Object> i3 = this.f7070b.i(i2);
            c4Var.k(i3.getKey(), i3.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f7070b.n()) {
            c4Var.k(entry.getKey(), entry.getValue());
        }
        c4Var.f7072d = this.f7072d;
        return c4Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c4) {
            return this.f7070b.equals(((c4) obj).f7070b);
        }
        return false;
    }

    public final void f(c4<T> c4Var) {
        for (int i2 = 0; i2 < c4Var.f7070b.k(); i2++) {
            l(c4Var.f7070b.i(i2));
        }
        for (Map.Entry<T, Object> entry : c4Var.f7070b.n()) {
            l(entry);
        }
    }

    public final int hashCode() {
        return this.f7070b.hashCode();
    }

    public final void j() {
        if (this.f7071c) {
            return;
        }
        this.f7070b.e();
        this.f7071c = true;
    }

    public final boolean n() {
        return this.f7071c;
    }

    public final Iterator<Map.Entry<T, Object>> o() {
        if (this.f7072d) {
            return new z4(this.f7070b.entrySet().iterator());
        }
        return this.f7070b.entrySet().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> p() {
        if (this.f7072d) {
            return new z4(this.f7070b.p().iterator());
        }
        return this.f7070b.p().iterator();
    }

    public final boolean q() {
        for (int i2 = 0; i2 < this.f7070b.k(); i2++) {
            if (!h(this.f7070b.i(i2))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.f7070b.n()) {
            if (!h(entry)) {
                return false;
            }
        }
        return true;
    }

    public final int r() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f7070b.k(); i3++) {
            i2 += m(this.f7070b.i(i3));
        }
        for (Map.Entry<T, Object> entry : this.f7070b.n()) {
            i2 += m(entry);
        }
        return i2;
    }

    private c4(boolean z) {
        this(n6.b(0));
        j();
    }

    private c4(n6<T, Object> n6Var) {
        this.f7070b = n6Var;
        j();
    }
}