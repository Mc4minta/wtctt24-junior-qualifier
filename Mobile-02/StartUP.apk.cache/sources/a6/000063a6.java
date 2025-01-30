package org.spongycastle.crypto.util;

/* loaded from: classes3.dex */
public abstract class Pack {
    public static int bigEndianToInt(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        return (bArr[i4 + 1] & 255) | (bArr[i2] << 24) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 8);
    }

    public static long bigEndianToLong(byte[] bArr, int i2) {
        int bigEndianToInt = bigEndianToInt(bArr, i2);
        return (bigEndianToInt(bArr, i2 + 4) & 4294967295L) | ((bigEndianToInt & 4294967295L) << 32);
    }

    public static byte[] intToBigEndian(int i2) {
        byte[] bArr = new byte[4];
        intToBigEndian(i2, bArr, 0);
        return bArr;
    }

    public static byte[] intToLittleEndian(int i2) {
        byte[] bArr = new byte[4];
        intToLittleEndian(i2, bArr, 0);
        return bArr;
    }

    public static int littleEndianToInt(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        return (bArr[i4 + 1] << 24) | (bArr[i2] & 255) | ((bArr[i3] & 255) << 8) | ((bArr[i4] & 255) << 16);
    }

    public static long littleEndianToLong(byte[] bArr, int i2) {
        return ((littleEndianToInt(bArr, i2 + 4) & 4294967295L) << 32) | (littleEndianToInt(bArr, i2) & 4294967295L);
    }

    public static byte[] longToBigEndian(long j2) {
        byte[] bArr = new byte[8];
        longToBigEndian(j2, bArr, 0);
        return bArr;
    }

    public static byte[] longToLittleEndian(long j2) {
        byte[] bArr = new byte[8];
        longToLittleEndian(j2, bArr, 0);
        return bArr;
    }

    public static void intToBigEndian(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) (i2 >>> 24);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i2 >>> 16);
        int i5 = i4 + 1;
        bArr[i5] = (byte) (i2 >>> 8);
        bArr[i5 + 1] = (byte) i2;
    }

    public static void intToLittleEndian(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) i2;
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        int i5 = i4 + 1;
        bArr[i5] = (byte) (i2 >>> 16);
        bArr[i5 + 1] = (byte) (i2 >>> 24);
    }

    public static void longToBigEndian(long j2, byte[] bArr, int i2) {
        intToBigEndian((int) (j2 >>> 32), bArr, i2);
        intToBigEndian((int) (j2 & 4294967295L), bArr, i2 + 4);
    }

    public static void longToLittleEndian(long j2, byte[] bArr, int i2) {
        intToLittleEndian((int) (4294967295L & j2), bArr, i2);
        intToLittleEndian((int) (j2 >>> 32), bArr, i2 + 4);
    }

    public static void bigEndianToLong(byte[] bArr, int i2, long[] jArr) {
        for (int i3 = 0; i3 < jArr.length; i3++) {
            jArr[i3] = bigEndianToLong(bArr, i2);
            i2 += 8;
        }
    }

    public static void littleEndianToLong(byte[] bArr, int i2, long[] jArr) {
        for (int i3 = 0; i3 < jArr.length; i3++) {
            jArr[i3] = littleEndianToLong(bArr, i2);
            i2 += 8;
        }
    }

    public static byte[] longToBigEndian(long[] jArr) {
        byte[] bArr = new byte[jArr.length * 8];
        longToBigEndian(jArr, bArr, 0);
        return bArr;
    }

    public static byte[] longToLittleEndian(long[] jArr) {
        byte[] bArr = new byte[jArr.length * 8];
        longToLittleEndian(jArr, bArr, 0);
        return bArr;
    }

    public static void bigEndianToInt(byte[] bArr, int i2, int[] iArr) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr[i3] = bigEndianToInt(bArr, i2);
            i2 += 4;
        }
    }

    public static void littleEndianToInt(byte[] bArr, int i2, int[] iArr) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr[i3] = littleEndianToInt(bArr, i2);
            i2 += 4;
        }
    }

    public static byte[] intToBigEndian(int[] iArr) {
        byte[] bArr = new byte[iArr.length * 4];
        intToBigEndian(iArr, bArr, 0);
        return bArr;
    }

    public static byte[] intToLittleEndian(int[] iArr) {
        byte[] bArr = new byte[iArr.length * 4];
        intToLittleEndian(iArr, bArr, 0);
        return bArr;
    }

    public static void longToBigEndian(long[] jArr, byte[] bArr, int i2) {
        for (long j2 : jArr) {
            longToBigEndian(j2, bArr, i2);
            i2 += 8;
        }
    }

    public static void longToLittleEndian(long[] jArr, byte[] bArr, int i2) {
        for (long j2 : jArr) {
            longToLittleEndian(j2, bArr, i2);
            i2 += 8;
        }
    }

    public static void littleEndianToInt(byte[] bArr, int i2, int[] iArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            iArr[i3 + i5] = littleEndianToInt(bArr, i2);
            i2 += 4;
        }
    }

    public static void intToBigEndian(int[] iArr, byte[] bArr, int i2) {
        for (int i3 : iArr) {
            intToBigEndian(i3, bArr, i2);
            i2 += 4;
        }
    }

    public static void intToLittleEndian(int[] iArr, byte[] bArr, int i2) {
        for (int i3 : iArr) {
            intToLittleEndian(i3, bArr, i2);
            i2 += 4;
        }
    }
}