package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class g5 extends n4<g5> implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private byte[] f6453c = v4.f6587h;

    /* renamed from: d  reason: collision with root package name */
    private String f6454d = "";

    /* renamed from: e  reason: collision with root package name */
    private byte[][] f6455e = v4.f6586g;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6456f = false;

    public g5() {
        this.f6521b = null;
        this.a = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.clearcut.n4, com.google.android.gms.internal.clearcut.s4
    /* renamed from: i */
    public final g5 clone() {
        try {
            g5 g5Var = (g5) super.clone();
            byte[][] bArr = this.f6455e;
            if (bArr != null && bArr.length > 0) {
                g5Var.f6455e = (byte[][]) bArr.clone();
            }
            return g5Var;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.n4, com.google.android.gms.internal.clearcut.s4
    public final void b(m4 m4Var) throws IOException {
        if (!Arrays.equals(this.f6453c, v4.f6587h)) {
            m4Var.d(1, this.f6453c);
        }
        byte[][] bArr = this.f6455e;
        if (bArr != null && bArr.length > 0) {
            int i2 = 0;
            while (true) {
                byte[][] bArr2 = this.f6455e;
                if (i2 >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i2];
                if (bArr3 != null) {
                    m4Var.d(2, bArr3);
                }
                i2++;
            }
        }
        String str = this.f6454d;
        if (str != null && !str.equals("")) {
            m4Var.c(4, this.f6454d);
        }
        super.b(m4Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.clearcut.n4, com.google.android.gms.internal.clearcut.s4
    public final int e() {
        int e2 = super.e();
        if (!Arrays.equals(this.f6453c, v4.f6587h)) {
            e2 += m4.i(1, this.f6453c);
        }
        byte[][] bArr = this.f6455e;
        if (bArr != null && bArr.length > 0) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte[][] bArr2 = this.f6455e;
                if (i2 >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i2];
                if (bArr3 != null) {
                    i4++;
                    i3 += m4.s(bArr3);
                }
                i2++;
            }
            e2 = e2 + i3 + (i4 * 1);
        }
        String str = this.f6454d;
        return (str == null || str.equals("")) ? e2 : e2 + m4.h(4, this.f6454d);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g5) {
            g5 g5Var = (g5) obj;
            if (Arrays.equals(this.f6453c, g5Var.f6453c)) {
                String str = this.f6454d;
                if (str == null) {
                    if (g5Var.f6454d != null) {
                        return false;
                    }
                } else if (!str.equals(g5Var.f6454d)) {
                    return false;
                }
                if (r4.i(this.f6455e, g5Var.f6455e)) {
                    p4 p4Var = this.f6521b;
                    if (p4Var == null || p4Var.b()) {
                        p4 p4Var2 = g5Var.f6521b;
                        return p4Var2 == null || p4Var2.b();
                    }
                    return this.f6521b.equals(g5Var.f6521b);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.clearcut.n4, com.google.android.gms.internal.clearcut.s4
    public final /* synthetic */ s4 f() throws CloneNotSupportedException {
        return (g5) clone();
    }

    @Override // com.google.android.gms.internal.clearcut.n4
    public final /* synthetic */ g5 h() throws CloneNotSupportedException {
        return (g5) clone();
    }

    public final int hashCode() {
        int hashCode = (((g5.class.getName().hashCode() + 527) * 31) + Arrays.hashCode(this.f6453c)) * 31;
        String str = this.f6454d;
        int i2 = 0;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + r4.g(this.f6455e)) * 31) + 1237) * 31;
        p4 p4Var = this.f6521b;
        if (p4Var != null && !p4Var.b()) {
            i2 = this.f6521b.hashCode();
        }
        return hashCode2 + i2;
    }
}