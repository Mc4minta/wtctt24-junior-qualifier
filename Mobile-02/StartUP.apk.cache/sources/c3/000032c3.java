package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.e1;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
final class m2<T> implements z2<T> {
    private static final Unsafe a = x3.z();

    /* renamed from: b  reason: collision with root package name */
    private final int[] f6505b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f6506c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6507d;

    /* renamed from: e  reason: collision with root package name */
    private final int f6508e;

    /* renamed from: f  reason: collision with root package name */
    private final int f6509f;

    /* renamed from: g  reason: collision with root package name */
    private final i2 f6510g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f6511h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f6512i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f6513j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f6514k;

    /* renamed from: l  reason: collision with root package name */
    private final int[] f6515l;
    private final int[] m;
    private final int[] n;
    private final p2 o;
    private final s1 p;
    private final q3<?, ?> q;
    private final r0<?> r;
    private final d2 s;

    private m2(int[] iArr, Object[] objArr, int i2, int i3, int i4, i2 i2Var, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, p2 p2Var, s1 s1Var, q3<?, ?> q3Var, r0<?> r0Var, d2 d2Var) {
        this.f6505b = iArr;
        this.f6506c = objArr;
        this.f6507d = i2;
        this.f6508e = i3;
        this.f6509f = i4;
        this.f6512i = i2Var instanceof e1;
        this.f6513j = z;
        this.f6511h = r0Var != null && r0Var.g(i2Var);
        this.f6514k = false;
        this.f6515l = iArr2;
        this.m = iArr3;
        this.n = iArr4;
        this.o = p2Var;
        this.p = s1Var;
        this.q = q3Var;
        this.r = r0Var;
        this.f6510g = i2Var;
        this.s = d2Var;
    }

