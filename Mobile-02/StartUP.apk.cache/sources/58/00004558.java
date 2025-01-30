package e.f.d.b;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: StatefulRunnable.java */
/* loaded from: classes2.dex */
public abstract class d<T> implements Runnable {
    protected final AtomicInteger a = new AtomicInteger(0);

    public void a() {
        if (this.a.compareAndSet(0, 2)) {
            d();
        }
    }

    protected abstract void b(T t);

    protected abstract T c() throws Exception;

    protected abstract void d();

    protected abstract void e(Exception exc);

    protected abstract void f(T t);

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.compareAndSet(0, 1)) {
            try {
                T c2 = c();
                this.a.set(3);
                try {
                    f(c2);
                } finally {
                    b(c2);
                }
            } catch (Exception e2) {
                this.a.set(4);
                e(e2);
            }
        }
    }
}