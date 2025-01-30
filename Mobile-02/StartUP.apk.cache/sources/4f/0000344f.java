package com.google.android.gms.internal.p000firebaseperf;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.z5  reason: invalid package */
/* loaded from: classes2.dex */
final class z5<T> implements m6<T> {
    private static final int[] a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    private static final Unsafe f7006b = k7.y();

    /* renamed from: c  reason: collision with root package name */
    private final int[] f7007c;

    /* renamed from: d  reason: collision with root package name */
    private final Object[] f7008d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7009e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7010f;

    /* renamed from: g  reason: collision with root package name */
    private final v5 f7011g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f7012h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f7013i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f7014j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f7015k;

    /* renamed from: l  reason: collision with root package name */
    private final int[] f7016l;
    private final int m;
    private final int n;
    private final a6 o;
    private final f5 p;
    private final e7<?, ?> q;
    private final c4<?> r;
    private final o5 s;

    private z5(int[] iArr, Object[] objArr, int i2, int i3, v5 v5Var, boolean z, boolean z2, int[] iArr2, int i4, int i5, a6 a6Var, f5 f5Var, e7<?, ?> e7Var, c4<?> c4Var, o5 o5Var) {
        this.f7007c = iArr;
        this.f7008d = objArr;
        this.f7009e = i2;
        this.f7010f = i3;
        this.f7013i = v5Var instanceof m4;
        this.f7014j = z;
        this.f7012h = c4Var != null && c4Var.e(v5Var);
        this.f7015k = false;
        this.f7016l = iArr2;
        this.m = i4;
        this.n = i5;
        this.o = a6Var;
        this.p = f5Var;
        this.q = e7Var;
        this.r = c4Var;
        this.f7011g = v5Var;
        this.s = o5Var;
    }

    private final boolean A(T t, T t2, int i2) {
        return o(t, i2) == o(t2, i2);
    }

    private static List<?> B(Object obj, long j2) {
        return (List) k7.G(obj, j2);
    }

    private static <T> double C(T t, long j2) {
        return ((Double) k7.G(t, j2)).doubleValue();
    }

    private static <T> float D(T t, long j2) {
        return ((Float) k7.G(t, j2)).floatValue();
    }

    private static <T> int E(T t, long j2) {
        return ((Integer) k7.G(t, j2)).intValue();
    }

    private static <T> long F(T t, long j2) {
        return ((Long) k7.G(t, j2)).longValue();
    }

    private static <T> boolean G(T t, long j2) {
        return ((Boolean) k7.G(t, j2)).booleanValue();
    }

