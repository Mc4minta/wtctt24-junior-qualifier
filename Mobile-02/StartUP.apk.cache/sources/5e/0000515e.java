package kotlin.a0;

import java.util.Iterator;

/* compiled from: Iterables.kt */
/* loaded from: classes3.dex */
public final class f0<T> implements Iterable<e0<? extends T>>, kotlin.jvm.internal.n0.a {
    private final kotlin.e0.c.a<Iterator<T>> a;

    /* JADX WARN: Multi-variable type inference failed */
    public f0(kotlin.e0.c.a<? extends Iterator<? extends T>> iteratorFactory) {
        kotlin.jvm.internal.m.g(iteratorFactory, "iteratorFactory");
        this.a = iteratorFactory;
    }

    @Override // java.lang.Iterable
    public Iterator<e0<T>> iterator() {
        return new g0(this.a.invoke());
    }
}