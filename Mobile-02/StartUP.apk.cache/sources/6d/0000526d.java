package kotlin.k0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class g<T> implements h<T> {
    private final kotlin.e0.c.a<T> a;

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.e0.c.l<T, T> f17335b;

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<T>, kotlin.jvm.internal.n0.a {
        private T a;

        /* renamed from: b  reason: collision with root package name */
        private int f17336b = -2;

        a() {
        }

        private final void b() {
            T t;
            if (this.f17336b == -2) {
                t = (T) g.this.a.invoke();
            } else {
                kotlin.e0.c.l lVar = g.this.f17335b;
                T t2 = this.a;
                kotlin.jvm.internal.m.e(t2);
                t = (T) lVar.invoke(t2);
            }
            this.a = t;
            this.f17336b = t == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f17336b < 0) {
                b();
            }
            return this.f17336b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f17336b < 0) {
                b();
            }
            if (this.f17336b != 0) {
                T t = this.a;
                Objects.requireNonNull(t, "null cannot be cast to non-null type T");
                this.f17336b = -1;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(kotlin.e0.c.a<? extends T> getInitialValue, kotlin.e0.c.l<? super T, ? extends T> getNextValue) {
        kotlin.jvm.internal.m.g(getInitialValue, "getInitialValue");
        kotlin.jvm.internal.m.g(getNextValue, "getNextValue");
        this.a = getInitialValue;
        this.f17335b = getNextValue;
    }

    @Override // kotlin.k0.h
    public Iterator<T> iterator() {
        return new a();
    }
}