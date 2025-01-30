package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.DigestDerivationFunction;
import org.spongycastle.crypto.params.ISO18033KDFParameters;
import org.spongycastle.crypto.params.KDFParameters;
import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public class BaseKDFBytesGenerator implements DigestDerivationFunction {
    private int counterStart;
    private Digest digest;
    private byte[] iv;
    private byte[] shared;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseKDFBytesGenerator(int i2, Digest digest) {
        this.counterStart = i2;
        this.digest = digest;
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i2, int i3) throws DataLengthException, IllegalArgumentException {
        int i4 = i3;
        int i5 = i2;
        if (bArr.length - i4 >= i5) {
            long j2 = i4;
            int digestSize = this.digest.getDigestSize();
            if (j2 <= 8589934591L) {
                long j3 = digestSize;
                int i6 = (int) (((j2 + j3) - 1) / j3);
                byte[] bArr2 = new byte[this.digest.getDigestSize()];
                byte[] bArr3 = new byte[4];
                Pack.intToBigEndian(this.counterStart, bArr3, 0);
                int i7 = this.counterStart & (-256);
                for (int i8 = 0; i8 < i6; i8++) {
                    Digest digest = this.digest;
                    byte[] bArr4 = this.shared;
                    digest.update(bArr4, 0, bArr4.length);
                    this.digest.update(bArr3, 0, 4);
                    byte[] bArr5 = this.iv;
                    if (bArr5 != null) {
                        this.digest.update(bArr5, 0, bArr5.length);
                    }
                    this.digest.doFinal(bArr2, 0);
                    if (i4 > digestSize) {
                        System.arraycopy(bArr2, 0, bArr, i5, digestSize);
                        i5 += digestSize;
                        i4 -= digestSize;
                    } else {
                        System.arraycopy(bArr2, 0, bArr, i5, i4);
                    }
                    byte b2 = (byte) (bArr3[3] + 1);
                    bArr3[3] = b2;
                    if (b2 == 0) {
                        i7 += 256;
                        Pack.intToBigEndian(i7, bArr3, 0);
                    }
                }
                this.digest.reset();
                return (int) j2;
            }
            throw new IllegalArgumentException("Output length too large");
        }
        throw new DataLengthException("output buffer too small");
    }

    @Override // org.spongycastle.crypto.DigestDerivationFunction
    public Digest getDigest() {
        return this.digest;
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFParameters) {
            KDFParameters kDFParameters = (KDFParameters) derivationParameters;
            this.shared = kDFParameters.getSharedSecret();
            this.iv = kDFParameters.getIV();
        } else if (derivationParameters instanceof ISO18033KDFParameters) {
            this.shared = ((ISO18033KDFParameters) derivationParameters).getSeed();
            this.iv = null;
        } else {
            throw new IllegalArgumentException("KDF parameters required for KDF2Generator");
        }
    }
}