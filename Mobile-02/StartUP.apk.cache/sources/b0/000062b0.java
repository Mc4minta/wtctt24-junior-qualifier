package org.spongycastle.crypto.params;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;

/* loaded from: classes3.dex */
public class NaccacheSternKeyGenerationParameters extends KeyGenerationParameters {
    private int certainty;
    private int cntSmallPrimes;
    private boolean debug;

    public NaccacheSternKeyGenerationParameters(SecureRandom secureRandom, int i2, int i3, int i4) {
        this(secureRandom, i2, i3, i4, false);
    }

    public int getCertainty() {
        return this.certainty;
    }

    public int getCntSmallPrimes() {
        return this.cntSmallPrimes;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public NaccacheSternKeyGenerationParameters(SecureRandom secureRandom, int i2, int i3, int i4, boolean z) {
        super(secureRandom, i2);
        this.debug = false;
        this.certainty = i3;
        if (i4 % 2 == 1) {
            throw new IllegalArgumentException("cntSmallPrimes must be a multiple of 2");
        }
        if (i4 >= 30) {
            this.cntSmallPrimes = i4;
            this.debug = z;
            return;
        }
        throw new IllegalArgumentException("cntSmallPrimes must be >= 30 for security reasons");
    }
}