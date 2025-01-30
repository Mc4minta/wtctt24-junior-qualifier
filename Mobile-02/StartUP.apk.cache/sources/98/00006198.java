package org.spongycastle.crypto.digests;

/* loaded from: classes3.dex */
public class SHA3Digest extends KeccakDigest {
    public SHA3Digest() {
        this(256);
    }

    private static int checkBitLength(int i2) {
        if (i2 == 224 || i2 == 256 || i2 == 384 || i2 == 512) {
            return i2;
        }
        throw new IllegalArgumentException("'bitLength' " + i2 + " not supported for SHA-3");
    }

    @Override // org.spongycastle.crypto.digests.KeccakDigest, org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i2) {
        absorb(new byte[]{2}, 0, 2L);
        return super.doFinal(bArr, i2);
    }

    @Override // org.spongycastle.crypto.digests.KeccakDigest, org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA3-" + this.fixedOutputLength;
    }

    public SHA3Digest(int i2) {
        super(checkBitLength(i2));
    }

    public SHA3Digest(SHA3Digest sHA3Digest) {
        super(sHA3Digest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.spongycastle.crypto.digests.KeccakDigest
    public int doFinal(byte[] bArr, int i2, byte b2, int i3) {
        if (i3 >= 0 && i3 <= 7) {
            int i4 = (b2 & ((1 << i3) - 1)) | (2 << i3);
            int i5 = i3 + 2;
            if (i5 >= 8) {
                byte[] bArr2 = this.oneByte;
                bArr2[0] = (byte) i4;
                absorb(bArr2, 0, 8L);
                i5 -= 8;
                i4 >>>= 8;
            }
            return super.doFinal(bArr, i2, (byte) i4, i5);
        }
        throw new IllegalArgumentException("'partialBits' must be in the range [0,7]");
    }
}