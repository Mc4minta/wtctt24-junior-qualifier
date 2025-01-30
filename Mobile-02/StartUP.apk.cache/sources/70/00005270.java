package kotlin.k0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.p;
import kotlin.x;

/* compiled from: SequenceBuilder.kt */
/* loaded from: classes3.dex */
final class i<T> extends j<T> implements Iterator<T>, kotlin.c0.d<x>, kotlin.jvm.internal.n0.a {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private T f17338b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator<? extends T> f17339c;

    /* renamed from: d  reason: collision with root package name */
    private kotlin.c0.d<? super x> f17340d;

    private final Throwable f() {
        int i2 = this.a;
        if (i2 != 4) {
            if (i2 != 5) {
                return new IllegalStateException("Unexpected state of the iterator: " + this.a);
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    private final T g() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // kotlin.c0.d
    public void b(Object obj) {
        kotlin.q.b(obj);
        this.a = 4;
    }

    @Override // kotlin.k0.j
    public Object d(T t, kotlin.c0.d<? super x> dVar) {
        Object c2;
        Object c3;
        Object c4;
        this.f17338b = t;
        this.a = 3;
        this.f17340d = dVar;
        c2 = kotlin.c0.h.d.c();
        c3 = kotlin.c0.h.d.c();
        if (c2 == c3) {
            kotlin.c0.i.a.g.c(dVar);
        }
        c4 = kotlin.c0.h.d.c();
        return c2 == c4 ? c2 : x.a;
    }

    @Override // kotlin.c0.d
    public kotlin.c0.f e() {
        return kotlin.c0.g.a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i2 = this.a;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        return true;
                    }
                    if (i2 == 4) {
                        return false;
                    }
                    throw f();
                }
                Iterator<? extends T> it = this.f17339c;
                kotlin.jvm.internal.m.e(it);
                if (it.hasNext()) {
                    this.a = 2;
                    return true;
                }
                this.f17339c = null;
            }
            this.a = 5;
            kotlin.c0.d<? super x> dVar = this.f17340d;
            kotlin.jvm.internal.m.e(dVar);
            this.f17340d = null;
            x xVar = x.a;
            p.a aVar = kotlin.p.a;
            dVar.b(kotlin.p.a(xVar));
        }
    }

    public final void i(kotlin.c0.d<? super x> dVar) {
        this.f17340d = dVar;
    }

    @Override // java.util.Iterator
    public T next() {
        int i2 = this.a;
        if (i2 == 0 || i2 == 1) {
            return g();
        }
        if (i2 == 2) {
            this.a = 1;
            Iterator<? extends T> it = this.f17339c;
            kotlin.jvm.internal.m.e(it);
            return it.next();
        } else if (i2 == 3) {
            this.a = 0;
            T t = this.f17338b;
            this.f17338b = null;
            return t;
        } else {
            throw f();
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}