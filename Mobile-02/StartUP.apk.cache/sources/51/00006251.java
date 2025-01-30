package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.math.ec.Tnaf;

/* loaded from: classes3.dex */
public class GOST28147Mac implements Mac {
    private int blockSize = 8;
    private int macSize = 4;
    private boolean firstStep = true;
    private int[] workingKey = null;
    private byte[] S = {9, 6, 3, 2, 8, 11, 1, 7, 10, 4, 14, 15, 12, 0, 13, 5, 3, 7, 14, 9, 8, 10, 15, 0, 5, 2, 6, 12, 11, 4, 13, 1, 14, 4, 6, 2, 11, 3, 13, 8, 12, 15, 5, 10, 0, 7, 1, 9, 14, 7, 10, 12, 13, 1, 3, 9, 0, 2, 11, 4, 15, 8, 5, 6, 11, 5, 1, 9, 8, 13, 15, 0, 14, 4, 2, 3, 12, 7, 10, 6, 3, 10, 13, 12, 1, 2, 0, 11, 7, 5, 9, 4, 8, 15, 14, 6, 1, 13, 2, 9, 7, 10, 6, 0, 8, 12, 4, 5, 15, 3, 11, 14, 11, 10, 15, 5, 0, 12, 14, 8, 6, 2, 3, 9, 1, 7, 13, 4};
    private byte[] mac = new byte[8];
    private byte[] buf = new byte[8];
    private int bufOff = 0;

