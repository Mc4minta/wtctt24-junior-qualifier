package org.spongycastle.pqc.jcajce.provider.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.ShortBufferException;

/* loaded from: classes3.dex */
public abstract class AsymmetricHybridCipher extends CipherSpiExt {
    protected AlgorithmParameterSpec paramSpec;

    protected abstract int decryptOutputSize(int i2);

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final int doFinal(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws ShortBufferException, BadPaddingException {
        if (bArr2.length >= getOutputSize(i3)) {
            byte[] doFinal = doFinal(bArr, i2, i3);
            System.arraycopy(doFinal, 0, bArr2, i4, doFinal.length);
            return doFinal.length;
        }
        throw new ShortBufferException("Output buffer too short.");
    }

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    public abstract byte[] doFinal(byte[] bArr, int i2, int i3) throws BadPaddingException;

    protected abstract int encryptOutputSize(int i2);

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final int getBlockSize() {
        return 0;
    }

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final byte[] getIV() {
        return null;
    }

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final int getOutputSize(int i2) {
        return this.opMode == 1 ? encryptOutputSize(i2) : decryptOutputSize(i2);
    }

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final AlgorithmParameterSpec getParameters() {
        return this.paramSpec;
    }

    protected abstract void initCipherDecrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException;

    protected abstract void initCipherEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public final void initDecrypt(Key key) throws InvalidKeyException {
        try {
            initDecrypt(key, null);
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public final void initEncrypt(Key key) throws InvalidKeyException {
        try {
            initEncrypt(key, null, new SecureRandom());
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    protected final void setMode(String str) {
    }

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    protected final void setPadding(String str) {
    }

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final int update(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws ShortBufferException {
        if (bArr2.length >= getOutputSize(i3)) {
            byte[] update = update(bArr, i2, i3);
            System.arraycopy(update, 0, bArr2, i4, update.length);
            return update.length;
        }
        throw new ShortBufferException("output");
    }

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    public abstract byte[] update(byte[] bArr, int i2, int i3);

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final void initDecrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.opMode = 2;
        initCipherDecrypt(key, algorithmParameterSpec);
    }

    public final void initEncrypt(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            initEncrypt(key, null, secureRandom);
        } catch (InvalidAlgorithmParameterException unused) {
            throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
        }
    }

    public final void initEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        initEncrypt(key, algorithmParameterSpec, new SecureRandom());
    }

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final void initEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.opMode = 1;
        initCipherEncrypt(key, algorithmParameterSpec, secureRandom);
    }
}