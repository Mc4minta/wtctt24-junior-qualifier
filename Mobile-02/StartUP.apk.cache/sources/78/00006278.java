package org.spongycastle.crypto.paddings;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.ParametersWithRandom;

/* loaded from: classes3.dex */
public class PaddedBufferedBlockCipher extends BufferedBlockCipher {
    BlockCipherPadding padding;

    public PaddedBufferedBlockCipher(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        this.cipher = blockCipher;
        this.padding = blockCipherPadding;
        this.buf = new byte[blockCipher.getBlockSize()];
        this.bufOff = 0;
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public int doFinal(byte[] bArr, int i2) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        int i3;
        int blockSize = this.cipher.getBlockSize();
        if (this.forEncryption) {
            if (this.bufOff != blockSize) {
                i3 = 0;
            } else if ((blockSize * 2) + i2 <= bArr.length) {
                i3 = this.cipher.processBlock(this.buf, 0, bArr, i2);
                this.bufOff = 0;
            } else {
                reset();
                throw new OutputLengthException("output buffer too short");
            }
            this.padding.addPadding(this.buf, this.bufOff);
            return i3 + this.cipher.processBlock(this.buf, 0, bArr, i2 + i3);
        } else if (this.bufOff == blockSize) {
            BlockCipher blockCipher = this.cipher;
            byte[] bArr2 = this.buf;
            int processBlock = blockCipher.processBlock(bArr2, 0, bArr2, 0);
            this.bufOff = 0;
            try {
                int padCount = processBlock - this.padding.padCount(this.buf);
                System.arraycopy(this.buf, 0, bArr, i2, padCount);
                return padCount;
            } finally {
                reset();
            }
        } else {
            reset();
            throw new DataLengthException("last block incomplete in decryption");
        }
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public int getOutputSize(int i2) {
        int length;
        int i3 = i2 + this.bufOff;
        byte[] bArr = this.buf;
        int length2 = i3 % bArr.length;
        if (length2 == 0) {
            if (!this.forEncryption) {
                return i3;
            }
            length = bArr.length;
        } else {
            i3 -= length2;
            length = bArr.length;
        }
        return i3 + length;
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public int getUpdateOutputSize(int i2) {
        int i3 = i2 + this.bufOff;
        byte[] bArr = this.buf;
        int length = i3 % bArr.length;
        return length == 0 ? Math.max(0, i3 - bArr.length) : i3 - length;
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.forEncryption = z;
        reset();
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.padding.init(parametersWithRandom.getRandom());
            this.cipher.init(z, parametersWithRandom.getParameters());
            return;
        }
        this.padding.init(null);
        this.cipher.init(z, cipherParameters);
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public int processByte(byte b2, byte[] bArr, int i2) throws DataLengthException, IllegalStateException {
        int i3 = this.bufOff;
        byte[] bArr2 = this.buf;
        int i4 = 0;
        if (i3 == bArr2.length) {
            int processBlock = this.cipher.processBlock(bArr2, 0, bArr, i2);
            this.bufOff = 0;
            i4 = processBlock;
        }
        byte[] bArr3 = this.buf;
        int i5 = this.bufOff;
        this.bufOff = i5 + 1;
        bArr3[i5] = b2;
        return i4;
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException, IllegalStateException {
        if (i3 >= 0) {
            int blockSize = getBlockSize();
            int updateOutputSize = getUpdateOutputSize(i3);
            if (updateOutputSize > 0 && updateOutputSize + i4 > bArr2.length) {
                throw new OutputLengthException("output buffer too short");
            }
            byte[] bArr3 = this.buf;
            int length = bArr3.length;
            int i5 = this.bufOff;
            int i6 = length - i5;
            int i7 = 0;
            if (i3 > i6) {
                System.arraycopy(bArr, i2, bArr3, i5, i6);
                this.bufOff = 0;
                i3 -= i6;
                i2 += i6;
                i7 = this.cipher.processBlock(this.buf, 0, bArr2, i4) + 0;
                while (i3 > this.buf.length) {
                    i7 += this.cipher.processBlock(bArr, i2, bArr2, i4 + i7);
                    i3 -= blockSize;
                    i2 += blockSize;
                }
            }
            System.arraycopy(bArr, i2, this.buf, this.bufOff, i3);
            this.bufOff += i3;
            return i7;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    public PaddedBufferedBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, new PKCS7Padding());
    }
}