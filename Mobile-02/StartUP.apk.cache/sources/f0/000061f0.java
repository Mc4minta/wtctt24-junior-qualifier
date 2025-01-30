package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public class ISAACEngine implements StreamCipher {
    private final int sizeL = 8;
    private final int stateArraySize = 256;
    private int[] engineState = null;
    private int[] results = null;
    private int a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f17796b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f17797c = 0;
    private int index = 0;
    private byte[] keyStream = new byte[1024];
    private byte[] workingKey = null;
    private boolean initialised = false;

    private void isaac() {
        int i2 = this.f17796b;
        int i3 = this.f17797c + 1;
        this.f17797c = i3;
        this.f17796b = i2 + i3;
        for (int i4 = 0; i4 < 256; i4++) {
            int[] iArr = this.engineState;
            int i5 = iArr[i4];
            int i6 = i4 & 3;
            if (i6 == 0) {
                int i7 = this.a;
                this.a = i7 ^ (i7 << 13);
            } else if (i6 == 1) {
                int i8 = this.a;
                this.a = i8 ^ (i8 >>> 6);
            } else if (i6 == 2) {
                int i9 = this.a;
                this.a = i9 ^ (i9 << 2);
            } else if (i6 == 3) {
                int i10 = this.a;
                this.a = i10 ^ (i10 >>> 16);
            }
            int i11 = this.a + iArr[(i4 + 128) & 255];
            this.a = i11;
            int i12 = iArr[(i5 >>> 2) & 255] + i11 + this.f17796b;
            iArr[i4] = i12;
            int[] iArr2 = this.results;
            int i13 = iArr[(i12 >>> 10) & 255] + i5;
            this.f17796b = i13;
            iArr2[i4] = i13;
        }
    }

    private void mix(int[] iArr) {
        iArr[0] = iArr[0] ^ (iArr[1] << 11);
        iArr[3] = iArr[3] + iArr[0];
        iArr[1] = iArr[1] + iArr[2];
        iArr[1] = iArr[1] ^ (iArr[2] >>> 2);
        iArr[4] = iArr[4] + iArr[1];
        iArr[2] = iArr[2] + iArr[3];
        iArr[2] = iArr[2] ^ (iArr[3] << 8);
        iArr[5] = iArr[5] + iArr[2];
        iArr[3] = iArr[3] + iArr[4];
        iArr[3] = iArr[3] ^ (iArr[4] >>> 16);
        iArr[6] = iArr[6] + iArr[3];
        iArr[4] = iArr[4] + iArr[5];
        iArr[4] = iArr[4] ^ (iArr[5] << 10);
        iArr[7] = iArr[7] + iArr[4];
        iArr[5] = iArr[5] + iArr[6];
        iArr[5] = (iArr[6] >>> 4) ^ iArr[5];
        iArr[0] = iArr[0] + iArr[5];
        iArr[6] = iArr[6] + iArr[7];
        iArr[6] = iArr[6] ^ (iArr[7] << 8);
        iArr[1] = iArr[1] + iArr[6];
        iArr[7] = iArr[7] + iArr[0];
        iArr[7] = iArr[7] ^ (iArr[0] >>> 9);
        iArr[2] = iArr[2] + iArr[7];
        iArr[0] = iArr[0] + iArr[1];
    }

    private void setKey(byte[] bArr) {
        this.workingKey = bArr;
        if (this.engineState == null) {
            this.engineState = new int[256];
        }
        if (this.results == null) {
            this.results = new int[256];
        }
        for (int i2 = 0; i2 < 256; i2++) {
            int[] iArr = this.engineState;
            this.results[i2] = 0;
            iArr[i2] = 0;
        }
        this.f17797c = 0;
        this.f17796b = 0;
        this.a = 0;
        this.index = 0;
        int length = bArr.length + (bArr.length & 3);
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        for (int i3 = 0; i3 < length; i3 += 4) {
            this.results[i3 >>> 2] = Pack.littleEndianToInt(bArr2, i3);
        }
        int[] iArr2 = new int[8];
        for (int i4 = 0; i4 < 8; i4++) {
            iArr2[i4] = -1640531527;
        }
        for (int i5 = 0; i5 < 4; i5++) {
            mix(iArr2);
        }
        int i6 = 0;
        while (i6 < 2) {
            for (int i7 = 0; i7 < 256; i7 += 8) {
                for (int i8 = 0; i8 < 8; i8++) {
                    iArr2[i8] = iArr2[i8] + (i6 < 1 ? this.results[i7 + i8] : this.engineState[i7 + i8]);
                }
                mix(iArr2);
                for (int i9 = 0; i9 < 8; i9++) {
                    this.engineState[i7 + i9] = iArr2[i9];
                }
            }
            i6++;
        }
        isaac();
        this.initialised = true;
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "ISAAC";
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            setKey(((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to ISAAC init - " + cipherParameters.getClass().getName());
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        if (this.initialised) {
            if (i2 + i3 <= bArr.length) {
                if (i4 + i3 <= bArr2.length) {
                    for (int i5 = 0; i5 < i3; i5++) {
                        if (this.index == 0) {
                            isaac();
                            this.keyStream = Pack.intToBigEndian(this.results);
                        }
                        byte[] bArr3 = this.keyStream;
                        int i6 = this.index;
                        bArr2[i5 + i4] = (byte) (bArr3[i6] ^ bArr[i5 + i2]);
                        this.index = (i6 + 1) & 1023;
                    }
                    return i3;
                }
                throw new OutputLengthException("output buffer too short");
            }
            throw new DataLengthException("input buffer too short");
        }
        throw new IllegalStateException(getAlgorithmName() + " not initialised");
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void reset() {
        setKey(this.workingKey);
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public byte returnByte(byte b2) {
        if (this.index == 0) {
            isaac();
            this.keyStream = Pack.intToBigEndian(this.results);
        }
        byte[] bArr = this.keyStream;
        int i2 = this.index;
        byte b3 = (byte) (b2 ^ bArr[i2]);
        this.index = (i2 + 1) & 1023;
        return b3;
    }
}