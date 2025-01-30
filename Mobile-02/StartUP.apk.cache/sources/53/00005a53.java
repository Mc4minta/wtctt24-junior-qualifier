package kotlinx.coroutines;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* compiled from: DefaultExecutor.kt */
/* loaded from: classes3.dex */
public final class z extends g0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: g  reason: collision with root package name */
    private static final long f17547g;

    /* renamed from: h  reason: collision with root package name */
    public static final z f17548h;

    static {
        Long l2;
        z zVar = new z();
        f17548h = zVar;
        f0.d0(zVar, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        f17547g = timeUnit.toNanos(l2.longValue());
    }

    private z() {
    }

    private final synchronized void X0() {
        if (f1()) {
            debugStatus = 3;
            O0();
            notifyAll();
        }
    }

    private final synchronized Thread d1() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean f1() {
        int i2 = debugStatus;
        return i2 == 2 || i2 == 3;
    }

    private final synchronized boolean i1() {
        if (f1()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    @Override // kotlinx.coroutines.h0
    protected Thread n0() {
        Thread thread = _thread;
        return thread != null ? thread : d1();
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean J0;
        d1.f17420b.c(this);
        e1 a = f1.a();
        if (a != null) {
            a.b();
        }
        try {
            if (!i1()) {
                if (J0) {
                    return;
                }
                return;
            }
            long j2 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long L0 = L0();
                if (L0 == Long.MAX_VALUE) {
                    e1 a2 = f1.a();
                    long nanoTime = a2 != null ? a2.nanoTime() : System.nanoTime();
                    if (j2 == Long.MAX_VALUE) {
                        j2 = f17547g + nanoTime;
                    }
                    long j3 = j2 - nanoTime;
                    if (j3 <= 0) {
                        _thread = null;
                        X0();
                        e1 a3 = f1.a();
                        if (a3 != null) {
                            a3.f();
                        }
                        if (J0()) {
                            return;
                        }
                        n0();
                        return;
                    }
                    L0 = kotlin.i0.f.e(L0, j3);
                } else {
                    j2 = Long.MAX_VALUE;
                }
                if (L0 > 0) {
                    if (f1()) {
                        _thread = null;
                        X0();
                        e1 a4 = f1.a();
                        if (a4 != null) {
                            a4.f();
                        }
                        if (J0()) {
                            return;
                        }
                        n0();
                        return;
                    }
                    e1 a5 = f1.a();
                    if (a5 != null) {
                        a5.e(this, L0);
                    } else {
                        LockSupport.parkNanos(this, L0);
                    }
                }
            }
        } finally {
            _thread = null;
            X0();
            e1 a6 = f1.a();
            if (a6 != null) {
                a6.f();
            }
            if (!J0()) {
                n0();
            }
        }
    }
}