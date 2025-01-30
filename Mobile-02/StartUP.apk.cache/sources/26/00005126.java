package j;

import java.io.IOException;

/* compiled from: ForwardingSink.kt */
/* loaded from: classes3.dex */
public abstract class k implements c0 {
    private final c0 delegate;

    public k(c0 delegate) {
        kotlin.jvm.internal.m.g(delegate, "delegate");
        this.delegate = delegate;
    }

    /* renamed from: -deprecated_delegate  reason: not valid java name */
    public final c0 m2202deprecated_delegate() {
        return this.delegate;
    }

    @Override // j.c0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final c0 delegate() {
        return this.delegate;
    }

    @Override // j.c0, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // j.c0
    public f0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // j.c0
    public void write(f source, long j2) throws IOException {
        kotlin.jvm.internal.m.g(source, "source");
        this.delegate.write(source, j2);
    }
}