package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LazyJVM.kt */
/* loaded from: classes3.dex */
final class s<T> implements h<T>, Serializable {
    private kotlin.e0.c.a<? extends T> a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f17409b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f17410c;

    public s(kotlin.e0.c.a<? extends T> initializer, Object obj) {
        kotlin.jvm.internal.m.g(initializer, "initializer");
        this.a = initializer;
        this.f17409b = w.a;
        this.f17410c = obj == null ? this : obj;
    }

    public boolean a() {
        return this.f17409b != w.a;
    }

    @Override // kotlin.h
    public T getValue() {
        T t;
        T t2 = (T) this.f17409b;
        w wVar = w.a;
        if (t2 != wVar) {
            return t2;
        }
        synchronized (this.f17410c) {
            t = (T) this.f17409b;
            if (t == wVar) {
                kotlin.e0.c.a<? extends T> aVar = this.a;
                kotlin.jvm.internal.m.e(aVar);
                t = aVar.invoke();
                this.f17409b = t;
                this.a = null;
            }
        }
        return t;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ s(kotlin.e0.c.a aVar, Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, (i2 & 2) != 0 ? null : obj);
    }
}