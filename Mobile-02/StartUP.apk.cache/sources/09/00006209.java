package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

/* loaded from: classes3.dex */
public class Shacal2Engine implements BlockCipher {
    private static final int BLOCK_SIZE = 32;
    private static final int[] K = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    private static final int ROUNDS = 64;
    private boolean forEncryption = false;
    private int[] workingKey = null;

    private void byteBlockToInts(byte[] bArr, int[] iArr, int i2, int i3) {
        while (i3 < 8) {
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
            int i7 = i5 + 1;
            iArr[i3] = i6 | ((bArr[i5] & 255) << 8) | (bArr[i7] & 255);
            i3++;
            i2 = i7 + 1;
        }
    }

    private void bytes2ints(byte[] bArr, int[] iArr, int i2, int i3) {
        while (i3 < bArr.length / 4) {
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
            int i7 = i5 + 1;
            int i8 = i6 | ((bArr[i5] & 255) << 8);
            iArr[i3] = i8 | (bArr[i7] & 255);
            i3++;
            i2 = i7 + 1;
        }
    }

    private void decryptBlock(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int[] iArr = new int[8];
        byteBlockToInts(bArr, iArr, i2, 0);
        for (int i4 = 63; i4 > -1; i4--) {
            int i5 = (iArr[0] - ((((iArr[1] >>> 2) | (iArr[1] << (-2))) ^ ((iArr[1] >>> 13) | (iArr[1] << (-13)))) ^ ((iArr[1] >>> 22) | (iArr[1] << (-22))))) - (((iArr[1] & iArr[2]) ^ (iArr[1] & iArr[3])) ^ (iArr[2] & iArr[3]));
            iArr[0] = iArr[1];
            iArr[1] = iArr[2];
            iArr[2] = iArr[3];
            iArr[3] = iArr[4] - i5;
            iArr[4] = iArr[5];
            iArr[5] = iArr[6];
            iArr[6] = iArr[7];
            iArr[7] = (((i5 - K[i4]) - this.workingKey[i4]) - ((((iArr[4] >>> 6) | (iArr[4] << (-6))) ^ ((iArr[4] >>> 11) | (iArr[4] << (-11)))) ^ ((iArr[4] >>> 25) | (iArr[4] << (-25))))) - (((~iArr[4]) & iArr[6]) ^ (iArr[5] & iArr[4]));
        }
        ints2bytes(iArr, bArr2, i3);
    }

    private void encryptBlock(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int[] iArr = new int[8];
        byteBlockToInts(bArr, iArr, i2, 0);
        for (int i4 = 0; i4 < 64; i4++) {
            int i5 = ((((iArr[4] >>> 6) | (iArr[4] << (-6))) ^ ((iArr[4] >>> 11) | (iArr[4] << (-11)))) ^ ((iArr[4] >>> 25) | (iArr[4] << (-25)))) + ((iArr[4] & iArr[5]) ^ ((~iArr[4]) & iArr[6])) + iArr[7] + K[i4] + this.workingKey[i4];
            iArr[7] = iArr[6];
            iArr[6] = iArr[5];
            iArr[5] = iArr[4];
            iArr[4] = iArr[3] + i5;
            iArr[3] = iArr[2];
            iArr[2] = iArr[1];
            iArr[1] = iArr[0];
            iArr[0] = i5 + ((((iArr[0] >>> 2) | (iArr[0] << (-2))) ^ ((iArr[0] >>> 13) | (iArr[0] << (-13)))) ^ ((iArr[0] >>> 22) | (iArr[0] << (-22)))) + ((iArr[2] & iArr[3]) ^ ((iArr[0] & iArr[2]) ^ (iArr[0] & iArr[3])));
        }
        ints2bytes(iArr, bArr2, i3);
    }

    private void ints2bytes(int[] iArr, byte[] bArr, int i2) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i4 = i2 + 1;
            bArr[i2] = (byte) (iArr[i3] >>> 24);
            int i5 = i4 + 1;
            bArr[i4] = (byte) (iArr[i3] >>> 16);
            int i6 = i5 + 1;
            bArr[i5] = (byte) (iArr[i3] >>> 8);
            i2 = i6 + 1;
            bArr[i6] = (byte) iArr[i3];
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Shacal2";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 32;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            this.forEncryption = z;
            this.workingKey = new int[64];
            setKey(((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("only simple KeyParameter expected.");
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i2, byte[] bArr2, int i3) throws DataLengthException, IllegalStateException {
        if (this.workingKey != null) {
            if (i2 + 32 <= bArr.length) {
                if (i3 + 32 <= bArr2.length) {
                    if (this.forEncryption) {
                        encryptBlock(bArr, i2, bArr2, i3);
                        return 32;
                    }
                    decryptBlock(bArr, i2, bArr2, i3);
                    return 32;
                }
                throw new OutputLengthException("output buffer too short");
            }
            throw new DataLengthException("input buffer too short");
        }
        throw new IllegalStateException("Shacal2 not initialised");
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }

    public void setKey(byte[] bArr) {
        if (bArr.length != 0 && bArr.length <= 64) {
            if (bArr.length >= 16 && bArr.length % 8 == 0) {
                bytes2ints(bArr, this.workingKey, 0, 0);
                for (int i2 = 16; i2 < 64; i2++) {
                    int[] iArr = this.workingKey;
                    int i3 = i2 - 2;
                    int i4 = i2 - 15;
                    iArr[i2] = ((iArr[i3] >>> 10) ^ (((iArr[i3] >>> 17) | (iArr[i3] << (-17))) ^ ((iArr[i3] >>> 19) | (iArr[i3] << (-19))))) + iArr[i2 - 7] + ((iArr[i4] >>> 3) ^ (((iArr[i4] >>> 7) | (iArr[i4] << (-7))) ^ ((iArr[i4] >>> 18) | (iArr[i4] << (-18))))) + iArr[i2 - 16];
                }
                return;
            }
        }
        throw new IllegalArgumentException("Shacal2-key must be 16 - 64 bytes and multiple of 8");
    }
}