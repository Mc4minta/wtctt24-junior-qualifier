package org.spongycastle.crypto.params;

import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public final class KDFFeedbackParameters implements DerivationParameters {
    private static final int UNUSED_R = -1;
    private final byte[] fixedInputData;
    private final byte[] iv;
    private final byte[] ki;
    private final int r;
    private final boolean useCounter;

    private KDFFeedbackParameters(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, boolean z) {
        if (bArr != null) {
            this.ki = Arrays.clone(bArr);
            if (bArr3 == null) {
                this.fixedInputData = new byte[0];
            } else {
                this.fixedInputData = Arrays.clone(bArr3);
            }
            this.r = i2;
            if (bArr2 == null) {
                this.iv = new byte[0];
            } else {
                this.iv = Arrays.clone(bArr2);
            }
            this.useCounter = z;
            return;
        }
        throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
    }

    public static KDFFeedbackParameters createWithCounter(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2) {
        if (i2 != 8 && i2 != 16 && i2 != 24 && i2 != 32) {
            throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
        }
        return new KDFFeedbackParameters(bArr, bArr2, bArr3, i2, true);
    }

    public static KDFFeedbackParameters createWithoutCounter(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new KDFFeedbackParameters(bArr, bArr2, bArr3, -1, false);
    }

    public byte[] getFixedInputData() {
        return Arrays.clone(this.fixedInputData);
    }

    public byte[] getIV() {
        return this.iv;
    }

    public byte[] getKI() {
        return this.ki;
    }

    public int getR() {
        return this.r;
    }

    public boolean useCounter() {
        return this.useCounter;
    }
}