package org.spongycastle.jcajce.spec;

import javax.crypto.spec.PBEKeySpec;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

/* loaded from: classes3.dex */
public class PBKDF2KeySpec extends PBEKeySpec {
    private AlgorithmIdentifier prf;

    public PBKDF2KeySpec(char[] cArr, byte[] bArr, int i2, int i3, AlgorithmIdentifier algorithmIdentifier) {
        super(cArr, bArr, i2, i3);
        this.prf = algorithmIdentifier;
    }

    public AlgorithmIdentifier getPrf() {
        return this.prf;
    }
}