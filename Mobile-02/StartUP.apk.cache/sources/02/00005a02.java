package kotlinx.coroutines.i1;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.x;

/* compiled from: WorkQueue.kt */
/* loaded from: classes3.dex */
public final class n {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f17480b = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f17481c = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f17482d = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");

    /* renamed from: e  reason: collision with root package name */
    private final AtomicReferenceArray<i> f17483e = new AtomicReferenceArray<>(128);
    private volatile Object lastScheduledTask = null;
    private volatile int producerIndex = 0;
    private volatile int consumerIndex = 0;
    private volatile int blockingTasksInBuffer = 0;

    public static /* synthetic */ i b(n nVar, i iVar, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return nVar.a(iVar, z);
    }

    private final i c(i iVar) {
        if (iVar.f17473b.j() == 1) {
            f17482d.incrementAndGet(this);
        }
        if (e() == 127) {
            return iVar;
        }
        int i2 = this.producerIndex & 127;
        while (this.f17483e.get(i2) != null) {
            Thread.yield();
        }
        this.f17483e.lazySet(i2, iVar);
        f17480b.incrementAndGet(this);
        return null;
    }

    private final void d(i iVar) {
        if (iVar != null) {
            if (iVar.f17473b.j() == 1) {
                int decrementAndGet = f17482d.decrementAndGet(this);
                if (x.a()) {
                    if (!(decrementAndGet >= 0)) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    private final i i() {
        i andSet;
        while (true) {
            int i2 = this.consumerIndex;
            if (i2 - this.producerIndex == 0) {
                return null;
            }
            int i3 = i2 & 127;
            if (f17481c.compareAndSet(this, i2, i2 + 1) && (andSet = this.f17483e.getAndSet(i3, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(e eVar) {
        i i2 = i();
        if (i2 != null) {
            eVar.a(i2);
            return true;
        }
        return false;
    }

    private final long m(n nVar, boolean z) {
        i iVar;
        do {
            iVar = (i) nVar.lastScheduledTask;
            if (iVar == null) {
                return -2L;
            }
            if (z) {
                if (!(iVar.f17473b.j() == 1)) {
                    return -2L;
                }
            }
            long a2 = l.f17479f.a() - iVar.a;
            long j2 = l.a;
            if (a2 < j2) {
                return j2 - a2;
            }
        } while (!a.compareAndSet(nVar, iVar, null));
        b(this, iVar, false, 2, null);
        return -1L;
    }

    public final i a(i iVar, boolean z) {
        if (z) {
            return c(iVar);
        }
        i iVar2 = (i) a.getAndSet(this, iVar);
        if (iVar2 != null) {
            return c(iVar2);
        }
        return null;
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(e eVar) {
        i iVar = (i) a.getAndSet(this, null);
        if (iVar != null) {
            eVar.a(iVar);
        }
        do {
        } while (j(eVar));
    }

    public final i h() {
        i iVar = (i) a.getAndSet(this, null);
        return iVar != null ? iVar : i();
    }

    public final long k(n nVar) {
        if (x.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        int i2 = nVar.producerIndex;
        AtomicReferenceArray<i> atomicReferenceArray = nVar.f17483e;
        for (int i3 = nVar.consumerIndex; i3 != i2; i3++) {
            int i4 = i3 & 127;
            if (nVar.blockingTasksInBuffer == 0) {
                break;
            }
            i iVar = atomicReferenceArray.get(i4);
            if (iVar != null) {
                if ((iVar.f17473b.j() == 1) && atomicReferenceArray.compareAndSet(i4, iVar, null)) {
                    f17482d.decrementAndGet(nVar);
                    b(this, iVar, false, 2, null);
                    return -1L;
                }
            }
        }
        return m(nVar, true);
    }

    public final long l(n nVar) {
        if (x.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        i i2 = nVar.i();
        if (i2 != null) {
            i b2 = b(this, i2, false, 2, null);
            if (x.a()) {
                if (b2 == null) {
                    return -1L;
                }
                throw new AssertionError();
            }
            return -1L;
        }
        return m(nVar, false);
    }
}