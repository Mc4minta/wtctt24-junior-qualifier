package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PublicKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.asn1.McElieceCCA2PublicKey;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2Parameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2PublicKeySpec;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

/* loaded from: classes3.dex */
public class BCMcElieceCCA2PublicKey implements CipherParameters, PublicKey {
    private static final long serialVersionUID = 1;
    private McElieceCCA2Parameters McElieceCCA2Params;

    /* renamed from: g  reason: collision with root package name */
    private GF2Matrix f17869g;
    private int n;
    private String oid;
    private int t;

    public BCMcElieceCCA2PublicKey(String str, int i2, int i3, GF2Matrix gF2Matrix) {
        this.oid = str;
        this.n = i2;
        this.t = i3;
        this.f17869g = gF2Matrix;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCMcElieceCCA2PublicKey)) {
            return false;
        }
        BCMcElieceCCA2PublicKey bCMcElieceCCA2PublicKey = (BCMcElieceCCA2PublicKey) obj;
        return this.n == bCMcElieceCCA2PublicKey.n && this.t == bCMcElieceCCA2PublicKey.t && this.f17869g.equals(bCMcElieceCCA2PublicKey.f17869g);
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
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(getOID(), DERNull.INSTANCE), new McElieceCCA2PublicKey(new ASN1ObjectIdentifier(this.oid), this.n, this.t, this.f17869g)).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return null;
    }

    public GF2Matrix getG() {
        return this.f17869g;
    }

    public int getK() {
        return this.f17869g.getNumRows();
    }

    public McElieceCCA2Parameters getMcElieceCCA2Parameters() {
        return this.McElieceCCA2Params;
    }

    public int getN() {
        return this.n;
    }

    protected ASN1ObjectIdentifier getOID() {
        return new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2");
    }

    public String getOIDString() {
        return this.oid;
    }

    public int getT() {
        return this.t;
    }

    public int hashCode() {
        return this.n + this.t + this.f17869g.hashCode();
    }

    public String toString() {
        return (("McEliecePublicKey:\n length of the code         : " + this.n + "\n") + " error correction capability: " + this.t + "\n") + " generator matrix           : " + this.f17869g.toString();
    }

    public BCMcElieceCCA2PublicKey(McElieceCCA2PublicKeySpec mcElieceCCA2PublicKeySpec) {
        this(mcElieceCCA2PublicKeySpec.getOIDString(), mcElieceCCA2PublicKeySpec.getN(), mcElieceCCA2PublicKeySpec.getT(), mcElieceCCA2PublicKeySpec.getMatrixG());
    }

    public BCMcElieceCCA2PublicKey(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters) {
        this(mcElieceCCA2PublicKeyParameters.getOIDString(), mcElieceCCA2PublicKeyParameters.getN(), mcElieceCCA2PublicKeyParameters.getT(), mcElieceCCA2PublicKeyParameters.getMatrixG());
        this.McElieceCCA2Params = mcElieceCCA2PublicKeyParameters.getParameters();
    }
}