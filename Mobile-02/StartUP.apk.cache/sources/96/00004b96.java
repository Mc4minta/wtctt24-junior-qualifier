package h.c;

/* compiled from: SingleEmitter.java */
/* loaded from: classes2.dex */
public interface d0<T> {
    boolean a(Throwable th);

    boolean isDisposed();

    void onError(Throwable th);

    void onSuccess(T t);
}