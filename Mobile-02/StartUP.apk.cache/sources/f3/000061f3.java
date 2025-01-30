package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;

/* loaded from: classes3.dex */
public class NullEngine implements BlockCipher {
    protected static final int DEFAULT_BLOCK_SIZE = 1;
    private final int blockSize;
    private boolean initialised;

    public NullEngine() {
        this(1);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Null";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.initialised = true;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i2, byte[] bArr2, int i3) throws DataLengthException, IllegalStateException {
        if (this.initialised) {
            int i4 = this.blockSize;
            if (i2 + i4 <= bArr.length) {
                if (i4 + i3 > bArr2.length) {
                    throw new OutputLengthException("output buffer too short");
                }
                int i5 = 0;
                while (true) {
                    int i6 = this.blockSize;
                    if (i5 >= i6) {
                        return i6;
                    }
                    bArr2[i3 + i5] = bArr[i2 + i5];
                    i5++;
                }
            } else {
                throw new DataLengthException("input buffer too short");
            }
        } else {
            throw new IllegalStateException("Null engine not initialised");
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }

    public NullEngine(int i2) {
        this.blockSize = i2;
    }
}