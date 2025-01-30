package org.spongycastle.crypto.engines;

import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public class ChaChaEngine extends Salsa20Engine {
    public ChaChaEngine() {
    }

    public static void chachaCore(int i2, int[] iArr, int[] iArr2) {
        int i3 = 16;
        if (iArr.length == 16) {
            if (iArr2.length == 16) {
                if (i2 % 2 == 0) {
                    char c2 = 0;
                    int i4 = iArr[0];
                    int i5 = iArr[1];
                    int i6 = iArr[2];
                    int i7 = iArr[3];
                    int i8 = iArr[4];
                    int i9 = iArr[5];
                    int i10 = iArr[6];
                    int i11 = 7;
                    int i12 = iArr[7];
                    int i13 = 8;
                    int i14 = iArr[8];
                    int i15 = iArr[9];
                    int i16 = iArr[10];
                    int i17 = iArr[11];
                    int i18 = 12;
                    int i19 = iArr[12];
                    int i20 = iArr[13];
                    int i21 = iArr[14];
                    int i22 = iArr[15];
                    int i23 = i21;
                    int i24 = i20;
                    int i25 = i19;
                    int i26 = i17;
                    int i27 = i16;
                    int i28 = i15;
                    int i29 = i14;
                    int i30 = i12;
                    int i31 = i10;
                    int i32 = i9;
                    int i33 = i8;
                    int i34 = i7;
                    int i35 = i6;
                    int i36 = i5;
                    int i37 = i4;
                    int i38 = i2;
                    while (i38 > 0) {
                        int i39 = i37 + i33;
                        int rotl = Salsa20Engine.rotl(i25 ^ i39, i3);
                        int i40 = i29 + rotl;
                        int rotl2 = Salsa20Engine.rotl(i33 ^ i40, i18);
                        int i41 = i39 + rotl2;
                        int rotl3 = Salsa20Engine.rotl(rotl ^ i41, i13);
                        int i42 = i40 + rotl3;
                        int rotl4 = Salsa20Engine.rotl(rotl2 ^ i42, i11);
                        int i43 = i36 + i32;
                        int rotl5 = Salsa20Engine.rotl(i24 ^ i43, i3);
                        int i44 = i28 + rotl5;
                        int rotl6 = Salsa20Engine.rotl(i32 ^ i44, i18);
                        int i45 = i43 + rotl6;
                        int rotl7 = Salsa20Engine.rotl(rotl5 ^ i45, i13);
                        int i46 = i44 + rotl7;
                        int rotl8 = Salsa20Engine.rotl(rotl6 ^ i46, i11);
                        int i47 = i35 + i31;
                        int rotl9 = Salsa20Engine.rotl(i23 ^ i47, i3);
                        int i48 = i27 + rotl9;
                        int rotl10 = Salsa20Engine.rotl(i31 ^ i48, i18);
                        int i49 = i47 + rotl10;
                        int rotl11 = Salsa20Engine.rotl(rotl9 ^ i49, i13);
                        int i50 = i48 + rotl11;
                        int rotl12 = Salsa20Engine.rotl(rotl10 ^ i50, i11);
                        int i51 = i34 + i30;
                        int rotl13 = Salsa20Engine.rotl(i22 ^ i51, 16);
                        int i52 = i26 + rotl13;
                        int rotl14 = Salsa20Engine.rotl(i30 ^ i52, i18);
                        int i53 = i51 + rotl14;
                        int rotl15 = Salsa20Engine.rotl(rotl13 ^ i53, 8);
                        int i54 = i52 + rotl15;
                        int rotl16 = Salsa20Engine.rotl(rotl14 ^ i54, 7);
                        int i55 = i41 + rotl8;
                        int rotl17 = Salsa20Engine.rotl(rotl15 ^ i55, 16);
                        int i56 = i50 + rotl17;
                        int rotl18 = Salsa20Engine.rotl(rotl8 ^ i56, 12);
                        i37 = i55 + rotl18;
                        i22 = Salsa20Engine.rotl(rotl17 ^ i37, 8);
                        i27 = i56 + i22;
                        i32 = Salsa20Engine.rotl(rotl18 ^ i27, 7);
                        int i57 = i45 + rotl12;
                        int rotl19 = Salsa20Engine.rotl(rotl3 ^ i57, 16);
                        int i58 = i54 + rotl19;
                        int rotl20 = Salsa20Engine.rotl(rotl12 ^ i58, 12);
                        i36 = i57 + rotl20;
                        i25 = Salsa20Engine.rotl(rotl19 ^ i36, 8);
                        i26 = i58 + i25;
                        i31 = Salsa20Engine.rotl(rotl20 ^ i26, 7);
                        int i59 = i49 + rotl16;
                        int rotl21 = Salsa20Engine.rotl(rotl7 ^ i59, 16);
                        int i60 = i42 + rotl21;
                        int rotl22 = Salsa20Engine.rotl(rotl16 ^ i60, 12);
                        i35 = i59 + rotl22;
                        i24 = Salsa20Engine.rotl(rotl21 ^ i35, 8);
                        i29 = i60 + i24;
                        i30 = Salsa20Engine.rotl(rotl22 ^ i29, 7);
                        int i61 = i53 + rotl4;
                        i3 = 16;
                        int rotl23 = Salsa20Engine.rotl(rotl11 ^ i61, 16);
                        int i62 = i46 + rotl23;
                        int rotl24 = Salsa20Engine.rotl(rotl4 ^ i62, 12);
                        i34 = i61 + rotl24;
                        i23 = Salsa20Engine.rotl(rotl23 ^ i34, 8);
                        i28 = i62 + i23;
                        i33 = Salsa20Engine.rotl(rotl24 ^ i28, 7);
                        i38 -= 2;
                        c2 = 0;
                        i18 = 12;
                        i13 = 8;
                        i11 = 7;
                    }
                    iArr2[c2] = i37 + iArr[c2];
                    iArr2[1] = i36 + iArr[1];
                    iArr2[2] = i35 + iArr[2];
                    iArr2[3] = i34 + iArr[3];
                    iArr2[4] = i33 + iArr[4];
                    iArr2[5] = i32 + iArr[5];
                    iArr2[6] = i31 + iArr[6];
                    iArr2[7] = i30 + iArr[7];
                    iArr2[8] = i29 + iArr[8];
                    iArr2[9] = i28 + iArr[9];
                    iArr2[10] = i27 + iArr[10];
                    iArr2[11] = i26 + iArr[11];
                    iArr2[12] = i25 + iArr[12];
                    iArr2[13] = i24 + iArr[13];
                    iArr2[14] = i23 + iArr[14];
                    iArr2[15] = i22 + iArr[15];
                    return;
                }
                throw new IllegalArgumentException("Number of rounds must be even");
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    @Override // org.spongycastle.crypto.engines.Salsa20Engine
    protected void advanceCounter(long j2) {
        int i2 = (int) (j2 >>> 32);
        int i3 = (int) j2;
        if (i2 > 0) {
            int[] iArr = this.engineState;
            iArr[13] = iArr[13] + i2;
        }
        int[] iArr2 = this.engineState;
        int i4 = iArr2[12];
        iArr2[12] = iArr2[12] + i3;
        if (i4 == 0 || iArr2[12] >= i4) {
            return;
        }
        iArr2[13] = iArr2[13] + 1;
    }

    @Override // org.spongycastle.crypto.engines.Salsa20Engine
    protected void generateKeyStream(byte[] bArr) {
        chachaCore(this.rounds, this.engineState, this.x);
        Pack.intToLittleEndian(this.x, bArr, 0);
    }

    @Override // org.spongycastle.crypto.engines.Salsa20Engine, org.spongycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "ChaCha" + this.rounds;
    }

    @Override // org.spongycastle.crypto.engines.Salsa20Engine
    protected long getCounter() {
        int[] iArr = this.engineState;
        return (iArr[13] << 32) | (iArr[12] & 4294967295L);
    }

    @Override // org.spongycastle.crypto.engines.Salsa20Engine
    protected void resetCounter() {
        int[] iArr = this.engineState;
        iArr[13] = 0;
        iArr[12] = 0;
    }

    @Override // org.spongycastle.crypto.engines.Salsa20Engine
    protected void retreatCounter(long j2) {
        int i2 = (int) (j2 >>> 32);
        int i3 = (int) j2;
        if (i2 != 0) {
            int[] iArr = this.engineState;
            if ((iArr[13] & 4294967295L) >= (i2 & 4294967295L)) {
                iArr[13] = iArr[13] - i2;
            } else {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
        }
        int[] iArr2 = this.engineState;
        if ((iArr2[12] & 4294967295L) >= (4294967295L & i3)) {
            iArr2[12] = iArr2[12] - i3;
        } else if (iArr2[13] != 0) {
            iArr2[13] = iArr2[13] - 1;
            iArr2[12] = iArr2[12] - i3;
        } else {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.spongycastle.crypto.engines.Salsa20Engine
    public void setKey(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        if (bArr != null) {
            int i2 = 16;
            if (bArr.length != 16 && bArr.length != 32) {
                throw new IllegalArgumentException(getAlgorithmName() + " requires 128 bit or 256 bit key");
            }
            this.engineState[4] = Pack.littleEndianToInt(bArr, 0);
            this.engineState[5] = Pack.littleEndianToInt(bArr, 4);
            this.engineState[6] = Pack.littleEndianToInt(bArr, 8);
            this.engineState[7] = Pack.littleEndianToInt(bArr, 12);
            if (bArr.length == 32) {
                bArr3 = Salsa20Engine.sigma;
            } else {
                bArr3 = Salsa20Engine.tau;
                i2 = 0;
            }
            this.engineState[8] = Pack.littleEndianToInt(bArr, i2);
            this.engineState[9] = Pack.littleEndianToInt(bArr, i2 + 4);
            this.engineState[10] = Pack.littleEndianToInt(bArr, i2 + 8);
            this.engineState[11] = Pack.littleEndianToInt(bArr, i2 + 12);
            this.engineState[0] = Pack.littleEndianToInt(bArr3, 0);
            this.engineState[1] = Pack.littleEndianToInt(bArr3, 4);
            this.engineState[2] = Pack.littleEndianToInt(bArr3, 8);
            this.engineState[3] = Pack.littleEndianToInt(bArr3, 12);
        }
        this.engineState[14] = Pack.littleEndianToInt(bArr2, 0);
        this.engineState[15] = Pack.littleEndianToInt(bArr2, 4);
    }

    public ChaChaEngine(int i2) {
        super(i2);
    }

    @Override // org.spongycastle.crypto.engines.Salsa20Engine
    protected void advanceCounter() {
        int[] iArr = this.engineState;
        int i2 = iArr[12] + 1;
        iArr[12] = i2;
        if (i2 == 0) {
            iArr[13] = iArr[13] + 1;
        }
    }

    @Override // org.spongycastle.crypto.engines.Salsa20Engine
    protected void retreatCounter() {
        int[] iArr = this.engineState;
        if (iArr[12] == 0 && iArr[13] == 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        int i2 = iArr[12] - 1;
        iArr[12] = i2;
        if (i2 == -1) {
            iArr[13] = iArr[13] - 1;
        }
    }
}