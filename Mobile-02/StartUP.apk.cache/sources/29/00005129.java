package j;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: GzipSource.kt */
/* loaded from: classes3.dex */
public final class n implements e0 {
    private byte a;

    /* renamed from: b  reason: collision with root package name */
    private final y f17157b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f17158c;

    /* renamed from: d  reason: collision with root package name */
    private final o f17159d;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f17160e;

    public n(e0 source) {
        kotlin.jvm.internal.m.g(source, "source");
        y yVar = new y(source);
        this.f17157b = yVar;
        Inflater inflater = new Inflater(true);
        this.f17158c = inflater;
        this.f17159d = new o((h) yVar, inflater);
        this.f17160e = new CRC32();
    }

    private final void a(String str, int i2, int i3) {
        if (i3 == i2) {
            return;
        }
        String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i2)}, 3));
        kotlin.jvm.internal.m.f(format, "java.lang.String.format(this, *args)");
        throw new IOException(format);
    }

    private final void b() throws IOException {
        this.f17157b.Z0(10L);
        byte A = this.f17157b.a.A(3L);
        boolean z = ((A >> 1) & 1) == 1;
        if (z) {
            d(this.f17157b.a, 0L, 10L);
        }
        a("ID1ID2", 8075, this.f17157b.U0());
        this.f17157b.skip(8L);
        if (((A >> 2) & 1) == 1) {
            this.f17157b.Z0(2L);
            if (z) {
                d(this.f17157b.a, 0L, 2L);
            }
            long y0 = this.f17157b.a.y0();
            this.f17157b.Z0(y0);
            if (z) {
                d(this.f17157b.a, 0L, y0);
            }
            this.f17157b.skip(y0);
        }
        if (((A >> 3) & 1) == 1) {
            long a = this.f17157b.a((byte) 0);
            if (a != -1) {
                if (z) {
                    d(this.f17157b.a, 0L, a + 1);
                }
                this.f17157b.skip(a + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((A >> 4) & 1) == 1) {
            long a2 = this.f17157b.a((byte) 0);
            if (a2 != -1) {
                if (z) {
                    d(this.f17157b.a, 0L, a2 + 1);
                }
                this.f17157b.skip(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            a("FHCRC", this.f17157b.f(), (short) this.f17160e.getValue());
            this.f17160e.reset();
        }
    }

    private final void c() throws IOException {
        a("CRC", this.f17157b.D0(), (int) this.f17160e.getValue());
        a("ISIZE", this.f17157b.D0(), (int) this.f17158c.getBytesWritten());
    }

    private final void d(f fVar, long j2, long j3) {
        int i2;
        z zVar = fVar.a;
        kotlin.jvm.internal.m.e(zVar);
        while (true) {
            int i3 = zVar.f17189d;
            int i4 = zVar.f17188c;
            if (j2 < i3 - i4) {
                break;
            }
            j2 -= i3 - i4;
            zVar = zVar.f17192g;
            kotlin.jvm.internal.m.e(zVar);
        }
        while (j3 > 0) {
            int min = (int) Math.min(zVar.f17189d - i2, j3);
            this.f17160e.update(zVar.f17187b, (int) (zVar.f17188c + j2), min);
            j3 -= min;
            zVar = zVar.f17192g;
            kotlin.jvm.internal.m.e(zVar);
            j2 = 0;
        }
    }

    @Override // j.e0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f17159d.close();
    }

    @Override // j.e0
    public long read(f sink, long j2) throws IOException {
        kotlin.jvm.internal.m.g(sink, "sink");
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        } else if (i2 == 0) {
            return 0L;
        } else {
            if (this.a == 0) {
                b();
                this.a = (byte) 1;
            }
            if (this.a == 1) {
                long O0 = sink.O0();
                long read = this.f17159d.read(sink, j2);
                if (read != -1) {
                    d(sink, O0, read);
                    return read;
                }
                this.a = (byte) 2;
            }
            if (this.a == 2) {
                c();
                this.a = (byte) 3;
                if (!this.f17157b.Q()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    @Override // j.e0
    public f0 timeout() {
        return this.f17157b.timeout();
    }
}