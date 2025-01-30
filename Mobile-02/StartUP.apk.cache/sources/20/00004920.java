package e.j.d;

import com.toshi.exception.OneTimeReadableException;
import kotlin.j0.m;

/* compiled from: OneTimeReadable.kt */
/* loaded from: classes2.dex */
public final class b<T> {
    private final T a;

    /* renamed from: b  reason: collision with root package name */
    private int f13524b;

    public b(T t) {
        this.a = t;
    }

    public final T a(Object obj, m<?> property) {
        kotlin.jvm.internal.m.g(property, "property");
        int i2 = this.f13524b + 1;
        this.f13524b = i2;
        if (i2 <= 1) {
            return this.a;
        }
        throw new OneTimeReadableException("This value can only be read 1 time");
    }
}