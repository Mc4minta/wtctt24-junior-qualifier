package org.spongycastle.crypto.prng;

/* loaded from: classes3.dex */
public interface RandomGenerator {
    void addSeedMaterial(long j2);

    void addSeedMaterial(byte[] bArr);

    void nextBytes(byte[] bArr);

    void nextBytes(byte[] bArr, int i2, int i3);
}