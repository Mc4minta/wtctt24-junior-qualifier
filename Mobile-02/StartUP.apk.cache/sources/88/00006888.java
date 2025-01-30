package org.spongycastle.pqc.crypto.gmss;

import org.spongycastle.crypto.Digest;
import org.spongycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.encoders.Hex;

/* loaded from: classes3.dex */
public class GMSSLeaf {
    private byte[] concHashs;
    private GMSSRandom gmssRandom;

    /* renamed from: i  reason: collision with root package name */
    private int f17845i;

    /* renamed from: j  reason: collision with root package name */
    private int f17846j;
    private int keysize;
    private byte[] leaf;
    private int mdsize;
    private Digest messDigestOTS;
    byte[] privateKeyOTS;
    private byte[] seed;
    private int steps;
    private int two_power_w;
    private int w;

    public GMSSLeaf(Digest digest, byte[][] bArr, int[] iArr) {
        this.f17845i = iArr[0];
        this.f17846j = iArr[1];
        this.steps = iArr[2];
        this.w = iArr[3];
        this.messDigestOTS = digest;
        this.gmssRandom = new GMSSRandom(digest);
        int digestSize = this.messDigestOTS.getDigestSize();
        this.mdsize = digestSize;
        int ceil = (int) Math.ceil((digestSize << 3) / this.w);
        this.keysize = ceil + ((int) Math.ceil(getLog((ceil << this.w) + 1) / this.w));
        this.two_power_w = 1 << this.w;
        this.privateKeyOTS = bArr[0];
        this.seed = bArr[1];
        this.concHashs = bArr[2];
        this.leaf = bArr[3];
    }

    private int getLog(int i2) {
        int i3 = 1;
        int i4 = 2;
        while (i4 < i2) {
            i4 <<= 1;
            i3++;
        }
        return i3;
    }

    private void updateLeafCalc() {
        byte[] bArr = new byte[this.messDigestOTS.getDigestSize()];
        for (int i2 = 0; i2 < this.steps + 10000; i2++) {
            int i3 = this.f17845i;
            if (i3 == this.keysize && this.f17846j == this.two_power_w - 1) {
                Digest digest = this.messDigestOTS;
                byte[] bArr2 = this.concHashs;
                digest.update(bArr2, 0, bArr2.length);
                byte[] bArr3 = new byte[this.messDigestOTS.getDigestSize()];
                this.leaf = bArr3;
                this.messDigestOTS.doFinal(bArr3, 0);
                return;
            }
            if (i3 != 0 && this.f17846j != this.two_power_w - 1) {
                Digest digest2 = this.messDigestOTS;
                byte[] bArr4 = this.privateKeyOTS;
                digest2.update(bArr4, 0, bArr4.length);
                this.privateKeyOTS = bArr;
                this.messDigestOTS.doFinal(bArr, 0);
                int i4 = this.f17846j + 1;
                this.f17846j = i4;
                if (i4 == this.two_power_w - 1) {
                    byte[] bArr5 = this.privateKeyOTS;
                    byte[] bArr6 = this.concHashs;
                    int i5 = this.mdsize;
                    System.arraycopy(bArr5, 0, bArr6, (this.f17845i - 1) * i5, i5);
                }
            } else {
                this.f17845i = i3 + 1;
                this.f17846j = 0;
                this.privateKeyOTS = this.gmssRandom.nextSeed(this.seed);
            }
        }
        throw new IllegalStateException("unable to updateLeaf in steps: " + this.steps + " " + this.f17845i + " " + this.f17846j);
    }

    public byte[] getLeaf() {
        return Arrays.clone(this.leaf);
    }

    public byte[][] getStatByte() {
        int i2 = this.mdsize;
        byte[][] bArr = {new byte[i2], new byte[i2], new byte[this.keysize * i2], new byte[i2]};
        bArr[0] = this.privateKeyOTS;
        bArr[1] = this.seed;
        bArr[2] = this.concHashs;
        bArr[3] = this.leaf;
        return bArr;
    }

