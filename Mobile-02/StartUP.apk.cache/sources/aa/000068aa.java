package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

/* loaded from: classes3.dex */
public class McEliecePublicKeyParameters extends McElieceKeyParameters {

    /* renamed from: g  reason: collision with root package name */
    private GF2Matrix f17856g;
    private int n;
    private String oid;
    private int t;

    public McEliecePublicKeyParameters(String str, int i2, int i3, GF2Matrix gF2Matrix, McElieceParameters mcElieceParameters) {
        super(false, mcElieceParameters);
        this.oid = str;
        this.n = i2;
        this.t = i3;
        this.f17856g = new GF2Matrix(gF2Matrix);
    }

    public GF2Matrix getG() {
        return this.f17856g;
    }

    public int getK() {
        return this.f17856g.getNumRows();
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

    public McEliecePublicKeyParameters(String str, int i2, int i3, byte[] bArr, McElieceParameters mcElieceParameters) {
        super(false, mcElieceParameters);
        this.oid = str;
        this.n = i3;
        this.t = i2;
        this.f17856g = new GF2Matrix(bArr);
    }
}