package j;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: DeflaterSink.kt */
/* loaded from: classes3.dex */
public final class j implements c0 {
    private boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final g f17155b;

    /* renamed from: c  reason: collision with root package name */
    private final Deflater f17156c;

    public j(g sink, Deflater deflater) {
        kotlin.jvm.internal.m.g(sink, "sink");
        kotlin.jvm.internal.m.g(deflater, "deflater");
        this.f17155b = sink;
        this.f17156c = deflater;
    }

    @IgnoreJRERequirement
    private final void a(boolean z) {
        z S0;
        int deflate;
        f buffer = this.f17155b.getBuffer();
        while (true) {
            S0 = buffer.S0(1);
            if (z) {
                Deflater deflater = this.f17156c;
                byte[] bArr = S0.f17187b;
                int i2 = S0.f17189d;
                deflate = deflater.deflate(bArr, i2, 8192 - i2, 2);
            } else {
                Deflater deflater2 = this.f17156c;
                byte[] bArr2 = S0.f17187b;
                int i3 = S0.f17189d;
                deflate = deflater2.deflate(bArr2, i3, 8192 - i3);
            }
            if (deflate > 0) {
                S0.f17189d += deflate;
                buffer.M0(buffer.O0() + deflate);
                this.f17155b.X();
            } else if (this.f17156c.needsInput()) {
                break;
            }
        }
        if (S0.f17188c == S0.f17189d) {
            buffer.a = S0.b();
            a0.b(S0);
        }
    }

    public final void b() {
        this.f17156c.finish();
        a(false);
    }

    @Override // j.c0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.a) {
            return;
        }
        Throwable th = null;
        try {
            b();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f17156c.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.f17155b.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.a = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // j.c0, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.f17155b.flush();
    }

    @Override // j.c0
    public f0 timeout() {
        return this.f17155b.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f17155b + ')';
    }

    @Override // j.c0
    public void write(f source, long j2) throws IOException {
        kotlin.jvm.internal.m.g(source, "source");
        c.b(source.O0(), 0L, j2);
        while (j2 > 0) {
            z zVar = source.a;
            kotlin.jvm.internal.m.e(zVar);
            int min = (int) Math.min(j2, zVar.f17189d - zVar.f17188c);
            this.f17156c.setInput(zVar.f17187b, zVar.f17188c, min);
            a(false);
            long j3 = min;
            source.M0(source.O0() - j3);
            int i2 = zVar.f17188c + min;
            zVar.f17188c = i2;
            if (i2 == zVar.f17189d) {
                source.a = zVar.b();
                a0.b(zVar);
            }
            j2 -= j3;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(c0 sink, Deflater deflater) {
        this(q.c(sink), deflater);
        kotlin.jvm.internal.m.g(sink, "sink");
        kotlin.jvm.internal.m.g(deflater, "deflater");
    }
}