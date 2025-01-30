package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

/* loaded from: classes3.dex */
public class McEliecePublicKeySpec implements KeySpec {

    /* renamed from: g  reason: collision with root package name */
    private GF2Matrix f17877g;
    private int n;
    private String oid;
    private int t;

    public McEliecePublicKeySpec(String str, int i2, int i3, GF2Matrix gF2Matrix) {
        this.oid = str;
        this.n = i2;
        this.t = i3;
        this.f17877g = new GF2Matrix(gF2Matrix);
    }

    public GF2Matrix getG() {
        return this.f17877g;
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

    public McEliecePublicKeySpec(String str, int i2, int i3, byte[] bArr) {
        this.oid = str;
        this.n = i3;
        this.t = i2;
        this.f17877g = new GF2Matrix(bArr);
    }
}