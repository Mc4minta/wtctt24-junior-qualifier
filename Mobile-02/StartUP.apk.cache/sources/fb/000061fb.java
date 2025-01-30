package org.spongycastle.crypto.engines;

import java.security.SecureRandom;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;

/* loaded from: classes3.dex */
public class RFC3211WrapEngine implements Wrapper {
    private CBCBlockCipher engine;
    private boolean forWrapping;
    private ParametersWithIV param;
    private SecureRandom rand;

    public RFC3211WrapEngine(BlockCipher blockCipher) {
        this.engine = new CBCBlockCipher(blockCipher);
    }

    @Override // org.spongycastle.crypto.Wrapper
    public String getAlgorithmName() {
        return this.engine.getUnderlyingCipher().getAlgorithmName() + "/RFC3211Wrap";
    }

    @Override // org.spongycastle.crypto.Wrapper
    public void init(boolean z, CipherParameters cipherParameters) {
        this.forWrapping = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.rand = parametersWithRandom.getRandom();
            this.param = (ParametersWithIV) parametersWithRandom.getParameters();
            return;
        }
        if (z) {
            this.rand = new SecureRandom();
        }
        this.param = (ParametersWithIV) cipherParameters;
    }

    @Override // org.spongycastle.crypto.Wrapper
    public byte[] unwrap(byte[] bArr, int i2, int i3) throws InvalidCipherTextException {
        if (!this.forWrapping) {
            int blockSize = this.engine.getBlockSize();
            if (i3 >= blockSize * 2) {
                byte[] bArr2 = new byte[i3];
                byte[] bArr3 = new byte[blockSize];
                int i4 = 0;
                System.arraycopy(bArr, i2, bArr2, 0, i3);
                System.arraycopy(bArr, i2, bArr3, 0, blockSize);
                this.engine.init(false, new ParametersWithIV(this.param.getParameters(), bArr3));
                for (int i5 = blockSize; i5 < i3; i5 += blockSize) {
                    this.engine.processBlock(bArr2, i5, bArr2, i5);
                }
                System.arraycopy(bArr2, i3 - blockSize, bArr3, 0, blockSize);
                this.engine.init(false, new ParametersWithIV(this.param.getParameters(), bArr3));
                this.engine.processBlock(bArr2, 0, bArr2, 0);
                this.engine.init(false, this.param);
                for (int i6 = 0; i6 < i3; i6 += blockSize) {
                    this.engine.processBlock(bArr2, i6, bArr2, i6);
                }
                if ((bArr2[0] & 255) <= i3 - 4) {
                    byte[] bArr4 = new byte[bArr2[0] & 255];
                    System.arraycopy(bArr2, 4, bArr4, 0, bArr2[0]);
                    int i7 = 0;
                    while (i4 != 3) {
                        int i8 = i4 + 1;
                        i7 |= ((byte) (~bArr2[i8])) ^ bArr4[i4];
                        i4 = i8;
                    }
                    if (i7 == 0) {
                        return bArr4;
                    }
                    throw new InvalidCipherTextException("wrapped key fails checksum");
                }
                throw new InvalidCipherTextException("wrapped key corrupted");
            }
            throw new InvalidCipherTextException("input too short");
        }
        throw new IllegalStateException("not set for unwrapping");
    }

    @Override // org.spongycastle.crypto.Wrapper
    public byte[] wrap(byte[] bArr, int i2, int i3) {
        byte[] bArr2;
        if (this.forWrapping) {
            this.engine.init(true, this.param);
            int blockSize = this.engine.getBlockSize();
            int i4 = i3 + 4;
            int i5 = blockSize * 2;
            if (i4 < i5) {
                bArr2 = new byte[i5];
            } else {
                bArr2 = new byte[i4 % blockSize == 0 ? i4 : ((i4 / blockSize) + 1) * blockSize];
            }
            bArr2[0] = (byte) i3;
            bArr2[1] = (byte) (~bArr[i2]);
            bArr2[2] = (byte) (~bArr[i2 + 1]);
            bArr2[3] = (byte) (~bArr[i2 + 2]);
            System.arraycopy(bArr, i2, bArr2, 4, i3);
            int length = bArr2.length - i4;
            byte[] bArr3 = new byte[length];
            this.rand.nextBytes(bArr3);
            System.arraycopy(bArr3, 0, bArr2, i4, length);
            for (int i6 = 0; i6 < bArr2.length; i6 += blockSize) {
                this.engine.processBlock(bArr2, i6, bArr2, i6);
            }
            for (int i7 = 0; i7 < bArr2.length; i7 += blockSize) {
                this.engine.processBlock(bArr2, i7, bArr2, i7);
            }
            return bArr2;
        }
        throw new IllegalStateException("not set for wrapping");
    }
}