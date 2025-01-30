package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

/* loaded from: classes3.dex */
public class McElieceCCA2PublicKeySpec implements KeySpec {
    private GF2Matrix matrixG;
    private int n;
    private String oid;
    private int t;

    public McElieceCCA2PublicKeySpec(String str, int i2, int i3, GF2Matrix gF2Matrix) {
        this.oid = str;
        this.n = i2;
        this.t = i3;
        this.matrixG = new GF2Matrix(gF2Matrix);
    }

    public GF2Matrix getMatrixG() {
        return this.matrixG;
    }

    public int getN() {
        return this.n;
    }

    public String getOIDString() {
        return this.oid;
    }

    public int getT() {
        return this.t;
    }

    public McElieceCCA2PublicKeySpec(String str, int i2, int i3, byte[] bArr) {
        this.oid = str;
        this.n = i2;
        this.t = i3;
        this.matrixG = new GF2Matrix(bArr);
    }
}