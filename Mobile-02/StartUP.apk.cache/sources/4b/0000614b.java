package org.spongycastle.crypto;

/* loaded from: classes3.dex */
public class BufferedBlockCipher {
    protected byte[] buf;
    protected int bufOff;
    protected BlockCipher cipher;
    protected boolean forEncryption;
    protected boolean partialBlockOkay;
    protected boolean pgpCFB;

    /* JADX INFO: Access modifiers changed from: protected */
    public BufferedBlockCipher() {
    }

    public int doFinal(byte[] bArr, int i2) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        try {
            int i3 = this.bufOff;
            if (i2 + i3 <= bArr.length) {
                int i4 = 0;
                if (i3 != 0) {
                    if (this.partialBlockOkay) {
                        BlockCipher blockCipher = this.cipher;
                        byte[] bArr2 = this.buf;
                        blockCipher.processBlock(bArr2, 0, bArr2, 0);
                        int i5 = this.bufOff;
                        this.bufOff = 0;
                        System.arraycopy(this.buf, 0, bArr, i2, i5);
                        i4 = i5;
                    } else {
                        throw new DataLengthException("data not block size aligned");
                    }
                }
                return i4;
            }
            throw new OutputLengthException("output buffer too short for doFinal()");
        } finally {
            reset();
        }
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public int getOutputSize(int i2) {
        return i2 + this.bufOff;
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public int getUpdateOutputSize(int i2) {
        int length;
        int i3 = i2 + this.bufOff;
        if (this.pgpCFB) {
            if (this.forEncryption) {
                length = (i3 % this.buf.length) - (this.cipher.getBlockSize() + 2);
            } else {
                length = i3 % this.buf.length;
            }
        } else {
            length = i3 % this.buf.length;
        }
        return i3 - length;
    }

    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.forEncryption = z;
        reset();
        this.cipher.init(z, cipherParameters);
    }

    public int processByte(byte b2, byte[] bArr, int i2) throws DataLengthException, IllegalStateException {
        byte[] bArr2 = this.buf;
        int i3 = this.bufOff;
        int i4 = i3 + 1;
        this.bufOff = i4;
        bArr2[i3] = b2;
        if (i4 == bArr2.length) {
            int processBlock = this.cipher.processBlock(bArr2, 0, bArr, i2);
            this.bufOff = 0;
            return processBlock;
        }
        return 0;
    }

    public int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException, IllegalStateException {
        int i5;
        if (i3 >= 0) {
            int blockSize = getBlockSize();
            int updateOutputSize = getUpdateOutputSize(i3);
            if (updateOutputSize > 0 && updateOutputSize + i4 > bArr2.length) {
                throw new OutputLengthException("output buffer too short");
            }
            byte[] bArr3 = this.buf;
            int length = bArr3.length;
            int i6 = this.bufOff;
            int i7 = length - i6;
            if (i3 > i7) {
                System.arraycopy(bArr, i2, bArr3, i6, i7);
                i5 = this.cipher.processBlock(this.buf, 0, bArr2, i4) + 0;
                this.bufOff = 0;
                i3 -= i7;
                i2 += i7;
                while (i3 > this.buf.length) {
                    i5 += this.cipher.processBlock(bArr, i2, bArr2, i4 + i5);
                    i3 -= blockSize;
                    i2 += blockSize;
                }
            } else {
                i5 = 0;
            }
            System.arraycopy(bArr, i2, this.buf, this.bufOff, i3);
            int i8 = this.bufOff + i3;
            this.bufOff = i8;
            byte[] bArr4 = this.buf;
            if (i8 == bArr4.length) {
                int processBlock = i5 + this.cipher.processBlock(bArr4, 0, bArr2, i4 + i5);
                this.bufOff = 0;
                return processBlock;
            }
            return i5;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    public void reset() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.buf;
            if (i2 < bArr.length) {
                bArr[i2] = 0;
                i2++;
            } else {
                this.bufOff = 0;
                this.cipher.reset();
                return;
            }
        }
    }

    public BufferedBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        this.buf = new byte[blockCipher.getBlockSize()];
        boolean z = false;
        this.bufOff = 0;
        String algorithmName = blockCipher.getAlgorithmName();
        int indexOf = algorithmName.indexOf(47) + 1;
        boolean z2 = indexOf > 0 && algorithmName.startsWith("PGP", indexOf);
        this.pgpCFB = z2;
        if (!z2 && !(blockCipher instanceof StreamCipher)) {
            if (indexOf > 0 && algorithmName.startsWith("OpenPGP", indexOf)) {
                z = true;
            }
            this.partialBlockOkay = z;
            return;
        }
        this.partialBlockOkay = true;
    }
}