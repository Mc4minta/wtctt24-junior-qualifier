package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;

/* loaded from: classes3.dex */
public class PaddedBlockCipher extends BufferedBlockCipher {
    public PaddedBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        this.buf = new byte[blockCipher.getBlockSize()];
        this.bufOff = 0;
    }

    @Override // org.spongycastle.crypto.BufferedBlockCipher
    public int doFinal(byte[] bArr, int i2) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        int i3;
        int i4;
        int blockSize = this.cipher.getBlockSize();
        if (this.forEncryption) {
            if (this.bufOff != blockSize) {
                i4 = 0;
            } else if ((blockSize * 2) + i2 <= bArr.length) {
                i4 = this.cipher.processBlock(this.buf, 0, bArr, i2);
                this.bufOff = 0;
            } else {
                throw new DataLengthException("output buffer too short");
            }
            byte b2 = (byte) (blockSize - this.bufOff);
            while (true) {
                int i5 = this.bufOff;
                if (i5 >= blockSize) {
                    break;
                }
                this.buf[i5] = b2;
                this.bufOff = i5 + 1;
            }
            i3 = i4 + this.cipher.processBlock(this.buf, 0, bArr, i2 + i4);
        } else if (this.bufOff == blockSize) {
            BlockCipher blockCipher = this.cipher;
            byte[] bArr2 = this.buf;
            int processBlock = blockCipher.processBlock(bArr2, 0, bArr2, 0);
            this.bufOff = 0;
            byte[] bArr3 = this.buf;
            int i6 = bArr3[blockSize - 1] & 255;
            if (i6 >= 0 && i6 <= blockSize) {
                i3 = processBlock - i6;
                System.arraycopy(bArr3, 0, bArr, i2, i3);
            } else {
                throw new InvalidCipherTextException("pad block corrupted");
            }
        } else {
            throw new DataLengthException("last block incomplete in decryption");
        }
        reset();
        return i3;
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
        return length == 0 ? i3 - bArr.length : i3 - length;
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
                throw new DataLengthException("output buffer too short");
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
}