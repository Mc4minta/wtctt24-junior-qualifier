package j;

import java.security.MessageDigest;

/* compiled from: SegmentedByteString.kt */
/* loaded from: classes3.dex */
public final class b0 extends i {

    /* renamed from: f  reason: collision with root package name */
    private final transient byte[][] f17140f;

    /* renamed from: g  reason: collision with root package name */
    private final transient int[] f17141g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(byte[][] segments, int[] directory) {
        super(i.a.B());
        kotlin.jvm.internal.m.g(segments, "segments");
        kotlin.jvm.internal.m.g(directory, "directory");
        this.f17140f = segments;
        this.f17141g = directory;
    }

    private final i Y() {
        return new i(T());
    }

    @Override // j.i
    public int D() {
        return W()[X().length - 1];
    }

    @Override // j.i
    public String F() {
        return Y().F();
    }

    @Override // j.i
    public byte[] G() {
        return T();
    }

    @Override // j.i
    public byte H(int i2) {
        c.b(W()[X().length - 1], i2, 1L);
        int b2 = j.h0.c.b(this, i2);
        return X()[b2][(i2 - (b2 == 0 ? 0 : W()[b2 - 1])) + W()[X().length + b2]];
    }

    @Override // j.i
    public boolean K(int i2, i other, int i3, int i4) {
        kotlin.jvm.internal.m.g(other, "other");
        if (i2 < 0 || i2 > Q() - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int b2 = j.h0.c.b(this, i2);
        while (i2 < i5) {
            int i6 = b2 == 0 ? 0 : W()[b2 - 1];
            int i7 = W()[X().length + b2];
            int min = Math.min(i5, (W()[b2] - i6) + i6) - i2;
            if (!other.L(i3, X()[b2], i7 + (i2 - i6), min)) {
                return false;
            }
            i3 += min;
            i2 += min;
            b2++;
        }
        return true;
    }

    @Override // j.i
    public boolean L(int i2, byte[] other, int i3, int i4) {
        kotlin.jvm.internal.m.g(other, "other");
        if (i2 < 0 || i2 > Q() - i4 || i3 < 0 || i3 > other.length - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int b2 = j.h0.c.b(this, i2);
        while (i2 < i5) {
            int i6 = b2 == 0 ? 0 : W()[b2 - 1];
            int i7 = W()[X().length + b2];
            int min = Math.min(i5, (W()[b2] - i6) + i6) - i2;
            if (!c.a(X()[b2], i7 + (i2 - i6), other, i3, min)) {
                return false;
            }
            i3 += min;
            i2 += min;
            b2++;
        }
        return true;
    }

    @Override // j.i
    public i S() {
        return Y().S();
    }

    @Override // j.i
    public byte[] T() {
        byte[] bArr = new byte[Q()];
        int length = X().length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = W()[length + i2];
            int i6 = W()[i2];
            int i7 = i6 - i3;
            kotlin.a0.m.d(X()[i2], bArr, i4, i5, i5 + i7);
            i4 += i7;
            i2++;
            i3 = i6;
        }
        return bArr;
    }

    @Override // j.i
    public void V(f buffer, int i2, int i3) {
        kotlin.jvm.internal.m.g(buffer, "buffer");
        int i4 = i2 + i3;
        int b2 = j.h0.c.b(this, i2);
        while (i2 < i4) {
            int i5 = b2 == 0 ? 0 : W()[b2 - 1];
            int i6 = W()[X().length + b2];
            int min = Math.min(i4, (W()[b2] - i5) + i5) - i2;
            int i7 = i6 + (i2 - i5);
            z zVar = new z(X()[b2], i7, i7 + min, true, false);
            z zVar2 = buffer.a;
            if (zVar2 == null) {
                zVar.f17193h = zVar;
                zVar.f17192g = zVar;
                buffer.a = zVar;
            } else {
                kotlin.jvm.internal.m.e(zVar2);
                z zVar3 = zVar2.f17193h;
                kotlin.jvm.internal.m.e(zVar3);
                zVar3.c(zVar);
            }
            i2 += min;
            b2++;
        }
        buffer.M0(buffer.O0() + i3);
    }

    public final int[] W() {
        return this.f17141g;
    }

    public final byte[][] X() {
        return this.f17140f;
    }

    @Override // j.i
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (iVar.Q() == Q() && K(0, iVar, 0, Q())) {
                return true;
            }
        }
        return false;
    }

    @Override // j.i
    public String h() {
        return Y().h();
    }

    @Override // j.i
    public int hashCode() {
        int C = C();
        if (C != 0) {
            return C;
        }
        int length = X().length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int i5 = W()[length + i2];
            int i6 = W()[i2];
            byte[] bArr = X()[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        M(i3);
        return i3;
    }

    @Override // j.i
    public String toString() {
        return Y().toString();
    }

    @Override // j.i
    public i y(String algorithm) {
        kotlin.jvm.internal.m.g(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = X().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = W()[length + i2];
            int i5 = W()[i2];
            messageDigest.update(X()[i2], i4, i5 - i3);
            i2++;
            i3 = i5;
        }
        byte[] digestBytes = messageDigest.digest();
        kotlin.jvm.internal.m.f(digestBytes, "digestBytes");
        return new i(digestBytes);
    }
}