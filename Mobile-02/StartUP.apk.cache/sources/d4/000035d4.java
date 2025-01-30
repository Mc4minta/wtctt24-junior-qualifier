package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class y5<T> implements m6<T> {
    private static final int[] a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    private static final Unsafe f7429b = j7.t();

    /* renamed from: c  reason: collision with root package name */
    private final int[] f7430c;

    /* renamed from: d  reason: collision with root package name */
    private final Object[] f7431d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7432e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7433f;

    /* renamed from: g  reason: collision with root package name */
    private final u5 f7434g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f7435h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f7436i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f7437j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f7438k;

    /* renamed from: l  reason: collision with root package name */
    private final int[] f7439l;
    private final int m;
    private final int n;
    private final b6 o;
    private final d5 p;
    private final d7<?, ?> q;
    private final b4<?> r;
    private final r5 s;

    private y5(int[] iArr, Object[] objArr, int i2, int i3, u5 u5Var, boolean z, boolean z2, int[] iArr2, int i4, int i5, b6 b6Var, d5 d5Var, d7<?, ?> d7Var, b4<?> b4Var, r5 r5Var) {
        this.f7430c = iArr;
        this.f7431d = objArr;
        this.f7432e = i2;
        this.f7433f = i3;
        this.f7436i = u5Var instanceof n4;
        this.f7437j = z;
        this.f7435h = b4Var != null && b4Var.e(u5Var);
        this.f7438k = false;
        this.f7439l = iArr2;
        this.m = i4;
        this.n = i5;
        this.o = b6Var;
        this.p = d5Var;
        this.q = d7Var;
        this.r = b4Var;
        this.f7434g = u5Var;
        this.s = r5Var;
    }

    private final boolean A(T t, int i2, int i3) {
        return j7.b(t, (long) (P(i3) & 1048575)) == i2;
    }

    private final boolean B(T t, int i2, int i3, int i4, int i5) {
        if (i3 == 1048575) {
            return z(t, i2);
        }
        return (i4 & i5) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean C(Object obj, int i2, m6 m6Var) {
        return m6Var.d(j7.F(obj, i2 & 1048575));
    }

    private static <T> double D(T t, long j2) {
        return ((Double) j7.F(t, j2)).doubleValue();
    }

    private final int E(int i2, int i3) {
        int length = (this.f7430c.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.f7430c[i5];
            if (i2 == i6) {
                return i5;
            }
            if (i2 < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    private final Object F(int i2) {
        return this.f7431d[(i2 / 3) << 1];
    }

    private final void G(T t, int i2) {
        int P = P(i2);
        long j2 = 1048575 & P;
        if (j2 == 1048575) {
            return;
        }
        j7.h(t, j2, (1 << (P >>> 20)) | j7.b(t, j2));
    }

    private final void H(T t, int i2, int i3) {
        j7.h(t, P(i3) & 1048575, i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x048f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void I(T r18, com.google.android.gms.internal.measurement.w7 r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.y5.I(java.lang.Object, com.google.android.gms.internal.measurement.w7):void");
    }

    private final void J(T t, T t2, int i2) {
        int N = N(i2);
        int i3 = this.f7430c[i2];
        long j2 = N & 1048575;
        if (A(t2, i3, i2)) {
            Object F = j7.F(t, j2);
            Object F2 = j7.F(t2, j2);
            if (F != null && F2 != null) {
                j7.j(t, j2, q4.e(F, F2));
                H(t, i3, i2);
            } else if (F2 != null) {
                j7.j(t, j2, F2);
                H(t, i3, i2);
            }
        }
    }

    private static <T> float K(T t, long j2) {
        return ((Float) j7.F(t, j2)).floatValue();
    }

    private final r4 L(int i2) {
        return (r4) this.f7431d[((i2 / 3) << 1) + 1];
    }

    private final boolean M(T t, T t2, int i2) {
        return z(t, i2) == z(t2, i2);
    }

    private final int N(int i2) {
        return this.f7430c[i2 + 1];
    }

    private static <T> int O(T t, long j2) {
        return ((Integer) j7.F(t, j2)).intValue();
    }

    private final int P(int i2) {
        return this.f7430c[i2 + 2];
    }

    private static <T> long Q(T t, long j2) {
        return ((Long) j7.F(t, j2)).longValue();
    }

    private static c7 R(Object obj) {
        n4 n4Var = (n4) obj;
        c7 c7Var = n4Var.zzb;
        if (c7Var == c7.a()) {
            c7 g2 = c7.g();
            n4Var.zzb = g2;
            return g2;
        }
        return c7Var;
    }

    private static <T> boolean S(T t, long j2) {
        return ((Boolean) j7.F(t, j2)).booleanValue();
    }

    private final int T(int i2) {
        if (i2 < this.f7432e || i2 > this.f7433f) {
            return -1;
        }
        return E(i2, 0);
    }

    private final int j(int i2, int i3) {
        if (i2 < this.f7432e || i2 > this.f7433f) {
            return -1;
        }
        return E(i2, i3);
    }

    private static <UT, UB> int k(d7<UT, UB> d7Var, T t) {
        return d7Var.l(d7Var.f(t));
    }

    private final int l(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, c3 c3Var) throws IOException {
        int k2;
        Unsafe unsafe = f7429b;
        long j3 = this.f7430c[i9 + 2] & 1048575;
        switch (i8) {
            case 51:
                if (i6 == 1) {
                    unsafe.putObject(t, j2, Double.valueOf(d3.m(bArr, i2)));
                    k2 = i2 + 8;
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 52:
                if (i6 == 5) {
                    unsafe.putObject(t, j2, Float.valueOf(d3.o(bArr, i2)));
                    k2 = i2 + 4;
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 53:
            case 54:
                if (i6 == 0) {
                    k2 = d3.k(bArr, i2, c3Var);
                    unsafe.putObject(t, j2, Long.valueOf(c3Var.f7067b));
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 55:
            case 62:
                if (i6 == 0) {
                    k2 = d3.i(bArr, i2, c3Var);
                    unsafe.putObject(t, j2, Integer.valueOf(c3Var.a));
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 56:
            case 65:
                if (i6 == 1) {
                    unsafe.putObject(t, j2, Long.valueOf(d3.l(bArr, i2)));
                    k2 = i2 + 8;
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 57:
            case 64:
                if (i6 == 5) {
                    unsafe.putObject(t, j2, Integer.valueOf(d3.h(bArr, i2)));
                    k2 = i2 + 4;
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 58:
                if (i6 == 0) {
                    k2 = d3.k(bArr, i2, c3Var);
                    unsafe.putObject(t, j2, Boolean.valueOf(c3Var.f7067b != 0));
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 59:
                if (i6 == 2) {
                    int i10 = d3.i(bArr, i2, c3Var);
                    int i11 = c3Var.a;
                    if (i11 == 0) {
                        unsafe.putObject(t, j2, "");
                    } else if ((i7 & PKIFailureInfo.duplicateCertReq) != 0 && !l7.g(bArr, i10, i10 + i11)) {
                        throw zzfm.f();
                    } else {
                        unsafe.putObject(t, j2, new String(bArr, i10, i11, q4.a));
                        i10 += i11;
                    }
                    unsafe.putInt(t, j3, i5);
                    return i10;
                }
                return i2;
            case 60:
                if (i6 == 2) {
                    int g2 = d3.g(q(i9), bArr, i2, i3, c3Var);
                    Object object = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t, j2, c3Var.f7068c);
                    } else {
                        unsafe.putObject(t, j2, q4.e(object, c3Var.f7068c));
                    }
                    unsafe.putInt(t, j3, i5);
                    return g2;
                }
                return i2;
            case 61:
                if (i6 == 2) {
                    k2 = d3.q(bArr, i2, c3Var);
                    unsafe.putObject(t, j2, c3Var.f7068c);
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 63:
                if (i6 == 0) {
                    int i12 = d3.i(bArr, i2, c3Var);
                    int i13 = c3Var.a;
                    r4 L = L(i9);
                    if (L != null && !L.f(i13)) {
                        R(t).c(i4, Long.valueOf(i13));
                        return i12;
                    }
                    unsafe.putObject(t, j2, Integer.valueOf(i13));
                    k2 = i12;
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 66:
                if (i6 == 0) {
                    k2 = d3.i(bArr, i2, c3Var);
                    unsafe.putObject(t, j2, Integer.valueOf(t3.d(c3Var.a)));
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 67:
                if (i6 == 0) {
                    k2 = d3.k(bArr, i2, c3Var);
                    unsafe.putObject(t, j2, Long.valueOf(t3.a(c3Var.f7067b)));
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 68:
                if (i6 == 3) {
                    k2 = d3.f(q(i9), bArr, i2, i3, (i4 & (-8)) | 4, c3Var);
                    Object object2 = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j2, c3Var.f7068c);
                    } else {
                        unsafe.putObject(t, j2, q4.e(object2, c3Var.f7068c));
                    }
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            default:
                return i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x0233 -> B:116:0x0234). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x016b -> B:67:0x016c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x01e5 -> B:96:0x01e6). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int m(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.measurement.c3 r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1126
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.y5.m(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.c3):int");
    }

    private final <K, V> int n(T t, byte[] bArr, int i2, int i3, int i4, long j2, c3 c3Var) throws IOException {
        Unsafe unsafe = f7429b;
        Object F = F(i4);
        Object object = unsafe.getObject(t, j2);
        if (this.s.d(object)) {
            Object a2 = this.s.a(F);
            this.s.f(a2, object);
            unsafe.putObject(t, j2, a2);
            object = a2;
        }
        this.s.e(F);
        this.s.c(object);
        int i5 = d3.i(bArr, i2, c3Var);
        int i6 = c3Var.a;
        if (i6 >= 0 && i6 <= i3 - i5) {
            throw null;
        }
        throw zzfm.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0397  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> com.google.android.gms.internal.measurement.y5<T> p(java.lang.Class<T> r33, com.google.android.gms.internal.measurement.s5 r34, com.google.android.gms.internal.measurement.b6 r35, com.google.android.gms.internal.measurement.d5 r36, com.google.android.gms.internal.measurement.d7<?, ?> r37, com.google.android.gms.internal.measurement.b4<?> r38, com.google.android.gms.internal.measurement.r5 r39) {
        /*
            Method dump skipped, instructions count: 1046
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.y5.p(java.lang.Class, com.google.android.gms.internal.measurement.s5, com.google.android.gms.internal.measurement.b6, com.google.android.gms.internal.measurement.d5, com.google.android.gms.internal.measurement.d7, com.google.android.gms.internal.measurement.b4, com.google.android.gms.internal.measurement.r5):com.google.android.gms.internal.measurement.y5");
    }

    private final m6 q(int i2) {
        int i3 = (i2 / 3) << 1;
        m6 m6Var = (m6) this.f7431d[i3];
        if (m6Var != null) {
            return m6Var;
        }
        m6<T> b2 = j6.a().b((Class) this.f7431d[i3 + 1]);
        this.f7431d[i3] = b2;
        return b2;
    }

    private final <K, V, UT, UB> UB r(int i2, int i3, Map<K, V> map, r4 r4Var, UB ub, d7<UT, UB> d7Var) {
        p5<?, ?> e2 = this.s.e(F(i2));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!r4Var.f(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = d7Var.a();
                }
                p3 x = h3.x(m5.a(e2, next.getKey(), next.getValue()));
                try {
                    m5.b(x.b(), e2, next.getKey(), next.getValue());
                    d7Var.c(ub, i3, x.a());
                    it.remove();
                } catch (IOException e3) {
                    throw new RuntimeException(e3);
                }
            }
        }
        return ub;
    }

    private final <UT, UB> UB s(Object obj, int i2, UB ub, d7<UT, UB> d7Var) {
        r4 L;
        int i3 = this.f7430c[i2];
        Object F = j7.F(obj, N(i2) & 1048575);
        return (F == null || (L = L(i2)) == null) ? ub : (UB) r(i2, i3, this.s.c(F), L, ub, d7Var);
    }

    private static Field t(Class<?> cls, String str) {
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

    private static List<?> u(Object obj, long j2) {
        return (List) j7.F(obj, j2);
    }

    private static void v(int i2, Object obj, w7 w7Var) throws IOException {
        if (obj instanceof String) {
            w7Var.m(i2, (String) obj);
        } else {
            w7Var.H(i2, (h3) obj);
        }
    }

    private static <UT, UB> void w(d7<UT, UB> d7Var, T t, w7 w7Var) throws IOException {
        d7Var.d(d7Var.f(t), w7Var);
    }

    private final <K, V> void x(w7 w7Var, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            w7Var.I(i2, this.s.e(F(i3)), this.s.b(obj));
        }
    }

    private final void y(T t, T t2, int i2) {
        long N = N(i2) & 1048575;
        if (z(t2, i2)) {
            Object F = j7.F(t, N);
            Object F2 = j7.F(t2, N);
            if (F != null && F2 != null) {
                j7.j(t, N, q4.e(F, F2));
                G(t, i2);
            } else if (F2 != null) {
                j7.j(t, N, F2);
                G(t, i2);
            }
        }
    }

    private final boolean z(T t, int i2) {
        int P = P(i2);
        long j2 = P & 1048575;
        if (j2 != 1048575) {
            return (j7.b(t, j2) & (1 << (P >>> 20))) != 0;
        }
        int N = N(i2);
        long j3 = N & 1048575;
        switch ((N & 267386880) >>> 20) {
            case 0:
                return j7.C(t, j3) != 0.0d;
            case 1:
                return j7.x(t, j3) != 0.0f;
            case 2:
                return j7.o(t, j3) != 0;
            case 3:
                return j7.o(t, j3) != 0;
            case 4:
                return j7.b(t, j3) != 0;
            case 5:
                return j7.o(t, j3) != 0;
            case 6:
                return j7.b(t, j3) != 0;
            case 7:
                return j7.w(t, j3);
            case 8:
                Object F = j7.F(t, j3);
                if (F instanceof String) {
                    return !((String) F).isEmpty();
                } else if (F instanceof h3) {
                    return !h3.a.equals(F);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return j7.F(t, j3) != null;
            case 10:
                return !h3.a.equals(j7.F(t, j3));
            case 11:
                return j7.b(t, j3) != 0;
            case 12:
                return j7.b(t, j3) != 0;
            case 13:
                return j7.b(t, j3) != 0;
            case 14:
                return j7.o(t, j3) != 0;
            case 15:
                return j7.b(t, j3) != 0;
            case 16:
                return j7.o(t, j3) != 0;
            case 17:
                return j7.F(t, j3) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final T a() {
        return (T) this.o.c(this.f7434g);
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final void b(T t) {
        int i2;
        int i3 = this.m;
        while (true) {
            i2 = this.n;
            if (i3 >= i2) {
                break;
            }
            long N = N(this.f7439l[i3]) & 1048575;
            Object F = j7.F(t, N);
            if (F != null) {
                j7.j(t, N, this.s.g(F));
            }
            i3++;
        }
        int length = this.f7439l.length;
        while (i2 < length) {
            this.p.d(t, this.f7439l[i2]);
            i2++;
        }
        this.q.j(t);
        if (this.f7435h) {
            this.r.g(t);
        }
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final int c(T t) {
        int i2;
        int b2;
        int length = this.f7430c.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int N = N(i4);
            int i5 = this.f7430c[i4];
            long j2 = 1048575 & N;
            int i6 = 37;
            switch ((N & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    b2 = q4.b(Double.doubleToLongBits(j7.C(t, j2)));
                    i3 = i2 + b2;
                    break;
                case 1:
                    i2 = i3 * 53;
                    b2 = Float.floatToIntBits(j7.x(t, j2));
                    i3 = i2 + b2;
                    break;
                case 2:
                    i2 = i3 * 53;
                    b2 = q4.b(j7.o(t, j2));
                    i3 = i2 + b2;
                    break;
                case 3:
                    i2 = i3 * 53;
                    b2 = q4.b(j7.o(t, j2));
                    i3 = i2 + b2;
                    break;
                case 4:
                    i2 = i3 * 53;
                    b2 = j7.b(t, j2);
                    i3 = i2 + b2;
                    break;
                case 5:
                    i2 = i3 * 53;
                    b2 = q4.b(j7.o(t, j2));
                    i3 = i2 + b2;
                    break;
                case 6:
                    i2 = i3 * 53;
                    b2 = j7.b(t, j2);
                    i3 = i2 + b2;
                    break;
                case 7:
                    i2 = i3 * 53;
                    b2 = q4.c(j7.w(t, j2));
                    i3 = i2 + b2;
                    break;
                case 8:
                    i2 = i3 * 53;
                    b2 = ((String) j7.F(t, j2)).hashCode();
                    i3 = i2 + b2;
                    break;
                case 9:
                    Object F = j7.F(t, j2);
                    if (F != null) {
                        i6 = F.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    b2 = j7.F(t, j2).hashCode();
                    i3 = i2 + b2;
                    break;
                case 11:
                    i2 = i3 * 53;
                    b2 = j7.b(t, j2);
                    i3 = i2 + b2;
                    break;
                case 12:
                    i2 = i3 * 53;
                    b2 = j7.b(t, j2);
                    i3 = i2 + b2;
                    break;
                case 13:
                    i2 = i3 * 53;
                    b2 = j7.b(t, j2);
                    i3 = i2 + b2;
                    break;
                case 14:
                    i2 = i3 * 53;
                    b2 = q4.b(j7.o(t, j2));
                    i3 = i2 + b2;
                    break;
                case 15:
                    i2 = i3 * 53;
                    b2 = j7.b(t, j2);
                    i3 = i2 + b2;
                    break;
                case 16:
                    i2 = i3 * 53;
                    b2 = q4.b(j7.o(t, j2));
                    i3 = i2 + b2;
                    break;
                case 17:
                    Object F2 = j7.F(t, j2);
                    if (F2 != null) {
                        i6 = F2.hashCode();
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
                    b2 = j7.F(t, j2).hashCode();
                    i3 = i2 + b2;
                    break;
                case 50:
                    i2 = i3 * 53;
                    b2 = j7.F(t, j2).hashCode();
                    i3 = i2 + b2;
                    break;
                case 51:
                    if (A(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = q4.b(Double.doubleToLongBits(D(t, j2)));
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (A(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = Float.floatToIntBits(K(t, j2));
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (A(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = q4.b(Q(t, j2));
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (A(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = q4.b(Q(t, j2));
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (A(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = O(t, j2);
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (A(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = q4.b(Q(t, j2));
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (A(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = O(t, j2);
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (A(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = q4.c(S(t, j2));
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (A(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = ((String) j7.F(t, j2)).hashCode();
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (A(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = j7.F(t, j2).hashCode();
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (A(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = j7.F(t, j2).hashCode();
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (A(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = O(t, j2);
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (A(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = O(t, j2);
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (A(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = O(t, j2);
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (A(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = q4.b(Q(t, j2));
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (A(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = O(t, j2);
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (A(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = q4.b(Q(t, j2));
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (A(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = j7.F(t, j2).hashCode();
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.q.f(t).hashCode();
        return this.f7435h ? (hashCode * 53) + this.r.b(t).hashCode() : hashCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.m6
    public final boolean d(T t) {
        int i2;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean z = true;
            if (i6 >= this.m) {
                return !this.f7435h || this.r.b(t).q();
            }
            int i7 = this.f7439l[i6];
            int i8 = this.f7430c[i7];
            int N = N(i7);
            int i9 = this.f7430c[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = f7429b.getInt(t, i10);
                }
                i3 = i5;
                i2 = i10;
            } else {
                i2 = i4;
                i3 = i5;
            }
            if (((268435456 & N) != 0) && !B(t, i7, i2, i3, i11)) {
                return false;
            }
            int i12 = (267386880 & N) >>> 20;
            if (i12 != 9 && i12 != 17) {
                if (i12 != 27) {
                    if (i12 == 60 || i12 == 68) {
                        if (A(t, i8, i7) && !C(t, N, q(i7))) {
                            return false;
                        }
                    } else if (i12 != 49) {
                        if (i12 == 50 && !this.s.b(j7.F(t, N & 1048575)).isEmpty()) {
                            this.s.e(F(i7));
                            throw null;
                        }
                    }
                }
                List list = (List) j7.F(t, N & 1048575);
                if (!list.isEmpty()) {
                    m6 q = q(i7);
                    int i13 = 0;
                    while (true) {
                        if (i13 >= list.size()) {
                            break;
                        } else if (!q.d(list.get(i13))) {
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
            } else if (B(t, i7, i2, i3, i11) && !C(t, N, q(i7))) {
                return false;
            }
            i6++;
            i4 = i2;
            i5 = i3;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.measurement.m6
    public final int e(T t) {
        int i2;
        int i3;
        int i4;
        boolean z;
        long j2;
        int b0;
        int H;
        int A0;
        int i5;
        int R;
        int V;
        int g0;
        int o0;
        int B;
        int V2;
        int g02;
        int o02;
        int i6 = 267386880;
        int i7 = 0;
        if (this.f7437j) {
            Unsafe unsafe = f7429b;
            int i8 = 0;
            int i9 = 0;
            while (i8 < this.f7430c.length) {
                int N = N(i8);
                int i10 = (N & i6) >>> 20;
                int i11 = this.f7430c[i8];
                long j3 = N & 1048575;
                int i12 = (i10 < h4.N.a() || i10 > h4.a0.a()) ? 0 : this.f7430c[i8 + 2] & 1048575;
                switch (i10) {
                    case 0:
                        if (z(t, i8)) {
                            B = zzel.B(i11, 0.0d);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 1:
                        if (z(t, i8)) {
                            B = zzel.C(i11, 0.0f);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 2:
                        if (z(t, i8)) {
                            B = zzel.b0(i11, j7.o(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 3:
                        if (z(t, i8)) {
                            B = zzel.h0(i11, j7.o(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 4:
                        if (z(t, i8)) {
                            B = zzel.l0(i11, j7.b(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 5:
                        if (z(t, i8)) {
                            B = zzel.q0(i11, 0L);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 6:
                        if (z(t, i8)) {
                            B = zzel.x0(i11, 0);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 7:
                        if (z(t, i8)) {
                            B = zzel.H(i11, true);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 8:
                        if (z(t, i8)) {
                            Object F = j7.F(t, j3);
                            if (F instanceof h3) {
                                B = zzel.T(i11, (h3) F);
                                break;
                            } else {
                                B = zzel.G(i11, (String) F);
                                break;
                            }
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 9:
                        if (z(t, i8)) {
                            B = o6.a(i11, j7.F(t, j3), q(i8));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 10:
                        if (z(t, i8)) {
                            B = zzel.T(i11, (h3) j7.F(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 11:
                        if (z(t, i8)) {
                            B = zzel.p0(i11, j7.b(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 12:
                        if (z(t, i8)) {
                            B = zzel.C0(i11, j7.b(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 13:
                        if (z(t, i8)) {
                            B = zzel.A0(i11, 0);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 14:
                        if (z(t, i8)) {
                            B = zzel.u0(i11, 0L);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 15:
                        if (z(t, i8)) {
                            B = zzel.t0(i11, j7.b(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 16:
                        if (z(t, i8)) {
                            B = zzel.m0(i11, j7.o(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 17:
                        if (z(t, i8)) {
                            B = zzel.U(i11, (u5) j7.F(t, j3), q(i8));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 18:
                        B = o6.U(i11, u(t, j3), false);
                        break;
                    case 19:
                        B = o6.R(i11, u(t, j3), false);
                        break;
                    case 20:
                        B = o6.d(i11, u(t, j3), false);
                        break;
                    case 21:
                        B = o6.t(i11, u(t, j3), false);
                        break;
                    case 22:
                        B = o6.H(i11, u(t, j3), false);
                        break;
                    case 23:
                        B = o6.U(i11, u(t, j3), false);
                        break;
                    case 24:
                        B = o6.R(i11, u(t, j3), false);
                        break;
                    case 25:
                        B = o6.X(i11, u(t, j3), false);
                        break;
                    case 26:
                        B = o6.b(i11, u(t, j3));
                        break;
                    case 27:
                        B = o6.c(i11, u(t, j3), q(i8));
                        break;
                    case 28:
                        B = o6.r(i11, u(t, j3));
                        break;
                    case 29:
                        B = o6.L(i11, u(t, j3), false);
                        break;
                    case 30:
                        B = o6.D(i11, u(t, j3), false);
                        break;
                    case 31:
                        B = o6.R(i11, u(t, j3), false);
                        break;
                    case 32:
                        B = o6.U(i11, u(t, j3), false);
                        break;
                    case 33:
                        B = o6.O(i11, u(t, j3), false);
                        break;
                    case 34:
                        B = o6.z(i11, u(t, j3), false);
                        break;
                    case 35:
                        V2 = o6.V((List) unsafe.getObject(t, j3));
                        if (V2 > 0) {
                            if (this.f7438k) {
                                unsafe.putInt(t, i12, V2);
                            }
                            g02 = zzel.g0(i11);
                            o02 = zzel.o0(V2);
                            B = g02 + o02 + V2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 36:
                        V2 = o6.S((List) unsafe.getObject(t, j3));
                        if (V2 > 0) {
                            if (this.f7438k) {
                                unsafe.putInt(t, i12, V2);
                            }
                            g02 = zzel.g0(i11);
                            o02 = zzel.o0(V2);
                            B = g02 + o02 + V2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 37:
                        V2 = o6.e((List) unsafe.getObject(t, j3));
                        if (V2 > 0) {
                            if (this.f7438k) {
                                unsafe.putInt(t, i12, V2);
                            }
                            g02 = zzel.g0(i11);
                            o02 = zzel.o0(V2);
                            B = g02 + o02 + V2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 38:
                        V2 = o6.u((List) unsafe.getObject(t, j3));
                        if (V2 > 0) {
                            if (this.f7438k) {
                                unsafe.putInt(t, i12, V2);
                            }
                            g02 = zzel.g0(i11);
                            o02 = zzel.o0(V2);
                            B = g02 + o02 + V2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 39:
                        V2 = o6.I((List) unsafe.getObject(t, j3));
                        if (V2 > 0) {
                            if (this.f7438k) {
                                unsafe.putInt(t, i12, V2);
                            }
                            g02 = zzel.g0(i11);
                            o02 = zzel.o0(V2);
                            B = g02 + o02 + V2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 40:
                        V2 = o6.V((List) unsafe.getObject(t, j3));
                        if (V2 > 0) {
                            if (this.f7438k) {
                                unsafe.putInt(t, i12, V2);
                            }
                            g02 = zzel.g0(i11);
                            o02 = zzel.o0(V2);
                            B = g02 + o02 + V2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 41:
                        V2 = o6.S((List) unsafe.getObject(t, j3));
                        if (V2 > 0) {
                            if (this.f7438k) {
                                unsafe.putInt(t, i12, V2);
                            }
                            g02 = zzel.g0(i11);
                            o02 = zzel.o0(V2);
                            B = g02 + o02 + V2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 42:
                        V2 = o6.Y((List) unsafe.getObject(t, j3));
                        if (V2 > 0) {
                            if (this.f7438k) {
                                unsafe.putInt(t, i12, V2);
                            }
                            g02 = zzel.g0(i11);
                            o02 = zzel.o0(V2);
                            B = g02 + o02 + V2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 43:
                        V2 = o6.M((List) unsafe.getObject(t, j3));
                        if (V2 > 0) {
                            if (this.f7438k) {
                                unsafe.putInt(t, i12, V2);
                            }
                            g02 = zzel.g0(i11);
                            o02 = zzel.o0(V2);
                            B = g02 + o02 + V2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 44:
                        V2 = o6.E((List) unsafe.getObject(t, j3));
                        if (V2 > 0) {
                            if (this.f7438k) {
                                unsafe.putInt(t, i12, V2);
                            }
                            g02 = zzel.g0(i11);
                            o02 = zzel.o0(V2);
                            B = g02 + o02 + V2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 45:
                        V2 = o6.S((List) unsafe.getObject(t, j3));
                        if (V2 > 0) {
                            if (this.f7438k) {
                                unsafe.putInt(t, i12, V2);
                            }
                            g02 = zzel.g0(i11);
                            o02 = zzel.o0(V2);
                            B = g02 + o02 + V2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 46:
                        V2 = o6.V((List) unsafe.getObject(t, j3));
                        if (V2 > 0) {
                            if (this.f7438k) {
                                unsafe.putInt(t, i12, V2);
                            }
                            g02 = zzel.g0(i11);
                            o02 = zzel.o0(V2);
                            B = g02 + o02 + V2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 47:
                        V2 = o6.P((List) unsafe.getObject(t, j3));
                        if (V2 > 0) {
                            if (this.f7438k) {
                                unsafe.putInt(t, i12, V2);
                            }
                            g02 = zzel.g0(i11);
                            o02 = zzel.o0(V2);
                            B = g02 + o02 + V2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 48:
                        V2 = o6.A((List) unsafe.getObject(t, j3));
                        if (V2 > 0) {
                            if (this.f7438k) {
                                unsafe.putInt(t, i12, V2);
                            }
                            g02 = zzel.g0(i11);
                            o02 = zzel.o0(V2);
                            B = g02 + o02 + V2;
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 49:
                        B = o6.s(i11, u(t, j3), q(i8));
                        break;
                    case 50:
                        B = this.s.h(i11, j7.F(t, j3), F(i8));
                        break;
                    case 51:
                        if (A(t, i11, i8)) {
                            B = zzel.B(i11, 0.0d);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 52:
                        if (A(t, i11, i8)) {
                            B = zzel.C(i11, 0.0f);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 53:
                        if (A(t, i11, i8)) {
                            B = zzel.b0(i11, Q(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 54:
                        if (A(t, i11, i8)) {
                            B = zzel.h0(i11, Q(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 55:
                        if (A(t, i11, i8)) {
                            B = zzel.l0(i11, O(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 56:
                        if (A(t, i11, i8)) {
                            B = zzel.q0(i11, 0L);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 57:
                        if (A(t, i11, i8)) {
                            B = zzel.x0(i11, 0);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 58:
                        if (A(t, i11, i8)) {
                            B = zzel.H(i11, true);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 59:
                        if (A(t, i11, i8)) {
                            Object F2 = j7.F(t, j3);
                            if (F2 instanceof h3) {
                                B = zzel.T(i11, (h3) F2);
                                break;
                            } else {
                                B = zzel.G(i11, (String) F2);
                                break;
                            }
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 60:
                        if (A(t, i11, i8)) {
                            B = o6.a(i11, j7.F(t, j3), q(i8));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 61:
                        if (A(t, i11, i8)) {
                            B = zzel.T(i11, (h3) j7.F(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 62:
                        if (A(t, i11, i8)) {
                            B = zzel.p0(i11, O(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 63:
                        if (A(t, i11, i8)) {
                            B = zzel.C0(i11, O(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 64:
                        if (A(t, i11, i8)) {
                            B = zzel.A0(i11, 0);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 65:
                        if (A(t, i11, i8)) {
                            B = zzel.u0(i11, 0L);
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 66:
                        if (A(t, i11, i8)) {
                            B = zzel.t0(i11, O(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 67:
                        if (A(t, i11, i8)) {
                            B = zzel.m0(i11, Q(t, j3));
                            break;
                        } else {
                            continue;
                            i8 += 3;
                            i6 = 267386880;
                        }
                    case 68:
                        if (A(t, i11, i8)) {
                            B = zzel.U(i11, (u5) j7.F(t, j3), q(i8));
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
                i9 += B;
                i8 += 3;
                i6 = 267386880;
            }
            return i9 + k(this.q, t);
        }
        Unsafe unsafe2 = f7429b;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (i14 < this.f7430c.length) {
            int N2 = N(i14);
            int[] iArr = this.f7430c;
            int i17 = iArr[i14];
            int i18 = (N2 & 267386880) >>> 20;
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
                i2 = (!this.f7438k || i18 < h4.N.a() || i18 > h4.a0.a()) ? 0 : this.f7430c[i14 + 2] & 1048575;
                i3 = 0;
            }
            long j4 = N2 & 1048575;
            switch (i18) {
                case 0:
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    if ((i16 & i3) != 0) {
                        i15 += zzel.B(i17, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    i4 = 0;
                    j2 = 0;
                    if ((i16 & i3) != 0) {
                        z = false;
                        i15 += zzel.C(i17, 0.0f);
                        break;
                    }
                    z = false;
                case 2:
                    i4 = 0;
                    j2 = 0;
                    if ((i16 & i3) != 0) {
                        b0 = zzel.b0(i17, unsafe2.getLong(t, j4));
                        i15 += b0;
                    }
                    z = false;
                    break;
                case 3:
                    i4 = 0;
                    j2 = 0;
                    if ((i16 & i3) != 0) {
                        b0 = zzel.h0(i17, unsafe2.getLong(t, j4));
                        i15 += b0;
                    }
                    z = false;
                    break;
                case 4:
                    i4 = 0;
                    j2 = 0;
                    if ((i16 & i3) != 0) {
                        b0 = zzel.l0(i17, unsafe2.getInt(t, j4));
                        i15 += b0;
                    }
                    z = false;
                    break;
                case 5:
                    i4 = 0;
                    j2 = 0;
                    if ((i16 & i3) != 0) {
                        b0 = zzel.q0(i17, 0L);
                        i15 += b0;
                    }
                    z = false;
                    break;
                case 6:
                    if ((i16 & i3) != 0) {
                        i4 = 0;
                        i15 += zzel.x0(i17, 0);
                        z = false;
                        j2 = 0;
                        break;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                case 7:
                    if ((i16 & i3) != 0) {
                        H = zzel.H(i17, true);
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 8:
                    if ((i16 & i3) != 0) {
                        Object object = unsafe2.getObject(t, j4);
                        if (object instanceof h3) {
                            H = zzel.T(i17, (h3) object);
                        } else {
                            H = zzel.G(i17, (String) object);
                        }
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 9:
                    if ((i16 & i3) != 0) {
                        H = o6.a(i17, unsafe2.getObject(t, j4), q(i14));
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 10:
                    if ((i16 & i3) != 0) {
                        H = zzel.T(i17, (h3) unsafe2.getObject(t, j4));
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 11:
                    if ((i16 & i3) != 0) {
                        H = zzel.p0(i17, unsafe2.getInt(t, j4));
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 12:
                    if ((i16 & i3) != 0) {
                        H = zzel.C0(i17, unsafe2.getInt(t, j4));
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 13:
                    if ((i16 & i3) != 0) {
                        A0 = zzel.A0(i17, 0);
                        i15 += A0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 14:
                    if ((i16 & i3) != 0) {
                        H = zzel.u0(i17, 0L);
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 15:
                    if ((i16 & i3) != 0) {
                        H = zzel.t0(i17, unsafe2.getInt(t, j4));
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 16:
                    if ((i16 & i3) != 0) {
                        H = zzel.m0(i17, unsafe2.getLong(t, j4));
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 17:
                    if ((i16 & i3) != 0) {
                        H = zzel.U(i17, (u5) unsafe2.getObject(t, j4), q(i14));
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 18:
                    H = o6.U(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += H;
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 19:
                    i5 = 0;
                    R = o6.R(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += R;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 20:
                    i5 = 0;
                    R = o6.d(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += R;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 21:
                    i5 = 0;
                    R = o6.t(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += R;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 22:
                    i5 = 0;
                    R = o6.H(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += R;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 23:
                    i5 = 0;
                    R = o6.U(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += R;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 24:
                    i5 = 0;
                    R = o6.R(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += R;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 25:
                    i5 = 0;
                    R = o6.X(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += R;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 26:
                    H = o6.b(i17, (List) unsafe2.getObject(t, j4));
                    i15 += H;
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 27:
                    H = o6.c(i17, (List) unsafe2.getObject(t, j4), q(i14));
                    i15 += H;
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 28:
                    H = o6.r(i17, (List) unsafe2.getObject(t, j4));
                    i15 += H;
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 29:
                    H = o6.L(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += H;
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 30:
                    i5 = 0;
                    R = o6.D(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += R;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 31:
                    i5 = 0;
                    R = o6.R(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += R;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 32:
                    i5 = 0;
                    R = o6.U(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += R;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 33:
                    i5 = 0;
                    R = o6.O(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += R;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 34:
                    i5 = 0;
                    R = o6.z(i17, (List) unsafe2.getObject(t, j4), false);
                    i15 += R;
                    i4 = i5;
                    z = false;
                    j2 = 0;
                    break;
                case 35:
                    V = o6.V((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f7438k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzel.g0(i17);
                        o0 = zzel.o0(V);
                        A0 = g0 + o0 + V;
                        i15 += A0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 36:
                    V = o6.S((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f7438k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzel.g0(i17);
                        o0 = zzel.o0(V);
                        A0 = g0 + o0 + V;
                        i15 += A0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 37:
                    V = o6.e((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f7438k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzel.g0(i17);
                        o0 = zzel.o0(V);
                        A0 = g0 + o0 + V;
                        i15 += A0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 38:
                    V = o6.u((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f7438k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzel.g0(i17);
                        o0 = zzel.o0(V);
                        A0 = g0 + o0 + V;
                        i15 += A0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 39:
                    V = o6.I((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f7438k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzel.g0(i17);
                        o0 = zzel.o0(V);
                        A0 = g0 + o0 + V;
                        i15 += A0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 40:
                    V = o6.V((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f7438k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzel.g0(i17);
                        o0 = zzel.o0(V);
                        A0 = g0 + o0 + V;
                        i15 += A0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 41:
                    V = o6.S((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f7438k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzel.g0(i17);
                        o0 = zzel.o0(V);
                        A0 = g0 + o0 + V;
                        i15 += A0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 42:
                    V = o6.Y((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f7438k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzel.g0(i17);
                        o0 = zzel.o0(V);
                        A0 = g0 + o0 + V;
                        i15 += A0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 43:
                    V = o6.M((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f7438k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzel.g0(i17);
                        o0 = zzel.o0(V);
                        A0 = g0 + o0 + V;
                        i15 += A0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 44:
                    V = o6.E((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f7438k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzel.g0(i17);
                        o0 = zzel.o0(V);
                        A0 = g0 + o0 + V;
                        i15 += A0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 45:
                    V = o6.S((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f7438k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzel.g0(i17);
                        o0 = zzel.o0(V);
                        A0 = g0 + o0 + V;
                        i15 += A0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 46:
                    V = o6.V((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f7438k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzel.g0(i17);
                        o0 = zzel.o0(V);
                        A0 = g0 + o0 + V;
                        i15 += A0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 47:
                    V = o6.P((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f7438k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzel.g0(i17);
                        o0 = zzel.o0(V);
                        A0 = g0 + o0 + V;
                        i15 += A0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 48:
                    V = o6.A((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f7438k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzel.g0(i17);
                        o0 = zzel.o0(V);
                        A0 = g0 + o0 + V;
                        i15 += A0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 49:
                    H = o6.s(i17, (List) unsafe2.getObject(t, j4), q(i14));
                    i15 += H;
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 50:
                    H = this.s.h(i17, unsafe2.getObject(t, j4), F(i14));
                    i15 += H;
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 51:
                    if (A(t, i17, i14)) {
                        H = zzel.B(i17, 0.0d);
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 52:
                    if (A(t, i17, i14)) {
                        A0 = zzel.C(i17, 0.0f);
                        i15 += A0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 53:
                    if (A(t, i17, i14)) {
                        H = zzel.b0(i17, Q(t, j4));
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 54:
                    if (A(t, i17, i14)) {
                        H = zzel.h0(i17, Q(t, j4));
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 55:
                    if (A(t, i17, i14)) {
                        H = zzel.l0(i17, O(t, j4));
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 56:
                    if (A(t, i17, i14)) {
                        H = zzel.q0(i17, 0L);
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 57:
                    if (A(t, i17, i14)) {
                        A0 = zzel.x0(i17, 0);
                        i15 += A0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 58:
                    if (A(t, i17, i14)) {
                        H = zzel.H(i17, true);
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 59:
                    if (A(t, i17, i14)) {
                        Object object2 = unsafe2.getObject(t, j4);
                        if (object2 instanceof h3) {
                            H = zzel.T(i17, (h3) object2);
                        } else {
                            H = zzel.G(i17, (String) object2);
                        }
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 60:
                    if (A(t, i17, i14)) {
                        H = o6.a(i17, unsafe2.getObject(t, j4), q(i14));
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 61:
                    if (A(t, i17, i14)) {
                        H = zzel.T(i17, (h3) unsafe2.getObject(t, j4));
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 62:
                    if (A(t, i17, i14)) {
                        H = zzel.p0(i17, O(t, j4));
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 63:
                    if (A(t, i17, i14)) {
                        H = zzel.C0(i17, O(t, j4));
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 64:
                    if (A(t, i17, i14)) {
                        A0 = zzel.A0(i17, 0);
                        i15 += A0;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 65:
                    if (A(t, i17, i14)) {
                        H = zzel.u0(i17, 0L);
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 66:
                    if (A(t, i17, i14)) {
                        H = zzel.t0(i17, O(t, j4));
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 67:
                    if (A(t, i17, i14)) {
                        H = zzel.m0(i17, Q(t, j4));
                        i15 += H;
                    }
                    i4 = 0;
                    z = false;
                    j2 = 0;
                    break;
                case 68:
                    if (A(t, i17, i14)) {
                        H = zzel.U(i17, (u5) unsafe2.getObject(t, j4), q(i14));
                        i15 += H;
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
        int k2 = i15 + k(this.q, t);
        if (this.f7435h) {
            c4<?> b2 = this.r.b(t);
            for (int i22 = i21; i22 < b2.f7070b.k(); i22++) {
                Map.Entry<?, Object> i23 = b2.f7070b.i(i22);
                i21 += c4.a((e4) i23.getKey(), i23.getValue());
            }
            for (Map.Entry<?, Object> entry : b2.f7070b.n()) {
                i21 += c4.a((e4) entry.getKey(), entry.getValue());
            }
            return k2 + i21;
        }
        return k2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.j7.C(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.j7.C(r11, r6))) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (com.google.android.gms.internal.measurement.o6.q(com.google.android.gms.internal.measurement.j7.F(r10, r6), com.google.android.gms.internal.measurement.j7.F(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (com.google.android.gms.internal.measurement.o6.q(com.google.android.gms.internal.measurement.j7.F(r10, r6), com.google.android.gms.internal.measurement.j7.F(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (com.google.android.gms.internal.measurement.j7.o(r10, r6) == com.google.android.gms.internal.measurement.j7.o(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
        if (com.google.android.gms.internal.measurement.j7.b(r10, r6) == com.google.android.gms.internal.measurement.j7.b(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a4, code lost:
        if (com.google.android.gms.internal.measurement.j7.o(r10, r6) == com.google.android.gms.internal.measurement.j7.o(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
        if (com.google.android.gms.internal.measurement.j7.b(r10, r6) == com.google.android.gms.internal.measurement.j7.b(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c8, code lost:
        if (com.google.android.gms.internal.measurement.j7.b(r10, r6) == com.google.android.gms.internal.measurement.j7.b(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00da, code lost:
        if (com.google.android.gms.internal.measurement.j7.b(r10, r6) == com.google.android.gms.internal.measurement.j7.b(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f0, code lost:
        if (com.google.android.gms.internal.measurement.o6.q(com.google.android.gms.internal.measurement.j7.F(r10, r6), com.google.android.gms.internal.measurement.j7.F(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0106, code lost:
        if (com.google.android.gms.internal.measurement.o6.q(com.google.android.gms.internal.measurement.j7.F(r10, r6), com.google.android.gms.internal.measurement.j7.F(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011c, code lost:
        if (com.google.android.gms.internal.measurement.o6.q(com.google.android.gms.internal.measurement.j7.F(r10, r6), com.google.android.gms.internal.measurement.j7.F(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x012e, code lost:
        if (com.google.android.gms.internal.measurement.j7.w(r10, r6) == com.google.android.gms.internal.measurement.j7.w(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0140, code lost:
        if (com.google.android.gms.internal.measurement.j7.b(r10, r6) == com.google.android.gms.internal.measurement.j7.b(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0154, code lost:
        if (com.google.android.gms.internal.measurement.j7.o(r10, r6) == com.google.android.gms.internal.measurement.j7.o(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0165, code lost:
        if (com.google.android.gms.internal.measurement.j7.b(r10, r6) == com.google.android.gms.internal.measurement.j7.b(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0178, code lost:
        if (com.google.android.gms.internal.measurement.j7.o(r10, r6) == com.google.android.gms.internal.measurement.j7.o(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x018b, code lost:
        if (com.google.android.gms.internal.measurement.j7.o(r10, r6) == com.google.android.gms.internal.measurement.j7.o(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.j7.x(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.j7.x(r11, r6))) goto L85;
     */
    @Override // com.google.android.gms.internal.measurement.m6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean f(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.y5.f(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final void g(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i2 = 0; i2 < this.f7430c.length; i2 += 3) {
            int N = N(i2);
            long j2 = 1048575 & N;
            int i3 = this.f7430c[i2];
            switch ((N & 267386880) >>> 20) {
                case 0:
                    if (z(t2, i2)) {
                        j7.f(t, j2, j7.C(t2, j2));
                        G(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (z(t2, i2)) {
                        j7.g(t, j2, j7.x(t2, j2));
                        G(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (z(t2, i2)) {
                        j7.i(t, j2, j7.o(t2, j2));
                        G(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (z(t2, i2)) {
                        j7.i(t, j2, j7.o(t2, j2));
                        G(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (z(t2, i2)) {
                        j7.h(t, j2, j7.b(t2, j2));
                        G(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (z(t2, i2)) {
                        j7.i(t, j2, j7.o(t2, j2));
                        G(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (z(t2, i2)) {
                        j7.h(t, j2, j7.b(t2, j2));
                        G(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (z(t2, i2)) {
                        j7.k(t, j2, j7.w(t2, j2));
                        G(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (z(t2, i2)) {
                        j7.j(t, j2, j7.F(t2, j2));
                        G(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    y(t, t2, i2);
                    break;
                case 10:
                    if (z(t2, i2)) {
                        j7.j(t, j2, j7.F(t2, j2));
                        G(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (z(t2, i2)) {
                        j7.h(t, j2, j7.b(t2, j2));
                        G(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (z(t2, i2)) {
                        j7.h(t, j2, j7.b(t2, j2));
                        G(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (z(t2, i2)) {
                        j7.h(t, j2, j7.b(t2, j2));
                        G(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (z(t2, i2)) {
                        j7.i(t, j2, j7.o(t2, j2));
                        G(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (z(t2, i2)) {
                        j7.h(t, j2, j7.b(t2, j2));
                        G(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (z(t2, i2)) {
                        j7.i(t, j2, j7.o(t2, j2));
                        G(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    y(t, t2, i2);
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
                    o6.n(this.s, t, t2, j2);
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
                    if (A(t2, i3, i2)) {
                        j7.j(t, j2, j7.F(t2, j2));
                        H(t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    J(t, t2, i2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (A(t2, i3, i2)) {
                        j7.j(t, j2, j7.F(t2, j2));
                        H(t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    J(t, t2, i2);
                    break;
            }
        }
        o6.o(this.q, t, t2);
        if (this.f7435h) {
            o6.m(this.r, t, t2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x02d1, code lost:
        if (r0 == r5) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02d5, code lost:
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r2 = r18;
        r10 = r20;
        r1 = r25;
        r6 = r27;
        r7 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x031a, code lost:
        if (r0 == r15) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x033d, code lost:
        if (r0 == r15) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x033f, code lost:
        r2 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    @Override // com.google.android.gms.internal.measurement.m6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.measurement.c3 r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 956
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.y5.h(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.c3):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0a2a  */
    @Override // com.google.android.gms.internal.measurement.m6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i(T r14, com.google.android.gms.internal.measurement.w7 r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2916
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.y5.i(java.lang.Object, com.google.android.gms.internal.measurement.w7):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x04c9, code lost:
        if (r6 == 1048575) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x04cb, code lost:
        r26.putInt(r12, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x04d1, code lost:
        r1 = null;
        r2 = r9.m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x04d6, code lost:
        if (r2 >= r9.n) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x04d8, code lost:
        r1 = (com.google.android.gms.internal.measurement.c7) r9.s(r12, r9.f7439l[r2], r1, r9.q);
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x04e7, code lost:
        if (r1 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x04e9, code lost:
        r9.q.h(r12, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x04ee, code lost:
        if (r7 != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x04f2, code lost:
        if (r0 != r31) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x04f9, code lost:
        throw com.google.android.gms.internal.measurement.zzfm.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x04fc, code lost:
        if (r0 > r31) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x04fe, code lost:
        if (r3 != r7) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0500, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0505, code lost:
        throw com.google.android.gms.internal.measurement.zzfm.e();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int o(T r28, byte[] r29, int r30, int r31, int r32, com.google.android.gms.internal.measurement.c3 r33) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.y5.o(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.c3):int");
    }
}