    private static <UT, UB> int h(e7<UT, UB> e7Var, T t) {
        return e7Var.f(e7Var.g(t));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0397  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> com.google.android.gms.internal.p000firebaseperf.z5<T> i(java.lang.Class<T> r33, com.google.android.gms.internal.p000firebaseperf.t5 r34, com.google.android.gms.internal.p000firebaseperf.a6 r35, com.google.android.gms.internal.p000firebaseperf.f5 r36, com.google.android.gms.internal.p000firebaseperf.e7<?, ?> r37, com.google.android.gms.internal.p000firebaseperf.c4<?> r38, com.google.android.gms.internal.p000firebaseperf.o5 r39) {
        /*
            Method dump skipped, instructions count: 1046
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.z5.i(java.lang.Class, com.google.android.gms.internal.firebase-perf.t5, com.google.android.gms.internal.firebase-perf.a6, com.google.android.gms.internal.firebase-perf.f5, com.google.android.gms.internal.firebase-perf.e7, com.google.android.gms.internal.firebase-perf.c4, com.google.android.gms.internal.firebase-perf.o5):com.google.android.gms.internal.firebase-perf.z5");
    }

    private static Field j(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private static void k(int i2, Object obj, y7 y7Var) throws IOException {
        if (obj instanceof String) {
            y7Var.m(i2, (String) obj);
        } else {
            y7Var.L(i2, (i3) obj);
        }
    }

    private static <UT, UB> void l(e7<UT, UB> e7Var, T t, y7 y7Var) throws IOException {
        e7Var.a(e7Var.g(t), y7Var);
    }

    private final <K, V> void m(y7 y7Var, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            y7Var.H(i2, this.s.a(t(i3)), this.s.e(obj));
        }
    }

    private final void n(T t, T t2, int i2) {
        long u = u(i2) & 1048575;
        if (o(t2, i2)) {
            Object G = k7.G(t, u);
            Object G2 = k7.G(t2, u);
            if (G != null && G2 != null) {
                k7.g(t, u, n4.f(G, G2));
                w(t, i2);
            } else if (G2 != null) {
                k7.g(t, u, G2);
                w(t, i2);
            }
        }
    }

    private final boolean o(T t, int i2) {
        int v = v(i2);
        long j2 = v & 1048575;
        if (j2 != 1048575) {
            return (k7.u(t, j2) & (1 << (v >>> 20))) != 0;
        }
        int u = u(i2);
        long j3 = u & 1048575;
        switch ((u & 267386880) >>> 20) {
            case 0:
                return k7.F(t, j3) != 0.0d;
            case 1:
                return k7.E(t, j3) != 0.0f;
            case 2:
                return k7.C(t, j3) != 0;
            case 3:
                return k7.C(t, j3) != 0;
            case 4:
                return k7.u(t, j3) != 0;
            case 5:
                return k7.C(t, j3) != 0;
            case 6:
                return k7.u(t, j3) != 0;
            case 7:
                return k7.D(t, j3);
            case 8:
                Object G = k7.G(t, j3);
                if (G instanceof String) {
                    return !((String) G).isEmpty();
                } else if (G instanceof i3) {
                    return !i3.a.equals(G);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return k7.G(t, j3) != null;
            case 10:
                return !i3.a.equals(k7.G(t, j3));
            case 11:
                return k7.u(t, j3) != 0;
            case 12:
                return k7.u(t, j3) != 0;
            case 13:
                return k7.u(t, j3) != 0;
            case 14:
                return k7.C(t, j3) != 0;
            case 15:
                return k7.u(t, j3) != 0;
            case 16:
                return k7.C(t, j3) != 0;
            case 17:
                return k7.G(t, j3) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean p(T t, int i2, int i3) {
        return k7.u(t, (long) (v(i3) & 1048575)) == i2;
    }

    private final boolean q(T t, int i2, int i3, int i4, int i5) {
        if (i3 == 1048575) {
            return o(t, i2);
        }
        return (i4 & i5) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean r(Object obj, int i2, m6 m6Var) {
        return m6Var.d(k7.G(obj, i2 & 1048575));
    }

    private final m6 s(int i2) {
        int i3 = (i2 / 3) << 1;
        m6 m6Var = (m6) this.f7008d[i3];
        if (m6Var != null) {
            return m6Var;
        }
        m6<T> a2 = h6.b().a((Class) this.f7008d[i3 + 1]);
        this.f7008d[i3] = a2;
        return a2;
    }

    private final Object t(int i2) {
        return this.f7008d[(i2 / 3) << 1];
    }

    private final int u(int i2) {
        return this.f7007c[i2 + 1];
    }

    private final int v(int i2) {
        return this.f7007c[i2 + 2];
    }

    private final void w(T t, int i2) {
        int v = v(i2);
        long j2 = 1048575 & v;
        if (j2 == 1048575) {
            return;
        }
        k7.e(t, j2, (1 << (v >>> 20)) | k7.u(t, j2));
    }

    private final void x(T t, int i2, int i3) {
        k7.e(t, v(i3) & 1048575, i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x048f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void y(T r18, com.google.android.gms.internal.p000firebaseperf.y7 r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.z5.y(java.lang.Object, com.google.android.gms.internal.firebase-perf.y7):void");
    }

    private final void z(T t, T t2, int i2) {
        int u = u(i2);
        int i3 = this.f7007c[i2];
        long j2 = u & 1048575;
        if (p(t2, i3, i2)) {
            Object G = k7.G(t, j2);
            Object G2 = k7.G(t2, j2);
            if (G != null && G2 != null) {
                k7.g(t, j2, n4.f(G, G2));
                x(t, i3, i2);
            } else if (G2 != null) {
                k7.g(t, j2, G2);
                x(t, i3, i2);
            }
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.m6
    public final void a(T t) {
        int i2;
        int i3 = this.m;
        while (true) {
            i2 = this.n;
            if (i3 >= i2) {
                break;
            }
            long u = u(this.f7016l[i3]) & 1048575;
            Object G = k7.G(t, u);
            if (G != null) {
                k7.g(t, u, this.s.b(G));
            }
            i3++;
        }
        int length = this.f7016l.length;
        while (i2 < length) {
            this.p.a(t, this.f7016l[i2]);
            i2++;
        }
        this.q.c(t);
        if (this.f7012h) {
            this.r.f(t);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0a2a  */
    @Override // com.google.android.gms.internal.p000firebaseperf.m6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(T r14, com.google.android.gms.internal.p000firebaseperf.y7 r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2916
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.z5.b(java.lang.Object, com.google.android.gms.internal.firebase-perf.y7):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.p000firebaseperf.m6
    public final int c(T t) {
        int i2;
        int i3;
        int i4;
        boolean z;
        long j2;
        int f0;
        int R;
        int z0;
        int i5;
        int Z;
        int M;
        int F0;
        int r;
        int L;
        int M2;
        int F02;
        int r2;
        int i6 = 267386880;
        int i7 = 0;
        if (this.f7014j) {
            Unsafe unsafe = f7006b;
            int i8 = 0;
            int i9 = 0;
            while (i8 < this.f7007c.length) {
                int u = u(i8);
                int i10 = (u & i6) >>> 20;
                int i11 = this.f7007c[i8];
                long j3 = u & 1048575;
                int i12 = (i10 < j4.N.h() || i10 > j4.a0.h()) ? 0 : this.f7007c[i8 + 2] & 1048575;
                switch (i10) {
                    case 0:
                        if (o(t, i8)) {
                            L = zzev.L(i11, 0.0d);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 1:
                        if (o(t, i8)) {
                            L = zzev.M(i11, 0.0f);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 2:
                        if (o(t, i8)) {
                            L = zzev.f0(i11, k7.C(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 3:
                        if (o(t, i8)) {
                            L = zzev.i0(i11, k7.C(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 4:
                        if (o(t, i8)) {
                            L = zzev.v0(i11, k7.u(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 5:
                        if (o(t, i8)) {
                            L = zzev.n0(i11, 0L);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 6:
                        if (o(t, i8)) {
                            L = zzev.y0(i11, 0);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 7:
                        if (o(t, i8)) {
                            L = zzev.R(i11, true);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 8:
                        if (o(t, i8)) {
                            Object G = k7.G(t, j3);
                            if (G instanceof i3) {
                                L = zzev.a0(i11, (i3) G);
                                break;
                            } else {
                                L = zzev.Q(i11, (String) G);
                                break;
                            }
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 9:
                        if (o(t, i8)) {
                            L = o6.j(i11, k7.G(t, j3), s(i8));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 10:
                        if (o(t, i8)) {
                            L = zzev.a0(i11, (i3) k7.G(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 11:
                        if (o(t, i8)) {
                            L = zzev.w0(i11, k7.u(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 12:
                        if (o(t, i8)) {
                            L = zzev.A0(i11, k7.u(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 13:
                        if (o(t, i8)) {
                            L = zzev.z0(i11, 0);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 14:
                        if (o(t, i8)) {
                            L = zzev.t0(i11, 0L);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 15:
                        if (o(t, i8)) {
                            L = zzev.x0(i11, k7.u(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 16:
                        if (o(t, i8)) {
                            L = zzev.k0(i11, k7.C(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 17:
                        if (o(t, i8)) {
                            L = zzev.b0(i11, (v5) k7.G(t, j3), s(i8));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 18:
                        L = o6.a0(i11, B(t, j3), false);
                        break;
                    case 19:
                        L = o6.Z(i11, B(t, j3), false);
                        break;
                    case 20:
                        L = o6.S(i11, B(t, j3), false);
                        break;
                    case 21:
                        L = o6.T(i11, B(t, j3), false);
                        break;
                    case 22:
                        L = o6.W(i11, B(t, j3), false);
                        break;
                    case 23:
                        L = o6.a0(i11, B(t, j3), false);
                        break;
                    case 24:
                        L = o6.Z(i11, B(t, j3), false);
                        break;
                    case 25:
                        L = o6.b0(i11, B(t, j3), false);
                        break;
                    case 26:
                        L = o6.k(i11, B(t, j3));
                        break;
                    case 27:
                        L = o6.l(i11, B(t, j3), s(i8));
                        break;
                    case 28:
                        L = o6.o(i11, B(t, j3));
                        break;
                    case 29:
                        L = o6.X(i11, B(t, j3), false);
                        break;
                    case 30:
                        L = o6.V(i11, B(t, j3), false);
                        break;
                    case 31:
                        L = o6.Z(i11, B(t, j3), false);
                        break;
                    case 32:
                        L = o6.a0(i11, B(t, j3), false);
                        break;
                    case 33:
                        L = o6.Y(i11, B(t, j3), false);
                        break;
                    case 34:
                        L = o6.U(i11, B(t, j3), false);
                        break;
                    case 35:
                        M2 = o6.M((List) unsafe.getObject(t, j3));
                        if (M2 > 0) {
                            if (this.f7015k) {
                                unsafe.putInt(t, i12, M2);
                            }
                            F02 = zzev.F0(i11);
                            r2 = zzev.r(M2);
                            L = F02 + r2 + M2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 36:
                        M2 = o6.H((List) unsafe.getObject(t, j3));
                        if (M2 > 0) {
                            if (this.f7015k) {
                                unsafe.putInt(t, i12, M2);
                            }
                            F02 = zzev.F0(i11);
                            r2 = zzev.r(M2);
                            L = F02 + r2 + M2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 37:
                        M2 = o6.m((List) unsafe.getObject(t, j3));
                        if (M2 > 0) {
                            if (this.f7015k) {
                                unsafe.putInt(t, i12, M2);
                            }
                            F02 = zzev.F0(i11);
                            r2 = zzev.r(M2);
                            L = F02 + r2 + M2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 38:
                        M2 = o6.q((List) unsafe.getObject(t, j3));
                        if (M2 > 0) {
                            if (this.f7015k) {
                                unsafe.putInt(t, i12, M2);
                            }
                            F02 = zzev.F0(i11);
                            r2 = zzev.r(M2);
                            L = F02 + r2 + M2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 39:
                        M2 = o6.y((List) unsafe.getObject(t, j3));
                        if (M2 > 0) {
                            if (this.f7015k) {
                                unsafe.putInt(t, i12, M2);
                            }
                            F02 = zzev.F0(i11);
                            r2 = zzev.r(M2);
                            L = F02 + r2 + M2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 40:
                        M2 = o6.M((List) unsafe.getObject(t, j3));
                        if (M2 > 0) {
                            if (this.f7015k) {
                                unsafe.putInt(t, i12, M2);
                            }
                            F02 = zzev.F0(i11);
                            r2 = zzev.r(M2);
                            L = F02 + r2 + M2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 41:
                        M2 = o6.H((List) unsafe.getObject(t, j3));
                        if (M2 > 0) {
                            if (this.f7015k) {
                                unsafe.putInt(t, i12, M2);
                            }
                            F02 = zzev.F0(i11);
                            r2 = zzev.r(M2);
                            L = F02 + r2 + M2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 42:
                        M2 = o6.O((List) unsafe.getObject(t, j3));
                        if (M2 > 0) {
                            if (this.f7015k) {
                                unsafe.putInt(t, i12, M2);
                            }
                            F02 = zzev.F0(i11);
                            r2 = zzev.r(M2);
                            L = F02 + r2 + M2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 43:
                        M2 = o6.A((List) unsafe.getObject(t, j3));
                        if (M2 > 0) {
                            if (this.f7015k) {
                                unsafe.putInt(t, i12, M2);
                            }
                            F02 = zzev.F0(i11);
                            r2 = zzev.r(M2);
                            L = F02 + r2 + M2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 44:
                        M2 = o6.v((List) unsafe.getObject(t, j3));
                        if (M2 > 0) {
                            if (this.f7015k) {
                                unsafe.putInt(t, i12, M2);
                            }
                            F02 = zzev.F0(i11);
                            r2 = zzev.r(M2);
                            L = F02 + r2 + M2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 45:
                        M2 = o6.H((List) unsafe.getObject(t, j3));
                        if (M2 > 0) {
                            if (this.f7015k) {
                                unsafe.putInt(t, i12, M2);
                            }
                            F02 = zzev.F0(i11);
                            r2 = zzev.r(M2);
                            L = F02 + r2 + M2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 46:
                        M2 = o6.M((List) unsafe.getObject(t, j3));
                        if (M2 > 0) {
                            if (this.f7015k) {
                                unsafe.putInt(t, i12, M2);
                            }
                            F02 = zzev.F0(i11);
                            r2 = zzev.r(M2);
                            L = F02 + r2 + M2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 47:
                        M2 = o6.C((List) unsafe.getObject(t, j3));
                        if (M2 > 0) {
                            if (this.f7015k) {
                                unsafe.putInt(t, i12, M2);
                            }
                            F02 = zzev.F0(i11);
                            r2 = zzev.r(M2);
                            L = F02 + r2 + M2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 48:
                        M2 = o6.s((List) unsafe.getObject(t, j3));
                        if (M2 > 0) {
                            if (this.f7015k) {
                                unsafe.putInt(t, i12, M2);
                            }
                            F02 = zzev.F0(i11);
                            r2 = zzev.r(M2);
                            L = F02 + r2 + M2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 49:
                        L = o6.p(i11, B(t, j3), s(i8));
                        break;
                    case 50:
                        L = this.s.d(i11, k7.G(t, j3), t(i8));
                        break;
                    case 51:
                        if (p(t, i11, i8)) {
                            L = zzev.L(i11, 0.0d);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 52:
                        if (p(t, i11, i8)) {
                            L = zzev.M(i11, 0.0f);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 53:
                        if (p(t, i11, i8)) {
                            L = zzev.f0(i11, F(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 54:
                        if (p(t, i11, i8)) {
                            L = zzev.i0(i11, F(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 55:
                        if (p(t, i11, i8)) {
                            L = zzev.v0(i11, E(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 56:
                        if (p(t, i11, i8)) {
                            L = zzev.n0(i11, 0L);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 57:
                        if (p(t, i11, i8)) {
                            L = zzev.y0(i11, 0);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 58:
                        if (p(t, i11, i8)) {
                            L = zzev.R(i11, true);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 59:
                        if (p(t, i11, i8)) {
                            Object G2 = k7.G(t, j3);
                            if (G2 instanceof i3) {
                                L = zzev.a0(i11, (i3) G2);
                                break;
                            } else {
                                L = zzev.Q(i11, (String) G2);
                                break;
                            }
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 60:
                        if (p(t, i11, i8)) {
                            L = o6.j(i11, k7.G(t, j3), s(i8));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 61:
                        if (p(t, i11, i8)) {
                            L = zzev.a0(i11, (i3) k7.G(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 62:
                        if (p(t, i11, i8)) {
                            L = zzev.w0(i11, E(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 63:
                        if (p(t, i11, i8)) {
                            L = zzev.A0(i11, E(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 64:
                        if (p(t, i11, i8)) {
                            L = zzev.z0(i11, 0);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 65:
                        if (p(t, i11, i8)) {
                            L = zzev.t0(i11, 0L);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 66:
                        if (p(t, i11, i8)) {
                            L = zzev.x0(i11, E(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 67:
                        if (p(t, i11, i8)) {
                            L = zzev.k0(i11, F(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 68:
                        if (p(t, i11, i8)) {
                            L = zzev.b0(i11, (v5) k7.G(t, j3), s(i8));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    default:
                        i8 += 3;
                        i6 = 267386880;
                }
                i9 += L;
                i8 += 3;
                i6 = 267386880;
            }
            return i9 + h(this.q, t);
        }
        Unsafe unsafe2 = f7006b;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (i14 < this.f7007c.length) {
            int u2 = u(i14);
            int[] iArr = this.f7007c;
            int i17 = iArr[i14];
            int i18 = (u2 & 267386880) >>> 20;
            if (i18 <= 17) {
                int i19 = iArr[i14 + 2];
                int i20 = i19 & 1048575;
                i3 = 1 << (i19 >>> 20);
                if (i20 != i13) {
                    i16 = unsafe2.getInt(t, i20);
                    i13 = i20;
                }
                i2 = i19;
            } else {
                i2 = (!this.f7015k || i18 < j4.N.h() || i18 > j4.a0.h()) ? 0 : this.f7007c[i14 + 2] & 1048575;
                i3 = 0;
            }
            long j4 = u2 & 1048575;
            switch (i18) {
                case 0:
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    if ((i16 & i3) != 0) {
                        i15 += zzev.L(i17, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    i4 = 0;
                    j2 = 0;
                    if ((i16 & i3) != 0) {
                        z = false;
                        i15 += zzev.M(i17, 0.0f);
                        break;
                    }
                    z = false;
                case 2:
                    i4 = 0;
                    j2 = 0;
                    if ((i16 & i3) != 0) {
                        f0 = zzev.f0(i17, unsafe2.getLong(t, j4));
                        i15 += f0;
                    }
                    z = false;
                    break;
                case 3:
                    i4 = 0;
                    j2 = 0;
                    if ((i16 & i3) != 0) {
                        f0 = zzev.i0(i17, unsafe2.getLong(t, j4));
                        i15 += f0;
                    }
                    z = false;
                    break;
                case 4:
                    i4 = 0;
                    j2 = 0;
                    if ((i16 & i3) != 0) {
                        f0 = zzev.v0(i17, unsafe2.getInt(t, j4));
                        i15 += f0;
                    }
                    z = false;
                    break;
                case 5:
                    i4 = 0;
                    j2 = 0;
                    if ((i16 & i3) != 0) {
                        f0 = zzev.n0(i17, 0L);
                        i15 += f0;
                    }
                    z = false;
                    break;
                case 6:
                    if ((i16 & i3) != 0) {
                        i4 = 0;
                        i15 += zzev.y0(i17, 0);
                        z = false;
                        j2 = 0;
                        break;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                case 7:
                    if ((i16 & i3) != 0) {
                        R = zzev.R(i17, true);
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 8:
                    if ((i16 & i3) != 0) {
                        Object object = unsafe2.getObject(t, j4);
                        if (object instanceof i3) {
                            R = zzev.a0(i17, (i3) object);
                        } else {
                            R = zzev.Q(i17, (String) object);
                        }
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 9:
                    if ((i16 & i3) != 0) {
                        R = o6.j(i17, unsafe2.getObject(t, j4), s(i14));
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 10:
                    if ((i16 & i3) != 0) {
                        R = zzev.a0(i17, (i3) unsafe2.getObject(t, j4));
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 11:
                    if ((i16 & i3) != 0) {
                        R = zzev.w0(i17, unsafe2.getInt(t, j4));
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 12:
                    if ((i16 & i3) != 0) {
                        R = zzev.A0(i17, unsafe2.getInt(t, j4));
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 13:
                    if ((i16 & i3) != 0) {
                        z0 = zzev.z0(i17, 0);
                        i15 += z0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 14:
                    if ((i16 & i3) != 0) {
                        R = zzev.t0(i17, 0L);
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 15:
                    if ((i16 & i3) != 0) {
                        R = zzev.x0(i17, unsafe2.getInt(t, j4));
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 16:
                    if ((i16 & i3) != 0) {
                        R = zzev.k0(i17, unsafe2.getLong(t, j4));
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 17:
                    if ((i16 & i3) != 0) {
                        R = zzev.b0(i17, (v5) unsafe2.getObject(t, j4), s(i14));
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 18:
                    R = o6.a0(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += R;
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 19:
                    i5 = 0;
                    Z = o6.Z(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += Z;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 20:
                    i5 = 0;
                    Z = o6.S(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += Z;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 21:
                    i5 = 0;
                    Z = o6.T(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += Z;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 22:
                    i5 = 0;
                    Z = o6.W(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += Z;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 23:
                    i5 = 0;
                    Z = o6.a0(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += Z;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 24:
                    i5 = 0;
                    Z = o6.Z(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += Z;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 25:
                    i5 = 0;
                    Z = o6.b0(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += Z;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 26:
                    R = o6.k(i17, (List) unsafe2.getObject(t, j4));
                    i15 += R;
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 27:
                    R = o6.l(i17, (List) unsafe2.getObject(t, j4), s(i14));
                    i15 += R;
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 28:
                    R = o6.o(i17, (List) unsafe2.getObject(t, j4));
                    i15 += R;
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 29:
                    R = o6.X(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += R;
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 30:
                    i5 = 0;
                    Z = o6.V(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += Z;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 31:
                    i5 = 0;
                    Z = o6.Z(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += Z;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 32:
                    i5 = 0;
                    Z = o6.a0(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += Z;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 33:
                    i5 = 0;
                    Z = o6.Y(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += Z;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 34:
                    i5 = 0;
                    Z = o6.U(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += Z;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 35:
                    M = o6.M((List) unsafe2.getObject(t, j4));
                    if (M > 0) {
                        if (this.f7015k) {
                            unsafe2.putInt(t, i2, M);
                        }
                        F0 = zzev.F0(i17);
                        r = zzev.r(M);
                        z0 = F0 + r + M;
                        i15 += z0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 36:
                    M = o6.H((List) unsafe2.getObject(t, j4));
                    if (M > 0) {
                        if (this.f7015k) {
                            unsafe2.putInt(t, i2, M);
                        }
                        F0 = zzev.F0(i17);
                        r = zzev.r(M);
                        z0 = F0 + r + M;
                        i15 += z0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 37:
                    M = o6.m((List) unsafe2.getObject(t, j4));
                    if (M > 0) {
                        if (this.f7015k) {
                            unsafe2.putInt(t, i2, M);
                        }
                        F0 = zzev.F0(i17);
                        r = zzev.r(M);
                        z0 = F0 + r + M;
                        i15 += z0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 38:
                    M = o6.q((List) unsafe2.getObject(t, j4));
                    if (M > 0) {
                        if (this.f7015k) {
                            unsafe2.putInt(t, i2, M);
                        }
                        F0 = zzev.F0(i17);
                        r = zzev.r(M);
                        z0 = F0 + r + M;
                        i15 += z0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 39:
                    M = o6.y((List) unsafe2.getObject(t, j4));
                    if (M > 0) {
                        if (this.f7015k) {
                            unsafe2.putInt(t, i2, M);
                        }
                        F0 = zzev.F0(i17);
                        r = zzev.r(M);
                        z0 = F0 + r + M;
                        i15 += z0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 40:
                    M = o6.M((List) unsafe2.getObject(t, j4));
                    if (M > 0) {
                        if (this.f7015k) {
                            unsafe2.putInt(t, i2, M);
                        }
                        F0 = zzev.F0(i17);
                        r = zzev.r(M);
                        z0 = F0 + r + M;
                        i15 += z0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 41:
                    M = o6.H((List) unsafe2.getObject(t, j4));
                    if (M > 0) {
                        if (this.f7015k) {
                            unsafe2.putInt(t, i2, M);
                        }
                        F0 = zzev.F0(i17);
                        r = zzev.r(M);
                        z0 = F0 + r + M;
                        i15 += z0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 42:
                    M = o6.O((List) unsafe2.getObject(t, j4));
                    if (M > 0) {
                        if (this.f7015k) {
                            unsafe2.putInt(t, i2, M);
                        }
                        F0 = zzev.F0(i17);
                        r = zzev.r(M);
                        z0 = F0 + r + M;
                        i15 += z0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 43:
                    M = o6.A((List) unsafe2.getObject(t, j4));
                    if (M > 0) {
                        if (this.f7015k) {
                            unsafe2.putInt(t, i2, M);
                        }
                        F0 = zzev.F0(i17);
                        r = zzev.r(M);
                        z0 = F0 + r + M;
                        i15 += z0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 44:
                    M = o6.v((List) unsafe2.getObject(t, j4));
                    if (M > 0) {
                        if (this.f7015k) {
                            unsafe2.putInt(t, i2, M);
                        }
                        F0 = zzev.F0(i17);
                        r = zzev.r(M);
                        z0 = F0 + r + M;
                        i15 += z0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 45:
                    M = o6.H((List) unsafe2.getObject(t, j4));
                    if (M > 0) {
                        if (this.f7015k) {
                            unsafe2.putInt(t, i2, M);
                        }
                        F0 = zzev.F0(i17);
                        r = zzev.r(M);
                        z0 = F0 + r + M;
                        i15 += z0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 46:
                    M = o6.M((List) unsafe2.getObject(t, j4));
                    if (M > 0) {
                        if (this.f7015k) {
                            unsafe2.putInt(t, i2, M);
                        }
                        F0 = zzev.F0(i17);
                        r = zzev.r(M);
                        z0 = F0 + r + M;
                        i15 += z0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 47:
                    M = o6.C((List) unsafe2.getObject(t, j4));
                    if (M > 0) {
                        if (this.f7015k) {
                            unsafe2.putInt(t, i2, M);
                        }
                        F0 = zzev.F0(i17);
                        r = zzev.r(M);
                        z0 = F0 + r + M;
                        i15 += z0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 48:
                    M = o6.s((List) unsafe2.getObject(t, j4));
                    if (M > 0) {
                        if (this.f7015k) {
                            unsafe2.putInt(t, i2, M);
                        }
                        F0 = zzev.F0(i17);
                        r = zzev.r(M);
                        z0 = F0 + r + M;
                        i15 += z0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 49:
                    R = o6.p(i17, (List) unsafe2.getObject(t, j4), s(i14));
                    i15 += R;
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 50:
                    R = this.s.d(i17, unsafe2.getObject(t, j4), t(i14));
                    i15 += R;
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 51:
                    if (p(t, i17, i14)) {
                        R = zzev.L(i17, 0.0d);
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 52:
                    if (p(t, i17, i14)) {
                        z0 = zzev.M(i17, 0.0f);
                        i15 += z0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 53:
                    if (p(t, i17, i14)) {
                        R = zzev.f0(i17, F(t, j4));
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 54:
                    if (p(t, i17, i14)) {
                        R = zzev.i0(i17, F(t, j4));
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 55:
                    if (p(t, i17, i14)) {
                        R = zzev.v0(i17, E(t, j4));
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 56:
                    if (p(t, i17, i14)) {
                        R = zzev.n0(i17, 0L);
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 57:
                    if (p(t, i17, i14)) {
                        z0 = zzev.y0(i17, 0);
                        i15 += z0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 58:
                    if (p(t, i17, i14)) {
                        R = zzev.R(i17, true);
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 59:
                    if (p(t, i17, i14)) {
                        Object object2 = unsafe2.getObject(t, j4);
                        if (object2 instanceof i3) {
                            R = zzev.a0(i17, (i3) object2);
                        } else {
                            R = zzev.Q(i17, (String) object2);
                        }
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 60:
                    if (p(t, i17, i14)) {
                        R = o6.j(i17, unsafe2.getObject(t, j4), s(i14));
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 61:
                    if (p(t, i17, i14)) {
                        R = zzev.a0(i17, (i3) unsafe2.getObject(t, j4));
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 62:
                    if (p(t, i17, i14)) {
                        R = zzev.w0(i17, E(t, j4));
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 63:
                    if (p(t, i17, i14)) {
                        R = zzev.A0(i17, E(t, j4));
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 64:
                    if (p(t, i17, i14)) {
                        z0 = zzev.z0(i17, 0);
                        i15 += z0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 65:
                    if (p(t, i17, i14)) {
                        R = zzev.t0(i17, 0L);
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 66:
                    if (p(t, i17, i14)) {
                        R = zzev.x0(i17, E(t, j4));
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 67:
                    if (p(t, i17, i14)) {
                        R = zzev.k0(i17, F(t, j4));
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 68:
                    if (p(t, i17, i14)) {
                        R = zzev.b0(i17, (v5) unsafe2.getObject(t, j4), s(i14));
                        i15 += R;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                default:
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
            }
            i14 += 3;
            i7 = i4;
        }
        int i21 = i7;
        int h2 = i15 + h(this.q, t);
        if (this.f7012h) {
            e4<?> c2 = this.r.c(t);
            for (int i22 = i21; i22 < c2.f6712b.n(); i22++) {
                Map.Entry<?, Object> g2 = c2.f6712b.g(i22);
                i21 += e4.k((g4) g2.getKey(), g2.getValue());
            }
            for (Map.Entry<?, Object> entry : c2.f6712b.o()) {
                i21 += e4.k((g4) entry.getKey(), entry.getValue());
            }
            return h2 + i21;
        }
        return h2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.firebase-perf.m6] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.firebase-perf.m6] */
    @Override // com.google.android.gms.internal.p000firebaseperf.m6
    public final boolean d(T t) {
        int i2;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean z = true;
            if (i6 >= this.m) {
                return !this.f7012h || this.r.c(t).c();
            }
            int i7 = this.f7016l[i6];
            int i8 = this.f7007c[i7];
            int u = u(i7);
            int i9 = this.f7007c[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = f7006b.getInt(t, i10);
                }
                i3 = i5;
                i2 = i10;
            } else {
                i2 = i4;
                i3 = i5;
            }
            if (((268435456 & u) != 0) && !q(t, i7, i2, i3, i11)) {
                return false;
            }
            int i12 = (267386880 & u) >>> 20;
            if (i12 != 9 && i12 != 17) {
                if (i12 != 27) {
                    if (i12 == 60 || i12 == 68) {
                        if (p(t, i8, i7) && !r(t, u, s(i7))) {
                            return false;
                        }
                    } else if (i12 != 49) {
                        if (i12 != 50) {
                            continue;
                        } else {
                            Map<?, ?> e2 = this.s.e(k7.G(t, u & 1048575));
                            if (!e2.isEmpty()) {
                                if (this.s.a(t(i7)).f6834c.h() == v7.MESSAGE) {
                                    m6<T> m6Var = 0;
                                    Iterator<?> it = e2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (m6Var == null) {
                                            m6Var = h6.b().a(next.getClass());
                                        }
                                        boolean d2 = m6Var.d(next);
                                        m6Var = m6Var;
                                        if (!d2) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) k7.G(t, u & 1048575);
                if (!list.isEmpty()) {
                    ?? s = s(i7);
                    int i13 = 0;
                    while (true) {
                        if (i13 >= list.size()) {
                            break;
                        } else if (!s.d(list.get(i13))) {
                            z = false;
                            break;
                        } else {
                            i13++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (q(t, i7, i2, i3, i11) && !r(t, u, s(i7))) {
                return false;
            }
            i6++;
            i4 = i2;
            i5 = i3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.p000firebaseperf.k7.F(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.p000firebaseperf.k7.F(r11, r6))) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.o6.u(com.google.android.gms.internal.p000firebaseperf.k7.G(r10, r6), com.google.android.gms.internal.p000firebaseperf.k7.G(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.o6.u(com.google.android.gms.internal.p000firebaseperf.k7.G(r10, r6), com.google.android.gms.internal.p000firebaseperf.k7.G(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.k7.C(r10, r6) == com.google.android.gms.internal.p000firebaseperf.k7.C(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.k7.u(r10, r6) == com.google.android.gms.internal.p000firebaseperf.k7.u(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a4, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.k7.C(r10, r6) == com.google.android.gms.internal.p000firebaseperf.k7.C(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.k7.u(r10, r6) == com.google.android.gms.internal.p000firebaseperf.k7.u(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c8, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.k7.u(r10, r6) == com.google.android.gms.internal.p000firebaseperf.k7.u(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00da, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.k7.u(r10, r6) == com.google.android.gms.internal.p000firebaseperf.k7.u(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f0, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.o6.u(com.google.android.gms.internal.p000firebaseperf.k7.G(r10, r6), com.google.android.gms.internal.p000firebaseperf.k7.G(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0106, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.o6.u(com.google.android.gms.internal.p000firebaseperf.k7.G(r10, r6), com.google.android.gms.internal.p000firebaseperf.k7.G(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011c, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.o6.u(com.google.android.gms.internal.p000firebaseperf.k7.G(r10, r6), com.google.android.gms.internal.p000firebaseperf.k7.G(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x012e, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.k7.D(r10, r6) == com.google.android.gms.internal.p000firebaseperf.k7.D(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0140, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.k7.u(r10, r6) == com.google.android.gms.internal.p000firebaseperf.k7.u(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0154, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.k7.C(r10, r6) == com.google.android.gms.internal.p000firebaseperf.k7.C(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0165, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.k7.u(r10, r6) == com.google.android.gms.internal.p000firebaseperf.k7.u(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0178, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.k7.C(r10, r6) == com.google.android.gms.internal.p000firebaseperf.k7.C(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x018b, code lost:
        if (com.google.android.gms.internal.p000firebaseperf.k7.C(r10, r6) == com.google.android.gms.internal.p000firebaseperf.k7.C(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.p000firebaseperf.k7.E(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.p000firebaseperf.k7.E(r11, r6))) goto L85;
     */
    @Override // com.google.android.gms.internal.p000firebaseperf.m6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean e(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.z5.e(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.m6
    public final int f(T t) {
        int i2;
        int e2;
        int length = this.f7007c.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int u = u(i4);
            int i5 = this.f7007c[i4];
            long j2 = 1048575 & u;
            int i6 = 37;
            switch ((u & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    e2 = n4.e(Double.doubleToLongBits(k7.F(t, j2)));
                    i3 = i2 + e2;
                    break;
                case 1:
                    i2 = i3 * 53;
                    e2 = Float.floatToIntBits(k7.E(t, j2));
                    i3 = i2 + e2;
                    break;
                case 2:
                    i2 = i3 * 53;
                    e2 = n4.e(k7.C(t, j2));
                    i3 = i2 + e2;
                    break;
                case 3:
                    i2 = i3 * 53;
                    e2 = n4.e(k7.C(t, j2));
                    i3 = i2 + e2;
                    break;
                case 4:
                    i2 = i3 * 53;
                    e2 = k7.u(t, j2);
                    i3 = i2 + e2;
                    break;
                case 5:
                    i2 = i3 * 53;
                    e2 = n4.e(k7.C(t, j2));
                    i3 = i2 + e2;
                    break;
                case 6:
                    i2 = i3 * 53;
                    e2 = k7.u(t, j2);
                    i3 = i2 + e2;
                    break;
                case 7:
                    i2 = i3 * 53;
                    e2 = n4.j(k7.D(t, j2));
                    i3 = i2 + e2;
                    break;
                case 8:
                    i2 = i3 * 53;
                    e2 = ((String) k7.G(t, j2)).hashCode();
                    i3 = i2 + e2;
                    break;
                case 9:
                    Object G = k7.G(t, j2);
                    if (G != null) {
                        i6 = G.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    e2 = k7.G(t, j2).hashCode();
                    i3 = i2 + e2;
                    break;
                case 11:
                    i2 = i3 * 53;
                    e2 = k7.u(t, j2);
                    i3 = i2 + e2;
                    break;
                case 12:
                    i2 = i3 * 53;
                    e2 = k7.u(t, j2);
                    i3 = i2 + e2;
                    break;
                case 13:
                    i2 = i3 * 53;
                    e2 = k7.u(t, j2);
                    i3 = i2 + e2;
                    break;
                case 14:
                    i2 = i3 * 53;
                    e2 = n4.e(k7.C(t, j2));
                    i3 = i2 + e2;
                    break;
                case 15:
                    i2 = i3 * 53;
                    e2 = k7.u(t, j2);
                    i3 = i2 + e2;
                    break;
                case 16:
                    i2 = i3 * 53;
                    e2 = n4.e(k7.C(t, j2));
                    i3 = i2 + e2;
                    break;
                case 17:
                    Object G2 = k7.G(t, j2);
                    if (G2 != null) {
                        i6 = G2.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i2 = i3 * 53;
                    e2 = k7.G(t, j2).hashCode();
                    i3 = i2 + e2;
                    break;
                case 50:
                    i2 = i3 * 53;
                    e2 = k7.G(t, j2).hashCode();
                    i3 = i2 + e2;
                    break;
                case 51:
                    if (p(t, i5, i4)) {
                        i2 = i3 * 53;
                        e2 = n4.e(Double.doubleToLongBits(C(t, j2)));
                        i3 = i2 + e2;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (p(t, i5, i4)) {
                        i2 = i3 * 53;
                        e2 = Float.floatToIntBits(D(t, j2));
                        i3 = i2 + e2;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (p(t, i5, i4)) {
                        i2 = i3 * 53;
                        e2 = n4.e(F(t, j2));
                        i3 = i2 + e2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (p(t, i5, i4)) {
                        i2 = i3 * 53;
                        e2 = n4.e(F(t, j2));
                        i3 = i2 + e2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (p(t, i5, i4)) {
                        i2 = i3 * 53;
                        e2 = E(t, j2);
                        i3 = i2 + e2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (p(t, i5, i4)) {
                        i2 = i3 * 53;
                        e2 = n4.e(F(t, j2));
                        i3 = i2 + e2;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (p(t, i5, i4)) {
                        i2 = i3 * 53;
                        e2 = E(t, j2);
                        i3 = i2 + e2;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (p(t, i5, i4)) {
                        i2 = i3 * 53;
                        e2 = n4.j(G(t, j2));
                        i3 = i2 + e2;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (p(t, i5, i4)) {
                        i2 = i3 * 53;
                        e2 = ((String) k7.G(t, j2)).hashCode();
                        i3 = i2 + e2;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (p(t, i5, i4)) {
                        i2 = i3 * 53;
                        e2 = k7.G(t, j2).hashCode();
                        i3 = i2 + e2;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (p(t, i5, i4)) {
                        i2 = i3 * 53;
                        e2 = k7.G(t, j2).hashCode();
                        i3 = i2 + e2;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (p(t, i5, i4)) {
                        i2 = i3 * 53;
                        e2 = E(t, j2);
                        i3 = i2 + e2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (p(t, i5, i4)) {
                        i2 = i3 * 53;
                        e2 = E(t, j2);
                        i3 = i2 + e2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (p(t, i5, i4)) {
                        i2 = i3 * 53;
                        e2 = E(t, j2);
                        i3 = i2 + e2;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (p(t, i5, i4)) {
                        i2 = i3 * 53;
                        e2 = n4.e(F(t, j2));
                        i3 = i2 + e2;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (p(t, i5, i4)) {
                        i2 = i3 * 53;
                        e2 = E(t, j2);
                        i3 = i2 + e2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (p(t, i5, i4)) {
                        i2 = i3 * 53;
                        e2 = n4.e(F(t, j2));
                        i3 = i2 + e2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (p(t, i5, i4)) {
                        i2 = i3 * 53;
                        e2 = k7.G(t, j2).hashCode();
                        i3 = i2 + e2;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.q.g(t).hashCode();
        return this.f7012h ? (hashCode * 53) + this.r.c(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.m6
    public final void g(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i2 = 0; i2 < this.f7007c.length; i2 += 3) {
            int u = u(i2);
            long j2 = 1048575 & u;
            int i3 = this.f7007c[i2];
            switch ((u & 267386880) >>> 20) {
                case 0:
                    if (o(t2, i2)) {
                        k7.c(t, j2, k7.F(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (o(t2, i2)) {
                        k7.d(t, j2, k7.E(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (o(t2, i2)) {
                        k7.f(t, j2, k7.C(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (o(t2, i2)) {
                        k7.f(t, j2, k7.C(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (o(t2, i2)) {
                        k7.e(t, j2, k7.u(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (o(t2, i2)) {
                        k7.f(t, j2, k7.C(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (o(t2, i2)) {
                        k7.e(t, j2, k7.u(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (o(t2, i2)) {
                        k7.h(t, j2, k7.D(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (o(t2, i2)) {
                        k7.g(t, j2, k7.G(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    n(t, t2, i2);
                    break;
                case 10:
                    if (o(t2, i2)) {
                        k7.g(t, j2, k7.G(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (o(t2, i2)) {
                        k7.e(t, j2, k7.u(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (o(t2, i2)) {
                        k7.e(t, j2, k7.u(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (o(t2, i2)) {
                        k7.e(t, j2, k7.u(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (o(t2, i2)) {
                        k7.f(t, j2, k7.C(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (o(t2, i2)) {
                        k7.e(t, j2, k7.u(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (o(t2, i2)) {
                        k7.f(t, j2, k7.C(t2, j2));
                        w(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    n(t, t2, i2);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.p.b(t, t2, j2);
                    break;
                case 50:
                    o6.e(this.s, t, t2, j2);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (p(t2, i3, i2)) {
                        k7.g(t, j2, k7.G(t2, j2));
                        x(t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    z(t, t2, i2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (p(t2, i3, i2)) {
                        k7.g(t, j2, k7.G(t2, j2));
                        x(t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    z(t, t2, i2);
                    break;
            }
        }
        o6.f(this.q, t, t2);
        if (this.f7012h) {
            o6.d(this.r, t, t2);
        }
    }
}