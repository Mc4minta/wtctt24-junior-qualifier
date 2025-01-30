package com.facebook.common.memory;

import java.io.InputStream;

/* compiled from: PooledByteBufferInputStream.java */
/* loaded from: classes2.dex */
public class h extends InputStream {
    final PooledByteBuffer a;

    /* renamed from: b  reason: collision with root package name */
    int f4490b;

    /* renamed from: c  reason: collision with root package name */
    int f4491c;

    public h(PooledByteBuffer pooledByteBuffer) {
        e.f.d.c.i.b(!pooledByteBuffer.isClosed());
        this.a = (PooledByteBuffer) e.f.d.c.i.g(pooledByteBuffer);
        this.f4490b = 0;
        this.f4491c = 0;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.a.size() - this.f4490b;
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.f4491c = this.f4490b;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (available() <= 0) {
            return -1;
        }
        PooledByteBuffer pooledByteBuffer = this.a;
        int i2 = this.f4490b;
        this.f4490b = i2 + 1;
        return pooledByteBuffer.k(i2) & 255;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.f4490b = this.f4491c;
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        e.f.d.c.i.b(j2 >= 0);
        int min = Math.min((int) j2, available());
        this.f4490b += min;
        return min;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        if (i2 >= 0 && i3 >= 0 && i2 + i3 <= bArr.length) {
            int available = available();
            if (available <= 0) {
                return -1;
            }
            if (i3 <= 0) {
                return 0;
            }
            int min = Math.min(available, i3);
            this.a.l(this.f4490b, bArr, i2, min);
            this.f4490b += min;
            return min;
        }
        throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i2 + "; regionLength=" + i3);
    }
}