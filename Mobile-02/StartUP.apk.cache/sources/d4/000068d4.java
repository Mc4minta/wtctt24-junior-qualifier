package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PrivateKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.asn1.McEliecePrivateKey;
import org.spongycastle.pqc.crypto.mceliece.McElieceParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.spongycastle.pqc.jcajce.spec.McEliecePrivateKeySpec;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

/* loaded from: classes3.dex */
public class BCMcEliecePrivateKey implements CipherParameters, PrivateKey {
    private static final long serialVersionUID = 1;
    private GF2mField field;
    private PolynomialGF2mSmallM goppaPoly;

    /* renamed from: h  reason: collision with root package name */
    private GF2Matrix f17870h;

    /* renamed from: k  reason: collision with root package name */
    private int f17871k;
    private McElieceParameters mcElieceParams;
    private int n;
    private String oid;
    private Permutation p1;
    private Permutation p2;
    private PolynomialGF2mSmallM[] qInv;
    private GF2Matrix sInv;

    public BCMcEliecePrivateKey(String str, int i2, int i3, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, GF2Matrix gF2Matrix, Permutation permutation, Permutation permutation2, GF2Matrix gF2Matrix2, PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        this.oid = str;
        this.n = i2;
        this.f17871k = i3;
        this.field = gF2mField;
        this.goppaPoly = polynomialGF2mSmallM;
        this.sInv = gF2Matrix;
        this.p1 = permutation;
        this.p2 = permutation2;
        this.f17870h = gF2Matrix2;
        this.qInv = polynomialGF2mSmallMArr;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BCMcEliecePrivateKey) {
            BCMcEliecePrivateKey bCMcEliecePrivateKey = (BCMcEliecePrivateKey) obj;
            return this.n == bCMcEliecePrivateKey.n && this.f17871k == bCMcEliecePrivateKey.f17871k && this.field.equals(bCMcEliecePrivateKey.field) && this.goppaPoly.equals(bCMcEliecePrivateKey.goppaPoly) && this.sInv.equals(bCMcEliecePrivateKey.sInv) && this.p1.equals(bCMcEliecePrivateKey.p1) && this.p2.equals(bCMcEliecePrivateKey.p2) && this.f17870h.equals(bCMcEliecePrivateKey.f17870h);
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
            try {
                return new PrivateKeyInfo(new AlgorithmIdentifier(getOID(), DERNull.INSTANCE), new McEliecePrivateKey(new ASN1ObjectIdentifier(this.oid), this.n, this.f17871k, this.field, this.goppaPoly, this.sInv, this.p1, this.p2, this.f17870h, this.qInv)).getEncoded();
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public GF2mField getField() {
        return this.field;
    }

    @Override // java.security.Key
    public String getFormat() {
        return null;
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return this.goppaPoly;
    }

    public GF2Matrix getH() {
        return this.f17870h;
    }

    public int getK() {
        return this.f17871k;
    }

    public McElieceParameters getMcElieceParameters() {
        return this.mcElieceParams;
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

    public Permutation getP1() {
        return this.p1;
    }

    public Permutation getP2() {
        return this.p2;
    }

    public PolynomialGF2mSmallM[] getQInv() {
        return this.qInv;
    }

    public GF2Matrix getSInv() {
        return this.sInv;
    }

    public int hashCode() {
        return this.f17871k + this.n + this.field.hashCode() + this.goppaPoly.hashCode() + this.sInv.hashCode() + this.p1.hashCode() + this.p2.hashCode() + this.f17870h.hashCode();
    }

    public String toString() {
        return (((((" length of the code          : " + this.n + "\n") + " dimension of the code       : " + this.f17871k + "\n") + " irreducible Goppa polynomial: " + this.goppaPoly + "\n") + " (k x k)-matrix S^-1         : " + this.sInv + "\n") + " permutation P1              : " + this.p1 + "\n") + " permutation P2              : " + this.p2;
    }

    public BCMcEliecePrivateKey(McEliecePrivateKeySpec mcEliecePrivateKeySpec) {
        this(mcEliecePrivateKeySpec.getOIDString(), mcEliecePrivateKeySpec.getN(), mcEliecePrivateKeySpec.getK(), mcEliecePrivateKeySpec.getField(), mcEliecePrivateKeySpec.getGoppaPoly(), mcEliecePrivateKeySpec.getSInv(), mcEliecePrivateKeySpec.getP1(), mcEliecePrivateKeySpec.getP2(), mcEliecePrivateKeySpec.getH(), mcEliecePrivateKeySpec.getQInv());
    }

    public BCMcEliecePrivateKey(McEliecePrivateKeyParameters mcEliecePrivateKeyParameters) {
        this(mcEliecePrivateKeyParameters.getOIDString(), mcEliecePrivateKeyParameters.getN(), mcEliecePrivateKeyParameters.getK(), mcEliecePrivateKeyParameters.getField(), mcEliecePrivateKeyParameters.getGoppaPoly(), mcEliecePrivateKeyParameters.getSInv(), mcEliecePrivateKeyParameters.getP1(), mcEliecePrivateKeyParameters.getP2(), mcEliecePrivateKeyParameters.getH(), mcEliecePrivateKeyParameters.getQInv());
        this.mcElieceParams = mcEliecePrivateKeyParameters.getParameters();
    }
}