package retrofit2;

import java.util.Objects;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: Response.java */
/* loaded from: classes3.dex */
public final class s<T> {
    private final Response a;

    /* renamed from: b  reason: collision with root package name */
    private final T f17992b;

    /* renamed from: c  reason: collision with root package name */
    private final ResponseBody f17993c;

    private s(Response response, T t, ResponseBody responseBody) {
        this.a = response;
        this.f17992b = t;
        this.f17993c = responseBody;
    }

    public static <T> s<T> c(ResponseBody responseBody, Response response) {
        Objects.requireNonNull(responseBody, "body == null");
        Objects.requireNonNull(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            return new s<>(response, null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> s<T> g(T t, Response response) {
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new s<>(response, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public T a() {
        return this.f17992b;
    }

    public int b() {
        return this.a.code();
    }

    public ResponseBody d() {
        return this.f17993c;
    }

    public boolean e() {
        return this.a.isSuccessful();
    }

    public String f() {
        return this.a.message();
    }

    public String toString() {
        return this.a.toString();
    }
}