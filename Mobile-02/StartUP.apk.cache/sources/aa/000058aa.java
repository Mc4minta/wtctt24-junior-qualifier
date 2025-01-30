package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.e0.c.l;
import kotlin.x;

/* compiled from: locks.kt */
/* loaded from: classes3.dex */
public interface SimpleLock {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: locks.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final DefaultSimpleLock simpleLock(Runnable runnable, l<? super InterruptedException, x> lVar) {
            if (runnable != null && lVar != null) {
                return new CancellableSimpleLock(runnable, lVar);
            }
            return new DefaultSimpleLock(null, 1, null);
        }
    }

    void lock();

    void unlock();
}