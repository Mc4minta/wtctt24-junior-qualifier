package kotlin.c0;

import java.io.Serializable;
import kotlin.c0.f;
import kotlin.e0.c.p;
import kotlin.jvm.internal.m;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes3.dex */
public final class g implements f, Serializable {
    public static final g a = new g();

    private g() {
    }

    @Override // kotlin.c0.f
    public <R> R fold(R r, p<? super R, ? super f.b, ? extends R> operation) {
        m.g(operation, "operation");
        return r;
    }

    @Override // kotlin.c0.f
    public <E extends f.b> E get(f.c<E> key) {
        m.g(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // kotlin.c0.f
    public f minusKey(f.c<?> key) {
        m.g(key, "key");
        return this;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}