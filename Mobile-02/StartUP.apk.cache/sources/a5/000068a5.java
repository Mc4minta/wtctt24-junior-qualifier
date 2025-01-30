package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.MessageEncryptor;

/* loaded from: classes3.dex */
public class McEliecePKCSDigestCipher {
    private boolean forEncrypting;
    private final MessageEncryptor mcElieceCipher;
    private final Digest messDigest;

    public McEliecePKCSDigestCipher(MessageEncryptor messageEncryptor, Digest digest) {
        this.mcElieceCipher = messageEncryptor;
        this.messDigest = digest;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        this.forEncrypting = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            asymmetricKeyParameter = (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).getParameters();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        if (z && asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("Encrypting Requires Public Key.");
        }
        if (!z && !asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("Decrypting Requires Private Key.");
        }
        reset();
        this.mcElieceCipher.init(z, cipherParameters);
    }

    public byte[] messageDecrypt(byte[] bArr) {
        if (!this.forEncrypting) {
            try {
                return this.mcElieceCipher.messageDecrypt(bArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        throw new IllegalStateException("McEliecePKCSDigestCipher not initialised for decrypting.");
    }

    public byte[] messageEncrypt() {
        if (this.forEncrypting) {
            byte[] bArr = new byte[this.messDigest.getDigestSize()];
            this.messDigest.doFinal(bArr, 0);
            try {
                return this.mcElieceCipher.messageEncrypt(bArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        throw new IllegalStateException("McEliecePKCSDigestCipher not initialised for encrypting.");
    }

    public void reset() {
        this.messDigest.reset();
    }

    public void update(byte b2) {
        this.messDigest.update(b2);
    }

    public void update(byte[] bArr, int i2, int i3) {
        this.messDigest.update(bArr, i2, i3);
    }
}