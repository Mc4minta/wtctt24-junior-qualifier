package j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AsyncTimeout.kt */
/* loaded from: classes3.dex */
public class d extends f0 {
    public static final a Companion = new a(null);
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static d head;
    private boolean inQueue;
    private d next;
    private long timeoutAt;

    /* compiled from: AsyncTimeout.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(d dVar) {
            synchronized (d.class) {
                if (dVar.inQueue) {
                    dVar.inQueue = false;
                    for (d dVar2 = d.head; dVar2 != null; dVar2 = dVar2.next) {
                        if (dVar2.next == dVar) {
                            dVar2.next = dVar.next;
                            dVar.next = null;
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(d dVar, long j2, boolean z) {
            synchronized (d.class) {
                if (!dVar.inQueue) {
                    dVar.inQueue = true;
                    if (d.head == null) {
                        d.head = new d();
                        new b().start();
                    }
                    long nanoTime = System.nanoTime();
                    int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                    if (i2 != 0 && z) {
                        dVar.timeoutAt = Math.min(j2, dVar.deadlineNanoTime() - nanoTime) + nanoTime;
                    } else if (i2 != 0) {
                        dVar.timeoutAt = j2 + nanoTime;
                    } else if (z) {
                        dVar.timeoutAt = dVar.deadlineNanoTime();
                    } else {
                        throw new AssertionError();
                    }
                    long remainingNanos = dVar.remainingNanos(nanoTime);
                    d dVar2 = d.head;
                    kotlin.jvm.internal.m.e(dVar2);
                    while (dVar2.next != null) {
                        d dVar3 = dVar2.next;
                        kotlin.jvm.internal.m.e(dVar3);
                        if (remainingNanos < dVar3.remainingNanos(nanoTime)) {
                            break;
                        }
                        dVar2 = dVar2.next;
                        kotlin.jvm.internal.m.e(dVar2);
                    }
                    dVar.next = dVar2.next;
                    dVar2.next = dVar;
                    if (dVar2 == d.head) {
                        d.class.notify();
                    }
                    kotlin.x xVar = kotlin.x.a;
                } else {
                    throw new IllegalStateException("Unbalanced enter/exit".toString());
                }
            }
        }

        public final d c() throws InterruptedException {
            d dVar = d.head;
            kotlin.jvm.internal.m.e(dVar);
            d dVar2 = dVar.next;
            if (dVar2 != null) {
                long remainingNanos = dVar2.remainingNanos(System.nanoTime());
                if (remainingNanos <= 0) {
                    d dVar3 = d.head;
                    kotlin.jvm.internal.m.e(dVar3);
                    dVar3.next = dVar2.next;
                    dVar2.next = null;
                    return dVar2;
                }
                long j2 = remainingNanos / 1000000;
                d.class.wait(j2, (int) (remainingNanos - (1000000 * j2)));
                return null;
            }
            long nanoTime = System.nanoTime();
            d.class.wait(d.IDLE_TIMEOUT_MILLIS);
            d dVar4 = d.head;
            kotlin.jvm.internal.m.e(dVar4);
            if (dVar4.next != null || System.nanoTime() - nanoTime < d.IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return d.head;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AsyncTimeout.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d c2;
            while (true) {
                try {
                    synchronized (d.class) {
                        c2 = d.Companion.c();
                        if (c2 == d.head) {
                            d.head = null;
                            return;
                        }
                        kotlin.x xVar = kotlin.x.a;
                    }
                    if (c2 != null) {
                        c2.timedOut();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* compiled from: AsyncTimeout.kt */
    /* loaded from: classes3.dex */
    public static final class c implements c0 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c0 f17142b;

        c(c0 c0Var) {
            this.f17142b = c0Var;
        }

        @Override // j.c0
        /* renamed from: a */
        public d timeout() {
            return d.this;
        }

