package com.google.zxing.q;

import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.http.message.TokenParser;

/* compiled from: BitArray.java */
/* loaded from: classes2.dex */
public final class a implements Cloneable {
    private int[] a;

    /* renamed from: b  reason: collision with root package name */
    private int f9912b;

    public a() {
        this.f9912b = 0;
        this.a = new int[1];
    }

    private void h(int i2) {
        if (i2 > (this.a.length << 5)) {
            int[] r = r(i2);
            int[] iArr = this.a;
            System.arraycopy(iArr, 0, r, 0, iArr.length);
            this.a = r;
        }
    }

    private static int[] r(int i2) {
        return new int[(i2 + 31) / 32];
    }

    public void b(boolean z) {
        h(this.f9912b + 1);
        if (z) {
            int[] iArr = this.a;
            int i2 = this.f9912b;
            int i3 = i2 / 32;
            iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
        }
        this.f9912b++;
    }

    public void c(a aVar) {
        int i2 = aVar.f9912b;
        h(this.f9912b + i2);
        for (int i3 = 0; i3 < i2; i3++) {
            b(aVar.i(i3));
        }
    }

    public void d(int i2, int i3) {
        if (i3 >= 0 && i3 <= 32) {
            h(this.f9912b + i3);
            while (i3 > 0) {
                boolean z = true;
                if (((i2 >> (i3 - 1)) & 1) != 1) {
                    z = false;
                }
                b(z);
                i3--;
            }
            return;
        }
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    public void e() {
        int length = this.a.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.a[i2] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f9912b == aVar.f9912b && Arrays.equals(this.a, aVar.a);
        }
        return false;
    }

    /* renamed from: f */
    public a clone() {
        return new a((int[]) this.a.clone(), this.f9912b);
    }

    public int hashCode() {
        return (this.f9912b * 31) + Arrays.hashCode(this.a);
    }

    public boolean i(int i2) {
        return ((1 << (i2 & 31)) & this.a[i2 / 32]) != 0;
    }

    public int[] k() {
        return this.a;
    }

    public int l(int i2) {
        int i3 = this.f9912b;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (~((1 << (i2 & 31)) - 1)) & this.a[i4];
        while (i5 == 0) {
            i4++;
            int[] iArr = this.a;
            if (i4 == iArr.length) {
                return this.f9912b;
            }
            i5 = iArr[i4];
        }
        int numberOfTrailingZeros = (i4 << 5) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.f9912b;
        return numberOfTrailingZeros > i6 ? i6 : numberOfTrailingZeros;
    }

    public int n(int i2) {
        int i3 = this.f9912b;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (~((1 << (i2 & 31)) - 1)) & (~this.a[i4]);
        while (i5 == 0) {
            i4++;
            int[] iArr = this.a;
            if (i4 == iArr.length) {
                return this.f9912b;
            }
            i5 = ~iArr[i4];
        }
        int numberOfTrailingZeros = (i4 << 5) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.f9912b;
        return numberOfTrailingZeros > i6 ? i6 : numberOfTrailingZeros;
    }

    public int o() {
        return this.f9912b;
    }

    public int p() {
        return (this.f9912b + 7) / 8;
    }

    public boolean q(int i2, int i3, boolean z) {
        if (i3 < i2 || i2 < 0 || i3 > this.f9912b) {
            throw new IllegalArgumentException();
        }
        if (i3 == i2) {
            return true;
        }
        int i4 = i3 - 1;
        int i5 = i2 / 32;
        int i6 = i4 / 32;
        int i7 = i5;
        while (i7 <= i6) {
            int i8 = (2 << (i7 >= i6 ? 31 & i4 : 31)) - (1 << (i7 > i5 ? 0 : i2 & 31));
            int i9 = this.a[i7] & i8;
            if (!z) {
                i8 = 0;
            }
            if (i9 != i8) {
                return false;
            }
            i7++;
        }
        return true;
    }

    public void s() {
        int[] iArr = new int[this.a.length];
        int i2 = (this.f9912b - 1) / 32;
        int i3 = i2 + 1;
        for (int i4 = 0; i4 < i3; i4++) {
            long j2 = this.a[i4];
            long j3 = ((j2 & 1431655765) << 1) | ((j2 >> 1) & 1431655765);
            long j4 = ((j3 & 858993459) << 2) | ((j3 >> 2) & 858993459);
            long j5 = ((j4 & 252645135) << 4) | ((j4 >> 4) & 252645135);
            long j6 = ((j5 & 16711935) << 8) | ((j5 >> 8) & 16711935);
            iArr[i2 - i4] = (int) (((j6 & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((j6 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        }
        int i5 = this.f9912b;
        int i6 = i3 << 5;
        if (i5 != i6) {
            int i7 = i6 - i5;
            int i8 = iArr[0] >>> i7;
            for (int i9 = 1; i9 < i3; i9++) {
                int i10 = iArr[i9];
                iArr[i9 - 1] = i8 | (i10 << (32 - i7));
                i8 = i10 >>> i7;
            }
            iArr[i3 - 1] = i8;
        }
        this.a = iArr;
    }

    public void t(int i2) {
        int[] iArr = this.a;
        int i3 = i2 / 32;
        iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f9912b);
        for (int i2 = 0; i2 < this.f9912b; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(TokenParser.SP);
            }
            sb.append(i(i2) ? 'X' : '.');
        }
        return sb.toString();
    }

    public void u(int i2, int i3) {
        this.a[i2 / 32] = i3;
    }

    public void v(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (i(i2)) {
                    i6 |= 1 << (7 - i7);
                }
                i2++;
            }
            bArr[i3 + i5] = (byte) i6;
        }
    }

    public void w(a aVar) {
        if (this.f9912b != aVar.f9912b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = iArr[i2] ^ aVar.a[i2];
            i2++;
        }
    }

    public a(int i2) {
        this.f9912b = i2;
        this.a = r(i2);
    }

    a(int[] iArr, int i2) {
        this.a = iArr;
        this.f9912b = i2;
    }
}