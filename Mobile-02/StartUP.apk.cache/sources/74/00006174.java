package org.spongycastle.crypto.agreement.jpake;

import java.math.BigInteger;

/* loaded from: classes3.dex */
public class JPAKEPrimeOrderGroup {

    /* renamed from: g  reason: collision with root package name */
    private final BigInteger f17787g;
    private final BigInteger p;
    private final BigInteger q;

    public JPAKEPrimeOrderGroup(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, false);
    }

    public BigInteger getG() {
        return this.f17787g;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getQ() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JPAKEPrimeOrderGroup(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, boolean z) {
        JPAKEUtil.validateNotNull(bigInteger, "p");
        JPAKEUtil.validateNotNull(bigInteger2, "q");
        JPAKEUtil.validateNotNull(bigInteger3, "g");
        if (!z) {
            BigInteger bigInteger4 = JPAKEUtil.ONE;
            if (bigInteger.subtract(bigInteger4).mod(bigInteger2).equals(JPAKEUtil.ZERO)) {
                if (bigInteger3.compareTo(BigInteger.valueOf(2L)) != -1 && bigInteger3.compareTo(bigInteger.subtract(bigInteger4)) != 1) {
                    if (bigInteger3.modPow(bigInteger2, bigInteger).equals(bigInteger4)) {
                        if (bigInteger.isProbablePrime(20)) {
                            if (!bigInteger2.isProbablePrime(20)) {
                                throw new IllegalArgumentException("q must be prime");
                            }
                        } else {
                            throw new IllegalArgumentException("p must be prime");
                        }
                    } else {
                        throw new IllegalArgumentException("g^q mod p must equal 1");
                    }
                } else {
                    throw new IllegalArgumentException("g must be in [2, p-1]");
                }
            } else {
                throw new IllegalArgumentException("p-1 must be evenly divisible by q");
            }
        }
        this.p = bigInteger;
        this.q = bigInteger2;
        this.f17787g = bigInteger3;
    }
}