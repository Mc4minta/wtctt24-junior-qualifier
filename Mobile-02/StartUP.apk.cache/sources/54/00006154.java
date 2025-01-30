package org.spongycastle.crypto;

/* loaded from: classes3.dex */
public interface DerivationFunction {
    int generateBytes(byte[] bArr, int i2, int i3) throws DataLengthException, IllegalArgumentException;

    void init(DerivationParameters derivationParameters);
}