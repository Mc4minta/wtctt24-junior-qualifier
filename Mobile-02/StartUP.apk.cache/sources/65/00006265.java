package org.spongycastle.crypto.modes;

import java.util.Vector;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class OCBBlockCipher implements AEADBlockCipher {
    private static final int BLOCK_SIZE = 16;
    private byte[] Checksum;
    private Vector L;
    private byte[] L_Asterisk;
    private byte[] L_Dollar;
    private byte[] OffsetHASH;
    private byte[] Sum;
    private boolean forEncryption;
    private byte[] hashBlock;
    private long hashBlockCount;
    private int hashBlockPos;
    private BlockCipher hashCipher;
    private byte[] initialAssociatedText;
    private byte[] macBlock;
    private int macSize;
    private byte[] mainBlock;
    private long mainBlockCount;
    private int mainBlockPos;
    private BlockCipher mainCipher;
    private byte[] KtopInput = null;
    private byte[] Stretch = new byte[24];
    private byte[] OffsetMAIN_0 = new byte[16];
    private byte[] OffsetMAIN = new byte[16];

    public OCBBlockCipher(BlockCipher blockCipher, BlockCipher blockCipher2) {
        if (blockCipher != null) {
            if (blockCipher.getBlockSize() != 16) {
                throw new IllegalArgumentException("'hashCipher' must have a block size of 16");
            }
            if (blockCipher2 != null) {
                if (blockCipher2.getBlockSize() == 16) {
                    if (blockCipher.getAlgorithmName().equals(blockCipher2.getAlgorithmName())) {
                        this.hashCipher = blockCipher;
                        this.mainCipher = blockCipher2;
                        return;
                    }
                    throw new IllegalArgumentException("'hashCipher' and 'mainCipher' must be the same algorithm");
                }
                throw new IllegalArgumentException("'mainCipher' must have a block size of 16");
            }
            throw new IllegalArgumentException("'mainCipher' cannot be null");
        }
        throw new IllegalArgumentException("'hashCipher' cannot be null");
    }

    protected static byte[] OCB_double(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int shiftLeft = shiftLeft(bArr, bArr2);
        bArr2[15] = (byte) ((CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA >>> ((1 - shiftLeft) << 3)) ^ bArr2[15]);
        return bArr2;
    }

    protected static void OCB_extend(byte[] bArr, int i2) {
        bArr[i2] = Byte.MIN_VALUE;
        while (true) {
            i2++;
            if (i2 >= 16) {
                return;
            }
            bArr[i2] = 0;
        }
    }

    protected static int OCB_ntz(long j2) {
        if (j2 == 0) {
            return 64;
        }
        int i2 = 0;
        while ((1 & j2) == 0) {
            i2++;
            j2 >>>= 1;
        }
        return i2;
    }

    protected static int shiftLeft(byte[] bArr, byte[] bArr2) {
        int i2 = 16;
        int i3 = 0;
        while (true) {
            i2--;
            if (i2 < 0) {
                return i3;
            }
            int i4 = bArr[i2] & 255;
            bArr2[i2] = (byte) (i3 | (i4 << 1));
            i3 = (i4 >>> 7) & 1;
        }
    }

    protected static void xor(byte[] bArr, byte[] bArr2) {
        for (int i2 = 15; i2 >= 0; i2--) {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
        }
    }

    protected void clear(byte[] bArr) {
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int doFinal(byte[] bArr, int i2) throws IllegalStateException, InvalidCipherTextException {
        byte[] bArr2;
        if (this.forEncryption) {
            bArr2 = null;
        } else {
            int i3 = this.mainBlockPos;
            int i4 = this.macSize;
            if (i3 >= i4) {
                int i5 = i3 - i4;
                this.mainBlockPos = i5;
                bArr2 = new byte[i4];
                System.arraycopy(this.mainBlock, i5, bArr2, 0, i4);
            } else {
                throw new InvalidCipherTextException("data too short");
            }
        }
        int i6 = this.hashBlockPos;
        if (i6 > 0) {
            OCB_extend(this.hashBlock, i6);
            updateHASH(this.L_Asterisk);
        }
        int i7 = this.mainBlockPos;
        if (i7 > 0) {
            if (this.forEncryption) {
                OCB_extend(this.mainBlock, i7);
                xor(this.Checksum, this.mainBlock);
            }
            xor(this.OffsetMAIN, this.L_Asterisk);
            byte[] bArr3 = new byte[16];
            this.hashCipher.processBlock(this.OffsetMAIN, 0, bArr3, 0);
            xor(this.mainBlock, bArr3);
            int length = bArr.length;
            int i8 = this.mainBlockPos;
            if (length >= i2 + i8) {
                System.arraycopy(this.mainBlock, 0, bArr, i2, i8);
                if (!this.forEncryption) {
                    OCB_extend(this.mainBlock, this.mainBlockPos);
                    xor(this.Checksum, this.mainBlock);
                }
            } else {
                throw new OutputLengthException("Output buffer too short");
            }
        }
        xor(this.Checksum, this.OffsetMAIN);
        xor(this.Checksum, this.L_Dollar);
        BlockCipher blockCipher = this.hashCipher;
        byte[] bArr4 = this.Checksum;
        blockCipher.processBlock(bArr4, 0, bArr4, 0);
        xor(this.Checksum, this.Sum);
        int i9 = this.macSize;
        byte[] bArr5 = new byte[i9];
        this.macBlock = bArr5;
        System.arraycopy(this.Checksum, 0, bArr5, 0, i9);
        int i10 = this.mainBlockPos;
        if (this.forEncryption) {
            int length2 = bArr.length;
            int i11 = i2 + i10;
            int i12 = this.macSize;
            if (length2 >= i11 + i12) {
                System.arraycopy(this.macBlock, 0, bArr, i11, i12);
                i10 += this.macSize;
            } else {
                throw new OutputLengthException("Output buffer too short");
            }
        } else if (!Arrays.constantTimeAreEqual(this.macBlock, bArr2)) {
            throw new InvalidCipherTextException("mac check in OCB failed");
        }
        reset(false);
        return i10;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public String getAlgorithmName() {
        return this.mainCipher.getAlgorithmName() + "/OCB";
    }

    protected byte[] getLSub(int i2) {
        while (i2 >= this.L.size()) {
            Vector vector = this.L;
            vector.addElement(OCB_double((byte[]) vector.lastElement()));
        }
        return (byte[]) this.L.elementAt(i2);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public byte[] getMac() {
        return Arrays.clone(this.macBlock);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getOutputSize(int i2) {
        int i3 = i2 + this.mainBlockPos;
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
        return this.mainCipher;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getUpdateOutputSize(int i2) {
        int i3 = i2 + this.mainBlockPos;
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
        byte[] iv;
        KeyParameter keyParameter;
        boolean z2 = this.forEncryption;
        this.forEncryption = z;
        this.macBlock = null;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            iv = aEADParameters.getNonce();
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            int macSize = aEADParameters.getMacSize();
            if (macSize >= 64 && macSize <= 128 && macSize % 8 == 0) {
                this.macSize = macSize / 8;
                keyParameter = aEADParameters.getKey();
            } else {
                throw new IllegalArgumentException("Invalid value for MAC size: " + macSize);
            }
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            iv = parametersWithIV.getIV();
            this.initialAssociatedText = null;
            this.macSize = 16;
            keyParameter = (KeyParameter) parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to OCB");
        }
        this.hashBlock = new byte[16];
        this.mainBlock = new byte[z ? 16 : this.macSize + 16];
        if (iv == null) {
            iv = new byte[0];
        }
        if (iv.length <= 15) {
            if (keyParameter != null) {
                this.hashCipher.init(true, keyParameter);
                this.mainCipher.init(z, keyParameter);
                this.KtopInput = null;
            } else if (z2 != z) {
                throw new IllegalArgumentException("cannot change encrypting state without providing key.");
            }
            byte[] bArr = new byte[16];
            this.L_Asterisk = bArr;
            this.hashCipher.processBlock(bArr, 0, bArr, 0);
            this.L_Dollar = OCB_double(this.L_Asterisk);
            Vector vector = new Vector();
            this.L = vector;
            vector.addElement(OCB_double(this.L_Dollar));
            int processNonce = processNonce(iv);
            int i2 = processNonce % 8;
            int i3 = processNonce / 8;
            if (i2 == 0) {
                System.arraycopy(this.Stretch, i3, this.OffsetMAIN_0, 0, 16);
            } else {
                for (int i4 = 0; i4 < 16; i4++) {
                    byte[] bArr2 = this.Stretch;
                    i3++;
                    this.OffsetMAIN_0[i4] = (byte) (((bArr2[i3] & 255) >>> (8 - i2)) | ((bArr2[i3] & 255) << i2));
                }
            }
            this.hashBlockPos = 0;
            this.mainBlockPos = 0;
            this.hashBlockCount = 0L;
            this.mainBlockCount = 0L;
            this.OffsetHASH = new byte[16];
            this.Sum = new byte[16];
            System.arraycopy(this.OffsetMAIN_0, 0, this.OffsetMAIN, 0, 16);
            this.Checksum = new byte[16];
            byte[] bArr3 = this.initialAssociatedText;
            if (bArr3 != null) {
                processAADBytes(bArr3, 0, bArr3.length);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("IV must be no more than 15 bytes");
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void processAADByte(byte b2) {
        byte[] bArr = this.hashBlock;
        int i2 = this.hashBlockPos;
        bArr[i2] = b2;
        int i3 = i2 + 1;
        this.hashBlockPos = i3;
        if (i3 == bArr.length) {
            processHashBlock();
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void processAADBytes(byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            byte[] bArr2 = this.hashBlock;
            int i5 = this.hashBlockPos;
            bArr2[i5] = bArr[i2 + i4];
            int i6 = i5 + 1;
            this.hashBlockPos = i6;
            if (i6 == bArr2.length) {
                processHashBlock();
            }
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processByte(byte b2, byte[] bArr, int i2) throws DataLengthException {
        byte[] bArr2 = this.mainBlock;
        int i3 = this.mainBlockPos;
        bArr2[i3] = b2;
        int i4 = i3 + 1;
        this.mainBlockPos = i4;
        if (i4 == bArr2.length) {
            processMainBlock(bArr, i2);
            return 16;
        }
        return 0;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException {
        if (bArr.length >= i2 + i3) {
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                byte[] bArr3 = this.mainBlock;
                int i7 = this.mainBlockPos;
                bArr3[i7] = bArr[i2 + i6];
                int i8 = i7 + 1;
                this.mainBlockPos = i8;
                if (i8 == bArr3.length) {
                    processMainBlock(bArr2, i4 + i5);
                    i5 += 16;
                }
            }
            return i5;
        }
        throw new DataLengthException("Input buffer too short");
    }

    protected void processHashBlock() {
        long j2 = this.hashBlockCount + 1;
        this.hashBlockCount = j2;
        updateHASH(getLSub(OCB_ntz(j2)));
        this.hashBlockPos = 0;
    }

    protected void processMainBlock(byte[] bArr, int i2) {
        if (bArr.length >= i2 + 16) {
            if (this.forEncryption) {
                xor(this.Checksum, this.mainBlock);
                this.mainBlockPos = 0;
            }
            byte[] bArr2 = this.OffsetMAIN;
            long j2 = this.mainBlockCount + 1;
            this.mainBlockCount = j2;
            xor(bArr2, getLSub(OCB_ntz(j2)));
            xor(this.mainBlock, this.OffsetMAIN);
            BlockCipher blockCipher = this.mainCipher;
            byte[] bArr3 = this.mainBlock;
            blockCipher.processBlock(bArr3, 0, bArr3, 0);
            xor(this.mainBlock, this.OffsetMAIN);
            System.arraycopy(this.mainBlock, 0, bArr, i2, 16);
            if (this.forEncryption) {
                return;
            }
            xor(this.Checksum, this.mainBlock);
            byte[] bArr4 = this.mainBlock;
            System.arraycopy(bArr4, 16, bArr4, 0, this.macSize);
            this.mainBlockPos = this.macSize;
            return;
        }
        throw new OutputLengthException("Output buffer too short");
    }

    protected int processNonce(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i2 = 0;
        System.arraycopy(bArr, 0, bArr2, 16 - bArr.length, bArr.length);
        bArr2[0] = (byte) (this.macSize << 4);
        int length = 15 - bArr.length;
        bArr2[length] = (byte) (bArr2[length] | 1);
        int i3 = bArr2[15] & 63;
        bArr2[15] = (byte) (bArr2[15] & 192);
        byte[] bArr3 = this.KtopInput;
        if (bArr3 == null || !Arrays.areEqual(bArr2, bArr3)) {
            byte[] bArr4 = new byte[16];
            this.KtopInput = bArr2;
            this.hashCipher.processBlock(bArr2, 0, bArr4, 0);
            System.arraycopy(bArr4, 0, this.Stretch, 0, 16);
            while (i2 < 8) {
                byte[] bArr5 = this.Stretch;
                int i4 = i2 + 16;
                byte b2 = bArr4[i2];
                i2++;
                bArr5[i4] = (byte) (b2 ^ bArr4[i2]);
            }
        }
        return i3;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void reset() {
        reset(true);
    }

    protected void updateHASH(byte[] bArr) {
        xor(this.OffsetHASH, bArr);
        xor(this.hashBlock, this.OffsetHASH);
        BlockCipher blockCipher = this.hashCipher;
        byte[] bArr2 = this.hashBlock;
        blockCipher.processBlock(bArr2, 0, bArr2, 0);
        xor(this.Sum, this.hashBlock);
    }

    protected void reset(boolean z) {
        this.hashCipher.reset();
        this.mainCipher.reset();
        clear(this.hashBlock);
        clear(this.mainBlock);
        this.hashBlockPos = 0;
        this.mainBlockPos = 0;
        this.hashBlockCount = 0L;
        this.mainBlockCount = 0L;
        clear(this.OffsetHASH);
        clear(this.Sum);
        System.arraycopy(this.OffsetMAIN_0, 0, this.OffsetMAIN, 0, 16);
        clear(this.Checksum);
        if (z) {
            this.macBlock = null;
        }
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }
}