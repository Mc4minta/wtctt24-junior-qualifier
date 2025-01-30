package retrofit2;

import java.util.Objects;

/* loaded from: classes3.dex */
public class HttpException extends RuntimeException {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final String f17880b;

    /* renamed from: c  reason: collision with root package name */
    private final transient s<?> f17881c;

    public HttpException(s<?> sVar) {
        super(a(sVar));
        this.a = sVar.b();
        this.f17880b = sVar.f();
        this.f17881c = sVar;
    }

    private static String a(s<?> sVar) {
        Objects.requireNonNull(sVar, "response == null");
        return "HTTP " + sVar.b() + " " + sVar.f();
    }

    public s<?> b() {
        return this.f17881c;
    }
}