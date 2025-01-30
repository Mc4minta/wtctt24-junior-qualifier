package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PublicKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.asn1.McEliecePublicKey;
import org.spongycastle.pqc.crypto.mceliece.McElieceParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.McEliecePublicKeySpec;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

/* loaded from: classes3.dex */
public class BCMcEliecePublicKey implements CipherParameters, PublicKey {
    private static final long serialVersionUID = 1;
    private McElieceParameters McElieceParams;

    /* renamed from: g  reason: collision with root package name */
    private GF2Matrix f17872g;
    private int n;
    private String oid;
    private int t;

    public BCMcEliecePublicKey(String str, int i2, int i3, GF2Matrix gF2Matrix) {
        this.oid = str;
        this.n = i2;
        this.t = i3;
        this.f17872g = gF2Matrix;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BCMcEliecePublicKey) {
            BCMcEliecePublicKey bCMcEliecePublicKey = (BCMcEliecePublicKey) obj;
            return this.n == bCMcEliecePublicKey.n && this.t == bCMcEliecePublicKey.t && this.f17872g.equals(bCMcEliecePublicKey.f17872g);
        }
        return false;
    }

    protected ASN1Primitive getAlgParams() {
        return null;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(getOID(), DERNull.INSTANCE), new McEliecePublicKey(new ASN1ObjectIdentifier(this.oid), this.n, this.t, this.f17872g)).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return null;
    }

    public GF2Matrix getG() {
        return this.f17872g;
    }

    public int getK() {
        return this.f17872g.getNumRows();
    }

    public McElieceParameters getMcElieceParameters() {
        return this.McElieceParams;
    }

    public int getN() {
        return this.n;
    }

    protected ASN1ObjectIdentifier getOID() {
        return new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.1");
    }

    public String getOIDString() {
        return this.oid;
    }

    public int getT() {
        return this.t;
    }

    public int hashCode() {
        return this.n + this.t + this.f17872g.hashCode();
    }

    public String toString() {
        return (("McEliecePublicKey:\n length of the code         : " + this.n + "\n") + " error correction capability: " + this.t + "\n") + " generator matrix           : " + this.f17872g.toString();
    }

    public BCMcEliecePublicKey(McEliecePublicKeySpec mcEliecePublicKeySpec) {
        this(mcEliecePublicKeySpec.getOIDString(), mcEliecePublicKeySpec.getN(), mcEliecePublicKeySpec.getT(), mcEliecePublicKeySpec.getG());
    }

    public BCMcEliecePublicKey(McEliecePublicKeyParameters mcEliecePublicKeyParameters) {
        this(mcEliecePublicKeyParameters.getOIDString(), mcEliecePublicKeyParameters.getN(), mcEliecePublicKeyParameters.getT(), mcEliecePublicKeyParameters.getG());
        this.McElieceParams = mcEliecePublicKeyParameters.getParameters();
    }
}