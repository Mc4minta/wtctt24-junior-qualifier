package h.c;

/* compiled from: Observer.java */
/* loaded from: classes2.dex */
public interface z<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(h.c.k0.b bVar);
}