package e.f.d.g;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* compiled from: TailAppendingInputStream.java */
/* loaded from: classes2.dex */
public class b extends FilterInputStream {
    private final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private int f12089b;

    /* renamed from: c  reason: collision with root package name */
    private int f12090c;

    public b(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        Objects.requireNonNull(inputStream);
        Objects.requireNonNull(bArr);
        this.a = bArr;
    }

    private int a() {
        int i2 = this.f12089b;
        byte[] bArr = this.a;
        if (i2 >= bArr.length) {
            return -1;
        }
        this.f12089b = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        if (((FilterInputStream) this).in.markSupported()) {
            super.mark(i2);
            this.f12090c = this.f12089b;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = ((FilterInputStream) this).in.read();
        return read != -1 ? read : a();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (((FilterInputStream) this).in.markSupported()) {
            ((FilterInputStream) this).in.reset();
            this.f12089b = this.f12090c;
            return;
        }
        throw new IOException("mark is not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = ((FilterInputStream) this).in.read(bArr, i2, i3);
        if (read != -1) {
            return read;
        }
        int i4 = 0;
        if (i3 == 0) {
            return 0;
        }
        while (i4 < i3) {
            int a = a();
            if (a == -1) {
                break;
            }
            bArr[i2 + i4] = (byte) a;
            i4++;
        }
        if (i4 > 0) {
            return i4;
        }
        return -1;
    }
}