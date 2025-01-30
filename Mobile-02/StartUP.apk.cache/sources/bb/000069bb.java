package retrofit2;

import java.io.IOException;
import okhttp3.Request;

/* compiled from: Call.java */
/* loaded from: classes3.dex */
public interface d<T> extends Cloneable {
    void cancel();

    /* renamed from: clone */
    d<T> mo2365clone();

    void d0(f<T> fVar);

    s<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();
}