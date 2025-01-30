package h.c.n0.i;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BasicIntQueueSubscription.java */
/* loaded from: classes3.dex */
public abstract class a<T> extends AtomicInteger implements h.c.n0.c.g<T> {
    @Override // h.c.n0.c.j
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}