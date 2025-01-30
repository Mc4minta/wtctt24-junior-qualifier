package org.spongycastle.crypto.params;

import java.math.BigInteger;

/* loaded from: classes3.dex */
public class CramerShoupPublicKeyParameters extends CramerShoupKeyParameters {

    /* renamed from: c  reason: collision with root package name */
    private BigInteger f17807c;

    /* renamed from: d  reason: collision with root package name */
    private BigInteger f17808d;

    /* renamed from: h  reason: collision with root package name */
    private BigInteger f17809h;

    public CramerShoupPublicKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        super(false, cramerShoupParameters);
        this.f17807c = bigInteger;
        this.f17808d = bigInteger2;
        this.f17809h = bigInteger3;
    }

    @Override // org.spongycastle.crypto.params.CramerShoupKeyParameters
    public boolean equals(Object obj) {
        if (obj instanceof CramerShoupPublicKeyParameters) {
            CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters = (CramerShoupPublicKeyParameters) obj;
            return cramerShoupPublicKeyParameters.getC().equals(this.f17807c) && cramerShoupPublicKeyParameters.getD().equals(this.f17808d) && cramerShoupPublicKeyParameters.getH().equals(this.f17809h) && super.equals(obj);
        }
        return false;
    }

    public BigInteger getC() {
        return this.f17807c;
    }

    public BigInteger getD() {
        return this.f17808d;
    }

    public BigInteger getH() {
        return this.f17809h;
    }

    @Override // org.spongycastle.crypto.params.CramerShoupKeyParameters
    public int hashCode() {
        return ((this.f17807c.hashCode() ^ this.f17808d.hashCode()) ^ this.f17809h.hashCode()) ^ super.hashCode();
    }
}