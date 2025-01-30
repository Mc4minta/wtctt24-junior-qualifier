package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

/* loaded from: classes3.dex */
public class VMPCEngine implements StreamCipher {
    protected byte[] workingIV;
    protected byte[] workingKey;
    protected byte n = 0;
    protected byte[] P = null;
    protected byte s = 0;

    @Override // org.spongycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "VMPC";
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            if (parametersWithIV.getParameters() instanceof KeyParameter) {
                KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
                byte[] iv = parametersWithIV.getIV();
                this.workingIV = iv;
                if (iv != null && iv.length >= 1 && iv.length <= 768) {
                    byte[] key = keyParameter.getKey();
                    this.workingKey = key;
                    initKey(key, this.workingIV);
                    return;
                }
                throw new IllegalArgumentException("VMPC requires 1 to 768 bytes of IV");
            }
            throw new IllegalArgumentException("VMPC init parameters must include a key");
        }
        throw new IllegalArgumentException("VMPC init parameters must include an IV");
    }

    protected void initKey(byte[] bArr, byte[] bArr2) {
        this.s = (byte) 0;
        this.P = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            this.P[i2] = (byte) i2;
        }
        for (int i3 = 0; i3 < 768; i3++) {
            byte[] bArr3 = this.P;
            int i4 = i3 & 255;
            byte b2 = bArr3[(this.s + bArr3[i4] + bArr[i3 % bArr.length]) & 255];
            this.s = b2;
            byte b3 = bArr3[i4];
            bArr3[i4] = bArr3[b2 & 255];
            bArr3[b2 & 255] = b3;
        }
        for (int i5 = 0; i5 < 768; i5++) {
            byte[] bArr4 = this.P;
            int i6 = i5 & 255;
            byte b4 = bArr4[(this.s + bArr4[i6] + bArr2[i5 % bArr2.length]) & 255];
            this.s = b4;
            byte b5 = bArr4[i6];
            bArr4[i6] = bArr4[b4 & 255];
            bArr4[b4 & 255] = b5;
        }
        this.n = (byte) 0;
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        if (i2 + i3 <= bArr.length) {
            if (i4 + i3 <= bArr2.length) {
                for (int i5 = 0; i5 < i3; i5++) {
                    byte[] bArr3 = this.P;
                    byte b2 = this.s;
                    byte b3 = this.n;
                    byte b4 = bArr3[(b2 + bArr3[b3 & 255]) & 255];
                    this.s = b4;
                    byte b5 = bArr3[(bArr3[bArr3[b4 & 255] & 255] + 1) & 255];
                    byte b6 = bArr3[b3 & 255];
                    bArr3[b3 & 255] = bArr3[b4 & 255];
                    bArr3[b4 & 255] = b6;
                    this.n = (byte) ((b3 + 1) & 255);
                    bArr2[i5 + i4] = (byte) (bArr[i5 + i2] ^ b5);
                }
                return i3;
            }
            throw new OutputLengthException("output buffer too short");
        }
        throw new DataLengthException("input buffer too short");
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void reset() {
        initKey(this.workingKey, this.workingIV);
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public byte returnByte(byte b2) {
        byte[] bArr = this.P;
        byte b3 = this.s;
        byte b4 = this.n;
        byte b5 = bArr[(b3 + bArr[b4 & 255]) & 255];
        this.s = b5;
        byte b6 = bArr[(bArr[bArr[b5 & 255] & 255] + 1) & 255];
        byte b7 = bArr[b4 & 255];
        bArr[b4 & 255] = bArr[b5 & 255];
        bArr[b5 & 255] = b7;
        this.n = (byte) ((b4 + 1) & 255);
        return (byte) (b2 ^ b6);
    }
}