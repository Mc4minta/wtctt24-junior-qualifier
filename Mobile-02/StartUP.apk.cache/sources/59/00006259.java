package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

/* loaded from: classes3.dex */
public class VMPCMac implements Mac {
    private byte[] T;

    /* renamed from: g  reason: collision with root package name */
    private byte f17806g;
    private byte[] workingIV;
    private byte[] workingKey;
    private byte x1;
    private byte x2;
    private byte x3;
    private byte x4;
    private byte n = 0;
    private byte[] P = null;
    private byte s = 0;

    private void initKey(byte[] bArr, byte[] bArr2) {
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

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i2) throws DataLengthException, IllegalStateException {
        for (int i3 = 1; i3 < 25; i3++) {
            byte[] bArr2 = this.P;
            byte b2 = this.s;
            byte b3 = this.n;
            byte b4 = bArr2[(b2 + bArr2[b3 & 255]) & 255];
            this.s = b4;
            byte b5 = this.x4;
            byte b6 = this.x3;
            byte b7 = bArr2[(b5 + b6 + i3) & 255];
            this.x4 = b7;
            byte b8 = this.x2;
            byte b9 = bArr2[(b6 + b8 + i3) & 255];
            this.x3 = b9;
            byte b10 = this.x1;
            byte b11 = bArr2[(b8 + b10 + i3) & 255];
            this.x2 = b11;
            byte b12 = bArr2[(b10 + b4 + i3) & 255];
            this.x1 = b12;
            byte[] bArr3 = this.T;
            byte b13 = this.f17806g;
            bArr3[b13 & 31] = (byte) (b12 ^ bArr3[b13 & 31]);
            bArr3[(b13 + 1) & 31] = (byte) (b11 ^ bArr3[(b13 + 1) & 31]);
            bArr3[(b13 + 2) & 31] = (byte) (b9 ^ bArr3[(b13 + 2) & 31]);
            bArr3[(b13 + 3) & 31] = (byte) (b7 ^ bArr3[(b13 + 3) & 31]);
            this.f17806g = (byte) ((b13 + 4) & 31);
            byte b14 = bArr2[b3 & 255];
            bArr2[b3 & 255] = bArr2[b4 & 255];
            bArr2[b4 & 255] = b14;
            this.n = (byte) ((b3 + 1) & 255);
        }
        for (int i4 = 0; i4 < 768; i4++) {
            byte[] bArr4 = this.P;
            int i5 = i4 & 255;
            byte b15 = bArr4[(this.s + bArr4[i5] + this.T[i4 & 31]) & 255];
            this.s = b15;
            byte b16 = bArr4[i5];
            bArr4[i5] = bArr4[b15 & 255];
            bArr4[b15 & 255] = b16;
        }
        byte[] bArr5 = new byte[20];
        for (int i6 = 0; i6 < 20; i6++) {
            byte[] bArr6 = this.P;
            int i7 = i6 & 255;
            byte b17 = bArr6[(this.s + bArr6[i7]) & 255];
            this.s = b17;
            bArr5[i6] = bArr6[(bArr6[bArr6[b17 & 255] & 255] + 1) & 255];
            byte b18 = bArr6[i7];
            bArr6[i7] = bArr6[b17 & 255];
            bArr6[b17 & 255] = b18;
        }
        System.arraycopy(bArr5, 0, bArr, i2, 20);
        reset();
        return 20;
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        return "VMPC-MAC";
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return 20;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
            if (parametersWithIV.getParameters() instanceof KeyParameter) {
                byte[] iv = parametersWithIV.getIV();
                this.workingIV = iv;
                if (iv != null && iv.length >= 1 && iv.length <= 768) {
                    this.workingKey = keyParameter.getKey();
                    reset();
                    return;
                }
                throw new IllegalArgumentException("VMPC-MAC requires 1 to 768 bytes of IV");
            }
            throw new IllegalArgumentException("VMPC-MAC Init parameters must include a key");
        }
        throw new IllegalArgumentException("VMPC-MAC Init parameters must include an IV");
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        initKey(this.workingKey, this.workingIV);
        this.n = (byte) 0;
        this.x4 = (byte) 0;
        this.x3 = (byte) 0;
        this.x2 = (byte) 0;
        this.x1 = (byte) 0;
        this.f17806g = (byte) 0;
        this.T = new byte[32];
        for (int i2 = 0; i2 < 32; i2++) {
            this.T[i2] = 0;
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b2) throws IllegalStateException {
        byte[] bArr = this.P;
        byte b3 = this.s;
        byte b4 = this.n;
        byte b5 = bArr[(b3 + bArr[b4 & 255]) & 255];
        this.s = b5;
        byte b6 = this.x4;
        byte b7 = this.x3;
        byte b8 = bArr[(b6 + b7) & 255];
        this.x4 = b8;
        byte b9 = this.x2;
        byte b10 = bArr[(b7 + b9) & 255];
        this.x3 = b10;
        byte b11 = this.x1;
        byte b12 = bArr[(b9 + b11) & 255];
        this.x2 = b12;
        byte b13 = bArr[(b11 + b5 + ((byte) (b2 ^ bArr[(bArr[bArr[b5 & 255] & 255] + 1) & 255]))) & 255];
        this.x1 = b13;
        byte[] bArr2 = this.T;
        byte b14 = this.f17806g;
        bArr2[b14 & 31] = (byte) (b13 ^ bArr2[b14 & 31]);
        bArr2[(b14 + 1) & 31] = (byte) (b12 ^ bArr2[(b14 + 1) & 31]);
        bArr2[(b14 + 2) & 31] = (byte) (b10 ^ bArr2[(b14 + 2) & 31]);
        bArr2[(b14 + 3) & 31] = (byte) (b8 ^ bArr2[(b14 + 3) & 31]);
        this.f17806g = (byte) ((b14 + 4) & 31);
        byte b15 = bArr[b4 & 255];
        bArr[b4 & 255] = bArr[b5 & 255];
        bArr[b5 & 255] = b15;
        this.n = (byte) ((b4 + 1) & 255);
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i2, int i3) throws DataLengthException, IllegalStateException {
        if (i2 + i3 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            update(bArr[i2 + i4]);
        }
    }
}