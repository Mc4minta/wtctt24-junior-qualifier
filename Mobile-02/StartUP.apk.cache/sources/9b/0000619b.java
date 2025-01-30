package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.Xof;

/* loaded from: classes3.dex */
public class SHAKEDigest extends KeccakDigest implements Xof {
    public SHAKEDigest() {
        this(128);
    }

    private static int checkBitLength(int i2) {
        if (i2 == 128 || i2 == 256) {
            return i2;
        }
        throw new IllegalArgumentException("'bitLength' " + i2 + " not supported for SHAKE");
    }

    @Override // org.spongycastle.crypto.digests.KeccakDigest, org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i2) {
        return doFinal(bArr, i2, getDigestSize());
    }

    @Override // org.spongycastle.crypto.digests.KeccakDigest, org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHAKE" + this.fixedOutputLength;
    }

    public SHAKEDigest(int i2) {
        super(checkBitLength(i2));
    }

    @Override // org.spongycastle.crypto.Xof
    public int doFinal(byte[] bArr, int i2, int i3) {
        absorb(new byte[]{15}, 0, 4L);
        squeeze(bArr, i2, i3 * 8);
        reset();
        return i3;
    }

    public SHAKEDigest(SHAKEDigest sHAKEDigest) {
        super(sHAKEDigest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.spongycastle.crypto.digests.KeccakDigest
    public int doFinal(byte[] bArr, int i2, byte b2, int i3) {
        return doFinal(bArr, i2, getDigestSize(), b2, i3);
    }

    protected int doFinal(byte[] bArr, int i2, int i3, byte b2, int i4) {
        if (i4 >= 0 && i4 <= 7) {
            int i5 = (b2 & ((1 << i4) - 1)) | (15 << i4);
            int i6 = i4 + 4;
            if (i6 >= 8) {
                byte[] bArr2 = this.oneByte;
                bArr2[0] = (byte) i5;
                absorb(bArr2, 0, 8L);
                i6 -= 8;
                i5 >>>= 8;
            }
            if (i6 > 0) {
                byte[] bArr3 = this.oneByte;
                bArr3[0] = (byte) i5;
                absorb(bArr3, 0, i6);
            }
            squeeze(bArr, i2, i3 * 8);
            reset();
            return i3;
        }
        throw new IllegalArgumentException("'partialBits' must be in the range [0,7]");
    }
}