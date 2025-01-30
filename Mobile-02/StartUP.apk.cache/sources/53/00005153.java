package kotlin.a0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: AbstractIterator.kt */
/* loaded from: classes3.dex */
public abstract class c<T> implements Iterator<T>, kotlin.jvm.internal.n0.a {
    private v0 a = v0.NotReady;

    /* renamed from: b  reason: collision with root package name */
    private T f17207b;

    private final boolean e() {
        this.a = v0.Failed;
        b();
        return this.a == v0.Ready;
    }

    protected abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        this.a = v0.Done;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(T t) {
        this.f17207b = t;
        this.a = v0.Ready;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        v0 v0Var = this.a;
        if (v0Var != v0.Failed) {
            int i2 = b.a[v0Var.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return e();
                }
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.a = v0.NotReady;
            return this.f17207b;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}