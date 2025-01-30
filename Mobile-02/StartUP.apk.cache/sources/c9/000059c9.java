package kotlin;

import java.io.Serializable;

/* compiled from: Lazy.kt */
/* loaded from: classes3.dex */
public final class y<T> implements h<T>, Serializable {
    private kotlin.e0.c.a<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    private Object f17414b;

    public y(kotlin.e0.c.a<? extends T> initializer) {
        kotlin.jvm.internal.m.g(initializer, "initializer");
        this.a = initializer;
        this.f17414b = w.a;
    }

    public boolean a() {
        return this.f17414b != w.a;
    }

    @Override // kotlin.h
    public T getValue() {
        if (this.f17414b == w.a) {
            kotlin.e0.c.a<? extends T> aVar = this.a;
            kotlin.jvm.internal.m.e(aVar);
            this.f17414b = aVar.invoke();
            this.a = null;
        }
        return (T) this.f17414b;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}