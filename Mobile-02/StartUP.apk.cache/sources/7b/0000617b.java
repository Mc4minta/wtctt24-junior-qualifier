package org.spongycastle.crypto.agreement.kdf;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.DerivationParameters;

/* loaded from: classes3.dex */
public class DHKDFParameters implements DerivationParameters {
    private ASN1ObjectIdentifier algorithm;
    private byte[] extraInfo;
    private int keySize;
    private byte[] z;

    public DHKDFParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i2, byte[] bArr) {
        this(aSN1ObjectIdentifier, i2, bArr, null);
    }

    public ASN1ObjectIdentifier getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getExtraInfo() {
        return this.extraInfo;
    }

    public int getKeySize() {
        return this.keySize;
    }

    public byte[] getZ() {
        return this.z;
    }

    public DHKDFParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i2, byte[] bArr, byte[] bArr2) {
        this.algorithm = aSN1ObjectIdentifier;
        this.keySize = i2;
        this.z = bArr;
        this.extraInfo = bArr2;
    }
}