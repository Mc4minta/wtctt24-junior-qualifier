package k.a;

/* compiled from: Subscriber.java */
/* loaded from: classes3.dex */
public interface c<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(d dVar);
}