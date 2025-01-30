package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class c7 {
    private static final c7 a = new c7(0, new int[0], new Object[0], false);

    /* renamed from: b  reason: collision with root package name */
    private int f7076b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f7077c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f7078d;

    /* renamed from: e  reason: collision with root package name */
    private int f7079e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7080f;

    private c7() {
        this(0, new int[8], new Object[8], true);
    }

    public static c7 a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c7 b(c7 c7Var, c7 c7Var2) {
        int i2 = c7Var.f7076b + c7Var2.f7076b;
        int[] copyOf = Arrays.copyOf(c7Var.f7077c, i2);
        System.arraycopy(c7Var2.f7077c, 0, copyOf, c7Var.f7076b, c7Var2.f7076b);
        Object[] copyOf2 = Arrays.copyOf(c7Var.f7078d, i2);
        System.arraycopy(c7Var2.f7078d, 0, copyOf2, c7Var.f7076b, c7Var2.f7076b);
        return new c7(i2, copyOf, copyOf2, true);
    }

    private static void d(int i2, Object obj, w7 w7Var) throws IOException {
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            w7Var.p(i3, ((Long) obj).longValue());
        } else if (i4 == 1) {
            w7Var.L(i3, ((Long) obj).longValue());
        } else if (i4 == 2) {
            w7Var.H(i3, (h3) obj);
        } else if (i4 != 3) {
            if (i4 == 5) {
                w7Var.G(i3, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzfm.d());
        } else if (w7Var.a() == n4.f.f7265l) {
            w7Var.f(i3);
            ((c7) obj).h(w7Var);
            w7Var.c(i3);
        } else {
            w7Var.c(i3);
            ((c7) obj).h(w7Var);
            w7Var.f(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c7 g() {
        return new c7();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(int i2, Object obj) {
        if (this.f7080f) {
            int i3 = this.f7076b;
            int[] iArr = this.f7077c;
            if (i3 == iArr.length) {
                int i4 = i3 + (i3 < 4 ? 8 : i3 >> 1);
                this.f7077c = Arrays.copyOf(iArr, i4);
                this.f7078d = Arrays.copyOf(this.f7078d, i4);
            }
            int[] iArr2 = this.f7077c;
            int i5 = this.f7076b;
            iArr2[i5] = i2;
            this.f7078d[i5] = obj;
            this.f7076b = i5 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(w7 w7Var) throws IOException {
        if (w7Var.a() == n4.f.m) {
            for (int i2 = this.f7076b - 1; i2 >= 0; i2--) {
                w7Var.i(this.f7077c[i2] >>> 3, this.f7078d[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < this.f7076b; i3++) {
            w7Var.i(this.f7077c[i3] >>> 3, this.f7078d[i3]);
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
            int i2 = this.f7076b;
            if (i2 == c7Var.f7076b) {
                int[] iArr = this.f7077c;
                int[] iArr2 = c7Var.f7077c;
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
                    Object[] objArr = this.f7078d;
                    Object[] objArr2 = c7Var.f7078d;
                    int i4 = this.f7076b;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f7076b; i3++) {
            z5.d(sb, i2, String.valueOf(this.f7077c[i3] >>> 3), this.f7078d[i3]);
        }
    }

    public final void h(w7 w7Var) throws IOException {
        if (this.f7076b == 0) {
            return;
        }
        if (w7Var.a() == n4.f.f7265l) {
            for (int i2 = 0; i2 < this.f7076b; i2++) {
                d(this.f7077c[i2], this.f7078d[i2], w7Var);
            }
            return;
        }
        for (int i3 = this.f7076b - 1; i3 >= 0; i3--) {
            d(this.f7077c[i3], this.f7078d[i3], w7Var);
        }
    }

    public final int hashCode() {
        int i2 = this.f7076b;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.f7077c;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.f7078d;
        int i8 = this.f7076b;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }

    public final void i() {
        this.f7080f = false;
    }

    public final int j() {
        int i2 = this.f7079e;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f7076b; i4++) {
            i3 += zzel.c0(this.f7077c[i4] >>> 3, (h3) this.f7078d[i4]);
        }
        this.f7079e = i3;
        return i3;
    }

    public final int k() {
        int h0;
        int i2 = this.f7079e;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f7076b; i4++) {
            int i5 = this.f7077c[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                h0 = zzel.h0(i6, ((Long) this.f7078d[i4]).longValue());
            } else if (i7 == 1) {
                h0 = zzel.q0(i6, ((Long) this.f7078d[i4]).longValue());
            } else if (i7 == 2) {
                h0 = zzel.T(i6, (h3) this.f7078d[i4]);
            } else if (i7 == 3) {
                h0 = (zzel.g0(i6) << 1) + ((c7) this.f7078d[i4]).k();
            } else if (i7 == 5) {
                h0 = zzel.x0(i6, ((Integer) this.f7078d[i4]).intValue());
            } else {
                throw new IllegalStateException(zzfm.d());
            }
            i3 += h0;
        }
        this.f7079e = i3;
        return i3;
    }

    private c7(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f7079e = -1;
        this.f7076b = i2;
        this.f7077c = iArr;
        this.f7078d = objArr;
        this.f7080f = z;
    }
}