package retrofit2.adapter.rxjava2;

import java.util.Objects;
import retrofit2.s;

/* compiled from: Result.java */
/* loaded from: classes3.dex */
public final class d<T> {
    private final s<T> a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f17889b;

    private d(s<T> sVar, Throwable th) {
        this.a = sVar;
        this.f17889b = th;
    }

    public static <T> d<T> a(Throwable th) {
        Objects.requireNonNull(th, "error == null");
        return new d<>(null, th);
    }

    public static <T> d<T> b(s<T> sVar) {
        Objects.requireNonNull(sVar, "response == null");
        return new d<>(sVar, null);
    }
}