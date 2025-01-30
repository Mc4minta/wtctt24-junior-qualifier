package org.spongycastle.pqc.jcajce.provider.util;

import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;

/* loaded from: classes3.dex */
public abstract class AsymmetricBlockCipher extends CipherSpiExt {
    protected ByteArrayOutputStream buf = new ByteArrayOutputStream();
    protected int cipherTextSize;
    protected int maxPlainTextSize;
    protected AlgorithmParameterSpec paramSpec;

    protected void checkLength(int i2) throws IllegalBlockSizeException {
        int size = i2 + this.buf.size();
        int i3 = this.opMode;
        if (i3 == 1) {
            if (size <= this.maxPlainTextSize) {
                return;
            }
            throw new IllegalBlockSizeException("The length of the plaintext (" + size + " bytes) is not supported by the cipher (max. " + this.maxPlainTextSize + " bytes).");
        } else if (i3 != 2 || size == this.cipherTextSize) {
        } else {
            throw new IllegalBlockSizeException("Illegal ciphertext length (expected " + this.cipherTextSize + " bytes, was " + size + " bytes).");
        }
    }

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final byte[] doFinal(byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        checkLength(i3);
        update(bArr, i2, i3);
        byte[] byteArray = this.buf.toByteArray();
        this.buf.reset();
        int i4 = this.opMode;
        if (i4 != 1) {
            if (i4 != 2) {
                return null;
            }
            return messageDecrypt(byteArray);
        }
        return messageEncrypt(byteArray);
    }

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final int getBlockSize() {
        return this.opMode == 1 ? this.maxPlainTextSize : this.cipherTextSize;
    }

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final byte[] getIV() {
        return null;
    }

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final int getOutputSize(int i2) {
        int size = i2 + this.buf.size();
        int blockSize = getBlockSize();
        if (size > blockSize) {
            return 0;
        }
        return blockSize;
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

    protected abstract byte[] messageDecrypt(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException;

    protected abstract byte[] messageEncrypt(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException;

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    protected final void setMode(String str) {
    }

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    protected final void setPadding(String str) {
    }

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final byte[] update(byte[] bArr, int i2, int i3) {
        if (i3 != 0) {
            this.buf.write(bArr, i2, i3);
        }
        return new byte[0];
    }

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final int update(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        update(bArr, i2, i3);
        return 0;
    }

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

    @Override // org.spongycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final int doFinal(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        if (bArr2.length >= getOutputSize(i3)) {
            byte[] doFinal = doFinal(bArr, i2, i3);
            System.arraycopy(doFinal, 0, bArr2, i4, doFinal.length);
            return doFinal.length;
        }
        throw new ShortBufferException("Output buffer too short.");
    }
}