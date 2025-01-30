package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA256Digest;

/* loaded from: classes3.dex */
public class McElieceCCA2Parameters extends McElieceParameters {
    public Digest digest;

    public McElieceCCA2Parameters() {
        this.digest = new SHA256Digest();
    }

    public Digest getDigest() {
        return this.digest;
    }

    public McElieceCCA2Parameters(int i2, int i3) {
        super(i2, i3);
        this.digest = new SHA256Digest();
    }

    public McElieceCCA2Parameters(Digest digest) {
        this.digest = digest;
    }
}