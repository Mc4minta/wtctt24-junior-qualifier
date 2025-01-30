package j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Timeout.kt */
/* loaded from: classes3.dex */
public class f0 {
    public static final b Companion = new b(null);
    public static final f0 NONE = new a();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    /* compiled from: Timeout.kt */
    /* loaded from: classes3.dex */
    public static final class a extends f0 {
        a() {
        }

        @Override // j.f0
        public f0 deadlineNanoTime(long j2) {
            return this;
        }

        @Override // j.f0
        public void throwIfReached() {
        }

        @Override // j.f0
        public f0 timeout(long j2, TimeUnit unit) {
            kotlin.jvm.internal.m.g(unit, "unit");
            return this;
        }
    }

    /* compiled from: Timeout.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public final long a(long j2, long j3) {
            return (j2 != 0 && (j3 == 0 || j2 < j3)) ? j2 : j3;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f0 clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public f0 clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final f0 deadline(long j2, TimeUnit unit) {
        kotlin.jvm.internal.m.g(unit, "unit");
        if (j2 > 0) {
            return deadlineNanoTime(System.nanoTime() + unit.toNanos(j2));
        }
        throw new IllegalArgumentException(("duration <= 0: " + j2).toString());
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final void intersectWith(f0 other, kotlin.e0.c.a<kotlin.x> block) {
        kotlin.jvm.internal.m.g(other, "other");
        kotlin.jvm.internal.m.g(block, "block");
        long timeoutNanos = timeoutNanos();
        long a2 = Companion.a(other.timeoutNanos(), timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout(a2, timeUnit);
        if (hasDeadline()) {
            long deadlineNanoTime = deadlineNanoTime();
            if (other.hasDeadline()) {
                deadlineNanoTime(Math.min(deadlineNanoTime(), other.deadlineNanoTime()));
            }
            try {
                block.invoke();
                kotlin.jvm.internal.l.b(1);
                timeout(timeoutNanos, timeUnit);
                if (other.hasDeadline()) {
                    deadlineNanoTime(deadlineNanoTime);
                }
                kotlin.jvm.internal.l.a(1);
                return;
            } catch (Throwable th) {
                kotlin.jvm.internal.l.b(1);
                timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (other.hasDeadline()) {
                    deadlineNanoTime(deadlineNanoTime);
                }
                kotlin.jvm.internal.l.a(1);
                throw th;
            }
        }
        if (other.hasDeadline()) {
            deadlineNanoTime(other.deadlineNanoTime());
        }
        try {
            block.invoke();
            kotlin.jvm.internal.l.b(1);
            timeout(timeoutNanos, timeUnit);
            if (other.hasDeadline()) {
                clearDeadline();
            }
            kotlin.jvm.internal.l.a(1);
        } catch (Throwable th2) {
            kotlin.jvm.internal.l.b(1);
            timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (other.hasDeadline()) {
                clearDeadline();
            }
            kotlin.jvm.internal.l.a(1);
            throw th2;
        }
    }

    public void throwIfReached() throws IOException {
        Thread currentThread = Thread.currentThread();
        kotlin.jvm.internal.m.f(currentThread, "Thread.currentThread()");
        if (!currentThread.isInterrupted()) {
            if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        throw new InterruptedIOException("interrupted");
    }

    public f0 timeout(long j2, TimeUnit unit) {
        kotlin.jvm.internal.m.g(unit, "unit");
        if (j2 >= 0) {
            this.timeoutNanos = unit.toNanos(j2);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j2).toString());
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object monitor) throws InterruptedIOException {
        kotlin.jvm.internal.m.g(monitor, "monitor");
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            long j2 = 0;
            if (!hasDeadline && timeoutNanos == 0) {
                monitor.wait();
                return;
            }
            long nanoTime = System.nanoTime();
            if (hasDeadline && timeoutNanos != 0) {
                timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - nanoTime);
            } else if (hasDeadline) {
                timeoutNanos = deadlineNanoTime() - nanoTime;
            }
            if (timeoutNanos > 0) {
                long j3 = timeoutNanos / 1000000;
                Long.signum(j3);
                monitor.wait(j3, (int) (timeoutNanos - (1000000 * j3)));
                j2 = System.nanoTime() - nanoTime;
            }
            if (j2 >= timeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public f0 deadlineNanoTime(long j2) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j2;
        return this;
    }
}