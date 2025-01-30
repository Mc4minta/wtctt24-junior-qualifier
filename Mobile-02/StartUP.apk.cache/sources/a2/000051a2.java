package kotlin.c0;

import kotlin.c0.f;
import kotlin.c0.f.b;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes3.dex */
public abstract class b<B extends f.b, E extends B> implements f.c<E> {
    private final f.c<?> a;

    /* renamed from: b  reason: collision with root package name */
    private final l<f.b, E> f17250b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.e0.c.l<kotlin.c0.f$b, E extends B>, java.lang.Object, kotlin.e0.c.l<? super kotlin.c0.f$b, ? extends E extends B>] */
    public b(f.c<B> baseKey, l<? super f.b, ? extends E> safeCast) {
        m.g(baseKey, "baseKey");
        m.g(safeCast, "safeCast");
        this.f17250b = safeCast;
        this.a = baseKey instanceof b ? (f.c<B>) ((b) baseKey).a : baseKey;
    }

    public final boolean a(f.c<?> key) {
        m.g(key, "key");
        return key == this || this.a == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/c0/f$b;)TE; */
    public final f.b b(f.b element) {
        m.g(element, "element");
        return (f.b) this.f17250b.invoke(element);
    }
}