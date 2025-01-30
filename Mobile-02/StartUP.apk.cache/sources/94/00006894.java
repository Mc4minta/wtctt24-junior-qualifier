package org.spongycastle.pqc.crypto.gmss.util;

import java.lang.reflect.Array;
import org.spongycastle.crypto.Digest;

/* loaded from: classes3.dex */
public class WinternitzOTSignature {
    private int checksumsize;
    private GMSSRandom gmssRandom;
    private int keysize;
    private int mdsize;
    private Digest messDigestOTS;
    private int messagesize;
    private byte[][] privateKeyOTS;
    private int w;

    public WinternitzOTSignature(byte[] bArr, Digest digest, int i2) {
        int digestSize;
        this.w = i2;
        this.messDigestOTS = digest;
        this.gmssRandom = new GMSSRandom(digest);
        this.mdsize = this.messDigestOTS.getDigestSize();
        double d2 = i2;
        int ceil = (int) Math.ceil((digestSize << 3) / d2);
        this.messagesize = ceil;
        int log = getLog((ceil << i2) + 1);
        this.checksumsize = log;
        int ceil2 = this.messagesize + ((int) Math.ceil(log / d2));
        this.keysize = ceil2;
        this.privateKeyOTS = (byte[][]) Array.newInstance(byte.class, ceil2, this.mdsize);
        int i3 = this.mdsize;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        for (int i4 = 0; i4 < this.keysize; i4++) {
            this.privateKeyOTS[i4] = this.gmssRandom.nextSeed(bArr2);
        }
    }

    public int getLog(int i2) {
        int i3 = 1;
        int i4 = 2;
        while (i4 < i2) {
            i4 <<= 1;
            i3++;
        }
        return i3;
    }

    public byte[][] getPrivateKey() {
        return this.privateKeyOTS;
    }

    public byte[] getPublicKey() {
        int i2 = this.keysize;
        int i3 = this.mdsize;
        int i4 = i2 * i3;
        byte[] bArr = new byte[i4];
        byte[] bArr2 = new byte[i3];
        int i5 = 1 << this.w;
        for (int i6 = 0; i6 < this.keysize; i6++) {
            Digest digest = this.messDigestOTS;
            byte[][] bArr3 = this.privateKeyOTS;
            digest.update(bArr3[i6], 0, bArr3[i6].length);
            byte[] bArr4 = new byte[this.messDigestOTS.getDigestSize()];
            this.messDigestOTS.doFinal(bArr4, 0);
            for (int i7 = 2; i7 < i5; i7++) {
                this.messDigestOTS.update(bArr4, 0, bArr4.length);
                bArr4 = new byte[this.messDigestOTS.getDigestSize()];
                this.messDigestOTS.doFinal(bArr4, 0);
            }
            int i8 = this.mdsize;
            System.arraycopy(bArr4, 0, bArr, i8 * i6, i8);
        }
        this.messDigestOTS.update(bArr, 0, i4);
        byte[] bArr5 = new byte[this.messDigestOTS.getDigestSize()];
        this.messDigestOTS.doFinal(bArr5, 0);
        return bArr5;
    }

