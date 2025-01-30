package org.spongycastle.crypto.engines;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.EphemeralKeyPair;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.KeyParser;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.IESParameters;
import org.spongycastle.crypto.params.IESWithCipherParameters;
import org.spongycastle.crypto.params.KDFParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public class IESEngine {
    private byte[] IV;
    byte[] V;
    BasicAgreement agree;
    BufferedBlockCipher cipher;
    boolean forEncryption;
    DerivationFunction kdf;
    private EphemeralKeyPairGenerator keyPairGenerator;
    private KeyParser keyParser;
    Mac mac;
    byte[] macBuf;
    IESParameters param;
    CipherParameters privParam;
    CipherParameters pubParam;

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac) {
        this.agree = basicAgreement;
        this.kdf = derivationFunction;
        this.mac = mac;
        this.macBuf = new byte[mac.getMacSize()];
        this.cipher = null;
    }

    private byte[] decryptBlock(byte[] bArr, int i2, int i3) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        int doFinal;
        if (i3 >= this.V.length + this.mac.getMacSize()) {
            if (this.cipher == null) {
                doFinal = (i3 - this.V.length) - this.mac.getMacSize();
                byte[] bArr4 = new byte[doFinal];
                int macKeySize = this.param.getMacKeySize() / 8;
                bArr2 = new byte[macKeySize];
                int i4 = doFinal + macKeySize;
                byte[] bArr5 = new byte[i4];
                this.kdf.generateBytes(bArr5, 0, i4);
                if (this.V.length != 0) {
                    System.arraycopy(bArr5, 0, bArr2, 0, macKeySize);
                    System.arraycopy(bArr5, macKeySize, bArr4, 0, doFinal);
                } else {
                    System.arraycopy(bArr5, 0, bArr4, 0, doFinal);
                    System.arraycopy(bArr5, doFinal, bArr2, 0, macKeySize);
                }
                bArr3 = new byte[doFinal];
                for (int i5 = 0; i5 != doFinal; i5++) {
                    bArr3[i5] = (byte) (bArr[(this.V.length + i2) + i5] ^ bArr4[i5]);
                }
            } else {
                int cipherKeySize = ((IESWithCipherParameters) this.param).getCipherKeySize() / 8;
                byte[] bArr6 = new byte[cipherKeySize];
                int macKeySize2 = this.param.getMacKeySize() / 8;
                bArr2 = new byte[macKeySize2];
                int i6 = cipherKeySize + macKeySize2;
                byte[] bArr7 = new byte[i6];
                this.kdf.generateBytes(bArr7, 0, i6);
                System.arraycopy(bArr7, 0, bArr6, 0, cipherKeySize);
                System.arraycopy(bArr7, cipherKeySize, bArr2, 0, macKeySize2);
                if (this.IV != null) {
                    this.cipher.init(false, new ParametersWithIV(new KeyParameter(bArr6), this.IV));
                } else {
                    this.cipher.init(false, new KeyParameter(bArr6));
                }
                bArr3 = new byte[this.cipher.getOutputSize((i3 - this.V.length) - this.mac.getMacSize())];
                BufferedBlockCipher bufferedBlockCipher = this.cipher;
                byte[] bArr8 = this.V;
                int processBytes = bufferedBlockCipher.processBytes(bArr, i2 + bArr8.length, (i3 - bArr8.length) - this.mac.getMacSize(), bArr3, 0);
                doFinal = processBytes + this.cipher.doFinal(bArr3, processBytes);
            }
            byte[] encodingV = this.param.getEncodingV();
            byte[] lengthTag = this.V.length != 0 ? getLengthTag(encodingV) : null;
            int i7 = i2 + i3;
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i7 - this.mac.getMacSize(), i7);
            int length = copyOfRange.length;
            byte[] bArr9 = new byte[length];
            this.mac.init(new KeyParameter(bArr2));
            Mac mac = this.mac;
            byte[] bArr10 = this.V;
            mac.update(bArr, i2 + bArr10.length, (i3 - bArr10.length) - length);
            if (encodingV != null) {
                this.mac.update(encodingV, 0, encodingV.length);
            }
            if (this.V.length != 0) {
                this.mac.update(lengthTag, 0, lengthTag.length);
            }
            this.mac.doFinal(bArr9, 0);
            if (Arrays.constantTimeAreEqual(copyOfRange, bArr9)) {
                return Arrays.copyOfRange(bArr3, 0, doFinal);
            }
            throw new InvalidCipherTextException("Invalid MAC.");
        }
        throw new InvalidCipherTextException("Length of input must be greater than the MAC and V combined");
    }

    private byte[] encryptBlock(byte[] bArr, int i2, int i3) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        if (this.cipher == null) {
            byte[] bArr4 = new byte[i3];
            int macKeySize = this.param.getMacKeySize() / 8;
            bArr3 = new byte[macKeySize];
            int i4 = i3 + macKeySize;
            byte[] bArr5 = new byte[i4];
            this.kdf.generateBytes(bArr5, 0, i4);
            if (this.V.length != 0) {
                System.arraycopy(bArr5, 0, bArr3, 0, macKeySize);
                System.arraycopy(bArr5, macKeySize, bArr4, 0, i3);
            } else {
                System.arraycopy(bArr5, 0, bArr4, 0, i3);
                System.arraycopy(bArr5, i3, bArr3, 0, macKeySize);
            }
            bArr2 = new byte[i3];
            for (int i5 = 0; i5 != i3; i5++) {
                bArr2[i5] = (byte) (bArr[i2 + i5] ^ bArr4[i5]);
            }
        } else {
            int cipherKeySize = ((IESWithCipherParameters) this.param).getCipherKeySize() / 8;
            byte[] bArr6 = new byte[cipherKeySize];
            int macKeySize2 = this.param.getMacKeySize() / 8;
            byte[] bArr7 = new byte[macKeySize2];
            int i6 = cipherKeySize + macKeySize2;
            byte[] bArr8 = new byte[i6];
            this.kdf.generateBytes(bArr8, 0, i6);
            System.arraycopy(bArr8, 0, bArr6, 0, cipherKeySize);
            System.arraycopy(bArr8, cipherKeySize, bArr7, 0, macKeySize2);
            if (this.IV != null) {
                this.cipher.init(true, new ParametersWithIV(new KeyParameter(bArr6), this.IV));
            } else {
                this.cipher.init(true, new KeyParameter(bArr6));
            }
            bArr2 = new byte[this.cipher.getOutputSize(i3)];
            int processBytes = this.cipher.processBytes(bArr, i2, i3, bArr2, 0);
            i3 = processBytes + this.cipher.doFinal(bArr2, processBytes);
            bArr3 = bArr7;
        }
        byte[] encodingV = this.param.getEncodingV();
        byte[] lengthTag = this.V.length != 0 ? getLengthTag(encodingV) : null;
        int macSize = this.mac.getMacSize();
        byte[] bArr9 = new byte[macSize];
        this.mac.init(new KeyParameter(bArr3));
        this.mac.update(bArr2, 0, bArr2.length);
        if (encodingV != null) {
            this.mac.update(encodingV, 0, encodingV.length);
        }
        if (this.V.length != 0) {
            this.mac.update(lengthTag, 0, lengthTag.length);
        }
        this.mac.doFinal(bArr9, 0);
        byte[] bArr10 = this.V;
        byte[] bArr11 = new byte[bArr10.length + i3 + macSize];
        System.arraycopy(bArr10, 0, bArr11, 0, bArr10.length);
        System.arraycopy(bArr2, 0, bArr11, this.V.length, i3);
        System.arraycopy(bArr9, 0, bArr11, this.V.length + i3, macSize);
        return bArr11;
    }

    private void extractParams(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.IV = parametersWithIV.getIV();
            this.param = (IESParameters) parametersWithIV.getParameters();
            return;
        }
        this.IV = null;
        this.param = (IESParameters) cipherParameters;
    }

    public BufferedBlockCipher getCipher() {
        return this.cipher;
    }

    protected byte[] getLengthTag(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        if (bArr != null) {
            Pack.longToBigEndian(bArr.length * 8, bArr2, 0);
        }
        return bArr2;
    }

    public Mac getMac() {
        return this.mac;
    }

    public void init(boolean z, CipherParameters cipherParameters, CipherParameters cipherParameters2, CipherParameters cipherParameters3) {
        this.forEncryption = z;
        this.privParam = cipherParameters;
        this.pubParam = cipherParameters2;
        this.V = new byte[0];
        extractParams(cipherParameters3);
    }

    public byte[] processBlock(byte[] bArr, int i2, int i3) throws InvalidCipherTextException {
        byte[] decryptBlock;
        if (this.forEncryption) {
            EphemeralKeyPairGenerator ephemeralKeyPairGenerator = this.keyPairGenerator;
            if (ephemeralKeyPairGenerator != null) {
                EphemeralKeyPair generate = ephemeralKeyPairGenerator.generate();
                this.privParam = generate.getKeyPair().getPrivate();
                this.V = generate.getEncodedPublicKey();
            }
        } else if (this.keyParser != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i2, i3);
            try {
                this.pubParam = this.keyParser.readKey(byteArrayInputStream);
                this.V = Arrays.copyOfRange(bArr, i2, (i3 - byteArrayInputStream.available()) + i2);
            } catch (IOException e2) {
                throw new InvalidCipherTextException("unable to recover ephemeral public key: " + e2.getMessage(), e2);
            }
        }
        this.agree.init(this.privParam);
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.agree.getFieldSize(), this.agree.calculateAgreement(this.pubParam));
        byte[] bArr2 = this.V;
        if (bArr2.length != 0) {
            byte[] concatenate = Arrays.concatenate(bArr2, asUnsignedByteArray);
            Arrays.fill(asUnsignedByteArray, (byte) 0);
            asUnsignedByteArray = concatenate;
        }
        try {
            this.kdf.init(new KDFParameters(asUnsignedByteArray, this.param.getDerivationV()));
            if (this.forEncryption) {
                decryptBlock = encryptBlock(bArr, i2, i3);
            } else {
                decryptBlock = decryptBlock(bArr, i2, i3);
            }
            return decryptBlock;
        } finally {
            Arrays.fill(asUnsignedByteArray, (byte) 0);
        }
    }

    public void init(AsymmetricKeyParameter asymmetricKeyParameter, CipherParameters cipherParameters, EphemeralKeyPairGenerator ephemeralKeyPairGenerator) {
        this.forEncryption = true;
        this.pubParam = asymmetricKeyParameter;
        this.keyPairGenerator = ephemeralKeyPairGenerator;
        extractParams(cipherParameters);
    }

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac, BufferedBlockCipher bufferedBlockCipher) {
        this.agree = basicAgreement;
        this.kdf = derivationFunction;
        this.mac = mac;
        this.macBuf = new byte[mac.getMacSize()];
        this.cipher = bufferedBlockCipher;
    }

    public void init(AsymmetricKeyParameter asymmetricKeyParameter, CipherParameters cipherParameters, KeyParser keyParser) {
        this.forEncryption = false;
        this.privParam = asymmetricKeyParameter;
        this.keyParser = keyParser;
        extractParams(cipherParameters);
    }
}