package h.c.n0.d;

/* compiled from: BlockingLastObserver.java */
/* loaded from: classes.dex */
public final class g<T> extends e<T> {
    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        this.a = null;
        this.f14116b = th;
        countDown();
    }

    @Override // h.c.z, k.a.c
    public void onNext(T t) {
        this.a = t;
    }
}