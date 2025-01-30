package org.spongycastle.crypto.encodings;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;

/* loaded from: classes3.dex */
public class OAEPEncoding implements AsymmetricBlockCipher {
    private byte[] defHash;
    private AsymmetricBlockCipher engine;
    private boolean forEncryption;
    private Digest mgf1Hash;
    private SecureRandom random;

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this(asymmetricBlockCipher, new SHA1Digest(), null);
    }

    private void ItoOSP(int i2, byte[] bArr) {
        bArr[0] = (byte) (i2 >>> 24);
        bArr[1] = (byte) (i2 >>> 16);
        bArr[2] = (byte) (i2 >>> 8);
        bArr[3] = (byte) (i2 >>> 0);
    }

    private byte[] maskGeneratorFunction1(byte[] bArr, int i2, int i3, int i4) {
        byte[] bArr2 = new byte[i4];
        int digestSize = this.mgf1Hash.getDigestSize();
        byte[] bArr3 = new byte[digestSize];
        byte[] bArr4 = new byte[4];
        this.mgf1Hash.reset();
        int i5 = 0;
        while (i5 < i4 / digestSize) {
            ItoOSP(i5, bArr4);
            this.mgf1Hash.update(bArr, i2, i3);
            this.mgf1Hash.update(bArr4, 0, 4);
            this.mgf1Hash.doFinal(bArr3, 0);
            System.arraycopy(bArr3, 0, bArr2, i5 * digestSize, digestSize);
            i5++;
        }
        int i6 = digestSize * i5;
        if (i6 < i4) {
            ItoOSP(i5, bArr4);
            this.mgf1Hash.update(bArr, i2, i3);
            this.mgf1Hash.update(bArr4, 0, 4);
            this.mgf1Hash.doFinal(bArr3, 0);
            System.arraycopy(bArr3, 0, bArr2, i6, i4 - i6);
        }
        return bArr2;
    }

    public byte[] decodeBlock(byte[] bArr, int i2, int i3) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        byte[] processBlock = this.engine.processBlock(bArr, i2, i3);
        if (processBlock.length < this.engine.getOutputBlockSize()) {
            int outputBlockSize = this.engine.getOutputBlockSize();
            byte[] bArr4 = new byte[outputBlockSize];
            System.arraycopy(processBlock, 0, bArr4, outputBlockSize - processBlock.length, processBlock.length);
            processBlock = bArr4;
        }
        int length = processBlock.length;
        byte[] bArr5 = this.defHash;
        if (length >= (bArr5.length * 2) + 1) {
            byte[] maskGeneratorFunction1 = maskGeneratorFunction1(processBlock, bArr5.length, processBlock.length - bArr5.length, bArr5.length);
            int i4 = 0;
            while (true) {
                bArr2 = this.defHash;
                if (i4 == bArr2.length) {
                    break;
                }
                processBlock[i4] = (byte) (processBlock[i4] ^ maskGeneratorFunction1[i4]);
                i4++;
            }
            byte[] maskGeneratorFunction12 = maskGeneratorFunction1(processBlock, 0, bArr2.length, processBlock.length - bArr2.length);
            for (int length2 = this.defHash.length; length2 != processBlock.length; length2++) {
                processBlock[length2] = (byte) (processBlock[length2] ^ maskGeneratorFunction12[length2 - this.defHash.length]);
            }
            int i5 = 0;
            boolean z = false;
            while (true) {
                bArr3 = this.defHash;
                if (i5 == bArr3.length) {
                    break;
                }
                if (bArr3[i5] != processBlock[bArr3.length + i5]) {
                    z = true;
                }
                i5++;
            }
            if (!z) {
                int length3 = bArr3.length * 2;
                while (length3 != processBlock.length && processBlock[length3] == 0) {
                    length3++;
                }
                if (length3 < processBlock.length - 1 && processBlock[length3] == 1) {
                    int i6 = length3 + 1;
                    int length4 = processBlock.length - i6;
                    byte[] bArr6 = new byte[length4];
                    System.arraycopy(processBlock, i6, bArr6, 0, length4);
                    return bArr6;
                }
                throw new InvalidCipherTextException("data start wrong " + length3);
            }
            throw new InvalidCipherTextException("data hash wrong");
        }
        throw new InvalidCipherTextException("data too short");
    }

    public byte[] encodeBlock(byte[] bArr, int i2, int i3) throws InvalidCipherTextException {
        int inputBlockSize = getInputBlockSize() + 1 + (this.defHash.length * 2);
        byte[] bArr2 = new byte[inputBlockSize];
        int i4 = inputBlockSize - i3;
        System.arraycopy(bArr, i2, bArr2, i4, i3);
        bArr2[i4 - 1] = 1;
        byte[] bArr3 = this.defHash;
        System.arraycopy(bArr3, 0, bArr2, bArr3.length, bArr3.length);
        int length = this.defHash.length;
        byte[] bArr4 = new byte[length];
        this.random.nextBytes(bArr4);
        byte[] maskGeneratorFunction1 = maskGeneratorFunction1(bArr4, 0, length, inputBlockSize - this.defHash.length);
        for (int length2 = this.defHash.length; length2 != inputBlockSize; length2++) {
            bArr2[length2] = (byte) (bArr2[length2] ^ maskGeneratorFunction1[length2 - this.defHash.length]);
        }
        System.arraycopy(bArr4, 0, bArr2, 0, this.defHash.length);
        byte[] bArr5 = this.defHash;
        byte[] maskGeneratorFunction12 = maskGeneratorFunction1(bArr2, bArr5.length, inputBlockSize - bArr5.length, bArr5.length);
        for (int i5 = 0; i5 != this.defHash.length; i5++) {
            bArr2[i5] = (byte) (bArr2[i5] ^ maskGeneratorFunction12[i5]);
        }
        return this.engine.processBlock(bArr2, 0, inputBlockSize);
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        int inputBlockSize = this.engine.getInputBlockSize();
        return this.forEncryption ? (inputBlockSize - 1) - (this.defHash.length * 2) : inputBlockSize;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        int outputBlockSize = this.engine.getOutputBlockSize();
        return this.forEncryption ? outputBlockSize : (outputBlockSize - 1) - (this.defHash.length * 2);
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            this.random = ((ParametersWithRandom) cipherParameters).getRandom();
        } else {
            this.random = new SecureRandom();
        }
        this.engine.init(z, cipherParameters);
        this.forEncryption = z;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i2, int i3) throws InvalidCipherTextException {
        if (this.forEncryption) {
            return encodeBlock(bArr, i2, i3);
        }
        return decodeBlock(bArr, i2, i3);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        this(asymmetricBlockCipher, digest, null);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, byte[] bArr) {
        this(asymmetricBlockCipher, digest, digest, bArr);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, byte[] bArr) {
        this.engine = asymmetricBlockCipher;
        this.mgf1Hash = digest2;
        this.defHash = new byte[digest.getDigestSize()];
        digest.reset();
        if (bArr != null) {
            digest.update(bArr, 0, bArr.length);
        }
        digest.doFinal(this.defHash, 0);
    }
}