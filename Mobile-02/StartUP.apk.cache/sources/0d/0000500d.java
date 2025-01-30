package h.c.n0.g;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: ScheduledRunnable.java */
/* loaded from: classes3.dex */
public final class n extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, h.c.k0.b {
    static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    static final Object f16683b = new Object();

    /* renamed from: c  reason: collision with root package name */
    static final Object f16684c = new Object();

    /* renamed from: d  reason: collision with root package name */
    static final Object f16685d = new Object();

    /* renamed from: e  reason: collision with root package name */
    final Runnable f16686e;

    public n(Runnable runnable, h.c.n0.a.b bVar) {
        super(3);
        this.f16686e = runnable;
        lazySet(0, bVar);
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == f16685d) {
                return;
            }
            if (obj == f16683b) {
                future.cancel(false);
                return;
            } else if (obj == f16684c) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // h.c.k0.b
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        while (true) {
            Object obj5 = get(1);
            if (obj5 == f16685d || obj5 == (obj3 = f16683b) || obj5 == (obj4 = f16684c)) {
                break;
            }
            boolean z = get(2) != Thread.currentThread();
            if (z) {
                obj3 = obj4;
            }
            if (compareAndSet(1, obj5, obj3)) {
                if (obj5 != null) {
                    ((Future) obj5).cancel(z);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == f16685d || obj == (obj2 = a) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((h.c.n0.a.b) obj).c(this);
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        Object obj = get(0);
        return obj == a || obj == f16685d;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        boolean compareAndSet;
        Object obj4;
        Object obj5;
        lazySet(2, Thread.currentThread());
        try {
            this.f16686e.run();
        } finally {
            try {
                lazySet(2, null);
                obj4 = get(0);
                if (obj4 != a) {
                    ((h.c.n0.a.b) obj4).c(this);
                }
                do {
                    obj5 = get(1);
                    if (obj5 != f16683b) {
                        return;
                    }
                    return;
                } while (!compareAndSet(1, obj5, f16685d));
            } catch (Throwable th) {
                do {
                    if (obj == obj2) {
                        break;
                    } else if (obj == obj3) {
                        break;
                    }
                } while (!compareAndSet);
            }
        }
        lazySet(2, null);
        obj4 = get(0);
        if (obj4 != a && compareAndSet(0, obj4, f16685d) && obj4 != null) {
            ((h.c.n0.a.b) obj4).c(this);
        }
        do {
            obj5 = get(1);
            if (obj5 != f16683b || obj5 == f16684c) {
                return;
            }
        } while (!compareAndSet(1, obj5, f16685d));
    }
}