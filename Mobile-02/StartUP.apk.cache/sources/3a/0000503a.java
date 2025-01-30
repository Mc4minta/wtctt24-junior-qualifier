package h.c.n0.j;

import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingIgnoringReceiver.java */
/* loaded from: classes3.dex */
public final class f extends CountDownLatch implements h.c.m0.f<Throwable>, h.c.m0.a {
    public Throwable a;

    public f() {
        super(1);
    }

    @Override // h.c.m0.f
    /* renamed from: a */
    public void accept(Throwable th) {
        this.a = th;
        countDown();
    }

    @Override // h.c.m0.a
    public void run() {
        countDown();
    }
}