package org.spongycastle.crypto.prng.drbg;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.encoders.Hex;

/* loaded from: classes3.dex */
public class CTRSP800DRBG implements SP80090DRBG {
    private static final int AES_MAX_BITS_REQUEST = 262144;
    private static final long AES_RESEED_MAX = 140737488355328L;
    private static final byte[] K_BITS = Hex.decode("000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F");
    private static final int TDEA_MAX_BITS_REQUEST = 4096;
    private static final long TDEA_RESEED_MAX = 2147483648L;
    private byte[] _Key;
    private byte[] _V;
    private BlockCipher _engine;
    private EntropySource _entropySource;
    private boolean _isTDEA;
    private int _keySizeInBits;
    private long _reseedCounter = 0;
    private int _securityStrength;
    private int _seedLength;

    public CTRSP800DRBG(BlockCipher blockCipher, int i2, int i3, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        this._isTDEA = false;
        this._entropySource = entropySource;
        this._engine = blockCipher;
        this._keySizeInBits = i2;
        this._securityStrength = i3;
        this._seedLength = (blockCipher.getBlockSize() * 8) + i2;
        this._isTDEA = isTDEA(blockCipher);
        if (i3 <= 256) {
            if (getMaxSecurityStrength(blockCipher, i2) >= i3) {
                if (entropySource.entropySize() >= i3) {
                    CTR_DRBG_Instantiate_algorithm(getEntropy(), bArr2, bArr);
                    return;
                }
                throw new IllegalArgumentException("Not enough entropy for security strength required");
            }
            throw new IllegalArgumentException("Requested security strength is not supported by block cipher and key size");
        }
        throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
    }

    private void BCC(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int blockSize = this._engine.getBlockSize();
        byte[] bArr5 = new byte[blockSize];
        int length = bArr4.length / blockSize;
        byte[] bArr6 = new byte[blockSize];
        this._engine.init(true, new KeyParameter(expandKey(bArr2)));
        this._engine.processBlock(bArr3, 0, bArr5, 0);
        for (int i2 = 0; i2 < length; i2++) {
            XOR(bArr6, bArr5, bArr4, i2 * blockSize);
            this._engine.processBlock(bArr6, 0, bArr5, 0);
        }
        System.arraycopy(bArr5, 0, bArr, 0, bArr.length);
    }

    private byte[] Block_Cipher_df(byte[] bArr, int i2) {
        int blockSize = this._engine.getBlockSize();
        int length = bArr.length;
        int i3 = length + 8;
        byte[] bArr2 = new byte[((((i3 + 1) + blockSize) - 1) / blockSize) * blockSize];
        copyIntToByteArray(bArr2, length, 0);
        copyIntToByteArray(bArr2, i2 / 8, 4);
        System.arraycopy(bArr, 0, bArr2, 8, length);
        bArr2[i3] = Byte.MIN_VALUE;
        int i4 = this._keySizeInBits;
        int i5 = (i4 / 8) + blockSize;
        byte[] bArr3 = new byte[i5];
        byte[] bArr4 = new byte[blockSize];
        byte[] bArr5 = new byte[blockSize];
        int i6 = i4 / 8;
        byte[] bArr6 = new byte[i6];
        System.arraycopy(K_BITS, 0, bArr6, 0, i6);
        int i7 = 0;
        while (true) {
            int i8 = i7 * blockSize;
            if (i8 * 8 >= this._keySizeInBits + (blockSize * 8)) {
                break;
            }
            copyIntToByteArray(bArr5, i7, 0);
            BCC(bArr4, bArr6, bArr5, bArr2);
            int i9 = i5 - i8;
            if (i9 > blockSize) {
                i9 = blockSize;
            }
            System.arraycopy(bArr4, 0, bArr3, i8, i9);
            i7++;
        }
        byte[] bArr7 = new byte[blockSize];
        System.arraycopy(bArr3, 0, bArr6, 0, i6);
        System.arraycopy(bArr3, i6, bArr7, 0, blockSize);
        int i10 = i2 / 2;
        byte[] bArr8 = new byte[i10];
        this._engine.init(true, new KeyParameter(expandKey(bArr6)));
        int i11 = 0;
        while (true) {
            int i12 = i11 * blockSize;
            if (i12 >= i10) {
                return bArr8;
            }
            this._engine.processBlock(bArr7, 0, bArr7, 0);
            int i13 = i10 - i12;
            if (i13 > blockSize) {
                i13 = blockSize;
            }
            System.arraycopy(bArr7, 0, bArr8, i12, i13);
            i11++;
        }
    }

