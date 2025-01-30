package org.spongycastle.math;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;

/* loaded from: classes3.dex */
public abstract class Primes {
    public static final int SMALL_FACTOR_LIMIT = 211;
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger THREE = BigInteger.valueOf(3);

    /* loaded from: classes3.dex */
    public static class MROutput {
        private BigInteger factor;
        private boolean provablyComposite;

        private MROutput(boolean z, BigInteger bigInteger) {
            this.provablyComposite = z;
            this.factor = bigInteger;
        }

        static /* synthetic */ MROutput access$000() {
            return probablyPrime();
        }

        static /* synthetic */ MROutput access$200() {
            return provablyCompositeNotPrimePower();
        }

        private static MROutput probablyPrime() {
            return new MROutput(false, null);
        }

        private static MROutput provablyCompositeNotPrimePower() {
            return new MROutput(true, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static MROutput provablyCompositeWithFactor(BigInteger bigInteger) {
            return new MROutput(true, bigInteger);
        }

        public BigInteger getFactor() {
            return this.factor;
        }

        public boolean isNotPrimePower() {
            return this.provablyComposite && this.factor == null;
        }

        public boolean isProvablyComposite() {
            return this.provablyComposite;
        }
    }

    /* loaded from: classes3.dex */
    public static class STOutput {
        private BigInteger prime;
        private int primeGenCounter;
        private byte[] primeSeed;

        public BigInteger getPrime() {
            return this.prime;
        }

        public int getPrimeGenCounter() {
            return this.primeGenCounter;
        }

        public byte[] getPrimeSeed() {
            return this.primeSeed;
        }

        private STOutput(BigInteger bigInteger, byte[] bArr, int i2) {
            this.prime = bigInteger;
            this.primeSeed = bArr;
            this.primeGenCounter = i2;
        }
    }

    private static void checkCandidate(BigInteger bigInteger, String str) {
        if (bigInteger == null || bigInteger.signum() < 1 || bigInteger.bitLength() < 2) {
            throw new IllegalArgumentException("'" + str + "' must be non-null and >= 2");
        }
    }

    public static MROutput enhancedMRProbablePrimeTest(BigInteger bigInteger, SecureRandom secureRandom, int i2) {
        boolean z;
        BigInteger bigInteger2;
        checkCandidate(bigInteger, "candidate");
        if (secureRandom != null) {
            if (i2 >= 1) {
                if (bigInteger.bitLength() == 2) {
                    return MROutput.access$000();
                }
                if (!bigInteger.testBit(0)) {
                    return MROutput.provablyCompositeWithFactor(TWO);
                }
                BigInteger subtract = bigInteger.subtract(ONE);
                BigInteger subtract2 = bigInteger.subtract(TWO);
                int lowestSetBit = subtract.getLowestSetBit();
                BigInteger shiftRight = subtract.shiftRight(lowestSetBit);
                for (int i3 = 0; i3 < i2; i3++) {
                    BigInteger createRandomInRange = BigIntegers.createRandomInRange(TWO, subtract2, secureRandom);
                    BigInteger gcd = createRandomInRange.gcd(bigInteger);
                    BigInteger bigInteger3 = ONE;
                    if (gcd.compareTo(bigInteger3) > 0) {
                        return MROutput.provablyCompositeWithFactor(gcd);
                    }
                    BigInteger modPow = createRandomInRange.modPow(shiftRight, bigInteger);
                    if (!modPow.equals(bigInteger3) && !modPow.equals(subtract)) {
                        int i4 = 1;
                        while (true) {
                            if (i4 >= lowestSetBit) {
                                z = false;
                                bigInteger2 = modPow;
                                break;
                            }
                            bigInteger2 = modPow.modPow(TWO, bigInteger);
                            if (bigInteger2.equals(subtract)) {
                                z = true;
                                break;
                            } else if (bigInteger2.equals(ONE)) {
                                z = false;
                                break;
                            } else {
                                i4++;
                                modPow = bigInteger2;
                            }
                        }
                        if (!z) {
                            BigInteger bigInteger4 = ONE;
                            if (!bigInteger2.equals(bigInteger4)) {
                                modPow = bigInteger2.modPow(TWO, bigInteger);
                                if (modPow.equals(bigInteger4)) {
                                    modPow = bigInteger2;
                                }
                            }
                            BigInteger gcd2 = modPow.subtract(bigInteger4).gcd(bigInteger);
                            if (gcd2.compareTo(bigInteger4) > 0) {
                                return MROutput.provablyCompositeWithFactor(gcd2);
                            }
                            return MROutput.access$200();
                        }
                    }
                }
                return MROutput.access$000();
            }
            throw new IllegalArgumentException("'iterations' must be > 0");
        }
        throw new IllegalArgumentException("'random' cannot be null");
    }

    private static int extract32(byte[] bArr) {
        int min = Math.min(4, bArr.length);
        int i2 = 0;
        int i3 = 0;
        while (i2 < min) {
            int i4 = i2 + 1;
            i3 |= (bArr[bArr.length - i4] & 255) << (i2 * 8);
            i2 = i4;
        }
        return i3;
    }

    public static STOutput generateSTRandomPrime(Digest digest, int i2, byte[] bArr) {
        if (digest != null) {
            if (i2 >= 2) {
                if (bArr != null && bArr.length != 0) {
                    return implSTRandomPrime(digest, i2, Arrays.clone(bArr));
                }
                throw new IllegalArgumentException("'inputSeed' cannot be null or empty");
            }
            throw new IllegalArgumentException("'length' must be >= 2");
        }
        throw new IllegalArgumentException("'hash' cannot be null");
    }

    public static boolean hasAnySmallFactors(BigInteger bigInteger) {
        checkCandidate(bigInteger, "candidate");
        return implHasAnySmallFactors(bigInteger);
    }

    private static void hash(Digest digest, byte[] bArr, byte[] bArr2, int i2) {
        digest.update(bArr, 0, bArr.length);
        digest.doFinal(bArr2, i2);
    }

    private static BigInteger hashGen(Digest digest, byte[] bArr, int i2) {
        int digestSize = digest.getDigestSize();
        int i3 = i2 * digestSize;
        byte[] bArr2 = new byte[i3];
        for (int i4 = 0; i4 < i2; i4++) {
            i3 -= digestSize;
            hash(digest, bArr, bArr2, i3);
            inc(bArr, 1);
        }
        return new BigInteger(1, bArr2);
    }

    private static boolean implHasAnySmallFactors(BigInteger bigInteger) {
        int intValue = bigInteger.mod(BigInteger.valueOf(223092870)).intValue();
        if (intValue % 2 != 0 && intValue % 3 != 0 && intValue % 5 != 0 && intValue % 7 != 0 && intValue % 11 != 0 && intValue % 13 != 0 && intValue % 17 != 0 && intValue % 19 != 0 && intValue % 23 != 0) {
            int intValue2 = bigInteger.mod(BigInteger.valueOf(58642669)).intValue();
            if (intValue2 % 29 != 0 && intValue2 % 31 != 0 && intValue2 % 37 != 0 && intValue2 % 41 != 0 && intValue2 % 43 != 0) {
                int intValue3 = bigInteger.mod(BigInteger.valueOf(600662303)).intValue();
                if (intValue3 % 47 != 0 && intValue3 % 53 != 0 && intValue3 % 59 != 0 && intValue3 % 61 != 0 && intValue3 % 67 != 0) {
                    int intValue4 = bigInteger.mod(BigInteger.valueOf(33984931)).intValue();
                    if (intValue4 % 71 != 0 && intValue4 % 73 != 0 && intValue4 % 79 != 0 && intValue4 % 83 != 0) {
                        int intValue5 = bigInteger.mod(BigInteger.valueOf(89809099)).intValue();
                        if (intValue5 % 89 != 0 && intValue5 % 97 != 0 && intValue5 % 101 != 0 && intValue5 % 103 != 0) {
                            int intValue6 = bigInteger.mod(BigInteger.valueOf(167375713)).intValue();
                            if (intValue6 % 107 != 0 && intValue6 % 109 != 0 && intValue6 % 113 != 0 && intValue6 % 127 != 0) {
                                int intValue7 = bigInteger.mod(BigInteger.valueOf(371700317)).intValue();
                                if (intValue7 % 131 != 0 && intValue7 % CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA != 0 && intValue7 % CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA != 0 && intValue7 % CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA != 0) {
                                    int intValue8 = bigInteger.mod(BigInteger.valueOf(645328247)).intValue();
                                    if (intValue8 % CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA != 0 && intValue8 % CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384 != 0 && intValue8 % CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 != 0 && intValue8 % CipherSuite.TLS_DH_anon_WITH_AES_256_GCM_SHA384 != 0) {
                                        int intValue9 = bigInteger.mod(BigInteger.valueOf(1070560157)).intValue();
                                        if (intValue9 % CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384 != 0 && intValue9 % CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384 != 0 && intValue9 % CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA384 != 0 && intValue9 % CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256 != 0) {
                                            int intValue10 = bigInteger.mod(BigInteger.valueOf(1596463769)).intValue();
                                            if (intValue10 % CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256 != 0 && intValue10 % CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256 != 0 && intValue10 % 199 != 0 && intValue10 % SMALL_FACTOR_LIMIT != 0) {
                                                return false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean implMRProbablePrimeToBase(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i2, BigInteger bigInteger4) {
        BigInteger modPow = bigInteger4.modPow(bigInteger3, bigInteger);
        if (modPow.equals(ONE) || modPow.equals(bigInteger2)) {
            return true;
        }
        for (int i3 = 1; i3 < i2; i3++) {
            modPow = modPow.modPow(TWO, bigInteger);
            if (modPow.equals(bigInteger2)) {
                return true;
            }
            if (modPow.equals(ONE)) {
                return false;
            }
        }
        return false;
    }

    private static STOutput implSTRandomPrime(Digest digest, int i2, byte[] bArr) {
        Object obj;
        int digestSize = digest.getDigestSize();
        Object obj2 = null;
        int i3 = 1;
        if (i2 < 33) {
            byte[] bArr2 = new byte[digestSize];
            byte[] bArr3 = new byte[digestSize];
            int i4 = 0;
            do {
                hash(digest, bArr, bArr2, 0);
                inc(bArr, 1);
                hash(digest, bArr, bArr3, 0);
                inc(bArr, 1);
                i4++;
                long extract32 = (((extract32(bArr2) ^ extract32(bArr3)) & ((-1) >>> (32 - i2))) | (1 << (i2 - 1)) | 1) & 4294967295L;
                if (isPrime32(extract32)) {
                    return new STOutput(BigInteger.valueOf(extract32), bArr, i4);
                }
            } while (i4 <= i2 * 4);
            throw new IllegalStateException("Too many iterations in Shawe-Taylor Random_Prime Routine");
        }
        STOutput implSTRandomPrime = implSTRandomPrime(digest, (i2 + 3) / 2, bArr);
        BigInteger prime = implSTRandomPrime.getPrime();
        byte[] primeSeed = implSTRandomPrime.getPrimeSeed();
        int primeGenCounter = implSTRandomPrime.getPrimeGenCounter();
        int i5 = i2 - 1;
        int i6 = (i5 / (digestSize * 8)) + 1;
        BigInteger hashGen = hashGen(digest, primeSeed, i6);
        BigInteger bigInteger = ONE;
        BigInteger bit = hashGen.mod(bigInteger.shiftLeft(i5)).setBit(i5);
        BigInteger shiftLeft = prime.shiftLeft(1);
        BigInteger shiftLeft2 = bit.subtract(bigInteger).divide(shiftLeft).add(bigInteger).shiftLeft(1);
        BigInteger add = shiftLeft2.multiply(prime).add(bigInteger);
        int i7 = primeGenCounter;
        int i8 = 0;
        while (true) {
            if (add.bitLength() > i2) {
                BigInteger bigInteger2 = ONE;
                shiftLeft2 = bigInteger2.shiftLeft(i5).subtract(bigInteger2).divide(shiftLeft).add(bigInteger2).shiftLeft(i3);
                add = shiftLeft2.multiply(prime).add(bigInteger2);
            }
            i7 += i3;
            if (!implHasAnySmallFactors(add)) {
                BigInteger add2 = hashGen(digest, primeSeed, i6).mod(add.subtract(THREE)).add(TWO);
                BigInteger add3 = shiftLeft2.add(BigInteger.valueOf(i8));
                BigInteger modPow = add2.modPow(add3, add);
                BigInteger bigInteger3 = ONE;
                if (add.gcd(modPow.subtract(bigInteger3)).equals(bigInteger3) && modPow.modPow(prime, add).equals(bigInteger3)) {
                    return new STOutput(add, primeSeed, i7);
                }
                obj = null;
                shiftLeft2 = add3;
                i8 = 0;
            } else {
                obj = obj2;
                inc(primeSeed, i6);
            }
            if (i7 < (i2 * 4) + primeGenCounter) {
                i8 += 2;
                add = add.add(shiftLeft);
                obj2 = obj;
                i3 = 1;
            } else {
                throw new IllegalStateException("Too many iterations in Shawe-Taylor Random_Prime Routine");
            }
        }
    }

    private static void inc(byte[] bArr, int i2) {
        int length = bArr.length;
        while (i2 > 0) {
            length--;
            if (length < 0) {
                return;
            }
            int i3 = i2 + (bArr[length] & 255);
            bArr[length] = (byte) i3;
            i2 = i3 >>> 8;
        }
    }

    public static boolean isMRProbablePrime(BigInteger bigInteger, SecureRandom secureRandom, int i2) {
        checkCandidate(bigInteger, "candidate");
        if (secureRandom != null) {
            if (i2 >= 1) {
                if (bigInteger.bitLength() == 2) {
                    return true;
                }
                if (bigInteger.testBit(0)) {
                    BigInteger subtract = bigInteger.subtract(ONE);
                    BigInteger subtract2 = bigInteger.subtract(TWO);
                    int lowestSetBit = subtract.getLowestSetBit();
                    BigInteger shiftRight = subtract.shiftRight(lowestSetBit);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if (!implMRProbablePrimeToBase(bigInteger, subtract, shiftRight, lowestSetBit, BigIntegers.createRandomInRange(TWO, subtract2, secureRandom))) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("'iterations' must be > 0");
        }
        throw new IllegalArgumentException("'random' cannot be null");
    }

    public static boolean isMRProbablePrimeToBase(BigInteger bigInteger, BigInteger bigInteger2) {
        checkCandidate(bigInteger, "candidate");
        checkCandidate(bigInteger2, "base");
        BigInteger bigInteger3 = ONE;
        if (bigInteger2.compareTo(bigInteger.subtract(bigInteger3)) < 0) {
            if (bigInteger.bitLength() == 2) {
                return true;
            }
            BigInteger subtract = bigInteger.subtract(bigInteger3);
            int lowestSetBit = subtract.getLowestSetBit();
            return implMRProbablePrimeToBase(bigInteger, subtract, subtract.shiftRight(lowestSetBit), lowestSetBit, bigInteger2);
        }
        throw new IllegalArgumentException("'base' must be < ('candidate' - 1)");
    }

    private static boolean isPrime32(long j2) {
        if ((j2 >>> 32) != 0) {
            throw new IllegalArgumentException("Size limit exceeded");
        }
        int i2 = (j2 > 5L ? 1 : (j2 == 5L ? 0 : -1));
        if (i2 <= 0) {
            return j2 == 2 || j2 == 3 || i2 == 0;
        } else if ((1 & j2) == 0 || j2 % 3 == 0 || j2 % 5 == 0) {
            return false;
        } else {
            long[] jArr = {1, 7, 11, 13, 17, 19, 23, 29};
            long j3 = 0;
            int i3 = 1;
            while (true) {
                if (i3 >= 8) {
                    j3 += 30;
                    if (j3 * j3 >= j2) {
                        return true;
                    }
                    i3 = 0;
                } else if (j2 % (jArr[i3] + j3) == 0) {
                    return j2 < 30;
                } else {
                    i3++;
                }
            }
        }
    }
}