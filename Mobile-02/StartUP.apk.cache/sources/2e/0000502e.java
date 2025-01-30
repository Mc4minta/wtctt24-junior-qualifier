package h.c.n0.i;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: BasicQueueSubscription.java */
/* loaded from: classes3.dex */
public abstract class b<T> extends AtomicLong implements h.c.n0.c.g<T> {
    @Override // h.c.n0.c.j
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}