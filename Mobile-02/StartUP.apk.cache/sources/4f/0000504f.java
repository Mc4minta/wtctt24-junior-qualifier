package h.c;

/* compiled from: MaybeObserver.java */
/* loaded from: classes2.dex */
public interface p<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(h.c.k0.b bVar);

    void onSuccess(T t);
}