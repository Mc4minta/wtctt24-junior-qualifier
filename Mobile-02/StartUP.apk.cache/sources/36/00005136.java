package j;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: RealBufferedSink.kt */
/* loaded from: classes3.dex */
public final class x implements g {
    public final f a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f17183b;

    /* renamed from: c  reason: collision with root package name */
    public final c0 f17184c;

    public x(c0 sink) {
        kotlin.jvm.internal.m.g(sink, "sink");
        this.f17184c = sink;
        this.a = new f();
    }

    @Override // j.g
    public g D(int i2) {
        if (!this.f17183b) {
            this.a.D(i2);
            return X();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public g F(long j2) {
        if (!this.f17183b) {
            this.a.F(j2);
            return X();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public g K0(i byteString) {
        kotlin.jvm.internal.m.g(byteString, "byteString");
        if (!this.f17183b) {
            this.a.K0(byteString);
            return X();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public g P(int i2) {
        if (!this.f17183b) {
            this.a.P(i2);
            return X();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public g R(int i2) {
        if (!this.f17183b) {
            this.a.R(i2);
            return X();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public g X() {
        if (!this.f17183b) {
            long d2 = this.a.d();
            if (d2 > 0) {
                this.f17184c.write(this.a, d2);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public g a1(long j2) {
        if (!this.f17183b) {
            this.a.a1(j2);
            return X();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public OutputStream c1() {
        return new a();
    }

    @Override // j.c0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f17183b) {
            return;
        }
        Throwable th = null;
        try {
            if (this.a.O0() > 0) {
                c0 c0Var = this.f17184c;
                f fVar = this.a;
                c0Var.write(fVar, fVar.O0());
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f17184c.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f17183b = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // j.g, j.c0, java.io.Flushable
    public void flush() {
        if (!this.f17183b) {
            if (this.a.O0() > 0) {
                c0 c0Var = this.f17184c;
                f fVar = this.a;
                c0Var.write(fVar, fVar.O0());
            }
            this.f17184c.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public f getBuffer() {
        return this.a;
    }

    @Override // j.g
    public g h0(String string) {
        kotlin.jvm.internal.m.g(string, "string");
        if (!this.f17183b) {
            this.a.h0(string);
            return X();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public f i() {
        return this.a;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f17183b;
    }

    @Override // j.g
    public g q0(String string, int i2, int i3) {
        kotlin.jvm.internal.m.g(string, "string");
        if (!this.f17183b) {
            this.a.q0(string, i2, i3);
            return X();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public long t0(e0 source) {
        kotlin.jvm.internal.m.g(source, "source");
        long j2 = 0;
        while (true) {
            long read = source.read(this.a, (long) PKIFailureInfo.certRevoked);
            if (read == -1) {
                return j2;
            }
            j2 += read;
            X();
        }
    }

    @Override // j.c0
    public f0 timeout() {
        return this.f17184c.timeout();
    }

    public String toString() {
        return "buffer(" + this.f17184c + ')';
    }

    @Override // j.g
    public g u0(long j2) {
        if (!this.f17183b) {
            this.a.u0(j2);
            return X();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public g w() {
        if (!this.f17183b) {
            long O0 = this.a.O0();
            if (O0 > 0) {
                this.f17184c.write(this.a, O0);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        kotlin.jvm.internal.m.g(source, "source");
        if (!this.f17183b) {
            int write = this.a.write(source);
            X();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public g x(int i2) {
        if (!this.f17183b) {
            this.a.x(i2);
            return X();
        }
        throw new IllegalStateException("closed".toString());
    }

    /* compiled from: RealBufferedSink.kt */
    /* loaded from: classes3.dex */
    public static final class a extends OutputStream {
        a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            x.this.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            x xVar = x.this;
            if (xVar.f17183b) {
                return;
            }
            xVar.flush();
        }

        public String toString() {
            return x.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i2) {
            x xVar = x.this;
            if (!xVar.f17183b) {
                xVar.a.R((byte) i2);
                x.this.X();
                return;
            }
            throw new IOException("closed");
        }

        @Override // java.io.OutputStream
        public void write(byte[] data, int i2, int i3) {
            kotlin.jvm.internal.m.g(data, "data");
            x xVar = x.this;
            if (!xVar.f17183b) {
                xVar.a.write(data, i2, i3);
                x.this.X();
                return;
            }
            throw new IOException("closed");
        }
    }

    @Override // j.c0
    public void write(f source, long j2) {
        kotlin.jvm.internal.m.g(source, "source");
        if (!this.f17183b) {
            this.a.write(source, j2);
            X();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public g write(byte[] source) {
        kotlin.jvm.internal.m.g(source, "source");
        if (!this.f17183b) {
            this.a.write(source);
            return X();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.g
    public g write(byte[] source, int i2, int i3) {
        kotlin.jvm.internal.m.g(source, "source");
        if (!this.f17183b) {
            this.a.write(source, i2, i3);
            return X();
        }
        throw new IllegalStateException("closed".toString());
    }
}