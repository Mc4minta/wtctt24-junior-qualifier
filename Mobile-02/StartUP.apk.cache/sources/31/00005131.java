package j;

import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmOkio.kt */
/* loaded from: classes3.dex */
public final class u implements c0 {
    private final OutputStream a;

    /* renamed from: b  reason: collision with root package name */
    private final f0 f17168b;

    public u(OutputStream out, f0 timeout) {
        kotlin.jvm.internal.m.g(out, "out");
        kotlin.jvm.internal.m.g(timeout, "timeout");
        this.a = out;
        this.f17168b = timeout;
    }

    @Override // j.c0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // j.c0, java.io.Flushable
    public void flush() {
        this.a.flush();
    }

    @Override // j.c0
    public f0 timeout() {
        return this.f17168b;
    }

    public String toString() {
        return "sink(" + this.a + ')';
    }

    @Override // j.c0
    public void write(f source, long j2) {
        kotlin.jvm.internal.m.g(source, "source");
        c.b(source.O0(), 0L, j2);
        while (j2 > 0) {
            this.f17168b.throwIfReached();
            z zVar = source.a;
            kotlin.jvm.internal.m.e(zVar);
            int min = (int) Math.min(j2, zVar.f17189d - zVar.f17188c);
            this.a.write(zVar.f17187b, zVar.f17188c, min);
            zVar.f17188c += min;
            long j3 = min;
            j2 -= j3;
            source.M0(source.O0() - j3);
            if (zVar.f17188c == zVar.f17189d) {
                source.a = zVar.b();
                a0.b(zVar);
            }
        }
    }
}