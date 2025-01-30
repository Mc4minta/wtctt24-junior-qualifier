package org.spongycastle.pqc.crypto.gmss.util;

/* loaded from: classes3.dex */
public class GMSSUtil {
    public int bytesToIntLittleEndian(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    public byte[] concatenateArray(byte[][] bArr) {
        byte[] bArr2 = new byte[bArr.length * bArr[0].length];
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            System.arraycopy(bArr[i3], 0, bArr2, i2, bArr[i3].length);
            i2 += bArr[i3].length;
        }
        return bArr2;
    }

    public int getLog(int i2) {
        int i3 = 1;
        int i4 = 2;
        while (i4 < i2) {
            i4 <<= 1;
            i3++;
        }
        return i3;
    }

    public byte[] intToBytesLittleEndian(int i2) {
        return new byte[]{(byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)};
    }

    public void printArray(String str, byte[][] bArr) {
        System.out.println(str);
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                System.out.println(i2 + "; " + ((int) bArr[i3][i4]));
                i2++;
            }
        }
    }

    public boolean testPowerOfTwo(int i2) {
        int i3 = 1;
        while (i3 < i2) {
            i3 <<= 1;
        }
        return i2 == i3;
    }

    public int bytesToIntLittleEndian(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = (bArr[i2] & 255) | ((bArr[i3] & 255) << 8);
        return ((bArr[i4 + 1] & 255) << 24) | i5 | ((bArr[i4] & 255) << 16);
    }

    public void printArray(String str, byte[] bArr) {
        System.out.println(str);
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            System.out.println(i2 + "; " + ((int) bArr[i3]));
            i2++;
        }
    }
}