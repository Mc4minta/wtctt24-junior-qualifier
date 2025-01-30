package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.params.CramerShoupParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.util.BigIntegers;

/* loaded from: classes3.dex */
public class CramerShoupParametersGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private int certainty;
    private SecureRandom random;
    private int size;

    /* loaded from: classes3.dex */
    private static class ParametersHelper {
        private static final BigInteger TWO = BigInteger.valueOf(2);

        private ParametersHelper() {
        }

        static BigInteger[] generateSafePrimes(int i2, int i3, SecureRandom secureRandom) {
            BigInteger bigInteger;
            BigInteger add;
            int i4 = i2 - 1;
            while (true) {
                bigInteger = new BigInteger(i4, 2, secureRandom);
                add = bigInteger.shiftLeft(1).add(CramerShoupParametersGenerator.ONE);
                if (!add.isProbablePrime(i3) || (i3 > 2 && !bigInteger.isProbablePrime(i3))) {
                }
            }
            return new BigInteger[]{add, bigInteger};
        }

        static BigInteger selectGenerator(BigInteger bigInteger, SecureRandom secureRandom) {
            BigInteger modPow;
            BigInteger subtract = bigInteger.subtract(TWO);
            do {
                BigInteger bigInteger2 = TWO;
                modPow = BigIntegers.createRandomInRange(bigInteger2, subtract, secureRandom).modPow(bigInteger2, bigInteger);
            } while (modPow.equals(CramerShoupParametersGenerator.ONE));
            return modPow;
        }
    }

    public CramerShoupParameters generateParameters() {
        BigInteger bigInteger = ParametersHelper.generateSafePrimes(this.size, this.certainty, this.random)[1];
        BigInteger selectGenerator = ParametersHelper.selectGenerator(bigInteger, this.random);
        BigInteger selectGenerator2 = ParametersHelper.selectGenerator(bigInteger, this.random);
        while (selectGenerator.equals(selectGenerator2)) {
            selectGenerator2 = ParametersHelper.selectGenerator(bigInteger, this.random);
        }
        return new CramerShoupParameters(bigInteger, selectGenerator, selectGenerator2, new SHA256Digest());
    }

    public void init(int i2, int i3, SecureRandom secureRandom) {
        this.size = i2;
        this.certainty = i3;
        this.random = secureRandom;
    }

    public CramerShoupParameters generateParameters(DHParameters dHParameters) {
        BigInteger p = dHParameters.getP();
        BigInteger g2 = dHParameters.getG();
        BigInteger selectGenerator = ParametersHelper.selectGenerator(p, this.random);
        while (g2.equals(selectGenerator)) {
            selectGenerator = ParametersHelper.selectGenerator(p, this.random);
        }
        return new CramerShoupParameters(p, g2, selectGenerator, new SHA256Digest());
    }
}