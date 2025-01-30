package e.g.b.a.d;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: ByteStreams.java */
/* loaded from: classes2.dex */
public final class g {
    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        y.d(inputStream);
        y.d(outputStream);
        byte[] bArr = new byte[4096];
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j2;
            }
            outputStream.write(bArr, 0, read);
            j2 += read;
        }
    }

    public static InputStream b(InputStream inputStream, long j2) {
        return new a(inputStream, j2);
    }

    public static int c(InputStream inputStream, byte[] bArr, int i2, int i3) throws IOException {
        y.d(inputStream);
        y.d(bArr);
        if (i3 >= 0) {
            int i4 = 0;
            while (i4 < i3) {
                int read = inputStream.read(bArr, i2 + i4, i3 - i4);
                if (read == -1) {
                    break;
                }
                i4 += read;
            }
            return i4;
        }
        throw new IndexOutOfBoundsException("len is negative");
    }

    /* compiled from: ByteStreams.java */
    /* loaded from: classes2.dex */
    private static final class a extends FilterInputStream {
        private long a;

        /* renamed from: b  reason: collision with root package name */
        private long f13410b;

        a(InputStream inputStream, long j2) {
            super(inputStream);
            this.f13410b = -1L;
            y.d(inputStream);
            y.b(j2 >= 0, "limit must be non-negative");
            this.a = j2;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.a);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i2) {
            ((FilterInputStream) this).in.mark(i2);
            this.f13410b = this.a;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.a == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read();
            if (read != -1) {
                this.a--;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (((FilterInputStream) this).in.markSupported()) {
                if (this.f13410b != -1) {
                    ((FilterInputStream) this).in.reset();
                    this.a = this.f13410b;
                } else {
                    throw new IOException("Mark not set");
                }
            } else {
                throw new IOException("Mark not supported");
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j2) throws IOException {
            long skip = ((FilterInputStream) this).in.skip(Math.min(j2, this.a));
            this.a -= skip;
            return skip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            long j2 = this.a;
            if (j2 == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read(bArr, i2, (int) Math.min(i3, j2));
            if (read != -1) {
                this.a -= read;
            }
            return read;
        }
    }
}