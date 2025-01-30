package org.spongycastle.crypto;

/* loaded from: classes3.dex */
public interface AsymmetricBlockCipher {
    int getInputBlockSize();

    int getOutputBlockSize();

    void init(boolean z, CipherParameters cipherParameters);

    byte[] processBlock(byte[] bArr, int i2, int i3) throws InvalidCipherTextException;
}