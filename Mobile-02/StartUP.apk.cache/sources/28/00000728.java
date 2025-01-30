package com.appsflyer.internal;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.math.ec.Tnaf;

/* loaded from: classes.dex */
public class an extends FilterInputStream {

    /* renamed from: ı  reason: contains not printable characters */
    private byte[] f210;

    /* renamed from: Ɩ  reason: contains not printable characters */
    private int f211;

    /* renamed from: ǃ  reason: contains not printable characters */
    private byte[] f212;

    /* renamed from: ɩ  reason: contains not printable characters */
    private ak f213;

    /* renamed from: ɹ  reason: contains not printable characters */
    private int[] f214;

    /* renamed from: Ι  reason: contains not printable characters */
    private byte[] f215;

    /* renamed from: ι  reason: contains not printable characters */
    private final int f216;

    /* renamed from: І  reason: contains not printable characters */
    private int f217;

    /* renamed from: і  reason: contains not printable characters */
    private int f218;

    /* renamed from: Ӏ  reason: contains not printable characters */
    private int f219;

    public an(InputStream inputStream, int[] iArr, byte[] bArr, int i2, boolean z, int i3) throws IOException {
        super(inputStream);
        this.f218 = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        int min = Math.min(Math.max(i2, 3), 16);
        this.f216 = min;
        this.f212 = new byte[8];
        byte[] bArr2 = new byte[8];
        this.f215 = bArr2;
        this.f210 = new byte[8];
        this.f214 = new int[2];
        this.f211 = 8;
        this.f219 = 8;
        this.f217 = i3;
        if (i3 == 2) {
            System.arraycopy(bArr, 0, bArr2, 0, 8);
        }
        this.f213 = new ak(iArr, min, true, z);
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private int m154() throws IOException {
        if (this.f218 == Integer.MAX_VALUE) {
            this.f218 = ((FilterInputStream) this).in.read();
        }
        if (this.f211 == 8) {
            byte[] bArr = this.f212;
            int i2 = this.f218;
            bArr[0] = (byte) i2;
            if (i2 < 0) {
                throw new IllegalStateException("unexpected block size");
            }
            int i3 = 1;
            do {
                int read = ((FilterInputStream) this).in.read(this.f212, i3, 8 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } while (i3 < 8);
            if (i3 >= 8) {
                m155();
                int read2 = ((FilterInputStream) this).in.read();
                this.f218 = read2;
                this.f211 = 0;
                this.f219 = read2 < 0 ? 8 - (this.f212[7] & 255) : 8;
            } else {
                throw new IllegalStateException("unexpected block size");
            }
        }
        return this.f219;
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private void m155() {
        if (this.f217 == 2) {
            byte[] bArr = this.f212;
            System.arraycopy(bArr, 0, this.f210, 0, bArr.length);
        }
        byte[] bArr2 = this.f212;
        int i2 = ((bArr2[0] << 24) & (-16777216)) + ((bArr2[1] << Tnaf.POW_2_WIDTH) & 16711680) + ((bArr2[2] << 8) & 65280) + (bArr2[3] & 255);
        int i3 = ((-16777216) & (bArr2[4] << 24)) + (16711680 & (bArr2[5] << Tnaf.POW_2_WIDTH)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255);
        int i4 = this.f216;
        ak akVar = this.f213;
        aj.m149(i2, i3, false, i4, akVar.f194, akVar.f195, this.f214);
        int[] iArr = this.f214;
        int i5 = iArr[0];
        int i6 = iArr[1];
        byte[] bArr3 = this.f212;
        bArr3[0] = (byte) (i5 >> 24);
        bArr3[1] = (byte) (i5 >> 16);
        bArr3[2] = (byte) (i5 >> 8);
        bArr3[3] = (byte) i5;
        bArr3[4] = (byte) (i6 >> 24);
        bArr3[5] = (byte) (i6 >> 16);
        bArr3[6] = (byte) (i6 >> 8);
        bArr3[7] = (byte) i6;
        if (this.f217 == 2) {
            for (int i7 = 0; i7 < 8; i7++) {
                byte[] bArr4 = this.f212;
                bArr4[i7] = (byte) (bArr4[i7] ^ this.f215[i7]);
            }
            byte[] bArr5 = this.f210;
            System.arraycopy(bArr5, 0, this.f215, 0, bArr5.length);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        m154();
        return this.f219 - this.f211;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        m154();
        int i2 = this.f211;
        if (i2 >= this.f219) {
            return -1;
        }
        byte[] bArr = this.f212;
        this.f211 = i2 + 1;
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
            m154();
            int i6 = this.f211;
            if (i6 >= this.f219) {
                if (i5 == i2) {
                    return -1;
                }
                return i3 - (i4 - i5);
            }
            byte[] bArr2 = this.f212;
            this.f211 = i6 + 1;
            bArr[i5] = bArr2[i6];
        }
        return i3;
    }
}