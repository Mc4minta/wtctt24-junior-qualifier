package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LazyJVM.kt */
/* loaded from: classes3.dex */
final class r<T> implements h<T>, Serializable {

    /* renamed from: c  reason: collision with root package name */
    private volatile kotlin.e0.c.a<? extends T> f17389c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Object f17390d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f17391e;

    /* renamed from: b  reason: collision with root package name */
    public static final a f17388b = new a(null);
    private static final AtomicReferenceFieldUpdater<r<?>, Object> a = AtomicReferenceFieldUpdater.newUpdater(r.class, Object.class, "d");

    /* compiled from: LazyJVM.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public r(kotlin.e0.c.a<? extends T> initializer) {
        kotlin.jvm.internal.m.g(initializer, "initializer");
        this.f17389c = initializer;
        w wVar = w.a;
        this.f17390d = wVar;
        this.f17391e = wVar;
    }

    public boolean a() {
        return this.f17390d != w.a;
    }

    @Override // kotlin.h
    public T getValue() {
        T t = (T) this.f17390d;
        w wVar = w.a;
        if (t != wVar) {
            return t;
        }
        kotlin.e0.c.a<? extends T> aVar = this.f17389c;
        if (aVar != null) {
            T invoke = aVar.invoke();
            if (a.compareAndSet(this, wVar, invoke)) {
                this.f17389c = null;
                return invoke;
            }
        }
        return (T) this.f17390d;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}