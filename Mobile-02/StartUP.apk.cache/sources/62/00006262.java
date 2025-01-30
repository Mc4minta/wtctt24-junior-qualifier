package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.modes.gcm.GCMExponentiator;
import org.spongycastle.crypto.modes.gcm.GCMMultiplier;
import org.spongycastle.crypto.modes.gcm.GCMUtil;
import org.spongycastle.crypto.modes.gcm.Tables1kGCMExponentiator;
import org.spongycastle.crypto.modes.gcm.Tables8kGCMMultiplier;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public class GCMBlockCipher implements AEADBlockCipher {
    private static final int BLOCK_SIZE = 16;
    private byte[] H;
    private byte[] J0;
    private byte[] S;
    private byte[] S_at;
    private byte[] S_atPre;
    private byte[] atBlock;
    private int atBlockPos;
    private long atLength;
    private long atLengthPre;
    private byte[] bufBlock;
    private int bufOff;
    private BlockCipher cipher;
    private byte[] counter;
    private GCMExponentiator exp;
    private boolean forEncryption;
    private byte[] initialAssociatedText;
    private byte[] macBlock;
    private int macSize;
    private GCMMultiplier multiplier;
    private byte[] nonce;
    private long totalLength;

    public GCMBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, null);
    }

    private void gCTRBlock(byte[] bArr, byte[] bArr2, int i2) {
        byte[] nextCounterBlock = getNextCounterBlock();
        GCMUtil.xor(nextCounterBlock, bArr);
        System.arraycopy(nextCounterBlock, 0, bArr2, i2, 16);
        byte[] bArr3 = this.S;
        if (this.forEncryption) {
            bArr = nextCounterBlock;
        }
        gHASHBlock(bArr3, bArr);
        this.totalLength += 16;
    }

    private void gCTRPartial(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        byte[] nextCounterBlock = getNextCounterBlock();
        GCMUtil.xor(nextCounterBlock, bArr, i2, i3);
        System.arraycopy(nextCounterBlock, 0, bArr2, i4, i3);
        byte[] bArr3 = this.S;
        if (this.forEncryption) {
            bArr = nextCounterBlock;
        }
        gHASHPartial(bArr3, bArr, 0, i3);
        this.totalLength += i3;
    }

    private void gHASH(byte[] bArr, byte[] bArr2, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 16) {
            gHASHPartial(bArr, bArr2, i3, Math.min(i2 - i3, 16));
        }
    }

    private void gHASHBlock(byte[] bArr, byte[] bArr2) {
        GCMUtil.xor(bArr, bArr2);
        this.multiplier.multiplyH(bArr);
    }

    private void gHASHPartial(byte[] bArr, byte[] bArr2, int i2, int i3) {
        GCMUtil.xor(bArr, bArr2, i2, i3);
        this.multiplier.multiplyH(bArr);
    }

    private byte[] getNextCounterBlock() {
        byte[] bArr = this.counter;
        int i2 = (bArr[15] & 255) + 1;
        bArr[15] = (byte) i2;
        int i3 = (i2 >>> 8) + (bArr[14] & 255);
        bArr[14] = (byte) i3;
        int i4 = (i3 >>> 8) + (bArr[13] & 255);
        bArr[13] = (byte) i4;
        bArr[12] = (byte) ((i4 >>> 8) + (bArr[12] & 255));
        byte[] bArr2 = new byte[16];
        this.cipher.processBlock(bArr, 0, bArr2, 0);
        return bArr2;
    }

    private void initCipher() {
        if (this.atLength > 0) {
            System.arraycopy(this.S_at, 0, this.S_atPre, 0, 16);
            this.atLengthPre = this.atLength;
        }
        int i2 = this.atBlockPos;
        if (i2 > 0) {
            gHASHPartial(this.S_atPre, this.atBlock, 0, i2);
            this.atLengthPre += this.atBlockPos;
        }
        if (this.atLengthPre > 0) {
            System.arraycopy(this.S_atPre, 0, this.S, 0, 16);
        }
    }

    private void outputBlock(byte[] bArr, int i2) {
        if (bArr.length >= i2 + 16) {
            if (this.totalLength == 0) {
                initCipher();
            }
            gCTRBlock(this.bufBlock, bArr, i2);
            if (this.forEncryption) {
                this.bufOff = 0;
                return;
            }
            byte[] bArr2 = this.bufBlock;
            System.arraycopy(bArr2, 16, bArr2, 0, this.macSize);
            this.bufOff = this.macSize;
            return;
        }
        throw new OutputLengthException("Output buffer too short");
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int doFinal(byte[] bArr, int i2) throws IllegalStateException, InvalidCipherTextException {
        if (this.totalLength == 0) {
            initCipher();
        }
        int i3 = this.bufOff;
        if (this.forEncryption) {
            if (bArr.length < i2 + i3 + this.macSize) {
                throw new OutputLengthException("Output buffer too short");
            }
        } else {
            int i4 = this.macSize;
            if (i3 >= i4) {
                i3 -= i4;
                if (bArr.length < i2 + i3) {
                    throw new OutputLengthException("Output buffer too short");
                }
            } else {
                throw new InvalidCipherTextException("data too short");
            }
        }
        if (i3 > 0) {
            gCTRPartial(this.bufBlock, 0, i3, bArr, i2);
        }
        long j2 = this.atLength;
        int i5 = this.atBlockPos;
        long j3 = j2 + i5;
        this.atLength = j3;
        if (j3 > this.atLengthPre) {
            if (i5 > 0) {
                gHASHPartial(this.S_at, this.atBlock, 0, i5);
            }
            if (this.atLengthPre > 0) {
                GCMUtil.xor(this.S_at, this.S_atPre);
            }
            long j4 = ((this.totalLength * 8) + 127) >>> 7;
            byte[] bArr2 = new byte[16];
            if (this.exp == null) {
                Tables1kGCMExponentiator tables1kGCMExponentiator = new Tables1kGCMExponentiator();
                this.exp = tables1kGCMExponentiator;
                tables1kGCMExponentiator.init(this.H);
            }
            this.exp.exponentiateX(j4, bArr2);
            GCMUtil.multiply(this.S_at, bArr2);
            GCMUtil.xor(this.S, this.S_at);
        }
        byte[] bArr3 = new byte[16];
        Pack.longToBigEndian(this.atLength * 8, bArr3, 0);
        Pack.longToBigEndian(this.totalLength * 8, bArr3, 8);
        gHASHBlock(this.S, bArr3);
        byte[] bArr4 = new byte[16];
        this.cipher.processBlock(this.J0, 0, bArr4, 0);
        GCMUtil.xor(bArr4, this.S);
        int i6 = this.macSize;
        byte[] bArr5 = new byte[i6];
        this.macBlock = bArr5;
        System.arraycopy(bArr4, 0, bArr5, 0, i6);
        if (this.forEncryption) {
            System.arraycopy(this.macBlock, 0, bArr, i2 + this.bufOff, this.macSize);
            i3 += this.macSize;
        } else {
            int i7 = this.macSize;
            byte[] bArr6 = new byte[i7];
            System.arraycopy(this.bufBlock, i3, bArr6, 0, i7);
            if (!Arrays.constantTimeAreEqual(this.macBlock, bArr6)) {
                throw new InvalidCipherTextException("mac check in GCM failed");
            }
        }
        reset(false);
        return i3;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/GCM";
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public byte[] getMac() {
        return Arrays.clone(this.macBlock);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getOutputSize(int i2) {
        int i3 = i2 + this.bufOff;
        if (this.forEncryption) {
            return i3 + this.macSize;
        }
        int i4 = this.macSize;
        if (i3 < i4) {
            return 0;
        }
        return i3 - i4;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getUpdateOutputSize(int i2) {
        int i3 = i2 + this.bufOff;
        if (!this.forEncryption) {
            int i4 = this.macSize;
            if (i3 < i4) {
                return 0;
            }
            i3 -= i4;
        }
        return i3 - (i3 % 16);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        KeyParameter keyParameter;
        this.forEncryption = z;
        this.macBlock = null;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            this.nonce = aEADParameters.getNonce();
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            int macSize = aEADParameters.getMacSize();
            if (macSize >= 32 && macSize <= 128 && macSize % 8 == 0) {
                this.macSize = macSize / 8;
                keyParameter = aEADParameters.getKey();
            } else {
                throw new IllegalArgumentException("Invalid value for MAC size: " + macSize);
            }
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.nonce = parametersWithIV.getIV();
            this.initialAssociatedText = null;
            this.macSize = 16;
            keyParameter = (KeyParameter) parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to GCM");
        }
        this.bufBlock = new byte[z ? 16 : this.macSize + 16];
        byte[] bArr = this.nonce;
        if (bArr != null && bArr.length >= 1) {
            if (keyParameter != null) {
                this.cipher.init(true, keyParameter);
                byte[] bArr2 = new byte[16];
                this.H = bArr2;
                this.cipher.processBlock(bArr2, 0, bArr2, 0);
                this.multiplier.init(this.H);
                this.exp = null;
            } else if (this.H == null) {
                throw new IllegalArgumentException("Key must be specified in initial init");
            }
            byte[] bArr3 = new byte[16];
            this.J0 = bArr3;
            byte[] bArr4 = this.nonce;
            if (bArr4.length == 12) {
                System.arraycopy(bArr4, 0, bArr3, 0, bArr4.length);
                this.J0[15] = 1;
            } else {
                gHASH(bArr3, bArr4, bArr4.length);
                byte[] bArr5 = new byte[16];
                Pack.longToBigEndian(this.nonce.length * 8, bArr5, 8);
                gHASHBlock(this.J0, bArr5);
            }
            this.S = new byte[16];
            this.S_at = new byte[16];
            this.S_atPre = new byte[16];
            this.atBlock = new byte[16];
            this.atBlockPos = 0;
            this.atLength = 0L;
            this.atLengthPre = 0L;
            this.counter = Arrays.clone(this.J0);
            this.bufOff = 0;
            this.totalLength = 0L;
            byte[] bArr6 = this.initialAssociatedText;
            if (bArr6 != null) {
                processAADBytes(bArr6, 0, bArr6.length);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("IV must be at least 1 byte");
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void processAADByte(byte b2) {
        byte[] bArr = this.atBlock;
        int i2 = this.atBlockPos;
        bArr[i2] = b2;
        int i3 = i2 + 1;
        this.atBlockPos = i3;
        if (i3 == 16) {
            gHASHBlock(this.S_at, bArr);
            this.atBlockPos = 0;
            this.atLength += 16;
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void processAADBytes(byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            byte[] bArr2 = this.atBlock;
            int i5 = this.atBlockPos;
            bArr2[i5] = bArr[i2 + i4];
            int i6 = i5 + 1;
            this.atBlockPos = i6;
            if (i6 == 16) {
                gHASHBlock(this.S_at, bArr2);
                this.atBlockPos = 0;
                this.atLength += 16;
            }
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processByte(byte b2, byte[] bArr, int i2) throws DataLengthException {
        byte[] bArr2 = this.bufBlock;
        int i3 = this.bufOff;
        bArr2[i3] = b2;
        int i4 = i3 + 1;
        this.bufOff = i4;
        if (i4 == bArr2.length) {
            outputBlock(bArr, i2);
            return 16;
        }
        return 0;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException {
        if (bArr.length >= i2 + i3) {
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                byte[] bArr3 = this.bufBlock;
                int i7 = this.bufOff;
                bArr3[i7] = bArr[i2 + i6];
                int i8 = i7 + 1;
                this.bufOff = i8;
                if (i8 == bArr3.length) {
                    outputBlock(bArr2, i4 + i5);
                    i5 += 16;
                }
            }
            return i5;
        }
        throw new DataLengthException("Input buffer too short");
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void reset() {
        reset(true);
    }

    public GCMBlockCipher(BlockCipher blockCipher, GCMMultiplier gCMMultiplier) {
        if (blockCipher.getBlockSize() == 16) {
            gCMMultiplier = gCMMultiplier == null ? new Tables8kGCMMultiplier() : gCMMultiplier;
            this.cipher = blockCipher;
            this.multiplier = gCMMultiplier;
            return;
        }
        throw new IllegalArgumentException("cipher required with a block size of 16.");
    }

    private void reset(boolean z) {
        this.cipher.reset();
        this.S = new byte[16];
        this.S_at = new byte[16];
        this.S_atPre = new byte[16];
        this.atBlock = new byte[16];
        this.atBlockPos = 0;
        this.atLength = 0L;
        this.atLengthPre = 0L;
        this.counter = Arrays.clone(this.J0);
        this.bufOff = 0;
        this.totalLength = 0L;
        byte[] bArr = this.bufBlock;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
        if (z) {
            this.macBlock = null;
        }
        byte[] bArr2 = this.initialAssociatedText;
        if (bArr2 != null) {
            processAADBytes(bArr2, 0, bArr2.length);
        }
    }
}