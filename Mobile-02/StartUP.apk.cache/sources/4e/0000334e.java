package com.google.android.gms.internal.p000firebaseperf;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.c7  reason: invalid package */
/* loaded from: classes2.dex */
public final class c7 {
    private static final c7 a = new c7(0, new int[0], new Object[0], false);

    /* renamed from: b  reason: collision with root package name */
    private int f6699b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f6700c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f6701d;

    /* renamed from: e  reason: collision with root package name */
    private int f6702e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6703f;

    private c7() {
        this(0, new int[8], new Object[8], true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c7 b(c7 c7Var, c7 c7Var2) {
        int i2 = c7Var.f6699b + c7Var2.f6699b;
        int[] copyOf = Arrays.copyOf(c7Var.f6700c, i2);
        System.arraycopy(c7Var2.f6700c, 0, copyOf, c7Var.f6699b, c7Var2.f6699b);
        Object[] copyOf2 = Arrays.copyOf(c7Var.f6701d, i2);
        System.arraycopy(c7Var2.f6701d, 0, copyOf2, c7Var.f6699b, c7Var2.f6699b);
        return new c7(i2, copyOf, copyOf2, true);
    }

    private static void e(int i2, Object obj, y7 y7Var) throws IOException {
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            y7Var.F(i3, ((Long) obj).longValue());
        } else if (i4 == 1) {
            y7Var.h(i3, ((Long) obj).longValue());
        } else if (i4 == 2) {
            y7Var.L(i3, (i3) obj);
        } else if (i4 != 3) {
            if (i4 == 5) {
                y7Var.I(i3, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzfs.a());
        } else if (y7Var.J() == i6.f6759d) {
            y7Var.Q(i3);
            ((c7) obj).f(y7Var);
            y7Var.K(i3);
        } else {
            y7Var.K(i3);
            ((c7) obj).f(y7Var);
            y7Var.Q(i3);
        }
    }

    public static c7 h() {
        return a;
    }

    public final int a() {
        int i0;
        int i2 = this.f6702e;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f6699b; i4++) {
            int i5 = this.f6700c[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i0 = zzev.i0(i6, ((Long) this.f6701d[i4]).longValue());
            } else if (i7 == 1) {
                i0 = zzev.n0(i6, ((Long) this.f6701d[i4]).longValue());
            } else if (i7 == 2) {
                i0 = zzev.a0(i6, (i3) this.f6701d[i4]);
            } else if (i7 == 3) {
                i0 = (zzev.F0(i6) << 1) + ((c7) this.f6701d[i4]).a();
            } else if (i7 == 5) {
                i0 = zzev.y0(i6, ((Integer) this.f6701d[i4]).intValue());
            } else {
                throw new IllegalStateException(zzfs.a());
            }
            i3 += i0;
        }
        this.f6702e = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(y7 y7Var) throws IOException {
        if (y7Var.J() == i6.f6760e) {
            for (int i2 = this.f6699b - 1; i2 >= 0; i2--) {
                y7Var.i(this.f6700c[i2] >>> 3, this.f6701d[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < this.f6699b; i3++) {
            y7Var.i(this.f6700c[i3] >>> 3, this.f6701d[i3]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f6699b; i3++) {
            w5.c(sb, i2, String.valueOf(this.f6700c[i3] >>> 3), this.f6701d[i3]);
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof c7)) {
            c7 c7Var = (c7) obj;
            int i2 = this.f6699b;
            if (i2 == c7Var.f6699b) {
                int[] iArr = this.f6700c;
                int[] iArr2 = c7Var.f6700c;
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
                    Object[] objArr = this.f6701d;
                    Object[] objArr2 = c7Var.f6701d;
                    int i4 = this.f6699b;
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

    public final void f(y7 y7Var) throws IOException {
        if (this.f6699b == 0) {
            return;
        }
        if (y7Var.J() == i6.f6759d) {
            for (int i2 = 0; i2 < this.f6699b; i2++) {
                e(this.f6700c[i2], this.f6701d[i2], y7Var);
            }
            return;
        }
        for (int i3 = this.f6699b - 1; i3 >= 0; i3--) {
            e(this.f6700c[i3], this.f6701d[i3], y7Var);
        }
    }

    public final void g() {
        this.f6703f = false;
    }

    public final int hashCode() {
        int i2 = this.f6699b;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.f6700c;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.f6701d;
        int i8 = this.f6699b;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }

    public final int i() {
        int i2 = this.f6702e;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f6699b; i4++) {
            i3 += zzev.g0(this.f6700c[i4] >>> 3, (i3) this.f6701d[i4]);
        }
        this.f6702e = i3;
        return i3;
    }

    private c7(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f6702e = -1;
        this.f6699b = i2;
        this.f6700c = iArr;
        this.f6701d = objArr;
        this.f6703f = z;
    }
}