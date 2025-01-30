package h.c.j0;

import android.os.Looper;
import h.c.k0.b;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: MainThreadDisposable.java */
/* loaded from: classes2.dex */
public abstract class a implements b {
    private final AtomicBoolean a = new AtomicBoolean();

    /* compiled from: MainThreadDisposable.java */
    /* renamed from: h.c.j0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0339a implements Runnable {
        RunnableC0339a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a();
        }
    }

    protected abstract void a();

    @Override // h.c.k0.b
    public final void dispose() {
        if (this.a.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a();
            } else {
                h.c.j0.c.a.b().c(new RunnableC0339a());
            }
        }
    }

    @Override // h.c.k0.b
    public final boolean isDisposed() {
        return this.a.get();
    }
}