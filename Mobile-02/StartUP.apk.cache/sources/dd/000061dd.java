package org.spongycastle.crypto.engines;

/* loaded from: classes3.dex */
public final class CAST6Engine extends CAST5Engine {
    protected static final int BLOCK_SIZE = 16;
    protected static final int ROUNDS = 12;
    protected int[] _Kr = new int[48];
    protected int[] _Km = new int[48];
    protected int[] _Tr = new int[192];
    protected int[] _Tm = new int[192];
    private int[] _workingKey = new int[8];

    protected final void CAST_Decipher(int i2, int i3, int i4, int i5, int[] iArr) {
        int i6;
        int i7 = 0;
        while (true) {
            if (i7 >= 6) {
                break;
            }
            int i8 = (11 - i7) * 4;
            i4 ^= F1(i5, this._Km[i8], this._Kr[i8]);
            int i9 = i8 + 1;
            i3 ^= F2(i4, this._Km[i9], this._Kr[i9]);
            int i10 = i8 + 2;
            i2 ^= F3(i3, this._Km[i10], this._Kr[i10]);
            int i11 = i8 + 3;
            i5 ^= F1(i2, this._Km[i11], this._Kr[i11]);
            i7++;
        }
        for (i6 = 6; i6 < 12; i6++) {
            int i12 = (11 - i6) * 4;
            int i13 = i12 + 3;
            i5 ^= F1(i2, this._Km[i13], this._Kr[i13]);
            int i14 = i12 + 2;
            i2 ^= F3(i3, this._Km[i14], this._Kr[i14]);
            int i15 = i12 + 1;
            i3 ^= F2(i4, this._Km[i15], this._Kr[i15]);
            i4 ^= F1(i5, this._Km[i12], this._Kr[i12]);
        }
        iArr[0] = i2;
        iArr[1] = i3;
        iArr[2] = i4;
        iArr[3] = i5;
    }

    protected final void CAST_Encipher(int i2, int i3, int i4, int i5, int[] iArr) {
        int i6;
        int i7 = 0;
        while (true) {
            if (i7 >= 6) {
                break;
            }
            int i8 = i7 * 4;
            i4 ^= F1(i5, this._Km[i8], this._Kr[i8]);
            int i9 = i8 + 1;
            i3 ^= F2(i4, this._Km[i9], this._Kr[i9]);
            int i10 = i8 + 2;
            i2 ^= F3(i3, this._Km[i10], this._Kr[i10]);
            int i11 = i8 + 3;
            i5 ^= F1(i2, this._Km[i11], this._Kr[i11]);
            i7++;
        }
        for (i6 = 6; i6 < 12; i6++) {
            int i12 = i6 * 4;
            int i13 = i12 + 3;
            i5 ^= F1(i2, this._Km[i13], this._Kr[i13]);
            int i14 = i12 + 2;
            i2 ^= F3(i3, this._Km[i14], this._Kr[i14]);
            int i15 = i12 + 1;
            i3 ^= F2(i4, this._Km[i15], this._Kr[i15]);
            i4 ^= F1(i5, this._Km[i12], this._Kr[i12]);
        }
        iArr[0] = i2;
        iArr[1] = i3;
        iArr[2] = i4;
        iArr[3] = i5;
    }

    @Override // org.spongycastle.crypto.engines.CAST5Engine
    protected int decryptBlock(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int[] iArr = new int[4];
        CAST_Decipher(BytesTo32bits(bArr, i2), BytesTo32bits(bArr, i2 + 4), BytesTo32bits(bArr, i2 + 8), BytesTo32bits(bArr, i2 + 12), iArr);
        Bits32ToBytes(iArr[0], bArr2, i3);
        Bits32ToBytes(iArr[1], bArr2, i3 + 4);
        Bits32ToBytes(iArr[2], bArr2, i3 + 8);
        Bits32ToBytes(iArr[3], bArr2, i3 + 12);
        return 16;
    }

    @Override // org.spongycastle.crypto.engines.CAST5Engine
    protected int encryptBlock(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int[] iArr = new int[4];
        CAST_Encipher(BytesTo32bits(bArr, i2), BytesTo32bits(bArr, i2 + 4), BytesTo32bits(bArr, i2 + 8), BytesTo32bits(bArr, i2 + 12), iArr);
        Bits32ToBytes(iArr[0], bArr2, i3);
        Bits32ToBytes(iArr[1], bArr2, i3 + 4);
        Bits32ToBytes(iArr[2], bArr2, i3 + 8);
        Bits32ToBytes(iArr[3], bArr2, i3 + 12);
        return 16;
    }

