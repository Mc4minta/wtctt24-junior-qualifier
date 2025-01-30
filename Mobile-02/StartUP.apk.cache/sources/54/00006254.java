package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.ParametersWithIV;

/* compiled from: CFBBlockCipherMac.java */
/* loaded from: classes3.dex */
class MacCFBBlockCipher {
    private byte[] IV;
    private int blockSize;
    private byte[] cfbOutV;
    private byte[] cfbV;
    private BlockCipher cipher;

    public MacCFBBlockCipher(BlockCipher blockCipher, int i2) {
        this.cipher = null;
        this.cipher = blockCipher;
        this.blockSize = i2 / 8;
        this.IV = new byte[blockCipher.getBlockSize()];
        this.cfbV = new byte[blockCipher.getBlockSize()];
        this.cfbOutV = new byte[blockCipher.getBlockSize()];
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CFB" + (this.blockSize * 8);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getMacBlock(byte[] bArr) {
        this.cipher.processBlock(this.cfbV, 0, bArr, 0);
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            int length = iv.length;
            byte[] bArr = this.IV;
            if (length < bArr.length) {
                System.arraycopy(iv, 0, bArr, bArr.length - iv.length, iv.length);
            } else {
                System.arraycopy(iv, 0, bArr, 0, bArr.length);
            }
            reset();
            this.cipher.init(true, parametersWithIV.getParameters());
            return;
        }
        reset();
        this.cipher.init(true, cipherParameters);
    }

    public int processBlock(byte[] bArr, int i2, byte[] bArr2, int i3) throws DataLengthException, IllegalStateException {
        int i4 = this.blockSize;
        if (i2 + i4 <= bArr.length) {
            if (i4 + i3 <= bArr2.length) {
                this.cipher.processBlock(this.cfbV, 0, this.cfbOutV, 0);
                int i5 = 0;
                while (true) {
                    int i6 = this.blockSize;
                    if (i5 < i6) {
                        bArr2[i3 + i5] = (byte) (this.cfbOutV[i5] ^ bArr[i2 + i5]);
                        i5++;
                    } else {
                        byte[] bArr3 = this.cfbV;
                        System.arraycopy(bArr3, i6, bArr3, 0, bArr3.length - i6);
                        byte[] bArr4 = this.cfbV;
                        int length = bArr4.length;
                        int i7 = this.blockSize;
                        System.arraycopy(bArr2, i3, bArr4, length - i7, i7);
                        return this.blockSize;
                    }
                }
            } else {
                throw new DataLengthException("output buffer too short");
            }
        } else {
            throw new DataLengthException("input buffer too short");
        }
    }

    public void reset() {
        byte[] bArr = this.IV;
        System.arraycopy(bArr, 0, this.cfbV, 0, bArr.length);
        this.cipher.reset();
    }
}