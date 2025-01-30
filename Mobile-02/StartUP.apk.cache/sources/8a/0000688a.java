package org.spongycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.util.Vector;
import org.spongycastle.crypto.Digest;
import org.spongycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.spongycastle.pqc.crypto.gmss.util.WinternitzOTSignature;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class GMSSPrivateKeyParameters extends GMSSKeyParameters {
    private int[] K;
    private byte[][][] currentAuthPaths;
    private Vector[][] currentRetain;
    private byte[][] currentRootSig;
    private byte[][] currentSeeds;
    private Vector[] currentStack;
    private Treehash[][] currentTreehash;
    private GMSSDigestProvider digestProvider;
    private GMSSParameters gmssPS;
    private GMSSRandom gmssRandom;
    private int[] heightOfTrees;
    private int[] index;
    private byte[][][] keep;
    private int mdLength;
    private Digest messDigestTrees;
    private int[] minTreehash;
    private byte[][][] nextAuthPaths;
    private GMSSLeaf[] nextNextLeaf;
    private GMSSRootCalc[] nextNextRoot;
    private byte[][] nextNextSeeds;
    private Vector[][] nextRetain;
    private byte[][] nextRoot;
    private GMSSRootSig[] nextRootSig;
    private Vector[] nextStack;
    private Treehash[][] nextTreehash;
    private int numLayer;
    private int[] numLeafs;
    private int[] otsIndex;
    private GMSSLeaf[] upperLeaf;
    private GMSSLeaf[] upperTreehashLeaf;
    private boolean used;

    public GMSSPrivateKeyParameters(byte[][] bArr, byte[][] bArr2, byte[][][] bArr3, byte[][][] bArr4, Treehash[][] treehashArr, Treehash[][] treehashArr2, Vector[] vectorArr, Vector[] vectorArr2, Vector[][] vectorArr3, Vector[][] vectorArr4, byte[][] bArr5, byte[][] bArr6, GMSSParameters gMSSParameters, GMSSDigestProvider gMSSDigestProvider) {
        this(null, bArr, bArr2, bArr3, bArr4, null, treehashArr, treehashArr2, vectorArr, vectorArr2, vectorArr3, vectorArr4, null, null, null, null, bArr5, null, bArr6, null, gMSSParameters, gMSSDigestProvider);
    }

    private void computeAuthPaths(int i2) {
        int i3;
        int i4;
        byte[] bArr;
        int i5 = this.index[i2];
        int i6 = this.heightOfTrees[i2];
        int i7 = this.K[i2];
        int i8 = 0;
        while (true) {
            i3 = i6 - i7;
            if (i8 >= i3) {
                break;
            }
            this.currentTreehash[i2][i8].updateNextSeed(this.gmssRandom);
            i8++;
        }
        int heightOfPhi = heightOfPhi(i5);
        byte[] bArr2 = new byte[this.mdLength];
        byte[] nextSeed = this.gmssRandom.nextSeed(this.currentSeeds[i2]);
        int i9 = (i5 >>> (heightOfPhi + 1)) & 1;
        int i10 = this.mdLength;
        byte[] bArr3 = new byte[i10];
        int i11 = i6 - 1;
        if (heightOfPhi < i11 && i9 == 0) {
            System.arraycopy(this.currentAuthPaths[i2][heightOfPhi], 0, bArr3, 0, i10);
        }
        int i12 = this.mdLength;
        byte[] bArr4 = new byte[i12];
        if (heightOfPhi == 0) {
            if (i2 == this.numLayer - 1) {
                bArr = new WinternitzOTSignature(nextSeed, this.digestProvider.get(), this.otsIndex[i2]).getPublicKey();
            } else {
                byte[] bArr5 = new byte[i12];
                System.arraycopy(this.currentSeeds[i2], 0, bArr5, 0, i12);
                this.gmssRandom.nextSeed(bArr5);
                byte[] leaf = this.upperLeaf[i2].getLeaf();
                this.upperLeaf[i2].initLeafCalc(bArr5);
                bArr = leaf;
            }
            System.arraycopy(bArr, 0, this.currentAuthPaths[i2][0], 0, this.mdLength);
        } else {
            int i13 = i12 << 1;
            byte[] bArr6 = new byte[i13];
            System.arraycopy(this.currentAuthPaths[i2][heightOfPhi - 1], 0, bArr6, 0, i12);
            byte[] bArr7 = this.keep[i2][(int) Math.floor(i4 / 2)];
            int i14 = this.mdLength;
            System.arraycopy(bArr7, 0, bArr6, i14, i14);
            this.messDigestTrees.update(bArr6, 0, i13);
            this.currentAuthPaths[i2][heightOfPhi] = new byte[this.messDigestTrees.getDigestSize()];
            this.messDigestTrees.doFinal(this.currentAuthPaths[i2][heightOfPhi], 0);
            for (int i15 = 0; i15 < heightOfPhi; i15++) {
                if (i15 < i3) {
                    if (this.currentTreehash[i2][i15].wasFinished()) {
                        System.arraycopy(this.currentTreehash[i2][i15].getFirstNode(), 0, this.currentAuthPaths[i2][i15], 0, this.mdLength);
                        this.currentTreehash[i2][i15].destroy();
                    } else {
                        System.err.println("Treehash (" + i2 + "," + i15 + ") not finished when needed in AuthPathComputation");
                    }
                }
                if (i15 < i11 && i15 >= i3) {
                    int i16 = i15 - i3;
                    if (this.currentRetain[i2][i16].size() > 0) {
                        System.arraycopy(this.currentRetain[i2][i16].lastElement(), 0, this.currentAuthPaths[i2][i15], 0, this.mdLength);
                        Vector[][] vectorArr = this.currentRetain;
                        vectorArr[i2][i16].removeElementAt(vectorArr[i2][i16].size() - 1);
                    }
                }
                if (i15 < i3 && ((1 << i15) * 3) + i5 < this.numLeafs[i2]) {
                    this.currentTreehash[i2][i15].initialize();
                }
            }
        }
        if (heightOfPhi < i11 && i9 == 0) {
            System.arraycopy(bArr3, 0, this.keep[i2][(int) Math.floor(heightOfPhi / 2)], 0, this.mdLength);
        }
        if (i2 == this.numLayer - 1) {
            for (int i17 = 1; i17 <= i3 / 2; i17++) {
                int minTreehashIndex = getMinTreehashIndex(i2);
                if (minTreehashIndex >= 0) {
                    try {
                        byte[] bArr8 = new byte[this.mdLength];
                        System.arraycopy(this.currentTreehash[i2][minTreehashIndex].getSeedActive(), 0, bArr8, 0, this.mdLength);
                        this.currentTreehash[i2][minTreehashIndex].update(this.gmssRandom, new WinternitzOTSignature(this.gmssRandom.nextSeed(bArr8), this.digestProvider.get(), this.otsIndex[i2]).getPublicKey());
                    } catch (Exception e2) {
                        System.out.println(e2);
                    }
                }
            }
            return;
        }
        this.minTreehash[i2] = getMinTreehashIndex(i2);
    }

    private int getMinTreehashIndex(int i2) {
        int i3 = -1;
        for (int i4 = 0; i4 < this.heightOfTrees[i2] - this.K[i2]; i4++) {
            if (this.currentTreehash[i2][i4].wasInitialized() && !this.currentTreehash[i2][i4].wasFinished() && (i3 == -1 || this.currentTreehash[i2][i4].getLowestNodeHeight() < this.currentTreehash[i2][i3].getLowestNodeHeight())) {
                i3 = i4;
            }
        }
        return i3;
    }

    private int heightOfPhi(int i2) {
        if (i2 == 0) {
            return -1;
        }
        int i3 = 0;
        int i4 = 1;
        while (i2 % i4 == 0) {
            i4 *= 2;
            i3++;
        }
        return i3 - 1;
    }

    private void nextTree(int i2) {
        if (i2 > 0) {
            int[] iArr = this.index;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            int i4 = i2;
            boolean z = true;
            do {
                i4--;
                if (this.index[i4] < this.numLeafs[i4]) {
                    z = false;
                }
                if (!z) {
                    break;
                }
            } while (i4 > 0);
            if (z) {
                return;
            }
            this.gmssRandom.nextSeed(this.currentSeeds[i2]);
            this.nextRootSig[i3].updateSign();
            if (i2 > 1) {
                GMSSLeaf[] gMSSLeafArr = this.nextNextLeaf;
                int i5 = i3 - 1;
                gMSSLeafArr[i5] = gMSSLeafArr[i5].nextLeaf();
            }
            GMSSLeaf[] gMSSLeafArr2 = this.upperLeaf;
            gMSSLeafArr2[i3] = gMSSLeafArr2[i3].nextLeaf();
            if (this.minTreehash[i3] >= 0) {
                GMSSLeaf[] gMSSLeafArr3 = this.upperTreehashLeaf;
                gMSSLeafArr3[i3] = gMSSLeafArr3[i3].nextLeaf();
                try {
                    this.currentTreehash[i3][this.minTreehash[i3]].update(this.gmssRandom, this.upperTreehashLeaf[i3].getLeaf());
                    this.currentTreehash[i3][this.minTreehash[i3]].wasFinished();
                } catch (Exception e2) {
                    System.out.println(e2);
                }
            }
            updateNextNextAuthRoot(i2);
            this.currentRootSig[i3] = this.nextRootSig[i3].getSig();
            for (int i6 = 0; i6 < this.heightOfTrees[i2] - this.K[i2]; i6++) {
                Treehash[] treehashArr = this.currentTreehash[i2];
                Treehash[][] treehashArr2 = this.nextTreehash;
                treehashArr[i6] = treehashArr2[i3][i6];
                treehashArr2[i3][i6] = this.nextNextRoot[i3].getTreehash()[i6];
            }
            for (int i7 = 0; i7 < this.heightOfTrees[i2]; i7++) {
                System.arraycopy(this.nextAuthPaths[i3][i7], 0, this.currentAuthPaths[i2][i7], 0, this.mdLength);
                System.arraycopy(this.nextNextRoot[i3].getAuthPath()[i7], 0, this.nextAuthPaths[i3][i7], 0, this.mdLength);
            }
            for (int i8 = 0; i8 < this.K[i2] - 1; i8++) {
                Vector[] vectorArr = this.currentRetain[i2];
                Vector[][] vectorArr2 = this.nextRetain;
                vectorArr[i8] = vectorArr2[i3][i8];
                vectorArr2[i3][i8] = this.nextNextRoot[i3].getRetain()[i8];
            }
            Vector[] vectorArr3 = this.currentStack;
            Vector[] vectorArr4 = this.nextStack;
            vectorArr3[i2] = vectorArr4[i3];
            vectorArr4[i3] = this.nextNextRoot[i3].getStack();
            this.nextRoot[i3] = this.nextNextRoot[i3].getRoot();
            int i9 = this.mdLength;
            byte[] bArr = new byte[i9];
            byte[] bArr2 = new byte[i9];
            System.arraycopy(this.currentSeeds[i3], 0, bArr2, 0, i9);
            this.gmssRandom.nextSeed(bArr2);
            this.gmssRandom.nextSeed(bArr2);
            this.nextRootSig[i3].initSign(this.gmssRandom.nextSeed(bArr2), this.nextRoot[i3]);
            nextKey(i3);
        }
    }

    private void updateKey(int i2) {
        computeAuthPaths(i2);
        if (i2 > 0) {
            if (i2 > 1) {
                GMSSLeaf[] gMSSLeafArr = this.nextNextLeaf;
                int i3 = (i2 - 1) - 1;
                gMSSLeafArr[i3] = gMSSLeafArr[i3].nextLeaf();
            }
            GMSSLeaf[] gMSSLeafArr2 = this.upperLeaf;
            int i4 = i2 - 1;
            gMSSLeafArr2[i4] = gMSSLeafArr2[i4].nextLeaf();
            int floor = (int) Math.floor((getNumLeafs(i2) * 2) / (this.heightOfTrees[i4] - this.K[i4]));
            int[] iArr = this.index;
            if (iArr[i2] % floor == 1) {
                if (iArr[i2] > 1 && this.minTreehash[i4] >= 0) {
                    try {
                        this.currentTreehash[i4][this.minTreehash[i4]].update(this.gmssRandom, this.upperTreehashLeaf[i4].getLeaf());
                        this.currentTreehash[i4][this.minTreehash[i4]].wasFinished();
                    } catch (Exception e2) {
                        System.out.println(e2);
                    }
                }
                this.minTreehash[i4] = getMinTreehashIndex(i4);
                int[] iArr2 = this.minTreehash;
                if (iArr2[i4] >= 0) {
                    this.upperTreehashLeaf[i4] = new GMSSLeaf(this.digestProvider.get(), this.otsIndex[i4], floor, this.currentTreehash[i4][iArr2[i4]].getSeedActive());
                    GMSSLeaf[] gMSSLeafArr3 = this.upperTreehashLeaf;
                    gMSSLeafArr3[i4] = gMSSLeafArr3[i4].nextLeaf();
                }
            } else if (this.minTreehash[i4] >= 0) {
                GMSSLeaf[] gMSSLeafArr4 = this.upperTreehashLeaf;
                gMSSLeafArr4[i4] = gMSSLeafArr4[i4].nextLeaf();
            }
            this.nextRootSig[i4].updateSign();
            if (this.index[i2] == 1) {
                this.nextNextRoot[i4].initialize(new Vector());
            }
            updateNextNextAuthRoot(i2);
        }
    }

    private void updateNextNextAuthRoot(int i2) {
        byte[] bArr = new byte[this.mdLength];
        int i3 = i2 - 1;
        byte[] nextSeed = this.gmssRandom.nextSeed(this.nextNextSeeds[i3]);
        if (i2 == this.numLayer - 1) {
            this.nextNextRoot[i3].update(this.nextNextSeeds[i3], new WinternitzOTSignature(nextSeed, this.digestProvider.get(), this.otsIndex[i2]).getPublicKey());
            return;
        }
        this.nextNextRoot[i3].update(this.nextNextSeeds[i3], this.nextNextLeaf[i3].getLeaf());
        this.nextNextLeaf[i3].initLeafCalc(this.nextNextSeeds[i3]);
    }

    public byte[][][] getCurrentAuthPaths() {
        return Arrays.clone(this.currentAuthPaths);
    }

    public byte[][] getCurrentSeeds() {
        return Arrays.clone(this.currentSeeds);
    }

    public int[] getIndex() {
        return this.index;
    }

    public GMSSDigestProvider getName() {
        return this.digestProvider;
    }

    public int getNumLeafs(int i2) {
        return this.numLeafs[i2];
    }

    public byte[] getSubtreeRootSig(int i2) {
        return this.currentRootSig[i2];
    }

    public boolean isUsed() {
        return this.used;
    }

    public void markUsed() {
        this.used = true;
    }

    public GMSSPrivateKeyParameters nextKey() {
        GMSSPrivateKeyParameters gMSSPrivateKeyParameters = new GMSSPrivateKeyParameters(this);
        gMSSPrivateKeyParameters.nextKey(this.gmssPS.getNumOfLayers() - 1);
        return gMSSPrivateKeyParameters;
    }

    public GMSSPrivateKeyParameters(int[] iArr, byte[][] bArr, byte[][] bArr2, byte[][][] bArr3, byte[][][] bArr4, byte[][][] bArr5, Treehash[][] treehashArr, Treehash[][] treehashArr2, Vector[] vectorArr, Vector[] vectorArr2, Vector[][] vectorArr3, Vector[][] vectorArr4, GMSSLeaf[] gMSSLeafArr, GMSSLeaf[] gMSSLeafArr2, GMSSLeaf[] gMSSLeafArr3, int[] iArr2, byte[][] bArr6, GMSSRootCalc[] gMSSRootCalcArr, byte[][] bArr7, GMSSRootSig[] gMSSRootSigArr, GMSSParameters gMSSParameters, GMSSDigestProvider gMSSDigestProvider) {
        super(true, gMSSParameters);
        this.used = false;
        Digest digest = gMSSDigestProvider.get();
        this.messDigestTrees = digest;
        this.mdLength = digest.getDigestSize();
        this.gmssPS = gMSSParameters;
        this.otsIndex = gMSSParameters.getWinternitzParameter();
        this.K = gMSSParameters.getK();
        this.heightOfTrees = gMSSParameters.getHeightOfTrees();
        int numOfLayers = this.gmssPS.getNumOfLayers();
        this.numLayer = numOfLayers;
        if (iArr == null) {
            this.index = new int[numOfLayers];
            for (int i2 = 0; i2 < this.numLayer; i2++) {
                this.index[i2] = 0;
            }
        } else {
            this.index = iArr;
        }
        this.currentSeeds = bArr;
        this.nextNextSeeds = bArr2;
        this.currentAuthPaths = bArr3;
        this.nextAuthPaths = bArr4;
        int i3 = 2;
        if (bArr5 == null) {
            this.keep = new byte[this.numLayer][];
            int i4 = 0;
            while (i4 < this.numLayer) {
                this.keep[i4] = (byte[][]) Array.newInstance(byte.class, (int) Math.floor(this.heightOfTrees[i4] / i3), this.mdLength);
                i4++;
                i3 = 2;
            }
        } else {
            this.keep = bArr5;
        }
        if (vectorArr == null) {
            this.currentStack = new Vector[this.numLayer];
            for (int i5 = 0; i5 < this.numLayer; i5++) {
                this.currentStack[i5] = new Vector();
            }
        } else {
            this.currentStack = vectorArr;
        }
        if (vectorArr2 == null) {
            this.nextStack = new Vector[this.numLayer - 1];
            int i6 = 0;
            for (int i7 = 1; i6 < this.numLayer - i7; i7 = 1) {
                this.nextStack[i6] = new Vector();
                i6++;
            }
        } else {
            this.nextStack = vectorArr2;
        }
        this.currentTreehash = treehashArr;
        this.nextTreehash = treehashArr2;
        this.currentRetain = vectorArr3;
        this.nextRetain = vectorArr4;
        this.nextRoot = bArr6;
        this.digestProvider = gMSSDigestProvider;
        if (gMSSRootCalcArr == null) {
            this.nextNextRoot = new GMSSRootCalc[this.numLayer - 1];
            int i8 = 0;
            for (int i9 = 1; i8 < this.numLayer - i9; i9 = 1) {
                int i10 = i8 + 1;
                this.nextNextRoot[i8] = new GMSSRootCalc(this.heightOfTrees[i10], this.K[i10], this.digestProvider);
                i8 = i10;
            }
        } else {
            this.nextNextRoot = gMSSRootCalcArr;
        }
        this.currentRootSig = bArr7;
        this.numLeafs = new int[this.numLayer];
        for (int i11 = 0; i11 < this.numLayer; i11++) {
            this.numLeafs[i11] = 1 << this.heightOfTrees[i11];
        }
        this.gmssRandom = new GMSSRandom(this.messDigestTrees);
        int i12 = this.numLayer;
        if (i12 <= 1) {
            this.nextNextLeaf = new GMSSLeaf[0];
        } else if (gMSSLeafArr == null) {
            this.nextNextLeaf = new GMSSLeaf[i12 - 2];
            int i13 = 0;
            while (i13 < this.numLayer - 2) {
                int i14 = i13 + 1;
                this.nextNextLeaf[i13] = new GMSSLeaf(gMSSDigestProvider.get(), this.otsIndex[i14], this.numLeafs[i13 + 2], this.nextNextSeeds[i13]);
                i13 = i14;
            }
        } else {
            this.nextNextLeaf = gMSSLeafArr;
        }
        if (gMSSLeafArr2 == null) {
            this.upperLeaf = new GMSSLeaf[this.numLayer - 1];
            int i15 = 0;
            for (int i16 = 1; i15 < this.numLayer - i16; i16 = 1) {
                int i17 = i15 + 1;
                this.upperLeaf[i15] = new GMSSLeaf(gMSSDigestProvider.get(), this.otsIndex[i15], this.numLeafs[i17], this.currentSeeds[i15]);
                i15 = i17;
            }
        } else {
            this.upperLeaf = gMSSLeafArr2;
        }
        if (gMSSLeafArr3 == null) {
            this.upperTreehashLeaf = new GMSSLeaf[this.numLayer - 1];
            int i18 = 0;
            for (int i19 = 1; i18 < this.numLayer - i19; i19 = 1) {
                int i20 = i18 + 1;
                this.upperTreehashLeaf[i18] = new GMSSLeaf(gMSSDigestProvider.get(), this.otsIndex[i18], this.numLeafs[i20]);
                i18 = i20;
            }
        } else {
            this.upperTreehashLeaf = gMSSLeafArr3;
        }
        if (iArr2 == null) {
            this.minTreehash = new int[this.numLayer - 1];
            int i21 = 0;
            for (int i22 = 1; i21 < this.numLayer - i22; i22 = 1) {
                this.minTreehash[i21] = -1;
                i21++;
            }
        } else {
            this.minTreehash = iArr2;
        }
        int i23 = this.mdLength;
        byte[] bArr8 = new byte[i23];
        byte[] bArr9 = new byte[i23];
        if (gMSSRootSigArr == null) {
            this.nextRootSig = new GMSSRootSig[this.numLayer - 1];
            int i24 = 0;
            while (i24 < this.numLayer - 1) {
                System.arraycopy(bArr[i24], 0, bArr8, 0, this.mdLength);
                this.gmssRandom.nextSeed(bArr8);
                byte[] nextSeed = this.gmssRandom.nextSeed(bArr8);
                int i25 = i24 + 1;
                this.nextRootSig[i24] = new GMSSRootSig(gMSSDigestProvider.get(), this.otsIndex[i24], this.heightOfTrees[i25]);
                this.nextRootSig[i24].initSign(nextSeed, bArr6[i24]);
                i24 = i25;
            }
            return;
        }
        this.nextRootSig = gMSSRootSigArr;
    }

    public int getIndex(int i2) {
        return this.index[i2];
    }

    private void nextKey(int i2) {
        int i3 = this.numLayer;
        if (i2 == i3 - 1) {
            int[] iArr = this.index;
            iArr[i2] = iArr[i2] + 1;
        }
        if (this.index[i2] != this.numLeafs[i2]) {
            updateKey(i2);
        } else if (i3 != 1) {
            nextTree(i2);
            this.index[i2] = 0;
        }
    }

    private GMSSPrivateKeyParameters(GMSSPrivateKeyParameters gMSSPrivateKeyParameters) {
        super(true, gMSSPrivateKeyParameters.getParameters());
        this.used = false;
        this.index = Arrays.clone(gMSSPrivateKeyParameters.index);
        this.currentSeeds = Arrays.clone(gMSSPrivateKeyParameters.currentSeeds);
        this.nextNextSeeds = Arrays.clone(gMSSPrivateKeyParameters.nextNextSeeds);
        this.currentAuthPaths = Arrays.clone(gMSSPrivateKeyParameters.currentAuthPaths);
        this.nextAuthPaths = Arrays.clone(gMSSPrivateKeyParameters.nextAuthPaths);
        this.currentTreehash = gMSSPrivateKeyParameters.currentTreehash;
        this.nextTreehash = gMSSPrivateKeyParameters.nextTreehash;
        this.currentStack = gMSSPrivateKeyParameters.currentStack;
        this.nextStack = gMSSPrivateKeyParameters.nextStack;
        this.currentRetain = gMSSPrivateKeyParameters.currentRetain;
        this.nextRetain = gMSSPrivateKeyParameters.nextRetain;
        this.keep = Arrays.clone(gMSSPrivateKeyParameters.keep);
        this.nextNextLeaf = gMSSPrivateKeyParameters.nextNextLeaf;
        this.upperLeaf = gMSSPrivateKeyParameters.upperLeaf;
        this.upperTreehashLeaf = gMSSPrivateKeyParameters.upperTreehashLeaf;
        this.minTreehash = gMSSPrivateKeyParameters.minTreehash;
        this.gmssPS = gMSSPrivateKeyParameters.gmssPS;
        this.nextRoot = Arrays.clone(gMSSPrivateKeyParameters.nextRoot);
        this.nextNextRoot = gMSSPrivateKeyParameters.nextNextRoot;
        this.currentRootSig = gMSSPrivateKeyParameters.currentRootSig;
        this.nextRootSig = gMSSPrivateKeyParameters.nextRootSig;
        this.digestProvider = gMSSPrivateKeyParameters.digestProvider;
        this.heightOfTrees = gMSSPrivateKeyParameters.heightOfTrees;
        this.otsIndex = gMSSPrivateKeyParameters.otsIndex;
        this.K = gMSSPrivateKeyParameters.K;
        this.numLayer = gMSSPrivateKeyParameters.numLayer;
        this.messDigestTrees = gMSSPrivateKeyParameters.messDigestTrees;
        this.mdLength = gMSSPrivateKeyParameters.mdLength;
        this.gmssRandom = gMSSPrivateKeyParameters.gmssRandom;
        this.numLeafs = gMSSPrivateKeyParameters.numLeafs;
    }
}