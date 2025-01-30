package j;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: RealBufferedSource.kt */
/* loaded from: classes3.dex */
public final class y implements h {
    public final f a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f17185b;

    /* renamed from: c  reason: collision with root package name */
    public final e0 f17186c;

    public y(e0 source) {
        kotlin.jvm.internal.m.g(source, "source");
        this.f17186c = source;
        this.a = new f();
    }

    @Override // j.h
    public int C() {
        Z0(4L);
        return this.a.C();
    }

    @Override // j.h
    public String C0() {
        return Z(Long.MAX_VALUE);
    }

    @Override // j.h
    public int D0() {
        Z0(4L);
        return this.a.D0();
    }

    @Override // j.h
    public byte[] E0(long j2) {
        Z0(j2);
        return this.a.E0(j2);
    }

    @Override // j.h
    public String G0() {
        this.a.t0(this.f17186c);
        return this.a.G0();
    }

    @Override // j.h
    public long H() {
        Z0(8L);
        return this.a.H();
    }

    @Override // j.h
    public byte[] J() {
        this.a.t0(this.f17186c);
        return this.a.J();
    }

    @Override // j.h
    public long M(i bytes) {
        kotlin.jvm.internal.m.g(bytes, "bytes");
        return c(bytes, 0L);
    }

    @Override // j.h
    public long P0() {
        Z0(8L);
        return this.a.P0();
    }

