package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: locks.kt */
/* loaded from: classes3.dex */
public final class CancellableSimpleLock extends DefaultSimpleLock {
    private final Runnable checkCancelled;
    private final l<InterruptedException, x> interruptedExceptionHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CancellableSimpleLock(Lock lock, Runnable checkCancelled, l<? super InterruptedException, x> interruptedExceptionHandler) {
        super(lock);
        m.g(lock, "lock");
        m.g(checkCancelled, "checkCancelled");
        m.g(interruptedExceptionHandler, "interruptedExceptionHandler");
        this.checkCancelled = checkCancelled;
        this.interruptedExceptionHandler = interruptedExceptionHandler;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.DefaultSimpleLock, kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void lock() {
        while (!getLock().tryLock(50L, TimeUnit.MILLISECONDS)) {
            try {
                this.checkCancelled.run();
            } catch (InterruptedException e2) {
                this.interruptedExceptionHandler.invoke(e2);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CancellableSimpleLock(Runnable checkCancelled, l<? super InterruptedException, x> interruptedExceptionHandler) {
        this(new ReentrantLock(), checkCancelled, interruptedExceptionHandler);
        m.g(checkCancelled, "checkCancelled");
        m.g(interruptedExceptionHandler, "interruptedExceptionHandler");
    }
}