    public byte[] getSignature(byte[] bArr) {
        int i2;
        int i3 = this.keysize;
        int i4 = this.mdsize;
        byte[] bArr2 = new byte[i3 * i4];
        byte[] bArr3 = new byte[i4];
        this.messDigestOTS.update(bArr, 0, bArr.length);
        int digestSize = this.messDigestOTS.getDigestSize();
        byte[] bArr4 = new byte[digestSize];
        this.messDigestOTS.doFinal(bArr4, 0);
        int i5 = this.w;
        int i6 = 8;
        if (8 % i5 == 0) {
            int i7 = 8 / i5;
            int i8 = (1 << i5) - 1;
            byte[] bArr5 = new byte[this.mdsize];
            int i9 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < digestSize; i11++) {
                for (int i12 = 0; i12 < i7; i12++) {
                    int i13 = bArr4[i11] & i8;
                    i9 += i13;
                    System.arraycopy(this.privateKeyOTS[i10], 0, bArr5, 0, this.mdsize);
                    while (i13 > 0) {
                        this.messDigestOTS.update(bArr5, 0, bArr5.length);
                        bArr5 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr5, 0);
                        i13--;
                    }
                    int i14 = this.mdsize;
                    System.arraycopy(bArr5, 0, bArr2, i10 * i14, i14);
                    bArr4[i11] = (byte) (bArr4[i11] >>> this.w);
                    i10++;
                }
            }
            int i15 = (this.messagesize << this.w) - i9;
            int i16 = 0;
            while (i16 < this.checksumsize) {
                System.arraycopy(this.privateKeyOTS[i10], 0, bArr5, 0, this.mdsize);
                for (int i17 = i15 & i8; i17 > 0; i17--) {
                    this.messDigestOTS.update(bArr5, 0, bArr5.length);
                    bArr5 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr5, 0);
                }
                int i18 = this.mdsize;
                System.arraycopy(bArr5, 0, bArr2, i10 * i18, i18);
                int i19 = this.w;
                i15 >>>= i19;
                i10++;
                i16 += i19;
            }
        } else if (i5 < 8) {
            int i20 = this.mdsize;
            int i21 = i20 / i5;
            int i22 = (1 << i5) - 1;
            byte[] bArr6 = new byte[i20];
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            while (i23 < i21) {
                long j2 = 0;
                for (int i27 = 0; i27 < this.w; i27++) {
                    j2 ^= (bArr4[i24] & 255) << (i27 << 3);
                    i24++;
                }
                int i28 = 0;
                while (i28 < i6) {
                    int i29 = i21;
                    int i30 = (int) (j2 & i22);
                    i26 += i30;
                    System.arraycopy(this.privateKeyOTS[i25], 0, bArr6, 0, this.mdsize);
                    while (i30 > 0) {
                        this.messDigestOTS.update(bArr6, 0, bArr6.length);
                        bArr6 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr6, 0);
                        i30--;
                    }
                    int i31 = this.mdsize;
                    System.arraycopy(bArr6, 0, bArr2, i25 * i31, i31);
                    j2 >>>= this.w;
                    i25++;
                    i28++;
                    i21 = i29;
                    i6 = 8;
                }
                i23++;
                i6 = 8;
            }
            int i32 = this.mdsize % this.w;
            int i33 = 0;
            long j3 = 0;
            while (i33 < i32) {
                j3 ^= (bArr4[i24] & 255) << (i33 << 3);
                i24++;
                i33++;
                i32 = i32;
            }
            int i34 = i32 << 3;
            int i35 = 0;
            while (i35 < i34) {
                int i36 = (int) (i22 & j3);
                i26 += i36;
                System.arraycopy(this.privateKeyOTS[i25], 0, bArr6, 0, this.mdsize);
                while (i36 > 0) {
                    this.messDigestOTS.update(bArr6, 0, bArr6.length);
                    bArr6 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr6, 0);
                    i36--;
                }
                int i37 = this.mdsize;
                System.arraycopy(bArr6, 0, bArr2, i25 * i37, i37);
                int i38 = this.w;
                j3 >>>= i38;
                i25++;
                i35 += i38;
            }
            int i39 = (this.messagesize << this.w) - i26;
            int i40 = 0;
            while (i40 < this.checksumsize) {
                System.arraycopy(this.privateKeyOTS[i25], 0, bArr6, 0, this.mdsize);
                for (int i41 = i39 & i22; i41 > 0; i41--) {
                    this.messDigestOTS.update(bArr6, 0, bArr6.length);
                    bArr6 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr6, 0);
                }
                int i42 = this.mdsize;
                System.arraycopy(bArr6, 0, bArr2, i25 * i42, i42);
                int i43 = this.w;
                i39 >>>= i43;
                i25++;
                i40 += i43;
            }
        } else if (i5 < 57) {
            int i44 = this.mdsize;
            int i45 = (i44 << 3) - i5;
            int i46 = (1 << i5) - 1;
            byte[] bArr7 = new byte[i44];
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            while (i48 <= i45) {
                int i50 = i48 % 8;
                i48 += this.w;
                int i51 = 0;
                long j4 = 0;
                for (int i52 = i48 >>> 3; i52 < ((i48 + 7) >>> 3); i52++) {
                    j4 ^= (bArr4[i52] & 255) << (i51 << 3);
                    i51++;
                }
                long j5 = (j4 >>> i50) & i46;
                i47 = (int) (i47 + j5);
                System.arraycopy(this.privateKeyOTS[i49], 0, bArr7, 0, this.mdsize);
                while (j5 > 0) {
                    this.messDigestOTS.update(bArr7, 0, bArr7.length);
                    bArr7 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr7, 0);
                    j5--;
                }
                int i53 = this.mdsize;
                System.arraycopy(bArr7, 0, bArr2, i49 * i53, i53);
                i49++;
            }
            int i54 = i48 >>> 3;
            if (i54 < this.mdsize) {
                int i55 = i48 % 8;
                int i56 = 0;
                long j6 = 0;
                while (true) {
                    i2 = this.mdsize;
                    if (i54 >= i2) {
                        break;
                    }
                    j6 ^= (bArr4[i54] & 255) << (i56 << 3);
                    i56++;
                    i54++;
                }
                long j7 = (j6 >>> i55) & i46;
                i47 = (int) (i47 + j7);
                System.arraycopy(this.privateKeyOTS[i49], 0, bArr7, 0, i2);
                while (j7 > 0) {
                    this.messDigestOTS.update(bArr7, 0, bArr7.length);
                    bArr7 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr7, 0);
                    j7--;
                }
                int i57 = this.mdsize;
                System.arraycopy(bArr7, 0, bArr2, i49 * i57, i57);
                i49++;
            }
            int i58 = (this.messagesize << this.w) - i47;
            int i59 = i49;
            int i60 = 0;
            while (i60 < this.checksumsize) {
                System.arraycopy(this.privateKeyOTS[i59], 0, bArr7, 0, this.mdsize);
                for (long j8 = i58 & i46; j8 > 0; j8--) {
                    this.messDigestOTS.update(bArr7, 0, bArr7.length);
                    bArr7 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr7, 0);
                }
                int i61 = this.mdsize;
                System.arraycopy(bArr7, 0, bArr2, i59 * i61, i61);
                int i62 = this.w;
                i58 >>>= i62;
                i59++;
                i60 += i62;
            }
        }
        return bArr2;
    }
}