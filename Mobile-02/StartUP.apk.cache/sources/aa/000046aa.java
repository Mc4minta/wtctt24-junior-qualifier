package e.f.j.l;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;

/* compiled from: ThreadHandoffProducerQueue.java */
/* loaded from: classes2.dex */
public class t0 {
    private boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    private final Deque<Runnable> f12751b = new ArrayDeque();

    /* renamed from: c  reason: collision with root package name */
    private final Executor f12752c;

    public t0(Executor executor) {
        this.f12752c = (Executor) e.f.d.c.i.g(executor);
    }

    public synchronized void a(Runnable runnable) {
        if (this.a) {
            this.f12751b.add(runnable);
        } else {
            this.f12752c.execute(runnable);
        }
    }

    public synchronized void b(Runnable runnable) {
        this.f12751b.remove(runnable);
    }
}