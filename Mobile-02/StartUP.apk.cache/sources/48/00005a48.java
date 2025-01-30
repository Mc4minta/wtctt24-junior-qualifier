package kotlinx.coroutines;

/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes3.dex */
public final class v {
    public static final void a(kotlin.c0.f fVar, Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) fVar.get(CoroutineExceptionHandler.r);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(fVar, th);
            } else {
                u.a(fVar, th);
            }
        } catch (Throwable th2) {
            u.a(fVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        kotlin.c.a(runtimeException, th);
        return runtimeException;
    }
}