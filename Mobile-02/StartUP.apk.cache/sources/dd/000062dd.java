package org.spongycastle.crypto.prng.drbg;

import org.spongycastle.math.ec.ECPoint;

/* loaded from: classes3.dex */
public class DualECPoints {
    private final int cofactor;
    private final ECPoint p;
    private final ECPoint q;
    private final int securityStrength;

    public DualECPoints(int i2, ECPoint eCPoint, ECPoint eCPoint2, int i3) {
        if (eCPoint.getCurve().equals(eCPoint2.getCurve())) {
            this.securityStrength = i2;
            this.p = eCPoint;
            this.q = eCPoint2;
            this.cofactor = i3;
            return;
        }
        throw new IllegalArgumentException("points need to be on the same curve");
    }

    private static int log2(int i2) {
        int i3 = 0;
        while (true) {
            i2 >>= 1;
            if (i2 == 0) {
                return i3;
            }
            i3++;
        }
    }

    public int getCofactor() {
        return this.cofactor;
    }

    public int getMaxOutlen() {
        return ((this.p.getCurve().getFieldSize() - (log2(this.cofactor) + 13)) / 8) * 8;
    }

    public ECPoint getP() {
        return this.p;
    }

    public ECPoint getQ() {
        return this.q;
    }

    public int getSecurityStrength() {
        return this.securityStrength;
    }

    public int getSeedLen() {
        return this.p.getCurve().getFieldSize();
    }
}