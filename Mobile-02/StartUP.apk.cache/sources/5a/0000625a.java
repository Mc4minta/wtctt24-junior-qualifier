package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;

/* loaded from: classes3.dex */
public interface AEADBlockCipher {
    int doFinal(byte[] bArr, int i2) throws IllegalStateException, InvalidCipherTextException;

    String getAlgorithmName();

    byte[] getMac();

    int getOutputSize(int i2);

    BlockCipher getUnderlyingCipher();

    int getUpdateOutputSize(int i2);

    void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException;

    void processAADByte(byte b2);

    void processAADBytes(byte[] bArr, int i2, int i3);

    int processByte(byte b2, byte[] bArr, int i2) throws DataLengthException;

    int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException;

    void reset();
}