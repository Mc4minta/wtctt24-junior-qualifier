package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.SkeinEngine;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.SkeinParameters;

/* loaded from: classes3.dex */
public class SkeinMac implements Mac {
    public static final int SKEIN_1024 = 1024;
    public static final int SKEIN_256 = 256;
    public static final int SKEIN_512 = 512;
    private SkeinEngine engine;

    public SkeinMac(int i2, int i3) {
        this.engine = new SkeinEngine(i2, i3);
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i2) {
        return this.engine.doFinal(bArr, i2);
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        return "Skein-MAC-" + (this.engine.getBlockSize() * 8) + "-" + (this.engine.getOutputSize() * 8);
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return this.engine.getOutputSize();
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        SkeinParameters build;
        if (cipherParameters instanceof SkeinParameters) {
            build = (SkeinParameters) cipherParameters;
        } else if (cipherParameters instanceof KeyParameter) {
            build = new SkeinParameters.Builder().setKey(((KeyParameter) cipherParameters).getKey()).build();
        } else {
            throw new IllegalArgumentException("Invalid parameter passed to Skein MAC init - " + cipherParameters.getClass().getName());
        }
        if (build.getKey() != null) {
            this.engine.init(build);
            return;
        }
        throw new IllegalArgumentException("Skein MAC requires a key parameter.");
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        this.engine.reset();
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b2) {
        this.engine.update(b2);
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i2, int i3) {
        this.engine.update(bArr, i2, i3);
    }

    public SkeinMac(SkeinMac skeinMac) {
        this.engine = new SkeinEngine(skeinMac.engine);
    }
}