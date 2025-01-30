package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public class RFC5649WrapEngine implements Wrapper {
    private BlockCipher engine;
    private byte[] extractedAIV = null;
    private boolean forWrapping;
    private byte[] highOrderIV;
    private KeyParameter param;
    private byte[] preIV;

    public RFC5649WrapEngine(BlockCipher blockCipher) {
        byte[] bArr = {-90, 89, 89, -90};
        this.highOrderIV = bArr;
        this.preIV = bArr;
        this.engine = blockCipher;
    }

    private byte[] padPlaintext(byte[] bArr) {
        int length = bArr.length;
        int i2 = (8 - (length % 8)) % 8;
        byte[] bArr2 = new byte[length + i2];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        if (i2 != 0) {
            System.arraycopy(new byte[i2], 0, bArr2, length, i2);
        }
        return bArr2;
    }

    private byte[] rfc3394UnwrapNoIvCheck(byte[] bArr, int i2, int i3) {
        int i4 = i3 - 8;
        byte[] bArr2 = new byte[i4];
        byte[] bArr3 = new byte[8];
        byte[] bArr4 = new byte[16];
        System.arraycopy(bArr, i2, bArr3, 0, 8);
        System.arraycopy(bArr, i2 + 8, bArr2, 0, i4);
        this.engine.init(false, this.param);
        int i5 = (i3 / 8) - 1;
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = i5; i7 >= 1; i7--) {
                System.arraycopy(bArr3, 0, bArr4, 0, 8);
                int i8 = (i7 - 1) * 8;
                System.arraycopy(bArr2, i8, bArr4, 8, 8);
                int i9 = (i5 * i6) + i7;
                int i10 = 1;
                while (i9 != 0) {
                    int i11 = 8 - i10;
                    bArr4[i11] = (byte) (((byte) i9) ^ bArr4[i11]);
                    i9 >>>= 8;
                    i10++;
                }
                this.engine.processBlock(bArr4, 0, bArr4, 0);
                System.arraycopy(bArr4, 0, bArr3, 0, 8);
                System.arraycopy(bArr4, 8, bArr2, i8, 8);
            }
        }
        this.extractedAIV = bArr3;
        return bArr2;
    }

    @Override // org.spongycastle.crypto.Wrapper
    public String getAlgorithmName() {
        return this.engine.getAlgorithmName();
    }

    @Override // org.spongycastle.crypto.Wrapper
    public void init(boolean z, CipherParameters cipherParameters) {
        this.forWrapping = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        if (cipherParameters instanceof KeyParameter) {
            this.param = (KeyParameter) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.preIV = parametersWithIV.getIV();
            this.param = (KeyParameter) parametersWithIV.getParameters();
            if (this.preIV.length != 4) {
                throw new IllegalArgumentException("IV length not equal to 4");
            }
        }
    }

    @Override // org.spongycastle.crypto.Wrapper
    public byte[] unwrap(byte[] bArr, int i2, int i3) throws InvalidCipherTextException {
        byte[] rfc3394UnwrapNoIvCheck;
        if (!this.forWrapping) {
            int i4 = i3 / 8;
            if (i4 * 8 == i3) {
                if (i4 != 1) {
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(bArr, i2, bArr2, 0, i3);
                    byte[] bArr3 = new byte[i3];
                    if (i4 == 2) {
                        this.engine.init(false, this.param);
                        int i5 = 0;
                        while (i5 < i3) {
                            this.engine.processBlock(bArr2, i5, bArr3, i5);
                            i5 += this.engine.getBlockSize();
                        }
                        byte[] bArr4 = new byte[8];
                        this.extractedAIV = bArr4;
                        System.arraycopy(bArr3, 0, bArr4, 0, bArr4.length);
                        byte[] bArr5 = this.extractedAIV;
                        int length = i3 - bArr5.length;
                        rfc3394UnwrapNoIvCheck = new byte[length];
                        System.arraycopy(bArr3, bArr5.length, rfc3394UnwrapNoIvCheck, 0, length);
                    } else {
                        rfc3394UnwrapNoIvCheck = rfc3394UnwrapNoIvCheck(bArr, i2, i3);
                    }
                    byte[] bArr6 = new byte[4];
                    byte[] bArr7 = new byte[4];
                    System.arraycopy(this.extractedAIV, 0, bArr6, 0, 4);
                    System.arraycopy(this.extractedAIV, 4, bArr7, 0, 4);
                    int bigEndianToInt = Pack.bigEndianToInt(bArr7, 0);
                    boolean constantTimeAreEqual = Arrays.constantTimeAreEqual(bArr6, this.preIV);
                    int length2 = rfc3394UnwrapNoIvCheck.length;
                    if (bigEndianToInt <= length2 - 8) {
                        constantTimeAreEqual = false;
                    }
                    if (bigEndianToInt > length2) {
                        constantTimeAreEqual = false;
                    }
                    int i6 = length2 - bigEndianToInt;
                    if (i6 >= rfc3394UnwrapNoIvCheck.length) {
                        i6 = rfc3394UnwrapNoIvCheck.length;
                        constantTimeAreEqual = false;
                    }
                    byte[] bArr8 = new byte[i6];
                    System.arraycopy(rfc3394UnwrapNoIvCheck, rfc3394UnwrapNoIvCheck.length - i6, bArr8, 0, i6);
                    if (!Arrays.constantTimeAreEqual(bArr8, new byte[i6])) {
                        constantTimeAreEqual = false;
                    }
                    if (constantTimeAreEqual) {
                        byte[] bArr9 = new byte[bigEndianToInt];
                        System.arraycopy(rfc3394UnwrapNoIvCheck, 0, bArr9, 0, bigEndianToInt);
                        return bArr9;
                    }
                    throw new InvalidCipherTextException("checksum failed");
                }
                throw new InvalidCipherTextException("unwrap data must be at least 16 bytes");
            }
            throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
        }
        throw new IllegalStateException("not set for unwrapping");
    }

    @Override // org.spongycastle.crypto.Wrapper
    public byte[] wrap(byte[] bArr, int i2, int i3) {
        if (this.forWrapping) {
            byte[] bArr2 = new byte[8];
            byte[] intToBigEndian = Pack.intToBigEndian(i3);
            byte[] bArr3 = this.preIV;
            int i4 = 0;
            System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
            System.arraycopy(intToBigEndian, 0, bArr2, this.preIV.length, intToBigEndian.length);
            byte[] bArr4 = new byte[i3];
            System.arraycopy(bArr, i2, bArr4, 0, i3);
            byte[] padPlaintext = padPlaintext(bArr4);
            if (padPlaintext.length == 8) {
                int length = padPlaintext.length + 8;
                byte[] bArr5 = new byte[length];
                System.arraycopy(bArr2, 0, bArr5, 0, 8);
                System.arraycopy(padPlaintext, 0, bArr5, 8, padPlaintext.length);
                this.engine.init(true, this.param);
                while (i4 < length) {
                    this.engine.processBlock(bArr5, i4, bArr5, i4);
                    i4 += this.engine.getBlockSize();
                }
                return bArr5;
            }
            RFC3394WrapEngine rFC3394WrapEngine = new RFC3394WrapEngine(this.engine);
            rFC3394WrapEngine.init(true, new ParametersWithIV(this.param, bArr2));
            return rFC3394WrapEngine.wrap(padPlaintext, 0, padPlaintext.length);
        }
        throw new IllegalStateException("not set for wrapping");
    }
}