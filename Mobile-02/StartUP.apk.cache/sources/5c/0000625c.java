package org.spongycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class CCMBlockCipher implements AEADBlockCipher {
    private int blockSize;
    private BlockCipher cipher;
    private boolean forEncryption;
    private byte[] initialAssociatedText;
    private CipherParameters keyParam;
    private byte[] macBlock;
    private int macSize;
    private byte[] nonce;
    private ExposedByteArrayOutputStream associatedText = new ExposedByteArrayOutputStream();
    private ExposedByteArrayOutputStream data = new ExposedByteArrayOutputStream();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public ExposedByteArrayOutputStream() {
        }

        public byte[] getBuffer() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public CCMBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.macBlock = new byte[blockSize];
        if (blockSize != 16) {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        }
    }

    private int calculateMac(byte[] bArr, int i2, int i3, byte[] bArr2) {
        CBCBlockCipherMac cBCBlockCipherMac = new CBCBlockCipherMac(this.cipher, this.macSize * 8);
        cBCBlockCipherMac.init(this.keyParam);
        byte[] bArr3 = new byte[16];
        if (hasAssociatedText()) {
            bArr3[0] = (byte) (bArr3[0] | 64);
        }
        int i4 = 2;
        bArr3[0] = (byte) (bArr3[0] | ((((cBCBlockCipherMac.getMacSize() - 2) / 2) & 7) << 3));
        byte b2 = bArr3[0];
        byte[] bArr4 = this.nonce;
        bArr3[0] = (byte) (b2 | (((15 - bArr4.length) - 1) & 7));
        System.arraycopy(bArr4, 0, bArr3, 1, bArr4.length);
        int i5 = i3;
        int i6 = 1;
        while (i5 > 0) {
            bArr3[16 - i6] = (byte) (i5 & 255);
            i5 >>>= 8;
            i6++;
        }
        cBCBlockCipherMac.update(bArr3, 0, 16);
        if (hasAssociatedText()) {
            int associatedTextLength = getAssociatedTextLength();
            if (associatedTextLength < 65280) {
                cBCBlockCipherMac.update((byte) (associatedTextLength >> 8));
                cBCBlockCipherMac.update((byte) associatedTextLength);
            } else {
                cBCBlockCipherMac.update((byte) -1);
                cBCBlockCipherMac.update((byte) -2);
                cBCBlockCipherMac.update((byte) (associatedTextLength >> 24));
                cBCBlockCipherMac.update((byte) (associatedTextLength >> 16));
                cBCBlockCipherMac.update((byte) (associatedTextLength >> 8));
                cBCBlockCipherMac.update((byte) associatedTextLength);
                i4 = 6;
            }
            byte[] bArr5 = this.initialAssociatedText;
            if (bArr5 != null) {
                cBCBlockCipherMac.update(bArr5, 0, bArr5.length);
            }
            if (this.associatedText.size() > 0) {
                cBCBlockCipherMac.update(this.associatedText.getBuffer(), 0, this.associatedText.size());
            }
            int i7 = (i4 + associatedTextLength) % 16;
            if (i7 != 0) {
                while (i7 != 16) {
                    cBCBlockCipherMac.update((byte) 0);
                    i7++;
                }
            }
        }
        cBCBlockCipherMac.update(bArr, i2, i3);
        return cBCBlockCipherMac.doFinal(bArr2, 0);
    }

    private int getAssociatedTextLength() {
        int size = this.associatedText.size();
        byte[] bArr = this.initialAssociatedText;
        return size + (bArr == null ? 0 : bArr.length);
    }

    private boolean hasAssociatedText() {
        return getAssociatedTextLength() > 0;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int doFinal(byte[] bArr, int i2) throws IllegalStateException, InvalidCipherTextException {
        int processPacket = processPacket(this.data.getBuffer(), 0, this.data.size(), bArr, i2);
        reset();
        return processPacket;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CCM";
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public byte[] getMac() {
        int i2 = this.macSize;
        byte[] bArr = new byte[i2];
        System.arraycopy(this.macBlock, 0, bArr, 0, i2);
        return bArr;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getOutputSize(int i2) {
        int size = i2 + this.data.size();
        if (this.forEncryption) {
            return size + this.macSize;
        }
        int i3 = this.macSize;
        if (size < i3) {
            return 0;
        }
        return size - i3;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getUpdateOutputSize(int i2) {
        return 0;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters parameters;
        this.forEncryption = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            this.nonce = aEADParameters.getNonce();
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            this.macSize = aEADParameters.getMacSize() / 8;
            parameters = aEADParameters.getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.nonce = parametersWithIV.getIV();
            this.initialAssociatedText = null;
            this.macSize = this.macBlock.length / 2;
            parameters = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to CCM: " + cipherParameters.getClass().getName());
        }
        if (parameters != null) {
            this.keyParam = parameters;
        }
        byte[] bArr = this.nonce;
        if (bArr != null && bArr.length >= 7 && bArr.length <= 13) {
            reset();
            return;
        }
        throw new IllegalArgumentException("nonce must have length from 7 to 13 octets");
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void processAADByte(byte b2) {
        this.associatedText.write(b2);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void processAADBytes(byte[] bArr, int i2, int i3) {
        this.associatedText.write(bArr, i2, i3);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processByte(byte b2, byte[] bArr, int i2) throws DataLengthException, IllegalStateException {
        this.data.write(b2);
        return 0;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException, IllegalStateException {
        if (bArr.length >= i2 + i3) {
            this.data.write(bArr, i2, i3);
            return 0;
        }
        throw new DataLengthException("Input buffer too short");
    }

    public byte[] processPacket(byte[] bArr, int i2, int i3) throws IllegalStateException, InvalidCipherTextException {
        byte[] bArr2;
        if (this.forEncryption) {
            bArr2 = new byte[this.macSize + i3];
        } else {
            int i4 = this.macSize;
            if (i3 >= i4) {
                bArr2 = new byte[i3 - i4];
            } else {
                throw new InvalidCipherTextException("data too short");
            }
        }
        processPacket(bArr, i2, i3, bArr2, 0);
        return bArr2;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void reset() {
        this.cipher.reset();
        this.associatedText.reset();
        this.data.reset();
    }

    public int processPacket(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws IllegalStateException, InvalidCipherTextException, DataLengthException {
        int i5;
        if (this.keyParam != null) {
            byte[] bArr3 = this.nonce;
            int length = 15 - bArr3.length;
            if (length < 4 && i3 >= (1 << (length * 8))) {
                throw new IllegalStateException("CCM packet too large for choice of q.");
            }
            byte[] bArr4 = new byte[this.blockSize];
            bArr4[0] = (byte) ((length - 1) & 7);
            System.arraycopy(bArr3, 0, bArr4, 1, bArr3.length);
            SICBlockCipher sICBlockCipher = new SICBlockCipher(this.cipher);
            sICBlockCipher.init(this.forEncryption, new ParametersWithIV(this.keyParam, bArr4));
            if (this.forEncryption) {
                int i6 = this.macSize + i3;
                if (bArr2.length >= i6 + i4) {
                    calculateMac(bArr, i2, i3, this.macBlock);
                    byte[] bArr5 = new byte[this.blockSize];
                    sICBlockCipher.processBlock(this.macBlock, 0, bArr5, 0);
                    int i7 = i2;
                    int i8 = i4;
                    while (true) {
                        int i9 = i2 + i3;
                        int i10 = this.blockSize;
                        if (i7 < i9 - i10) {
                            sICBlockCipher.processBlock(bArr, i7, bArr2, i8);
                            int i11 = this.blockSize;
                            i8 += i11;
                            i7 += i11;
                        } else {
                            byte[] bArr6 = new byte[i10];
                            int i12 = i9 - i7;
                            System.arraycopy(bArr, i7, bArr6, 0, i12);
                            sICBlockCipher.processBlock(bArr6, 0, bArr6, 0);
                            System.arraycopy(bArr6, 0, bArr2, i8, i12);
                            System.arraycopy(bArr5, 0, bArr2, i4 + i3, this.macSize);
                            return i6;
                        }
                    }
                } else {
                    throw new OutputLengthException("Output buffer too short.");
                }
            } else {
                int i13 = this.macSize;
                if (i3 >= i13) {
                    int i14 = i3 - i13;
                    if (bArr2.length >= i14 + i4) {
                        int i15 = i2 + i14;
                        System.arraycopy(bArr, i15, this.macBlock, 0, i13);
                        byte[] bArr7 = this.macBlock;
                        sICBlockCipher.processBlock(bArr7, 0, bArr7, 0);
                        int i16 = this.macSize;
                        while (true) {
                            byte[] bArr8 = this.macBlock;
                            if (i16 == bArr8.length) {
                                break;
                            }
                            bArr8[i16] = 0;
                            i16++;
                        }
                        int i17 = i2;
                        int i18 = i4;
                        while (true) {
                            i5 = this.blockSize;
                            if (i17 >= i15 - i5) {
                                break;
                            }
                            sICBlockCipher.processBlock(bArr, i17, bArr2, i18);
                            int i19 = this.blockSize;
                            i18 += i19;
                            i17 += i19;
                        }
                        byte[] bArr9 = new byte[i5];
                        int i20 = i14 - (i17 - i2);
                        System.arraycopy(bArr, i17, bArr9, 0, i20);
                        sICBlockCipher.processBlock(bArr9, 0, bArr9, 0);
                        System.arraycopy(bArr9, 0, bArr2, i18, i20);
                        byte[] bArr10 = new byte[this.blockSize];
                        calculateMac(bArr2, i4, i14, bArr10);
                        if (Arrays.constantTimeAreEqual(this.macBlock, bArr10)) {
                            return i14;
                        }
                        throw new InvalidCipherTextException("mac check in CCM failed");
                    }
                    throw new OutputLengthException("Output buffer too short.");
                }
                throw new InvalidCipherTextException("data too short");
            }
        } else {
            throw new IllegalStateException("CCM cipher unitialized.");
        }
    }
}