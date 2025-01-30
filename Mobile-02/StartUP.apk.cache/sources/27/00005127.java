package j;

import java.io.IOException;

/* compiled from: ForwardingSource.kt */
/* loaded from: classes3.dex */
public abstract class l implements e0 {
    private final e0 delegate;

    public l(e0 delegate) {
        kotlin.jvm.internal.m.g(delegate, "delegate");
        this.delegate = delegate;
    }

    /* renamed from: -deprecated_delegate  reason: not valid java name */
    public final e0 m2203deprecated_delegate() {
        return this.delegate;
    }

    @Override // j.e0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final e0 delegate() {
        return this.delegate;
    }

    @Override // j.e0
    public long read(f sink, long j2) throws IOException {
        kotlin.jvm.internal.m.g(sink, "sink");
        return this.delegate.read(sink, j2);
    }

    @Override // j.e0
    public f0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}