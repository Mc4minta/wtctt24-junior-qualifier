package org.spongycastle.crypto;

/* loaded from: classes3.dex */
public class BufferedAsymmetricBlockCipher {
    protected byte[] buf;
    protected int bufOff;
    private final AsymmetricBlockCipher cipher;

    public BufferedAsymmetricBlockCipher(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.cipher = asymmetricBlockCipher;
    }

    public byte[] doFinal() throws InvalidCipherTextException {
        byte[] processBlock = this.cipher.processBlock(this.buf, 0, this.bufOff);
        reset();
        return processBlock;
    }

    public int getBufferPosition() {
        return this.bufOff;
    }

    public int getInputBlockSize() {
        return this.cipher.getInputBlockSize();
    }

    public int getOutputBlockSize() {
        return this.cipher.getOutputBlockSize();
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        reset();
        this.cipher.init(z, cipherParameters);
        this.buf = new byte[this.cipher.getInputBlockSize() + (z ? 1 : 0)];
        this.bufOff = 0;
    }

    public void processByte(byte b2) {
        int i2 = this.bufOff;
        byte[] bArr = this.buf;
        if (i2 < bArr.length) {
            this.bufOff = i2 + 1;
            bArr[i2] = b2;
            return;
        }
        throw new DataLengthException("attempt to process message too long for cipher");
    }

    public void processBytes(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return;
        }
        if (i3 >= 0) {
            int i4 = this.bufOff;
            int i5 = i4 + i3;
            byte[] bArr2 = this.buf;
            if (i5 <= bArr2.length) {
                System.arraycopy(bArr, i2, bArr2, i4, i3);
                this.bufOff += i3;
                return;
            }
            throw new DataLengthException("attempt to process message too long for cipher");
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    public void reset() {
        if (this.buf != null) {
            int i2 = 0;
            while (true) {
                byte[] bArr = this.buf;
                if (i2 >= bArr.length) {
                    break;
                }
                bArr[i2] = 0;
                i2++;
            }
        }
        this.bufOff = 0;
    }
}