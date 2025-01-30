package org.spongycastle.crypto;

/* loaded from: classes3.dex */
public abstract class StreamBlockCipher implements BlockCipher, StreamCipher {
    private final BlockCipher cipher;

    /* JADX INFO: Access modifiers changed from: protected */
    public StreamBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
    }

    protected abstract byte calculateByte(byte b2);

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException {
        if (i4 + i3 <= bArr2.length) {
            int i5 = i2 + i3;
            if (i5 <= bArr.length) {
                while (i2 < i5) {
                    bArr2[i4] = calculateByte(bArr[i2]);
                    i4++;
                    i2++;
                }
                return i3;
            }
            throw new DataLengthException("input buffer too small");
        }
        throw new DataLengthException("output buffer too short");
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public final byte returnByte(byte b2) {
        return calculateByte(b2);
    }
}