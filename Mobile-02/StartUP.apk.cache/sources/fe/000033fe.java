package com.google.android.gms.internal.p000firebaseperf;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.s3  reason: invalid package */
/* loaded from: classes2.dex */
public class s3 extends t3 {

    /* renamed from: e  reason: collision with root package name */
    protected final byte[] f6905e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s3(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.f6905e = bArr;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.i3
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof i3) && size() == ((i3) obj).size()) {
            if (size() == 0) {
                return true;
            }
            if (obj instanceof s3) {
                s3 s3Var = (s3) obj;
                int t = t();
                int t2 = s3Var.t();
                if (t == 0 || t2 == 0 || t == t2) {
                    return y(s3Var, 0, size());
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.i3
    protected final String i(Charset charset) {
        return new String(this.f6905e, z(), size(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.i3
    public final void k(j3 j3Var) throws IOException {
        j3Var.a(this.f6905e, z(), size());
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.i3
    protected final int o(int i2, int i3, int i4) {
        return n4.d(i2, this.f6905e, z(), i4);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.i3
    public final i3 q(int i2, int i3) {
        int p = i3.p(0, i3, size());
        if (p == 0) {
            return i3.a;
        }
        return new p3(this.f6905e, z(), p);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.i3
    public final boolean s() {
        int z = z();
        return m7.f(this.f6905e, z, size() + z);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.i3
    public int size() {
        return this.f6905e.length;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.i3
    public byte u(int i2) {
        return this.f6905e[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.i3
    public byte w(int i2) {
        return this.f6905e[i2];
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.t3
    final boolean y(i3 i3Var, int i2, int i3) {
        if (i3 <= i3Var.size()) {
            if (i3 <= i3Var.size()) {
                if (i3Var instanceof s3) {
                    s3 s3Var = (s3) i3Var;
                    byte[] bArr = this.f6905e;
                    byte[] bArr2 = s3Var.f6905e;
                    int z = z() + i3;
                    int z2 = z();
                    int z3 = s3Var.z();
                    while (z2 < z) {
                        if (bArr[z2] != bArr2[z3]) {
                            return false;
                        }
                        z2++;
                        z3++;
                    }
                    return true;
                }
                return i3Var.q(0, i3).equals(q(0, i3));
            }
            int size = i3Var.size();
            StringBuilder sb = new StringBuilder(59);
            sb.append("Ran off end of other: 0, ");
            sb.append(i3);
            sb.append(", ");
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        int size2 = size();
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Length too large: ");
        sb2.append(i3);
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }

    protected int z() {
        return 0;
    }
}