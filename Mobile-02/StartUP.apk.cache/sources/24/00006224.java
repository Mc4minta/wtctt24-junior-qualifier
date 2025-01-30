package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.math.ec.WNafUtil;
import org.spongycastle.util.BigIntegers;

/* loaded from: classes3.dex */
class DHParametersHelper {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    DHParametersHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger[] generateSafePrimes(int i2, int i3, SecureRandom secureRandom) {
        int i4 = i2 - 1;
        int i5 = i2 >>> 2;
        while (true) {
            BigInteger bigInteger = new BigInteger(i4, 2, secureRandom);
            BigInteger add = bigInteger.shiftLeft(1).add(ONE);
            if (add.isProbablePrime(i3) && (i3 <= 2 || bigInteger.isProbablePrime(i3 - 2))) {
                if (WNafUtil.getNafWeight(add) >= i5) {
                    return new BigInteger[]{add, bigInteger};
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger selectGenerator(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger modPow;
        BigInteger subtract = bigInteger.subtract(TWO);
        do {
            BigInteger bigInteger3 = TWO;
            modPow = BigIntegers.createRandomInRange(bigInteger3, subtract, secureRandom).modPow(bigInteger3, bigInteger);
        } while (modPow.equals(ONE));
        return modPow;
    }
}