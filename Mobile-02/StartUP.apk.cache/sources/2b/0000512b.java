package j;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmOkio.kt */
/* loaded from: classes3.dex */
public final class p implements e0 {
    private final InputStream a;

    /* renamed from: b  reason: collision with root package name */
    private final f0 f17164b;

    public p(InputStream input, f0 timeout) {
        kotlin.jvm.internal.m.g(input, "input");
        kotlin.jvm.internal.m.g(timeout, "timeout");
        this.a = input;
        this.f17164b = timeout;
    }

    @Override // j.e0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // j.e0
    public long read(f sink, long j2) {
        kotlin.jvm.internal.m.g(sink, "sink");
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 == 0) {
            return 0L;
        }
        if (i2 >= 0) {
            try {
                this.f17164b.throwIfReached();
                z S0 = sink.S0(1);
                int read = this.a.read(S0.f17187b, S0.f17189d, (int) Math.min(j2, 8192 - S0.f17189d));
                if (read == -1) {
                    if (S0.f17188c == S0.f17189d) {
                        sink.a = S0.b();
                        a0.b(S0);
                        return -1L;
                    }
                    return -1L;
                }
                S0.f17189d += read;
                long j3 = read;
                sink.M0(sink.O0() + j3);
                return j3;
            } catch (AssertionError e2) {
                if (q.e(e2)) {
                    throw new IOException(e2);
                }
                throw e2;
            }
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }

    @Override // j.e0
    public f0 timeout() {
        return this.f17164b;
    }

    public String toString() {
        return "source(" + this.a + ')';
    }
}