package j;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout.kt */
/* loaded from: classes3.dex */
public class m extends f0 {
    private f0 a;

    public m(f0 delegate) {
        kotlin.jvm.internal.m.g(delegate, "delegate");
        this.a = delegate;
    }

    public final f0 a() {
        return this.a;
    }

    public final m b(f0 delegate) {
        kotlin.jvm.internal.m.g(delegate, "delegate");
        this.a = delegate;
        return this;
    }

    @Override // j.f0
    public f0 clearDeadline() {
        return this.a.clearDeadline();
    }

    @Override // j.f0
    public f0 clearTimeout() {
        return this.a.clearTimeout();
    }

    @Override // j.f0
    public long deadlineNanoTime() {
        return this.a.deadlineNanoTime();
    }

    @Override // j.f0
    public boolean hasDeadline() {
        return this.a.hasDeadline();
    }

    @Override // j.f0
    public void throwIfReached() throws IOException {
        this.a.throwIfReached();
    }

    @Override // j.f0
    public f0 timeout(long j2, TimeUnit unit) {
        kotlin.jvm.internal.m.g(unit, "unit");
        return this.a.timeout(j2, unit);
    }

    @Override // j.f0
    public long timeoutNanos() {
        return this.a.timeoutNanos();
    }

    @Override // j.f0
    public f0 deadlineNanoTime(long j2) {
        return this.a.deadlineNanoTime(j2);
    }
}