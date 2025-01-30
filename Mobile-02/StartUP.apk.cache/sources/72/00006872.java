package org.spongycastle.math.raw;

import java.math.BigInteger;
import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public abstract class Nat320 {
    public static void copy64(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
    }

    public static long[] create64() {
        return new long[5];
    }

    public static long[] createExt64() {
        return new long[10];
    }

    public static boolean eq64(long[] jArr, long[] jArr2) {
        for (int i2 = 4; i2 >= 0; i2--) {
            if (jArr[i2] != jArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static long[] fromBigInteger64(BigInteger bigInteger) {
        if (bigInteger.signum() >= 0 && bigInteger.bitLength() <= 320) {
            long[] create64 = create64();
            int i2 = 0;
            while (bigInteger.signum() != 0) {
                create64[i2] = bigInteger.longValue();
                bigInteger = bigInteger.shiftRight(64);
                i2++;
            }
            return create64;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isOne64(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            if (jArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero64(long[] jArr) {
        for (int i2 = 0; i2 < 5; i2++) {
            if (jArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static BigInteger toBigInteger64(long[] jArr) {
        byte[] bArr = new byte[40];
        for (int i2 = 0; i2 < 5; i2++) {
            long j2 = jArr[i2];
            if (j2 != 0) {
                Pack.longToBigEndian(j2, bArr, (4 - i2) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }
}