    @Override // j.h
    public boolean Q() {
        if (!this.f17185b) {
            return this.a.Q() && this.f17186c.read(this.a, (long) PKIFailureInfo.certRevoked) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.h
    public long T0(c0 sink) {
        kotlin.jvm.internal.m.g(sink, "sink");
        long j2 = 0;
        while (this.f17186c.read(this.a, (long) PKIFailureInfo.certRevoked) != -1) {
            long d2 = this.a.d();
            if (d2 > 0) {
                j2 += d2;
                sink.write(this.a, d2);
            }
        }
        if (this.a.O0() > 0) {
            long O0 = j2 + this.a.O0();
            f fVar = this.a;
            sink.write(fVar, fVar.O0());
            return O0;
        }
        return j2;
    }

    @Override // j.h
    public void U(f sink, long j2) {
        kotlin.jvm.internal.m.g(sink, "sink");
        try {
            Z0(j2);
            this.a.U(sink, j2);
        } catch (EOFException e2) {
            sink.t0(this.a);
            throw e2;
        }
    }

    @Override // j.h
    public short U0() {
        Z0(2L);
        return this.a.U0();
    }

    @Override // j.h
    public long W(i targetBytes) {
        kotlin.jvm.internal.m.g(targetBytes, "targetBytes");
        return d(targetBytes, 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        if (r4 == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        r1 = new java.lang.StringBuilder();
        r1.append("Expected leading [0-9] or '-' character but was 0x");
        r2 = kotlin.l0.b.a(16);
        r2 = kotlin.l0.b.a(r2);
        r2 = java.lang.Integer.toString(r8, r2);
        kotlin.jvm.internal.m.f(r2, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        r1.append(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        throw new java.lang.NumberFormatException(r1.toString());
     */
    @Override // j.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long Y() {
        /*
            r10 = this;
            r0 = 1
            r10.Z0(r0)
            r2 = 0
            r4 = r2
        L8:
            long r6 = r4 + r0
            boolean r8 = r10.request(r6)
            if (r8 == 0) goto L59
            j.f r8 = r10.a
            byte r8 = r8.A(r4)
            r9 = 48
            byte r9 = (byte) r9
            if (r8 < r9) goto L20
            r9 = 57
            byte r9 = (byte) r9
            if (r8 <= r9) goto L2a
        L20:
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 != 0) goto L2c
            r5 = 45
            byte r5 = (byte) r5
            if (r8 == r5) goto L2a
            goto L2c
        L2a:
            r4 = r6
            goto L8
        L2c:
            if (r4 == 0) goto L2f
            goto L59
        L2f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9] or '-' character but was 0x"
            r1.append(r2)
            r2 = 16
            int r2 = kotlin.l0.a.a(r2)
            int r2 = kotlin.l0.a.a(r2)
            java.lang.String r2 = java.lang.Integer.toString(r8, r2)
            java.lang.String r3 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            kotlin.jvm.internal.m.f(r2, r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L59:
            j.f r0 = r10.a
            long r0 = r0.Y()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j.y.Y():long");
    }

    @Override // j.h
    public String Z(long j2) {
        if (j2 >= 0) {
            long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
            byte b2 = (byte) 10;
            long b3 = b(b2, 0L, j3);
            if (b3 != -1) {
                return j.h0.a.d(this.a, b3);
            }
            if (j3 < Long.MAX_VALUE && request(j3) && this.a.A(j3 - 1) == ((byte) 13) && request(1 + j3) && this.a.A(j3) == b2) {
                return j.h0.a.d(this.a, j3);
            }
            f fVar = new f();
            f fVar2 = this.a;
            fVar2.f(fVar, 0L, Math.min(32, fVar2.O0()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.a.O0(), j2) + " content=" + fVar.v0().F() + "…");
        }
        throw new IllegalArgumentException(("limit < 0: " + j2).toString());
    }

    @Override // j.h
    public void Z0(long j2) {
        if (!request(j2)) {
            throw new EOFException();
        }
    }

    public long a(byte b2) {
        return b(b2, 0L, Long.MAX_VALUE);
    }

    public long b(byte b2, long j2, long j3) {
        boolean z = true;
        if (!this.f17185b) {
            if (!((0 > j2 || j3 < j2) ? false : false)) {
                throw new IllegalArgumentException(("fromIndex=" + j2 + " toIndex=" + j3).toString());
            }
            while (j2 < j3) {
                long G = this.a.G(b2, j2, j3);
                if (G != -1) {
                    return G;
                }
                long O0 = this.a.O0();
                if (O0 >= j3 || this.f17186c.read(this.a, (long) PKIFailureInfo.certRevoked) == -1) {
                    return -1L;
                }
                j2 = Math.max(j2, O0);
            }
            return -1L;
        }
        throw new IllegalStateException("closed".toString());
    }

    public long c(i bytes, long j2) {
        kotlin.jvm.internal.m.g(bytes, "bytes");
        if (!(!this.f17185b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long K = this.a.K(bytes, j2);
            if (K != -1) {
                return K;
            }
            long O0 = this.a.O0();
            if (this.f17186c.read(this.a, (long) PKIFailureInfo.certRevoked) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, (O0 - bytes.Q()) + 1);
        }
    }

    @Override // j.e0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f17185b) {
            return;
        }
        this.f17185b = true;
        this.f17186c.close();
        this.a.b();
    }

    public long d(i targetBytes, long j2) {
        kotlin.jvm.internal.m.g(targetBytes, "targetBytes");
        if (!(!this.f17185b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long N = this.a.N(targetBytes, j2);
            if (N != -1) {
                return N;
            }
            long O0 = this.a.O0();
            if (this.f17186c.read(this.a, (long) PKIFailureInfo.certRevoked) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, O0);
        }
    }

    public boolean e(long j2, i bytes, int i2, int i3) {
        int i4;
        kotlin.jvm.internal.m.g(bytes, "bytes");
        if (!this.f17185b) {
            if (j2 >= 0 && i2 >= 0 && i3 >= 0 && bytes.Q() - i2 >= i3) {
                for (i4 = 0; i4 < i3; i4 = i4 + 1) {
                    long j3 = i4 + j2;
                    i4 = (request(1 + j3) && this.a.A(j3) == bytes.A(i2 + i4)) ? i4 + 1 : 0;
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.h
    public long e1() {
        byte A;
        int a2;
        int a3;
        Z0(1L);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!request(i3)) {
                break;
            }
            A = this.a.A(i2);
            if ((A < ((byte) 48) || A > ((byte) 57)) && ((A < ((byte) 97) || A > ((byte) 102)) && (A < ((byte) 65) || A > ((byte) 70)))) {
                break;
            }
            i2 = i3;
        }
        if (i2 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            a2 = kotlin.l0.b.a(16);
            a3 = kotlin.l0.b.a(a2);
            String num = Integer.toString(A, a3);
            kotlin.jvm.internal.m.f(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            sb.append(num);
            throw new NumberFormatException(sb.toString());
        }
        return this.a.e1();
    }

    public short f() {
        Z0(2L);
        return this.a.y0();
    }

    @Override // j.h
    public InputStream g1() {
        return new a();
    }

    @Override // j.h, j.g
    public f getBuffer() {
        return this.a;
    }

    @Override // j.h
    public int h1(t options) {
        kotlin.jvm.internal.m.g(options, "options");
        if (!this.f17185b) {
            while (true) {
                int e2 = j.h0.a.e(this.a, options, true);
                if (e2 == -2) {
                    if (this.f17186c.read(this.a, (long) PKIFailureInfo.certRevoked) == -1) {
                        break;
                    }
                } else if (e2 != -1) {
                    this.a.skip(options.m()[e2].Q());
                    return e2;
                }
            }
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.h, j.g
    public f i() {
        return this.a;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f17185b;
    }

    @Override // j.h
    public boolean j0(long j2, i bytes) {
        kotlin.jvm.internal.m.g(bytes, "bytes");
        return e(j2, bytes, 0, bytes.Q());
    }

    @Override // j.h
    public String l0(Charset charset) {
        kotlin.jvm.internal.m.g(charset, "charset");
        this.a.t0(this.f17186c);
        return this.a.l0(charset);
    }

    @Override // j.h
    public byte m0() {
        Z0(1L);
        return this.a.m0();
    }

    @Override // j.h
    public String p(long j2) {
        Z0(j2);
        return this.a.p(j2);
    }

    @Override // j.h
    public h peek() {
        return q.d(new v(this));
    }

    @Override // j.e0
    public long read(f sink, long j2) {
        kotlin.jvm.internal.m.g(sink, "sink");
        if (j2 >= 0) {
            if (!this.f17185b) {
                if (this.a.O0() == 0 && this.f17186c.read(this.a, (long) PKIFailureInfo.certRevoked) == -1) {
                    return -1L;
                }
                return this.a.read(sink, Math.min(j2, this.a.O0()));
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }

    @Override // j.h
    public void readFully(byte[] sink) {
        kotlin.jvm.internal.m.g(sink, "sink");
        try {
            Z0(sink.length);
            this.a.readFully(sink);
        } catch (EOFException e2) {
            int i2 = 0;
            while (this.a.O0() > 0) {
                f fVar = this.a;
                int n0 = fVar.n0(sink, i2, (int) fVar.O0());
                if (n0 == -1) {
                    throw new AssertionError();
                }
                i2 += n0;
            }
            throw e2;
        }
    }

    @Override // j.h
    public boolean request(long j2) {
        if (j2 >= 0) {
            if (!this.f17185b) {
                while (this.a.O0() < j2) {
                    if (this.f17186c.read(this.a, (long) PKIFailureInfo.certRevoked) == -1) {
                        return false;
                    }
                }
                return true;
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }

    @Override // j.h
    public i s(long j2) {
        Z0(j2);
        return this.a.s(j2);
    }

    @Override // j.h
    public void skip(long j2) {
        if (!(!this.f17185b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j2 > 0) {
            if (this.a.O0() == 0 && this.f17186c.read(this.a, (long) PKIFailureInfo.certRevoked) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j2, this.a.O0());
            this.a.skip(min);
            j2 -= min;
        }
    }

    @Override // j.e0
    public f0 timeout() {
        return this.f17186c.timeout();
    }

    public String toString() {
        return "buffer(" + this.f17186c + ')';
    }

    @Override // j.h
    public i v0() {
        this.a.t0(this.f17186c);
        return this.a.v0();
    }

    /* compiled from: RealBufferedSource.kt */
    /* loaded from: classes3.dex */
    public static final class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() {
            y yVar = y.this;
            if (!yVar.f17185b) {
                return (int) Math.min(yVar.a.O0(), (long) RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
            }
            throw new IOException("closed");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            y.this.close();
        }

        @Override // java.io.InputStream
        public int read() {
            y yVar = y.this;
            if (!yVar.f17185b) {
                if (yVar.a.O0() == 0) {
                    y yVar2 = y.this;
                    if (yVar2.f17186c.read(yVar2.a, (long) PKIFailureInfo.certRevoked) == -1) {
                        return -1;
                    }
                }
                return y.this.a.m0() & 255;
            }
            throw new IOException("closed");
        }

        public String toString() {
            return y.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] data, int i2, int i3) {
            kotlin.jvm.internal.m.g(data, "data");
            if (!y.this.f17185b) {
                c.b(data.length, i2, i3);
                if (y.this.a.O0() == 0) {
                    y yVar = y.this;
                    if (yVar.f17186c.read(yVar.a, (long) PKIFailureInfo.certRevoked) == -1) {
                        return -1;
                    }
                }
                return y.this.a.n0(data, i2, i3);
            }
            throw new IOException("closed");
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        kotlin.jvm.internal.m.g(sink, "sink");
        if (this.a.O0() == 0 && this.f17186c.read(this.a, (long) PKIFailureInfo.certRevoked) == -1) {
            return -1;
        }
        return this.a.read(sink);
    }
}