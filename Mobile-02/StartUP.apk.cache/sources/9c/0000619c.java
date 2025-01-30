package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public class SM3Digest extends GeneralDigest {
    private static final int BLOCK_SIZE = 16;
    private static final int DIGEST_LENGTH = 32;
    private static final int[] T = new int[64];
    private int[] V;
    private int[] W;
    private int[] W1;
    private int[] inwords;
    private int xOff;

    static {
        int i2;
        int i3 = 0;
        while (true) {
            if (i3 >= 16) {
                break;
            }
            T[i3] = (2043430169 >>> (32 - i3)) | (2043430169 << i3);
            i3++;
        }
        for (i2 = 16; i2 < 64; i2++) {
            int i4 = i2 % 32;
            T[i2] = (2055708042 >>> (32 - i4)) | (2055708042 << i4);
        }
    }

    public SM3Digest() {
        this.V = new int[8];
        this.inwords = new int[16];
        this.W = new int[68];
        this.W1 = new int[64];
        reset();
    }

    private int FF0(int i2, int i3, int i4) {
        return (i2 ^ i3) ^ i4;
    }

    private int FF1(int i2, int i3, int i4) {
        return (i2 & i4) | (i2 & i3) | (i3 & i4);
    }

    private int GG0(int i2, int i3, int i4) {
        return (i2 ^ i3) ^ i4;
    }

    private int GG1(int i2, int i3, int i4) {
        return ((~i2) & i4) | (i3 & i2);
    }

    private int P0(int i2) {
        return (i2 ^ ((i2 << 9) | (i2 >>> 23))) ^ ((i2 << 17) | (i2 >>> 15));
    }

    private int P1(int i2) {
        return (i2 ^ ((i2 << 15) | (i2 >>> 17))) ^ ((i2 << 23) | (i2 >>> 9));
    }

    private void copyIn(SM3Digest sM3Digest) {
        int[] iArr = sM3Digest.V;
        int[] iArr2 = this.V;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        int[] iArr3 = sM3Digest.inwords;
        int[] iArr4 = this.inwords;
        System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
        this.xOff = sM3Digest.xOff;
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new SM3Digest(this);
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i2) {
        finish();
        Pack.intToBigEndian(this.V[0], bArr, i2 + 0);
        Pack.intToBigEndian(this.V[1], bArr, i2 + 4);
        Pack.intToBigEndian(this.V[2], bArr, i2 + 8);
        Pack.intToBigEndian(this.V[3], bArr, i2 + 12);
        Pack.intToBigEndian(this.V[4], bArr, i2 + 16);
        Pack.intToBigEndian(this.V[5], bArr, i2 + 20);
        Pack.intToBigEndian(this.V[6], bArr, i2 + 24);
        Pack.intToBigEndian(this.V[7], bArr, i2 + 28);
        reset();
        return 32;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SM3";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 32;
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    protected void processBlock() {
        for (int i2 = 0; i2 < 16; i2++) {
            this.W[i2] = this.inwords[i2];
        }
        for (int i3 = 16; i3 < 68; i3++) {
            int[] iArr = this.W;
            int i4 = iArr[i3 - 3];
            int i5 = iArr[i3 - 13];
            iArr[i3] = (P1(((i4 >>> 17) | (i4 << 15)) ^ (iArr[i3 - 16] ^ iArr[i3 - 9])) ^ ((i5 >>> 25) | (i5 << 7))) ^ this.W[i3 - 6];
        }
        for (int i6 = 0; i6 < 64; i6++) {
            int[] iArr2 = this.W1;
            int[] iArr3 = this.W;
            iArr2[i6] = iArr3[i6 + 4] ^ iArr3[i6];
        }
        int[] iArr4 = this.V;
        int i7 = iArr4[0];
        int i8 = iArr4[1];
        int i9 = iArr4[2];
        int i10 = iArr4[3];
        int i11 = iArr4[4];
        int i12 = iArr4[5];
        int i13 = iArr4[6];
        int i14 = iArr4[7];
        int i15 = 0;
        int i16 = i13;
        while (i15 < 16) {
            int i17 = (i7 << 12) | (i7 >>> 20);
            int i18 = i17 + i11 + T[i15];
            int i19 = (i18 << 7) | (i18 >>> 25);
            int FF0 = FF0(i7, i8, i9) + i10;
            int GG0 = GG0(i11, i12, i16) + i14 + i19 + this.W[i15];
            int i20 = (i8 << 9) | (i8 >>> 23);
            i15++;
            int i21 = i11;
            i11 = P0(GG0);
            i14 = i16;
            i16 = (i12 << 19) | (i12 >>> 13);
            i12 = i21;
            i8 = i7;
            i7 = FF0 + (i19 ^ i17) + this.W1[i15];
            i10 = i9;
            i9 = i20;
        }
        int i22 = i10;
        int i23 = i9;
        int i24 = i8;
        int i25 = i7;
        int i26 = 16;
        int i27 = i14;
        int i28 = i16;
        while (i26 < 64) {
            int i29 = (i25 << 12) | (i25 >>> 20);
            int i30 = i29 + i11 + T[i26];
            int i31 = (i30 << 7) | (i30 >>> 25);
            int FF1 = FF1(i25, i24, i23) + i22;
            int GG1 = GG1(i11, i12, i28) + i27 + i31 + this.W[i26];
            int i32 = (i24 >>> 23) | (i24 << 9);
            int i33 = (i12 << 19) | (i12 >>> 13);
            i26++;
            i12 = i11;
            i11 = P0(GG1);
            i27 = i28;
            i28 = i33;
            i24 = i25;
            i25 = FF1 + (i31 ^ i29) + this.W1[i26];
            i22 = i23;
            i23 = i32;
        }
        int[] iArr5 = this.V;
        iArr5[0] = iArr5[0] ^ i25;
        iArr5[1] = iArr5[1] ^ i24;
        iArr5[2] = iArr5[2] ^ i23;
        iArr5[3] = iArr5[3] ^ i22;
        iArr5[4] = iArr5[4] ^ i11;
        iArr5[5] = iArr5[5] ^ i12;
        iArr5[6] = i28 ^ iArr5[6];
        iArr5[7] = iArr5[7] ^ i27;
        this.xOff = 0;
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    protected void processLength(long j2) {
        int i2 = this.xOff;
        if (i2 > 14) {
            this.inwords[i2] = 0;
            this.xOff = i2 + 1;
            processBlock();
        }
        while (true) {
            int i3 = this.xOff;
            if (i3 < 14) {
                this.inwords[i3] = 0;
                this.xOff = i3 + 1;
            } else {
                int[] iArr = this.inwords;
                int i4 = i3 + 1;
                this.xOff = i4;
                iArr[i3] = (int) (j2 >>> 32);
                this.xOff = i4 + 1;
                iArr[i4] = (int) j2;
                return;
            }
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    protected void processWord(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = (bArr[i4 + 1] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 8);
        int[] iArr = this.inwords;
        int i6 = this.xOff;
        iArr[i6] = i5;
        int i7 = i6 + 1;
        this.xOff = i7;
        if (i7 >= 16) {
            processBlock();
        }
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        SM3Digest sM3Digest = (SM3Digest) memoable;
        super.copyIn((GeneralDigest) sM3Digest);
        copyIn(sM3Digest);
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest, org.spongycastle.crypto.Digest
    public void reset() {
        super.reset();
        int[] iArr = this.V;
        iArr[0] = 1937774191;
        iArr[1] = 1226093241;
        iArr[2] = 388252375;
        iArr[3] = -628488704;
        iArr[4] = -1452330820;
        iArr[5] = 372324522;
        iArr[6] = -477237683;
        iArr[7] = -1325724082;
        this.xOff = 0;
    }

    public SM3Digest(SM3Digest sM3Digest) {
        super(sM3Digest);
        this.V = new int[8];
        this.inwords = new int[16];
        this.W = new int[68];
        this.W1 = new int[64];
        copyIn(sM3Digest);
    }
}