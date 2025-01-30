package org.spongycastle.crypto.signers;

import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.SignerWithRecovery;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class ISO9796d2Signer implements SignerWithRecovery {
    public static final int TRAILER_IMPLICIT = 188;
    public static final int TRAILER_RIPEMD128 = 13004;
    public static final int TRAILER_RIPEMD160 = 12748;
    public static final int TRAILER_SHA1 = 13260;
    public static final int TRAILER_SHA256 = 13516;
    public static final int TRAILER_SHA384 = 14028;
    public static final int TRAILER_SHA512 = 13772;
    public static final int TRAILER_WHIRLPOOL = 14284;
    private byte[] block;
    private AsymmetricBlockCipher cipher;
    private Digest digest;
    private boolean fullMessage;
    private int keyBits;
    private byte[] mBuf;
    private int messageLength;
    private byte[] preBlock;
    private byte[] preSig;
    private byte[] recoveredMessage;
    private int trailer;

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, boolean z) {
        this.cipher = asymmetricBlockCipher;
        this.digest = digest;
        if (z) {
            this.trailer = 188;
            return;
        }
        Integer trailer = ISOTrailers.getTrailer(digest);
        if (trailer != null) {
            this.trailer = trailer.intValue();
            return;
        }
        throw new IllegalArgumentException("no valid trailer for digest: " + digest.getAlgorithmName());
    }

    private void clearBlock(byte[] bArr) {
        for (int i2 = 0; i2 != bArr.length; i2++) {
            bArr[i2] = 0;
        }
    }

    private boolean isSameAs(byte[] bArr, byte[] bArr2) {
        boolean z;
        int i2 = this.messageLength;
        byte[] bArr3 = this.mBuf;
        if (i2 > bArr3.length) {
            z = bArr3.length <= bArr2.length;
            for (int i3 = 0; i3 != this.mBuf.length; i3++) {
                if (bArr[i3] != bArr2[i3]) {
                    z = false;
                }
            }
        } else {
            z = i2 == bArr2.length;
            for (int i4 = 0; i4 != bArr2.length; i4++) {
                if (bArr[i4] != bArr2[i4]) {
                    z = false;
                }
            }
        }
        return z;
    }

    private boolean returnFalse(byte[] bArr) {
        clearBlock(this.mBuf);
        clearBlock(bArr);
        return false;
    }

    @Override // org.spongycastle.crypto.Signer
    public byte[] generateSignature() throws CryptoException {
        int i2;
        int i3;
        byte b2;
        int i4;
        int digestSize = this.digest.getDigestSize();
        if (this.trailer == 188) {
            byte[] bArr = this.block;
            i3 = (bArr.length - digestSize) - 1;
            this.digest.doFinal(bArr, i3);
            byte[] bArr2 = this.block;
            bArr2[bArr2.length - 1] = PSSSigner.TRAILER_IMPLICIT;
            i2 = 8;
        } else {
            i2 = 16;
            byte[] bArr3 = this.block;
            int length = (bArr3.length - digestSize) - 2;
            this.digest.doFinal(bArr3, length);
            byte[] bArr4 = this.block;
            int i5 = this.trailer;
            bArr4[bArr4.length - 2] = (byte) (i5 >>> 8);
            bArr4[bArr4.length - 1] = (byte) i5;
            i3 = length;
        }
        int i6 = this.messageLength;
        int i7 = ((((digestSize + i6) * 8) + i2) + 4) - this.keyBits;
        if (i7 > 0) {
            int i8 = i6 - ((i7 + 7) / 8);
            b2 = 96;
            i4 = i3 - i8;
            System.arraycopy(this.mBuf, 0, this.block, i4, i8);
            this.recoveredMessage = new byte[i8];
        } else {
            b2 = 64;
            i4 = i3 - i6;
            System.arraycopy(this.mBuf, 0, this.block, i4, i6);
            this.recoveredMessage = new byte[this.messageLength];
        }
        int i9 = i4 - 1;
        if (i9 > 0) {
            for (int i10 = i9; i10 != 0; i10--) {
                this.block[i10] = -69;
            }
            byte[] bArr5 = this.block;
            bArr5[i9] = (byte) (bArr5[i9] ^ 1);
            bArr5[0] = 11;
            bArr5[0] = (byte) (bArr5[0] | b2);
        } else {
            byte[] bArr6 = this.block;
            bArr6[0] = 10;
            bArr6[0] = (byte) (bArr6[0] | b2);
        }
        AsymmetricBlockCipher asymmetricBlockCipher = this.cipher;
        byte[] bArr7 = this.block;
        byte[] processBlock = asymmetricBlockCipher.processBlock(bArr7, 0, bArr7.length);
        this.fullMessage = (b2 & 32) == 0;
        byte[] bArr8 = this.mBuf;
        byte[] bArr9 = this.recoveredMessage;
        System.arraycopy(bArr8, 0, bArr9, 0, bArr9.length);
        clearBlock(this.mBuf);
        clearBlock(this.block);
        return processBlock;
    }

    @Override // org.spongycastle.crypto.SignerWithRecovery
    public byte[] getRecoveredMessage() {
        return this.recoveredMessage;
    }

    @Override // org.spongycastle.crypto.SignerWithRecovery
    public boolean hasFullMessage() {
        return this.fullMessage;
    }

    @Override // org.spongycastle.crypto.Signer
    public void init(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        this.cipher.init(z, rSAKeyParameters);
        int bitLength = rSAKeyParameters.getModulus().bitLength();
        this.keyBits = bitLength;
        byte[] bArr = new byte[(bitLength + 7) / 8];
        this.block = bArr;
        if (this.trailer == 188) {
            this.mBuf = new byte[(bArr.length - this.digest.getDigestSize()) - 2];
        } else {
            this.mBuf = new byte[(bArr.length - this.digest.getDigestSize()) - 3];
        }
        reset();
    }

    @Override // org.spongycastle.crypto.Signer
    public void reset() {
        this.digest.reset();
        this.messageLength = 0;
        clearBlock(this.mBuf);
        byte[] bArr = this.recoveredMessage;
        if (bArr != null) {
            clearBlock(bArr);
        }
        this.recoveredMessage = null;
        this.fullMessage = false;
        if (this.preSig != null) {
            this.preSig = null;
            clearBlock(this.preBlock);
            this.preBlock = null;
        }
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte b2) {
        this.digest.update(b2);
        int i2 = this.messageLength;
        byte[] bArr = this.mBuf;
        if (i2 < bArr.length) {
            bArr[i2] = b2;
        }
        this.messageLength = i2 + 1;
    }

    @Override // org.spongycastle.crypto.SignerWithRecovery
    public void updateWithRecoveredMessage(byte[] bArr) throws InvalidCipherTextException {
        byte[] processBlock = this.cipher.processBlock(bArr, 0, bArr.length);
        if (((processBlock[0] & 192) ^ 64) == 0) {
            if (((processBlock[processBlock.length - 1] & 15) ^ 12) == 0) {
                int i2 = 2;
                if (((processBlock[processBlock.length - 1] & 255) ^ 188) == 0) {
                    i2 = 1;
                } else {
                    int i3 = ((processBlock[processBlock.length - 2] & 255) << 8) | (processBlock[processBlock.length - 1] & 255);
                    Integer trailer = ISOTrailers.getTrailer(this.digest);
                    if (trailer != null) {
                        if (i3 != trailer.intValue()) {
                            throw new IllegalStateException("signer initialised with wrong digest for trailer " + i3);
                        }
                    } else {
                        throw new IllegalArgumentException("unrecognised hash in signature");
                    }
                }
                int i4 = 0;
                while (i4 != processBlock.length && ((processBlock[i4] & 15) ^ 10) != 0) {
                    i4++;
                }
                int i5 = i4 + 1;
                int length = ((processBlock.length - i2) - this.digest.getDigestSize()) - i5;
                if (length > 0) {
                    if ((processBlock[0] & 32) == 0) {
                        this.fullMessage = true;
                        byte[] bArr2 = new byte[length];
                        this.recoveredMessage = bArr2;
                        System.arraycopy(processBlock, i5, bArr2, 0, bArr2.length);
                    } else {
                        this.fullMessage = false;
                        byte[] bArr3 = new byte[length];
                        this.recoveredMessage = bArr3;
                        System.arraycopy(processBlock, i5, bArr3, 0, bArr3.length);
                    }
                    this.preSig = bArr;
                    this.preBlock = processBlock;
                    Digest digest = this.digest;
                    byte[] bArr4 = this.recoveredMessage;
                    digest.update(bArr4, 0, bArr4.length);
                    byte[] bArr5 = this.recoveredMessage;
                    this.messageLength = bArr5.length;
                    System.arraycopy(bArr5, 0, this.mBuf, 0, bArr5.length);
                    return;
                }
                throw new InvalidCipherTextException("malformed block");
            }
            throw new InvalidCipherTextException("malformed signature");
        }
        throw new InvalidCipherTextException("malformed signature");
    }

    @Override // org.spongycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        byte[] processBlock;
        byte[] bArr2 = this.preSig;
        if (bArr2 == null) {
            try {
                processBlock = this.cipher.processBlock(bArr, 0, bArr.length);
            } catch (Exception unused) {
                return false;
            }
        } else if (Arrays.areEqual(bArr2, bArr)) {
            processBlock = this.preBlock;
            this.preSig = null;
            this.preBlock = null;
        } else {
            throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
        }
        if (((processBlock[0] & 192) ^ 64) != 0) {
            return returnFalse(processBlock);
        }
        if (((processBlock[processBlock.length - 1] & 15) ^ 12) != 0) {
            return returnFalse(processBlock);
        }
        int i2 = 2;
        if (((processBlock[processBlock.length - 1] & 255) ^ 188) == 0) {
            i2 = 1;
        } else {
            int i3 = ((processBlock[processBlock.length - 2] & 255) << 8) | (processBlock[processBlock.length - 1] & 255);
            Integer trailer = ISOTrailers.getTrailer(this.digest);
            if (trailer != null) {
                if (i3 != trailer.intValue()) {
                    throw new IllegalStateException("signer initialised with wrong digest for trailer " + i3);
                }
            } else {
                throw new IllegalArgumentException("unrecognised hash in signature");
            }
        }
        int i4 = 0;
        while (i4 != processBlock.length && ((processBlock[i4] & 15) ^ 10) != 0) {
            i4++;
        }
        int i5 = i4 + 1;
        int digestSize = this.digest.getDigestSize();
        byte[] bArr3 = new byte[digestSize];
        int length = (processBlock.length - i2) - digestSize;
        int i6 = length - i5;
        if (i6 <= 0) {
            return returnFalse(processBlock);
        }
        if ((processBlock[0] & 32) == 0) {
            this.fullMessage = true;
            if (this.messageLength > i6) {
                return returnFalse(processBlock);
            }
            this.digest.reset();
            this.digest.update(processBlock, i5, i6);
            this.digest.doFinal(bArr3, 0);
            boolean z = true;
            for (int i7 = 0; i7 != digestSize; i7++) {
                int i8 = length + i7;
                processBlock[i8] = (byte) (processBlock[i8] ^ bArr3[i7]);
                if (processBlock[i8] != 0) {
                    z = false;
                }
            }
            if (!z) {
                return returnFalse(processBlock);
            }
            byte[] bArr4 = new byte[i6];
            this.recoveredMessage = bArr4;
            System.arraycopy(processBlock, i5, bArr4, 0, bArr4.length);
        } else {
            this.fullMessage = false;
            this.digest.doFinal(bArr3, 0);
            boolean z2 = true;
            for (int i9 = 0; i9 != digestSize; i9++) {
                int i10 = length + i9;
                processBlock[i10] = (byte) (processBlock[i10] ^ bArr3[i9]);
                if (processBlock[i10] != 0) {
                    z2 = false;
                }
            }
            if (!z2) {
                return returnFalse(processBlock);
            }
            byte[] bArr5 = new byte[i6];
            this.recoveredMessage = bArr5;
            System.arraycopy(processBlock, i5, bArr5, 0, bArr5.length);
        }
        if (this.messageLength != 0 && !isSameAs(this.mBuf, this.recoveredMessage)) {
            return returnFalse(processBlock);
        }
        clearBlock(this.mBuf);
        clearBlock(processBlock);
        return true;
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte[] bArr, int i2, int i3) {
        while (i3 > 0 && this.messageLength < this.mBuf.length) {
            update(bArr[i2]);
            i2++;
            i3--;
        }
        this.digest.update(bArr, i2, i3);
        this.messageLength += i3;
    }

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        this(asymmetricBlockCipher, digest, false);
    }
}