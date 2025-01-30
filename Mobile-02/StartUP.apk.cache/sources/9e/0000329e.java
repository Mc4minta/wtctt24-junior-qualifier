package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h0 extends g0 {

    /* renamed from: d  reason: collision with root package name */
    protected final byte[] f6457d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(byte[] bArr) {
        this.f6457d = bArr;
    }

    @Override // com.google.android.gms.internal.clearcut.a0
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof a0) && size() == ((a0) obj).size()) {
            if (size() == 0) {
                return true;
            }
            if (obj instanceof h0) {
                h0 h0Var = (h0) obj;
                int o = o();
                int o2 = h0Var.o();
                if (o == 0 || o2 == 0 || o == o2) {
                    return w(h0Var, 0, size());
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.clearcut.a0
    protected final int h(int i2, int i3, int i4) {
        return g1.c(i2, this.f6457d, x(), i4);
    }

    @Override // com.google.android.gms.internal.clearcut.a0
    public final a0 i(int i2, int i3) {
        int p = a0.p(0, i3, size());
        return p == 0 ? a0.a : new d0(this.f6457d, x(), p);
    }

    @Override // com.google.android.gms.internal.clearcut.a0
    protected final String k(Charset charset) {
        return new String(this.f6457d, x(), size(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.a0
    public final void l(z zVar) throws IOException {
        zVar.a(this.f6457d, x(), size());
    }

    @Override // com.google.android.gms.internal.clearcut.a0
    public final boolean m() {
        int x = x();
        return z3.i(this.f6457d, x, size() + x);
    }

    @Override // com.google.android.gms.internal.clearcut.a0
    public byte s(int i2) {
        return this.f6457d[i2];
    }

    @Override // com.google.android.gms.internal.clearcut.a0
    public int size() {
        return this.f6457d.length;
    }

    @Override // com.google.android.gms.internal.clearcut.g0
    final boolean w(a0 a0Var, int i2, int i3) {
        if (i3 > a0Var.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i3);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i3 > a0Var.size()) {
            int size2 = a0Var.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i3);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (a0Var instanceof h0) {
            h0 h0Var = (h0) a0Var;
            byte[] bArr = this.f6457d;
            byte[] bArr2 = h0Var.f6457d;
            int x = x() + i3;
            int x2 = x();
            int x3 = h0Var.x();
            while (x2 < x) {
                if (bArr[x2] != bArr2[x3]) {
                    return false;
                }
                x2++;
                x3++;
            }
            return true;
        } else {
            return a0Var.i(0, i3).equals(i(0, i3));
        }
    }

    protected int x() {
        return 0;
    }
}