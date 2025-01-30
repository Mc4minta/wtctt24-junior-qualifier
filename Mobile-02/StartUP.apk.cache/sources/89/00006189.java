package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class KeccakDigest implements ExtendedDigest {
    long[] C;
    protected int bitsAvailableForSqueezing;
    protected int bitsInQueue;
    long[] chiC;
    protected byte[] chunk;
    protected byte[] dataQueue;
    protected int fixedOutputLength;
    protected byte[] oneByte;
    protected int rate;
    protected boolean squeezing;
    protected byte[] state;
    long[] tempA;
    private static long[] KeccakRoundConstants = keccakInitializeRoundConstants();
    private static int[] KeccakRhoOffsets = keccakInitializeRhoOffsets();

    public KeccakDigest() {
        this(288);
    }

    private void KeccakAbsorb(byte[] bArr, byte[] bArr2, int i2) {
        keccakPermutationAfterXor(bArr, bArr2, i2);
    }

    private void KeccakExtract(byte[] bArr, byte[] bArr2, int i2) {
        System.arraycopy(bArr, 0, bArr2, 0, i2 * 8);
    }

    private void KeccakExtract1024bits(byte[] bArr, byte[] bArr2) {
        System.arraycopy(bArr, 0, bArr2, 0, 128);
    }

    private static boolean LFSR86540(byte[] bArr) {
        boolean z = (bArr[0] & 1) != 0;
        if ((bArr[0] & 128) != 0) {
            bArr[0] = (byte) ((bArr[0] << 1) ^ 113);
        } else {
            bArr[0] = (byte) (bArr[0] << 1);
        }
        return z;
    }

    private void absorbQueue() {
        KeccakAbsorb(this.state, this.dataQueue, this.rate / 8);
        this.bitsInQueue = 0;
    }

    private void chi(long[] jArr) {
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = 0;
            while (i3 < 5) {
                int i4 = i2 * 5;
                int i5 = i3 + 1;
                this.chiC[i3] = jArr[i3 + i4] ^ ((~jArr[(i5 % 5) + i4]) & jArr[((i3 + 2) % 5) + i4]);
                i3 = i5;
            }
            for (int i6 = 0; i6 < 5; i6++) {
                jArr[(i2 * 5) + i6] = this.chiC[i6];
            }
        }
    }

    private void clearDataQueueSection(int i2, int i3) {
        for (int i4 = i2; i4 != i2 + i3; i4++) {
            this.dataQueue[i4] = 0;
        }
    }

    private void fromBytesToWords(long[] jArr, byte[] bArr) {
        for (int i2 = 0; i2 < 25; i2++) {
            jArr[i2] = 0;
            int i3 = i2 * 8;
            for (int i4 = 0; i4 < 8; i4++) {
                jArr[i2] = jArr[i2] | ((bArr[i3 + i4] & 255) << (i4 * 8));
            }
        }
    }

    private void fromWordsToBytes(byte[] bArr, long[] jArr) {
        for (int i2 = 0; i2 < 25; i2++) {
            int i3 = i2 * 8;
            for (int i4 = 0; i4 < 8; i4++) {
                bArr[i3 + i4] = (byte) ((jArr[i2] >>> (i4 * 8)) & 255);
            }
        }
    }

    private void init(int i2) {
        if (i2 == 128) {
            initSponge(1344, 256);
        } else if (i2 == 224) {
            initSponge(1152, 448);
        } else if (i2 == 256) {
            initSponge(1088, 512);
        } else if (i2 == 288) {
            initSponge(1024, 576);
        } else if (i2 == 384) {
            initSponge(832, 768);
        } else if (i2 == 512) {
            initSponge(576, 1024);
        } else {
            throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
        }
    }

    private void initSponge(int i2, int i3) {
        if (i2 + i3 == 1600) {
            if (i2 > 0 && i2 < 1600 && i2 % 64 == 0) {
                this.rate = i2;
                Arrays.fill(this.state, (byte) 0);
                Arrays.fill(this.dataQueue, (byte) 0);
                this.bitsInQueue = 0;
                this.squeezing = false;
                this.bitsAvailableForSqueezing = 0;
                this.fixedOutputLength = i3 / 2;
                this.chunk = new byte[i2 / 8];
                this.oneByte = new byte[1];
                return;
            }
            throw new IllegalStateException("invalid rate value");
        }
        throw new IllegalStateException("rate + capacity != 1600");
    }

    private void iota(long[] jArr, int i2) {
        jArr[0] = jArr[0] ^ KeccakRoundConstants[i2];
    }

    private static int[] keccakInitializeRhoOffsets() {
        int[] iArr = new int[25];
        int i2 = 0;
        iArr[0] = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < 24) {
            int i5 = i2 + 1;
            iArr[(i3 % 5) + ((i4 % 5) * 5)] = (((i2 + 2) * i5) / 2) % 64;
            i4 = ((i3 * 2) + (i4 * 3)) % 5;
            i3 = ((i3 * 0) + (i4 * 1)) % 5;
            i2 = i5;
        }
        return iArr;
    }

    private static long[] keccakInitializeRoundConstants() {
        long[] jArr = new long[24];
        byte[] bArr = {1};
        for (int i2 = 0; i2 < 24; i2++) {
            jArr[i2] = 0;
            for (int i3 = 0; i3 < 7; i3++) {
                int i4 = (1 << i3) - 1;
                if (LFSR86540(bArr)) {
                    jArr[i2] = jArr[i2] ^ (1 << i4);
                }
            }
        }
        return jArr;
    }

    private void keccakPermutation(byte[] bArr) {
        long[] jArr = new long[bArr.length / 8];
        fromBytesToWords(jArr, bArr);
        keccakPermutationOnWords(jArr);
        fromWordsToBytes(bArr, jArr);
    }

    private void keccakPermutationAfterXor(byte[] bArr, byte[] bArr2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) (bArr[i3] ^ bArr2[i3]);
        }
        keccakPermutation(bArr);
    }

    private void keccakPermutationOnWords(long[] jArr) {
        for (int i2 = 0; i2 < 24; i2++) {
            theta(jArr);
            rho(jArr);
            pi(jArr);
            chi(jArr);
            iota(jArr, i2);
        }
    }

    private void padAndSwitchToSqueezingPhase() {
        int i2 = this.bitsInQueue;
        int i3 = i2 + 1;
        int i4 = this.rate;
        if (i3 == i4) {
            byte[] bArr = this.dataQueue;
            int i5 = i2 / 8;
            bArr[i5] = (byte) ((1 << (i2 % 8)) | bArr[i5]);
            absorbQueue();
            clearDataQueueSection(0, this.rate / 8);
        } else {
            clearDataQueueSection((i2 + 7) / 8, (i4 / 8) - ((i2 + 7) / 8));
            byte[] bArr2 = this.dataQueue;
            int i6 = this.bitsInQueue;
            int i7 = i6 / 8;
            bArr2[i7] = (byte) ((1 << (i6 % 8)) | bArr2[i7]);
        }
        byte[] bArr3 = this.dataQueue;
        int i8 = this.rate;
        int i9 = (i8 - 1) / 8;
        bArr3[i9] = (byte) ((1 << ((i8 - 1) % 8)) | bArr3[i9]);
        absorbQueue();
        int i10 = this.rate;
        if (i10 == 1024) {
            KeccakExtract1024bits(this.state, this.dataQueue);
            this.bitsAvailableForSqueezing = 1024;
        } else {
            KeccakExtract(this.state, this.dataQueue, i10 / 64);
            this.bitsAvailableForSqueezing = this.rate;
        }
        this.squeezing = true;
    }

    private void pi(long[] jArr) {
        long[] jArr2 = this.tempA;
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        for (int i2 = 0; i2 < 5; i2++) {
            for (int i3 = 0; i3 < 5; i3++) {
                jArr[((((i2 * 2) + (i3 * 3)) % 5) * 5) + i3] = this.tempA[(i3 * 5) + i2];
            }
        }
    }

    private void rho(long[] jArr) {
        for (int i2 = 0; i2 < 5; i2++) {
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = (i3 * 5) + i2;
                int[] iArr = KeccakRhoOffsets;
                jArr[i4] = iArr[i4] != 0 ? (jArr[i4] << iArr[i4]) ^ (jArr[i4] >>> (64 - iArr[i4])) : jArr[i4];
            }
        }
    }

    private void theta(long[] jArr) {
        for (int i2 = 0; i2 < 5; i2++) {
            this.C[i2] = 0;
            for (int i3 = 0; i3 < 5; i3++) {
                long[] jArr2 = this.C;
                jArr2[i2] = jArr2[i2] ^ jArr[(i3 * 5) + i2];
            }
        }
        int i4 = 0;
        while (i4 < 5) {
            long[] jArr3 = this.C;
            int i5 = i4 + 1;
            int i6 = i5 % 5;
            long j2 = ((jArr3[i6] << 1) ^ (jArr3[i6] >>> 63)) ^ jArr3[(i4 + 4) % 5];
            for (int i7 = 0; i7 < 5; i7++) {
                int i8 = (i7 * 5) + i4;
                jArr[i8] = jArr[i8] ^ j2;
            }
            i4 = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void absorb(byte[] bArr, int i2, long j2) {
        if (this.bitsInQueue % 8 == 0) {
            if (this.squeezing) {
                throw new IllegalStateException("attempt to absorb while squeezing.");
            }
            long j3 = 0;
            while (j3 < j2) {
                int i3 = this.bitsInQueue;
                long j4 = 8;
                if (i3 == 0) {
                    int i4 = this.rate;
                    if (j2 >= i4 && j3 <= j2 - i4) {
                        long j5 = (j2 - j3) / i4;
                        long j6 = 0;
                        while (j6 < j5) {
                            byte[] bArr2 = this.chunk;
                            System.arraycopy(bArr, (int) (i2 + (j3 / j4) + (bArr2.length * j6)), bArr2, 0, bArr2.length);
                            byte[] bArr3 = this.state;
                            byte[] bArr4 = this.chunk;
                            KeccakAbsorb(bArr3, bArr4, bArr4.length);
                            j6++;
                            j4 = 8;
                        }
                        j3 += j5 * this.rate;
                    }
                }
                int i5 = (int) (j2 - j3);
                int i6 = i5 + i3;
                int i7 = this.rate;
                if (i6 > i7) {
                    i5 = i7 - i3;
                }
                int i8 = i5 % 8;
                int i9 = i5 - i8;
                System.arraycopy(bArr, ((int) (j3 / 8)) + i2, this.dataQueue, i3 / 8, i9 / 8);
                int i10 = this.bitsInQueue + i9;
                this.bitsInQueue = i10;
                j3 += i9;
                if (i10 == this.rate) {
                    absorbQueue();
                }
                if (i8 > 0) {
                    byte[] bArr5 = this.dataQueue;
                    int i11 = this.bitsInQueue;
                    bArr5[i11 / 8] = (byte) (((1 << i8) - 1) & bArr[((int) (j3 / 8)) + i2]);
                    this.bitsInQueue = i11 + i8;
                    j3 += i8;
                }
            }
            return;
        }
        throw new IllegalStateException("attempt to absorb with odd length queue.");
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i2) {
        squeeze(bArr, i2, this.fixedOutputLength);
        reset();
        return getDigestSize();
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "Keccak-" + this.fixedOutputLength;
    }

    @Override // org.spongycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return this.rate / 8;
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return this.fixedOutputLength / 8;
    }

    @Override // org.spongycastle.crypto.Digest
    public void reset() {
        init(this.fixedOutputLength);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void squeeze(byte[] bArr, int i2, long j2) {
        if (!this.squeezing) {
            padAndSwitchToSqueezingPhase();
        }
        long j3 = 0;
        if (j2 % 8 != 0) {
            throw new IllegalStateException("outputLength not a multiple of 8");
        }
        while (j3 < j2) {
            if (this.bitsAvailableForSqueezing == 0) {
                keccakPermutation(this.state);
                int i3 = this.rate;
                if (i3 == 1024) {
                    KeccakExtract1024bits(this.state, this.dataQueue);
                    this.bitsAvailableForSqueezing = 1024;
                } else {
                    KeccakExtract(this.state, this.dataQueue, i3 / 64);
                    this.bitsAvailableForSqueezing = this.rate;
                }
            }
            int i4 = this.bitsAvailableForSqueezing;
            long j4 = j2 - j3;
            int i5 = ((long) i4) > j4 ? (int) j4 : i4;
            System.arraycopy(this.dataQueue, (this.rate - i4) / 8, bArr, ((int) (j3 / 8)) + i2, i5 / 8);
            this.bitsAvailableForSqueezing -= i5;
            j3 += i5;
        }
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte b2) {
        byte[] bArr = this.oneByte;
        bArr[0] = b2;
        absorb(bArr, 0, 8L);
    }

    public KeccakDigest(int i2) {
        this.state = new byte[200];
        this.dataQueue = new byte[192];
        this.C = new long[5];
        this.tempA = new long[25];
        this.chiC = new long[5];
        init(i2);
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte[] bArr, int i2, int i3) {
        absorb(bArr, i2, i3 * 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int doFinal(byte[] bArr, int i2, byte b2, int i3) {
        if (i3 > 0) {
            byte[] bArr2 = this.oneByte;
            bArr2[0] = b2;
            absorb(bArr2, 0, i3);
        }
        squeeze(bArr, i2, this.fixedOutputLength);
        reset();
        return getDigestSize();
    }

    public KeccakDigest(KeccakDigest keccakDigest) {
        byte[] bArr = new byte[200];
        this.state = bArr;
        this.dataQueue = new byte[192];
        this.C = new long[5];
        this.tempA = new long[25];
        this.chiC = new long[5];
        byte[] bArr2 = keccakDigest.state;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        byte[] bArr3 = keccakDigest.dataQueue;
        System.arraycopy(bArr3, 0, this.dataQueue, 0, bArr3.length);
        this.rate = keccakDigest.rate;
        this.bitsInQueue = keccakDigest.bitsInQueue;
        this.fixedOutputLength = keccakDigest.fixedOutputLength;
        this.squeezing = keccakDigest.squeezing;
        this.bitsAvailableForSqueezing = keccakDigest.bitsAvailableForSqueezing;
        this.chunk = Arrays.clone(keccakDigest.chunk);
        this.oneByte = Arrays.clone(keccakDigest.oneByte);
    }
}