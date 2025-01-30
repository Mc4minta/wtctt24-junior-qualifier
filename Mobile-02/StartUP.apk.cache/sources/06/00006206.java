package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.MaxBytesExceededException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.SkippingStreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Pack;
import org.spongycastle.util.Strings;

/* loaded from: classes3.dex */
public class Salsa20Engine implements SkippingStreamCipher {
    public static final int DEFAULT_ROUNDS = 20;
    private static final int STATE_SIZE = 16;
    protected static final byte[] sigma = Strings.toByteArray("expand 32-byte k");
    protected static final byte[] tau = Strings.toByteArray("expand 16-byte k");
    private int cW0;
    private int cW1;
    private int cW2;
    protected int[] engineState;
    private int index;
    private boolean initialised;
    private byte[] keyStream;
    protected int rounds;
    protected int[] x;

    public Salsa20Engine() {
        this(20);
    }

    private boolean limitExceeded() {
        int i2 = this.cW0 + 1;
        this.cW0 = i2;
        if (i2 == 0) {
            int i3 = this.cW1 + 1;
            this.cW1 = i3;
            if (i3 == 0) {
                int i4 = this.cW2 + 1;
                this.cW2 = i4;
                return (i4 & 32) != 0;
            }
        }
        return false;
    }

    private void resetLimitCounter() {
        this.cW0 = 0;
        this.cW1 = 0;
        this.cW2 = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int rotl(int i2, int i3) {
        return (i2 >>> (-i3)) | (i2 << i3);
    }

    public static void salsaCore(int i2, int[] iArr, int[] iArr2) {
        if (iArr.length == 16) {
            if (iArr2.length == 16) {
                if (i2 % 2 == 0) {
                    char c2 = 0;
                    int i3 = iArr[0];
                    int i4 = iArr[1];
                    int i5 = iArr[2];
                    int i6 = iArr[3];
                    int i7 = iArr[4];
                    int i8 = iArr[5];
                    int i9 = iArr[6];
                    int i10 = 7;
                    int i11 = iArr[7];
                    int i12 = iArr[8];
                    int i13 = 9;
                    int i14 = iArr[9];
                    int i15 = iArr[10];
                    int i16 = iArr[11];
                    int i17 = iArr[12];
                    int i18 = 13;
                    int i19 = iArr[13];
                    int i20 = iArr[14];
                    int i21 = iArr[15];
                    int i22 = i20;
                    int i23 = i19;
                    int i24 = i17;
                    int i25 = i16;
                    int i26 = i15;
                    int i27 = i14;
                    int i28 = i12;
                    int i29 = i11;
                    int i30 = i9;
                    int i31 = i8;
                    int i32 = i7;
                    int i33 = i6;
                    int i34 = i5;
                    int i35 = i4;
                    int i36 = i3;
                    int i37 = i2;
                    while (i37 > 0) {
                        int rotl = rotl(i36 + i24, i10) ^ i32;
                        int rotl2 = i28 ^ rotl(rotl + i36, i13);
                        int rotl3 = i24 ^ rotl(rotl2 + rotl, i18);
                        int rotl4 = rotl(rotl3 + rotl2, 18) ^ i36;
                        int rotl5 = i27 ^ rotl(i31 + i35, i10);
                        int rotl6 = i23 ^ rotl(rotl5 + i31, i13);
                        int rotl7 = i35 ^ rotl(rotl6 + rotl5, i18);
                        int rotl8 = rotl(rotl7 + rotl6, 18) ^ i31;
                        int rotl9 = i22 ^ rotl(i26 + i30, 7);
                        int rotl10 = i34 ^ rotl(rotl9 + i26, 9);
                        int rotl11 = i30 ^ rotl(rotl10 + rotl9, 13);
                        int rotl12 = i26 ^ rotl(rotl11 + rotl10, 18);
                        int rotl13 = i33 ^ rotl(i21 + i25, 7);
                        int rotl14 = i29 ^ rotl(rotl13 + i21, 9);
                        int i38 = i37;
                        int rotl15 = i25 ^ rotl(rotl14 + rotl13, 13);
                        int rotl16 = i21 ^ rotl(rotl15 + rotl14, 18);
                        i35 = rotl7 ^ rotl(rotl4 + rotl13, 7);
                        i34 = rotl10 ^ rotl(i35 + rotl4, 9);
                        int rotl17 = rotl13 ^ rotl(i34 + i35, 13);
                        int rotl18 = rotl4 ^ rotl(rotl17 + i34, 18);
                        i30 = rotl11 ^ rotl(rotl8 + rotl, 7);
                        i29 = rotl14 ^ rotl(i30 + rotl8, 9);
                        int rotl19 = rotl(i29 + i30, 13) ^ rotl;
                        i31 = rotl8 ^ rotl(rotl19 + i29, 18);
                        i25 = rotl15 ^ rotl(rotl12 + rotl5, 7);
                        int rotl20 = rotl(i25 + rotl12, 9) ^ rotl2;
                        i27 = rotl5 ^ rotl(rotl20 + i25, 13);
                        i26 = rotl12 ^ rotl(i27 + rotl20, 18);
                        i24 = rotl3 ^ rotl(rotl16 + rotl9, 7);
                        i23 = rotl6 ^ rotl(i24 + rotl16, 9);
                        i22 = rotl9 ^ rotl(i23 + i24, 13);
                        i21 = rotl16 ^ rotl(i22 + i23, 18);
                        i33 = rotl17;
                        i28 = rotl20;
                        i36 = rotl18;
                        i32 = rotl19;
                        c2 = 0;
                        i18 = 13;
                        i13 = 9;
                        i10 = 7;
                        i37 = i38 - 2;
                    }
                    char c3 = c2;
                    iArr2[c3] = i36 + iArr[c3];
                    iArr2[1] = i35 + iArr[1];
                    iArr2[2] = i34 + iArr[2];
                    iArr2[3] = i33 + iArr[3];
                    iArr2[4] = i32 + iArr[4];
                    iArr2[5] = i31 + iArr[5];
                    iArr2[6] = i30 + iArr[6];
                    iArr2[7] = i29 + iArr[7];
                    iArr2[8] = i28 + iArr[8];
                    iArr2[9] = i27 + iArr[9];
                    iArr2[10] = i26 + iArr[10];
                    iArr2[11] = i25 + iArr[11];
                    iArr2[12] = i24 + iArr[12];
                    iArr2[13] = i23 + iArr[13];
                    iArr2[14] = i22 + iArr[14];
                    iArr2[15] = i21 + iArr[15];
                    return;
                }
                throw new IllegalArgumentException("Number of rounds must be even");
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    protected void advanceCounter(long j2) {
        int i2 = (int) (j2 >>> 32);
        int i3 = (int) j2;
        if (i2 > 0) {
            int[] iArr = this.engineState;
            iArr[9] = iArr[9] + i2;
        }
        int[] iArr2 = this.engineState;
        int i4 = iArr2[8];
        iArr2[8] = iArr2[8] + i3;
        if (i4 == 0 || iArr2[8] >= i4) {
            return;
        }
        iArr2[9] = iArr2[9] + 1;
    }

    protected void generateKeyStream(byte[] bArr) {
        salsaCore(this.rounds, this.engineState, this.x);
        Pack.intToLittleEndian(this.x, bArr, 0);
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        if (this.rounds != 20) {
            return "Salsa20/" + this.rounds;
        }
        return "Salsa20";
    }

    protected long getCounter() {
        int[] iArr = this.engineState;
        return (iArr[9] << 32) | (iArr[8] & 4294967295L);
    }

    protected int getNonceSize() {
        return 8;
    }

    @Override // org.spongycastle.crypto.SkippingCipher
    public long getPosition() {
        return (getCounter() * 64) + this.index;
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            if (iv != null && iv.length == getNonceSize()) {
                CipherParameters parameters = parametersWithIV.getParameters();
                if (parameters == null) {
                    if (this.initialised) {
                        setKey(null, iv);
                    } else {
                        throw new IllegalStateException(getAlgorithmName() + " KeyParameter can not be null for first initialisation");
                    }
                } else if (parameters instanceof KeyParameter) {
                    setKey(((KeyParameter) parameters).getKey(), iv);
                } else {
                    throw new IllegalArgumentException(getAlgorithmName() + " Init parameters must contain a KeyParameter (or null for re-init)");
                }
                reset();
                this.initialised = true;
                return;
            }
            throw new IllegalArgumentException(getAlgorithmName() + " requires exactly " + getNonceSize() + " bytes of IV");
        }
        throw new IllegalArgumentException(getAlgorithmName() + " Init parameters must include an IV");
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        if (this.initialised) {
            if (i2 + i3 <= bArr.length) {
                if (i4 + i3 <= bArr2.length) {
                    if (limitExceeded(i3)) {
                        throw new MaxBytesExceededException("2^70 byte limit per IV would be exceeded; Change IV");
                    }
                    for (int i5 = 0; i5 < i3; i5++) {
                        byte[] bArr3 = this.keyStream;
                        int i6 = this.index;
                        bArr2[i5 + i4] = (byte) (bArr3[i6] ^ bArr[i5 + i2]);
                        int i7 = (i6 + 1) & 63;
                        this.index = i7;
                        if (i7 == 0) {
                            advanceCounter();
                            generateKeyStream(this.keyStream);
                        }
                    }
                    return i3;
                }
                throw new OutputLengthException("output buffer too short");
            }
            throw new DataLengthException("input buffer too short");
        }
        throw new IllegalStateException(getAlgorithmName() + " not initialised");
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public void reset() {
        this.index = 0;
        resetLimitCounter();
        resetCounter();
        generateKeyStream(this.keyStream);
    }

    protected void resetCounter() {
        int[] iArr = this.engineState;
        iArr[9] = 0;
        iArr[8] = 0;
    }

    protected void retreatCounter(long j2) {
        int i2 = (int) (j2 >>> 32);
        int i3 = (int) j2;
        if (i2 != 0) {
            int[] iArr = this.engineState;
            if ((iArr[9] & 4294967295L) >= (i2 & 4294967295L)) {
                iArr[9] = iArr[9] - i2;
            } else {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
        }
        int[] iArr2 = this.engineState;
        if ((iArr2[8] & 4294967295L) >= (4294967295L & i3)) {
            iArr2[8] = iArr2[8] - i3;
        } else if (iArr2[9] != 0) {
            iArr2[9] = iArr2[9] - 1;
            iArr2[8] = iArr2[8] - i3;
        } else {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
    }

    @Override // org.spongycastle.crypto.StreamCipher
    public byte returnByte(byte b2) {
        if (!limitExceeded()) {
            byte[] bArr = this.keyStream;
            int i2 = this.index;
            byte b3 = (byte) (b2 ^ bArr[i2]);
            int i3 = (i2 + 1) & 63;
            this.index = i3;
            if (i3 == 0) {
                advanceCounter();
                generateKeyStream(this.keyStream);
            }
            return b3;
        }
        throw new MaxBytesExceededException("2^70 byte limit per IV; Change IV");
    }

    @Override // org.spongycastle.crypto.SkippingCipher
    public long seekTo(long j2) {
        reset();
        return skip(j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setKey(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        if (bArr != null) {
            int i2 = 16;
            if (bArr.length != 16 && bArr.length != 32) {
                throw new IllegalArgumentException(getAlgorithmName() + " requires 128 bit or 256 bit key");
            }
            this.engineState[1] = Pack.littleEndianToInt(bArr, 0);
            this.engineState[2] = Pack.littleEndianToInt(bArr, 4);
            this.engineState[3] = Pack.littleEndianToInt(bArr, 8);
            this.engineState[4] = Pack.littleEndianToInt(bArr, 12);
            if (bArr.length == 32) {
                bArr3 = sigma;
            } else {
                bArr3 = tau;
                i2 = 0;
            }
            this.engineState[11] = Pack.littleEndianToInt(bArr, i2);
            this.engineState[12] = Pack.littleEndianToInt(bArr, i2 + 4);
            this.engineState[13] = Pack.littleEndianToInt(bArr, i2 + 8);
            this.engineState[14] = Pack.littleEndianToInt(bArr, i2 + 12);
            this.engineState[0] = Pack.littleEndianToInt(bArr3, 0);
            this.engineState[5] = Pack.littleEndianToInt(bArr3, 4);
            this.engineState[10] = Pack.littleEndianToInt(bArr3, 8);
            this.engineState[15] = Pack.littleEndianToInt(bArr3, 12);
        }
        this.engineState[6] = Pack.littleEndianToInt(bArr2, 0);
        this.engineState[7] = Pack.littleEndianToInt(bArr2, 4);
    }

    @Override // org.spongycastle.crypto.SkippingCipher
    public long skip(long j2) {
        long j3;
        if (j2 >= 0) {
            if (j2 >= 64) {
                long j4 = j2 / 64;
                advanceCounter(j4);
                j3 = j2 - (j4 * 64);
            } else {
                j3 = j2;
            }
            int i2 = this.index;
            int i3 = (((int) j3) + i2) & 63;
            this.index = i3;
            if (i3 < i2) {
                advanceCounter();
            }
        } else {
            long j5 = -j2;
            if (j5 >= 64) {
                long j6 = j5 / 64;
                retreatCounter(j6);
                j5 -= j6 * 64;
            }
            for (long j7 = 0; j7 < j5; j7++) {
                if (this.index == 0) {
                    retreatCounter();
                }
                this.index = (this.index - 1) & 63;
            }
        }
        generateKeyStream(this.keyStream);
        return j2;
    }

    public Salsa20Engine(int i2) {
        this.index = 0;
        this.engineState = new int[16];
        this.x = new int[16];
        this.keyStream = new byte[64];
        this.initialised = false;
        if (i2 > 0 && (i2 & 1) == 0) {
            this.rounds = i2;
            return;
        }
        throw new IllegalArgumentException("'rounds' must be a positive, even number");
    }

    private boolean limitExceeded(int i2) {
        int i3 = this.cW0 + i2;
        this.cW0 = i3;
        if (i3 >= i2 || i3 < 0) {
            return false;
        }
        int i4 = this.cW1 + 1;
        this.cW1 = i4;
        if (i4 == 0) {
            int i5 = this.cW2 + 1;
            this.cW2 = i5;
            return (i5 & 32) != 0;
        }
        return false;
    }

    protected void advanceCounter() {
        int[] iArr = this.engineState;
        int i2 = iArr[8] + 1;
        iArr[8] = i2;
        if (i2 == 0) {
            iArr[9] = iArr[9] + 1;
        }
    }

    protected void retreatCounter() {
        int[] iArr = this.engineState;
        if (iArr[8] == 0 && iArr[9] == 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        int i2 = iArr[8] - 1;
        iArr[8] = i2;
        if (i2 == -1) {
            iArr[9] = iArr[9] - 1;
        }
    }
}