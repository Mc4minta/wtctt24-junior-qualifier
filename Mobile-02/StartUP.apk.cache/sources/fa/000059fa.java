package kotlinx.coroutines.i1;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.k0;

/* compiled from: Dispatcher.kt */
/* loaded from: classes3.dex */
final class f extends k0 implements j, Executor {

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f17466c = AtomicIntegerFieldUpdater.newUpdater(f.class, "inFlightTasks");

    /* renamed from: e  reason: collision with root package name */
    private final d f17468e;

    /* renamed from: f  reason: collision with root package name */
    private final int f17469f;

    /* renamed from: g  reason: collision with root package name */
    private final String f17470g;

    /* renamed from: h  reason: collision with root package name */
    private final int f17471h;

    /* renamed from: d  reason: collision with root package name */
    private final ConcurrentLinkedQueue<Runnable> f17467d = new ConcurrentLinkedQueue<>();
    private volatile int inFlightTasks = 0;

    public f(d dVar, int i2, String str, int i3) {
        this.f17468e = dVar;
        this.f17469f = i2;
        this.f17470g = str;
        this.f17471h = i3;
    }

    private final void K(Runnable runnable, boolean z) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17466c;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.f17469f) {
                this.f17468e.N(runnable, this, z);
                return;
            }
            this.f17467d.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.f17469f) {
                return;
            }
            runnable = this.f17467d.poll();
        } while (runnable != null);
    }

    @Override // kotlinx.coroutines.t
    public void A(kotlin.c0.f fVar, Runnable runnable) {
        K(runnable, false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.i1.j
    public void d() {
        Runnable poll = this.f17467d.poll();
        if (poll != null) {
            this.f17468e.N(poll, this, true);
            return;
        }
        f17466c.decrementAndGet(this);
        Runnable poll2 = this.f17467d.poll();
        if (poll2 != null) {
            K(poll2, true);
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        K(runnable, false);
    }

    @Override // kotlinx.coroutines.i1.j
    public int j() {
        return this.f17471h;
    }

    @Override // kotlinx.coroutines.t
    public String toString() {
        String str = this.f17470g;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f17468e + ']';
    }
}