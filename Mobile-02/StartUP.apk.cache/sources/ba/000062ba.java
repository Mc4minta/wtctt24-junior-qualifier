package org.spongycastle.crypto.params;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;

/* loaded from: classes3.dex */
public class RSAKeyGenerationParameters extends KeyGenerationParameters {
    private int certainty;
    private BigInteger publicExponent;

    public RSAKeyGenerationParameters(BigInteger bigInteger, SecureRandom secureRandom, int i2, int i3) {
        super(secureRandom, i2);
        if (i2 >= 12) {
            if (bigInteger.testBit(0)) {
                this.publicExponent = bigInteger;
                this.certainty = i3;
                return;
            }
            throw new IllegalArgumentException("public exponent cannot be even");
        }
        throw new IllegalArgumentException("key strength too small");
    }

    public int getCertainty() {
        return this.certainty;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }
}