package j;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: Source.kt */
/* loaded from: classes3.dex */
public interface e0 extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(f fVar, long j2) throws IOException;

    f0 timeout();
}