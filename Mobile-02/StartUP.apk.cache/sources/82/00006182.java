package org.spongycastle.crypto.agreement.srp;

import java.math.BigInteger;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.SRP6GroupParameters;

/* loaded from: classes3.dex */
public class SRP6VerifierGenerator {
    protected BigInteger N;
    protected Digest digest;

    /* renamed from: g  reason: collision with root package name */
    protected BigInteger f17791g;

    public BigInteger generateVerifier(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return this.f17791g.modPow(SRP6Util.calculateX(this.digest, this.N, bArr, bArr2, bArr3), this.N);
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest) {
        this.N = bigInteger;
        this.f17791g = bigInteger2;
        this.digest = digest;
    }

    public void init(SRP6GroupParameters sRP6GroupParameters, Digest digest) {
        this.N = sRP6GroupParameters.getN();
        this.f17791g = sRP6GroupParameters.getG();
        this.digest = digest;
    }
}