package e.g.b.a.d;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: LoggingStreamingContent.java */
/* loaded from: classes2.dex */
public final class u implements b0 {
    private final b0 a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13460b;

    /* renamed from: c  reason: collision with root package name */
    private final Level f13461c;

    /* renamed from: d  reason: collision with root package name */
    private final Logger f13462d;

    public u(b0 b0Var, Logger logger, Level level, int i2) {
        this.a = b0Var;
        this.f13462d = logger;
        this.f13461c = level;
        this.f13460b = i2;
    }

    @Override // e.g.b.a.d.b0
    public void writeTo(OutputStream outputStream) throws IOException {
        t tVar = new t(outputStream, this.f13462d, this.f13461c, this.f13460b);
        try {
            this.a.writeTo(tVar);
            tVar.a().close();
            outputStream.flush();
        } catch (Throwable th) {
            tVar.a().close();
            throw th;
        }
    }
}