package retrofit2;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* compiled from: Invocation.java */
/* loaded from: classes3.dex */
public final class k {
    private final Method a;

    /* renamed from: b  reason: collision with root package name */
    private final List<?> f17913b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Method method, List<?> list) {
        this.a = method;
        this.f17913b = Collections.unmodifiableList(list);
    }

    public Method a() {
        return this.a;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.a.getDeclaringClass().getName(), this.a.getName(), this.f17913b);
    }
}