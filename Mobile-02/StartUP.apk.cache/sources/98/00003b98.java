package com.google.firebase.perf.network;

import com.google.android.gms.internal.p000firebaseperf.i0;
import com.google.android.gms.internal.p000firebaseperf.y0;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public final class b extends InputStream {
    private final InputStream a;

    /* renamed from: b  reason: collision with root package name */
    private final i0 f9381b;

    /* renamed from: c  reason: collision with root package name */
    private final y0 f9382c;

    /* renamed from: e  reason: collision with root package name */
    private long f9384e;

    /* renamed from: d  reason: collision with root package name */
    private long f9383d = -1;

    /* renamed from: f  reason: collision with root package name */
    private long f9385f = -1;

    public b(InputStream inputStream, i0 i0Var, y0 y0Var) {
        this.f9382c = y0Var;
        this.a = inputStream;
        this.f9381b = i0Var;
        this.f9384e = i0Var.e();
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        try {
            return this.a.available();
        } catch (IOException e2) {
            this.f9381b.o(this.f9382c.a());
            g.c(this.f9381b);
            throw e2;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        long a = this.f9382c.a();
        if (this.f9385f == -1) {
            this.f9385f = a;
        }
        try {
            this.a.close();
            long j2 = this.f9383d;
            if (j2 != -1) {
                this.f9381b.p(j2);
            }
            long j3 = this.f9384e;
            if (j3 != -1) {
                this.f9381b.n(j3);
            }
            this.f9381b.o(this.f9385f);
            this.f9381b.g();
        } catch (IOException e2) {
            this.f9381b.o(this.f9382c.a());
            g.c(this.f9381b);
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public final void mark(int i2) {
        this.a.mark(i2);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.a.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        try {
            int read = this.a.read();
            long a = this.f9382c.a();
            if (this.f9384e == -1) {
                this.f9384e = a;
            }
            if (read == -1 && this.f9385f == -1) {
                this.f9385f = a;
                this.f9381b.o(a);
                this.f9381b.g();
            } else {
                long j2 = this.f9383d + 1;
                this.f9383d = j2;
                this.f9381b.p(j2);
            }
            return read;
        } catch (IOException e2) {
            this.f9381b.o(this.f9382c.a());
            g.c(this.f9381b);
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public final void reset() throws IOException {
        try {
            this.a.reset();
        } catch (IOException e2) {
            this.f9381b.o(this.f9382c.a());
            g.c(this.f9381b);
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public final long skip(long j2) throws IOException {
        try {
            long skip = this.a.skip(j2);
            long a = this.f9382c.a();
            if (this.f9384e == -1) {
                this.f9384e = a;
            }
            if (skip == -1 && this.f9385f == -1) {
                this.f9385f = a;
                this.f9381b.o(a);
            } else {
                long j3 = this.f9383d + skip;
                this.f9383d = j3;
                this.f9381b.p(j3);
            }
            return skip;
        } catch (IOException e2) {
            this.f9381b.o(this.f9382c.a());
            g.c(this.f9381b);
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        try {
            int read = this.a.read(bArr, i2, i3);
            long a = this.f9382c.a();
            if (this.f9384e == -1) {
                this.f9384e = a;
            }
            if (read == -1 && this.f9385f == -1) {
                this.f9385f = a;
                this.f9381b.o(a);
                this.f9381b.g();
            } else {
                long j2 = this.f9383d + read;
                this.f9383d = j2;
                this.f9381b.p(j2);
            }
            return read;
        } catch (IOException e2) {
            this.f9381b.o(this.f9382c.a());
            g.c(this.f9381b);
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        try {
            int read = this.a.read(bArr);
            long a = this.f9382c.a();
            if (this.f9384e == -1) {
                this.f9384e = a;
            }
            if (read == -1 && this.f9385f == -1) {
                this.f9385f = a;
                this.f9381b.o(a);
                this.f9381b.g();
            } else {
                long j2 = this.f9383d + read;
                this.f9383d = j2;
                this.f9381b.p(j2);
            }
            return read;
        } catch (IOException e2) {
            this.f9381b.o(this.f9382c.a());
            g.c(this.f9381b);
            throw e2;
        }
    }
}