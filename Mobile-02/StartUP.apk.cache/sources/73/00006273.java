package org.spongycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public class Tables8kGCMMultiplier implements GCMMultiplier {
    private byte[] H;
    private int[][][] M;

    @Override // org.spongycastle.crypto.modes.gcm.GCMMultiplier
    public void init(byte[] bArr) {
        if (this.M == null) {
            this.M = (int[][][]) Array.newInstance(int.class, 32, 16, 4);
        } else if (Arrays.areEqual(this.H, bArr)) {
            return;
        }
        this.H = Arrays.clone(bArr);
        GCMUtil.asInts(bArr, this.M[1][8]);
        for (int i2 = 4; i2 >= 1; i2 >>= 1) {
            int[][][] iArr = this.M;
            GCMUtil.multiplyP(iArr[1][i2 + i2], iArr[1][i2]);
        }
        int[][][] iArr2 = this.M;
        int i3 = 0;
        GCMUtil.multiplyP(iArr2[1][1], iArr2[0][8]);
        for (int i4 = 4; i4 >= 1; i4 >>= 1) {
            int[][][] iArr3 = this.M;
            GCMUtil.multiplyP(iArr3[0][i4 + i4], iArr3[0][i4]);
        }
        while (true) {
            for (int i5 = 2; i5 < 16; i5 += i5) {
                for (int i6 = 1; i6 < i5; i6++) {
                    int[][][] iArr4 = this.M;
                    GCMUtil.xor(iArr4[i3][i5], iArr4[i3][i6], iArr4[i3][i5 + i6]);
                }
            }
            i3++;
            if (i3 == 32) {
                return;
            }
            if (i3 > 1) {
                for (int i7 = 8; i7 > 0; i7 >>= 1) {
                    int[][][] iArr5 = this.M;
                    GCMUtil.multiplyP8(iArr5[i3 - 2][i7], iArr5[i3][i7]);
                }
            }
        }
    }

    @Override // org.spongycastle.crypto.modes.gcm.GCMMultiplier
    public void multiplyH(byte[] bArr) {
        int[] iArr = new int[4];
        for (int i2 = 15; i2 >= 0; i2--) {
            int[][][] iArr2 = this.M;
            int i3 = i2 + i2;
            int[] iArr3 = iArr2[i3][bArr[i2] & 15];
            iArr[0] = iArr[0] ^ iArr3[0];
            iArr[1] = iArr[1] ^ iArr3[1];
            iArr[2] = iArr[2] ^ iArr3[2];
            iArr[3] = iArr3[3] ^ iArr[3];
            int[] iArr4 = iArr2[i3 + 1][(bArr[i2] & 240) >>> 4];
            iArr[0] = iArr[0] ^ iArr4[0];
            iArr[1] = iArr[1] ^ iArr4[1];
            iArr[2] = iArr[2] ^ iArr4[2];
            iArr[3] = iArr[3] ^ iArr4[3];
        }
        Pack.intToBigEndian(iArr, bArr, 0);
    }
}