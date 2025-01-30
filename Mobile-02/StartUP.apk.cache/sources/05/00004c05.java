package h.c.n0.d;

/* compiled from: BlockingFirstObserver.java */
/* loaded from: classes.dex */
public final class f<T> extends e<T> {
    @Override // h.c.z, k.a.c
    public void onError(Throwable th) {
        if (this.a == null) {
            this.f14116b = th;
        }
        countDown();
    }

    @Override // h.c.z, k.a.c
    public void onNext(T t) {
        if (this.a == null) {
            this.a = t;
            this.f14117c.dispose();
            countDown();
        }
    }
}