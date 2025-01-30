package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: locks.kt */
/* loaded from: classes3.dex */
public class DefaultSimpleLock implements SimpleLock {
    private final Lock lock;

    public DefaultSimpleLock() {
        this(null, 1, null);
    }

    public DefaultSimpleLock(Lock lock) {
        m.g(lock, "lock");
        this.lock = lock;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Lock getLock() {
        return this.lock;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void lock() {
        this.lock.lock();
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void unlock() {
        this.lock.unlock();
    }

    public /* synthetic */ DefaultSimpleLock(Lock lock, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new ReentrantLock() : lock);
    }
}