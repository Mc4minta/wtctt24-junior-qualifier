package h.c;

/* compiled from: SingleObserver.java */
/* loaded from: classes2.dex */
public interface e0<T> {
    void onError(Throwable th);

    void onSubscribe(h.c.k0.b bVar);

    void onSuccess(T t);
}