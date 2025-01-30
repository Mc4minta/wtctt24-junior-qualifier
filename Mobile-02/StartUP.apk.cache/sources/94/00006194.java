package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public class SHA1Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 20;
    private static final int Y1 = 1518500249;
    private static final int Y2 = 1859775393;
    private static final int Y3 = -1894007588;
    private static final int Y4 = -899497514;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int H5;
    private int[] X;
    private int xOff;

    public SHA1Digest() {
        this.X = new int[80];
        reset();
    }

    private void copyIn(SHA1Digest sHA1Digest) {
        this.H1 = sHA1Digest.H1;
        this.H2 = sHA1Digest.H2;
        this.H3 = sHA1Digest.H3;
        this.H4 = sHA1Digest.H4;
        this.H5 = sHA1Digest.H5;
        int[] iArr = sHA1Digest.X;
        System.arraycopy(iArr, 0, this.X, 0, iArr.length);
        this.xOff = sHA1Digest.xOff;
    }

    private int f(int i2, int i3, int i4) {
        return ((~i2) & i4) | (i3 & i2);
    }

    private int g(int i2, int i3, int i4) {
        return (i2 & i4) | (i2 & i3) | (i3 & i4);
    }

    private int h(int i2, int i3, int i4) {
        return (i2 ^ i3) ^ i4;
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new SHA1Digest(this);
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i2) {
        finish();
        Pack.intToBigEndian(this.H1, bArr, i2);
        Pack.intToBigEndian(this.H2, bArr, i2 + 4);
        Pack.intToBigEndian(this.H3, bArr, i2 + 8);
        Pack.intToBigEndian(this.H4, bArr, i2 + 12);
        Pack.intToBigEndian(this.H5, bArr, i2 + 16);
        reset();
        return 20;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-1";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 20;
    }

    @Override // org.spongycastle.crypto.digests.EncodableDigest
    public byte[] getEncodedState() {
        byte[] bArr = new byte[(this.xOff * 4) + 40];
        super.populateState(bArr);
        Pack.intToBigEndian(this.H1, bArr, 16);
        Pack.intToBigEndian(this.H2, bArr, 20);
        Pack.intToBigEndian(this.H3, bArr, 24);
        Pack.intToBigEndian(this.H4, bArr, 28);
        Pack.intToBigEndian(this.H5, bArr, 32);
        Pack.intToBigEndian(this.xOff, bArr, 36);
        for (int i2 = 0; i2 != this.xOff; i2++) {
            Pack.intToBigEndian(this.X[i2], bArr, (i2 * 4) + 40);
        }
        return bArr;
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    protected void processBlock() {
        for (int i2 = 16; i2 < 80; i2++) {
            int[] iArr = this.X;
            int i3 = ((iArr[i2 - 3] ^ iArr[i2 - 8]) ^ iArr[i2 - 14]) ^ iArr[i2 - 16];
            iArr[i2] = (i3 >>> 31) | (i3 << 1);
        }
        int i4 = this.H1;
        int i5 = this.H2;
        int i6 = this.H3;
        int i7 = this.H4;
        int i8 = this.H5;
        int i9 = 0;
        int i10 = 0;
        while (i9 < 4) {
            int i11 = i10 + 1;
            int f2 = i8 + ((i4 << 5) | (i4 >>> 27)) + f(i5, i6, i7) + this.X[i10] + Y1;
            int i12 = (i5 >>> 2) | (i5 << 30);
            int i13 = i11 + 1;
            int f3 = i7 + ((f2 << 5) | (f2 >>> 27)) + f(i4, i12, i6) + this.X[i11] + Y1;
            int i14 = (i4 >>> 2) | (i4 << 30);
            int i15 = i13 + 1;
            int f4 = i6 + ((f3 << 5) | (f3 >>> 27)) + f(f2, i14, i12) + this.X[i13] + Y1;
            i8 = (f2 >>> 2) | (f2 << 30);
            int i16 = i15 + 1;
            i5 = i12 + ((f4 << 5) | (f4 >>> 27)) + f(f3, i8, i14) + this.X[i15] + Y1;
            i7 = (f3 >>> 2) | (f3 << 30);
            i4 = i14 + ((i5 << 5) | (i5 >>> 27)) + f(f4, i7, i8) + this.X[i16] + Y1;
            i6 = (f4 >>> 2) | (f4 << 30);
            i9++;
            i10 = i16 + 1;
        }
        int i17 = 0;
        while (i17 < 4) {
            int i18 = i10 + 1;
            int h2 = i8 + ((i4 << 5) | (i4 >>> 27)) + h(i5, i6, i7) + this.X[i10] + Y2;
            int i19 = (i5 >>> 2) | (i5 << 30);
            int i20 = i18 + 1;
            int h3 = i7 + ((h2 << 5) | (h2 >>> 27)) + h(i4, i19, i6) + this.X[i18] + Y2;
            int i21 = (i4 >>> 2) | (i4 << 30);
            int i22 = i20 + 1;
            int h4 = i6 + ((h3 << 5) | (h3 >>> 27)) + h(h2, i21, i19) + this.X[i20] + Y2;
            i8 = (h2 >>> 2) | (h2 << 30);
            int i23 = i22 + 1;
            i5 = i19 + ((h4 << 5) | (h4 >>> 27)) + h(h3, i8, i21) + this.X[i22] + Y2;
            i7 = (h3 >>> 2) | (h3 << 30);
            i4 = i21 + ((i5 << 5) | (i5 >>> 27)) + h(h4, i7, i8) + this.X[i23] + Y2;
            i6 = (h4 >>> 2) | (h4 << 30);
            i17++;
            i10 = i23 + 1;
        }
        int i24 = 0;
        while (i24 < 4) {
            int i25 = i10 + 1;
            int g2 = i8 + ((i4 << 5) | (i4 >>> 27)) + g(i5, i6, i7) + this.X[i10] + Y3;
            int i26 = (i5 >>> 2) | (i5 << 30);
            int i27 = i25 + 1;
            int g3 = i7 + ((g2 << 5) | (g2 >>> 27)) + g(i4, i26, i6) + this.X[i25] + Y3;
            int i28 = (i4 >>> 2) | (i4 << 30);
            int i29 = i27 + 1;
            int g4 = i6 + ((g3 << 5) | (g3 >>> 27)) + g(g2, i28, i26) + this.X[i27] + Y3;
            i8 = (g2 >>> 2) | (g2 << 30);
            int i30 = i29 + 1;
            i5 = i26 + ((g4 << 5) | (g4 >>> 27)) + g(g3, i8, i28) + this.X[i29] + Y3;
            i7 = (g3 >>> 2) | (g3 << 30);
            i4 = i28 + ((i5 << 5) | (i5 >>> 27)) + g(g4, i7, i8) + this.X[i30] + Y3;
            i6 = (g4 >>> 2) | (g4 << 30);
            i24++;
            i10 = i30 + 1;
        }
        int i31 = 0;
        while (i31 <= 3) {
            int i32 = i10 + 1;
            int h5 = i8 + ((i4 << 5) | (i4 >>> 27)) + h(i5, i6, i7) + this.X[i10] + Y4;
            int i33 = (i5 >>> 2) | (i5 << 30);
            int i34 = i32 + 1;
            int h6 = i7 + ((h5 << 5) | (h5 >>> 27)) + h(i4, i33, i6) + this.X[i32] + Y4;
            int i35 = (i4 >>> 2) | (i4 << 30);
            int i36 = i34 + 1;
            int h7 = i6 + ((h6 << 5) | (h6 >>> 27)) + h(h5, i35, i33) + this.X[i34] + Y4;
            i8 = (h5 >>> 2) | (h5 << 30);
            int i37 = i36 + 1;
            i5 = i33 + ((h7 << 5) | (h7 >>> 27)) + h(h6, i8, i35) + this.X[i36] + Y4;
            i7 = (h6 >>> 2) | (h6 << 30);
            i4 = i35 + ((i5 << 5) | (i5 >>> 27)) + h(h7, i7, i8) + this.X[i37] + Y4;
            i6 = (h7 >>> 2) | (h7 << 30);
            i31++;
            i10 = i37 + 1;
        }
        this.H1 += i4;
        this.H2 += i5;
        this.H3 += i6;
        this.H4 += i7;
        this.H5 += i8;
        this.xOff = 0;
        for (int i38 = 0; i38 < 16; i38++) {
            this.X[i38] = 0;
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    protected void processLength(long j2) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.X;
        iArr[14] = (int) (j2 >>> 32);
        iArr[15] = (int) (j2 & (-1));
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    protected void processWord(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = (bArr[i4 + 1] & 255) | (bArr[i2] << 24) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 8);
        int[] iArr = this.X;
        int i6 = this.xOff;
        iArr[i6] = i5;
        int i7 = i6 + 1;
        this.xOff = i7;
        if (i7 == 16) {
            processBlock();
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest, org.spongycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.H1 = 1732584193;
        this.H2 = -271733879;
        this.H3 = -1732584194;
        this.H4 = 271733878;
        this.H5 = -1009589776;
        this.xOff = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.X;
            if (i2 == iArr.length) {
                return;
            }
            iArr[i2] = 0;
            i2++;
        }
    }

    public SHA1Digest(SHA1Digest sHA1Digest) {
        super(sHA1Digest);
        this.X = new int[80];
        copyIn(sHA1Digest);
    }

    public SHA1Digest(byte[] bArr) {
        super(bArr);
        this.X = new int[80];
        this.H1 = Pack.bigEndianToInt(bArr, 16);
        this.H2 = Pack.bigEndianToInt(bArr, 20);
        this.H3 = Pack.bigEndianToInt(bArr, 24);
        this.H4 = Pack.bigEndianToInt(bArr, 28);
        this.H5 = Pack.bigEndianToInt(bArr, 32);
        this.xOff = Pack.bigEndianToInt(bArr, 36);
        for (int i2 = 0; i2 != this.xOff; i2++) {
            this.X[i2] = Pack.bigEndianToInt(bArr, (i2 * 4) + 40);
        }
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        SHA1Digest sHA1Digest = (SHA1Digest) memoable;
        super.copyIn((GeneralDigest) sHA1Digest);
        copyIn(sHA1Digest);
    }
}