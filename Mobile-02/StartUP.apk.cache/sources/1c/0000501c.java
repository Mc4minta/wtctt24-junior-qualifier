package h.c.n0.h;

/* compiled from: BlockingLastSubscriber.java */
/* loaded from: classes3.dex */
public final class e<T> extends c<T> {
    @Override // k.a.c
    public void onError(Throwable th) {
        this.a = null;
        this.f16715b = th;
        countDown();
    }

    @Override // k.a.c
    public void onNext(T t) {
        this.a = t;
    }
}