    public int[] getStatInt() {
        return new int[]{this.f17845i, this.f17846j, this.steps, this.w};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initLeafCalc(byte[] bArr) {
        this.f17845i = 0;
        this.f17846j = 0;
        byte[] bArr2 = new byte[this.mdsize];
        System.arraycopy(bArr, 0, bArr2, 0, this.seed.length);
        this.seed = this.gmssRandom.nextSeed(bArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GMSSLeaf nextLeaf() {
        GMSSLeaf gMSSLeaf = new GMSSLeaf(this);
        gMSSLeaf.updateLeafCalc();
        return gMSSLeaf;
    }

    public String toString() {
        String str = "";
        for (int i2 = 0; i2 < 4; i2++) {
            str = str + getStatInt()[i2] + " ";
        }
        String str2 = str + " " + this.mdsize + " " + this.keysize + " " + this.two_power_w + " ";
        byte[][] statByte = getStatByte();
        for (int i3 = 0; i3 < 4; i3++) {
            str2 = statByte[i3] != null ? str2 + new String(Hex.encode(statByte[i3])) + " " : str2 + "null ";
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GMSSLeaf(Digest digest, int i2, int i3) {
        int digestSize;
        int ceil;
        int ceil2;
        int i4;
        this.w = i2;
        this.messDigestOTS = digest;
        this.gmssRandom = new GMSSRandom(digest);
        this.mdsize = this.messDigestOTS.getDigestSize();
        double d2 = i2;
        this.keysize = ((int) Math.ceil((digestSize << 3) / d2)) + ((int) Math.ceil(getLog((ceil << i2) + 1) / d2));
        this.two_power_w = 1 << i2;
        this.steps = (int) Math.ceil(((((i4 - 1) * ceil2) + 1) + ceil2) / i3);
        int i5 = this.mdsize;
        this.seed = new byte[i5];
        this.leaf = new byte[i5];
        this.privateKeyOTS = new byte[i5];
        this.concHashs = new byte[i5 * this.keysize];
    }

    public GMSSLeaf(Digest digest, int i2, int i3, byte[] bArr) {
        int digestSize;
        int ceil;
        int ceil2;
        int i4;
        this.w = i2;
        this.messDigestOTS = digest;
        this.gmssRandom = new GMSSRandom(digest);
        this.mdsize = this.messDigestOTS.getDigestSize();
        double d2 = i2;
        this.keysize = ((int) Math.ceil((digestSize << 3) / d2)) + ((int) Math.ceil(getLog((ceil << i2) + 1) / d2));
        this.two_power_w = 1 << i2;
        this.steps = (int) Math.ceil(((((i4 - 1) * ceil2) + 1) + ceil2) / i3);
        int i5 = this.mdsize;
        this.seed = new byte[i5];
        this.leaf = new byte[i5];
        this.privateKeyOTS = new byte[i5];
        this.concHashs = new byte[i5 * this.keysize];
        initLeafCalc(bArr);
    }

    private GMSSLeaf(GMSSLeaf gMSSLeaf) {
        this.messDigestOTS = gMSSLeaf.messDigestOTS;
        this.mdsize = gMSSLeaf.mdsize;
        this.keysize = gMSSLeaf.keysize;
        this.gmssRandom = gMSSLeaf.gmssRandom;
        this.leaf = Arrays.clone(gMSSLeaf.leaf);
        this.concHashs = Arrays.clone(gMSSLeaf.concHashs);
        this.f17845i = gMSSLeaf.f17845i;
        this.f17846j = gMSSLeaf.f17846j;
        this.two_power_w = gMSSLeaf.two_power_w;
        this.w = gMSSLeaf.w;
        this.steps = gMSSLeaf.steps;
        this.seed = Arrays.clone(gMSSLeaf.seed);
        this.privateKeyOTS = Arrays.clone(gMSSLeaf.privateKeyOTS);
    }
}