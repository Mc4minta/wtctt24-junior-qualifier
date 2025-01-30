package kotlin;

import java.io.Serializable;

/* compiled from: Lazy.kt */
/* loaded from: classes3.dex */
public final class e<T> implements h<T>, Serializable {
    private final T a;

    public e(T t) {
        this.a = t;
    }

    @Override // kotlin.h
    public T getValue() {
        return this.a;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}