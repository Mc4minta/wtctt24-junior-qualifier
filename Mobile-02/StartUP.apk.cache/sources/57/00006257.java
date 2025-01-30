package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public class SipHash implements Mac {

    /* renamed from: c  reason: collision with root package name */
    protected final int f17804c;

    /* renamed from: d  reason: collision with root package name */
    protected final int f17805d;
    protected long k0;
    protected long k1;
    protected long m;
    protected long v0;
    protected long v1;
    protected long v2;
    protected long v3;
    protected int wordCount;
    protected int wordPos;

    public SipHash() {
        this.m = 0L;
        this.wordPos = 0;
        this.wordCount = 0;
        this.f17804c = 2;
        this.f17805d = 4;
    }

    protected static long rotateLeft(long j2, int i2) {
        return (j2 >>> (-i2)) | (j2 << i2);
    }

    protected void applySipRounds(int i2) {
        long j2 = this.v0;
        long j3 = this.v1;
        long j4 = this.v2;
        long j5 = this.v3;
        for (int i3 = 0; i3 < i2; i3++) {
            long j6 = j2 + j3;
            long j7 = j4 + j5;
            long rotateLeft = rotateLeft(j3, 13) ^ j6;
            long rotateLeft2 = rotateLeft(j5, 16) ^ j7;
            long j8 = j7 + rotateLeft;
            j2 = rotateLeft(j6, 32) + rotateLeft2;
            j3 = rotateLeft(rotateLeft, 17) ^ j8;
            j5 = rotateLeft(rotateLeft2, 21) ^ j2;
            j4 = rotateLeft(j8, 32);
        }
        this.v0 = j2;
        this.v1 = j3;
        this.v2 = j4;
        this.v3 = j5;
    }

    public long doFinal() throws DataLengthException, IllegalStateException {
        int i2;
        long j2 = this.m >>> ((7 - this.wordPos) << 3);
        this.m = j2;
        long j3 = j2 >>> 8;
        this.m = j3;
        this.m = j3 | ((((this.wordCount << 3) + i2) & 255) << 56);
        processMessageWord();
        this.v2 ^= 255;
        applySipRounds(this.f17805d);
        long j4 = ((this.v0 ^ this.v1) ^ this.v2) ^ this.v3;
        reset();
        return j4;
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        return "SipHash-" + this.f17804c + "-" + this.f17805d;
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return 8;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            if (key.length == 16) {
                this.k0 = Pack.littleEndianToLong(key, 0);
                this.k1 = Pack.littleEndianToLong(key, 8);
                reset();
                return;
            }
            throw new IllegalArgumentException("'params' must be a 128-bit key");
        }
        throw new IllegalArgumentException("'params' must be an instance of KeyParameter");
    }

    protected void processMessageWord() {
        this.wordCount++;
        this.v3 ^= this.m;
        applySipRounds(this.f17804c);
        this.v0 ^= this.m;
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        long j2 = this.k0;
        this.v0 = 8317987319222330741L ^ j2;
        long j3 = this.k1;
        this.v1 = 7237128888997146477L ^ j3;
        this.v2 = j2 ^ 7816392313619706465L;
        this.v3 = 8387220255154660723L ^ j3;
        this.m = 0L;
        this.wordPos = 0;
        this.wordCount = 0;
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b2) throws IllegalStateException {
        long j2 = this.m >>> 8;
        this.m = j2;
        this.m = j2 | ((b2 & 255) << 56);
        int i2 = this.wordPos + 1;
        this.wordPos = i2;
        if (i2 == 8) {
            processMessageWord();
            this.wordPos = 0;
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i2, int i3) throws DataLengthException, IllegalStateException {
        int i4 = i3 & (-8);
        int i5 = this.wordPos;
        int i6 = 0;
        if (i5 == 0) {
            while (i6 < i4) {
                this.m = Pack.littleEndianToLong(bArr, i2 + i6);
                processMessageWord();
                i6 += 8;
            }
            while (i6 < i3) {
                long j2 = this.m >>> 8;
                this.m = j2;
                this.m = j2 | ((bArr[i2 + i6] & 255) << 56);
                i6++;
            }
            this.wordPos = i3 - i4;
            return;
        }
        int i7 = i5 << 3;
        int i8 = 0;
        while (i8 < i4) {
            long littleEndianToLong = Pack.littleEndianToLong(bArr, i2 + i8);
            this.m = (this.m >>> (-i7)) | (littleEndianToLong << i7);
            processMessageWord();
            this.m = littleEndianToLong;
            i8 += 8;
        }
        while (i8 < i3) {
            long j3 = this.m >>> 8;
            this.m = j3;
            this.m = j3 | ((bArr[i2 + i8] & 255) << 56);
            int i9 = this.wordPos + 1;
            this.wordPos = i9;
            if (i9 == 8) {
                processMessageWord();
                this.wordPos = 0;
            }
            i8++;
        }
    }

    public SipHash(int i2, int i3) {
        this.m = 0L;
        this.wordPos = 0;
        this.wordCount = 0;
        this.f17804c = i2;
        this.f17805d = i3;
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i2) throws DataLengthException, IllegalStateException {
        Pack.longToLittleEndian(doFinal(), bArr, i2);
        return 8;
    }
}