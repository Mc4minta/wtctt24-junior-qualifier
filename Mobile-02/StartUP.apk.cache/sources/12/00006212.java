package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.signers.PSSSigner;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.math.ec.Tnaf;

/* loaded from: classes3.dex */
public final class TwofishEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final int GF256_FDBK = 361;
    private static final int GF256_FDBK_2 = 180;
    private static final int GF256_FDBK_4 = 90;
    private static final int INPUT_WHITEN = 0;
    private static final int MAX_KEY_BITS = 256;
    private static final int MAX_ROUNDS = 16;
    private static final int OUTPUT_WHITEN = 4;
    private static final byte[][] P = {new byte[]{-87, 103, -77, -24, 4, -3, -93, 118, -102, -110, Byte.MIN_VALUE, 120, -28, -35, -47, 56, 13, -58, 53, -104, 24, -9, -20, 108, 67, 117, 55, 38, -6, 19, -108, 72, -14, -48, -117, 48, -124, 84, -33, 35, 25, 91, 61, 89, -13, -82, -94, -126, 99, 1, -125, 46, -39, 81, -101, 124, -90, -21, -91, -66, 22, 12, -29, 97, -64, -116, 58, -11, 115, 44, 37, 11, -69, 78, -119, 107, 83, 106, -76, -15, -31, -26, -67, 69, -30, -12, -74, 102, -52, -107, 3, 86, -44, 28, 30, -41, -5, -61, -114, -75, -23, -49, -65, -70, -22, 119, 57, -81, 51, -55, 98, 113, -127, 121, 9, -83, 36, -51, -7, -40, -27, -59, -71, 77, 68, 8, -122, -25, -95, 29, -86, -19, 6, 112, -78, -46, 65, 123, -96, 17, 49, -62, 39, -112, 32, -10, 96, -1, -106, 92, -79, -85, -98, -100, 82, 27, 95, -109, 10, -17, -111, -123, 73, -18, 45, 79, -113, 59, 71, -121, 109, 70, -42, 62, 105, 100, 42, -50, -53, 47, -4, -105, 5, 122, -84, Byte.MAX_VALUE, -43, 26, 75, 14, -89, 90, 40, 20, 63, 41, -120, 60, 76, 2, -72, -38, -80, 23, 85, 31, -118, 125, 87, -57, -115, 116, -73, -60, -97, 114, 126, 21, 34, 18, 88, 7, -103, 52, 110, 80, -34, 104, 101, PSSSigner.TRAILER_IMPLICIT, -37, -8, -56, -88, 43, 64, -36, -2, 50, -92, -54, Tnaf.POW_2_WIDTH, 33, -16, -45, 93, 15, 0, 111, -99, 54, 66, 74, 94, -63, -32}, new byte[]{117, -13, -58, -12, -37, 123, -5, -56, 74, -45, -26, 107, 69, 125, -24, 75, -42, 50, -40, -3, 55, 113, -15, -31, 48, 15, -8, 27, -121, -6, 6, 63, 94, -70, -82, 91, -118, 0, PSSSigner.TRAILER_IMPLICIT, -99, 109, -63, -79, 14, Byte.MIN_VALUE, 93, -46, -43, -96, -124, 7, 20, -75, -112, 44, -93, -78, 115, 76, 84, -110, 116, 54, 81, 56, -80, -67, 90, -4, 96, 98, -106, 108, 66, -9, Tnaf.POW_2_WIDTH, 124, 40, 39, -116, 19, -107, -100, -57, 36, 70, 59, 112, -54, -29, -123, -53, 17, -48, -109, -72, -90, -125, 32, -1, -97, 119, -61, -52, 3, 111, 8, -65, 64, -25, 43, -30, 121, 12, -86, -126, 65, 58, -22, -71, -28, -102, -92, -105, 126, -38, 122, 23, 102, -108, -95, 29, 61, -16, -34, -77, 11, 114, -89, 28, -17, -47, 83, 62, -113, 51, 38, 95, -20, 118, 42, 73, -127, -120, -18, 33, -60, 26, -21, -39, -59, 57, -103, -51, -83, 49, -117, 1, 24, 35, -35, 31, 78, 45, -7, 72, 79, -14, 101, -114, 120, 92, 88, 25, -115, -27, -104, 87, 103, Byte.MAX_VALUE, 5, 100, -81, 99, -74, -2, -11, -73, 60, -91, -50, -23, 104, 68, -32, 77, 67, 105, 41, 46, -84, 21, 89, -88, 10, -98, 110, 71, -33, 52, 53, 106, -49, -36, 34, -55, -64, -101, -119, -44, -19, -85, 18, -94, 13, 82, -69, 2, 47, -87, -41, 97, 30, -76, 80, 4, -10, -62, 22, 37, -122, 86, 85, 9, -66, -111}};
    private static final int P_00 = 1;
    private static final int P_01 = 0;
    private static final int P_02 = 0;
    private static final int P_03 = 1;
    private static final int P_04 = 1;
    private static final int P_10 = 0;
    private static final int P_11 = 0;
    private static final int P_12 = 1;
    private static final int P_13 = 1;
    private static final int P_14 = 0;
    private static final int P_20 = 1;
    private static final int P_21 = 1;
    private static final int P_22 = 0;
    private static final int P_23 = 0;
    private static final int P_24 = 0;
    private static final int P_30 = 0;
    private static final int P_31 = 1;
    private static final int P_32 = 1;
    private static final int P_33 = 0;
    private static final int P_34 = 1;
    private static final int ROUNDS = 16;
    private static final int ROUND_SUBKEYS = 8;
    private static final int RS_GF_FDBK = 333;
    private static final int SK_BUMP = 16843009;
    private static final int SK_ROTL = 9;
    private static final int SK_STEP = 33686018;
    private static final int TOTAL_SUBKEYS = 40;
    private int[] gSBox;
    private int[] gSubKeys;
    private boolean encrypting = false;
    private int[] gMDS0 = new int[256];
    private int[] gMDS1 = new int[256];
    private int[] gMDS2 = new int[256];
    private int[] gMDS3 = new int[256];
    private int k64Cnt = 0;
    private byte[] workingKey = null;

    public TwofishEngine() {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        for (int i2 = 0; i2 < 256; i2++) {
            byte[][] bArr = P;
            int i3 = bArr[0][i2] & 255;
            iArr[0] = i3;
            iArr2[0] = Mx_X(i3) & 255;
            iArr3[0] = Mx_Y(i3) & 255;
            int i4 = bArr[1][i2] & 255;
            iArr[1] = i4;
            iArr2[1] = Mx_X(i4) & 255;
            iArr3[1] = Mx_Y(i4) & 255;
            this.gMDS0[i2] = iArr[1] | (iArr2[1] << 8) | (iArr3[1] << 16) | (iArr3[1] << 24);
            this.gMDS1[i2] = iArr3[0] | (iArr3[0] << 8) | (iArr2[0] << 16) | (iArr[0] << 24);
            this.gMDS2[i2] = (iArr3[1] << 24) | iArr2[1] | (iArr3[1] << 8) | (iArr[1] << 16);
            this.gMDS3[i2] = iArr2[0] | (iArr[0] << 8) | (iArr3[0] << 16) | (iArr2[0] << 24);
        }
    }

    private void Bits32ToBytes(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) i2;
        bArr[i3 + 1] = (byte) (i2 >> 8);
        bArr[i3 + 2] = (byte) (i2 >> 16);
        bArr[i3 + 3] = (byte) (i2 >> 24);
    }

    private int BytesTo32Bits(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    private int F32(int i2, int[] iArr) {
        int i3;
        int i4;
        int b0 = b0(i2);
        int b1 = b1(i2);
        int b2 = b2(i2);
        int b3 = b3(i2);
        int i5 = iArr[0];
        int i6 = iArr[1];
        int i7 = iArr[2];
        int i8 = iArr[3];
        int i9 = this.k64Cnt & 3;
        if (i9 != 0) {
            if (i9 == 1) {
                int[] iArr2 = this.gMDS0;
                byte[][] bArr = P;
                i3 = (iArr2[(bArr[0][b0] & 255) ^ b0(i5)] ^ this.gMDS1[(bArr[0][b1] & 255) ^ b1(i5)]) ^ this.gMDS2[(bArr[1][b2] & 255) ^ b2(i5)];
                i4 = this.gMDS3[(bArr[1][b3] & 255) ^ b3(i5)];
                return i3 ^ i4;
            }
            if (i9 != 2) {
                if (i9 != 3) {
                    return 0;
                }
            }
            int[] iArr3 = this.gMDS0;
            byte[][] bArr2 = P;
            i3 = (iArr3[(bArr2[0][(bArr2[0][b0] & 255) ^ b0(i6)] & 255) ^ b0(i5)] ^ this.gMDS1[(bArr2[0][(bArr2[1][b1] & 255) ^ b1(i6)] & 255) ^ b1(i5)]) ^ this.gMDS2[(bArr2[1][(bArr2[0][b2] & 255) ^ b2(i6)] & 255) ^ b2(i5)];
            i4 = this.gMDS3[(bArr2[1][(bArr2[1][b3] & 255) ^ b3(i6)] & 255) ^ b3(i5)];
            return i3 ^ i4;
        }
        byte[][] bArr3 = P;
        b0 = (bArr3[1][b0] & 255) ^ b0(i8);
        b1 = (bArr3[0][b1] & 255) ^ b1(i8);
        b2 = (bArr3[0][b2] & 255) ^ b2(i8);
        b3 = (bArr3[1][b3] & 255) ^ b3(i8);
        byte[][] bArr4 = P;
        b0 = (bArr4[1][b0] & 255) ^ b0(i7);
        b1 = (bArr4[1][b1] & 255) ^ b1(i7);
        b2 = (bArr4[0][b2] & 255) ^ b2(i7);
        b3 = (bArr4[0][b3] & 255) ^ b3(i7);
        int[] iArr32 = this.gMDS0;
        byte[][] bArr22 = P;
        i3 = (iArr32[(bArr22[0][(bArr22[0][b0] & 255) ^ b0(i6)] & 255) ^ b0(i5)] ^ this.gMDS1[(bArr22[0][(bArr22[1][b1] & 255) ^ b1(i6)] & 255) ^ b1(i5)]) ^ this.gMDS2[(bArr22[1][(bArr22[0][b2] & 255) ^ b2(i6)] & 255) ^ b2(i5)];
        i4 = this.gMDS3[(bArr22[1][(bArr22[1][b3] & 255) ^ b3(i6)] & 255) ^ b3(i5)];
        return i3 ^ i4;
    }

    private int Fe32_0(int i2) {
        int[] iArr = this.gSBox;
        return iArr[(((i2 >>> 24) & 255) * 2) + 513] ^ ((iArr[((i2 & 255) * 2) + 0] ^ iArr[(((i2 >>> 8) & 255) * 2) + 1]) ^ iArr[(((i2 >>> 16) & 255) * 2) + 512]);
    }

    private int Fe32_3(int i2) {
        int[] iArr = this.gSBox;
        return iArr[(((i2 >>> 16) & 255) * 2) + 513] ^ ((iArr[(((i2 >>> 24) & 255) * 2) + 0] ^ iArr[((i2 & 255) * 2) + 1]) ^ iArr[(((i2 >>> 8) & 255) * 2) + 512]);
    }

    private int LFSR1(int i2) {
        return ((i2 & 1) != 0 ? 180 : 0) ^ (i2 >> 1);
    }

    private int LFSR2(int i2) {
        return ((i2 >> 2) ^ ((i2 & 2) != 0 ? 180 : 0)) ^ ((i2 & 1) != 0 ? 90 : 0);
    }

    private int Mx_X(int i2) {
        return i2 ^ LFSR2(i2);
    }

    private int Mx_Y(int i2) {
        return LFSR2(i2) ^ (LFSR1(i2) ^ i2);
    }

    private int RS_MDS_Encode(int i2, int i3) {
        for (int i4 = 0; i4 < 4; i4++) {
            i3 = RS_rem(i3);
        }
        int i5 = i2 ^ i3;
        for (int i6 = 0; i6 < 4; i6++) {
            i5 = RS_rem(i5);
        }
        return i5;
    }

    private int RS_rem(int i2) {
        int i3 = (i2 >>> 24) & 255;
        int i4 = ((i3 << 1) ^ ((i3 & 128) != 0 ? RS_GF_FDBK : 0)) & 255;
        int i5 = ((i3 >>> 1) ^ ((i3 & 1) != 0 ? CipherSuite.TLS_DH_anon_WITH_AES_128_GCM_SHA256 : 0)) ^ i4;
        return ((((i2 << 8) ^ (i5 << 24)) ^ (i4 << 16)) ^ (i5 << 8)) ^ i3;
    }

    private int b0(int i2) {
        return i2 & 255;
    }

    private int b1(int i2) {
        return (i2 >>> 8) & 255;
    }

    private int b2(int i2) {
        return (i2 >>> 16) & 255;
    }

    private int b3(int i2) {
        return (i2 >>> 24) & 255;
    }

    private void decryptBlock(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int BytesTo32Bits = BytesTo32Bits(bArr, i2) ^ this.gSubKeys[4];
        int BytesTo32Bits2 = BytesTo32Bits(bArr, i2 + 4) ^ this.gSubKeys[5];
        int BytesTo32Bits3 = BytesTo32Bits(bArr, i2 + 8) ^ this.gSubKeys[6];
        int BytesTo32Bits4 = BytesTo32Bits(bArr, i2 + 12) ^ this.gSubKeys[7];
        int i4 = 39;
        for (int i5 = 0; i5 < 16; i5 += 2) {
            int Fe32_0 = Fe32_0(BytesTo32Bits);
            int Fe32_3 = Fe32_3(BytesTo32Bits2);
            int[] iArr = this.gSubKeys;
            int i6 = i4 - 1;
            int i7 = BytesTo32Bits4 ^ (((Fe32_3 * 2) + Fe32_0) + iArr[i4]);
            int i8 = i6 - 1;
            BytesTo32Bits3 = ((BytesTo32Bits3 >>> 31) | (BytesTo32Bits3 << 1)) ^ ((Fe32_0 + Fe32_3) + iArr[i6]);
            BytesTo32Bits4 = (i7 << 31) | (i7 >>> 1);
            int Fe32_02 = Fe32_0(BytesTo32Bits3);
            int Fe32_32 = Fe32_3(BytesTo32Bits4);
            int[] iArr2 = this.gSubKeys;
            int i9 = i8 - 1;
            int i10 = BytesTo32Bits2 ^ (((Fe32_32 * 2) + Fe32_02) + iArr2[i8]);
            i4 = i9 - 1;
            BytesTo32Bits = ((BytesTo32Bits >>> 31) | (BytesTo32Bits << 1)) ^ ((Fe32_02 + Fe32_32) + iArr2[i9]);
            BytesTo32Bits2 = (i10 << 31) | (i10 >>> 1);
        }
        Bits32ToBytes(this.gSubKeys[0] ^ BytesTo32Bits3, bArr2, i3);
        Bits32ToBytes(BytesTo32Bits4 ^ this.gSubKeys[1], bArr2, i3 + 4);
        Bits32ToBytes(this.gSubKeys[2] ^ BytesTo32Bits, bArr2, i3 + 8);
        Bits32ToBytes(this.gSubKeys[3] ^ BytesTo32Bits2, bArr2, i3 + 12);
    }

    private void encryptBlock(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = 0;
        int BytesTo32Bits = BytesTo32Bits(bArr, i2) ^ this.gSubKeys[0];
        int BytesTo32Bits2 = BytesTo32Bits(bArr, i2 + 4) ^ this.gSubKeys[1];
        int BytesTo32Bits3 = BytesTo32Bits(bArr, i2 + 8) ^ this.gSubKeys[2];
        int BytesTo32Bits4 = BytesTo32Bits(bArr, i2 + 12) ^ this.gSubKeys[3];
        int i5 = 8;
        while (i4 < 16) {
            int Fe32_0 = Fe32_0(BytesTo32Bits);
            int Fe32_3 = Fe32_3(BytesTo32Bits2);
            int[] iArr = this.gSubKeys;
            int i6 = i5 + 1;
            int i7 = BytesTo32Bits3 ^ ((Fe32_0 + Fe32_3) + iArr[i5]);
            BytesTo32Bits3 = (i7 >>> 1) | (i7 << 31);
            int i8 = (BytesTo32Bits4 >>> 31) | (BytesTo32Bits4 << 1);
            int i9 = i6 + 1;
            BytesTo32Bits4 = i8 ^ ((Fe32_0 + (Fe32_3 * 2)) + iArr[i6]);
            int Fe32_02 = Fe32_0(BytesTo32Bits3);
            int Fe32_32 = Fe32_3(BytesTo32Bits4);
            int[] iArr2 = this.gSubKeys;
            int i10 = i9 + 1;
            int i11 = BytesTo32Bits ^ ((Fe32_02 + Fe32_32) + iArr2[i9]);
            BytesTo32Bits = (i11 >>> 1) | (i11 << 31);
            i4 += 2;
            BytesTo32Bits2 = ((BytesTo32Bits2 << 1) | (BytesTo32Bits2 >>> 31)) ^ ((Fe32_02 + (Fe32_32 * 2)) + iArr2[i10]);
            i5 = i10 + 1;
        }
        Bits32ToBytes(this.gSubKeys[4] ^ BytesTo32Bits3, bArr2, i3);
        Bits32ToBytes(BytesTo32Bits4 ^ this.gSubKeys[5], bArr2, i3 + 4);
        Bits32ToBytes(this.gSubKeys[6] ^ BytesTo32Bits, bArr2, i3 + 8);
        Bits32ToBytes(this.gSubKeys[7] ^ BytesTo32Bits2, bArr2, i3 + 12);
    }

    private void setKey(byte[] bArr) {
        int b0;
        int b1;
        int b2;
        int b3;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        this.gSubKeys = new int[40];
        int i6 = this.k64Cnt;
        if (i6 < 1) {
            throw new IllegalArgumentException("Key size less than 64 bits");
        }
        if (i6 <= 4) {
            for (int i7 = 0; i7 < this.k64Cnt; i7++) {
                int i8 = i7 * 8;
                iArr[i7] = BytesTo32Bits(bArr, i8);
                iArr2[i7] = BytesTo32Bits(bArr, i8 + 4);
                iArr3[(this.k64Cnt - 1) - i7] = RS_MDS_Encode(iArr[i7], iArr2[i7]);
            }
            for (int i9 = 0; i9 < 20; i9++) {
                int i10 = SK_STEP * i9;
                int F32 = F32(i10, iArr);
                int F322 = F32(i10 + SK_BUMP, iArr2);
                int i11 = (F322 >>> 24) | (F322 << 8);
                int i12 = F32 + i11;
                int[] iArr4 = this.gSubKeys;
                int i13 = i9 * 2;
                iArr4[i13] = i12;
                int i14 = i12 + i11;
                iArr4[i13 + 1] = (i14 << 9) | (i14 >>> 23);
            }
            int i15 = iArr3[0];
            int i16 = iArr3[1];
            int i17 = 2;
            int i18 = iArr3[2];
            int i19 = iArr3[3];
            this.gSBox = new int[1024];
            int i20 = 0;
            while (i20 < 256) {
                int i21 = this.k64Cnt & 3;
                if (i21 != 0) {
                    if (i21 == 1) {
                        int[] iArr5 = this.gSBox;
                        int i22 = i20 * 2;
                        int[] iArr6 = this.gMDS0;
                        byte[][] bArr2 = P;
                        iArr5[i22] = iArr6[(bArr2[0][i20] & 255) ^ b0(i15)];
                        this.gSBox[i22 + 1] = this.gMDS1[(bArr2[0][i20] & 255) ^ b1(i15)];
                        this.gSBox[i22 + 512] = this.gMDS2[(bArr2[1][i20] & 255) ^ b2(i15)];
                        this.gSBox[i22 + 513] = this.gMDS3[(bArr2[1][i20] & 255) ^ b3(i15)];
                    } else if (i21 == i17) {
                        i5 = i20;
                        i4 = i5;
                        i3 = i4;
                        i2 = i3;
                        int[] iArr7 = this.gSBox;
                        int i23 = i20 * 2;
                        int[] iArr8 = this.gMDS0;
                        byte[][] bArr3 = P;
                        iArr7[i23] = iArr8[(bArr3[0][(bArr3[0][i4] & 255) ^ b0(i16)] & 255) ^ b0(i15)];
                        this.gSBox[i23 + 1] = this.gMDS1[(bArr3[0][(bArr3[1][i3] & 255) ^ b1(i16)] & 255) ^ b1(i15)];
                        this.gSBox[i23 + 512] = this.gMDS2[(bArr3[1][(bArr3[0][i2] & 255) ^ b2(i16)] & 255) ^ b2(i15)];
                        this.gSBox[i23 + 513] = this.gMDS3[(bArr3[1][(bArr3[1][i5] & 255) ^ b3(i16)] & 255) ^ b3(i15)];
                    } else if (i21 == 3) {
                        b3 = i20;
                        b0 = b3;
                        b1 = b0;
                        b2 = b1;
                    }
                    i20++;
                    i17 = 2;
                } else {
                    byte[][] bArr4 = P;
                    b0 = (bArr4[1][i20] & 255) ^ b0(i19);
                    b1 = (bArr4[0][i20] & 255) ^ b1(i19);
                    b2 = (bArr4[0][i20] & 255) ^ b2(i19);
                    b3 = (bArr4[1][i20] & 255) ^ b3(i19);
                }
                byte[][] bArr5 = P;
                i4 = (bArr5[1][b0] & 255) ^ b0(i18);
                i3 = (bArr5[1][b1] & 255) ^ b1(i18);
                i2 = (bArr5[0][b2] & 255) ^ b2(i18);
                i5 = (bArr5[0][b3] & 255) ^ b3(i18);
                int[] iArr72 = this.gSBox;
                int i232 = i20 * 2;
                int[] iArr82 = this.gMDS0;
                byte[][] bArr32 = P;
                iArr72[i232] = iArr82[(bArr32[0][(bArr32[0][i4] & 255) ^ b0(i16)] & 255) ^ b0(i15)];
                this.gSBox[i232 + 1] = this.gMDS1[(bArr32[0][(bArr32[1][i3] & 255) ^ b1(i16)] & 255) ^ b1(i15)];
                this.gSBox[i232 + 512] = this.gMDS2[(bArr32[1][(bArr32[0][i2] & 255) ^ b2(i16)] & 255) ^ b2(i15)];
                this.gSBox[i232 + 513] = this.gMDS3[(bArr32[1][(bArr32[1][i5] & 255) ^ b3(i16)] & 255) ^ b3(i15)];
                i20++;
                i17 = 2;
            }
            return;
        }
        throw new IllegalArgumentException("Key size larger than 256 bits");
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Twofish";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.encrypting = z;
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            this.workingKey = key;
            this.k64Cnt = key.length / 8;
            setKey(key);
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to Twofish init - " + cipherParameters.getClass().getName());
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i2, byte[] bArr2, int i3) {
        if (this.workingKey != null) {
            if (i2 + 16 <= bArr.length) {
                if (i3 + 16 <= bArr2.length) {
                    if (this.encrypting) {
                        encryptBlock(bArr, i2, bArr2, i3);
                        return 16;
                    }
                    decryptBlock(bArr, i2, bArr2, i3);
                    return 16;
                }
                throw new OutputLengthException("output buffer too short");
            }
            throw new DataLengthException("input buffer too short");
        }
        throw new IllegalStateException("Twofish not initialised");
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
        byte[] bArr = this.workingKey;
        if (bArr != null) {
            setKey(bArr);
        }
    }
}