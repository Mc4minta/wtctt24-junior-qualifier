package com.google.android.gms.internal.clearcut;

/* loaded from: classes2.dex */
public final class p4 implements Cloneable {
    private static final q4 a = new q4();

    /* renamed from: b  reason: collision with root package name */
    private boolean f6533b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f6534c;

    /* renamed from: d  reason: collision with root package name */
    private q4[] f6535d;

    /* renamed from: e  reason: collision with root package name */
    private int f6536e;

    p4() {
        this(10);
    }

    private p4(int i2) {
        this.f6533b = false;
        int i3 = i2 << 2;
        int i4 = 4;
        while (true) {
            if (i4 >= 32) {
                break;
            }
            int i5 = (1 << i4) - 12;
            if (i3 <= i5) {
                i3 = i5;
                break;
            }
            i4++;
        }
        int i6 = i3 / 4;
        this.f6534c = new int[i6];
        this.f6535d = new q4[i6];
        this.f6536e = 0;
    }

    public final boolean b() {
        return this.f6536e == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int c() {
        return this.f6536e;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i2 = this.f6536e;
        p4 p4Var = new p4(i2);
        System.arraycopy(this.f6534c, 0, p4Var.f6534c, 0, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            q4[] q4VarArr = this.f6535d;
            if (q4VarArr[i3] != null) {
                p4Var.f6535d[i3] = (q4) q4VarArr[i3].clone();
            }
        }
        p4Var.f6536e = i2;
        return p4Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final q4 d(int i2) {
        return this.f6535d[i2];
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof p4) {
            p4 p4Var = (p4) obj;
            int i2 = this.f6536e;
            if (i2 != p4Var.f6536e) {
                return false;
            }
            int[] iArr = this.f6534c;
            int[] iArr2 = p4Var.f6534c;
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
                q4[] q4VarArr = this.f6535d;
                q4[] q4VarArr2 = p4Var.f6535d;
                int i4 = this.f6536e;
                int i5 = 0;
                while (true) {
                    if (i5 >= i4) {
                        z2 = true;
                        break;
                    } else if (!q4VarArr[i5].equals(q4VarArr2[i5])) {
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
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i2 = 17;
        for (int i3 = 0; i3 < this.f6536e; i3++) {
            i2 = (((i2 * 31) + this.f6534c[i3]) * 31) + this.f6535d[i3].hashCode();
        }
        return i2;
    }
}