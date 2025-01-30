package com.appsflyer.internal;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.math.ec.Tnaf;

/* loaded from: classes.dex */
public class al extends FilterInputStream {

    /* renamed from: Ι  reason: contains not printable characters */
    private static final short f196 = (short) ((Math.sqrt(5.0d) - 1.0d) * Math.pow(2.0d, 15.0d));

    /* renamed from: ı  reason: contains not printable characters */
    private byte[] f197;

    /* renamed from: Ɩ  reason: contains not printable characters */
    private int f198;

    /* renamed from: ǃ  reason: contains not printable characters */
    private int f199;

    /* renamed from: ȷ  reason: contains not printable characters */
    private int f200;

    /* renamed from: ɩ  reason: contains not printable characters */
    private byte[] f201;

    /* renamed from: ɹ  reason: contains not printable characters */
    private int f202;

    /* renamed from: ɾ  reason: contains not printable characters */
    private int f203;

    /* renamed from: ι  reason: contains not printable characters */
    private byte[] f204;

    /* renamed from: І  reason: contains not printable characters */
    private int f205;

    /* renamed from: і  reason: contains not printable characters */
    private int f206;

    /* renamed from: Ӏ  reason: contains not printable characters */
    private int f207;

    /* renamed from: ӏ  reason: contains not printable characters */
    private int f208;

    public al(InputStream inputStream, int[] iArr, int i2, byte[] bArr, int i3, int i4) throws IOException {
        super(inputStream);
        this.f207 = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.f197 = new byte[8];
        this.f204 = new byte[8];
        this.f201 = new byte[8];
        this.f199 = 8;
        this.f206 = 8;
        this.f205 = Math.min(Math.max(i3, 5), 16);
        this.f202 = i4;
        if (i4 == 3) {
            System.arraycopy(bArr, 0, this.f204, 0, 8);
        }
        long j2 = ((iArr[0] & 4294967295L) << 32) | (4294967295L & iArr[1]);
        if (i2 == 0) {
            this.f198 = (int) j2;
            long j3 = j2 >> 3;
            short s = f196;
            this.f203 = (int) ((s * j3) >> 32);
            this.f200 = (int) (j2 >> 32);
            this.f208 = (int) (j3 + s);
            return;
        }
        int i5 = (int) j2;
        this.f198 = i5;
        this.f203 = i5 * i2;
        this.f200 = i5 ^ i2;
        this.f208 = (int) (j2 >> 32);
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    private void m152() {
        if (this.f202 == 3) {
            byte[] bArr = this.f197;
            System.arraycopy(bArr, 0, this.f201, 0, bArr.length);
        }
        byte[] bArr2 = this.f197;
        int i2 = ((bArr2[0] << 24) & (-16777216)) + ((bArr2[1] << Tnaf.POW_2_WIDTH) & 16711680) + ((bArr2[2] << 8) & 65280) + (bArr2[3] & 255);
        int i3 = ((-16777216) & (bArr2[4] << 24)) + (16711680 & (bArr2[5] << Tnaf.POW_2_WIDTH)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255);
        int i4 = 0;
        while (true) {
            int i5 = this.f205;
            if (i4 >= i5) {
                break;
            }
            short s = f196;
            i3 -= ((((i5 - i4) * s) + i2) ^ ((i2 << 4) + this.f200)) ^ ((i2 >>> 5) + this.f208);
            i2 -= (((i3 << 4) + this.f198) ^ ((s * (i5 - i4)) + i3)) ^ ((i3 >>> 5) + this.f203);
            i4++;
        }
        byte[] bArr3 = this.f197;
        bArr3[0] = (byte) (i2 >> 24);
        bArr3[1] = (byte) (i2 >> 16);
        bArr3[2] = (byte) (i2 >> 8);
        bArr3[3] = (byte) i2;
        bArr3[4] = (byte) (i3 >> 24);
        bArr3[5] = (byte) (i3 >> 16);
        bArr3[6] = (byte) (i3 >> 8);
        bArr3[7] = (byte) i3;
        if (this.f202 == 3) {
            for (int i6 = 0; i6 < 8; i6++) {
                byte[] bArr4 = this.f197;
                bArr4[i6] = (byte) (bArr4[i6] ^ this.f204[i6]);
            }
            byte[] bArr5 = this.f201;
            System.arraycopy(bArr5, 0, this.f204, 0, bArr5.length);
        }
    }

    /* renamed from: ι  reason: contains not printable characters */
    private int m153() throws IOException {
        if (this.f207 == Integer.MAX_VALUE) {
            this.f207 = ((FilterInputStream) this).in.read();
        }
        if (this.f199 == 8) {
            byte[] bArr = this.f197;
            int i2 = this.f207;
            bArr[0] = (byte) i2;
            if (i2 < 0) {
                throw new IllegalStateException("unexpected block size");
            }
            int i3 = 1;
            do {
                int read = ((FilterInputStream) this).in.read(this.f197, i3, 8 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } while (i3 < 8);
            if (i3 >= 8) {
                m152();
                int read2 = ((FilterInputStream) this).in.read();
                this.f207 = read2;
                this.f199 = 0;
                this.f206 = read2 < 0 ? 8 - (this.f197[7] & 255) : 8;
            } else {
                throw new IllegalStateException("unexpected block size");
            }
        }
        return this.f206;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        m153();
        return this.f206 - this.f199;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        m153();
        int i2 = this.f199;
        if (i2 >= this.f206) {
            return -1;
        }
        byte[] bArr = this.f197;
        this.f199 = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        long j3 = 0;
        while (j3 < j2 && read() != -1) {
            j3++;
        }
        return j3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = i2 + i3;
        for (int i5 = i2; i5 < i4; i5++) {
            m153();
            int i6 = this.f199;
            if (i6 >= this.f206) {
                if (i5 == i2) {
                    return -1;
                }
                return i3 - (i4 - i5);
            }
            byte[] bArr2 = this.f197;
            this.f199 = i6 + 1;
            bArr[i5] = bArr2[i6];
        }
        return i3;
    }
}