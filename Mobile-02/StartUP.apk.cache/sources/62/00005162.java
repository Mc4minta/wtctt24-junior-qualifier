package kotlin.a0;

import java.util.Iterator;

/* compiled from: Iterators.kt */
/* loaded from: classes3.dex */
public abstract class h0 implements Iterator<Integer>, kotlin.jvm.internal.n0.a {
    @Override // java.util.Iterator
    /* renamed from: b */
    public final Integer next() {
        return Integer.valueOf(c());
    }

    public abstract int c();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}