package org.spongycastle.crypto.macs;

import okhttp3.internal.http2.Http2Connection;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Pack;

/* loaded from: classes3.dex */
public class Poly1305 implements Mac {
    private static final int BLOCK_SIZE = 16;
    private final BlockCipher cipher;
    private final byte[] currentBlock;
    private int currentBlockOffset;
    private int h0;
    private int h1;
    private int h2;
    private int h3;
    private int h4;
    private int k0;
    private int k1;
    private int k2;
    private int k3;
    private int r0;
    private int r1;
    private int r2;
    private int r3;
    private int r4;
    private int s1;
    private int s2;
    private int s3;
    private int s4;
    private final byte[] singleByte;

    public Poly1305() {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        this.cipher = null;
    }

    private static final long mul32x32_64(int i2, int i3) {
        return i2 * i3;
    }

    private void processBlock() {
        int i2 = this.currentBlockOffset;
        if (i2 < 16) {
            this.currentBlock[i2] = 1;
            for (int i3 = i2 + 1; i3 < 16; i3++) {
                this.currentBlock[i3] = 0;
            }
        }
        long littleEndianToInt = Pack.littleEndianToInt(this.currentBlock, 0) & 4294967295L;
        long littleEndianToInt2 = Pack.littleEndianToInt(this.currentBlock, 4) & 4294967295L;
        long littleEndianToInt3 = Pack.littleEndianToInt(this.currentBlock, 8) & 4294967295L;
        long littleEndianToInt4 = 4294967295L & Pack.littleEndianToInt(this.currentBlock, 12);
        int i4 = (int) (this.h0 + (littleEndianToInt & 67108863));
        this.h0 = i4;
        this.h1 = (int) (this.h1 + ((((littleEndianToInt2 << 32) | littleEndianToInt) >>> 26) & 67108863));
        this.h2 = (int) (this.h2 + (((littleEndianToInt2 | (littleEndianToInt3 << 32)) >>> 20) & 67108863));
        this.h3 = (int) (this.h3 + ((((littleEndianToInt4 << 32) | littleEndianToInt3) >>> 14) & 67108863));
        int i5 = (int) (this.h4 + (littleEndianToInt4 >>> 8));
        this.h4 = i5;
        if (this.currentBlockOffset == 16) {
            this.h4 = i5 + Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        long mul32x32_64 = mul32x32_64(i4, this.r0) + mul32x32_64(this.h1, this.s4) + mul32x32_64(this.h2, this.s3) + mul32x32_64(this.h3, this.s2) + mul32x32_64(this.h4, this.s1);
        long mul32x32_642 = mul32x32_64(this.h0, this.r1) + mul32x32_64(this.h1, this.r0) + mul32x32_64(this.h2, this.s4) + mul32x32_64(this.h3, this.s3) + mul32x32_64(this.h4, this.s2);
        long mul32x32_643 = mul32x32_64(this.h0, this.r2) + mul32x32_64(this.h1, this.r1) + mul32x32_64(this.h2, this.r0) + mul32x32_64(this.h3, this.s4) + mul32x32_64(this.h4, this.s3);
        long mul32x32_644 = mul32x32_64(this.h0, this.r3) + mul32x32_64(this.h1, this.r2) + mul32x32_64(this.h2, this.r1) + mul32x32_64(this.h3, this.r0) + mul32x32_64(this.h4, this.s4);
        long mul32x32_645 = mul32x32_64(this.h0, this.r4) + mul32x32_64(this.h1, this.r3) + mul32x32_64(this.h2, this.r2) + mul32x32_64(this.h3, this.r1) + mul32x32_64(this.h4, this.r0);
        int i6 = ((int) mul32x32_64) & 67108863;
        this.h0 = i6;
        long j2 = mul32x32_642 + (mul32x32_64 >>> 26);
        this.h1 = ((int) j2) & 67108863;
        long j3 = mul32x32_643 + ((j2 >>> 26) & (-1));
        this.h2 = ((int) j3) & 67108863;
        long j4 = mul32x32_644 + ((j3 >>> 26) & (-1));
        this.h3 = ((int) j4) & 67108863;
        long j5 = mul32x32_645 + (j4 >>> 26);
        this.h4 = ((int) j5) & 67108863;
        this.h0 = (int) (i6 + ((j5 >>> 26) * 5));
    }

    private void setKey(byte[] bArr, byte[] bArr2) {
        if (this.cipher != null && (bArr2 == null || bArr2.length != 16)) {
            throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
        }
        Poly1305KeyGenerator.checkKey(bArr);
        int littleEndianToInt = Pack.littleEndianToInt(bArr, 16);
        int littleEndianToInt2 = Pack.littleEndianToInt(bArr, 20);
        int littleEndianToInt3 = Pack.littleEndianToInt(bArr, 24);
        int littleEndianToInt4 = Pack.littleEndianToInt(bArr, 28);
        this.r0 = 67108863 & littleEndianToInt;
        int i2 = ((littleEndianToInt >>> 26) | (littleEndianToInt2 << 6)) & 67108611;
        this.r1 = i2;
        int i3 = ((littleEndianToInt2 >>> 20) | (littleEndianToInt3 << 12)) & 67092735;
        this.r2 = i3;
        int i4 = ((littleEndianToInt3 >>> 14) | (littleEndianToInt4 << 18)) & 66076671;
        this.r3 = i4;
        int i5 = (littleEndianToInt4 >>> 8) & 1048575;
        this.r4 = i5;
        this.s1 = i2 * 5;
        this.s2 = i3 * 5;
        this.s3 = i4 * 5;
        this.s4 = i5 * 5;
        BlockCipher blockCipher = this.cipher;
        if (blockCipher != null) {
            byte[] bArr3 = new byte[16];
            blockCipher.init(true, new KeyParameter(bArr, 0, 16));
            this.cipher.processBlock(bArr2, 0, bArr3, 0);
            bArr = bArr3;
        }
        this.k0 = Pack.littleEndianToInt(bArr, 0);
        this.k1 = Pack.littleEndianToInt(bArr, 4);
        this.k2 = Pack.littleEndianToInt(bArr, 8);
        this.k3 = Pack.littleEndianToInt(bArr, 12);
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i2) throws DataLengthException, IllegalStateException {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (i2 + 16 <= bArr.length) {
            if (this.currentBlockOffset > 0) {
                processBlock();
            }
            int i8 = this.h0;
            int i9 = i8 >>> 26;
            int i10 = i8 & 67108863;
            this.h0 = i10;
            int i11 = this.h1 + i9;
            this.h1 = i11;
            int i12 = i11 >>> 26;
            int i13 = i11 & 67108863;
            this.h1 = i13;
            int i14 = this.h2 + i12;
            this.h2 = i14;
            int i15 = i14 >>> 26;
            int i16 = i14 & 67108863;
            this.h2 = i16;
            int i17 = this.h3 + i15;
            this.h3 = i17;
            int i18 = i17 >>> 26;
            int i19 = i17 & 67108863;
            this.h3 = i19;
            int i20 = this.h4 + i18;
            this.h4 = i20;
            int i21 = i20 >>> 26;
            int i22 = i20 & 67108863;
            this.h4 = i22;
            int i23 = i10 + (i21 * 5);
            this.h0 = i23;
            int i24 = i23 + 5;
            int i25 = (i24 >>> 26) + i13;
            int i26 = (i25 >>> 26) + i16;
            int i27 = (i26 >>> 26) + i19;
            int i28 = 67108863 & i27;
            int i29 = ((i27 >>> 26) + i22) - 67108864;
            int i30 = (i29 >>> 31) - 1;
            int i31 = ~i30;
            this.h0 = (i23 & i31) | (i24 & 67108863 & i30);
            this.h1 = (i13 & i31) | (i25 & 67108863 & i30);
            this.h2 = (i16 & i31) | (i26 & 67108863 & i30);
            this.h3 = (i28 & i30) | (i19 & i31);
            this.h4 = (i22 & i31) | (i29 & i30);
            long j2 = ((i3 | (i4 << 26)) & 4294967295L) + (this.k0 & 4294967295L);
            Pack.intToLittleEndian((int) j2, bArr, i2);
            long j3 = (((i4 >>> 6) | (i5 << 20)) & 4294967295L) + (this.k1 & 4294967295L) + (j2 >>> 32);
            Pack.intToLittleEndian((int) j3, bArr, i2 + 4);
            long j4 = (((i5 >>> 12) | (i6 << 14)) & 4294967295L) + (this.k2 & 4294967295L) + (j3 >>> 32);
            Pack.intToLittleEndian((int) j4, bArr, i2 + 8);
            Pack.intToLittleEndian((int) ((((i6 >>> 18) | (i7 << 8)) & 4294967295L) + (4294967295L & this.k3) + (j4 >>> 32)), bArr, i2 + 12);
            reset();
            return 16;
        }
        throw new DataLengthException("Output buffer is too short.");
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        if (this.cipher == null) {
            return "Poly1305";
        }
        return "Poly1305-" + this.cipher.getAlgorithmName();
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return 16;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        byte[] bArr;
        if (this.cipher == null) {
            bArr = null;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.getIV();
            cipherParameters = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
        }
        if (cipherParameters instanceof KeyParameter) {
            setKey(((KeyParameter) cipherParameters).getKey(), bArr);
            reset();
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a key.");
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        this.currentBlockOffset = 0;
        this.h4 = 0;
        this.h3 = 0;
        this.h2 = 0;
        this.h1 = 0;
        this.h0 = 0;
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b2) throws IllegalStateException {
        byte[] bArr = this.singleByte;
        bArr[0] = b2;
        update(bArr, 0, 1);
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i2, int i3) throws DataLengthException, IllegalStateException {
        int i4 = 0;
        while (i3 > i4) {
            if (this.currentBlockOffset == 16) {
                processBlock();
                this.currentBlockOffset = 0;
            }
            int min = Math.min(i3 - i4, 16 - this.currentBlockOffset);
            System.arraycopy(bArr, i4 + i2, this.currentBlock, this.currentBlockOffset, min);
            i4 += min;
            this.currentBlockOffset += min;
        }
    }

    public Poly1305(BlockCipher blockCipher) {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        if (blockCipher.getBlockSize() == 16) {
            this.cipher = blockCipher;
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a 128 bit block cipher.");
    }
}