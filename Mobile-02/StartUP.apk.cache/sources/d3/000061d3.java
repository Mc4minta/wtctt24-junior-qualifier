package org.spongycastle.crypto.encodings;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;

/* loaded from: classes3.dex */
public class PKCS1Encoding implements AsymmetricBlockCipher {
    private static final int HEADER_LENGTH = 10;
    public static final String NOT_STRICT_LENGTH_ENABLED_PROPERTY = "org.spongycastle.pkcs1.not_strict";
    public static final String STRICT_LENGTH_ENABLED_PROPERTY = "org.spongycastle.pkcs1.strict";
    private AsymmetricBlockCipher engine;
    private byte[] fallback;
    private boolean forEncryption;
    private boolean forPrivateKey;
    private int pLen;
    private SecureRandom random;
    private boolean useStrictLength;

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.pLen = -1;
        this.fallback = null;
        this.engine = asymmetricBlockCipher;
        this.useStrictLength = useStrict();
    }

    private static int checkPkcs1Encoding(byte[] bArr, int i2) {
        int i3 = 0 | (bArr[0] ^ 2);
        int i4 = i2 + 1;
        int length = bArr.length - i4;
        for (int i5 = 1; i5 < length; i5++) {
            byte b2 = bArr[i5];
            int i6 = b2 | (b2 >> 1);
            int i7 = i6 | (i6 >> 2);
            i3 |= ((i7 | (i7 >> 4)) & 1) - 1;
        }
        int i8 = bArr[bArr.length - i4] | i3;
        int i9 = i8 | (i8 >> 1);
        int i10 = i9 | (i9 >> 2);
        return ~(((i10 | (i10 >> 4)) & 1) - 1);
    }

    private byte[] decodeBlock(byte[] bArr, int i2, int i3) throws InvalidCipherTextException {
        byte b2;
        if (this.pLen != -1) {
            return decodeBlockOrRandom(bArr, i2, i3);
        }
        byte[] processBlock = this.engine.processBlock(bArr, i2, i3);
        if (processBlock.length >= getOutputBlockSize()) {
            byte b3 = processBlock[0];
            if (this.forPrivateKey) {
                if (b3 != 2) {
                    throw new InvalidCipherTextException("unknown block type");
                }
            } else if (b3 != 1) {
                throw new InvalidCipherTextException("unknown block type");
            }
            if (this.useStrictLength && processBlock.length != this.engine.getOutputBlockSize()) {
                throw new InvalidCipherTextException("block incorrect size");
            }
            int i4 = 1;
            while (i4 != processBlock.length && (b2 = processBlock[i4]) != 0) {
                if (b3 == 1 && b2 != -1) {
                    throw new InvalidCipherTextException("block padding incorrect");
                }
                i4++;
            }
            int i5 = i4 + 1;
            if (i5 <= processBlock.length && i5 >= 10) {
                int length = processBlock.length - i5;
                byte[] bArr2 = new byte[length];
                System.arraycopy(processBlock, i5, bArr2, 0, length);
                return bArr2;
            }
            throw new InvalidCipherTextException("no data in block");
        }
        throw new InvalidCipherTextException("block truncated");
    }

    private byte[] decodeBlockOrRandom(byte[] bArr, int i2, int i3) throws InvalidCipherTextException {
        if (this.forPrivateKey) {
            byte[] processBlock = this.engine.processBlock(bArr, i2, i3);
            byte[] bArr2 = this.fallback;
            if (bArr2 == null) {
                bArr2 = new byte[this.pLen];
                this.random.nextBytes(bArr2);
            }
            if (processBlock.length >= getOutputBlockSize()) {
                if (this.useStrictLength && processBlock.length != this.engine.getOutputBlockSize()) {
                    throw new InvalidCipherTextException("block incorrect size");
                }
                int checkPkcs1Encoding = checkPkcs1Encoding(processBlock, this.pLen);
                byte[] bArr3 = new byte[this.pLen];
                int i4 = 0;
                while (true) {
                    int i5 = this.pLen;
                    if (i4 >= i5) {
                        return bArr3;
                    }
                    bArr3[i4] = (byte) ((processBlock[(processBlock.length - i5) + i4] & (~checkPkcs1Encoding)) | (bArr2[i4] & checkPkcs1Encoding));
                    i4++;
                }
            } else {
                throw new InvalidCipherTextException("block truncated");
            }
        } else {
            throw new InvalidCipherTextException("sorry, this method is only for decryption, not for signing");
        }
    }

    private byte[] encodeBlock(byte[] bArr, int i2, int i3) throws InvalidCipherTextException {
        if (i3 <= getInputBlockSize()) {
            int inputBlockSize = this.engine.getInputBlockSize();
            byte[] bArr2 = new byte[inputBlockSize];
            if (this.forPrivateKey) {
                bArr2[0] = 1;
                for (int i4 = 1; i4 != (inputBlockSize - i3) - 1; i4++) {
                    bArr2[i4] = -1;
                }
            } else {
                this.random.nextBytes(bArr2);
                bArr2[0] = 2;
                for (int i5 = 1; i5 != (inputBlockSize - i3) - 1; i5++) {
                    while (bArr2[i5] == 0) {
                        bArr2[i5] = (byte) this.random.nextInt();
                    }
                }
            }
            int i6 = inputBlockSize - i3;
            bArr2[i6 - 1] = 0;
            System.arraycopy(bArr, i2, bArr2, i6, i3);
            return this.engine.processBlock(bArr2, 0, inputBlockSize);
        }
        throw new IllegalArgumentException("input data too large");
    }

    private boolean useStrict() {
        String str = (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.spongycastle.crypto.encodings.PKCS1Encoding.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                return System.getProperty(PKCS1Encoding.STRICT_LENGTH_ENABLED_PROPERTY);
            }
        });
        String str2 = (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.spongycastle.crypto.encodings.PKCS1Encoding.2
            @Override // java.security.PrivilegedAction
            public Object run() {
                return System.getProperty(PKCS1Encoding.NOT_STRICT_LENGTH_ENABLED_PROPERTY);
            }
        });
        if (str2 != null) {
            return !str2.equals("true");
        }
        return str == null || str.equals("true");
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        int inputBlockSize = this.engine.getInputBlockSize();
        return this.forEncryption ? inputBlockSize - 10 : inputBlockSize;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        int outputBlockSize = this.engine.getOutputBlockSize();
        return this.forEncryption ? outputBlockSize : outputBlockSize - 10;
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.random = parametersWithRandom.getRandom();
            asymmetricKeyParameter = (AsymmetricKeyParameter) parametersWithRandom.getParameters();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
            if (!asymmetricKeyParameter.isPrivate() && z) {
                this.random = new SecureRandom();
            }
        }
        this.engine.init(z, cipherParameters);
        this.forPrivateKey = asymmetricKeyParameter.isPrivate();
        this.forEncryption = z;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i2, int i3) throws InvalidCipherTextException {
        if (this.forEncryption) {
            return encodeBlock(bArr, i2, i3);
        }
        return decodeBlock(bArr, i2, i3);
    }

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher, int i2) {
        this.pLen = -1;
        this.fallback = null;
        this.engine = asymmetricBlockCipher;
        this.useStrictLength = useStrict();
        this.pLen = i2;
    }

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher, byte[] bArr) {
        this.pLen = -1;
        this.fallback = null;
        this.engine = asymmetricBlockCipher;
        this.useStrictLength = useStrict();
        this.fallback = bArr;
        this.pLen = bArr.length;
    }
}