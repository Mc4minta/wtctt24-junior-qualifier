package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.g4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.e4  reason: invalid package */
/* loaded from: classes2.dex */
public final class e4<T extends g4<T>> {
    private static final e4 a = new e4(true);

    /* renamed from: b  reason: collision with root package name */
    final n6<T, Object> f6712b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6713c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6714d;

    private e4() {
        this.f6712b = n6.f(16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(s7 s7Var, int i2, Object obj) {
        int F0 = zzev.F0(i2);
        if (s7Var == s7.f6915k) {
            n4.i((v5) obj);
            F0 <<= 1;
        }
        return F0 + l(s7Var, obj);
    }

    private final Object f(T t) {
        Object obj = this.f6712b.get(t);
        if (obj instanceof v4) {
            v4 v4Var = (v4) obj;
            return v4.e();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(zzev zzevVar, s7 s7Var, int i2, Object obj) throws IOException {
        if (s7Var == s7.f6915k) {
            v5 v5Var = (v5) obj;
            n4.i(v5Var);
            zzevVar.b(i2, 3);
            v5Var.e(zzevVar);
            zzevVar.b(i2, 4);
            return;
        }
        zzevVar.b(i2, s7Var.n());
        switch (h4.f6730b[s7Var.ordinal()]) {
            case 1:
                zzevVar.g(((Double) obj).doubleValue());
                return;
            case 2:
                zzevVar.U(((Float) obj).floatValue());
                return;
            case 3:
                zzevVar.B(((Long) obj).longValue());
                return;
            case 4:
                zzevVar.B(((Long) obj).longValue());
                return;
            case 5:
                zzevVar.B0(((Integer) obj).intValue());
                return;
            case 6:
                zzevVar.D(((Long) obj).longValue());
                return;
            case 7:
                zzevVar.E0(((Integer) obj).intValue());
                return;
            case 8:
                zzevVar.m0(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((v5) obj).e(zzevVar);
                return;
            case 10:
                zzevVar.X((v5) obj);
                return;
            case 11:
                if (obj instanceof i3) {
                    zzevVar.p((i3) obj);
                    return;
                } else {
                    zzevVar.z((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof i3) {
                    zzevVar.p((i3) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzevVar.Y(bArr, 0, bArr.length);
                return;
            case 13:
                zzevVar.C0(((Integer) obj).intValue());
                return;
            case 14:
                zzevVar.E0(((Integer) obj).intValue());
                return;
            case 15:
                zzevVar.D(((Long) obj).longValue());
                return;
            case 16:
                zzevVar.D0(((Integer) obj).intValue());
                return;
            case 17:
                zzevVar.C(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof q4) {
                    zzevVar.B0(((q4) obj).getNumber());
                    return;
                } else {
                    zzevVar.B0(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    private final void i(T t, Object obj) {
        if (t.w()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    j(t.f(), obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            j(t.f(), obj);
        }
        if (obj instanceof v4) {
            this.f6714d = true;
        }
        this.f6712b.put(t, obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.p000firebaseperf.q4) == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.p000firebaseperf.v4) == false) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(com.google.android.gms.internal.p000firebaseperf.s7 r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.p000firebaseperf.n4.a(r3)
            int[] r0 = com.google.android.gms.internal.p000firebaseperf.h4.a
            com.google.android.gms.internal.firebase-perf.v7 r2 = r2.h()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.p000firebaseperf.v5
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.p000firebaseperf.v4
            if (r2 == 0) goto L14
            goto L42
        L1f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.p000firebaseperf.q4
            if (r2 == 0) goto L14
            goto L42
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.p000firebaseperf.i3
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.e4.j(com.google.android.gms.internal.firebase-perf.s7, java.lang.Object):void");
    }

    public static int k(g4<?> g4Var, Object obj) {
        s7 f2 = g4Var.f();
        int number = g4Var.getNumber();
        if (g4Var.w()) {
            int i2 = 0;
            if (g4Var.x()) {
                for (Object obj2 : (List) obj) {
                    i2 += l(f2, obj2);
                }
                return zzev.F0(number) + i2 + zzev.y(i2);
            }
            for (Object obj3 : (List) obj) {
                i2 += e(f2, number, obj3);
            }
            return i2;
        }
        return e(f2, number, obj);
    }

    private static int l(s7 s7Var, Object obj) {
        switch (h4.f6730b[s7Var.ordinal()]) {
            case 1:
                return zzev.K(((Double) obj).doubleValue());
            case 2:
                return zzev.Z(((Float) obj).floatValue());
            case 3:
                return zzev.E(((Long) obj).longValue());
            case 4:
                return zzev.F(((Long) obj).longValue());
            case 5:
                return zzev.G0(((Integer) obj).intValue());
            case 6:
                return zzev.H(((Long) obj).longValue());
            case 7:
                return zzev.t(((Integer) obj).intValue());
            case 8:
                return zzev.o0(((Boolean) obj).booleanValue());
            case 9:
                return zzev.h0((v5) obj);
            case 10:
                if (obj instanceof v4) {
                    return zzev.d((v4) obj);
                }
                return zzev.c0((v5) obj);
            case 11:
                if (obj instanceof i3) {
                    return zzev.S((i3) obj);
                }
                return zzev.A((String) obj);
            case 12:
                if (obj instanceof i3) {
                    return zzev.S((i3) obj);
                }
                return zzev.T((byte[]) obj);
            case 13:
                return zzev.r(((Integer) obj).intValue());
            case 14:
                return zzev.u(((Integer) obj).intValue());
            case 15:
                return zzev.I(((Long) obj).longValue());
            case 16:
                return zzev.s(((Integer) obj).intValue());
            case 17:
                return zzev.G(((Long) obj).longValue());
            case 18:
                if (obj instanceof q4) {
                    return zzev.v(((q4) obj).getNumber());
                }
                return zzev.v(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static <T extends g4<T>> boolean m(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.k() == v7.MESSAGE) {
            if (key.w()) {
                for (v5 v5Var : (List) entry.getValue()) {
                    if (!v5Var.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof v5) {
                    if (!((v5) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof v4) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private final void n(Map.Entry<T, Object> entry) {
        v5 O;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof v4) {
            v4 v4Var = (v4) value;
            value = v4.e();
        }
        if (key.w()) {
            Object f2 = f(key);
            if (f2 == null) {
                f2 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) f2).add(p(obj));
            }
            this.f6712b.put(key, f2);
        } else if (key.k() == v7.MESSAGE) {
            Object f3 = f(key);
            if (f3 == null) {
                this.f6712b.put(key, p(value));
                return;
            }
            if (f3 instanceof b6) {
                O = key.t((b6) f3, (b6) value);
            } else {
                O = key.p(((v5) f3).b(), (v5) value).O();
            }
            this.f6712b.put(key, O);
        } else {
            this.f6712b.put(key, p(value));
        }
    }

    private static int o(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.k() == v7.MESSAGE && !key.w() && !key.x()) {
            if (value instanceof v4) {
                return zzev.N(entry.getKey().getNumber(), (v4) value);
            }
            return zzev.O(entry.getKey().getNumber(), (v5) value);
        }
        return k(key, value);
    }

    private static Object p(Object obj) {
        if (obj instanceof b6) {
            return ((b6) obj).V();
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    public static <T extends g4<T>> e4<T> r() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> a() {
        if (this.f6714d) {
            return new a5(this.f6712b.p().iterator());
        }
        return this.f6712b.p().iterator();
    }

    public final boolean b() {
        return this.f6713c;
    }

    public final boolean c() {
        for (int i2 = 0; i2 < this.f6712b.n(); i2++) {
            if (!m(this.f6712b.g(i2))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.f6712b.o()) {
            if (!m(entry)) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        e4 e4Var = new e4();
        for (int i2 = 0; i2 < this.f6712b.n(); i2++) {
            Map.Entry<T, Object> g2 = this.f6712b.g(i2);
            e4Var.i(g2.getKey(), g2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f6712b.o()) {
            e4Var.i(entry.getKey(), entry.getValue());
        }
        e4Var.f6714d = this.f6714d;
        return e4Var;
    }

    public final Iterator<Map.Entry<T, Object>> d() {
        if (this.f6714d) {
            return new a5(this.f6712b.entrySet().iterator());
        }
        return this.f6712b.entrySet().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e4) {
            return this.f6712b.equals(((e4) obj).f6712b);
        }
        return false;
    }

    public final void h(e4<T> e4Var) {
        for (int i2 = 0; i2 < e4Var.f6712b.n(); i2++) {
            n(e4Var.f6712b.g(i2));
        }
        for (Map.Entry<T, Object> entry : e4Var.f6712b.o()) {
            n(entry);
        }
    }

    public final int hashCode() {
        return this.f6712b.hashCode();
    }

    public final void q() {
        if (this.f6713c) {
            return;
        }
        this.f6712b.m();
        this.f6713c = true;
    }

    public final int s() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f6712b.n(); i3++) {
            i2 += o(this.f6712b.g(i3));
        }
        for (Map.Entry<T, Object> entry : this.f6712b.o()) {
            i2 += o(entry);
        }
        return i2;
    }

    private e4(boolean z) {
        this(n6.f(0));
        q();
    }

    private e4(n6<T, Object> n6Var) {
        this.f6712b = n6Var;
        q();
    }
}