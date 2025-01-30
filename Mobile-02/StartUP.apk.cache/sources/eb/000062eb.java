package org.spongycastle.crypto.signers;

import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class GenericSigner implements Signer {
    private final Digest digest;
    private final AsymmetricBlockCipher engine;
    private boolean forSigning;

    public GenericSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        this.engine = asymmetricBlockCipher;
        this.digest = digest;
    }

    @Override // org.spongycastle.crypto.Signer
    public byte[] generateSignature() throws CryptoException, DataLengthException {
        if (this.forSigning) {
            int digestSize = this.digest.getDigestSize();
            byte[] bArr = new byte[digestSize];
            this.digest.doFinal(bArr, 0);
            return this.engine.processBlock(bArr, 0, digestSize);
        }
        throw new IllegalStateException("GenericSigner not initialised for signature generation.");
    }

    @Override // org.spongycastle.crypto.Signer
    public void init(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        this.forSigning = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            asymmetricKeyParameter = (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).getParameters();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        if (z && !asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("signing requires private key");
        }
        if (!z && asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("verification requires public key");
        }
        reset();
        this.engine.init(z, cipherParameters);
    }

    @Override // org.spongycastle.crypto.Signer
    public void reset() {
        this.digest.reset();
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte b2) {
        this.digest.update(b2);
    }

    @Override // org.spongycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        if (!this.forSigning) {
            int digestSize = this.digest.getDigestSize();
            byte[] bArr2 = new byte[digestSize];
            this.digest.doFinal(bArr2, 0);
            try {
                byte[] processBlock = this.engine.processBlock(bArr, 0, bArr.length);
                if (processBlock.length < digestSize) {
                    byte[] bArr3 = new byte[digestSize];
                    System.arraycopy(processBlock, 0, bArr3, digestSize - processBlock.length, processBlock.length);
                    processBlock = bArr3;
                }
                return Arrays.constantTimeAreEqual(processBlock, bArr2);
            } catch (Exception unused) {
                return false;
            }
        }
        throw new IllegalStateException("GenericSigner not initialised for verification");
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte[] bArr, int i2, int i3) {
        this.digest.update(bArr, i2, i3);
    }
}