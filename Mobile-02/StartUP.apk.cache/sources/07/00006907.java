package org.spongycastle.pqc.jcajce.spec;

import org.spongycastle.pqc.crypto.gmss.GMSSParameters;

/* loaded from: classes3.dex */
public class GMSSPublicKeySpec extends GMSSKeySpec {
    private byte[] gmssPublicKey;

    public GMSSPublicKeySpec(byte[] bArr, GMSSParameters gMSSParameters) {
        super(gMSSParameters);
        this.gmssPublicKey = bArr;
    }

    public byte[] getPublicKey() {
        return this.gmssPublicKey;
    }
}