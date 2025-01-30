package h.c.n0.h;

/* compiled from: BlockingFirstSubscriber.java */
/* loaded from: classes3.dex */
public final class d<T> extends c<T> {
    @Override // k.a.c
    public void onError(Throwable th) {
        if (this.a == null) {
            this.f16715b = th;
        } else {
            h.c.r0.a.u(th);
        }
        countDown();
    }

    @Override // k.a.c
    public void onNext(T t) {
        if (this.a == null) {
            this.a = t;
            this.f16716c.cancel();
            countDown();
        }
    }
}