package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public class r3 extends o3 {

    /* renamed from: e  reason: collision with root package name */
    protected final byte[] f7332e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r3(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.f7332e = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.o3
    final boolean B(h3 h3Var, int i2, int i3) {
        if (i3 <= h3Var.i()) {
            if (i3 <= h3Var.i()) {
                if (h3Var instanceof r3) {
                    r3 r3Var = (r3) h3Var;
                    byte[] bArr = this.f7332e;
                    byte[] bArr2 = r3Var.f7332e;
                    int C = C() + i3;
                    int C2 = C();
                    int C3 = r3Var.C();
                    while (C2 < C) {
                        if (bArr[C2] != bArr2[C3]) {
                            return false;
                        }
                        C2++;
                        C3++;
                    }
                    return true;
                }
                return h3Var.m(0, i3).equals(m(0, i3));
            }
            int i4 = h3Var.i();
            StringBuilder sb = new StringBuilder(59);
            sb.append("Ran off end of other: 0, ");
            sb.append(i3);
            sb.append(", ");
            sb.append(i4);
            throw new IllegalArgumentException(sb.toString());
        }
        int i5 = i();
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Length too large: ");
        sb2.append(i3);
        sb2.append(i5);
        throw new IllegalArgumentException(sb2.toString());
    }

    protected int C() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.h3
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof h3) && i() == ((h3) obj).i()) {
            if (i() == 0) {
                return true;
            }
            if (obj instanceof r3) {
                r3 r3Var = (r3) obj;
                int z = z();
                int z2 = r3Var.z();
                if (z == 0 || z2 == 0 || z == z2) {
                    return B(r3Var, 0, i());
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.h3
    public byte h(int i2) {
        return this.f7332e[i2];
    }

    @Override // com.google.android.gms.internal.measurement.h3
    public int i() {
        return this.f7332e.length;
    }

    @Override // com.google.android.gms.internal.measurement.h3
    protected final int l(int i2, int i3, int i4) {
        return q4.a(i2, this.f7332e, C(), i4);
    }

    @Override // com.google.android.gms.internal.measurement.h3
    public final h3 m(int i2, int i3) {
        int u = h3.u(0, i3, i());
        if (u == 0) {
            return h3.a;
        }
        return new k3(this.f7332e, C(), u);
    }

    @Override // com.google.android.gms.internal.measurement.h3
    protected final String q(Charset charset) {
        return new String(this.f7332e, C(), i(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h3
    public final void r(e3 e3Var) throws IOException {
        e3Var.a(this.f7332e, C(), i());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h3
    public byte s(int i2) {
        return this.f7332e[i2];
    }

    @Override // com.google.android.gms.internal.measurement.h3
    public final boolean y() {
        int C = C();
        return l7.g(this.f7332e, C, i() + C);
    }
}