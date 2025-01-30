package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public class SHA256Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 32;
    static final int[] K = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int H5;
    private int H6;
    private int H7;
    private int H8;
    private int[] X;
    private int xOff;

    public SHA256Digest() {
        this.X = new int[64];
        reset();
    }

    private int Ch(int i2, int i3, int i4) {
        return ((~i2) & i4) ^ (i3 & i2);
    }

    private int Maj(int i2, int i3, int i4) {
        return ((i2 & i4) ^ (i2 & i3)) ^ (i3 & i4);
    }

    private int Sum0(int i2) {
        return ((i2 << 10) | (i2 >>> 22)) ^ (((i2 >>> 2) | (i2 << 30)) ^ ((i2 >>> 13) | (i2 << 19)));
    }

    private int Sum1(int i2) {
        return ((i2 << 7) | (i2 >>> 25)) ^ (((i2 >>> 6) | (i2 << 26)) ^ ((i2 >>> 11) | (i2 << 21)));
    }

    private int Theta0(int i2) {
        return (i2 >>> 3) ^ (((i2 >>> 7) | (i2 << 25)) ^ ((i2 >>> 18) | (i2 << 14)));
    }

    private int Theta1(int i2) {
        return (i2 >>> 10) ^ (((i2 >>> 17) | (i2 << 15)) ^ ((i2 >>> 19) | (i2 << 13)));
    }

    private void copyIn(SHA256Digest sHA256Digest) {
        super.copyIn((GeneralDigest) sHA256Digest);
        this.H1 = sHA256Digest.H1;
        this.H2 = sHA256Digest.H2;
        this.H3 = sHA256Digest.H3;
        this.H4 = sHA256Digest.H4;
        this.H5 = sHA256Digest.H5;
        this.H6 = sHA256Digest.H6;
        this.H7 = sHA256Digest.H7;
        this.H8 = sHA256Digest.H8;
        int[] iArr = sHA256Digest.X;
        System.arraycopy(iArr, 0, this.X, 0, iArr.length);
        this.xOff = sHA256Digest.xOff;
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new SHA256Digest(this);
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i2) {
        finish();
        Pack.intToBigEndian(this.H1, bArr, i2);
        Pack.intToBigEndian(this.H2, bArr, i2 + 4);
        Pack.intToBigEndian(this.H3, bArr, i2 + 8);
        Pack.intToBigEndian(this.H4, bArr, i2 + 12);
        Pack.intToBigEndian(this.H5, bArr, i2 + 16);
        Pack.intToBigEndian(this.H6, bArr, i2 + 20);
        Pack.intToBigEndian(this.H7, bArr, i2 + 24);
        Pack.intToBigEndian(this.H8, bArr, i2 + 28);
        reset();
        return 32;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-256";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 32;
    }

    @Override // org.spongycastle.crypto.digests.EncodableDigest
    public byte[] getEncodedState() {
        byte[] bArr = new byte[(this.xOff * 4) + 52];
        super.populateState(bArr);
        Pack.intToBigEndian(this.H1, bArr, 16);
        Pack.intToBigEndian(this.H2, bArr, 20);
        Pack.intToBigEndian(this.H3, bArr, 24);
        Pack.intToBigEndian(this.H4, bArr, 28);
        Pack.intToBigEndian(this.H5, bArr, 32);
        Pack.intToBigEndian(this.H6, bArr, 36);
        Pack.intToBigEndian(this.H7, bArr, 40);
        Pack.intToBigEndian(this.H8, bArr, 44);
        Pack.intToBigEndian(this.xOff, bArr, 48);
        for (int i2 = 0; i2 != this.xOff; i2++) {
            Pack.intToBigEndian(this.X[i2], bArr, (i2 * 4) + 52);
        }
        return bArr;
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    protected void processBlock() {
        for (int i2 = 16; i2 <= 63; i2++) {
            int[] iArr = this.X;
            int Theta1 = Theta1(iArr[i2 - 2]);
            int[] iArr2 = this.X;
            iArr[i2] = Theta1 + iArr2[i2 - 7] + Theta0(iArr2[i2 - 15]) + this.X[i2 - 16];
        }
        int i3 = this.H1;
        int i4 = this.H2;
        int i5 = this.H3;
        int i6 = this.H4;
        int i7 = this.H5;
        int i8 = this.H6;
        int i9 = this.H7;
        int i10 = this.H8;
        int i11 = 0;
        for (int i12 = 0; i12 < 8; i12++) {
            int Sum1 = Sum1(i7) + Ch(i7, i8, i9);
            int[] iArr3 = K;
            int i13 = i10 + Sum1 + iArr3[i11] + this.X[i11];
            int i14 = i6 + i13;
            int Sum0 = i13 + Sum0(i3) + Maj(i3, i4, i5);
            int i15 = i11 + 1;
            int Sum12 = i9 + Sum1(i14) + Ch(i14, i7, i8) + iArr3[i15] + this.X[i15];
            int i16 = i5 + Sum12;
            int Sum02 = Sum12 + Sum0(Sum0) + Maj(Sum0, i3, i4);
            int i17 = i15 + 1;
            int Sum13 = i8 + Sum1(i16) + Ch(i16, i14, i7) + iArr3[i17] + this.X[i17];
            int i18 = i4 + Sum13;
            int Sum03 = Sum13 + Sum0(Sum02) + Maj(Sum02, Sum0, i3);
            int i19 = i17 + 1;
            int Sum14 = i7 + Sum1(i18) + Ch(i18, i16, i14) + iArr3[i19] + this.X[i19];
            int i20 = i3 + Sum14;
            int Sum04 = Sum14 + Sum0(Sum03) + Maj(Sum03, Sum02, Sum0);
            int i21 = i19 + 1;
            int Sum15 = i14 + Sum1(i20) + Ch(i20, i18, i16) + iArr3[i21] + this.X[i21];
            i10 = Sum0 + Sum15;
            i6 = Sum15 + Sum0(Sum04) + Maj(Sum04, Sum03, Sum02);
            int i22 = i21 + 1;
            int Sum16 = i16 + Sum1(i10) + Ch(i10, i20, i18) + iArr3[i22] + this.X[i22];
            i9 = Sum02 + Sum16;
            i5 = Sum16 + Sum0(i6) + Maj(i6, Sum04, Sum03);
            int i23 = i22 + 1;
            int Sum17 = i18 + Sum1(i9) + Ch(i9, i10, i20) + iArr3[i23] + this.X[i23];
            i8 = Sum03 + Sum17;
            i4 = Sum17 + Sum0(i5) + Maj(i5, i6, Sum04);
            int i24 = i23 + 1;
            int Sum18 = i20 + Sum1(i8) + Ch(i8, i9, i10) + iArr3[i24] + this.X[i24];
            i7 = Sum04 + Sum18;
            i3 = Sum18 + Sum0(i4) + Maj(i4, i5, i6);
            i11 = i24 + 1;
        }
        this.H1 += i3;
        this.H2 += i4;
        this.H3 += i5;
        this.H4 += i6;
        this.H5 += i7;
        this.H6 += i8;
        this.H7 += i9;
        this.H8 += i10;
        this.xOff = 0;
        for (int i25 = 0; i25 < 16; i25++) {
            this.X[i25] = 0;
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
        this.H1 = 1779033703;
        this.H2 = -1150833019;
        this.H3 = 1013904242;
        this.H4 = -1521486534;
        this.H5 = 1359893119;
        this.H6 = -1694144372;
        this.H7 = 528734635;
        this.H8 = 1541459225;
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

    public SHA256Digest(SHA256Digest sHA256Digest) {
        super(sHA256Digest);
        this.X = new int[64];
        copyIn(sHA256Digest);
    }

    public SHA256Digest(byte[] bArr) {
        super(bArr);
        this.X = new int[64];
        this.H1 = Pack.bigEndianToInt(bArr, 16);
        this.H2 = Pack.bigEndianToInt(bArr, 20);
        this.H3 = Pack.bigEndianToInt(bArr, 24);
        this.H4 = Pack.bigEndianToInt(bArr, 28);
        this.H5 = Pack.bigEndianToInt(bArr, 32);
        this.H6 = Pack.bigEndianToInt(bArr, 36);
        this.H7 = Pack.bigEndianToInt(bArr, 40);
        this.H8 = Pack.bigEndianToInt(bArr, 44);
        this.xOff = Pack.bigEndianToInt(bArr, 48);
        for (int i2 = 0; i2 != this.xOff; i2++) {
            this.X[i2] = Pack.bigEndianToInt(bArr, (i2 * 4) + 52);
        }
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        copyIn((SHA256Digest) memoable);
    }
}