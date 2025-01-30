package org.spongycastle.pqc.crypto.gmss;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class GMSSUtils {
    GMSSUtils() {
    }

    static GMSSLeaf[] clone(GMSSLeaf[] gMSSLeafArr) {
        if (gMSSLeafArr == null) {
            return null;
        }
        GMSSLeaf[] gMSSLeafArr2 = new GMSSLeaf[gMSSLeafArr.length];
        System.arraycopy(gMSSLeafArr, 0, gMSSLeafArr2, 0, gMSSLeafArr.length);
        return gMSSLeafArr2;
    }

    static GMSSRootCalc[] clone(GMSSRootCalc[] gMSSRootCalcArr) {
        if (gMSSRootCalcArr == null) {
            return null;
        }
        GMSSRootCalc[] gMSSRootCalcArr2 = new GMSSRootCalc[gMSSRootCalcArr.length];
        System.arraycopy(gMSSRootCalcArr, 0, gMSSRootCalcArr2, 0, gMSSRootCalcArr.length);
        return gMSSRootCalcArr2;
    }

    static GMSSRootSig[] clone(GMSSRootSig[] gMSSRootSigArr) {
        if (gMSSRootSigArr == null) {
            return null;
        }
        GMSSRootSig[] gMSSRootSigArr2 = new GMSSRootSig[gMSSRootSigArr.length];
        System.arraycopy(gMSSRootSigArr, 0, gMSSRootSigArr2, 0, gMSSRootSigArr.length);
        return gMSSRootSigArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[][] clone(byte[][] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[][] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 != bArr.length; i2++) {
            bArr2[i2] = Arrays.clone(bArr[i2]);
        }
        return bArr2;
    }

    static byte[][][] clone(byte[][][] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[][][] bArr2 = new byte[bArr.length][];
        for (int i2 = 0; i2 != bArr.length; i2++) {
            bArr2[i2] = clone(bArr[i2]);
        }
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Treehash[] clone(Treehash[] treehashArr) {
        if (treehashArr == null) {
            return null;
        }
        Treehash[] treehashArr2 = new Treehash[treehashArr.length];
        System.arraycopy(treehashArr, 0, treehashArr2, 0, treehashArr.length);
        return treehashArr2;
    }

    static Treehash[][] clone(Treehash[][] treehashArr) {
        if (treehashArr == null) {
            return null;
        }
        Treehash[][] treehashArr2 = new Treehash[treehashArr.length];
        for (int i2 = 0; i2 != treehashArr.length; i2++) {
            treehashArr2[i2] = clone(treehashArr[i2]);
        }
        return treehashArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Vector[] clone(Vector[] vectorArr) {
        if (vectorArr == null) {
            return null;
        }
        Vector[] vectorArr2 = new Vector[vectorArr.length];
        for (int i2 = 0; i2 != vectorArr.length; i2++) {
            vectorArr2[i2] = new Vector();
            Enumeration elements = vectorArr[i2].elements();
            while (elements.hasMoreElements()) {
                vectorArr2[i2].addElement(elements.nextElement());
            }
        }
        return vectorArr2;
    }

    static Vector[][] clone(Vector[][] vectorArr) {
        if (vectorArr == null) {
            return null;
        }
        Vector[][] vectorArr2 = new Vector[vectorArr.length];
        for (int i2 = 0; i2 != vectorArr.length; i2++) {
            vectorArr2[i2] = clone(vectorArr[i2]);
        }
        return vectorArr2;
    }
}