    private byte[] CM5func(byte[] bArr, int i2, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length - i2];
        System.arraycopy(bArr, i2, bArr3, 0, bArr2.length);
        for (int i3 = 0; i3 != bArr2.length; i3++) {
            bArr3[i3] = (byte) (bArr3[i3] ^ bArr2[i3]);
        }
        return bArr3;
    }

    private int bytesToint(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] << 24) & (-16777216)) + ((bArr[i2 + 2] << Tnaf.POW_2_WIDTH) & 16711680) + ((bArr[i2 + 1] << 8) & 65280) + (bArr[i2] & 255);
    }

    private int[] generateWorkingKey(byte[] bArr) {
        if (bArr.length == 32) {
            int[] iArr = new int[8];
            for (int i2 = 0; i2 != 8; i2++) {
                iArr[i2] = bytesToint(bArr, i2 * 4);
            }
            return iArr;
        }
        throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
    }

    private void gost28147MacFunc(int[] iArr, byte[] bArr, int i2, byte[] bArr2, int i3) {
        int bytesToint = bytesToint(bArr, i2);
        int bytesToint2 = bytesToint(bArr, i2 + 4);
        for (int i4 = 0; i4 < 2; i4++) {
            int i5 = 0;
            while (i5 < 8) {
                i5++;
                int i6 = bytesToint;
                bytesToint = bytesToint2 ^ gost28147_mainStep(bytesToint, iArr[i5]);
                bytesToint2 = i6;
            }
        }
        intTobytes(bytesToint, bArr2, i3);
        intTobytes(bytesToint2, bArr2, i3 + 4);
    }

    private int gost28147_mainStep(int i2, int i3) {
        int i4 = i3 + i2;
        byte[] bArr = this.S;
        int i5 = (bArr[((i4 >> 0) & 15) + 0] << 0) + (bArr[((i4 >> 4) & 15) + 16] << 4) + (bArr[((i4 >> 8) & 15) + 32] << 8) + (bArr[((i4 >> 12) & 15) + 48] << 12) + (bArr[((i4 >> 16) & 15) + 64] << Tnaf.POW_2_WIDTH) + (bArr[((i4 >> 20) & 15) + 80] << 20) + (bArr[((i4 >> 24) & 15) + 96] << 24) + (bArr[((i4 >> 28) & 15) + 112] << 28);
        return (i5 << 11) | (i5 >>> 21);
    }

    private void intTobytes(int i2, byte[] bArr, int i3) {
        bArr[i3 + 3] = (byte) (i2 >>> 24);
        bArr[i3 + 2] = (byte) (i2 >>> 16);
        bArr[i3 + 1] = (byte) (i2 >>> 8);
        bArr[i3] = (byte) i2;
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i2) throws DataLengthException, IllegalStateException {
        while (true) {
            int i3 = this.bufOff;
            if (i3 >= this.blockSize) {
                break;
            }
            this.buf[i3] = 0;
            this.bufOff = i3 + 1;
        }
        byte[] bArr2 = this.buf;
        byte[] bArr3 = new byte[bArr2.length];
        System.arraycopy(bArr2, 0, bArr3, 0, this.mac.length);
        if (this.firstStep) {
            this.firstStep = false;
        } else {
            bArr3 = CM5func(this.buf, 0, this.mac);
        }
        gost28147MacFunc(this.workingKey, bArr3, 0, this.mac, 0);
        byte[] bArr4 = this.mac;
        int i4 = this.macSize;
        System.arraycopy(bArr4, (bArr4.length / 2) - i4, bArr, i2, i4);
        reset();
        return this.macSize;
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        return "GOST28147Mac";
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return this.macSize;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        reset();
        this.buf = new byte[this.blockSize];
        if (cipherParameters instanceof ParametersWithSBox) {
            ParametersWithSBox parametersWithSBox = (ParametersWithSBox) cipherParameters;
            System.arraycopy(parametersWithSBox.getSBox(), 0, this.S, 0, parametersWithSBox.getSBox().length);
            if (parametersWithSBox.getParameters() != null) {
                this.workingKey = generateWorkingKey(((KeyParameter) parametersWithSBox.getParameters()).getKey());
            }
        } else if (cipherParameters instanceof KeyParameter) {
            this.workingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey());
        } else {
            throw new IllegalArgumentException("invalid parameter passed to GOST28147 init - " + cipherParameters.getClass().getName());
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.buf;
            if (i2 < bArr.length) {
                bArr[i2] = 0;
                i2++;
            } else {
                this.bufOff = 0;
                this.firstStep = true;
                return;
            }
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b2) throws IllegalStateException {
        int i2 = this.bufOff;
        byte[] bArr = this.buf;
        if (i2 == bArr.length) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, this.mac.length);
            if (this.firstStep) {
                this.firstStep = false;
            } else {
                bArr2 = CM5func(this.buf, 0, this.mac);
            }
            gost28147MacFunc(this.workingKey, bArr2, 0, this.mac, 0);
            this.bufOff = 0;
        }
        byte[] bArr3 = this.buf;
        int i3 = this.bufOff;
        this.bufOff = i3 + 1;
        bArr3[i3] = b2;
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i2, int i3) throws DataLengthException, IllegalStateException {
        if (i3 >= 0) {
            int i4 = this.blockSize;
            int i5 = this.bufOff;
            int i6 = i4 - i5;
            if (i3 > i6) {
                System.arraycopy(bArr, i2, this.buf, i5, i6);
                byte[] bArr2 = this.buf;
                byte[] bArr3 = new byte[bArr2.length];
                System.arraycopy(bArr2, 0, bArr3, 0, this.mac.length);
                if (this.firstStep) {
                    this.firstStep = false;
                } else {
                    bArr3 = CM5func(this.buf, 0, this.mac);
                }
                gost28147MacFunc(this.workingKey, bArr3, 0, this.mac, 0);
                this.bufOff = 0;
                while (true) {
                    i3 -= i6;
                    i2 += i6;
                    if (i3 <= this.blockSize) {
                        break;
                    }
                    gost28147MacFunc(this.workingKey, CM5func(bArr, i2, this.mac), 0, this.mac, 0);
                    i6 = this.blockSize;
                }
            }
            System.arraycopy(bArr, i2, this.buf, this.bufOff, i3);
            this.bufOff += i3;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}