package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class i5 extends n4<i5> implements Cloneable {
    private int A;
    private int[] B;
    private long C;
    private x4 D;
    public boolean E;

    /* renamed from: c  reason: collision with root package name */
    public long f6459c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f6460d = 0;

    /* renamed from: e  reason: collision with root package name */
    private long f6461e = 0;

    /* renamed from: f  reason: collision with root package name */
    private String f6462f = "";

    /* renamed from: g  reason: collision with root package name */
    public int f6463g = 0;

    /* renamed from: h  reason: collision with root package name */
    private String f6464h = "";

    /* renamed from: j  reason: collision with root package name */
    private int f6465j = 0;

    /* renamed from: k  reason: collision with root package name */
    private boolean f6466k = false;

    /* renamed from: l  reason: collision with root package name */
    private j5[] f6467l = j5.i();
    private byte[] m;
    private w4 n;
    public byte[] p;
    private String q;
    private String t;
    private f5 u;
    private String v;
    public long w;
    private g5 x;
    public byte[] y;
    private String z;

    public i5() {
        byte[] bArr = v4.f6587h;
        this.m = bArr;
        this.n = null;
        this.p = bArr;
        this.q = "";
        this.t = "";
        this.u = null;
        this.v = "";
        this.w = 180000L;
        this.x = null;
        this.y = bArr;
        this.z = "";
        this.A = 0;
        this.B = v4.a;
        this.C = 0L;
        this.D = null;
        this.E = false;
        this.f6521b = null;
        this.a = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.clearcut.n4, com.google.android.gms.internal.clearcut.s4
    /* renamed from: i */
    public final i5 clone() {
        try {
            i5 i5Var = (i5) super.clone();
            j5[] j5VarArr = this.f6467l;
            if (j5VarArr != null && j5VarArr.length > 0) {
                i5Var.f6467l = new j5[j5VarArr.length];
                int i2 = 0;
                while (true) {
                    j5[] j5VarArr2 = this.f6467l;
                    if (i2 >= j5VarArr2.length) {
                        break;
                    }
                    if (j5VarArr2[i2] != null) {
                        i5Var.f6467l[i2] = (j5) j5VarArr2[i2].clone();
                    }
                    i2++;
                }
            }
            w4 w4Var = this.n;
            if (w4Var != null) {
                i5Var.n = w4Var;
            }
            f5 f5Var = this.u;
            if (f5Var != null) {
                i5Var.u = (f5) f5Var.clone();
            }
            g5 g5Var = this.x;
            if (g5Var != null) {
                i5Var.x = (g5) g5Var.clone();
            }
            int[] iArr = this.B;
            if (iArr != null && iArr.length > 0) {
                i5Var.B = (int[]) iArr.clone();
            }
            x4 x4Var = this.D;
            if (x4Var != null) {
                i5Var.D = x4Var;
            }
            return i5Var;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.n4, com.google.android.gms.internal.clearcut.s4
    public final void b(m4 m4Var) throws IOException {
        long j2 = this.f6459c;
        if (j2 != 0) {
            m4Var.u(1, j2);
        }
        String str = this.f6462f;
        if (str != null && !str.equals("")) {
            m4Var.c(2, this.f6462f);
        }
        j5[] j5VarArr = this.f6467l;
        int i2 = 0;
        if (j5VarArr != null && j5VarArr.length > 0) {
            int i3 = 0;
            while (true) {
                j5[] j5VarArr2 = this.f6467l;
                if (i3 >= j5VarArr2.length) {
                    break;
                }
                j5 j5Var = j5VarArr2[i3];
                if (j5Var != null) {
                    m4Var.b(3, j5Var);
                }
                i3++;
            }
        }
        byte[] bArr = this.m;
        byte[] bArr2 = v4.f6587h;
        if (!Arrays.equals(bArr, bArr2)) {
            m4Var.d(4, this.m);
        }
        if (!Arrays.equals(this.p, bArr2)) {
            m4Var.d(6, this.p);
        }
        f5 f5Var = this.u;
        if (f5Var != null) {
            m4Var.b(7, f5Var);
        }
        String str2 = this.q;
        if (str2 != null && !str2.equals("")) {
            m4Var.c(8, this.q);
        }
        w4 w4Var = this.n;
        if (w4Var != null) {
            m4Var.o(9, w4Var);
        }
        int i4 = this.f6463g;
        if (i4 != 0) {
            m4Var.l(11, i4);
        }
        String str3 = this.t;
        if (str3 != null && !str3.equals("")) {
            m4Var.c(13, this.t);
        }
        String str4 = this.v;
        if (str4 != null && !str4.equals("")) {
            m4Var.c(14, this.v);
        }
        long j3 = this.w;
        if (j3 != 180000) {
            m4Var.j(15, 0);
            m4Var.w(m4.v(j3));
        }
        g5 g5Var = this.x;
        if (g5Var != null) {
            m4Var.b(16, g5Var);
        }
        long j4 = this.f6460d;
        if (j4 != 0) {
            m4Var.u(17, j4);
        }
        if (!Arrays.equals(this.y, bArr2)) {
            m4Var.d(18, this.y);
        }
        int[] iArr = this.B;
        if (iArr != null && iArr.length > 0) {
            while (true) {
                int[] iArr2 = this.B;
                if (i2 >= iArr2.length) {
                    break;
                }
                m4Var.l(20, iArr2[i2]);
                i2++;
            }
        }
        x4 x4Var = this.D;
        if (x4Var != null) {
            m4Var.o(23, x4Var);
        }
        String str5 = this.z;
        if (str5 != null && !str5.equals("")) {
            m4Var.c(24, this.z);
        }
        boolean z = this.E;
        if (z) {
            m4Var.k(25, z);
        }
        String str6 = this.f6464h;
        if (str6 != null && !str6.equals("")) {
            m4Var.c(26, this.f6464h);
        }
        super.b(m4Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.clearcut.n4, com.google.android.gms.internal.clearcut.s4
    public final int e() {
        int[] iArr;
        int e2 = super.e();
        long j2 = this.f6459c;
        if (j2 != 0) {
            e2 += m4.m(1, j2);
        }
        String str = this.f6462f;
        if (str != null && !str.equals("")) {
            e2 += m4.h(2, this.f6462f);
        }
        j5[] j5VarArr = this.f6467l;
        int i2 = 0;
        if (j5VarArr != null && j5VarArr.length > 0) {
            int i3 = 0;
            while (true) {
                j5[] j5VarArr2 = this.f6467l;
                if (i3 >= j5VarArr2.length) {
                    break;
                }
                j5 j5Var = j5VarArr2[i3];
                if (j5Var != null) {
                    e2 += m4.g(3, j5Var);
                }
                i3++;
            }
        }
        byte[] bArr = this.m;
        byte[] bArr2 = v4.f6587h;
        if (!Arrays.equals(bArr, bArr2)) {
            e2 += m4.i(4, this.m);
        }
        if (!Arrays.equals(this.p, bArr2)) {
            e2 += m4.i(6, this.p);
        }
        f5 f5Var = this.u;
        if (f5Var != null) {
            e2 += m4.g(7, f5Var);
        }
        String str2 = this.q;
        if (str2 != null && !str2.equals("")) {
            e2 += m4.h(8, this.q);
        }
        w4 w4Var = this.n;
        if (w4Var != null) {
            e2 += zzbn.O(9, w4Var);
        }
        int i4 = this.f6463g;
        if (i4 != 0) {
            e2 += m4.y(11) + m4.z(i4);
        }
        String str3 = this.t;
        if (str3 != null && !str3.equals("")) {
            e2 += m4.h(13, this.t);
        }
        String str4 = this.v;
        if (str4 != null && !str4.equals("")) {
            e2 += m4.h(14, this.v);
        }
        long j3 = this.w;
        if (j3 != 180000) {
            e2 += m4.y(15) + m4.x(m4.v(j3));
        }
        g5 g5Var = this.x;
        if (g5Var != null) {
            e2 += m4.g(16, g5Var);
        }
        long j4 = this.f6460d;
        if (j4 != 0) {
            e2 += m4.m(17, j4);
        }
        if (!Arrays.equals(this.y, bArr2)) {
            e2 += m4.i(18, this.y);
        }
        int[] iArr2 = this.B;
        if (iArr2 != null && iArr2.length > 0) {
            int i5 = 0;
            while (true) {
                iArr = this.B;
                if (i2 >= iArr.length) {
                    break;
                }
                i5 += m4.z(iArr[i2]);
                i2++;
            }
            e2 = e2 + i5 + (iArr.length * 2);
        }
        x4 x4Var = this.D;
        if (x4Var != null) {
            e2 += zzbn.O(23, x4Var);
        }
        String str5 = this.z;
        if (str5 != null && !str5.equals("")) {
            e2 += m4.h(24, this.z);
        }
        if (this.E) {
            e2 += m4.y(25) + 1;
        }
        String str6 = this.f6464h;
        return (str6 == null || str6.equals("")) ? e2 : e2 + m4.h(26, this.f6464h);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i5) {
            i5 i5Var = (i5) obj;
            if (this.f6459c == i5Var.f6459c && this.f6460d == i5Var.f6460d) {
                String str = this.f6462f;
                if (str == null) {
                    if (i5Var.f6462f != null) {
                        return false;
                    }
                } else if (!str.equals(i5Var.f6462f)) {
                    return false;
                }
                if (this.f6463g != i5Var.f6463g) {
                    return false;
                }
                String str2 = this.f6464h;
                if (str2 == null) {
                    if (i5Var.f6464h != null) {
                        return false;
                    }
                } else if (!str2.equals(i5Var.f6464h)) {
                    return false;
                }
                if (r4.c(this.f6467l, i5Var.f6467l) && Arrays.equals(this.m, i5Var.m)) {
                    w4 w4Var = this.n;
                    if (w4Var == null) {
                        if (i5Var.n != null) {
                            return false;
                        }
                    } else if (!w4Var.equals(i5Var.n)) {
                        return false;
                    }
                    if (Arrays.equals(this.p, i5Var.p)) {
                        String str3 = this.q;
                        if (str3 == null) {
                            if (i5Var.q != null) {
                                return false;
                            }
                        } else if (!str3.equals(i5Var.q)) {
                            return false;
                        }
                        String str4 = this.t;
                        if (str4 == null) {
                            if (i5Var.t != null) {
                                return false;
                            }
                        } else if (!str4.equals(i5Var.t)) {
                            return false;
                        }
                        f5 f5Var = this.u;
                        if (f5Var == null) {
                            if (i5Var.u != null) {
                                return false;
                            }
                        } else if (!f5Var.equals(i5Var.u)) {
                            return false;
                        }
                        String str5 = this.v;
                        if (str5 == null) {
                            if (i5Var.v != null) {
                                return false;
                            }
                        } else if (!str5.equals(i5Var.v)) {
                            return false;
                        }
                        if (this.w != i5Var.w) {
                            return false;
                        }
                        g5 g5Var = this.x;
                        if (g5Var == null) {
                            if (i5Var.x != null) {
                                return false;
                            }
                        } else if (!g5Var.equals(i5Var.x)) {
                            return false;
                        }
                        if (Arrays.equals(this.y, i5Var.y)) {
                            String str6 = this.z;
                            if (str6 == null) {
                                if (i5Var.z != null) {
                                    return false;
                                }
                            } else if (!str6.equals(i5Var.z)) {
                                return false;
                            }
                            if (r4.a(this.B, i5Var.B)) {
                                x4 x4Var = this.D;
                                if (x4Var == null) {
                                    if (i5Var.D != null) {
                                        return false;
                                    }
                                } else if (!x4Var.equals(i5Var.D)) {
                                    return false;
                                }
                                if (this.E != i5Var.E) {
                                    return false;
                                }
                                p4 p4Var = this.f6521b;
                                if (p4Var == null || p4Var.b()) {
                                    p4 p4Var2 = i5Var.f6521b;
                                    return p4Var2 == null || p4Var2.b();
                                }
                                return this.f6521b.equals(i5Var.f6521b);
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.clearcut.n4, com.google.android.gms.internal.clearcut.s4
    public final /* synthetic */ s4 f() throws CloneNotSupportedException {
        return (i5) clone();
    }

    @Override // com.google.android.gms.internal.clearcut.n4
    public final /* synthetic */ i5 h() throws CloneNotSupportedException {
        return (i5) clone();
    }

    public final int hashCode() {
        long j2 = this.f6459c;
        long j3 = this.f6460d;
        int hashCode = (((((i5.class.getName().hashCode() + 527) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31 * 31;
        String str = this.f6462f;
        int i2 = 0;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f6463g) * 31;
        String str2 = this.f6464h;
        int hashCode3 = ((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31 * 31) + 1237) * 31) + r4.f(this.f6467l)) * 31) + Arrays.hashCode(this.m);
        w4 w4Var = this.n;
        int hashCode4 = ((((hashCode3 * 31) + (w4Var == null ? 0 : w4Var.hashCode())) * 31) + Arrays.hashCode(this.p)) * 31;
        String str3 = this.q;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.t;
        int hashCode6 = hashCode5 + (str4 == null ? 0 : str4.hashCode());
        f5 f5Var = this.u;
        int hashCode7 = ((hashCode6 * 31) + (f5Var == null ? 0 : f5Var.hashCode())) * 31;
        String str5 = this.v;
        int hashCode8 = str5 == null ? 0 : str5.hashCode();
        long j4 = this.w;
        g5 g5Var = this.x;
        int hashCode9 = (((((((hashCode7 + hashCode8) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (g5Var == null ? 0 : g5Var.hashCode())) * 31) + Arrays.hashCode(this.y)) * 31;
        String str6 = this.z;
        int hashCode10 = str6 == null ? 0 : str6.hashCode();
        x4 x4Var = this.D;
        int d2 = (((((((hashCode9 + hashCode10) * 31 * 31) + r4.d(this.B)) * 31 * 31) + (x4Var == null ? 0 : x4Var.hashCode())) * 31) + (this.E ? 1231 : 1237)) * 31;
        p4 p4Var = this.f6521b;
        if (p4Var != null && !p4Var.b()) {
            i2 = this.f6521b.hashCode();
        }
        return d2 + i2;
    }
}