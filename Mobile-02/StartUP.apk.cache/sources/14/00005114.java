package j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Okio.kt */
/* loaded from: classes3.dex */
public final class e implements c0 {
    @Override // j.c0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // j.c0, java.io.Flushable
    public void flush() {
    }

    @Override // j.c0
    public f0 timeout() {
        return f0.NONE;
    }

    @Override // j.c0
    public void write(f source, long j2) {
        kotlin.jvm.internal.m.g(source, "source");
        source.skip(j2);
    }
}