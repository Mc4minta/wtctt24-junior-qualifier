package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.RSAKeyGenerationParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.spongycastle.math.Primes;
import org.spongycastle.math.ec.WNafUtil;

/* loaded from: classes3.dex */
public class RSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private int iterations;
    private RSAKeyGenerationParameters param;

    private static int getNumberOfIterations(int i2, int i3) {
        if (i2 >= 1536) {
            if (i3 <= 100) {
                return 3;
            }
            if (i3 <= 128) {
                return 4;
            }
            return 4 + (((i3 - 128) + 1) / 2);
        } else if (i2 >= 1024) {
            if (i3 <= 100) {
                return 4;
            }
            if (i3 <= 112) {
                return 5;
            }
            return (((i3 - 112) + 1) / 2) + 5;
        } else if (i2 < 512) {
            if (i3 <= 80) {
                return 40;
            }
            return 40 + (((i3 - 80) + 1) / 2);
        } else if (i3 <= 80) {
            return 5;
        } else {
            if (i3 <= 100) {
                return 7;
            }
            return (((i3 - 100) + 1) / 2) + 7;
        }
    }

    protected BigInteger chooseRandomPrime(int i2, BigInteger bigInteger, BigInteger bigInteger2) {
        for (int i3 = 0; i3 != i2 * 5; i3++) {
            BigInteger bigInteger3 = new BigInteger(i2, 1, this.param.getRandom());
            BigInteger mod = bigInteger3.mod(bigInteger);
            BigInteger bigInteger4 = ONE;
            if (!mod.equals(bigInteger4) && bigInteger3.multiply(bigInteger3).compareTo(bigInteger2) >= 0 && isProbablePrime(bigInteger3) && bigInteger.gcd(bigInteger3.subtract(bigInteger4)).equals(bigInteger4)) {
                return bigInteger3;
            }
        }
        throw new IllegalStateException("unable to generate prime number for RSA key");
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger chooseRandomPrime;
        BigInteger multiply;
        BigInteger bigInteger;
        RSAKeyPairGenerator rSAKeyPairGenerator = this;
        int strength = rSAKeyPairGenerator.param.getStrength();
        int i2 = (strength + 1) / 2;
        int i3 = strength - i2;
        int i4 = strength / 2;
        int i5 = i4 - 100;
        int i6 = strength / 3;
        if (i5 < i6) {
            i5 = i6;
        }
        int i7 = strength >> 2;
        BigInteger pow = BigInteger.valueOf(2L).pow(i4);
        BigInteger bigInteger2 = ONE;
        BigInteger shiftLeft = bigInteger2.shiftLeft(strength - 1);
        BigInteger shiftLeft2 = bigInteger2.shiftLeft(i5);
        AsymmetricCipherKeyPair asymmetricCipherKeyPair = null;
        boolean z = false;
        while (!z) {
            BigInteger publicExponent = rSAKeyPairGenerator.param.getPublicExponent();
            BigInteger chooseRandomPrime2 = rSAKeyPairGenerator.chooseRandomPrime(i2, publicExponent, shiftLeft);
            while (true) {
                chooseRandomPrime = rSAKeyPairGenerator.chooseRandomPrime(i3, publicExponent, shiftLeft);
                BigInteger abs = chooseRandomPrime.subtract(chooseRandomPrime2).abs();
                if (abs.bitLength() >= i5 && abs.compareTo(shiftLeft2) > 0) {
                    multiply = chooseRandomPrime2.multiply(chooseRandomPrime);
                    if (multiply.bitLength() != strength) {
                        chooseRandomPrime2 = chooseRandomPrime2.max(chooseRandomPrime);
                    } else if (WNafUtil.getNafWeight(multiply) >= i7) {
                        break;
                    } else {
                        chooseRandomPrime2 = rSAKeyPairGenerator.chooseRandomPrime(i2, publicExponent, shiftLeft);
                    }
                } else {
                    rSAKeyPairGenerator = this;
                    strength = strength;
                }
            }
            if (chooseRandomPrime2.compareTo(chooseRandomPrime) < 0) {
                bigInteger = chooseRandomPrime2;
                chooseRandomPrime2 = chooseRandomPrime;
            } else {
                bigInteger = chooseRandomPrime;
            }
            BigInteger bigInteger3 = ONE;
            BigInteger subtract = chooseRandomPrime2.subtract(bigInteger3);
            BigInteger subtract2 = bigInteger.subtract(bigInteger3);
            int i8 = strength;
            BigInteger modInverse = publicExponent.modInverse(subtract.divide(subtract.gcd(subtract2)).multiply(subtract2));
            if (modInverse.compareTo(pow) <= 0) {
                rSAKeyPairGenerator = this;
                strength = i8;
            } else {
                asymmetricCipherKeyPair = new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new RSAKeyParameters(false, multiply, publicExponent), (AsymmetricKeyParameter) new RSAPrivateCrtKeyParameters(multiply, publicExponent, modInverse, chooseRandomPrime2, bigInteger, modInverse.remainder(subtract), modInverse.remainder(subtract2), bigInteger.modInverse(chooseRandomPrime2)));
                z = true;
                strength = i8;
                rSAKeyPairGenerator = this;
            }
        }
        return asymmetricCipherKeyPair;
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        RSAKeyGenerationParameters rSAKeyGenerationParameters = (RSAKeyGenerationParameters) keyGenerationParameters;
        this.param = rSAKeyGenerationParameters;
        this.iterations = getNumberOfIterations(rSAKeyGenerationParameters.getStrength(), this.param.getCertainty());
    }

    protected boolean isProbablePrime(BigInteger bigInteger) {
        return !Primes.hasAnySmallFactors(bigInteger) && Primes.isMRProbablePrime(bigInteger, this.param.getRandom(), this.iterations);
    }
}