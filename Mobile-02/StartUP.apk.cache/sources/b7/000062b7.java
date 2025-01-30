package org.spongycastle.crypto.params;

/* loaded from: classes3.dex */
public class RC2Parameters extends KeyParameter {
    private int bits;

    public RC2Parameters(byte[] bArr) {
        this(bArr, bArr.length > 128 ? 1024 : bArr.length * 8);
    }

    public int getEffectiveKeyBits() {
        return this.bits;
    }

    public RC2Parameters(byte[] bArr, int i2) {
        super(bArr);
        this.bits = i2;
    }
}