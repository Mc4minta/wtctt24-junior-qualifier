package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: PooledByteArrayBufferedInputStream.java */
/* loaded from: classes2.dex */
public class f extends InputStream {
    private final InputStream a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f4485b;

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.common.references.c<byte[]> f4486c;

    /* renamed from: d  reason: collision with root package name */
    private int f4487d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f4488e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4489f = false;

    public f(InputStream inputStream, byte[] bArr, com.facebook.common.references.c<byte[]> cVar) {
        this.a = (InputStream) e.f.d.c.i.g(inputStream);
        this.f4485b = (byte[]) e.f.d.c.i.g(bArr);
        this.f4486c = (com.facebook.common.references.c) e.f.d.c.i.g(cVar);
    }

    private boolean a() throws IOException {
        if (this.f4488e < this.f4487d) {
            return true;
        }
        int read = this.a.read(this.f4485b);
        if (read <= 0) {
            return false;
        }
        this.f4487d = read;
        this.f4488e = 0;
        return true;
    }

    private void b() throws IOException {
        if (this.f4489f) {
            throw new IOException("stream already closed");
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        e.f.d.c.i.i(this.f4488e <= this.f4487d);
        b();
        return (this.f4487d - this.f4488e) + this.a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f4489f) {
            return;
        }
        this.f4489f = true;
        this.f4486c.release(this.f4485b);
        super.close();
    }

    protected void finalize() throws Throwable {
        if (!this.f4489f) {
            e.f.d.d.a.i("PooledByteInputStream", "Finalized without closing");
            close();
        }
        super.finalize();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        e.f.d.c.i.i(this.f4488e <= this.f4487d);
        b();
        if (a()) {
            byte[] bArr = this.f4485b;
            int i2 = this.f4488e;
            this.f4488e = i2 + 1;
            return bArr[i2] & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public long skip(long j2) throws IOException {
        e.f.d.c.i.i(this.f4488e <= this.f4487d);
        b();
        int i2 = this.f4487d;
        int i3 = this.f4488e;
        long j3 = i2 - i3;
        if (j3 >= j2) {
            this.f4488e = (int) (i3 + j2);
            return j2;
        }
        this.f4488e = i2;
        return j3 + this.a.skip(j2 - j3);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        e.f.d.c.i.i(this.f4488e <= this.f4487d);
        b();
        if (a()) {
            int min = Math.min(this.f4487d - this.f4488e, i3);
            System.arraycopy(this.f4485b, this.f4488e, bArr, i2, min);
            this.f4488e += min;
            return min;
        }
        return -1;
    }
}