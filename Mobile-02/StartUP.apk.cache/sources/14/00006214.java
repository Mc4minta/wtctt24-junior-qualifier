package org.spongycastle.crypto.engines;

/* loaded from: classes3.dex */
public class VMPCKSA3Engine extends VMPCEngine {
    @Override // org.spongycastle.crypto.engines.VMPCEngine, org.spongycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "VMPC-KSA3";
    }

    @Override // org.spongycastle.crypto.engines.VMPCEngine
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
        for (int i7 = 0; i7 < 768; i7++) {
            byte[] bArr5 = this.P;
            int i8 = i7 & 255;
            byte b6 = bArr5[(this.s + bArr5[i8] + bArr[i7 % bArr.length]) & 255];
            this.s = b6;
            byte b7 = bArr5[i8];
            bArr5[i8] = bArr5[b6 & 255];
            bArr5[b6 & 255] = b7;
        }
        this.n = (byte) 0;
    }
}