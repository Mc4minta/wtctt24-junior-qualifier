package kotlinx.coroutines;

import java.util.List;

/* compiled from: CoroutineExceptionHandlerImpl.kt */
/* loaded from: classes3.dex */
public final class u {
    private static final List<CoroutineExceptionHandler> a;

    static {
        kotlin.k0.h b2;
        List<CoroutineExceptionHandler> B;
        b2 = kotlin.k0.n.b(defpackage.a.a());
        B = kotlin.k0.p.B(b2);
        a = B;
    }

    public static final void a(kotlin.c0.f fVar, Throwable th) {
        for (CoroutineExceptionHandler coroutineExceptionHandler : a) {
            try {
                coroutineExceptionHandler.handleException(fVar, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, v.b(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}