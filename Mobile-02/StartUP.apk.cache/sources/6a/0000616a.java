package org.spongycastle.crypto;

/* loaded from: classes3.dex */
public interface StreamCipher {
    String getAlgorithmName();

    void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException;

    int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException;

    void reset();

    byte returnByte(byte b2);
}