    @Override // org.spongycastle.crypto.engines.CAST5Engine, org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "CAST6";
    }

    @Override // org.spongycastle.crypto.engines.CAST5Engine, org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.spongycastle.crypto.engines.CAST5Engine, org.spongycastle.crypto.BlockCipher
    public void reset() {
    }

    @Override // org.spongycastle.crypto.engines.CAST5Engine
    protected void setKey(byte[] bArr) {
        int i2 = 1518500249;
        int i3 = 19;
        for (int i4 = 0; i4 < 24; i4++) {
            for (int i5 = 0; i5 < 8; i5++) {
                int i6 = (i4 * 8) + i5;
                this._Tm[i6] = i2;
                i2 += 1859775393;
                this._Tr[i6] = i3;
                i3 = (i3 + 17) & 31;
            }
        }
        byte[] bArr2 = new byte[64];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        for (int i7 = 0; i7 < 8; i7++) {
            this._workingKey[i7] = BytesTo32bits(bArr2, i7 * 4);
        }
        for (int i8 = 0; i8 < 12; i8++) {
            int i9 = i8 * 2;
            int i10 = i9 * 8;
            int[] iArr = this._workingKey;
            iArr[6] = iArr[6] ^ F1(iArr[7], this._Tm[i10], this._Tr[i10]);
            int[] iArr2 = this._workingKey;
            int i11 = i10 + 1;
            iArr2[5] = iArr2[5] ^ F2(iArr2[6], this._Tm[i11], this._Tr[i11]);
            int[] iArr3 = this._workingKey;
            int i12 = i10 + 2;
            iArr3[4] = iArr3[4] ^ F3(iArr3[5], this._Tm[i12], this._Tr[i12]);
            int[] iArr4 = this._workingKey;
            int i13 = i10 + 3;
            iArr4[3] = F1(iArr4[4], this._Tm[i13], this._Tr[i13]) ^ iArr4[3];
            int[] iArr5 = this._workingKey;
            int i14 = i10 + 4;
            iArr5[2] = F2(iArr5[3], this._Tm[i14], this._Tr[i14]) ^ iArr5[2];
            int[] iArr6 = this._workingKey;
            int i15 = i10 + 5;
            iArr6[1] = F3(iArr6[2], this._Tm[i15], this._Tr[i15]) ^ iArr6[1];
            int[] iArr7 = this._workingKey;
            int i16 = i10 + 6;
            iArr7[0] = iArr7[0] ^ F1(iArr7[1], this._Tm[i16], this._Tr[i16]);
            int[] iArr8 = this._workingKey;
            int i17 = i10 + 7;
            iArr8[7] = F2(iArr8[0], this._Tm[i17], this._Tr[i17]) ^ iArr8[7];
            int i18 = (i9 + 1) * 8;
            int[] iArr9 = this._workingKey;
            iArr9[6] = iArr9[6] ^ F1(iArr9[7], this._Tm[i18], this._Tr[i18]);
            int[] iArr10 = this._workingKey;
            int i19 = i18 + 1;
            iArr10[5] = iArr10[5] ^ F2(iArr10[6], this._Tm[i19], this._Tr[i19]);
            int[] iArr11 = this._workingKey;
            int i20 = i18 + 2;
            iArr11[4] = iArr11[4] ^ F3(iArr11[5], this._Tm[i20], this._Tr[i20]);
            int[] iArr12 = this._workingKey;
            int i21 = i18 + 3;
            iArr12[3] = F1(iArr12[4], this._Tm[i21], this._Tr[i21]) ^ iArr12[3];
            int[] iArr13 = this._workingKey;
            int i22 = i18 + 4;
            iArr13[2] = F2(iArr13[3], this._Tm[i22], this._Tr[i22]) ^ iArr13[2];
            int[] iArr14 = this._workingKey;
            int i23 = i18 + 5;
            iArr14[1] = F3(iArr14[2], this._Tm[i23], this._Tr[i23]) ^ iArr14[1];
            int[] iArr15 = this._workingKey;
            int i24 = i18 + 6;
            iArr15[0] = iArr15[0] ^ F1(iArr15[1], this._Tm[i24], this._Tr[i24]);
            int[] iArr16 = this._workingKey;
            int i25 = i18 + 7;
            iArr16[7] = F2(iArr16[0], this._Tm[i25], this._Tr[i25]) ^ iArr16[7];
            int[] iArr17 = this._Kr;
            int i26 = i8 * 4;
            int[] iArr18 = this._workingKey;
            iArr17[i26] = iArr18[0] & 31;
            int i27 = i26 + 1;
            iArr17[i27] = iArr18[2] & 31;
            int i28 = i26 + 2;
            iArr17[i28] = iArr18[4] & 31;
            int i29 = i26 + 3;
            iArr17[i29] = iArr18[6] & 31;
            int[] iArr19 = this._Km;
            iArr19[i26] = iArr18[7];
            iArr19[i27] = iArr18[5];
            iArr19[i28] = iArr18[3];
            iArr19[i29] = iArr18[1];
        }
    }
}