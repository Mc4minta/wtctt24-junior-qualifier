package org.spongycastle.crypto.modes.gcm;

import java.util.Vector;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class Tables1kGCMExponentiator implements GCMExponentiator {
    private Vector lookupPowX2;

    private void ensureAvailable(int i2) {
        int size = this.lookupPowX2.size();
        if (size <= i2) {
            int[] iArr = (int[]) this.lookupPowX2.elementAt(size - 1);
            do {
                iArr = Arrays.clone(iArr);
                GCMUtil.multiply(iArr, iArr);
                this.lookupPowX2.addElement(iArr);
                size++;
            } while (size <= i2);
        }
    }

    @Override // org.spongycastle.crypto.modes.gcm.GCMExponentiator
    public void exponentiateX(long j2, byte[] bArr) {
        int[] oneAsInts = GCMUtil.oneAsInts();
        int i2 = 0;
        while (j2 > 0) {
            if ((1 & j2) != 0) {
                ensureAvailable(i2);
                GCMUtil.multiply(oneAsInts, (int[]) this.lookupPowX2.elementAt(i2));
            }
            i2++;
            j2 >>>= 1;
        }
        GCMUtil.asBytes(oneAsInts, bArr);
    }

    @Override // org.spongycastle.crypto.modes.gcm.GCMExponentiator
    public void init(byte[] bArr) {
        int[] asInts = GCMUtil.asInts(bArr);
        Vector vector = this.lookupPowX2;
        if (vector == null || !Arrays.areEqual(asInts, (int[]) vector.elementAt(0))) {
            Vector vector2 = new Vector(8);
            this.lookupPowX2 = vector2;
            vector2.addElement(asInts);
        }
    }
}