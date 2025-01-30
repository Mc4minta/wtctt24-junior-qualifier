package kotlin.c0;

import kotlin.c0.f;
import kotlin.e0.c.p;
import kotlin.jvm.internal.m;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes3.dex */
public abstract class a implements f.b {
    private final f.c<?> key;

    public a(f.c<?> key) {
        m.g(key, "key");
        this.key = key;
    }

    @Override // kotlin.c0.f
    public <R> R fold(R r, p<? super R, ? super f.b, ? extends R> operation) {
        m.g(operation, "operation");
        return (R) f.b.a.a(this, r, operation);
    }

    @Override // kotlin.c0.f.b, kotlin.c0.f
    public <E extends f.b> E get(f.c<E> key) {
        m.g(key, "key");
        return (E) f.b.a.b(this, key);
    }

    @Override // kotlin.c0.f.b
    public f.c<?> getKey() {
        return this.key;
    }

    @Override // kotlin.c0.f
    public f minusKey(f.c<?> key) {
        m.g(key, "key");
        return f.b.a.c(this, key);
    }

    public f plus(f context) {
        m.g(context, "context");
        return f.b.a.d(this, context);
    }
}