    private final boolean A(T t, int i2, int i3, int i4) {
        return this.f6513j ? y(t, i2) : (i3 & i4) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean B(Object obj, int i2, z2 z2Var) {
        return z2Var.j(x3.M(obj, i2 & 1048575));
    }

    private final z2 C(int i2) {
        int i3 = (i2 / 4) << 1;
        z2 z2Var = (z2) this.f6506c[i3];
        if (z2Var != null) {
            return z2Var;
        }
        z2<T> b2 = u2.a().b((Class) this.f6506c[i3 + 1]);
        this.f6506c[i3] = b2;
        return b2;
    }

    private final Object D(int i2) {
        return this.f6506c[(i2 / 4) << 1];
    }

    private final i1<?> E(int i2) {
        return (i1) this.f6506c[((i2 / 4) << 1) + 1];
    }

    private final int F(int i2) {
        return this.f6505b[i2 + 1];
    }

    private final int G(int i2) {
        return this.f6505b[i2 + 2];
    }

    private final int H(int i2) {
        int i3 = this.f6507d;
        if (i2 >= i3) {
            int i4 = this.f6509f;
            if (i2 < i4) {
                int i5 = (i2 - i3) << 2;
                if (this.f6505b[i5] == i2) {
                    return i5;
                }
                return -1;
            } else if (i2 <= this.f6508e) {
                int i6 = i4 - i3;
                int length = (this.f6505b.length / 4) - 1;
                while (i6 <= length) {
                    int i7 = (length + i6) >>> 1;
                    int i8 = i7 << 2;
                    int i9 = this.f6505b[i8];
                    if (i2 == i9) {
                        return i8;
                    }
                    if (i2 < i9) {
                        length = i7 - 1;
                    } else {
                        i6 = i7 + 1;
                    }
                }
            }
        }
        return -1;
    }

    private final void I(T t, int i2) {
        if (this.f6513j) {
            return;
        }
        int G = G(i2);
        long j2 = G & 1048575;
        x3.g(t, j2, x3.H(t, j2) | (1 << (G >>> 20)));
    }

    private final void J(T t, int i2, int i3) {
        x3.g(t, G(i3) & 1048575, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0494  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void K(T r19, com.google.android.gms.internal.clearcut.l4 r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.m2.K(java.lang.Object, com.google.android.gms.internal.clearcut.l4):void");
    }

    private final void L(T t, T t2, int i2) {
        int F = F(i2);
        int i3 = this.f6505b[i2];
        long j2 = F & 1048575;
        if (z(t2, i3, i2)) {
            Object M = x3.M(t, j2);
            Object M2 = x3.M(t2, j2);
            if (M != null && M2 != null) {
                x3.i(t, j2, g1.d(M, M2));
                J(t, i3, i2);
            } else if (M2 != null) {
                x3.i(t, j2, M2);
                J(t, i3, i2);
            }
        }
    }

    private final boolean M(T t, T t2, int i2) {
        return y(t, i2) == y(t2, i2);
    }

    private static <E> List<E> N(Object obj, long j2) {
        return (List) x3.M(obj, j2);
    }

    private static <T> double O(T t, long j2) {
        return ((Double) x3.M(t, j2)).doubleValue();
    }

    private static <T> float P(T t, long j2) {
        return ((Float) x3.M(t, j2)).floatValue();
    }

    private static <T> int Q(T t, long j2) {
        return ((Integer) x3.M(t, j2)).intValue();
    }

    private static <T> long R(T t, long j2) {
        return ((Long) x3.M(t, j2)).longValue();
    }

    private static <T> boolean S(T t, long j2) {
        return ((Boolean) x3.M(t, j2)).booleanValue();
    }

    private static r3 T(Object obj) {
        e1 e1Var = (e1) obj;
        r3 r3Var = e1Var.zzjp;
        if (r3Var == r3.h()) {
            r3 i2 = r3.i();
            e1Var.zzjp = i2;
            return i2;
        }
        return r3Var;
    }

    private static int a(int i2, byte[] bArr, int i3, int i4, Object obj, w wVar) throws IOException {
        return v.c(i2, bArr, i3, i4, T(obj), wVar);
    }

    private static int k(z2<?> z2Var, int i2, byte[] bArr, int i3, int i4, j1<?> j1Var, w wVar) throws IOException {
        int m = m(z2Var, bArr, i3, i4, wVar);
        while (true) {
            j1Var.add(wVar.f6600c);
            if (m >= i4) {
                break;
            }
            int e2 = v.e(bArr, m, wVar);
            if (i2 != wVar.a) {
                break;
            }
            m = m(z2Var, bArr, e2, i4, wVar);
        }
        return m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int l(z2 z2Var, byte[] bArr, int i2, int i3, int i4, w wVar) throws IOException {
        m2 m2Var = (m2) z2Var;
        Object i5 = m2Var.i();
        int r = m2Var.r(i5, bArr, i2, i3, i4, wVar);
        m2Var.b(i5);
        wVar.f6600c = i5;
        return r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int m(z2 z2Var, byte[] bArr, int i2, int i3, w wVar) throws IOException {
        int i4 = i2 + 1;
        int i5 = bArr[i2];
        if (i5 < 0) {
            i4 = v.d(i5, bArr, i4, wVar);
            i5 = wVar.a;
        }
        int i6 = i4;
        if (i5 < 0 || i5 > i3 - i6) {
            throw zzco.a();
        }
        Object i7 = z2Var.i();
        int i8 = i5 + i6;
        z2Var.h(i7, bArr, i6, i8, wVar);
        z2Var.b(i7);
        wVar.f6600c = i7;
        return i8;
    }

    private static <UT, UB> int n(q3<UT, UB> q3Var, T t) {
        return q3Var.j(q3Var.k(t));
    }

    private final int o(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, w wVar) throws IOException {
        Object valueOf;
        Object valueOf2;
        int g2;
        long j3;
        int i10;
        Object valueOf3;
        int i11;
        Unsafe unsafe = a;
        long j4 = this.f6505b[i9 + 2] & 1048575;
        switch (i8) {
            case 51:
                if (i6 == 1) {
                    valueOf = Double.valueOf(v.l(bArr, i2));
                    unsafe.putObject(t, j2, valueOf);
                    g2 = i2 + 8;
                    unsafe.putInt(t, j4, i5);
                    return g2;
                }
                return i2;
            case 52:
                if (i6 == 5) {
                    valueOf2 = Float.valueOf(v.n(bArr, i2));
                    unsafe.putObject(t, j2, valueOf2);
                    g2 = i2 + 4;
                    unsafe.putInt(t, j4, i5);
                    return g2;
                }
                return i2;
            case 53:
            case 54:
                if (i6 == 0) {
                    g2 = v.g(bArr, i2, wVar);
                    j3 = wVar.f6599b;
                    valueOf3 = Long.valueOf(j3);
                    unsafe.putObject(t, j2, valueOf3);
                    unsafe.putInt(t, j4, i5);
                    return g2;
                }
                return i2;
            case 55:
            case 62:
                if (i6 == 0) {
                    g2 = v.e(bArr, i2, wVar);
                    i10 = wVar.a;
                    valueOf3 = Integer.valueOf(i10);
                    unsafe.putObject(t, j2, valueOf3);
                    unsafe.putInt(t, j4, i5);
                    return g2;
                }
                return i2;
            case 56:
            case 65:
                if (i6 == 1) {
                    valueOf = Long.valueOf(v.k(bArr, i2));
                    unsafe.putObject(t, j2, valueOf);
                    g2 = i2 + 8;
                    unsafe.putInt(t, j4, i5);
                    return g2;
                }
                return i2;
            case 57:
            case 64:
                if (i6 == 5) {
                    valueOf2 = Integer.valueOf(v.h(bArr, i2));
                    unsafe.putObject(t, j2, valueOf2);
                    g2 = i2 + 4;
                    unsafe.putInt(t, j4, i5);
                    return g2;
                }
                return i2;
            case 58:
                if (i6 == 0) {
                    g2 = v.g(bArr, i2, wVar);
                    valueOf3 = Boolean.valueOf(wVar.f6599b != 0);
                    unsafe.putObject(t, j2, valueOf3);
                    unsafe.putInt(t, j4, i5);
                    return g2;
                }
                return i2;
            case 59:
                if (i6 == 2) {
                    g2 = v.e(bArr, i2, wVar);
                    i11 = wVar.a;
                    if (i11 == 0) {
                        valueOf3 = "";
                        unsafe.putObject(t, j2, valueOf3);
                        unsafe.putInt(t, j4, i5);
                        return g2;
                    } else if ((i7 & PKIFailureInfo.duplicateCertReq) == 0 || z3.i(bArr, g2, g2 + i11)) {
                        unsafe.putObject(t, j2, new String(bArr, g2, i11, g1.a));
                        g2 += i11;
                        unsafe.putInt(t, j4, i5);
                        return g2;
                    } else {
                        throw zzco.e();
                    }
                }
                return i2;
            case 60:
                if (i6 == 2) {
                    g2 = m(C(i9), bArr, i2, i3, wVar);
                    Object object = unsafe.getInt(t, j4) == i5 ? unsafe.getObject(t, j2) : null;
                    valueOf3 = wVar.f6600c;
                    if (object != null) {
                        valueOf3 = g1.d(object, valueOf3);
                    }
                    unsafe.putObject(t, j2, valueOf3);
                    unsafe.putInt(t, j4, i5);
                    return g2;
                }
                return i2;
            case 61:
                if (i6 == 2) {
                    g2 = v.e(bArr, i2, wVar);
                    i11 = wVar.a;
                    if (i11 == 0) {
                        valueOf3 = a0.a;
                        unsafe.putObject(t, j2, valueOf3);
                        unsafe.putInt(t, j4, i5);
                        return g2;
                    }
                    unsafe.putObject(t, j2, a0.q(bArr, g2, i11));
                    g2 += i11;
                    unsafe.putInt(t, j4, i5);
                    return g2;
                }
                return i2;
            case 63:
                if (i6 == 0) {
                    int e2 = v.e(bArr, i2, wVar);
                    int i12 = wVar.a;
                    i1<?> E = E(i9);
                    if (E != null && E.c(i12) == null) {
                        T(t).e(i4, Long.valueOf(i12));
                        return e2;
                    }
                    unsafe.putObject(t, j2, Integer.valueOf(i12));
                    g2 = e2;
                    unsafe.putInt(t, j4, i5);
                    return g2;
                }
                return i2;
            case 66:
                if (i6 == 0) {
                    g2 = v.e(bArr, i2, wVar);
                    i10 = j0.e(wVar.a);
                    valueOf3 = Integer.valueOf(i10);
                    unsafe.putObject(t, j2, valueOf3);
                    unsafe.putInt(t, j4, i5);
                    return g2;
                }
                return i2;
            case 67:
                if (i6 == 0) {
                    g2 = v.g(bArr, i2, wVar);
                    j3 = j0.a(wVar.f6599b);
                    valueOf3 = Long.valueOf(j3);
                    unsafe.putObject(t, j2, valueOf3);
                    unsafe.putInt(t, j4, i5);
                    return g2;
                }
                return i2;
            case 68:
                if (i6 == 3) {
                    g2 = l(C(i9), bArr, i2, i3, (i4 & (-8)) | 4, wVar);
                    Object object2 = unsafe.getInt(t, j4) == i5 ? unsafe.getObject(t, j2) : null;
                    valueOf3 = wVar.f6600c;
                    if (object2 != null) {
                        valueOf3 = g1.d(object2, valueOf3);
                    }
                    unsafe.putObject(t, j2, valueOf3);
                    unsafe.putInt(t, j4, i5);
                    return g2;
                }
                return i2;
            default:
                return i2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x0233, code lost:
        if (r29.f6599b != 0) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0235, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0237, code lost:
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0238, code lost:
        r12.i(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x023b, code lost:
        if (r4 >= r19) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x023d, code lost:
        r6 = com.google.android.gms.internal.clearcut.v.e(r17, r4, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0243, code lost:
        if (r20 != r29.a) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0245, code lost:
        r4 = com.google.android.gms.internal.clearcut.v.g(r17, r6, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x024d, code lost:
        if (r29.f6599b == 0) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:?, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:?, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0137, code lost:
        if (r4 == 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0139, code lost:
        r12.add(com.google.android.gms.internal.clearcut.a0.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x013f, code lost:
        r12.add(com.google.android.gms.internal.clearcut.a0.q(r17, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0147, code lost:
        if (r1 >= r19) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0149, code lost:
        r4 = com.google.android.gms.internal.clearcut.v.e(r17, r1, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x014f, code lost:
        if (r20 != r29.a) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0151, code lost:
        r1 = com.google.android.gms.internal.clearcut.v.e(r17, r4, r29);
        r4 = r29.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0157, code lost:
        if (r4 != 0) goto L82;
     */
    /* JADX WARN: Removed duplicated region for block: B:245:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:247:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x01e2 -> B:91:0x01bb). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:126:0x0237 -> B:127:0x0238). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:132:0x024d -> B:125:0x0235). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x013f -> B:66:0x0147). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0157 -> B:64:0x0139). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0194 -> B:82:0x0198). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x01a8 -> B:79:0x0189). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x01ce -> B:96:0x01d2). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int p(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.clearcut.w r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 994
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.m2.p(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.clearcut.w):int");
    }

    private final <K, V> int q(T t, byte[] bArr, int i2, int i3, int i4, int i5, long j2, w wVar) throws IOException {
        Unsafe unsafe = a;
        Object D = D(i4);
        Object object = unsafe.getObject(t, j2);
        if (this.s.e(object)) {
            Object a2 = this.s.a(D);
            this.s.g(a2, object);
            unsafe.putObject(t, j2, a2);
            object = a2;
        }
        this.s.h(D);
        this.s.j(object);
        int e2 = v.e(bArr, i2, wVar);
        int i6 = wVar.a;
        if (i6 < 0 || i6 > i3 - e2) {
            throw zzco.a();
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0372 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int r(T r27, byte[] r28, int r29, int r30, int r31, com.google.android.gms.internal.clearcut.w r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1072
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.m2.r(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.clearcut.w):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> m2<T> s(Class<T> cls, g2 g2Var, p2 p2Var, s1 s1Var, q3<?, ?> q3Var, r0<?> r0Var, d2 d2Var) {
        int k2;
        int i2;
        int i3;
        int b2;
        int i4;
        int i5;
        if (!(g2Var instanceof w2)) {
            ((m3) g2Var).a();
            throw new NoSuchMethodError();
        }
        w2 w2Var = (w2) g2Var;
        boolean z = w2Var.a() == e1.e.f6410j;
        if (w2Var.d() == 0) {
            k2 = 0;
            i2 = 0;
            i3 = 0;
        } else {
            int f2 = w2Var.f();
            int g2 = w2Var.g();
            k2 = w2Var.k();
            i2 = f2;
            i3 = g2;
        }
        int[] iArr = new int[k2 << 2];
        Object[] objArr = new Object[k2 << 1];
        int[] iArr2 = w2Var.h() > 0 ? new int[w2Var.h()] : null;
        int[] iArr3 = w2Var.i() > 0 ? new int[w2Var.i()] : null;
        x2 e2 = w2Var.e();
        if (e2.a()) {
            int g3 = e2.g();
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                if (g3 >= w2Var.l() || i6 >= ((g3 - i2) << 2)) {
                    if (e2.k()) {
                        b2 = (int) x3.b(e2.l());
                        i4 = (int) x3.b(e2.m());
                        i5 = 0;
                    } else {
                        b2 = (int) x3.b(e2.n());
                        if (e2.o()) {
                            i4 = (int) x3.b(e2.p());
                            i5 = e2.q();
                        } else {
                            i4 = 0;
                            i5 = 0;
                        }
                    }
                    iArr[i6] = e2.g();
                    int i9 = i6 + 1;
                    iArr[i9] = (e2.s() ? PKIFailureInfo.duplicateCertReq : 0) | (e2.r() ? 268435456 : 0) | (e2.h() << 20) | b2;
                    iArr[i6 + 2] = i4 | (i5 << 20);
                    if (e2.v() != null) {
                        int i10 = (i6 / 4) << 1;
                        objArr[i10] = e2.v();
                        if (e2.t() != null) {
                            objArr[i10 + 1] = e2.t();
                        } else if (e2.u() != null) {
                            objArr[i10 + 1] = e2.u();
                        }
                    } else if (e2.t() != null) {
                        objArr[((i6 / 4) << 1) + 1] = e2.t();
                    } else if (e2.u() != null) {
                        objArr[((i6 / 4) << 1) + 1] = e2.u();
                    }
                    int h2 = e2.h();
                    if (h2 == z0.c0.ordinal()) {
                        iArr2[i7] = i6;
                        i7++;
                    } else if (h2 >= 18 && h2 <= 49) {
                        iArr3[i8] = iArr[i9] & 1048575;
                        i8++;
                    }
                    if (!e2.a()) {
                        break;
                    }
                    g3 = e2.g();
                } else {
                    for (int i11 = 0; i11 < 4; i11++) {
                        iArr[i6 + i11] = -1;
                    }
                }
                i6 += 4;
            }
        }
        return new m2<>(iArr, objArr, i2, i3, w2Var.l(), w2Var.c(), z, false, w2Var.j(), iArr2, iArr3, p2Var, s1Var, q3Var, r0Var, d2Var);
    }

    private final <K, V, UT, UB> UB t(int i2, int i3, Map<K, V> map, i1<?> i1Var, UB ub, q3<UT, UB> q3Var) {
        b2<?, ?> h2 = this.s.h(D(i2));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (i1Var.c(((Integer) next.getValue()).intValue()) == null) {
                if (ub == null) {
                    ub = q3Var.f();
                }
                f0 t = a0.t(a2.a(h2, next.getKey(), next.getValue()));
                try {
                    a2.b(t.b(), h2, next.getKey(), next.getValue());
                    q3Var.b(ub, i3, t.a());
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    private static void u(int i2, Object obj, l4 l4Var) throws IOException {
        if (obj instanceof String) {
            l4Var.m(i2, (String) obj);
        } else {
            l4Var.M(i2, (a0) obj);
        }
    }

    private static <UT, UB> void v(q3<UT, UB> q3Var, T t, l4 l4Var) throws IOException {
        q3Var.c(q3Var.k(t), l4Var);
    }

    private final <K, V> void w(l4 l4Var, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            l4Var.R(i2, this.s.h(D(i3)), this.s.i(obj));
        }
    }

    private final void x(T t, T t2, int i2) {
        long F = F(i2) & 1048575;
        if (y(t2, i2)) {
            Object M = x3.M(t, F);
            Object M2 = x3.M(t2, F);
            if (M != null && M2 != null) {
                x3.i(t, F, g1.d(M, M2));
                I(t, i2);
            } else if (M2 != null) {
                x3.i(t, F, M2);
                I(t, i2);
            }
        }
    }

    private final boolean y(T t, int i2) {
        if (!this.f6513j) {
            int G = G(i2);
            return (x3.H(t, (long) (G & 1048575)) & (1 << (G >>> 20))) != 0;
        }
        int F = F(i2);
        long j2 = F & 1048575;
        switch ((F & 267386880) >>> 20) {
            case 0:
                return x3.L(t, j2) != 0.0d;
            case 1:
                return x3.K(t, j2) != 0.0f;
            case 2:
                return x3.I(t, j2) != 0;
            case 3:
                return x3.I(t, j2) != 0;
            case 4:
                return x3.H(t, j2) != 0;
            case 5:
                return x3.I(t, j2) != 0;
            case 6:
                return x3.H(t, j2) != 0;
            case 7:
                return x3.J(t, j2);
            case 8:
                Object M = x3.M(t, j2);
                if (M instanceof String) {
                    return !((String) M).isEmpty();
                } else if (M instanceof a0) {
                    return !a0.a.equals(M);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return x3.M(t, j2) != null;
            case 10:
                return !a0.a.equals(x3.M(t, j2));
            case 11:
                return x3.H(t, j2) != 0;
            case 12:
                return x3.H(t, j2) != 0;
            case 13:
                return x3.H(t, j2) != 0;
            case 14:
                return x3.I(t, j2) != 0;
            case 15:
                return x3.H(t, j2) != 0;
            case 16:
                return x3.I(t, j2) != 0;
            case 17:
                return x3.M(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean z(T t, int i2, int i3) {
        return x3.H(t, (long) (G(i3) & 1048575)) == i2;
    }

    @Override // com.google.android.gms.internal.clearcut.z2
    public final void b(T t) {
        int[] iArr = this.m;
        if (iArr != null) {
            for (int i2 : iArr) {
                long F = F(i2) & 1048575;
                Object M = x3.M(t, F);
                if (M != null) {
                    x3.i(t, F, this.s.b(M));
                }
            }
        }
        int[] iArr2 = this.n;
        if (iArr2 != null) {
            for (int i3 : iArr2) {
                this.p.a(t, i3);
            }
        }
        this.q.d(t);
        if (this.f6511h) {
            this.r.f(t);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.z2
    public final void c(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i2 = 0; i2 < this.f6505b.length; i2 += 4) {
            int F = F(i2);
            long j2 = 1048575 & F;
            int i3 = this.f6505b[i2];
            switch ((F & 267386880) >>> 20) {
                case 0:
                    if (y(t2, i2)) {
                        x3.e(t, j2, x3.L(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (y(t2, i2)) {
                        x3.f(t, j2, x3.K(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (!y(t2, i2)) {
                        break;
                    }
                    x3.h(t, j2, x3.I(t2, j2));
                    I(t, i2);
                    break;
                case 3:
                    if (!y(t2, i2)) {
                        break;
                    }
                    x3.h(t, j2, x3.I(t2, j2));
                    I(t, i2);
                    break;
                case 4:
                    if (!y(t2, i2)) {
                        break;
                    }
                    x3.g(t, j2, x3.H(t2, j2));
                    I(t, i2);
                    break;
                case 5:
                    if (!y(t2, i2)) {
                        break;
                    }
                    x3.h(t, j2, x3.I(t2, j2));
                    I(t, i2);
                    break;
                case 6:
                    if (!y(t2, i2)) {
                        break;
                    }
                    x3.g(t, j2, x3.H(t2, j2));
                    I(t, i2);
                    break;
                case 7:
                    if (y(t2, i2)) {
                        x3.j(t, j2, x3.J(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!y(t2, i2)) {
                        break;
                    }
                    x3.i(t, j2, x3.M(t2, j2));
                    I(t, i2);
                    break;
                case 9:
                case 17:
                    x(t, t2, i2);
                    break;
                case 10:
                    if (!y(t2, i2)) {
                        break;
                    }
                    x3.i(t, j2, x3.M(t2, j2));
                    I(t, i2);
                    break;
                case 11:
                    if (!y(t2, i2)) {
                        break;
                    }
                    x3.g(t, j2, x3.H(t2, j2));
                    I(t, i2);
                    break;
                case 12:
                    if (!y(t2, i2)) {
                        break;
                    }
                    x3.g(t, j2, x3.H(t2, j2));
                    I(t, i2);
                    break;
                case 13:
                    if (!y(t2, i2)) {
                        break;
                    }
                    x3.g(t, j2, x3.H(t2, j2));
                    I(t, i2);
                    break;
                case 14:
                    if (!y(t2, i2)) {
                        break;
                    }
                    x3.h(t, j2, x3.I(t2, j2));
                    I(t, i2);
                    break;
                case 15:
                    if (!y(t2, i2)) {
                        break;
                    }
                    x3.g(t, j2, x3.H(t2, j2));
                    I(t, i2);
                    break;
                case 16:
                    if (!y(t2, i2)) {
                        break;
                    }
                    x3.h(t, j2, x3.I(t2, j2));
                    I(t, i2);
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
                    b3.h(this.s, t, t2, j2);
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
                    if (!z(t2, i3, i2)) {
                        break;
                    }
                    x3.i(t, j2, x3.M(t2, j2));
                    J(t, i3, i2);
                    break;
                case 60:
                case 68:
                    L(t, t2, i2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!z(t2, i3, i2)) {
                        break;
                    }
                    x3.i(t, j2, x3.M(t2, j2));
                    J(t, i3, i2);
                    break;
            }
        }
        if (this.f6513j) {
            return;
        }
        b3.i(this.q, t, t2);
        if (this.f6511h) {
            b3.g(this.r, t, t2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0181, code lost:
        if (r19.f6514k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0193, code lost:
        if (r19.f6514k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01a5, code lost:
        if (r19.f6514k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01b6, code lost:
        if (r19.f6514k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01c7, code lost:
        if (r19.f6514k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x01d8, code lost:
        if (r19.f6514k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01e9, code lost:
        if (r19.f6514k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01fa, code lost:
        if (r19.f6514k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x020b, code lost:
        if (r19.f6514k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x020d, code lost:
        r2.putInt(r20, r14, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0211, code lost:
        r3 = (com.google.android.gms.internal.clearcut.zzbn.B0(r3) + com.google.android.gms.internal.clearcut.zzbn.D0(r5)) + r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0331, code lost:
        if ((r5 instanceof com.google.android.gms.internal.clearcut.a0) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0334, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.C(r3, (java.lang.String) r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0414, code lost:
        if (z(r20, r15, r5) != false) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0434, code lost:
        if (z(r20, r15, r5) != false) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x043c, code lost:
        if (z(r20, r15, r5) != false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x045c, code lost:
        if (z(r20, r15, r5) != false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0464, code lost:
        if (z(r20, r15, r5) != false) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0474, code lost:
        if ((r4 instanceof com.google.android.gms.internal.clearcut.a0) != false) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x047c, code lost:
        if (z(r20, r15, r5) != false) goto L305;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x0514, code lost:
        if (r19.f6514k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x0526, code lost:
        if (r19.f6514k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x0538, code lost:
        if (r19.f6514k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x054a, code lost:
        if (r19.f6514k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x055c, code lost:
        if (r19.f6514k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x056e, code lost:
        if (r19.f6514k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0580, code lost:
        if (r19.f6514k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x0592, code lost:
        if (r19.f6514k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x05a3, code lost:
        if (r19.f6514k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x05b4, code lost:
        if (r19.f6514k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x05c5, code lost:
        if (r19.f6514k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x05d6, code lost:
        if (r19.f6514k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x05e7, code lost:
        if (r19.f6514k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x05f8, code lost:
        if (r19.f6514k != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x05fa, code lost:
        r2.putInt(r20, r9, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x05fe, code lost:
        r9 = (com.google.android.gms.internal.clearcut.zzbn.B0(r15) + com.google.android.gms.internal.clearcut.zzbn.D0(r4)) + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x06c4, code lost:
        if ((r12 & r18) != 0) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x06c6, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.P(r15, (com.google.android.gms.internal.clearcut.i2) r2.getObject(r20, r10), C(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x06f1, code lost:
        if ((r12 & r18) != 0) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x06f3, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.o0(r15, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x06fc, code lost:
        if ((r12 & r18) != 0) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x06fe, code lost:
        r9 = com.google.android.gms.internal.clearcut.zzbn.v0(r15, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x0721, code lost:
        if ((r12 & r18) != 0) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x0723, code lost:
        r4 = r2.getObject(r20, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x0727, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.N(r15, (com.google.android.gms.internal.clearcut.a0) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x0730, code lost:
        if ((r12 & r18) != 0) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x0732, code lost:
        r4 = com.google.android.gms.internal.clearcut.b3.n(r15, r2.getObject(r20, r10), C(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:430:0x074a, code lost:
        if ((r4 instanceof com.google.android.gms.internal.clearcut.a0) != false) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:432:0x074d, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.C(r15, (java.lang.String) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x0757, code lost:
        if ((r12 & r18) != 0) goto L305;
     */
    /* JADX WARN: Code restructure failed: missing block: B:435:0x0759, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.Q(r15, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ab, code lost:
        if ((r5 instanceof com.google.android.gms.internal.clearcut.a0) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0127, code lost:
        if (r19.f6514k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0139, code lost:
        if (r19.f6514k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x014b, code lost:
        if (r19.f6514k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x015d, code lost:
        if (r19.f6514k != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x016f, code lost:
        if (r19.f6514k != false) goto L104;
     */
    @Override // com.google.android.gms.internal.clearcut.z2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int d(T r20) {
        /*
            Method dump skipped, instructions count: 2306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.m2.d(java.lang.Object):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x01a0, code lost:
        if (com.google.android.gms.internal.clearcut.x3.I(r10, r6) == com.google.android.gms.internal.clearcut.x3.I(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (com.google.android.gms.internal.clearcut.b3.y(com.google.android.gms.internal.clearcut.x3.M(r10, r6), com.google.android.gms.internal.clearcut.x3.M(r11, r6)) != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
        if (com.google.android.gms.internal.clearcut.b3.y(com.google.android.gms.internal.clearcut.x3.M(r10, r6), com.google.android.gms.internal.clearcut.x3.M(r11, r6)) != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
        if (com.google.android.gms.internal.clearcut.x3.I(r10, r6) == com.google.android.gms.internal.clearcut.x3.I(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
        if (com.google.android.gms.internal.clearcut.x3.H(r10, r6) == com.google.android.gms.internal.clearcut.x3.H(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0096, code lost:
        if (com.google.android.gms.internal.clearcut.x3.I(r10, r6) == com.google.android.gms.internal.clearcut.x3.I(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a8, code lost:
        if (com.google.android.gms.internal.clearcut.x3.H(r10, r6) == com.google.android.gms.internal.clearcut.x3.H(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ba, code lost:
        if (com.google.android.gms.internal.clearcut.x3.H(r10, r6) == com.google.android.gms.internal.clearcut.x3.H(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00cc, code lost:
        if (com.google.android.gms.internal.clearcut.x3.H(r10, r6) == com.google.android.gms.internal.clearcut.x3.H(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e2, code lost:
        if (com.google.android.gms.internal.clearcut.b3.y(com.google.android.gms.internal.clearcut.x3.M(r10, r6), com.google.android.gms.internal.clearcut.x3.M(r11, r6)) != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f8, code lost:
        if (com.google.android.gms.internal.clearcut.b3.y(com.google.android.gms.internal.clearcut.x3.M(r10, r6), com.google.android.gms.internal.clearcut.x3.M(r11, r6)) != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x010e, code lost:
        if (com.google.android.gms.internal.clearcut.b3.y(com.google.android.gms.internal.clearcut.x3.M(r10, r6), com.google.android.gms.internal.clearcut.x3.M(r11, r6)) != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0120, code lost:
        if (com.google.android.gms.internal.clearcut.x3.J(r10, r6) == com.google.android.gms.internal.clearcut.x3.J(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0132, code lost:
        if (com.google.android.gms.internal.clearcut.x3.H(r10, r6) == com.google.android.gms.internal.clearcut.x3.H(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0145, code lost:
        if (com.google.android.gms.internal.clearcut.x3.I(r10, r6) == com.google.android.gms.internal.clearcut.x3.I(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0156, code lost:
        if (com.google.android.gms.internal.clearcut.x3.H(r10, r6) == com.google.android.gms.internal.clearcut.x3.H(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0169, code lost:
        if (com.google.android.gms.internal.clearcut.x3.I(r10, r6) == com.google.android.gms.internal.clearcut.x3.I(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x017c, code lost:
        if (com.google.android.gms.internal.clearcut.x3.I(r10, r6) == com.google.android.gms.internal.clearcut.x3.I(r11, r6)) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x018d, code lost:
        if (com.google.android.gms.internal.clearcut.x3.H(r10, r6) == com.google.android.gms.internal.clearcut.x3.H(r11, r6)) goto L84;
     */
    @Override // com.google.android.gms.internal.clearcut.z2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean e(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 610
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.m2.e(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ce, code lost:
        if (r3 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e0, code lost:
        if (r3 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e2, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e6, code lost:
        r2 = (r2 * 53) + r7;
     */
    @Override // com.google.android.gms.internal.clearcut.z2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int f(T r9) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.m2.f(java.lang.Object):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0976  */
    @Override // com.google.android.gms.internal.clearcut.z2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(T r14, com.google.android.gms.internal.clearcut.l4 r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2736
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.m2.g(java.lang.Object, com.google.android.gms.internal.clearcut.l4):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0164, code lost:
        if (r0 == r15) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0188, code lost:
        if (r0 == r15) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01a1, code lost:
        if (r0 == r15) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a3, code lost:
        r2 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v25, types: [int] */
    @Override // com.google.android.gms.internal.clearcut.z2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h(T r23, byte[] r24, int r25, int r26, com.google.android.gms.internal.clearcut.w r27) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.m2.h(java.lang.Object, byte[], int, int, com.google.android.gms.internal.clearcut.w):void");
    }

    @Override // com.google.android.gms.internal.clearcut.z2
    public final T i() {
        return (T) this.o.a(this.f6510g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.clearcut.z2
    public final boolean j(T t) {
        int i2;
        int i3;
        boolean z;
        int[] iArr = this.f6515l;
        if (iArr != null && iArr.length != 0) {
            int i4 = -1;
            int length = iArr.length;
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6 = i2 + 1) {
                int i7 = iArr[i6];
                int H = H(i7);
                int F = F(H);
                if (this.f6513j) {
                    i2 = i6;
                    i3 = 0;
                } else {
                    int i8 = this.f6505b[H + 2];
                    int i9 = i8 & 1048575;
                    i3 = 1 << (i8 >>> 20);
                    if (i9 != i4) {
                        i2 = i6;
                        i5 = a.getInt(t, i9);
                        i4 = i9;
                    } else {
                        i2 = i6;
                    }
                }
                if (((268435456 & F) != 0) && !A(t, H, i5, i3)) {
                    return false;
                }
                int i10 = (267386880 & F) >>> 20;
                if (i10 != 9 && i10 != 17) {
                    if (i10 != 27) {
                        if (i10 == 60 || i10 == 68) {
                            if (z(t, i7, H) && !B(t, F, C(H))) {
                                return false;
                            }
                        } else if (i10 != 49) {
                            if (i10 == 50 && !this.s.i(x3.M(t, F & 1048575)).isEmpty()) {
                                this.s.h(D(H));
                                throw null;
                            }
                        }
                    }
                    List list = (List) x3.M(t, F & 1048575);
                    if (!list.isEmpty()) {
                        z2 C = C(H);
                        for (int i11 = 0; i11 < list.size(); i11++) {
                            if (!C.j(list.get(i11))) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    if (!z) {
                        return false;
                    }
                } else if (A(t, H, i5, i3) && !B(t, F, C(H))) {
                    return false;
                }
            }
            if (this.f6511h && !this.r.b(t).d()) {
                return false;
            }
        }
        return true;
    }
}