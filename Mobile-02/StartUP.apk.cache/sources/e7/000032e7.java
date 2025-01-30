package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.e1;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class r3 {
    private static final r3 a = new r3(0, new int[0], new Object[0], false);

    /* renamed from: b  reason: collision with root package name */
    private int f6545b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f6546c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f6547d;

    /* renamed from: e  reason: collision with root package name */
    private int f6548e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6549f;

    private r3() {
        this(0, new int[8], new Object[8], true);
    }

    private r3(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f6548e = -1;
        this.f6545b = i2;
        this.f6546c = iArr;
        this.f6547d = objArr;
        this.f6549f = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r3 a(r3 r3Var, r3 r3Var2) {
        int i2 = r3Var.f6545b + r3Var2.f6545b;
        int[] copyOf = Arrays.copyOf(r3Var.f6546c, i2);
        System.arraycopy(r3Var2.f6546c, 0, copyOf, r3Var.f6545b, r3Var2.f6545b);
        Object[] copyOf2 = Arrays.copyOf(r3Var.f6547d, i2);
        System.arraycopy(r3Var2.f6547d, 0, copyOf2, r3Var.f6545b, r3Var2.f6545b);
        return new r3(i2, copyOf, copyOf2, true);
    }

    private static void f(int i2, Object obj, l4 l4Var) throws IOException {
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            l4Var.F(i3, ((Long) obj).longValue());
        } else if (i4 == 1) {
            l4Var.h(i3, ((Long) obj).longValue());
        } else if (i4 == 2) {
            l4Var.M(i3, (a0) obj);
        } else if (i4 != 3) {
            if (i4 != 5) {
                throw new RuntimeException(zzco.c());
            }
            l4Var.t(i3, ((Integer) obj).intValue());
        } else if (l4Var.Q() == e1.e.f6412l) {
            l4Var.O(i3);
            ((r3) obj).g(l4Var);
            l4Var.K(i3);
        } else {
            l4Var.K(i3);
            ((r3) obj).g(l4Var);
            l4Var.O(i3);
        }
    }

    public static r3 h() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r3 i() {
        return new r3();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(l4 l4Var) throws IOException {
        if (l4Var.Q() == e1.e.m) {
            for (int i2 = this.f6545b - 1; i2 >= 0; i2--) {
                l4Var.i(this.f6546c[i2] >>> 3, this.f6547d[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < this.f6545b; i3++) {
            l4Var.i(this.f6546c[i3] >>> 3, this.f6547d[i3]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f6545b; i3++) {
            l2.c(sb, i2, String.valueOf(this.f6546c[i3] >>> 3), this.f6547d[i3]);
        }
    }

    public final int d() {
        int d0;
        int i2 = this.f6548e;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f6545b; i4++) {
            int i5 = this.f6546c[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                d0 = zzbn.d0(i6, ((Long) this.f6547d[i4]).longValue());
            } else if (i7 == 1) {
                d0 = zzbn.k0(i6, ((Long) this.f6547d[i4]).longValue());
            } else if (i7 == 2) {
                d0 = zzbn.N(i6, (a0) this.f6547d[i4]);
            } else if (i7 == 3) {
                d0 = (zzbn.B0(i6) << 1) + ((r3) this.f6547d[i4]).d();
            } else if (i7 != 5) {
                throw new IllegalStateException(zzco.c());
            } else {
                d0 = zzbn.t0(i6, ((Integer) this.f6547d[i4]).intValue());
            }
            i3 += d0;
        }
        this.f6548e = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(int i2, Object obj) {
        if (!this.f6549f) {
            throw new UnsupportedOperationException();
        }
        int i3 = this.f6545b;
        int[] iArr = this.f6546c;
        if (i3 == iArr.length) {
            int i4 = i3 + (i3 < 4 ? 8 : i3 >> 1);
            this.f6546c = Arrays.copyOf(iArr, i4);
            this.f6547d = Arrays.copyOf(this.f6547d, i4);
        }
        int[] iArr2 = this.f6546c;
        int i5 = this.f6545b;
        iArr2[i5] = i2;
        this.f6547d[i5] = obj;
        this.f6545b = i5 + 1;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof r3)) {
            r3 r3Var = (r3) obj;
            int i2 = this.f6545b;
            if (i2 == r3Var.f6545b) {
                int[] iArr = this.f6546c;
                int[] iArr2 = r3Var.f6546c;
                int i3 = 0;
                while (true) {
                    if (i3 >= i2) {
                        z = true;
                        break;
                    } else if (iArr[i3] != iArr2[i3]) {
                        z = false;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z) {
                    Object[] objArr = this.f6547d;
                    Object[] objArr2 = r3Var.f6547d;
                    int i4 = this.f6545b;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= i4) {
                            z2 = true;
                            break;
                        } else if (!objArr[i5].equals(objArr2[i5])) {
                            z2 = false;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    if (z2) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final void g(l4 l4Var) throws IOException {
        if (this.f6545b == 0) {
            return;
        }
        if (l4Var.Q() == e1.e.f6412l) {
            for (int i2 = 0; i2 < this.f6545b; i2++) {
                f(this.f6546c[i2], this.f6547d[i2], l4Var);
            }
            return;
        }
        for (int i3 = this.f6545b - 1; i3 >= 0; i3--) {
            f(this.f6546c[i3], this.f6547d[i3], l4Var);
        }
    }

    public final int hashCode() {
        int i2 = this.f6545b;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.f6546c;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.f6547d;
        int i8 = this.f6545b;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }

    public final int j() {
        int i2 = this.f6548e;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f6545b; i4++) {
            i3 += zzbn.X(this.f6546c[i4] >>> 3, (a0) this.f6547d[i4]);
        }
        this.f6548e = i3;
        return i3;
    }

    public final void k() {
        this.f6549f = false;
    }
}