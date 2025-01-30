package org.apache.commons.io.b;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ByteArrayOutputStream.java */
/* loaded from: classes3.dex */
public class a extends OutputStream {
    private static final byte[] a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private final List<byte[]> f17576b;

    /* renamed from: c  reason: collision with root package name */
    private int f17577c;

    /* renamed from: d  reason: collision with root package name */
    private int f17578d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f17579e;

    /* renamed from: f  reason: collision with root package name */
    private int f17580f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f17581g;

    public a() {
        this(1024);
    }

    private void a(int i2) {
        if (this.f17577c < this.f17576b.size() - 1) {
            this.f17578d += this.f17579e.length;
            int i3 = this.f17577c + 1;
            this.f17577c = i3;
            this.f17579e = this.f17576b.get(i3);
            return;
        }
        byte[] bArr = this.f17579e;
        if (bArr == null) {
            this.f17578d = 0;
        } else {
            i2 = Math.max(bArr.length << 1, i2 - this.f17578d);
            this.f17578d += this.f17579e.length;
        }
        this.f17577c++;
        byte[] bArr2 = new byte[i2];
        this.f17579e = bArr2;
        this.f17576b.add(bArr2);
    }

    public synchronized byte[] b() {
        int i2 = this.f17580f;
        if (i2 == 0) {
            return a;
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (byte[] bArr2 : this.f17576b) {
            int min = Math.min(bArr2.length, i2);
            System.arraycopy(bArr2, 0, bArr, i3, min);
            i3 += min;
            i2 -= min;
            if (i2 == 0) {
                break;
            }
        }
        return bArr;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Deprecated
    public String toString() {
        return new String(b(), Charset.defaultCharset());
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        int i4;
        if (i2 < 0 || i2 > bArr.length || i3 < 0 || (i4 = i2 + i3) > bArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i3 == 0) {
            return;
        }
        synchronized (this) {
            int i5 = this.f17580f;
            int i6 = i5 + i3;
            int i7 = i5 - this.f17578d;
            while (i3 > 0) {
                int min = Math.min(i3, this.f17579e.length - i7);
                System.arraycopy(bArr, i4 - i3, this.f17579e, i7, min);
                i3 -= min;
                if (i3 > 0) {
                    a(i6);
                    i7 = 0;
                }
            }
            this.f17580f = i6;
        }
    }

    public a(int i2) {
        this.f17576b = new ArrayList();
        this.f17581g = true;
        if (i2 >= 0) {
            synchronized (this) {
                a(i2);
            }
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i2) {
        int i3 = this.f17580f;
        int i4 = i3 - this.f17578d;
        if (i4 == this.f17579e.length) {
            a(i3 + 1);
            i4 = 0;
        }
        this.f17579e[i4] = (byte) i2;
        this.f17580f++;
    }
}