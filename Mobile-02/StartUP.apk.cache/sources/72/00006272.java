package org.spongycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public class Tables64kGCMMultiplier implements GCMMultiplier {
    private byte[] H;
    private int[][][] M;

    @Override // org.spongycastle.crypto.modes.gcm.GCMMultiplier
    public void init(byte[] bArr) {
        if (this.M == null) {
            this.M = (int[][][]) Array.newInstance(int.class, 16, 256, 4);
        } else if (Arrays.areEqual(this.H, bArr)) {
            return;
        }
        this.H = Arrays.clone(bArr);
        int i2 = 0;
        GCMUtil.asInts(bArr, this.M[0][128]);
        for (int i3 = 64; i3 >= 1; i3 >>= 1) {
            int[][][] iArr = this.M;
            GCMUtil.multiplyP(iArr[0][i3 + i3], iArr[0][i3]);
        }
        while (true) {
            for (int i4 = 2; i4 < 256; i4 += i4) {
                for (int i5 = 1; i5 < i4; i5++) {
                    int[][][] iArr2 = this.M;
                    GCMUtil.xor(iArr2[i2][i4], iArr2[i2][i5], iArr2[i2][i4 + i5]);
                }
            }
            i2++;
            if (i2 == 16) {
                return;
            }
            for (int i6 = 128; i6 > 0; i6 >>= 1) {
                int[][][] iArr3 = this.M;
                GCMUtil.multiplyP8(iArr3[i2 - 1][i6], iArr3[i2][i6]);
            }
        }
    }

    @Override // org.spongycastle.crypto.modes.gcm.GCMMultiplier
    public void multiplyH(byte[] bArr) {
        int[] iArr = new int[4];
        for (int i2 = 15; i2 >= 0; i2--) {
            int[] iArr2 = this.M[i2][bArr[i2] & 255];
            iArr[0] = iArr[0] ^ iArr2[0];
            iArr[1] = iArr[1] ^ iArr2[1];
            iArr[2] = iArr[2] ^ iArr2[2];
            iArr[3] = iArr2[3] ^ iArr[3];
        }
        Pack.intToBigEndian(iArr, bArr, 0);
    }
}