package org.spongycastle.pqc.math.ntru.util;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class ArrayEncoder {
    private static final int[] COEFF1_TABLE = {0, 0, 0, 1, 1, 1, -1, -1};
    private static final int[] COEFF2_TABLE = {0, 1, -1, 0, 1, -1, 0, 1};
    private static final int[] BIT1_TABLE = {1, 1, 1, 0, 0, 0, 1, 0, 1};
    private static final int[] BIT2_TABLE = {1, 1, 1, 1, 0, 0, 0, 1, 0};
    private static final int[] BIT3_TABLE = {1, 0, 1, 0, 0, 1, 1, 1, 0};

    public static int[] decodeMod3Sves(byte[] bArr, int i2) {
        int[] iArr = new int[i2];
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length * 8) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int bit = (getBit(bArr, i3) * 4) + (getBit(bArr, i5) * 2) + getBit(bArr, i6);
            int i8 = i4 + 1;
            iArr[i4] = COEFF1_TABLE[bit];
            i4 = i8 + 1;
            iArr[i8] = COEFF2_TABLE[bit];
            if (i4 > i2 - 2) {
                break;
            }
            i3 = i7;
        }
        return iArr;
    }

    public static int[] decodeMod3Tight(byte[] bArr, int i2) {
        BigInteger bigInteger = new BigInteger(1, bArr);
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = bigInteger.mod(BigInteger.valueOf(3L)).intValue() - 1;
            if (iArr[i3] > 1) {
                iArr[i3] = iArr[i3] - 3;
            }
            bigInteger = bigInteger.divide(BigInteger.valueOf(3L));
        }
        return iArr;
    }

    public static int[] decodeModQ(byte[] bArr, int i2, int i3) {
        int[] iArr = new int[i2];
        int numberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(i3);
        int i4 = i2 * numberOfLeadingZeros;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            if (i6 > 0 && i6 % numberOfLeadingZeros == 0) {
                i5++;
            }
            iArr[i5] = iArr[i5] + (getBit(bArr, i6) << (i6 % numberOfLeadingZeros));
        }
        return iArr;
    }

    public static byte[] encodeMod3Sves(int[] iArr) {
        byte[] bArr = new byte[((((iArr.length * 3) + 1) / 2) + 7) / 8];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < (iArr.length / 2) * 2) {
            int i5 = i2 + 1;
            int i6 = iArr[i2] + 1;
            int i7 = i5 + 1;
            int i8 = iArr[i5] + 1;
            if (i6 == 0 && i8 == 0) {
                throw new IllegalStateException("Illegal encoding!");
            }
            int i9 = (i6 * 3) + i8;
            int[] iArr2 = {BIT1_TABLE[i9], BIT2_TABLE[i9], BIT3_TABLE[i9]};
            for (int i10 = 0; i10 < 3; i10++) {
                bArr[i4] = (byte) (bArr[i4] | (iArr2[i10] << i3));
                if (i3 == 7) {
                    i4++;
                    i3 = 0;
                } else {
                    i3++;
                }
            }
            i2 = i7;
        }
        return bArr;
    }

    public static byte[] encodeMod3Tight(int[] iArr) {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int length = iArr.length - 1; length >= 0; length--) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(3L)).add(BigInteger.valueOf(iArr[length] + 1));
        }
        int bitLength = (BigInteger.valueOf(3L).pow(iArr.length).bitLength() + 7) / 8;
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length >= bitLength) {
            return byteArray.length > bitLength ? Arrays.copyOfRange(byteArray, 1, byteArray.length) : byteArray;
        }
        byte[] bArr = new byte[bitLength];
        System.arraycopy(byteArray, 0, bArr, bitLength - byteArray.length, byteArray.length);
        return bArr;
    }

    public static byte[] encodeModQ(int[] iArr, int i2) {
        int numberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(i2);
        byte[] bArr = new byte[((iArr.length * numberOfLeadingZeros) + 7) / 8];
        int i3 = 0;
        int i4 = 0;
        for (int i5 : iArr) {
            for (int i6 = 0; i6 < numberOfLeadingZeros; i6++) {
                bArr[i4] = (byte) ((((i5 >> i6) & 1) << i3) | bArr[i4]);
                if (i3 == 7) {
                    i4++;
                    i3 = 0;
                } else {
                    i3++;
                }
            }
        }
        return bArr;
    }

    private static int getBit(byte[] bArr, int i2) {
        return ((bArr[i2 / 8] & 255) >> (i2 % 8)) & 1;
    }

    public static int[] decodeModQ(InputStream inputStream, int i2, int i3) throws IOException {
        return decodeModQ(Util.readFullLength(inputStream, (((31 - Integer.numberOfLeadingZeros(i3)) * i2) + 7) / 8), i2, i3);
    }

    public static int[] decodeMod3Tight(InputStream inputStream, int i2) throws IOException {
        return decodeMod3Tight(Util.readFullLength(inputStream, (int) Math.ceil(((i2 * Math.log(3.0d)) / Math.log(2.0d)) / 8.0d)), i2);
    }
}