        @Override // j.c0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            d dVar = d.this;
            dVar.enter();
            try {
                this.f17142b.close();
                kotlin.x xVar = kotlin.x.a;
                if (dVar.exit()) {
                    throw dVar.access$newTimeoutException(null);
                }
            } catch (IOException e2) {
                if (!dVar.exit()) {
                    throw e2;
                }
                throw dVar.access$newTimeoutException(e2);
            } finally {
                dVar.exit();
            }
        }

        @Override // j.c0, java.io.Flushable
        public void flush() {
            d dVar = d.this;
            dVar.enter();
            try {
                this.f17142b.flush();
                kotlin.x xVar = kotlin.x.a;
                if (dVar.exit()) {
                    throw dVar.access$newTimeoutException(null);
                }
            } catch (IOException e2) {
                if (!dVar.exit()) {
                    throw e2;
                }
                throw dVar.access$newTimeoutException(e2);
            } finally {
                dVar.exit();
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f17142b + ')';
        }

        @Override // j.c0
        public void write(f source, long j2) {
            kotlin.jvm.internal.m.g(source, "source");
            j.c.b(source.O0(), 0L, j2);
            while (true) {
                long j3 = 0;
                if (j2 <= 0) {
                    return;
                }
                z zVar = source.a;
                kotlin.jvm.internal.m.e(zVar);
                while (true) {
                    if (j3 >= 65536) {
                        break;
                    }
                    j3 += zVar.f17189d - zVar.f17188c;
                    if (j3 >= j2) {
                        j3 = j2;
                        break;
                    } else {
                        zVar = zVar.f17192g;
                        kotlin.jvm.internal.m.e(zVar);
                    }
                }
                d dVar = d.this;
                dVar.enter();
                try {
                    this.f17142b.write(source, j3);
                    kotlin.x xVar = kotlin.x.a;
                    if (dVar.exit()) {
                        throw dVar.access$newTimeoutException(null);
                    }
                    j2 -= j3;
                } catch (IOException e2) {
                    if (!dVar.exit()) {
                        throw e2;
                    }
                    throw dVar.access$newTimeoutException(e2);
                } finally {
                    dVar.exit();
                }
            }
        }
    }

    /* compiled from: AsyncTimeout.kt */
    /* renamed from: j.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0410d implements e0 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e0 f17143b;

        C0410d(e0 e0Var) {
            this.f17143b = e0Var;
        }

        @Override // j.e0
        /* renamed from: a */
        public d timeout() {
            return d.this;
        }

        @Override // j.e0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            d dVar = d.this;
            dVar.enter();
            try {
                this.f17143b.close();
                kotlin.x xVar = kotlin.x.a;
                if (dVar.exit()) {
                    throw dVar.access$newTimeoutException(null);
                }
            } catch (IOException e2) {
                if (!dVar.exit()) {
                    throw e2;
                }
                throw dVar.access$newTimeoutException(e2);
            } finally {
                dVar.exit();
            }
        }

        @Override // j.e0
        public long read(f sink, long j2) {
            kotlin.jvm.internal.m.g(sink, "sink");
            d dVar = d.this;
            dVar.enter();
            try {
                long read = this.f17143b.read(sink, j2);
                if (dVar.exit()) {
                    throw dVar.access$newTimeoutException(null);
                }
                return read;
            } catch (IOException e2) {
                if (dVar.exit()) {
                    throw dVar.access$newTimeoutException(e2);
                }
                throw e2;
            } finally {
                dVar.exit();
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f17143b + ')';
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long remainingNanos(long j2) {
        return this.timeoutAt - j2;
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void enter() {
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            Companion.e(this, timeoutNanos, hasDeadline);
        }
    }

    public final boolean exit() {
        return Companion.d(this);
    }

    protected IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final c0 sink(c0 sink) {
        kotlin.jvm.internal.m.g(sink, "sink");
        return new c(sink);
    }

    public final e0 source(e0 source) {
        kotlin.jvm.internal.m.g(source, "source");
        return new C0410d(source);
    }

    protected void timedOut() {
    }

    public final <T> T withTimeout(kotlin.e0.c.a<? extends T> block) {
        kotlin.jvm.internal.m.g(block, "block");
        enter();
        try {
            try {
                T invoke = block.invoke();
                kotlin.jvm.internal.l.b(1);
                if (exit()) {
                    throw access$newTimeoutException(null);
                }
                kotlin.jvm.internal.l.a(1);
                return invoke;
            } catch (IOException e2) {
                if (exit()) {
                    throw access$newTimeoutException(e2);
                }
                throw e2;
            }
        } catch (Throwable th) {
            kotlin.jvm.internal.l.b(1);
            exit();
            kotlin.jvm.internal.l.a(1);
            throw th;
        }
    }
}