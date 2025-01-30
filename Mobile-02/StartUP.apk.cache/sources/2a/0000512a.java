package j;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource.kt */
/* loaded from: classes3.dex */
public final class o implements e0 {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17161b;

    /* renamed from: c  reason: collision with root package name */
    private final h f17162c;

    /* renamed from: d  reason: collision with root package name */
    private final Inflater f17163d;

    public o(h source, Inflater inflater) {
        kotlin.jvm.internal.m.g(source, "source");
        kotlin.jvm.internal.m.g(inflater, "inflater");
        this.f17162c = source;
        this.f17163d = inflater;
    }

    private final void c() {
        int i2 = this.a;
        if (i2 == 0) {
            return;
        }
        int remaining = i2 - this.f17163d.getRemaining();
        this.a -= remaining;
        this.f17162c.skip(remaining);
    }

    public final long a(f sink, long j2) throws IOException {
        kotlin.jvm.internal.m.g(sink, "sink");
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 >= 0) {
            if (!this.f17161b) {
                if (i2 == 0) {
                    return 0L;
                }
                try {
                    z S0 = sink.S0(1);
                    b();
                    int inflate = this.f17163d.inflate(S0.f17187b, S0.f17189d, (int) Math.min(j2, 8192 - S0.f17189d));
                    c();
                    if (inflate > 0) {
                        S0.f17189d += inflate;
                        long j3 = inflate;
                        sink.M0(sink.O0() + j3);
                        return j3;
                    }
                    if (S0.f17188c == S0.f17189d) {
                        sink.a = S0.b();
                        a0.b(S0);
                    }
                    return 0L;
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }

    public final boolean b() throws IOException {
        if (this.f17163d.needsInput()) {
            if (this.f17162c.Q()) {
                return true;
            }
            z zVar = this.f17162c.getBuffer().a;
            kotlin.jvm.internal.m.e(zVar);
            int i2 = zVar.f17189d;
            int i3 = zVar.f17188c;
            int i4 = i2 - i3;
            this.a = i4;
            this.f17163d.setInput(zVar.f17187b, i3, i4);
            return false;
        }
        return false;
    }

    @Override // j.e0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f17161b) {
            return;
        }
        this.f17163d.end();
        this.f17161b = true;
        this.f17162c.close();
    }

    @Override // j.e0
    public long read(f sink, long j2) throws IOException {
        kotlin.jvm.internal.m.g(sink, "sink");
        do {
            long a = a(sink, j2);
            if (a > 0) {
                return a;
            }
            if (this.f17163d.finished() || this.f17163d.needsDictionary()) {
                return -1L;
            }
        } while (!this.f17162c.Q());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // j.e0
    public f0 timeout() {
        return this.f17162c.timeout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(e0 source, Inflater inflater) {
        this(q.d(source), inflater);
        kotlin.jvm.internal.m.g(source, "source");
        kotlin.jvm.internal.m.g(inflater, "inflater");
    }
}