package h.c.n0.d;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BasicIntQueueDisposable.java */
/* loaded from: classes.dex */
public abstract class b<T> extends AtomicInteger implements h.c.n0.c.e<T> {
    @Override // h.c.n0.c.j
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}