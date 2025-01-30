package j;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Pipe.kt */
/* loaded from: classes3.dex */
public final class w {
    private final f a = new f();

    /* renamed from: b  reason: collision with root package name */
    private boolean f17174b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17175c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17176d;

    /* renamed from: e  reason: collision with root package name */
    private c0 f17177e;

    /* renamed from: f  reason: collision with root package name */
    private final c0 f17178f;

    /* renamed from: g  reason: collision with root package name */
    private final e0 f17179g;

    /* renamed from: h  reason: collision with root package name */
    private final long f17180h;

    /* compiled from: Pipe.kt */
    /* loaded from: classes3.dex */
    public static final class a implements c0 {
        private final f0 a = new f0();

        a() {
        }

        @Override // j.c0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (w.this.a()) {
                if (w.this.e()) {
                    return;
                }
                c0 c2 = w.this.c();
                if (c2 == null) {
                    if (w.this.f() && w.this.a().O0() > 0) {
                        throw new IOException("source is closed");
                    }
                    w.this.g(true);
                    f a = w.this.a();
                    if (a == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                    a.notifyAll();
                    c2 = null;
                }
                kotlin.x xVar = kotlin.x.a;
                if (c2 != null) {
                    w wVar = w.this;
                    f0 timeout = c2.timeout();
                    f0 timeout2 = wVar.i().timeout();
                    long timeoutNanos = timeout.timeoutNanos();
                    long a2 = f0.Companion.a(timeout2.timeoutNanos(), timeout.timeoutNanos());
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    timeout.timeout(a2, timeUnit);
                    if (timeout.hasDeadline()) {
                        long deadlineNanoTime = timeout.deadlineNanoTime();
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            c2.close();
                            timeout.timeout(timeoutNanos, timeUnit);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                            }
                            throw th;
                        }
                    }
                    if (timeout2.hasDeadline()) {
                        timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                    }
                    try {
                        c2.close();
                        timeout.timeout(timeoutNanos, timeUnit);
                        if (timeout2.hasDeadline()) {
                            timeout.clearDeadline();
                        }
                    } catch (Throwable th2) {
                        timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout2.hasDeadline()) {
                            timeout.clearDeadline();
                        }
                        throw th2;
                    }
                }
            }
        }

        @Override // j.c0, java.io.Flushable
        public void flush() {
            c0 c2;
            synchronized (w.this.a()) {
                if (!w.this.e()) {
                    if (!w.this.b()) {
                        c2 = w.this.c();
                        if (c2 == null) {
                            if (w.this.f() && w.this.a().O0() > 0) {
                                throw new IOException("source is closed");
                            }
                            c2 = null;
                        }
                        kotlin.x xVar = kotlin.x.a;
                    } else {
                        throw new IOException("canceled");
                    }
                } else {
                    throw new IllegalStateException("closed".toString());
                }
            }
            if (c2 != null) {
                w wVar = w.this;
                f0 timeout = c2.timeout();
                f0 timeout2 = wVar.i().timeout();
                long timeoutNanos = timeout.timeoutNanos();
                long a = f0.Companion.a(timeout2.timeoutNanos(), timeout.timeoutNanos());
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                timeout.timeout(a, timeUnit);
                if (timeout.hasDeadline()) {
                    long deadlineNanoTime = timeout.deadlineNanoTime();
                    if (timeout2.hasDeadline()) {
                        timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                    }
                    try {
                        c2.flush();
                        timeout.timeout(timeoutNanos, timeUnit);
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(deadlineNanoTime);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(deadlineNanoTime);
                        }
                        throw th;
                    }
                }
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                }
                try {
                    c2.flush();
                    timeout.timeout(timeoutNanos, timeUnit);
                    if (timeout2.hasDeadline()) {
                        timeout.clearDeadline();
                    }
                } catch (Throwable th2) {
                    timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout2.hasDeadline()) {
                        timeout.clearDeadline();
                    }
                    throw th2;
                }
            }
        }

        @Override // j.c0
        public f0 timeout() {
            return this.a;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0091, code lost:
            r1 = kotlin.x.a;
         */
        @Override // j.c0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void write(j.f r13, long r14) {
            /*
                Method dump skipped, instructions count: 319
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: j.w.a.write(j.f, long):void");
        }
    }

    /* compiled from: Pipe.kt */
    /* loaded from: classes3.dex */
    public static final class b implements e0 {
        private final f0 a = new f0();

        b() {
        }

        @Override // j.e0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (w.this.a()) {
                w.this.h(true);
                f a = w.this.a();
                if (a != null) {
                    a.notifyAll();
                    kotlin.x xVar = kotlin.x.a;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
            }
        }

        @Override // j.e0
        public long read(f sink, long j2) {
            kotlin.jvm.internal.m.g(sink, "sink");
            synchronized (w.this.a()) {
                if (!w.this.f()) {
                    if (!w.this.b()) {
                        while (w.this.a().O0() == 0) {
                            if (w.this.e()) {
                                return -1L;
                            }
                            this.a.waitUntilNotified(w.this.a());
                            if (w.this.b()) {
                                throw new IOException("canceled");
                            }
                        }
                        long read = w.this.a().read(sink, j2);
                        f a = w.this.a();
                        if (a != null) {
                            a.notifyAll();
                            return read;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                    throw new IOException("canceled");
                }
                throw new IllegalStateException("closed".toString());
            }
        }

        @Override // j.e0
        public f0 timeout() {
            return this.a;
        }
    }

    public w(long j2) {
        this.f17180h = j2;
        if (j2 >= 1) {
            this.f17178f = new a();
            this.f17179g = new b();
            return;
        }
        throw new IllegalArgumentException(("maxBufferSize < 1: " + j2).toString());
    }

    public final f a() {
        return this.a;
    }

    public final boolean b() {
        return this.f17174b;
    }

    public final c0 c() {
        return this.f17177e;
    }

    public final long d() {
        return this.f17180h;
    }

    public final boolean e() {
        return this.f17175c;
    }

    public final boolean f() {
        return this.f17176d;
    }

    public final void g(boolean z) {
        this.f17175c = z;
    }

    public final void h(boolean z) {
        this.f17176d = z;
    }

    public final c0 i() {
        return this.f17178f;
    }

    public final e0 j() {
        return this.f17179g;
    }
}