    private void CTR_DRBG_Instantiate_algorithm(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] Block_Cipher_df = Block_Cipher_df(Arrays.concatenate(bArr, bArr2, bArr3), this._seedLength);
        int blockSize = this._engine.getBlockSize();
        byte[] bArr4 = new byte[(this._keySizeInBits + 7) / 8];
        this._Key = bArr4;
        byte[] bArr5 = new byte[blockSize];
        this._V = bArr5;
        CTR_DRBG_Update(Block_Cipher_df, bArr4, bArr5);
        this._reseedCounter = 1L;
    }

    private void CTR_DRBG_Reseed_algorithm(byte[] bArr) {
        CTR_DRBG_Update(Block_Cipher_df(Arrays.concatenate(getEntropy(), bArr), this._seedLength), this._Key, this._V);
        this._reseedCounter = 1L;
    }

    private void CTR_DRBG_Update(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int length = bArr.length;
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[this._engine.getBlockSize()];
        int blockSize = this._engine.getBlockSize();
        this._engine.init(true, new KeyParameter(expandKey(bArr2)));
        int i2 = 0;
        while (true) {
            int i3 = i2 * blockSize;
            if (i3 < bArr.length) {
                addOneTo(bArr3);
                this._engine.processBlock(bArr3, 0, bArr5, 0);
                int i4 = length - i3;
                if (i4 > blockSize) {
                    i4 = blockSize;
                }
                System.arraycopy(bArr5, 0, bArr4, i3, i4);
                i2++;
            } else {
                XOR(bArr4, bArr, bArr4, 0);
                System.arraycopy(bArr4, 0, bArr2, 0, bArr2.length);
                System.arraycopy(bArr4, bArr2.length, bArr3, 0, bArr3.length);
                return;
            }
        }
    }

    private void XOR(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2) {
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr[i3] = (byte) (bArr2[i3] ^ bArr3[i3 + i2]);
        }
    }

    private void addOneTo(byte[] bArr) {
        int i2 = 1;
        for (int i3 = 1; i3 <= bArr.length; i3++) {
            int i4 = (bArr[bArr.length - i3] & 255) + i2;
            i2 = i4 > 255 ? 1 : 0;
            bArr[bArr.length - i3] = (byte) i4;
        }
    }

    private void copyIntToByteArray(byte[] bArr, int i2, int i3) {
        bArr[i3 + 0] = (byte) (i2 >> 24);
        bArr[i3 + 1] = (byte) (i2 >> 16);
        bArr[i3 + 2] = (byte) (i2 >> 8);
        bArr[i3 + 3] = (byte) i2;
    }

    private byte[] getEntropy() {
        byte[] entropy = this._entropySource.getEntropy();
        if (entropy.length >= (this._securityStrength + 7) / 8) {
            return entropy;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    private int getMaxSecurityStrength(BlockCipher blockCipher, int i2) {
        if (isTDEA(blockCipher) && i2 == 168) {
            return 112;
        }
        if (blockCipher.getAlgorithmName().equals("AES")) {
            return i2;
        }
        return -1;
    }

    private boolean isTDEA(BlockCipher blockCipher) {
        return blockCipher.getAlgorithmName().equals("DESede") || blockCipher.getAlgorithmName().equals("TDEA");
    }

    private void padKey(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + 0;
        bArr2[i3 + 0] = (byte) (bArr[i4] & 254);
        int i5 = i2 + 1;
        bArr2[i3 + 1] = (byte) ((bArr[i4] << 7) | ((bArr[i5] & 252) >>> 1));
        int i6 = i2 + 2;
        bArr2[i3 + 2] = (byte) ((bArr[i5] << 6) | ((bArr[i6] & 248) >>> 2));
        int i7 = i2 + 3;
        bArr2[i3 + 3] = (byte) ((bArr[i6] << 5) | ((bArr[i7] & 240) >>> 3));
        int i8 = i2 + 4;
        bArr2[i3 + 4] = (byte) ((bArr[i7] << 4) | ((bArr[i8] & 224) >>> 4));
        int i9 = i2 + 5;
        bArr2[i3 + 5] = (byte) ((bArr[i8] << 3) | ((bArr[i9] & 192) >>> 5));
        int i10 = i2 + 6;
        bArr2[i3 + 6] = (byte) ((bArr[i9] << 2) | ((bArr[i10] & 128) >>> 6));
        int i11 = i3 + 7;
        bArr2[i11] = (byte) (bArr[i10] << 1);
        while (i3 <= i11) {
            byte b2 = bArr2[i3];
            bArr2[i3] = (byte) (((((b2 >> 7) ^ ((((((b2 >> 1) ^ (b2 >> 2)) ^ (b2 >> 3)) ^ (b2 >> 4)) ^ (b2 >> 5)) ^ (b2 >> 6))) ^ 1) & 1) | (b2 & 254));
            i3++;
        }
    }

    byte[] expandKey(byte[] bArr) {
        if (this._isTDEA) {
            byte[] bArr2 = new byte[24];
            padKey(bArr, 0, bArr2, 0);
            padKey(bArr, 7, bArr2, 8);
            padKey(bArr, 14, bArr2, 16);
            return bArr2;
        }
        return bArr;
    }

    @Override // org.spongycastle.crypto.prng.drbg.SP80090DRBG
    public int generate(byte[] bArr, byte[] bArr2, boolean z) {
        byte[] bArr3;
        if (this._isTDEA) {
            if (this._reseedCounter > TDEA_RESEED_MAX) {
                return -1;
            }
            if (Utils.isTooLarge(bArr, 512)) {
                throw new IllegalArgumentException("Number of bits per request limited to 4096");
            }
        } else if (this._reseedCounter > AES_RESEED_MAX) {
            return -1;
        } else {
            if (Utils.isTooLarge(bArr, 32768)) {
                throw new IllegalArgumentException("Number of bits per request limited to 262144");
            }
        }
        if (z) {
            CTR_DRBG_Reseed_algorithm(bArr2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            bArr3 = Block_Cipher_df(bArr2, this._seedLength);
            CTR_DRBG_Update(bArr3, this._Key, this._V);
        } else {
            bArr3 = new byte[this._seedLength];
        }
        int length = this._V.length;
        byte[] bArr4 = new byte[length];
        this._engine.init(true, new KeyParameter(expandKey(this._Key)));
        for (int i2 = 0; i2 <= bArr.length / length; i2++) {
            int i3 = i2 * length;
            int length2 = bArr.length - i3 > length ? length : bArr.length - (this._V.length * i2);
            if (length2 != 0) {
                addOneTo(this._V);
                this._engine.processBlock(this._V, 0, bArr4, 0);
                System.arraycopy(bArr4, 0, bArr, i3, length2);
            }
        }
        CTR_DRBG_Update(bArr3, this._Key, this._V);
        this._reseedCounter++;
        return bArr.length * 8;
    }

    @Override // org.spongycastle.crypto.prng.drbg.SP80090DRBG
    public int getBlockSize() {
        return this._V.length * 8;
    }

    @Override // org.spongycastle.crypto.prng.drbg.SP80090DRBG
    public void reseed(byte[] bArr) {
        CTR_DRBG_Reseed_algorithm(bArr);
    }
}