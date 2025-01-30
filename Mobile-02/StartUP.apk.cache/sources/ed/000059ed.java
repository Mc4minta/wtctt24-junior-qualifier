package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.g0;

/* compiled from: EventLoop.kt */
/* loaded from: classes3.dex */
public abstract class h0 extends f0 {
    protected abstract Thread n0();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o0(long j2, g0.a aVar) {
        if (x.a()) {
            if (!(this != z.f17548h)) {
                throw new AssertionError();
            }
        }
        z.f17548h.Q0(j2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r0() {
        Thread n0 = n0();
        if (Thread.currentThread() != n0) {
            e1 a = f1.a();
            if (a != null) {
                a.d(n0);
            } else {
                LockSupport.unpark(n0);
            }
        }
    }
}