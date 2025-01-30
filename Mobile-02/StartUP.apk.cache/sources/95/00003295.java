package com.google.android.gms.internal.clearcut;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class f5 extends n4<f5> implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private String[] f6442c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f6443d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f6444e;

    /* renamed from: f  reason: collision with root package name */
    private long[] f6445f;

    /* renamed from: g  reason: collision with root package name */
    private long[] f6446g;

    public f5() {
        String[] strArr = v4.f6585f;
        this.f6442c = strArr;
        this.f6443d = strArr;
        this.f6444e = v4.a;
        long[] jArr = v4.f6581b;
        this.f6445f = jArr;
        this.f6446g = jArr;
        this.f6521b = null;
        this.a = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.clearcut.n4, com.google.android.gms.internal.clearcut.s4
    /* renamed from: i */
    public final f5 clone() {
        try {
            f5 f5Var = (f5) super.clone();
            String[] strArr = this.f6442c;
            if (strArr != null && strArr.length > 0) {
                f5Var.f6442c = (String[]) strArr.clone();
            }
            String[] strArr2 = this.f6443d;
            if (strArr2 != null && strArr2.length > 0) {
                f5Var.f6443d = (String[]) strArr2.clone();
            }
            int[] iArr = this.f6444e;
            if (iArr != null && iArr.length > 0) {
                f5Var.f6444e = (int[]) iArr.clone();
            }
            long[] jArr = this.f6445f;
            if (jArr != null && jArr.length > 0) {
                f5Var.f6445f = (long[]) jArr.clone();
            }
            long[] jArr2 = this.f6446g;
            if (jArr2 != null && jArr2.length > 0) {
                f5Var.f6446g = (long[]) jArr2.clone();
            }
            return f5Var;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.n4, com.google.android.gms.internal.clearcut.s4
    public final void b(m4 m4Var) throws IOException {
        String[] strArr = this.f6442c;
        int i2 = 0;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f6442c;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    m4Var.c(1, str);
                }
                i3++;
            }
        }
        String[] strArr3 = this.f6443d;
        if (strArr3 != null && strArr3.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr4 = this.f6443d;
                if (i4 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i4];
                if (str2 != null) {
                    m4Var.c(2, str2);
                }
                i4++;
            }
        }
        int[] iArr = this.f6444e;
        if (iArr != null && iArr.length > 0) {
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.f6444e;
                if (i5 >= iArr2.length) {
                    break;
                }
                m4Var.l(3, iArr2[i5]);
                i5++;
            }
        }
        long[] jArr = this.f6445f;
        if (jArr != null && jArr.length > 0) {
            int i6 = 0;
            while (true) {
                long[] jArr2 = this.f6445f;
                if (i6 >= jArr2.length) {
                    break;
                }
                m4Var.u(4, jArr2[i6]);
                i6++;
            }
        }
        long[] jArr3 = this.f6446g;
        if (jArr3 != null && jArr3.length > 0) {
            while (true) {
                long[] jArr4 = this.f6446g;
                if (i2 >= jArr4.length) {
                    break;
                }
                m4Var.u(5, jArr4[i2]);
                i2++;
            }
        }
        super.b(m4Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.clearcut.n4, com.google.android.gms.internal.clearcut.s4
    public final int e() {
        long[] jArr;
        int[] iArr;
        int e2 = super.e();
        String[] strArr = this.f6442c;
        int i2 = 0;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                String[] strArr2 = this.f6442c;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    i5++;
                    i4 += m4.r(str);
                }
                i3++;
            }
            e2 = e2 + i4 + (i5 * 1);
        }
        String[] strArr3 = this.f6443d;
        if (strArr3 != null && strArr3.length > 0) {
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                String[] strArr4 = this.f6443d;
                if (i6 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i6];
                if (str2 != null) {
                    i8++;
                    i7 += m4.r(str2);
                }
                i6++;
            }
            e2 = e2 + i7 + (i8 * 1);
        }
        int[] iArr2 = this.f6444e;
        if (iArr2 != null && iArr2.length > 0) {
            int i9 = 0;
            int i10 = 0;
            while (true) {
                iArr = this.f6444e;
                if (i9 >= iArr.length) {
                    break;
                }
                i10 += m4.z(iArr[i9]);
                i9++;
            }
            e2 = e2 + i10 + (iArr.length * 1);
        }
        long[] jArr2 = this.f6445f;
        if (jArr2 != null && jArr2.length > 0) {
            int i11 = 0;
            int i12 = 0;
            while (true) {
                jArr = this.f6445f;
                if (i11 >= jArr.length) {
                    break;
                }
                i12 += m4.x(jArr[i11]);
                i11++;
            }
            e2 = e2 + i12 + (jArr.length * 1);
        }
        long[] jArr3 = this.f6446g;
        if (jArr3 == null || jArr3.length <= 0) {
            return e2;
        }
        int i13 = 0;
        while (true) {
            long[] jArr4 = this.f6446g;
            if (i2 >= jArr4.length) {
                return e2 + i13 + (jArr4.length * 1);
            }
            i13 += m4.x(jArr4[i2]);
            i2++;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f5) {
            f5 f5Var = (f5) obj;
            if (r4.c(this.f6442c, f5Var.f6442c) && r4.c(this.f6443d, f5Var.f6443d) && r4.a(this.f6444e, f5Var.f6444e) && r4.b(this.f6445f, f5Var.f6445f) && r4.b(this.f6446g, f5Var.f6446g)) {
                p4 p4Var = this.f6521b;
                if (p4Var == null || p4Var.b()) {
                    p4 p4Var2 = f5Var.f6521b;
                    return p4Var2 == null || p4Var2.b();
                }
                return this.f6521b.equals(f5Var.f6521b);
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.clearcut.n4, com.google.android.gms.internal.clearcut.s4
    public final /* synthetic */ s4 f() throws CloneNotSupportedException {
        return (f5) clone();
    }

    @Override // com.google.android.gms.internal.clearcut.n4
    public final /* synthetic */ f5 h() throws CloneNotSupportedException {
        return (f5) clone();
    }

    public final int hashCode() {
        int hashCode = (((((((((((f5.class.getName().hashCode() + 527) * 31) + r4.f(this.f6442c)) * 31) + r4.f(this.f6443d)) * 31) + r4.d(this.f6444e)) * 31) + r4.e(this.f6445f)) * 31) + r4.e(this.f6446g)) * 31;
        p4 p4Var = this.f6521b;
        return hashCode + ((p4Var == null || p4Var.b()) ? 0 : this.f6521b.hashCode());
    }
}